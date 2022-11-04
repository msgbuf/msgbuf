/*
 * Copyright (c) 2022 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.xml;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import de.haumacher.msgbuf.data.DataObject;

/**
 * Optional interface implemented by {@link DataObject}s that support XML serialization.
 */
public interface XmlSerializable {

	/**
	 * Serializes this object to XML.
	 *
	 * @param out
	 *        The {@link XMLStreamWriter} to write this object to.
	 * @throws XMLStreamException
	 *         If writing fails.
	 */
	default void writeTo(XMLStreamWriter out) throws XMLStreamException {
		out.writeStartElement(getXmlTagName());
		writeContent(out);
		out.writeEndElement();
	}
	
	/**
	 * Writes the contents of this object (attributes and sub-elements) to XML.
	 *
	 * @param out
	 *        The {@link XMLStreamWriter} to write this object to.
	 * @throws XMLStreamException
	 *         If writing fails.
	 */
	void writeContent(XMLStreamWriter out) throws XMLStreamException;
	
	/**
	 * The tag name used to {@link #writeTo(XMLStreamWriter) write this object} as top-level element in an XML document.
	 */
	String getXmlTagName();
	
}
