package test.openworld.base;

/**
 * Base event for server-sent events.
 */
public interface SSEEvent extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/** Type codes for the {@link test.openworld.base.SSEEvent} hierarchy. */
	public enum TypeKind {

		/** Type literal for {@link test.openworld.base.TextEvent}. */
		TEXT_EVENT,
		;

	}

	/** Registry for dynamically registered subtypes. */
	static final java.util.Map<String, de.haumacher.msgbuf.data.Factory<? extends test.openworld.base.SSEEvent>> REGISTRY = new java.util.HashMap<>();

	/**
	 * Registers a subtype factory for polymorphic deserialization.
	 */
	static void register(String typeId, de.haumacher.msgbuf.data.Factory<? extends test.openworld.base.SSEEvent> factory) {
		REGISTRY.put(typeId, factory);
	}

	/** Visitor interface for the {@link test.openworld.base.SSEEvent} hierarchy.*/
	public interface Visitor<R,A,E extends Throwable> {

		/** Visit case for {@link test.openworld.base.TextEvent}.*/
		R visit(test.openworld.base.TextEvent self, A arg) throws E;

		/** Fallback for visiting subtypes not known at compile time. */
		R visitDefault(test.openworld.base.SSEEvent self, A arg) throws E;

	}

	/** @see #getTimestamp() */
	String TIMESTAMP__PROP = "timestamp";

	/** The type code of this instance. */
	TypeKind kind();

	/**
	 * Timestamp of the event.
	 */
	long getTimestamp();

	/**
	 * @see #getTimestamp()
	 */
	test.openworld.base.SSEEvent setTimestamp(long value);

	@Override
	public test.openworld.base.SSEEvent registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.openworld.base.SSEEvent unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.openworld.base.SSEEvent readSSEEvent(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.openworld.base.SSEEvent result;
		de.haumacher.msgbuf.data.TypeRegistryLoader.ensureLoaded();
		in.beginArray();
		String type = in.nextString();
		switch (type) {
			case TextEvent.TEXT_EVENT__TYPE: result = test.openworld.base.TextEvent.readTextEvent(in); break;
			default: {
				de.haumacher.msgbuf.data.Factory<? extends test.openworld.base.SSEEvent> factory = test.openworld.base.SSEEvent.REGISTRY.get(type);
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

	/** Creates a new {@link SSEEvent} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static SSEEvent readSSEEvent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.openworld.base.impl.SSEEvent_Impl.readSSEEvent_XmlContent(in);
	}

	/** Accepts the given visitor. */
	public abstract <R,A,E extends Throwable> R visit(Visitor<R,A,E> v, A arg) throws E;

}
