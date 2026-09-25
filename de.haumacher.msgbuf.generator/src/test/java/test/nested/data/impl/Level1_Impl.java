package test.nested.data.impl;

/**
 * Implementation of {@link test.nested.data.Level1}.
 */
public class Level1_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.nested.data.Level1 {
	/**
	 * Implementation of {@link test.nested.data.Level1.Level2}.
	 */
	public static class Level2_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.nested.data.Level1.Level2 {
		/**
		 * Implementation of {@link test.nested.data.Level1.Level2.Node}.
		 */
		public static abstract class Node_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.nested.data.Level1.Level2.Node {

			private String _label = "";

			/**
			 * Creates a {@link Node_Impl} instance.
			 */
			public Node_Impl() {
				super();
			}

			@Override
			public final String getLabel() {
				return _label;
			}

			@Override
			public test.nested.data.Level1.Level2.Node setLabel(String value) {
				internalSetLabel(value);
				return this;
			}

			/** Internal setter for {@link #getLabel()} without chain call utility. */
			protected final void internalSetLabel(String value) {
				_listener.beforeSet(this, LABEL__PROP, value);
				_label = value;
				_listener.afterChanged(this, LABEL__PROP);
			}

			protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

			@Override
			public test.nested.data.Level1.Level2.Node registerListener(de.haumacher.msgbuf.observer.Listener l) {
				internalRegisterListener(l);
				return this;
			}

			protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
				_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
			}

			@Override
			public test.nested.data.Level1.Level2.Node unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
				internalUnregisterListener(l);
				return this;
			}

			protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
				_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
			}

			static final java.util.List<String> PROPERTIES;
			static {
				java.util.List<String> local = java.util.Arrays.asList(
					LABEL__PROP);
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
					case LABEL__PROP: return getLabel();
					default: return test.nested.data.Level1.Level2.Node.super.get(field);
				}
			}

			@Override
			public void set(String field, Object value) {
				switch (field) {
					case LABEL__PROP: internalSetLabel((String) value); break;
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
				out.name(LABEL__PROP);
				out.value(getLabel());
			}

			@Override
			protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
				switch (field) {
					case LABEL__PROP: setLabel(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
					default: super.readField(in, field);
				}
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
				out.name(LABEL__ID);
				out.value(getLabel());
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
					case LABEL__ID: setLabel(in.nextString()); break;
					default: in.skipValue(); 
				}
			}

			/** XML element name representing a {@link test.nested.data.Level1.Level2.Node} type. */
			public static final String NODE__XML_ELEMENT = "node";

			/** XML attribute or element name of a {@link #getLabel} property. */
			private static final String LABEL__XML_ATTR = "label";

			@Override
			public final void writeContent(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
				writeAttributes(out);
				writeElements(out);
			}

			/** Serializes all fields that are written as XML attributes. */
			protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
				out.writeAttribute(LABEL__XML_ATTR, getLabel());
			}

			/** Serializes all fields that are written as XML elements. */
			protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
				// No element fields.
			}

			/** Creates a new {@link test.nested.data.Level1.Level2.Node} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
			public static Node_Impl readNode_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
				switch (in.getLocalName()) {
					case test.nested.data.impl.Level1_Impl.Level2_Impl.Branch_Impl.BRANCH__XML_ELEMENT: {
						return test.nested.data.impl.Level1_Impl.Level2_Impl.Branch_Impl.readBranch_XmlContent(in);
					}

					case test.nested.data.impl.Level1_Impl.Level2_Impl.Root_Impl.ROOT__XML_ELEMENT: {
						return test.nested.data.impl.Level1_Impl.Level2_Impl.Root_Impl.readRoot_XmlContent(in);
					}

					case test.nested.data.impl.Level1_Impl.Level2_Impl.Leaf_Impl.LEAF__XML_ELEMENT: {
						return test.nested.data.impl.Level1_Impl.Level2_Impl.Leaf_Impl.readLeaf_XmlContent(in);
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
					case LABEL__XML_ATTR: {
						setLabel(value);
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
					case LABEL__XML_ATTR: {
						setLabel(in.getElementText());
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
		 * Implementation of {@link test.nested.data.Level1.Level2.Composite}.
		 */
		public static abstract class Composite_Impl extends test.nested.data.impl.Level1_Impl.Level2_Impl.Node_Impl implements test.nested.data.Level1.Level2.Composite {

			private final java.util.List<test.nested.data.Level1.Level2.Node> _children = new de.haumacher.msgbuf.util.ReferenceList<test.nested.data.Level1.Level2.Node>() {
				@Override
				protected void beforeAdd(int index, test.nested.data.Level1.Level2.Node element) {
					_listener.beforeAdd(Composite_Impl.this, CHILDREN__PROP, index, element);
				}

				@Override
				protected void afterRemove(int index, test.nested.data.Level1.Level2.Node element) {
					_listener.afterRemove(Composite_Impl.this, CHILDREN__PROP, index, element);
				}

				@Override
				protected void afterChanged() {
					_listener.afterChanged(Composite_Impl.this, CHILDREN__PROP);
				}
			};

			/**
			 * Creates a {@link Composite_Impl} instance.
			 */
			public Composite_Impl() {
				super();
			}

			@Override
			public final java.util.List<test.nested.data.Level1.Level2.Node> getChildren() {
				return _children;
			}

			@Override
			public test.nested.data.Level1.Level2.Composite setChildren(java.util.List<? extends test.nested.data.Level1.Level2.Node> value) {
				internalSetChildren(value);
				return this;
			}

			/** Internal setter for {@link #getChildren()} without chain call utility. */
			protected final void internalSetChildren(java.util.List<? extends test.nested.data.Level1.Level2.Node> value) {
				if (value == null) throw new IllegalArgumentException("Property 'children' cannot be null.");
				_children.clear();
				_children.addAll(value);
			}

			@Override
			public test.nested.data.Level1.Level2.Composite addChildren(test.nested.data.Level1.Level2.Node value) {
				internalAddChildren(value);
				return this;
			}

			/** Implementation of {@link #addChildren(test.nested.data.Level1.Level2.Node)} without chain call utility. */
			protected final void internalAddChildren(test.nested.data.Level1.Level2.Node value) {
				_children.add(value);
			}

			@Override
			public final void removeChildren(test.nested.data.Level1.Level2.Node value) {
				_children.remove(value);
			}

			@Override
			public test.nested.data.Level1.Level2.Composite setLabel(String value) {
				internalSetLabel(value);
				return this;
			}

			@SuppressWarnings("hiding")
			static final java.util.List<String> PROPERTIES;
			static {
				java.util.List<String> local = java.util.Arrays.asList(
					CHILDREN__PROP);
				java.util.List<String> tmp = new java.util.ArrayList<>();
				tmp.addAll(test.nested.data.impl.Level1_Impl.Level2_Impl.Node_Impl.PROPERTIES);
				tmp.addAll(local);
				PROPERTIES = java.util.Collections.unmodifiableList(tmp);
			}

			@SuppressWarnings("hiding")
			static final java.util.Set<String> TRANSIENT_PROPERTIES;
			static {
				java.util.HashSet<String> tmp = new java.util.HashSet<>();
				tmp.addAll(test.nested.data.impl.Level1_Impl.Level2_Impl.Node_Impl.TRANSIENT_PROPERTIES);
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
					case CHILDREN__PROP: return getChildren();
					default: return super.get(field);
				}
			}

			@Override
			public void set(String field, Object value) {
				switch (field) {
					case CHILDREN__PROP: internalSetChildren(de.haumacher.msgbuf.util.Conversions.asList(test.nested.data.Level1.Level2.Node.class, value)); break;
					default: super.set(field, value); break;
				}
			}

			@Override
			protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
				super.writeFields(out);
				out.name(CHILDREN__PROP);
				out.beginArray();
				for (test.nested.data.Level1.Level2.Node x : getChildren()) {
					x.writeTo(out);
				}
				out.endArray();
			}

			@Override
			protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
				switch (field) {
					case CHILDREN__PROP: {
						java.util.List<test.nested.data.Level1.Level2.Node> newValue = new java.util.ArrayList<>();
						in.beginArray();
						while (in.hasNext()) {
							newValue.add(test.nested.data.Level1.Level2.Node.readNode(in));
						}
						in.endArray();
						setChildren(newValue);
					}
					break;
					default: super.readField(in, field);
				}
			}

			@Override
			protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
				super.writeFields(out);
				out.name(CHILDREN__ID);
				{
					java.util.List<test.nested.data.Level1.Level2.Node> values = getChildren();
					out.beginArray(de.haumacher.msgbuf.binary.DataType.OBJECT, values.size());
					for (test.nested.data.Level1.Level2.Node x : values) {
						x.writeTo(out);
					}
					out.endArray();
				}
			}

			@Override
			protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
				switch (field) {
					case CHILDREN__ID: {
						in.beginArray();
						while (in.hasNext()) {
							addChildren(test.nested.data.Level1.Level2.Node.readNode(in));
						}
						in.endArray();
					}
					break;
					default: super.readField(in, field);
				}
			}

			/** XML element name representing a {@link test.nested.data.Level1.Level2.Composite} type. */
			public static final String COMPOSITE__XML_ELEMENT = "composite";

			/** XML attribute or element name of a {@link #getChildren} property. */
			private static final String CHILDREN__XML_ATTR = "children";

			/** Serializes all fields that are written as XML attributes. */
			@Override
			protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
				super.writeAttributes(out);
			}

			/** Serializes all fields that are written as XML elements. */
			@Override
			protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
				super.writeElements(out);
				out.writeStartElement(CHILDREN__XML_ATTR);
				for (test.nested.data.Level1.Level2.Node element : getChildren()) {
					element.writeTo(out);
				}
				out.writeEndElement();
			}

			/** Creates a new {@link test.nested.data.Level1.Level2.Composite} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
			public static Composite_Impl readComposite_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
				switch (in.getLocalName()) {
					case test.nested.data.impl.Level1_Impl.Level2_Impl.Branch_Impl.BRANCH__XML_ELEMENT: {
						return test.nested.data.impl.Level1_Impl.Level2_Impl.Branch_Impl.readBranch_XmlContent(in);
					}

					case test.nested.data.impl.Level1_Impl.Level2_Impl.Root_Impl.ROOT__XML_ELEMENT: {
						return test.nested.data.impl.Level1_Impl.Level2_Impl.Root_Impl.readRoot_XmlContent(in);
					}

					default: {
						internalSkipUntilMatchingEndElement(in);
						return null;
					}
				}
			}

			@Override
			protected void readFieldXmlAttribute(String name, String value) {
				switch (name) {
					default: {
						super.readFieldXmlAttribute(name, value);
					}
				}
			}

			@Override
			protected void readFieldXmlElement(javax.xml.stream.XMLStreamReader in, String localName) throws javax.xml.stream.XMLStreamException {
				switch (localName) {
					case CHILDREN__XML_ATTR: {
						internalReadChildrenListXml(in);
						break;
					}
					default: {
						super.readFieldXmlElement(in, localName);
					}
				}
			}

			private void internalReadChildrenListXml(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
				while (true) {
					int event = in.nextTag();
					if (event == javax.xml.stream.XMLStreamConstants.END_ELEMENT) {
						break;
					}

					addChildren(test.nested.data.impl.Level1_Impl.Level2_Impl.Node_Impl.readNode_XmlContent(in));
				}
			}

			@Override
			public final <R,A,E extends Throwable> R visit(test.nested.data.Level1.Level2.Node.Visitor<R,A,E> v, A arg) throws E {
				return visit((test.nested.data.Level1.Level2.Composite.Visitor<R,A,E>) v, arg);
			}

		}
		/**
		 * Implementation of {@link test.nested.data.Level1.Level2.Leaf}.
		 */
		public static class Leaf_Impl extends test.nested.data.impl.Level1_Impl.Level2_Impl.Node_Impl implements test.nested.data.Level1.Level2.Leaf {

			private int _value = 0;

			/**
			 * Creates a {@link Leaf_Impl} instance.
			 *
			 * @see test.nested.data.Level1.Level2.Leaf#create()
			 */
			public Leaf_Impl() {
				super();
			}

			@Override
			public TypeKind kind() {
				return TypeKind.LEAF;
			}

			@Override
			public final int getValue() {
				return _value;
			}

			@Override
			public test.nested.data.Level1.Level2.Leaf setValue(int value) {
				internalSetValue(value);
				return this;
			}

			/** Internal setter for {@link #getValue()} without chain call utility. */
			protected final void internalSetValue(int value) {
				_listener.beforeSet(this, VALUE__PROP, value);
				_value = value;
				_listener.afterChanged(this, VALUE__PROP);
			}

			@Override
			public test.nested.data.Level1.Level2.Leaf setLabel(String value) {
				internalSetLabel(value);
				return this;
			}

			@Override
			public String jsonType() {
				return LEAF__TYPE;
			}

			@SuppressWarnings("hiding")
			static final java.util.List<String> PROPERTIES;
			static {
				java.util.List<String> local = java.util.Arrays.asList(
					VALUE__PROP);
				java.util.List<String> tmp = new java.util.ArrayList<>();
				tmp.addAll(test.nested.data.impl.Level1_Impl.Level2_Impl.Node_Impl.PROPERTIES);
				tmp.addAll(local);
				PROPERTIES = java.util.Collections.unmodifiableList(tmp);
			}

			@SuppressWarnings("hiding")
			static final java.util.Set<String> TRANSIENT_PROPERTIES;
			static {
				java.util.HashSet<String> tmp = new java.util.HashSet<>();
				tmp.addAll(test.nested.data.impl.Level1_Impl.Level2_Impl.Node_Impl.TRANSIENT_PROPERTIES);
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
					case VALUE__PROP: return getValue();
					default: return super.get(field);
				}
			}

			@Override
			public void set(String field, Object value) {
				switch (field) {
					case VALUE__PROP: internalSetValue((int) value); break;
					default: super.set(field, value); break;
				}
			}

			@Override
			protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
				super.writeFields(out);
				out.name(VALUE__PROP);
				out.value(getValue());
			}

			@Override
			protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
				switch (field) {
					case VALUE__PROP: setValue(in.nextInt()); break;
					default: super.readField(in, field);
				}
			}

			@Override
			public int typeId() {
				return LEAF__TYPE_ID;
			}

			@Override
			protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
				super.writeFields(out);
				out.name(VALUE__ID);
				out.value(getValue());
			}

			/** Helper for creating an object of type {@link test.nested.data.Level1.Level2.Leaf} from a polymorphic composition. */
			public static test.nested.data.Level1.Level2.Leaf readLeaf_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
				test.nested.data.impl.Level1_Impl.Level2_Impl.Leaf_Impl result = new Leaf_Impl();
				result.readContent(in);
				return result;
			}

			@Override
			protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
				switch (field) {
					case VALUE__ID: setValue(in.nextInt()); break;
					default: super.readField(in, field);
				}
			}

			/** XML element name representing a {@link test.nested.data.Level1.Level2.Leaf} type. */
			public static final String LEAF__XML_ELEMENT = "leaf";

			/** XML attribute or element name of a {@link #getValue} property. */
			private static final String VALUE__XML_ATTR = "value";

			@Override
			public String getXmlTagName() {
				return LEAF__XML_ELEMENT;
			}

			/** Serializes all fields that are written as XML attributes. */
			@Override
			protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
				super.writeAttributes(out);
				out.writeAttribute(VALUE__XML_ATTR, Integer.toString(getValue()));
			}

			/** Serializes all fields that are written as XML elements. */
			@Override
			protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
				super.writeElements(out);
				// No element fields.
			}

			/** Creates a new {@link test.nested.data.Level1.Level2.Leaf} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
			public static Leaf_Impl readLeaf_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
				Leaf_Impl result = new Leaf_Impl();
				result.readContentXml(in);
				return result;
			}

			@Override
			protected void readFieldXmlAttribute(String name, String value) {
				switch (name) {
					case VALUE__XML_ATTR: {
						setValue(Integer.parseInt(value));
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
					case VALUE__XML_ATTR: {
						setValue(Integer.parseInt(in.getElementText()));
						break;
					}
					default: {
						super.readFieldXmlElement(in, localName);
					}
				}
			}

			@Override
			public <R,A,E extends Throwable> R visit(test.nested.data.Level1.Level2.Node.Visitor<R,A,E> v, A arg) throws E {
				return v.visit(this, arg);
			}

		}
		/**
		 * Implementation of {@link test.nested.data.Level1.Level2.Branch}.
		 */
		public static class Branch_Impl extends test.nested.data.impl.Level1_Impl.Level2_Impl.Composite_Impl implements test.nested.data.Level1.Level2.Branch {

			private boolean _expanded = false;

			/**
			 * Creates a {@link Branch_Impl} instance.
			 *
			 * @see test.nested.data.Level1.Level2.Branch#create()
			 */
			public Branch_Impl() {
				super();
			}

			@Override
			public TypeKind kind() {
				return TypeKind.BRANCH;
			}

			@Override
			public final boolean isExpanded() {
				return _expanded;
			}

			@Override
			public test.nested.data.Level1.Level2.Branch setExpanded(boolean value) {
				internalSetExpanded(value);
				return this;
			}

			/** Internal setter for {@link #isExpanded()} without chain call utility. */
			protected final void internalSetExpanded(boolean value) {
				_listener.beforeSet(this, EXPANDED__PROP, value);
				_expanded = value;
				_listener.afterChanged(this, EXPANDED__PROP);
			}

			@Override
			public test.nested.data.Level1.Level2.Branch setChildren(java.util.List<? extends test.nested.data.Level1.Level2.Node> value) {
				internalSetChildren(value);
				return this;
			}

			@Override
			public test.nested.data.Level1.Level2.Branch addChildren(test.nested.data.Level1.Level2.Node value) {
				internalAddChildren(value);
				return this;
			}

			@Override
			public test.nested.data.Level1.Level2.Branch setLabel(String value) {
				internalSetLabel(value);
				return this;
			}

			@Override
			public String jsonType() {
				return BRANCH__TYPE;
			}

			@SuppressWarnings("hiding")
			static final java.util.List<String> PROPERTIES;
			static {
				java.util.List<String> local = java.util.Arrays.asList(
					EXPANDED__PROP);
				java.util.List<String> tmp = new java.util.ArrayList<>();
				tmp.addAll(test.nested.data.impl.Level1_Impl.Level2_Impl.Composite_Impl.PROPERTIES);
				tmp.addAll(local);
				PROPERTIES = java.util.Collections.unmodifiableList(tmp);
			}

			@SuppressWarnings("hiding")
			static final java.util.Set<String> TRANSIENT_PROPERTIES;
			static {
				java.util.HashSet<String> tmp = new java.util.HashSet<>();
				tmp.addAll(test.nested.data.impl.Level1_Impl.Level2_Impl.Composite_Impl.TRANSIENT_PROPERTIES);
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
					case EXPANDED__PROP: return isExpanded();
					default: return super.get(field);
				}
			}

			@Override
			public void set(String field, Object value) {
				switch (field) {
					case EXPANDED__PROP: internalSetExpanded((boolean) value); break;
					default: super.set(field, value); break;
				}
			}

			@Override
			protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
				super.writeFields(out);
				out.name(EXPANDED__PROP);
				out.value(isExpanded());
			}

			@Override
			protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
				switch (field) {
					case EXPANDED__PROP: setExpanded(in.nextBoolean()); break;
					default: super.readField(in, field);
				}
			}

			@Override
			public int typeId() {
				return BRANCH__TYPE_ID;
			}

			@Override
			protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
				super.writeFields(out);
				out.name(EXPANDED__ID);
				out.value(isExpanded());
			}

			/** Helper for creating an object of type {@link test.nested.data.Level1.Level2.Branch} from a polymorphic composition. */
			public static test.nested.data.Level1.Level2.Branch readBranch_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
				test.nested.data.impl.Level1_Impl.Level2_Impl.Branch_Impl result = new Branch_Impl();
				result.readContent(in);
				return result;
			}

			@Override
			protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
				switch (field) {
					case EXPANDED__ID: setExpanded(in.nextBoolean()); break;
					default: super.readField(in, field);
				}
			}

			/** XML element name representing a {@link test.nested.data.Level1.Level2.Branch} type. */
			public static final String BRANCH__XML_ELEMENT = "branch";

			/** XML attribute or element name of a {@link #isExpanded} property. */
			private static final String EXPANDED__XML_ATTR = "expanded";

			@Override
			public String getXmlTagName() {
				return BRANCH__XML_ELEMENT;
			}

			/** Serializes all fields that are written as XML attributes. */
			@Override
			protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
				super.writeAttributes(out);
				out.writeAttribute(EXPANDED__XML_ATTR, Boolean.toString(isExpanded()));
			}

			/** Serializes all fields that are written as XML elements. */
			@Override
			protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
				super.writeElements(out);
				// No element fields.
			}

			/** Creates a new {@link test.nested.data.Level1.Level2.Branch} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
			public static Branch_Impl readBranch_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
				Branch_Impl result = new Branch_Impl();
				result.readContentXml(in);
				return result;
			}

			@Override
			protected void readFieldXmlAttribute(String name, String value) {
				switch (name) {
					case EXPANDED__XML_ATTR: {
						setExpanded(Boolean.parseBoolean(value));
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
					case EXPANDED__XML_ATTR: {
						setExpanded(Boolean.parseBoolean(in.getElementText()));
						break;
					}
					default: {
						super.readFieldXmlElement(in, localName);
					}
				}
			}

			@Override
			public <R,A,E extends Throwable> R visit(test.nested.data.Level1.Level2.Composite.Visitor<R,A,E> v, A arg) throws E {
				return v.visit(this, arg);
			}

		}
		/**
		 * Implementation of {@link test.nested.data.Level1.Level2.Root}.
		 */
		public static class Root_Impl extends test.nested.data.impl.Level1_Impl.Level2_Impl.Composite_Impl implements test.nested.data.Level1.Level2.Root {

			private String _title = "";

			/**
			 * Creates a {@link Root_Impl} instance.
			 *
			 * @see test.nested.data.Level1.Level2.Root#create()
			 */
			public Root_Impl() {
				super();
			}

			@Override
			public TypeKind kind() {
				return TypeKind.ROOT;
			}

			@Override
			public final String getTitle() {
				return _title;
			}

			@Override
			public test.nested.data.Level1.Level2.Root setTitle(String value) {
				internalSetTitle(value);
				return this;
			}

			/** Internal setter for {@link #getTitle()} without chain call utility. */
			protected final void internalSetTitle(String value) {
				_listener.beforeSet(this, TITLE__PROP, value);
				_title = value;
				_listener.afterChanged(this, TITLE__PROP);
			}

			@Override
			public test.nested.data.Level1.Level2.Root setChildren(java.util.List<? extends test.nested.data.Level1.Level2.Node> value) {
				internalSetChildren(value);
				return this;
			}

			@Override
			public test.nested.data.Level1.Level2.Root addChildren(test.nested.data.Level1.Level2.Node value) {
				internalAddChildren(value);
				return this;
			}

			@Override
			public test.nested.data.Level1.Level2.Root setLabel(String value) {
				internalSetLabel(value);
				return this;
			}

			@Override
			public String jsonType() {
				return ROOT__TYPE;
			}

			@SuppressWarnings("hiding")
			static final java.util.List<String> PROPERTIES;
			static {
				java.util.List<String> local = java.util.Arrays.asList(
					TITLE__PROP);
				java.util.List<String> tmp = new java.util.ArrayList<>();
				tmp.addAll(test.nested.data.impl.Level1_Impl.Level2_Impl.Composite_Impl.PROPERTIES);
				tmp.addAll(local);
				PROPERTIES = java.util.Collections.unmodifiableList(tmp);
			}

			@SuppressWarnings("hiding")
			static final java.util.Set<String> TRANSIENT_PROPERTIES;
			static {
				java.util.HashSet<String> tmp = new java.util.HashSet<>();
				tmp.addAll(test.nested.data.impl.Level1_Impl.Level2_Impl.Composite_Impl.TRANSIENT_PROPERTIES);
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
					case TITLE__PROP: return getTitle();
					default: return super.get(field);
				}
			}

			@Override
			public void set(String field, Object value) {
				switch (field) {
					case TITLE__PROP: internalSetTitle((String) value); break;
					default: super.set(field, value); break;
				}
			}

			@Override
			protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
				super.writeFields(out);
				out.name(TITLE__PROP);
				out.value(getTitle());
			}

			@Override
			protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
				switch (field) {
					case TITLE__PROP: setTitle(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
					default: super.readField(in, field);
				}
			}

			@Override
			public int typeId() {
				return ROOT__TYPE_ID;
			}

			@Override
			protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
				super.writeFields(out);
				out.name(TITLE__ID);
				out.value(getTitle());
			}

			/** Helper for creating an object of type {@link test.nested.data.Level1.Level2.Root} from a polymorphic composition. */
			public static test.nested.data.Level1.Level2.Root readRoot_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
				test.nested.data.impl.Level1_Impl.Level2_Impl.Root_Impl result = new Root_Impl();
				result.readContent(in);
				return result;
			}

			@Override
			protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
				switch (field) {
					case TITLE__ID: setTitle(in.nextString()); break;
					default: super.readField(in, field);
				}
			}

			/** XML element name representing a {@link test.nested.data.Level1.Level2.Root} type. */
			public static final String ROOT__XML_ELEMENT = "root";

			/** XML attribute or element name of a {@link #getTitle} property. */
			private static final String TITLE__XML_ATTR = "title";

			@Override
			public String getXmlTagName() {
				return ROOT__XML_ELEMENT;
			}

			/** Serializes all fields that are written as XML attributes. */
			@Override
			protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
				super.writeAttributes(out);
				out.writeAttribute(TITLE__XML_ATTR, getTitle());
			}

			/** Serializes all fields that are written as XML elements. */
			@Override
			protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
				super.writeElements(out);
				// No element fields.
			}

			/** Creates a new {@link test.nested.data.Level1.Level2.Root} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
			public static Root_Impl readRoot_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
				Root_Impl result = new Root_Impl();
				result.readContentXml(in);
				return result;
			}

			@Override
			protected void readFieldXmlAttribute(String name, String value) {
				switch (name) {
					case TITLE__XML_ATTR: {
						setTitle(value);
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
					case TITLE__XML_ATTR: {
						setTitle(in.getElementText());
						break;
					}
					default: {
						super.readFieldXmlElement(in, localName);
					}
				}
			}

			@Override
			public <R,A,E extends Throwable> R visit(test.nested.data.Level1.Level2.Composite.Visitor<R,A,E> v, A arg) throws E {
				return v.visit(this, arg);
			}

		}

		/**
		 * Creates a {@link Level2_Impl} instance.
		 *
		 * @see test.nested.data.Level1.Level2#create()
		 */
		public Level2_Impl() {
			super();
		}

		protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

		@Override
		public test.nested.data.Level1.Level2 registerListener(de.haumacher.msgbuf.observer.Listener l) {
			internalRegisterListener(l);
			return this;
		}

		protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
			_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
		}

		@Override
		public test.nested.data.Level1.Level2 unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
			internalUnregisterListener(l);
			return this;
		}

		protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
			_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
		}

		@Override
		public String jsonType() {
			return LEVEL_2__TYPE;
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

		/** Helper for creating an object of type {@link test.nested.data.Level1.Level2} from a polymorphic composition. */
		public static test.nested.data.Level1.Level2 readLevel2_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			test.nested.data.impl.Level1_Impl.Level2_Impl result = new Level2_Impl();
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

		/** XML element name representing a {@link test.nested.data.Level1.Level2} type. */
		public static final String LEVEL_2__XML_ELEMENT = "level-2";

		@Override
		public String getXmlTagName() {
			return LEVEL_2__XML_ELEMENT;
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

		/** Creates a new {@link test.nested.data.Level1.Level2} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Level2_Impl readLevel2_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			Level2_Impl result = new Level2_Impl();
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

	private test.nested.data.Level1.Level2.Node _node = null;

	private final java.util.List<test.nested.data.Level1.Level2.Node> _nodes = new de.haumacher.msgbuf.util.ReferenceList<test.nested.data.Level1.Level2.Node>() {
		@Override
		protected void beforeAdd(int index, test.nested.data.Level1.Level2.Node element) {
			_listener.beforeAdd(Level1_Impl.this, NODES__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, test.nested.data.Level1.Level2.Node element) {
			_listener.afterRemove(Level1_Impl.this, NODES__PROP, index, element);
		}

		@Override
		protected void afterChanged() {
			_listener.afterChanged(Level1_Impl.this, NODES__PROP);
		}
	};

	/**
	 * Creates a {@link Level1_Impl} instance.
	 *
	 * @see test.nested.data.Level1#create()
	 */
	public Level1_Impl() {
		super();
	}

	@Override
	public final test.nested.data.Level1.Level2.Node getNode() {
		return _node;
	}

	@Override
	public test.nested.data.Level1 setNode(test.nested.data.Level1.Level2.Node value) {
		internalSetNode(value);
		return this;
	}

	/** Internal setter for {@link #getNode()} without chain call utility. */
	protected final void internalSetNode(test.nested.data.Level1.Level2.Node value) {
		_listener.beforeSet(this, NODE__PROP, value);
		_node = value;
		_listener.afterChanged(this, NODE__PROP);
	}

	@Override
	public final boolean hasNode() {
		return _node != null;
	}

	@Override
	public final java.util.List<test.nested.data.Level1.Level2.Node> getNodes() {
		return _nodes;
	}

	@Override
	public test.nested.data.Level1 setNodes(java.util.List<? extends test.nested.data.Level1.Level2.Node> value) {
		internalSetNodes(value);
		return this;
	}

	/** Internal setter for {@link #getNodes()} without chain call utility. */
	protected final void internalSetNodes(java.util.List<? extends test.nested.data.Level1.Level2.Node> value) {
		if (value == null) throw new IllegalArgumentException("Property 'nodes' cannot be null.");
		_nodes.clear();
		_nodes.addAll(value);
	}

	@Override
	public test.nested.data.Level1 addNodes(test.nested.data.Level1.Level2.Node value) {
		internalAddNodes(value);
		return this;
	}

	/** Implementation of {@link #addNodes(test.nested.data.Level1.Level2.Node)} without chain call utility. */
	protected final void internalAddNodes(test.nested.data.Level1.Level2.Node value) {
		_nodes.add(value);
	}

	@Override
	public final void removeNodes(test.nested.data.Level1.Level2.Node value) {
		_nodes.remove(value);
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.nested.data.Level1 registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.nested.data.Level1 unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		internalUnregisterListener(l);
		return this;
	}

	protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
	}

	@Override
	public String jsonType() {
		return LEVEL_1__TYPE;
	}

	static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			NODE__PROP, 
			NODES__PROP);
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
			case NODE__PROP: return getNode();
			case NODES__PROP: return getNodes();
			default: return test.nested.data.Level1.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case NODE__PROP: internalSetNode((test.nested.data.Level1.Level2.Node) value); break;
			case NODES__PROP: internalSetNodes(de.haumacher.msgbuf.util.Conversions.asList(test.nested.data.Level1.Level2.Node.class, value)); break;
		}
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		if (hasNode()) {
			out.name(NODE__PROP);
			getNode().writeTo(out);
		}
		out.name(NODES__PROP);
		out.beginArray();
		for (test.nested.data.Level1.Level2.Node x : getNodes()) {
			x.writeTo(out);
		}
		out.endArray();
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case NODE__PROP: setNode(test.nested.data.Level1.Level2.Node.readNode(in)); break;
			case NODES__PROP: {
				java.util.List<test.nested.data.Level1.Level2.Node> newValue = new java.util.ArrayList<>();
				in.beginArray();
				while (in.hasNext()) {
					newValue.add(test.nested.data.Level1.Level2.Node.readNode(in));
				}
				in.endArray();
				setNodes(newValue);
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
		if (hasNode()) {
			out.name(NODE__ID);
			getNode().writeTo(out);
		}
		out.name(NODES__ID);
		{
			java.util.List<test.nested.data.Level1.Level2.Node> values = getNodes();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.OBJECT, values.size());
			for (test.nested.data.Level1.Level2.Node x : values) {
				x.writeTo(out);
			}
			out.endArray();
		}
	}

	/** Helper for creating an object of type {@link test.nested.data.Level1} from a polymorphic composition. */
	public static test.nested.data.Level1 readLevel1_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.nested.data.impl.Level1_Impl result = new Level1_Impl();
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
			case NODE__ID: setNode(test.nested.data.Level1.Level2.Node.readNode(in)); break;
			case NODES__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addNodes(test.nested.data.Level1.Level2.Node.readNode(in));
				}
				in.endArray();
			}
			break;
			default: in.skipValue(); 
		}
	}

	/** XML element name representing a {@link test.nested.data.Level1} type. */
	public static final String LEVEL_1__XML_ELEMENT = "level-1";

	/** XML attribute or element name of a {@link #getNode} property. */
	private static final String NODE__XML_ATTR = "node";

	/** XML attribute or element name of a {@link #getNodes} property. */
	private static final String NODES__XML_ATTR = "nodes";

	@Override
	public String getXmlTagName() {
		return LEVEL_1__XML_ELEMENT;
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
		if (hasNode()) {
			out.writeStartElement(NODE__XML_ATTR);
			getNode().writeTo(out);
			out.writeEndElement();
		}
		out.writeStartElement(NODES__XML_ATTR);
		for (test.nested.data.Level1.Level2.Node element : getNodes()) {
			element.writeTo(out);
		}
		out.writeEndElement();
	}

	/** Creates a new {@link test.nested.data.Level1} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Level1_Impl readLevel1_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		Level1_Impl result = new Level1_Impl();
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
			case NODE__XML_ATTR: {
				in.nextTag();
				setNode(test.nested.data.impl.Level1_Impl.Level2_Impl.Node_Impl.readNode_XmlContent(in));
				internalSkipUntilMatchingEndElement(in);
				break;
			}
			case NODES__XML_ATTR: {
				internalReadNodesListXml(in);
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

	private void internalReadNodesListXml(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		while (true) {
			int event = in.nextTag();
			if (event == javax.xml.stream.XMLStreamConstants.END_ELEMENT) {
				break;
			}

			addNodes(test.nested.data.impl.Level1_Impl.Level2_Impl.Node_Impl.readNode_XmlContent(in));
		}
	}

}
