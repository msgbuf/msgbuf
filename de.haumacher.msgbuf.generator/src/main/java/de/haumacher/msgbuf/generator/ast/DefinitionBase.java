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
	public static final String COMMENT = "comment";

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
	public DefinitionBase setComment(String value) {
		internalSetComment(value);
		return this;
	}

	/** Internal setter for {@link #getComment()} without chain call utility. */
	protected final void internalSetComment(String value) {
		_listener.beforeSet(this, COMMENT, value);
		_comment = value;
	}

	@Override
	public DefinitionBase setOptions(java.util.Map<String, Option> value) {
		internalSetOptions(value);
		return this;
	}

	@Override
	public DefinitionBase putOption(String key, Option value) {
		internalPutOption(key, value);
		return this;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			COMMENT));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case COMMENT: return getComment();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case COMMENT: internalSetComment((String) value); break;
			default: super.set(field, value); break;
		}
	}

	/** Reads a new instance from the given reader. */
	public static DefinitionBase readDefinitionBase(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		DefinitionBase result;
		in.beginArray();
		String type = in.nextString();
		switch (type) {
			case Constant.CONSTANT__TYPE: result = de.haumacher.msgbuf.generator.ast.Constant.readConstant(in); break;
			case Field.FIELD__TYPE: result = de.haumacher.msgbuf.generator.ast.Field.readField(in); break;
			case EnumDef.ENUM_DEF__TYPE: result = de.haumacher.msgbuf.generator.ast.EnumDef.readEnumDef(in); break;
			case MessageDef.MESSAGE_DEF__TYPE: result = de.haumacher.msgbuf.generator.ast.MessageDef.readMessageDef(in); break;
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
		return visit((DefinitionBase.Visitor<R,A>) v, arg);
	}

}
