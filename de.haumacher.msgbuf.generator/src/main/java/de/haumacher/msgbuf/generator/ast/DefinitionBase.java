package de.haumacher.msgbuf.generator.ast;

/**
 * Base class for type and field definitions.
 */
public abstract class DefinitionBase extends WithOptions {

	/** Visitor interface for the {@link DefinitionBase} hierarchy.*/
	public interface Visitor<R,A> extends Part.Visitor<R,A>, Definition.Visitor<R,A> {

		// Pure sum interface.

	}

	/** @see #getComment() */
	private static final String COMMENT = "comment";

	private String _comment = "";

	/**
	 * Creates a {@link DefinitionBase} instance.
	 */
	protected DefinitionBase() {
		super();
	}

	/**
	 * The documentation comment for this definition.
	 */
	public final String getComment() {
		return _comment;
	}

	/**
	 * @see #getComment()
	 */
	public final DefinitionBase setComment(String value) {
		_comment = value;
		return this;
	}

	/** Reads a new instance from the given reader. */
	public static DefinitionBase readDefinitionBase(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		DefinitionBase result;
		in.beginArray();
		String type = in.nextString();
		switch (type) {
			case Constant.CONSTANT__TYPE: result = Constant.readConstant(in); break;
			case Field.FIELD__TYPE: result = Field.readField(in); break;
			case EnumDef.ENUM_DEF__TYPE: result = EnumDef.readEnumDef(in); break;
			case MessageDef.MESSAGE_DEF__TYPE: result = MessageDef.readMessageDef(in); break;
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
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case COMMENT: setComment(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
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
