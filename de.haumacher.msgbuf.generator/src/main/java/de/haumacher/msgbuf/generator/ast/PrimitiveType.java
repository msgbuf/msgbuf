package de.haumacher.msgbuf.generator.ast;

/**
 * A primitive built-in {@link Type}.
 */
public class PrimitiveType extends Type {

	/**
	 * Supported built-in types.
	 */
	public enum Kind implements de.haumacher.msgbuf.data.ProtocolEnum {

		/**
		 * A 32 bit integer.
		 */
		INT_32("INT32"),

		UINT_32("UINT32"),

		SINT_32("SINT32"),

		FIXED_32("FIXED32"),

		SFIXED_32("SFIXED32"),

		/**
		 * A 64 bit integer.
		 */
		INT_64("INT64"),

		UINT_64("UINT64"),

		SINT_64("SINT64"),

		FIXED_64("FIXED64"),

		SFIXED_64("SFIXED64"),

		/**
		 * A boolean.
		 */
		BOOL("BOOL"),

		/**
		 * A string of characters.
		 */
		STRING("STRING"),

		/**
		 * A 32 bit floating point number.
		 */
		FLOAT("FLOAT"),

		/**
		 * A 64 bit floating point number.
		 */
		DOUBLE("DOUBLE"),

		/**
		 * A string of octets.
		 */
		BYTES("BYTES"),

		;

		private final String _protocolName;

		private Kind(String protocolName) {
			_protocolName = protocolName;
		}

		/**
		 * The protocol name of a {@link Kind} constant.
		 *
		 * @see #valueOfProtocol(String)
		 */
		@Override
		public String protocolName() {
			return _protocolName;
		}

		/** Looks up a {@link Kind} constant by it's protocol name. */
		public static Kind valueOfProtocol(String protocolName) {
			if (protocolName == null) { return null; }
			switch (protocolName) {
				case "INT32": return INT_32;
				case "UINT32": return UINT_32;
				case "SINT32": return SINT_32;
				case "FIXED32": return FIXED_32;
				case "SFIXED32": return SFIXED_32;
				case "INT64": return INT_64;
				case "UINT64": return UINT_64;
				case "SINT64": return SINT_64;
				case "FIXED64": return FIXED_64;
				case "SFIXED64": return SFIXED_64;
				case "BOOL": return BOOL;
				case "STRING": return STRING;
				case "FLOAT": return FLOAT;
				case "DOUBLE": return DOUBLE;
				case "BYTES": return BYTES;
			}
			return INT_32;
		}

		/** Writes this instance to the given output. */
		public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
			out.value(protocolName());
		}

		/** Reads a new instance from the given reader. */
		public static Kind readKind(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			return valueOfProtocol(in.nextString());
		}

		/** Writes this instance to the given binary output. */
		public final void writeTo(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
			switch (this) {
				case INT_32: out.value(1); break;
				case UINT_32: out.value(2); break;
				case SINT_32: out.value(3); break;
				case FIXED_32: out.value(4); break;
				case SFIXED_32: out.value(5); break;
				case INT_64: out.value(6); break;
				case UINT_64: out.value(7); break;
				case SINT_64: out.value(8); break;
				case FIXED_64: out.value(9); break;
				case SFIXED_64: out.value(10); break;
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
				case 1: return INT_32;
				case 2: return UINT_32;
				case 3: return SINT_32;
				case 4: return FIXED_32;
				case 5: return SFIXED_32;
				case 6: return INT_64;
				case 7: return UINT_64;
				case 8: return SINT_64;
				case 9: return FIXED_64;
				case 10: return SFIXED_64;
				case 11: return BOOL;
				case 12: return STRING;
				case 13: return FLOAT;
				case 14: return DOUBLE;
				case 15: return BYTES;
				default: return INT_32;
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
	public static final String KIND = "kind";

	private Kind _kind = de.haumacher.msgbuf.generator.ast.PrimitiveType.Kind.INT_32;

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
		_listener.beforeSet(this, KIND, value);
		_kind = value;
		return this;
	}

	@Override
	public String jsonType() {
		return PRIMITIVE_TYPE__TYPE;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			KIND));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case KIND: return getKind();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case KIND: setKind((Kind) value); break;
			default: super.set(field, value); break;
		}
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
