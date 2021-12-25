/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package test.hierarchy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

import de.haumacher.msgbuf.binary.OctetDataReader;
import de.haumacher.msgbuf.binary.OctetDataWriter;
import de.haumacher.msgbuf.io.StringR;
import de.haumacher.msgbuf.json.JsonReader;
import junit.framework.TestCase;
import test.hierarchy.data.Car;
import test.hierarchy.data.Circle;
import test.hierarchy.data.Group;
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

}
