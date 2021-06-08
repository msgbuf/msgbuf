package de.haumacher.msgbuf.generator.ast;

/**
 * An option annotation.
 */
public abstract class Option extends de.haumacher.msgbuf.data.AbstractDataObject implements de.haumacher.msgbuf.binary.BinaryDataObject {

	/** Visitor interface for the {@link Option} hierarchy.*/
	public interface Visitor<R,A> {

		/** Visit case for {@link StringOption}.*/
		R visit(StringOption self, A arg);

		/** Visit case for {@link NumberOption}.*/
		R visit(NumberOption self, A arg);

		/** Visit case for {@link Flag}.*/
		R visit(Flag self, A arg);

	}

	/**
	 * Creates a {@link Option} instance.
	 */
	protected Option() {
		super();
	}

	private String _name = "";

	/**
	 * The name of this option.
	 */
	public final String getName() {
		return _name;
	}

	/**
	 * @see #getName()
	 */
	public final Option setName(String value) {
		_name = value;
		return this;
	}

	/** Reads a new instance from the given reader. */
	public static Option readOption(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		Option result;
		in.beginArray();
		String type = in.nextString();
		switch (type) {
			case "StringOption": result = StringOption.readStringOption(in); break;
			case "NumberOption": result = NumberOption.readNumberOption(in); break;
			case "Flag": result = Flag.readFlag(in); break;
			default: in.skipValue(); result = null; break;
		}
		in.endArray();
		return result;
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		out.beginArray();
		out.value(jsonType());
		writeContent(out);
		out.endArray();
	}

	/** The type identifier for this concrete subtype. */
	protected abstract String jsonType();

	@Override
	public Object get(String field) {
		switch (field) {
			case "name": return getName();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case "name": setName((String) value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name("name");
		out.value(getName());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case "name": setName(in.nextString()); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		out.beginObject();
		out.name(0);
		out.value(typeId());
		writeFields(out);
		out.endObject();
	}

	/** The binary identifier for this concrete type in the polymorphic {@link Option} hierarchy. */
	protected abstract int typeId();

	/**
	 * Serializes all fields of this instance to the given binary output.
	 *
	 * @param out
	 *        The binary output to write to.
	 * @throws java.io.IOException If writing fails.
	 */
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		out.name(1);
		out.value(getName());
	}

	/** Consumes the value for the field with the given ID and assigns its value. */
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case 1: setName(in.nextString()); break;
			default: in.skipValue(); 
		}
	}

	/** Reads a new instance from the given reader. */
	public static Option readOption(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		Option result;
		int typeField = in.nextName();
		assert typeField == 0;
		int type = in.nextInt();
		switch (type) {
			case 1: result = StringOption.create(); break;
			case 2: result = NumberOption.create(); break;
			case 3: result = Flag.create(); break;
			default: while (in.hasNext()) {in.skipValue(); } in.endObject(); return null;
		}
		while (in.hasNext()) {
			int field = in.nextName();
			result.readField(in, field);
		}
		in.endObject();
		return result;
	}

	/** Accepts the given visitor. */
	public abstract <R,A> R visit(Visitor<R,A> v, A arg);


}
