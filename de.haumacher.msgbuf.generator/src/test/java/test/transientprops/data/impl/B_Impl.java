package test.transientprops.data.impl;

/**
 * Implementation of {@link test.transientprops.data.B}.
 */
public class B_Impl extends test.transientprops.data.impl.A_Impl implements test.transientprops.data.B {

	private String _y1 = "";

	private transient String _y2 = "";

	/**
	 * Creates a {@link B_Impl} instance.
	 *
	 * @see test.transientprops.data.B#create()
	 */
	public B_Impl() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.B;
	}

	@Override
	public final String getY1() {
		return _y1;
	}

	@Override
	public test.transientprops.data.B setY1(String value) {
		internalSetY1(value);
		return this;
	}

	/** Internal setter for {@link #getY1()} without chain call utility. */
	protected final void internalSetY1(String value) {
		_listener.beforeSet(this, Y_1__PROP, value);
		_y1 = value;
		_listener.afterChanged(this, Y_1__PROP);
	}

	@Override
	public final String getY2() {
		return _y2;
	}

	@Override
	public test.transientprops.data.B setY2(String value) {
		internalSetY2(value);
		return this;
	}

	/** Internal setter for {@link #getY2()} without chain call utility. */
	protected final void internalSetY2(String value) {
		_listener.beforeSet(this, Y_2__PROP, value);
		_y2 = value;
		_listener.afterChanged(this, Y_2__PROP);
	}

	@Override
	public test.transientprops.data.B setX1(String value) {
		internalSetX1(value);
		return this;
	}

	@Override
	public test.transientprops.data.B setX2(String value) {
		internalSetX2(value);
		return this;
	}

	@Override
	public String jsonType() {
		return B__TYPE;
	}

	@SuppressWarnings("hiding")
	static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			Y_1__PROP, 
			Y_2__PROP);
		java.util.List<String> tmp = new java.util.ArrayList<>();
		tmp.addAll(test.transientprops.data.impl.A_Impl.PROPERTIES);
		tmp.addAll(local);
		PROPERTIES = java.util.Collections.unmodifiableList(tmp);
	}

	@SuppressWarnings("hiding")
	static final java.util.Set<String> TRANSIENT_PROPERTIES;
	static {
		java.util.HashSet<String> tmp = new java.util.HashSet<>();
		tmp.addAll(test.transientprops.data.impl.A_Impl.TRANSIENT_PROPERTIES);
		tmp.addAll(java.util.Arrays.asList(
				Y_2__PROP));
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
			case Y_1__PROP: return getY1();
			case Y_2__PROP: return getY2();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case Y_1__PROP: internalSetY1((String) value); break;
			case Y_2__PROP: internalSetY2((String) value); break;
			default: super.set(field, value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(Y_1__PROP);
		out.value(getY1());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case Y_1__PROP: setY1(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			default: super.readField(in, field);
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(Y_1__ID);
		out.value(getY1());
	}

	/** Helper for creating an object of type {@link test.transientprops.data.B} from a polymorphic composition. */
	public static test.transientprops.data.B readB_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.transientprops.data.impl.B_Impl result = new B_Impl();
		result.readContent(in);
		return result;
	}

	@Override
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case Y_1__ID: setY1(in.nextString()); break;
			default: super.readField(in, field);
		}
	}

	/** XML element name representing a {@link test.transientprops.data.B} type. */
	public static final String B__XML_ELEMENT = "b";

	/** XML attribute or element name of a {@link #getY1} property. */
	private static final String Y_1__XML_ATTR = "y-1";

	/** XML attribute or element name of a {@link #getY2} property. */
	private static final String Y_2__XML_ATTR = "y-2";

	@Override
	public String getXmlTagName() {
		return B__XML_ELEMENT;
	}

	/** Serializes all fields that are written as XML attributes. */
	@Override
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeAttributes(out);
		out.writeAttribute(Y_1__XML_ATTR, getY1());
		out.writeAttribute(Y_2__XML_ATTR, getY2());
	}

	/** Serializes all fields that are written as XML elements. */
	@Override
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeElements(out);
		// No element fields.
	}

	/** Creates a new {@link test.transientprops.data.B} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static B_Impl readB_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		B_Impl result = new B_Impl();
		result.readContentXml(in);
		return result;
	}

	@Override
	protected void readFieldXmlAttribute(String name, String value) {
		switch (name) {
			case Y_1__XML_ATTR: {
				setY1(value);
				break;
			}
			case Y_2__XML_ATTR: {
				setY2(value);
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
			case Y_1__XML_ATTR: {
				setY1(in.getElementText());
				break;
			}
			case Y_2__XML_ATTR: {
				setY2(in.getElementText());
				break;
			}
			default: {
				super.readFieldXmlElement(in, localName);
			}
		}
	}

}
