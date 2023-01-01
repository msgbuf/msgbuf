package test.oneoffield.data;

public interface SampleMessage extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/**
	 * Creates a {@link test.oneoffield.data.SampleMessage} instance.
	 */
	static test.oneoffield.data.SampleMessage create() {
		return new test.oneoffield.data.impl.SampleMessage_Impl();
	}

	/** Identifier for the {@link test.oneoffield.data.SampleMessage} type in JSON format. */
	static final String SAMPLE_MESSAGE__TYPE = "SampleMessage";

	@Override
	public test.oneoffield.data.SampleMessage registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.oneoffield.data.SampleMessage unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.oneoffield.data.SampleMessage readSampleMessage(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.oneoffield.data.impl.SampleMessage_Impl result = new test.oneoffield.data.impl.SampleMessage_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.oneoffield.data.SampleMessage readSampleMessage(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.oneoffield.data.SampleMessage result = test.oneoffield.data.impl.SampleMessage_Impl.readSampleMessage_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link SampleMessage} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static SampleMessage readSampleMessage(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.oneoffield.data.impl.SampleMessage_Impl.readSampleMessage_XmlContent(in);
	}

}
