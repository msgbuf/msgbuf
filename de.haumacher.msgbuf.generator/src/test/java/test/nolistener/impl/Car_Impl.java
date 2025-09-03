package test.nolistener.impl;

/**
 * Implementation of {@link test.nolistener.Car}.
 */
public class Car_Impl extends test.nolistener.impl.Shape_Impl implements test.nolistener.Car {

	private test.nolistener.Circle _wheel1 = null;

	private test.nolistener.Circle _wheel2 = null;

	private test.nolistener.Rectangle _body = null;

	/**
	 * Creates a {@link Car_Impl} instance.
	 *
	 * @see test.nolistener.Car#create()
	 */
	public Car_Impl() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.CAR;
	}

	@Override
	public final test.nolistener.Circle getWheel1() {
		return _wheel1;
	}

	@Override
	public test.nolistener.Car setWheel1(test.nolistener.Circle value) {
		internalSetWheel1(value);
		return this;
	}

	/** Internal setter for {@link #getWheel1()} without chain call utility. */
	protected final void internalSetWheel1(test.nolistener.Circle value) {
		_wheel1 = value;
	}

	@Override
	public final boolean hasWheel1() {
		return _wheel1 != null;
	}

	@Override
	public final test.nolistener.Circle getWheel2() {
		return _wheel2;
	}

	@Override
	public test.nolistener.Car setWheel2(test.nolistener.Circle value) {
		internalSetWheel2(value);
		return this;
	}

	/** Internal setter for {@link #getWheel2()} without chain call utility. */
	protected final void internalSetWheel2(test.nolistener.Circle value) {
		_wheel2 = value;
	}

	@Override
	public final boolean hasWheel2() {
		return _wheel2 != null;
	}

	@Override
	public final test.nolistener.Rectangle getBody() {
		return _body;
	}

	@Override
	public test.nolistener.Car setBody(test.nolistener.Rectangle value) {
		internalSetBody(value);
		return this;
	}

	/** Internal setter for {@link #getBody()} without chain call utility. */
	protected final void internalSetBody(test.nolistener.Rectangle value) {
		_body = value;
	}

	@Override
	public final boolean hasBody() {
		return _body != null;
	}

	@Override
	public test.nolistener.Car setXCoordinate(int value) {
		internalSetXCoordinate(value);
		return this;
	}

	@Override
	public test.nolistener.Car setYCoordinate(int value) {
		internalSetYCoordinate(value);
		return this;
	}

	@Override
	public String jsonType() {
		return CAR__TYPE;
	}

	@SuppressWarnings("hiding")
	static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			WHEEL_1__PROP, 
			WHEEL_2__PROP, 
			BODY__PROP);
		java.util.List<String> tmp = new java.util.ArrayList<>();
		tmp.addAll(test.nolistener.impl.Shape_Impl.PROPERTIES);
		tmp.addAll(local);
		PROPERTIES = java.util.Collections.unmodifiableList(tmp);
	}

	@SuppressWarnings("hiding")
	static final java.util.Set<String> TRANSIENT_PROPERTIES;
	static {
		java.util.HashSet<String> tmp = new java.util.HashSet<>();
		tmp.addAll(test.nolistener.impl.Shape_Impl.TRANSIENT_PROPERTIES);
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
			case WHEEL_1__PROP: return getWheel1();
			case WHEEL_2__PROP: return getWheel2();
			case BODY__PROP: return getBody();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case WHEEL_1__PROP: internalSetWheel1((test.nolistener.Circle) value); break;
			case WHEEL_2__PROP: internalSetWheel2((test.nolistener.Circle) value); break;
			case BODY__PROP: internalSetBody((test.nolistener.Rectangle) value); break;
			default: super.set(field, value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		if (hasWheel1()) {
			out.name(WHEEL_1__PROP);
			getWheel1().writeContent(out);
		}
		if (hasWheel2()) {
			out.name(WHEEL_2__PROP);
			getWheel2().writeContent(out);
		}
		if (hasBody()) {
			out.name(BODY__PROP);
			getBody().writeContent(out);
		}
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case WHEEL_1__PROP: setWheel1(test.nolistener.Circle.readCircle(in)); break;
			case WHEEL_2__PROP: setWheel2(test.nolistener.Circle.readCircle(in)); break;
			case BODY__PROP: setBody(test.nolistener.Rectangle.readRectangle(in)); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public int typeId() {
		return CAR__TYPE_ID;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		super.writeFields(out);
		if (hasWheel1()) {
			out.name(WHEEL_1__ID);
			getWheel1().writeTo(out);
		}
		if (hasWheel2()) {
			out.name(WHEEL_2__ID);
			getWheel2().writeTo(out);
		}
		if (hasBody()) {
			out.name(BODY__ID);
			getBody().writeTo(out);
		}
	}

	/** Helper for creating an object of type {@link test.nolistener.Car} from a polymorphic composition. */
	public static test.nolistener.Car readCar_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.nolistener.impl.Car_Impl result = new Car_Impl();
		result.readContent(in);
		return result;
	}

	@Override
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case WHEEL_1__ID: setWheel1(test.nolistener.Circle.readCircle(in)); break;
			case WHEEL_2__ID: setWheel2(test.nolistener.Circle.readCircle(in)); break;
			case BODY__ID: setBody(test.nolistener.Rectangle.readRectangle(in)); break;
			default: super.readField(in, field);
		}
	}

	/** XML element name representing a {@link test.nolistener.Car} type. */
	public static final String CAR__XML_ELEMENT = "car";

	/** XML attribute or element name of a {@link #getWheel1} property. */
	private static final String WHEEL_1__XML_ATTR = "wheel-1";

	/** XML attribute or element name of a {@link #getWheel2} property. */
	private static final String WHEEL_2__XML_ATTR = "wheel-2";

	/** XML attribute or element name of a {@link #getBody} property. */
	private static final String BODY__XML_ATTR = "body";

	@Override
	public String getXmlTagName() {
		return CAR__XML_ELEMENT;
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
		if (hasWheel1()) {
			out.writeStartElement(WHEEL_1__XML_ATTR);
			getWheel1().writeContent(out);
			out.writeEndElement();
		}
		if (hasWheel2()) {
			out.writeStartElement(WHEEL_2__XML_ATTR);
			getWheel2().writeContent(out);
			out.writeEndElement();
		}
		if (hasBody()) {
			out.writeStartElement(BODY__XML_ATTR);
			getBody().writeContent(out);
			out.writeEndElement();
		}
	}

	/** Creates a new {@link test.nolistener.Car} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Car_Impl readCar_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		Car_Impl result = new Car_Impl();
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
			case WHEEL_1__XML_ATTR: {
				setWheel1(test.nolistener.impl.Circle_Impl.readCircle_XmlContent(in));
				break;
			}
			case WHEEL_2__XML_ATTR: {
				setWheel2(test.nolistener.impl.Circle_Impl.readCircle_XmlContent(in));
				break;
			}
			case BODY__XML_ATTR: {
				setBody(test.nolistener.impl.Rectangle_Impl.readRectangle_XmlContent(in));
				break;
			}
			default: {
				super.readFieldXmlElement(in, localName);
			}
		}
	}

	@Override
	public <R,A,E extends Throwable> R visit(test.nolistener.Shape.Visitor<R,A,E> v, A arg) throws E {
		return v.visit(this, arg);
	}

}
