package test.nested.data.impl;

/**
 * Implementation of {@link test.nested.data.Holder}.
 */
public class Holder_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.nested.data.Holder {

	private test.nested.data.Outer.Shape _shape = null;

	private final java.util.List<test.nested.data.Outer.Shape> _shapes = new de.haumacher.msgbuf.util.ReferenceList<test.nested.data.Outer.Shape>() {
		@Override
		protected void beforeAdd(int index, test.nested.data.Outer.Shape element) {
			_listener.beforeAdd(Holder_Impl.this, SHAPES__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, test.nested.data.Outer.Shape element) {
			_listener.afterRemove(Holder_Impl.this, SHAPES__PROP, index, element);
		}

		@Override
		protected void afterChanged() {
			_listener.afterChanged(Holder_Impl.this, SHAPES__PROP);
		}
	};

	private test.nested.data.Level1.Level2.Node _node = null;

	private final java.util.List<test.nested.data.Animal> _animals = new de.haumacher.msgbuf.util.ReferenceList<test.nested.data.Animal>() {
		@Override
		protected void beforeAdd(int index, test.nested.data.Animal element) {
			_listener.beforeAdd(Holder_Impl.this, ANIMALS__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, test.nested.data.Animal element) {
			_listener.afterRemove(Holder_Impl.this, ANIMALS__PROP, index, element);
		}

		@Override
		protected void afterChanged() {
			_listener.afterChanged(Holder_Impl.this, ANIMALS__PROP);
		}
	};

	/**
	 * Creates a {@link Holder_Impl} instance.
	 *
	 * @see test.nested.data.Holder#create()
	 */
	public Holder_Impl() {
		super();
	}

	@Override
	public final test.nested.data.Outer.Shape getShape() {
		return _shape;
	}

	@Override
	public test.nested.data.Holder setShape(test.nested.data.Outer.Shape value) {
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

	@Override
	public final java.util.List<test.nested.data.Outer.Shape> getShapes() {
		return _shapes;
	}

	@Override
	public test.nested.data.Holder setShapes(java.util.List<? extends test.nested.data.Outer.Shape> value) {
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
	public test.nested.data.Holder addShapes(test.nested.data.Outer.Shape value) {
		internalAddShapes(value);
		return this;
	}

	/** Implementation of {@link #addShapes(test.nested.data.Outer.Shape)} without chain call utility. */
	protected final void internalAddShapes(test.nested.data.Outer.Shape value) {
		_shapes.add(value);
	}

	@Override
	public final void removeShapes(test.nested.data.Outer.Shape value) {
		_shapes.remove(value);
	}

	@Override
	public final test.nested.data.Level1.Level2.Node getNode() {
		return _node;
	}

	@Override
	public test.nested.data.Holder setNode(test.nested.data.Level1.Level2.Node value) {
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
	public final java.util.List<test.nested.data.Animal> getAnimals() {
		return _animals;
	}

	@Override
	public test.nested.data.Holder setAnimals(java.util.List<? extends test.nested.data.Animal> value) {
		internalSetAnimals(value);
		return this;
	}

	/** Internal setter for {@link #getAnimals()} without chain call utility. */
	protected final void internalSetAnimals(java.util.List<? extends test.nested.data.Animal> value) {
		if (value == null) throw new IllegalArgumentException("Property 'animals' cannot be null.");
		_animals.clear();
		_animals.addAll(value);
	}

	@Override
	public test.nested.data.Holder addAnimal(test.nested.data.Animal value) {
		internalAddAnimal(value);
		return this;
	}

	/** Implementation of {@link #addAnimal(test.nested.data.Animal)} without chain call utility. */
	protected final void internalAddAnimal(test.nested.data.Animal value) {
		_animals.add(value);
	}

	@Override
	public final void removeAnimal(test.nested.data.Animal value) {
		_animals.remove(value);
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.nested.data.Holder registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.nested.data.Holder unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		internalUnregisterListener(l);
		return this;
	}

	protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
	}

	@Override
	public String jsonType() {
		return HOLDER__TYPE;
	}

	static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			SHAPE__PROP, 
			SHAPES__PROP, 
			NODE__PROP, 
			ANIMALS__PROP);
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
			case SHAPES__PROP: return getShapes();
			case NODE__PROP: return getNode();
			case ANIMALS__PROP: return getAnimals();
			default: return test.nested.data.Holder.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case SHAPE__PROP: internalSetShape((test.nested.data.Outer.Shape) value); break;
			case SHAPES__PROP: internalSetShapes(de.haumacher.msgbuf.util.Conversions.asList(test.nested.data.Outer.Shape.class, value)); break;
			case NODE__PROP: internalSetNode((test.nested.data.Level1.Level2.Node) value); break;
			case ANIMALS__PROP: internalSetAnimals(de.haumacher.msgbuf.util.Conversions.asList(test.nested.data.Animal.class, value)); break;
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
		out.name(SHAPES__PROP);
		out.beginArray();
		for (test.nested.data.Outer.Shape x : getShapes()) {
			x.writeTo(out);
		}
		out.endArray();
		if (hasNode()) {
			out.name(NODE__PROP);
			getNode().writeTo(out);
		}
		out.name(ANIMALS__PROP);
		out.beginArray();
		for (test.nested.data.Animal x : getAnimals()) {
			x.writeTo(out);
		}
		out.endArray();
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case SHAPE__PROP: setShape(test.nested.data.Outer.Shape.readShape(in)); break;
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
			case NODE__PROP: setNode(test.nested.data.Level1.Level2.Node.readNode(in)); break;
			case ANIMALS__PROP: {
				java.util.List<test.nested.data.Animal> newValue = new java.util.ArrayList<>();
				in.beginArray();
				while (in.hasNext()) {
					newValue.add(test.nested.data.Animal.readAnimal(in));
				}
				in.endArray();
				setAnimals(newValue);
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
		if (hasShape()) {
			out.name(SHAPE__ID);
			getShape().writeTo(out);
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
		if (hasNode()) {
			out.name(NODE__ID);
			getNode().writeTo(out);
		}
		out.name(ANIMALS__ID);
		{
			java.util.List<test.nested.data.Animal> values = getAnimals();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.OBJECT, values.size());
			for (test.nested.data.Animal x : values) {
				x.writeTo(out);
			}
			out.endArray();
		}
	}

	/** Helper for creating an object of type {@link test.nested.data.Holder} from a polymorphic composition. */
	public static test.nested.data.Holder readHolder_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.nested.data.impl.Holder_Impl result = new Holder_Impl();
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
			case SHAPES__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addShapes(test.nested.data.Outer.Shape.readShape(in));
				}
				in.endArray();
			}
			break;
			case NODE__ID: setNode(test.nested.data.Level1.Level2.Node.readNode(in)); break;
			case ANIMALS__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addAnimal(test.nested.data.Animal.readAnimal(in));
				}
				in.endArray();
			}
			break;
			default: in.skipValue(); 
		}
	}

	/** XML element name representing a {@link test.nested.data.Holder} type. */
	public static final String HOLDER__XML_ELEMENT = "holder";

	/** XML attribute or element name of a {@link #getShape} property. */
	private static final String SHAPE__XML_ATTR = "shape";

	/** XML attribute or element name of a {@link #getShapes} property. */
	private static final String SHAPES__XML_ATTR = "shapes";

	/** XML attribute or element name of a {@link #getNode} property. */
	private static final String NODE__XML_ATTR = "node";

	/** XML attribute or element name of a {@link #getAnimals} property. */
	private static final String ANIMALS__XML_ATTR = "animals";

	@Override
	public String getXmlTagName() {
		return HOLDER__XML_ELEMENT;
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
		out.writeStartElement(SHAPES__XML_ATTR);
		for (test.nested.data.Outer.Shape element : getShapes()) {
			element.writeTo(out);
		}
		out.writeEndElement();
		if (hasNode()) {
			out.writeStartElement(NODE__XML_ATTR);
			getNode().writeTo(out);
			out.writeEndElement();
		}
		out.writeStartElement(ANIMALS__XML_ATTR);
		for (test.nested.data.Animal element : getAnimals()) {
			element.writeTo(out);
		}
		out.writeEndElement();
	}

	/** Creates a new {@link test.nested.data.Holder} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Holder_Impl readHolder_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		Holder_Impl result = new Holder_Impl();
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
			case SHAPES__XML_ATTR: {
				internalReadShapesListXml(in);
				break;
			}
			case NODE__XML_ATTR: {
				in.nextTag();
				setNode(test.nested.data.impl.Level1_Impl.Level2_Impl.Node_Impl.readNode_XmlContent(in));
				internalSkipUntilMatchingEndElement(in);
				break;
			}
			case ANIMALS__XML_ATTR: {
				internalReadAnimalsListXml(in);
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

			addShapes(test.nested.data.impl.Outer_Impl.Shape_Impl.readShape_XmlContent(in));
		}
	}

	private void internalReadAnimalsListXml(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		while (true) {
			int event = in.nextTag();
			if (event == javax.xml.stream.XMLStreamConstants.END_ELEMENT) {
				break;
			}

			addAnimal(test.nested.data.impl.Animal_Impl.readAnimal_XmlContent(in));
		}
	}

}
