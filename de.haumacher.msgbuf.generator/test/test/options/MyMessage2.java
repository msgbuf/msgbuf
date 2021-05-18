package test.options;

public class MyMessage2 implements de.haumacher.msgbuf.data.DataObject {

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
		result.readContent(in);
		return result;
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		out.beginObject();
		writeContent(out);
		out.endObject();
	}

	/** Reads all fields of this instance from the given input. */
	protected final void readContent(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		while (in.hasNext()) {
			String field = in.nextName();
			readField(in, field);
		}
	}

	@Override
	public Object get(String field) {
		switch (field) {
			default: return null;
		}
	}

	@Override
	public void set(String field, Object value) {
		// No fields.
	}

	/** Writes all fields of this instance to the given output. */
	protected void writeContent(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		// No fields.
	}

	/** Reads the given field from the given input. */
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			default: in.skipValue();
		}
	}

}
