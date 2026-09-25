/*
 * Copyright (c) 2023 Bernhard Haumacher et al. All Rights Reserved.
 */
package test.container;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Collections;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;

import junit.framework.TestCase;
import test.container.model.MyContainer;
import test.container.model.MyContent;

/**
 * Test case for <code>@Container</code> annotations.
 *
 * @author <a href="mailto:haui@haumacher.de">Bernhard Haumacher</a>
 */
@SuppressWarnings("javadoc")
public class TestContainer extends TestCase {
	
	public void testUpdateSingle() {
		MyContainer container = MyContainer.create().setName("container");
		MyContainer otherContainer = MyContainer.create().setName("other");
		
		MyContent c1 = MyContent.create().setName("content 1");
		
		container.setContent1(c1);
		assertEquals(container, c1.getContainer());
		
		MyContent c2 = MyContent.create().setName("content 2");
		container.setContent1(c2);
		assertNull(c1.getContainer());
		assertEquals(container, c2.getContainer());
		
		container.setContent2(c1);
		assertEquals(container, c1.getContainer());
		assertEquals(container, c2.getContainer());
		
		try {
			otherContainer.setContent1(c1);
			fail("Must not make object part of two different containers.");
		} catch (IllegalStateException ex) {
			assertEquals("Object may not be part of two different containers.", ex.getMessage());
		}
		
		// Check that nothing has changed.
		assertNull(otherContainer.getContent1());
		assertEquals(container, c1.getContainer());
		assertEquals(container, c2.getContainer());
	}
	
	public void testUpdateMulti() {
		MyContainer container = MyContainer.create().setName("container");
		MyContainer otherContainer = MyContainer.create().setName("other");
		
		MyContent c1 = MyContent.create().setName("content 1");
		
		container.addContentList(c1);
		assertEquals(container, c1.getContainer());
		
		MyContent c2 = MyContent.create().setName("content 2");
		container.addContentList(c2);
		assertEquals(container, c1.getContainer());
		assertEquals(container, c2.getContainer());
		
		container.setContentList(Arrays.asList(c1));
		assertEquals(container, c1.getContainer());
		assertNull(c2.getContainer());
		
		container.removeContentList(c1);
		assertNull(c1.getContainer());
		
		container.setContentList(Arrays.asList(c1, c2));
		assertEquals(container, c1.getContainer());
		assertEquals(container, c2.getContainer());
		
		container.getContentList().clear();
		assertNull(c1.getContainer());
		assertNull(c2.getContainer());
		
		container.addContentList(c1);
		try {
			container.addContentList(c1);
			fail("Must not make object part of two different containers.");
		} catch (IllegalStateException ex) {
			assertEquals("Object may not be part of two different containers.", ex.getMessage());
		}
		
		// Check that nothing has changed.
		assertEquals(container, c1.getContainer());
		assertEquals(Arrays.asList(c1), container.getContentList());
		
		try {
			otherContainer.addContentList(c1);
			fail("Must not make object part of two different containers.");
		} catch (IllegalStateException ex) {
			assertEquals("Object may not be part of two different containers.", ex.getMessage());
		}
		
		assertEquals(container, c1.getContainer());
		assertEquals(Arrays.asList(c1), container.getContentList());
		assertEquals(0, otherContainer.getContentList().size());
	}
	
	public void testUpdateMap() {
		MyContainer container = MyContainer.create().setName("container");
		MyContainer otherContainer = MyContainer.create().setName("other");
		
		MyContent c1 = MyContent.create().setName("content 1");
		
		container.putContentMap("c1", c1);
		assertEquals(container, c1.getContainer());
		
		MyContent c2 = MyContent.create().setName("content 2");
		container.putContentMap("c2", c2);
		assertEquals(container, c1.getContainer());
		assertEquals(container, c2.getContainer());
		
		container.setContentMap(Collections.singletonMap("c1", c1));
		assertEquals(container, c1.getContainer());
		assertNull(c2.getContainer());
		
		container.removeContentMap("c1");
		assertNull(c1.getContainer());
		
		container.getContentMap().putAll(Collections.singletonMap("c1", c1));
		container.getContentMap().putAll(Collections.singletonMap("c2", c2));
		assertEquals(container, c1.getContainer());
		assertEquals(container, c2.getContainer());
		
		container.getContentMap().clear();
		assertNull(c1.getContainer());
		assertNull(c2.getContainer());
		
		container.getContentMap().put("c1", c2);
		assertEquals(container, c2.getContainer());

		container.getContentMap().put("c1", c2);
		assertEquals(container, c2.getContainer());
		
		container.getContentMap().put("c1", c1);
		assertEquals(container, c1.getContainer());
		assertNull(c2.getContainer());
		
		try {
			container.getContentMap().put("c2", c1);
			fail("Must not make object part of two different containers.");
		} catch (IllegalStateException ex) {
			assertEquals("Object may not be part of two different containers.", ex.getMessage());
		}
		
		// Check that nothing has changed.
		assertEquals(container, c1.getContainer());
		assertEquals(Collections.singletonMap("c1", c1), container.getContentMap());
		
		try {
			otherContainer.putContentMap("c1", c1);
			fail("Must not make object part of two different containers.");
		} catch (IllegalStateException ex) {
			assertEquals("Object may not be part of two different containers.", ex.getMessage());
		}
		
		assertEquals(container, c1.getContainer());
		assertEquals(Collections.singletonMap("c1", c1), container.getContentMap());
		assertEquals(0, otherContainer.getContentMap().size());
	}
	
	public void testUpdateIdentical() {
		MyContent c = MyContent.create().setName("c");
		MyContainer container = MyContainer.create().setContent1(c);
		
		assertEquals(container, c.getContainer());
		assertEquals(c, container.getContent1());
		
		container.setContent1(c);
		
		assertEquals(container, c.getContainer());
		assertEquals(c, container.getContent1());
	}
	
	public void testUpdateRef() {
		MyContent c = MyContent.create().setName("c");
		MyContainer container = MyContainer.create().setOther(c).addOthers(c);
		
		assertEquals(c, container.getOther());
		assertNull(c.getContainer());
		
		container.setContent1(c);
		assertEquals(container, c.getContainer());
	}

	/**
	 * The container reference is derived and not written in XML format. Writing it made XML
	 * serialization recurse endlessly (issue #29).
	 */
	public void testXml() throws XMLStreamException {
		MyContainer container = MyContainer.create().setName("c");
		container.setContent1(MyContent.create().setName("x"));
		container.addContentList(MyContent.create().setName("y"));

		StringWriter buffer = new StringWriter();
		container.writeTo(XMLOutputFactory.newDefaultFactory().createXMLStreamWriter(buffer));
		String xml = buffer.toString();
		assertEquals("<my-container name=\"c\"><content-1 name=\"x\"></content-1>"
			+ "<content-list><my-content name=\"y\"></my-content></content-list><others></others></my-container>", xml);

		MyContainer copy = MyContainer.readMyContainer(XMLInputFactory.newFactory().createXMLStreamReader(new StringReader(xml)));
		assertEquals("x", copy.getContent1().getName());
		assertSame(copy, copy.getContent1().getContainer());
		assertSame(copy, copy.getContentList().get(0).getContainer());
	}

}
