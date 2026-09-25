package test.hierarchynames.data.impl;

/**
 * Implementation of {@link test.hierarchynames.data.B}.
 */
public class B_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.hierarchynames.data.B {
	/**
	 * Implementation of {@link test.hierarchynames.data.B.Item}.
	 */
	public static class Item_Impl extends test.hierarchynames.data.impl.Msg_Impl implements test.hierarchynames.data.B.Item {

		private int _b = 0;

		/**
		 * Creates a {@link Item_Impl} instance.
		 *
		 * @see test.hierarchynames.data.B.Item#create()
		 */
		public Item_Impl() {
			super();
		}

		@Override
		public final int getB() {
			return _b;
		}

		@Override
		public test.hierarchynames.data.B.Item setB(int value) {
			internalSetB(value);
			return this;
		}

		/** Internal setter for {@link #getB()} without chain call utility. */
		protected final void internalSetB(int value) {
			_listener.beforeSet(this, B__PROP, value);
			_b = value;
			_listener.afterChanged(this, B__PROP);
		}

		@Override
		public String jsonType() {
			return ITEM__TYPE;
		}

		static final java.util.List<String> PROPERTIES;
		static {
			java.util.List<String> local = java.util.Arrays.asList(
				B__PROP);
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
				case B__PROP: return getB();
				default: return super.get(field);
			}
		}

		@Override
		public void set(String field, Object value) {
			switch (field) {
				case B__PROP: internalSetB((int) value); break;
				default: super.set(field, value); break;
			}
		}

		@Override
		protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
			super.writeFields(out);
			out.name(B__PROP);
			out.value(getB());
		}

		@Override
		protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
			switch (field) {
				case B__PROP: setB(in.nextInt()); break;
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
			out.name(B__ID);
			out.value(getB());
		}

		/** Helper for creating an object of type {@link test.hierarchynames.data.B.Item} from a polymorphic composition. */
		public static test.hierarchynames.data.B.Item readItem_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			test.hierarchynames.data.impl.B_Impl.Item_Impl result = new Item_Impl();
			result.readContent(in);
			return result;
		}

		@Override
		protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
			switch (field) {
				case B__ID: setB(in.nextInt()); break;
				default: super.readField(in, field);
			}
		}

		/** XML element name representing a {@link test.hierarchynames.data.B.Item} type. */
		public static final String ITEM__XML_ELEMENT = "item";

		/** XML attribute or element name of a {@link #getB} property. */
		private static final String B__XML_ATTR = "b";

		@Override
		public String getXmlTagName() {
			return ITEM__XML_ELEMENT;
		}

		/** Serializes all fields that are written as XML attributes. */
		@Override
		protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
			super.writeAttributes(out);
			out.writeAttribute(B__XML_ATTR, Integer.toString(getB()));
		}

		/** Serializes all fields that are written as XML elements. */
		@Override
		protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
			super.writeElements(out);
			// No element fields.
		}

		/** Creates a new {@link test.hierarchynames.data.B.Item} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Item_Impl readItem_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			Item_Impl result = new Item_Impl();
			result.readContentXml(in);
			return result;
		}

		@Override
		protected void readFieldXmlAttribute(String name, String value) {
			switch (name) {
				case B__XML_ATTR: {
					setB(Integer.parseInt(value));
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
				case B__XML_ATTR: {
					setB(Integer.parseInt(in.getElementText()));
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
	 * Creates a {@link B_Impl} instance.
	 *
	 * @see test.hierarchynames.data.B#create()
	 */
	public B_Impl() {
		super();
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.hierarchynames.data.B registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.hierarchynames.data.B unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		internalUnregisterListener(l);
		return this;
	}

	protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
	}

	@Override
	public String jsonType() {
		return B__TYPE;
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

	/** Helper for creating an object of type {@link test.hierarchynames.data.B} from a polymorphic composition. */
	public static test.hierarchynames.data.B readB_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.hierarchynames.data.impl.B_Impl result = new B_Impl();
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

	/** XML element name representing a {@link test.hierarchynames.data.B} type. */
	public static final String B__XML_ELEMENT = "b";

	@Override
	public String getXmlTagName() {
		return B__XML_ELEMENT;
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

	/** Creates a new {@link test.hierarchynames.data.B} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static B_Impl readB_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		B_Impl result = new B_Impl();
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
