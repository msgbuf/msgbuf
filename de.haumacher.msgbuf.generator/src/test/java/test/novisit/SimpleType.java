package test.novisit;

/**
 * A concrete type without abstract super type.
 */
public interface SimpleType extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/**
	 * Creates a {@link test.novisit.SimpleType} instance.
	 */
	static test.novisit.SimpleType create() {
		return new test.novisit.impl.SimpleType_Impl();
	}

	/** Identifier for the {@link test.novisit.SimpleType} type in JSON format. */
	static final String SIMPLE_TYPE__TYPE = "SimpleType";

	/** @see #getStr() */
	static final String STR__PROP = "str";

	/** @see #getX() */
	static final String X__PROP = "x";

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
	test.novisit.SimpleType setStr(String value);

	/**
	 * An int property
	 */
	int getX();

	/**
	 * @see #getX()
	 */
	test.novisit.SimpleType setX(int value);

	@Override
	public test.novisit.SimpleType registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.novisit.SimpleType unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.novisit.SimpleType readSimpleType(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.novisit.impl.SimpleType_Impl result = new test.novisit.impl.SimpleType_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.novisit.SimpleType readSimpleType(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.novisit.SimpleType result = test.novisit.impl.SimpleType_Impl.readSimpleType_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link SimpleType} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static SimpleType readSimpleType(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.novisit.impl.SimpleType_Impl.readSimpleType_XmlContent(in);
	}

}
