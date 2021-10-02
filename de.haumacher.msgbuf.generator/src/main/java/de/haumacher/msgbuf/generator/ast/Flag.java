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

	/** @see #isValue() */
	public static final String VALUE = "value";

	private boolean _value = false;

	/**
	 * The boolean value assigned to the option {@link #getName()}.
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
		return "Flag";
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
			case VALUE: return isValue();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case VALUE: setValue((boolean) value); break;
			default: super.set(field, value); break;
		}
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
	public int typeId() {
		return 3;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(2);
		out.value(isValue());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case 2: setValue(in.nextBoolean()); break;
			default: super.readField(in, field);
		}
	}

	/** Reads a new instance from the given reader. */
	public static Flag readFlag(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		Flag result = new Flag();
		while (in.hasNext()) {
			int field = in.nextName();
			result.readField(in, field);
		}
		in.endObject();
		return result;
	}

	@Override
	public <R,A> R visit(Option.Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}

}
