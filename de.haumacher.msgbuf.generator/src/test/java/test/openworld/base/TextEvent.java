package test.openworld.base;

/**
 * A simple text event.
 */
public interface TextEvent extends test.openworld.base.SSEEvent {

	/**
	 * Creates a {@link test.openworld.base.TextEvent} instance.
	 */
	static test.openworld.base.TextEvent create() {
		return new test.openworld.base.impl.TextEvent_Impl();
	}

	/** Identifier for the {@link test.openworld.base.TextEvent} type in JSON format. */
	String TEXT_EVENT__TYPE = "TextEvent";

	/** @see #getText() */
	String TEXT__PROP = "text";

	/**
	 * The text content.
	 */
	String getText();

	/**
	 * @see #getText()
	 */
	test.openworld.base.TextEvent setText(String value);

	@Override
	test.openworld.base.TextEvent setTimestamp(long value);

	/** Reads a new instance from the given reader. */
	static test.openworld.base.TextEvent readTextEvent(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.openworld.base.impl.TextEvent_Impl result = new test.openworld.base.impl.TextEvent_Impl();
		result.readContent(in);
		return result;
	}

	/** Creates a new {@link TextEvent} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static TextEvent readTextEvent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.openworld.base.impl.TextEvent_Impl.readTextEvent_XmlContent(in);
	}

}
