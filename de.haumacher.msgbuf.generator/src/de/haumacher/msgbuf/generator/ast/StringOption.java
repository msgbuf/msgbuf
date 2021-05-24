package de.haumacher.msgbuf.generator.ast;

/**
 * {@link Option} annotating a string value
 */
public class StringOption extends Option {

	/**
	 * Creates a {@link StringOption} instance.
	 */
	public static StringOption stringOption() {
		return new StringOption();
	}

	/**
	 * Creates a {@link StringOption} instance.
	 *
	 * @see #stringOption()
	 */
	protected StringOption() {
		super();
	}

	private String _value = "";

	/**
	 * The string value assigned to the option {@link #getName()}.
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
	protected String jsonType() {
		return "StringOption";
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case "value": return getValue();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case "value": setValue((String) value); break;
			default: super.set(field, value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name("value");
		out.value(getValue());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case "value": setValue(in.nextString()); break;
			default: super.readField(in, field);
		}
	}

	@Override
	protected int typeId() {
		return 1;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(2);
		out.value(getValue());
	}

	/** Reads a new instance from the given reader. */
	public static StringOption readStringOption(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		StringOption result = new StringOption();
		while (in.hasNext()) {
			int field = in.nextName();
			result.readField(in, field);
		}
		in.endObject();
		return result;
	}

	@Override
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case 2: setValue(in.nextString()); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public <R,A> R visit(Option.Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}

}
