package de.haumacher.msgbuf.generator.ast;

/**
 * {@link Option} annotating an int value
 */
public class NumberOption extends Option {

	/**
	 * Creates a {@link NumberOption} instance.
	 */
	public static NumberOption create() {
		return new NumberOption();
	}

	/** Identifier for the {@link NumberOption} type in JSON format. */
	public static final String NUMBER_OPTION__TYPE = "NumberOption";

	/** @see #getValue() */
	public static final String VALUE = "value";

	private double _value = 0.0d;

	/**
	 * Creates a {@link NumberOption} instance.
	 *
	 * @see #create()
	 */
	protected NumberOption() {
		super();
	}

	/**
	 * The number assigned to the option {@link #name}.
	 */
	public final double getValue() {
		return _value;
	}

	/**
	 * @see #getValue()
	 */
	public final NumberOption setValue(double value) {
		_value = value;
		return this;
	}

	/** Reads a new instance from the given reader. */
	public static NumberOption readNumberOption(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		NumberOption result = new NumberOption();
		in.beginObject();
		result.readFields(in);
		in.endObject();
		return result;
	}

	@Override
	public String jsonType() {
		return NUMBER_OPTION__TYPE;
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
			case VALUE: setValue(in.nextDouble()); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public <R,A> R visit(Option.Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}

}
