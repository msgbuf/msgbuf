package test.xmlprimitives.data;

/**
 * Every primitive type as nullable field.
 */
public interface Nullables extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/**
	 * Creates a {@link test.xmlprimitives.data.Nullables} instance.
	 */
	static test.xmlprimitives.data.Nullables create() {
		return new test.xmlprimitives.data.impl.Nullables_Impl();
	}

	/** Identifier for the {@link test.xmlprimitives.data.Nullables} type in JSON format. */
	String NULLABLES__TYPE = "Nullables";

	/** @see #getNBool() */
	String N_BOOL__PROP = "nBool";

	/** @see #getNInt32() */
	String N_INT_32__PROP = "nInt32";

	/** @see #getNSint32() */
	String N_SINT_32__PROP = "nSint32";

	/** @see #getNUint32() */
	String N_UINT_32__PROP = "nUint32";

	/** @see #getNFixed32() */
	String N_FIXED_32__PROP = "nFixed32";

	/** @see #getNSfixed32() */
	String N_SFIXED_32__PROP = "nSfixed32";

	/** @see #getNInt64() */
	String N_INT_64__PROP = "nInt64";

	/** @see #getNSint64() */
	String N_SINT_64__PROP = "nSint64";

	/** @see #getNUint64() */
	String N_UINT_64__PROP = "nUint64";

	/** @see #getNFixed64() */
	String N_FIXED_64__PROP = "nFixed64";

	/** @see #getNSfixed64() */
	String N_SFIXED_64__PROP = "nSfixed64";

	/** @see #getNFloat() */
	String N_FLOAT__PROP = "nFloat";

	/** @see #getNDouble() */
	String N_DOUBLE__PROP = "nDouble";

	/** @see #getNString() */
	String N_STRING__PROP = "nString";

	/** @see #getNBytes() */
	String N_BYTES__PROP = "nBytes";

	/** @see #getNJson() */
	String N_JSON__PROP = "nJson";

	/** @see #getNColor() */
	String N_COLOR__PROP = "nColor";

	/** @see #getNlInt32() */
	String NL_INT_32__PROP = "nlInt32";

	/** @see #getNlUint32() */
	String NL_UINT_32__PROP = "nlUint32";

	/** @see #getNlString() */
	String NL_STRING__PROP = "nlString";

	/** @see #getNlBytes() */
	String NL_BYTES__PROP = "nlBytes";

	/** Identifier for the property {@link #getNBool()} in binary format. */
	static final int N_BOOL__ID = 1;

	/** Identifier for the property {@link #getNInt32()} in binary format. */
	static final int N_INT_32__ID = 2;

	/** Identifier for the property {@link #getNSint32()} in binary format. */
	static final int N_SINT_32__ID = 3;

	/** Identifier for the property {@link #getNUint32()} in binary format. */
	static final int N_UINT_32__ID = 4;

	/** Identifier for the property {@link #getNFixed32()} in binary format. */
	static final int N_FIXED_32__ID = 5;

	/** Identifier for the property {@link #getNSfixed32()} in binary format. */
	static final int N_SFIXED_32__ID = 6;

	/** Identifier for the property {@link #getNInt64()} in binary format. */
	static final int N_INT_64__ID = 7;

	/** Identifier for the property {@link #getNSint64()} in binary format. */
	static final int N_SINT_64__ID = 8;

	/** Identifier for the property {@link #getNUint64()} in binary format. */
	static final int N_UINT_64__ID = 9;

	/** Identifier for the property {@link #getNFixed64()} in binary format. */
	static final int N_FIXED_64__ID = 10;

	/** Identifier for the property {@link #getNSfixed64()} in binary format. */
	static final int N_SFIXED_64__ID = 11;

	/** Identifier for the property {@link #getNFloat()} in binary format. */
	static final int N_FLOAT__ID = 12;

	/** Identifier for the property {@link #getNDouble()} in binary format. */
	static final int N_DOUBLE__ID = 13;

	/** Identifier for the property {@link #getNString()} in binary format. */
	static final int N_STRING__ID = 14;

	/** Identifier for the property {@link #getNBytes()} in binary format. */
	static final int N_BYTES__ID = 15;

	/** Identifier for the property {@link #getNJson()} in binary format. */
	static final int N_JSON__ID = 16;

	/** Identifier for the property {@link #getNColor()} in binary format. */
	static final int N_COLOR__ID = 17;

	/** Identifier for the property {@link #getNlInt32()} in binary format. */
	static final int NL_INT_32__ID = 18;

	/** Identifier for the property {@link #getNlUint32()} in binary format. */
	static final int NL_UINT_32__ID = 19;

	/** Identifier for the property {@link #getNlString()} in binary format. */
	static final int NL_STRING__ID = 20;

	/** Identifier for the property {@link #getNlBytes()} in binary format. */
	static final int NL_BYTES__ID = 21;

	Boolean getNBool();

	/**
	 * @see #getNBool()
	 */
	test.xmlprimitives.data.Nullables setNBool(Boolean value);

	/**
	 * Checks, whether {@link #getNBool()} has a value.
	 */
	boolean hasNBool();

	Integer getNInt32();

	/**
	 * @see #getNInt32()
	 */
	test.xmlprimitives.data.Nullables setNInt32(Integer value);

	/**
	 * Checks, whether {@link #getNInt32()} has a value.
	 */
	boolean hasNInt32();

	Integer getNSint32();

	/**
	 * @see #getNSint32()
	 */
	test.xmlprimitives.data.Nullables setNSint32(Integer value);

	/**
	 * Checks, whether {@link #getNSint32()} has a value.
	 */
	boolean hasNSint32();

	Integer getNUint32();

	/**
	 * @see #getNUint32()
	 */
	test.xmlprimitives.data.Nullables setNUint32(Integer value);

	/**
	 * Checks, whether {@link #getNUint32()} has a value.
	 */
	boolean hasNUint32();

	Integer getNFixed32();

	/**
	 * @see #getNFixed32()
	 */
	test.xmlprimitives.data.Nullables setNFixed32(Integer value);

	/**
	 * Checks, whether {@link #getNFixed32()} has a value.
	 */
	boolean hasNFixed32();

	Integer getNSfixed32();

	/**
	 * @see #getNSfixed32()
	 */
	test.xmlprimitives.data.Nullables setNSfixed32(Integer value);

	/**
	 * Checks, whether {@link #getNSfixed32()} has a value.
	 */
	boolean hasNSfixed32();

	Long getNInt64();

	/**
	 * @see #getNInt64()
	 */
	test.xmlprimitives.data.Nullables setNInt64(Long value);

	/**
	 * Checks, whether {@link #getNInt64()} has a value.
	 */
	boolean hasNInt64();

	Long getNSint64();

	/**
	 * @see #getNSint64()
	 */
	test.xmlprimitives.data.Nullables setNSint64(Long value);

	/**
	 * Checks, whether {@link #getNSint64()} has a value.
	 */
	boolean hasNSint64();

	Long getNUint64();

	/**
	 * @see #getNUint64()
	 */
	test.xmlprimitives.data.Nullables setNUint64(Long value);

	/**
	 * Checks, whether {@link #getNUint64()} has a value.
	 */
	boolean hasNUint64();

	Long getNFixed64();

	/**
	 * @see #getNFixed64()
	 */
	test.xmlprimitives.data.Nullables setNFixed64(Long value);

	/**
	 * Checks, whether {@link #getNFixed64()} has a value.
	 */
	boolean hasNFixed64();

	Long getNSfixed64();

	/**
	 * @see #getNSfixed64()
	 */
	test.xmlprimitives.data.Nullables setNSfixed64(Long value);

	/**
	 * Checks, whether {@link #getNSfixed64()} has a value.
	 */
	boolean hasNSfixed64();

	Float getNFloat();

	/**
	 * @see #getNFloat()
	 */
	test.xmlprimitives.data.Nullables setNFloat(Float value);

	/**
	 * Checks, whether {@link #getNFloat()} has a value.
	 */
	boolean hasNFloat();

	Double getNDouble();

	/**
	 * @see #getNDouble()
	 */
	test.xmlprimitives.data.Nullables setNDouble(Double value);

	/**
	 * Checks, whether {@link #getNDouble()} has a value.
	 */
	boolean hasNDouble();

	String getNString();

	/**
	 * @see #getNString()
	 */
	test.xmlprimitives.data.Nullables setNString(String value);

	/**
	 * Checks, whether {@link #getNString()} has a value.
	 */
	boolean hasNString();

	byte[] getNBytes();

	/**
	 * @see #getNBytes()
	 */
	test.xmlprimitives.data.Nullables setNBytes(byte[] value);

	/**
	 * Checks, whether {@link #getNBytes()} has a value.
	 */
	boolean hasNBytes();

	Object getNJson();

	/**
	 * @see #getNJson()
	 */
	test.xmlprimitives.data.Nullables setNJson(Object value);

	/**
	 * Checks, whether {@link #getNJson()} has a value.
	 */
	boolean hasNJson();

	test.xmlprimitives.data.Color getNColor();

	/**
	 * @see #getNColor()
	 */
	test.xmlprimitives.data.Nullables setNColor(test.xmlprimitives.data.Color value);

	/**
	 * Checks, whether {@link #getNColor()} has a value.
	 */
	boolean hasNColor();

	java.util.List<Integer> getNlInt32();

	/**
	 * @see #getNlInt32()
	 */
	test.xmlprimitives.data.Nullables setNlInt32(java.util.List<? extends Integer> value);

	/**
	 * Adds a value to the {@link #getNlInt32()} list.
	 */
	test.xmlprimitives.data.Nullables addNlInt32(int value);

	/**
	 * Removes a value from the {@link #getNlInt32()} list.
	 */
	void removeNlInt32(int value);

	/**
	 * Checks, whether {@link #getNlInt32()} has a value.
	 */
	boolean hasNlInt32();

	java.util.List<Integer> getNlUint32();

	/**
	 * @see #getNlUint32()
	 */
	test.xmlprimitives.data.Nullables setNlUint32(java.util.List<? extends Integer> value);

	/**
	 * Adds a value to the {@link #getNlUint32()} list.
	 */
	test.xmlprimitives.data.Nullables addNlUint32(int value);

	/**
	 * Removes a value from the {@link #getNlUint32()} list.
	 */
	void removeNlUint32(int value);

	/**
	 * Checks, whether {@link #getNlUint32()} has a value.
	 */
	boolean hasNlUint32();

	java.util.List<String> getNlString();

	/**
	 * @see #getNlString()
	 */
	test.xmlprimitives.data.Nullables setNlString(java.util.List<? extends String> value);

	/**
	 * Adds a value to the {@link #getNlString()} list.
	 */
	test.xmlprimitives.data.Nullables addNlString(String value);

	/**
	 * Removes a value from the {@link #getNlString()} list.
	 */
	void removeNlString(String value);

	/**
	 * Checks, whether {@link #getNlString()} has a value.
	 */
	boolean hasNlString();

	java.util.List<byte[]> getNlBytes();

	/**
	 * @see #getNlBytes()
	 */
	test.xmlprimitives.data.Nullables setNlBytes(java.util.List<? extends byte[]> value);

	/**
	 * Adds a value to the {@link #getNlBytes()} list.
	 */
	test.xmlprimitives.data.Nullables addNlByte(byte[] value);

	/**
	 * Removes a value from the {@link #getNlBytes()} list.
	 */
	void removeNlByte(byte[] value);

	/**
	 * Checks, whether {@link #getNlBytes()} has a value.
	 */
	boolean hasNlBytes();

	@Override
	public test.xmlprimitives.data.Nullables registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.xmlprimitives.data.Nullables unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.xmlprimitives.data.Nullables readNullables(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.xmlprimitives.data.impl.Nullables_Impl result = new test.xmlprimitives.data.impl.Nullables_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.xmlprimitives.data.Nullables readNullables(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.xmlprimitives.data.Nullables result = test.xmlprimitives.data.impl.Nullables_Impl.readNullables_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link Nullables} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Nullables readNullables(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.xmlprimitives.data.impl.Nullables_Impl.readNullables_XmlContent(in);
	}

}
