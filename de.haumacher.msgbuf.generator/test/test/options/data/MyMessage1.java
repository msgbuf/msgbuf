package test.options.data;

public class MyMessage1 extends de.haumacher.msgbuf.data.AbstractDataObject {

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

}
