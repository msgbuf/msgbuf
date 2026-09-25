package test.openworld.deep.base;

/**
 * Local leaf of a sibling subtree.
 */
public interface Dog extends test.openworld.deep.base.Animal {

	/**
	 * Creates a {@link test.openworld.deep.base.Dog} instance.
	 */
	static test.openworld.deep.base.Dog create() {
		return new test.openworld.deep.base.impl.Dog_Impl();
	}

	/** Identifier for the {@link test.openworld.deep.base.Dog} type in JSON format. */
	String DOG__TYPE = "Dog";

	/** @see #isGood() */
	String GOOD__PROP = "good";

	boolean isGood();

	/**
	 * @see #isGood()
	 */
	test.openworld.deep.base.Dog setGood(boolean value);

	@Override
	test.openworld.deep.base.Dog setName(String value);

	/** Reads a new instance from the given reader. */
	static test.openworld.deep.base.Dog readDog(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.openworld.deep.base.impl.Dog_Impl result = new test.openworld.deep.base.impl.Dog_Impl();
		result.readContent(in);
		return result;
	}

	/** Creates a new {@link Dog} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Dog readDog(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.openworld.deep.base.impl.Dog_Impl.readDog_XmlContent(in);
	}

}
