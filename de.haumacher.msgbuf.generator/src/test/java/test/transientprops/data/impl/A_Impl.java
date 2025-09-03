package test.transientprops.data.impl;

/**
 * Implementation of {@link test.transientprops.data.A}.
 */
public class A_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.transientprops.data.A {

	private String _x1 = "";

	private transient String _x2 = "";

	/**
	 * Creates a {@link A_Impl} instance.
	 *
	 * @see test.transientprops.data.A#create()
	 */
	public A_Impl() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.A;
	}

	@Override
	public final String getX1() {
		return _x1;
	}

	@Override
	public test.transientprops.data.A setX1(String value) {
		internalSetX1(value);
		return this;
	}

	/** Internal setter for {@link #getX1()} without chain call utility. */
	protected final void internalSetX1(String value) {
		_listener.beforeSet(this, X_1__PROP, value);
		_x1 = value;
		_listener.afterChanged(this, X_1__PROP);
	}

	@Override
	public final String getX2() {
		return _x2;
	}

	@Override
	public test.transientprops.data.A setX2(String value) {
		internalSetX2(value);
		return this;
	}

	/** Internal setter for {@link #getX2()} without chain call utility. */
	protected final void internalSetX2(String value) {
		_listener.beforeSet(this, X_2__PROP, value);
		_x2 = value;
		_listener.afterChanged(this, X_2__PROP);
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.transientprops.data.A registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.transientprops.data.A unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
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

	static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			X_1__PROP, 
			X_2__PROP);
		PROPERTIES = java.util.Collections.unmodifiableList(local);
	}

	static final java.util.Set<String> TRANSIENT_PROPERTIES;
	static {
		java.util.HashSet<String> tmp = new java.util.HashSet<>();
		tmp.addAll(java.util.Arrays.asList(
				X_2__PROP));
		TRANSIENT_PROPERTIES = java.util.Collections.unmodifiableSet(tmp);
	}

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public java.util.Set<String> transientProperties() {
		return TRANSIENT_PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case X_1__PROP: return getX1();
			case X_2__PROP: return getX2();
			default: return test.transientprops.data.A.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case X_1__PROP: internalSetX1((String) value); break;
			case X_2__PROP: internalSetX2((String) value); break;
		}
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(X_1__PROP);
		out.value(getX1());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case X_1__PROP: setX1(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
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
		out.name(X_1__ID);
		out.value(getX1());
	}

	/** Helper for creating an object of type {@link test.transientprops.data.A} from a polymorphic composition. */
	public static test.transientprops.data.A readA_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.transientprops.data.impl.A_Impl result = new A_Impl();
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
			case X_1__ID: setX1(in.nextString()); break;
			default: in.skipValue(); 
		}
	}

	/** XML element name representing a {@link test.transientprops.data.A} type. */
	public static final String A__XML_ELEMENT = "a";

	/** XML attribute or element name of a {@link #getX1} property. */
	private static final String X_1__XML_ATTR = "x-1";

	/** XML attribute or element name of a {@link #getX2} property. */
	private static final String X_2__XML_ATTR = "x-2";

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
		out.writeAttribute(X_1__XML_ATTR, getX1());
		out.writeAttribute(X_2__XML_ATTR, getX2());
	}

	/** Serializes all fields that are written as XML elements. */
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		// No element fields.
	}

	/** Creates a new {@link test.transientprops.data.A} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
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
			case X_1__XML_ATTR: {
				setX1(value);
				break;
			}
			case X_2__XML_ATTR: {
				setX2(value);
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
			case X_1__XML_ATTR: {
				setX1(in.getElementText());
				break;
			}
			case X_2__XML_ATTR: {
				setX2(in.getElementText());
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
