package de.haumacher.msgbuf.generator.ast;

/**
 * {@link Option} annotating a boolean value
 */
public class Flag extends Option {

	/**
	 * Creates a {@link Flag} instance.
	 */
	public static Flag create() {
		return new Flag();
	}

	/**
	 * Creates a {@link Flag} instance.
	 *
	 * @see #create()
	 */
	protected Flag() {
		super();
	}

	/** Identifier for the {@link Flag} type in JSON format. */
	public static final String FLAG__TYPE = "Flag";

	/** @see #isValue() */
	public static final String VALUE = "value";

	private boolean _value = false;

	/**
	 * The boolean value assigned to the option {@link #name}.
	 */
	public final boolean isValue() {
		return _value;
	}

	/**
	 * @see #isValue()
	 */
	public final Flag setValue(boolean value) {
		_value = value;
		return this;
	}

	/** Reads a new instance from the given reader. */
	public static Flag readFlag(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		Flag result = new Flag();
		in.beginObject();
		result.readFields(in);
		in.endObject();
		return result;
	}

	@Override
	public String jsonType() {
		return FLAG__TYPE;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(VALUE);
		out.value(isValue());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case VALUE: setValue(in.nextBoolean()); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public <R,A> R visit(Option.Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}

}
