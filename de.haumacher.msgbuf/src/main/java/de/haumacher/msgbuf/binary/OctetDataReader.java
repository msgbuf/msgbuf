/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.binary;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * {@link DataReader} that reconstructs values written with a {@link OctetDataWriter}.
 */
public class OctetDataReader implements DataReader {

	private static final int MASK_3 = ~(0xFFFFFFFF << 3);
	private static final int MASK_7 = ~(0xFFFFFFFF << 7);

	private static final int BIT_8 = 1 << 7;
	static final int BIT_1 = 1;
	
	private static final int NO_NAME = -1;
	private static final int END_OF_OBJECT = -2;

	final InputStream _in;
	
	State _state = State.START;
	
	private FieldTag _content = FieldTag.OBJ;

	private int _length;
	
	private final List<SFrame> _stack = new ArrayList<>();
	private int _name;
	
	/** 
	 * Creates a {@link OctetDataReader}.
	 */
	public OctetDataReader(InputStream in) {
		_in = in;
	}

	@Override
	public void beginObject() throws IOException {
		consumeValue(FieldTag.OBJ);
		
		_stack.add(new SFrame(_state, _length, _content));
		_state = State.FIELD;
		_name = NO_NAME;
	}

	@Override
	public void endObject() throws IOException {
		fetchName();
		assert _name == END_OF_OBJECT : "There are more fields to read: " + _name;
		
		SFrame sFrame = _stack.remove(_stack.size() - 1);
		
		_state = sFrame.getState();
		_length = sFrame.getLength();
		_content = sFrame.getContent();
		_name = NO_NAME;
	}
	
	@Override
	public boolean hasNext() throws IOException {
		switch (_state) {
		case FIELD:
			fetchName();
			return _name >= 0;
		case ARRAY_VALUE:
			return _length > 0;
		default:
			return false;
		}
	}

	@Override
	public int nextName() throws IOException {
		requireState(State.FIELD);
		fetchName();
		assert _name >= 0 : "No more fields left";
		_state = State.FIELD_VALUE;
		
		int result = _name;
		_name = NO_NAME;
		return result;
	}

	private void fetchName() throws IOException {
		if (_name == NO_NAME) {
			int nameAndTag = readVarInt();
			_content = tag(nameAndTag);
			if (_content == FieldTag.STOP) {
				_name = END_OF_OBJECT;
			} else {
				_name = name(nameAndTag);
			}
		}
	}

	@Override
	public int nextInt() throws IOException {
		consumeValue(FieldTag.VAR);
		return readVarInt();
	}

	@Override
	public int nextIntSigned() throws IOException {
		consumeValue(FieldTag.VAR);
		return BinaryUtil.zigzagDecode(readVarInt());
	}

	@Override
	public int nextIntFixed() throws IOException {
		consumeValue(FieldTag.F32);
		return readFixedInt();
	}

	@Override
	public long nextLong() throws IOException {
		consumeValue(FieldTag.VAR);
		return readVarLong();
	}

	@Override
	public long nextLongSigned() throws IOException {
		consumeValue(FieldTag.VAR);
		return BinaryUtil.zigzagDecode(readVarLong());
	}

	@Override
	public long nextLongFixed() throws IOException {
		consumeValue(FieldTag.F64);
		return readFixedLong();
	}

	@Override
	public float nextFloat() throws IOException {
		consumeValue(FieldTag.F32);
		return Float.intBitsToFloat(readFixedInt());
	}

	@Override
	public double nextDouble() throws IOException {
		consumeValue(FieldTag.F64);
		return Double.longBitsToDouble(readFixedLong());
	}

	@Override
	public String nextString() throws IOException {
		consumeValue(FieldTag.REPEATED);
		long sizeAndTag = readVarLong();
		ContentTag tag = tag(sizeAndTag);
		assert tag == ContentTag.CHAR : "Received '" + tag + "' but character string was requested.";
		int size = size(sizeAndTag);
		
		return new String(readBinary(size), "utf-8");
	}

	@Override
	public byte[] nextBinary() throws IOException {
		switch (_content) {
		case REPEATED: {
			consumeValue(FieldTag.REPEATED);
			
			long sizeAndTag = readVarLong();
			ContentTag tag = tag(sizeAndTag);
			assert tag == ContentTag.F8: "Received '" + tag + "' but binary string was requested.";
			int size = size(sizeAndTag);
			
			return readBinary(size);
		}
		
		case CHUNKED: {
			consumeValue(FieldTag.CHUNKED);
			
			long sizeAndTag = readVarLong();
			ContentTag tag = tag(sizeAndTag);
			assert tag == ContentTag.F8: "Received '" + tag + "' but binary string was requested.";
			
			try (InputStream in = new ChunkedInputStream()) {
				byte[] result = new byte[0];
				while (true) {
					int available = in.available();
					if (available == 0) {
						return result;
					}
					int currentLength = result.length;
					byte[] next = new byte[currentLength + available];
					System.arraycopy(result, 0, next, 0, currentLength);
					in.read(next, currentLength, available);
					result = next;
				}
			}
		}

		default:
			throw unexpectedContent(FieldTag.REPEATED);
		}
	}
	
	@Override
	public InputStream nextBinaryStream() throws IOException {
		switch (_content) {
		case REPEATED: {
			consumeValue(FieldTag.REPEATED);
			
			long sizeAndTag = readVarLong();
			ContentTag tag = tag(sizeAndTag);
			assert tag == ContentTag.F8: "Received '" + tag + "' but binary string was requested.";
			
			int size = size(sizeAndTag);
			return new LimitedInputStream(size);
		}
		case CHUNKED: {
			consumeValue(FieldTag.CHUNKED);
			
			long sizeAndTag = readVarLong();
			ContentTag tag = tag(sizeAndTag);
			assert tag == ContentTag.F8: "Received '" + tag + "' but binary string was requested.";
			
			return new ChunkedInputStream();
		}
		default:
			throw unexpectedContent(FieldTag.REPEATED);
		}
	}
	
	private class LimitedInputStream extends InputStream {

		private int _available;

		public LimitedInputStream(int size) {
			_available = size;
		}
		
		@Override
		public int read() throws IOException {
			if (_available == 0) {
				return -1;
			}
			_available--;
			return _in.read();
		}
		
		@Override
		public int read(byte[] buffer, int off, int len) throws IOException {
			if (_available == 0) {
				return -1;
			}
			
			int direct = Math.min(_available, len);
			_available -= direct;
			_in.read(buffer, off, direct);
			return direct;
		}
		
		@Override
		public int available() throws IOException {
			return _available;
		}
		
		@Override
		public void close() throws IOException {
			if (_available > 0) {
				_in.skip(_available);
			}
		}
		
	}
	
	private class ChunkedInputStream extends InputStream {
		
		private final State _before;
		int _chunkSize;
		int _pos;
		
		/** 
		 * Creates a {@link OctetDataReader.ChunkedInputStream}.
		 */
		public ChunkedInputStream() throws IOException {
			_before = _state;
			_state = State.CHUNKED_VALUE;
			
			fetchChunkSize();
		}

		@Override
		public int read() throws IOException {
			ensureData();
			if (_chunkSize == 0) {
				return -1;
			}
			_pos++;
			return _in.read();
		}

		@Override
		public int read(byte[] buffer, int off, int len) throws IOException {
			int available = available();
			if (_chunkSize == 0) {
				return -1;
			}
			int direct = Math.min(available, len);
			_in.read(buffer, off, direct);
			_pos += direct;
			return direct;
		}
		
		@Override
		public int available() throws IOException {
			ensureData();
			return _chunkSize - _pos;
		}
		
		@Override
		public void close() throws IOException {
			while (_chunkSize > 0) {
				int available = available();
				_pos += available;
				_in.skip(available);
			}
			_state = _before;
		}

		private void ensureData() throws IOException {
			if (_pos == _chunkSize && _chunkSize > 0) {
				fetchChunkSize();
			}
		}
		
		private void fetchChunkSize() throws IOException {
			_chunkSize = readVarInt();
			_pos = 0;
		}

	}

	@Override
	public int beginArray() throws IOException {
		requireState(State.FIELD_VALUE);
		_state = State.ARRAY_VALUE;

		long sizeAndTag = readVarLong();
		_content = tag(sizeAndTag).toFieldTag();
		_length = size(sizeAndTag);
		
		return _length;
	}

	@Override
	public void endArray() throws IOException {
		requireState(State.ARRAY_VALUE);
		assert _length == 0 : "Received array value (" + _length + " remaining) while end of array was requested.";
		_state = State.FIELD;
	}
	
	@Override
	public void skipValue() throws IOException {
		FieldTag tag = _content;
		switch (tag) {
		case VAR:
			nextLong();
			break;
		case F32:
			nextIntFixed();
			break;
		case F64:
			nextLongFixed();
			break;
		case F8:
			consumeValue(tag);
			_in.read();
			break;
		case OBJ:
			beginObject();
			while (hasNext()) {
				nextName();
				skipValue();
			}
			endObject();
			break;
		case REPEATED:
			beginArray();
			if (_content == FieldTag.REPEATED) {
				while (hasNext()) {
					// Inner string or byte array.
					long sizeAndTag = readVarLong();
					ContentTag content = tag(sizeAndTag);
					int innerLength = size(sizeAndTag);
					
					assert content == ContentTag.F8 || content == ContentTag.CHAR : "Invalid nested array: " + content;
					_in.skip(innerLength);
					
					_length--;
				}
			} else {
				while (hasNext()) {
					skipValue();
				}
			}
			endArray();
			break;
		case CHUNKED:
			requireState(State.FIELD_VALUE);
			
			long sizeAndTag = readVarLong();
			_content = tag(sizeAndTag).toFieldTag();
			
			while (true) {
				int chunkSize = readVarInt();
				if (chunkSize == 0) {
					break;
				}
				
				_in.skip(chunkSize);
			}
			
			_state = State.FIELD;
			break;
		case STOP:
			assert false : "No value to skip, end of object reached.";
			break;
		}
	}

	private void requireState(State requested) {
		assert _state == requested : "Expecting '" + requested + "' but received '" + _state + "'.";
	}

	private void consumeValue(FieldTag requested) throws IOException {
		assert _content == requested : "Received '" + _content + "' while '" + requested + "' was requested.";
		
		switch (_state) {
		case START:
			assert requested == FieldTag.OBJ : "Data starts always with an object, '" + requested + "' was requested.";
			_state = State.FIELD;
			break;
		case FIELD_VALUE:
			_state = State.FIELD;
			break;
		case ARRAY_VALUE: 
			assert _length > 0 : "Expecting end of array.";
			_length--;
			break;
		default: 
			throw unexpectedContent(requested);
		}
	}

	private IOException unexpectedContent(FieldTag requested) throws IOException {
		throw new IOException("Cannot read '" + requested + "' in state '" + _state + "'.");
	}

	final int readVarInt() throws IOException {
		int result = 0;
		int shift = 0;
		while (true) {
			int data = _in.read();
			if (data < 0) {
				throw new IOException("End of stream received, while reading var int.");
			}
			result |= (data & MASK_7) << shift;
			if ((data & BIT_8) == 0) {
				return result;
			}
			shift += 7;
		}
	}

	private long readVarLong() throws IOException {
		long result = 0;
		int shift = 0;
		while (true) {
			int data = _in.read();
			if (data < 0) {
				throw new IOException("End of stream received, while reading var int.");
			}
			result |= (data & MASK_7) << shift;
			if ((data & BIT_8) == 0) {
				return result;
			}
			shift += 7;
		}
	}
	
	private int readFixedInt() throws IOException {
		int result = 0;
		for (int n = 0; n < 4; n++) {
			int data = _in.read();
			if (data < 0) {
				throw new IOException("End of stream received, while reading fixed int.");
			}
			result <<= 8;
			result |= data;
		}
		return result;
	}

	private long readFixedLong() throws IOException {
		long result = 0;
		for (int n = 0; n < 8; n++) {
			int data = _in.read();
			if (data < 0) {
				throw new IOException("End of stream received, while reading fixed int.");
			}
			result <<= 8;
			result |= data;
		}
		return result;
	}
	
	private byte[] readBinary(int size) throws IOException {
		byte[] result = new byte[size];
		int offset = 0;
		while (offset < size) {
			int direct = _in.read(result, offset, size - offset);
			if (direct < 0) {
				throw new IOException("Received end of stream while receiving a binary string of size '" + size + "'.");
			}
			offset += direct;
		}
		return result;
	}

	private static int name(int nameAndTag) {
		return nameAndTag >>> 3;
	}

	private static FieldTag tag(int nameAndTag) {
		return FieldTag.values()[nameAndTag & MASK_3];
	}

	private static int size(long sizeAndTag) {
		return ((int) (sizeAndTag >>> 3));
	}

	private static ContentTag tag(long sizeAndTag) {
		return ContentTag.values()[((int) sizeAndTag) & MASK_3];
	}

	private static final class SFrame {

		private final State _state;
		private final int _length;
		private FieldTag _content;

		/** 
		 * Creates a {@link SFrame}.
		 * @param expected 
		 */
		public SFrame(State state, int length, FieldTag expected) {
			_state = state;
			_length = length;
			_content = expected;
		}

		public State getState() {
			return _state;
		}

		public int getLength() {
			return _length;
		}
		
		public FieldTag getContent() {
			return _content;
		}
	}
}
