package test.openworld.novisitor.ext.impl;

/**
 * Implementation of {@link test.openworld.novisitor.ext.Square}.
 */
public class Square_Impl extends test.openworld.novisitor.base.impl.Shape_Impl implements test.openworld.novisitor.ext.Square {

	private int _side = 0;

	/**
	 * Creates a {@link Square_Impl} instance.
	 *
	 * @see test.openworld.novisitor.ext.Square#create()
	 */
	public Square_Impl() {
		super();
	}

	@Override
	public TypeKind kind() {
		return null;
	}

	@Override
	public final int getSide() {
		return _side;
	}

	@Override
	public test.openworld.novisitor.ext.Square setSide(int value) {
		internalSetSide(value);
		return this;
	}

	/** Internal setter for {@link #getSide()} without chain call utility. */
	protected final void internalSetSide(int value) {
		_listener.beforeSet(this, SIDE__PROP, value);
		_side = value;
		_listener.afterChanged(this, SIDE__PROP);
	}

	@Override
	public test.openworld.novisitor.ext.Square setName(String value) {
		internalSetName(value);
		return this;
	}

	@Override
	public String jsonType() {
		return SQUARE__TYPE;
	}

	@SuppressWarnings("hiding")
	protected static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			SIDE__PROP);
		java.util.List<String> tmp = new java.util.ArrayList<>();
		tmp.addAll(test.openworld.novisitor.base.impl.Shape_Impl.PROPERTIES);
		tmp.addAll(local);
		PROPERTIES = java.util.Collections.unmodifiableList(tmp);
	}

	@SuppressWarnings("hiding")
	protected static final java.util.Set<String> TRANSIENT_PROPERTIES;
	static {
		java.util.HashSet<String> tmp = new java.util.HashSet<>();
		tmp.addAll(test.openworld.novisitor.base.impl.Shape_Impl.TRANSIENT_PROPERTIES);
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
			case SIDE__PROP: return getSide();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case SIDE__PROP: internalSetSide((int) value); break;
			default: super.set(field, value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(SIDE__PROP);
		out.value(getSide());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case SIDE__PROP: setSide(in.nextInt()); break;
			default: super.readField(in, field);
		}
	}

	/** XML element name representing a {@link test.openworld.novisitor.ext.Square} type. */
	public static final String SQUARE__XML_ELEMENT = "square";

	/** XML attribute or element name of a {@link #getSide} property. */
	private static final String SIDE__XML_ATTR = "side";

	@Override
	public String getXmlTagName() {
		return SQUARE__XML_ELEMENT;
	}

	/** Serializes all fields that are written as XML attributes. */
	@Override
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeAttributes(out);
		out.writeAttribute(SIDE__XML_ATTR, Integer.toString(getSide()));
	}

	/** Serializes all fields that are written as XML elements. */
	@Override
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeElements(out);
		// No element fields.
	}

	/** Creates a new {@link test.openworld.novisitor.ext.Square} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Square_Impl readSquare_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		Square_Impl result = new Square_Impl();
		result.readContentXml(in);
		return result;
	}

	@Override
	protected void readFieldXmlAttribute(String name, String value) {
		switch (name) {
			case SIDE__XML_ATTR: {
				setSide(Integer.parseInt(value));
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
			case SIDE__XML_ATTR: {
				setSide(Integer.parseInt(in.getElementText()));
				break;
			}
			default: {
				super.readFieldXmlElement(in, localName);
			}
		}
	}

}
