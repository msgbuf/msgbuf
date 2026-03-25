package de.haumacher.msgbuf.json.value;

/**
 * Envelope type representing any JSON value for binary and XML serialization.
 */
public abstract class JsonValue extends de.haumacher.msgbuf.data.AbstractDataObject implements de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.xml.XmlSerializable {

	/** Type codes for the {@link de.haumacher.msgbuf.json.value.JsonValue} hierarchy. */
	public enum TypeKind {

		/** Type literal for {@link de.haumacher.msgbuf.json.value.JsonString}. */
		JSON_STRING,

		/** Type literal for {@link de.haumacher.msgbuf.json.value.JsonLong}. */
		JSON_LONG,

		/** Type literal for {@link de.haumacher.msgbuf.json.value.JsonDouble}. */
		JSON_DOUBLE,

		/** Type literal for {@link de.haumacher.msgbuf.json.value.JsonBoolean}. */
		JSON_BOOLEAN,

		/** Type literal for {@link de.haumacher.msgbuf.json.value.JsonNull}. */
		JSON_NULL,

		/** Type literal for {@link de.haumacher.msgbuf.json.value.JsonArray}. */
		JSON_ARRAY,

		/** Type literal for {@link de.haumacher.msgbuf.json.value.JsonObject}. */
		JSON_OBJECT,
		;

	}

	/**
	 * Creates a {@link JsonValue} instance.
	 */
	protected JsonValue() {
		super();
	}

	/** The type code of this instance. */
	public abstract TypeKind kind();

	/** The type identifier for this concrete subtype. */
	public abstract String jsonType();

	/** Reads a new instance from the given reader. */
	public static de.haumacher.msgbuf.json.value.JsonValue readJsonValue(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		de.haumacher.msgbuf.json.value.JsonValue result;
		in.beginArray();
		String type = in.nextString();
		switch (type) {
			case JsonString.JSON_STRING__TYPE: result = de.haumacher.msgbuf.json.value.JsonString.readJsonString(in); break;
			case JsonLong.JSON_LONG__TYPE: result = de.haumacher.msgbuf.json.value.JsonLong.readJsonLong(in); break;
			case JsonDouble.JSON_DOUBLE__TYPE: result = de.haumacher.msgbuf.json.value.JsonDouble.readJsonDouble(in); break;
			case JsonBoolean.JSON_BOOLEAN__TYPE: result = de.haumacher.msgbuf.json.value.JsonBoolean.readJsonBoolean(in); break;
			case JsonNull.JSON_NULL__TYPE: result = de.haumacher.msgbuf.json.value.JsonNull.readJsonNull(in); break;
			case JsonArray.JSON_ARRAY__TYPE: result = de.haumacher.msgbuf.json.value.JsonArray.readJsonArray(in); break;
			case JsonObject.JSON_OBJECT__TYPE: result = de.haumacher.msgbuf.json.value.JsonObject.readJsonObject(in); break;
			default: in.skipValue(); result = null; break;
		}
		in.endArray();
		return result;
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		out.beginArray();
		out.value(jsonType());
		writeContent(out);
		out.endArray();
	}

	/** The binary identifier for this concrete type in the polymorphic {@link de.haumacher.msgbuf.json.value.JsonValue} hierarchy. */
	abstract int typeId();

	@Override
	public final void writeTo(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		out.beginObject();
		out.name(0);
		out.value(typeId());
		writeFields(out);
		out.endObject();
	}

	/**
	 * Serializes all fields of this instance to the given binary output.
	 *
	 * @param out
	 *        The binary output to write to.
	 * @throws java.io.IOException If writing fails.
	 */
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		// No fields to write, hook for subclasses.
	}

	/** Reads a new instance from the given reader. */
	public static de.haumacher.msgbuf.json.value.JsonValue readJsonValue(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		int typeField = in.nextName();
		assert typeField == 0;
		int type = in.nextInt();
		de.haumacher.msgbuf.json.value.JsonValue result;
		switch (type) {
			case de.haumacher.msgbuf.json.value.JsonString.JSON_STRING__TYPE_ID: result = de.haumacher.msgbuf.json.value.JsonString.readJsonString_Content(in); break;
			case de.haumacher.msgbuf.json.value.JsonLong.JSON_LONG__TYPE_ID: result = de.haumacher.msgbuf.json.value.JsonLong.readJsonLong_Content(in); break;
			case de.haumacher.msgbuf.json.value.JsonDouble.JSON_DOUBLE__TYPE_ID: result = de.haumacher.msgbuf.json.value.JsonDouble.readJsonDouble_Content(in); break;
			case de.haumacher.msgbuf.json.value.JsonBoolean.JSON_BOOLEAN__TYPE_ID: result = de.haumacher.msgbuf.json.value.JsonBoolean.readJsonBoolean_Content(in); break;
			case de.haumacher.msgbuf.json.value.JsonNull.JSON_NULL__TYPE_ID: result = de.haumacher.msgbuf.json.value.JsonNull.readJsonNull_Content(in); break;
			case de.haumacher.msgbuf.json.value.JsonArray.JSON_ARRAY__TYPE_ID: result = de.haumacher.msgbuf.json.value.JsonArray.readJsonArray_Content(in); break;
			case de.haumacher.msgbuf.json.value.JsonObject.JSON_OBJECT__TYPE_ID: result = de.haumacher.msgbuf.json.value.JsonObject.readJsonObject_Content(in); break;
			default: result = null; while (in.hasNext()) {in.skipValue(); }
		}
		in.endObject();
		return result;
	}

	/** Helper for reading all fields of this instance. */
	protected final void readContent(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		while (in.hasNext()) {
			int field = in.nextName();
			readField(in, field);
		}
	}

	/** Consumes the value for the field with the given ID and assigns its value. */
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			default: in.skipValue(); 
		}
	}

	/** XML element name representing a {@link de.haumacher.msgbuf.json.value.JsonValue} type. */
	public static final String JSON_VALUE__XML_ELEMENT = "json-value";

	@Override
	public final void writeContent(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		writeAttributes(out);
		writeElements(out);
	}

	/** Serializes all fields that are written as XML attributes. */
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
	}

	/** Serializes all fields that are written as XML elements. */
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		// No element fields.
	}

	/** Creates a new {@link de.haumacher.msgbuf.json.value.JsonValue} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static JsonValue readJsonValue_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		switch (in.getLocalName()) {
			case JsonString.JSON_STRING__XML_ELEMENT: {
				return de.haumacher.msgbuf.json.value.JsonString.readJsonString_XmlContent(in);
			}

			case JsonLong.JSON_LONG__XML_ELEMENT: {
				return de.haumacher.msgbuf.json.value.JsonLong.readJsonLong_XmlContent(in);
			}

			case JsonDouble.JSON_DOUBLE__XML_ELEMENT: {
				return de.haumacher.msgbuf.json.value.JsonDouble.readJsonDouble_XmlContent(in);
			}

			case JsonBoolean.JSON_BOOLEAN__XML_ELEMENT: {
				return de.haumacher.msgbuf.json.value.JsonBoolean.readJsonBoolean_XmlContent(in);
			}

			case JsonNull.JSON_NULL__XML_ELEMENT: {
				return de.haumacher.msgbuf.json.value.JsonNull.readJsonNull_XmlContent(in);
			}

			case JsonArray.JSON_ARRAY__XML_ELEMENT: {
				return de.haumacher.msgbuf.json.value.JsonArray.readJsonArray_XmlContent(in);
			}

			case JsonObject.JSON_OBJECT__XML_ELEMENT: {
				return de.haumacher.msgbuf.json.value.JsonObject.readJsonObject_XmlContent(in);
			}

			default: {
				internalSkipUntilMatchingEndElement(in);
				return null;
			}
		}
	}

	/** Reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	protected final void readContentXml(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		for (int n = 0, cnt = in.getAttributeCount(); n < cnt; n++) {
			String name = in.getAttributeLocalName(n);
			String value = in.getAttributeValue(n);

			readFieldXmlAttribute(name, value);
		}
		while (true) {
			int event = in.nextTag();
			if (event == javax.xml.stream.XMLStreamConstants.END_ELEMENT) {
				break;
			}
			assert event == javax.xml.stream.XMLStreamConstants.START_ELEMENT;

			String localName = in.getLocalName();
			readFieldXmlElement(in, localName);
		}
	}

	/** Parses the given attribute value and assigns it to the field with the given name. */
	protected void readFieldXmlAttribute(String name, String value) {
		switch (name) {
			default: {
				// Skip unknown attribute.
			}
		}
	}

	/** Reads the element under the cursor and assigns its contents to the field with the given name. */
	protected void readFieldXmlElement(javax.xml.stream.XMLStreamReader in, String localName) throws javax.xml.stream.XMLStreamException {
		switch (localName) {
			default: {
				internalSkipUntilMatchingEndElement(in);
			}
		}
	}

	protected static final void internalSkipUntilMatchingEndElement(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		int level = 0;
		while (true) {
			switch (in.next()) {
				case javax.xml.stream.XMLStreamConstants.START_ELEMENT: level++; break;
				case javax.xml.stream.XMLStreamConstants.END_ELEMENT: if (level == 0) { return; } else { level--; break; }
			}
		}
	}

	/** Creates a new {@link JsonValue} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static JsonValue readJsonValue(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return de.haumacher.msgbuf.json.value.JsonValue.readJsonValue_XmlContent(in);
	}

}
