/*
 * Copyright (c) 2024 Bernhard Haumacher et al. All Rights Reserved.
 */
package test.embedded;

import java.io.StringReader;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import junit.framework.TestCase;
import test.embedded.data.Container;
import test.embedded.data.EmbeddingContainer;
import test.embedded.data.EmbeddingSingleContainer;
import test.embedded.data.SingleContainer;

/**
 * Test case for embedding references in XML serialization.
 */
@SuppressWarnings("javadoc")
public class TestEmbedded extends TestCase {

	public void testRead() throws XMLStreamException, FactoryConfigurationError {
		Container container = Container.readContainer(reader("<container><contents><a/><b/></contents></container>"));
		assertEquals(2, container.getContents().size());
	}

	public void testReadEmbedding() throws XMLStreamException, FactoryConfigurationError {
		EmbeddingContainer container1 = EmbeddingContainer.readEmbeddingContainer(reader("<embedding-container><contents><a/><b/></contents></embedding-container>"));
		EmbeddingContainer container2 = EmbeddingContainer.readEmbeddingContainer(reader("<embedding-container><a/><b/></embedding-container>"));
		assertEquals(2, container1.getContents().size());
		assertEquals(2, container2.getContents().size());
	}
	
	public void testReadSingle() throws XMLStreamException, FactoryConfigurationError {
		SingleContainer container = SingleContainer.readSingleContainer(reader("<single-container><contents><a/></contents></single-container>"));
		assertNotNull(container.getContents());
	}
	
	public void testReadSingleEmbedding() throws XMLStreamException, FactoryConfigurationError {
		EmbeddingSingleContainer container1 = EmbeddingSingleContainer.readEmbeddingSingleContainer(reader("<embedding-single-container><contents><a/></contents></embedding-single-container>"));
		EmbeddingSingleContainer container2 = EmbeddingSingleContainer.readEmbeddingSingleContainer(reader("<embedding-single-container><a/></embedding-single-container>"));
		assertNotNull(container1.getContents());
		assertNotNull(container2.getContents());
	}
	

	private XMLStreamReader reader(String xml) throws XMLStreamException, FactoryConfigurationError {
		return XMLInputFactory.newFactory().createXMLStreamReader(new StringReader(xml));
	}
}
