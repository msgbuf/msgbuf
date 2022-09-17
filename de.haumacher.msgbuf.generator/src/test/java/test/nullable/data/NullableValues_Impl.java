package test.nullable.data;

class NullableValues_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements NullableValues {

	private Integer _int = null;

	private Long _long = null;

	private Boolean _boolean = null;

	private String _string = null;

	private java.util.List<Integer> _intList = null;

	private java.util.List<String> _stringList = null;

	private java.util.Map<String, Integer> _stringIntMap = null;

	private Decision _optionalDecision = null;

	/**
	 * Creates a {@link NullableValues_Impl} instance.
	 *
	 * @see NullableValues#create()
	 */
	protected NullableValues_Impl() {
		super();
	}

	@Override
	public final Integer getInt() {
		return _int;
	}

	@Override
	public NullableValues setInt(Integer value) {
		internalSetInt(value);
		return this;
	}

	/** Internal setter for {@link #getInt()} without chain call utility. */
	protected final void internalSetInt(Integer value) {
		_int = value;
	}

	@Override
	public final boolean hasInt() {
		return _int != null;
	}

	@Override
	public final Long getLong() {
		return _long;
	}

	@Override
	public NullableValues setLong(Long value) {
		internalSetLong(value);
		return this;
	}

	/** Internal setter for {@link #getLong()} without chain call utility. */
	protected final void internalSetLong(Long value) {
		_long = value;
	}

	@Override
	public final boolean hasLong() {
		return _long != null;
	}

	@Override
	public final Boolean getBoolean() {
		return _boolean;
	}

	@Override
	public NullableValues setBoolean(Boolean value) {
		internalSetBoolean(value);
		return this;
	}

	/** Internal setter for {@link #getBoolean()} without chain call utility. */
	protected final void internalSetBoolean(Boolean value) {
		_boolean = value;
	}

	@Override
	public final boolean hasBoolean() {
		return _boolean != null;
	}

	@Override
	public final String getString() {
		return _string;
	}

	@Override
	public NullableValues setString(String value) {
		internalSetString(value);
		return this;
	}

	/** Internal setter for {@link #getString()} without chain call utility. */
	protected final void internalSetString(String value) {
		_string = value;
	}

	@Override
	public final boolean hasString() {
		return _string != null;
	}

	@Override
	public final java.util.List<Integer> getIntList() {
		return _intList;
	}

	@Override
	public NullableValues setIntList(java.util.List<? extends Integer> value) {
		internalSetIntList(value);
		return this;
	}

	/** Internal setter for {@link #getIntList()} without chain call utility. */
	protected final void internalSetIntList(java.util.List<? extends Integer> value) {
		if (_intList == null) _intList = new java.util.ArrayList<>();
		_intList.clear();
		_intList.addAll(value);
	}

	@Override
	public NullableValues addIntList(int value) {
		internalAddIntList(value);
		return this;
	}

	/** Implementation of {@link #addIntList(int)} without chain call utility. */
	protected final void internalAddIntList(int value) {
		if (_intList == null) _intList = new java.util.ArrayList<>();
		_intList.add(value);
	}

	@Override
	public final void removeIntList(int value) {
		if (_intList == null) _intList = new java.util.ArrayList<>();
		_intList.remove(value);
	}

	@Override
	public final boolean hasIntList() {
		return _intList != null;
	}

	@Override
	public final java.util.List<String> getStringList() {
		return _stringList;
	}

	@Override
	public NullableValues setStringList(java.util.List<? extends String> value) {
		internalSetStringList(value);
		return this;
	}

	/** Internal setter for {@link #getStringList()} without chain call utility. */
	protected final void internalSetStringList(java.util.List<? extends String> value) {
		if (_stringList == null) _stringList = new java.util.ArrayList<>();
		_stringList.clear();
		_stringList.addAll(value);
	}

	@Override
	public NullableValues addStringList(String value) {
		internalAddStringList(value);
		return this;
	}

	/** Implementation of {@link #addStringList(String)} without chain call utility. */
	protected final void internalAddStringList(String value) {
		if (_stringList == null) _stringList = new java.util.ArrayList<>();
		_stringList.add(value);
	}

	@Override
	public final void removeStringList(String value) {
		if (_stringList == null) _stringList = new java.util.ArrayList<>();
		_stringList.remove(value);
	}

	@Override
	public final boolean hasStringList() {
		return _stringList != null;
	}

	@Override
	public final java.util.Map<String, Integer> getStringIntMap() {
		return _stringIntMap;
	}

	@Override
	public NullableValues setStringIntMap(java.util.Map<String, Integer> value) {
		internalSetStringIntMap(value);
		return this;
	}

	/** Internal setter for {@link #getStringIntMap()} without chain call utility. */
	protected final void internalSetStringIntMap(java.util.Map<String, Integer> value) {
		if (_stringIntMap == null) _stringIntMap = new java.util.HashMap<>();
		_stringIntMap.clear();
		_stringIntMap.putAll(value);
	}

	@Override
	public NullableValues putStringIntMap(String key, int value) {
		internalPutStringIntMap(key, value);
		return this;
	}

	/** Implementation of {@link #putStringIntMap(String, int)} without chain call utility. */
	protected final void  internalPutStringIntMap(String key, int value) {
		if (_stringIntMap == null) _stringIntMap = new java.util.HashMap<>();
		if (_stringIntMap.containsKey(key)) {
			throw new IllegalArgumentException("Property 'stringIntMap' already contains a value for key '" + key + "'.");
		}
		_stringIntMap.put(key, value);
	}

	@Override
	public final void removeStringIntMap(String key) {
		if (_stringIntMap == null) _stringIntMap = new java.util.HashMap<>();
		_stringIntMap.remove(key);
	}

	@Override
	public final boolean hasStringIntMap() {
		return _stringIntMap != null;
	}

	@Override
	public final Decision getOptionalDecision() {
		return _optionalDecision;
	}

	@Override
	public NullableValues setOptionalDecision(Decision value) {
		internalSetOptionalDecision(value);
		return this;
	}

	/** Internal setter for {@link #getOptionalDecision()} without chain call utility. */
	protected final void internalSetOptionalDecision(Decision value) {
		_optionalDecision = value;
	}

	@Override
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
			default: return NullableValues.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case INT: internalSetInt((Integer) value); break;
			case LONG: internalSetLong((Long) value); break;
			case BOOLEAN: internalSetBoolean((Boolean) value); break;
			case STRING: internalSetString((String) value); break;
			case INT_LIST: internalSetIntList(de.haumacher.msgbuf.util.Conversions.asList(Integer.class, value)); break;
			case STRING_LIST: internalSetStringList(de.haumacher.msgbuf.util.Conversions.asList(String.class, value)); break;
			case STRING_INT_MAP: internalSetStringIntMap((java.util.Map<String, Integer>) value); break;
			case OPTIONAL_DECISION: internalSetOptionalDecision((Decision) value); break;
		}
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

	/** Helper for creating an object of type {@link NullableValues} from a polymorphic composition. */
	public static NullableValues readNullableValues_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.nullable.data.NullableValues_Impl result = new NullableValues_Impl();
		result.readContent(in);
		return result;
	}

	/** Helper for reading all fields of this instance. */
	protected final void readContent(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		while (in.hasNext()) {
			int field = in.nextName();
			readField(in, field);
		}
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
