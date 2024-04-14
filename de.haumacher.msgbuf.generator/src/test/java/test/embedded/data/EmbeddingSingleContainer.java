package test.embedded.data;

public interface EmbeddingSingleContainer extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/**
	 * Creates a {@link test.embedded.data.EmbeddingSingleContainer} instance.
	 */
	static test.embedded.data.EmbeddingSingleContainer create() {
		return new test.embedded.data.impl.EmbeddingSingleContainer_Impl();
	}

	/** Identifier for the {@link test.embedded.data.EmbeddingSingleContainer} type in JSON format. */
	String EMBEDDING_SINGLE_CONTAINER__TYPE = "EmbeddingSingleContainer";

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
	test.embedded.data.EmbeddingSingleContainer setName(String value);

	test.embedded.data.Base getContents();

	/**
	 * @see #getContents()
	 */
	test.embedded.data.EmbeddingSingleContainer setContents(test.embedded.data.Base value);

	/**
	 * Checks, whether {@link #getContents()} has a value.
	 */
	boolean hasContents();

	@Override
	public test.embedded.data.EmbeddingSingleContainer registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.embedded.data.EmbeddingSingleContainer unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.embedded.data.EmbeddingSingleContainer readEmbeddingSingleContainer(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.embedded.data.impl.EmbeddingSingleContainer_Impl result = new test.embedded.data.impl.EmbeddingSingleContainer_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.embedded.data.EmbeddingSingleContainer readEmbeddingSingleContainer(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.embedded.data.EmbeddingSingleContainer result = test.embedded.data.impl.EmbeddingSingleContainer_Impl.readEmbeddingSingleContainer_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link EmbeddingSingleContainer} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static EmbeddingSingleContainer readEmbeddingSingleContainer(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.embedded.data.impl.EmbeddingSingleContainer_Impl.readEmbeddingSingleContainer_XmlContent(in);
	}

}
