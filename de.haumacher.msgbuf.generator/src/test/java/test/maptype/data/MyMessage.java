package test.maptype.data;

public interface MyMessage extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/**
	 * Creates a {@link test.maptype.data.MyMessage} instance.
	 */
	static test.maptype.data.MyMessage create() {
		return new test.maptype.data.impl.MyMessage_Impl();
	}

	/** Identifier for the {@link test.maptype.data.MyMessage} type in JSON format. */
	String MY_MESSAGE__TYPE = "MyMessage";

	/** @see #getProjects() */
	String PROJECTS__PROP = "projects";

	/** @see #getRating() */
	String RATING__PROP = "rating";

	/** Identifier for the property {@link #getProjects()} in binary format. */
	static final int PROJECTS__ID = 3;

	/** Identifier for the property {@link #getRating()} in binary format. */
	static final int RATING__ID = 4;

	java.util.Map<String, test.maptype.data.Project> getProjects();

	/**
	 * @see #getProjects()
	 */
	test.maptype.data.MyMessage setProjects(java.util.Map<String, test.maptype.data.Project> value);

	/**
	 * Adds a key value pair to the {@link #getProjects()} map.
	 */
	test.maptype.data.MyMessage putProject(String key, test.maptype.data.Project value);

	/**
	 * Removes a key from the {@link #getProjects()} map.
	 */
	void removeProject(String key);

	java.util.Map<Integer, String> getRating();

	/**
	 * @see #getRating()
	 */
	test.maptype.data.MyMessage setRating(java.util.Map<Integer, String> value);

	/**
	 * Adds a key value pair to the {@link #getRating()} map.
	 */
	test.maptype.data.MyMessage putRating(int key, String value);

	/**
	 * Removes a key from the {@link #getRating()} map.
	 */
	void removeRating(int key);

	@Override
	public test.maptype.data.MyMessage registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.maptype.data.MyMessage unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.maptype.data.MyMessage readMyMessage(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.maptype.data.impl.MyMessage_Impl result = new test.maptype.data.impl.MyMessage_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.maptype.data.MyMessage readMyMessage(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.maptype.data.MyMessage result = test.maptype.data.impl.MyMessage_Impl.readMyMessage_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link MyMessage} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static MyMessage readMyMessage(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.maptype.data.impl.MyMessage_Impl.readMyMessage_XmlContent(in);
	}

}
