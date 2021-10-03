package de.haumacher.msgbuf.generator.ast;

/**
 * {@link Option} annotating a string value
 */
public class StringOption extends Option {

	/**
	 * Creates a {@link StringOption} instance.
	 */
	public static StringOption create() {
		return new StringOption();
	}

	/**
	 * Creates a {@link StringOption} instance.
	 *
	 * @see #create()
	 */
	protected StringOption() {
		super();
	}

	/** Identifier for the {@link StringOption} type in JSON format. */
	public static final String STRING_OPTION__TYPE = "StringOption";

	/** @see #getValue() */
	public static final String VALUE = "value";

	private String _value = "";

	/**
	 * The string value assigned to the option {@link #name}.
	 */
	public final String getValue() {
		return _value;
	}

	/**
	 * @see #getValue()
	 */
	public final StringOption setValue(String value) {
		_value = value;
		return this;
	}

	/** Reads a new instance from the given reader. */
	public static StringOption readStringOption(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		StringOption result = new StringOption();
		in.beginObject();
		result.readFields(in);
		in.endObject();
		return result;
	}

	@Override
	public String jsonType() {
		return STRING_OPTION__TYPE;
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
