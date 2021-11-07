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

		/** Writes this instance to the given binary output. */
		public final void writeTo(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
			switch (this) {
				case INT32: out.value(1); break;
				case UINT32: out.value(2); break;
				case SINT32: out.value(3); break;
				case FIXED32: out.value(4); break;
				case SFIXED32: out.value(5); break;
				case INT64: out.value(6); break;
				case UINT64: out.value(7); break;
				case SINT64: out.value(8); break;
				case FIXED64: out.value(9); break;
				case SFIXED64: out.value(10); break;
				case BOOL: out.value(11); break;
				case STRING: out.value(12); break;
				case FLOAT: out.value(13); break;
				case DOUBLE: out.value(14); break;
				case BYTES: out.value(15); break;
				default: out.value(0);
			}
		}

		/** Reads a new instance from the given binary reader. */
		public static Kind readKind(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			switch (in.nextInt()) {
				case 1: return INT32;
				case 2: return UINT32;
				case 3: return SINT32;
				case 4: return FIXED32;
				case 5: return SFIXED32;
				case 6: return INT64;
				case 7: return UINT64;
				case 8: return SINT64;
				case 9: return FIXED64;
				case 10: return SFIXED64;
				case 11: return BOOL;
				case 12: return STRING;
				case 13: return FLOAT;
				case 14: return DOUBLE;
				case 15: return BYTES;
				default: return INT32;
			}
		}
	}

	/**
	 * Creates a {@link PrimitiveType} instance.
	 */
	public static PrimitiveType create() {
		return new PrimitiveType();
	}

	/** Identifier for the {@link PrimitiveType} type in JSON format. */
	public static final String PRIMITIVE_TYPE__TYPE = "PrimitiveType";

	/** @see #getKind() */
	private static final String KIND = "kind";

	private Kind _kind = Kind.INT32;

	/**
	 * Creates a {@link PrimitiveType} instance.
	 *
	 * @see #create()
	 */
	protected PrimitiveType() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.PRIMITIVE_TYPE;
	}

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
		if (value == null) throw new IllegalArgumentException("Property 'kind' cannot be null.");
		_kind = value;
		return this;
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
	public String jsonType() {
		return PRIMITIVE_TYPE__TYPE;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(KIND);
		getKind().writeTo(out);
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case KIND: setKind(de.haumacher.msgbuf.generator.ast.PrimitiveType.Kind.readKind(in)); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public <R,A> R visit(Type.Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}

}
