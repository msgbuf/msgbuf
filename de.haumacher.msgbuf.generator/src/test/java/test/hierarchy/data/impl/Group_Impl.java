package test.hierarchy.data.impl;

/**
 * Implementation of {@link test.hierarchy.data.Group}.
 */
public class Group_Impl extends test.hierarchy.data.impl.Shape_Impl implements test.hierarchy.data.Group {

	private final java.util.List<test.hierarchy.data.Shape> _shapes = new de.haumacher.msgbuf.util.ReferenceList<test.hierarchy.data.Shape>() {
		@Override
		protected void beforeAdd(int index, test.hierarchy.data.Shape element) {
			_listener.beforeAdd(Group_Impl.this, SHAPES__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, test.hierarchy.data.Shape element) {
			_listener.afterRemove(Group_Impl.this, SHAPES__PROP, index, element);
		}

		@Override
		protected void afterChanged() {
			_listener.afterChanged(Group_Impl.this, SHAPES__PROP);
		}
	};

	/**
	 * Creates a {@link Group_Impl} instance.
	 *
	 * @see test.hierarchy.data.Group#create()
	 */
	public Group_Impl() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.GROUP;
	}

	@Override
	public final java.util.List<test.hierarchy.data.Shape> getShapes() {
		return _shapes;
	}

	@Override
	public test.hierarchy.data.Group setShapes(java.util.List<? extends test.hierarchy.data.Shape> value) {
		internalSetShapes(value);
		return this;
	}

	/** Internal setter for {@link #getShapes()} without chain call utility. */
	protected final void internalSetShapes(java.util.List<? extends test.hierarchy.data.Shape> value) {
		if (value == null) throw new IllegalArgumentException("Property 'shapes' cannot be null.");
		_shapes.clear();
		_shapes.addAll(value);
	}

	@Override
	public test.hierarchy.data.Group addShape(test.hierarchy.data.Shape value) {
		internalAddShape(value);
		return this;
	}

	/** Implementation of {@link #addShape(test.hierarchy.data.Shape)} without chain call utility. */
	protected final void internalAddShape(test.hierarchy.data.Shape value) {
		_shapes.add(value);
	}

	@Override
	public final void removeShape(test.hierarchy.data.Shape value) {
		_shapes.remove(value);
	}

	@Override
	public test.hierarchy.data.Group setXCoordinate(int value) {
		internalSetXCoordinate(value);
		return this;
	}

	@Override
	public test.hierarchy.data.Group setYCoordinate(int value) {
		internalSetYCoordinate(value);
		return this;
	}

	@Override
	public test.hierarchy.data.Group setColor(test.hierarchy.data.Color value) {
		internalSetColor(value);
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
			case SHAPES__PROP: internalSetShapes(de.haumacher.msgbuf.util.Conversions.asList(test.hierarchy.data.Shape.class, value)); break;
			default: super.set(field, value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(SHAPES__PROP);
		out.beginArray();
		for (test.hierarchy.data.Shape x : getShapes()) {
			x.writeTo(out);
		}
		out.endArray();
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case SHAPES__PROP: {
				java.util.List<test.hierarchy.data.Shape> newValue = new java.util.ArrayList<>();
				in.beginArray();
				while (in.hasNext()) {
					newValue.add(test.hierarchy.data.Shape.readShape(in));
				}
				in.endArray();
				setShapes(newValue);
			}
			break;
			default: super.readField(in, field);
		}
	}

	@Override
	public int typeId() {
		return GROUP__TYPE_ID;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(SHAPES__ID);
		{
			java.util.List<test.hierarchy.data.Shape> values = getShapes();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.OBJECT, values.size());
			for (test.hierarchy.data.Shape x : values) {
				x.writeTo(out);
			}
			out.endArray();
		}
	}

	/** Helper for creating an object of type {@link test.hierarchy.data.Group} from a polymorphic composition. */
	public static test.hierarchy.data.Group readGroup_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.hierarchy.data.impl.Group_Impl result = new Group_Impl();
		result.readContent(in);
		return result;
	}

	@Override
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case SHAPES__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addShape(test.hierarchy.data.Shape.readShape(in));
				}
				in.endArray();
			}
			break;
			default: super.readField(in, field);
		}
	}

	/** XML element name representing a {@link test.hierarchy.data.Group} type. */
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
		for (test.hierarchy.data.Shape element : getShapes()) {
			element.writeTo(out);
		}
		out.writeEndElement();
	}

	/** Creates a new {@link test.hierarchy.data.Group} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Group_Impl readGroup_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		Group_Impl result = new Group_Impl();
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
			case test.hierarchy.data.impl.Circle_Impl.CIRCLE__XML_ELEMENT: {
				addShape(test.hierarchy.data.impl.Circle_Impl.readCircle_XmlContent(in));
				break;
			}
			case test.hierarchy.data.impl.Rectangle_Impl.RECTANGLE__XML_ELEMENT: {
				addShape(test.hierarchy.data.impl.Rectangle_Impl.readRectangle_XmlContent(in));
				break;
			}
			case test.hierarchy.data.impl.Group_Impl.GROUP__XML_ELEMENT: {
				addShape(test.hierarchy.data.impl.Group_Impl.readGroup_XmlContent(in));
				break;
			}
			case test.hierarchy.data.impl.Optional_Impl.OPTIONAL__XML_ELEMENT: {
				addShape(test.hierarchy.data.impl.Optional_Impl.readOptional_XmlContent(in));
				break;
			}
			case test.hierarchy.data.impl.Car_Impl.CAR__XML_ELEMENT: {
				addShape(test.hierarchy.data.impl.Car_Impl.readCar_XmlContent(in));
				break;
			}
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

			addShape(test.hierarchy.data.impl.Shape_Impl.readShape_XmlContent(in));
		}
	}

	@Override
	public <R,A,E extends Throwable> R visit(test.hierarchy.data.Shape.Visitor<R,A,E> v, A arg) throws E {
		return v.visit(this, arg);
	}

}
