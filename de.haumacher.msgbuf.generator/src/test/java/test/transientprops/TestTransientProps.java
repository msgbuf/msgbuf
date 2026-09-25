/*
 * SPDX-FileCopyrightText: 2025 (c) Business Operation Systems GmbH <info@top-logic.com>
 * 
 * SPDX-License-Identifier: AGPL-3.0-only OR LicenseRef-BOS-TopLogic-1.0
 */
package test.transientprops;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;

import junit.framework.TestCase;
import test.transientprops.data.A;
import test.transientprops.data.B;
import test.transientprops.data.C;

/**
 * Test case for transient properties.
 */
public class TestTransientProps extends TestCase {
	
	public void testA() {
		assertEquals(set(A.X_2__PROP), A.create().transientProperties());
		assertEquals(Arrays.asList(A.X_1__PROP, A.X_2__PROP), A.create().properties());
	}

	public void testB() {
		assertEquals(set(A.X_2__PROP, B.Y_2__PROP), B.create().transientProperties());
		assertEquals(Arrays.asList(A.X_1__PROP, A.X_2__PROP, B.Y_1__PROP, B.Y_2__PROP), B.create().properties());
	}
	
	public void testC() {
		assertEquals(set(A.X_2__PROP, B.Y_2__PROP, C.Z_2__PROP), C.create().transientProperties());
		assertEquals(Arrays.asList(A.X_1__PROP, A.X_2__PROP, B.Y_1__PROP, B.Y_2__PROP, C.Z_1__PROP, C.Z_2__PROP), C.create().properties());
	}
	
	/** Transient properties are not written in XML format (issue #29). */
	public void testXml() throws XMLStreamException {
		C value = C.create().setX1("a").setX2("t").setY1("b").setY2("tt").setZ1("c").setZ2("ttt");
		String xml = xml(value);
		assertEquals("<c x-1=\"a\" y-1=\"b\" z-1=\"c\"></c>", xml);

		C copy = C.readC(xmlReader(xml));
		assertEquals("a", copy.getX1());
		assertEquals("b", copy.getY1());
		assertEquals("c", copy.getZ1());
		assertEquals("", copy.getX2());
		assertEquals("", copy.getZ2());
	}

	/** Documents of earlier versions that contain transient properties can still be read. */
	public void testXmlReadLegacy() throws XMLStreamException {
		C copy = C.readC(xmlReader("<c x-1=\"a\" x-2=\"t\" y-1=\"b\" y-2=\"tt\" z-1=\"c\" z-2=\"ttt\"></c>"));
		assertEquals("a", copy.getX1());
		assertEquals("b", copy.getY1());
		assertEquals("c", copy.getZ1());
		assertEquals("", copy.getX2());
		assertEquals("", copy.getY2());
		assertEquals("", copy.getZ2());
	}

	private static String xml(C value) throws XMLStreamException {
		StringWriter buffer = new StringWriter();
		value.writeTo(XMLOutputFactory.newDefaultFactory().createXMLStreamWriter(buffer));
		return buffer.toString();
	}

	private static javax.xml.stream.XMLStreamReader xmlReader(String xml) throws XMLStreamException {
		return XMLInputFactory.newFactory().createXMLStreamReader(new StringReader(xml));
	}

	private Set<String> set(String ...s) {
		return new HashSet<>(Arrays.asList(s));
	}

}
