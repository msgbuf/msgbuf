package test.jsonvalue.data;

/**
 * A message carrying an opaque JSON payload.
 */
public interface PatchEvent extends de.haumacher.msgbuf.data.DataObject {

	/**
	 * Creates a {@link test.jsonvalue.data.PatchEvent} instance.
	 */
	static test.jsonvalue.data.PatchEvent create() {
		return new test.jsonvalue.data.impl.PatchEvent_Impl();
	}

	/** Identifier for the {@link test.jsonvalue.data.PatchEvent} type in JSON format. */
	String PATCH_EVENT__TYPE = "PatchEvent";

	/** @see #getControlId() */
	String CONTROL_ID__PROP = "controlId";

	/** @see #getPatch() */
	String PATCH__PROP = "patch";

	/**
	 * ID of the control being patched.
	 */
	String getControlId();

	/**
	 * @see #getControlId()
	 */
	test.jsonvalue.data.PatchEvent setControlId(String value);

	/**
	 * The patch data as a native JSON value.
	 */
	Object getPatch();

	/**
	 * @see #getPatch()
	 */
	test.jsonvalue.data.PatchEvent setPatch(Object value);

	/**
	 * Checks, whether {@link #getPatch()} has a value.
	 */
	boolean hasPatch();

	/** Reads a new instance from the given reader. */
	static test.jsonvalue.data.PatchEvent readPatchEvent(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.jsonvalue.data.impl.PatchEvent_Impl result = new test.jsonvalue.data.impl.PatchEvent_Impl();
		result.readContent(in);
		return result;
	}

}
