package de.haumacher.msgbuf.generator.ast;

/**
 * {@link Option} annotating a string value
 */
public class StringOption extends Option {

	/**
	 * Creates a {@link StringOption} instance.
	 */
	public static StringOption create() {
		return new de.haumacher.msgbuf.generator.ast.StringOption();
	}

	/** Identifier for the {@link StringOption} type in JSON format. */
	public static final String STRING_OPTION__TYPE = "StringOption";

	/** @see #getValue() */
	public static final String VALUE = "value";

	private String _value = "";

	/**
	 * Creates a {@link StringOption} instance.
	 *
	 * @see StringOption#create()
	 */
	protected StringOption() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.STRING_OPTION;
	}

	/**
	 * The string value assigned to the option.
	 */
	public final String getValue() {
		return _value;
	}

	/**
	 * @see #getValue()
	 */
	public StringOption setValue(String value) {
		internalSetValue(value);
		return this;
	}

	/** Internal setter for {@link #getValue()} without chain call utility. */
	protected final void internalSetValue(String value) {
		_listener.beforeSet(this, VALUE, value);
		_value = value;
	}

	@Override
	public String jsonType() {
		return STRING_OPTION__TYPE;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			VALUE));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case VALUE: return getValue();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case VALUE: internalSetValue((String) value); break;
			default: super.set(field, value); break;
		}
	}

	/** Reads a new instance from the given reader. */
	public static StringOption readStringOption(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		de.haumacher.msgbuf.generator.ast.StringOption result = new de.haumacher.msgbuf.generator.ast.StringOption();
		result.readContent(in);
		return result;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(VALUE);
		out.value(getValue());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case VALUE: setValue(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public <R,A> R visit(Option.Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}

}
