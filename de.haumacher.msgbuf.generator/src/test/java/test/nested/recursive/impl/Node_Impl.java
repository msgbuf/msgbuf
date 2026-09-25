package test.nested.recursive.impl;

/**
 * Implementation of {@link test.nested.recursive.Node}.
 */
public class Node_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.nested.recursive.Node {
	/**
	 * Implementation of {@link test.nested.recursive.Node.Special}.
	 */
	public static class Special_Impl extends test.nested.recursive.impl.Node_Impl implements test.nested.recursive.Node.Special {

		private int _weight = 0;

		/**
		 * Creates a {@link Special_Impl} instance.
		 *
		 * @see test.nested.recursive.Node.Special#create()
		 */
		public Special_Impl() {
			super();
		}

		@Override
		public TypeKind kind() {
			return TypeKind.SPECIAL;
		}

		@Override
		public final int getWeight() {
			return _weight;
		}

		@Override
		public test.nested.recursive.Node.Special setWeight(int value) {
			internalSetWeight(value);
			return this;
		}

		/** Internal setter for {@link #getWeight()} without chain call utility. */
		protected final void internalSetWeight(int value) {
			_listener.beforeSet(this, WEIGHT__PROP, value);
			_weight = value;
			_listener.afterChanged(this, WEIGHT__PROP);
		}

		@Override
		public test.nested.recursive.Node.Special setName(String value) {
			internalSetName(value);
			return this;
		}

		@Override
		public test.nested.recursive.Node.Special setChildren(java.util.List<? extends test.nested.recursive.Node> value) {
			internalSetChildren(value);
			return this;
		}

		@Override
		public test.nested.recursive.Node.Special addChildren(test.nested.recursive.Node value) {
			internalAddChildren(value);
			return this;
		}

		@Override
		public String jsonType() {
			return SPECIAL__TYPE;
		}

		@SuppressWarnings("hiding")
		static final java.util.List<String> PROPERTIES;
		static {
			java.util.List<String> local = java.util.Arrays.asList(
				WEIGHT__PROP);
			java.util.List<String> tmp = new java.util.ArrayList<>();
			tmp.addAll(test.nested.recursive.impl.Node_Impl.PROPERTIES);
			tmp.addAll(local);
			PROPERTIES = java.util.Collections.unmodifiableList(tmp);
		}

		@SuppressWarnings("hiding")
		static final java.util.Set<String> TRANSIENT_PROPERTIES;
		static {
			java.util.HashSet<String> tmp = new java.util.HashSet<>();
			tmp.addAll(test.nested.recursive.impl.Node_Impl.TRANSIENT_PROPERTIES);
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
				case WEIGHT__PROP: return getWeight();
				default: return super.get(field);
			}
		}

		@Override
		public void set(String field, Object value) {
			switch (field) {
				case WEIGHT__PROP: internalSetWeight((int) value); break;
				default: super.set(field, value); break;
			}
		}

		@Override
		protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
			super.writeFields(out);
			out.name(WEIGHT__PROP);
			out.value(getWeight());
		}

		@Override
		protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
			switch (field) {
				case WEIGHT__PROP: setWeight(in.nextInt()); break;
				default: super.readField(in, field);
			}
		}

		@Override
		protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
			super.writeFields(out);
			out.name(WEIGHT__ID);
			out.value(getWeight());
		}

		/** Helper for creating an object of type {@link test.nested.recursive.Node.Special} from a polymorphic composition. */
		public static test.nested.recursive.Node.Special readSpecial_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			test.nested.recursive.impl.Node_Impl.Special_Impl result = new Special_Impl();
			result.readContent(in);
			return result;
		}

		@Override
		protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
			switch (field) {
				case WEIGHT__ID: setWeight(in.nextInt()); break;
				default: super.readField(in, field);
			}
		}

		/** XML element name representing a {@link test.nested.recursive.Node.Special} type. */
		public static final String SPECIAL__XML_ELEMENT = "special";

		/** XML attribute or element name of a {@link #getWeight} property. */
		private static final String WEIGHT__XML_ATTR = "weight";

		@Override
		public String getXmlTagName() {
			return SPECIAL__XML_ELEMENT;
		}

		/** Serializes all fields that are written as XML attributes. */
		@Override
		protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
			super.writeAttributes(out);
			out.writeAttribute(WEIGHT__XML_ATTR, Integer.toString(getWeight()));
		}

		/** Serializes all fields that are written as XML elements. */
		@Override
		protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
			super.writeElements(out);
			// No element fields.
		}

		/** Creates a new {@link test.nested.recursive.Node.Special} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Special_Impl readSpecial_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			Special_Impl result = new Special_Impl();
			result.readContentXml(in);
			return result;
		}

		@Override
		protected void readFieldXmlAttribute(String name, String value) {
			switch (name) {
				case WEIGHT__XML_ATTR: {
					setWeight(Integer.parseInt(value));
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
				case WEIGHT__XML_ATTR: {
					setWeight(Integer.parseInt(in.getElementText()));
					break;
				}
				default: {
					super.readFieldXmlElement(in, localName);
				}
			}
		}

	}

	private String _name = "";

	private final java.util.List<test.nested.recursive.Node> _children = new de.haumacher.msgbuf.util.ReferenceList<test.nested.recursive.Node>() {
		@Override
		protected void beforeAdd(int index, test.nested.recursive.Node element) {
			_listener.beforeAdd(Node_Impl.this, CHILDREN__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, test.nested.recursive.Node element) {
			_listener.afterRemove(Node_Impl.this, CHILDREN__PROP, index, element);
		}

		@Override
		protected void afterChanged() {
			_listener.afterChanged(Node_Impl.this, CHILDREN__PROP);
		}
	};

	/**
	 * Creates a {@link Node_Impl} instance.
	 *
	 * @see test.nested.recursive.Node#create()
	 */
	public Node_Impl() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.NODE;
	}

	@Override
	public final String getName() {
		return _name;
	}

	@Override
	public test.nested.recursive.Node setName(String value) {
		internalSetName(value);
		return this;
	}

	/** Internal setter for {@link #getName()} without chain call utility. */
	protected final void internalSetName(String value) {
		_listener.beforeSet(this, NAME__PROP, value);
		_name = value;
		_listener.afterChanged(this, NAME__PROP);
	}

	@Override
	public final java.util.List<test.nested.recursive.Node> getChildren() {
		return _children;
	}

	@Override
	public test.nested.recursive.Node setChildren(java.util.List<? extends test.nested.recursive.Node> value) {
		internalSetChildren(value);
		return this;
	}

	/** Internal setter for {@link #getChildren()} without chain call utility. */
	protected final void internalSetChildren(java.util.List<? extends test.nested.recursive.Node> value) {
		if (value == null) throw new IllegalArgumentException("Property 'children' cannot be null.");
		_children.clear();
		_children.addAll(value);
	}

	@Override
	public test.nested.recursive.Node addChildren(test.nested.recursive.Node value) {
		internalAddChildren(value);
		return this;
	}

	/** Implementation of {@link #addChildren(test.nested.recursive.Node)} without chain call utility. */
	protected final void internalAddChildren(test.nested.recursive.Node value) {
		_children.add(value);
	}

	@Override
	public final void removeChildren(test.nested.recursive.Node value) {
		_children.remove(value);
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.nested.recursive.Node registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.nested.recursive.Node unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		internalUnregisterListener(l);
		return this;
	}

	protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
	}

	@Override
	public String jsonType() {
		return NODE__TYPE;
	}

	static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			NAME__PROP, 
			CHILDREN__PROP);
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
			case NAME__PROP: return getName();
			case CHILDREN__PROP: return getChildren();
			default: return test.nested.recursive.Node.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case NAME__PROP: internalSetName((String) value); break;
			case CHILDREN__PROP: internalSetChildren(de.haumacher.msgbuf.util.Conversions.asList(test.nested.recursive.Node.class, value)); break;
		}
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(NAME__PROP);
		out.value(getName());
		out.name(CHILDREN__PROP);
		out.beginArray();
		for (test.nested.recursive.Node x : getChildren()) {
			x.writeTo(out);
		}
		out.endArray();
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case NAME__PROP: setName(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			case CHILDREN__PROP: {
				java.util.List<test.nested.recursive.Node> newValue = new java.util.ArrayList<>();
				in.beginArray();
				while (in.hasNext()) {
					newValue.add(test.nested.recursive.Node.readNode(in));
				}
				in.endArray();
				setChildren(newValue);
			}
			break;
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
		out.name(NAME__ID);
		out.value(getName());
		out.name(CHILDREN__ID);
		{
			java.util.List<test.nested.recursive.Node> values = getChildren();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.OBJECT, values.size());
			for (test.nested.recursive.Node x : values) {
				x.writeTo(out);
			}
			out.endArray();
		}
	}

	/** Helper for creating an object of type {@link test.nested.recursive.Node} from a polymorphic composition. */
	public static test.nested.recursive.Node readNode_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.nested.recursive.impl.Node_Impl result = new Node_Impl();
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
			case NAME__ID: setName(in.nextString()); break;
			case CHILDREN__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addChildren(test.nested.recursive.Node.readNode(in));
				}
				in.endArray();
			}
			break;
			default: in.skipValue(); 
		}
	}

	/** XML element name representing a {@link test.nested.recursive.Node} type. */
	public static final String NODE__XML_ELEMENT = "node";

	/** XML attribute or element name of a {@link #getName} property. */
	private static final String NAME__XML_ATTR = "name";

	/** XML attribute or element name of a {@link #getChildren} property. */
	private static final String CHILDREN__XML_ATTR = "children";

	@Override
	public String getXmlTagName() {
		return NODE__XML_ELEMENT;
	}

	@Override
	public final void writeContent(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		writeAttributes(out);
		writeElements(out);
	}

	/** Serializes all fields that are written as XML attributes. */
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		out.writeAttribute(NAME__XML_ATTR, getName());
	}

	/** Serializes all fields that are written as XML elements. */
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		out.writeStartElement(CHILDREN__XML_ATTR);
		for (test.nested.recursive.Node element : getChildren()) {
			element.writeTo(out);
		}
		out.writeEndElement();
	}

	/** Creates a new {@link test.nested.recursive.Node} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Node_Impl readNode_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		Node_Impl result = new Node_Impl();
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
			case NAME__XML_ATTR: {
				setName(value);
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
			case NAME__XML_ATTR: {
				setName(in.getElementText());
				break;
			}
			case CHILDREN__XML_ATTR: {
				internalReadChildrenListXml(in);
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

	private void internalReadChildrenListXml(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		while (true) {
			int event = in.nextTag();
			if (event == javax.xml.stream.XMLStreamConstants.END_ELEMENT) {
				break;
			}

			addChildren(test.nested.recursive.impl.Node_Impl.readNode_XmlContent(in));
		}
	}

}
