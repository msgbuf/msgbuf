package test.embedded.data;

public interface A extends Base {

	/**
	 * Creates a {@link test.embedded.data.A} instance.
	 */
	static test.embedded.data.A create() {
		return new test.embedded.data.impl.A_Impl();
	}

	/** Identifier for the {@link test.embedded.data.A} type in JSON format. */
	String A__TYPE = "A";

	/** Identifier for the {@link test.embedded.data.A} type in binary format. */
	static final int A__TYPE_ID = 1;

	/** Reads a new instance from the given reader. */
	static test.embedded.data.A readA(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.embedded.data.impl.A_Impl result = new test.embedded.data.impl.A_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.embedded.data.A readA(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.embedded.data.A result = test.embedded.data.impl.A_Impl.readA_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link A} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static A readA(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.embedded.data.impl.A_Impl.readA_XmlContent(in);
	}

}
