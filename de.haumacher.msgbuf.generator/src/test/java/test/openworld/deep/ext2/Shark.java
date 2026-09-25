package test.openworld.deep.ext2;

/**
 * Leaf of a second extension file below the intermediate of the first extension file.
 */
public interface Shark extends test.openworld.deep.ext1.Fish {

	/** Extended visitor that can handle {@link Shark}. */
	public interface Visitor<R,A,E extends Throwable> extends test.openworld.deep.ext1.Fish.Visitor<R,A,E> {

		/** Visit case for {@link Shark}. */
		R visit(test.openworld.deep.ext2.Shark self, A arg) throws E;

	}

	/**
	 * Creates a {@link test.openworld.deep.ext2.Shark} instance.
	 */
	static test.openworld.deep.ext2.Shark create() {
		return new test.openworld.deep.ext2.impl.Shark_Impl();
	}

	/** Identifier for the {@link test.openworld.deep.ext2.Shark} type in JSON format. */
	String SHARK__TYPE = "Shark";

	/** @see #getTeeth() */
	String TEETH__PROP = "teeth";

	int getTeeth();

	/**
	 * @see #getTeeth()
	 */
	test.openworld.deep.ext2.Shark setTeeth(int value);

	@Override
	test.openworld.deep.ext2.Shark setFins(int value);

	@Override
	test.openworld.deep.ext2.Shark setName(String value);

	/** Reads a new instance from the given reader. */
	static test.openworld.deep.ext2.Shark readShark(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.openworld.deep.ext2.impl.Shark_Impl result = new test.openworld.deep.ext2.impl.Shark_Impl();
		result.readContent(in);
		return result;
	}

	/** Creates a new {@link Shark} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Shark readShark(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.openworld.deep.ext2.impl.Shark_Impl.readShark_XmlContent(in);
	}

}
