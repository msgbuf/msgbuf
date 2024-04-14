package de.haumacher.msgbuf.generator.ast;

/**
 * {@link Definition} of an enumeration.
 */
public class EnumDef extends Definition {

	/**
	 * Creates a {@link de.haumacher.msgbuf.generator.ast.EnumDef} instance.
	 */
	public static de.haumacher.msgbuf.generator.ast.EnumDef create() {
		return new de.haumacher.msgbuf.generator.ast.EnumDef();
	}

	/** Identifier for the {@link de.haumacher.msgbuf.generator.ast.EnumDef} type in JSON format. */
	public static final String ENUM_DEF__TYPE = "EnumDef";

	/** @see #getConstants() */
	public static final String CONSTANTS__PROP = "constants";

	private final java.util.List<de.haumacher.msgbuf.generator.ast.Constant> _constants = new de.haumacher.msgbuf.util.ReferenceList<>() {
		@Override
		protected void beforeAdd(int index, de.haumacher.msgbuf.generator.ast.Constant element) {
			_listener.beforeAdd(EnumDef.this, CONSTANTS__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, de.haumacher.msgbuf.generator.ast.Constant element) {
			_listener.afterRemove(EnumDef.this, CONSTANTS__PROP, index, element);
		}
	};

	/**
	 * Creates a {@link EnumDef} instance.
	 *
	 * @see de.haumacher.msgbuf.generator.ast.EnumDef#create()
	 */
	protected EnumDef() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.ENUM_DEF;
	}

	/**
	 * All enum constants of this enumeration
	 */
	public final java.util.List<de.haumacher.msgbuf.generator.ast.Constant> getConstants() {
		return _constants;
	}

	/**
	 * @see #getConstants()
	 */
	public de.haumacher.msgbuf.generator.ast.EnumDef setConstants(java.util.List<? extends de.haumacher.msgbuf.generator.ast.Constant> value) {
		internalSetConstants(value);
		return this;
	}

	/** Internal setter for {@link #getConstants()} without chain call utility. */
	protected final void internalSetConstants(java.util.List<? extends de.haumacher.msgbuf.generator.ast.Constant> value) {
		if (value == null) throw new IllegalArgumentException("Property 'constants' cannot be null.");
		_constants.clear();
		_constants.addAll(value);
	}

	/**
	 * Adds a value to the {@link #getConstants()} list.
	 */
	public de.haumacher.msgbuf.generator.ast.EnumDef addConstant(de.haumacher.msgbuf.generator.ast.Constant value) {
		internalAddConstant(value);
		return this;
	}

	/** Implementation of {@link #addConstant(de.haumacher.msgbuf.generator.ast.Constant)} without chain call utility. */
	protected final void internalAddConstant(de.haumacher.msgbuf.generator.ast.Constant value) {
		_constants.add(value);
	}

	/**
	 * Removes a value from the {@link #getConstants()} list.
	 */
	public final void removeConstant(de.haumacher.msgbuf.generator.ast.Constant value) {
		_constants.remove(value);
	}

	@Override
	public de.haumacher.msgbuf.generator.ast.EnumDef setName(String value) {
		internalSetName(value);
		return this;
	}

	@Override
	public de.haumacher.msgbuf.generator.ast.EnumDef setFile(de.haumacher.msgbuf.generator.ast.DefinitionFile value) {
		internalSetFile(value);
		return this;
	}

	@Override
	public de.haumacher.msgbuf.generator.ast.EnumDef setOuter(de.haumacher.msgbuf.generator.ast.MessageDef value) {
		internalSetOuter(value);
		return this;
	}

	@Override
	public de.haumacher.msgbuf.generator.ast.EnumDef setComment(String value) {
		internalSetComment(value);
		return this;
	}

	@Override
	public de.haumacher.msgbuf.generator.ast.EnumDef setOptions(java.util.Map<String, de.haumacher.msgbuf.generator.ast.Option> value) {
		internalSetOptions(value);
		return this;
	}

	@Override
	public de.haumacher.msgbuf.generator.ast.EnumDef putOption(String key, de.haumacher.msgbuf.generator.ast.Option value) {
		internalPutOption(key, value);
		return this;
	}

	@Override
	public String jsonType() {
		return ENUM_DEF__TYPE;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			CONSTANTS__PROP));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case CONSTANTS__PROP: return getConstants();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case CONSTANTS__PROP: internalSetConstants(de.haumacher.msgbuf.util.Conversions.asList(de.haumacher.msgbuf.generator.ast.Constant.class, value)); break;
			default: super.set(field, value); break;
		}
	}

	/** Reads a new instance from the given reader. */
	public static de.haumacher.msgbuf.generator.ast.EnumDef readEnumDef(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		de.haumacher.msgbuf.generator.ast.EnumDef result = new de.haumacher.msgbuf.generator.ast.EnumDef();
		result.readContent(in);
		return result;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(CONSTANTS__PROP);
		out.beginArray();
		for (de.haumacher.msgbuf.generator.ast.Constant x : getConstants()) {
			x.writeContent(out);
		}
		out.endArray();
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case CONSTANTS__PROP: {
				in.beginArray();
				while (in.hasNext()) {
					addConstant(de.haumacher.msgbuf.generator.ast.Constant.readConstant(in));
				}
				in.endArray();
			}
			break;
			default: super.readField(in, field);
		}
	}

	@Override
	public <R,A> R visit(de.haumacher.msgbuf.generator.ast.Definition.Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}

}
