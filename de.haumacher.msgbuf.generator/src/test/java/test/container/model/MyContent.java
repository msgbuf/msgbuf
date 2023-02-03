package test.container.model;

public interface MyContent extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/**
	 * Creates a {@link test.container.model.MyContent} instance.
	 */
	static test.container.model.MyContent create() {
		return new test.container.model.impl.MyContent_Impl();
	}

	/** Identifier for the {@link test.container.model.MyContent} type in JSON format. */
	String MY_CONTENT__TYPE = "MyContent";

	/** @see #getContainer() */
	String CONTAINER__PROP = "container";

	/** @see #getName() */
	String NAME__PROP = "name";

	/** Identifier for the property {@link #getName()} in binary format. */
	static final int NAME__ID = 2;

	test.container.model.MyContainer getContainer();

	/**
	 * Checks, whether {@link #getContainer()} has a value.
	 */
	boolean hasContainer();

	String getName();

	/**
	 * @see #getName()
	 */
	test.container.model.MyContent setName(String value);

	@Override
	public test.container.model.MyContent registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.container.model.MyContent unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.container.model.MyContent readMyContent(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.container.model.impl.MyContent_Impl result = new test.container.model.impl.MyContent_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.container.model.MyContent readMyContent(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.container.model.MyContent result = test.container.model.impl.MyContent_Impl.readMyContent_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link MyContent} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static MyContent readMyContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.container.model.impl.MyContent_Impl.readMyContent_XmlContent(in);
	}

}
