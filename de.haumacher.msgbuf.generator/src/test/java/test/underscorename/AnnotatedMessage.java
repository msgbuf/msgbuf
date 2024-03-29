package test.underscorename;

public interface AnnotatedMessage extends BaseMsg {

	/**
	 * Creates a {@link test.underscorename.AnnotatedMessage} instance.
	 */
	static test.underscorename.AnnotatedMessage create() {
		return new test.underscorename.impl.AnnotatedMessage_Impl();
	}

	/** Identifier for the {@link test.underscorename.AnnotatedMessage} type in JSON format. */
	String ANNOTATED_MESSAGE__TYPE = "m1";

	/** @see #getAnnotatedField() */
	String ANNOTATED_FIELD__PROP = "f1";

	/** Identifier for the {@link test.underscorename.AnnotatedMessage} type in binary format. */
	static final int ANNOTATED_MESSAGE__TYPE_ID = 2;

	/** Identifier for the property {@link #getAnnotatedField()} in binary format. */
	static final int ANNOTATED_FIELD__ID = 1;

	String getAnnotatedField();

	/**
	 * @see #getAnnotatedField()
	 */
	test.underscorename.AnnotatedMessage setAnnotatedField(String value);

	/** Reads a new instance from the given reader. */
	static test.underscorename.AnnotatedMessage readannotated_message(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.underscorename.impl.AnnotatedMessage_Impl result = new test.underscorename.impl.AnnotatedMessage_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.underscorename.AnnotatedMessage readannotated_message(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.underscorename.AnnotatedMessage result = test.underscorename.impl.AnnotatedMessage_Impl.readannotated_message_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link AnnotatedMessage} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static AnnotatedMessage readAnnotated_message(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.underscorename.impl.AnnotatedMessage_Impl.readAnnotated_message_XmlContent(in);
	}

}
