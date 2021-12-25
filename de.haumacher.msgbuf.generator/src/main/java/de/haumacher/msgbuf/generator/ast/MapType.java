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

	@Override
	public TypeKind kind() {
		return TypeKind.MAP_TYPE;
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
	public MapType setKeyType(Type value) {
		internalSetKeyType(value);
		return this;
	}
	/** Internal setter for {@link #getKeyType()} without chain call utility. */
	protected final void internalSetKeyType(Type value) {
		_listener.beforeSet(this, KEY_TYPE, value);
		_keyType = value;
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
	public MapType setValueType(Type value) {
		internalSetValueType(value);
		return this;
	}
	/** Internal setter for {@link #getValueType()} without chain call utility. */
	protected final void internalSetValueType(Type value) {
		_listener.beforeSet(this, VALUE_TYPE, value);
		_valueType = value;
	}


	/**
	 * Checks, whether {@link #getValueType()} has a value.
	 */
	public final boolean hasValueType() {
		return _valueType != null;
	}

	@Override
	public String jsonType() {
		return MAP_TYPE__TYPE;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			KEY_TYPE, 
			VALUE_TYPE));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case KEY_TYPE: return getKeyType();
			case VALUE_TYPE: return getValueType();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case KEY_TYPE: setKeyType((Type) value); break;
			case VALUE_TYPE: setValueType((Type) value); break;
			default: super.set(field, value); break;
		}
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
			case KEY_TYPE: setKeyType(de.haumacher.msgbuf.generator.ast.Type.readType(in)); break;
			case VALUE_TYPE: setValueType(de.haumacher.msgbuf.generator.ast.Type.readType(in)); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public <R,A> R visit(Type.Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}

}
