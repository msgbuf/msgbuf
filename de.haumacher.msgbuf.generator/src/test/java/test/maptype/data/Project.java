package test.maptype.data;

public interface Project extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/**
	 * Creates a {@link test.maptype.data.Project} instance.
	 */
	static test.maptype.data.Project create() {
		return new test.maptype.data.impl.Project_Impl();
	}

	/** Identifier for the {@link test.maptype.data.Project} type in JSON format. */
	String PROJECT__TYPE = "Project";

	/** @see #getName() */
	String NAME__PROP = "name";

	/** @see #getCost() */
	String COST__PROP = "cost";

	/** Identifier for the property {@link #getName()} in binary format. */
	static final int NAME__ID = 1;

	/** Identifier for the property {@link #getCost()} in binary format. */
	static final int COST__ID = 2;

	String getName();

	/**
	 * @see #getName()
	 */
	test.maptype.data.Project setName(String value);

	double getCost();

	/**
	 * @see #getCost()
	 */
	test.maptype.data.Project setCost(double value);

	@Override
	public test.maptype.data.Project registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.maptype.data.Project unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.maptype.data.Project readProject(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.maptype.data.impl.Project_Impl result = new test.maptype.data.impl.Project_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.maptype.data.Project readProject(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.maptype.data.Project result = test.maptype.data.impl.Project_Impl.readProject_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link Project} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Project readProject(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.maptype.data.impl.Project_Impl.readProject_XmlContent(in);
	}

}
