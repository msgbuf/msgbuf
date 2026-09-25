package test.nested.owext.impl;

/**
 * Implementation of {@link test.nested.owext.Patches}.
 */
public class Patches_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.nested.owext.Patches {
	/**
	 * Implementation of {@link test.nested.owext.Patches.PatchEvent}.
	 */
	public static class PatchEvent_Impl extends test.nested.owbase.impl.Events_Impl.Event_Impl implements test.nested.owext.Patches.PatchEvent {

		private String _patch = "";

		/**
		 * Creates a {@link PatchEvent_Impl} instance.
		 *
		 * @see test.nested.owext.Patches.PatchEvent#create()
		 */
		public PatchEvent_Impl() {
			super();
		}

		@Override
		public TypeKind kind() {
			return null;
		}

		@Override
		public final String getPatch() {
			return _patch;
		}

		@Override
		public test.nested.owext.Patches.PatchEvent setPatch(String value) {
			internalSetPatch(value);
			return this;
		}

		/** Internal setter for {@link #getPatch()} without chain call utility. */
		protected final void internalSetPatch(String value) {
			_listener.beforeSet(this, PATCH__PROP, value);
			_patch = value;
			_listener.afterChanged(this, PATCH__PROP);
		}

		@Override
		public test.nested.owext.Patches.PatchEvent setTimestamp(long value) {
			internalSetTimestamp(value);
			return this;
		}

		@Override
		public String jsonType() {
			return PATCH_EVENT__TYPE;
		}

		@SuppressWarnings("hiding")
		protected static final java.util.List<String> PROPERTIES;
		static {
			java.util.List<String> local = java.util.Arrays.asList(
				PATCH__PROP);
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
				case PATCH__PROP: return getPatch();
				default: return super.get(field);
			}
		}

		@Override
		public void set(String field, Object value) {
			switch (field) {
				case PATCH__PROP: internalSetPatch((String) value); break;
				default: super.set(field, value); break;
			}
		}

		@Override
		protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
			super.writeFields(out);
			out.name(PATCH__PROP);
			out.value(getPatch());
		}

		@Override
		protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
			switch (field) {
				case PATCH__PROP: setPatch(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
				default: super.readField(in, field);
			}
		}

		/** XML element name representing a {@link test.nested.owext.Patches.PatchEvent} type. */
		public static final String PATCH_EVENT__XML_ELEMENT = "patch-event";

		/** XML attribute or element name of a {@link #getPatch} property. */
		private static final String PATCH__XML_ATTR = "patch";

		@Override
		public String getXmlTagName() {
			return PATCH_EVENT__XML_ELEMENT;
		}

		/** Serializes all fields that are written as XML attributes. */
		@Override
		protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
			super.writeAttributes(out);
			out.writeAttribute(PATCH__XML_ATTR, getPatch());
		}

		/** Serializes all fields that are written as XML elements. */
		@Override
		protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
			super.writeElements(out);
			// No element fields.
		}

		/** Creates a new {@link test.nested.owext.Patches.PatchEvent} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static PatchEvent_Impl readPatchEvent_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			PatchEvent_Impl result = new PatchEvent_Impl();
			result.readContentXml(in);
			return result;
		}

		@Override
		protected void readFieldXmlAttribute(String name, String value) {
			switch (name) {
				case PATCH__XML_ATTR: {
					setPatch(value);
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
				case PATCH__XML_ATTR: {
					setPatch(in.getElementText());
					break;
				}
				default: {
					super.readFieldXmlElement(in, localName);
				}
			}
		}

		@Override
		public <R,A,E extends Throwable> R visit(test.nested.owbase.Events.Event.Visitor<R,A,E> v, A arg) throws E {
			if (v instanceof test.nested.owext.Patches.PatchEvent.Visitor) {
				return ((test.nested.owext.Patches.PatchEvent.Visitor<R,A,E>) v).visit(this, arg);
			}
			return v.visitDefault(this, arg);
		}

	}

	/**
	 * Creates a {@link Patches_Impl} instance.
	 *
	 * @see test.nested.owext.Patches#create()
	 */
	public Patches_Impl() {
		super();
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.nested.owext.Patches registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.nested.owext.Patches unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		internalUnregisterListener(l);
		return this;
	}

	protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
	}

	@Override
	public String jsonType() {
		return PATCHES__TYPE;
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	/** XML element name representing a {@link test.nested.owext.Patches} type. */
	public static final String PATCHES__XML_ELEMENT = "patches";

	@Override
	public String getXmlTagName() {
		return PATCHES__XML_ELEMENT;
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
		// No element fields.
	}

	/** Creates a new {@link test.nested.owext.Patches} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Patches_Impl readPatches_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		Patches_Impl result = new Patches_Impl();
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
