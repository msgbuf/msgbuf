package test.openworld.deep.ext1.impl;

/**
 * Implementation of {@link test.openworld.deep.ext1.Forest}.
 */
public class Forest_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.openworld.deep.ext1.Forest {
	/**
	 * Implementation of {@link test.openworld.deep.ext1.Forest.Oak}.
	 */
	public static class Oak_Impl extends test.openworld.deep.base.impl.Habitat_Impl.Tree_Impl implements test.openworld.deep.ext1.Forest.Oak {

		private int _age = 0;

		/**
		 * Creates a {@link Oak_Impl} instance.
		 *
		 * @see test.openworld.deep.ext1.Forest.Oak#create()
		 */
		public Oak_Impl() {
			super();
		}

		@Override
		public TypeKind kind() {
			return null;
		}

		@Override
		public final int getAge() {
			return _age;
		}

		@Override
		public test.openworld.deep.ext1.Forest.Oak setAge(int value) {
			internalSetAge(value);
			return this;
		}

		/** Internal setter for {@link #getAge()} without chain call utility. */
		protected final void internalSetAge(int value) {
			_listener.beforeSet(this, AGE__PROP, value);
			_age = value;
			_listener.afterChanged(this, AGE__PROP);
		}

		@Override
		public test.openworld.deep.ext1.Forest.Oak setHeight(int value) {
			internalSetHeight(value);
			return this;
		}

		@Override
		public test.openworld.deep.ext1.Forest.Oak setSpecies(String value) {
			internalSetSpecies(value);
			return this;
		}

		@Override
		public String jsonType() {
			return OAK__TYPE;
		}

		@SuppressWarnings("hiding")
		protected static final java.util.List<String> PROPERTIES;
		static {
			java.util.List<String> local = java.util.Arrays.asList(
				AGE__PROP);
			java.util.List<String> tmp = new java.util.ArrayList<>();
			tmp.addAll(test.openworld.deep.base.impl.Habitat_Impl.Tree_Impl.PROPERTIES);
			tmp.addAll(local);
			PROPERTIES = java.util.Collections.unmodifiableList(tmp);
		}

		@SuppressWarnings("hiding")
		protected static final java.util.Set<String> TRANSIENT_PROPERTIES;
		static {
			java.util.HashSet<String> tmp = new java.util.HashSet<>();
			tmp.addAll(test.openworld.deep.base.impl.Habitat_Impl.Tree_Impl.TRANSIENT_PROPERTIES);
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
				case AGE__PROP: return getAge();
				default: return super.get(field);
			}
		}

		@Override
		public void set(String field, Object value) {
			switch (field) {
				case AGE__PROP: internalSetAge((int) value); break;
				default: super.set(field, value); break;
			}
		}

		@Override
		protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
			super.writeFields(out);
			out.name(AGE__PROP);
			out.value(getAge());
		}

		@Override
		protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
			switch (field) {
				case AGE__PROP: setAge(in.nextInt()); break;
				default: super.readField(in, field);
			}
		}

		/** XML element name representing a {@link test.openworld.deep.ext1.Forest.Oak} type. */
		public static final String OAK__XML_ELEMENT = "oak";

		/** XML attribute or element name of a {@link #getAge} property. */
		private static final String AGE__XML_ATTR = "age";

		@Override
		public String getXmlTagName() {
			return OAK__XML_ELEMENT;
		}

		/** Serializes all fields that are written as XML attributes. */
		@Override
		protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
			super.writeAttributes(out);
			out.writeAttribute(AGE__XML_ATTR, Integer.toString(getAge()));
		}

		/** Serializes all fields that are written as XML elements. */
		@Override
		protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
			super.writeElements(out);
			// No element fields.
		}

		/** Creates a new {@link test.openworld.deep.ext1.Forest.Oak} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Oak_Impl readOak_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			Oak_Impl result = new Oak_Impl();
			result.readContentXml(in);
			return result;
		}

		@Override
		protected void readFieldXmlAttribute(String name, String value) {
			switch (name) {
				case AGE__XML_ATTR: {
					setAge(Integer.parseInt(value));
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
				case AGE__XML_ATTR: {
					setAge(Integer.parseInt(in.getElementText()));
					break;
				}
				default: {
					super.readFieldXmlElement(in, localName);
				}
			}
		}

		@Override
		public <R,A,E extends Throwable> R visit(test.openworld.deep.base.Habitat.Tree.Visitor<R,A,E> v, A arg) throws E {
			if (v instanceof test.openworld.deep.ext1.Forest.Oak.Visitor) {
				return ((test.openworld.deep.ext1.Forest.Oak.Visitor<R,A,E>) v).visit(this, arg);
			}
			return v.visitDefault(this, arg);
		}

	}

	/**
	 * Creates a {@link Forest_Impl} instance.
	 *
	 * @see test.openworld.deep.ext1.Forest#create()
	 */
	public Forest_Impl() {
		super();
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.openworld.deep.ext1.Forest registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.openworld.deep.ext1.Forest unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		internalUnregisterListener(l);
		return this;
	}

	protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
	}

	@Override
	public String jsonType() {
		return FOREST__TYPE;
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	/** XML element name representing a {@link test.openworld.deep.ext1.Forest} type. */
	public static final String FOREST__XML_ELEMENT = "forest";

	@Override
	public String getXmlTagName() {
		return FOREST__XML_ELEMENT;
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

	/** Creates a new {@link test.openworld.deep.ext1.Forest} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Forest_Impl readForest_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		Forest_Impl result = new Forest_Impl();
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
