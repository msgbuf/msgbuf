package de.haumacher.msgbuf.json.value;

/**
 * A JSON array value.
 */
public class JsonArray extends de.haumacher.msgbuf.json.value.JsonValue {

	/**
	 * Creates a {@link de.haumacher.msgbuf.json.value.JsonArray} instance.
	 */
	public static de.haumacher.msgbuf.json.value.JsonArray create() {
		return new de.haumacher.msgbuf.json.value.JsonArray();
	}

	/** Identifier for the {@link de.haumacher.msgbuf.json.value.JsonArray} type in JSON format. */
	public static final String JSON_ARRAY__TYPE = "JsonArray";

	/** @see #getElements() */
	private static final String ELEMENTS__PROP = "elements";

	/** Identifier for the {@link de.haumacher.msgbuf.json.value.JsonArray} type in binary format. */
	static final int JSON_ARRAY__TYPE_ID = 6;

	/** Identifier for the property {@link #getElements()} in binary format. */
	static final int ELEMENTS__ID = 1;

	private final java.util.List<de.haumacher.msgbuf.json.value.JsonValue> _elements = new java.util.ArrayList<>();

	/**
	 * Creates a {@link JsonArray} instance.
	 *
	 * @see de.haumacher.msgbuf.json.value.JsonArray#create()
	 */
	protected JsonArray() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.JSON_ARRAY;
	}

	public final java.util.List<de.haumacher.msgbuf.json.value.JsonValue> getElements() {
		return _elements;
	}

	/**
	 * @see #getElements()
	 */
	public de.haumacher.msgbuf.json.value.JsonArray setElements(java.util.List<? extends de.haumacher.msgbuf.json.value.JsonValue> value) {
		internalSetElements(value);
		return this;
	}

	/** Internal setter for {@link #getElements()} without chain call utility. */
	protected final void internalSetElements(java.util.List<? extends de.haumacher.msgbuf.json.value.JsonValue> value) {
		if (value == null) throw new IllegalArgumentException("Property 'elements' cannot be null.");
		_elements.clear();
		_elements.addAll(value);
	}

	/**
	 * Adds a value to the {@link #getElements()} list.
	 */
	public de.haumacher.msgbuf.json.value.JsonArray addElement(de.haumacher.msgbuf.json.value.JsonValue value) {
		internalAddElement(value);
		return this;
	}

	/** Implementation of {@link #addElement(de.haumacher.msgbuf.json.value.JsonValue)} without chain call utility. */
	protected final void internalAddElement(de.haumacher.msgbuf.json.value.JsonValue value) {
		_elements.add(value);
	}

	/**
	 * Removes a value from the {@link #getElements()} list.
	 */
	public final void removeElement(de.haumacher.msgbuf.json.value.JsonValue value) {
		_elements.remove(value);
	}

	@Override
	public String jsonType() {
		return JSON_ARRAY__TYPE;
	}

	/** Reads a new instance from the given reader. */
	public static de.haumacher.msgbuf.json.value.JsonArray readJsonArray(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		de.haumacher.msgbuf.json.value.JsonArray result = new de.haumacher.msgbuf.json.value.JsonArray();
		result.readContent(in);
		return result;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(ELEMENTS__PROP);
		out.beginArray();
		for (de.haumacher.msgbuf.json.value.JsonValue x : getElements()) {
			x.writeTo(out);
		}
		out.endArray();
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case ELEMENTS__PROP: {
				java.util.List<de.haumacher.msgbuf.json.value.JsonValue> newValue = new java.util.ArrayList<>();
				in.beginArray();
				while (in.hasNext()) {
					newValue.add(de.haumacher.msgbuf.json.value.JsonValue.readJsonValue(in));
				}
				in.endArray();
				setElements(newValue);
			}
			break;
			default: super.readField(in, field);
		}
	}

	/** The binary identifier for this concrete type in the polymorphic {@link de.haumacher.msgbuf.json.value.JsonArray} hierarchy. */
	public int typeId() {
		return JSON_ARRAY__TYPE_ID;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(ELEMENTS__ID);
		{
			java.util.List<de.haumacher.msgbuf.json.value.JsonValue> values = getElements();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.OBJECT, values.size());
			for (de.haumacher.msgbuf.json.value.JsonValue x : values) {
				x.writeTo(out);
			}
			out.endArray();
		}
	}

	/** Reads a new instance from the given reader. */
	public static de.haumacher.msgbuf.json.value.JsonArray readJsonArray(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		de.haumacher.msgbuf.json.value.JsonArray result = de.haumacher.msgbuf.json.value.JsonArray.readJsonArray_Content(in);
		in.endObject();
		return result;
	}

	/** Helper for creating an object of type {@link de.haumacher.msgbuf.json.value.JsonArray} from a polymorphic composition. */
	public static de.haumacher.msgbuf.json.value.JsonArray readJsonArray_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		de.haumacher.msgbuf.json.value.JsonArray result = new JsonArray();
		result.readContent(in);
		return result;
	}

	@Override
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case ELEMENTS__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addElement(de.haumacher.msgbuf.json.value.JsonValue.readJsonValue(in));
				}
				in.endArray();
			}
			break;
			default: super.readField(in, field);
		}
	}

}
