package test.nested.doc.impl;

/**
 * Implementation of {@link test.nested.doc.Doc}.
 */
public class Doc_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.nested.doc.Doc {
	/**
	 * Implementation of {@link test.nested.doc.Doc.Sec}.
	 */
	public static class Sec_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.nested.doc.Doc.Sec {
		/**
		 * Implementation of {@link test.nested.doc.Doc.Sec.Item}.
		 */
		public static abstract class Item_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.nested.doc.Doc.Sec.Item {

			private test.nested.doc.Doc.Sec.Item.Kind _kind = test.nested.doc.Doc.Sec.Item.Kind.PLAIN;

			private String _package = "";

			/**
			 * Creates a {@link Item_Impl} instance.
			 */
			public Item_Impl() {
				super();
			}

			@Override
			public final test.nested.doc.Doc.Sec.Item.Kind getKind() {
				return _kind;
			}

			@Override
			public test.nested.doc.Doc.Sec.Item setKind(test.nested.doc.Doc.Sec.Item.Kind value) {
				internalSetKind(value);
				return this;
			}

			/** Internal setter for {@link #getKind()} without chain call utility. */
			protected final void internalSetKind(test.nested.doc.Doc.Sec.Item.Kind value) {
				if (value == null) throw new IllegalArgumentException("Property 'kind' cannot be null.");
				_listener.beforeSet(this, KIND__PROP, value);
				_kind = value;
				_listener.afterChanged(this, KIND__PROP);
			}

			@Override
			public final String getPackage() {
				return _package;
			}

			@Override
			public test.nested.doc.Doc.Sec.Item setPackage(String value) {
				internalSetPackage(value);
				return this;
			}

			/** Internal setter for {@link #getPackage()} without chain call utility. */
			protected final void internalSetPackage(String value) {
				_listener.beforeSet(this, PACKAGE__PROP, value);
				_package = value;
				_listener.afterChanged(this, PACKAGE__PROP);
			}

			protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

			@Override
			public test.nested.doc.Doc.Sec.Item registerListener(de.haumacher.msgbuf.observer.Listener l) {
				internalRegisterListener(l);
				return this;
			}

			protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
				_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
			}

			@Override
			public test.nested.doc.Doc.Sec.Item unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
				internalUnregisterListener(l);
				return this;
			}

			protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
				_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
			}

			static final java.util.List<String> PROPERTIES;
			static {
				java.util.List<String> local = java.util.Arrays.asList(
					KIND__PROP, 
					PACKAGE__PROP);
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
					case KIND__PROP: return getKind();
					case PACKAGE__PROP: return getPackage();
					default: return test.nested.doc.Doc.Sec.Item.super.get(field);
				}
			}

			@Override
			public void set(String field, Object value) {
				switch (field) {
					case KIND__PROP: internalSetKind((test.nested.doc.Doc.Sec.Item.Kind) value); break;
					case PACKAGE__PROP: internalSetPackage((String) value); break;
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
				out.name(KIND__PROP);
				getKind().writeTo(out);
				out.name(PACKAGE__PROP);
				out.value(getPackage());
			}

			@Override
			protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
				switch (field) {
					case KIND__PROP: setKind(test.nested.doc.Doc.Sec.Item.Kind.readKind(in)); break;
					case PACKAGE__PROP: setPackage(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
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
				out.name(KIND__ID);
				getKind().writeTo(out);
				out.name(PACKAGE__ID);
				out.value(getPackage());
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
					case KIND__ID: setKind(test.nested.doc.Doc.Sec.Item.Kind.readKind(in)); break;
					case PACKAGE__ID: setPackage(in.nextString()); break;
					default: in.skipValue(); 
				}
			}

			/** XML element name representing a {@link test.nested.doc.Doc.Sec.Item} type. */
			public static final String ITEM__XML_ELEMENT = "item";

			/** XML attribute or element name of a {@link #getKind} property. */
			private static final String KIND__XML_ATTR = "kind";

			/** XML attribute or element name of a {@link #getPackage} property. */
			private static final String PACKAGE__XML_ATTR = "package";

			@Override
			public final void writeContent(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
				writeAttributes(out);
				writeElements(out);
			}

			/** Serializes all fields that are written as XML attributes. */
			protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
				out.writeAttribute(KIND__XML_ATTR, getKind().protocolName());
				out.writeAttribute(PACKAGE__XML_ATTR, getPackage());
			}

			/** Serializes all fields that are written as XML elements. */
			protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
				// No element fields.
			}

			/** Creates a new {@link test.nested.doc.Doc.Sec.Item} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
			public static Item_Impl readItem_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
				switch (in.getLocalName()) {
					case test.nested.doc.impl.Doc_Impl.Sec_Impl.Para_Impl.PARA__XML_ELEMENT: {
						return test.nested.doc.impl.Doc_Impl.Sec_Impl.Para_Impl.readPara_XmlContent(in);
					}

					case test.nested.doc.impl.Doc_Impl.Sec_Impl.Case_Impl.CASE__XML_ELEMENT: {
						return test.nested.doc.impl.Doc_Impl.Sec_Impl.Case_Impl.readCase_XmlContent(in);
					}

					case Figure_Impl.FIGURE__XML_ELEMENT: {
						return test.nested.doc.impl.Figure_Impl.readFigure_XmlContent(in);
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
					case KIND__XML_ATTR: {
						setKind(test.nested.doc.Doc.Sec.Item.Kind.valueOfProtocol(value));
						break;
					}
					case PACKAGE__XML_ATTR: {
						setPackage(value);
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
					case KIND__XML_ATTR: {
						setKind(test.nested.doc.Doc.Sec.Item.Kind.valueOfProtocol(in.getElementText()));
						break;
					}
					case PACKAGE__XML_ATTR: {
						setPackage(in.getElementText());
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
		 * Implementation of {@link test.nested.doc.Doc.Sec.Block}.
		 */
		public static abstract class Block_Impl extends test.nested.doc.impl.Doc_Impl.Sec_Impl.Item_Impl implements test.nested.doc.Doc.Sec.Block {

			private int _weight = 0;

			/**
			 * Creates a {@link Block_Impl} instance.
			 */
			public Block_Impl() {
				super();
			}

			@Override
			public final int getWeight() {
				return _weight;
			}

			@Override
			public test.nested.doc.Doc.Sec.Block setWeight(int value) {
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
			public test.nested.doc.Doc.Sec.Block setKind(test.nested.doc.Doc.Sec.Item.Kind value) {
				internalSetKind(value);
				return this;
			}

			@Override
			public test.nested.doc.Doc.Sec.Block setPackage(String value) {
				internalSetPackage(value);
				return this;
			}

			@SuppressWarnings("hiding")
			static final java.util.List<String> PROPERTIES;
			static {
				java.util.List<String> local = java.util.Arrays.asList(
					WEIGHT__PROP);
				java.util.List<String> tmp = new java.util.ArrayList<>();
				tmp.addAll(test.nested.doc.impl.Doc_Impl.Sec_Impl.Item_Impl.PROPERTIES);
				tmp.addAll(local);
				PROPERTIES = java.util.Collections.unmodifiableList(tmp);
			}

			@SuppressWarnings("hiding")
			static final java.util.Set<String> TRANSIENT_PROPERTIES;
			static {
				java.util.HashSet<String> tmp = new java.util.HashSet<>();
				tmp.addAll(test.nested.doc.impl.Doc_Impl.Sec_Impl.Item_Impl.TRANSIENT_PROPERTIES);
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

			@Override
			protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
				switch (field) {
					case WEIGHT__ID: setWeight(in.nextInt()); break;
					default: super.readField(in, field);
				}
			}

			/** XML element name representing a {@link test.nested.doc.Doc.Sec.Block} type. */
			public static final String BLOCK__XML_ELEMENT = "block";

			/** XML attribute or element name of a {@link #getWeight} property. */
			private static final String WEIGHT__XML_ATTR = "weight";

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

			/** Creates a new {@link test.nested.doc.Doc.Sec.Block} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
			public static Block_Impl readBlock_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
				switch (in.getLocalName()) {
					case test.nested.doc.impl.Doc_Impl.Sec_Impl.Para_Impl.PARA__XML_ELEMENT: {
						return test.nested.doc.impl.Doc_Impl.Sec_Impl.Para_Impl.readPara_XmlContent(in);
					}

					case test.nested.doc.impl.Doc_Impl.Sec_Impl.Case_Impl.CASE__XML_ELEMENT: {
						return test.nested.doc.impl.Doc_Impl.Sec_Impl.Case_Impl.readCase_XmlContent(in);
					}

					case Figure_Impl.FIGURE__XML_ELEMENT: {
						return test.nested.doc.impl.Figure_Impl.readFigure_XmlContent(in);
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

			@Override
			public final <R,A,E extends Throwable> R visit(test.nested.doc.Doc.Sec.Item.Visitor<R,A,E> v, A arg) throws E {
				return visit((test.nested.doc.Doc.Sec.Block.Visitor<R,A,E>) v, arg);
			}

		}
		/**
		 * Implementation of {@link test.nested.doc.Doc.Sec.Para}.
		 */
		public static class Para_Impl extends test.nested.doc.impl.Doc_Impl.Sec_Impl.Block_Impl implements test.nested.doc.Doc.Sec.Para {

			private String _text = "";

			/**
			 * Creates a {@link Para_Impl} instance.
			 *
			 * @see test.nested.doc.Doc.Sec.Para#create()
			 */
			public Para_Impl() {
				super();
			}

			@Override
			public TypeKind kind() {
				return TypeKind.PARA;
			}

			@Override
			public final String getText() {
				return _text;
			}

			@Override
			public test.nested.doc.Doc.Sec.Para setText(String value) {
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
			public test.nested.doc.Doc.Sec.Para setWeight(int value) {
				internalSetWeight(value);
				return this;
			}

			@Override
			public test.nested.doc.Doc.Sec.Para setKind(test.nested.doc.Doc.Sec.Item.Kind value) {
				internalSetKind(value);
				return this;
			}

			@Override
			public test.nested.doc.Doc.Sec.Para setPackage(String value) {
				internalSetPackage(value);
				return this;
			}

			@Override
			public String jsonType() {
				return PARA__TYPE;
			}

			@SuppressWarnings("hiding")
			static final java.util.List<String> PROPERTIES;
			static {
				java.util.List<String> local = java.util.Arrays.asList(
					TEXT__PROP);
				java.util.List<String> tmp = new java.util.ArrayList<>();
				tmp.addAll(test.nested.doc.impl.Doc_Impl.Sec_Impl.Block_Impl.PROPERTIES);
				tmp.addAll(local);
				PROPERTIES = java.util.Collections.unmodifiableList(tmp);
			}

			@SuppressWarnings("hiding")
			static final java.util.Set<String> TRANSIENT_PROPERTIES;
			static {
				java.util.HashSet<String> tmp = new java.util.HashSet<>();
				tmp.addAll(test.nested.doc.impl.Doc_Impl.Sec_Impl.Block_Impl.TRANSIENT_PROPERTIES);
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

			@Override
			public int typeId() {
				return PARA__TYPE_ID;
			}

			@Override
			protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
				super.writeFields(out);
				out.name(TEXT__ID);
				out.value(getText());
			}

			/** Helper for creating an object of type {@link test.nested.doc.Doc.Sec.Para} from a polymorphic composition. */
			public static test.nested.doc.Doc.Sec.Para readPara_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
				test.nested.doc.impl.Doc_Impl.Sec_Impl.Para_Impl result = new Para_Impl();
				result.readContent(in);
				return result;
			}

			@Override
			protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
				switch (field) {
					case TEXT__ID: setText(in.nextString()); break;
					default: super.readField(in, field);
				}
			}

			/** XML element name representing a {@link test.nested.doc.Doc.Sec.Para} type. */
			public static final String PARA__XML_ELEMENT = "para";

			/** XML attribute or element name of a {@link #getText} property. */
			private static final String TEXT__XML_ATTR = "text";

			@Override
			public String getXmlTagName() {
				return PARA__XML_ELEMENT;
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

			/** Creates a new {@link test.nested.doc.Doc.Sec.Para} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
			public static Para_Impl readPara_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
				Para_Impl result = new Para_Impl();
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
			public <R,A,E extends Throwable> R visit(test.nested.doc.Doc.Sec.Block.Visitor<R,A,E> v, A arg) throws E {
				return v.visit(this, arg);
			}

		}
		/**
		 * Implementation of {@link test.nested.doc.Doc.Sec.Case}.
		 */
		public static class Case_Impl extends test.nested.doc.impl.Doc_Impl.Sec_Impl.Block_Impl implements test.nested.doc.Doc.Sec.Case {

			private final java.util.List<test.nested.doc.Doc.Sec.Item> _children = new de.haumacher.msgbuf.util.ReferenceList<test.nested.doc.Doc.Sec.Item>() {
				@Override
				protected void beforeAdd(int index, test.nested.doc.Doc.Sec.Item element) {
					_listener.beforeAdd(Case_Impl.this, CHILDREN__PROP, index, element);
				}

				@Override
				protected void afterRemove(int index, test.nested.doc.Doc.Sec.Item element) {
					_listener.afterRemove(Case_Impl.this, CHILDREN__PROP, index, element);
				}

				@Override
				protected void afterChanged() {
					_listener.afterChanged(Case_Impl.this, CHILDREN__PROP);
				}
			};

			/**
			 * Creates a {@link Case_Impl} instance.
			 *
			 * @see test.nested.doc.Doc.Sec.Case#create()
			 */
			public Case_Impl() {
				super();
			}

			@Override
			public TypeKind kind() {
				return TypeKind.CASE;
			}

			@Override
			public final java.util.List<test.nested.doc.Doc.Sec.Item> getChildren() {
				return _children;
			}

			@Override
			public test.nested.doc.Doc.Sec.Case setChildren(java.util.List<? extends test.nested.doc.Doc.Sec.Item> value) {
				internalSetChildren(value);
				return this;
			}

			/** Internal setter for {@link #getChildren()} without chain call utility. */
			protected final void internalSetChildren(java.util.List<? extends test.nested.doc.Doc.Sec.Item> value) {
				if (value == null) throw new IllegalArgumentException("Property 'children' cannot be null.");
				_children.clear();
				_children.addAll(value);
			}

			@Override
			public test.nested.doc.Doc.Sec.Case addChildren(test.nested.doc.Doc.Sec.Item value) {
				internalAddChildren(value);
				return this;
			}

			/** Implementation of {@link #addChildren(test.nested.doc.Doc.Sec.Item)} without chain call utility. */
			protected final void internalAddChildren(test.nested.doc.Doc.Sec.Item value) {
				_children.add(value);
			}

			@Override
			public final void removeChildren(test.nested.doc.Doc.Sec.Item value) {
				_children.remove(value);
			}

			@Override
			public test.nested.doc.Doc.Sec.Case setWeight(int value) {
				internalSetWeight(value);
				return this;
			}

			@Override
			public test.nested.doc.Doc.Sec.Case setKind(test.nested.doc.Doc.Sec.Item.Kind value) {
				internalSetKind(value);
				return this;
			}

			@Override
			public test.nested.doc.Doc.Sec.Case setPackage(String value) {
				internalSetPackage(value);
				return this;
			}

			@Override
			public String jsonType() {
				return CASE__TYPE;
			}

			@SuppressWarnings("hiding")
			static final java.util.List<String> PROPERTIES;
			static {
				java.util.List<String> local = java.util.Arrays.asList(
					CHILDREN__PROP);
				java.util.List<String> tmp = new java.util.ArrayList<>();
				tmp.addAll(test.nested.doc.impl.Doc_Impl.Sec_Impl.Block_Impl.PROPERTIES);
				tmp.addAll(local);
				PROPERTIES = java.util.Collections.unmodifiableList(tmp);
			}

			@SuppressWarnings("hiding")
			static final java.util.Set<String> TRANSIENT_PROPERTIES;
			static {
				java.util.HashSet<String> tmp = new java.util.HashSet<>();
				tmp.addAll(test.nested.doc.impl.Doc_Impl.Sec_Impl.Block_Impl.TRANSIENT_PROPERTIES);
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
					case CHILDREN__PROP: internalSetChildren(de.haumacher.msgbuf.util.Conversions.asList(test.nested.doc.Doc.Sec.Item.class, value)); break;
					default: super.set(field, value); break;
				}
			}

			@Override
			protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
				super.writeFields(out);
				out.name(CHILDREN__PROP);
				out.beginArray();
				for (test.nested.doc.Doc.Sec.Item x : getChildren()) {
					x.writeTo(out);
				}
				out.endArray();
			}

			@Override
			protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
				switch (field) {
					case CHILDREN__PROP: {
						java.util.List<test.nested.doc.Doc.Sec.Item> newValue = new java.util.ArrayList<>();
						in.beginArray();
						while (in.hasNext()) {
							newValue.add(test.nested.doc.Doc.Sec.Item.readItem(in));
						}
						in.endArray();
						setChildren(newValue);
					}
					break;
					default: super.readField(in, field);
				}
			}

			@Override
			public int typeId() {
				return CASE__TYPE_ID;
			}

			@Override
			protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
				super.writeFields(out);
				out.name(CHILDREN__ID);
				{
					java.util.List<test.nested.doc.Doc.Sec.Item> values = getChildren();
					out.beginArray(de.haumacher.msgbuf.binary.DataType.OBJECT, values.size());
					for (test.nested.doc.Doc.Sec.Item x : values) {
						x.writeTo(out);
					}
					out.endArray();
				}
			}

			/** Helper for creating an object of type {@link test.nested.doc.Doc.Sec.Case} from a polymorphic composition. */
			public static test.nested.doc.Doc.Sec.Case readCase_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
				test.nested.doc.impl.Doc_Impl.Sec_Impl.Case_Impl result = new Case_Impl();
				result.readContent(in);
				return result;
			}

			@Override
			protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
				switch (field) {
					case CHILDREN__ID: {
						in.beginArray();
						while (in.hasNext()) {
							addChildren(test.nested.doc.Doc.Sec.Item.readItem(in));
						}
						in.endArray();
					}
					break;
					default: super.readField(in, field);
				}
			}

			/** XML element name representing a {@link test.nested.doc.Doc.Sec.Case} type. */
			public static final String CASE__XML_ELEMENT = "case";

			/** XML attribute or element name of a {@link #getChildren} property. */
			private static final String CHILDREN__XML_ATTR = "children";

			@Override
			public String getXmlTagName() {
				return CASE__XML_ELEMENT;
			}

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
				for (test.nested.doc.Doc.Sec.Item element : getChildren()) {
					element.writeTo(out);
				}
				out.writeEndElement();
			}

			/** Creates a new {@link test.nested.doc.Doc.Sec.Case} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
			public static Case_Impl readCase_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
				Case_Impl result = new Case_Impl();
				result.readContentXml(in);
				return result;
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

					addChildren(test.nested.doc.impl.Doc_Impl.Sec_Impl.Item_Impl.readItem_XmlContent(in));
				}
			}

			@Override
			public <R,A,E extends Throwable> R visit(test.nested.doc.Doc.Sec.Block.Visitor<R,A,E> v, A arg) throws E {
				return v.visit(this, arg);
			}

		}

		/**
		 * Creates a {@link Sec_Impl} instance.
		 *
		 * @see test.nested.doc.Doc.Sec#create()
		 */
		public Sec_Impl() {
			super();
		}

		protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

		@Override
		public test.nested.doc.Doc.Sec registerListener(de.haumacher.msgbuf.observer.Listener l) {
			internalRegisterListener(l);
			return this;
		}

		protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
			_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
		}

		@Override
		public test.nested.doc.Doc.Sec unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
			internalUnregisterListener(l);
			return this;
		}

		protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
			_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
		}

		@Override
		public String jsonType() {
			return SEC__TYPE;
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

		/** Helper for creating an object of type {@link test.nested.doc.Doc.Sec} from a polymorphic composition. */
		public static test.nested.doc.Doc.Sec readSec_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			test.nested.doc.impl.Doc_Impl.Sec_Impl result = new Sec_Impl();
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

		/** XML element name representing a {@link test.nested.doc.Doc.Sec} type. */
		public static final String SEC__XML_ELEMENT = "sec";

		@Override
		public String getXmlTagName() {
			return SEC__XML_ELEMENT;
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

		/** Creates a new {@link test.nested.doc.Doc.Sec} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Sec_Impl readSec_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			Sec_Impl result = new Sec_Impl();
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

	private final java.util.List<test.nested.doc.Doc.Sec.Item> _items = new de.haumacher.msgbuf.util.ReferenceList<test.nested.doc.Doc.Sec.Item>() {
		@Override
		protected void beforeAdd(int index, test.nested.doc.Doc.Sec.Item element) {
			_listener.beforeAdd(Doc_Impl.this, ITEMS__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, test.nested.doc.Doc.Sec.Item element) {
			_listener.afterRemove(Doc_Impl.this, ITEMS__PROP, index, element);
		}

		@Override
		protected void afterChanged() {
			_listener.afterChanged(Doc_Impl.this, ITEMS__PROP);
		}
	};

	private final java.util.Map<String, test.nested.doc.Doc.Sec.Item> _byName = new de.haumacher.msgbuf.util.ReferenceMap<String, test.nested.doc.Doc.Sec.Item>() {
		@Override
		protected void beforeAdd(String index, test.nested.doc.Doc.Sec.Item element) {
			_listener.beforeAdd(Doc_Impl.this, BY_NAME__PROP, index, element);
		}

		@Override
		protected void afterRemove(String index, test.nested.doc.Doc.Sec.Item element) {
			_listener.afterRemove(Doc_Impl.this, BY_NAME__PROP, index, element);
		}

		@Override
		protected void afterChanged() {
			_listener.afterChanged(Doc_Impl.this, BY_NAME__PROP);
		}
	};

	private test.nested.doc.Doc.Sec.Item _maybe = null;

	/**
	 * Creates a {@link Doc_Impl} instance.
	 *
	 * @see test.nested.doc.Doc#create()
	 */
	public Doc_Impl() {
		super();
	}

	@Override
	public final java.util.List<test.nested.doc.Doc.Sec.Item> getItems() {
		return _items;
	}

	@Override
	public test.nested.doc.Doc setItems(java.util.List<? extends test.nested.doc.Doc.Sec.Item> value) {
		internalSetItems(value);
		return this;
	}

	/** Internal setter for {@link #getItems()} without chain call utility. */
	protected final void internalSetItems(java.util.List<? extends test.nested.doc.Doc.Sec.Item> value) {
		if (value == null) throw new IllegalArgumentException("Property 'items' cannot be null.");
		_items.clear();
		_items.addAll(value);
	}

	@Override
	public test.nested.doc.Doc addItem(test.nested.doc.Doc.Sec.Item value) {
		internalAddItem(value);
		return this;
	}

	/** Implementation of {@link #addItem(test.nested.doc.Doc.Sec.Item)} without chain call utility. */
	protected final void internalAddItem(test.nested.doc.Doc.Sec.Item value) {
		_items.add(value);
	}

	@Override
	public final void removeItem(test.nested.doc.Doc.Sec.Item value) {
		_items.remove(value);
	}

	@Override
	public final java.util.Map<String, test.nested.doc.Doc.Sec.Item> getByName() {
		return _byName;
	}

	@Override
	public test.nested.doc.Doc setByName(java.util.Map<String, test.nested.doc.Doc.Sec.Item> value) {
		internalSetByName(value);
		return this;
	}

	/** Internal setter for {@link #getByName()} without chain call utility. */
	protected final void internalSetByName(java.util.Map<String, test.nested.doc.Doc.Sec.Item> value) {
		if (value == null) throw new IllegalArgumentException("Property 'byName' cannot be null.");
		_byName.clear();
		_byName.putAll(value);
	}

	@Override
	public test.nested.doc.Doc putByName(String key, test.nested.doc.Doc.Sec.Item value) {
		internalPutByName(key, value);
		return this;
	}

	/** Implementation of {@link #putByName(String, test.nested.doc.Doc.Sec.Item)} without chain call utility. */
	protected final void  internalPutByName(String key, test.nested.doc.Doc.Sec.Item value) {
		if (_byName.containsKey(key)) {
			throw new IllegalArgumentException("Property 'byName' already contains a value for key '" + key + "'.");
		}
		_byName.put(key, value);
	}

	@Override
	public final void removeByName(String key) {
		_byName.remove(key);
	}

	@Override
	public final test.nested.doc.Doc.Sec.Item getMaybe() {
		return _maybe;
	}

	@Override
	public test.nested.doc.Doc setMaybe(test.nested.doc.Doc.Sec.Item value) {
		internalSetMaybe(value);
		return this;
	}

	/** Internal setter for {@link #getMaybe()} without chain call utility. */
	protected final void internalSetMaybe(test.nested.doc.Doc.Sec.Item value) {
		_listener.beforeSet(this, MAYBE__PROP, value);
		_maybe = value;
		_listener.afterChanged(this, MAYBE__PROP);
	}

	@Override
	public final boolean hasMaybe() {
		return _maybe != null;
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.nested.doc.Doc registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.nested.doc.Doc unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		internalUnregisterListener(l);
		return this;
	}

	protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
	}

	@Override
	public String jsonType() {
		return DOC__TYPE;
	}

	static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			ITEMS__PROP, 
			BY_NAME__PROP, 
			MAYBE__PROP);
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
			case ITEMS__PROP: return getItems();
			case BY_NAME__PROP: return getByName();
			case MAYBE__PROP: return getMaybe();
			default: return test.nested.doc.Doc.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case ITEMS__PROP: internalSetItems(de.haumacher.msgbuf.util.Conversions.asList(test.nested.doc.Doc.Sec.Item.class, value)); break;
			case BY_NAME__PROP: internalSetByName((java.util.Map<String, test.nested.doc.Doc.Sec.Item>) value); break;
			case MAYBE__PROP: internalSetMaybe((test.nested.doc.Doc.Sec.Item) value); break;
		}
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(ITEMS__PROP);
		out.beginArray();
		for (test.nested.doc.Doc.Sec.Item x : getItems()) {
			x.writeTo(out);
		}
		out.endArray();
		out.name(BY_NAME__PROP);
		out.beginObject();
		for (java.util.Map.Entry<String,test.nested.doc.Doc.Sec.Item> entry : getByName().entrySet()) {
			out.name(entry.getKey());
			entry.getValue().writeTo(out);
		}
		out.endObject();
		if (hasMaybe()) {
			out.name(MAYBE__PROP);
			getMaybe().writeTo(out);
		}
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case ITEMS__PROP: {
				java.util.List<test.nested.doc.Doc.Sec.Item> newValue = new java.util.ArrayList<>();
				in.beginArray();
				while (in.hasNext()) {
					newValue.add(test.nested.doc.Doc.Sec.Item.readItem(in));
				}
				in.endArray();
				setItems(newValue);
			}
			break;
			case BY_NAME__PROP: {
				java.util.Map<String, test.nested.doc.Doc.Sec.Item> newValue = new java.util.LinkedHashMap<>();
				in.beginObject();
				while (in.hasNext()) {
					newValue.put(in.nextName(), test.nested.doc.Doc.Sec.Item.readItem(in));
				}
				in.endObject();
				setByName(newValue);
				break;
			}
			case MAYBE__PROP: setMaybe(test.nested.doc.Doc.Sec.Item.readItem(in)); break;
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
		out.name(ITEMS__ID);
		{
			java.util.List<test.nested.doc.Doc.Sec.Item> values = getItems();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.OBJECT, values.size());
			for (test.nested.doc.Doc.Sec.Item x : values) {
				x.writeTo(out);
			}
			out.endArray();
		}
		out.name(BY_NAME__ID);
		{
			out.beginArray(de.haumacher.msgbuf.binary.DataType.OBJECT, getByName().size());
			for (java.util.Map.Entry<String,test.nested.doc.Doc.Sec.Item> entry : getByName().entrySet()) {
				out.beginObject();
				out.name(1);
				out.value(entry.getKey());
				out.name(2);
				entry.getValue().writeTo(out);
				out.endObject();
			}
			out.endArray();
		}
		if (hasMaybe()) {
			out.name(MAYBE__ID);
			getMaybe().writeTo(out);
		}
	}

	/** Helper for creating an object of type {@link test.nested.doc.Doc} from a polymorphic composition. */
	public static test.nested.doc.Doc readDoc_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.nested.doc.impl.Doc_Impl result = new Doc_Impl();
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
			case ITEMS__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addItem(test.nested.doc.Doc.Sec.Item.readItem(in));
				}
				in.endArray();
			}
			break;
			case BY_NAME__ID: {
				in.beginArray();
				while (in.hasNext()) {
					in.beginObject();
					String key = "";
					test.nested.doc.Doc.Sec.Item value = null;
					while (in.hasNext()) {
						switch (in.nextName()) {
							case 1: key = in.nextString(); break;
							case 2: value = test.nested.doc.Doc.Sec.Item.readItem(in); break;
							default: in.skipValue(); break;
						}
					}
					putByName(key, value);
					in.endObject();
				}
				in.endArray();
				break;
			}
			case MAYBE__ID: setMaybe(test.nested.doc.Doc.Sec.Item.readItem(in)); break;
			default: in.skipValue(); 
		}
	}

	/** XML element name representing a {@link test.nested.doc.Doc} type. */
	public static final String DOC__XML_ELEMENT = "doc";

	/** XML attribute or element name of a {@link #getItems} property. */
	private static final String ITEMS__XML_ATTR = "items";

	/** XML attribute or element name of a {@link #getByName} property. */
	private static final String BY_NAME__XML_ATTR = "by-name";

	/** XML attribute or element name of a {@link #getMaybe} property. */
	private static final String MAYBE__XML_ATTR = "maybe";

	@Override
	public String getXmlTagName() {
		return DOC__XML_ELEMENT;
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
		out.writeStartElement(ITEMS__XML_ATTR);
		for (test.nested.doc.Doc.Sec.Item element : getItems()) {
			element.writeTo(out);
		}
		out.writeEndElement();
		if (hasMaybe()) {
			out.writeStartElement(MAYBE__XML_ATTR);
			getMaybe().writeTo(out);
			out.writeEndElement();
		}
	}

	/** Creates a new {@link test.nested.doc.Doc} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Doc_Impl readDoc_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		Doc_Impl result = new Doc_Impl();
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
			case ITEMS__XML_ATTR: {
				internalReadItemsListXml(in);
				break;
			}
			case MAYBE__XML_ATTR: {
				in.nextTag();
				setMaybe(test.nested.doc.impl.Doc_Impl.Sec_Impl.Item_Impl.readItem_XmlContent(in));
				internalSkipUntilMatchingEndElement(in);
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

	private void internalReadItemsListXml(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		while (true) {
			int event = in.nextTag();
			if (event == javax.xml.stream.XMLStreamConstants.END_ELEMENT) {
				break;
			}

			addItem(test.nested.doc.impl.Doc_Impl.Sec_Impl.Item_Impl.readItem_XmlContent(in));
		}
	}

}
