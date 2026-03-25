package de.haumacher.msgbuf.json.value;

/**
 * A JSON boolean value.
 */
public class JsonBoolean extends de.haumacher.msgbuf.json.value.JsonValue {

	/**
	 * Creates a {@link de.haumacher.msgbuf.json.value.JsonBoolean} instance.
	 */
	public static de.haumacher.msgbuf.json.value.JsonBoolean create() {
		return new de.haumacher.msgbuf.json.value.JsonBoolean();
	}

	/** Identifier for the {@link de.haumacher.msgbuf.json.value.JsonBoolean} type in JSON format. */
	public static final String JSON_BOOLEAN__TYPE = "JsonBoolean";

	/** @see #isValue() */
	private static final String VALUE__PROP = "value";

	/** Identifier for the {@link de.haumacher.msgbuf.json.value.JsonBoolean} type in binary format. */
	static final int JSON_BOOLEAN__TYPE_ID = 4;

	/** Identifier for the property {@link #isValue()} in binary format. */
	static final int VALUE__ID = 1;

	private boolean _value = false;

	/**
	 * Creates a {@link JsonBoolean} instance.
	 *
	 * @see de.haumacher.msgbuf.json.value.JsonBoolean#create()
	 */
	protected JsonBoolean() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.JSON_BOOLEAN;
	}

	public final boolean isValue() {
		return _value;
	}

	/**
	 * @see #isValue()
	 */
	public de.haumacher.msgbuf.json.value.JsonBoolean setValue(boolean value) {
		internalSetValue(value);
		return this;
	}

	/** Internal setter for {@link #isValue()} without chain call utility. */
	protected final void internalSetValue(boolean value) {
		_value = value;
	}

	@Override
	public String jsonType() {
		return JSON_BOOLEAN__TYPE;
	}

	/** Reads a new instance from the given reader. */
	public static de.haumacher.msgbuf.json.value.JsonBoolean readJsonBoolean(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		de.haumacher.msgbuf.json.value.JsonBoolean result = new de.haumacher.msgbuf.json.value.JsonBoolean();
		result.readContent(in);
		return result;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(VALUE__PROP);
		out.value(isValue());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case VALUE__PROP: setValue(in.nextBoolean()); break;
			default: super.readField(in, field);
		}
	}

	/** The binary identifier for this concrete type in the polymorphic {@link de.haumacher.msgbuf.json.value.JsonBoolean} hierarchy. */
	public int typeId() {
		return JSON_BOOLEAN__TYPE_ID;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(VALUE__ID);
		out.value(isValue());
	}

	/** Reads a new instance from the given reader. */
	public static de.haumacher.msgbuf.json.value.JsonBoolean readJsonBoolean(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		de.haumacher.msgbuf.json.value.JsonBoolean result = de.haumacher.msgbuf.json.value.JsonBoolean.readJsonBoolean_Content(in);
		in.endObject();
		return result;
	}

	/** Helper for creating an object of type {@link de.haumacher.msgbuf.json.value.JsonBoolean} from a polymorphic composition. */
	public static de.haumacher.msgbuf.json.value.JsonBoolean readJsonBoolean_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		de.haumacher.msgbuf.json.value.JsonBoolean result = new JsonBoolean();
		result.readContent(in);
		return result;
	}

	@Override
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case VALUE__ID: setValue(in.nextBoolean()); break;
			default: super.readField(in, field);
		}
	}

	/** XML element name representing a {@link de.haumacher.msgbuf.json.value.JsonBoolean} type. */
	public static final String JSON_BOOLEAN__XML_ELEMENT = "json-boolean";

	/** XML attribute or element name of a {@link #isValue} property. */
	private static final String VALUE__XML_ATTR = "value";

	@Override
	public String getXmlTagName() {
		return JSON_BOOLEAN__XML_ELEMENT;
	}

	/** Serializes all fields that are written as XML attributes. */
	@Override
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeAttributes(out);
		out.writeAttribute(VALUE__XML_ATTR, Boolean.toString(isValue()));
	}

	/** Serializes all fields that are written as XML elements. */
	@Override
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeElements(out);
		// No element fields.
	}

	/** Creates a new {@link de.haumacher.msgbuf.json.value.JsonBoolean} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static JsonBoolean readJsonBoolean_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		JsonBoolean result = new JsonBoolean();
		result.readContentXml(in);
		return result;
	}

	@Override
	protected void readFieldXmlAttribute(String name, String value) {
		switch (name) {
			case VALUE__XML_ATTR: {
				setValue(Boolean.parseBoolean(value));
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
				setValue(Boolean.parseBoolean(in.getElementText()));
				break;
			}
			default: {
				super.readFieldXmlElement(in, localName);
			}
		}
	}

	/** Creates a new {@link JsonBoolean} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static JsonBoolean readJsonBoolean(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return de.haumacher.msgbuf.json.value.JsonBoolean.readJsonBoolean_XmlContent(in);
	}

}
