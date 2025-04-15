package de.haumacher.msgbuf.generator.ast;

/**
 * A field definition of a {@link MessageDef}.
 */
public class Field extends Part implements de.haumacher.msgbuf.generator.FieldOperations {

	/**
	 * Creates a {@link de.haumacher.msgbuf.generator.ast.Field} instance.
	 */
	public static de.haumacher.msgbuf.generator.ast.Field create() {
		return new de.haumacher.msgbuf.generator.ast.Field();
	}

	/** Identifier for the {@link de.haumacher.msgbuf.generator.ast.Field} type in JSON format. */
	public static final String FIELD__TYPE = "Field";

	/** @see #isTransient() */
	public static final String TRANSIENT__PROP = "transient";

	/** @see #isRepeated() */
	public static final String REPEATED__PROP = "repeated";

	/** @see #getType() */
	public static final String TYPE__PROP = "type";

	/** @see #getDefaultValue() */
	public static final String DEFAULT_VALUE__PROP = "defaultValue";

	private boolean _transient = false;

	private boolean _repeated = false;

	private de.haumacher.msgbuf.generator.ast.Type _type = null;

	private String _defaultValue = null;

	/**
	 * Creates a {@link Field} instance.
	 *
	 * @see de.haumacher.msgbuf.generator.ast.Field#create()
	 */
	protected Field() {
		super();
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
	public de.haumacher.msgbuf.generator.ast.Field setTransient(boolean value) {
		internalSetTransient(value);
		return this;
	}

	/** Internal setter for {@link #isTransient()} without chain call utility. */
	protected final void internalSetTransient(boolean value) {
		_listener.beforeSet(this, TRANSIENT__PROP, value);
		_transient = value;
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
	public de.haumacher.msgbuf.generator.ast.Field setRepeated(boolean value) {
		internalSetRepeated(value);
		return this;
	}

	/** Internal setter for {@link #isRepeated()} without chain call utility. */
	protected final void internalSetRepeated(boolean value) {
		_listener.beforeSet(this, REPEATED__PROP, value);
		_repeated = value;
	}

	/**
	 * The type of values that can be stored in this field.
	 */
	public final de.haumacher.msgbuf.generator.ast.Type getType() {
		return _type;
	}

	/**
	 * @see #getType()
	 */
	public de.haumacher.msgbuf.generator.ast.Field setType(de.haumacher.msgbuf.generator.ast.Type value) {
		internalSetType(value);
		return this;
	}

	/** Internal setter for {@link #getType()} without chain call utility. */
	protected final void internalSetType(de.haumacher.msgbuf.generator.ast.Type value) {
		_listener.beforeSet(this, TYPE__PROP, value);
		_type = value;
	}

	/**
	 * Checks, whether {@link #getType()} has a value.
	 */
	public final boolean hasType() {
		return _type != null;
	}

	/**
	 * The initializer value to assign to the field.
	 */
	public final String getDefaultValue() {
		return _defaultValue;
	}

	/**
	 * @see #getDefaultValue()
	 */
	public de.haumacher.msgbuf.generator.ast.Field setDefaultValue(String value) {
		internalSetDefaultValue(value);
		return this;
	}

	/** Internal setter for {@link #getDefaultValue()} without chain call utility. */
	protected final void internalSetDefaultValue(String value) {
		_listener.beforeSet(this, DEFAULT_VALUE__PROP, value);
		_defaultValue = value;
	}

	/**
	 * Checks, whether {@link #getDefaultValue()} has a value.
	 */
	public final boolean hasDefaultValue() {
		return _defaultValue != null;
	}

	@Override
	public de.haumacher.msgbuf.generator.ast.Field setName(String value) {
		internalSetName(value);
		return this;
	}

	@Override
	public de.haumacher.msgbuf.generator.ast.Field setIndex(int value) {
		internalSetIndex(value);
		return this;
	}

	@Override
	public de.haumacher.msgbuf.generator.ast.Field setOwner(de.haumacher.msgbuf.generator.ast.Definition value) {
		internalSetOwner(value);
		return this;
	}

	@Override
	public de.haumacher.msgbuf.generator.ast.Field setComment(String value) {
		internalSetComment(value);
		return this;
	}

	@Override
	public de.haumacher.msgbuf.generator.ast.Field setOptions(java.util.Map<String, de.haumacher.msgbuf.generator.ast.Option> value) {
		internalSetOptions(value);
		return this;
	}

	@Override
	public de.haumacher.msgbuf.generator.ast.Field putOption(String key, de.haumacher.msgbuf.generator.ast.Option value) {
		internalPutOption(key, value);
		return this;
	}

	@Override
	public String jsonType() {
		return FIELD__TYPE;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			TRANSIENT__PROP, 
			REPEATED__PROP, 
			TYPE__PROP, 
			DEFAULT_VALUE__PROP));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case TRANSIENT__PROP: return isTransient();
			case REPEATED__PROP: return isRepeated();
			case TYPE__PROP: return getType();
			case DEFAULT_VALUE__PROP: return getDefaultValue();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case TRANSIENT__PROP: internalSetTransient((boolean) value); break;
			case REPEATED__PROP: internalSetRepeated((boolean) value); break;
			case TYPE__PROP: internalSetType((de.haumacher.msgbuf.generator.ast.Type) value); break;
			case DEFAULT_VALUE__PROP: internalSetDefaultValue((String) value); break;
			default: super.set(field, value); break;
		}
	}

	/** Reads a new instance from the given reader. */
	public static de.haumacher.msgbuf.generator.ast.Field readField(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		de.haumacher.msgbuf.generator.ast.Field result = new de.haumacher.msgbuf.generator.ast.Field();
		result.readContent(in);
		return result;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(TRANSIENT__PROP);
		out.value(isTransient());
		out.name(REPEATED__PROP);
		out.value(isRepeated());
		if (hasType()) {
			out.name(TYPE__PROP);
			getType().writeTo(out);
		}
		if (hasDefaultValue()) {
			out.name(DEFAULT_VALUE__PROP);
			out.value(getDefaultValue());
		}
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case TRANSIENT__PROP: setTransient(in.nextBoolean()); break;
			case REPEATED__PROP: setRepeated(in.nextBoolean()); break;
			case TYPE__PROP: setType(de.haumacher.msgbuf.generator.ast.Type.readType(in)); break;
			case DEFAULT_VALUE__PROP: setDefaultValue(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public Field self() {
		return this;
	}

	@Override
	public <R,A> R visit(de.haumacher.msgbuf.generator.ast.Part.Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}

}
