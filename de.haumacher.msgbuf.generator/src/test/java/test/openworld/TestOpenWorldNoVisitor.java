/*
 * Copyright (c) 2026 Bernhard Haumacher et al. All Rights Reserved.
 */
package test.openworld;

import java.io.IOException;

import de.haumacher.msgbuf.io.StringR;
import de.haumacher.msgbuf.json.JsonReader;
import junit.framework.TestCase;
import test.openworld.novisitor.base.Shape;
import test.openworld.novisitor.ext.Square;

/**
 * Test case for an OpenWorld hierarchy without visitors (issue #39).
 */
@SuppressWarnings("javadoc")
public class TestOpenWorldNoVisitor extends TestCase {

	public void testExtensionRoundTrip() throws IOException {
		Square square = Square.create().setSide(3);
		square.setName("s");
		String json = square.toString();
		assertEquals("[\"Square\",{\"name\":\"s\",\"side\":3}]", json);
		Shape copy = Shape.readShape(new JsonReader(new StringR(json)));
		assertTrue(copy instanceof Square);
		assertEquals(json, copy.toString());
	}

	public void testNoVisitor() {
		for (Class<?> type : Square.class.getClasses()) {
			assertFalse("Unexpected " + type.getName(), type.getSimpleName().equals("Visitor"));
		}
	}

}
