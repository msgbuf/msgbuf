package test.defaultvalue.data;

public interface A extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/**
	 * Creates a {@link test.defaultvalue.data.A} instance.
	 */
	static test.defaultvalue.data.A create() {
		return new test.defaultvalue.data.impl.A_Impl();
	}

	/** Identifier for the {@link test.defaultvalue.data.A} type in JSON format. */
	String A__TYPE = "A";

	/** @see #getS() */
	String S__PROP = "s";

	/** @see #getX() */
	String X__PROP = "x";

	/** @see #getY() */
	String Y__PROP = "y";

	/** @see #isState() */
	String STATE__PROP = "state";

	/** Identifier for the property {@link #getS()} in binary format. */
	static final int S__ID = 1;

	/** Identifier for the property {@link #getX()} in binary format. */
	static final int X__ID = 2;

	/** Identifier for the property {@link #getY()} in binary format. */
	static final int Y__ID = 3;

	/** Identifier for the property {@link #isState()} in binary format. */
	static final int STATE__ID = 4;

	String getS();

	/**
	 * @see #getS()
	 */
	test.defaultvalue.data.A setS(String value);

	int getX();

	/**
	 * @see #getX()
	 */
	test.defaultvalue.data.A setX(int value);

	double getY();

	/**
	 * @see #getY()
	 */
	test.defaultvalue.data.A setY(double value);

	boolean isState();

	/**
	 * @see #isState()
	 */
	test.defaultvalue.data.A setState(boolean value);

	@Override
	public test.defaultvalue.data.A registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.defaultvalue.data.A unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.defaultvalue.data.A readA(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.defaultvalue.data.impl.A_Impl result = new test.defaultvalue.data.impl.A_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.defaultvalue.data.A readA(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.defaultvalue.data.A result = test.defaultvalue.data.impl.A_Impl.readA_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link A} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static A readA(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.defaultvalue.data.impl.A_Impl.readA_XmlContent(in);
	}

}
