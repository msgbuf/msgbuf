package test.options;

public class MyMessage1 implements de.haumacher.msgbuf.data.DataObject {

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
