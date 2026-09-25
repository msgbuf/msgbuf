package test.nested.data.impl;

/**
 * Implementation of {@link test.nested.data.Triangle}.
 */
public class Triangle_Impl extends test.nested.data.impl.Outer_Impl.Shape_Impl implements test.nested.data.Triangle {

	private int _base = 0;

	private int _height = 0;

	/**
	 * Creates a {@link Triangle_Impl} instance.
	 *
	 * @see test.nested.data.Triangle#create()
	 */
	public Triangle_Impl() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.TRIANGLE;
	}

	@Override
	public final int getBase() {
		return _base;
	}

	@Override
	public test.nested.data.Triangle setBase(int value) {
		internalSetBase(value);
		return this;
	}

	/** Internal setter for {@link #getBase()} without chain call utility. */
	protected final void internalSetBase(int value) {
		_listener.beforeSet(this, BASE__PROP, value);
		_base = value;
		_listener.afterChanged(this, BASE__PROP);
	}

	@Override
	public final int getHeight() {
		return _height;
	}

	@Override
	public test.nested.data.Triangle setHeight(int value) {
		internalSetHeight(value);
		return this;
	}

	/** Internal setter for {@link #getHeight()} without chain call utility. */
	protected final void internalSetHeight(int value) {
		_listener.beforeSet(this, HEIGHT__PROP, value);
		_height = value;
		_listener.afterChanged(this, HEIGHT__PROP);
	}

	@Override
	public test.nested.data.Triangle setName(String value) {
		internalSetName(value);
		return this;
	}

	@Override
	public String jsonType() {
		return TRIANGLE__TYPE;
	}

	@SuppressWarnings("hiding")
	static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			BASE__PROP, 
			HEIGHT__PROP);
		java.util.List<String> tmp = new java.util.ArrayList<>();
		tmp.addAll(test.nested.data.impl.Outer_Impl.Shape_Impl.PROPERTIES);
		tmp.addAll(local);
		PROPERTIES = java.util.Collections.unmodifiableList(tmp);
	}

	@SuppressWarnings("hiding")
	static final java.util.Set<String> TRANSIENT_PROPERTIES;
	static {
		java.util.HashSet<String> tmp = new java.util.HashSet<>();
		tmp.addAll(test.nested.data.impl.Outer_Impl.Shape_Impl.TRANSIENT_PROPERTIES);
		tmp.addAll(java.util.Arrays.asList(
				));
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
			case BASE__PROP: return getBase();
			case HEIGHT__PROP: return getHeight();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case BASE__PROP: internalSetBase((int) value); break;
			case HEIGHT__PROP: internalSetHeight((int) value); break;
			default: super.set(field, value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(BASE__PROP);
		out.value(getBase());
		out.name(HEIGHT__PROP);
		out.value(getHeight());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case BASE__PROP: setBase(in.nextInt()); break;
			case HEIGHT__PROP: setHeight(in.nextInt()); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public int typeId() {
		return TRIANGLE__TYPE_ID;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(BASE__ID);
		out.value(getBase());
		out.name(HEIGHT__ID);
		out.value(getHeight());
	}

	/** Helper for creating an object of type {@link test.nested.data.Triangle} from a polymorphic composition. */
	public static test.nested.data.Triangle readTriangle_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.nested.data.impl.Triangle_Impl result = new Triangle_Impl();
		result.readContent(in);
		return result;
	}

	@Override
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case BASE__ID: setBase(in.nextInt()); break;
			case HEIGHT__ID: setHeight(in.nextInt()); break;
			default: super.readField(in, field);
		}
	}

	/** XML element name representing a {@link test.nested.data.Triangle} type. */
	public static final String TRIANGLE__XML_ELEMENT = "triangle";

	/** XML attribute or element name of a {@link #getBase} property. */
	private static final String BASE__XML_ATTR = "base";

	/** XML attribute or element name of a {@link #getHeight} property. */
	private static final String HEIGHT__XML_ATTR = "height";

	@Override
	public String getXmlTagName() {
		return TRIANGLE__XML_ELEMENT;
	}

	/** Serializes all fields that are written as XML attributes. */
	@Override
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeAttributes(out);
		out.writeAttribute(BASE__XML_ATTR, Integer.toString(getBase()));
		out.writeAttribute(HEIGHT__XML_ATTR, Integer.toString(getHeight()));
	}

	/** Serializes all fields that are written as XML elements. */
	@Override
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeElements(out);
		// No element fields.
	}

	/** Creates a new {@link test.nested.data.Triangle} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Triangle_Impl readTriangle_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		Triangle_Impl result = new Triangle_Impl();
		result.readContentXml(in);
		return result;
	}

	@Override
	protected void readFieldXmlAttribute(String name, String value) {
		switch (name) {
			case BASE__XML_ATTR: {
				setBase(Integer.parseInt(value));
				break;
			}
			case HEIGHT__XML_ATTR: {
				setHeight(Integer.parseInt(value));
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
			case BASE__XML_ATTR: {
				setBase(Integer.parseInt(in.getElementText()));
				break;
			}
			case HEIGHT__XML_ATTR: {
				setHeight(Integer.parseInt(in.getElementText()));
				break;
			}
			default: {
				super.readFieldXmlElement(in, localName);
			}
		}
	}

	@Override
	public <R,A,E extends Throwable> R visit(test.nested.data.Outer.Shape.Visitor<R,A,E> v, A arg) throws E {
		return v.visit(this, arg);
	}

}
