package test.notypekind.impl;

/**
 * A {@link Shape} that has no sub-shapes.
 */
public abstract class AtomicShape_Impl extends test.notypekind.impl.Shape_Impl implements test.notypekind.AtomicShape {

	/**
	 * Creates a {@link AtomicShape_Impl} instance.
	 */
	public AtomicShape_Impl() {
		super();
	}

	@Override
	public test.notypekind.AtomicShape setXCoordinate(int value) {
		internalSetXCoordinate(value);
		return this;
	}

	@Override
	public test.notypekind.AtomicShape setYCoordinate(int value) {
		internalSetYCoordinate(value);
		return this;
	}

	/** XML element name representing a {@link test.notypekind.AtomicShape} type. */
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

	/** Creates a new {@link test.notypekind.AtomicShape} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static AtomicShape_Impl readAtomicShape_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		switch (in.getLocalName()) {
			case Circle_Impl.CIRCLE__XML_ELEMENT: {
				return test.notypekind.impl.Circle_Impl.readCircle_XmlContent(in);
			}

			case Rectangle_Impl.RECTANGLE__XML_ELEMENT: {
				return test.notypekind.impl.Rectangle_Impl.readRectangle_XmlContent(in);
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
	public final <R,A,E extends Throwable> R visit(test.notypekind.Shape.Visitor<R,A,E> v, A arg) throws E {
		return visit((test.notypekind.AtomicShape.Visitor<R,A,E>) v, arg);
	}

}
