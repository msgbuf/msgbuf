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

	/**
	 * Creates a {@link CustomType} instance.
	 *
	 * @see #create()
	 */
	protected CustomType() {
		super();
	}

	/** @see #getName() */
	public static final String NAME = "name";

	/** @see #getDefinition() */
	public static final String DEFINITION = "definition";

	private QName _name = null;

	private transient Definition _definition = null;

	/**
	 * The name of the reference type.
	 */
	public final QName getName() {
		return _name;
	}

	/**
	 * @see #getName()
	 */
	public final CustomType setName(QName value) {
		_name = value;
		return this;
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
	public final CustomType setDefinition(Definition value) {
		_definition = value;
		return this;
	}

	/**
	 * Checks, whether {@link #getDefinition()} has a value.
	 */
	public final boolean hasDefinition() {
		return _definition != null;
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
	public String jsonType() {
		return "CustomType";
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
			case NAME: setName(QName.readQName(in)); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public int typeId() {
		return 1;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		super.writeFields(out);
		if (hasName()) {
			out.name(1);
			getName().writeTo(out);
		}
	}

	@Override
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case 1: setName(QName.readQName(in)); break;
			default: super.readField(in, field);
		}
	}

	/** Reads a new instance from the given reader. */
	public static CustomType readCustomType(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		CustomType result = new CustomType();
		while (in.hasNext()) {
			int field = in.nextName();
			result.readField(in, field);
		}
		in.endObject();
		return result;
	}

	@Override
	public <R,A> R visit(Type.Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}

}
