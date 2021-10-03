package de.haumacher.msgbuf.generator.ast;

/**
 * A {@link Type} that is composed of a key and a value.
 */
public class MapType extends Type {

	/**
	 * Creates a {@link MapType} instance.
	 */
	public static MapType create() {
		return new MapType();
	}

	/** Identifier for the {@link MapType} type in JSON format. */
	public static final String MAP_TYPE__TYPE = "MapType";

	/** @see #getKeyType() */
	public static final String KEY_TYPE = "keyType";

	/** @see #getValueType() */
	public static final String VALUE_TYPE = "valueType";

	private Type _keyType = null;

	private Type _valueType = null;

	/**
	 * Creates a {@link MapType} instance.
	 *
	 * @see #create()
	 */
	protected MapType() {
		super();
	}

	/**
	 * The key type of this map.
	 */
	public final Type getKeyType() {
		return _keyType;
	}

	/**
	 * @see #getKeyType()
	 */
	public final MapType setKeyType(Type value) {
		_keyType = value;
		return this;
	}

	/**
	 * Checks, whether {@link #getKeyType()} has a value.
	 */
	public final boolean hasKeyType() {
		return _keyType != null;
	}

	/**
	 * The value type of this map.
	 */
	public final Type getValueType() {
		return _valueType;
	}

	/**
	 * @see #getValueType()
	 */
	public final MapType setValueType(Type value) {
		_valueType = value;
		return this;
	}

	/**
	 * Checks, whether {@link #getValueType()} has a value.
	 */
	public final boolean hasValueType() {
		return _valueType != null;
	}

	/** Reads a new instance from the given reader. */
	public static MapType readMapType(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		MapType result = new MapType();
		in.beginObject();
		result.readFields(in);
		in.endObject();
		return result;
	}

	@Override
	public String jsonType() {
		return MAP_TYPE__TYPE;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		if (hasKeyType()) {
			out.name(KEY_TYPE);
			getKeyType().writeTo(out);
		}
		if (hasValueType()) {
			out.name(VALUE_TYPE);
			getValueType().writeTo(out);
		}
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case KEY_TYPE: setKeyType(Type.readType(in)); break;
			case VALUE_TYPE: setValueType(Type.readType(in)); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public <R,A> R visit(Type.Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}

}
