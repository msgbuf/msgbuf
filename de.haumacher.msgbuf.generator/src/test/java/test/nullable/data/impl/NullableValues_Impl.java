package test.nullable.data.impl;

/**
 * Implementation of {@link test.nullable.data.NullableValues}.
 */
public class NullableValues_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.nullable.data.NullableValues {

	private Integer _int = null;

	private Long _long = null;

	private Boolean _boolean = null;

	private String _string = null;

	private java.util.List<Integer> _intList = null;

	private java.util.List<String> _stringList = null;

	private java.util.Map<String, Integer> _stringIntMap = null;

	private test.nullable.data.Decision _optionalDecision = null;

	/**
	 * Creates a {@link NullableValues_Impl} instance.
	 *
	 * @see test.nullable.data.NullableValues#create()
	 */
	public NullableValues_Impl() {
		super();
	}

	@Override
	public final Integer getInt() {
		return _int;
	}

	@Override
	public test.nullable.data.NullableValues setInt(Integer value) {
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
	public test.nullable.data.NullableValues setLong(Long value) {
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
	public test.nullable.data.NullableValues setBoolean(Boolean value) {
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
	public test.nullable.data.NullableValues setString(String value) {
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
	public test.nullable.data.NullableValues setIntList(java.util.List<? extends Integer> value) {
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
	public test.nullable.data.NullableValues addIntList(int value) {
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
	public test.nullable.data.NullableValues setStringList(java.util.List<? extends String> value) {
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
	public test.nullable.data.NullableValues addStringList(String value) {
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
	public test.nullable.data.NullableValues setStringIntMap(java.util.Map<String, Integer> value) {
		internalSetStringIntMap(value);
		return this;
	}

	/** Internal setter for {@link #getStringIntMap()} without chain call utility. */
	protected final void internalSetStringIntMap(java.util.Map<String, Integer> value) {
		if (_stringIntMap == null) _stringIntMap = new java.util.LinkedHashMap<>();
		_stringIntMap.clear();
		_stringIntMap.putAll(value);
	}

	@Override
	public test.nullable.data.NullableValues putStringIntMap(String key, int value) {
		internalPutStringIntMap(key, value);
		return this;
	}

	/** Implementation of {@link #putStringIntMap(String, int)} without chain call utility. */
	protected final void  internalPutStringIntMap(String key, int value) {
		if (_stringIntMap == null) _stringIntMap = new java.util.LinkedHashMap<>();
		if (_stringIntMap.containsKey(key)) {
			throw new IllegalArgumentException("Property 'stringIntMap' already contains a value for key '" + key + "'.");
		}
		_stringIntMap.put(key, value);
	}

	@Override
	public final void removeStringIntMap(String key) {
		if (_stringIntMap == null) _stringIntMap = new java.util.LinkedHashMap<>();
		_stringIntMap.remove(key);
	}

	@Override
	public final boolean hasStringIntMap() {
		return _stringIntMap != null;
	}

	@Override
	public final test.nullable.data.Decision getOptionalDecision() {
		return _optionalDecision;
	}

	@Override
	public test.nullable.data.NullableValues setOptionalDecision(test.nullable.data.Decision value) {
		internalSetOptionalDecision(value);
		return this;
	}

	/** Internal setter for {@link #getOptionalDecision()} without chain call utility. */
	protected final void internalSetOptionalDecision(test.nullable.data.Decision value) {
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

	static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			INT__PROP, 
			LONG__PROP, 
			BOOLEAN__PROP, 
			STRING__PROP, 
			INT_LIST__PROP, 
			STRING_LIST__PROP, 
			STRING_INT_MAP__PROP, 
			OPTIONAL_DECISION__PROP);
		PROPERTIES = java.util.Collections.unmodifiableList(local);
	}

	static final java.util.Set<String> TRANSIENT_PROPERTIES;
	static {
		java.util.HashSet<String> tmp = new java.util.HashSet<>();
		tmp.addAll(java.util.Arrays.asList(
				));
		TRANSIENT_PROPERTIES = java.util.Collections.unmodifiableSet(tmp);
	}

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public java.util.Set<String> transientProperties() {
		return TRANSIENT_PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case INT__PROP: return getInt();
			case LONG__PROP: return getLong();
			case BOOLEAN__PROP: return getBoolean();
			case STRING__PROP: return getString();
			case INT_LIST__PROP: return getIntList();
			case STRING_LIST__PROP: return getStringList();
			case STRING_INT_MAP__PROP: return getStringIntMap();
			case OPTIONAL_DECISION__PROP: return getOptionalDecision();
			default: return test.nullable.data.NullableValues.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case INT__PROP: internalSetInt((Integer) value); break;
			case LONG__PROP: internalSetLong((Long) value); break;
			case BOOLEAN__PROP: internalSetBoolean((Boolean) value); break;
			case STRING__PROP: internalSetString((String) value); break;
			case INT_LIST__PROP: internalSetIntList(de.haumacher.msgbuf.util.Conversions.asList(Integer.class, value)); break;
			case STRING_LIST__PROP: internalSetStringList(de.haumacher.msgbuf.util.Conversions.asList(String.class, value)); break;
			case STRING_INT_MAP__PROP: internalSetStringIntMap((java.util.Map<String, Integer>) value); break;
			case OPTIONAL_DECISION__PROP: internalSetOptionalDecision((test.nullable.data.Decision) value); break;
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
			out.name(INT__PROP);
			out.value(getInt());
		}
		if (hasLong()) {
			out.name(LONG__PROP);
			out.value(getLong());
		}
		if (hasBoolean()) {
			out.name(BOOLEAN__PROP);
			out.value(getBoolean());
		}
		if (hasString()) {
			out.name(STRING__PROP);
			out.value(getString());
		}
		if (hasIntList()) {
			out.name(INT_LIST__PROP);
			out.beginArray();
			for (int x : getIntList()) {
				out.value(x);
			}
			out.endArray();
		}
		if (hasStringList()) {
			out.name(STRING_LIST__PROP);
			out.beginArray();
			for (String x : getStringList()) {
				out.value(x);
			}
			out.endArray();
		}
		if (hasStringIntMap()) {
			out.name(STRING_INT_MAP__PROP);
			out.beginObject();
			for (java.util.Map.Entry<String,Integer> entry : getStringIntMap().entrySet()) {
				out.name(entry.getKey());
				out.value(entry.getValue());
			}
			out.endObject();
		}
		if (hasOptionalDecision()) {
			out.name(OPTIONAL_DECISION__PROP);
			getOptionalDecision().writeTo(out);
		}
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case INT__PROP: setInt(in.nextInt()); break;
			case LONG__PROP: setLong(in.nextLong()); break;
			case BOOLEAN__PROP: setBoolean(in.nextBoolean()); break;
			case STRING__PROP: setString(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			case INT_LIST__PROP: {
				java.util.List<Integer> newValue = new java.util.ArrayList<>();
				in.beginArray();
				while (in.hasNext()) {
					newValue.add(in.nextInt());
				}
				in.endArray();
				setIntList(newValue);
			}
			break;
			case STRING_LIST__PROP: {
				java.util.List<String> newValue = new java.util.ArrayList<>();
				in.beginArray();
				while (in.hasNext()) {
					newValue.add(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in));
				}
				in.endArray();
				setStringList(newValue);
			}
			break;
			case STRING_INT_MAP__PROP: {
				java.util.Map<String, Integer> newValue = new java.util.LinkedHashMap<>();
				in.beginObject();
				while (in.hasNext()) {
					newValue.put(in.nextName(), in.nextInt());
				}
				in.endObject();
				setStringIntMap(newValue);
				break;
			}
			case OPTIONAL_DECISION__PROP: setOptionalDecision(test.nullable.data.Decision.readDecision(in)); break;
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

	/** Helper for creating an object of type {@link test.nullable.data.NullableValues} from a polymorphic composition. */
	public static test.nullable.data.NullableValues readNullableValues_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.nullable.data.impl.NullableValues_Impl result = new NullableValues_Impl();
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

	/** XML element name representing a {@link test.nullable.data.NullableValues} type. */
	public static final String NULLABLE_VALUES__XML_ELEMENT = "nullable-values";

	/** XML attribute or element name of a {@link #getInt} property. */
	private static final String INT__XML_ATTR = "int";

	/** XML attribute or element name of a {@link #getLong} property. */
	private static final String LONG__XML_ATTR = "long";

	/** XML attribute or element name of a {@link #getBoolean} property. */
	private static final String BOOLEAN__XML_ATTR = "boolean";

	/** XML attribute or element name of a {@link #getString} property. */
	private static final String STRING__XML_ATTR = "string";

	/** XML attribute or element name of a {@link #getIntList} property. */
	private static final String INT_LIST__XML_ATTR = "int-list";

	/** XML attribute or element name of a {@link #getStringList} property. */
	private static final String STRING_LIST__XML_ATTR = "string-list";

	/** XML attribute or element name of a {@link #getStringIntMap} property. */
	private static final String STRING_INT_MAP__XML_ATTR = "string-int-map";

	/** XML attribute or element name of a {@link #getOptionalDecision} property. */
	private static final String OPTIONAL_DECISION__XML_ATTR = "optional-decision";

	@Override
	public String getXmlTagName() {
		return NULLABLE_VALUES__XML_ELEMENT;
	}

	@Override
	public final void writeContent(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		writeAttributes(out);
		writeElements(out);
	}

	/** Serializes all fields that are written as XML attributes. */
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		out.writeAttribute(INT__XML_ATTR, Integer.toString(getInt()));
		out.writeAttribute(LONG__XML_ATTR, Long.toString(getLong()));
		out.writeAttribute(BOOLEAN__XML_ATTR, Boolean.toString(getBoolean()));
		out.writeAttribute(STRING__XML_ATTR, getString());
		out.writeAttribute(INT_LIST__XML_ATTR, getIntList().stream().map(x -> Integer.toString(x)).collect(java.util.stream.Collectors.joining(", ")));
		out.writeAttribute(STRING_LIST__XML_ATTR, getStringList().stream().map(x -> x).collect(java.util.stream.Collectors.joining(", ")));
		out.writeAttribute(OPTIONAL_DECISION__XML_ATTR, getOptionalDecision().protocolName());
	}

	/** Serializes all fields that are written as XML elements. */
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		// No element fields.
	}

	/** Creates a new {@link test.nullable.data.NullableValues} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static NullableValues_Impl readNullableValues_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		NullableValues_Impl result = new NullableValues_Impl();
		result.readContentXml(in);
		return result;
	}

	/** Reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	protected final void readContentXml(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		for (int n = 0, cnt = in.getAttributeCount(); n < cnt; n++) {
			String name = in.getAttributeLocalName(n);
			String value = in.getAttributeValue(n);

			readFieldXmlAttribute(name, value);
		}
		while (true) {
			int event = in.nextTag();
			if (event == javax.xml.stream.XMLStreamConstants.END_ELEMENT) {
				break;
			}
			assert event == javax.xml.stream.XMLStreamConstants.START_ELEMENT;

			String localName = in.getLocalName();
			readFieldXmlElement(in, localName);
		}
	}

	/** Parses the given attribute value and assigns it to the field with the given name. */
	protected void readFieldXmlAttribute(String name, String value) {
		switch (name) {
			case INT__XML_ATTR: {
				setInt(Integer.parseInt(value));
				break;
			}
			case LONG__XML_ATTR: {
				setLong(Long.parseLong(value));
				break;
			}
			case BOOLEAN__XML_ATTR: {
				setBoolean(Boolean.parseBoolean(value));
				break;
			}
			case STRING__XML_ATTR: {
				setString(value);
				break;
			}
			case INT_LIST__XML_ATTR: {
				setIntList(java.util.Arrays.stream(value.split("\\s*,\\s*")).map(x -> Integer.parseInt(x)).collect(java.util.stream.Collectors.toList()));
				break;
			}
			case STRING_LIST__XML_ATTR: {
				setStringList(java.util.Arrays.stream(value.split("\\s*,\\s*")).map(x -> x).collect(java.util.stream.Collectors.toList()));
				break;
			}
			case OPTIONAL_DECISION__XML_ATTR: {
				setOptionalDecision(test.nullable.data.Decision.valueOfProtocol(value));
				break;
			}
			default: {
				// Skip unknown attribute.
			}
		}
	}

	/** Reads the element under the cursor and assigns its contents to the field with the given name. */
	protected void readFieldXmlElement(javax.xml.stream.XMLStreamReader in, String localName) throws javax.xml.stream.XMLStreamException {
		switch (localName) {
			case INT__XML_ATTR: {
				setInt(Integer.parseInt(in.getElementText()));
				break;
			}
			case LONG__XML_ATTR: {
				setLong(Long.parseLong(in.getElementText()));
				break;
			}
			case BOOLEAN__XML_ATTR: {
				setBoolean(Boolean.parseBoolean(in.getElementText()));
				break;
			}
			case STRING__XML_ATTR: {
				setString(in.getElementText());
				break;
			}
			case INT_LIST__XML_ATTR: {
				setIntList(java.util.Arrays.stream(in.getElementText().split("\\s*,\\s*")).map(x -> Integer.parseInt(x)).collect(java.util.stream.Collectors.toList()));
				break;
			}
			case STRING_LIST__XML_ATTR: {
				setStringList(java.util.Arrays.stream(in.getElementText().split("\\s*,\\s*")).map(x -> x).collect(java.util.stream.Collectors.toList()));
				break;
			}
			case OPTIONAL_DECISION__XML_ATTR: {
				setOptionalDecision(test.nullable.data.Decision.valueOfProtocol(in.getElementText()));
				break;
			}
			default: {
				internalSkipUntilMatchingEndElement(in);
			}
		}
	}

	protected static final void internalSkipUntilMatchingEndElement(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		int level = 0;
		while (true) {
			switch (in.next()) {
				case javax.xml.stream.XMLStreamConstants.START_ELEMENT: level++; break;
				case javax.xml.stream.XMLStreamConstants.END_ELEMENT: if (level == 0) { return; } else { level--; break; }
			}
		}
	}

}
