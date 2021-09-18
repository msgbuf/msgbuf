/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.binary;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

import junit.framework.TestCase;

/**
 * Test case for {@link DataReader} and {@link DataWriter}.
 */
@SuppressWarnings("javadoc")
public class TestDataReaderWriter extends TestCase {
	
	interface IOTest {
		void writeObject(OctetDataWriter out) throws IOException;
		void readObject(OctetDataReader in) throws IOException;
	}
	
	public void testVarIntMessage() throws IOException {
		doTest(new IOTest() {
			@Override
			public void writeObject(OctetDataWriter out) throws IOException {
				out.beginObject();
				out.name(1);
				out.value(42);
				out.endObject();
			}

			@Override
			public void readObject(OctetDataReader in) throws IOException {
				in.beginObject();
				assertEquals(1, in.nextName());
				assertEquals(42, in.nextInt());
				in.endObject();
			}
		});
	}
	
	public void testStringMessage() throws IOException {
		doTest(new IOTest() {
			@Override
			public void writeObject(OctetDataWriter out) throws IOException {
				out.beginObject();
				out.name(1);
				out.value("Hello world!");
				out.endObject();
			}
			
			@Override
			public void readObject(OctetDataReader in) throws IOException {
				in.beginObject();
				assertEquals(1, in.nextName());
				assertEquals("Hello world!", in.nextString());
				in.endObject();
			}
		});
	}
	
	public void testByteArrayAsStreamMessage() throws IOException {
		doTest(new IOTest() {
			@Override
			public void writeObject(OctetDataWriter out) throws IOException {
				out.beginObject();
				out.name(1);
				out.value(new byte[] {1, 2, 3, 4, 5});
				out.endObject();
			}
			
			@Override
			public void readObject(OctetDataReader in) throws IOException {
				in.beginObject();
				assertEquals(1, in.nextName());
				try (InputStream data = in.nextBinaryStream()) {
					assertEquals(1, data.read());
					assertEquals(2, data.read());
					assertEquals(3, data.read());
					assertEquals(4, data.read());
					assertEquals(5, data.read());
					assertEquals(-1, data.read());
				}
				in.endObject();
			}
		});
	}
	
	public void testChunkedStreamMessage() throws IOException {
		doTest(new IOTest() {
			@Override
			public void writeObject(OctetDataWriter out) throws IOException {
				out.beginObject();
				out.name(1);
				try (OutputStream data = out.valueBinaryStream()) {
					for (int n = 0; n < 1000; n++) {
						data.write(0);
						data.write(new byte[] {1, 2, 3, 4, 5});				
					}
				}
				out.endObject();
			}
			
			@Override
			public void readObject(OctetDataReader in) throws IOException {
				in.beginObject();
				assertEquals(1, in.nextName());
				try (InputStream data = in.nextBinaryStream()) {
					for (int n = 0; n < 1000; n++) {
						assertEquals(0, data.read());
						assertEquals(1, data.read());
						assertEquals(2, data.read());
						assertEquals(3, data.read());
						assertEquals(4, data.read());
						assertEquals(5, data.read());
					}
					assertEquals(-1, data.read());
				}
				in.endObject();
			}
		});
	}
	
	public void testComplexMessage() throws IOException {
		doTest(new IOTest() {
			@Override
			public void writeObject(OctetDataWriter out) throws IOException {
				out.beginObject();
				int wField = 0;

				out.name(wField++);
				out.value(1);
				out.name(wField++);
				out.valueSigned(-2);
				out.name(wField++);
				out.valueFixed(0xCAFEBABE);
				
				out.name(wField++);
				out.value(1L);
				out.name(wField++);
				out.valueSigned(-2L);
				out.name(wField++);
				out.valueFixed(0xCAFEBABECAFEBABEL);
				
				out.name(wField++);
				out.value(13.42f);
				out.name(wField++);
				out.value(42.13d);
				
				out.name(wField++);
				out.beginArray(DataType.INT, 2);
				out.value(99);
				out.value(9999);
				out.endArray();
				
				out.name(wField++);
				out.beginArray(DataType.STRING, 3);
				out.value("Hello");
				out.value("world");
				out.value("!");
				out.endArray();
				
				out.name(wField++);
				out.beginArray(DataType.OBJECT, 2);
				{
					out.beginObject();
					{
						out.name(0);
						out.value(13);
						out.name(1);
						out.value("My value");
					}
					out.endObject();
					
					out.beginObject();
					{
						out.name(2);
						out.value("First value");
						out.name(3);
						out.value("Second value");
					}
					out.endObject();
				}
				out.endArray();
				
				out.name(wField++);
				out.value("Hällo Wörld!");
				
				out.name(wField++);
				out.value(new byte[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
				
				out.name(wField++);
				writeChunkedValue(out);
				
				out.name(wField++);
				writeChunkedValue(out);
				
				out.endObject();
			}
			
			@Override
			public void readObject(OctetDataReader in) throws IOException {
				int rField = 0;
				
				in.beginObject();
				assertEquals(rField++, in.nextName());
				assertEquals(1, in.nextInt());
				assertEquals(rField++, in.nextName());
				assertEquals(-2, in.nextIntSigned());
				assertEquals(rField++, in.nextName());
				assertEquals(0xCAFEBABE, in.nextIntFixed());
				
				assertTrue(in.hasNext());
				assertEquals(rField++, in.nextName());
				assertEquals(1, in.nextLong());
				assertEquals(rField++, in.nextName());
				assertEquals(-2, in.nextLongSigned());
				assertEquals(rField++, in.nextName());
				assertEquals(0xCAFEBABECAFEBABEL, in.nextLongFixed());
				
				assertEquals(rField++, in.nextName());
				assertEquals(13.42f, in.nextFloat());
				assertEquals(rField++, in.nextName());
				assertEquals(42.13d, in.nextDouble());
				
				assertEquals(rField++, in.nextName());
				assertEquals(2, in.beginArray());
				{
					assertEquals(99, in.nextInt());
					assertEquals(9999, in.nextInt());
				}
				in.endArray();
				
				assertEquals(rField++, in.nextName());
				assertEquals(3, in.beginArray());
				{
					assertEquals("Hello", in.nextString());
					assertEquals("world", in.nextString());
					assertTrue(in.hasNext());
					assertEquals("!", in.nextString());
					assertFalse(in.hasNext());
				}
				in.endArray();
				
				assertEquals(rField++, in.nextName());
				assertEquals(2, in.beginArray());
				{
					in.beginObject();
					{
						assertEquals(0, in.nextName());
						assertEquals(13, in.nextInt());
						
						assertTrue(in.hasNext());
						assertEquals(1, in.nextName());
						assertEquals("My value", in.nextString());
			
						assertFalse(in.hasNext());
					}
					in.endObject();
					
					assertTrue(in.hasNext());
					in.beginObject();
					{
						assertEquals(2, in.nextName());
						assertEquals("First value", in.nextString());
						
						assertTrue(in.hasNext());
						assertEquals(3, in.nextName());
						assertEquals("Second value", in.nextString());
			
						assertFalse(in.hasNext());
					}
					in.endObject();
			
					assertFalse(in.hasNext());
				}
				in.endArray();
				
				assertTrue(in.hasNext());
				assertEquals(rField++, in.nextName());
				assertEquals("Hällo Wörld!", in.nextString());
				
				assertEquals(rField++, in.nextName());
				assertEquals(10, in.nextBinary().length);
				
				assertEquals(rField++, in.nextName());
				assertEquals(3710, in.nextBinary().length);
				
				assertEquals(rField++, in.nextName());
				try (InputStream content = in.nextBinaryStream()) {
					assertEquals(1, content.read());
					assertEquals(2, content.read());
					assertEquals(3, content.read());
					assertEquals(4, content.read());
					assertEquals(5, content.read());
				}
				
				assertFalse(in.hasNext());
				in.endObject();
			}
		});
	}

	private void doTest(IOTest io) throws IOException {
		doTestEncodeDecode(io);
		doTestSkipValue(io);
	}
	
	public void doTestEncodeDecode(IOTest io) throws IOException {
		byte[] message = createMessage(io);
		readMessage(message, io);
	}

	private byte[] createMessage(IOTest io) throws IOException {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		OctetDataWriter out = new OctetDataWriter(buffer);
		
		io.writeObject(out);
		writeMarkerOject(out);
		
		return buffer.toByteArray();
	}

	private void readMessage(byte[] message, IOTest io) throws IOException {
		OctetDataReader in = reader(message);
		io.readObject(in);
		readMarkerObject(in);
	}

	static void writeChunkedValue(OctetDataWriter out) throws IOException {
		try (OutputStream content = out.valueBinaryStream()) {
			content.write(1);
			content.write(new byte[] {2, 3, 4, 5, 6, 7, 8, 9, 10});
			content.write(chunk(200, 11));
			content.write(chunk(500, 12));
			content.write(chunk(1000, 13));
			content.write(chunk(2000, 14));
		}
	}

	private static byte[] chunk(int length, int value) {
		byte[] result = new byte[length];
		Arrays.fill(result, (byte)value);
		return result;
	}

	private OctetDataReader reader(byte[] message) {
		OctetDataReader in = new OctetDataReader(new ByteArrayInputStream(message));
		return in;
	}
	
	public void doTestSkipValue(IOTest io) throws IOException {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		OctetDataWriter out = new OctetDataWriter(buffer);
		
		io.writeObject(out);
		writeMarkerOject(out);
		
		byte[] message = buffer.toByteArray();
		OctetDataReader in = reader(message);
		
		in.skipValue();
		readMarkerObject(in);
	}

	private void writeMarkerOject(OctetDataWriter out) throws IOException {
		out.beginObject();
		out.name(12345);
		out.value("The end!");
		out.endObject();
	}

	private void readMarkerObject(OctetDataReader in) throws IOException {
		in.beginObject();
		assertEquals(12345, in.nextName());
		assertEquals("The end!", in.nextString());
		in.endObject();
	}
	
}
