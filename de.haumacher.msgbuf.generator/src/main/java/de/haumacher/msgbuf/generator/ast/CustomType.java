package de.haumacher.msgbuf.generator.ast;

/**
 * Reference to a custom defined {@link Type}.
 *
 * A custom type is either a {@link EnumDef}, or a {@link MessageDef}.
 */
public class CustomType extends Type {

	/**
	 * Creates a {@link de.haumacher.msgbuf.generator.ast.CustomType} instance.
	 */
	public static de.haumacher.msgbuf.generator.ast.CustomType create() {
		return new de.haumacher.msgbuf.generator.ast.CustomType();
	}

	/** Identifier for the {@link de.haumacher.msgbuf.generator.ast.CustomType} type in JSON format. */
	public static final String CUSTOM_TYPE__TYPE = "CustomType";

	/** @see #getName() */
	public static final String NAME__PROP = "name";

	/** @see #getDefinition() */
	public static final String DEFINITION__PROP = "definition";

	private de.haumacher.msgbuf.generator.ast.QName _name = null;

	private transient de.haumacher.msgbuf.generator.ast.Definition _definition = null;

	/**
	 * Creates a {@link CustomType} instance.
	 *
	 * @see de.haumacher.msgbuf.generator.ast.CustomType#create()
	 */
	protected CustomType() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.CUSTOM_TYPE;
	}

	/**
	 * The name of the reference type.
	 */
	public final de.haumacher.msgbuf.generator.ast.QName getName() {
		return _name;
	}

	/**
	 * @see #getName()
	 */
	public de.haumacher.msgbuf.generator.ast.CustomType setName(de.haumacher.msgbuf.generator.ast.QName value) {
		internalSetName(value);
		return this;
	}

	/** Internal setter for {@link #getName()} without chain call utility. */
	protected final void internalSetName(de.haumacher.msgbuf.generator.ast.QName value) {
		_listener.beforeSet(this, NAME__PROP, value);
		_name = value;
	}

	/**
	 * Checks, whether {@link #getName()} has a value.
	 */
	public final boolean hasName() {
		return _name != null;
	}

	/**
	 * Resolved reference of the {@link Definition} defining the {@link #getName() referenced type}.
	 */
	public final de.haumacher.msgbuf.generator.ast.Definition getDefinition() {
		return _definition;
	}

	/**
	 * @see #getDefinition()
	 */
	public de.haumacher.msgbuf.generator.ast.CustomType setDefinition(de.haumacher.msgbuf.generator.ast.Definition value) {
		internalSetDefinition(value);
		return this;
	}

	/** Internal setter for {@link #getDefinition()} without chain call utility. */
	protected final void internalSetDefinition(de.haumacher.msgbuf.generator.ast.Definition value) {
		_listener.beforeSet(this, DEFINITION__PROP, value);
		_definition = value;
	}

	/**
	 * Checks, whether {@link #getDefinition()} has a value.
	 */
	public final boolean hasDefinition() {
		return _definition != null;
	}

	@Override
	public String jsonType() {
		return CUSTOM_TYPE__TYPE;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			NAME__PROP, 
			DEFINITION__PROP));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case NAME__PROP: return getName();
			case DEFINITION__PROP: return getDefinition();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case NAME__PROP: internalSetName((de.haumacher.msgbuf.generator.ast.QName) value); break;
			case DEFINITION__PROP: internalSetDefinition((de.haumacher.msgbuf.generator.ast.Definition) value); break;
			default: super.set(field, value); break;
		}
	}

	/** Reads a new instance from the given reader. */
	public static de.haumacher.msgbuf.generator.ast.CustomType readCustomType(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		de.haumacher.msgbuf.generator.ast.CustomType result = new de.haumacher.msgbuf.generator.ast.CustomType();
		result.readContent(in);
		return result;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		if (hasName()) {
			out.name(NAME__PROP);
			getName().writeTo(out);
		}
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case NAME__PROP: setName(de.haumacher.msgbuf.generator.ast.QName.readQName(in)); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public <R,A> R visit(de.haumacher.msgbuf.generator.ast.Type.Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}

}
