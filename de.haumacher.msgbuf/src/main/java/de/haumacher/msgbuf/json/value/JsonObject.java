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

}
