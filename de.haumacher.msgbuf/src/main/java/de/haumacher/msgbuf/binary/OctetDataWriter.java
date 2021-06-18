/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.binary;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * {@link DataWriter} that encodes into a stream of octets (8 bit byte values).
 */
public class OctetDataWriter implements DataWriter {
	
	private static final int CHUNK_BUFFER_SIZE = 1024;
	private static final int MIN_CHUNK_SIZE = CHUNK_BUFFER_SIZE / 2;
	
	private static final int MASK_7 = ~(0xFFFFFFFF << 7);
	private static final int MASK_8 = ~(0xFFFFFFFF << 8);

	private static final int BIT_8 = 1 << 7;
	
	final OutputStream _out;
	
	State _state = State.START;
	
	private int _field;
	private DataType _content;
	private int _length;
	
	private final List<SFrame> _stack = new ArrayList<>();

	/** 
	 * Creates a {@link OctetDataWriter}.
	 */
	public OctetDataWriter(OutputStream out) {
		_out = out;
	}

	@Override
	public void beginObject() throws IOException {
		State before = _state;
		switch (_state) {
		case START:
			break;
		case FIELD_VALUE:
			before = State.FIELD;
			break;
		case ARRAY_VALUE:
			consumeArrayValue(DataType.OBJECT);
			break;
		default:
			assert false : "Cannot start object in state '" + _state + "'.";
		}
		_stack.add(new SFrame(before, _length, _content));
		_state = State.FIELD;
	}

	@Override
	public void endObject() throws IOException {
		expect(State.FIELD);
		writeVarInt(FieldTag.STOP.ordinal());
		SFrame frame = _stack.remove(_stack.size() - 1);
		_state = frame.getState();
		_length = frame.getLength();
		_content = frame.getContent();
	}

	@Override
	public void beginArray(DataType type, int length) throws IOException {
		expect(State.FIELD_VALUE);
		writeVarInt(encodeId(FieldTag.REPEATED));
		writeVarLong(encodeLength(type.tag().asContent(), length));
		_length = length;
		_content = type;
		_state = State.ARRAY_VALUE;
	}

	@Override
	public void endArray() throws IOException {
		expect(State.ARRAY_VALUE);
		assert _length == 0;
		_state = State.FIELD;
	}

	@Override
	public void name(int id) throws IOException {
		expect(State.FIELD);
		_field = id;
		
		_state = State.FIELD_VALUE;
	}

	@Override
	public void value(int value) throws IOException {
		valueSeen(DataType.INT);
		writeVarInt(value);
	}

	@Override
	public void valueSigned(int value) throws IOException {
		valueSeen(DataType.SINT);
		writeVarInt(BinaryUtil.zigzagEncode(value));
	}
	
	@Override
	public void valueFixed(int value) throws IOException {
		valueSeen(DataType.FINT);
		writeFixedInt(value);
	}

	@Override
	public void value(float value) throws IOException {
		valueSeen(DataType.FLOAT);
		writeFixedInt(Float.floatToIntBits(value));
	}

	@Override
	public void value(long value) throws IOException {
		valueSeen(DataType.LONG);
		writeVarLong(value);
	}

	@Override
	public void valueSigned(long value) throws IOException {
		valueSeen(DataType.SLONG);
		writeVarLong(BinaryUtil.zigzagEncode(value));
	}
	
	@Override
	public void valueFixed(long value) throws IOException {
		valueSeen(DataType.FLONG);
		writeFixedLong(value);
	}

	@Override
	public void value(double value) throws IOException {
		valueSeen(DataType.DOUBLE);
		writeFixedLong(Double.doubleToLongBits(value));
	}
	
	@Override
	public void value(byte[] value) throws IOException {
		valueSeen(DataType.BINARY);
		writeVarLong(encodeLength(ContentTag.F8, value.length));
		writeBinary(value);
	}
	
	@Override
	public OutputStream valueBinaryStream() throws IOException {
		assert _state == State.FIELD_VALUE : "Chunked binary data can only be written as direct field contents.";
		writeVarInt(encodeId(FieldTag.CHUNKED));
		writeVarLong(encodeLength(ContentTag.F8, 0));
		
		_state = State.CHUNKED_VALUE;
		
		return new OutputStream() {
			int _pos = 0;
			byte[] _buffer;
			
			@Override
			public void write(int data) throws IOException {
				ensureBufferSize(1);
				_buffer[_pos++] = (byte) data;
			}
			
			@Override
			public void write(byte[] buffer, int off, int len) throws IOException {
				if (len >= MIN_CHUNK_SIZE) {
					flush();
					writeChunk(len, off, buffer);
				} else {
					ensureBufferSize(len);
					System.arraycopy(buffer, off, _buffer, _pos, len);
					_pos += len;
				}
			}

			private void ensureBufferSize(int size) throws IOException {
				if (_buffer == null) {
					_buffer = new byte[CHUNK_BUFFER_SIZE];
				}
				if (_pos + size > CHUNK_BUFFER_SIZE) {
					flush();
				}
			}
			
			@Override
			public void flush() throws IOException {
				if (_pos > 0) {
					writeChunk(_pos, 0, _buffer);
					_pos = 0;
				}
			}
			
			@Override
			public void close() throws IOException {
				flush();
				writeVarInt(0);
				
				_state = State.FIELD;
			}

			private void writeChunk(int length, int start, byte[] buffer) throws IOException {
				writeVarInt(length);
				_out.write(buffer, start, length);
			}
		};
	}
	
	@Override
	public void value(String value) throws IOException {
		byte[] bytes = value.getBytes("utf-8");
		
		valueSeen(DataType.STRING);
		writeVarLong(encodeLength(ContentTag.CHAR, bytes.length));
		writeBinary(bytes);
	}

	private void expect(State expected) {
		assert _state == expected : "Invalid state '" + _state + "', expectd '" + expected + "'.";
	}

	private void valueSeen(DataType type) throws IOException {
		switch (_state) {
		case FIELD_VALUE:
			writeVarInt(encodeId(type.tag()));
			_state = State.FIELD;
			break;
		case ARRAY_VALUE:
			consumeArrayValue(type);
			break;
		default:
			assert false : "Invalid state '" + _state + "', expecting either '" + State.FIELD_VALUE + "', or '" + State.ARRAY_VALUE + "'.";
		}
	}

	private void consumeArrayValue(DataType type) {
		assert _length > 0 : "End of array expected.";
		assert _content == type : "Expected value of type '" + _content + "', but received '" + type + "'.";
		_length--;
	}

	final void writeVarInt(int data) throws IOException {
		while (true) {
			int octet = data & MASK_7;
			data >>>= 7;
			if (data == 0) {
				_out.write(octet);
				break;
			} else {
				octet |= BIT_8;
				_out.write(octet);
			}
		}
	}

	private void writeVarLong(long data) throws IOException {
		while (true) {
			int octet = ((int) data) & MASK_7;
			data >>>= 7;
			if (data == 0) {
				_out.write(octet);
				break;
			} else {
				octet |= BIT_8;
				_out.write(octet);
			}
		}
	}
	
	private void writeFixedInt(int data) throws IOException {
		for (int shift = 32 - 8; shift >= 0; shift -= 8) {
			int octet = (data >>> shift) & MASK_8;
			_out.write(octet);
		}
	}

	private void writeFixedLong(long data) throws IOException {
		for (int shift = 64 - 8; shift >= 0; shift -= 8) {
			int octet = ((int) (data >>> shift)) & MASK_8;
			_out.write(octet);
		}
	}
	
	private void writeBinary(byte[] bytes) throws IOException {
		_out.write(bytes);
	}

	private int encodeId(FieldTag tag) {
		return _field << 3 | tag.ordinal();
	}

	private static long encodeLength(ContentTag tag, int length) {
		return (((long) length) << 3) | tag.ordinal();
	}

	private static final class SFrame {

		private final State _state;
		private final int _length;
		private DataType _content;

		/** 
		 * Creates a {@link SFrame}.
		 * @param dataType 
		 */
		public SFrame(State state, int length, DataType dataType) {
			_state = state;
			_length = length;
			_content = dataType;
		}

		public State getState() {
			return _state;
		}

		public int getLength() {
			return _length;
		}
		
		public DataType getContent() {
			return _content;
		}
	}
}
