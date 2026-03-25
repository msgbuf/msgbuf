package de.haumacher.msgbuf.json.value;

/**
 * A JSON null value.
 */
public class JsonNull extends de.haumacher.msgbuf.json.value.JsonValue {

	/**
	 * Creates a {@link de.haumacher.msgbuf.json.value.JsonNull} instance.
	 */
	public static de.haumacher.msgbuf.json.value.JsonNull create() {
		return new de.haumacher.msgbuf.json.value.JsonNull();
	}

	/** Identifier for the {@link de.haumacher.msgbuf.json.value.JsonNull} type in JSON format. */
	public static final String JSON_NULL__TYPE = "JsonNull";

	/** Identifier for the {@link de.haumacher.msgbuf.json.value.JsonNull} type in binary format. */
	static final int JSON_NULL__TYPE_ID = 5;

	/**
	 * Creates a {@link JsonNull} instance.
	 *
	 * @see de.haumacher.msgbuf.json.value.JsonNull#create()
	 */
	protected JsonNull() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.JSON_NULL;
	}

	@Override
	public String jsonType() {
		return JSON_NULL__TYPE;
	}

	/** Reads a new instance from the given reader. */
	public static de.haumacher.msgbuf.json.value.JsonNull readJsonNull(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		de.haumacher.msgbuf.json.value.JsonNull result = new de.haumacher.msgbuf.json.value.JsonNull();
		result.readContent(in);
		return result;
	}

	/** The binary identifier for this concrete type in the polymorphic {@link de.haumacher.msgbuf.json.value.JsonNull} hierarchy. */
	public int typeId() {
		return JSON_NULL__TYPE_ID;
	}

	/** Reads a new instance from the given reader. */
	public static de.haumacher.msgbuf.json.value.JsonNull readJsonNull(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		de.haumacher.msgbuf.json.value.JsonNull result = de.haumacher.msgbuf.json.value.JsonNull.readJsonNull_Content(in);
		in.endObject();
		return result;
	}

	/** Helper for creating an object of type {@link de.haumacher.msgbuf.json.value.JsonNull} from a polymorphic composition. */
	public static de.haumacher.msgbuf.json.value.JsonNull readJsonNull_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		de.haumacher.msgbuf.json.value.JsonNull result = new JsonNull();
		result.readContent(in);
		return result;
	}

	/** XML element name representing a {@link de.haumacher.msgbuf.json.value.JsonNull} type. */
	public static final String JSON_NULL__XML_ELEMENT = "json-null";

	@Override
	public String getXmlTagName() {
		return JSON_NULL__XML_ELEMENT;
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
		// No element fields.
	}

	/** Creates a new {@link de.haumacher.msgbuf.json.value.JsonNull} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static JsonNull readJsonNull_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		JsonNull result = new JsonNull();
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
			default: {
				super.readFieldXmlElement(in, localName);
			}
		}
	}

	/** Creates a new {@link JsonNull} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static JsonNull readJsonNull(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return de.haumacher.msgbuf.json.value.JsonNull.readJsonNull_XmlContent(in);
	}

}
