/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package test.onlyxml;

import java.io.StringReader;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import junit.framework.TestCase;
import test.onlyxml.data.Car;
import test.onlyxml.data.Circle;
import test.onlyxml.data.Group;
import test.onlyxml.data.Optional;
import test.onlyxml.data.Shape;

/**
 * Test case for polymorphic data class inheritance hierarchies.
 */
@SuppressWarnings("javadoc")
public class TestOnlyXml extends TestCase {
	
	public void testXmlRead() throws XMLStreamException, FactoryConfigurationError {
		checkShape("<group x='10' y='20'><shapes><circle radius='50'/><optional hidden='true'><shape><circle radius='100'/></shape></optional><car><wheel-1 radius='75'/></car></shapes></group>");
		checkShape("<group> <x>10</x> <y>20</y> <circle><radius>50</radius></circle> <optional><hidden>true</hidden> <circle radius='100'/></optional> <car><wheel-1><radius>75</radius></wheel-1></car> </group>");
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
