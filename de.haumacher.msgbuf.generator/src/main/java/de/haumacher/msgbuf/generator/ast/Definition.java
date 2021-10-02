package de.haumacher.msgbuf.generator.ast;

/**
 * Base class of a definition in a {@link DefinitionFile}.
 */
public abstract class Definition extends WithOptions {

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

	/** @see #getComment() */
	public static final String COMMENT = "comment";

	/** @see #getName() */
	public static final String NAME = "name";

	/** @see #getFile() */
	public static final String FILE = "file";

	/** @see #getOuter() */
	public static final String OUTER = "outer";

	private String _comment = "";

	private String _name = "";

	private transient DefinitionFile _file = null;

	private transient MessageDef _outer = null;

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

	/**
	 * The {@link MessageDef} that contains this inner {@Definition}.
	 *
	 * <p>
	 * The value is <code>null</code> for top-level defintions, see {@link #getFile()}.
	 * </p>
	 */
	public final MessageDef getOuter() {
		return _outer;
	}

	/**
	 * @see #getOuter()
	 */
	public final Definition setOuter(MessageDef value) {
		_outer = value;
		return this;
	}

	/**
	 * Checks, whether {@link #getOuter()} has a value.
	 */
	public final boolean hasOuter() {
		return _outer != null;
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
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(COMMENT);
		out.value(getComment());
		out.name(NAME);
		out.value(getName());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case COMMENT: setComment(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			case NAME: setName(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			default: super.readField(in, field);
		}
	}

	/** Accepts the given visitor. */
	public abstract <R,A> R visit(Visitor<R,A> v, A arg);


	@Override
	public final <R,A> R visit(WithOptions.Visitor<R,A> v, A arg) {
		return visit((Visitor<R,A>) v, arg);
	}

}
