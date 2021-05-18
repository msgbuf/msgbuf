package de.haumacher.msgbuf.generator.ast;

/**
 * Base class of a definition in a {@link DefinitionFile}.
 */
public abstract class Definition extends de.haumacher.msgbuf.data.AbstractDataObject {

	/** Visitor interface for the {@link Definition} hierarchy.*/
	public interface Visitor<R,A> {

		/** Visit case for {@link EnumDef}.*/
		R visit(EnumDef self, A arg);

		/** Visit case for {@link MessageDef}.*/
		R visit(MessageDef self, A arg);

	}

	/**
	 * Creates a {@link Definition} instance.
	 */
	protected Definition() {
		super();
	}

	private String _comment = "";

	private String _name = "";

	private transient DefinitionFile _file = null;

	/**
	 * The documentation comment for this definition.
	 */
	public final String getComment() {
		return _comment;
	}

	/**
	 * @see #getComment()
	 */
	public final Definition setComment(String value) {
		_comment = value;
		return this;
	}

	/**
	 * The name of this definition.
	 */
	public final String getName() {
		return _name;
	}

	/**
	 * @see #getName()
	 */
	public final Definition setName(String value) {
		_name = value;
		return this;
	}

	/**
	 * Reference back to the {@link DefinitionFile} that contains this definition.
	 */
	public final DefinitionFile getFile() {
		return _file;
	}

	/**
	 * @see #getFile()
	 */
	public final Definition setFile(DefinitionFile value) {
		_file = value;
		return this;
	}

	/**
	 * Checks, whether {@link #getFile()} has a value.
	 */
	public final boolean hasFile() {
		return _file != null;
	}

	/** Reads a new instance from the given reader. */
	public static Definition readDefinition(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		Definition result;
		in.beginArray();
		String type = in.nextString();
		switch (type) {
			case "EnumDef": result = EnumDef.readEnumDef(in); break;
			case "MessageDef": result = MessageDef.readMessageDef(in); break;
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
			case "comment": return getComment();
			case "name": return getName();
			case "file": return getFile();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case "comment": setComment((String) value); break;
			case "name": setName((String) value); break;
			case "file": setFile((DefinitionFile) value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name("comment");
		out.value(getComment());
		out.name("name");
		out.value(getName());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case "comment": setComment(in.nextString()); break;
			case "name": setName(in.nextString()); break;
			default: super.readField(in, field);
		}
	}

	/** Accepts the given visitor. */
	public abstract <R,A> R visit(Visitor<R,A> v, A arg);


}
