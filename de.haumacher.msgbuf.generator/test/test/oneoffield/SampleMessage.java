package test.oneoffield;

public class SampleMessage implements de.haumacher.msgbuf.data.DataObject {

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
		result.readFields(in);
		return result;
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	/**
	 * Writes a JSON object containing keys for all fields of this object.
	 *
	 * @param out The writer to write to.
	 */
	protected final void writeContent(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		out.beginObject();
		writeFields(out);
		out.endObject();
	}

	/**
	 * Reads all fields of this instance from the given input.
	 *
	 * @param in The reader to take the input from.
	 */
	protected final void readFields(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
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
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		// No fields.
	}

	/** Reads the given field from the given input. */
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			default: in.skipValue();
		}
	}

}
