package de.haumacher.msgbuf.generator.ast;

/**
 * A constant of an {@link EnumDef}.
 *
 * @see EnumDef#getConstants()
 */
public class Constant extends Part {

	/**
	 * Creates a {@link de.haumacher.msgbuf.generator.ast.Constant} instance.
	 */
	public static de.haumacher.msgbuf.generator.ast.Constant create() {
		return new de.haumacher.msgbuf.generator.ast.Constant();
	}

	/** Identifier for the {@link de.haumacher.msgbuf.generator.ast.Constant} type in JSON format. */
	public static final String CONSTANT__TYPE = "Constant";

	/**
	 * Creates a {@link Constant} instance.
	 *
	 * @see de.haumacher.msgbuf.generator.ast.Constant#create()
	 */
	protected Constant() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.CONSTANT;
	}

	@Override
	public de.haumacher.msgbuf.generator.ast.Constant setName(String value) {
		internalSetName(value);
		return this;
	}

	@Override
	public de.haumacher.msgbuf.generator.ast.Constant setIndex(int value) {
		internalSetIndex(value);
		return this;
	}

	@Override
	public de.haumacher.msgbuf.generator.ast.Constant setOwner(de.haumacher.msgbuf.generator.ast.Definition value) {
		internalSetOwner(value);
		return this;
	}

	@Override
	public de.haumacher.msgbuf.generator.ast.Constant setComment(String value) {
		internalSetComment(value);
		return this;
	}

	@Override
	public de.haumacher.msgbuf.generator.ast.Constant setOptions(java.util.Map<String, de.haumacher.msgbuf.generator.ast.Option> value) {
		internalSetOptions(value);
		return this;
	}

	@Override
	public de.haumacher.msgbuf.generator.ast.Constant putOption(String key, de.haumacher.msgbuf.generator.ast.Option value) {
		internalPutOption(key, value);
		return this;
	}

	@Override
	public String jsonType() {
		return CONSTANT__TYPE;
	}

	/** Reads a new instance from the given reader. */
	public static de.haumacher.msgbuf.generator.ast.Constant readConstant(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		de.haumacher.msgbuf.generator.ast.Constant result = new de.haumacher.msgbuf.generator.ast.Constant();
		result.readContent(in);
		return result;
	}

	@Override
	public <R,A> R visit(de.haumacher.msgbuf.generator.ast.Part.Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}

}
