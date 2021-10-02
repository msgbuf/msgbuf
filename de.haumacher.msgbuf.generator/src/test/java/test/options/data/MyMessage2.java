package test.options.data;

public class MyMessage2 extends de.haumacher.msgbuf.data.AbstractReflectiveDataObject implements de.haumacher.msgbuf.binary.BinaryDataObject {

	public enum EnumNotAllowingAlias {

		UNKNOWN,

		STARTED,

		;

		/** Writes this instance to the given output. */
		public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
			out.value(name());
		}

		/** Reads a new instance from the given reader. */
		public static EnumNotAllowingAlias readEnumNotAllowingAlias(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			return valueOf(in.nextString());
		}

		/** Writes this instance to the given binary output. */
		public final void writeTo(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
			switch (this) {
				case UNKNOWN: out.value(2); break;
				case STARTED: out.value(1); break;
				default: out.value(0);
			}
		}

		/** Reads a new instance from the given binary reader. */
		public static EnumNotAllowingAlias readEnumNotAllowingAlias(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			switch (in.nextInt()) {
				case 2: return UNKNOWN;
				case 1: return STARTED;
				default: return UNKNOWN;
			}
		}
	}

	/**
	 * Creates a {@link MyMessage2} instance.
	 */
	public static MyMessage2 create() {
		return new MyMessage2();
	}

	/**
	 * Creates a {@link MyMessage2} instance.
	 *
	 * @see #create()
	 */
	protected MyMessage2() {
		super();
	}

	/** Reads a new instance from the given reader. */
	public static MyMessage2 readMyMessage2(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		MyMessage2 result = new MyMessage2();
		in.beginObject();
		result.readFields(in);
		in.endObject();
		return result;
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		out.beginObject();
		writeFields(out);
		out.endObject();
	}

	/**
	 * Serializes all fields of this instance to the given binary output.
	 *
	 * @param out
	 *        The binary output to write to.
	 * @throws java.io.IOException If writing fails.
	 */
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		// No fields to write, hook for subclasses.
	}

	/** Consumes the value for the field with the given ID and assigns its value. */
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			default: in.skipValue(); 
		}
	}

	/** Reads a new instance from the given reader. */
	public static MyMessage2 readMyMessage2(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		MyMessage2 result = new MyMessage2();
		while (in.hasNext()) {
			int field = in.nextName();
			result.readField(in, field);
		}
		in.endObject();
		return result;
	}

}
