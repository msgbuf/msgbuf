package test.oneoffield.data;

public interface SampleMessage extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable {

	/**
	 * Creates a {@link SampleMessage} instance.
	 */
	static SampleMessage create() {
		return new test.oneoffield.data.SampleMessage_Impl();
	}

	/** Identifier for the {@link SampleMessage} type in JSON format. */
	static final String SAMPLE_MESSAGE__TYPE = "SampleMessage";

	@Override
	public SampleMessage registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public SampleMessage unregisterListener(de.haumacher.msgbuf.observer.Listener l);


	/** Reads a new instance from the given reader. */
	static SampleMessage readSampleMessage(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.oneoffield.data.SampleMessage_Impl result = new test.oneoffield.data.SampleMessage_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static SampleMessage readSampleMessage(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		SampleMessage result = test.oneoffield.data.SampleMessage_Impl.readSampleMessage_Content(in);
		in.endObject();
		return result;
	}

}
