package test.onlyxml.data;

/**
 * A concrete type without abstract super type.
 */
public interface SimpleType extends de.haumacher.msgbuf.xml.XmlSerializable {

	/**
	 * Creates a {@link test.onlyxml.data.SimpleType} instance.
	 */
	static test.onlyxml.data.SimpleType create() {
		return new test.onlyxml.data.impl.SimpleType_Impl();
	}

	/**
	 * A string property
	 */
	String getStr();

	/**
	 * @see #getStr()
	 */
	test.onlyxml.data.SimpleType setStr(String value);

	/**
	 * An int property
	 */
	int getX();

	/**
	 * @see #getX()
	 */
	test.onlyxml.data.SimpleType setX(int value);

	/** Creates a new {@link SimpleType} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static SimpleType readSimpleType(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.onlyxml.data.impl.SimpleType_Impl.readSimpleType_XmlContent(in);
	}

}
