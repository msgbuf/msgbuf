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

}
