package test.openworld.base.impl;

/**
 * Implementation of {@link test.openworld.base.TextEvent}.
 */
public class TextEvent_Impl extends test.openworld.base.impl.SSEEvent_Impl implements test.openworld.base.TextEvent {

	private String _text = "";

	/**
	 * Creates a {@link TextEvent_Impl} instance.
	 *
	 * @see test.openworld.base.TextEvent#create()
	 */
	public TextEvent_Impl() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.TEXT_EVENT;
	}

	@Override
	public final String getText() {
		return _text;
	}

	@Override
	public test.openworld.base.TextEvent setText(String value) {
		internalSetText(value);
		return this;
	}

	/** Internal setter for {@link #getText()} without chain call utility. */
	protected final void internalSetText(String value) {
		_listener.beforeSet(this, TEXT__PROP, value);
		_text = value;
		_listener.afterChanged(this, TEXT__PROP);
	}

	@Override
	public test.openworld.base.TextEvent setTimestamp(long value) {
		internalSetTimestamp(value);
		return this;
	}

	@Override
	public String jsonType() {
		return TEXT_EVENT__TYPE;
	}

	@SuppressWarnings("hiding")
	protected static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			TEXT__PROP);
		java.util.List<String> tmp = new java.util.ArrayList<>();
		tmp.addAll(test.openworld.base.impl.SSEEvent_Impl.PROPERTIES);
		tmp.addAll(local);
		PROPERTIES = java.util.Collections.unmodifiableList(tmp);
	}

	@SuppressWarnings("hiding")
	protected static final java.util.Set<String> TRANSIENT_PROPERTIES;
	static {
		java.util.HashSet<String> tmp = new java.util.HashSet<>();
		tmp.addAll(test.openworld.base.impl.SSEEvent_Impl.TRANSIENT_PROPERTIES);
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
			case TEXT__PROP: return getText();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case TEXT__PROP: internalSetText((String) value); break;
			default: super.set(field, value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(TEXT__PROP);
		out.value(getText());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case TEXT__PROP: setText(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			default: super.readField(in, field);
		}
	}

	/** XML element name representing a {@link test.openworld.base.TextEvent} type. */
	public static final String TEXT_EVENT__XML_ELEMENT = "text-event";

	/** XML attribute or element name of a {@link #getText} property. */
	private static final String TEXT__XML_ATTR = "text";

	@Override
	public String getXmlTagName() {
		return TEXT_EVENT__XML_ELEMENT;
	}

	/** Serializes all fields that are written as XML attributes. */
	@Override
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeAttributes(out);
		out.writeAttribute(TEXT__XML_ATTR, getText());
	}

	/** Serializes all fields that are written as XML elements. */
	@Override
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeElements(out);
		// No element fields.
	}

	/** Creates a new {@link test.openworld.base.TextEvent} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static TextEvent_Impl readTextEvent_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		TextEvent_Impl result = new TextEvent_Impl();
		result.readContentXml(in);
		return result;
	}

	@Override
	protected void readFieldXmlAttribute(String name, String value) {
		switch (name) {
			case TEXT__XML_ATTR: {
				setText(value);
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
			case TEXT__XML_ATTR: {
				setText(in.getElementText());
				break;
			}
			default: {
				super.readFieldXmlElement(in, localName);
			}
		}
	}

	@Override
	public <R,A,E extends Throwable> R visit(test.openworld.base.SSEEvent.Visitor<R,A,E> v, A arg) throws E {
		return v.visit(this, arg);
	}

}
