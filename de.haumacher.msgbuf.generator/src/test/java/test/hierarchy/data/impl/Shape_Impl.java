package test.hierarchy.data.impl;

/**
 * Implementation of {@link test.hierarchy.data.Shape}.
 */
public abstract class Shape_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.hierarchy.data.Shape {

	private int _xCoordinate = 0;

	private int _yCoordinate = 0;

	private test.hierarchy.data.Color _color = test.hierarchy.data.Color.RED;

	/**
	 * Creates a {@link Shape_Impl} instance.
	 */
	public Shape_Impl() {
		super();
	}

	/** The type code of this instance. */
	public abstract TypeKind kind();

	@Override
	public final int getXCoordinate() {
		return _xCoordinate;
	}

	@Override
	public test.hierarchy.data.Shape setXCoordinate(int value) {
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
	public test.hierarchy.data.Shape setYCoordinate(int value) {
		internalSetYCoordinate(value);
		return this;
	}

	/** Internal setter for {@link #getYCoordinate()} without chain call utility. */
	protected final void internalSetYCoordinate(int value) {
		_listener.beforeSet(this, Y_COORDINATE__PROP, value);
		_yCoordinate = value;
	}

	@Override
	public final test.hierarchy.data.Color getColor() {
		return _color;
	}

	@Override
	public test.hierarchy.data.Shape setColor(test.hierarchy.data.Color value) {
		internalSetColor(value);
		return this;
	}

	/** Internal setter for {@link #getColor()} without chain call utility. */
	protected final void internalSetColor(test.hierarchy.data.Color value) {
		if (value == null) throw new IllegalArgumentException("Property 'color' cannot be null.");
		_listener.beforeSet(this, COLOR__PROP, value);
		_color = value;
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.hierarchy.data.Shape registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.hierarchy.data.Shape unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		internalUnregisterListener(l);
		return this;
	}

	protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			X_COORDINATE__PROP, 
			Y_COORDINATE__PROP, 
			COLOR__PROP));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case X_COORDINATE__PROP: return getXCoordinate();
			case Y_COORDINATE__PROP: return getYCoordinate();
			case COLOR__PROP: return getColor();
			default: return test.hierarchy.data.Shape.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case X_COORDINATE__PROP: internalSetXCoordinate((int) value); break;
			case Y_COORDINATE__PROP: internalSetYCoordinate((int) value); break;
			case COLOR__PROP: internalSetColor((test.hierarchy.data.Color) value); break;
		}
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		out.beginArray();
		out.value(jsonType());
		writeContent(out);
		out.endArray();
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(X_COORDINATE__PROP);
		out.value(getXCoordinate());
		out.name(Y_COORDINATE__PROP);
		out.value(getYCoordinate());
		out.name(COLOR__PROP);
		getColor().writeTo(out);
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case X_COORDINATE__PROP: setXCoordinate(in.nextInt()); break;
			case Y_COORDINATE__PROP: setYCoordinate(in.nextInt()); break;
			case COLOR__PROP: setColor(test.hierarchy.data.Color.readColor(in)); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		out.beginObject();
		out.name(0);
		out.value(typeId());
		writeFields(out);
		out.endObject();
	}

	/**
	 * Serializes all fields of this instance to the given binary output.
	 *
	 * @param out
	 *        The binary output to write to.
	 * @throws java.io.IOException If writing fails.
	 */
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		out.name(X_COORDINATE__ID);
		out.value(getXCoordinate());
		out.name(Y_COORDINATE__ID);
		out.value(getYCoordinate());
		out.name(COLOR__ID);
		getColor().writeTo(out);
	}

	/** Helper for reading all fields of this instance. */
	protected final void readContent(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		while (in.hasNext()) {
			int field = in.nextName();
			readField(in, field);
		}
	}

	/** Consumes the value for the field with the given ID and assigns its value. */
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case X_COORDINATE__ID: setXCoordinate(in.nextInt()); break;
			case Y_COORDINATE__ID: setYCoordinate(in.nextInt()); break;
			case COLOR__ID: setColor(test.hierarchy.data.Color.readColor(in)); break;
			default: in.skipValue(); 
		}
	}

	/** XML element name representing a {@link test.hierarchy.data.Shape} type. */
	public static final String SHAPE__XML_ELEMENT = "shape";

	/** XML attribute or element name of a {@link #getXCoordinate} property. */
	private static final String X_COORDINATE__XML_ATTR = "x";

	/** XML attribute or element name of a {@link #getYCoordinate} property. */
	private static final String Y_COORDINATE__XML_ATTR = "y";

	/** XML attribute or element name of a {@link #getColor} property. */
	private static final String COLOR__XML_ATTR = "color";

	@Override
	public final void writeContent(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		writeAttributes(out);
		writeElements(out);
	}

	/** Serializes all fields that are written as XML attributes. */
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		out.writeAttribute(X_COORDINATE__XML_ATTR, Integer.toString(getXCoordinate()));
		out.writeAttribute(Y_COORDINATE__XML_ATTR, Integer.toString(getYCoordinate()));
		out.writeAttribute(COLOR__XML_ATTR, getColor().protocolName());
	}

	/** Serializes all fields that are written as XML elements. */
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		// No element fields.
	}

	/** Creates a new {@link test.hierarchy.data.Shape} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Shape_Impl readShape_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		switch (in.getLocalName()) {
			case Circle_Impl.CIRCLE__XML_ELEMENT: {
				return test.hierarchy.data.impl.Circle_Impl.readCircle_XmlContent(in);
			}

			case Rectangle_Impl.RECTANGLE__XML_ELEMENT: {
				return test.hierarchy.data.impl.Rectangle_Impl.readRectangle_XmlContent(in);
			}

			case Group_Impl.GROUP__XML_ELEMENT: {
				return test.hierarchy.data.impl.Group_Impl.readGroup_XmlContent(in);
			}

			case Optional_Impl.OPTIONAL__XML_ELEMENT: {
				return test.hierarchy.data.impl.Optional_Impl.readOptional_XmlContent(in);
			}

			case Car_Impl.CAR__XML_ELEMENT: {
				return test.hierarchy.data.impl.Car_Impl.readCar_XmlContent(in);
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
			case COLOR__XML_ATTR: {
				setColor(test.hierarchy.data.Color.valueOfProtocol(value));
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
			case COLOR__XML_ATTR: {
				setColor(test.hierarchy.data.Color.valueOfProtocol(in.getElementText()));
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
