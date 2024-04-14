/*
 * Copyright (c) 2024 Bernhard Haumacher et al. All Rights Reserved.
 */
package test.operations;

import junit.framework.TestCase;
import test.operations.data.Data;
import test.operations.data.ExtendedData;

/**
 * Test case for data classes with operation mix-ins.
 */
@SuppressWarnings("javadoc")
public class TestOperations extends TestCase {

	public void testOperations() {
		Data data = Data.create();
		data.inc();
		data.inc();
		assertEquals(2, data.getX());
		
		ExtendedData extended = ExtendedData.create();
		extended.inc();
		extended.inc();
		extended.addToY();
		extended.addToY();
		assertEquals(2, extended.getX());
		assertEquals(4, extended.getY());
	}
}
