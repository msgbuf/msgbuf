package de.haumacher.msgbuf.generator.ast;

/**
 * A field definition of a {@link MessageDef}.
 */
public class Field implements de.haumacher.msgbuf.data.DataObject {

	/**
	 * Creates a {@link Field} instance.
	 */
	public static Field field() {
		return new Field();
	}

	/**
	 * Creates a {@link Field} instance.
	 *
	 * @see #field()
	 */
	protected Field() {
		super();
	}

	private String _comment = "";

	private String _name = "";

	private boolean _transient = false;

	private boolean _repeated = false;

	private Type _type = null;

	private int _index = 0;

	/**
	 * The documentation comment for this field.
	 */
	public final String getComment() {
		return _comment;
	}

	/**
	 * @see #getComment()
	 */
	public final Field setComment(String value) {
		_comment = value;
		return this;
	}

	/**
	 * The name of this field.
	 */
	public final String getName() {
		return _name;
	}

	/**
	 * @see #getName()
	 */
	public final Field setName(String value) {
		_name = value;
		return this;
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
	public final Field setTransient(boolean value) {
		_transient = value;
		return this;
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
	public final Field setRepeated(boolean value) {
		_repeated = value;
		return this;
	}

	/**
	 * The type of values that can be stored in this field.
	 */
	public final Type getType() {
		return _type;
	}

	/**
	 * @see #getType()
	 */
	public final Field setType(Type value) {
		_type = value;
		return this;
	}

	/**
	 * Checks, whether {@link #getType()} has a value.
	 */
	public final boolean hasType() {
		return _type != null;
	}

	/**
	 * The numerical ID of this field.
	 */
	public final int getIndex() {
		return _index;
	}

	/**
	 * @see #getIndex()
	 */
	public final Field setIndex(int value) {
		_index = value;
		return this;
	}

	/** Reads a new instance from the given reader. */
	public static Field readField(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		Field result = new Field();
		result.readContent(in);
		return result;
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		out.beginObject();
		writeContent(out);
		out.endObject();
	}

	/** Reads all fields of this instance from the given input. */
	protected final void readContent(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		while (in.hasNext()) {
			String field = in.nextName();
			readField(in, field);
		}
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case "comment": return getComment();
			case "name": return getName();
			case "transient": return isTransient();
			case "repeated": return isRepeated();
			case "type": return getType();
			case "index": return getIndex();
			default: return null;
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case "comment": setComment((String) value); break;
			case "name": setName((String) value); break;
			case "transient": setTransient((boolean) value); break;
			case "repeated": setRepeated((boolean) value); break;
			case "type": setType((Type) value); break;
			case "index": setIndex((int) value); break;
		}
	}

	/** Writes all fields of this instance to the given output. */
	protected void writeContent(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		out.name("comment");
		out.value(getComment());
		out.name("name");
		out.value(getName());
		out.name("transient");
		out.value(isTransient());
		out.name("repeated");
		out.value(isRepeated());
		if (hasType()) {
			out.name("type");
			getType().writeTo(out);
		}
		out.name("index");
		out.value(getIndex());
	}

	/** Reads the given field from the given input. */
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case "comment": setComment(in.nextString()); break;
			case "name": setName(in.nextString()); break;
			case "transient": setTransient(in.nextBoolean()); break;
			case "repeated": setRepeated(in.nextBoolean()); break;
			case "type": setType(Type.readType(in)); break;
			case "index": setIndex(in.nextInt()); break;
			default: in.skipValue();
		}
	}

}
