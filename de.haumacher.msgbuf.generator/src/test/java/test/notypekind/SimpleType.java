package test.notypekind;

/**
 * A concrete type without abstract super type.
 */
public interface SimpleType extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/**
	 * Creates a {@link test.notypekind.SimpleType} instance.
	 */
	static test.notypekind.SimpleType create() {
		return new test.notypekind.impl.SimpleType_Impl();
	}

	/** Identifier for the {@link test.notypekind.SimpleType} type in JSON format. */
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
	test.notypekind.SimpleType setStr(String value);

	/**
	 * An int property
	 */
	int getX();

	/**
	 * @see #getX()
	 */
	test.notypekind.SimpleType setX(int value);

	@Override
	public test.notypekind.SimpleType registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.notypekind.SimpleType unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.notypekind.SimpleType readSimpleType(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.notypekind.impl.SimpleType_Impl result = new test.notypekind.impl.SimpleType_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.notypekind.SimpleType readSimpleType(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.notypekind.SimpleType result = test.notypekind.impl.SimpleType_Impl.readSimpleType_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link SimpleType} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static SimpleType readSimpleType(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.notypekind.impl.SimpleType_Impl.readSimpleType_XmlContent(in);
	}

}
