package test.maptype.data;

public interface Project extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable {

	/**
	 * Creates a {@link Project} instance.
	 */
	static Project create() {
		return new test.maptype.data.Project_Impl();
	}

	/** Identifier for the {@link Project} type in JSON format. */
	static final String PROJECT__TYPE = "Project";

	/** @see #getName() */
	static final String NAME = "name";

	/** @see #getCost() */
	static final String COST = "cost";

	/** Identifier for the property {@link #getName()} in binary format. */
	static final int NAME__ID = 1;

	/** Identifier for the property {@link #getCost()} in binary format. */
	static final int COST__ID = 2;

	String getName();

	/**
	 * @see #getName()
	 */
	Project setName(String value);

	double getCost();

	/**
	 * @see #getCost()
	 */
	Project setCost(double value);

	@Override
	public Project registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public Project unregisterListener(de.haumacher.msgbuf.observer.Listener l);


	/** Reads a new instance from the given reader. */
	static Project readProject(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.maptype.data.Project_Impl result = new test.maptype.data.Project_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static Project readProject(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		Project result = test.maptype.data.Project_Impl.readProject_Content(in);
		in.endObject();
		return result;
	}

}
