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
import javax.xml.stream.XMLStreamReader;

import de.haumacher.msgbuf.binary.OctetDataReader;
import de.haumacher.msgbuf.binary.OctetDataWriter;
import de.haumacher.msgbuf.io.StringR;
import de.haumacher.msgbuf.json.JsonReader;
import de.haumacher.msgbuf.xml.XmlSerializable;
import junit.framework.TestCase;
import test.nested.data.Animal;
import test.nested.data.Holder;
import test.nested.data.Level1;
import test.nested.data.Level1.Level2;
import test.nested.data.Outer;
import test.nested.data.Triangle;
import test.nested.data.Zoo;
import test.nested.owbase.Events;
import test.nested.owcount.CountEvent;
import test.nested.owext.Patches;

/**
 * Test case for polymorphic hierarchies whose abstract root (or parts of it) are nested messages (issue #16).
 */
@SuppressWarnings("javadoc")
public class TestNested extends TestCase {

	/** The shape of the issue report: an abstract root nested in a message. */
	public void testNestedAbstractRootJson() throws IOException {
		Outer.Shape circle = Outer.Circle.create().setRadius(5).setName("c");
		assertEquals("[\"Circle\",{\"name\":\"c\",\"radius\":5}]", circle.toString());

		Outer.Shape copy = Outer.Shape.readShape(json(circle.toString()));
		assertTrue(copy instanceof Outer.Circle);
		assertEquals(5, ((Outer.Circle) copy).getRadius());
		assertEquals("c", copy.getName());
	}

	public void testTopLevelExtendingNestedJson() throws IOException {
		Outer.Shape triangle = Triangle.create().setBase(3).setHeight(4).setName("t");
		assertEquals("[\"Triangle\",{\"name\":\"t\",\"base\":3,\"height\":4}]", triangle.toString());
		assertTrue(Outer.Shape.readShape(json(triangle.toString())) instanceof Triangle);
	}

	public void testFieldsInNestedSibling() throws IOException, XMLStreamException {
		Outer.Drawing drawing = Outer.Drawing.create()
			.setMain(Outer.Square.create().setSide(2).setName("main"))
			.addShape(Outer.Circle.create().setRadius(1))
			.addShape(Triangle.create().setBase(7))
			.addShape(Outer.Square.create().setSide(9));
		assertEquals(
			"{\"main\":[\"Square\",{\"name\":\"main\",\"side\":2}],\"shapes\":["
				+ "[\"Circle\",{\"name\":\"\",\"radius\":1}],"
				+ "[\"Triangle\",{\"name\":\"\",\"base\":7,\"height\":0}],"
				+ "[\"Square\",{\"name\":\"\",\"side\":9}]]}",
			drawing.toString());

		String expected = drawing.toString();
		assertEquals(expected, Outer.Drawing.readDrawing(json(expected)).toString());
		assertEquals(expected, Outer.Drawing.readDrawing(binaryReader(binary(drawing))).toString());
		assertEquals(expected, Outer.Drawing.readDrawing(xmlReader(xml(drawing))).toString());

		Outer.Drawing copy = Outer.Drawing.readDrawing(json(expected));
		assertTrue(copy.getMain() instanceof Outer.Square);
		assertTrue(copy.getShapes().get(0) instanceof Outer.Circle);
		assertTrue(copy.getShapes().get(1) instanceof Triangle);
		assertTrue(copy.getShapes().get(2) instanceof Outer.Square);
	}

	public void testFieldInOuter() throws IOException, XMLStreamException {
		Outer outer = Outer.create().setShape(Outer.Circle.create().setRadius(42).setName("x"));
		String expected = outer.toString();
		assertEquals("{\"shape\":[\"Circle\",{\"name\":\"x\",\"radius\":42}]}", expected);
		assertEquals(expected, Outer.readOuter(json(expected)).toString());
		assertEquals(expected, Outer.readOuter(binaryReader(binary(outer))).toString());
		assertEquals(expected, Outer.readOuter(xmlReader(xml(outer))).toString());
	}

	/** Root abstract, abstract intermediate, concrete leaves; nested two levels deep. */
	public void testDeeplyNestedWithAbstractIntermediate() throws IOException, XMLStreamException {
		Level1 value = Level1.create()
			.setNode(Level2.Root.create().setTitle("r")
				.addChildren(Level2.Leaf.create().setValue(1))
				.addChildren(Level2.Branch.create().setExpanded(true)
					.addChildren(Level2.Leaf.create().setValue(2).setLabel("deep"))))
			.addNodes(Level2.Leaf.create().setValue(3))
			.addNodes(Level2.Branch.create());

		String expected = value.toString();
		assertEquals(
			"{\"node\":[\"Root\",{\"label\":\"\",\"children\":["
				+ "[\"Leaf\",{\"label\":\"\",\"value\":1}],"
				+ "[\"Branch\",{\"label\":\"\",\"children\":[[\"Leaf\",{\"label\":\"deep\",\"value\":2}]],\"expanded\":true}]"
				+ "],\"title\":\"r\"}],\"nodes\":["
				+ "[\"Leaf\",{\"label\":\"\",\"value\":3}],"
				+ "[\"Branch\",{\"label\":\"\",\"children\":[],\"expanded\":false}]]}",
			expected);
		assertEquals(expected, Level1.readLevel1(json(expected)).toString());
		assertEquals(expected, Level1.readLevel1(binaryReader(binary(value))).toString());
		assertEquals(expected, Level1.readLevel1(xmlReader(xml(value))).toString());

		// Reading through the abstract intermediate.
		Level2.Composite composite = Level2.Composite.readComposite(json(value.getNode().toString()));
		assertTrue(composite instanceof Level2.Root);
		assertEquals(2, composite.getChildren().size());
	}

	/** Nested sub-messages extending a top-level abstract root. */
	public void testNestedExtendingTopLevel() throws IOException, XMLStreamException {
		Zoo zoo = Zoo.create()
			.addAnimal(Zoo.Cat.create().setIndoor(true).setName("tom"))
			.addAnimal(Zoo.Parrot.create().addWord("hello").setWingspan(0.5).setName("polly"));

		String expected = zoo.toString();
		assertEquals(
			"{\"animals\":[[\"Cat\",{\"name\":\"tom\",\"indoor\":true}],"
				+ "[\"Parrot\",{\"name\":\"polly\",\"wingspan\":0.5,\"words\":[\"hello\"]}]]}",
			expected);
		assertEquals(expected, Zoo.readZoo(json(expected)).toString());
		assertEquals(expected, Zoo.readZoo(binaryReader(binary(zoo))).toString());
		assertEquals(expected, Zoo.readZoo(xmlReader(xml(zoo))).toString());

		Animal parrot = Animal.readAnimal(json(zoo.getAnimals().get(1).toString()));
		assertTrue(parrot instanceof Zoo.Parrot);
		assertTrue(Zoo.Bird.readBird(json(parrot.toString())) instanceof Zoo.Parrot);
	}

	/** A top-level message with fields of nested and top-level abstract types. */
	public void testTopLevelHolder() throws IOException, XMLStreamException {
		Holder holder = Holder.create()
			.setShape(Triangle.create().setHeight(1))
			.addShapes(Outer.Circle.create().setRadius(2))
			.addShapes(Outer.Square.create().setSide(3))
			.setNode(Level2.Leaf.create().setValue(4))
			.addAnimal(Zoo.Cat.create());

		String expected = holder.toString();
		assertEquals(expected, Holder.readHolder(json(expected)).toString());
		assertEquals(expected, Holder.readHolder(binaryReader(binary(holder))).toString());
		assertEquals(expected, Holder.readHolder(xmlReader(xml(holder))).toString());

		Holder copy = Holder.readHolder(binaryReader(binary(holder)));
		assertTrue(copy.getShape() instanceof Triangle);
		assertTrue(copy.getShapes().get(0) instanceof Outer.Circle);
		assertTrue(copy.getShapes().get(1) instanceof Outer.Square);
		assertTrue(copy.getNode() instanceof Level2.Leaf);
		assertTrue(copy.getAnimals().get(0) instanceof Zoo.Cat);
	}

	public void testVisitor() {
		Outer.Shape.Visitor<String, Void, RuntimeException> shapes = new Outer.Shape.Visitor<>() {
			@Override
			public String visit(Outer.Circle self, Void arg) {
				return "circle";
			}

			@Override
			public String visit(Outer.Square self, Void arg) {
				return "square";
			}

			@Override
			public String visit(Triangle self, Void arg) {
				return "triangle";
			}
		};
		assertEquals("circle", Outer.Circle.create().visit(shapes, null));
		assertEquals("square", Outer.Square.create().visit(shapes, null));
		assertEquals("triangle", Triangle.create().visit(shapes, null));

		Level2.Node.Visitor<String, Void, RuntimeException> nodes = new Level2.Node.Visitor<>() {
			@Override
			public String visit(Level2.Leaf self, Void arg) {
				return "leaf";
			}

			@Override
			public String visit(Level2.Branch self, Void arg) {
				return "branch";
			}

			@Override
			public String visit(Level2.Root self, Void arg) {
				return "root";
			}
		};
		assertEquals("leaf", Level2.Leaf.create().visit(nodes, null));
		assertEquals("branch", Level2.Branch.create().visit(nodes, null));
		assertEquals("root", Level2.Root.create().visit(nodes, null));
		// Dispatch through the abstract intermediate's visitor.
		Level2.Node root = Level2.Root.create();
		assertEquals("root", ((Level2.Composite) root).visit((Level2.Composite.Visitor<String, Void, RuntimeException>) nodes, null));

		Animal.Visitor<String, Void, RuntimeException> animals = new Animal.Visitor<>() {
			@Override
			public String visit(Zoo.Cat self, Void arg) {
				return "cat";
			}

			@Override
			public String visit(Zoo.Parrot self, Void arg) {
				return "parrot";
			}
		};
		assertEquals("cat", Zoo.Cat.create().visit(animals, null));
		assertEquals("parrot", Zoo.Parrot.create().visit(animals, null));
	}

	/**
	 * A nested OpenWorld root extended by nested and top-level messages of other files.
	 *
	 * <p>
	 * OpenWorld implies NoBinary, so only JSON and XML apply. The extension types are discovered
	 * through the generated service descriptor in <code>src/test/resources/META-INF/services</code>.
	 * XML is checked for the local type only: the generated XML reader of an OpenWorld root does not
	 * consult the registry of extension types (for top-level roots neither).
	 * </p>
	 */
	public void testOpenWorldCrossFile() throws IOException, XMLStreamException {
		Events events = Events.create()
			.addEvent(Events.TextEvent.create().setText("hi").setTimestamp(1))
			.addEvent(Patches.PatchEvent.create().setPatch("p").setTimestamp(2))
			.addEvent(CountEvent.create().setCount(3).setTimestamp(3));

		String expected = events.toString();
		assertEquals(
			"{\"events\":[[\"TextEvent\",{\"timestamp\":1,\"text\":\"hi\"}],"
				+ "[\"PatchEvent\",{\"timestamp\":2,\"patch\":\"p\"}],"
				+ "[\"CountEvent\",{\"timestamp\":3,\"count\":3}]]}",
			expected);

		// OpenWorld implies NoBinary, also for a file whose only extension is nested.
		assertFalse(Patches.PatchEvent.create() instanceof de.haumacher.msgbuf.binary.BinaryDataObject);
		assertFalse(CountEvent.create() instanceof de.haumacher.msgbuf.binary.BinaryDataObject);

		Events copy = Events.readEvents(json(expected));
		assertEquals(expected, copy.toString());
		assertTrue(copy.getEvents().get(0) instanceof Events.TextEvent);
		assertTrue(copy.getEvents().get(1) instanceof Patches.PatchEvent);
		assertTrue(copy.getEvents().get(2) instanceof CountEvent);

		// XML: the local type of the base file is read back.
		Events local = Events.create().addEvent(Events.TextEvent.create().setText("hi").setTimestamp(1));
		assertEquals(local.toString(), Events.readEvents(xmlReader(xml(local))).toString());

		Events.Event.Visitor<String, Void, RuntimeException> visitor = new Patches.PatchEvent.Visitor<>() {
			@Override
			public String visit(Events.TextEvent self, Void arg) {
				return "text";
			}

			@Override
			public String visit(Patches.PatchEvent self, Void arg) {
				return "patch";
			}

			@Override
			public String visitDefault(Events.Event self, Void arg) {
				return "default";
			}
		};
		assertEquals("text", copy.getEvents().get(0).visit(visitor, null));
		assertEquals("patch", copy.getEvents().get(1).visit(visitor, null));
		assertEquals("default", copy.getEvents().get(2).visit(visitor, null));
	}

	private static JsonReader json(String data) {
		return new JsonReader(new StringR(data));
	}

	private static byte[] binary(de.haumacher.msgbuf.binary.BinaryDataObject value) throws IOException {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		value.writeTo(new OctetDataWriter(buffer));
		return buffer.toByteArray();
	}

	private static OctetDataReader binaryReader(byte[] data) {
		return new OctetDataReader(new ByteArrayInputStream(data));
	}

	private static String xml(XmlSerializable value) throws XMLStreamException {
		StringWriter buffer = new StringWriter();
		value.writeTo(XMLOutputFactory.newDefaultFactory().createXMLStreamWriter(buffer));
		return buffer.toString();
	}

	private static XMLStreamReader xmlReader(String xml) throws XMLStreamException {
		return XMLInputFactory.newFactory().createXMLStreamReader(new StringReader(xml));
	}

}
