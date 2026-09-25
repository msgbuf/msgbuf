package test.nested.data.impl;

/**
 * Implementation of {@link test.nested.data.Outer}.
 */
public class Outer_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.nested.data.Outer {
	/**
	 * Implementation of {@link test.nested.data.Outer.Shape}.
	 */
	public static abstract class Shape_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.nested.data.Outer.Shape {

		private String _name = "";

		/**
		 * Creates a {@link Shape_Impl} instance.
		 */
		public Shape_Impl() {
			super();
		}

		@Override
		public final String getName() {
			return _name;
		}

		@Override
		public test.nested.data.Outer.Shape setName(String value) {
			internalSetName(value);
			return this;
		}

		/** Internal setter for {@link #getName()} without chain call utility. */
		protected final void internalSetName(String value) {
			_listener.beforeSet(this, NAME__PROP, value);
			_name = value;
			_listener.afterChanged(this, NAME__PROP);
		}

		protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

		@Override
		public test.nested.data.Outer.Shape registerListener(de.haumacher.msgbuf.observer.Listener l) {
			internalRegisterListener(l);
			return this;
		}

		protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
			_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
		}

		@Override
		public test.nested.data.Outer.Shape unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
			internalUnregisterListener(l);
			return this;
		}

		protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
			_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
		}

		static final java.util.List<String> PROPERTIES;
		static {
			java.util.List<String> local = java.util.Arrays.asList(
				NAME__PROP);
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
				default: return test.nested.data.Outer.Shape.super.get(field);
			}
		}

		@Override
		public void set(String field, Object value) {
			switch (field) {
				case NAME__PROP: internalSetName((String) value); break;
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
			out.name(NAME__PROP);
			out.value(getName());
		}

		@Override
		protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
			switch (field) {
				case NAME__PROP: setName(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
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
			out.name(NAME__ID);
			out.value(getName());
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
				default: in.skipValue(); 
			}
		}

		/** XML element name representing a {@link test.nested.data.Outer.Shape} type. */
		public static final String SHAPE__XML_ELEMENT = "shape";

		/** XML attribute or element name of a {@link #getName} property. */
		private static final String NAME__XML_ATTR = "name";

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
			// No element fields.
		}

		/** Creates a new {@link test.nested.data.Outer.Shape} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Shape_Impl readShape_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			switch (in.getLocalName()) {
				case test.nested.data.impl.Outer_Impl.Circle_Impl.CIRCLE__XML_ELEMENT: {
					return test.nested.data.impl.Outer_Impl.Circle_Impl.readCircle_XmlContent(in);
				}

				case test.nested.data.impl.Outer_Impl.Square_Impl.SQUARE__XML_ELEMENT: {
					return test.nested.data.impl.Outer_Impl.Square_Impl.readSquare_XmlContent(in);
				}

				case Triangle_Impl.TRIANGLE__XML_ELEMENT: {
					return test.nested.data.impl.Triangle_Impl.readTriangle_XmlContent(in);
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
	 * Implementation of {@link test.nested.data.Outer.Circle}.
	 */
	public static class Circle_Impl extends test.nested.data.impl.Outer_Impl.Shape_Impl implements test.nested.data.Outer.Circle {

		private int _radius = 0;

		/**
		 * Creates a {@link Circle_Impl} instance.
		 *
		 * @see test.nested.data.Outer.Circle#create()
		 */
		public Circle_Impl() {
			super();
		}

		@Override
		public TypeKind kind() {
			return TypeKind.CIRCLE;
		}

		@Override
		public final int getRadius() {
			return _radius;
		}

		@Override
		public test.nested.data.Outer.Circle setRadius(int value) {
			internalSetRadius(value);
			return this;
		}

		/** Internal setter for {@link #getRadius()} without chain call utility. */
		protected final void internalSetRadius(int value) {
			_listener.beforeSet(this, RADIUS__PROP, value);
			_radius = value;
			_listener.afterChanged(this, RADIUS__PROP);
		}

		@Override
		public test.nested.data.Outer.Circle setName(String value) {
			internalSetName(value);
			return this;
		}

		@Override
		public String jsonType() {
			return CIRCLE__TYPE;
		}

		@SuppressWarnings("hiding")
		static final java.util.List<String> PROPERTIES;
		static {
			java.util.List<String> local = java.util.Arrays.asList(
				RADIUS__PROP);
			java.util.List<String> tmp = new java.util.ArrayList<>();
			tmp.addAll(test.nested.data.impl.Outer_Impl.Shape_Impl.PROPERTIES);
			tmp.addAll(local);
			PROPERTIES = java.util.Collections.unmodifiableList(tmp);
		}

		@SuppressWarnings("hiding")
		static final java.util.Set<String> TRANSIENT_PROPERTIES;
		static {
			java.util.HashSet<String> tmp = new java.util.HashSet<>();
			tmp.addAll(test.nested.data.impl.Outer_Impl.Shape_Impl.TRANSIENT_PROPERTIES);
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
				case RADIUS__PROP: return getRadius();
				default: return super.get(field);
			}
		}

		@Override
		public void set(String field, Object value) {
			switch (field) {
				case RADIUS__PROP: internalSetRadius((int) value); break;
				default: super.set(field, value); break;
			}
		}

		@Override
		protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
			super.writeFields(out);
			out.name(RADIUS__PROP);
			out.value(getRadius());
		}

		@Override
		protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
			switch (field) {
				case RADIUS__PROP: setRadius(in.nextInt()); break;
				default: super.readField(in, field);
			}
		}

		@Override
		public int typeId() {
			return CIRCLE__TYPE_ID;
		}

		@Override
		protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
			super.writeFields(out);
			out.name(RADIUS__ID);
			out.value(getRadius());
		}

		/** Helper for creating an object of type {@link test.nested.data.Outer.Circle} from a polymorphic composition. */
		public static test.nested.data.Outer.Circle readCircle_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			test.nested.data.impl.Outer_Impl.Circle_Impl result = new Circle_Impl();
			result.readContent(in);
			return result;
		}

		@Override
		protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
			switch (field) {
				case RADIUS__ID: setRadius(in.nextInt()); break;
				default: super.readField(in, field);
			}
		}

		/** XML element name representing a {@link test.nested.data.Outer.Circle} type. */
		public static final String CIRCLE__XML_ELEMENT = "circle";

		/** XML attribute or element name of a {@link #getRadius} property. */
		private static final String RADIUS__XML_ATTR = "radius";

		@Override
		public String getXmlTagName() {
			return CIRCLE__XML_ELEMENT;
		}

		/** Serializes all fields that are written as XML attributes. */
		@Override
		protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
			super.writeAttributes(out);
			out.writeAttribute(RADIUS__XML_ATTR, Integer.toString(getRadius()));
		}

		/** Serializes all fields that are written as XML elements. */
		@Override
		protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
			super.writeElements(out);
			// No element fields.
		}

		/** Creates a new {@link test.nested.data.Outer.Circle} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Circle_Impl readCircle_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			Circle_Impl result = new Circle_Impl();
			result.readContentXml(in);
			return result;
		}

		@Override
		protected void readFieldXmlAttribute(String name, String value) {
			switch (name) {
				case RADIUS__XML_ATTR: {
					setRadius(Integer.parseInt(value));
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
				case RADIUS__XML_ATTR: {
					setRadius(Integer.parseInt(in.getElementText()));
					break;
				}
				default: {
					super.readFieldXmlElement(in, localName);
				}
			}
		}

		@Override
		public <R,A,E extends Throwable> R visit(test.nested.data.Outer.Shape.Visitor<R,A,E> v, A arg) throws E {
			return v.visit(this, arg);
		}

	}
	/**
	 * Implementation of {@link test.nested.data.Outer.Square}.
	 */
	public static class Square_Impl extends test.nested.data.impl.Outer_Impl.Shape_Impl implements test.nested.data.Outer.Square {

		private int _side = 0;

		/**
		 * Creates a {@link Square_Impl} instance.
		 *
		 * @see test.nested.data.Outer.Square#create()
		 */
		public Square_Impl() {
			super();
		}

		@Override
		public TypeKind kind() {
			return TypeKind.SQUARE;
		}

		@Override
		public final int getSide() {
			return _side;
		}

		@Override
		public test.nested.data.Outer.Square setSide(int value) {
			internalSetSide(value);
			return this;
		}

		/** Internal setter for {@link #getSide()} without chain call utility. */
		protected final void internalSetSide(int value) {
			_listener.beforeSet(this, SIDE__PROP, value);
			_side = value;
			_listener.afterChanged(this, SIDE__PROP);
		}

		@Override
		public test.nested.data.Outer.Square setName(String value) {
			internalSetName(value);
			return this;
		}

		@Override
		public String jsonType() {
			return SQUARE__TYPE;
		}

		@SuppressWarnings("hiding")
		static final java.util.List<String> PROPERTIES;
		static {
			java.util.List<String> local = java.util.Arrays.asList(
				SIDE__PROP);
			java.util.List<String> tmp = new java.util.ArrayList<>();
			tmp.addAll(test.nested.data.impl.Outer_Impl.Shape_Impl.PROPERTIES);
			tmp.addAll(local);
			PROPERTIES = java.util.Collections.unmodifiableList(tmp);
		}

		@SuppressWarnings("hiding")
		static final java.util.Set<String> TRANSIENT_PROPERTIES;
		static {
			java.util.HashSet<String> tmp = new java.util.HashSet<>();
			tmp.addAll(test.nested.data.impl.Outer_Impl.Shape_Impl.TRANSIENT_PROPERTIES);
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
				case SIDE__PROP: return getSide();
				default: return super.get(field);
			}
		}

		@Override
		public void set(String field, Object value) {
			switch (field) {
				case SIDE__PROP: internalSetSide((int) value); break;
				default: super.set(field, value); break;
			}
		}

		@Override
		protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
			super.writeFields(out);
			out.name(SIDE__PROP);
			out.value(getSide());
		}

		@Override
		protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
			switch (field) {
				case SIDE__PROP: setSide(in.nextInt()); break;
				default: super.readField(in, field);
			}
		}

		@Override
		public int typeId() {
			return SQUARE__TYPE_ID;
		}

		@Override
		protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
			super.writeFields(out);
			out.name(SIDE__ID);
			out.value(getSide());
		}

		/** Helper for creating an object of type {@link test.nested.data.Outer.Square} from a polymorphic composition. */
		public static test.nested.data.Outer.Square readSquare_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			test.nested.data.impl.Outer_Impl.Square_Impl result = new Square_Impl();
			result.readContent(in);
			return result;
		}

		@Override
		protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
			switch (field) {
				case SIDE__ID: setSide(in.nextInt()); break;
				default: super.readField(in, field);
			}
		}

		/** XML element name representing a {@link test.nested.data.Outer.Square} type. */
		public static final String SQUARE__XML_ELEMENT = "square";

		/** XML attribute or element name of a {@link #getSide} property. */
		private static final String SIDE__XML_ATTR = "side";

		@Override
		public String getXmlTagName() {
			return SQUARE__XML_ELEMENT;
		}

		/** Serializes all fields that are written as XML attributes. */
		@Override
		protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
			super.writeAttributes(out);
			out.writeAttribute(SIDE__XML_ATTR, Integer.toString(getSide()));
		}

		/** Serializes all fields that are written as XML elements. */
		@Override
		protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
			super.writeElements(out);
			// No element fields.
		}

		/** Creates a new {@link test.nested.data.Outer.Square} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Square_Impl readSquare_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			Square_Impl result = new Square_Impl();
			result.readContentXml(in);
			return result;
		}

		@Override
		protected void readFieldXmlAttribute(String name, String value) {
			switch (name) {
				case SIDE__XML_ATTR: {
					setSide(Integer.parseInt(value));
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
				case SIDE__XML_ATTR: {
					setSide(Integer.parseInt(in.getElementText()));
					break;
				}
				default: {
					super.readFieldXmlElement(in, localName);
				}
			}
		}

		@Override
		public <R,A,E extends Throwable> R visit(test.nested.data.Outer.Shape.Visitor<R,A,E> v, A arg) throws E {
			return v.visit(this, arg);
		}

	}
	/**
	 * Implementation of {@link test.nested.data.Outer.Drawing}.
	 */
	public static class Drawing_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.nested.data.Outer.Drawing {

		private test.nested.data.Outer.Shape _main = null;

		private final java.util.List<test.nested.data.Outer.Shape> _shapes = new de.haumacher.msgbuf.util.ReferenceList<test.nested.data.Outer.Shape>() {
			@Override
			protected void beforeAdd(int index, test.nested.data.Outer.Shape element) {
				_listener.beforeAdd(Drawing_Impl.this, SHAPES__PROP, index, element);
			}

			@Override
			protected void afterRemove(int index, test.nested.data.Outer.Shape element) {
				_listener.afterRemove(Drawing_Impl.this, SHAPES__PROP, index, element);
			}

			@Override
			protected void afterChanged() {
				_listener.afterChanged(Drawing_Impl.this, SHAPES__PROP);
			}
		};

		/**
		 * Creates a {@link Drawing_Impl} instance.
		 *
		 * @see test.nested.data.Outer.Drawing#create()
		 */
		public Drawing_Impl() {
			super();
		}

		@Override
		public final test.nested.data.Outer.Shape getMain() {
			return _main;
		}

		@Override
		public test.nested.data.Outer.Drawing setMain(test.nested.data.Outer.Shape value) {
			internalSetMain(value);
			return this;
		}

		/** Internal setter for {@link #getMain()} without chain call utility. */
		protected final void internalSetMain(test.nested.data.Outer.Shape value) {
			_listener.beforeSet(this, MAIN__PROP, value);
			_main = value;
			_listener.afterChanged(this, MAIN__PROP);
		}

		@Override
		public final boolean hasMain() {
			return _main != null;
		}

		@Override
		public final java.util.List<test.nested.data.Outer.Shape> getShapes() {
			return _shapes;
		}

		@Override
		public test.nested.data.Outer.Drawing setShapes(java.util.List<? extends test.nested.data.Outer.Shape> value) {
			internalSetShapes(value);
			return this;
		}

		/** Internal setter for {@link #getShapes()} without chain call utility. */
		protected final void internalSetShapes(java.util.List<? extends test.nested.data.Outer.Shape> value) {
			if (value == null) throw new IllegalArgumentException("Property 'shapes' cannot be null.");
			_shapes.clear();
			_shapes.addAll(value);
		}

		@Override
		public test.nested.data.Outer.Drawing addShape(test.nested.data.Outer.Shape value) {
			internalAddShape(value);
			return this;
		}

		/** Implementation of {@link #addShape(test.nested.data.Outer.Shape)} without chain call utility. */
		protected final void internalAddShape(test.nested.data.Outer.Shape value) {
			_shapes.add(value);
		}

		@Override
		public final void removeShape(test.nested.data.Outer.Shape value) {
			_shapes.remove(value);
		}

		protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

		@Override
		public test.nested.data.Outer.Drawing registerListener(de.haumacher.msgbuf.observer.Listener l) {
			internalRegisterListener(l);
			return this;
		}

		protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
			_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
		}

		@Override
		public test.nested.data.Outer.Drawing unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
			internalUnregisterListener(l);
			return this;
		}

		protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
			_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
		}

		@Override
		public String jsonType() {
			return DRAWING__TYPE;
		}

		static final java.util.List<String> PROPERTIES;
		static {
			java.util.List<String> local = java.util.Arrays.asList(
				MAIN__PROP, 
				SHAPES__PROP);
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
				case MAIN__PROP: return getMain();
				case SHAPES__PROP: return getShapes();
				default: return test.nested.data.Outer.Drawing.super.get(field);
			}
		}

		@Override
		public void set(String field, Object value) {
			switch (field) {
				case MAIN__PROP: internalSetMain((test.nested.data.Outer.Shape) value); break;
				case SHAPES__PROP: internalSetShapes(de.haumacher.msgbuf.util.Conversions.asList(test.nested.data.Outer.Shape.class, value)); break;
			}
		}

		@Override
		public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
			writeContent(out);
		}

		@Override
		protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
			super.writeFields(out);
			if (hasMain()) {
				out.name(MAIN__PROP);
				getMain().writeTo(out);
			}
			out.name(SHAPES__PROP);
			out.beginArray();
			for (test.nested.data.Outer.Shape x : getShapes()) {
				x.writeTo(out);
			}
			out.endArray();
		}

		@Override
		protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
			switch (field) {
				case MAIN__PROP: setMain(test.nested.data.Outer.Shape.readShape(in)); break;
				case SHAPES__PROP: {
					java.util.List<test.nested.data.Outer.Shape> newValue = new java.util.ArrayList<>();
					in.beginArray();
					while (in.hasNext()) {
						newValue.add(test.nested.data.Outer.Shape.readShape(in));
					}
					in.endArray();
					setShapes(newValue);
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
			if (hasMain()) {
				out.name(MAIN__ID);
				getMain().writeTo(out);
			}
			out.name(SHAPES__ID);
			{
				java.util.List<test.nested.data.Outer.Shape> values = getShapes();
				out.beginArray(de.haumacher.msgbuf.binary.DataType.OBJECT, values.size());
				for (test.nested.data.Outer.Shape x : values) {
					x.writeTo(out);
				}
				out.endArray();
			}
		}

		/** Helper for creating an object of type {@link test.nested.data.Outer.Drawing} from a polymorphic composition. */
		public static test.nested.data.Outer.Drawing readDrawing_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			test.nested.data.impl.Outer_Impl.Drawing_Impl result = new Drawing_Impl();
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
				case MAIN__ID: setMain(test.nested.data.Outer.Shape.readShape(in)); break;
				case SHAPES__ID: {
					in.beginArray();
					while (in.hasNext()) {
						addShape(test.nested.data.Outer.Shape.readShape(in));
					}
					in.endArray();
				}
				break;
				default: in.skipValue(); 
			}
		}

		/** XML element name representing a {@link test.nested.data.Outer.Drawing} type. */
		public static final String DRAWING__XML_ELEMENT = "drawing";

		/** XML attribute or element name of a {@link #getMain} property. */
		private static final String MAIN__XML_ATTR = "main";

		/** XML attribute or element name of a {@link #getShapes} property. */
		private static final String SHAPES__XML_ATTR = "shapes";

		@Override
		public String getXmlTagName() {
			return DRAWING__XML_ELEMENT;
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
			if (hasMain()) {
				out.writeStartElement(MAIN__XML_ATTR);
				getMain().writeTo(out);
				out.writeEndElement();
			}
			out.writeStartElement(SHAPES__XML_ATTR);
			for (test.nested.data.Outer.Shape element : getShapes()) {
				element.writeTo(out);
			}
			out.writeEndElement();
		}

		/** Creates a new {@link test.nested.data.Outer.Drawing} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Drawing_Impl readDrawing_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			Drawing_Impl result = new Drawing_Impl();
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
				case MAIN__XML_ATTR: {
					in.nextTag();
					setMain(test.nested.data.impl.Outer_Impl.Shape_Impl.readShape_XmlContent(in));
					internalSkipUntilMatchingEndElement(in);
					break;
				}
				case SHAPES__XML_ATTR: {
					internalReadShapesListXml(in);
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

		private void internalReadShapesListXml(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			while (true) {
				int event = in.nextTag();
				if (event == javax.xml.stream.XMLStreamConstants.END_ELEMENT) {
					break;
				}

				addShape(test.nested.data.impl.Outer_Impl.Shape_Impl.readShape_XmlContent(in));
			}
		}

	}

	private test.nested.data.Outer.Shape _shape = null;

	/**
	 * Creates a {@link Outer_Impl} instance.
	 *
	 * @see test.nested.data.Outer#create()
	 */
	public Outer_Impl() {
		super();
	}

	@Override
	public final test.nested.data.Outer.Shape getShape() {
		return _shape;
	}

	@Override
	public test.nested.data.Outer setShape(test.nested.data.Outer.Shape value) {
		internalSetShape(value);
		return this;
	}

	/** Internal setter for {@link #getShape()} without chain call utility. */
	protected final void internalSetShape(test.nested.data.Outer.Shape value) {
		_listener.beforeSet(this, SHAPE__PROP, value);
		_shape = value;
		_listener.afterChanged(this, SHAPE__PROP);
	}

	@Override
	public final boolean hasShape() {
		return _shape != null;
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.nested.data.Outer registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.nested.data.Outer unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
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

	static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			SHAPE__PROP);
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
			case SHAPE__PROP: return getShape();
			default: return test.nested.data.Outer.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case SHAPE__PROP: internalSetShape((test.nested.data.Outer.Shape) value); break;
		}
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		if (hasShape()) {
			out.name(SHAPE__PROP);
			getShape().writeTo(out);
		}
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case SHAPE__PROP: setShape(test.nested.data.Outer.Shape.readShape(in)); break;
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
		if (hasShape()) {
			out.name(SHAPE__ID);
			getShape().writeTo(out);
		}
	}

	/** Helper for creating an object of type {@link test.nested.data.Outer} from a polymorphic composition. */
	public static test.nested.data.Outer readOuter_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.nested.data.impl.Outer_Impl result = new Outer_Impl();
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
			case SHAPE__ID: setShape(test.nested.data.Outer.Shape.readShape(in)); break;
			default: in.skipValue(); 
		}
	}

	/** XML element name representing a {@link test.nested.data.Outer} type. */
	public static final String OUTER__XML_ELEMENT = "outer";

	/** XML attribute or element name of a {@link #getShape} property. */
	private static final String SHAPE__XML_ATTR = "shape";

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
		if (hasShape()) {
			out.writeStartElement(SHAPE__XML_ATTR);
			getShape().writeTo(out);
			out.writeEndElement();
		}
	}

	/** Creates a new {@link test.nested.data.Outer} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
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
			case SHAPE__XML_ATTR: {
				in.nextTag();
				setShape(test.nested.data.impl.Outer_Impl.Shape_Impl.readShape_XmlContent(in));
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

}
