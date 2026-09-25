package test.xmlprimitives.data;

/**
 * Every primitive type as singular field.
 */
public interface Values extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/**
	 * Creates a {@link test.xmlprimitives.data.Values} instance.
	 */
	static test.xmlprimitives.data.Values create() {
		return new test.xmlprimitives.data.impl.Values_Impl();
	}

	/** Identifier for the {@link test.xmlprimitives.data.Values} type in JSON format. */
	String VALUES__TYPE = "Values";

	/** @see #isVBool() */
	String V_BOOL__PROP = "vBool";

	/** @see #getVInt32() */
	String V_INT_32__PROP = "vInt32";

	/** @see #getVSint32() */
	String V_SINT_32__PROP = "vSint32";

	/** @see #getVUint32() */
	String V_UINT_32__PROP = "vUint32";

	/** @see #getVFixed32() */
	String V_FIXED_32__PROP = "vFixed32";

	/** @see #getVSfixed32() */
	String V_SFIXED_32__PROP = "vSfixed32";

	/** @see #getVInt64() */
	String V_INT_64__PROP = "vInt64";

	/** @see #getVSint64() */
	String V_SINT_64__PROP = "vSint64";

	/** @see #getVUint64() */
	String V_UINT_64__PROP = "vUint64";

	/** @see #getVFixed64() */
	String V_FIXED_64__PROP = "vFixed64";

	/** @see #getVSfixed64() */
	String V_SFIXED_64__PROP = "vSfixed64";

	/** @see #getVFloat() */
	String V_FLOAT__PROP = "vFloat";

	/** @see #getVDouble() */
	String V_DOUBLE__PROP = "vDouble";

	/** @see #getVString() */
	String V_STRING__PROP = "vString";

	/** @see #getVBytes() */
	String V_BYTES__PROP = "vBytes";

	/** @see #getVJson() */
	String V_JSON__PROP = "vJson";

	/** @see #getVColor() */
	String V_COLOR__PROP = "vColor";

	/** Identifier for the property {@link #isVBool()} in binary format. */
	static final int V_BOOL__ID = 1;

	/** Identifier for the property {@link #getVInt32()} in binary format. */
	static final int V_INT_32__ID = 2;

	/** Identifier for the property {@link #getVSint32()} in binary format. */
	static final int V_SINT_32__ID = 3;

	/** Identifier for the property {@link #getVUint32()} in binary format. */
	static final int V_UINT_32__ID = 4;

	/** Identifier for the property {@link #getVFixed32()} in binary format. */
	static final int V_FIXED_32__ID = 5;

	/** Identifier for the property {@link #getVSfixed32()} in binary format. */
	static final int V_SFIXED_32__ID = 6;

	/** Identifier for the property {@link #getVInt64()} in binary format. */
	static final int V_INT_64__ID = 7;

	/** Identifier for the property {@link #getVSint64()} in binary format. */
	static final int V_SINT_64__ID = 8;

	/** Identifier for the property {@link #getVUint64()} in binary format. */
	static final int V_UINT_64__ID = 9;

	/** Identifier for the property {@link #getVFixed64()} in binary format. */
	static final int V_FIXED_64__ID = 10;

	/** Identifier for the property {@link #getVSfixed64()} in binary format. */
	static final int V_SFIXED_64__ID = 11;

	/** Identifier for the property {@link #getVFloat()} in binary format. */
	static final int V_FLOAT__ID = 12;

	/** Identifier for the property {@link #getVDouble()} in binary format. */
	static final int V_DOUBLE__ID = 13;

	/** Identifier for the property {@link #getVString()} in binary format. */
	static final int V_STRING__ID = 14;

	/** Identifier for the property {@link #getVBytes()} in binary format. */
	static final int V_BYTES__ID = 15;

	/** Identifier for the property {@link #getVJson()} in binary format. */
	static final int V_JSON__ID = 16;

	/** Identifier for the property {@link #getVColor()} in binary format. */
	static final int V_COLOR__ID = 17;

	boolean isVBool();

	/**
	 * @see #isVBool()
	 */
	test.xmlprimitives.data.Values setVBool(boolean value);

	int getVInt32();

	/**
	 * @see #getVInt32()
	 */
	test.xmlprimitives.data.Values setVInt32(int value);

	int getVSint32();

	/**
	 * @see #getVSint32()
	 */
	test.xmlprimitives.data.Values setVSint32(int value);

	int getVUint32();

	/**
	 * @see #getVUint32()
	 */
	test.xmlprimitives.data.Values setVUint32(int value);

	int getVFixed32();

	/**
	 * @see #getVFixed32()
	 */
	test.xmlprimitives.data.Values setVFixed32(int value);

	int getVSfixed32();

	/**
	 * @see #getVSfixed32()
	 */
	test.xmlprimitives.data.Values setVSfixed32(int value);

	long getVInt64();

	/**
	 * @see #getVInt64()
	 */
	test.xmlprimitives.data.Values setVInt64(long value);

	long getVSint64();

	/**
	 * @see #getVSint64()
	 */
	test.xmlprimitives.data.Values setVSint64(long value);

	long getVUint64();

	/**
	 * @see #getVUint64()
	 */
	test.xmlprimitives.data.Values setVUint64(long value);

	long getVFixed64();

	/**
	 * @see #getVFixed64()
	 */
	test.xmlprimitives.data.Values setVFixed64(long value);

	long getVSfixed64();

	/**
	 * @see #getVSfixed64()
	 */
	test.xmlprimitives.data.Values setVSfixed64(long value);

	float getVFloat();

	/**
	 * @see #getVFloat()
	 */
	test.xmlprimitives.data.Values setVFloat(float value);

	double getVDouble();

	/**
	 * @see #getVDouble()
	 */
	test.xmlprimitives.data.Values setVDouble(double value);

	String getVString();

	/**
	 * @see #getVString()
	 */
	test.xmlprimitives.data.Values setVString(String value);

	byte[] getVBytes();

	/**
	 * @see #getVBytes()
	 */
	test.xmlprimitives.data.Values setVBytes(byte[] value);

	Object getVJson();

	/**
	 * @see #getVJson()
	 */
	test.xmlprimitives.data.Values setVJson(Object value);

	/**
	 * Checks, whether {@link #getVJson()} has a value.
	 */
	boolean hasVJson();

	test.xmlprimitives.data.Color getVColor();

	/**
	 * @see #getVColor()
	 */
	test.xmlprimitives.data.Values setVColor(test.xmlprimitives.data.Color value);

	@Override
	public test.xmlprimitives.data.Values registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.xmlprimitives.data.Values unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.xmlprimitives.data.Values readValues(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.xmlprimitives.data.impl.Values_Impl result = new test.xmlprimitives.data.impl.Values_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.xmlprimitives.data.Values readValues(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.xmlprimitives.data.Values result = test.xmlprimitives.data.impl.Values_Impl.readValues_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link Values} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Values readValues(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.xmlprimitives.data.impl.Values_Impl.readValues_XmlContent(in);
	}

}
