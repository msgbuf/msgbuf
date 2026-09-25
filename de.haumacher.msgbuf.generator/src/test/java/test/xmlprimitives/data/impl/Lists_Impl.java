package test.xmlprimitives.data.impl;

/**
 * Implementation of {@link test.xmlprimitives.data.Lists}.
 */
public class Lists_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.xmlprimitives.data.Lists {

	private final java.util.List<Boolean> _lBool = new de.haumacher.msgbuf.util.ReferenceList<Boolean>() {
		@Override
		protected void beforeAdd(int index, Boolean element) {
			_listener.beforeAdd(Lists_Impl.this, L_BOOL__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, Boolean element) {
			_listener.afterRemove(Lists_Impl.this, L_BOOL__PROP, index, element);
		}

		@Override
		protected void afterChanged() {
			_listener.afterChanged(Lists_Impl.this, L_BOOL__PROP);
		}
	};

	private final java.util.List<Integer> _lInt32 = new de.haumacher.msgbuf.util.ReferenceList<Integer>() {
		@Override
		protected void beforeAdd(int index, Integer element) {
			_listener.beforeAdd(Lists_Impl.this, L_INT_32__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, Integer element) {
			_listener.afterRemove(Lists_Impl.this, L_INT_32__PROP, index, element);
		}

		@Override
		protected void afterChanged() {
			_listener.afterChanged(Lists_Impl.this, L_INT_32__PROP);
		}
	};

	private final java.util.List<Integer> _lSint32 = new de.haumacher.msgbuf.util.ReferenceList<Integer>() {
		@Override
		protected void beforeAdd(int index, Integer element) {
			_listener.beforeAdd(Lists_Impl.this, L_SINT_32__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, Integer element) {
			_listener.afterRemove(Lists_Impl.this, L_SINT_32__PROP, index, element);
		}

		@Override
		protected void afterChanged() {
			_listener.afterChanged(Lists_Impl.this, L_SINT_32__PROP);
		}
	};

	private final java.util.List<Integer> _lUint32 = new de.haumacher.msgbuf.util.ReferenceList<Integer>() {
		@Override
		protected void beforeAdd(int index, Integer element) {
			_listener.beforeAdd(Lists_Impl.this, L_UINT_32__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, Integer element) {
			_listener.afterRemove(Lists_Impl.this, L_UINT_32__PROP, index, element);
		}

		@Override
		protected void afterChanged() {
			_listener.afterChanged(Lists_Impl.this, L_UINT_32__PROP);
		}
	};

	private final java.util.List<Integer> _lFixed32 = new de.haumacher.msgbuf.util.ReferenceList<Integer>() {
		@Override
		protected void beforeAdd(int index, Integer element) {
			_listener.beforeAdd(Lists_Impl.this, L_FIXED_32__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, Integer element) {
			_listener.afterRemove(Lists_Impl.this, L_FIXED_32__PROP, index, element);
		}

		@Override
		protected void afterChanged() {
			_listener.afterChanged(Lists_Impl.this, L_FIXED_32__PROP);
		}
	};

	private final java.util.List<Integer> _lSfixed32 = new de.haumacher.msgbuf.util.ReferenceList<Integer>() {
		@Override
		protected void beforeAdd(int index, Integer element) {
			_listener.beforeAdd(Lists_Impl.this, L_SFIXED_32__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, Integer element) {
			_listener.afterRemove(Lists_Impl.this, L_SFIXED_32__PROP, index, element);
		}

		@Override
		protected void afterChanged() {
			_listener.afterChanged(Lists_Impl.this, L_SFIXED_32__PROP);
		}
	};

	private final java.util.List<Long> _lInt64 = new de.haumacher.msgbuf.util.ReferenceList<Long>() {
		@Override
		protected void beforeAdd(int index, Long element) {
			_listener.beforeAdd(Lists_Impl.this, L_INT_64__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, Long element) {
			_listener.afterRemove(Lists_Impl.this, L_INT_64__PROP, index, element);
		}

		@Override
		protected void afterChanged() {
			_listener.afterChanged(Lists_Impl.this, L_INT_64__PROP);
		}
	};

	private final java.util.List<Long> _lSint64 = new de.haumacher.msgbuf.util.ReferenceList<Long>() {
		@Override
		protected void beforeAdd(int index, Long element) {
			_listener.beforeAdd(Lists_Impl.this, L_SINT_64__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, Long element) {
			_listener.afterRemove(Lists_Impl.this, L_SINT_64__PROP, index, element);
		}

		@Override
		protected void afterChanged() {
			_listener.afterChanged(Lists_Impl.this, L_SINT_64__PROP);
		}
	};

	private final java.util.List<Long> _lUint64 = new de.haumacher.msgbuf.util.ReferenceList<Long>() {
		@Override
		protected void beforeAdd(int index, Long element) {
			_listener.beforeAdd(Lists_Impl.this, L_UINT_64__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, Long element) {
			_listener.afterRemove(Lists_Impl.this, L_UINT_64__PROP, index, element);
		}

		@Override
		protected void afterChanged() {
			_listener.afterChanged(Lists_Impl.this, L_UINT_64__PROP);
		}
	};

	private final java.util.List<Long> _lFixed64 = new de.haumacher.msgbuf.util.ReferenceList<Long>() {
		@Override
		protected void beforeAdd(int index, Long element) {
			_listener.beforeAdd(Lists_Impl.this, L_FIXED_64__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, Long element) {
			_listener.afterRemove(Lists_Impl.this, L_FIXED_64__PROP, index, element);
		}

		@Override
		protected void afterChanged() {
			_listener.afterChanged(Lists_Impl.this, L_FIXED_64__PROP);
		}
	};

	private final java.util.List<Long> _lSfixed64 = new de.haumacher.msgbuf.util.ReferenceList<Long>() {
		@Override
		protected void beforeAdd(int index, Long element) {
			_listener.beforeAdd(Lists_Impl.this, L_SFIXED_64__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, Long element) {
			_listener.afterRemove(Lists_Impl.this, L_SFIXED_64__PROP, index, element);
		}

		@Override
		protected void afterChanged() {
			_listener.afterChanged(Lists_Impl.this, L_SFIXED_64__PROP);
		}
	};

	private final java.util.List<Float> _lFloat = new de.haumacher.msgbuf.util.ReferenceList<Float>() {
		@Override
		protected void beforeAdd(int index, Float element) {
			_listener.beforeAdd(Lists_Impl.this, L_FLOAT__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, Float element) {
			_listener.afterRemove(Lists_Impl.this, L_FLOAT__PROP, index, element);
		}

		@Override
		protected void afterChanged() {
			_listener.afterChanged(Lists_Impl.this, L_FLOAT__PROP);
		}
	};

	private final java.util.List<Double> _lDouble = new de.haumacher.msgbuf.util.ReferenceList<Double>() {
		@Override
		protected void beforeAdd(int index, Double element) {
			_listener.beforeAdd(Lists_Impl.this, L_DOUBLE__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, Double element) {
			_listener.afterRemove(Lists_Impl.this, L_DOUBLE__PROP, index, element);
		}

		@Override
		protected void afterChanged() {
			_listener.afterChanged(Lists_Impl.this, L_DOUBLE__PROP);
		}
	};

	private final java.util.List<String> _lString = new de.haumacher.msgbuf.util.ReferenceList<String>() {
		@Override
		protected void beforeAdd(int index, String element) {
			_listener.beforeAdd(Lists_Impl.this, L_STRING__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, String element) {
			_listener.afterRemove(Lists_Impl.this, L_STRING__PROP, index, element);
		}

		@Override
		protected void afterChanged() {
			_listener.afterChanged(Lists_Impl.this, L_STRING__PROP);
		}
	};

	private final java.util.List<byte[]> _lBytes = new de.haumacher.msgbuf.util.ReferenceList<byte[]>() {
		@Override
		protected void beforeAdd(int index, byte[] element) {
			_listener.beforeAdd(Lists_Impl.this, L_BYTES__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, byte[] element) {
			_listener.afterRemove(Lists_Impl.this, L_BYTES__PROP, index, element);
		}

		@Override
		protected void afterChanged() {
			_listener.afterChanged(Lists_Impl.this, L_BYTES__PROP);
		}
	};

	private final java.util.List<test.xmlprimitives.data.Color> _lColor = new de.haumacher.msgbuf.util.ReferenceList<test.xmlprimitives.data.Color>() {
		@Override
		protected void beforeAdd(int index, test.xmlprimitives.data.Color element) {
			_listener.beforeAdd(Lists_Impl.this, L_COLOR__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, test.xmlprimitives.data.Color element) {
			_listener.afterRemove(Lists_Impl.this, L_COLOR__PROP, index, element);
		}

		@Override
		protected void afterChanged() {
			_listener.afterChanged(Lists_Impl.this, L_COLOR__PROP);
		}
	};

	/**
	 * Creates a {@link Lists_Impl} instance.
	 *
	 * @see test.xmlprimitives.data.Lists#create()
	 */
	public Lists_Impl() {
		super();
	}

	@Override
	public final java.util.List<Boolean> isLBool() {
		return _lBool;
	}

	@Override
	public test.xmlprimitives.data.Lists setLBool(java.util.List<? extends Boolean> value) {
		internalSetLBool(value);
		return this;
	}

	/** Internal setter for {@link #isLBool()} without chain call utility. */
	protected final void internalSetLBool(java.util.List<? extends Boolean> value) {
		_lBool.clear();
		_lBool.addAll(value);
	}

	@Override
	public test.xmlprimitives.data.Lists addLBool(boolean value) {
		internalAddLBool(value);
		return this;
	}

	/** Implementation of {@link #addLBool(boolean)} without chain call utility. */
	protected final void internalAddLBool(boolean value) {
		_lBool.add(value);
	}

	@Override
	public final void removeLBool(boolean value) {
		_lBool.remove(value);
	}

	@Override
	public final java.util.List<Integer> getLInt32() {
		return _lInt32;
	}

	@Override
	public test.xmlprimitives.data.Lists setLInt32(java.util.List<? extends Integer> value) {
		internalSetLInt32(value);
		return this;
	}

	/** Internal setter for {@link #getLInt32()} without chain call utility. */
	protected final void internalSetLInt32(java.util.List<? extends Integer> value) {
		_lInt32.clear();
		_lInt32.addAll(value);
	}

	@Override
	public test.xmlprimitives.data.Lists addLInt32(int value) {
		internalAddLInt32(value);
		return this;
	}

	/** Implementation of {@link #addLInt32(int)} without chain call utility. */
	protected final void internalAddLInt32(int value) {
		_lInt32.add(value);
	}

	@Override
	public final void removeLInt32(int value) {
		_lInt32.remove(value);
	}

	@Override
	public final java.util.List<Integer> getLSint32() {
		return _lSint32;
	}

	@Override
	public test.xmlprimitives.data.Lists setLSint32(java.util.List<? extends Integer> value) {
		internalSetLSint32(value);
		return this;
	}

	/** Internal setter for {@link #getLSint32()} without chain call utility. */
	protected final void internalSetLSint32(java.util.List<? extends Integer> value) {
		_lSint32.clear();
		_lSint32.addAll(value);
	}

	@Override
	public test.xmlprimitives.data.Lists addLSint32(int value) {
		internalAddLSint32(value);
		return this;
	}

	/** Implementation of {@link #addLSint32(int)} without chain call utility. */
	protected final void internalAddLSint32(int value) {
		_lSint32.add(value);
	}

	@Override
	public final void removeLSint32(int value) {
		_lSint32.remove(value);
	}

	@Override
	public final java.util.List<Integer> getLUint32() {
		return _lUint32;
	}

	@Override
	public test.xmlprimitives.data.Lists setLUint32(java.util.List<? extends Integer> value) {
		internalSetLUint32(value);
		return this;
	}

	/** Internal setter for {@link #getLUint32()} without chain call utility. */
	protected final void internalSetLUint32(java.util.List<? extends Integer> value) {
		_lUint32.clear();
		_lUint32.addAll(value);
	}

	@Override
	public test.xmlprimitives.data.Lists addLUint32(int value) {
		internalAddLUint32(value);
		return this;
	}

	/** Implementation of {@link #addLUint32(int)} without chain call utility. */
	protected final void internalAddLUint32(int value) {
		_lUint32.add(value);
	}

	@Override
	public final void removeLUint32(int value) {
		_lUint32.remove(value);
	}

	@Override
	public final java.util.List<Integer> getLFixed32() {
		return _lFixed32;
	}

	@Override
	public test.xmlprimitives.data.Lists setLFixed32(java.util.List<? extends Integer> value) {
		internalSetLFixed32(value);
		return this;
	}

	/** Internal setter for {@link #getLFixed32()} without chain call utility. */
	protected final void internalSetLFixed32(java.util.List<? extends Integer> value) {
		_lFixed32.clear();
		_lFixed32.addAll(value);
	}

	@Override
	public test.xmlprimitives.data.Lists addLFixed32(int value) {
		internalAddLFixed32(value);
		return this;
	}

	/** Implementation of {@link #addLFixed32(int)} without chain call utility. */
	protected final void internalAddLFixed32(int value) {
		_lFixed32.add(value);
	}

	@Override
	public final void removeLFixed32(int value) {
		_lFixed32.remove(value);
	}

	@Override
	public final java.util.List<Integer> getLSfixed32() {
		return _lSfixed32;
	}

	@Override
	public test.xmlprimitives.data.Lists setLSfixed32(java.util.List<? extends Integer> value) {
		internalSetLSfixed32(value);
		return this;
	}

	/** Internal setter for {@link #getLSfixed32()} without chain call utility. */
	protected final void internalSetLSfixed32(java.util.List<? extends Integer> value) {
		_lSfixed32.clear();
		_lSfixed32.addAll(value);
	}

	@Override
	public test.xmlprimitives.data.Lists addLSfixed32(int value) {
		internalAddLSfixed32(value);
		return this;
	}

	/** Implementation of {@link #addLSfixed32(int)} without chain call utility. */
	protected final void internalAddLSfixed32(int value) {
		_lSfixed32.add(value);
	}

	@Override
	public final void removeLSfixed32(int value) {
		_lSfixed32.remove(value);
	}

	@Override
	public final java.util.List<Long> getLInt64() {
		return _lInt64;
	}

	@Override
	public test.xmlprimitives.data.Lists setLInt64(java.util.List<? extends Long> value) {
		internalSetLInt64(value);
		return this;
	}

	/** Internal setter for {@link #getLInt64()} without chain call utility. */
	protected final void internalSetLInt64(java.util.List<? extends Long> value) {
		_lInt64.clear();
		_lInt64.addAll(value);
	}

	@Override
	public test.xmlprimitives.data.Lists addLInt64(long value) {
		internalAddLInt64(value);
		return this;
	}

	/** Implementation of {@link #addLInt64(long)} without chain call utility. */
	protected final void internalAddLInt64(long value) {
		_lInt64.add(value);
	}

	@Override
	public final void removeLInt64(long value) {
		_lInt64.remove(value);
	}

	@Override
	public final java.util.List<Long> getLSint64() {
		return _lSint64;
	}

	@Override
	public test.xmlprimitives.data.Lists setLSint64(java.util.List<? extends Long> value) {
		internalSetLSint64(value);
		return this;
	}

	/** Internal setter for {@link #getLSint64()} without chain call utility. */
	protected final void internalSetLSint64(java.util.List<? extends Long> value) {
		_lSint64.clear();
		_lSint64.addAll(value);
	}

	@Override
	public test.xmlprimitives.data.Lists addLSint64(long value) {
		internalAddLSint64(value);
		return this;
	}

	/** Implementation of {@link #addLSint64(long)} without chain call utility. */
	protected final void internalAddLSint64(long value) {
		_lSint64.add(value);
	}

	@Override
	public final void removeLSint64(long value) {
		_lSint64.remove(value);
	}

	@Override
	public final java.util.List<Long> getLUint64() {
		return _lUint64;
	}

	@Override
	public test.xmlprimitives.data.Lists setLUint64(java.util.List<? extends Long> value) {
		internalSetLUint64(value);
		return this;
	}

	/** Internal setter for {@link #getLUint64()} without chain call utility. */
	protected final void internalSetLUint64(java.util.List<? extends Long> value) {
		_lUint64.clear();
		_lUint64.addAll(value);
	}

	@Override
	public test.xmlprimitives.data.Lists addLUint64(long value) {
		internalAddLUint64(value);
		return this;
	}

	/** Implementation of {@link #addLUint64(long)} without chain call utility. */
	protected final void internalAddLUint64(long value) {
		_lUint64.add(value);
	}

	@Override
	public final void removeLUint64(long value) {
		_lUint64.remove(value);
	}

	@Override
	public final java.util.List<Long> getLFixed64() {
		return _lFixed64;
	}

	@Override
	public test.xmlprimitives.data.Lists setLFixed64(java.util.List<? extends Long> value) {
		internalSetLFixed64(value);
		return this;
	}

	/** Internal setter for {@link #getLFixed64()} without chain call utility. */
	protected final void internalSetLFixed64(java.util.List<? extends Long> value) {
		_lFixed64.clear();
		_lFixed64.addAll(value);
	}

	@Override
	public test.xmlprimitives.data.Lists addLFixed64(long value) {
		internalAddLFixed64(value);
		return this;
	}

	/** Implementation of {@link #addLFixed64(long)} without chain call utility. */
	protected final void internalAddLFixed64(long value) {
		_lFixed64.add(value);
	}

	@Override
	public final void removeLFixed64(long value) {
		_lFixed64.remove(value);
	}

	@Override
	public final java.util.List<Long> getLSfixed64() {
		return _lSfixed64;
	}

	@Override
	public test.xmlprimitives.data.Lists setLSfixed64(java.util.List<? extends Long> value) {
		internalSetLSfixed64(value);
		return this;
	}

	/** Internal setter for {@link #getLSfixed64()} without chain call utility. */
	protected final void internalSetLSfixed64(java.util.List<? extends Long> value) {
		_lSfixed64.clear();
		_lSfixed64.addAll(value);
	}

	@Override
	public test.xmlprimitives.data.Lists addLSfixed64(long value) {
		internalAddLSfixed64(value);
		return this;
	}

	/** Implementation of {@link #addLSfixed64(long)} without chain call utility. */
	protected final void internalAddLSfixed64(long value) {
		_lSfixed64.add(value);
	}

	@Override
	public final void removeLSfixed64(long value) {
		_lSfixed64.remove(value);
	}

	@Override
	public final java.util.List<Float> getLFloat() {
		return _lFloat;
	}

	@Override
	public test.xmlprimitives.data.Lists setLFloat(java.util.List<? extends Float> value) {
		internalSetLFloat(value);
		return this;
	}

	/** Internal setter for {@link #getLFloat()} without chain call utility. */
	protected final void internalSetLFloat(java.util.List<? extends Float> value) {
		_lFloat.clear();
		_lFloat.addAll(value);
	}

	@Override
	public test.xmlprimitives.data.Lists addLFloat(float value) {
		internalAddLFloat(value);
		return this;
	}

	/** Implementation of {@link #addLFloat(float)} without chain call utility. */
	protected final void internalAddLFloat(float value) {
		_lFloat.add(value);
	}

	@Override
	public final void removeLFloat(float value) {
		_lFloat.remove(value);
	}

	@Override
	public final java.util.List<Double> getLDouble() {
		return _lDouble;
	}

	@Override
	public test.xmlprimitives.data.Lists setLDouble(java.util.List<? extends Double> value) {
		internalSetLDouble(value);
		return this;
	}

	/** Internal setter for {@link #getLDouble()} without chain call utility. */
	protected final void internalSetLDouble(java.util.List<? extends Double> value) {
		_lDouble.clear();
		_lDouble.addAll(value);
	}

	@Override
	public test.xmlprimitives.data.Lists addLDouble(double value) {
		internalAddLDouble(value);
		return this;
	}

	/** Implementation of {@link #addLDouble(double)} without chain call utility. */
	protected final void internalAddLDouble(double value) {
		_lDouble.add(value);
	}

	@Override
	public final void removeLDouble(double value) {
		_lDouble.remove(value);
	}

	@Override
	public final java.util.List<String> getLString() {
		return _lString;
	}

	@Override
	public test.xmlprimitives.data.Lists setLString(java.util.List<? extends String> value) {
		internalSetLString(value);
		return this;
	}

	/** Internal setter for {@link #getLString()} without chain call utility. */
	protected final void internalSetLString(java.util.List<? extends String> value) {
		_lString.clear();
		_lString.addAll(value);
	}

	@Override
	public test.xmlprimitives.data.Lists addLString(String value) {
		internalAddLString(value);
		return this;
	}

	/** Implementation of {@link #addLString(String)} without chain call utility. */
	protected final void internalAddLString(String value) {
		_lString.add(value);
	}

	@Override
	public final void removeLString(String value) {
		_lString.remove(value);
	}

	@Override
	public final java.util.List<byte[]> getLBytes() {
		return _lBytes;
	}

	@Override
	public test.xmlprimitives.data.Lists setLBytes(java.util.List<? extends byte[]> value) {
		internalSetLBytes(value);
		return this;
	}

	/** Internal setter for {@link #getLBytes()} without chain call utility. */
	protected final void internalSetLBytes(java.util.List<? extends byte[]> value) {
		_lBytes.clear();
		_lBytes.addAll(value);
	}

	@Override
	public test.xmlprimitives.data.Lists addLByte(byte[] value) {
		internalAddLByte(value);
		return this;
	}

	/** Implementation of {@link #addLByte(byte[])} without chain call utility. */
	protected final void internalAddLByte(byte[] value) {
		_lBytes.add(value);
	}

	@Override
	public final void removeLByte(byte[] value) {
		_lBytes.remove(value);
	}

	@Override
	public final java.util.List<test.xmlprimitives.data.Color> getLColor() {
		return _lColor;
	}

	@Override
	public test.xmlprimitives.data.Lists setLColor(java.util.List<? extends test.xmlprimitives.data.Color> value) {
		internalSetLColor(value);
		return this;
	}

	/** Internal setter for {@link #getLColor()} without chain call utility. */
	protected final void internalSetLColor(java.util.List<? extends test.xmlprimitives.data.Color> value) {
		if (value == null) throw new IllegalArgumentException("Property 'lColor' cannot be null.");
		_lColor.clear();
		_lColor.addAll(value);
	}

	@Override
	public test.xmlprimitives.data.Lists addLColor(test.xmlprimitives.data.Color value) {
		internalAddLColor(value);
		return this;
	}

	/** Implementation of {@link #addLColor(test.xmlprimitives.data.Color)} without chain call utility. */
	protected final void internalAddLColor(test.xmlprimitives.data.Color value) {
		_lColor.add(value);
	}

	@Override
	public final void removeLColor(test.xmlprimitives.data.Color value) {
		_lColor.remove(value);
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.xmlprimitives.data.Lists registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.xmlprimitives.data.Lists unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		internalUnregisterListener(l);
		return this;
	}

	protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
	}

	@Override
	public String jsonType() {
		return LISTS__TYPE;
	}

	static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			L_BOOL__PROP, 
			L_INT_32__PROP, 
			L_SINT_32__PROP, 
			L_UINT_32__PROP, 
			L_FIXED_32__PROP, 
			L_SFIXED_32__PROP, 
			L_INT_64__PROP, 
			L_SINT_64__PROP, 
			L_UINT_64__PROP, 
			L_FIXED_64__PROP, 
			L_SFIXED_64__PROP, 
			L_FLOAT__PROP, 
			L_DOUBLE__PROP, 
			L_STRING__PROP, 
			L_BYTES__PROP, 
			L_COLOR__PROP);
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
			case L_BOOL__PROP: return isLBool();
			case L_INT_32__PROP: return getLInt32();
			case L_SINT_32__PROP: return getLSint32();
			case L_UINT_32__PROP: return getLUint32();
			case L_FIXED_32__PROP: return getLFixed32();
			case L_SFIXED_32__PROP: return getLSfixed32();
			case L_INT_64__PROP: return getLInt64();
			case L_SINT_64__PROP: return getLSint64();
			case L_UINT_64__PROP: return getLUint64();
			case L_FIXED_64__PROP: return getLFixed64();
			case L_SFIXED_64__PROP: return getLSfixed64();
			case L_FLOAT__PROP: return getLFloat();
			case L_DOUBLE__PROP: return getLDouble();
			case L_STRING__PROP: return getLString();
			case L_BYTES__PROP: return getLBytes();
			case L_COLOR__PROP: return getLColor();
			default: return test.xmlprimitives.data.Lists.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case L_BOOL__PROP: internalSetLBool(de.haumacher.msgbuf.util.Conversions.asList(Boolean.class, value)); break;
			case L_INT_32__PROP: internalSetLInt32(de.haumacher.msgbuf.util.Conversions.asList(Integer.class, value)); break;
			case L_SINT_32__PROP: internalSetLSint32(de.haumacher.msgbuf.util.Conversions.asList(Integer.class, value)); break;
			case L_UINT_32__PROP: internalSetLUint32(de.haumacher.msgbuf.util.Conversions.asList(Integer.class, value)); break;
			case L_FIXED_32__PROP: internalSetLFixed32(de.haumacher.msgbuf.util.Conversions.asList(Integer.class, value)); break;
			case L_SFIXED_32__PROP: internalSetLSfixed32(de.haumacher.msgbuf.util.Conversions.asList(Integer.class, value)); break;
			case L_INT_64__PROP: internalSetLInt64(de.haumacher.msgbuf.util.Conversions.asList(Long.class, value)); break;
			case L_SINT_64__PROP: internalSetLSint64(de.haumacher.msgbuf.util.Conversions.asList(Long.class, value)); break;
			case L_UINT_64__PROP: internalSetLUint64(de.haumacher.msgbuf.util.Conversions.asList(Long.class, value)); break;
			case L_FIXED_64__PROP: internalSetLFixed64(de.haumacher.msgbuf.util.Conversions.asList(Long.class, value)); break;
			case L_SFIXED_64__PROP: internalSetLSfixed64(de.haumacher.msgbuf.util.Conversions.asList(Long.class, value)); break;
			case L_FLOAT__PROP: internalSetLFloat(de.haumacher.msgbuf.util.Conversions.asList(Float.class, value)); break;
			case L_DOUBLE__PROP: internalSetLDouble(de.haumacher.msgbuf.util.Conversions.asList(Double.class, value)); break;
			case L_STRING__PROP: internalSetLString(de.haumacher.msgbuf.util.Conversions.asList(String.class, value)); break;
			case L_BYTES__PROP: internalSetLBytes(de.haumacher.msgbuf.util.Conversions.asList(byte[].class, value)); break;
			case L_COLOR__PROP: internalSetLColor(de.haumacher.msgbuf.util.Conversions.asList(test.xmlprimitives.data.Color.class, value)); break;
		}
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(L_BOOL__PROP);
		out.beginArray();
		for (boolean x : isLBool()) {
			out.value(x);
		}
		out.endArray();
		out.name(L_INT_32__PROP);
		out.beginArray();
		for (int x : getLInt32()) {
			out.value(x);
		}
		out.endArray();
		out.name(L_SINT_32__PROP);
		out.beginArray();
		for (int x : getLSint32()) {
			out.value(x);
		}
		out.endArray();
		out.name(L_UINT_32__PROP);
		out.beginArray();
		for (int x : getLUint32()) {
			out.value(x);
		}
		out.endArray();
		out.name(L_FIXED_32__PROP);
		out.beginArray();
		for (int x : getLFixed32()) {
			out.value(x);
		}
		out.endArray();
		out.name(L_SFIXED_32__PROP);
		out.beginArray();
		for (int x : getLSfixed32()) {
			out.value(x);
		}
		out.endArray();
		out.name(L_INT_64__PROP);
		out.beginArray();
		for (long x : getLInt64()) {
			out.value(x);
		}
		out.endArray();
		out.name(L_SINT_64__PROP);
		out.beginArray();
		for (long x : getLSint64()) {
			out.value(x);
		}
		out.endArray();
		out.name(L_UINT_64__PROP);
		out.beginArray();
		for (long x : getLUint64()) {
			out.value(x);
		}
		out.endArray();
		out.name(L_FIXED_64__PROP);
		out.beginArray();
		for (long x : getLFixed64()) {
			out.value(x);
		}
		out.endArray();
		out.name(L_SFIXED_64__PROP);
		out.beginArray();
		for (long x : getLSfixed64()) {
			out.value(x);
		}
		out.endArray();
		out.name(L_FLOAT__PROP);
		out.beginArray();
		for (float x : getLFloat()) {
			out.value(x);
		}
		out.endArray();
		out.name(L_DOUBLE__PROP);
		out.beginArray();
		for (double x : getLDouble()) {
			out.value(x);
		}
		out.endArray();
		out.name(L_STRING__PROP);
		out.beginArray();
		for (String x : getLString()) {
			out.value(x);
		}
		out.endArray();
		out.name(L_BYTES__PROP);
		out.beginArray();
		for (byte[] x : getLBytes()) {
			de.haumacher.msgbuf.json.JsonUtil.writeBinaryOptional(out, x);
		}
		out.endArray();
		out.name(L_COLOR__PROP);
		out.beginArray();
		for (test.xmlprimitives.data.Color x : getLColor()) {
			x.writeTo(out);
		}
		out.endArray();
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case L_BOOL__PROP: {
				java.util.List<Boolean> newValue = new java.util.ArrayList<>();
				in.beginArray();
				while (in.hasNext()) {
					newValue.add(in.nextBoolean());
				}
				in.endArray();
				setLBool(newValue);
			}
			break;
			case L_INT_32__PROP: {
				java.util.List<Integer> newValue = new java.util.ArrayList<>();
				in.beginArray();
				while (in.hasNext()) {
					newValue.add(in.nextInt());
				}
				in.endArray();
				setLInt32(newValue);
			}
			break;
			case L_SINT_32__PROP: {
				java.util.List<Integer> newValue = new java.util.ArrayList<>();
				in.beginArray();
				while (in.hasNext()) {
					newValue.add(in.nextInt());
				}
				in.endArray();
				setLSint32(newValue);
			}
			break;
			case L_UINT_32__PROP: {
				java.util.List<Integer> newValue = new java.util.ArrayList<>();
				in.beginArray();
				while (in.hasNext()) {
					newValue.add(in.nextInt());
				}
				in.endArray();
				setLUint32(newValue);
			}
			break;
			case L_FIXED_32__PROP: {
				java.util.List<Integer> newValue = new java.util.ArrayList<>();
				in.beginArray();
				while (in.hasNext()) {
					newValue.add(in.nextInt());
				}
				in.endArray();
				setLFixed32(newValue);
			}
			break;
			case L_SFIXED_32__PROP: {
				java.util.List<Integer> newValue = new java.util.ArrayList<>();
				in.beginArray();
				while (in.hasNext()) {
					newValue.add(in.nextInt());
				}
				in.endArray();
				setLSfixed32(newValue);
			}
			break;
			case L_INT_64__PROP: {
				java.util.List<Long> newValue = new java.util.ArrayList<>();
				in.beginArray();
				while (in.hasNext()) {
					newValue.add(in.nextLong());
				}
				in.endArray();
				setLInt64(newValue);
			}
			break;
			case L_SINT_64__PROP: {
				java.util.List<Long> newValue = new java.util.ArrayList<>();
				in.beginArray();
				while (in.hasNext()) {
					newValue.add(in.nextLong());
				}
				in.endArray();
				setLSint64(newValue);
			}
			break;
			case L_UINT_64__PROP: {
				java.util.List<Long> newValue = new java.util.ArrayList<>();
				in.beginArray();
				while (in.hasNext()) {
					newValue.add(in.nextLong());
				}
				in.endArray();
				setLUint64(newValue);
			}
			break;
			case L_FIXED_64__PROP: {
				java.util.List<Long> newValue = new java.util.ArrayList<>();
				in.beginArray();
				while (in.hasNext()) {
					newValue.add(in.nextLong());
				}
				in.endArray();
				setLFixed64(newValue);
			}
			break;
			case L_SFIXED_64__PROP: {
				java.util.List<Long> newValue = new java.util.ArrayList<>();
				in.beginArray();
				while (in.hasNext()) {
					newValue.add(in.nextLong());
				}
				in.endArray();
				setLSfixed64(newValue);
			}
			break;
			case L_FLOAT__PROP: {
				java.util.List<Float> newValue = new java.util.ArrayList<>();
				in.beginArray();
				while (in.hasNext()) {
					newValue.add((float) in.nextDouble());
				}
				in.endArray();
				setLFloat(newValue);
			}
			break;
			case L_DOUBLE__PROP: {
				java.util.List<Double> newValue = new java.util.ArrayList<>();
				in.beginArray();
				while (in.hasNext()) {
					newValue.add(in.nextDouble());
				}
				in.endArray();
				setLDouble(newValue);
			}
			break;
			case L_STRING__PROP: {
				java.util.List<String> newValue = new java.util.ArrayList<>();
				in.beginArray();
				while (in.hasNext()) {
					newValue.add(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in));
				}
				in.endArray();
				setLString(newValue);
			}
			break;
			case L_BYTES__PROP: {
				java.util.List<byte[]> newValue = new java.util.ArrayList<>();
				in.beginArray();
				while (in.hasNext()) {
					newValue.add(de.haumacher.msgbuf.json.JsonUtil.nextBinaryOptional(in));
				}
				in.endArray();
				setLBytes(newValue);
			}
			break;
			case L_COLOR__PROP: {
				java.util.List<test.xmlprimitives.data.Color> newValue = new java.util.ArrayList<>();
				in.beginArray();
				while (in.hasNext()) {
					newValue.add(test.xmlprimitives.data.Color.readColor(in));
				}
				in.endArray();
				setLColor(newValue);
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
		out.name(L_BOOL__ID);
		{
			java.util.List<Boolean> values = isLBool();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.INT, values.size());
			for (boolean x : values) {
				out.value(x);
			}
			out.endArray();
		}
		out.name(L_INT_32__ID);
		{
			java.util.List<Integer> values = getLInt32();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.INT, values.size());
			for (int x : values) {
				out.value(x);
			}
			out.endArray();
		}
		out.name(L_SINT_32__ID);
		{
			java.util.List<Integer> values = getLSint32();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.SINT, values.size());
			for (int x : values) {
				out.valueSigned(x);
			}
			out.endArray();
		}
		out.name(L_UINT_32__ID);
		{
			java.util.List<Integer> values = getLUint32();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.INT, values.size());
			for (int x : values) {
				out.value(x);
			}
			out.endArray();
		}
		out.name(L_FIXED_32__ID);
		{
			java.util.List<Integer> values = getLFixed32();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.FINT, values.size());
			for (int x : values) {
				out.valueFixed(x);
			}
			out.endArray();
		}
		out.name(L_SFIXED_32__ID);
		{
			java.util.List<Integer> values = getLSfixed32();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.FINT, values.size());
			for (int x : values) {
				out.valueFixed(x);
			}
			out.endArray();
		}
		out.name(L_INT_64__ID);
		{
			java.util.List<Long> values = getLInt64();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.LONG, values.size());
			for (long x : values) {
				out.value(x);
			}
			out.endArray();
		}
		out.name(L_SINT_64__ID);
		{
			java.util.List<Long> values = getLSint64();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.SLONG, values.size());
			for (long x : values) {
				out.valueSigned(x);
			}
			out.endArray();
		}
		out.name(L_UINT_64__ID);
		{
			java.util.List<Long> values = getLUint64();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.LONG, values.size());
			for (long x : values) {
				out.value(x);
			}
			out.endArray();
		}
		out.name(L_FIXED_64__ID);
		{
			java.util.List<Long> values = getLFixed64();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.FLONG, values.size());
			for (long x : values) {
				out.valueFixed(x);
			}
			out.endArray();
		}
		out.name(L_SFIXED_64__ID);
		{
			java.util.List<Long> values = getLSfixed64();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.FLONG, values.size());
			for (long x : values) {
				out.valueFixed(x);
			}
			out.endArray();
		}
		out.name(L_FLOAT__ID);
		{
			java.util.List<Float> values = getLFloat();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.FLOAT, values.size());
			for (float x : values) {
				out.value(x);
			}
			out.endArray();
		}
		out.name(L_DOUBLE__ID);
		{
			java.util.List<Double> values = getLDouble();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.DOUBLE, values.size());
			for (double x : values) {
				out.value(x);
			}
			out.endArray();
		}
		out.name(L_STRING__ID);
		{
			java.util.List<String> values = getLString();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.STRING, values.size());
			for (String x : values) {
				out.value(x);
			}
			out.endArray();
		}
		out.name(L_BYTES__ID);
		{
			java.util.List<byte[]> values = getLBytes();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.BINARY, values.size());
			for (byte[] x : values) {
				out.value(x);
			}
			out.endArray();
		}
		out.name(L_COLOR__ID);
		{
			java.util.List<test.xmlprimitives.data.Color> values = getLColor();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.INT, values.size());
			for (test.xmlprimitives.data.Color x : values) {
				x.writeTo(out);
			}
			out.endArray();
		}
	}

	/** Helper for creating an object of type {@link test.xmlprimitives.data.Lists} from a polymorphic composition. */
	public static test.xmlprimitives.data.Lists readLists_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.xmlprimitives.data.impl.Lists_Impl result = new Lists_Impl();
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
			case L_BOOL__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addLBool(in.nextBoolean());
				}
				in.endArray();
			}
			break;
			case L_INT_32__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addLInt32(in.nextInt());
				}
				in.endArray();
			}
			break;
			case L_SINT_32__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addLSint32(in.nextIntSigned());
				}
				in.endArray();
			}
			break;
			case L_UINT_32__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addLUint32(in.nextInt());
				}
				in.endArray();
			}
			break;
			case L_FIXED_32__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addLFixed32(in.nextIntFixed());
				}
				in.endArray();
			}
			break;
			case L_SFIXED_32__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addLSfixed32(in.nextIntFixed());
				}
				in.endArray();
			}
			break;
			case L_INT_64__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addLInt64(in.nextLong());
				}
				in.endArray();
			}
			break;
			case L_SINT_64__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addLSint64(in.nextLongSigned());
				}
				in.endArray();
			}
			break;
			case L_UINT_64__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addLUint64(in.nextLong());
				}
				in.endArray();
			}
			break;
			case L_FIXED_64__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addLFixed64(in.nextLongFixed());
				}
				in.endArray();
			}
			break;
			case L_SFIXED_64__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addLSfixed64(in.nextLongFixed());
				}
				in.endArray();
			}
			break;
			case L_FLOAT__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addLFloat(in.nextFloat());
				}
				in.endArray();
			}
			break;
			case L_DOUBLE__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addLDouble(in.nextDouble());
				}
				in.endArray();
			}
			break;
			case L_STRING__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addLString(in.nextString());
				}
				in.endArray();
			}
			break;
			case L_BYTES__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addLByte(in.nextBinary());
				}
				in.endArray();
			}
			break;
			case L_COLOR__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addLColor(test.xmlprimitives.data.Color.readColor(in));
				}
				in.endArray();
			}
			break;
			default: in.skipValue(); 
		}
	}

	/** XML element name representing a {@link test.xmlprimitives.data.Lists} type. */
	public static final String LISTS__XML_ELEMENT = "lists";

	/** XML attribute or element name of a {@link #isLBool} property. */
	private static final String L_BOOL__XML_ATTR = "l-bool";

	/** XML attribute or element name of a {@link #getLInt32} property. */
	private static final String L_INT_32__XML_ATTR = "l-int-32";

	/** XML attribute or element name of a {@link #getLSint32} property. */
	private static final String L_SINT_32__XML_ATTR = "l-sint-32";

	/** XML attribute or element name of a {@link #getLUint32} property. */
	private static final String L_UINT_32__XML_ATTR = "l-uint-32";

	/** XML attribute or element name of a {@link #getLFixed32} property. */
	private static final String L_FIXED_32__XML_ATTR = "l-fixed-32";

	/** XML attribute or element name of a {@link #getLSfixed32} property. */
	private static final String L_SFIXED_32__XML_ATTR = "l-sfixed-32";

	/** XML attribute or element name of a {@link #getLInt64} property. */
	private static final String L_INT_64__XML_ATTR = "l-int-64";

	/** XML attribute or element name of a {@link #getLSint64} property. */
	private static final String L_SINT_64__XML_ATTR = "l-sint-64";

	/** XML attribute or element name of a {@link #getLUint64} property. */
	private static final String L_UINT_64__XML_ATTR = "l-uint-64";

	/** XML attribute or element name of a {@link #getLFixed64} property. */
	private static final String L_FIXED_64__XML_ATTR = "l-fixed-64";

	/** XML attribute or element name of a {@link #getLSfixed64} property. */
	private static final String L_SFIXED_64__XML_ATTR = "l-sfixed-64";

	/** XML attribute or element name of a {@link #getLFloat} property. */
	private static final String L_FLOAT__XML_ATTR = "l-float";

	/** XML attribute or element name of a {@link #getLDouble} property. */
	private static final String L_DOUBLE__XML_ATTR = "l-double";

	/** XML attribute or element name of a {@link #getLString} property. */
	private static final String L_STRING__XML_ATTR = "l-string";

	/** XML attribute or element name of a {@link #getLBytes} property. */
	private static final String L_BYTES__XML_ATTR = "l-bytes";

	/** XML attribute or element name of a {@link #getLColor} property. */
	private static final String L_COLOR__XML_ATTR = "l-color";

	@Override
	public String getXmlTagName() {
		return LISTS__XML_ELEMENT;
	}

	@Override
	public final void writeContent(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		writeAttributes(out);
		writeElements(out);
	}

	/** Serializes all fields that are written as XML attributes. */
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		out.writeAttribute(L_BOOL__XML_ATTR, isLBool().stream().map(x -> Boolean.toString(x)).collect(java.util.stream.Collectors.joining(", ")));
		out.writeAttribute(L_INT_32__XML_ATTR, getLInt32().stream().map(x -> Integer.toString(x)).collect(java.util.stream.Collectors.joining(", ")));
		out.writeAttribute(L_SINT_32__XML_ATTR, getLSint32().stream().map(x -> Integer.toString(x)).collect(java.util.stream.Collectors.joining(", ")));
		out.writeAttribute(L_UINT_32__XML_ATTR, getLUint32().stream().map(x -> Long.toString(Integer.toUnsignedLong(x))).collect(java.util.stream.Collectors.joining(", ")));
		out.writeAttribute(L_FIXED_32__XML_ATTR, getLFixed32().stream().map(x -> Long.toString(Integer.toUnsignedLong(x))).collect(java.util.stream.Collectors.joining(", ")));
		out.writeAttribute(L_SFIXED_32__XML_ATTR, getLSfixed32().stream().map(x -> Integer.toString(x)).collect(java.util.stream.Collectors.joining(", ")));
		out.writeAttribute(L_INT_64__XML_ATTR, getLInt64().stream().map(x -> Long.toString(x)).collect(java.util.stream.Collectors.joining(", ")));
		out.writeAttribute(L_SINT_64__XML_ATTR, getLSint64().stream().map(x -> Long.toString(x)).collect(java.util.stream.Collectors.joining(", ")));
		out.writeAttribute(L_UINT_64__XML_ATTR, getLUint64().stream().map(x -> Long.toString(x)).collect(java.util.stream.Collectors.joining(", ")));
		out.writeAttribute(L_FIXED_64__XML_ATTR, getLFixed64().stream().map(x -> Long.toString(x)).collect(java.util.stream.Collectors.joining(", ")));
		out.writeAttribute(L_SFIXED_64__XML_ATTR, getLSfixed64().stream().map(x -> Long.toString(x)).collect(java.util.stream.Collectors.joining(", ")));
		out.writeAttribute(L_FLOAT__XML_ATTR, getLFloat().stream().map(x -> Float.toString(x)).collect(java.util.stream.Collectors.joining(", ")));
		out.writeAttribute(L_DOUBLE__XML_ATTR, getLDouble().stream().map(x -> Double.toString(x)).collect(java.util.stream.Collectors.joining(", ")));
		out.writeAttribute(L_STRING__XML_ATTR, getLString().stream().map(x -> x).collect(java.util.stream.Collectors.joining(", ")));
		out.writeAttribute(L_BYTES__XML_ATTR, getLBytes().stream().map(x -> java.util.Base64.getEncoder().encodeToString(x)).collect(java.util.stream.Collectors.joining(", ")));
		out.writeAttribute(L_COLOR__XML_ATTR, getLColor().stream().map(x -> x.protocolName()).collect(java.util.stream.Collectors.joining(", ")));
	}

	/** Serializes all fields that are written as XML elements. */
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		// No element fields.
	}

	/** Creates a new {@link test.xmlprimitives.data.Lists} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Lists_Impl readLists_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		Lists_Impl result = new Lists_Impl();
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
			case L_BOOL__XML_ATTR: {
				setLBool(java.util.Arrays.stream(value.isEmpty() ? new String[0] : value.split("\\s*,\\s*")).map(x -> Boolean.parseBoolean(x)).collect(java.util.stream.Collectors.toList()));
				break;
			}
			case L_INT_32__XML_ATTR: {
				setLInt32(java.util.Arrays.stream(value.isEmpty() ? new String[0] : value.split("\\s*,\\s*")).map(x -> Integer.parseInt(x)).collect(java.util.stream.Collectors.toList()));
				break;
			}
			case L_SINT_32__XML_ATTR: {
				setLSint32(java.util.Arrays.stream(value.isEmpty() ? new String[0] : value.split("\\s*,\\s*")).map(x -> Integer.parseInt(x)).collect(java.util.stream.Collectors.toList()));
				break;
			}
			case L_UINT_32__XML_ATTR: {
				setLUint32(java.util.Arrays.stream(value.isEmpty() ? new String[0] : value.split("\\s*,\\s*")).map(x -> (int) Long.parseLong(x)).collect(java.util.stream.Collectors.toList()));
				break;
			}
			case L_FIXED_32__XML_ATTR: {
				setLFixed32(java.util.Arrays.stream(value.isEmpty() ? new String[0] : value.split("\\s*,\\s*")).map(x -> (int) Long.parseLong(x)).collect(java.util.stream.Collectors.toList()));
				break;
			}
			case L_SFIXED_32__XML_ATTR: {
				setLSfixed32(java.util.Arrays.stream(value.isEmpty() ? new String[0] : value.split("\\s*,\\s*")).map(x -> Integer.parseInt(x)).collect(java.util.stream.Collectors.toList()));
				break;
			}
			case L_INT_64__XML_ATTR: {
				setLInt64(java.util.Arrays.stream(value.isEmpty() ? new String[0] : value.split("\\s*,\\s*")).map(x -> Long.parseLong(x)).collect(java.util.stream.Collectors.toList()));
				break;
			}
			case L_SINT_64__XML_ATTR: {
				setLSint64(java.util.Arrays.stream(value.isEmpty() ? new String[0] : value.split("\\s*,\\s*")).map(x -> Long.parseLong(x)).collect(java.util.stream.Collectors.toList()));
				break;
			}
			case L_UINT_64__XML_ATTR: {
				setLUint64(java.util.Arrays.stream(value.isEmpty() ? new String[0] : value.split("\\s*,\\s*")).map(x -> Long.parseLong(x)).collect(java.util.stream.Collectors.toList()));
				break;
			}
			case L_FIXED_64__XML_ATTR: {
				setLFixed64(java.util.Arrays.stream(value.isEmpty() ? new String[0] : value.split("\\s*,\\s*")).map(x -> Long.parseLong(x)).collect(java.util.stream.Collectors.toList()));
				break;
			}
			case L_SFIXED_64__XML_ATTR: {
				setLSfixed64(java.util.Arrays.stream(value.isEmpty() ? new String[0] : value.split("\\s*,\\s*")).map(x -> Long.parseLong(x)).collect(java.util.stream.Collectors.toList()));
				break;
			}
			case L_FLOAT__XML_ATTR: {
				setLFloat(java.util.Arrays.stream(value.isEmpty() ? new String[0] : value.split("\\s*,\\s*")).map(x -> Float.parseFloat(x)).collect(java.util.stream.Collectors.toList()));
				break;
			}
			case L_DOUBLE__XML_ATTR: {
				setLDouble(java.util.Arrays.stream(value.isEmpty() ? new String[0] : value.split("\\s*,\\s*")).map(x -> Double.parseDouble(x)).collect(java.util.stream.Collectors.toList()));
				break;
			}
			case L_STRING__XML_ATTR: {
				setLString(java.util.Arrays.stream(value.isEmpty() ? new String[0] : value.split("\\s*,\\s*")).map(x -> x).collect(java.util.stream.Collectors.toList()));
				break;
			}
			case L_BYTES__XML_ATTR: {
				setLBytes(java.util.Arrays.stream(value.isEmpty() ? new String[0] : value.split("\\s*,\\s*")).map(x -> java.util.Base64.getDecoder().decode(x)).collect(java.util.stream.Collectors.toList()));
				break;
			}
			case L_COLOR__XML_ATTR: {
				setLColor(java.util.Arrays.stream(value.isEmpty() ? new String[0] : value.split("\\s*,\\s*")).map(x -> test.xmlprimitives.data.Color.valueOfProtocol(x)).collect(java.util.stream.Collectors.toList()));
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
			case L_BOOL__XML_ATTR: {
				String text = in.getElementText();
				setLBool(java.util.Arrays.stream(text.isEmpty() ? new String[0] : text.split("\\s*,\\s*")).map(x -> Boolean.parseBoolean(x)).collect(java.util.stream.Collectors.toList()));
				break;
			}
			case L_INT_32__XML_ATTR: {
				String text = in.getElementText();
				setLInt32(java.util.Arrays.stream(text.isEmpty() ? new String[0] : text.split("\\s*,\\s*")).map(x -> Integer.parseInt(x)).collect(java.util.stream.Collectors.toList()));
				break;
			}
			case L_SINT_32__XML_ATTR: {
				String text = in.getElementText();
				setLSint32(java.util.Arrays.stream(text.isEmpty() ? new String[0] : text.split("\\s*,\\s*")).map(x -> Integer.parseInt(x)).collect(java.util.stream.Collectors.toList()));
				break;
			}
			case L_UINT_32__XML_ATTR: {
				String text = in.getElementText();
				setLUint32(java.util.Arrays.stream(text.isEmpty() ? new String[0] : text.split("\\s*,\\s*")).map(x -> (int) Long.parseLong(x)).collect(java.util.stream.Collectors.toList()));
				break;
			}
			case L_FIXED_32__XML_ATTR: {
				String text = in.getElementText();
				setLFixed32(java.util.Arrays.stream(text.isEmpty() ? new String[0] : text.split("\\s*,\\s*")).map(x -> (int) Long.parseLong(x)).collect(java.util.stream.Collectors.toList()));
				break;
			}
			case L_SFIXED_32__XML_ATTR: {
				String text = in.getElementText();
				setLSfixed32(java.util.Arrays.stream(text.isEmpty() ? new String[0] : text.split("\\s*,\\s*")).map(x -> Integer.parseInt(x)).collect(java.util.stream.Collectors.toList()));
				break;
			}
			case L_INT_64__XML_ATTR: {
				String text = in.getElementText();
				setLInt64(java.util.Arrays.stream(text.isEmpty() ? new String[0] : text.split("\\s*,\\s*")).map(x -> Long.parseLong(x)).collect(java.util.stream.Collectors.toList()));
				break;
			}
			case L_SINT_64__XML_ATTR: {
				String text = in.getElementText();
				setLSint64(java.util.Arrays.stream(text.isEmpty() ? new String[0] : text.split("\\s*,\\s*")).map(x -> Long.parseLong(x)).collect(java.util.stream.Collectors.toList()));
				break;
			}
			case L_UINT_64__XML_ATTR: {
				String text = in.getElementText();
				setLUint64(java.util.Arrays.stream(text.isEmpty() ? new String[0] : text.split("\\s*,\\s*")).map(x -> Long.parseLong(x)).collect(java.util.stream.Collectors.toList()));
				break;
			}
			case L_FIXED_64__XML_ATTR: {
				String text = in.getElementText();
				setLFixed64(java.util.Arrays.stream(text.isEmpty() ? new String[0] : text.split("\\s*,\\s*")).map(x -> Long.parseLong(x)).collect(java.util.stream.Collectors.toList()));
				break;
			}
			case L_SFIXED_64__XML_ATTR: {
				String text = in.getElementText();
				setLSfixed64(java.util.Arrays.stream(text.isEmpty() ? new String[0] : text.split("\\s*,\\s*")).map(x -> Long.parseLong(x)).collect(java.util.stream.Collectors.toList()));
				break;
			}
			case L_FLOAT__XML_ATTR: {
				String text = in.getElementText();
				setLFloat(java.util.Arrays.stream(text.isEmpty() ? new String[0] : text.split("\\s*,\\s*")).map(x -> Float.parseFloat(x)).collect(java.util.stream.Collectors.toList()));
				break;
			}
			case L_DOUBLE__XML_ATTR: {
				String text = in.getElementText();
				setLDouble(java.util.Arrays.stream(text.isEmpty() ? new String[0] : text.split("\\s*,\\s*")).map(x -> Double.parseDouble(x)).collect(java.util.stream.Collectors.toList()));
				break;
			}
			case L_STRING__XML_ATTR: {
				String text = in.getElementText();
				setLString(java.util.Arrays.stream(text.isEmpty() ? new String[0] : text.split("\\s*,\\s*")).map(x -> x).collect(java.util.stream.Collectors.toList()));
				break;
			}
			case L_BYTES__XML_ATTR: {
				String text = in.getElementText();
				setLBytes(java.util.Arrays.stream(text.isEmpty() ? new String[0] : text.split("\\s*,\\s*")).map(x -> java.util.Base64.getDecoder().decode(x)).collect(java.util.stream.Collectors.toList()));
				break;
			}
			case L_COLOR__XML_ATTR: {
				String text = in.getElementText();
				setLColor(java.util.Arrays.stream(text.isEmpty() ? new String[0] : text.split("\\s*,\\s*")).map(x -> test.xmlprimitives.data.Color.valueOfProtocol(x)).collect(java.util.stream.Collectors.toList()));
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
