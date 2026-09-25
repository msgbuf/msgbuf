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
import test.nested.doc.Doc;
import test.nested.doc.Figure;
import test.nested.note.Note;

/**
 * Test case for a nested polymorphic hierarchy used in repeated, map and nullable fields, and
 * referenced from another file (issue #16).
 */
@SuppressWarnings("javadoc")
public class TestNestedDoc extends TestCase {

	public void testJson() throws IOException {
		Doc doc = createDoc();
		String json = doc.toString();
		assertEquals("{\"items\":["
			+ "[\"Case\",{\"kind\":\"RICH\",\"package\":\"pkg\",\"weight\":3,\"children\":["
			+ "[\"Para\",{\"kind\":\"PLAIN\",\"package\":\"\",\"weight\":1,\"text\":\"hello\"}],"
			+ "[\"Figure\",{\"kind\":\"PLAIN\",\"package\":\"\",\"weight\":0,\"src\":\"x.png\"}],"
			+ "[\"Case\",{\"kind\":\"PLAIN\",\"package\":\"\",\"weight\":0,\"children\":[]}]]}],"
			+ "[\"Figure\",{\"kind\":\"PLAIN\",\"package\":\"\",\"weight\":0,\"src\":\"y\"}]],"
			+ "\"byName\":{\"p\":[\"Para\",{\"kind\":\"PLAIN\",\"package\":\"\",\"weight\":0,\"text\":\"m\"}]},"
			+ "\"maybe\":[\"Figure\",{\"kind\":\"PLAIN\",\"package\":\"\",\"weight\":0,\"src\":\"\"}]}", json);
		assertEquals(json, Doc.readDoc(new JsonReader(new StringR(json))).toString());
	}

	public void testJsonNullable() throws IOException {
		String json = Doc.create().toString();
		assertEquals("{\"items\":[],\"byName\":{}}", json);
		assertNull(Doc.readDoc(new JsonReader(new StringR(json))).getMaybe());
	}

	public void testBinary() throws IOException {
		Doc doc = createDoc();
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		doc.writeTo(new OctetDataWriter(buffer));
		Doc copy = Doc.readDoc(new OctetDataReader(new ByteArrayInputStream(buffer.toByteArray())));
		assertEquals(doc.toString(), copy.toString());
	}

	public void testXml() throws XMLStreamException {
		// Doc itself has a map field, which is not supported in XML.
		Doc.Sec.Case value = createCase();
		StringWriter buffer = new StringWriter();
		value.writeTo(XMLOutputFactory.newDefaultFactory().createXMLStreamWriter(buffer));
		Doc.Sec.Item copy = Doc.Sec.Item.readItem(
			XMLInputFactory.newFactory().createXMLStreamReader(new StringReader(buffer.toString())));
		assertEquals(value.toString(), copy.toString());
	}

	public void testCrossFileReference() throws IOException {
		Note note = Note.create()
			.setTarget(createCase())
			.setInner(Note.Inner.create().addRef(Figure.create()).addRef(Doc.Sec.Para.create()));
		String json = note.toString();
		assertEquals(json, Note.readNote(new JsonReader(new StringR(json))).toString());
	}

	public void testVisitor() {
		Doc.Sec.Item.Visitor<String, Void, RuntimeException> visitor =
			new Doc.Sec.Item.Visitor<String, Void, RuntimeException>() {
				@Override
				public String visit(Doc.Sec.Para self, Void arg) {
					return "para";
				}

				@Override
				public String visit(Doc.Sec.Case self, Void arg) {
					return "case";
				}

				@Override
				public String visit(Figure self, Void arg) {
					return "figure";
				}
			};
		assertEquals("case", createCase().visit(visitor, null));
		assertEquals("figure", Figure.create().visit(visitor, null));
	}

	private static Doc createDoc() {
		return Doc.create()
			.addItem(createCase())
			.addItem(Figure.create().setSrc("y"))
			.putByName("p", Doc.Sec.Para.create().setText("m"))
			.setMaybe(Figure.create());
	}

	private static Doc.Sec.Case createCase() {
		Doc.Sec.Case result = Doc.Sec.Case.create().setWeight(3).setPackage("pkg").setKind(Doc.Sec.Item.Kind.RICH);
		result.addChildren(Doc.Sec.Para.create().setText("hello").setWeight(1));
		result.addChildren(Figure.create().setSrc("x.png"));
		result.addChildren(Doc.Sec.Case.create());
		return result;
	}

}
