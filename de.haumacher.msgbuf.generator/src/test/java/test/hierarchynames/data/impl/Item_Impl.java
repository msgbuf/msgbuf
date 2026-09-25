package test.hierarchynames.data.impl;

/**
 * Implementation of {@link test.hierarchynames.data.Item}.
 */
public class Item_Impl extends test.hierarchynames.data.impl.Outer_Impl.Shape_Impl implements test.hierarchynames.data.Item {

	private String _top = "";

	/**
	 * Creates a {@link Item_Impl} instance.
	 *
	 * @see test.hierarchynames.data.Item#create()
	 */
	public Item_Impl() {
		super();
	}

	@Override
	public final String getTop() {
		return _top;
	}

	@Override
	public test.hierarchynames.data.Item setTop(String value) {
		internalSetTop(value);
		return this;
	}

	/** Internal setter for {@link #getTop()} without chain call utility. */
	protected final void internalSetTop(String value) {
		_listener.beforeSet(this, TOP__PROP, value);
		_top = value;
		_listener.afterChanged(this, TOP__PROP);
	}

	@Override
	public String jsonType() {
		return ITEM__TYPE;
	}

	static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			TOP__PROP);
		PROPERTIES = java.util.Collections.unmodifiableList(local);
	}

	static final java.util.Set<String> TRANSIENT_PROPERTIES;
	static {
		java.util.HashSet<String> tmp = new java.util.HashSet<>();
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
			case TOP__PROP: return getTop();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case TOP__PROP: internalSetTop((String) value); break;
			default: super.set(field, value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(TOP__PROP);
		out.value(getTop());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case TOP__PROP: setTop(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public int typeId() {
		return ITEM__TYPE_ID;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(TOP__ID);
		out.value(getTop());
	}

	/** Helper for creating an object of type {@link test.hierarchynames.data.Item} from a polymorphic composition. */
	public static test.hierarchynames.data.Item readItem_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.hierarchynames.data.impl.Item_Impl result = new Item_Impl();
		result.readContent(in);
		return result;
	}

	@Override
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case TOP__ID: setTop(in.nextString()); break;
			default: super.readField(in, field);
		}
	}

	/** XML element name representing a {@link test.hierarchynames.data.Item} type. */
	public static final String ITEM__XML_ELEMENT = "TopItem";

	/** XML attribute or element name of a {@link #getTop} property. */
	private static final String TOP__XML_ATTR = "top";

	@Override
	public String getXmlTagName() {
		return ITEM__XML_ELEMENT;
	}

	/** Serializes all fields that are written as XML attributes. */
	@Override
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeAttributes(out);
		out.writeAttribute(TOP__XML_ATTR, getTop());
	}

	/** Serializes all fields that are written as XML elements. */
	@Override
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeElements(out);
		// No element fields.
	}

	/** Creates a new {@link test.hierarchynames.data.Item} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Item_Impl readItem_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		Item_Impl result = new Item_Impl();
		result.readContentXml(in);
		return result;
	}

	@Override
	protected void readFieldXmlAttribute(String name, String value) {
		switch (name) {
			case TOP__XML_ATTR: {
				setTop(value);
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
			case TOP__XML_ATTR: {
				setTop(in.getElementText());
				break;
			}
			default: {
				super.readFieldXmlElement(in, localName);
			}
		}
	}

	@Override
	public <R,A,E extends Throwable> R visit(test.hierarchynames.data.Outer.Shape.Visitor<R,A,E> v, A arg) throws E {
		return v.visit(this, arg);
	}

}
