package test.nointerfaces;

/**
 * A rectangle.
 */
public class Rectangle extends AtomicShape {

	/**
	 * Creates a {@link test.nointerfaces.Rectangle} instance.
	 */
	public static test.nointerfaces.Rectangle create() {
		return new test.nointerfaces.Rectangle();
	}

	/** Identifier for the {@link test.nointerfaces.Rectangle} type in JSON format. */
	public static final String RECTANGLE__TYPE = "Rectangle";

	/** @see #getWidth() */
	public static final String WIDTH__PROP = "w";

	/** @see #getHeight() */
	public static final String HEIGHT__PROP = "h";

	/** Identifier for the {@link test.nointerfaces.Rectangle} type in binary format. */
	static final int RECTANGLE__TYPE_ID = 2;

	/** Identifier for the property {@link #getWidth()} in binary format. */
	static final int WIDTH__ID = 3;

	/** Identifier for the property {@link #getHeight()} in binary format. */
	static final int HEIGHT__ID = 4;

	private int _width = 0;

	private int _height = 0;

	/**
	 * Creates a {@link Rectangle} instance.
	 *
	 * @see test.nointerfaces.Rectangle#create()
	 */
	protected Rectangle() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.RECTANGLE;
	}

	/**
	 * The width of this {@link Rectangle}.
	 *
	 * <p>
	 * The top left corner of this {@Rectangle} is at ({@link #getXCoordinate()}, {@link #getYCoordinate()}).
	 * </p>
	 *
	 * @see #getHeight()
	 */
	public final int getWidth() {
		return _width;
	}

	/**
	 * @see #getWidth()
	 */
	public test.nointerfaces.Rectangle setWidth(int value) {
		internalSetWidth(value);
		return this;
	}

	/** Internal setter for {@link #getWidth()} without chain call utility. */
	protected final void internalSetWidth(int value) {
		_listener.beforeSet(this, WIDTH__PROP, value);
		_width = value;
	}

	/**
	 * The width of this {@link Rectangle}.
	 *
	 * @see #getWidth()
	 */
	public final int getHeight() {
		return _height;
	}

	/**
	 * @see #getHeight()
	 */
	public test.nointerfaces.Rectangle setHeight(int value) {
		internalSetHeight(value);
		return this;
	}

	/** Internal setter for {@link #getHeight()} without chain call utility. */
	protected final void internalSetHeight(int value) {
		_listener.beforeSet(this, HEIGHT__PROP, value);
		_height = value;
	}

	@Override
	public test.nointerfaces.Rectangle setXCoordinate(int value) {
		internalSetXCoordinate(value);
		return this;
	}

	@Override
	public test.nointerfaces.Rectangle setYCoordinate(int value) {
		internalSetYCoordinate(value);
		return this;
	}

	@Override
	public String jsonType() {
		return RECTANGLE__TYPE;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			WIDTH__PROP, 
			HEIGHT__PROP));

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
			case WIDTH__PROP: return getWidth();
			case HEIGHT__PROP: return getHeight();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case WIDTH__PROP: internalSetWidth((int) value); break;
			case HEIGHT__PROP: internalSetHeight((int) value); break;
			default: super.set(field, value); break;
		}
	}

	/** Reads a new instance from the given reader. */
	public static test.nointerfaces.Rectangle readRectangle(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.nointerfaces.Rectangle result = new test.nointerfaces.Rectangle();
		result.readContent(in);
		return result;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(WIDTH__PROP);
		out.value(getWidth());
		out.name(HEIGHT__PROP);
		out.value(getHeight());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case WIDTH__PROP: setWidth(in.nextInt()); break;
			case HEIGHT__PROP: setHeight(in.nextInt()); break;
			default: super.readField(in, field);
		}
	}

	/** The binary identifier for this concrete type in the polymorphic {@link test.nointerfaces.Rectangle} hierarchy. */
	public int typeId() {
		return RECTANGLE__TYPE_ID;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(WIDTH__ID);
		out.value(getWidth());
		out.name(HEIGHT__ID);
		out.value(getHeight());
	}

	/** Reads a new instance from the given reader. */
	public static test.nointerfaces.Rectangle readRectangle(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.nointerfaces.Rectangle result = test.nointerfaces.Rectangle.readRectangle_Content(in);
		in.endObject();
		return result;
	}

	/** Helper for creating an object of type {@link test.nointerfaces.Rectangle} from a polymorphic composition. */
	public static test.nointerfaces.Rectangle readRectangle_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.nointerfaces.Rectangle result = new Rectangle();
		result.readContent(in);
		return result;
	}

	@Override
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case WIDTH__ID: setWidth(in.nextInt()); break;
			case HEIGHT__ID: setHeight(in.nextInt()); break;
			default: super.readField(in, field);
		}
	}

	/** XML element name representing a {@link test.nointerfaces.Rectangle} type. */
	public static final String RECTANGLE__XML_ELEMENT = "rectangle";

	/** XML attribute or element name of a {@link #getWidth} property. */
	private static final String WIDTH__XML_ATTR = "w";

	/** XML attribute or element name of a {@link #getHeight} property. */
	private static final String HEIGHT__XML_ATTR = "h";

	@Override
	public String getXmlTagName() {
		return RECTANGLE__XML_ELEMENT;
	}

	/** Serializes all fields that are written as XML attributes. */
	@Override
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeAttributes(out);
		out.writeAttribute(WIDTH__XML_ATTR, Integer.toString(getWidth()));
		out.writeAttribute(HEIGHT__XML_ATTR, Integer.toString(getHeight()));
	}

	/** Serializes all fields that are written as XML elements. */
	@Override
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeElements(out);
		// No element fields.
	}

	/** Creates a new {@link test.nointerfaces.Rectangle} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Rectangle readRectangle_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		Rectangle result = new Rectangle();
		result.readContentXml(in);
		return result;
	}

	@Override
	protected void readFieldXmlAttribute(String name, String value) {
		switch (name) {
			case WIDTH__XML_ATTR: {
				setWidth(Integer.parseInt(value));
				break;
			}
			case HEIGHT__XML_ATTR: {
				setHeight(Integer.parseInt(value));
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
			case WIDTH__XML_ATTR: {
				setWidth(Integer.parseInt(in.getElementText()));
				break;
			}
			case HEIGHT__XML_ATTR: {
				setHeight(Integer.parseInt(in.getElementText()));
				break;
			}
			default: {
				super.readFieldXmlElement(in, localName);
			}
		}
	}

	/** Creates a new {@link Rectangle} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Rectangle readRectangle(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.nointerfaces.Rectangle.readRectangle_XmlContent(in);
	}

	@Override
	public <R,A,E extends Throwable> R visit(test.nointerfaces.AtomicShape.Visitor<R,A,E> v, A arg) throws E {
		return v.visit(this, arg);
	}

}
