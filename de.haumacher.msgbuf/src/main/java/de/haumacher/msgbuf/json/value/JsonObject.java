package de.haumacher.msgbuf.json.value;

/**
 * A JSON object value (ordered map of string keys to JSON values).
 */
public class JsonObject extends de.haumacher.msgbuf.json.value.JsonValue {

	/**
	 * Creates a {@link de.haumacher.msgbuf.json.value.JsonObject} instance.
	 */
	public static de.haumacher.msgbuf.json.value.JsonObject create() {
		return new de.haumacher.msgbuf.json.value.JsonObject();
	}

	/** Identifier for the {@link de.haumacher.msgbuf.json.value.JsonObject} type in JSON format. */
	public static final String JSON_OBJECT__TYPE = "JsonObject";

	/** @see #getEntries() */
	private static final String ENTRIES__PROP = "entries";

	/** Identifier for the {@link de.haumacher.msgbuf.json.value.JsonObject} type in binary format. */
	static final int JSON_OBJECT__TYPE_ID = 7;

	/** Identifier for the property {@link #getEntries()} in binary format. */
	static final int ENTRIES__ID = 1;

	private final java.util.Map<String, de.haumacher.msgbuf.json.value.JsonValue> _entries = new java.util.LinkedHashMap<>();

	/**
	 * Creates a {@link JsonObject} instance.
	 *
	 * @see de.haumacher.msgbuf.json.value.JsonObject#create()
	 */
	protected JsonObject() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.JSON_OBJECT;
	}

	public final java.util.Map<String, de.haumacher.msgbuf.json.value.JsonValue> getEntries() {
		return _entries;
	}

	/**
	 * @see #getEntries()
	 */
	public de.haumacher.msgbuf.json.value.JsonObject setEntries(java.util.Map<String, de.haumacher.msgbuf.json.value.JsonValue> value) {
		internalSetEntries(value);
		return this;
	}

	/** Internal setter for {@link #getEntries()} without chain call utility. */
	protected final void internalSetEntries(java.util.Map<String, de.haumacher.msgbuf.json.value.JsonValue> value) {
		if (value == null) throw new IllegalArgumentException("Property 'entries' cannot be null.");
		_entries.clear();
		_entries.putAll(value);
	}

	/**
	 * Adds a key value pair to the {@link #getEntries()} map.
	 */
	public de.haumacher.msgbuf.json.value.JsonObject putEntry(String key, de.haumacher.msgbuf.json.value.JsonValue value) {
		internalPutEntry(key, value);
		return this;
	}

	/** Implementation of {@link #putEntry(String, de.haumacher.msgbuf.json.value.JsonValue)} without chain call utility. */
	protected final void  internalPutEntry(String key, de.haumacher.msgbuf.json.value.JsonValue value) {
		if (_entries.containsKey(key)) {
			throw new IllegalArgumentException("Property 'entries' already contains a value for key '" + key + "'.");
		}
		_entries.put(key, value);
	}

	/**
	 * Removes a key from the {@link #getEntries()} map.
	 */
	public final void removeEntry(String key) {
		_entries.remove(key);
	}

	@Override
	public String jsonType() {
		return JSON_OBJECT__TYPE;
	}

	/** Reads a new instance from the given reader. */
	public static de.haumacher.msgbuf.json.value.JsonObject readJsonObject(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		de.haumacher.msgbuf.json.value.JsonObject result = new de.haumacher.msgbuf.json.value.JsonObject();
		result.readContent(in);
		return result;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(ENTRIES__PROP);
		out.beginObject();
		for (java.util.Map.Entry<String,de.haumacher.msgbuf.json.value.JsonValue> entry : getEntries().entrySet()) {
			out.name(entry.getKey());
			entry.getValue().writeTo(out);
		}
		out.endObject();
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case ENTRIES__PROP: {
				java.util.Map<String, de.haumacher.msgbuf.json.value.JsonValue> newValue = new java.util.LinkedHashMap<>();
				in.beginObject();
				while (in.hasNext()) {
					newValue.put(in.nextName(), de.haumacher.msgbuf.json.value.JsonValue.readJsonValue(in));
				}
				in.endObject();
				setEntries(newValue);
				break;
			}
			default: super.readField(in, field);
		}
	}

	/** The binary identifier for this concrete type in the polymorphic {@link de.haumacher.msgbuf.json.value.JsonObject} hierarchy. */
	public int typeId() {
		return JSON_OBJECT__TYPE_ID;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(ENTRIES__ID);
		{
			out.beginArray(de.haumacher.msgbuf.binary.DataType.OBJECT, getEntries().size());
			for (java.util.Map.Entry<String,de.haumacher.msgbuf.json.value.JsonValue> entry : getEntries().entrySet()) {
				out.beginObject();
				out.name(1);
				out.value(entry.getKey());
				out.name(2);
				entry.getValue().writeTo(out);
				out.endObject();
			}
			out.endArray();
		}
	}

	/** Reads a new instance from the given reader. */
	public static de.haumacher.msgbuf.json.value.JsonObject readJsonObject(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		de.haumacher.msgbuf.json.value.JsonObject result = de.haumacher.msgbuf.json.value.JsonObject.readJsonObject_Content(in);
		in.endObject();
		return result;
	}

	/** Helper for creating an object of type {@link de.haumacher.msgbuf.json.value.JsonObject} from a polymorphic composition. */
	public static de.haumacher.msgbuf.json.value.JsonObject readJsonObject_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		de.haumacher.msgbuf.json.value.JsonObject result = new JsonObject();
		result.readContent(in);
		return result;
	}

	@Override
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case ENTRIES__ID: {
				in.beginArray();
				while (in.hasNext()) {
					in.beginObject();
					String key = "";
					de.haumacher.msgbuf.json.value.JsonValue value = null;
					while (in.hasNext()) {
						switch (in.nextName()) {
							case 1: key = in.nextString(); break;
							case 2: value = de.haumacher.msgbuf.json.value.JsonValue.readJsonValue(in); break;
							default: in.skipValue(); break;
						}
					}
					putEntry(key, value);
					in.endObject();
				}
				in.endArray();
				break;
			}
			default: super.readField(in, field);
		}
	}

	/** XML element name representing a {@link de.haumacher.msgbuf.json.value.JsonObject} type. */
	public static final String JSON_OBJECT__XML_ELEMENT = "json-object";

	/** XML attribute or element name of a {@link #getEntries} property. */
	private static final String ENTRIES__XML_ATTR = "entries";

	@Override
	public String getXmlTagName() {
		return JSON_OBJECT__XML_ELEMENT;
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

	/** Creates a new {@link de.haumacher.msgbuf.json.value.JsonObject} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static JsonObject readJsonObject_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		JsonObject result = new JsonObject();
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

	/** Creates a new {@link JsonObject} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static JsonObject readJsonObject(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return de.haumacher.msgbuf.json.value.JsonObject.readJsonObject_XmlContent(in);
	}

}
