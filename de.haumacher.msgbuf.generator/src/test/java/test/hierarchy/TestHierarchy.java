/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package test.hierarchy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.function.Consumer;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import de.haumacher.msgbuf.binary.OctetDataReader;
import de.haumacher.msgbuf.binary.OctetDataWriter;
import de.haumacher.msgbuf.io.StringR;
import de.haumacher.msgbuf.json.JsonReader;
import junit.framework.TestCase;
import test.hierarchy.data.Car;
import test.hierarchy.data.Circle;
import test.hierarchy.data.Color;
import test.hierarchy.data.Group;
import test.hierarchy.data.Optional;
import test.hierarchy.data.Rectangle;
import test.hierarchy.data.Shape;

/**
 * Test case for polymorphic data class inheritance hierarchies.
 */
@SuppressWarnings("javadoc")
public class TestHierarchy extends TestCase {

	public void testPolymorphism() throws IOException {
		Shape shape = Group.create()
			.addShape(Circle.create().setRadius(5).setXCoordinate(1).setYCoordinate(2))
			.addShape(Rectangle.create().setWidth(10).setHeight(3).setXCoordinate(2).setYCoordinate(3))
			.addShape(
				Group.create()
					.addShape(Circle.create())
					.addShape(Circle.create())
					.addShape(Rectangle.create()));
		
		assertCopy(shape, this::checkCopyPolymorphic);
	}

	private void checkCopyPolymorphic(Shape copy) {
		assertTrue(copy instanceof Group);
		List<Shape> contentsCopy = ((Group) copy).getShapes();
		assertEquals(3, contentsCopy.size());
		assertTrue(contentsCopy.get(0) instanceof Circle);
	}

	public void testMonomorphicReferences() throws IOException {
		Car shape = Car.create()
			.setWheel1(Circle.create().setRadius(10).setXCoordinate(30).setYCoordinate(10))
			.setWheel2(Circle.create().setRadius(10).setXCoordinate(50).setYCoordinate(10))
			.setBody(Rectangle.create().setWidth(40).setHeight(20).setXCoordinate(20).setYCoordinate(5)); 

		assertCopy(shape, this::checkCopyMonomorphic);
	}

	private void checkCopyMonomorphic(Shape copy) {
		assertTrue(copy instanceof Car);
		assertEquals(30, ((Car) copy).getWheel1().getXCoordinate());
		assertEquals(50, ((Car) copy).getWheel2().getXCoordinate());
		assertEquals(20, ((Car) copy).getBody().getXCoordinate());
	}
	
	private void assertCopy(Shape shape, Consumer<Shape> check) throws IOException {
		check.accept(writeAndReadBackJson(shape));
		check.accept(writeAndReadBackBinary(shape));
	}

	private Shape writeAndReadBackJson(Shape shape) throws IOException {
		String data = shape.toString();
		return Shape.readShape(new JsonReader(new StringR(data)));
	}
	
	private Shape writeAndReadBackBinary(Shape shape) throws IOException {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		shape.writeTo(new OctetDataWriter(buffer));
		return Shape.readShape(new OctetDataReader(new ByteArrayInputStream(buffer.toByteArray())));
	}
	
	public void testXmlRead() throws XMLStreamException, FactoryConfigurationError {
		checkShape("<group x='10' y='20'><shapes><circle radius='50' color='blue'/><optional hidden='true'><shape><circle radius='100'/></shape></optional><car><wheel-1 radius='75'/></car></shapes></group>");
		checkShape("<group> <x>10</x> <y>20</y> <circle><radius>50</radius><color>blue</color></circle> <optional><hidden>true</hidden> <circle radius='100'/></optional> <car><wheel-1><radius>75</radius></wheel-1></car> </group>");
	}

	private void checkShape(String xml) throws XMLStreamException, FactoryConfigurationError {
		Shape shape = Shape.readShape(reader(xml));
		
		assertNotNull(shape);
		assertTrue(shape instanceof Group);
		Group group = (Group) shape;
		assertEquals(10, group.getXCoordinate());
		assertEquals(20, group.getYCoordinate());
		assertEquals(3, group.getShapes().size());
		
		Shape first = group.getShapes().get(0);
		assertNotNull(first);
		assertTrue(first.toString(), first instanceof Circle);
		assertEquals(50, ((Circle) first).getRadius());
		assertEquals(Color.BLUE, first.getColor());
		
		Shape second = group.getShapes().get(1);
		assertNotNull(second);
		assertTrue(second.toString(), second instanceof Optional);
		Optional optional = (Optional) second;
		assertTrue(optional.isHidden());
		Shape optionalShape = optional.getShape();
		assertNotNull(optionalShape);
		assertEquals(100, ((Circle) optionalShape).getRadius());
		
		Shape third = group.getShapes().get(2);
		assertNotNull(third);
		assertTrue(third.toString(), third instanceof Car);
		Car car = (Car) third;
		Circle wheel = car.getWheel1();
		assertNotNull(wheel);
		assertEquals(75, wheel.getRadius());
	}

	private XMLStreamReader reader(String xml) throws XMLStreamException, FactoryConfigurationError {
		return XMLInputFactory.newFactory().createXMLStreamReader(new StringReader(xml));
	}

}
