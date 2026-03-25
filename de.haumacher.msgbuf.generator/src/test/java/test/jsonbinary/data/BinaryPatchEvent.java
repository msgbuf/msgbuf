package test.jsonbinary.data;

/**
 * A message with json fields, supporting both JSON and Binary serialization.
 */
public interface BinaryPatchEvent extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject {

	/**
	 * Creates a {@link test.jsonbinary.data.BinaryPatchEvent} instance.
	 */
	static test.jsonbinary.data.BinaryPatchEvent create() {
		return new test.jsonbinary.data.impl.BinaryPatchEvent_Impl();
	}

	/** Identifier for the {@link test.jsonbinary.data.BinaryPatchEvent} type in JSON format. */
	String BINARY_PATCH_EVENT__TYPE = "BinaryPatchEvent";

	/** @see #getControlId() */
	String CONTROL_ID__PROP = "controlId";

	/** @see #getPatch() */
	String PATCH__PROP = "patch";

	/** Identifier for the property {@link #getControlId()} in binary format. */
	static final int CONTROL_ID__ID = 1;

	/** Identifier for the property {@link #getPatch()} in binary format. */
	static final int PATCH__ID = 2;

	String getControlId();

	/**
	 * @see #getControlId()
	 */
	test.jsonbinary.data.BinaryPatchEvent setControlId(String value);

	/**
	 * The patch data as a native JSON value.
	 */
	Object getPatch();

	/**
	 * @see #getPatch()
	 */
	test.jsonbinary.data.BinaryPatchEvent setPatch(Object value);

	/**
	 * Checks, whether {@link #getPatch()} has a value.
	 */
	boolean hasPatch();

	/** Reads a new instance from the given reader. */
	static test.jsonbinary.data.BinaryPatchEvent readBinaryPatchEvent(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.jsonbinary.data.impl.BinaryPatchEvent_Impl result = new test.jsonbinary.data.impl.BinaryPatchEvent_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.jsonbinary.data.BinaryPatchEvent readBinaryPatchEvent(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.jsonbinary.data.BinaryPatchEvent result = test.jsonbinary.data.impl.BinaryPatchEvent_Impl.readBinaryPatchEvent_Content(in);
		in.endObject();
		return result;
	}

}
