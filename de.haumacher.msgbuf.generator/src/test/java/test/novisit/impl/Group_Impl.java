package test.novisit.impl;

/**
 * Implementation of {@link test.novisit.Group}.
 */
public class Group_Impl extends test.novisit.impl.Shape_Impl implements test.novisit.Group {

	private final java.util.List<test.novisit.Shape> _shapes = new de.haumacher.msgbuf.util.ReferenceList<test.novisit.Shape>() {
		@Override
		protected void beforeAdd(int index, test.novisit.Shape element) {
			_listener.beforeAdd(Group_Impl.this, SHAPES__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, test.novisit.Shape element) {
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
	 * @see test.novisit.Group#create()
	 */
	public Group_Impl() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.GROUP;
	}

	@Override
	public final java.util.List<test.novisit.Shape> getShapes() {
		return _shapes;
	}

	@Override
	public test.novisit.Group setShapes(java.util.List<? extends test.novisit.Shape> value) {
		internalSetShapes(value);
		return this;
	}

	/** Internal setter for {@link #getShapes()} without chain call utility. */
	protected final void internalSetShapes(java.util.List<? extends test.novisit.Shape> value) {
		if (value == null) throw new IllegalArgumentException("Property 'shapes' cannot be null.");
		_shapes.clear();
		_shapes.addAll(value);
	}

	@Override
	public test.novisit.Group addShape(test.novisit.Shape value) {
		internalAddShape(value);
		return this;
	}

	/** Implementation of {@link #addShape(test.novisit.Shape)} without chain call utility. */
	protected final void internalAddShape(test.novisit.Shape value) {
		_shapes.add(value);
	}

	@Override
	public final void removeShape(test.novisit.Shape value) {
		_shapes.remove(value);
	}

	@Override
	public test.novisit.Group setXCoordinate(int value) {
		internalSetXCoordinate(value);
		return this;
	}

	@Override
	public test.novisit.Group setYCoordinate(int value) {
		internalSetYCoordinate(value);
		return this;
	}

	@Override
	public String jsonType() {
		return GROUP__TYPE;
	}

	@SuppressWarnings("hiding")
	static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			SHAPES__PROP);
		java.util.List<String> tmp = new java.util.ArrayList<>();
		tmp.addAll(test.novisit.impl.Shape_Impl.PROPERTIES);
		tmp.addAll(local);
		PROPERTIES = java.util.Collections.unmodifiableList(tmp);
	}

	@SuppressWarnings("hiding")
	static final java.util.Set<String> TRANSIENT_PROPERTIES;
	static {
		java.util.HashSet<String> tmp = new java.util.HashSet<>();
		tmp.addAll(test.novisit.impl.Shape_Impl.TRANSIENT_PROPERTIES);
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
			case SHAPES__PROP: return getShapes();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case SHAPES__PROP: internalSetShapes(de.haumacher.msgbuf.util.Conversions.asList(test.novisit.Shape.class, value)); break;
			default: super.set(field, value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(SHAPES__PROP);
		out.beginArray();
		for (test.novisit.Shape x : getShapes()) {
			x.writeTo(out);
		}
		out.endArray();
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case SHAPES__PROP: {
				java.util.List<test.novisit.Shape> newValue = new java.util.ArrayList<>();
				in.beginArray();
				while (in.hasNext()) {
					newValue.add(test.novisit.Shape.readShape(in));
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
			java.util.List<test.novisit.Shape> values = getShapes();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.OBJECT, values.size());
			for (test.novisit.Shape x : values) {
				x.writeTo(out);
			}
			out.endArray();
		}
	}

	/** Helper for creating an object of type {@link test.novisit.Group} from a polymorphic composition. */
	public static test.novisit.Group readGroup_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.novisit.impl.Group_Impl result = new Group_Impl();
		result.readContent(in);
		return result;
	}

	@Override
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case SHAPES__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addShape(test.novisit.Shape.readShape(in));
				}
				in.endArray();
			}
			break;
			default: super.readField(in, field);
		}
	}

	/** XML element name representing a {@link test.novisit.Group} type. */
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
		for (test.novisit.Shape element : getShapes()) {
			element.writeTo(out);
		}
		out.writeEndElement();
	}

	/** Creates a new {@link test.novisit.Group} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
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

			addShape(test.novisit.impl.Shape_Impl.readShape_XmlContent(in));
		}
	}

}
