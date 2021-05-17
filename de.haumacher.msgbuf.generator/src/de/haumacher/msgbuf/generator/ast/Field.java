package de.haumacher.msgbuf.generator.ast;

public class Field {

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

	private boolean _repeated;

	private Type _type;

	private String _name;

	private int _index;

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

	private static final int[] FIELDS = {0, 0, 0, 0, };

	/** Reads a new instance from the given reader. */
	public static Field readField(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		Field result = new Field();
		result.readContent(in);
		return result;
	}

	/** Writes this instance to the given output. */
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

	/** Retrieves value of the field with the given index. */
	public Object get(String field) {
		switch (field) {
			case "repeated": return isRepeated();
			case "type": return getType();
			case "name": return getName();
			case "index": return getIndex();
			default: return null;
		}
	}

	/** Sets the value of the field with the given index. */
	public void set(String field, Object value) {
		switch (field) {
			case "repeated": setRepeated((boolean) value); break;
			case "type": setType((Type) value); break;
			case "name": setName((String) value); break;
			case "index": setIndex((int) value); break;
		}
	}

	/** Writes all fields of this instance to the given output. */
	protected void writeContent(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		out.name("repeated");
		out.value(isRepeated());
		out.name("type");
		getType().writeTo(out);
		out.name("name");
		out.value(getName());
		out.name("index");
		out.value(getIndex());
	}

	/** Reads the given field from the given input. */
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case "repeated": setRepeated(in.nextBoolean()); break;
			case "type": setType(Type.readType(in)); break;
			case "name": setName(in.nextString()); break;
			case "index": setIndex(in.nextInt()); break;
			default: in.skipValue();
		}
	}

}
