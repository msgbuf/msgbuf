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

	/**
	 * Creates a {@link MapType} instance.
	 *
	 * @see #create()
	 */
	protected MapType() {
		super();
	}

	/** @see #getKeyType() */
	public static final String KEY_TYPE = "keyType";

	/** @see #getValueType() */
	public static final String VALUE_TYPE = "valueType";

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
		in.beginObject();
		result.readFields(in);
		in.endObject();
		return result;
	}

	@Override
	public String jsonType() {
		return "MapType";
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
	public int typeId() {
		return 3;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		super.writeFields(out);
		if (hasKeyType()) {
			out.name(1);
			getKeyType().writeTo(out);
		}
		if (hasValueType()) {
			out.name(2);
			getValueType().writeTo(out);
		}
	}

	@Override
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case 1: setKeyType(Type.readType(in)); break;
			case 2: setValueType(Type.readType(in)); break;
			default: super.readField(in, field);
		}
	}

	/** Reads a new instance from the given reader. */
	public static MapType readMapType(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		MapType result = new MapType();
		while (in.hasNext()) {
			int field = in.nextName();
			result.readField(in, field);
		}
		in.endObject();
		return result;
	}

	@Override
	public <R,A> R visit(Type.Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}

}
