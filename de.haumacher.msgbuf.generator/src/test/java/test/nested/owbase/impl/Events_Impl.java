package test.nested.owbase.impl;

/**
 * Implementation of {@link test.nested.owbase.Events}.
 */
public class Events_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.nested.owbase.Events {
	/**
	 * Implementation of {@link test.nested.owbase.Events.Event}.
	 */
	public static abstract class Event_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.nested.owbase.Events.Event {

		static {
			de.haumacher.msgbuf.data.TypeRegistryLoader.ensureLoaded();
		}

		private long _timestamp = 0L;

		/**
		 * Creates a {@link Event_Impl} instance.
		 */
		public Event_Impl() {
			super();
		}

		@Override
		public final long getTimestamp() {
			return _timestamp;
		}

		@Override
		public test.nested.owbase.Events.Event setTimestamp(long value) {
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
		public test.nested.owbase.Events.Event registerListener(de.haumacher.msgbuf.observer.Listener l) {
			internalRegisterListener(l);
			return this;
		}

		protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
			_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
		}

		@Override
		public test.nested.owbase.Events.Event unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
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
				default: return test.nested.owbase.Events.Event.super.get(field);
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

		/** XML element name representing a {@link test.nested.owbase.Events.Event} type. */
		public static final String EVENT__XML_ELEMENT = "event";

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

		/** Creates a new {@link test.nested.owbase.Events.Event} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Event_Impl readEvent_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			switch (in.getLocalName()) {
				case test.nested.owbase.impl.Events_Impl.TextEvent_Impl.TEXT_EVENT__XML_ELEMENT: {
					return test.nested.owbase.impl.Events_Impl.TextEvent_Impl.readTextEvent_XmlContent(in);
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
	/**
	 * Implementation of {@link test.nested.owbase.Events.TextEvent}.
	 */
	public static class TextEvent_Impl extends test.nested.owbase.impl.Events_Impl.Event_Impl implements test.nested.owbase.Events.TextEvent {

		private String _text = "";

		/**
		 * Creates a {@link TextEvent_Impl} instance.
		 *
		 * @see test.nested.owbase.Events.TextEvent#create()
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
		public test.nested.owbase.Events.TextEvent setText(String value) {
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
		public test.nested.owbase.Events.TextEvent setTimestamp(long value) {
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

		/** XML element name representing a {@link test.nested.owbase.Events.TextEvent} type. */
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

		/** Creates a new {@link test.nested.owbase.Events.TextEvent} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
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
		public <R,A,E extends Throwable> R visit(test.nested.owbase.Events.Event.Visitor<R,A,E> v, A arg) throws E {
			return v.visit(this, arg);
		}

	}

	private final java.util.List<test.nested.owbase.Events.Event> _events = new de.haumacher.msgbuf.util.ReferenceList<test.nested.owbase.Events.Event>() {
		@Override
		protected void beforeAdd(int index, test.nested.owbase.Events.Event element) {
			_listener.beforeAdd(Events_Impl.this, EVENTS__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, test.nested.owbase.Events.Event element) {
			_listener.afterRemove(Events_Impl.this, EVENTS__PROP, index, element);
		}

		@Override
		protected void afterChanged() {
			_listener.afterChanged(Events_Impl.this, EVENTS__PROP);
		}
	};

	/**
	 * Creates a {@link Events_Impl} instance.
	 *
	 * @see test.nested.owbase.Events#create()
	 */
	public Events_Impl() {
		super();
	}

	@Override
	public final java.util.List<test.nested.owbase.Events.Event> getEvents() {
		return _events;
	}

	@Override
	public test.nested.owbase.Events setEvents(java.util.List<? extends test.nested.owbase.Events.Event> value) {
		internalSetEvents(value);
		return this;
	}

	/** Internal setter for {@link #getEvents()} without chain call utility. */
	protected final void internalSetEvents(java.util.List<? extends test.nested.owbase.Events.Event> value) {
		if (value == null) throw new IllegalArgumentException("Property 'events' cannot be null.");
		_events.clear();
		_events.addAll(value);
	}

	@Override
	public test.nested.owbase.Events addEvent(test.nested.owbase.Events.Event value) {
		internalAddEvent(value);
		return this;
	}

	/** Implementation of {@link #addEvent(test.nested.owbase.Events.Event)} without chain call utility. */
	protected final void internalAddEvent(test.nested.owbase.Events.Event value) {
		_events.add(value);
	}

	@Override
	public final void removeEvent(test.nested.owbase.Events.Event value) {
		_events.remove(value);
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.nested.owbase.Events registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.nested.owbase.Events unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		internalUnregisterListener(l);
		return this;
	}

	protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
	}

	@Override
	public String jsonType() {
		return EVENTS__TYPE;
	}

	protected static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			EVENTS__PROP);
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
			case EVENTS__PROP: return getEvents();
			default: return test.nested.owbase.Events.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case EVENTS__PROP: internalSetEvents(de.haumacher.msgbuf.util.Conversions.asList(test.nested.owbase.Events.Event.class, value)); break;
		}
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(EVENTS__PROP);
		out.beginArray();
		for (test.nested.owbase.Events.Event x : getEvents()) {
			x.writeTo(out);
		}
		out.endArray();
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case EVENTS__PROP: {
				java.util.List<test.nested.owbase.Events.Event> newValue = new java.util.ArrayList<>();
				in.beginArray();
				while (in.hasNext()) {
					newValue.add(test.nested.owbase.Events.Event.readEvent(in));
				}
				in.endArray();
				setEvents(newValue);
			}
			break;
			default: super.readField(in, field);
		}
	}

	/** XML element name representing a {@link test.nested.owbase.Events} type. */
	public static final String EVENTS__XML_ELEMENT = "events";

	/** XML attribute or element name of a {@link #getEvents} property. */
	private static final String EVENTS__XML_ATTR = "events";

	@Override
	public String getXmlTagName() {
		return EVENTS__XML_ELEMENT;
	}

	@Override
	public final void writeContent(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		writeAttributes(out);
		writeElements(out);
	}

	/** Serializes all fields that are written as XML attributes. */
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
	}

	/** Serializes all fields that are written as XML elements. */
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		out.writeStartElement(EVENTS__XML_ATTR);
		for (test.nested.owbase.Events.Event element : getEvents()) {
			element.writeTo(out);
		}
		out.writeEndElement();
	}

	/** Creates a new {@link test.nested.owbase.Events} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Events_Impl readEvents_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		Events_Impl result = new Events_Impl();
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
			default: {
				// Skip unknown attribute.
			}
		}
	}

	/** Reads the element under the cursor and assigns its contents to the field with the given name. */
	protected void readFieldXmlElement(javax.xml.stream.XMLStreamReader in, String localName) throws javax.xml.stream.XMLStreamException {
		switch (localName) {
			case EVENTS__XML_ATTR: {
				internalReadEventsListXml(in);
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

	private void internalReadEventsListXml(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		while (true) {
			int event = in.nextTag();
			if (event == javax.xml.stream.XMLStreamConstants.END_ELEMENT) {
				break;
			}

			addEvent(test.nested.owbase.impl.Events_Impl.Event_Impl.readEvent_XmlContent(in));
		}
	}

}
