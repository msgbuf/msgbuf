package test.nested.owcount.impl;

/**
 * Implementation of {@link test.nested.owcount.CountEvent}.
 */
public class CountEvent_Impl extends test.nested.owbase.impl.Events_Impl.Event_Impl implements test.nested.owcount.CountEvent {

	private int _count = 0;

	/**
	 * Creates a {@link CountEvent_Impl} instance.
	 *
	 * @see test.nested.owcount.CountEvent#create()
	 */
	public CountEvent_Impl() {
		super();
	}

	@Override
	public TypeKind kind() {
		return null;
	}

	@Override
	public final int getCount() {
		return _count;
	}

	@Override
	public test.nested.owcount.CountEvent setCount(int value) {
		internalSetCount(value);
		return this;
	}

	/** Internal setter for {@link #getCount()} without chain call utility. */
	protected final void internalSetCount(int value) {
		_listener.beforeSet(this, COUNT__PROP, value);
		_count = value;
		_listener.afterChanged(this, COUNT__PROP);
	}

	@Override
	public test.nested.owcount.CountEvent setTimestamp(long value) {
		internalSetTimestamp(value);
		return this;
	}

	@Override
	public String jsonType() {
		return COUNT_EVENT__TYPE;
	}

	@SuppressWarnings("hiding")
	protected static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			COUNT__PROP);
		java.util.List<String> tmp = new java.util.ArrayList<>();
		tmp.addAll(test.nested.owbase.impl.Events_Impl.Event_Impl.PROPERTIES);
		tmp.addAll(local);
		PROPERTIES = java.util.Collections.unmodifiableList(tmp);
	}

	@SuppressWarnings("hiding")
	protected static final java.util.Set<String> TRANSIENT_PROPERTIES;
	static {
		java.util.HashSet<String> tmp = new java.util.HashSet<>();
		tmp.addAll(test.nested.owbase.impl.Events_Impl.Event_Impl.TRANSIENT_PROPERTIES);
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
			case COUNT__PROP: return getCount();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case COUNT__PROP: internalSetCount((int) value); break;
			default: super.set(field, value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(COUNT__PROP);
		out.value(getCount());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case COUNT__PROP: setCount(in.nextInt()); break;
			default: super.readField(in, field);
		}
	}

	/** XML element name representing a {@link test.nested.owcount.CountEvent} type. */
	public static final String COUNT_EVENT__XML_ELEMENT = "count-event";

	/** XML attribute or element name of a {@link #getCount} property. */
	private static final String COUNT__XML_ATTR = "count";

	@Override
	public String getXmlTagName() {
		return COUNT_EVENT__XML_ELEMENT;
	}

	/** Serializes all fields that are written as XML attributes. */
	@Override
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeAttributes(out);
		out.writeAttribute(COUNT__XML_ATTR, Integer.toString(getCount()));
	}

	/** Serializes all fields that are written as XML elements. */
	@Override
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeElements(out);
		// No element fields.
	}

	/** Creates a new {@link test.nested.owcount.CountEvent} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static CountEvent_Impl readCountEvent_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		CountEvent_Impl result = new CountEvent_Impl();
		result.readContentXml(in);
		return result;
	}

	@Override
	protected void readFieldXmlAttribute(String name, String value) {
		switch (name) {
			case COUNT__XML_ATTR: {
				setCount(Integer.parseInt(value));
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
			case COUNT__XML_ATTR: {
				setCount(Integer.parseInt(in.getElementText()));
				break;
			}
			default: {
				super.readFieldXmlElement(in, localName);
			}
		}
	}

	@Override
	public <R,A,E extends Throwable> R visit(test.nested.owbase.Events.Event.Visitor<R,A,E> v, A arg) throws E {
		if (v instanceof test.nested.owcount.CountEvent.Visitor) {
			return ((test.nested.owcount.CountEvent.Visitor<R,A,E>) v).visit(this, arg);
		}
		return v.visitDefault(this, arg);
	}

}
