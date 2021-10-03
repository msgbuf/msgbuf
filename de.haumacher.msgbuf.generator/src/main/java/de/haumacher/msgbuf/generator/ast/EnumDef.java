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
	private static final String CONSTANTS = "constants";

	private final java.util.List<Constant> _constants = new java.util.ArrayList<>();

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
	public final EnumDef setConstants(java.util.List<Constant> value) {
		if (value == null) throw new IllegalArgumentException("Property 'constants' cannot be null.");
		_constants.clear();
		_constants.addAll(value);
		return this;
	}

	/**
	 * Adds a value to the {@link #getConstants()} list.
	 */
	public final EnumDef addConstant(Constant value) {
		_constants.add(value);
		return this;
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
	public String jsonType() {
		return ENUM_DEF__TYPE;
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
					addConstant(Constant.readConstant(in));
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
