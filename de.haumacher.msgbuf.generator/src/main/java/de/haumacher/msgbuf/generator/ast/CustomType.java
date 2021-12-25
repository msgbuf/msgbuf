package de.haumacher.msgbuf.generator.ast;

/**
 * Reference to a custom defined {@link Type}.
 *
 * A custom type is either a {@link EnumDef}, or a {@link MessageDef}.
 */
public class CustomType extends Type {

	/**
	 * Creates a {@link CustomType} instance.
	 */
	public static CustomType create() {
		return new CustomType();
	}

	/** Identifier for the {@link CustomType} type in JSON format. */
	public static final String CUSTOM_TYPE__TYPE = "CustomType";

	/** @see #getName() */
	public static final String NAME = "name";

	/** @see #getDefinition() */
	public static final String DEFINITION = "definition";

	private QName _name = null;

	private transient Definition _definition = null;

	/**
	 * Creates a {@link CustomType} instance.
	 *
	 * @see #create()
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
	public final QName getName() {
		return _name;
	}

	/**
	 * @see #getName()
	 */
	public CustomType setName(QName value) {
		internalSetName(value);
		return this;
	}
	/** Internal setter for {@link #getName()} without chain call utility. */
	protected final void internalSetName(QName value) {
		_listener.beforeSet(this, NAME, value);
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
	public final Definition getDefinition() {
		return _definition;
	}

	/**
	 * @see #getDefinition()
	 */
	public CustomType setDefinition(Definition value) {
		internalSetDefinition(value);
		return this;
	}
	/** Internal setter for {@link #getDefinition()} without chain call utility. */
	protected final void internalSetDefinition(Definition value) {
		_listener.beforeSet(this, DEFINITION, value);
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
			NAME, 
			DEFINITION));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case NAME: return getName();
			case DEFINITION: return getDefinition();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case NAME: setName((QName) value); break;
			case DEFINITION: setDefinition((Definition) value); break;
			default: super.set(field, value); break;
		}
	}

	/** Reads a new instance from the given reader. */
	public static CustomType readCustomType(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		CustomType result = new CustomType();
		in.beginObject();
		result.readFields(in);
		in.endObject();
		return result;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		if (hasName()) {
			out.name(NAME);
			getName().writeTo(out);
		}
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case NAME: setName(de.haumacher.msgbuf.generator.ast.QName.readQName(in)); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public <R,A> R visit(Type.Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}

}
