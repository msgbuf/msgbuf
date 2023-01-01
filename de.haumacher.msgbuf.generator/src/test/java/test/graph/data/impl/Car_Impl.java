package test.graph.data.impl;

/**
 * A special {@link Shape} that contains concrete monomorphic references to type in a polymorphic hierarchy.
 */
public class Car_Impl extends test.graph.data.impl.Shape_Impl implements test.graph.data.Car {

	private test.graph.data.Circle _wheel1 = null;

	private test.graph.data.Circle _wheel2 = null;

	private test.graph.data.Rectangle _body = null;

	/**
	 * Creates a {@link Car_Impl} instance.
	 *
	 * @see test.graph.data.Car#create()
	 */
	public Car_Impl() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.CAR;
	}

	@Override
	public final test.graph.data.Circle getWheel1() {
		return _wheel1;
	}

	@Override
	public test.graph.data.Car setWheel1(test.graph.data.Circle value) {
		internalSetWheel1(value);
		return this;
	}

	/** Internal setter for {@link #getWheel1()} without chain call utility. */
	protected final void internalSetWheel1(test.graph.data.Circle value) {
		_listener.beforeSet(this, WHEEL_1__PROP, value);
		_wheel1 = value;
	}

	@Override
	public final boolean hasWheel1() {
		return _wheel1 != null;
	}

	@Override
	public final test.graph.data.Circle getWheel2() {
		return _wheel2;
	}

	@Override
	public test.graph.data.Car setWheel2(test.graph.data.Circle value) {
		internalSetWheel2(value);
		return this;
	}

	/** Internal setter for {@link #getWheel2()} without chain call utility. */
	protected final void internalSetWheel2(test.graph.data.Circle value) {
		_listener.beforeSet(this, WHEEL_2__PROP, value);
		_wheel2 = value;
	}

	@Override
	public final boolean hasWheel2() {
		return _wheel2 != null;
	}

	@Override
	public final test.graph.data.Rectangle getBody() {
		return _body;
	}

	@Override
	public test.graph.data.Car setBody(test.graph.data.Rectangle value) {
		internalSetBody(value);
		return this;
	}

	/** Internal setter for {@link #getBody()} without chain call utility. */
	protected final void internalSetBody(test.graph.data.Rectangle value) {
		_listener.beforeSet(this, BODY__PROP, value);
		_body = value;
	}

	@Override
	public final boolean hasBody() {
		return _body != null;
	}

	@Override
	public test.graph.data.Car setXCoordinate(int value) {
		internalSetXCoordinate(value);
		return this;
	}

	@Override
	public test.graph.data.Car setYCoordinate(int value) {
		internalSetYCoordinate(value);
		return this;
	}

	@Override
	public String jsonType() {
		return CAR__TYPE;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			WHEEL_1__PROP, 
			WHEEL_2__PROP, 
			BODY__PROP));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
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
			case WHEEL_1__PROP: internalSetWheel1((test.graph.data.Circle) value); break;
			case WHEEL_2__PROP: internalSetWheel2((test.graph.data.Circle) value); break;
			case BODY__PROP: internalSetBody((test.graph.data.Rectangle) value); break;
			default: super.set(field, value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.graph.Scope scope, de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(scope, out);
		if (hasWheel1()) {
			out.name(WHEEL_1__PROP);
			getWheel1().writeTo(scope, out);
		}
		if (hasWheel2()) {
			out.name(WHEEL_2__PROP);
			getWheel2().writeTo(scope, out);
		}
		if (hasBody()) {
			out.name(BODY__PROP);
			getBody().writeTo(scope, out);
		}
	}

	@Override
	public void writeFieldValue(de.haumacher.msgbuf.graph.Scope scope, de.haumacher.msgbuf.json.JsonWriter out, String field) throws java.io.IOException {
		switch (field) {
			case WHEEL_1__PROP: {
				if (hasWheel1()) {
					getWheel1().writeTo(scope, out);
				} else {
					out.nullValue();
				}
				break;
			}
			case WHEEL_2__PROP: {
				if (hasWheel2()) {
					getWheel2().writeTo(scope, out);
				} else {
					out.nullValue();
				}
				break;
			}
			case BODY__PROP: {
				if (hasBody()) {
					getBody().writeTo(scope, out);
				} else {
					out.nullValue();
				}
				break;
			}
			default: super.writeFieldValue(scope, out, field);
		}
	}

	@Override
	public void readField(de.haumacher.msgbuf.graph.Scope scope, de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case WHEEL_1__PROP: setWheel1(test.graph.data.Circle.readCircle(scope, in)); break;
			case WHEEL_2__PROP: setWheel2(test.graph.data.Circle.readCircle(scope, in)); break;
			case BODY__PROP: setBody(test.graph.data.Rectangle.readRectangle(scope, in)); break;
			default: super.readField(scope, in, field);
		}
	}

	/** XML element name representing a {@link test.graph.data.Car} type. */
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

	/** Creates a new {@link test.graph.data.Car} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
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
				setWheel1(test.graph.data.impl.Circle_Impl.readCircle_XmlContent(in));
				break;
			}
			case WHEEL_2__XML_ATTR: {
				setWheel2(test.graph.data.impl.Circle_Impl.readCircle_XmlContent(in));
				break;
			}
			case BODY__XML_ATTR: {
				setBody(test.graph.data.impl.Rectangle_Impl.readRectangle_XmlContent(in));
				break;
			}
			default: {
				super.readFieldXmlElement(in, localName);
			}
		}
	}

	@Override
	public <R,A,E extends Throwable> R visit(test.graph.data.Shape.Visitor<R,A,E> v, A arg) throws E {
		return v.visit(this, arg);
	}

}
