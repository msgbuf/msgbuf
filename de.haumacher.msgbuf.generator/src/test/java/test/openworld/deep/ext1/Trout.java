package test.openworld.deep.ext1;

/**
 * Leaf of the extension file below its own intermediate.
 */
public interface Trout extends test.openworld.deep.ext1.Fish {

	/**
	 * Creates a {@link test.openworld.deep.ext1.Trout} instance.
	 */
	static test.openworld.deep.ext1.Trout create() {
		return new test.openworld.deep.ext1.impl.Trout_Impl();
	}

	/** Identifier for the {@link test.openworld.deep.ext1.Trout} type in JSON format. */
	String TROUT__TYPE = "Trout";

	/** @see #isRainbow() */
	String RAINBOW__PROP = "rainbow";

	boolean isRainbow();

	/**
	 * @see #isRainbow()
	 */
	test.openworld.deep.ext1.Trout setRainbow(boolean value);

	@Override
	test.openworld.deep.ext1.Trout setFins(int value);

	@Override
	test.openworld.deep.ext1.Trout setName(String value);

	/** Reads a new instance from the given reader. */
	static test.openworld.deep.ext1.Trout readTrout(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.openworld.deep.ext1.impl.Trout_Impl result = new test.openworld.deep.ext1.impl.Trout_Impl();
		result.readContent(in);
		return result;
	}

	/** Creates a new {@link Trout} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Trout readTrout(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.openworld.deep.ext1.impl.Trout_Impl.readTrout_XmlContent(in);
	}

}
