/*
 * Copyright (c) 2026 Bernhard Haumacher et al. All Rights Reserved.
 */
package test.xmlprimitives;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import de.haumacher.msgbuf.binary.OctetDataReader;
import de.haumacher.msgbuf.binary.OctetDataWriter;
import de.haumacher.msgbuf.io.StringR;
import de.haumacher.msgbuf.json.JsonReader;
import de.haumacher.msgbuf.xml.XmlSerializable;
import junit.framework.TestCase;
import test.xmlprimitives.data.Color;
import test.xmlprimitives.data.Lists;
import test.xmlprimitives.data.Nullables;
import test.xmlprimitives.data.Values;

/**
 * Test case for XML, JSON and binary round-trips of all primitive types, singular, repeated and
 * nullable (issue #44).
 */
@SuppressWarnings("javadoc")
public class TestXmlPrimitives extends TestCase {

	/** 3_000_000_000 as unsigned 32 bit value. */
	private static final int UINT_ABOVE_2_31 = (int) 3_000_000_000L;

	private static final byte[] SOME_BYTES = { 0, 1, -1, 127, -128, 42 };

	public void testValuesDefault() throws Exception {
		Values values = Values.create();
		assertNull(values.getVBytes());
		checkValues(values);
	}

	public void testValuesEdge() throws Exception {
		Map<String, Object> json = new LinkedHashMap<>();
		json.put("a", "x, y");
		json.put("b", Arrays.asList("<&>", true));

		Values values = Values.create()
			.setVBool(true)
			.setVInt32(Integer.MIN_VALUE)
			.setVSint32(-7)
			.setVUint32(UINT_ABOVE_2_31)
			.setVFixed32(0xFFFFFFFF)
			.setVSfixed32(-1)
			.setVInt64(Long.MIN_VALUE)
			.setVSint64(-3)
			.setVUint64(-1L)
			.setVFixed64(Long.MAX_VALUE)
			.setVSfixed64(-1L)
			.setVFloat(-1.5e-30f)
			.setVDouble(-0.0)
			.setVString("<a href=\"x\">&amp; 'quoted', comma</a> é")
			.setVBytes(SOME_BYTES)
			.setVJson(json)
			.setVColor(Color.GREEN);

		Values xml = checkValues(values);
		assertEquals(UINT_ABOVE_2_31, xml.getVUint32());
		assertEquals(0xFFFFFFFF, xml.getVFixed32());
		assertTrue(Arrays.equals(SOME_BYTES, xml.getVBytes()));
		assertEquals(Double.doubleToLongBits(-0.0), Double.doubleToLongBits(xml.getVDouble()));

		String written = toXml(values);
		// Unsigned decimal, as expected by the reader.
		assertTrue(written, written.contains("v-uint-32=\"3000000000\""));
		assertTrue(written, written.contains("v-fixed-32=\"4294967295\""));
		// Base64
		assertTrue(written, written.contains("v-bytes=\"AAH/f4Aq\""));
	}

	public void testValuesEmptyBytes() throws Exception {
		Values xml = checkValues(Values.create().setVBytes(new byte[0]));
		assertNotNull(xml.getVBytes());
		assertEquals(0, xml.getVBytes().length);
	}

	public void testValuesSignedUint32Accepted() throws Exception {
		// Signed decimal is still accepted for unsigned 32 bit values.
		Values values = Values.readValues(reader("<values v-uint-32='-1' v-fixed-32='-2'/>"));
		assertEquals(-1, values.getVUint32());
		assertEquals(-2, values.getVFixed32());
	}

	public void testValuesElements() throws Exception {
		Values values = Values.readValues(reader(
			"<values><v-uint-32>4294967295</v-uint-32><v-bytes>AAH/f4Aq</v-bytes><v-color>RED</v-color></values>"));
		assertEquals(-1, values.getVUint32());
		assertTrue(Arrays.equals(SOME_BYTES, values.getVBytes()));
		assertEquals(Color.RED, values.getVColor());
	}

	public void testListsEmpty() throws Exception {
		Lists xml = checkLists(Lists.create());
		assertTrue(xml.getLInt32().isEmpty());
		assertTrue(xml.getLString().isEmpty());
		assertTrue(xml.getLBytes().isEmpty());
	}

	public void testListsEdge() throws Exception {
		Lists lists = Lists.create()
			.setLBool(Arrays.asList(true, false))
			.setLInt32(Arrays.asList(Integer.MIN_VALUE, -1, 0, Integer.MAX_VALUE))
			.setLSint32(Arrays.asList(-7, 7))
			.setLUint32(Arrays.asList(UINT_ABOVE_2_31, 0, -1))
			.setLFixed32(Arrays.asList(0xFFFFFFFF, 1))
			.setLSfixed32(Arrays.asList(-1))
			.setLInt64(Arrays.asList(Long.MIN_VALUE, Long.MAX_VALUE))
			.setLSint64(Arrays.asList(-3L))
			.setLUint64(Arrays.asList(-1L, 0L))
			.setLFixed64(Arrays.asList(Long.MAX_VALUE))
			.setLSfixed64(Arrays.asList(-1L, 5L))
			.setLFloat(Arrays.asList(-1.5f, 0.25f))
			.setLDouble(Arrays.asList(1e300, -0.0))
			.setLString(Arrays.asList("a", "<b&c>", "d e"))
			.setLBytes(Arrays.asList(SOME_BYTES, new byte[0], new byte[] { 7 }))
			.setLColor(Arrays.asList(Color.GREEN, Color.RED));

		Lists xml = checkLists(lists);
		assertEquals(Arrays.asList(UINT_ABOVE_2_31, 0, -1), xml.getLUint32());
		assertEquals(3, xml.getLBytes().size());
		assertTrue(Arrays.equals(SOME_BYTES, xml.getLBytes().get(0)));
		assertEquals(0, xml.getLBytes().get(1).length);

		String written = toXml(lists);
		assertTrue(written, written.contains("l-uint-32=\"3000000000, 0, 4294967295\""));
	}

	public void testListsElements() throws Exception {
		Lists lists = Lists.readLists(reader(
			"<lists><l-int-32>1, 2,3</l-int-32><l-uint-32/><l-bytes>AAH/f4Aq, Bw==</l-bytes></lists>"));
		assertEquals(Arrays.asList(1, 2, 3), lists.getLInt32());
		assertEquals(Collections.emptyList(), lists.getLUint32());
		assertEquals(2, lists.getLBytes().size());
		assertTrue(Arrays.equals(new byte[] { 7 }, lists.getLBytes().get(1)));
	}

	public void testNullablesUnset() throws Exception {
		Nullables xml = checkNullables(Nullables.create());
		assertFalse(xml.hasNInt32());
		assertFalse(xml.hasNUint32());
		assertFalse(xml.hasNBytes());
		assertFalse(xml.hasNString());
		assertFalse(xml.hasNColor());
		assertFalse(xml.hasNJson());
	}

	public void testNullablesSet() throws Exception {
		List<Object> json = new ArrayList<>();
		json.add("x");
		json.add(Collections.singletonMap("k", "v"));

		Nullables nullables = Nullables.create()
			.setNBool(false)
			.setNInt32(0)
			.setNSint32(-1)
			.setNUint32(UINT_ABOVE_2_31)
			.setNFixed32(-1)
			.setNSfixed32(Integer.MIN_VALUE)
			.setNInt64(0L)
			.setNSint64(-1L)
			.setNUint64(-1L)
			.setNFixed64(1L)
			.setNSfixed64(Long.MIN_VALUE)
			.setNFloat(0.0f)
			.setNDouble(Double.MAX_VALUE)
			.setNString("")
			.setNBytes(new byte[0])
			.setNJson(json)
			.setNColor(Color.RED)
			.setNlInt32(new ArrayList<>())
			.setNlUint32(Arrays.asList(UINT_ABOVE_2_31))
			.setNlString(Arrays.asList("s"))
			.setNlBytes(Arrays.asList(SOME_BYTES));

		Nullables xml = checkNullables(nullables);
		assertTrue(xml.hasNInt32());
		assertEquals(Integer.valueOf(UINT_ABOVE_2_31), xml.getNUint32());
		assertTrue(xml.hasNString());
		assertEquals("", xml.getNString());
		assertTrue(xml.hasNBytes());
		assertEquals(0, xml.getNBytes().length);
		assertTrue(xml.hasNlInt32());
		assertTrue(xml.getNlInt32().isEmpty());
		assertTrue(Arrays.equals(SOME_BYTES, xml.getNlBytes().get(0)));
	}

	/**
	 * Checks round-trips in all formats and returns the value read back from XML.
	 */
	private Values checkValues(Values values) throws Exception {
		String expected = values.toString();
		assertEquals(expected, Values.readValues(new JsonReader(new StringR(expected))).toString());

		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		values.writeTo(new OctetDataWriter(buffer));
		assertEquals(expected, Values.readValues(new OctetDataReader(new ByteArrayInputStream(buffer.toByteArray()))).toString());

		String xml = toXml(values);
		Values result = Values.readValues(reader(xml));
		assertEquals(xml, expected, result.toString());
		assertEquals(xml, toXml(result));
		return result;
	}

	private Lists checkLists(Lists lists) throws Exception {
		String expected = lists.toString();
		assertEquals(expected, Lists.readLists(new JsonReader(new StringR(expected))).toString());

		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		lists.writeTo(new OctetDataWriter(buffer));
		assertEquals(expected, Lists.readLists(new OctetDataReader(new ByteArrayInputStream(buffer.toByteArray()))).toString());

		String xml = toXml(lists);
		Lists result = Lists.readLists(reader(xml));
		assertEquals(xml, expected, result.toString());
		assertEquals(xml, toXml(result));
		return result;
	}

	private Nullables checkNullables(Nullables nullables) throws Exception {
		String expected = nullables.toString();
		assertEquals(expected, Nullables.readNullables(new JsonReader(new StringR(expected))).toString());

		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		nullables.writeTo(new OctetDataWriter(buffer));
		assertEquals(expected, Nullables.readNullables(new OctetDataReader(new ByteArrayInputStream(buffer.toByteArray()))).toString());

		String xml = toXml(nullables);
		Nullables result = Nullables.readNullables(reader(xml));
		assertEquals(xml, expected, result.toString());
		assertEquals(xml, toXml(result));
		return result;
	}

	private static String toXml(XmlSerializable value) throws XMLStreamException {
		StringWriter buffer = new StringWriter();
		value.writeTo(XMLOutputFactory.newDefaultFactory().createXMLStreamWriter(buffer));
		return buffer.toString();
	}

	private static XMLStreamReader reader(String xml) throws XMLStreamException, IOException {
		return XMLInputFactory.newFactory().createXMLStreamReader(new StringReader(xml));
	}

}
