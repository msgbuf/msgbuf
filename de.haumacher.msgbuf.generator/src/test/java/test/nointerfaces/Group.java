package test.nointerfaces;

/**
 * A group of shapes.
 */
public class Group extends Shape {

	/**
	 * Creates a {@link test.nointerfaces.Group} instance.
	 */
	public static test.nointerfaces.Group create() {
		return new test.nointerfaces.Group();
	}

	/** Identifier for the {@link test.nointerfaces.Group} type in JSON format. */
	public static final String GROUP__TYPE = "Group";

	/** @see #getShapes() */
	public static final String SHAPES__PROP = "shapes";

	/** Identifier for the {@link test.nointerfaces.Group} type in binary format. */
	static final int GROUP__TYPE_ID = 3;

	/** Identifier for the property {@link #getShapes()} in binary format. */
	static final int SHAPES__ID = 3;

	private final java.util.List<test.nointerfaces.Shape> _shapes = new de.haumacher.msgbuf.util.ReferenceList<test.nointerfaces.Shape>() {
		@Override
		protected void beforeAdd(int index, test.nointerfaces.Shape element) {
			_listener.beforeAdd(Group.this, SHAPES__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, test.nointerfaces.Shape element) {
			_listener.afterRemove(Group.this, SHAPES__PROP, index, element);
		}
	};

	/**
	 * Creates a {@link Group} instance.
	 *
	 * @see test.nointerfaces.Group#create()
	 */
	protected Group() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.GROUP;
	}

	/**
	 * All {@link Shape}s in this {@link Group}.
	 *
	 * <p>
	 * The origins of these {@link Shape}s get a coordinate offset of ({@link #getXCoordinate()}, {@link #getYCoordinate()}).
	 * </p>
	 */
	public final java.util.List<test.nointerfaces.Shape> getShapes() {
		return _shapes;
	}

	/**
	 * @see #getShapes()
	 */
	public test.nointerfaces.Group setShapes(java.util.List<? extends test.nointerfaces.Shape> value) {
		internalSetShapes(value);
		return this;
	}

	/** Internal setter for {@link #getShapes()} without chain call utility. */
	protected final void internalSetShapes(java.util.List<? extends test.nointerfaces.Shape> value) {
		if (value == null) throw new IllegalArgumentException("Property 'shapes' cannot be null.");
		_shapes.clear();
		_shapes.addAll(value);
	}

	/**
	 * Adds a value to the {@link #getShapes()} list.
	 */
	public test.nointerfaces.Group addShape(test.nointerfaces.Shape value) {
		internalAddShape(value);
		return this;
	}

	/** Implementation of {@link #addShape(test.nointerfaces.Shape)} without chain call utility. */
	protected final void internalAddShape(test.nointerfaces.Shape value) {
		_shapes.add(value);
	}

	/**
	 * Removes a value from the {@link #getShapes()} list.
	 */
	public final void removeShape(test.nointerfaces.Shape value) {
		_shapes.remove(value);
	}

	@Override
	public test.nointerfaces.Group setXCoordinate(int value) {
		internalSetXCoordinate(value);
		return this;
	}

	@Override
	public test.nointerfaces.Group setYCoordinate(int value) {
		internalSetYCoordinate(value);
		return this;
	}

	@Override
	public String jsonType() {
		return GROUP__TYPE;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			SHAPES__PROP));

	private static java.util.Set<String> TRANSIENT_PROPERTIES = java.util.Collections.unmodifiableSet(new java.util.HashSet<>(
			java.util.Arrays.asList(
				)));

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
			case SHAPES__PROP: return getShapes();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case SHAPES__PROP: internalSetShapes(de.haumacher.msgbuf.util.Conversions.asList(test.nointerfaces.Shape.class, value)); break;
			default: super.set(field, value); break;
		}
	}

	/** Reads a new instance from the given reader. */
	public static test.nointerfaces.Group readGroup(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.nointerfaces.Group result = new test.nointerfaces.Group();
		result.readContent(in);
		return result;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(SHAPES__PROP);
		out.beginArray();
		for (test.nointerfaces.Shape x : getShapes()) {
			x.writeTo(out);
		}
		out.endArray();
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case SHAPES__PROP: {
				java.util.List<test.nointerfaces.Shape> newValue = new java.util.ArrayList<>();
				in.beginArray();
				while (in.hasNext()) {
					newValue.add(test.nointerfaces.Shape.readShape(in));
				}
				in.endArray();
				setShapes(newValue);
			}
			break;
			default: super.readField(in, field);
		}
	}

	/** The binary identifier for this concrete type in the polymorphic {@link test.nointerfaces.Group} hierarchy. */
	public int typeId() {
		return GROUP__TYPE_ID;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(SHAPES__ID);
		{
			java.util.List<test.nointerfaces.Shape> values = getShapes();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.OBJECT, values.size());
			for (test.nointerfaces.Shape x : values) {
				x.writeTo(out);
			}
			out.endArray();
		}
	}

	/** Reads a new instance from the given reader. */
	public static test.nointerfaces.Group readGroup(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.nointerfaces.Group result = test.nointerfaces.Group.readGroup_Content(in);
		in.endObject();
		return result;
	}

	/** Helper for creating an object of type {@link test.nointerfaces.Group} from a polymorphic composition. */
	public static test.nointerfaces.Group readGroup_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.nointerfaces.Group result = new Group();
		result.readContent(in);
		return result;
	}

	@Override
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case SHAPES__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addShape(test.nointerfaces.Shape.readShape(in));
				}
				in.endArray();
			}
			break;
			default: super.readField(in, field);
		}
	}

	/** XML element name representing a {@link test.nointerfaces.Group} type. */
	public static final String GROUP__XML_ELEMENT = "group";

	/** XML attribute or element name of a {@link #getShapes} property. */
	private static final String SHAPES__XML_ATTR = "shapes";

	@Override
	public String getXmlTagName() {
		return GROUP__XML_ELEMENT;
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
		out.writeStartElement(SHAPES__XML_ATTR);
		for (test.nointerfaces.Shape element : getShapes()) {
			element.writeTo(out);
		}
		out.writeEndElement();
	}

	/** Creates a new {@link test.nointerfaces.Group} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Group readGroup_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		Group result = new Group();
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
			case SHAPES__XML_ATTR: {
				internalReadShapesListXml(in);
				break;
			}
			default: {
				super.readFieldXmlElement(in, localName);
			}
		}
	}

	private void internalReadShapesListXml(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		while (true) {
			int event = in.nextTag();
			if (event == javax.xml.stream.XMLStreamConstants.END_ELEMENT) {
				break;
			}

			addShape(test.nointerfaces.Shape.readShape_XmlContent(in));
		}
	}

	/** Creates a new {@link Group} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Group readGroup(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.nointerfaces.Group.readGroup_XmlContent(in);
	}

	@Override
	public <R,A,E extends Throwable> R visit(test.nointerfaces.Shape.Visitor<R,A,E> v, A arg) throws E {
		return v.visit(this, arg);
	}

}
