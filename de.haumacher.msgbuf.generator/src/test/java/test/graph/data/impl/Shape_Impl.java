package test.graph.data.impl;

/**
 * Implementation of {@link test.graph.data.Shape}.
 */
public abstract class Shape_Impl extends de.haumacher.msgbuf.graph.AbstractSharedGraphNode implements test.graph.data.Shape {

	private int _xCoordinate = 0;

	private int _yCoordinate = 0;

	/**
	 * Creates a {@link Shape_Impl} instance.
	 */
	public Shape_Impl() {
		super();
	}

	@Override
	public final int getXCoordinate() {
		return _xCoordinate;
	}

	@Override
	public test.graph.data.Shape setXCoordinate(int value) {
		internalSetXCoordinate(value);
		return this;
	}

	/** Internal setter for {@link #getXCoordinate()} without chain call utility. */
	protected final void internalSetXCoordinate(int value) {
		_listener.beforeSet(this, X_COORDINATE__PROP, value);
		_xCoordinate = value;
	}

	@Override
	public final int getYCoordinate() {
		return _yCoordinate;
	}

	@Override
	public test.graph.data.Shape setYCoordinate(int value) {
		internalSetYCoordinate(value);
		return this;
	}

	/** Internal setter for {@link #getYCoordinate()} without chain call utility. */
	protected final void internalSetYCoordinate(int value) {
		_listener.beforeSet(this, Y_COORDINATE__PROP, value);
		_yCoordinate = value;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			X_COORDINATE__PROP, 
			Y_COORDINATE__PROP));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case X_COORDINATE__PROP: return getXCoordinate();
			case Y_COORDINATE__PROP: return getYCoordinate();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case X_COORDINATE__PROP: internalSetXCoordinate((int) value); break;
			case Y_COORDINATE__PROP: internalSetYCoordinate((int) value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.graph.Scope scope, de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(scope, out);
		out.name(X_COORDINATE__PROP);
		out.value(getXCoordinate());
		out.name(Y_COORDINATE__PROP);
		out.value(getYCoordinate());
	}

	@Override
	public void writeFieldValue(de.haumacher.msgbuf.graph.Scope scope, de.haumacher.msgbuf.json.JsonWriter out, String field) throws java.io.IOException {
		switch (field) {
			case X_COORDINATE__PROP: {
				out.value(getXCoordinate());
				break;
			}
			case Y_COORDINATE__PROP: {
				out.value(getYCoordinate());
				break;
			}
			default: super.writeFieldValue(scope, out, field);
		}
	}

	@Override
	public void readField(de.haumacher.msgbuf.graph.Scope scope, de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case X_COORDINATE__PROP: setXCoordinate(in.nextInt()); break;
			case Y_COORDINATE__PROP: setYCoordinate(in.nextInt()); break;
			default: super.readField(scope, in, field);
		}
	}

	/** XML element name representing a {@link test.graph.data.Shape} type. */
	public static final String SHAPE__XML_ELEMENT = "shape";

	/** XML attribute or element name of a {@link #getXCoordinate} property. */
	private static final String X_COORDINATE__XML_ATTR = "x";

	/** XML attribute or element name of a {@link #getYCoordinate} property. */
	private static final String Y_COORDINATE__XML_ATTR = "y";

	@Override
	public final void writeContent(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		writeAttributes(out);
		writeElements(out);
	}

	/** Serializes all fields that are written as XML attributes. */
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		out.writeAttribute(X_COORDINATE__XML_ATTR, Integer.toString(getXCoordinate()));
		out.writeAttribute(Y_COORDINATE__XML_ATTR, Integer.toString(getYCoordinate()));
	}

	/** Serializes all fields that are written as XML elements. */
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		// No element fields.
	}

	/** Creates a new {@link test.graph.data.Shape} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Shape_Impl readShape_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		switch (in.getLocalName()) {
			case Circle_Impl.CIRCLE__XML_ELEMENT: {
				return test.graph.data.impl.Circle_Impl.readCircle_XmlContent(in);
			}

			case Rectangle_Impl.RECTANGLE__XML_ELEMENT: {
				return test.graph.data.impl.Rectangle_Impl.readRectangle_XmlContent(in);
			}

			case Group_Impl.GROUP__XML_ELEMENT: {
				return test.graph.data.impl.Group_Impl.readGroup_XmlContent(in);
			}

			case Car_Impl.CAR__XML_ELEMENT: {
				return test.graph.data.impl.Car_Impl.readCar_XmlContent(in);
			}

			default: {
				internalSkipUntilMatchingEndElement(in);
				return null;
			}
		}
	}

	/** Reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	protected final void readContentXml(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		for (int n = 0, cnt = in.getAttributeCount(); n < cnt; n++) {
			String name = in.getAttributeLocalName(n);
			String value = in.getAttributeValue(n);

			readFieldXmlAttribute(name, value);
		}
		while (true) {
			int event = in.nextTag();
			if (event == javax.xml.stream.XMLStreamConstants.END_ELEMENT) {
				break;
			}
			assert event == javax.xml.stream.XMLStreamConstants.START_ELEMENT;

			String localName = in.getLocalName();
			readFieldXmlElement(in, localName);
		}
	}

	/** Parses the given attribute value and assigns it to the field with the given name. */
	protected void readFieldXmlAttribute(String name, String value) {
		switch (name) {
			case X_COORDINATE__XML_ATTR: {
				setXCoordinate(Integer.parseInt(value));
				break;
			}
			case Y_COORDINATE__XML_ATTR: {
				setYCoordinate(Integer.parseInt(value));
				break;
			}
			default: {
				// Skip unknown attribute.
			}
		}
	}

	/** Reads the element under the cursor and assigns its contents to the field with the given name. */
	protected void readFieldXmlElement(javax.xml.stream.XMLStreamReader in, String localName) throws javax.xml.stream.XMLStreamException {
		switch (localName) {
			case X_COORDINATE__XML_ATTR: {
				setXCoordinate(Integer.parseInt(in.getElementText()));
				break;
			}
			case Y_COORDINATE__XML_ATTR: {
				setYCoordinate(Integer.parseInt(in.getElementText()));
				break;
			}
			default: {
				internalSkipUntilMatchingEndElement(in);
			}
		}
	}

	protected static final void internalSkipUntilMatchingEndElement(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		int level = 0;
		while (true) {
			switch (in.next()) {
				case javax.xml.stream.XMLStreamConstants.START_ELEMENT: level++; break;
				case javax.xml.stream.XMLStreamConstants.END_ELEMENT: if (level == 0) { return; } else { level--; break; }
			}
		}
	}

}
