package test.nullable.data;

public class NullableValues extends de.haumacher.msgbuf.data.AbstractDataObject implements de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.data.ReflectiveDataObject {

	/**
	 * Creates a {@link NullableValues} instance.
	 */
	public static NullableValues create() {
		return new NullableValues();
	}

	/** Identifier for the {@link NullableValues} type in JSON format. */
	public static final String NULLABLE_VALUES__TYPE = "NullableValues";

	/** @see #getInt() */
	public static final String INT = "int";

	/** @see #getLong() */
	public static final String LONG = "long";

	/** @see #getBoolean() */
	public static final String BOOLEAN = "boolean";

	/** @see #getString() */
	public static final String STRING = "string";

	/** @see #getIntList() */
	public static final String INT_LIST = "intList";

	/** @see #getStringList() */
	public static final String STRING_LIST = "stringList";

	/** @see #getStringIntMap() */
	public static final String STRING_INT_MAP = "stringIntMap";

	/** @see #getOptionalDecision() */
	public static final String OPTIONAL_DECISION = "optionalDecision";

	/** Identifier for the property {@link #getInt()} in binary format. */
	public static final int INT__ID = 1;

	/** Identifier for the property {@link #getLong()} in binary format. */
	public static final int LONG__ID = 2;

	/** Identifier for the property {@link #getBoolean()} in binary format. */
	public static final int BOOLEAN__ID = 3;

	/** Identifier for the property {@link #getString()} in binary format. */
	public static final int STRING__ID = 4;

	/** Identifier for the property {@link #getIntList()} in binary format. */
	public static final int INT_LIST__ID = 5;

	/** Identifier for the property {@link #getStringList()} in binary format. */
	public static final int STRING_LIST__ID = 6;

	/** Identifier for the property {@link #getStringIntMap()} in binary format. */
	public static final int STRING_INT_MAP__ID = 7;

	/** Identifier for the property {@link #getOptionalDecision()} in binary format. */
	public static final int OPTIONAL_DECISION__ID = 8;

	private Integer _int = null;

	private Long _long = null;

	private Boolean _boolean = null;

	private String _string = null;

	private java.util.List<Integer> _intList = null;

	private java.util.List<String> _stringList = null;

	private java.util.Map<String, Integer> _stringIntMap = null;

	private Decision _optionalDecision = null;

	/**
	 * Creates a {@link NullableValues} instance.
	 *
	 * @see #create()
	 */
	protected NullableValues() {
		super();
	}

	public final Integer getInt() {
		return _int;
	}

	/**
	 * @see #getInt()
	 */
	public final NullableValues setInt(Integer value) {
		_int = value;
		return this;
	}

	/**
	 * Checks, whether {@link #getInt()} has a value.
	 */
	public final boolean hasInt() {
		return _int != null;
	}

	public final Long getLong() {
		return _long;
	}

	/**
	 * @see #getLong()
	 */
	public final NullableValues setLong(Long value) {
		_long = value;
		return this;
	}

	/**
	 * Checks, whether {@link #getLong()} has a value.
	 */
	public final boolean hasLong() {
		return _long != null;
	}

	public final Boolean getBoolean() {
		return _boolean;
	}

	/**
	 * @see #getBoolean()
	 */
	public final NullableValues setBoolean(Boolean value) {
		_boolean = value;
		return this;
	}

	/**
	 * Checks, whether {@link #getBoolean()} has a value.
	 */
	public final boolean hasBoolean() {
		return _boolean != null;
	}

	public final String getString() {
		return _string;
	}

	/**
	 * @see #getString()
	 */
	public final NullableValues setString(String value) {
		_string = value;
		return this;
	}

	/**
	 * Checks, whether {@link #getString()} has a value.
	 */
	public final boolean hasString() {
		return _string != null;
	}

	public final java.util.List<Integer> getIntList() {
		return _intList;
	}

	/**
	 * @see #getIntList()
	 */
	public final NullableValues setIntList(java.util.List<Integer> value) {
		if (_intList == null) _intList = new java.util.ArrayList<>();
		_intList.clear();
		_intList.addAll(value);
		return this;
	}

	/**
	 * Adds a value to the {@link #getIntList()} list.
	 */
	public final NullableValues addIntList(int value) {
		if (_intList == null) _intList = new java.util.ArrayList<>();
		_intList.add(value);
		return this;
	}

	/**
	 * Removes a value from the {@link #getIntList()} list.
	 */
	public final NullableValues removeIntList(int value) {
		if (_intList == null) _intList = new java.util.ArrayList<>();
		_intList.remove(value);
		return this;
	}

	/**
	 * Checks, whether {@link #getIntList()} has a value.
	 */
	public final boolean hasIntList() {
		return _intList != null;
	}

	public final java.util.List<String> getStringList() {
		return _stringList;
	}

	/**
	 * @see #getStringList()
	 */
	public final NullableValues setStringList(java.util.List<String> value) {
		if (_stringList == null) _stringList = new java.util.ArrayList<>();
		_stringList.clear();
		_stringList.addAll(value);
		return this;
	}

	/**
	 * Adds a value to the {@link #getStringList()} list.
	 */
	public final NullableValues addStringList(String value) {
		if (_stringList == null) _stringList = new java.util.ArrayList<>();
		_stringList.add(value);
		return this;
	}

	/**
	 * Removes a value from the {@link #getStringList()} list.
	 */
	public final NullableValues removeStringList(String value) {
		if (_stringList == null) _stringList = new java.util.ArrayList<>();
		_stringList.remove(value);
		return this;
	}

	/**
	 * Checks, whether {@link #getStringList()} has a value.
	 */
	public final boolean hasStringList() {
		return _stringList != null;
	}

	public final java.util.Map<String, Integer> getStringIntMap() {
		return _stringIntMap;
	}

	/**
	 * @see #getStringIntMap()
	 */
	public final NullableValues setStringIntMap(java.util.Map<String, Integer> value) {
		if (_stringIntMap == null) _stringIntMap = new java.util.HashMap<>();
		_stringIntMap.clear();
		_stringIntMap.putAll(value);
		return this;
	}

	/**
	 * Adds a value to the {@link #getStringIntMap()} map.
	 */
	public final NullableValues putStringIntMap(String key, int value) {
		if (_stringIntMap == null) _stringIntMap = new java.util.HashMap<>();
		if (_stringIntMap.containsKey(key)) {
			throw new IllegalArgumentException("Property 'stringIntMap' already contains a value for key '" + key + "'.");
		}
		_stringIntMap.put(key, value);
		return this;
	}

	/**
	 * Removes a key from the {@link #getStringIntMap()} map.
	 */
	public final NullableValues removeStringIntMap(String key) {
		if (_stringIntMap == null) _stringIntMap = new java.util.HashMap<>();
		_stringIntMap.remove(key);
		return this;
	}

	/**
	 * Checks, whether {@link #getStringIntMap()} has a value.
	 */
	public final boolean hasStringIntMap() {
		return _stringIntMap != null;
	}

	public final Decision getOptionalDecision() {
		return _optionalDecision;
	}

	/**
	 * @see #getOptionalDecision()
	 */
	public final NullableValues setOptionalDecision(Decision value) {
		_optionalDecision = value;
		return this;
	}

	/**
	 * Checks, whether {@link #getOptionalDecision()} has a value.
	 */
	public final boolean hasOptionalDecision() {
		return _optionalDecision != null;
	}

	@Override
	public String jsonType() {
		return NULLABLE_VALUES__TYPE;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			INT, 
			LONG, 
			BOOLEAN, 
			STRING, 
			INT_LIST, 
			STRING_LIST, 
			STRING_INT_MAP, 
			OPTIONAL_DECISION));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case INT: return getInt();
			case LONG: return getLong();
			case BOOLEAN: return getBoolean();
			case STRING: return getString();
			case INT_LIST: return getIntList();
			case STRING_LIST: return getStringList();
			case STRING_INT_MAP: return getStringIntMap();
			case OPTIONAL_DECISION: return getOptionalDecision();
			default: return de.haumacher.msgbuf.data.ReflectiveDataObject.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case INT: setInt((Integer) value); break;
			case LONG: setLong((Long) value); break;
			case BOOLEAN: setBoolean((Boolean) value); break;
			case STRING: setString((String) value); break;
			case INT_LIST: setIntList((java.util.List<Integer>) value); break;
			case STRING_LIST: setStringList((java.util.List<String>) value); break;
			case STRING_INT_MAP: setStringIntMap((java.util.Map<String, Integer>) value); break;
			case OPTIONAL_DECISION: setOptionalDecision((Decision) value); break;
		}
	}

	/** Reads a new instance from the given reader. */
	public static NullableValues readNullableValues(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		NullableValues result = new NullableValues();
		in.beginObject();
		result.readFields(in);
		in.endObject();
		return result;
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		if (hasInt()) {
			out.name(INT);
			out.value(getInt());
		}
		if (hasLong()) {
			out.name(LONG);
			out.value(getLong());
		}
		if (hasBoolean()) {
			out.name(BOOLEAN);
			out.value(getBoolean());
		}
		if (hasString()) {
			out.name(STRING);
			out.value(getString());
		}
		if (hasIntList()) {
			out.name(INT_LIST);
			out.beginArray();
			for (int x : getIntList()) {
				out.value(x);
			}
			out.endArray();
		}
		if (hasStringList()) {
			out.name(STRING_LIST);
			out.beginArray();
			for (String x : getStringList()) {
				out.value(x);
			}
			out.endArray();
		}
		if (hasStringIntMap()) {
			out.name(STRING_INT_MAP);
			out.beginObject();
			for (java.util.Map.Entry<String,Integer> entry : getStringIntMap().entrySet()) {
				out.name(entry.getKey());
				out.value(entry.getValue());
			}
			out.endObject();
		}
		if (hasOptionalDecision()) {
			out.name(OPTIONAL_DECISION);
			getOptionalDecision().writeTo(out);
		}
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case INT: setInt(in.nextInt()); break;
			case LONG: setLong(in.nextLong()); break;
			case BOOLEAN: setBoolean(in.nextBoolean()); break;
			case STRING: setString(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			case INT_LIST: {
				in.beginArray();
				while (in.hasNext()) {
					addIntList(in.nextInt());
				}
				in.endArray();
			}
			break;
			case STRING_LIST: {
				in.beginArray();
				while (in.hasNext()) {
					addStringList(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in));
				}
				in.endArray();
			}
			break;
			case STRING_INT_MAP: {
				in.beginObject();
				while (in.hasNext()) {
					putStringIntMap(in.nextName(), in.nextInt());
				}
				in.endObject();
				break;
			}
			case OPTIONAL_DECISION: setOptionalDecision(test.nullable.data.Decision.readDecision(in)); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		out.beginObject();
		writeFields(out);
		out.endObject();
	}

	/**
	 * Serializes all fields of this instance to the given binary output.
	 *
	 * @param out
	 *        The binary output to write to.
	 * @throws java.io.IOException If writing fails.
	 */
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		if (hasInt()) {
			out.name(INT__ID);
			out.value(getInt());
		}
		if (hasLong()) {
			out.name(LONG__ID);
			out.value(getLong());
		}
		if (hasBoolean()) {
			out.name(BOOLEAN__ID);
			out.value(getBoolean());
		}
		if (hasString()) {
			out.name(STRING__ID);
			out.value(getString());
		}
		if (hasIntList()) {
			out.name(INT_LIST__ID);
			{
				java.util.List<Integer> values = getIntList();
				out.beginArray(de.haumacher.msgbuf.binary.DataType.INT, values.size());
				for (int x : values) {
					out.value(x);
				}
				out.endArray();
			}
		}
		if (hasStringList()) {
			out.name(STRING_LIST__ID);
			{
				java.util.List<String> values = getStringList();
				out.beginArray(de.haumacher.msgbuf.binary.DataType.STRING, values.size());
				for (String x : values) {
					out.value(x);
				}
				out.endArray();
			}
		}
		if (hasStringIntMap()) {
			out.name(STRING_INT_MAP__ID);
		}
		if (hasOptionalDecision()) {
			out.name(OPTIONAL_DECISION__ID);
			getOptionalDecision().writeTo(out);
		}
	}

	/** Reads a new instance from the given reader. */
	public static NullableValues readNullableValues(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		NullableValues result = new NullableValues();
		while (in.hasNext()) {
			int field = in.nextName();
			result.readField(in, field);
		}
		in.endObject();
		return result;
	}

	/** Consumes the value for the field with the given ID and assigns its value. */
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case INT__ID: setInt(in.nextInt()); break;
			case LONG__ID: setLong(in.nextLong()); break;
			case BOOLEAN__ID: setBoolean(in.nextBoolean()); break;
			case STRING__ID: setString(in.nextString()); break;
			case INT_LIST__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addIntList(in.nextInt());
				}
				in.endArray();
			}
			break;
			case STRING_LIST__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addStringList(in.nextString());
				}
				in.endArray();
			}
			break;
			case STRING_INT_MAP__ID: {
				in.beginArray();
				while (in.hasNext()) {
					in.beginObject();
					String key = "";
					int value = 0;
					while (in.hasNext()) {
						switch (in.nextName()) {
							case 1: key = in.nextString(); break;
							case 2: value = in.nextInt(); break;
							default: in.skipValue(); break;
						}
					}
					putStringIntMap(key, value);
					in.endObject();
				}
				in.endArray();
				break;
			}
			case OPTIONAL_DECISION__ID: setOptionalDecision(test.nullable.data.Decision.readDecision(in)); break;
			default: in.skipValue(); 
		}
	}

}
