package test.nojson;

/**
 * A concrete type without abstract super type.
 */
public interface SimpleType extends de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/**
	 * Creates a {@link test.nojson.SimpleType} instance.
	 */
	static test.nojson.SimpleType create() {
		return new test.nojson.impl.SimpleType_Impl();
	}

	/** Identifier for the {@link test.nojson.SimpleType} type in JSON format. */
	String SIMPLE_TYPE__TYPE = "SimpleType";

	/** @see #getStr() */
	String STR__PROP = "str";

	/** @see #getX() */
	String X__PROP = "x";

	/** Identifier for the property {@link #getStr()} in binary format. */
	static final int STR__ID = 1;

	/** Identifier for the property {@link #getX()} in binary format. */
	static final int X__ID = 2;

	/**
	 * A string property
	 */
	String getStr();

	/**
	 * @see #getStr()
	 */
	test.nojson.SimpleType setStr(String value);

	/**
	 * An int property
	 */
	int getX();

	/**
	 * @see #getX()
	 */
	test.nojson.SimpleType setX(int value);

	@Override
	public test.nojson.SimpleType registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.nojson.SimpleType unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.nojson.SimpleType readSimpleType(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.nojson.SimpleType result = test.nojson.impl.SimpleType_Impl.readSimpleType_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link SimpleType} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static SimpleType readSimpleType(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.nojson.impl.SimpleType_Impl.readSimpleType_XmlContent(in);
	}

}
