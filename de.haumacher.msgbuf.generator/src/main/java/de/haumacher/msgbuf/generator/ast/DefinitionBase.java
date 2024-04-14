package de.haumacher.msgbuf.generator.ast;

/**
 * Base class for type and field definitions.
 */
public abstract class DefinitionBase extends WithOptions {

	/** Visitor interface for the {@link de.haumacher.msgbuf.generator.ast.DefinitionBase} hierarchy.*/
	public interface Visitor<R,A> extends de.haumacher.msgbuf.generator.ast.Part.Visitor<R,A>, de.haumacher.msgbuf.generator.ast.Definition.Visitor<R,A> {

		// Pure sum interface.

	}

	/** @see #getComment() */
	public static final String COMMENT__PROP = "comment";

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
	public de.haumacher.msgbuf.generator.ast.DefinitionBase setComment(String value) {
		internalSetComment(value);
		return this;
	}

	/** Internal setter for {@link #getComment()} without chain call utility. */
	protected final void internalSetComment(String value) {
		_listener.beforeSet(this, COMMENT__PROP, value);
		_comment = value;
	}

	@Override
	public de.haumacher.msgbuf.generator.ast.DefinitionBase setOptions(java.util.Map<String, de.haumacher.msgbuf.generator.ast.Option> value) {
		internalSetOptions(value);
		return this;
	}

	@Override
	public de.haumacher.msgbuf.generator.ast.DefinitionBase putOption(String key, de.haumacher.msgbuf.generator.ast.Option value) {
		internalPutOption(key, value);
		return this;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			COMMENT__PROP));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case COMMENT__PROP: return getComment();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case COMMENT__PROP: internalSetComment((String) value); break;
			default: super.set(field, value); break;
		}
	}

	/** Reads a new instance from the given reader. */
	public static de.haumacher.msgbuf.generator.ast.DefinitionBase readDefinitionBase(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		de.haumacher.msgbuf.generator.ast.DefinitionBase result;
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
		out.name(COMMENT__PROP);
		out.value(getComment());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case COMMENT__PROP: setComment(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			default: super.readField(in, field);
		}
	}

	/** Accepts the given visitor. */
	public abstract <R,A> R visit(Visitor<R,A> v, A arg);

	@Override
	public final <R,A> R visit(de.haumacher.msgbuf.generator.ast.WithOptions.Visitor<R,A> v, A arg) {
		return visit((de.haumacher.msgbuf.generator.ast.DefinitionBase.Visitor<R,A>) v, arg);
	}

}
