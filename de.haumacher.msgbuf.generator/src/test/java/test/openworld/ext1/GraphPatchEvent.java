package test.openworld.ext1;

/**
 * A graph patch event extending the base SSE protocol.
 */
public interface GraphPatchEvent extends test.openworld.base.SSEEvent {

	/** Extended visitor that can handle {@link GraphPatchEvent}. */
	public interface Visitor<R,A,E extends Throwable> extends test.openworld.base.SSEEvent.Visitor<R,A,E> {

		/** Visit case for {@link GraphPatchEvent}. */
		R visit(test.openworld.ext1.GraphPatchEvent self, A arg) throws E;

	}

	/**
	 * Creates a {@link test.openworld.ext1.GraphPatchEvent} instance.
	 */
	static test.openworld.ext1.GraphPatchEvent create() {
		return new test.openworld.ext1.impl.GraphPatchEvent_Impl();
	}

	/** Identifier for the {@link test.openworld.ext1.GraphPatchEvent} type in JSON format. */
	String GRAPH_PATCH_EVENT__TYPE = "GraphPatchEvent";

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
	test.openworld.ext1.GraphPatchEvent setControlId(String value);

	/**
	 * Patch data.
	 */
	String getPatch();

	/**
	 * @see #getPatch()
	 */
	test.openworld.ext1.GraphPatchEvent setPatch(String value);

	@Override
	test.openworld.ext1.GraphPatchEvent setTimestamp(long value);

	/** Reads a new instance from the given reader. */
	static test.openworld.ext1.GraphPatchEvent readGraphPatchEvent(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.openworld.ext1.impl.GraphPatchEvent_Impl result = new test.openworld.ext1.impl.GraphPatchEvent_Impl();
		result.readContent(in);
		return result;
	}

	/** Creates a new {@link GraphPatchEvent} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static GraphPatchEvent readGraphPatchEvent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.openworld.ext1.impl.GraphPatchEvent_Impl.readGraphPatchEvent_XmlContent(in);
	}

}
