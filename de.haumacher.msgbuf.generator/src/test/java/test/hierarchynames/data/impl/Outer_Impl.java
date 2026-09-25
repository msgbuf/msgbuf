package test.hierarchynames.data.impl;

/**
 * Implementation of {@link test.hierarchynames.data.Outer}.
 */
public class Outer_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.hierarchynames.data.Outer {
	/**
	 * Implementation of {@link test.hierarchynames.data.Outer.Item}.
	 */
	public static class Item_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.hierarchynames.data.Outer.Item {

		private String _other = "";

		/**
		 * Creates a {@link Item_Impl} instance.
		 *
		 * @see test.hierarchynames.data.Outer.Item#create()
		 */
		public Item_Impl() {
			super();
		}

		@Override
		public final String getOther() {
			return _other;
		}

		@Override
		public test.hierarchynames.data.Outer.Item setOther(String value) {
			internalSetOther(value);
			return this;
		}

		/** Internal setter for {@link #getOther()} without chain call utility. */
		protected final void internalSetOther(String value) {
			_listener.beforeSet(this, OTHER__PROP, value);
			_other = value;
			_listener.afterChanged(this, OTHER__PROP);
		}

		protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

		@Override
		public test.hierarchynames.data.Outer.Item registerListener(de.haumacher.msgbuf.observer.Listener l) {
			internalRegisterListener(l);
			return this;
		}

		protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
			_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
		}

		@Override
		public test.hierarchynames.data.Outer.Item unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
			internalUnregisterListener(l);
			return this;
		}

		protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
			_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
		}

		@Override
		public String jsonType() {
			return ITEM__TYPE;
		}

		static final java.util.List<String> PROPERTIES;
		static {
			java.util.List<String> local = java.util.Arrays.asList(
				OTHER__PROP);
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
				case OTHER__PROP: return getOther();
				default: return test.hierarchynames.data.Outer.Item.super.get(field);
			}
		}

		@Override
		public void set(String field, Object value) {
			switch (field) {
				case OTHER__PROP: internalSetOther((String) value); break;
			}
		}

		@Override
		public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
			writeContent(out);
		}

		@Override
		protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
			super.writeFields(out);
			out.name(OTHER__PROP);
			out.value(getOther());
		}

		@Override
		protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
			switch (field) {
				case OTHER__PROP: setOther(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
				default: super.readField(in, field);
			}
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
			out.name(OTHER__ID);
			out.value(getOther());
		}

		/** Helper for creating an object of type {@link test.hierarchynames.data.Outer.Item} from a polymorphic composition. */
		public static test.hierarchynames.data.Outer.Item readItem_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			test.hierarchynames.data.impl.Outer_Impl.Item_Impl result = new Item_Impl();
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
				case OTHER__ID: setOther(in.nextString()); break;
				default: in.skipValue(); 
			}
		}

		/** XML element name representing a {@link test.hierarchynames.data.Outer.Item} type. */
		public static final String ITEM__XML_ELEMENT = "item";

		/** XML attribute or element name of a {@link #getOther} property. */
		private static final String OTHER__XML_ATTR = "other";

		@Override
		public String getXmlTagName() {
			return ITEM__XML_ELEMENT;
		}

		@Override
		public final void writeContent(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
			writeAttributes(out);
			writeElements(out);
		}

		/** Serializes all fields that are written as XML attributes. */
		protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
			out.writeAttribute(OTHER__XML_ATTR, getOther());
		}

		/** Serializes all fields that are written as XML elements. */
		protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
			// No element fields.
		}

		/** Creates a new {@link test.hierarchynames.data.Outer.Item} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Item_Impl readItem_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			Item_Impl result = new Item_Impl();
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
				case OTHER__XML_ATTR: {
					setOther(value);
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
				case OTHER__XML_ATTR: {
					setOther(in.getElementText());
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
	 * Implementation of {@link test.hierarchynames.data.Outer.Shape}.
	 */
	public static abstract class Shape_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.hierarchynames.data.Outer.Shape {

		/**
		 * Creates a {@link Shape_Impl} instance.
		 */
		public Shape_Impl() {
			super();
		}

		protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

		@Override
		public test.hierarchynames.data.Outer.Shape registerListener(de.haumacher.msgbuf.observer.Listener l) {
			internalRegisterListener(l);
			return this;
		}

		protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
			_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
		}

		@Override
		public test.hierarchynames.data.Outer.Shape unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
			internalUnregisterListener(l);
			return this;
		}

		protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
			_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
		}

		@Override
		public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
			out.beginArray();
			out.value(jsonType());
			writeContent(out);
			out.endArray();
		}

		@Override
		public final void writeTo(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
			out.beginObject();
			out.name(0);
			out.value(typeId());
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

		/** XML element name representing a {@link test.hierarchynames.data.Outer.Shape} type. */
		public static final String SHAPE__XML_ELEMENT = "shape";

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

		/** Creates a new {@link test.hierarchynames.data.Outer.Shape} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Shape_Impl readShape_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			switch (in.getLocalName()) {
				case test.hierarchynames.data.impl.Item_Impl.ITEM__XML_ELEMENT: {
					return test.hierarchynames.data.impl.Item_Impl.readItem_XmlContent(in);
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

	/**
	 * Creates a {@link Outer_Impl} instance.
	 *
	 * @see test.hierarchynames.data.Outer#create()
	 */
	public Outer_Impl() {
		super();
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.hierarchynames.data.Outer registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.hierarchynames.data.Outer unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		internalUnregisterListener(l);
		return this;
	}

	protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
	}

	@Override
	public String jsonType() {
		return OUTER__TYPE;
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

	/** Helper for creating an object of type {@link test.hierarchynames.data.Outer} from a polymorphic composition. */
	public static test.hierarchynames.data.Outer readOuter_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.hierarchynames.data.impl.Outer_Impl result = new Outer_Impl();
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

	/** XML element name representing a {@link test.hierarchynames.data.Outer} type. */
	public static final String OUTER__XML_ELEMENT = "outer";

	@Override
	public String getXmlTagName() {
		return OUTER__XML_ELEMENT;
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

	/** Creates a new {@link test.hierarchynames.data.Outer} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Outer_Impl readOuter_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		Outer_Impl result = new Outer_Impl();
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
