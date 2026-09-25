package test.hierarchynames.data.impl;

/**
 * Implementation of {@link test.hierarchynames.data.A}.
 */
public class A_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.hierarchynames.data.A {
	/**
	 * Implementation of {@link test.hierarchynames.data.A.Item}.
	 */
	public static class Item_Impl extends test.hierarchynames.data.impl.Msg_Impl implements test.hierarchynames.data.A.Item {

		private String _a = "";

		/**
		 * Creates a {@link Item_Impl} instance.
		 *
		 * @see test.hierarchynames.data.A.Item#create()
		 */
		public Item_Impl() {
			super();
		}

		@Override
		public final String getA() {
			return _a;
		}

		@Override
		public test.hierarchynames.data.A.Item setA(String value) {
			internalSetA(value);
			return this;
		}

		/** Internal setter for {@link #getA()} without chain call utility. */
		protected final void internalSetA(String value) {
			_listener.beforeSet(this, A__PROP, value);
			_a = value;
			_listener.afterChanged(this, A__PROP);
		}

		@Override
		public String jsonType() {
			return ITEM__TYPE;
		}

		static final java.util.List<String> PROPERTIES;
		static {
			java.util.List<String> local = java.util.Arrays.asList(
				A__PROP);
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
				case A__PROP: return getA();
				default: return super.get(field);
			}
		}

		@Override
		public void set(String field, Object value) {
			switch (field) {
				case A__PROP: internalSetA((String) value); break;
				default: super.set(field, value); break;
			}
		}

		@Override
		protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
			super.writeFields(out);
			out.name(A__PROP);
			out.value(getA());
		}

		@Override
		protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
			switch (field) {
				case A__PROP: setA(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
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
			out.name(A__ID);
			out.value(getA());
		}

		/** Helper for creating an object of type {@link test.hierarchynames.data.A.Item} from a polymorphic composition. */
		public static test.hierarchynames.data.A.Item readItem_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			test.hierarchynames.data.impl.A_Impl.Item_Impl result = new Item_Impl();
			result.readContent(in);
			return result;
		}

		@Override
		protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
			switch (field) {
				case A__ID: setA(in.nextString()); break;
				default: super.readField(in, field);
			}
		}

		/** XML element name representing a {@link test.hierarchynames.data.A.Item} type. */
		public static final String ITEM__XML_ELEMENT = "A.Item";

		/** XML attribute or element name of a {@link #getA} property. */
		private static final String A__XML_ATTR = "a";

		@Override
		public String getXmlTagName() {
			return ITEM__XML_ELEMENT;
		}

		/** Serializes all fields that are written as XML attributes. */
		@Override
		protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
			super.writeAttributes(out);
			out.writeAttribute(A__XML_ATTR, getA());
		}

		/** Serializes all fields that are written as XML elements. */
		@Override
		protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
			super.writeElements(out);
			// No element fields.
		}

		/** Creates a new {@link test.hierarchynames.data.A.Item} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Item_Impl readItem_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			Item_Impl result = new Item_Impl();
			result.readContentXml(in);
			return result;
		}

		@Override
		protected void readFieldXmlAttribute(String name, String value) {
			switch (name) {
				case A__XML_ATTR: {
					setA(value);
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
				case A__XML_ATTR: {
					setA(in.getElementText());
					break;
				}
				default: {
					super.readFieldXmlElement(in, localName);
				}
			}
		}

		@Override
		public <R,A,E extends Throwable> R visit(test.hierarchynames.data.Msg.Visitor<R,A,E> v, A arg) throws E {
			return v.visit(this, arg);
		}

	}

	/**
	 * Creates a {@link A_Impl} instance.
	 *
	 * @see test.hierarchynames.data.A#create()
	 */
	public A_Impl() {
		super();
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.hierarchynames.data.A registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.hierarchynames.data.A unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		internalUnregisterListener(l);
		return this;
	}

	protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
	}

	@Override
	public String jsonType() {
		return A__TYPE;
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		out.beginObject();
		writeFields(out);
		out.endObject();
	}

	/**
	 * Serializes all fields of this instance to the given binary output.
	 *
	 * @param out
	 *        The binary output to write to.
	 * @throws java.io.IOException If writing fails.
	 */
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		// No fields to write, hook for subclasses.
	}

	/** Helper for creating an object of type {@link test.hierarchynames.data.A} from a polymorphic composition. */
	public static test.hierarchynames.data.A readA_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.hierarchynames.data.impl.A_Impl result = new A_Impl();
		result.readContent(in);
		return result;
	}

	/** Helper for reading all fields of this instance. */
	protected final void readContent(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		while (in.hasNext()) {
			int field = in.nextName();
			readField(in, field);
		}
	}

	/** Consumes the value for the field with the given ID and assigns its value. */
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			default: in.skipValue(); 
		}
	}

	/** XML element name representing a {@link test.hierarchynames.data.A} type. */
	public static final String A__XML_ELEMENT = "a";

	@Override
	public String getXmlTagName() {
		return A__XML_ELEMENT;
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

	/** Creates a new {@link test.hierarchynames.data.A} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static A_Impl readA_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		A_Impl result = new A_Impl();
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
