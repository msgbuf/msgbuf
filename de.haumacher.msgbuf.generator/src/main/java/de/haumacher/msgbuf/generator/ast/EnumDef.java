package de.haumacher.msgbuf.generator.ast;

/**
 * {@link Definition} of an enumeration.
 */
public class EnumDef extends Definition {

	/**
	 * Creates a {@link EnumDef} instance.
	 */
	public static EnumDef create() {
		return new EnumDef();
	}

	/** Identifier for the {@link EnumDef} type in JSON format. */
	public static final String ENUM_DEF__TYPE = "EnumDef";

	/** @see #getConstants() */
	public static final String CONSTANTS = "constants";

	private final java.util.List<Constant> _constants = new de.haumacher.msgbuf.util.ReferenceList<Constant>() {
		@Override
		protected void beforeAdd(int index, Constant element) {
			_listener.beforeAdd(de.haumacher.msgbuf.generator.ast.EnumDef.this, CONSTANTS, index, element);
		}

		@Override
		protected void afterRemove(int index, Constant element) {
			_listener.afterRemove(de.haumacher.msgbuf.generator.ast.EnumDef.this, CONSTANTS, index, element);
		}
	};

	/**
	 * Creates a {@link EnumDef} instance.
	 *
	 * @see #create()
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
	public final java.util.List<Constant> getConstants() {
		return _constants;
	}

	/**
	 * @see #getConstants()
	 */
	public EnumDef setConstants(java.util.List<Constant> value) {
		internalSetConstants(value);
		return this;
	}
	/** Internal setter for {@link #getConstants()} without chain call utility. */
	protected final void internalSetConstants(java.util.List<Constant> value) {
		if (value == null) throw new IllegalArgumentException("Property 'constants' cannot be null.");
		_constants.clear();
		_constants.addAll(value);
	}


	/**
	 * Adds a value to the {@link #getConstants()} list.
	 */
	public EnumDef addConstant(Constant value) {
		internalAddConstant(value);
		return this;
	}

	/** Implementation of {@link #addConstant(Constant)} without chain call utility. */
	protected final void internalAddConstant(Constant value) {
		_constants.add(value);
	}

	/**
	 * Removes a value from the {@link #getConstants()} list.
	 */
	public final void removeConstant(Constant value) {
		_constants.remove(value);
	}

	@Override
	public EnumDef setName(String value) {
		internalSetName(value);
		return this;
	}

	@Override
	public EnumDef setFile(DefinitionFile value) {
		internalSetFile(value);
		return this;
	}

	@Override
	public EnumDef setOuter(MessageDef value) {
		internalSetOuter(value);
		return this;
	}

	@Override
	public EnumDef setComment(String value) {
		internalSetComment(value);
		return this;
	}

	@Override
	public EnumDef setOptions(java.util.Map<String, Option> value) {
		internalSetOptions(value);
		return this;
	}

	@Override
	public EnumDef putOption(String key, Option value) {
		internalPutOption(key, value);
		return this;
	}

	@Override
	public String jsonType() {
		return ENUM_DEF__TYPE;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			CONSTANTS));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case CONSTANTS: return getConstants();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case CONSTANTS: setConstants((java.util.List<Constant>) value); break;
			default: super.set(field, value); break;
		}
	}

	/** Reads a new instance from the given reader. */
	public static EnumDef readEnumDef(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		EnumDef result = new EnumDef();
		in.beginObject();
		result.readFields(in);
		in.endObject();
		return result;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(CONSTANTS);
		out.beginArray();
		for (Constant x : getConstants()) {
			x.writeContent(out);
		}
		out.endArray();
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case CONSTANTS: {
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
	public <R,A> R visit(Definition.Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}

}
