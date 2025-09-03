package test.transientprops.data;

public interface C extends B {

	/**
	 * Creates a {@link test.transientprops.data.C} instance.
	 */
	static test.transientprops.data.C create() {
		return new test.transientprops.data.impl.C_Impl();
	}

	/** Identifier for the {@link test.transientprops.data.C} type in JSON format. */
	String C__TYPE = "C";

	/** @see #getZ1() */
	String Z_1__PROP = "z1";

	/** @see #getZ2() */
	String Z_2__PROP = "z2";

	/** Identifier for the property {@link #getZ1()} in binary format. */
	static final int Z_1__ID = 5;

	String getZ1();

	/**
	 * @see #getZ1()
	 */
	test.transientprops.data.C setZ1(String value);

	String getZ2();

	/**
	 * @see #getZ2()
	 */
	test.transientprops.data.C setZ2(String value);

	@Override
	test.transientprops.data.C setY1(String value);

	@Override
	test.transientprops.data.C setY2(String value);

	@Override
	test.transientprops.data.C setX1(String value);

	@Override
	test.transientprops.data.C setX2(String value);

	/** Reads a new instance from the given reader. */
	static test.transientprops.data.C readC(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.transientprops.data.impl.C_Impl result = new test.transientprops.data.impl.C_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.transientprops.data.C readC(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.transientprops.data.C result = test.transientprops.data.impl.C_Impl.readC_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link C} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static C readC(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.transientprops.data.impl.C_Impl.readC_XmlContent(in);
	}

}
