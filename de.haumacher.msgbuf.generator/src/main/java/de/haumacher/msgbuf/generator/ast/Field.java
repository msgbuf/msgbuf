package de.haumacher.msgbuf.generator.ast;

/**
 * A field definition of a {@link MessageDef}.
 */
public class Field extends Part<Field> implements de.haumacher.msgbuf.generator.FieldOperations {

	/**
	 * Creates a {@link Field} instance.
	 */
	public static Field create() {
		return new Field();
	}

	/** Identifier for the {@link Field} type in JSON format. */
	public static final String FIELD__TYPE = "Field";

	/** @see #isTransient() */
	public static final String TRANSIENT = "transient";

	/** @see #isRepeated() */
	public static final String REPEATED = "repeated";

	/** @see #getType() */
	public static final String TYPE = "type";

	private boolean _transient = false;

	private boolean _repeated = false;

	private Type _type = null;

	/**
	 * Creates a {@link Field} instance.
	 *
	 * @see #create()
	 */
	protected Field() {
		super();
	}

	@Override
	protected final Field self() {
		return this;
	}

	@Override
	public TypeKind kind() {
		return TypeKind.FIELD;
	}

	/**
	 * Whether this field is not serialized when a message is created.
	 */
	public final boolean isTransient() {
		return _transient;
	}

	/**
	 * @see #isTransient()
	 */
	public final Field setTransient(boolean value) {
		_listener.beforeSet(this, TRANSIENT, value);
		_transient = value;
		return this;
	}

	/**
	 * Whether this field contains multiple values of its {@link #getType()}.
	 */
	public final boolean isRepeated() {
		return _repeated;
	}

	/**
	 * @see #isRepeated()
	 */
	public final Field setRepeated(boolean value) {
		_listener.beforeSet(this, REPEATED, value);
		_repeated = value;
		return this;
	}

	/**
	 * The type of values that can be stored in this field.
	 */
	public final Type getType() {
		return _type;
	}

	/**
	 * @see #getType()
	 */
	public final Field setType(Type value) {
		_listener.beforeSet(this, TYPE, value);
		_type = value;
		return this;
	}

	/**
	 * Checks, whether {@link #getType()} has a value.
	 */
	public final boolean hasType() {
		return _type != null;
	}

	@Override
	public String jsonType() {
		return FIELD__TYPE;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			TRANSIENT, 
			REPEATED, 
			TYPE));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case TRANSIENT: return isTransient();
			case REPEATED: return isRepeated();
			case TYPE: return getType();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case TRANSIENT: setTransient((boolean) value); break;
			case REPEATED: setRepeated((boolean) value); break;
			case TYPE: setType((Type) value); break;
			default: super.set(field, value); break;
		}
	}

	/** Reads a new instance from the given reader. */
	public static Field readField(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		Field result = new Field();
		in.beginObject();
		result.readFields(in);
		in.endObject();
		return result;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(TRANSIENT);
		out.value(isTransient());
		out.name(REPEATED);
		out.value(isRepeated());
		if (hasType()) {
			out.name(TYPE);
			getType().writeTo(out);
		}
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case TRANSIENT: setTransient(in.nextBoolean()); break;
			case REPEATED: setRepeated(in.nextBoolean()); break;
			case TYPE: setType(de.haumacher.msgbuf.generator.ast.Type.readType(in)); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public <R,A> R visit(Part.Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}

}
