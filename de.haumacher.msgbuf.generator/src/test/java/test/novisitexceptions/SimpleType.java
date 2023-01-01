package test.novisitexceptions;

/**
 * A concrete type without abstract super type.
 */
public interface SimpleType extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/**
	 * Creates a {@link test.novisitexceptions.SimpleType} instance.
	 */
	static test.novisitexceptions.SimpleType create() {
		return new test.novisitexceptions.impl.SimpleType_Impl();
	}

	/** Identifier for the {@link test.novisitexceptions.SimpleType} type in JSON format. */
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
	test.novisitexceptions.SimpleType setStr(String value);

	/**
	 * An int property
	 */
	int getX();

	/**
	 * @see #getX()
	 */
	test.novisitexceptions.SimpleType setX(int value);

	@Override
	public test.novisitexceptions.SimpleType registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.novisitexceptions.SimpleType unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.novisitexceptions.SimpleType readSimpleType(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.novisitexceptions.impl.SimpleType_Impl result = new test.novisitexceptions.impl.SimpleType_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.novisitexceptions.SimpleType readSimpleType(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.novisitexceptions.SimpleType result = test.novisitexceptions.impl.SimpleType_Impl.readSimpleType_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link SimpleType} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static SimpleType readSimpleType(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.novisitexceptions.impl.SimpleType_Impl.readSimpleType_XmlContent(in);
	}

}
