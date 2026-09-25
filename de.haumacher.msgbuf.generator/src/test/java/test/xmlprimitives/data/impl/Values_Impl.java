package test.xmlprimitives.data.impl;

/**
 * Implementation of {@link test.xmlprimitives.data.Values}.
 */
public class Values_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.xmlprimitives.data.Values {

	private boolean _vBool = false;

	private int _vInt32 = 0;

	private int _vSint32 = 0;

	private int _vUint32 = 0;

	private int _vFixed32 = 0;

	private int _vSfixed32 = 0;

	private long _vInt64 = 0L;

	private long _vSint64 = 0L;

	private long _vUint64 = 0L;

	private long _vFixed64 = 0L;

	private long _vSfixed64 = 0L;

	private float _vFloat = 0.0f;

	private double _vDouble = 0.0d;

	private String _vString = "";

	private byte[] _vBytes = null;

	private Object _vJson = null;

	private test.xmlprimitives.data.Color _vColor = test.xmlprimitives.data.Color.RED;

	/**
	 * Creates a {@link Values_Impl} instance.
	 *
	 * @see test.xmlprimitives.data.Values#create()
	 */
	public Values_Impl() {
		super();
	}

	@Override
	public final boolean isVBool() {
		return _vBool;
	}

	@Override
	public test.xmlprimitives.data.Values setVBool(boolean value) {
		internalSetVBool(value);
		return this;
	}

	/** Internal setter for {@link #isVBool()} without chain call utility. */
	protected final void internalSetVBool(boolean value) {
		_listener.beforeSet(this, V_BOOL__PROP, value);
		_vBool = value;
		_listener.afterChanged(this, V_BOOL__PROP);
	}

	@Override
	public final int getVInt32() {
		return _vInt32;
	}

	@Override
	public test.xmlprimitives.data.Values setVInt32(int value) {
		internalSetVInt32(value);
		return this;
	}

	/** Internal setter for {@link #getVInt32()} without chain call utility. */
	protected final void internalSetVInt32(int value) {
		_listener.beforeSet(this, V_INT_32__PROP, value);
		_vInt32 = value;
		_listener.afterChanged(this, V_INT_32__PROP);
	}

	@Override
	public final int getVSint32() {
		return _vSint32;
	}

	@Override
	public test.xmlprimitives.data.Values setVSint32(int value) {
		internalSetVSint32(value);
		return this;
	}

	/** Internal setter for {@link #getVSint32()} without chain call utility. */
	protected final void internalSetVSint32(int value) {
		_listener.beforeSet(this, V_SINT_32__PROP, value);
		_vSint32 = value;
		_listener.afterChanged(this, V_SINT_32__PROP);
	}

	@Override
	public final int getVUint32() {
		return _vUint32;
	}

	@Override
	public test.xmlprimitives.data.Values setVUint32(int value) {
		internalSetVUint32(value);
		return this;
	}

	/** Internal setter for {@link #getVUint32()} without chain call utility. */
	protected final void internalSetVUint32(int value) {
		_listener.beforeSet(this, V_UINT_32__PROP, value);
		_vUint32 = value;
		_listener.afterChanged(this, V_UINT_32__PROP);
	}

	@Override
	public final int getVFixed32() {
		return _vFixed32;
	}

	@Override
	public test.xmlprimitives.data.Values setVFixed32(int value) {
		internalSetVFixed32(value);
		return this;
	}

	/** Internal setter for {@link #getVFixed32()} without chain call utility. */
	protected final void internalSetVFixed32(int value) {
		_listener.beforeSet(this, V_FIXED_32__PROP, value);
		_vFixed32 = value;
		_listener.afterChanged(this, V_FIXED_32__PROP);
	}

	@Override
	public final int getVSfixed32() {
		return _vSfixed32;
	}

	@Override
	public test.xmlprimitives.data.Values setVSfixed32(int value) {
		internalSetVSfixed32(value);
		return this;
	}

	/** Internal setter for {@link #getVSfixed32()} without chain call utility. */
	protected final void internalSetVSfixed32(int value) {
		_listener.beforeSet(this, V_SFIXED_32__PROP, value);
		_vSfixed32 = value;
		_listener.afterChanged(this, V_SFIXED_32__PROP);
	}

	@Override
	public final long getVInt64() {
		return _vInt64;
	}

	@Override
	public test.xmlprimitives.data.Values setVInt64(long value) {
		internalSetVInt64(value);
		return this;
	}

	/** Internal setter for {@link #getVInt64()} without chain call utility. */
	protected final void internalSetVInt64(long value) {
		_listener.beforeSet(this, V_INT_64__PROP, value);
		_vInt64 = value;
		_listener.afterChanged(this, V_INT_64__PROP);
	}

	@Override
	public final long getVSint64() {
		return _vSint64;
	}

	@Override
	public test.xmlprimitives.data.Values setVSint64(long value) {
		internalSetVSint64(value);
		return this;
	}

	/** Internal setter for {@link #getVSint64()} without chain call utility. */
	protected final void internalSetVSint64(long value) {
		_listener.beforeSet(this, V_SINT_64__PROP, value);
		_vSint64 = value;
		_listener.afterChanged(this, V_SINT_64__PROP);
	}

	@Override
	public final long getVUint64() {
		return _vUint64;
	}

	@Override
	public test.xmlprimitives.data.Values setVUint64(long value) {
		internalSetVUint64(value);
		return this;
	}

	/** Internal setter for {@link #getVUint64()} without chain call utility. */
	protected final void internalSetVUint64(long value) {
		_listener.beforeSet(this, V_UINT_64__PROP, value);
		_vUint64 = value;
		_listener.afterChanged(this, V_UINT_64__PROP);
	}

	@Override
	public final long getVFixed64() {
		return _vFixed64;
	}

	@Override
	public test.xmlprimitives.data.Values setVFixed64(long value) {
		internalSetVFixed64(value);
		return this;
	}

	/** Internal setter for {@link #getVFixed64()} without chain call utility. */
	protected final void internalSetVFixed64(long value) {
		_listener.beforeSet(this, V_FIXED_64__PROP, value);
		_vFixed64 = value;
		_listener.afterChanged(this, V_FIXED_64__PROP);
	}

	@Override
	public final long getVSfixed64() {
		return _vSfixed64;
	}

	@Override
	public test.xmlprimitives.data.Values setVSfixed64(long value) {
		internalSetVSfixed64(value);
		return this;
	}

	/** Internal setter for {@link #getVSfixed64()} without chain call utility. */
	protected final void internalSetVSfixed64(long value) {
		_listener.beforeSet(this, V_SFIXED_64__PROP, value);
		_vSfixed64 = value;
		_listener.afterChanged(this, V_SFIXED_64__PROP);
	}

	@Override
	public final float getVFloat() {
		return _vFloat;
	}

	@Override
	public test.xmlprimitives.data.Values setVFloat(float value) {
		internalSetVFloat(value);
		return this;
	}

	/** Internal setter for {@link #getVFloat()} without chain call utility. */
	protected final void internalSetVFloat(float value) {
		_listener.beforeSet(this, V_FLOAT__PROP, value);
		_vFloat = value;
		_listener.afterChanged(this, V_FLOAT__PROP);
	}

	@Override
	public final double getVDouble() {
		return _vDouble;
	}

	@Override
	public test.xmlprimitives.data.Values setVDouble(double value) {
		internalSetVDouble(value);
		return this;
	}

	/** Internal setter for {@link #getVDouble()} without chain call utility. */
	protected final void internalSetVDouble(double value) {
		_listener.beforeSet(this, V_DOUBLE__PROP, value);
		_vDouble = value;
		_listener.afterChanged(this, V_DOUBLE__PROP);
	}

	@Override
	public final String getVString() {
		return _vString;
	}

	@Override
	public test.xmlprimitives.data.Values setVString(String value) {
		internalSetVString(value);
		return this;
	}

	/** Internal setter for {@link #getVString()} without chain call utility. */
	protected final void internalSetVString(String value) {
		_listener.beforeSet(this, V_STRING__PROP, value);
		_vString = value;
		_listener.afterChanged(this, V_STRING__PROP);
	}

	@Override
	public final byte[] getVBytes() {
		return _vBytes;
	}

	@Override
	public test.xmlprimitives.data.Values setVBytes(byte[] value) {
		internalSetVBytes(value);
		return this;
	}

	/** Internal setter for {@link #getVBytes()} without chain call utility. */
	protected final void internalSetVBytes(byte[] value) {
		_listener.beforeSet(this, V_BYTES__PROP, value);
		_vBytes = value;
		_listener.afterChanged(this, V_BYTES__PROP);
	}

	@Override
	public final Object getVJson() {
		return _vJson;
	}

	@Override
	public test.xmlprimitives.data.Values setVJson(Object value) {
		internalSetVJson(value);
		return this;
	}

	/** Internal setter for {@link #getVJson()} without chain call utility. */
	protected final void internalSetVJson(Object value) {
		_listener.beforeSet(this, V_JSON__PROP, value);
		_vJson = value;
		_listener.afterChanged(this, V_JSON__PROP);
	}

	@Override
	public final boolean hasVJson() {
		return _vJson != null;
	}

	@Override
	public final test.xmlprimitives.data.Color getVColor() {
		return _vColor;
	}

	@Override
	public test.xmlprimitives.data.Values setVColor(test.xmlprimitives.data.Color value) {
		internalSetVColor(value);
		return this;
	}

	/** Internal setter for {@link #getVColor()} without chain call utility. */
	protected final void internalSetVColor(test.xmlprimitives.data.Color value) {
		if (value == null) throw new IllegalArgumentException("Property 'vColor' cannot be null.");
		_listener.beforeSet(this, V_COLOR__PROP, value);
		_vColor = value;
		_listener.afterChanged(this, V_COLOR__PROP);
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.xmlprimitives.data.Values registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.xmlprimitives.data.Values unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		internalUnregisterListener(l);
		return this;
	}

	protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
	}

	@Override
	public String jsonType() {
		return VALUES__TYPE;
	}

	static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			V_BOOL__PROP, 
			V_INT_32__PROP, 
			V_SINT_32__PROP, 
			V_UINT_32__PROP, 
			V_FIXED_32__PROP, 
			V_SFIXED_32__PROP, 
			V_INT_64__PROP, 
			V_SINT_64__PROP, 
			V_UINT_64__PROP, 
			V_FIXED_64__PROP, 
			V_SFIXED_64__PROP, 
			V_FLOAT__PROP, 
			V_DOUBLE__PROP, 
			V_STRING__PROP, 
			V_BYTES__PROP, 
			V_JSON__PROP, 
			V_COLOR__PROP);
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
			case V_BOOL__PROP: return isVBool();
			case V_INT_32__PROP: return getVInt32();
			case V_SINT_32__PROP: return getVSint32();
			case V_UINT_32__PROP: return getVUint32();
			case V_FIXED_32__PROP: return getVFixed32();
			case V_SFIXED_32__PROP: return getVSfixed32();
			case V_INT_64__PROP: return getVInt64();
			case V_SINT_64__PROP: return getVSint64();
			case V_UINT_64__PROP: return getVUint64();
			case V_FIXED_64__PROP: return getVFixed64();
			case V_SFIXED_64__PROP: return getVSfixed64();
			case V_FLOAT__PROP: return getVFloat();
			case V_DOUBLE__PROP: return getVDouble();
			case V_STRING__PROP: return getVString();
			case V_BYTES__PROP: return getVBytes();
			case V_JSON__PROP: return getVJson();
			case V_COLOR__PROP: return getVColor();
			default: return test.xmlprimitives.data.Values.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case V_BOOL__PROP: internalSetVBool((boolean) value); break;
			case V_INT_32__PROP: internalSetVInt32((int) value); break;
			case V_SINT_32__PROP: internalSetVSint32((int) value); break;
			case V_UINT_32__PROP: internalSetVUint32((int) value); break;
			case V_FIXED_32__PROP: internalSetVFixed32((int) value); break;
			case V_SFIXED_32__PROP: internalSetVSfixed32((int) value); break;
			case V_INT_64__PROP: internalSetVInt64((long) value); break;
			case V_SINT_64__PROP: internalSetVSint64((long) value); break;
			case V_UINT_64__PROP: internalSetVUint64((long) value); break;
			case V_FIXED_64__PROP: internalSetVFixed64((long) value); break;
			case V_SFIXED_64__PROP: internalSetVSfixed64((long) value); break;
			case V_FLOAT__PROP: internalSetVFloat((float) value); break;
			case V_DOUBLE__PROP: internalSetVDouble((double) value); break;
			case V_STRING__PROP: internalSetVString((String) value); break;
			case V_BYTES__PROP: internalSetVBytes((byte[]) value); break;
			case V_JSON__PROP: internalSetVJson((Object) value); break;
			case V_COLOR__PROP: internalSetVColor((test.xmlprimitives.data.Color) value); break;
		}
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(V_BOOL__PROP);
		out.value(isVBool());
		out.name(V_INT_32__PROP);
		out.value(getVInt32());
		out.name(V_SINT_32__PROP);
		out.value(getVSint32());
		out.name(V_UINT_32__PROP);
		out.value(getVUint32());
		out.name(V_FIXED_32__PROP);
		out.value(getVFixed32());
		out.name(V_SFIXED_32__PROP);
		out.value(getVSfixed32());
		out.name(V_INT_64__PROP);
		out.value(getVInt64());
		out.name(V_SINT_64__PROP);
		out.value(getVSint64());
		out.name(V_UINT_64__PROP);
		out.value(getVUint64());
		out.name(V_FIXED_64__PROP);
		out.value(getVFixed64());
		out.name(V_SFIXED_64__PROP);
		out.value(getVSfixed64());
		out.name(V_FLOAT__PROP);
		out.value(getVFloat());
		out.name(V_DOUBLE__PROP);
		out.value(getVDouble());
		out.name(V_STRING__PROP);
		out.value(getVString());
		out.name(V_BYTES__PROP);
		de.haumacher.msgbuf.json.JsonUtil.writeBinaryOptional(out, getVBytes());
		if (hasVJson()) {
			out.name(V_JSON__PROP);
			de.haumacher.msgbuf.json.JsonUtil.writeJsonValue(out, getVJson());
		}
		out.name(V_COLOR__PROP);
		getVColor().writeTo(out);
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case V_BOOL__PROP: setVBool(in.nextBoolean()); break;
			case V_INT_32__PROP: setVInt32(in.nextInt()); break;
			case V_SINT_32__PROP: setVSint32(in.nextInt()); break;
			case V_UINT_32__PROP: setVUint32(in.nextInt()); break;
			case V_FIXED_32__PROP: setVFixed32(in.nextInt()); break;
			case V_SFIXED_32__PROP: setVSfixed32(in.nextInt()); break;
			case V_INT_64__PROP: setVInt64(in.nextLong()); break;
			case V_SINT_64__PROP: setVSint64(in.nextLong()); break;
			case V_UINT_64__PROP: setVUint64(in.nextLong()); break;
			case V_FIXED_64__PROP: setVFixed64(in.nextLong()); break;
			case V_SFIXED_64__PROP: setVSfixed64(in.nextLong()); break;
			case V_FLOAT__PROP: setVFloat((float) in.nextDouble()); break;
			case V_DOUBLE__PROP: setVDouble(in.nextDouble()); break;
			case V_STRING__PROP: setVString(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			case V_BYTES__PROP: setVBytes(de.haumacher.msgbuf.json.JsonUtil.nextBinaryOptional(in)); break;
			case V_JSON__PROP: setVJson(de.haumacher.msgbuf.json.JsonUtil.nextJsonValue(in)); break;
			case V_COLOR__PROP: setVColor(test.xmlprimitives.data.Color.readColor(in)); break;
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
		out.name(V_BOOL__ID);
		out.value(isVBool());
		out.name(V_INT_32__ID);
		out.value(getVInt32());
		out.name(V_SINT_32__ID);
		out.valueSigned(getVSint32());
		out.name(V_UINT_32__ID);
		out.value(getVUint32());
		out.name(V_FIXED_32__ID);
		out.valueFixed(getVFixed32());
		out.name(V_SFIXED_32__ID);
		out.valueFixed(getVSfixed32());
		out.name(V_INT_64__ID);
		out.value(getVInt64());
		out.name(V_SINT_64__ID);
		out.valueSigned(getVSint64());
		out.name(V_UINT_64__ID);
		out.value(getVUint64());
		out.name(V_FIXED_64__ID);
		out.valueFixed(getVFixed64());
		out.name(V_SFIXED_64__ID);
		out.valueFixed(getVSfixed64());
		out.name(V_FLOAT__ID);
		out.value(getVFloat());
		out.name(V_DOUBLE__ID);
		out.value(getVDouble());
		out.name(V_STRING__ID);
		out.value(getVString());
		if (getVBytes() != null) {
			out.name(V_BYTES__ID);
			out.value(getVBytes());
		}
		if (hasVJson()) {
			out.name(V_JSON__ID);
			de.haumacher.msgbuf.json.JsonUtil.toJsonValue(getVJson()).writeTo(out);
		}
		out.name(V_COLOR__ID);
		getVColor().writeTo(out);
	}

	/** Helper for creating an object of type {@link test.xmlprimitives.data.Values} from a polymorphic composition. */
	public static test.xmlprimitives.data.Values readValues_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.xmlprimitives.data.impl.Values_Impl result = new Values_Impl();
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
			case V_BOOL__ID: setVBool(in.nextBoolean()); break;
			case V_INT_32__ID: setVInt32(in.nextInt()); break;
			case V_SINT_32__ID: setVSint32(in.nextIntSigned()); break;
			case V_UINT_32__ID: setVUint32(in.nextInt()); break;
			case V_FIXED_32__ID: setVFixed32(in.nextIntFixed()); break;
			case V_SFIXED_32__ID: setVSfixed32(in.nextIntFixed()); break;
			case V_INT_64__ID: setVInt64(in.nextLong()); break;
			case V_SINT_64__ID: setVSint64(in.nextLongSigned()); break;
			case V_UINT_64__ID: setVUint64(in.nextLong()); break;
			case V_FIXED_64__ID: setVFixed64(in.nextLongFixed()); break;
			case V_SFIXED_64__ID: setVSfixed64(in.nextLongFixed()); break;
			case V_FLOAT__ID: setVFloat(in.nextFloat()); break;
			case V_DOUBLE__ID: setVDouble(in.nextDouble()); break;
			case V_STRING__ID: setVString(in.nextString()); break;
			case V_BYTES__ID: setVBytes(in.nextBinary()); break;
			case V_JSON__ID: setVJson(de.haumacher.msgbuf.json.JsonUtil.fromJsonValue(de.haumacher.msgbuf.json.value.JsonValue.readJsonValue(in))); break;
			case V_COLOR__ID: setVColor(test.xmlprimitives.data.Color.readColor(in)); break;
			default: in.skipValue(); 
		}
	}

	/** XML element name representing a {@link test.xmlprimitives.data.Values} type. */
	public static final String VALUES__XML_ELEMENT = "values";

	/** XML attribute or element name of a {@link #isVBool} property. */
	private static final String V_BOOL__XML_ATTR = "v-bool";

	/** XML attribute or element name of a {@link #getVInt32} property. */
	private static final String V_INT_32__XML_ATTR = "v-int-32";

	/** XML attribute or element name of a {@link #getVSint32} property. */
	private static final String V_SINT_32__XML_ATTR = "v-sint-32";

	/** XML attribute or element name of a {@link #getVUint32} property. */
	private static final String V_UINT_32__XML_ATTR = "v-uint-32";

	/** XML attribute or element name of a {@link #getVFixed32} property. */
	private static final String V_FIXED_32__XML_ATTR = "v-fixed-32";

	/** XML attribute or element name of a {@link #getVSfixed32} property. */
	private static final String V_SFIXED_32__XML_ATTR = "v-sfixed-32";

	/** XML attribute or element name of a {@link #getVInt64} property. */
	private static final String V_INT_64__XML_ATTR = "v-int-64";

	/** XML attribute or element name of a {@link #getVSint64} property. */
	private static final String V_SINT_64__XML_ATTR = "v-sint-64";

	/** XML attribute or element name of a {@link #getVUint64} property. */
	private static final String V_UINT_64__XML_ATTR = "v-uint-64";

	/** XML attribute or element name of a {@link #getVFixed64} property. */
	private static final String V_FIXED_64__XML_ATTR = "v-fixed-64";

	/** XML attribute or element name of a {@link #getVSfixed64} property. */
	private static final String V_SFIXED_64__XML_ATTR = "v-sfixed-64";

	/** XML attribute or element name of a {@link #getVFloat} property. */
	private static final String V_FLOAT__XML_ATTR = "v-float";

	/** XML attribute or element name of a {@link #getVDouble} property. */
	private static final String V_DOUBLE__XML_ATTR = "v-double";

	/** XML attribute or element name of a {@link #getVString} property. */
	private static final String V_STRING__XML_ATTR = "v-string";

	/** XML attribute or element name of a {@link #getVBytes} property. */
	private static final String V_BYTES__XML_ATTR = "v-bytes";

	/** XML attribute or element name of a {@link #getVJson} property. */
	private static final String V_JSON__XML_ATTR = "v-json";

	/** XML attribute or element name of a {@link #getVColor} property. */
	private static final String V_COLOR__XML_ATTR = "v-color";

	@Override
	public String getXmlTagName() {
		return VALUES__XML_ELEMENT;
	}

	@Override
	public final void writeContent(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		writeAttributes(out);
		writeElements(out);
	}

	/** Serializes all fields that are written as XML attributes. */
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		out.writeAttribute(V_BOOL__XML_ATTR, Boolean.toString(isVBool()));
		out.writeAttribute(V_INT_32__XML_ATTR, Integer.toString(getVInt32()));
		out.writeAttribute(V_SINT_32__XML_ATTR, Integer.toString(getVSint32()));
		out.writeAttribute(V_UINT_32__XML_ATTR, Long.toString(Integer.toUnsignedLong(getVUint32())));
		out.writeAttribute(V_FIXED_32__XML_ATTR, Long.toString(Integer.toUnsignedLong(getVFixed32())));
		out.writeAttribute(V_SFIXED_32__XML_ATTR, Integer.toString(getVSfixed32()));
		out.writeAttribute(V_INT_64__XML_ATTR, Long.toString(getVInt64()));
		out.writeAttribute(V_SINT_64__XML_ATTR, Long.toString(getVSint64()));
		out.writeAttribute(V_UINT_64__XML_ATTR, Long.toString(getVUint64()));
		out.writeAttribute(V_FIXED_64__XML_ATTR, Long.toString(getVFixed64()));
		out.writeAttribute(V_SFIXED_64__XML_ATTR, Long.toString(getVSfixed64()));
		out.writeAttribute(V_FLOAT__XML_ATTR, Float.toString(getVFloat()));
		out.writeAttribute(V_DOUBLE__XML_ATTR, Double.toString(getVDouble()));
		out.writeAttribute(V_STRING__XML_ATTR, getVString());
		if (getVBytes() != null) {
			out.writeAttribute(V_BYTES__XML_ATTR, java.util.Base64.getEncoder().encodeToString(getVBytes()));
		}
		out.writeAttribute(V_JSON__XML_ATTR, de.haumacher.msgbuf.json.JsonUtil.jsonStringValue(getVJson()));
		out.writeAttribute(V_COLOR__XML_ATTR, getVColor().protocolName());
	}

	/** Serializes all fields that are written as XML elements. */
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		// No element fields.
	}

	/** Creates a new {@link test.xmlprimitives.data.Values} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Values_Impl readValues_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		Values_Impl result = new Values_Impl();
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
			case V_BOOL__XML_ATTR: {
				setVBool(Boolean.parseBoolean(value));
				break;
			}
			case V_INT_32__XML_ATTR: {
				setVInt32(Integer.parseInt(value));
				break;
			}
			case V_SINT_32__XML_ATTR: {
				setVSint32(Integer.parseInt(value));
				break;
			}
			case V_UINT_32__XML_ATTR: {
				setVUint32((int) Long.parseLong(value));
				break;
			}
			case V_FIXED_32__XML_ATTR: {
				setVFixed32((int) Long.parseLong(value));
				break;
			}
			case V_SFIXED_32__XML_ATTR: {
				setVSfixed32(Integer.parseInt(value));
				break;
			}
			case V_INT_64__XML_ATTR: {
				setVInt64(Long.parseLong(value));
				break;
			}
			case V_SINT_64__XML_ATTR: {
				setVSint64(Long.parseLong(value));
				break;
			}
			case V_UINT_64__XML_ATTR: {
				setVUint64(Long.parseLong(value));
				break;
			}
			case V_FIXED_64__XML_ATTR: {
				setVFixed64(Long.parseLong(value));
				break;
			}
			case V_SFIXED_64__XML_ATTR: {
				setVSfixed64(Long.parseLong(value));
				break;
			}
			case V_FLOAT__XML_ATTR: {
				setVFloat(Float.parseFloat(value));
				break;
			}
			case V_DOUBLE__XML_ATTR: {
				setVDouble(Double.parseDouble(value));
				break;
			}
			case V_STRING__XML_ATTR: {
				setVString(value);
				break;
			}
			case V_BYTES__XML_ATTR: {
				setVBytes(java.util.Base64.getDecoder().decode(value));
				break;
			}
			case V_JSON__XML_ATTR: {
				setVJson(de.haumacher.msgbuf.json.JsonUtil.parseJsonValue(value));
				break;
			}
			case V_COLOR__XML_ATTR: {
				setVColor(test.xmlprimitives.data.Color.valueOfProtocol(value));
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
			case V_BOOL__XML_ATTR: {
				setVBool(Boolean.parseBoolean(in.getElementText()));
				break;
			}
			case V_INT_32__XML_ATTR: {
				setVInt32(Integer.parseInt(in.getElementText()));
				break;
			}
			case V_SINT_32__XML_ATTR: {
				setVSint32(Integer.parseInt(in.getElementText()));
				break;
			}
			case V_UINT_32__XML_ATTR: {
				setVUint32((int) Long.parseLong(in.getElementText()));
				break;
			}
			case V_FIXED_32__XML_ATTR: {
				setVFixed32((int) Long.parseLong(in.getElementText()));
				break;
			}
			case V_SFIXED_32__XML_ATTR: {
				setVSfixed32(Integer.parseInt(in.getElementText()));
				break;
			}
			case V_INT_64__XML_ATTR: {
				setVInt64(Long.parseLong(in.getElementText()));
				break;
			}
			case V_SINT_64__XML_ATTR: {
				setVSint64(Long.parseLong(in.getElementText()));
				break;
			}
			case V_UINT_64__XML_ATTR: {
				setVUint64(Long.parseLong(in.getElementText()));
				break;
			}
			case V_FIXED_64__XML_ATTR: {
				setVFixed64(Long.parseLong(in.getElementText()));
				break;
			}
			case V_SFIXED_64__XML_ATTR: {
				setVSfixed64(Long.parseLong(in.getElementText()));
				break;
			}
			case V_FLOAT__XML_ATTR: {
				setVFloat(Float.parseFloat(in.getElementText()));
				break;
			}
			case V_DOUBLE__XML_ATTR: {
				setVDouble(Double.parseDouble(in.getElementText()));
				break;
			}
			case V_STRING__XML_ATTR: {
				setVString(in.getElementText());
				break;
			}
			case V_BYTES__XML_ATTR: {
				setVBytes(java.util.Base64.getDecoder().decode(in.getElementText()));
				break;
			}
			case V_JSON__XML_ATTR: {
				setVJson(de.haumacher.msgbuf.json.JsonUtil.parseJsonValue(in.getElementText()));
				break;
			}
			case V_COLOR__XML_ATTR: {
				setVColor(test.xmlprimitives.data.Color.valueOfProtocol(in.getElementText()));
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
