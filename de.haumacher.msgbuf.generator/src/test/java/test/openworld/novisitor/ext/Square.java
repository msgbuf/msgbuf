package test.openworld.novisitor.ext;

public interface Square extends test.openworld.novisitor.base.Shape {

	/**
	 * Creates a {@link test.openworld.novisitor.ext.Square} instance.
	 */
	static test.openworld.novisitor.ext.Square create() {
		return new test.openworld.novisitor.ext.impl.Square_Impl();
	}

	/** Identifier for the {@link test.openworld.novisitor.ext.Square} type in JSON format. */
	String SQUARE__TYPE = "Square";

	/** @see #getSide() */
	String SIDE__PROP = "side";

	int getSide();

	/**
	 * @see #getSide()
	 */
	test.openworld.novisitor.ext.Square setSide(int value);

	@Override
	test.openworld.novisitor.ext.Square setName(String value);

	/** Reads a new instance from the given reader. */
	static test.openworld.novisitor.ext.Square readSquare(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.openworld.novisitor.ext.impl.Square_Impl result = new test.openworld.novisitor.ext.impl.Square_Impl();
		result.readContent(in);
		return result;
	}

	/** Creates a new {@link Square} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Square readSquare(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.openworld.novisitor.ext.impl.Square_Impl.readSquare_XmlContent(in);
	}

}
