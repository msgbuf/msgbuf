package test.novisitexceptions.impl;

/**
 * Implementation of {@link test.novisitexceptions.AtomicShape}.
 */
public abstract class AtomicShape_Impl extends test.novisitexceptions.impl.Shape_Impl implements test.novisitexceptions.AtomicShape {

	/**
	 * Creates a {@link AtomicShape_Impl} instance.
	 */
	public AtomicShape_Impl() {
		super();
	}

	@Override
	public test.novisitexceptions.AtomicShape setXCoordinate(int value) {
		internalSetXCoordinate(value);
		return this;
	}

	@Override
	public test.novisitexceptions.AtomicShape setYCoordinate(int value) {
		internalSetYCoordinate(value);
		return this;
	}

	/** XML element name representing a {@link test.novisitexceptions.AtomicShape} type. */
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

	/** Creates a new {@link test.novisitexceptions.AtomicShape} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static AtomicShape_Impl readAtomicShape_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		switch (in.getLocalName()) {
			case Circle_Impl.CIRCLE__XML_ELEMENT: {
				return test.novisitexceptions.impl.Circle_Impl.readCircle_XmlContent(in);
			}

			case Rectangle_Impl.RECTANGLE__XML_ELEMENT: {
				return test.novisitexceptions.impl.Rectangle_Impl.readRectangle_XmlContent(in);
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
	public final <R,A> R visit(test.novisitexceptions.Shape.Visitor<R,A> v, A arg) {
		return visit((test.novisitexceptions.AtomicShape.Visitor<R,A>) v, arg);
	}

}
