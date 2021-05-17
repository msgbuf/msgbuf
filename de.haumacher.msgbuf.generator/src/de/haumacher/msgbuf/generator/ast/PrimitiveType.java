package de.haumacher.msgbuf.generator.ast;

public class PrimitiveType extends Type {

	public enum Kind {

		DOUBLE,

		FLOAT,

		INT32,

		UINT32,

		SINT32,

		FIXED32,

		SFIXED32,

		INT64,

		UINT64,

		SINT64,

		FIXED64,

		SFIXED64,

		BOOL,

		STRING,

		BYTES,

		;

		/** Writes this instance to the given output. */
		public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
			out.value(name());
		}

		/** Reads a new instance from the given reader. */
		public static Kind readKind(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			return valueOf(in.nextString());
		}
	}

	/**
	 * Creates a {@link PrimitiveType} instance.
	 */
	public static PrimitiveType primitiveType() {
		return new PrimitiveType();
	}

	/**
	 * Creates a {@link PrimitiveType} instance.
	 *
	 * @see #primitiveType()
	 */
	protected PrimitiveType() {
		super();
	}

	private Kind _kind;

	public final Kind getKind() {
		return _kind;
	}

	/**
	 * @see #getKind()
	 */
	public final PrimitiveType setKind(Kind value) {
		_kind = value;
		return this;
	}

	/**
	 * Checks, whether {@link #getKind()} has a value.
	 */
	public final boolean hasKind() {
		return _kind != null;
	}

	private static final int[] FIELDS = {0, };

	/** Reads a new instance from the given reader. */
	public static PrimitiveType readPrimitiveType(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		PrimitiveType result = new PrimitiveType();
		result.readContent(in);
		return result;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case "kind": return getKind();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case "kind": setKind((Kind) value); break;
			default: super.set(field, value); break;
		}
	}

	@Override
	protected void writeContent(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeContent(out);
		if (hasKind()) {
			out.name("kind");
			getKind().writeTo(out);
		}
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case "kind": setKind(Kind.readKind(in)); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public <R,A> R visit(Type.Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}

}
