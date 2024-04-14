package test.embedded.data;

public interface SingleContainer extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/**
	 * Creates a {@link test.embedded.data.SingleContainer} instance.
	 */
	static test.embedded.data.SingleContainer create() {
		return new test.embedded.data.impl.SingleContainer_Impl();
	}

	/** Identifier for the {@link test.embedded.data.SingleContainer} type in JSON format. */
	String SINGLE_CONTAINER__TYPE = "SingleContainer";

	/** @see #getName() */
	String NAME__PROP = "name";

	/** @see #getContents() */
	String CONTENTS__PROP = "contents";

	/** Identifier for the property {@link #getName()} in binary format. */
	static final int NAME__ID = 1;

	/** Identifier for the property {@link #getContents()} in binary format. */
	static final int CONTENTS__ID = 2;

	String getName();

	/**
	 * @see #getName()
	 */
	test.embedded.data.SingleContainer setName(String value);

	test.embedded.data.Base getContents();

	/**
	 * @see #getContents()
	 */
	test.embedded.data.SingleContainer setContents(test.embedded.data.Base value);

	/**
	 * Checks, whether {@link #getContents()} has a value.
	 */
	boolean hasContents();

	@Override
	public test.embedded.data.SingleContainer registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.embedded.data.SingleContainer unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.embedded.data.SingleContainer readSingleContainer(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.embedded.data.impl.SingleContainer_Impl result = new test.embedded.data.impl.SingleContainer_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.embedded.data.SingleContainer readSingleContainer(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.embedded.data.SingleContainer result = test.embedded.data.impl.SingleContainer_Impl.readSingleContainer_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link SingleContainer} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static SingleContainer readSingleContainer(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.embedded.data.impl.SingleContainer_Impl.readSingleContainer_XmlContent(in);
	}

}
