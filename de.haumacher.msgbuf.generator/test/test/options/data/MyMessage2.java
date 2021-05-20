package test.options.data;

public class MyMessage2 extends de.haumacher.msgbuf.data.AbstractDataObject {

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
	}

	/**
	 * Creates a {@link MyMessage2} instance.
	 */
	public static MyMessage2 myMessage2() {
		return new MyMessage2();
	}

	/**
	 * Creates a {@link MyMessage2} instance.
	 *
	 * @see #myMessage2()
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

}
