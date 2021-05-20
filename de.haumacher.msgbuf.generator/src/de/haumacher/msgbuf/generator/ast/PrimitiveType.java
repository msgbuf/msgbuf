package de.haumacher.msgbuf.generator.ast;

/**
 * A primitive built-in {@link Type}.
 */
public class PrimitiveType extends Type {

	/**
	 * Supported built-in types.
	 */
	public enum Kind {

		/**
		 * A 32 bit integer.
		 */
		INT32,

		UINT32,

		SINT32,

		FIXED32,

		SFIXED32,

		/**
		 * A 64 bit integer.
		 */
		INT64,

		UINT64,

		SINT64,

		FIXED64,

		SFIXED64,

		/**
		 * A boolean.
		 */
		BOOL,

		/**
		 * A string of characters.
		 */
		STRING,

		/**
		 * A 32 bit floating point number.
		 */
		FLOAT,

		/**
		 * A 64 bit floating point number.
		 */
		DOUBLE,

		/**
		 * A string of octets.
		 */
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

	private Kind _kind = Kind.INT32;

	/**
	 * The type kind.
	 */
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

	/** Reads a new instance from the given reader. */
	public static PrimitiveType readPrimitiveType(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		PrimitiveType result = new PrimitiveType();
		in.beginObject();
		result.readFields(in);
		in.endObject();
		return result;
	}

	@Override
	protected String jsonType() {
		return "PrimitiveType";
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
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
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
