package test.oneoffield.data;

public class SampleMessage extends de.haumacher.msgbuf.data.AbstractDataObject {

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
