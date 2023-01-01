package test.nullable.data;

public interface NullableValues extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.data.ReflectiveDataObject, de.haumacher.msgbuf.xml.XmlSerializable {

	/**
	 * Creates a {@link test.nullable.data.NullableValues} instance.
	 */
	static test.nullable.data.NullableValues create() {
		return new test.nullable.data.impl.NullableValues_Impl();
	}

	/** Identifier for the {@link test.nullable.data.NullableValues} type in JSON format. */
	String NULLABLE_VALUES__TYPE = "NullableValues";

	/** @see #getInt() */
	String INT__PROP = "int";

	/** @see #getLong() */
	String LONG__PROP = "long";

	/** @see #getBoolean() */
	String BOOLEAN__PROP = "boolean";

	/** @see #getString() */
	String STRING__PROP = "string";

	/** @see #getIntList() */
	String INT_LIST__PROP = "intList";

	/** @see #getStringList() */
	String STRING_LIST__PROP = "stringList";

	/** @see #getStringIntMap() */
	String STRING_INT_MAP__PROP = "stringIntMap";

	/** @see #getOptionalDecision() */
	String OPTIONAL_DECISION__PROP = "optionalDecision";

	/** Identifier for the property {@link #getInt()} in binary format. */
	static final int INT__ID = 1;

	/** Identifier for the property {@link #getLong()} in binary format. */
	static final int LONG__ID = 2;

	/** Identifier for the property {@link #getBoolean()} in binary format. */
	static final int BOOLEAN__ID = 3;

	/** Identifier for the property {@link #getString()} in binary format. */
	static final int STRING__ID = 4;

	/** Identifier for the property {@link #getIntList()} in binary format. */
	static final int INT_LIST__ID = 5;

	/** Identifier for the property {@link #getStringList()} in binary format. */
	static final int STRING_LIST__ID = 6;

	/** Identifier for the property {@link #getStringIntMap()} in binary format. */
	static final int STRING_INT_MAP__ID = 7;

	/** Identifier for the property {@link #getOptionalDecision()} in binary format. */
	static final int OPTIONAL_DECISION__ID = 8;

	Integer getInt();

	/**
	 * @see #getInt()
	 */
	test.nullable.data.NullableValues setInt(Integer value);

	/**
	 * Checks, whether {@link #getInt()} has a value.
	 */
	boolean hasInt();

	Long getLong();

	/**
	 * @see #getLong()
	 */
	test.nullable.data.NullableValues setLong(Long value);

	/**
	 * Checks, whether {@link #getLong()} has a value.
	 */
	boolean hasLong();

	Boolean getBoolean();

	/**
	 * @see #getBoolean()
	 */
	test.nullable.data.NullableValues setBoolean(Boolean value);

	/**
	 * Checks, whether {@link #getBoolean()} has a value.
	 */
	boolean hasBoolean();

	String getString();

	/**
	 * @see #getString()
	 */
	test.nullable.data.NullableValues setString(String value);

	/**
	 * Checks, whether {@link #getString()} has a value.
	 */
	boolean hasString();

	java.util.List<Integer> getIntList();

	/**
	 * @see #getIntList()
	 */
	test.nullable.data.NullableValues setIntList(java.util.List<? extends Integer> value);

	/**
	 * Adds a value to the {@link #getIntList()} list.
	 */
	test.nullable.data.NullableValues addIntList(int value);

	/**
	 * Removes a value from the {@link #getIntList()} list.
	 */
	void removeIntList(int value);

	/**
	 * Checks, whether {@link #getIntList()} has a value.
	 */
	boolean hasIntList();

	java.util.List<String> getStringList();

	/**
	 * @see #getStringList()
	 */
	test.nullable.data.NullableValues setStringList(java.util.List<? extends String> value);

	/**
	 * Adds a value to the {@link #getStringList()} list.
	 */
	test.nullable.data.NullableValues addStringList(String value);

	/**
	 * Removes a value from the {@link #getStringList()} list.
	 */
	void removeStringList(String value);

	/**
	 * Checks, whether {@link #getStringList()} has a value.
	 */
	boolean hasStringList();

	java.util.Map<String, Integer> getStringIntMap();

	/**
	 * @see #getStringIntMap()
	 */
	test.nullable.data.NullableValues setStringIntMap(java.util.Map<String, Integer> value);

	/**
	 * Adds a key value pair to the {@link #getStringIntMap()} map.
	 */
	test.nullable.data.NullableValues putStringIntMap(String key, int value);

	/**
	 * Removes a key from the {@link #getStringIntMap()} map.
	 */
	void removeStringIntMap(String key);

	/**
	 * Checks, whether {@link #getStringIntMap()} has a value.
	 */
	boolean hasStringIntMap();

	test.nullable.data.Decision getOptionalDecision();

	/**
	 * @see #getOptionalDecision()
	 */
	test.nullable.data.NullableValues setOptionalDecision(test.nullable.data.Decision value);

	/**
	 * Checks, whether {@link #getOptionalDecision()} has a value.
	 */
	boolean hasOptionalDecision();

	/** Reads a new instance from the given reader. */
	static test.nullable.data.NullableValues readNullableValues(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.nullable.data.impl.NullableValues_Impl result = new test.nullable.data.impl.NullableValues_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.nullable.data.NullableValues readNullableValues(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.nullable.data.NullableValues result = test.nullable.data.impl.NullableValues_Impl.readNullableValues_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link NullableValues} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static NullableValues readNullableValues(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.nullable.data.impl.NullableValues_Impl.readNullableValues_XmlContent(in);
	}

}
