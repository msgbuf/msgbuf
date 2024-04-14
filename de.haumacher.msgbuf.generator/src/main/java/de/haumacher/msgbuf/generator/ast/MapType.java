package de.haumacher.msgbuf.generator.ast;

/**
 * A {@link Type} that is composed of a key and a value.
 */
public class MapType extends Type {

	/**
	 * Creates a {@link de.haumacher.msgbuf.generator.ast.MapType} instance.
	 */
	public static de.haumacher.msgbuf.generator.ast.MapType create() {
		return new de.haumacher.msgbuf.generator.ast.MapType();
	}

	/** Identifier for the {@link de.haumacher.msgbuf.generator.ast.MapType} type in JSON format. */
	public static final String MAP_TYPE__TYPE = "MapType";

	/** @see #getKeyType() */
	public static final String KEY_TYPE__PROP = "keyType";

	/** @see #getValueType() */
	public static final String VALUE_TYPE__PROP = "valueType";

	private de.haumacher.msgbuf.generator.ast.Type _keyType = null;

	private de.haumacher.msgbuf.generator.ast.Type _valueType = null;

	/**
	 * Creates a {@link MapType} instance.
	 *
	 * @see de.haumacher.msgbuf.generator.ast.MapType#create()
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
	public final de.haumacher.msgbuf.generator.ast.Type getKeyType() {
		return _keyType;
	}

	/**
	 * @see #getKeyType()
	 */
	public de.haumacher.msgbuf.generator.ast.MapType setKeyType(de.haumacher.msgbuf.generator.ast.Type value) {
		internalSetKeyType(value);
		return this;
	}

	/** Internal setter for {@link #getKeyType()} without chain call utility. */
	protected final void internalSetKeyType(de.haumacher.msgbuf.generator.ast.Type value) {
		_listener.beforeSet(this, KEY_TYPE__PROP, value);
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
	public final de.haumacher.msgbuf.generator.ast.Type getValueType() {
		return _valueType;
	}

	/**
	 * @see #getValueType()
	 */
	public de.haumacher.msgbuf.generator.ast.MapType setValueType(de.haumacher.msgbuf.generator.ast.Type value) {
		internalSetValueType(value);
		return this;
	}

	/** Internal setter for {@link #getValueType()} without chain call utility. */
	protected final void internalSetValueType(de.haumacher.msgbuf.generator.ast.Type value) {
		_listener.beforeSet(this, VALUE_TYPE__PROP, value);
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
			KEY_TYPE__PROP, 
			VALUE_TYPE__PROP));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case KEY_TYPE__PROP: return getKeyType();
			case VALUE_TYPE__PROP: return getValueType();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case KEY_TYPE__PROP: internalSetKeyType((de.haumacher.msgbuf.generator.ast.Type) value); break;
			case VALUE_TYPE__PROP: internalSetValueType((de.haumacher.msgbuf.generator.ast.Type) value); break;
			default: super.set(field, value); break;
		}
	}

	/** Reads a new instance from the given reader. */
	public static de.haumacher.msgbuf.generator.ast.MapType readMapType(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		de.haumacher.msgbuf.generator.ast.MapType result = new de.haumacher.msgbuf.generator.ast.MapType();
		result.readContent(in);
		return result;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		if (hasKeyType()) {
			out.name(KEY_TYPE__PROP);
			getKeyType().writeTo(out);
		}
		if (hasValueType()) {
			out.name(VALUE_TYPE__PROP);
			getValueType().writeTo(out);
		}
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case KEY_TYPE__PROP: setKeyType(de.haumacher.msgbuf.generator.ast.Type.readType(in)); break;
			case VALUE_TYPE__PROP: setValueType(de.haumacher.msgbuf.generator.ast.Type.readType(in)); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public <R,A> R visit(de.haumacher.msgbuf.generator.ast.Type.Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}

}
