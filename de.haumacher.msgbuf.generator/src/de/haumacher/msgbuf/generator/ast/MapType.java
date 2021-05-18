package de.haumacher.msgbuf.generator.ast;

/**
 * A {@link Type} that is composed of a key and a value.
 */
public class MapType extends Type {

	/**
	 * Creates a {@link MapType} instance.
	 */
	public static MapType mapType() {
		return new MapType();
	}

	/**
	 * Creates a {@link MapType} instance.
	 *
	 * @see #mapType()
	 */
	protected MapType() {
		super();
	}

	private Type _keyType = null;

	private Type _valueType = null;

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
		result.readFields(in);
		return result;
	}

	@Override
	protected String jsonType() {
		return "MapType";
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case "keyType": return getKeyType();
			case "valueType": return getValueType();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case "keyType": setKeyType((Type) value); break;
			case "valueType": setValueType((Type) value); break;
			default: super.set(field, value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		if (hasKeyType()) {
			out.name("keyType");
			getKeyType().writeTo(out);
		}
		if (hasValueType()) {
			out.name("valueType");
			getValueType().writeTo(out);
		}
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case "keyType": setKeyType(Type.readType(in)); break;
			case "valueType": setValueType(Type.readType(in)); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public <R,A> R visit(Type.Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}

}
