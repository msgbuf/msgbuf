package test.onlyxml.data.impl;

/**
 * Implementation of {@link test.onlyxml.data.Optional}.
 */
public class Optional_Impl extends test.onlyxml.data.impl.Shape_Impl implements test.onlyxml.data.Optional {

	private boolean _hidden = false;

	private test.onlyxml.data.Shape _shape = null;

	/**
	 * Creates a {@link Optional_Impl} instance.
	 *
	 * @see test.onlyxml.data.Optional#create()
	 */
	public Optional_Impl() {
		super();
	}

	@Override
	public final boolean isHidden() {
		return _hidden;
	}

	@Override
	public test.onlyxml.data.Optional setHidden(boolean value) {
		internalSetHidden(value);
		return this;
	}

	/** Internal setter for {@link #isHidden()} without chain call utility. */
	protected final void internalSetHidden(boolean value) {
		_hidden = value;
	}

	@Override
	public final test.onlyxml.data.Shape getShape() {
		return _shape;
	}

	@Override
	public test.onlyxml.data.Optional setShape(test.onlyxml.data.Shape value) {
		internalSetShape(value);
		return this;
	}

	/** Internal setter for {@link #getShape()} without chain call utility. */
	protected final void internalSetShape(test.onlyxml.data.Shape value) {
		_shape = value;
	}

	@Override
	public final boolean hasShape() {
		return _shape != null;
	}

	@Override
	public test.onlyxml.data.Optional setXCoordinate(int value) {
		internalSetXCoordinate(value);
		return this;
	}

	@Override
	public test.onlyxml.data.Optional setYCoordinate(int value) {
		internalSetYCoordinate(value);
		return this;
	}

	/** XML element name representing a {@link test.onlyxml.data.Optional} type. */
	public static final String OPTIONAL__XML_ELEMENT = "optional";

	/** XML attribute or element name of a {@link #isHidden} property. */
	private static final String HIDDEN__XML_ATTR = "hidden";

	/** XML attribute or element name of a {@link #getShape} property. */
	private static final String SHAPE__XML_ATTR = "shape";

	@Override
	public String getXmlTagName() {
		return OPTIONAL__XML_ELEMENT;
	}

	/** Serializes all fields that are written as XML attributes. */
	@Override
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeAttributes(out);
		out.writeAttribute(HIDDEN__XML_ATTR, Boolean.toString(isHidden()));
	}

	/** Serializes all fields that are written as XML elements. */
	@Override
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeElements(out);
		if (hasShape()) {
			out.writeStartElement(SHAPE__XML_ATTR);
			getShape().writeTo(out);
			out.writeEndElement();
		}
	}

	/** Creates a new {@link test.onlyxml.data.Optional} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Optional_Impl readOptional_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		Optional_Impl result = new Optional_Impl();
		result.readContentXml(in);
		return result;
	}

	@Override
	protected void readFieldXmlAttribute(String name, String value) {
		switch (name) {
			case HIDDEN__XML_ATTR: {
				setHidden(Boolean.parseBoolean(value));
				break;
			}
			default: {
				super.readFieldXmlAttribute(name, value);
			}
		}
	}

	@Override
	protected void readFieldXmlElement(javax.xml.stream.XMLStreamReader in, String localName) throws javax.xml.stream.XMLStreamException {
		switch (localName) {
			case HIDDEN__XML_ATTR: {
				setHidden(Boolean.parseBoolean(in.getElementText()));
				break;
			}
			case test.onlyxml.data.impl.Circle_Impl.CIRCLE__XML_ELEMENT: {
				setShape(test.onlyxml.data.impl.Circle_Impl.readCircle_XmlContent(in));
				break;
			}
			case test.onlyxml.data.impl.Rectangle_Impl.RECTANGLE__XML_ELEMENT: {
				setShape(test.onlyxml.data.impl.Rectangle_Impl.readRectangle_XmlContent(in));
				break;
			}
			case test.onlyxml.data.impl.Group_Impl.GROUP__XML_ELEMENT: {
				setShape(test.onlyxml.data.impl.Group_Impl.readGroup_XmlContent(in));
				break;
			}
			case test.onlyxml.data.impl.Optional_Impl.OPTIONAL__XML_ELEMENT: {
				setShape(test.onlyxml.data.impl.Optional_Impl.readOptional_XmlContent(in));
				break;
			}
			case test.onlyxml.data.impl.Car_Impl.CAR__XML_ELEMENT: {
				setShape(test.onlyxml.data.impl.Car_Impl.readCar_XmlContent(in));
				break;
			}
			case SHAPE__XML_ATTR: {
				in.nextTag();
				setShape(test.onlyxml.data.impl.Shape_Impl.readShape_XmlContent(in));
				internalSkipUntilMatchingEndElement(in);
				break;
			}
			default: {
				super.readFieldXmlElement(in, localName);
			}
		}
	}

}
