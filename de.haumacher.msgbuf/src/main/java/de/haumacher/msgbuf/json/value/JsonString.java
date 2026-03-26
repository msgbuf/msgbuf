package de.haumacher.msgbuf.json.value;

/**
 * A JSON string value.
 */
public class JsonString extends de.haumacher.msgbuf.json.value.JsonValue {

	/**
	 * Creates a {@link de.haumacher.msgbuf.json.value.JsonString} instance.
	 */
	public static de.haumacher.msgbuf.json.value.JsonString create() {
		return new de.haumacher.msgbuf.json.value.JsonString();
	}

	/** Identifier for the {@link de.haumacher.msgbuf.json.value.JsonString} type in JSON format. */
	public static final String JSON_STRING__TYPE = "JsonString";

	/** @see #getValue() */
	private static final String VALUE__PROP = "value";

	/** Identifier for the {@link de.haumacher.msgbuf.json.value.JsonString} type in binary format. */
	static final int JSON_STRING__TYPE_ID = 1;

	/** Identifier for the property {@link #getValue()} in binary format. */
	static final int VALUE__ID = 1;

	private String _value = "";

	/**
	 * Creates a {@link JsonString} instance.
	 *
	 * @see de.haumacher.msgbuf.json.value.JsonString#create()
	 */
	protected JsonString() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.JSON_STRING;
	}

	public final String getValue() {
		return _value;
	}

	/**
	 * @see #getValue()
	 */
	public de.haumacher.msgbuf.json.value.JsonString setValue(String value) {
		internalSetValue(value);
		return this;
	}

	/** Internal setter for {@link #getValue()} without chain call utility. */
	protected final void internalSetValue(String value) {
		_value = value;
	}

	@Override
	public String jsonType() {
		return JSON_STRING__TYPE;
	}

	/** Reads a new instance from the given reader. */
	public static de.haumacher.msgbuf.json.value.JsonString readJsonString(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		de.haumacher.msgbuf.json.value.JsonString result = new de.haumacher.msgbuf.json.value.JsonString();
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
			case VALUE__PROP: setValue(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			default: super.readField(in, field);
		}
	}

	/** The binary identifier for this concrete type in the polymorphic {@link de.haumacher.msgbuf.json.value.JsonString} hierarchy. */
	public int typeId() {
		return JSON_STRING__TYPE_ID;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(VALUE__ID);
		out.value(getValue());
	}

	/** Reads a new instance from the given reader. */
	public static de.haumacher.msgbuf.json.value.JsonString readJsonString(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		de.haumacher.msgbuf.json.value.JsonString result = de.haumacher.msgbuf.json.value.JsonString.readJsonString_Content(in);
		in.endObject();
		return result;
	}

	/** Helper for creating an object of type {@link de.haumacher.msgbuf.json.value.JsonString} from a polymorphic composition. */
	public static de.haumacher.msgbuf.json.value.JsonString readJsonString_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		de.haumacher.msgbuf.json.value.JsonString result = new JsonString();
		result.readContent(in);
		return result;
	}

	@Override
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case VALUE__ID: setValue(in.nextString()); break;
			default: super.readField(in, field);
		}
	}

}
