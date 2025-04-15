package test.defaultvalue.data.impl;

/**
 * Implementation of {@link test.defaultvalue.data.A}.
 */
public class A_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.defaultvalue.data.A {

	private String _s = "Hello world!";

	private int _x = 13;

	private double _y = -4213e-2;

	private boolean _state = true;

	/**
	 * Creates a {@link A_Impl} instance.
	 *
	 * @see test.defaultvalue.data.A#create()
	 */
	public A_Impl() {
		super();
	}

	@Override
	public final String getS() {
		return _s;
	}

	@Override
	public test.defaultvalue.data.A setS(String value) {
		internalSetS(value);
		return this;
	}

	/** Internal setter for {@link #getS()} without chain call utility. */
	protected final void internalSetS(String value) {
		_listener.beforeSet(this, S__PROP, value);
		_s = value;
	}

	@Override
	public final int getX() {
		return _x;
	}

	@Override
	public test.defaultvalue.data.A setX(int value) {
		internalSetX(value);
		return this;
	}

	/** Internal setter for {@link #getX()} without chain call utility. */
	protected final void internalSetX(int value) {
		_listener.beforeSet(this, X__PROP, value);
		_x = value;
	}

	@Override
	public final double getY() {
		return _y;
	}

	@Override
	public test.defaultvalue.data.A setY(double value) {
		internalSetY(value);
		return this;
	}

	/** Internal setter for {@link #getY()} without chain call utility. */
	protected final void internalSetY(double value) {
		_listener.beforeSet(this, Y__PROP, value);
		_y = value;
	}

	@Override
	public final boolean isState() {
		return _state;
	}

	@Override
	public test.defaultvalue.data.A setState(boolean value) {
		internalSetState(value);
		return this;
	}

	/** Internal setter for {@link #isState()} without chain call utility. */
	protected final void internalSetState(boolean value) {
		_listener.beforeSet(this, STATE__PROP, value);
		_state = value;
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.defaultvalue.data.A registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.defaultvalue.data.A unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		internalUnregisterListener(l);
		return this;
	}

	protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
	}

	@Override
	public String jsonType() {
		return A__TYPE;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			S__PROP, 
			X__PROP, 
			Y__PROP, 
			STATE__PROP));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case S__PROP: return getS();
			case X__PROP: return getX();
			case Y__PROP: return getY();
			case STATE__PROP: return isState();
			default: return test.defaultvalue.data.A.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case S__PROP: internalSetS((String) value); break;
			case X__PROP: internalSetX((int) value); break;
			case Y__PROP: internalSetY((double) value); break;
			case STATE__PROP: internalSetState((boolean) value); break;
		}
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(S__PROP);
		out.value(getS());
		out.name(X__PROP);
		out.value(getX());
		out.name(Y__PROP);
		out.value(getY());
		out.name(STATE__PROP);
		out.value(isState());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case S__PROP: setS(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			case X__PROP: setX(in.nextInt()); break;
			case Y__PROP: setY(in.nextDouble()); break;
			case STATE__PROP: setState(in.nextBoolean()); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		out.beginObject();
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
		out.name(S__ID);
		out.value(getS());
		out.name(X__ID);
		out.value(getX());
		out.name(Y__ID);
		out.value(getY());
		out.name(STATE__ID);
		out.value(isState());
	}

	/** Helper for creating an object of type {@link test.defaultvalue.data.A} from a polymorphic composition. */
	public static test.defaultvalue.data.A readA_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.defaultvalue.data.impl.A_Impl result = new A_Impl();
		result.readContent(in);
		return result;
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
			case S__ID: setS(in.nextString()); break;
			case X__ID: setX(in.nextInt()); break;
			case Y__ID: setY(in.nextDouble()); break;
			case STATE__ID: setState(in.nextBoolean()); break;
			default: in.skipValue(); 
		}
	}

	/** XML element name representing a {@link test.defaultvalue.data.A} type. */
	public static final String A__XML_ELEMENT = "a";

	/** XML attribute or element name of a {@link #getS} property. */
	private static final String S__XML_ATTR = "s";

	/** XML attribute or element name of a {@link #getX} property. */
	private static final String X__XML_ATTR = "x";

	/** XML attribute or element name of a {@link #getY} property. */
	private static final String Y__XML_ATTR = "y";

	/** XML attribute or element name of a {@link #isState} property. */
	private static final String STATE__XML_ATTR = "state";

	@Override
	public String getXmlTagName() {
		return A__XML_ELEMENT;
	}

	@Override
	public final void writeContent(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		writeAttributes(out);
		writeElements(out);
	}

	/** Serializes all fields that are written as XML attributes. */
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		out.writeAttribute(S__XML_ATTR, getS());
		out.writeAttribute(X__XML_ATTR, Integer.toString(getX()));
		out.writeAttribute(Y__XML_ATTR, Double.toString(getY()));
		out.writeAttribute(STATE__XML_ATTR, Boolean.toString(isState()));
	}

	/** Serializes all fields that are written as XML elements. */
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		// No element fields.
	}

	/** Creates a new {@link test.defaultvalue.data.A} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static A_Impl readA_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		A_Impl result = new A_Impl();
		result.readContentXml(in);
		return result;
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
			case S__XML_ATTR: {
				setS(value);
				break;
			}
			case X__XML_ATTR: {
				setX(Integer.parseInt(value));
				break;
			}
			case Y__XML_ATTR: {
				setY(Double.parseDouble(value));
				break;
			}
			case STATE__XML_ATTR: {
				setState(Boolean.parseBoolean(value));
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
			case S__XML_ATTR: {
				setS(in.getElementText());
				break;
			}
			case X__XML_ATTR: {
				setX(Integer.parseInt(in.getElementText()));
				break;
			}
			case Y__XML_ATTR: {
				setY(Double.parseDouble(in.getElementText()));
				break;
			}
			case STATE__XML_ATTR: {
				setState(Boolean.parseBoolean(in.getElementText()));
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
