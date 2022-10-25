package test.onlyxml.data;

/**
 * A shape that can be dynamically hidden.
 */
class Optional_Impl extends Shape_Impl implements Optional {

	private boolean _hidden = false;

	private Shape _shape = null;

	/**
	 * Creates a {@link Optional_Impl} instance.
	 *
	 * @see Optional#create()
	 */
	protected Optional_Impl() {
		super();
	}

	@Override
	public final boolean isHidden() {
		return _hidden;
	}

	@Override
	public Optional setHidden(boolean value) {
		internalSetHidden(value);
		return this;
	}

	/** Internal setter for {@link #isHidden()} without chain call utility. */
	protected final void internalSetHidden(boolean value) {
		_hidden = value;
	}

	@Override
	public final Shape getShape() {
		return _shape;
	}

	@Override
	public Optional setShape(Shape value) {
		internalSetShape(value);
		return this;
	}

	/** Internal setter for {@link #getShape()} without chain call utility. */
	protected final void internalSetShape(Shape value) {
		_shape = value;
	}

	@Override
	public final boolean hasShape() {
		return _shape != null;
	}

	@Override
	public Optional setXCoordinate(int value) {
		internalSetXCoordinate(value);
		return this;
	}

	@Override
	public Optional setYCoordinate(int value) {
		internalSetYCoordinate(value);
		return this;
	}

	/** XML element name representing a {@link Optional} type. */
	public static final String OPTIONAL__XML_ELEMENT = "optional";

	/** XML attribute or element name of a {@link #isHidden} property. */
	private static final String HIDDEN__XML_ATTR = "hidden";

	/** XML attribute or element name of a {@link #getShape} property. */
	private static final String SHAPE__XML_ATTR = "shape";

	/** Creates a new {@link Optional} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
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
			case test.onlyxml.data.Circle_Impl.CIRCLE__XML_ELEMENT: {
				setShape(test.onlyxml.data.Circle_Impl.readCircle_XmlContent(in));
				break;
			}
			case test.onlyxml.data.Rectangle_Impl.RECTANGLE__XML_ELEMENT: {
				setShape(test.onlyxml.data.Rectangle_Impl.readRectangle_XmlContent(in));
				break;
			}
			case test.onlyxml.data.Group_Impl.GROUP__XML_ELEMENT: {
				setShape(test.onlyxml.data.Group_Impl.readGroup_XmlContent(in));
				break;
			}
			case test.onlyxml.data.Optional_Impl.OPTIONAL__XML_ELEMENT: {
				setShape(test.onlyxml.data.Optional_Impl.readOptional_XmlContent(in));
				break;
			}
			case test.onlyxml.data.Car_Impl.CAR__XML_ELEMENT: {
				setShape(test.onlyxml.data.Car_Impl.readCar_XmlContent(in));
				break;
			}
			case SHAPE__XML_ATTR: {
				in.nextTag();
				setShape(test.onlyxml.data.Shape_Impl.readShape_XmlContent(in));
				internalSkipUntilMatchingEndElement(in);
				break;
			}
			default: {
				super.readFieldXmlElement(in, localName);
			}
		}
	}

}
