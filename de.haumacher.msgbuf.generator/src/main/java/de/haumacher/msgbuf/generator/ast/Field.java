package de.haumacher.msgbuf.generator.ast;

/**
 * A field definition of a {@link MessageDef}.
 */
public class Field extends Part {

	/**
	 * Creates a {@link Field} instance.
	 */
	public static Field create() {
		return new Field();
	}

	/**
	 * Creates a {@link Field} instance.
	 *
	 * @see #create()
	 */
	protected Field() {
		super();
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
	 * Whether this field is not serialized when a message is created.
	 */
	public final boolean isTransient() {
		return _transient;
	}

	/**
	 * @see #isTransient()
	 */
	public final Field setTransient(boolean value) {
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
		_type = value;
		return this;
	}

	/**
	 * Checks, whether {@link #getType()} has a value.
	 */
	public final boolean hasType() {
		return _type != null;
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
	public String jsonType() {
		return FIELD__TYPE;
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
			case TYPE: setType(Type.readType(in)); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public <R,A> R visit(Part.Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}

}
