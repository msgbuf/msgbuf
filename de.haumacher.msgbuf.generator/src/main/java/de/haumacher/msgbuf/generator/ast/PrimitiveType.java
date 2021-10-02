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

	/**
	 * Creates a {@link PrimitiveType} instance.
	 *
	 * @see #create()
	 */
	protected PrimitiveType() {
		super();
	}

	/** @see #getKind() */
	public static final String KIND = "kind";

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
	public String jsonType() {
		return "PrimitiveType";
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

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		if (hasKind()) {
			out.name(KIND);
			getKind().writeTo(out);
		}
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case KIND: setKind(Kind.readKind(in)); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public int typeId() {
		return 2;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		super.writeFields(out);
		if (hasKind()) {
			out.name(1);
			getKind().writeTo(out);
		}
	}

	@Override
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case 1: setKind(Kind.readKind(in)); break;
			default: super.readField(in, field);
		}
	}

	/** Reads a new instance from the given reader. */
	public static PrimitiveType readPrimitiveType(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		PrimitiveType result = new PrimitiveType();
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
