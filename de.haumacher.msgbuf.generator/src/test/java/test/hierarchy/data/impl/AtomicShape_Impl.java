package test.hierarchy.data.impl;

/**
 * Implementation of {@link test.hierarchy.data.AtomicShape}.
 */
public abstract class AtomicShape_Impl extends test.hierarchy.data.impl.Shape_Impl implements test.hierarchy.data.AtomicShape {

	/**
	 * Creates a {@link AtomicShape_Impl} instance.
	 */
	public AtomicShape_Impl() {
		super();
	}

	@Override
	public test.hierarchy.data.AtomicShape setXCoordinate(int value) {
		internalSetXCoordinate(value);
		return this;
	}

	@Override
	public test.hierarchy.data.AtomicShape setYCoordinate(int value) {
		internalSetYCoordinate(value);
		return this;
	}

	@Override
	public test.hierarchy.data.AtomicShape setColor(test.hierarchy.data.Color value) {
		internalSetColor(value);
		return this;
	}

	/** XML element name representing a {@link test.hierarchy.data.AtomicShape} type. */
	public static final String ATOMIC_SHAPE__XML_ELEMENT = "atomic-shape";

	/** Serializes all fields that are written as XML attributes. */
	@Override
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeAttributes(out);
	}

	/** Serializes all fields that are written as XML elements. */
	@Override
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeElements(out);
		// No element fields.
	}

	/** Creates a new {@link test.hierarchy.data.AtomicShape} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static AtomicShape_Impl readAtomicShape_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		switch (in.getLocalName()) {
			case Circle_Impl.CIRCLE__XML_ELEMENT: {
				return test.hierarchy.data.impl.Circle_Impl.readCircle_XmlContent(in);
			}

			case Rectangle_Impl.RECTANGLE__XML_ELEMENT: {
				return test.hierarchy.data.impl.Rectangle_Impl.readRectangle_XmlContent(in);
			}

			default: {
				internalSkipUntilMatchingEndElement(in);
				return null;
			}
		}
	}

	@Override
	protected void readFieldXmlAttribute(String name, String value) {
		switch (name) {
			default: {
				super.readFieldXmlAttribute(name, value);
			}
		}
	}

	@Override
	protected void readFieldXmlElement(javax.xml.stream.XMLStreamReader in, String localName) throws javax.xml.stream.XMLStreamException {
		switch (localName) {
			default: {
				super.readFieldXmlElement(in, localName);
			}
		}
	}

	@Override
	public final <R,A,E extends Throwable> R visit(test.hierarchy.data.Shape.Visitor<R,A,E> v, A arg) throws E {
		return visit((test.hierarchy.data.AtomicShape.Visitor<R,A,E>) v, arg);
	}

}
