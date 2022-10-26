package test.novisitexceptions;

/**
 * A rectangle.
 */
class Rectangle_Impl extends AtomicShape_Impl implements Rectangle {

	private int _width = 0;

	private int _height = 0;

	/**
	 * Creates a {@link Rectangle_Impl} instance.
	 *
	 * @see Rectangle#create()
	 */
	protected Rectangle_Impl() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.RECTANGLE;
	}

	@Override
	public final int getWidth() {
		return _width;
	}

	@Override
	public Rectangle setWidth(int value) {
		internalSetWidth(value);
		return this;
	}

	/** Internal setter for {@link #getWidth()} without chain call utility. */
	protected final void internalSetWidth(int value) {
		_listener.beforeSet(this, WIDTH__PROP, value);
		_width = value;
	}

	@Override
	public final int getHeight() {
		return _height;
	}

	@Override
	public Rectangle setHeight(int value) {
		internalSetHeight(value);
		return this;
	}

	/** Internal setter for {@link #getHeight()} without chain call utility. */
	protected final void internalSetHeight(int value) {
		_listener.beforeSet(this, HEIGHT__PROP, value);
		_height = value;
	}

	@Override
	public Rectangle setXCoordinate(int value) {
		internalSetXCoordinate(value);
		return this;
	}

	@Override
	public Rectangle setYCoordinate(int value) {
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

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
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

	@Override
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

	/** Helper for creating an object of type {@link Rectangle} from a polymorphic composition. */
	public static Rectangle readRectangle_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.novisitexceptions.Rectangle_Impl result = new Rectangle_Impl();
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

	/** XML element name representing a {@link Rectangle} type. */
	public static final String RECTANGLE__XML_ELEMENT = "rectangle";

	/** XML attribute or element name of a {@link #getWidth} property. */
	private static final String WIDTH__XML_ATTR = "w";

	/** XML attribute or element name of a {@link #getHeight} property. */
	private static final String HEIGHT__XML_ATTR = "h";

	/** Creates a new {@link Rectangle} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Rectangle_Impl readRectangle_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		Rectangle_Impl result = new Rectangle_Impl();
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

	@Override
	public <R,A> R visit(AtomicShape.Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}

}
