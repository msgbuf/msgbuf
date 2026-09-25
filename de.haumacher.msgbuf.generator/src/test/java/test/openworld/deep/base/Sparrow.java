package test.openworld.deep.base;

/**
 * Local leaf below the intermediate.
 */
public interface Sparrow extends test.openworld.deep.base.Bird {

	/**
	 * Creates a {@link test.openworld.deep.base.Sparrow} instance.
	 */
	static test.openworld.deep.base.Sparrow create() {
		return new test.openworld.deep.base.impl.Sparrow_Impl();
	}

	/** Identifier for the {@link test.openworld.deep.base.Sparrow} type in JSON format. */
	String SPARROW__TYPE = "Sparrow";

	/** @see #getFlock() */
	String FLOCK__PROP = "flock";

	int getFlock();

	/**
	 * @see #getFlock()
	 */
	test.openworld.deep.base.Sparrow setFlock(int value);

	@Override
	test.openworld.deep.base.Sparrow setWingspan(double value);

	@Override
	test.openworld.deep.base.Sparrow setName(String value);

	/** Reads a new instance from the given reader. */
	static test.openworld.deep.base.Sparrow readSparrow(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.openworld.deep.base.impl.Sparrow_Impl result = new test.openworld.deep.base.impl.Sparrow_Impl();
		result.readContent(in);
		return result;
	}

	/** Creates a new {@link Sparrow} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Sparrow readSparrow(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.openworld.deep.base.impl.Sparrow_Impl.readSparrow_XmlContent(in);
	}

}
