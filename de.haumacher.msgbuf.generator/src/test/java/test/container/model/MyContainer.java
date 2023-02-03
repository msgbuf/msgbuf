package test.container.model;

public interface MyContainer extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/**
	 * Creates a {@link test.container.model.MyContainer} instance.
	 */
	static test.container.model.MyContainer create() {
		return new test.container.model.impl.MyContainer_Impl();
	}

	/** Identifier for the {@link test.container.model.MyContainer} type in JSON format. */
	String MY_CONTAINER__TYPE = "MyContainer";

	/** @see #getName() */
	String NAME__PROP = "name";

	/** @see #getContent1() */
	String CONTENT_1__PROP = "content1";

	/** @see #getContent2() */
	String CONTENT_2__PROP = "content2";

	/** Identifier for the property {@link #getName()} in binary format. */
	static final int NAME__ID = 1;

	/** Identifier for the property {@link #getContent1()} in binary format. */
	static final int CONTENT_1__ID = 2;

	/** Identifier for the property {@link #getContent2()} in binary format. */
	static final int CONTENT_2__ID = 3;

	String getName();

	/**
	 * @see #getName()
	 */
	test.container.model.MyContainer setName(String value);

	test.container.model.MyContent getContent1();

	/**
	 * @see #getContent1()
	 */
	test.container.model.MyContainer setContent1(test.container.model.MyContent value);

	/**
	 * Checks, whether {@link #getContent1()} has a value.
	 */
	boolean hasContent1();

	test.container.model.MyContent getContent2();

	/**
	 * @see #getContent2()
	 */
	test.container.model.MyContainer setContent2(test.container.model.MyContent value);

	/**
	 * Checks, whether {@link #getContent2()} has a value.
	 */
	boolean hasContent2();

	@Override
	public test.container.model.MyContainer registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.container.model.MyContainer unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.container.model.MyContainer readMyContainer(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.container.model.impl.MyContainer_Impl result = new test.container.model.impl.MyContainer_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.container.model.MyContainer readMyContainer(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.container.model.MyContainer result = test.container.model.impl.MyContainer_Impl.readMyContainer_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link MyContainer} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static MyContainer readMyContainer(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.container.model.impl.MyContainer_Impl.readMyContainer_XmlContent(in);
	}

}
