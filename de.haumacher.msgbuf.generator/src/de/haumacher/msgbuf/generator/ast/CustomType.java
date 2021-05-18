package de.haumacher.msgbuf.generator.ast;

public class CustomType extends Type {

	/**
	 * Creates a {@link CustomType} instance.
	 */
	public static CustomType customType() {
		return new CustomType();
	}

	/**
	 * Creates a {@link CustomType} instance.
	 *
	 * @see #customType()
	 */
	protected CustomType() {
		super();
	}

	private QName _name = null;

	private transient Definition _definition = null;

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

	private static final int[] FIELDS = {0, 0, };

	/** Reads a new instance from the given reader. */
	public static CustomType readCustomType(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		CustomType result = new CustomType();
		result.readContent(in);
		return result;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case "name": return getName();
			case "definition": return getDefinition();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case "name": setName((QName) value); break;
			case "definition": setDefinition((Definition) value); break;
			default: super.set(field, value); break;
		}
	}

	@Override
	protected void writeContent(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeContent(out);
		if (hasName()) {
			out.name("name");
			getName().writeTo(out);
		}
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case "name": setName(QName.readQName(in)); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public <R,A> R visit(Type.Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}

}
