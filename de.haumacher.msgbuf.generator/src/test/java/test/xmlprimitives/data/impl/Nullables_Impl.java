package test.xmlprimitives.data.impl;

/**
 * Implementation of {@link test.xmlprimitives.data.Nullables}.
 */
public class Nullables_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.xmlprimitives.data.Nullables {

	private Boolean _nBool = null;

	private Integer _nInt32 = null;

	private Integer _nSint32 = null;

	private Integer _nUint32 = null;

	private Integer _nFixed32 = null;

	private Integer _nSfixed32 = null;

	private Long _nInt64 = null;

	private Long _nSint64 = null;

	private Long _nUint64 = null;

	private Long _nFixed64 = null;

	private Long _nSfixed64 = null;

	private Float _nFloat = null;

	private Double _nDouble = null;

	private String _nString = null;

	private byte[] _nBytes = null;

	private Object _nJson = null;

	private test.xmlprimitives.data.Color _nColor = null;

	private java.util.List<Integer> _nlInt32 = new de.haumacher.msgbuf.util.ReferenceList<Integer>() {
		@Override
		protected void beforeAdd(int index, Integer element) {
			_listener.beforeAdd(Nullables_Impl.this, NL_INT_32__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, Integer element) {
			_listener.afterRemove(Nullables_Impl.this, NL_INT_32__PROP, index, element);
		}

		@Override
		protected void afterChanged() {
			_listener.afterChanged(Nullables_Impl.this, NL_INT_32__PROP);
		}
	};

	private java.util.List<Integer> _nlUint32 = new de.haumacher.msgbuf.util.ReferenceList<Integer>() {
		@Override
		protected void beforeAdd(int index, Integer element) {
			_listener.beforeAdd(Nullables_Impl.this, NL_UINT_32__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, Integer element) {
			_listener.afterRemove(Nullables_Impl.this, NL_UINT_32__PROP, index, element);
		}

		@Override
		protected void afterChanged() {
			_listener.afterChanged(Nullables_Impl.this, NL_UINT_32__PROP);
		}
	};

	private java.util.List<String> _nlString = new de.haumacher.msgbuf.util.ReferenceList<String>() {
		@Override
		protected void beforeAdd(int index, String element) {
			_listener.beforeAdd(Nullables_Impl.this, NL_STRING__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, String element) {
			_listener.afterRemove(Nullables_Impl.this, NL_STRING__PROP, index, element);
		}

		@Override
		protected void afterChanged() {
			_listener.afterChanged(Nullables_Impl.this, NL_STRING__PROP);
		}
	};

	private java.util.List<byte[]> _nlBytes = new de.haumacher.msgbuf.util.ReferenceList<byte[]>() {
		@Override
		protected void beforeAdd(int index, byte[] element) {
			_listener.beforeAdd(Nullables_Impl.this, NL_BYTES__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, byte[] element) {
			_listener.afterRemove(Nullables_Impl.this, NL_BYTES__PROP, index, element);
		}

		@Override
		protected void afterChanged() {
			_listener.afterChanged(Nullables_Impl.this, NL_BYTES__PROP);
		}
	};

	/**
	 * Creates a {@link Nullables_Impl} instance.
	 *
	 * @see test.xmlprimitives.data.Nullables#create()
	 */
	public Nullables_Impl() {
		super();
	}

	@Override
	public final Boolean getNBool() {
		return _nBool;
	}

	@Override
	public test.xmlprimitives.data.Nullables setNBool(Boolean value) {
		internalSetNBool(value);
		return this;
	}

	/** Internal setter for {@link #getNBool()} without chain call utility. */
	protected final void internalSetNBool(Boolean value) {
		_listener.beforeSet(this, N_BOOL__PROP, value);
		_nBool = value;
		_listener.afterChanged(this, N_BOOL__PROP);
	}

	@Override
	public final boolean hasNBool() {
		return _nBool != null;
	}

	@Override
	public final Integer getNInt32() {
		return _nInt32;
	}

	@Override
	public test.xmlprimitives.data.Nullables setNInt32(Integer value) {
		internalSetNInt32(value);
		return this;
	}

	/** Internal setter for {@link #getNInt32()} without chain call utility. */
	protected final void internalSetNInt32(Integer value) {
		_listener.beforeSet(this, N_INT_32__PROP, value);
		_nInt32 = value;
		_listener.afterChanged(this, N_INT_32__PROP);
	}

	@Override
	public final boolean hasNInt32() {
		return _nInt32 != null;
	}

	@Override
	public final Integer getNSint32() {
		return _nSint32;
	}

	@Override
	public test.xmlprimitives.data.Nullables setNSint32(Integer value) {
		internalSetNSint32(value);
		return this;
	}

	/** Internal setter for {@link #getNSint32()} without chain call utility. */
	protected final void internalSetNSint32(Integer value) {
		_listener.beforeSet(this, N_SINT_32__PROP, value);
		_nSint32 = value;
		_listener.afterChanged(this, N_SINT_32__PROP);
	}

	@Override
	public final boolean hasNSint32() {
		return _nSint32 != null;
	}

	@Override
	public final Integer getNUint32() {
		return _nUint32;
	}

	@Override
	public test.xmlprimitives.data.Nullables setNUint32(Integer value) {
		internalSetNUint32(value);
		return this;
	}

	/** Internal setter for {@link #getNUint32()} without chain call utility. */
	protected final void internalSetNUint32(Integer value) {
		_listener.beforeSet(this, N_UINT_32__PROP, value);
		_nUint32 = value;
		_listener.afterChanged(this, N_UINT_32__PROP);
	}

	@Override
	public final boolean hasNUint32() {
		return _nUint32 != null;
	}

	@Override
	public final Integer getNFixed32() {
		return _nFixed32;
	}

	@Override
	public test.xmlprimitives.data.Nullables setNFixed32(Integer value) {
		internalSetNFixed32(value);
		return this;
	}

	/** Internal setter for {@link #getNFixed32()} without chain call utility. */
	protected final void internalSetNFixed32(Integer value) {
		_listener.beforeSet(this, N_FIXED_32__PROP, value);
		_nFixed32 = value;
		_listener.afterChanged(this, N_FIXED_32__PROP);
	}

	@Override
	public final boolean hasNFixed32() {
		return _nFixed32 != null;
	}

	@Override
	public final Integer getNSfixed32() {
		return _nSfixed32;
	}

	@Override
	public test.xmlprimitives.data.Nullables setNSfixed32(Integer value) {
		internalSetNSfixed32(value);
		return this;
	}

	/** Internal setter for {@link #getNSfixed32()} without chain call utility. */
	protected final void internalSetNSfixed32(Integer value) {
		_listener.beforeSet(this, N_SFIXED_32__PROP, value);
		_nSfixed32 = value;
		_listener.afterChanged(this, N_SFIXED_32__PROP);
	}

	@Override
	public final boolean hasNSfixed32() {
		return _nSfixed32 != null;
	}

	@Override
	public final Long getNInt64() {
		return _nInt64;
	}

	@Override
	public test.xmlprimitives.data.Nullables setNInt64(Long value) {
		internalSetNInt64(value);
		return this;
	}

	/** Internal setter for {@link #getNInt64()} without chain call utility. */
	protected final void internalSetNInt64(Long value) {
		_listener.beforeSet(this, N_INT_64__PROP, value);
		_nInt64 = value;
		_listener.afterChanged(this, N_INT_64__PROP);
	}

	@Override
	public final boolean hasNInt64() {
		return _nInt64 != null;
	}

	@Override
	public final Long getNSint64() {
		return _nSint64;
	}

	@Override
	public test.xmlprimitives.data.Nullables setNSint64(Long value) {
		internalSetNSint64(value);
		return this;
	}

	/** Internal setter for {@link #getNSint64()} without chain call utility. */
	protected final void internalSetNSint64(Long value) {
		_listener.beforeSet(this, N_SINT_64__PROP, value);
		_nSint64 = value;
		_listener.afterChanged(this, N_SINT_64__PROP);
	}

	@Override
	public final boolean hasNSint64() {
		return _nSint64 != null;
	}

	@Override
	public final Long getNUint64() {
		return _nUint64;
	}

	@Override
	public test.xmlprimitives.data.Nullables setNUint64(Long value) {
		internalSetNUint64(value);
		return this;
	}

	/** Internal setter for {@link #getNUint64()} without chain call utility. */
	protected final void internalSetNUint64(Long value) {
		_listener.beforeSet(this, N_UINT_64__PROP, value);
		_nUint64 = value;
		_listener.afterChanged(this, N_UINT_64__PROP);
	}

	@Override
	public final boolean hasNUint64() {
		return _nUint64 != null;
	}

	@Override
	public final Long getNFixed64() {
		return _nFixed64;
	}

	@Override
	public test.xmlprimitives.data.Nullables setNFixed64(Long value) {
		internalSetNFixed64(value);
		return this;
	}

	/** Internal setter for {@link #getNFixed64()} without chain call utility. */
	protected final void internalSetNFixed64(Long value) {
		_listener.beforeSet(this, N_FIXED_64__PROP, value);
		_nFixed64 = value;
		_listener.afterChanged(this, N_FIXED_64__PROP);
	}

	@Override
	public final boolean hasNFixed64() {
		return _nFixed64 != null;
	}

	@Override
	public final Long getNSfixed64() {
		return _nSfixed64;
	}

	@Override
	public test.xmlprimitives.data.Nullables setNSfixed64(Long value) {
		internalSetNSfixed64(value);
		return this;
	}

	/** Internal setter for {@link #getNSfixed64()} without chain call utility. */
	protected final void internalSetNSfixed64(Long value) {
		_listener.beforeSet(this, N_SFIXED_64__PROP, value);
		_nSfixed64 = value;
		_listener.afterChanged(this, N_SFIXED_64__PROP);
	}

	@Override
	public final boolean hasNSfixed64() {
		return _nSfixed64 != null;
	}

	@Override
	public final Float getNFloat() {
		return _nFloat;
	}

	@Override
	public test.xmlprimitives.data.Nullables setNFloat(Float value) {
		internalSetNFloat(value);
		return this;
	}

	/** Internal setter for {@link #getNFloat()} without chain call utility. */
	protected final void internalSetNFloat(Float value) {
		_listener.beforeSet(this, N_FLOAT__PROP, value);
		_nFloat = value;
		_listener.afterChanged(this, N_FLOAT__PROP);
	}

	@Override
	public final boolean hasNFloat() {
		return _nFloat != null;
	}

	@Override
	public final Double getNDouble() {
		return _nDouble;
	}

	@Override
	public test.xmlprimitives.data.Nullables setNDouble(Double value) {
		internalSetNDouble(value);
		return this;
	}

	/** Internal setter for {@link #getNDouble()} without chain call utility. */
	protected final void internalSetNDouble(Double value) {
		_listener.beforeSet(this, N_DOUBLE__PROP, value);
		_nDouble = value;
		_listener.afterChanged(this, N_DOUBLE__PROP);
	}

	@Override
	public final boolean hasNDouble() {
		return _nDouble != null;
	}

	@Override
	public final String getNString() {
		return _nString;
	}

	@Override
	public test.xmlprimitives.data.Nullables setNString(String value) {
		internalSetNString(value);
		return this;
	}

	/** Internal setter for {@link #getNString()} without chain call utility. */
	protected final void internalSetNString(String value) {
		_listener.beforeSet(this, N_STRING__PROP, value);
		_nString = value;
		_listener.afterChanged(this, N_STRING__PROP);
	}

	@Override
	public final boolean hasNString() {
		return _nString != null;
	}

	@Override
	public final byte[] getNBytes() {
		return _nBytes;
	}

	@Override
	public test.xmlprimitives.data.Nullables setNBytes(byte[] value) {
		internalSetNBytes(value);
		return this;
	}

	/** Internal setter for {@link #getNBytes()} without chain call utility. */
	protected final void internalSetNBytes(byte[] value) {
		_listener.beforeSet(this, N_BYTES__PROP, value);
		_nBytes = value;
		_listener.afterChanged(this, N_BYTES__PROP);
	}

	@Override
	public final boolean hasNBytes() {
		return _nBytes != null;
	}

	@Override
	public final Object getNJson() {
		return _nJson;
	}

	@Override
	public test.xmlprimitives.data.Nullables setNJson(Object value) {
		internalSetNJson(value);
		return this;
	}

	/** Internal setter for {@link #getNJson()} without chain call utility. */
	protected final void internalSetNJson(Object value) {
		_listener.beforeSet(this, N_JSON__PROP, value);
		_nJson = value;
		_listener.afterChanged(this, N_JSON__PROP);
	}

	@Override
	public final boolean hasNJson() {
		return _nJson != null;
	}

	@Override
	public final test.xmlprimitives.data.Color getNColor() {
		return _nColor;
	}

	@Override
	public test.xmlprimitives.data.Nullables setNColor(test.xmlprimitives.data.Color value) {
		internalSetNColor(value);
		return this;
	}

	/** Internal setter for {@link #getNColor()} without chain call utility. */
	protected final void internalSetNColor(test.xmlprimitives.data.Color value) {
		_listener.beforeSet(this, N_COLOR__PROP, value);
		_nColor = value;
		_listener.afterChanged(this, N_COLOR__PROP);
	}

	@Override
	public final boolean hasNColor() {
		return _nColor != null;
	}

	@Override
	public final java.util.List<Integer> getNlInt32() {
		return _nlInt32;
	}

	@Override
	public test.xmlprimitives.data.Nullables setNlInt32(java.util.List<? extends Integer> value) {
		internalSetNlInt32(value);
		return this;
	}

	/** Internal setter for {@link #getNlInt32()} without chain call utility. */
	protected final void internalSetNlInt32(java.util.List<? extends Integer> value) {
		if (_nlInt32 == null) _nlInt32 = new java.util.ArrayList<>();
		_nlInt32.clear();
		_nlInt32.addAll(value);
	}

	@Override
	public test.xmlprimitives.data.Nullables addNlInt32(int value) {
		internalAddNlInt32(value);
		return this;
	}

	/** Implementation of {@link #addNlInt32(int)} without chain call utility. */
	protected final void internalAddNlInt32(int value) {
		if (_nlInt32 == null) _nlInt32 = new java.util.ArrayList<>();
		_nlInt32.add(value);
	}

	@Override
	public final void removeNlInt32(int value) {
		if (_nlInt32 == null) _nlInt32 = new java.util.ArrayList<>();
		_nlInt32.remove(value);
	}

	@Override
	public final boolean hasNlInt32() {
		return _nlInt32 != null;
	}

	@Override
	public final java.util.List<Integer> getNlUint32() {
		return _nlUint32;
	}

	@Override
	public test.xmlprimitives.data.Nullables setNlUint32(java.util.List<? extends Integer> value) {
		internalSetNlUint32(value);
		return this;
	}

	/** Internal setter for {@link #getNlUint32()} without chain call utility. */
	protected final void internalSetNlUint32(java.util.List<? extends Integer> value) {
		if (_nlUint32 == null) _nlUint32 = new java.util.ArrayList<>();
		_nlUint32.clear();
		_nlUint32.addAll(value);
	}

	@Override
	public test.xmlprimitives.data.Nullables addNlUint32(int value) {
		internalAddNlUint32(value);
		return this;
	}

	/** Implementation of {@link #addNlUint32(int)} without chain call utility. */
	protected final void internalAddNlUint32(int value) {
		if (_nlUint32 == null) _nlUint32 = new java.util.ArrayList<>();
		_nlUint32.add(value);
	}

	@Override
	public final void removeNlUint32(int value) {
		if (_nlUint32 == null) _nlUint32 = new java.util.ArrayList<>();
		_nlUint32.remove(value);
	}

	@Override
	public final boolean hasNlUint32() {
		return _nlUint32 != null;
	}

	@Override
	public final java.util.List<String> getNlString() {
		return _nlString;
	}

	@Override
	public test.xmlprimitives.data.Nullables setNlString(java.util.List<? extends String> value) {
		internalSetNlString(value);
		return this;
	}

	/** Internal setter for {@link #getNlString()} without chain call utility. */
	protected final void internalSetNlString(java.util.List<? extends String> value) {
		if (_nlString == null) _nlString = new java.util.ArrayList<>();
		_nlString.clear();
		_nlString.addAll(value);
	}

	@Override
	public test.xmlprimitives.data.Nullables addNlString(String value) {
		internalAddNlString(value);
		return this;
	}

	/** Implementation of {@link #addNlString(String)} without chain call utility. */
	protected final void internalAddNlString(String value) {
		if (_nlString == null) _nlString = new java.util.ArrayList<>();
		_nlString.add(value);
	}

	@Override
	public final void removeNlString(String value) {
		if (_nlString == null) _nlString = new java.util.ArrayList<>();
		_nlString.remove(value);
	}

	@Override
	public final boolean hasNlString() {
		return _nlString != null;
	}

	@Override
	public final java.util.List<byte[]> getNlBytes() {
		return _nlBytes;
	}

	@Override
	public test.xmlprimitives.data.Nullables setNlBytes(java.util.List<? extends byte[]> value) {
		internalSetNlBytes(value);
		return this;
	}

	/** Internal setter for {@link #getNlBytes()} without chain call utility. */
	protected final void internalSetNlBytes(java.util.List<? extends byte[]> value) {
		if (_nlBytes == null) _nlBytes = new java.util.ArrayList<>();
		_nlBytes.clear();
		_nlBytes.addAll(value);
	}

	@Override
	public test.xmlprimitives.data.Nullables addNlByte(byte[] value) {
		internalAddNlByte(value);
		return this;
	}

	/** Implementation of {@link #addNlByte(byte[])} without chain call utility. */
	protected final void internalAddNlByte(byte[] value) {
		if (_nlBytes == null) _nlBytes = new java.util.ArrayList<>();
		_nlBytes.add(value);
	}

	@Override
	public final void removeNlByte(byte[] value) {
		if (_nlBytes == null) _nlBytes = new java.util.ArrayList<>();
		_nlBytes.remove(value);
	}

	@Override
	public final boolean hasNlBytes() {
		return _nlBytes != null;
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.xmlprimitives.data.Nullables registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.xmlprimitives.data.Nullables unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		internalUnregisterListener(l);
		return this;
	}

	protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
	}

	@Override
	public String jsonType() {
		return NULLABLES__TYPE;
	}

	static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			N_BOOL__PROP, 
			N_INT_32__PROP, 
			N_SINT_32__PROP, 
			N_UINT_32__PROP, 
			N_FIXED_32__PROP, 
			N_SFIXED_32__PROP, 
			N_INT_64__PROP, 
			N_SINT_64__PROP, 
			N_UINT_64__PROP, 
			N_FIXED_64__PROP, 
			N_SFIXED_64__PROP, 
			N_FLOAT__PROP, 
			N_DOUBLE__PROP, 
			N_STRING__PROP, 
			N_BYTES__PROP, 
			N_JSON__PROP, 
			N_COLOR__PROP, 
			NL_INT_32__PROP, 
			NL_UINT_32__PROP, 
			NL_STRING__PROP, 
			NL_BYTES__PROP);
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
			case N_BOOL__PROP: return getNBool();
			case N_INT_32__PROP: return getNInt32();
			case N_SINT_32__PROP: return getNSint32();
			case N_UINT_32__PROP: return getNUint32();
			case N_FIXED_32__PROP: return getNFixed32();
			case N_SFIXED_32__PROP: return getNSfixed32();
			case N_INT_64__PROP: return getNInt64();
			case N_SINT_64__PROP: return getNSint64();
			case N_UINT_64__PROP: return getNUint64();
			case N_FIXED_64__PROP: return getNFixed64();
			case N_SFIXED_64__PROP: return getNSfixed64();
			case N_FLOAT__PROP: return getNFloat();
			case N_DOUBLE__PROP: return getNDouble();
			case N_STRING__PROP: return getNString();
			case N_BYTES__PROP: return getNBytes();
			case N_JSON__PROP: return getNJson();
			case N_COLOR__PROP: return getNColor();
			case NL_INT_32__PROP: return getNlInt32();
			case NL_UINT_32__PROP: return getNlUint32();
			case NL_STRING__PROP: return getNlString();
			case NL_BYTES__PROP: return getNlBytes();
			default: return test.xmlprimitives.data.Nullables.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case N_BOOL__PROP: internalSetNBool((Boolean) value); break;
			case N_INT_32__PROP: internalSetNInt32((Integer) value); break;
			case N_SINT_32__PROP: internalSetNSint32((Integer) value); break;
			case N_UINT_32__PROP: internalSetNUint32((Integer) value); break;
			case N_FIXED_32__PROP: internalSetNFixed32((Integer) value); break;
			case N_SFIXED_32__PROP: internalSetNSfixed32((Integer) value); break;
			case N_INT_64__PROP: internalSetNInt64((Long) value); break;
			case N_SINT_64__PROP: internalSetNSint64((Long) value); break;
			case N_UINT_64__PROP: internalSetNUint64((Long) value); break;
			case N_FIXED_64__PROP: internalSetNFixed64((Long) value); break;
			case N_SFIXED_64__PROP: internalSetNSfixed64((Long) value); break;
			case N_FLOAT__PROP: internalSetNFloat((Float) value); break;
			case N_DOUBLE__PROP: internalSetNDouble((Double) value); break;
			case N_STRING__PROP: internalSetNString((String) value); break;
			case N_BYTES__PROP: internalSetNBytes((byte[]) value); break;
			case N_JSON__PROP: internalSetNJson((Object) value); break;
			case N_COLOR__PROP: internalSetNColor((test.xmlprimitives.data.Color) value); break;
			case NL_INT_32__PROP: internalSetNlInt32(de.haumacher.msgbuf.util.Conversions.asList(Integer.class, value)); break;
			case NL_UINT_32__PROP: internalSetNlUint32(de.haumacher.msgbuf.util.Conversions.asList(Integer.class, value)); break;
			case NL_STRING__PROP: internalSetNlString(de.haumacher.msgbuf.util.Conversions.asList(String.class, value)); break;
			case NL_BYTES__PROP: internalSetNlBytes(de.haumacher.msgbuf.util.Conversions.asList(byte[].class, value)); break;
		}
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		if (hasNBool()) {
			out.name(N_BOOL__PROP);
			out.value(getNBool());
		}
		if (hasNInt32()) {
			out.name(N_INT_32__PROP);
			out.value(getNInt32());
		}
		if (hasNSint32()) {
			out.name(N_SINT_32__PROP);
			out.value(getNSint32());
		}
		if (hasNUint32()) {
			out.name(N_UINT_32__PROP);
			out.value(getNUint32());
		}
		if (hasNFixed32()) {
			out.name(N_FIXED_32__PROP);
			out.value(getNFixed32());
		}
		if (hasNSfixed32()) {
			out.name(N_SFIXED_32__PROP);
			out.value(getNSfixed32());
		}
		if (hasNInt64()) {
			out.name(N_INT_64__PROP);
			out.value(getNInt64());
		}
		if (hasNSint64()) {
			out.name(N_SINT_64__PROP);
			out.value(getNSint64());
		}
		if (hasNUint64()) {
			out.name(N_UINT_64__PROP);
			out.value(getNUint64());
		}
		if (hasNFixed64()) {
			out.name(N_FIXED_64__PROP);
			out.value(getNFixed64());
		}
		if (hasNSfixed64()) {
			out.name(N_SFIXED_64__PROP);
			out.value(getNSfixed64());
		}
		if (hasNFloat()) {
			out.name(N_FLOAT__PROP);
			out.value(getNFloat());
		}
		if (hasNDouble()) {
			out.name(N_DOUBLE__PROP);
			out.value(getNDouble());
		}
		if (hasNString()) {
			out.name(N_STRING__PROP);
			out.value(getNString());
		}
		if (hasNBytes()) {
			out.name(N_BYTES__PROP);
			de.haumacher.msgbuf.json.JsonUtil.writeBinaryOptional(out, getNBytes());
		}
		if (hasNJson()) {
			out.name(N_JSON__PROP);
			de.haumacher.msgbuf.json.JsonUtil.writeJsonValue(out, getNJson());
		}
		if (hasNColor()) {
			out.name(N_COLOR__PROP);
			getNColor().writeTo(out);
		}
		if (hasNlInt32()) {
			out.name(NL_INT_32__PROP);
			out.beginArray();
			for (int x : getNlInt32()) {
				out.value(x);
			}
			out.endArray();
		}
		if (hasNlUint32()) {
			out.name(NL_UINT_32__PROP);
			out.beginArray();
			for (int x : getNlUint32()) {
				out.value(x);
			}
			out.endArray();
		}
		if (hasNlString()) {
			out.name(NL_STRING__PROP);
			out.beginArray();
			for (String x : getNlString()) {
				out.value(x);
			}
			out.endArray();
		}
		if (hasNlBytes()) {
			out.name(NL_BYTES__PROP);
			out.beginArray();
			for (byte[] x : getNlBytes()) {
				de.haumacher.msgbuf.json.JsonUtil.writeBinaryOptional(out, x);
			}
			out.endArray();
		}
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case N_BOOL__PROP: setNBool(in.nextBoolean()); break;
			case N_INT_32__PROP: setNInt32(in.nextInt()); break;
			case N_SINT_32__PROP: setNSint32(in.nextInt()); break;
			case N_UINT_32__PROP: setNUint32(in.nextInt()); break;
			case N_FIXED_32__PROP: setNFixed32(in.nextInt()); break;
			case N_SFIXED_32__PROP: setNSfixed32(in.nextInt()); break;
			case N_INT_64__PROP: setNInt64(in.nextLong()); break;
			case N_SINT_64__PROP: setNSint64(in.nextLong()); break;
			case N_UINT_64__PROP: setNUint64(in.nextLong()); break;
			case N_FIXED_64__PROP: setNFixed64(in.nextLong()); break;
			case N_SFIXED_64__PROP: setNSfixed64(in.nextLong()); break;
			case N_FLOAT__PROP: setNFloat((float) in.nextDouble()); break;
			case N_DOUBLE__PROP: setNDouble(in.nextDouble()); break;
			case N_STRING__PROP: setNString(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			case N_BYTES__PROP: setNBytes(de.haumacher.msgbuf.json.JsonUtil.nextBinaryOptional(in)); break;
			case N_JSON__PROP: setNJson(de.haumacher.msgbuf.json.JsonUtil.nextJsonValue(in)); break;
			case N_COLOR__PROP: setNColor(test.xmlprimitives.data.Color.readColor(in)); break;
			case NL_INT_32__PROP: {
				java.util.List<Integer> newValue = new java.util.ArrayList<>();
				in.beginArray();
				while (in.hasNext()) {
					newValue.add(in.nextInt());
				}
				in.endArray();
				setNlInt32(newValue);
			}
			break;
			case NL_UINT_32__PROP: {
				java.util.List<Integer> newValue = new java.util.ArrayList<>();
				in.beginArray();
				while (in.hasNext()) {
					newValue.add(in.nextInt());
				}
				in.endArray();
				setNlUint32(newValue);
			}
			break;
			case NL_STRING__PROP: {
				java.util.List<String> newValue = new java.util.ArrayList<>();
				in.beginArray();
				while (in.hasNext()) {
					newValue.add(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in));
				}
				in.endArray();
				setNlString(newValue);
			}
			break;
			case NL_BYTES__PROP: {
				java.util.List<byte[]> newValue = new java.util.ArrayList<>();
				in.beginArray();
				while (in.hasNext()) {
					newValue.add(de.haumacher.msgbuf.json.JsonUtil.nextBinaryOptional(in));
				}
				in.endArray();
				setNlBytes(newValue);
			}
			break;
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
		if (hasNBool()) {
			out.name(N_BOOL__ID);
			out.value(getNBool());
		}
		if (hasNInt32()) {
			out.name(N_INT_32__ID);
			out.value(getNInt32());
		}
		if (hasNSint32()) {
			out.name(N_SINT_32__ID);
			out.valueSigned(getNSint32());
		}
		if (hasNUint32()) {
			out.name(N_UINT_32__ID);
			out.value(getNUint32());
		}
		if (hasNFixed32()) {
			out.name(N_FIXED_32__ID);
			out.valueFixed(getNFixed32());
		}
		if (hasNSfixed32()) {
			out.name(N_SFIXED_32__ID);
			out.valueFixed(getNSfixed32());
		}
		if (hasNInt64()) {
			out.name(N_INT_64__ID);
			out.value(getNInt64());
		}
		if (hasNSint64()) {
			out.name(N_SINT_64__ID);
			out.valueSigned(getNSint64());
		}
		if (hasNUint64()) {
			out.name(N_UINT_64__ID);
			out.value(getNUint64());
		}
		if (hasNFixed64()) {
			out.name(N_FIXED_64__ID);
			out.valueFixed(getNFixed64());
		}
		if (hasNSfixed64()) {
			out.name(N_SFIXED_64__ID);
			out.valueFixed(getNSfixed64());
		}
		if (hasNFloat()) {
			out.name(N_FLOAT__ID);
			out.value(getNFloat());
		}
		if (hasNDouble()) {
			out.name(N_DOUBLE__ID);
			out.value(getNDouble());
		}
		if (hasNString()) {
			out.name(N_STRING__ID);
			out.value(getNString());
		}
		if (hasNBytes()) {
			out.name(N_BYTES__ID);
			out.value(getNBytes());
		}
		if (hasNJson()) {
			out.name(N_JSON__ID);
			de.haumacher.msgbuf.json.JsonUtil.toJsonValue(getNJson()).writeTo(out);
		}
		if (hasNColor()) {
			out.name(N_COLOR__ID);
			getNColor().writeTo(out);
		}
		if (hasNlInt32()) {
			out.name(NL_INT_32__ID);
			{
				java.util.List<Integer> values = getNlInt32();
				out.beginArray(de.haumacher.msgbuf.binary.DataType.INT, values.size());
				for (int x : values) {
					out.value(x);
				}
				out.endArray();
			}
		}
		if (hasNlUint32()) {
			out.name(NL_UINT_32__ID);
			{
				java.util.List<Integer> values = getNlUint32();
				out.beginArray(de.haumacher.msgbuf.binary.DataType.INT, values.size());
				for (int x : values) {
					out.value(x);
				}
				out.endArray();
			}
		}
		if (hasNlString()) {
			out.name(NL_STRING__ID);
			{
				java.util.List<String> values = getNlString();
				out.beginArray(de.haumacher.msgbuf.binary.DataType.STRING, values.size());
				for (String x : values) {
					out.value(x);
				}
				out.endArray();
			}
		}
		if (hasNlBytes()) {
			out.name(NL_BYTES__ID);
			{
				java.util.List<byte[]> values = getNlBytes();
				out.beginArray(de.haumacher.msgbuf.binary.DataType.BINARY, values.size());
				for (byte[] x : values) {
					out.value(x);
				}
				out.endArray();
			}
		}
	}

	/** Helper for creating an object of type {@link test.xmlprimitives.data.Nullables} from a polymorphic composition. */
	public static test.xmlprimitives.data.Nullables readNullables_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.xmlprimitives.data.impl.Nullables_Impl result = new Nullables_Impl();
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
			case N_BOOL__ID: setNBool(in.nextBoolean()); break;
			case N_INT_32__ID: setNInt32(in.nextInt()); break;
			case N_SINT_32__ID: setNSint32(in.nextIntSigned()); break;
			case N_UINT_32__ID: setNUint32(in.nextInt()); break;
			case N_FIXED_32__ID: setNFixed32(in.nextIntFixed()); break;
			case N_SFIXED_32__ID: setNSfixed32(in.nextIntFixed()); break;
			case N_INT_64__ID: setNInt64(in.nextLong()); break;
			case N_SINT_64__ID: setNSint64(in.nextLongSigned()); break;
			case N_UINT_64__ID: setNUint64(in.nextLong()); break;
			case N_FIXED_64__ID: setNFixed64(in.nextLongFixed()); break;
			case N_SFIXED_64__ID: setNSfixed64(in.nextLongFixed()); break;
			case N_FLOAT__ID: setNFloat(in.nextFloat()); break;
			case N_DOUBLE__ID: setNDouble(in.nextDouble()); break;
			case N_STRING__ID: setNString(in.nextString()); break;
			case N_BYTES__ID: setNBytes(in.nextBinary()); break;
			case N_JSON__ID: setNJson(de.haumacher.msgbuf.json.JsonUtil.fromJsonValue(de.haumacher.msgbuf.json.value.JsonValue.readJsonValue(in))); break;
			case N_COLOR__ID: setNColor(test.xmlprimitives.data.Color.readColor(in)); break;
			case NL_INT_32__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addNlInt32(in.nextInt());
				}
				in.endArray();
			}
			break;
			case NL_UINT_32__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addNlUint32(in.nextInt());
				}
				in.endArray();
			}
			break;
			case NL_STRING__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addNlString(in.nextString());
				}
				in.endArray();
			}
			break;
			case NL_BYTES__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addNlByte(in.nextBinary());
				}
				in.endArray();
			}
			break;
			default: in.skipValue(); 
		}
	}

	/** XML element name representing a {@link test.xmlprimitives.data.Nullables} type. */
	public static final String NULLABLES__XML_ELEMENT = "nullables";

	/** XML attribute or element name of a {@link #getNBool} property. */
	private static final String N_BOOL__XML_ATTR = "n-bool";

	/** XML attribute or element name of a {@link #getNInt32} property. */
	private static final String N_INT_32__XML_ATTR = "n-int-32";

	/** XML attribute or element name of a {@link #getNSint32} property. */
	private static final String N_SINT_32__XML_ATTR = "n-sint-32";

	/** XML attribute or element name of a {@link #getNUint32} property. */
	private static final String N_UINT_32__XML_ATTR = "n-uint-32";

	/** XML attribute or element name of a {@link #getNFixed32} property. */
	private static final String N_FIXED_32__XML_ATTR = "n-fixed-32";

	/** XML attribute or element name of a {@link #getNSfixed32} property. */
	private static final String N_SFIXED_32__XML_ATTR = "n-sfixed-32";

	/** XML attribute or element name of a {@link #getNInt64} property. */
	private static final String N_INT_64__XML_ATTR = "n-int-64";

	/** XML attribute or element name of a {@link #getNSint64} property. */
	private static final String N_SINT_64__XML_ATTR = "n-sint-64";

	/** XML attribute or element name of a {@link #getNUint64} property. */
	private static final String N_UINT_64__XML_ATTR = "n-uint-64";

	/** XML attribute or element name of a {@link #getNFixed64} property. */
	private static final String N_FIXED_64__XML_ATTR = "n-fixed-64";

	/** XML attribute or element name of a {@link #getNSfixed64} property. */
	private static final String N_SFIXED_64__XML_ATTR = "n-sfixed-64";

	/** XML attribute or element name of a {@link #getNFloat} property. */
	private static final String N_FLOAT__XML_ATTR = "n-float";

	/** XML attribute or element name of a {@link #getNDouble} property. */
	private static final String N_DOUBLE__XML_ATTR = "n-double";

	/** XML attribute or element name of a {@link #getNString} property. */
	private static final String N_STRING__XML_ATTR = "n-string";

	/** XML attribute or element name of a {@link #getNBytes} property. */
	private static final String N_BYTES__XML_ATTR = "n-bytes";

	/** XML attribute or element name of a {@link #getNJson} property. */
	private static final String N_JSON__XML_ATTR = "n-json";

	/** XML attribute or element name of a {@link #getNColor} property. */
	private static final String N_COLOR__XML_ATTR = "n-color";

	/** XML attribute or element name of a {@link #getNlInt32} property. */
	private static final String NL_INT_32__XML_ATTR = "nl-int-32";

	/** XML attribute or element name of a {@link #getNlUint32} property. */
	private static final String NL_UINT_32__XML_ATTR = "nl-uint-32";

	/** XML attribute or element name of a {@link #getNlString} property. */
	private static final String NL_STRING__XML_ATTR = "nl-string";

	/** XML attribute or element name of a {@link #getNlBytes} property. */
	private static final String NL_BYTES__XML_ATTR = "nl-bytes";

	@Override
	public String getXmlTagName() {
		return NULLABLES__XML_ELEMENT;
	}

	@Override
	public final void writeContent(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		writeAttributes(out);
		writeElements(out);
	}

	/** Serializes all fields that are written as XML attributes. */
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		if (hasNBool()) {
			out.writeAttribute(N_BOOL__XML_ATTR, Boolean.toString(getNBool()));
		}
		if (hasNInt32()) {
			out.writeAttribute(N_INT_32__XML_ATTR, Integer.toString(getNInt32()));
		}
		if (hasNSint32()) {
			out.writeAttribute(N_SINT_32__XML_ATTR, Integer.toString(getNSint32()));
		}
		if (hasNUint32()) {
			out.writeAttribute(N_UINT_32__XML_ATTR, Long.toString(Integer.toUnsignedLong(getNUint32())));
		}
		if (hasNFixed32()) {
			out.writeAttribute(N_FIXED_32__XML_ATTR, Long.toString(Integer.toUnsignedLong(getNFixed32())));
		}
		if (hasNSfixed32()) {
			out.writeAttribute(N_SFIXED_32__XML_ATTR, Integer.toString(getNSfixed32()));
		}
		if (hasNInt64()) {
			out.writeAttribute(N_INT_64__XML_ATTR, Long.toString(getNInt64()));
		}
		if (hasNSint64()) {
			out.writeAttribute(N_SINT_64__XML_ATTR, Long.toString(getNSint64()));
		}
		if (hasNUint64()) {
			out.writeAttribute(N_UINT_64__XML_ATTR, Long.toString(getNUint64()));
		}
		if (hasNFixed64()) {
			out.writeAttribute(N_FIXED_64__XML_ATTR, Long.toString(getNFixed64()));
		}
		if (hasNSfixed64()) {
			out.writeAttribute(N_SFIXED_64__XML_ATTR, Long.toString(getNSfixed64()));
		}
		if (hasNFloat()) {
			out.writeAttribute(N_FLOAT__XML_ATTR, Float.toString(getNFloat()));
		}
		if (hasNDouble()) {
			out.writeAttribute(N_DOUBLE__XML_ATTR, Double.toString(getNDouble()));
		}
		if (hasNString()) {
			out.writeAttribute(N_STRING__XML_ATTR, getNString());
		}
		if (hasNBytes()) {
			out.writeAttribute(N_BYTES__XML_ATTR, java.util.Base64.getEncoder().encodeToString(getNBytes()));
		}
		out.writeAttribute(N_JSON__XML_ATTR, de.haumacher.msgbuf.json.JsonUtil.jsonStringValue(getNJson()));
		if (hasNColor()) {
			out.writeAttribute(N_COLOR__XML_ATTR, getNColor().protocolName());
		}
		if (hasNlInt32()) {
			out.writeAttribute(NL_INT_32__XML_ATTR, getNlInt32().stream().map(x -> Integer.toString(x)).collect(java.util.stream.Collectors.joining(", ")));
		}
		if (hasNlUint32()) {
			out.writeAttribute(NL_UINT_32__XML_ATTR, getNlUint32().stream().map(x -> Long.toString(Integer.toUnsignedLong(x))).collect(java.util.stream.Collectors.joining(", ")));
		}
		if (hasNlString()) {
			out.writeAttribute(NL_STRING__XML_ATTR, getNlString().stream().map(x -> x).collect(java.util.stream.Collectors.joining(", ")));
		}
		if (hasNlBytes()) {
			out.writeAttribute(NL_BYTES__XML_ATTR, getNlBytes().stream().map(x -> java.util.Base64.getEncoder().encodeToString(x)).collect(java.util.stream.Collectors.joining(", ")));
		}
	}

	/** Serializes all fields that are written as XML elements. */
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		// No element fields.
	}

	/** Creates a new {@link test.xmlprimitives.data.Nullables} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Nullables_Impl readNullables_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		Nullables_Impl result = new Nullables_Impl();
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
			case N_BOOL__XML_ATTR: {
				setNBool(Boolean.parseBoolean(value));
				break;
			}
			case N_INT_32__XML_ATTR: {
				setNInt32(Integer.parseInt(value));
				break;
			}
			case N_SINT_32__XML_ATTR: {
				setNSint32(Integer.parseInt(value));
				break;
			}
			case N_UINT_32__XML_ATTR: {
				setNUint32((int) Long.parseLong(value));
				break;
			}
			case N_FIXED_32__XML_ATTR: {
				setNFixed32((int) Long.parseLong(value));
				break;
			}
			case N_SFIXED_32__XML_ATTR: {
				setNSfixed32(Integer.parseInt(value));
				break;
			}
			case N_INT_64__XML_ATTR: {
				setNInt64(Long.parseLong(value));
				break;
			}
			case N_SINT_64__XML_ATTR: {
				setNSint64(Long.parseLong(value));
				break;
			}
			case N_UINT_64__XML_ATTR: {
				setNUint64(Long.parseLong(value));
				break;
			}
			case N_FIXED_64__XML_ATTR: {
				setNFixed64(Long.parseLong(value));
				break;
			}
			case N_SFIXED_64__XML_ATTR: {
				setNSfixed64(Long.parseLong(value));
				break;
			}
			case N_FLOAT__XML_ATTR: {
				setNFloat(Float.parseFloat(value));
				break;
			}
			case N_DOUBLE__XML_ATTR: {
				setNDouble(Double.parseDouble(value));
				break;
			}
			case N_STRING__XML_ATTR: {
				setNString(value);
				break;
			}
			case N_BYTES__XML_ATTR: {
				setNBytes(java.util.Base64.getDecoder().decode(value));
				break;
			}
			case N_JSON__XML_ATTR: {
				setNJson(de.haumacher.msgbuf.json.JsonUtil.parseJsonValue(value));
				break;
			}
			case N_COLOR__XML_ATTR: {
				setNColor(test.xmlprimitives.data.Color.valueOfProtocol(value));
				break;
			}
			case NL_INT_32__XML_ATTR: {
				setNlInt32(java.util.Arrays.stream(value.isEmpty() ? new String[0] : value.split("\\s*,\\s*")).map(x -> Integer.parseInt(x)).collect(java.util.stream.Collectors.toList()));
				break;
			}
			case NL_UINT_32__XML_ATTR: {
				setNlUint32(java.util.Arrays.stream(value.isEmpty() ? new String[0] : value.split("\\s*,\\s*")).map(x -> (int) Long.parseLong(x)).collect(java.util.stream.Collectors.toList()));
				break;
			}
			case NL_STRING__XML_ATTR: {
				setNlString(java.util.Arrays.stream(value.isEmpty() ? new String[0] : value.split("\\s*,\\s*")).map(x -> x).collect(java.util.stream.Collectors.toList()));
				break;
			}
			case NL_BYTES__XML_ATTR: {
				setNlBytes(java.util.Arrays.stream(value.isEmpty() ? new String[0] : value.split("\\s*,\\s*")).map(x -> java.util.Base64.getDecoder().decode(x)).collect(java.util.stream.Collectors.toList()));
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
			case N_BOOL__XML_ATTR: {
				setNBool(Boolean.parseBoolean(in.getElementText()));
				break;
			}
			case N_INT_32__XML_ATTR: {
				setNInt32(Integer.parseInt(in.getElementText()));
				break;
			}
			case N_SINT_32__XML_ATTR: {
				setNSint32(Integer.parseInt(in.getElementText()));
				break;
			}
			case N_UINT_32__XML_ATTR: {
				setNUint32((int) Long.parseLong(in.getElementText()));
				break;
			}
			case N_FIXED_32__XML_ATTR: {
				setNFixed32((int) Long.parseLong(in.getElementText()));
				break;
			}
			case N_SFIXED_32__XML_ATTR: {
				setNSfixed32(Integer.parseInt(in.getElementText()));
				break;
			}
			case N_INT_64__XML_ATTR: {
				setNInt64(Long.parseLong(in.getElementText()));
				break;
			}
			case N_SINT_64__XML_ATTR: {
				setNSint64(Long.parseLong(in.getElementText()));
				break;
			}
			case N_UINT_64__XML_ATTR: {
				setNUint64(Long.parseLong(in.getElementText()));
				break;
			}
			case N_FIXED_64__XML_ATTR: {
				setNFixed64(Long.parseLong(in.getElementText()));
				break;
			}
			case N_SFIXED_64__XML_ATTR: {
				setNSfixed64(Long.parseLong(in.getElementText()));
				break;
			}
			case N_FLOAT__XML_ATTR: {
				setNFloat(Float.parseFloat(in.getElementText()));
				break;
			}
			case N_DOUBLE__XML_ATTR: {
				setNDouble(Double.parseDouble(in.getElementText()));
				break;
			}
			case N_STRING__XML_ATTR: {
				setNString(in.getElementText());
				break;
			}
			case N_BYTES__XML_ATTR: {
				setNBytes(java.util.Base64.getDecoder().decode(in.getElementText()));
				break;
			}
			case N_JSON__XML_ATTR: {
				setNJson(de.haumacher.msgbuf.json.JsonUtil.parseJsonValue(in.getElementText()));
				break;
			}
			case N_COLOR__XML_ATTR: {
				setNColor(test.xmlprimitives.data.Color.valueOfProtocol(in.getElementText()));
				break;
			}
			case NL_INT_32__XML_ATTR: {
				String text = in.getElementText();
				setNlInt32(java.util.Arrays.stream(text.isEmpty() ? new String[0] : text.split("\\s*,\\s*")).map(x -> Integer.parseInt(x)).collect(java.util.stream.Collectors.toList()));
				break;
			}
			case NL_UINT_32__XML_ATTR: {
				String text = in.getElementText();
				setNlUint32(java.util.Arrays.stream(text.isEmpty() ? new String[0] : text.split("\\s*,\\s*")).map(x -> (int) Long.parseLong(x)).collect(java.util.stream.Collectors.toList()));
				break;
			}
			case NL_STRING__XML_ATTR: {
				String text = in.getElementText();
				setNlString(java.util.Arrays.stream(text.isEmpty() ? new String[0] : text.split("\\s*,\\s*")).map(x -> x).collect(java.util.stream.Collectors.toList()));
				break;
			}
			case NL_BYTES__XML_ATTR: {
				String text = in.getElementText();
				setNlBytes(java.util.Arrays.stream(text.isEmpty() ? new String[0] : text.split("\\s*,\\s*")).map(x -> java.util.Base64.getDecoder().decode(x)).collect(java.util.stream.Collectors.toList()));
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
