package de.haumacher.msgbuf.generator.ast;

/**
 * An option annotation.
 */
public abstract class Option extends de.haumacher.msgbuf.data.AbstractDataObject {

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

	/** Accepts the given visitor. */
	public abstract <R,A> R visit(Visitor<R,A> v, A arg);


}
