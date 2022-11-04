package test.onlyxml.data;

/**
 * A group of shapes.
 */
class Group_Impl extends Shape_Impl implements Group {

	private final java.util.List<Shape> _shapes = new java.util.ArrayList<>();

	/**
	 * Creates a {@link Group_Impl} instance.
	 *
	 * @see Group#create()
	 */
	protected Group_Impl() {
		super();
	}

	@Override
	public final java.util.List<Shape> getShapes() {
		return _shapes;
	}

	@Override
	public Group setShapes(java.util.List<? extends Shape> value) {
		internalSetShapes(value);
		return this;
	}

	/** Internal setter for {@link #getShapes()} without chain call utility. */
	protected final void internalSetShapes(java.util.List<? extends Shape> value) {
		if (value == null) throw new IllegalArgumentException("Property 'shapes' cannot be null.");
		_shapes.clear();
		_shapes.addAll(value);
	}

	@Override
	public Group addShape(Shape value) {
		internalAddShape(value);
		return this;
	}

	/** Implementation of {@link #addShape(Shape)} without chain call utility. */
	protected final void internalAddShape(Shape value) {
		_shapes.add(value);
	}

	@Override
	public final void removeShape(Shape value) {
		_shapes.remove(value);
	}

	@Override
	public Group setXCoordinate(int value) {
		internalSetXCoordinate(value);
		return this;
	}

	@Override
	public Group setYCoordinate(int value) {
		internalSetYCoordinate(value);
		return this;
	}

	/** XML element name representing a {@link Group} type. */
	public static final String GROUP__XML_ELEMENT = "group";

	/** XML attribute or element name of a {@link #getShapes} property. */
	private static final String SHAPES__XML_ATTR = "shapes";

	@Override
	public String getXmlTagName() {
		return GROUP__XML_ELEMENT;
	}

	/** Serializes all fields that are written as XML attributes. */
	@Override
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeAttributes(out);
	}

	/** Serializes all fields that are written as XML elements. */
	@Override
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeElements(out);
		out.writeStartElement(SHAPES__XML_ATTR);
		for (test.onlyxml.data.Shape element : getShapes()) {
			element.writeTo(out);
		}
		out.writeEndElement();
	}

	/** Creates a new {@link Group} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Group_Impl readGroup_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		Group_Impl result = new Group_Impl();
		result.readContentXml(in);
		return result;
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
			case test.onlyxml.data.Circle_Impl.CIRCLE__XML_ELEMENT: {
				addShape(test.onlyxml.data.Circle_Impl.readCircle_XmlContent(in));
				break;
			}
			case test.onlyxml.data.Rectangle_Impl.RECTANGLE__XML_ELEMENT: {
				addShape(test.onlyxml.data.Rectangle_Impl.readRectangle_XmlContent(in));
				break;
			}
			case test.onlyxml.data.Group_Impl.GROUP__XML_ELEMENT: {
				addShape(test.onlyxml.data.Group_Impl.readGroup_XmlContent(in));
				break;
			}
			case test.onlyxml.data.Optional_Impl.OPTIONAL__XML_ELEMENT: {
				addShape(test.onlyxml.data.Optional_Impl.readOptional_XmlContent(in));
				break;
			}
			case test.onlyxml.data.Car_Impl.CAR__XML_ELEMENT: {
				addShape(test.onlyxml.data.Car_Impl.readCar_XmlContent(in));
				break;
			}
			case SHAPES__XML_ATTR: {
				internalReadShapesListXml(in);
				break;
			}
			default: {
				super.readFieldXmlElement(in, localName);
			}
		}
	}

	private void internalReadShapesListXml(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		while (true) {
			int event = in.nextTag();
			if (event == javax.xml.stream.XMLStreamConstants.END_ELEMENT) {
				break;
			}

			addShape(test.onlyxml.data.Shape_Impl.readShape_XmlContent(in));
		}
	}

}
