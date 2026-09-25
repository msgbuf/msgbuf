package test.nested.data;

/**
 * A top-level message extending a nested abstract message.
 */
public interface Triangle extends test.nested.data.Outer.Shape {

	/**
	 * Creates a {@link test.nested.data.Triangle} instance.
	 */
	static test.nested.data.Triangle create() {
		return new test.nested.data.impl.Triangle_Impl();
	}

	/** Identifier for the {@link test.nested.data.Triangle} type in JSON format. */
	String TRIANGLE__TYPE = "Triangle";

	/** @see #getBase() */
	String BASE__PROP = "base";

	/** @see #getHeight() */
	String HEIGHT__PROP = "height";

	/** Identifier for the {@link test.nested.data.Triangle} type in binary format. */
	static final int TRIANGLE__TYPE_ID = 3;

	/** Identifier for the property {@link #getBase()} in binary format. */
	static final int BASE__ID = 2;

	/** Identifier for the property {@link #getHeight()} in binary format. */
	static final int HEIGHT__ID = 3;

	int getBase();

	/**
	 * @see #getBase()
	 */
	test.nested.data.Triangle setBase(int value);

	int getHeight();

	/**
	 * @see #getHeight()
	 */
	test.nested.data.Triangle setHeight(int value);

	@Override
	test.nested.data.Triangle setName(String value);

	/** Reads a new instance from the given reader. */
	static test.nested.data.Triangle readTriangle(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.nested.data.impl.Triangle_Impl result = new test.nested.data.impl.Triangle_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.nested.data.Triangle readTriangle(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.nested.data.Triangle result = test.nested.data.impl.Triangle_Impl.readTriangle_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link Triangle} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Triangle readTriangle(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.nested.data.impl.Triangle_Impl.readTriangle_XmlContent(in);
	}

}
