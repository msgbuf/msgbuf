package test.options.data;

public class MyMessage1 extends de.haumacher.msgbuf.data.AbstractDataObject implements de.haumacher.msgbuf.binary.BinaryDataObject {

	public enum EnumAllowingAlias {

		UNKNOWN,

		STARTED,

		RUNNING,

		;

		/** Writes this instance to the given output. */
		public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
			out.value(name());
		}

		/** Reads a new instance from the given reader. */
		public static EnumAllowingAlias readEnumAllowingAlias(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			return valueOf(in.nextString());
		}

		/** Writes this instance to the given binary output. */
		public final void writeTo(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
			switch (this) {
				case UNKNOWN: out.value(0); break;
				case STARTED: out.value(1); break;
				case RUNNING: out.value(1); break;
				default: out.value(0);
			}
		}

		/** Reads a new instance from the given binary reader. */
		public static EnumAllowingAlias readEnumAllowingAlias(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			switch (in.nextInt()) {
				case 0: return UNKNOWN;
				case 1: return STARTED;
				default: return UNKNOWN;
			}
		}
	}

	/**
	 * Creates a {@link MyMessage1} instance.
	 */
	public static MyMessage1 myMessage1() {
		return new MyMessage1();
	}

	/**
	 * Creates a {@link MyMessage1} instance.
	 *
	 * @see #myMessage1()
	 */
	protected MyMessage1() {
		super();
	}

	/** Reads a new instance from the given reader. */
	public static MyMessage1 readMyMessage1(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		MyMessage1 result = new MyMessage1();
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

	/** Serializes all fields of this instance to the given binary output. */
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
	}

	/** Reads a new instance from the given reader. */
	public static MyMessage1 readMyMessage1(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		MyMessage1 result = new MyMessage1();
		while (in.hasNext()) {
			int field = in.nextName();
			result.readField(in, field);
		}
		in.endObject();
		return result;
	}

	/** Consumes the value for the field with the given ID and assigns its value. */
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			default: in.skipValue(); 
		}
	}

}
