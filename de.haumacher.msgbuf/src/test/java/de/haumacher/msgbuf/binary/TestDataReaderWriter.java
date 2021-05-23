/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.binary;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import junit.framework.TestCase;

/**
 * Test case for {@link DataReader} and {@link DataWriter}.
 */
@SuppressWarnings("javadoc")
public class TestDataReaderWriter extends TestCase {
	
	public void testEncodeDecode() throws IOException {
		byte[] message = createMessage();
		readMessage(message);
	}

	private byte[] createMessage() throws IOException {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		OctetDataWriter out = new OctetDataWriter(buffer);
		
		wirteObject(out);
		
		return buffer.toByteArray();
	}

	private void wirteObject(OctetDataWriter out) throws IOException {
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
		out.endObject();
	}

	private void readMessage(byte[] message) throws IOException {
		OctetDataReader in = reader(message);
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
		
		assertFalse(in.hasNext());
		in.endObject();
	}

	private OctetDataReader reader(byte[] message) {
		OctetDataReader in = new OctetDataReader(new ByteArrayInputStream(message));
		return in;
	}
	
	public void testSkipValue() throws IOException {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		OctetDataWriter out = new OctetDataWriter(buffer);
		
		wirteObject(out);
		
		out.beginObject();
		out.name(12345);
		out.value("The end!");
		out.endObject();
		
		byte[] message = buffer.toByteArray();
		OctetDataReader in = reader(message);
		
		in.skipValue();
		
		in.beginObject();
		assertEquals(12345, in.nextName());
		assertEquals("The end!", in.nextString());
		in.endObject();
	}

}
