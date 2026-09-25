package test.nested.owbase;

/**
 * An OpenWorld hierarchy with a nested abstract root (issue #16).
 */
public interface Events extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {
	/**
	 * Nested abstract root, extended from another file.
	 */
	public interface Event extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

		/** Type codes for the {@link test.nested.owbase.Events.Event} hierarchy. */
		public enum TypeKind {

			/** Type literal for {@link test.nested.owbase.Events.TextEvent}. */
			TEXT_EVENT,
			;

		}

		/** Registry for dynamically registered subtypes. */
		static final java.util.Map<String, de.haumacher.msgbuf.data.Factory<? extends test.nested.owbase.Events.Event>> REGISTRY = new java.util.HashMap<>();

		/**
		 * Registers a subtype factory for polymorphic deserialization.
		 */
		static void register(String typeId, de.haumacher.msgbuf.data.Factory<? extends test.nested.owbase.Events.Event> factory) {
			REGISTRY.put(typeId, factory);
		}

		/** Visitor interface for the {@link test.nested.owbase.Events.Event} hierarchy.*/
		public interface Visitor<R,A,E extends Throwable> {

			/** Visit case for {@link test.nested.owbase.Events.TextEvent}.*/
			R visit(test.nested.owbase.Events.TextEvent self, A arg) throws E;

			/** Fallback for visiting subtypes not known at compile time. */
			R visitDefault(test.nested.owbase.Events.Event self, A arg) throws E;

		}

		/** @see #getTimestamp() */
		String TIMESTAMP__PROP = "timestamp";

		/** The type code of this instance. */
		TypeKind kind();

		long getTimestamp();

		/**
		 * @see #getTimestamp()
		 */
		test.nested.owbase.Events.Event setTimestamp(long value);

		@Override
		public test.nested.owbase.Events.Event registerListener(de.haumacher.msgbuf.observer.Listener l);

		@Override
		public test.nested.owbase.Events.Event unregisterListener(de.haumacher.msgbuf.observer.Listener l);

		/** Reads a new instance from the given reader. */
		static test.nested.owbase.Events.Event readEvent(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			test.nested.owbase.Events.Event result;
			in.beginArray();
			String type = in.nextString();
			switch (type) {
				case test.nested.owbase.Events.TextEvent.TEXT_EVENT__TYPE: result = test.nested.owbase.Events.TextEvent.readTextEvent(in); break;
				default: {
					de.haumacher.msgbuf.data.TypeRegistryLoader.ensureLoaded();
					de.haumacher.msgbuf.data.Factory<? extends test.nested.owbase.Events.Event> factory = test.nested.owbase.Events.Event.REGISTRY.get(type);
					if (factory != null) {
						result = factory.create();
						result.readContent(in);
					} else {
						in.skipValue();
						result = null;
					}
				} break;
			}
			in.endArray();
			return result;
		}

		/** Registry for dynamically registered subtypes by their XML element names. */
		static final java.util.Map<String, de.haumacher.msgbuf.data.Factory<? extends test.nested.owbase.Events.Event>> XML_REGISTRY = new java.util.HashMap<>();

		/**
		 * Registers a subtype factory for reading elements with the given name in XML format.
		 */
		static void registerXml(String elementName, de.haumacher.msgbuf.data.Factory<? extends test.nested.owbase.Events.Event> factory) {
			XML_REGISTRY.put(elementName, factory);
		}

		/** Creates a new {@link Event} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Event readEvent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			in.nextTag();
			return test.nested.owbase.impl.Events_Impl.Event_Impl.readEvent_XmlContent(in);
		}

		/** Accepts the given visitor. */
		public abstract <R,A,E extends Throwable> R visit(Visitor<R,A,E> v, A arg) throws E;

	}
	public interface TextEvent extends test.nested.owbase.Events.Event {

		/**
		 * Creates a {@link test.nested.owbase.Events.TextEvent} instance.
		 */
		static test.nested.owbase.Events.TextEvent create() {
			return new test.nested.owbase.impl.Events_Impl.TextEvent_Impl();
		}

		/** Identifier for the {@link test.nested.owbase.Events.TextEvent} type in JSON format. */
		String TEXT_EVENT__TYPE = "TextEvent";

		/** @see #getText() */
		String TEXT__PROP = "text";

		String getText();

		/**
		 * @see #getText()
		 */
		test.nested.owbase.Events.TextEvent setText(String value);

		@Override
		test.nested.owbase.Events.TextEvent setTimestamp(long value);

		/** Reads a new instance from the given reader. */
		static test.nested.owbase.Events.TextEvent readTextEvent(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			test.nested.owbase.impl.Events_Impl.TextEvent_Impl result = new test.nested.owbase.impl.Events_Impl.TextEvent_Impl();
			result.readContent(in);
			return result;
		}

		/** Creates a new {@link TextEvent} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static TextEvent readTextEvent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			in.nextTag();
			return test.nested.owbase.impl.Events_Impl.TextEvent_Impl.readTextEvent_XmlContent(in);
		}

	}

	/**
	 * Creates a {@link test.nested.owbase.Events} instance.
	 */
	static test.nested.owbase.Events create() {
		return new test.nested.owbase.impl.Events_Impl();
	}

	/** Identifier for the {@link test.nested.owbase.Events} type in JSON format. */
	String EVENTS__TYPE = "Events";

	/** @see #getEvents() */
	String EVENTS__PROP = "events";

	java.util.List<test.nested.owbase.Events.Event> getEvents();

	/**
	 * @see #getEvents()
	 */
	test.nested.owbase.Events setEvents(java.util.List<? extends test.nested.owbase.Events.Event> value);

	/**
	 * Adds a value to the {@link #getEvents()} list.
	 */
	test.nested.owbase.Events addEvent(test.nested.owbase.Events.Event value);

	/**
	 * Removes a value from the {@link #getEvents()} list.
	 */
	void removeEvent(test.nested.owbase.Events.Event value);

	@Override
	public test.nested.owbase.Events registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.nested.owbase.Events unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.nested.owbase.Events readEvents(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.nested.owbase.impl.Events_Impl result = new test.nested.owbase.impl.Events_Impl();
		result.readContent(in);
		return result;
	}

	/** Creates a new {@link Events} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Events readEvents(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.nested.owbase.impl.Events_Impl.readEvents_XmlContent(in);
	}

}
