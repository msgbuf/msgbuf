package test.embedded.data;

public interface Container extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/**
	 * Creates a {@link test.embedded.data.Container} instance.
	 */
	static test.embedded.data.Container create() {
		return new test.embedded.data.impl.Container_Impl();
	}

	/** Identifier for the {@link test.embedded.data.Container} type in JSON format. */
	String CONTAINER__TYPE = "Container";

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
	test.embedded.data.Container setName(String value);

	java.util.List<test.embedded.data.Base> getContents();

	/**
	 * @see #getContents()
	 */
	test.embedded.data.Container setContents(java.util.List<? extends test.embedded.data.Base> value);

	/**
	 * Adds a value to the {@link #getContents()} list.
	 */
	test.embedded.data.Container addContent(test.embedded.data.Base value);

	/**
	 * Removes a value from the {@link #getContents()} list.
	 */
	void removeContent(test.embedded.data.Base value);

	@Override
	public test.embedded.data.Container registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.embedded.data.Container unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.embedded.data.Container readContainer(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.embedded.data.impl.Container_Impl result = new test.embedded.data.impl.Container_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.embedded.data.Container readContainer(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.embedded.data.Container result = test.embedded.data.impl.Container_Impl.readContainer_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link Container} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Container readContainer(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.embedded.data.impl.Container_Impl.readContainer_XmlContent(in);
	}

}
