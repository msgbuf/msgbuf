package test.nointerfaces;

/**
 * A circle {@link Shape}.
 */
public class Circle extends AtomicShape {

	/**
	 * Creates a {@link test.nointerfaces.Circle} instance.
	 */
	public static test.nointerfaces.Circle create() {
		return new test.nointerfaces.Circle();
	}

	/** Identifier for the {@link test.nointerfaces.Circle} type in JSON format. */
	public static final String CIRCLE__TYPE = "Circle";

	/** @see #getRadius() */
	public static final String RADIUS__PROP = "r";

	/** Identifier for the {@link test.nointerfaces.Circle} type in binary format. */
	static final int CIRCLE__TYPE_ID = 1;

	/** Identifier for the property {@link #getRadius()} in binary format. */
	static final int RADIUS__ID = 3;

	private int _radius = 0;

	/**
	 * Creates a {@link Circle} instance.
	 *
	 * @see test.nointerfaces.Circle#create()
	 */
	protected Circle() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.CIRCLE;
	}

	/**
	 * The radius of this {@link Circle} around its coordinate origin at ({@link #getXCoordinate()}, {@link #getYCoordinate()}).
	 */
	public final int getRadius() {
		return _radius;
	}

	/**
	 * @see #getRadius()
	 */
	public test.nointerfaces.Circle setRadius(int value) {
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
	public test.nointerfaces.Circle setXCoordinate(int value) {
		internalSetXCoordinate(value);
		return this;
	}

	@Override
	public test.nointerfaces.Circle setYCoordinate(int value) {
		internalSetYCoordinate(value);
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
		tmp.addAll(test.nointerfaces.Shape.PROPERTIES);
		tmp.addAll(local);
		PROPERTIES = java.util.Collections.unmodifiableList(tmp);
	}

	@SuppressWarnings("hiding")
	static final java.util.Set<String> TRANSIENT_PROPERTIES;
	static {
		java.util.HashSet<String> tmp = new java.util.HashSet<>();
		tmp.addAll(test.nointerfaces.Shape.TRANSIENT_PROPERTIES);
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

	/** Reads a new instance from the given reader. */
	public static test.nointerfaces.Circle readCircle(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.nointerfaces.Circle result = new test.nointerfaces.Circle();
		result.readContent(in);
		return result;
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

	/** The binary identifier for this concrete type in the polymorphic {@link test.nointerfaces.Circle} hierarchy. */
	public int typeId() {
		return CIRCLE__TYPE_ID;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(RADIUS__ID);
		out.value(getRadius());
	}

	/** Reads a new instance from the given reader. */
	public static test.nointerfaces.Circle readCircle(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.nointerfaces.Circle result = test.nointerfaces.Circle.readCircle_Content(in);
		in.endObject();
		return result;
	}

	/** Helper for creating an object of type {@link test.nointerfaces.Circle} from a polymorphic composition. */
	public static test.nointerfaces.Circle readCircle_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.nointerfaces.Circle result = new Circle();
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

	/** XML element name representing a {@link test.nointerfaces.Circle} type. */
	public static final String CIRCLE__XML_ELEMENT = "circle";

	/** XML attribute or element name of a {@link #getRadius} property. */
	private static final String RADIUS__XML_ATTR = "r";

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

	/** Creates a new {@link test.nointerfaces.Circle} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Circle readCircle_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		Circle result = new Circle();
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

	/** Creates a new {@link Circle} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Circle readCircle(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.nointerfaces.Circle.readCircle_XmlContent(in);
	}

	@Override
	public <R,A,E extends Throwable> R visit(test.nointerfaces.AtomicShape.Visitor<R,A,E> v, A arg) throws E {
		return v.visit(this, arg);
	}

}
