package test.underscorename;

public interface AnnotatedMessage extends BaseMsg {

	/**
	 * Creates a {@link AnnotatedMessage} instance.
	 */
	static AnnotatedMessage create() {
		return new test.underscorename.AnnotatedMessage_Impl();
	}

	/** Identifier for the {@link AnnotatedMessage} type in JSON format. */
	static final String ANNOTATED_MESSAGE__TYPE = "m1";

	/** @see #getAnnotatedField() */
	static final String ANNOTATED_FIELD = "f1";

	/** Identifier for the {@link AnnotatedMessage} type in binary format. */
	static final int ANNOTATED_MESSAGE__TYPE_ID = 2;

	/** Identifier for the property {@link #getAnnotatedField()} in binary format. */
	static final int ANNOTATED_FIELD__ID = 1;

	String getAnnotatedField();

	/**
	 * @see #getAnnotatedField()
	 */
	AnnotatedMessage setAnnotatedField(String value);


	/** Reads a new instance from the given reader. */
	static AnnotatedMessage readannotated_message(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.underscorename.AnnotatedMessage_Impl result = new test.underscorename.AnnotatedMessage_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static AnnotatedMessage readannotated_message(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		AnnotatedMessage result = test.underscorename.AnnotatedMessage_Impl.readannotated_message_Content(in);
		in.endObject();
		return result;
	}

}
