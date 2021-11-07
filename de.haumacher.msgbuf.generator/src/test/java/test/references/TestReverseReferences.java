/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package test.references;

import java.util.Arrays;
import java.util.Collections;

import junit.framework.TestCase;
import test.references.data.A;
import test.references.data.B;

/**
 * Test for automatic reverse references.
 */
@SuppressWarnings("javadoc")
public class TestReverseReferences extends TestCase {
	public void testReverse() {
		B b1 = B.create().setName("b1");
		A a1 = A.create().setName("a1").setB(b1);
		assertEquals(1, b1.getInB().size());
		assertEquals(0, b1.getInBs().size());
		assertEquals("a1", b1.getInB().iterator().next().getName());
		
		a1.setB(null);
		assertEquals(0, b1.getInB().size());
		assertEquals(0, b1.getInBs().size());
	}
	
	public void testReverseList() {
		A a1 = A.create().setName("a1");

		B b2 = B.create().setName("b2");
		a1.setBs(Arrays.asList(b2));
		assertEquals(0, b2.getInB().size());
		assertEquals(1, b2.getInBs().size());
		assertEquals("a1", b2.getInBs().iterator().next().getName());
		
		a1.setBs(Collections.emptyList());
		assertEquals(0, b2.getInB().size());
		assertEquals(0, b2.getInBs().size());
		
		B b3 = B.create().setName("b3");
		a1.addBs(b3);
		assertEquals(0, b3.getInB().size());
		assertEquals(1, b3.getInBs().size());
		assertEquals("a1", b3.getInBs().iterator().next().getName());
		
		a1.removeBs(b3);
		assertEquals(0, b3.getInB().size());
		assertEquals(0, b3.getInBs().size());
	}
}
