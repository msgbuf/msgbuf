package test.maptype.data;

public interface MyMessage extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/**
	 * Creates a {@link MyMessage} instance.
	 */
	static MyMessage create() {
		return new test.maptype.data.MyMessage_Impl();
	}

	/** Identifier for the {@link MyMessage} type in JSON format. */
	static final String MY_MESSAGE__TYPE = "MyMessage";

	/** @see #getProjects() */
	static final String PROJECTS__PROP = "projects";

	/** @see #getRating() */
	static final String RATING__PROP = "rating";

	/** Identifier for the property {@link #getProjects()} in binary format. */
	static final int PROJECTS__ID = 3;

	/** Identifier for the property {@link #getRating()} in binary format. */
	static final int RATING__ID = 4;

	java.util.Map<String, Project> getProjects();

	/**
	 * @see #getProjects()
	 */
	MyMessage setProjects(java.util.Map<String, Project> value);

	/**
	 * Adds a key value pair to the {@link #getProjects()} map.
	 */
	MyMessage putProject(String key, Project value);

	/**
	 * Removes a key from the {@link #getProjects()} map.
	 */
	void removeProject(String key);

	java.util.Map<Integer, String> getRating();

	/**
	 * @see #getRating()
	 */
	MyMessage setRating(java.util.Map<Integer, String> value);

	/**
	 * Adds a key value pair to the {@link #getRating()} map.
	 */
	MyMessage putRating(int key, String value);

	/**
	 * Removes a key from the {@link #getRating()} map.
	 */
	void removeRating(int key);

	@Override
	public MyMessage registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public MyMessage unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static MyMessage readMyMessage(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.maptype.data.MyMessage_Impl result = new test.maptype.data.MyMessage_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static MyMessage readMyMessage(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		MyMessage result = test.maptype.data.MyMessage_Impl.readMyMessage_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link MyMessage} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static MyMessage readMyMessage(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.maptype.data.MyMessage_Impl.readMyMessage_XmlContent(in);
	}

}
