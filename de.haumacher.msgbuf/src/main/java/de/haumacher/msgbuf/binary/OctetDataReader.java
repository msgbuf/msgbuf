/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.binary;

import java.io.EOFException;
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

	private final InputStream _in;
	
	private State _state = State.START;
	
	private Tag _content = Tag.OBJ;

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
		State before = _state;
		consumeValue(Tag.OBJ);
		
		_stack.add(new SFrame(before, _length, _content));
		_state = State.FIELD;
		_name = NO_NAME;
	}

	@Override
	public void endObject() throws IOException {
		require(State.FIELD);
		
		fetchName();
		assert _name == END_OF_OBJECT : "There are more fields to read.";
		
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
		require(State.FIELD);
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
			if (_content == Tag.STOP) {
				_name = END_OF_OBJECT;
			} else {
				_name = name(nameAndTag);
			}
		}
	}

	@Override
	public int nextInt() throws IOException {
		consumeValue(Tag.VAR);
		return readVarInt();
	}

	@Override
	public int nextIntSigned() throws IOException {
		consumeValue(Tag.VAR);
		return BinaryUtil.zigzagDecode(readVarInt());
	}

	@Override
	public int nextIntFixed() throws IOException {
		consumeValue(Tag.F32);
		return readFixedInt();
	}

	@Override
	public long nextLong() throws IOException {
		consumeValue(Tag.VAR);
		return readVarLong();
	}

	@Override
	public long nextLongSigned() throws IOException {
		consumeValue(Tag.VAR);
		return BinaryUtil.zigzagDecode(readVarLong());
	}

	@Override
	public long nextLongFixed() throws IOException {
		consumeValue(Tag.F64);
		return readFixedLong();
	}

	@Override
	public float nextFloat() throws IOException {
		consumeValue(Tag.F32);
		return Float.intBitsToFloat(readFixedInt());
	}

	@Override
	public double nextDouble() throws IOException {
		consumeValue(Tag.F64);
		return Double.longBitsToDouble(readFixedLong());
	}

	@Override
	public String nextString() throws IOException {
		consumeValue(Tag.REPEATED);
		long sizeAndTag = readVarLong();
		Tag tag = tag(sizeAndTag);
		assert tag == Tag.CHAR : "Received character string but '" + tag + "' was requested.";
		int size = size(sizeAndTag);
		
		return new String(readBinary(size), "utf-8");
	}

	@Override
	public byte[] nextBinary() throws IOException {
		consumeValue(Tag.REPEATED);
		long sizeAndTag = readVarLong();
		Tag tag = tag(sizeAndTag);
		assert tag == Tag.F8 : "Received '" + tag + "' array but binary string was requested.";
		int size = size(sizeAndTag);
		
		return readBinary(size);
	}

	@Override
	public int beginArray() throws IOException {
		require(State.FIELD_VALUE);
		_state = State.ARRAY_VALUE;

		long sizeAndTag = readVarLong();
		_content = tag(sizeAndTag);
		_length = size(sizeAndTag);
		
		return _length;
	}

	@Override
	public void endArray() throws IOException {
		require(State.ARRAY_VALUE);
		assert _length == 0 : "Received array value (" + _length + " remaining) while end of array was requested.";
		_state = State.FIELD;
	}
	
	@Override
	public void skipValue() throws IOException {
		Tag tag = _content;
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
		case CHAR:
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
			if (_content == Tag.REPEATED) {
				while (hasNext()) {
					// Inner string or byte array.
					long sizeAndTag = readVarLong();
					Tag content = tag(sizeAndTag);
					int innerLength = size(sizeAndTag);
					
					assert content == Tag.F8 || content == Tag.CHAR : "Invalid nested array: " + content;
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
		case STOP:
			assert false : "No value to skip, end of object reached.";
			break;
		}
	}

	private void require(State requested) {
		assert _state == requested : "Expecting '" +_state + "' but received '" + requested + "'.";
	}

	private void consumeValue(Tag requested) {
		switch (_state) {
		case START:
			assert requested == Tag.OBJ : "Data starts always with an object, '" + requested + "' was requested.";
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
			assert false : "Cannot read '" + requested + "' in state '" + _state + "'.";
		}
		
		assert _content == requested : "Received '" + _content + "' while '" + requested + "' was requested."; 
	}

	private int readVarInt() throws IOException {
		int result = 0;
		int shift = 0;
		while (true) {
			int data = _in.read();
			if (data < 0) {
				throw new EOFException("End of stream received, while reading var int.");
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
				throw new EOFException("End of stream received, while reading var int.");
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
				throw new EOFException("End of stream received, while reading fixed int.");
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
				throw new EOFException("End of stream received, while reading fixed int.");
			}
			result <<= 8;
			result |= data;
		}
		return result;
	}
	
	private byte[] readBinary(int size) throws IOException, EOFException {
		byte[] result = new byte[size];
		int offset = 0;
		while (offset < size) {
			int direct = _in.read(result, offset, size - offset);
			if (direct < 0) {
				throw new EOFException("Received end of stream while receiving a binary string of size '" + size + "'.");
			}
			offset += direct;
		}
		return result;
	}

	private static int name(int nameAndTag) {
		return nameAndTag >>> 3;
	}

	private static Tag tag(int nameAndTag) {
		return Tag.values()[nameAndTag & MASK_3];
	}

	private static int size(long sizeAndTag) {
		return ((int) (sizeAndTag >>> 3));
	}

	private static Tag tag(long sizeAndTag) {
		return Tag.values()[((int) sizeAndTag) & MASK_3];
	}

	private static final class SFrame {

		private final State _state;
		private final int _length;
		private Tag _content;

		/** 
		 * Creates a {@link SFrame}.
		 * @param expected 
		 */
		public SFrame(State state, int length, Tag expected) {
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
		
		public Tag getContent() {
			return _content;
		}
	}
}
