package test.nested.owcount;

/**
 * A top-level extension of a nested OpenWorld root declared in another file.
 */
public interface CountEvent extends test.nested.owbase.Events.Event {

	/** Extended visitor that can handle {@link CountEvent}. */
	public interface Visitor<R,A,E extends Throwable> extends test.nested.owbase.Events.Event.Visitor<R,A,E> {

		/** Visit case for {@link CountEvent}. */
		R visit(test.nested.owcount.CountEvent self, A arg) throws E;

	}

	/**
	 * Creates a {@link test.nested.owcount.CountEvent} instance.
	 */
	static test.nested.owcount.CountEvent create() {
		return new test.nested.owcount.impl.CountEvent_Impl();
	}

	/** Identifier for the {@link test.nested.owcount.CountEvent} type in JSON format. */
	String COUNT_EVENT__TYPE = "CountEvent";

	/** @see #getCount() */
	String COUNT__PROP = "count";

	int getCount();

	/**
	 * @see #getCount()
	 */
	test.nested.owcount.CountEvent setCount(int value);

	@Override
	test.nested.owcount.CountEvent setTimestamp(long value);

	/** Reads a new instance from the given reader. */
	static test.nested.owcount.CountEvent readCountEvent(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.nested.owcount.impl.CountEvent_Impl result = new test.nested.owcount.impl.CountEvent_Impl();
		result.readContent(in);
		return result;
	}

	/** Creates a new {@link CountEvent} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static CountEvent readCountEvent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.nested.owcount.impl.CountEvent_Impl.readCountEvent_XmlContent(in);
	}

}
