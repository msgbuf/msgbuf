package test.openworld.base.impl;

/**
 * Implementation of {@link test.openworld.base.SSEEvent}.
 */
public abstract class SSEEvent_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.openworld.base.SSEEvent {

	static {
		de.haumacher.msgbuf.data.TypeRegistryLoader.ensureLoaded();
	}

	private long _timestamp = 0L;

	/**
	 * Creates a {@link SSEEvent_Impl} instance.
	 */
	public SSEEvent_Impl() {
		super();
	}

	@Override
	public final long getTimestamp() {
		return _timestamp;
	}

	@Override
	public test.openworld.base.SSEEvent setTimestamp(long value) {
		internalSetTimestamp(value);
		return this;
	}

	/** Internal setter for {@link #getTimestamp()} without chain call utility. */
	protected final void internalSetTimestamp(long value) {
		_listener.beforeSet(this, TIMESTAMP__PROP, value);
		_timestamp = value;
		_listener.afterChanged(this, TIMESTAMP__PROP);
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.openworld.base.SSEEvent registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.openworld.base.SSEEvent unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		internalUnregisterListener(l);
		return this;
	}

	protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
	}

	protected static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			TIMESTAMP__PROP);
		PROPERTIES = java.util.Collections.unmodifiableList(local);
	}

	protected static final java.util.Set<String> TRANSIENT_PROPERTIES;
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
			case TIMESTAMP__PROP: return getTimestamp();
			default: return test.openworld.base.SSEEvent.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case TIMESTAMP__PROP: internalSetTimestamp((long) value); break;
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
		out.name(TIMESTAMP__PROP);
		out.value(getTimestamp());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case TIMESTAMP__PROP: setTimestamp(in.nextLong()); break;
			default: super.readField(in, field);
		}
	}

	/** XML element name representing a {@link test.openworld.base.SSEEvent} type. */
	public static final String SSEEVENT__XML_ELEMENT = "sseevent";

	/** XML attribute or element name of a {@link #getTimestamp} property. */
	private static final String TIMESTAMP__XML_ATTR = "timestamp";

	@Override
	public final void writeContent(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		writeAttributes(out);
		writeElements(out);
	}

	/** Serializes all fields that are written as XML attributes. */
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		out.writeAttribute(TIMESTAMP__XML_ATTR, Long.toString(getTimestamp()));
	}

	/** Serializes all fields that are written as XML elements. */
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		// No element fields.
	}

	/** Creates a new {@link test.openworld.base.SSEEvent} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static SSEEvent_Impl readSSEEvent_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		switch (in.getLocalName()) {
			case TextEvent_Impl.TEXT_EVENT__XML_ELEMENT: {
				return test.openworld.base.impl.TextEvent_Impl.readTextEvent_XmlContent(in);
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
			case TIMESTAMP__XML_ATTR: {
				setTimestamp(Long.parseLong(value));
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
			case TIMESTAMP__XML_ATTR: {
				setTimestamp(Long.parseLong(in.getElementText()));
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
