package test.embedded.data;

public interface B extends Base {

	/**
	 * Creates a {@link test.embedded.data.B} instance.
	 */
	static test.embedded.data.B create() {
		return new test.embedded.data.impl.B_Impl();
	}

	/** Identifier for the {@link test.embedded.data.B} type in JSON format. */
	String B__TYPE = "B";

	/** Identifier for the {@link test.embedded.data.B} type in binary format. */
	static final int B__TYPE_ID = 2;

	/** Reads a new instance from the given reader. */
	static test.embedded.data.B readB(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.embedded.data.impl.B_Impl result = new test.embedded.data.impl.B_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.embedded.data.B readB(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.embedded.data.B result = test.embedded.data.impl.B_Impl.readB_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link B} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static B readB(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.embedded.data.impl.B_Impl.readB_XmlContent(in);
	}

}
