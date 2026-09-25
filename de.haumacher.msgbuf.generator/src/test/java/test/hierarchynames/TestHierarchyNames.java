/*
 * Copyright (c) 2026 Bernhard Haumacher et al. All Rights Reserved.
 */
package test.hierarchynames;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;

import de.haumacher.msgbuf.binary.OctetDataReader;
import de.haumacher.msgbuf.binary.OctetDataWriter;
import de.haumacher.msgbuf.io.StringR;
import de.haumacher.msgbuf.json.JsonReader;
import junit.framework.TestCase;
import test.hierarchynames.data.A;
import test.hierarchynames.data.B;
import test.hierarchynames.data.Container;
import test.hierarchynames.data.Item;

/**
 * Test case for messages of one hierarchy with equal simple names that are made distinct with
 * <code>@Name</code> (issue #45).
 */
@SuppressWarnings("javadoc")
public class TestHierarchyNames extends TestCase {

	public void testNestedItemA() throws Exception {
		Container container = Container.create().setMsg(A.Item.create().setA("x")).setShape(Item.create().setTop("t"));
		assertEquals("{\"msg\":[\"A.Item\",{\"a\":\"x\"}],\"shape\":[\"TopItem\",{\"top\":\"t\"}]}", container.toString());
		checkRoundTrips(container);
	}

	public void testNestedItemB() throws Exception {
		Container container = Container.create().setMsg(B.Item.create().setB(42));
		assertEquals("{\"msg\":[\"Item\",{\"b\":42}]}", container.toString());
		checkRoundTrips(container);
	}

	private void checkRoundTrips(Container container) throws Exception {
		String json = container.toString();

		Container fromJson = Container.readContainer(new JsonReader(new StringR(json)));
		assertEquals(json, fromJson.toString());

		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		container.writeTo(new OctetDataWriter(buffer));
		Container fromBinary = Container.readContainer(new OctetDataReader(new ByteArrayInputStream(buffer.toByteArray())));
		assertEquals(json, fromBinary.toString());

		StringWriter xml = new StringWriter();
		container.writeTo(XMLOutputFactory.newDefaultFactory().createXMLStreamWriter(xml));
		Container fromXml = Container.readContainer(XMLInputFactory.newFactory().createXMLStreamReader(new StringReader(xml.toString())));
		assertEquals(xml.toString(), json, fromXml.toString());
	}

}
