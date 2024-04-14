package de.haumacher.msgbuf.generator.ast;

/**
 * {@link Option} annotating a boolean value
 */
public class Flag extends Option {

	/**
	 * Creates a {@link de.haumacher.msgbuf.generator.ast.Flag} instance.
	 */
	public static de.haumacher.msgbuf.generator.ast.Flag create() {
		return new de.haumacher.msgbuf.generator.ast.Flag();
	}

	/** Identifier for the {@link de.haumacher.msgbuf.generator.ast.Flag} type in JSON format. */
	public static final String FLAG__TYPE = "Flag";

	/** @see #isValue() */
	public static final String VALUE__PROP = "value";

	private boolean _value = false;

	/**
	 * Creates a {@link Flag} instance.
	 *
	 * @see de.haumacher.msgbuf.generator.ast.Flag#create()
	 */
	protected Flag() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.FLAG;
	}

	/**
	 * The boolean value assigned to the option.
	 */
	public final boolean isValue() {
		return _value;
	}

	/**
	 * @see #isValue()
	 */
	public de.haumacher.msgbuf.generator.ast.Flag setValue(boolean value) {
		internalSetValue(value);
		return this;
	}

	/** Internal setter for {@link #isValue()} without chain call utility. */
	protected final void internalSetValue(boolean value) {
		_listener.beforeSet(this, VALUE__PROP, value);
		_value = value;
	}

	@Override
	public String jsonType() {
		return FLAG__TYPE;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			VALUE__PROP));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case VALUE__PROP: return isValue();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case VALUE__PROP: internalSetValue((boolean) value); break;
			default: super.set(field, value); break;
		}
	}

	/** Reads a new instance from the given reader. */
	public static de.haumacher.msgbuf.generator.ast.Flag readFlag(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		de.haumacher.msgbuf.generator.ast.Flag result = new de.haumacher.msgbuf.generator.ast.Flag();
		result.readContent(in);
		return result;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(VALUE__PROP);
		out.value(isValue());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case VALUE__PROP: setValue(in.nextBoolean()); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public <R,A> R visit(de.haumacher.msgbuf.generator.ast.Option.Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}

}
