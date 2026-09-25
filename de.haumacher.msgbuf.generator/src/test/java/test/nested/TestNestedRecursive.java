/*
 * Copyright (c) 2026 Bernhard Haumacher et al. All Rights Reserved.
 */
package test.nested;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;

import de.haumacher.msgbuf.binary.OctetDataReader;
import de.haumacher.msgbuf.binary.OctetDataWriter;
import de.haumacher.msgbuf.io.StringR;
import de.haumacher.msgbuf.json.JsonReader;
import junit.framework.TestCase;
import test.nested.recursive.Expr;
import test.nested.recursive.Node;

/**
 * Test case for specializations nested in their own generalization (issue #32).
 */
@SuppressWarnings("javadoc")
public class TestNestedRecursive extends TestCase {

	public void testJson() throws IOException {
		Expr.Sum sum = createSum();
		String json = sum.toString();
		assertEquals("[\"Sum\",{\"label\":\"s\",\"operands\":[[\"Literal\",{\"label\":\"a\",\"value\":1}],"
			+ "[\"Sum\",{\"label\":\"\",\"operands\":[]}]],\"first\":{\"label\":\"\",\"value\":2}}]", json);
		assertEquals(json, Expr.readExpr(new JsonReader(new StringR(json))).toString());
	}

	public void testBinary() throws IOException {
		Expr.Sum sum = createSum();
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		sum.writeTo(new OctetDataWriter(buffer));
		Expr copy = Expr.readExpr(new OctetDataReader(new ByteArrayInputStream(buffer.toByteArray())));
		assertEquals(sum.toString(), copy.toString());
	}

	public void testXml() throws XMLStreamException {
		Expr.Sum sum = createSum();
		StringWriter buffer = new StringWriter();
		sum.writeTo(XMLOutputFactory.newDefaultFactory().createXMLStreamWriter(buffer));
		Expr copy = Expr.readExpr(XMLInputFactory.newFactory().createXMLStreamReader(new StringReader(buffer.toString())));
		assertEquals(sum.toString(), copy.toString());
	}

	public void testFieldIndexes() {
		// Inherited fields keep their index, own fields of the nested specializations follow.
		assertEquals(1, Expr.Literal.LABEL__ID);
		assertEquals(2, Expr.Literal.VALUE__ID);
		assertEquals(2, Expr.Sum.OPERANDS__ID);
		assertEquals(3, Expr.Sum.FIRST__ID);
		assertEquals(3, Node.Special.WEIGHT__ID);
	}

	public void testConcreteRoot() throws IOException {
		// A hierarchy with a concrete root carries no type information, read through the specialization's reader.
		Node.Special special = Node.Special.create().setWeight(4);
		special.setName("s");
		special.addChildren(Node.create().setName("c"));
		String json = special.toString();
		assertEquals("{\"name\":\"s\",\"children\":[{\"name\":\"c\",\"children\":[]}],\"weight\":4}", json);
		assertEquals(json, Node.Special.readSpecial(new JsonReader(new StringR(json))).toString());
	}

	private static Expr.Sum createSum() {
		Expr.Sum result = Expr.Sum.create();
		result.setLabel("s");
		result.addOperand(Expr.Literal.create().setValue(1).setLabel("a"));
		result.addOperand(Expr.Sum.create());
		result.setFirst(Expr.Literal.create().setValue(2));
		return result;
	}

}
