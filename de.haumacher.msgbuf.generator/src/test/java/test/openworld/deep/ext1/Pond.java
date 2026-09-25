package test.openworld.deep.ext1;

/**
 * Holder of values of the intermediate of this file.
 */
public interface Pond extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/**
	 * Creates a {@link test.openworld.deep.ext1.Pond} instance.
	 */
	static test.openworld.deep.ext1.Pond create() {
		return new test.openworld.deep.ext1.impl.Pond_Impl();
	}

	/** Identifier for the {@link test.openworld.deep.ext1.Pond} type in JSON format. */
	String POND__TYPE = "Pond";

	/** @see #getKing() */
	String KING__PROP = "king";

	/** @see #getSchool() */
	String SCHOOL__PROP = "school";

	test.openworld.deep.ext1.Fish getKing();

	/**
	 * @see #getKing()
	 */
	test.openworld.deep.ext1.Pond setKing(test.openworld.deep.ext1.Fish value);

	/**
	 * Checks, whether {@link #getKing()} has a value.
	 */
	boolean hasKing();

	java.util.List<test.openworld.deep.ext1.Fish> getSchool();

	/**
	 * @see #getSchool()
	 */
	test.openworld.deep.ext1.Pond setSchool(java.util.List<? extends test.openworld.deep.ext1.Fish> value);

	/**
	 * Adds a value to the {@link #getSchool()} list.
	 */
	test.openworld.deep.ext1.Pond addSchool(test.openworld.deep.ext1.Fish value);

	/**
	 * Removes a value from the {@link #getSchool()} list.
	 */
	void removeSchool(test.openworld.deep.ext1.Fish value);

	@Override
	public test.openworld.deep.ext1.Pond registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.openworld.deep.ext1.Pond unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.openworld.deep.ext1.Pond readPond(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.openworld.deep.ext1.impl.Pond_Impl result = new test.openworld.deep.ext1.impl.Pond_Impl();
		result.readContent(in);
		return result;
	}

	/** Creates a new {@link Pond} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Pond readPond(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.openworld.deep.ext1.impl.Pond_Impl.readPond_XmlContent(in);
	}

}
