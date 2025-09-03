package test.transientprops.data;

public interface B extends A {

	/**
	 * Creates a {@link test.transientprops.data.B} instance.
	 */
	static test.transientprops.data.B create() {
		return new test.transientprops.data.impl.B_Impl();
	}

	/** Identifier for the {@link test.transientprops.data.B} type in JSON format. */
	String B__TYPE = "B";

	/** @see #getY1() */
	String Y_1__PROP = "y1";

	/** @see #getY2() */
	String Y_2__PROP = "y2";

	/** Identifier for the property {@link #getY1()} in binary format. */
	static final int Y_1__ID = 3;

	String getY1();

	/**
	 * @see #getY1()
	 */
	test.transientprops.data.B setY1(String value);

	String getY2();

	/**
	 * @see #getY2()
	 */
	test.transientprops.data.B setY2(String value);

	@Override
	test.transientprops.data.B setX1(String value);

	@Override
	test.transientprops.data.B setX2(String value);

	/** Reads a new instance from the given reader. */
	static test.transientprops.data.B readB(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.transientprops.data.impl.B_Impl result = new test.transientprops.data.impl.B_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.transientprops.data.B readB(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.transientprops.data.B result = test.transientprops.data.impl.B_Impl.readB_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link B} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static B readB(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.transientprops.data.impl.B_Impl.readB_XmlContent(in);
	}

}
