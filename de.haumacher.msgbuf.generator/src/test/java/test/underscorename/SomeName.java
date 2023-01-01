package test.underscorename;

public interface SomeName extends BaseMsg {

	/**
	 * Creates a {@link test.underscorename.SomeName} instance.
	 */
	static test.underscorename.SomeName create() {
		return new test.underscorename.impl.SomeName_Impl();
	}

	/** Identifier for the {@link test.underscorename.SomeName} type in JSON format. */
	static final String SOME_NAME__TYPE = "some_name";

	/** @see #getMyField() */
	static final String MY_FIELD__PROP = "my_field";

	/** Identifier for the {@link test.underscorename.SomeName} type in binary format. */
	static final int SOME_NAME__TYPE_ID = 1;

	/** Identifier for the property {@link #getMyField()} in binary format. */
	static final int MY_FIELD__ID = 1;

	String getMyField();

	/**
	 * @see #getMyField()
	 */
	test.underscorename.SomeName setMyField(String value);

	/** Reads a new instance from the given reader. */
	static test.underscorename.SomeName readsome_name(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.underscorename.impl.SomeName_Impl result = new test.underscorename.impl.SomeName_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.underscorename.SomeName readsome_name(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.underscorename.SomeName result = test.underscorename.impl.SomeName_Impl.readsome_name_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link SomeName} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static SomeName readSome_name(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.underscorename.impl.SomeName_Impl.readSome_name_XmlContent(in);
	}

}
