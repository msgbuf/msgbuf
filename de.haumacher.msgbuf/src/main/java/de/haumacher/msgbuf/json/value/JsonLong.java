package de.haumacher.msgbuf.json.value;

/**
 * A JSON integer number value (fits in a long).
 */
public class JsonLong extends de.haumacher.msgbuf.json.value.JsonValue {

	/**
	 * Creates a {@link de.haumacher.msgbuf.json.value.JsonLong} instance.
	 */
	public static de.haumacher.msgbuf.json.value.JsonLong create() {
		return new de.haumacher.msgbuf.json.value.JsonLong();
	}

	/** Identifier for the {@link de.haumacher.msgbuf.json.value.JsonLong} type in JSON format. */
	public static final String JSON_LONG__TYPE = "JsonLong";

	/** @see #getValue() */
	private static final String VALUE__PROP = "value";

	/** Identifier for the {@link de.haumacher.msgbuf.json.value.JsonLong} type in binary format. */
	static final int JSON_LONG__TYPE_ID = 2;

	/** Identifier for the property {@link #getValue()} in binary format. */
	static final int VALUE__ID = 1;

	private long _value = 0L;

	/**
	 * Creates a {@link JsonLong} instance.
	 *
	 * @see de.haumacher.msgbuf.json.value.JsonLong#create()
	 */
	protected JsonLong() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.JSON_LONG;
	}

	public final long getValue() {
		return _value;
	}

	/**
	 * @see #getValue()
	 */
	public de.haumacher.msgbuf.json.value.JsonLong setValue(long value) {
		internalSetValue(value);
		return this;
	}

	/** Internal setter for {@link #getValue()} without chain call utility. */
	protected final void internalSetValue(long value) {
		_value = value;
	}

	@Override
	public String jsonType() {
		return JSON_LONG__TYPE;
	}

	/** Reads a new instance from the given reader. */
	public static de.haumacher.msgbuf.json.value.JsonLong readJsonLong(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		de.haumacher.msgbuf.json.value.JsonLong result = new de.haumacher.msgbuf.json.value.JsonLong();
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
			case VALUE__PROP: setValue(in.nextLong()); break;
			default: super.readField(in, field);
		}
	}

	/** The binary identifier for this concrete type in the polymorphic {@link de.haumacher.msgbuf.json.value.JsonLong} hierarchy. */
	public int typeId() {
		return JSON_LONG__TYPE_ID;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(VALUE__ID);
		out.value(getValue());
	}

	/** Reads a new instance from the given reader. */
	public static de.haumacher.msgbuf.json.value.JsonLong readJsonLong(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		de.haumacher.msgbuf.json.value.JsonLong result = de.haumacher.msgbuf.json.value.JsonLong.readJsonLong_Content(in);
		in.endObject();
		return result;
	}

	/** Helper for creating an object of type {@link de.haumacher.msgbuf.json.value.JsonLong} from a polymorphic composition. */
	public static de.haumacher.msgbuf.json.value.JsonLong readJsonLong_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		de.haumacher.msgbuf.json.value.JsonLong result = new JsonLong();
		result.readContent(in);
		return result;
	}

	@Override
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case VALUE__ID: setValue(in.nextLong()); break;
			default: super.readField(in, field);
		}
	}

	/** XML element name representing a {@link de.haumacher.msgbuf.json.value.JsonLong} type. */
	public static final String JSON_LONG__XML_ELEMENT = "json-long";

	/** XML attribute or element name of a {@link #getValue} property. */
	private static final String VALUE__XML_ATTR = "value";

	@Override
	public String getXmlTagName() {
		return JSON_LONG__XML_ELEMENT;
	}

	/** Serializes all fields that are written as XML attributes. */
	@Override
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeAttributes(out);
		out.writeAttribute(VALUE__XML_ATTR, Long.toString(getValue()));
	}

	/** Serializes all fields that are written as XML elements. */
	@Override
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeElements(out);
		// No element fields.
	}

	/** Creates a new {@link de.haumacher.msgbuf.json.value.JsonLong} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static JsonLong readJsonLong_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		JsonLong result = new JsonLong();
		result.readContentXml(in);
		return result;
	}

	@Override
	protected void readFieldXmlAttribute(String name, String value) {
		switch (name) {
			case VALUE__XML_ATTR: {
				setValue(Long.parseLong(value));
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
				setValue(Long.parseLong(in.getElementText()));
				break;
			}
			default: {
				super.readFieldXmlElement(in, localName);
			}
		}
	}

	/** Creates a new {@link JsonLong} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static JsonLong readJsonLong(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return de.haumacher.msgbuf.json.value.JsonLong.readJsonLong_XmlContent(in);
	}

}
