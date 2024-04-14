package de.haumacher.msgbuf.generator.ast;

/**
 * {@link Option} annotating an int value
 */
public class NumberOption extends Option {

	/**
	 * Creates a {@link de.haumacher.msgbuf.generator.ast.NumberOption} instance.
	 */
	public static de.haumacher.msgbuf.generator.ast.NumberOption create() {
		return new de.haumacher.msgbuf.generator.ast.NumberOption();
	}

	/** Identifier for the {@link de.haumacher.msgbuf.generator.ast.NumberOption} type in JSON format. */
	public static final String NUMBER_OPTION__TYPE = "NumberOption";

	/** @see #getValue() */
	public static final String VALUE__PROP = "value";

	private double _value = 0.0d;

	/**
	 * Creates a {@link NumberOption} instance.
	 *
	 * @see de.haumacher.msgbuf.generator.ast.NumberOption#create()
	 */
	protected NumberOption() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.NUMBER_OPTION;
	}

	/**
	 * The number assigned to the option.
	 */
	public final double getValue() {
		return _value;
	}

	/**
	 * @see #getValue()
	 */
	public de.haumacher.msgbuf.generator.ast.NumberOption setValue(double value) {
		internalSetValue(value);
		return this;
	}

	/** Internal setter for {@link #getValue()} without chain call utility. */
	protected final void internalSetValue(double value) {
		_listener.beforeSet(this, VALUE__PROP, value);
		_value = value;
	}

	@Override
	public String jsonType() {
		return NUMBER_OPTION__TYPE;
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
			case VALUE__PROP: return getValue();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case VALUE__PROP: internalSetValue((double) value); break;
			default: super.set(field, value); break;
		}
	}

	/** Reads a new instance from the given reader. */
	public static de.haumacher.msgbuf.generator.ast.NumberOption readNumberOption(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		de.haumacher.msgbuf.generator.ast.NumberOption result = new de.haumacher.msgbuf.generator.ast.NumberOption();
		result.readContent(in);
		return result;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(VALUE__PROP);
		out.value(getValue());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case VALUE__PROP: setValue(in.nextDouble()); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public <R,A> R visit(de.haumacher.msgbuf.generator.ast.Option.Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}

}
