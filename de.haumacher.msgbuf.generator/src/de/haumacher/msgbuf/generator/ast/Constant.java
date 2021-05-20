package de.haumacher.msgbuf.generator.ast;

/**
 * A constant of an {@link EnumDef}.
 *
 * @see EnumDef#getConstants()
 */
public class Constant extends de.haumacher.msgbuf.data.AbstractDataObject {

	/**
	 * Creates a {@link Constant} instance.
	 */
	public static Constant constant() {
		return new Constant();
	}

	/**
	 * Creates a {@link Constant} instance.
	 *
	 * @see #constant()
	 */
	protected Constant() {
		super();
	}

	private String _comment = "";

	private String _name = "";

	private int _index = 0;

	/**
	 * The documentation comment for this constant.
	 */
	public final String getComment() {
		return _comment;
	}

	/**
	 * @see #getComment()
	 */
	public final Constant setComment(String value) {
		_comment = value;
		return this;
	}

	/**
	 * The name of this constant.
	 */
	public final String getName() {
		return _name;
	}

	/**
	 * @see #getName()
	 */
	public final Constant setName(String value) {
		_name = value;
		return this;
	}

	/**
	 * The numeric identifier for this constant.
	 */
	public final int getIndex() {
		return _index;
	}

	/**
	 * @see #getIndex()
	 */
	public final Constant setIndex(int value) {
		_index = value;
		return this;
	}

	/** Reads a new instance from the given reader. */
	public static Constant readConstant(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		Constant result = new Constant();
		in.beginObject();
		result.readFields(in);
		in.endObject();
		return result;
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case "comment": return getComment();
			case "name": return getName();
			case "index": return getIndex();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case "comment": setComment((String) value); break;
			case "name": setName((String) value); break;
			case "index": setIndex((int) value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name("comment");
		out.value(getComment());
		out.name("name");
		out.value(getName());
		out.name("index");
		out.value(getIndex());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case "comment": setComment(in.nextString()); break;
			case "name": setName(in.nextString()); break;
			case "index": setIndex(in.nextInt()); break;
			default: super.readField(in, field);
		}
	}

}
