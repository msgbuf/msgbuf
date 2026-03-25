package de.haumacher.msgbuf.json.value;

/**
 * A JSON floating-point number value.
 */
public class JsonDouble extends de.haumacher.msgbuf.json.value.JsonValue {

	/**
	 * Creates a {@link de.haumacher.msgbuf.json.value.JsonDouble} instance.
	 */
	public static de.haumacher.msgbuf.json.value.JsonDouble create() {
		return new de.haumacher.msgbuf.json.value.JsonDouble();
	}

	/** Identifier for the {@link de.haumacher.msgbuf.json.value.JsonDouble} type in JSON format. */
	public static final String JSON_DOUBLE__TYPE = "JsonDouble";

	/** @see #getValue() */
	private static final String VALUE__PROP = "value";

	/** Identifier for the {@link de.haumacher.msgbuf.json.value.JsonDouble} type in binary format. */
	static final int JSON_DOUBLE__TYPE_ID = 3;

	/** Identifier for the property {@link #getValue()} in binary format. */
	static final int VALUE__ID = 1;

	private double _value = 0.0d;

	/**
	 * Creates a {@link JsonDouble} instance.
	 *
	 * @see de.haumacher.msgbuf.json.value.JsonDouble#create()
	 */
	protected JsonDouble() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.JSON_DOUBLE;
	}

	public final double getValue() {
		return _value;
	}

	/**
	 * @see #getValue()
	 */
	public de.haumacher.msgbuf.json.value.JsonDouble setValue(double value) {
		internalSetValue(value);
		return this;
	}

	/** Internal setter for {@link #getValue()} without chain call utility. */
	protected final void internalSetValue(double value) {
		_value = value;
	}

	@Override
	public String jsonType() {
		return JSON_DOUBLE__TYPE;
	}

	/** Reads a new instance from the given reader. */
	public static de.haumacher.msgbuf.json.value.JsonDouble readJsonDouble(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		de.haumacher.msgbuf.json.value.JsonDouble result = new de.haumacher.msgbuf.json.value.JsonDouble();
		result.readContent(in);
		return result;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(VALUE__PROP);
		out.value(getValue());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case VALUE__PROP: setValue(in.nextDouble()); break;
			default: super.readField(in, field);
		}
	}

	/** The binary identifier for this concrete type in the polymorphic {@link de.haumacher.msgbuf.json.value.JsonDouble} hierarchy. */
	public int typeId() {
		return JSON_DOUBLE__TYPE_ID;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(VALUE__ID);
		out.value(getValue());
	}

	/** Reads a new instance from the given reader. */
	public static de.haumacher.msgbuf.json.value.JsonDouble readJsonDouble(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		de.haumacher.msgbuf.json.value.JsonDouble result = de.haumacher.msgbuf.json.value.JsonDouble.readJsonDouble_Content(in);
		in.endObject();
		return result;
	}

	/** Helper for creating an object of type {@link de.haumacher.msgbuf.json.value.JsonDouble} from a polymorphic composition. */
	public static de.haumacher.msgbuf.json.value.JsonDouble readJsonDouble_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		de.haumacher.msgbuf.json.value.JsonDouble result = new JsonDouble();
		result.readContent(in);
		return result;
	}

	@Override
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case VALUE__ID: setValue(in.nextDouble()); break;
			default: super.readField(in, field);
		}
	}

	/** XML element name representing a {@link de.haumacher.msgbuf.json.value.JsonDouble} type. */
	public static final String JSON_DOUBLE__XML_ELEMENT = "json-double";

	/** XML attribute or element name of a {@link #getValue} property. */
	private static final String VALUE__XML_ATTR = "value";

	@Override
	public String getXmlTagName() {
		return JSON_DOUBLE__XML_ELEMENT;
	}

	/** Serializes all fields that are written as XML attributes. */
	@Override
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeAttributes(out);
		out.writeAttribute(VALUE__XML_ATTR, Double.toString(getValue()));
	}

	/** Serializes all fields that are written as XML elements. */
	@Override
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeElements(out);
		// No element fields.
	}

	/** Creates a new {@link de.haumacher.msgbuf.json.value.JsonDouble} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static JsonDouble readJsonDouble_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		JsonDouble result = new JsonDouble();
		result.readContentXml(in);
		return result;
	}

	@Override
	protected void readFieldXmlAttribute(String name, String value) {
		switch (name) {
			case VALUE__XML_ATTR: {
				setValue(Double.parseDouble(value));
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
			case VALUE__XML_ATTR: {
				setValue(Double.parseDouble(in.getElementText()));
				break;
			}
			default: {
				super.readFieldXmlElement(in, localName);
			}
		}
	}

	/** Creates a new {@link JsonDouble} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static JsonDouble readJsonDouble(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return de.haumacher.msgbuf.json.value.JsonDouble.readJsonDouble_XmlContent(in);
	}

}
