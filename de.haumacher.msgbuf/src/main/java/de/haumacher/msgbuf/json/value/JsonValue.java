package de.haumacher.msgbuf.json.value;

/**
 * Envelope type representing any JSON value for binary serialization.
 */
public abstract class JsonValue extends de.haumacher.msgbuf.data.AbstractDataObject implements de.haumacher.msgbuf.binary.BinaryDataObject {

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

}
