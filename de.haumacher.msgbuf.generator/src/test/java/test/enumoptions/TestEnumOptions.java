/*
 * Copyright (c) 2026 Bernhard Haumacher et al. All Rights Reserved.
 */
package test.enumoptions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import de.haumacher.msgbuf.binary.DataReader;
import de.haumacher.msgbuf.binary.DataWriter;
import de.haumacher.msgbuf.binary.OctetDataReader;
import de.haumacher.msgbuf.binary.OctetDataWriter;
import de.haumacher.msgbuf.io.StringR;
import de.haumacher.msgbuf.json.JsonReader;
import de.haumacher.msgbuf.json.JsonWriter;
import junit.framework.TestCase;

/**
 * Test case for enums honoring the serialization options of their file, like messages do (issue #20).
 */
@SuppressWarnings("javadoc")
public class TestEnumOptions extends TestCase {

	public void testNoBinary() throws IOException {
		assertFormats(test.enumoptions.nobinary.M.Nested.class, true, false);
		assertFormats(test.enumoptions.nobinary.TopLevel.class, true, false);

		test.enumoptions.nobinary.M value = test.enumoptions.nobinary.M.create()
			.setNested(test.enumoptions.nobinary.M.Nested.B)
			.setTop(test.enumoptions.nobinary.TopLevel.Y);
		String json = value.toString();
		assertEquals("{\"nested\":\"B\",\"top\":\"Y\"}", json);
		test.enumoptions.nobinary.M copy = test.enumoptions.nobinary.M.readM(new JsonReader(new StringR(json)));
		assertEquals(test.enumoptions.nobinary.M.Nested.B, copy.getNested());
		assertEquals(test.enumoptions.nobinary.TopLevel.Y, copy.getTop());
	}

	public void testNoJson() throws IOException {
		assertFormats(test.enumoptions.nojson.M.Nested.class, false, true);
		assertFormats(test.enumoptions.nojson.TopLevel.class, false, true);

		test.enumoptions.nojson.M value = test.enumoptions.nojson.M.create()
			.setNested(test.enumoptions.nojson.M.Nested.B)
			.setTop(test.enumoptions.nojson.TopLevel.Y);
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		value.writeTo(new OctetDataWriter(buffer));
		test.enumoptions.nojson.M copy = test.enumoptions.nojson.M.readM(
			new OctetDataReader(new ByteArrayInputStream(buffer.toByteArray())));
		assertEquals(test.enumoptions.nojson.M.Nested.B, copy.getNested());
		assertEquals(test.enumoptions.nojson.TopLevel.Y, copy.getTop());
	}

	public void testSharedGraph() {
		// SharedGraph implies JSON and excludes binary.
		assertFormats(test.enumoptions.sharedgraph.M.Nested.class, true, false);
		assertFormats(test.enumoptions.sharedgraph.TopLevel.class, true, false);
	}

	private static void assertFormats(Class<? extends Enum<?>> type, boolean json, boolean binary) {
		String name = type.getSimpleName();
		assertEquals("JSON writer of " + name, json, hasMethod(type, "writeTo", JsonWriter.class));
		assertEquals("JSON reader of " + name, json, hasMethod(type, "read" + name, JsonReader.class));
		assertEquals("Binary writer of " + name, binary, hasMethod(type, "writeTo", DataWriter.class));
		assertEquals("Binary reader of " + name, binary, hasMethod(type, "read" + name, DataReader.class));
	}

	private static boolean hasMethod(Class<?> type, String name, Class<?> parameterType) {
		for (Method method : type.getMethods()) {
			if (method.getName().equals(name) && method.getParameterCount() == 1
				&& method.getParameterTypes()[0] == parameterType) {
				return true;
			}
		}
		return false;
	}

}
