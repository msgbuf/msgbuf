package test.openworld.deep.ext1;

/**
 * Leaf of another file below an abstract intermediate of the base file.
 */
public interface Parrot extends test.openworld.deep.base.Bird {

	/** Extended visitor that can handle {@link Parrot}. */
	public interface Visitor<R,A,E extends Throwable> extends test.openworld.deep.base.Bird.Visitor<R,A,E> {

		/** Visit case for {@link Parrot}. */
		R visit(test.openworld.deep.ext1.Parrot self, A arg) throws E;

	}

	/**
	 * Creates a {@link test.openworld.deep.ext1.Parrot} instance.
	 */
	static test.openworld.deep.ext1.Parrot create() {
		return new test.openworld.deep.ext1.impl.Parrot_Impl();
	}

	/** Identifier for the {@link test.openworld.deep.ext1.Parrot} type in JSON format. */
	String PARROT__TYPE = "Parrot";

	/** @see #getWord() */
	String WORD__PROP = "word";

	String getWord();

	/**
	 * @see #getWord()
	 */
	test.openworld.deep.ext1.Parrot setWord(String value);

	@Override
	test.openworld.deep.ext1.Parrot setWingspan(double value);

	@Override
	test.openworld.deep.ext1.Parrot setName(String value);

	/** Reads a new instance from the given reader. */
	static test.openworld.deep.ext1.Parrot readParrot(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.openworld.deep.ext1.impl.Parrot_Impl result = new test.openworld.deep.ext1.impl.Parrot_Impl();
		result.readContent(in);
		return result;
	}

	/** Creates a new {@link Parrot} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Parrot readParrot(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.openworld.deep.ext1.impl.Parrot_Impl.readParrot_XmlContent(in);
	}

}
