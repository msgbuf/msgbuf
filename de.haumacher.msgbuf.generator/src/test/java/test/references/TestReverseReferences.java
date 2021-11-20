/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package test.references;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import de.haumacher.msgbuf.io.StringR;
import de.haumacher.msgbuf.json.JsonReader;
import de.haumacher.msgbuf.observer.Listener;
import de.haumacher.msgbuf.observer.Observable;
import junit.framework.TestCase;
import test.references.data.A;
import test.references.data.B;

/**
 * Test for automatic reverse references.
 */
@SuppressWarnings("javadoc")
public class TestReverseReferences extends TestCase {
	public void testReverse() throws IOException {
		B b1 = B.create().setName("b1");
		A a1 = A.create().setName("a1").setB(b1);
		assertEquals(1, b1.getInB().size());
		assertEquals(0, b1.getInBs().size());
		assertEquals("a1", b1.getInB().iterator().next().getName());
		
		A a2 = dumpLoad(a1, A::readA);
		assertEquals("a1", a2.getName());
		assertEquals("b1", a2.getB().getName());
		assertEquals(1, a2.getB().getInB().size());
		assertEquals(a2, a2.getB().getInB().iterator().next());
		
		a1.setB(null);
		assertEquals(0, b1.getInB().size());
		assertEquals(0, b1.getInBs().size());
	}

	private <T> T dumpLoad(T obj, Loader<T> constructor) throws IOException {
		return constructor.load(new JsonReader(new StringR(obj.toString())));
	}
	
	public void testReverseList() throws IOException {
		A a1 = A.create().setName("a1");

		B b1 = B.create().setName("b2");
		a1.setBs(Arrays.asList(b1));
		assertEquals(0, b1.getInB().size());
		assertEquals(1, b1.getInBs().size());
		assertEquals("a1", b1.getInBs().iterator().next().getName());
		
		A a2 = dumpLoad(a1, A::readA);
		B b2 = a2.getBs().iterator().next();
		assertEquals(0, b2.getInB().size());
		assertEquals(1, b2.getInBs().size());
		assertEquals("a1", b2.getInBs().iterator().next().getName());
		
		a1.setBs(Collections.emptyList());
		assertEquals(0, b1.getInB().size());
		assertEquals(0, b1.getInBs().size());
		
		B b3 = B.create().setName("b3");
		a1.addBs(b3);
		assertEquals(0, b3.getInB().size());
		assertEquals(1, b3.getInBs().size());
		assertEquals("a1", b3.getInBs().iterator().next().getName());
		
		a1.removeBs(b3);
		assertEquals(0, b3.getInB().size());
		assertEquals(0, b3.getInBs().size());
	}
	
	public void testSetListener() {
		Map<String, Object> properties = new HashMap<>();
		A a1 = A.create().registerListener((self, prop, value) -> properties.put(prop, value)).setB(B.create()).setName("a1");
		assertEquals(a1.getB(), properties.get(A.B));
		assertEquals("a1", properties.get(A.NAME));
	}
	
	public void testAddListener() {
		Map<String, Object> properties = new HashMap<>();
		Listener l = new Listener() {
			@Override
			public void beforeSet(Observable obj, String property, Object value) {
				if (value instanceof Observable) {
					((Observable) value).registerListener(this);
				}
				
				properties.put(property, value);
			}
			
			@Override
			public void beforeAdd(Observable obj, String property, int index, Object element) {
				if (element instanceof Observable) {
					((Observable) element).registerListener(this);
				}
				properties.put(property, element);
			}
		};
		A a1 = A.create().registerListener(l).setName("a1").addBs(B.create().setName("b1")).setChildren(Arrays.asList(A.create().setName("a2")));
		assertEquals("a1", properties.get(A.NAME));
		assertEquals(a1.getBs().get(0), properties.get(A.BS));
		assertEquals(a1.getChildren().get(0), properties.get(A.CHILDREN));
		
		a1.getBs().get(0).setName("b2");
		assertEquals("b2", properties.get(B.NAME));
	}
}
