package test.transientprops.data.impl;

/**
 * Implementation of {@link test.transientprops.data.C}.
 */
public class C_Impl extends test.transientprops.data.impl.B_Impl implements test.transientprops.data.C {

	private String _z1 = "";

	private transient String _z2 = "";

	/**
	 * Creates a {@link C_Impl} instance.
	 *
	 * @see test.transientprops.data.C#create()
	 */
	public C_Impl() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.C;
	}

	@Override
	public final String getZ1() {
		return _z1;
	}

	@Override
	public test.transientprops.data.C setZ1(String value) {
		internalSetZ1(value);
		return this;
	}

	/** Internal setter for {@link #getZ1()} without chain call utility. */
	protected final void internalSetZ1(String value) {
		_listener.beforeSet(this, Z_1__PROP, value);
		_z1 = value;
		_listener.afterChanged(this, Z_1__PROP);
	}

	@Override
	public final String getZ2() {
		return _z2;
	}

	@Override
	public test.transientprops.data.C setZ2(String value) {
		internalSetZ2(value);
		return this;
	}

	/** Internal setter for {@link #getZ2()} without chain call utility. */
	protected final void internalSetZ2(String value) {
		_listener.beforeSet(this, Z_2__PROP, value);
		_z2 = value;
		_listener.afterChanged(this, Z_2__PROP);
	}

	@Override
	public test.transientprops.data.C setY1(String value) {
		internalSetY1(value);
		return this;
	}

	@Override
	public test.transientprops.data.C setY2(String value) {
		internalSetY2(value);
		return this;
	}

	@Override
	public test.transientprops.data.C setX1(String value) {
		internalSetX1(value);
		return this;
	}

	@Override
	public test.transientprops.data.C setX2(String value) {
		internalSetX2(value);
		return this;
	}

	@Override
	public String jsonType() {
		return C__TYPE;
	}

	@SuppressWarnings("hiding")
	static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			Z_1__PROP, 
			Z_2__PROP);
		java.util.List<String> tmp = new java.util.ArrayList<>();
		tmp.addAll(test.transientprops.data.impl.B_Impl.PROPERTIES);
		tmp.addAll(local);
		PROPERTIES = java.util.Collections.unmodifiableList(tmp);
	}

	@SuppressWarnings("hiding")
	static final java.util.Set<String> TRANSIENT_PROPERTIES;
	static {
		java.util.HashSet<String> tmp = new java.util.HashSet<>();
		tmp.addAll(test.transientprops.data.impl.B_Impl.TRANSIENT_PROPERTIES);
		tmp.addAll(java.util.Arrays.asList(
				Z_2__PROP));
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
			case Z_1__PROP: return getZ1();
			case Z_2__PROP: return getZ2();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case Z_1__PROP: internalSetZ1((String) value); break;
			case Z_2__PROP: internalSetZ2((String) value); break;
			default: super.set(field, value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(Z_1__PROP);
		out.value(getZ1());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case Z_1__PROP: setZ1(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			default: super.readField(in, field);
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(Z_1__ID);
		out.value(getZ1());
	}

	/** Helper for creating an object of type {@link test.transientprops.data.C} from a polymorphic composition. */
	public static test.transientprops.data.C readC_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.transientprops.data.impl.C_Impl result = new C_Impl();
		result.readContent(in);
		return result;
	}

	@Override
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case Z_1__ID: setZ1(in.nextString()); break;
			default: super.readField(in, field);
		}
	}

	/** XML element name representing a {@link test.transientprops.data.C} type. */
	public static final String C__XML_ELEMENT = "c";

	/** XML attribute or element name of a {@link #getZ1} property. */
	private static final String Z_1__XML_ATTR = "z-1";

	/** XML attribute or element name of a {@link #getZ2} property. */
	private static final String Z_2__XML_ATTR = "z-2";

	@Override
	public String getXmlTagName() {
		return C__XML_ELEMENT;
	}

	/** Serializes all fields that are written as XML attributes. */
	@Override
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeAttributes(out);
		out.writeAttribute(Z_1__XML_ATTR, getZ1());
		out.writeAttribute(Z_2__XML_ATTR, getZ2());
	}

	/** Serializes all fields that are written as XML elements. */
	@Override
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeElements(out);
		// No element fields.
	}

	/** Creates a new {@link test.transientprops.data.C} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static C_Impl readC_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		C_Impl result = new C_Impl();
		result.readContentXml(in);
		return result;
	}

	@Override
	protected void readFieldXmlAttribute(String name, String value) {
		switch (name) {
			case Z_1__XML_ATTR: {
				setZ1(value);
				break;
			}
			case Z_2__XML_ATTR: {
				setZ2(value);
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
			case Z_1__XML_ATTR: {
				setZ1(in.getElementText());
				break;
			}
			case Z_2__XML_ATTR: {
				setZ2(in.getElementText());
				break;
			}
			default: {
				super.readFieldXmlElement(in, localName);
			}
		}
	}

}
