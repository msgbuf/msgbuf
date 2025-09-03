package test.novisitexceptions.impl;

/**
 * Implementation of {@link test.novisitexceptions.Circle}.
 */
public class Circle_Impl extends test.novisitexceptions.impl.AtomicShape_Impl implements test.novisitexceptions.Circle {

	private int _radius = 0;

	/**
	 * Creates a {@link Circle_Impl} instance.
	 *
	 * @see test.novisitexceptions.Circle#create()
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
	public test.novisitexceptions.Circle setRadius(int value) {
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
	public test.novisitexceptions.Circle setXCoordinate(int value) {
		internalSetXCoordinate(value);
		return this;
	}

	@Override
	public test.novisitexceptions.Circle setYCoordinate(int value) {
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
		tmp.addAll(test.novisitexceptions.impl.Shape_Impl.PROPERTIES);
		tmp.addAll(local);
		PROPERTIES = java.util.Collections.unmodifiableList(tmp);
	}

	@SuppressWarnings("hiding")
	static final java.util.Set<String> TRANSIENT_PROPERTIES;
	static {
		java.util.HashSet<String> tmp = new java.util.HashSet<>();
		tmp.addAll(test.novisitexceptions.impl.Shape_Impl.TRANSIENT_PROPERTIES);
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

	/** Helper for creating an object of type {@link test.novisitexceptions.Circle} from a polymorphic composition. */
	public static test.novisitexceptions.Circle readCircle_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.novisitexceptions.impl.Circle_Impl result = new Circle_Impl();
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

	/** XML element name representing a {@link test.novisitexceptions.Circle} type. */
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

	/** Creates a new {@link test.novisitexceptions.Circle} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
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
	public <R,A> R visit(test.novisitexceptions.AtomicShape.Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}

}
