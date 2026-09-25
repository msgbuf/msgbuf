package test.openworld.deep.ext2;

public interface Eagle extends test.openworld.deep.ext2.Raptor {

	/**
	 * Creates a {@link test.openworld.deep.ext2.Eagle} instance.
	 */
	static test.openworld.deep.ext2.Eagle create() {
		return new test.openworld.deep.ext2.impl.Eagle_Impl();
	}

	/** Identifier for the {@link test.openworld.deep.ext2.Eagle} type in JSON format. */
	String EAGLE__TYPE = "Eagle";

	/** @see #isBald() */
	String BALD__PROP = "bald";

	boolean isBald();

	/**
	 * @see #isBald()
	 */
	test.openworld.deep.ext2.Eagle setBald(boolean value);

	@Override
	test.openworld.deep.ext2.Eagle setSpeed(double value);

	@Override
	test.openworld.deep.ext2.Eagle setWingspan(double value);

	@Override
	test.openworld.deep.ext2.Eagle setName(String value);

	/** Reads a new instance from the given reader. */
	static test.openworld.deep.ext2.Eagle readEagle(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.openworld.deep.ext2.impl.Eagle_Impl result = new test.openworld.deep.ext2.impl.Eagle_Impl();
		result.readContent(in);
		return result;
	}

	/** Creates a new {@link Eagle} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Eagle readEagle(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.openworld.deep.ext2.impl.Eagle_Impl.readEagle_XmlContent(in);
	}

}
