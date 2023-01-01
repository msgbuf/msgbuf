package test.hierarchy.data.impl;

/**
 * A shape that can be dynamically hidden.
 */
public class Optional_Impl extends test.hierarchy.data.impl.Shape_Impl implements test.hierarchy.data.Optional {

	private boolean _hidden = false;

	private test.hierarchy.data.Shape _shape = null;

	/**
	 * Creates a {@link Optional_Impl} instance.
	 *
	 * @see test.hierarchy.data.Optional#create()
	 */
	public Optional_Impl() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.OPTIONAL;
	}

	@Override
	public final boolean isHidden() {
		return _hidden;
	}

	@Override
	public test.hierarchy.data.Optional setHidden(boolean value) {
		internalSetHidden(value);
		return this;
	}

	/** Internal setter for {@link #isHidden()} without chain call utility. */
	protected final void internalSetHidden(boolean value) {
		_listener.beforeSet(this, HIDDEN__PROP, value);
		_hidden = value;
	}

	@Override
	public final test.hierarchy.data.Shape getShape() {
		return _shape;
	}

	@Override
	public test.hierarchy.data.Optional setShape(test.hierarchy.data.Shape value) {
		internalSetShape(value);
		return this;
	}

	/** Internal setter for {@link #getShape()} without chain call utility. */
	protected final void internalSetShape(test.hierarchy.data.Shape value) {
		_listener.beforeSet(this, SHAPE__PROP, value);
		_shape = value;
	}

	@Override
	public final boolean hasShape() {
		return _shape != null;
	}

	@Override
	public test.hierarchy.data.Optional setXCoordinate(int value) {
		internalSetXCoordinate(value);
		return this;
	}

	@Override
	public test.hierarchy.data.Optional setYCoordinate(int value) {
		internalSetYCoordinate(value);
		return this;
	}

	@Override
	public test.hierarchy.data.Optional setColor(test.hierarchy.data.Color value) {
		internalSetColor(value);
		return this;
	}

	@Override
	public String jsonType() {
		return OPTIONAL__TYPE;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			HIDDEN__PROP, 
			SHAPE__PROP));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case HIDDEN__PROP: return isHidden();
			case SHAPE__PROP: return getShape();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case HIDDEN__PROP: internalSetHidden((boolean) value); break;
			case SHAPE__PROP: internalSetShape((test.hierarchy.data.Shape) value); break;
			default: super.set(field, value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(HIDDEN__PROP);
		out.value(isHidden());
		if (hasShape()) {
			out.name(SHAPE__PROP);
			getShape().writeTo(out);
		}
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case HIDDEN__PROP: setHidden(in.nextBoolean()); break;
			case SHAPE__PROP: setShape(test.hierarchy.data.Shape.readShape(in)); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public int typeId() {
		return OPTIONAL__TYPE_ID;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(HIDDEN__ID);
		out.value(isHidden());
		if (hasShape()) {
			out.name(SHAPE__ID);
			getShape().writeTo(out);
		}
	}

	/** Helper for creating an object of type {@link test.hierarchy.data.Optional} from a polymorphic composition. */
	public static test.hierarchy.data.Optional readOptional_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.hierarchy.data.impl.Optional_Impl result = new Optional_Impl();
		result.readContent(in);
		return result;
	}

	@Override
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case HIDDEN__ID: setHidden(in.nextBoolean()); break;
			case SHAPE__ID: setShape(test.hierarchy.data.Shape.readShape(in)); break;
			default: super.readField(in, field);
		}
	}

	/** XML element name representing a {@link test.hierarchy.data.Optional} type. */
	public static final String OPTIONAL__XML_ELEMENT = "optional";

	/** XML attribute or element name of a {@link #isHidden} property. */
	private static final String HIDDEN__XML_ATTR = "hidden";

	/** XML attribute or element name of a {@link #getShape} property. */
	private static final String SHAPE__XML_ATTR = "shape";

	@Override
	public String getXmlTagName() {
		return OPTIONAL__XML_ELEMENT;
	}

	/** Serializes all fields that are written as XML attributes. */
	@Override
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeAttributes(out);
		out.writeAttribute(HIDDEN__XML_ATTR, Boolean.toString(isHidden()));
	}

	/** Serializes all fields that are written as XML elements. */
	@Override
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeElements(out);
		if (hasShape()) {
			out.writeStartElement(SHAPE__XML_ATTR);
			getShape().writeTo(out);
			out.writeEndElement();
		}
	}

	/** Creates a new {@link test.hierarchy.data.Optional} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Optional_Impl readOptional_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		Optional_Impl result = new Optional_Impl();
		result.readContentXml(in);
		return result;
	}

	@Override
	protected void readFieldXmlAttribute(String name, String value) {
		switch (name) {
			case HIDDEN__XML_ATTR: {
				setHidden(Boolean.parseBoolean(value));
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
			case HIDDEN__XML_ATTR: {
				setHidden(Boolean.parseBoolean(in.getElementText()));
				break;
			}
			case test.hierarchy.data.impl.Circle_Impl.CIRCLE__XML_ELEMENT: {
				setShape(test.hierarchy.data.impl.Circle_Impl.readCircle_XmlContent(in));
				break;
			}
			case test.hierarchy.data.impl.Rectangle_Impl.RECTANGLE__XML_ELEMENT: {
				setShape(test.hierarchy.data.impl.Rectangle_Impl.readRectangle_XmlContent(in));
				break;
			}
			case test.hierarchy.data.impl.Group_Impl.GROUP__XML_ELEMENT: {
				setShape(test.hierarchy.data.impl.Group_Impl.readGroup_XmlContent(in));
				break;
			}
			case test.hierarchy.data.impl.Optional_Impl.OPTIONAL__XML_ELEMENT: {
				setShape(test.hierarchy.data.impl.Optional_Impl.readOptional_XmlContent(in));
				break;
			}
			case test.hierarchy.data.impl.Car_Impl.CAR__XML_ELEMENT: {
				setShape(test.hierarchy.data.impl.Car_Impl.readCar_XmlContent(in));
				break;
			}
			case SHAPE__XML_ATTR: {
				in.nextTag();
				setShape(test.hierarchy.data.impl.Shape_Impl.readShape_XmlContent(in));
				internalSkipUntilMatchingEndElement(in);
				break;
			}
			default: {
				super.readFieldXmlElement(in, localName);
			}
		}
	}

	@Override
	public <R,A,E extends Throwable> R visit(test.hierarchy.data.Shape.Visitor<R,A,E> v, A arg) throws E {
		return v.visit(this, arg);
	}

}
