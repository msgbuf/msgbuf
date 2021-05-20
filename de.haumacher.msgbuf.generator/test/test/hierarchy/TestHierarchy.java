/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package test.hierarchy;

import static test.hierarchy.data.Circle.*;
import static test.hierarchy.data.Group.*;
import static test.hierarchy.data.Rectangle.*;

import java.io.IOException;
import java.util.List;

import de.haumacher.msgbuf.io.StringR;
import de.haumacher.msgbuf.json.JsonReader;
import junit.framework.TestCase;
import test.hierarchy.data.Circle;
import test.hierarchy.data.Group;
import test.hierarchy.data.Shape;

/**
 * Test case for polymorphic data class inheritance hierarchies.
 */
@SuppressWarnings("javadoc")
public class TestHierarchy extends TestCase {

	public void testPolymorphism() throws IOException {
		Shape shape = group()
			.addShape(circle().setRadius(5).setXCoordinate(1).setYCoordinate(2))
			.addShape(rectangle().setWidth(10).setHeight(3).setXCoordinate(2).setYCoordinate(3))
			.addShape(
				group()
					.addShape(circle())
					.addShape(circle())
					.addShape(rectangle()));
		
		String data = shape.toString();
		Shape copy = Shape.readShape(new JsonReader(new StringR(data)));
		
		assertTrue(copy instanceof Group);
		List<Shape> contentsCopy = ((Group) copy).getShapes();
		assertEquals(3, contentsCopy.size());
		assertTrue(contentsCopy.get(0) instanceof Circle);
	}
	
}
