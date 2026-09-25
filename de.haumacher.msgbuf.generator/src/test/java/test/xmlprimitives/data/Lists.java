package test.xmlprimitives.data;

/**
 * Every primitive type as repeated field.
 */
public interface Lists extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/**
	 * Creates a {@link test.xmlprimitives.data.Lists} instance.
	 */
	static test.xmlprimitives.data.Lists create() {
		return new test.xmlprimitives.data.impl.Lists_Impl();
	}

	/** Identifier for the {@link test.xmlprimitives.data.Lists} type in JSON format. */
	String LISTS__TYPE = "Lists";

	/** @see #isLBool() */
	String L_BOOL__PROP = "lBool";

	/** @see #getLInt32() */
	String L_INT_32__PROP = "lInt32";

	/** @see #getLSint32() */
	String L_SINT_32__PROP = "lSint32";

	/** @see #getLUint32() */
	String L_UINT_32__PROP = "lUint32";

	/** @see #getLFixed32() */
	String L_FIXED_32__PROP = "lFixed32";

	/** @see #getLSfixed32() */
	String L_SFIXED_32__PROP = "lSfixed32";

	/** @see #getLInt64() */
	String L_INT_64__PROP = "lInt64";

	/** @see #getLSint64() */
	String L_SINT_64__PROP = "lSint64";

	/** @see #getLUint64() */
	String L_UINT_64__PROP = "lUint64";

	/** @see #getLFixed64() */
	String L_FIXED_64__PROP = "lFixed64";

	/** @see #getLSfixed64() */
	String L_SFIXED_64__PROP = "lSfixed64";

	/** @see #getLFloat() */
	String L_FLOAT__PROP = "lFloat";

	/** @see #getLDouble() */
	String L_DOUBLE__PROP = "lDouble";

	/** @see #getLString() */
	String L_STRING__PROP = "lString";

	/** @see #getLBytes() */
	String L_BYTES__PROP = "lBytes";

	/** @see #getLColor() */
	String L_COLOR__PROP = "lColor";

	/** Identifier for the property {@link #isLBool()} in binary format. */
	static final int L_BOOL__ID = 1;

	/** Identifier for the property {@link #getLInt32()} in binary format. */
	static final int L_INT_32__ID = 2;

	/** Identifier for the property {@link #getLSint32()} in binary format. */
	static final int L_SINT_32__ID = 3;

	/** Identifier for the property {@link #getLUint32()} in binary format. */
	static final int L_UINT_32__ID = 4;

	/** Identifier for the property {@link #getLFixed32()} in binary format. */
	static final int L_FIXED_32__ID = 5;

	/** Identifier for the property {@link #getLSfixed32()} in binary format. */
	static final int L_SFIXED_32__ID = 6;

	/** Identifier for the property {@link #getLInt64()} in binary format. */
	static final int L_INT_64__ID = 7;

	/** Identifier for the property {@link #getLSint64()} in binary format. */
	static final int L_SINT_64__ID = 8;

	/** Identifier for the property {@link #getLUint64()} in binary format. */
	static final int L_UINT_64__ID = 9;

	/** Identifier for the property {@link #getLFixed64()} in binary format. */
	static final int L_FIXED_64__ID = 10;

	/** Identifier for the property {@link #getLSfixed64()} in binary format. */
	static final int L_SFIXED_64__ID = 11;

	/** Identifier for the property {@link #getLFloat()} in binary format. */
	static final int L_FLOAT__ID = 12;

	/** Identifier for the property {@link #getLDouble()} in binary format. */
	static final int L_DOUBLE__ID = 13;

	/** Identifier for the property {@link #getLString()} in binary format. */
	static final int L_STRING__ID = 14;

	/** Identifier for the property {@link #getLBytes()} in binary format. */
	static final int L_BYTES__ID = 15;

	/** Identifier for the property {@link #getLColor()} in binary format. */
	static final int L_COLOR__ID = 16;

	java.util.List<Boolean> isLBool();

	/**
	 * @see #isLBool()
	 */
	test.xmlprimitives.data.Lists setLBool(java.util.List<? extends Boolean> value);

	/**
	 * Adds a value to the {@link #isLBool()} list.
	 */
	test.xmlprimitives.data.Lists addLBool(boolean value);

	/**
	 * Removes a value from the {@link #isLBool()} list.
	 */
	void removeLBool(boolean value);

	java.util.List<Integer> getLInt32();

	/**
	 * @see #getLInt32()
	 */
	test.xmlprimitives.data.Lists setLInt32(java.util.List<? extends Integer> value);

	/**
	 * Adds a value to the {@link #getLInt32()} list.
	 */
	test.xmlprimitives.data.Lists addLInt32(int value);

	/**
	 * Removes a value from the {@link #getLInt32()} list.
	 */
	void removeLInt32(int value);

	java.util.List<Integer> getLSint32();

	/**
	 * @see #getLSint32()
	 */
	test.xmlprimitives.data.Lists setLSint32(java.util.List<? extends Integer> value);

	/**
	 * Adds a value to the {@link #getLSint32()} list.
	 */
	test.xmlprimitives.data.Lists addLSint32(int value);

	/**
	 * Removes a value from the {@link #getLSint32()} list.
	 */
	void removeLSint32(int value);

	java.util.List<Integer> getLUint32();

	/**
	 * @see #getLUint32()
	 */
	test.xmlprimitives.data.Lists setLUint32(java.util.List<? extends Integer> value);

	/**
	 * Adds a value to the {@link #getLUint32()} list.
	 */
	test.xmlprimitives.data.Lists addLUint32(int value);

	/**
	 * Removes a value from the {@link #getLUint32()} list.
	 */
	void removeLUint32(int value);

	java.util.List<Integer> getLFixed32();

	/**
	 * @see #getLFixed32()
	 */
	test.xmlprimitives.data.Lists setLFixed32(java.util.List<? extends Integer> value);

	/**
	 * Adds a value to the {@link #getLFixed32()} list.
	 */
	test.xmlprimitives.data.Lists addLFixed32(int value);

	/**
	 * Removes a value from the {@link #getLFixed32()} list.
	 */
	void removeLFixed32(int value);

	java.util.List<Integer> getLSfixed32();

	/**
	 * @see #getLSfixed32()
	 */
	test.xmlprimitives.data.Lists setLSfixed32(java.util.List<? extends Integer> value);

	/**
	 * Adds a value to the {@link #getLSfixed32()} list.
	 */
	test.xmlprimitives.data.Lists addLSfixed32(int value);

	/**
	 * Removes a value from the {@link #getLSfixed32()} list.
	 */
	void removeLSfixed32(int value);

	java.util.List<Long> getLInt64();

	/**
	 * @see #getLInt64()
	 */
	test.xmlprimitives.data.Lists setLInt64(java.util.List<? extends Long> value);

	/**
	 * Adds a value to the {@link #getLInt64()} list.
	 */
	test.xmlprimitives.data.Lists addLInt64(long value);

	/**
	 * Removes a value from the {@link #getLInt64()} list.
	 */
	void removeLInt64(long value);

	java.util.List<Long> getLSint64();

	/**
	 * @see #getLSint64()
	 */
	test.xmlprimitives.data.Lists setLSint64(java.util.List<? extends Long> value);

	/**
	 * Adds a value to the {@link #getLSint64()} list.
	 */
	test.xmlprimitives.data.Lists addLSint64(long value);

	/**
	 * Removes a value from the {@link #getLSint64()} list.
	 */
	void removeLSint64(long value);

	java.util.List<Long> getLUint64();

	/**
	 * @see #getLUint64()
	 */
	test.xmlprimitives.data.Lists setLUint64(java.util.List<? extends Long> value);

	/**
	 * Adds a value to the {@link #getLUint64()} list.
	 */
	test.xmlprimitives.data.Lists addLUint64(long value);

	/**
	 * Removes a value from the {@link #getLUint64()} list.
	 */
	void removeLUint64(long value);

	java.util.List<Long> getLFixed64();

	/**
	 * @see #getLFixed64()
	 */
	test.xmlprimitives.data.Lists setLFixed64(java.util.List<? extends Long> value);

	/**
	 * Adds a value to the {@link #getLFixed64()} list.
	 */
	test.xmlprimitives.data.Lists addLFixed64(long value);

	/**
	 * Removes a value from the {@link #getLFixed64()} list.
	 */
	void removeLFixed64(long value);

	java.util.List<Long> getLSfixed64();

	/**
	 * @see #getLSfixed64()
	 */
	test.xmlprimitives.data.Lists setLSfixed64(java.util.List<? extends Long> value);

	/**
	 * Adds a value to the {@link #getLSfixed64()} list.
	 */
	test.xmlprimitives.data.Lists addLSfixed64(long value);

	/**
	 * Removes a value from the {@link #getLSfixed64()} list.
	 */
	void removeLSfixed64(long value);

	java.util.List<Float> getLFloat();

	/**
	 * @see #getLFloat()
	 */
	test.xmlprimitives.data.Lists setLFloat(java.util.List<? extends Float> value);

	/**
	 * Adds a value to the {@link #getLFloat()} list.
	 */
	test.xmlprimitives.data.Lists addLFloat(float value);

	/**
	 * Removes a value from the {@link #getLFloat()} list.
	 */
	void removeLFloat(float value);

	java.util.List<Double> getLDouble();

	/**
	 * @see #getLDouble()
	 */
	test.xmlprimitives.data.Lists setLDouble(java.util.List<? extends Double> value);

	/**
	 * Adds a value to the {@link #getLDouble()} list.
	 */
	test.xmlprimitives.data.Lists addLDouble(double value);

	/**
	 * Removes a value from the {@link #getLDouble()} list.
	 */
	void removeLDouble(double value);

	java.util.List<String> getLString();

	/**
	 * @see #getLString()
	 */
	test.xmlprimitives.data.Lists setLString(java.util.List<? extends String> value);

	/**
	 * Adds a value to the {@link #getLString()} list.
	 */
	test.xmlprimitives.data.Lists addLString(String value);

	/**
	 * Removes a value from the {@link #getLString()} list.
	 */
	void removeLString(String value);

	java.util.List<byte[]> getLBytes();

	/**
	 * @see #getLBytes()
	 */
	test.xmlprimitives.data.Lists setLBytes(java.util.List<? extends byte[]> value);

	/**
	 * Adds a value to the {@link #getLBytes()} list.
	 */
	test.xmlprimitives.data.Lists addLByte(byte[] value);

	/**
	 * Removes a value from the {@link #getLBytes()} list.
	 */
	void removeLByte(byte[] value);

	java.util.List<test.xmlprimitives.data.Color> getLColor();

	/**
	 * @see #getLColor()
	 */
	test.xmlprimitives.data.Lists setLColor(java.util.List<? extends test.xmlprimitives.data.Color> value);

	/**
	 * Adds a value to the {@link #getLColor()} list.
	 */
	test.xmlprimitives.data.Lists addLColor(test.xmlprimitives.data.Color value);

	/**
	 * Removes a value from the {@link #getLColor()} list.
	 */
	void removeLColor(test.xmlprimitives.data.Color value);

	@Override
	public test.xmlprimitives.data.Lists registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.xmlprimitives.data.Lists unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.xmlprimitives.data.Lists readLists(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.xmlprimitives.data.impl.Lists_Impl result = new test.xmlprimitives.data.impl.Lists_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.xmlprimitives.data.Lists readLists(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.xmlprimitives.data.Lists result = test.xmlprimitives.data.impl.Lists_Impl.readLists_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link Lists} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Lists readLists(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.xmlprimitives.data.impl.Lists_Impl.readLists_XmlContent(in);
	}

}
