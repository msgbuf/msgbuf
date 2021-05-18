package test.oneoffield;

public class SampleMessage {

	/**
	 * Creates a {@link SampleMessage} instance.
	 */
	public static SampleMessage sampleMessage() {
		return new SampleMessage();
	}

	/**
	 * Creates a {@link SampleMessage} instance.
	 *
	 * @see #sampleMessage()
	 */
	protected SampleMessage() {
		super();
	}

	/** Reads a new instance from the given reader. */
	public static SampleMessage readSampleMessage(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		SampleMessage result = new SampleMessage();
		result.readContent(in);
		return result;
	}

	/** Writes this instance to the given output. */
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

	/** Retrieves value of the field with the given index. */
	public Object get(String field) {
		switch (field) {
			default: return null;
		}
	}

	/** Sets the value of the field with the given index. */
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
