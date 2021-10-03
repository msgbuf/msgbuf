public class NullableValues extends de.haumacher.msgbuf.data.AbstractReflectiveDataObject implements de.haumacher.msgbuf.binary.BinaryDataObject {

	/**
	 * Creates a {@link NullableValues} instance.
	 */
	public static NullableValues create() {
		return new NullableValues();
	}

	/** Identifier for the {@link NullableValues} type in JSON format. */
	public static final String NULLABLE_VALUES__TYPE = "NullableValues";

	/** @see #getA() */
	public static final String A = "a";

	/** @see #getB() */
	public static final String B = "b";

	/** @see #isC() */
	public static final String C = "c";

	/** @see #getD() */
	public static final String D = "d";

	/** @see #getLa() */
	public static final String LA = "la";

	/** @see #getLb() */
	public static final String LB = "lb";

	/** @see #getMa() */
	public static final String MA = "ma";

	/** Identifier for the property {@link #getA()} in binary format. */
	public static final int A__ID = 1;

	/** Identifier for the property {@link #getB()} in binary format. */
	public static final int B__ID = 2;

	/** Identifier for the property {@link #isC()} in binary format. */
	public static final int C__ID = 3;

	/** Identifier for the property {@link #getD()} in binary format. */
	public static final int D__ID = 4;

	/** Identifier for the property {@link #getLa()} in binary format. */
	public static final int LA__ID = 5;

	/** Identifier for the property {@link #getLb()} in binary format. */
	public static final int LB__ID = 6;

	/** Identifier for the property {@link #getMa()} in binary format. */
	public static final int MA__ID = 7;

	private Integer _a = null;

	private Long _b = null;

	private Boolean _c = null;

	private String _d = null;

	private final java.util.List<Integer> _la = null;

	private final java.util.List<String> _lb = null;

	private java.util.Map<String, Integer> _ma = null;

	/**
	 * Creates a {@link NullableValues} instance.
	 *
	 * @see #create()
	 */
	protected NullableValues() {
		super();
	}

	public final Integer getA() {
		return _a;
	}

	/**
	 * @see #getA()
	 */
	public final NullableValues setA(Integer value) {
		_a = value;
		return this;
	}

	/**
	 * Checks, whether {@link #getA()} has a value.
	 */
	public final boolean hasA() {
		return _a != null;
	}

	public final Long getB() {
		return _b;
	}

	/**
	 * @see #getB()
	 */
	public final NullableValues setB(Long value) {
		_b = value;
		return this;
	}

	/**
	 * Checks, whether {@link #getB()} has a value.
	 */
	public final boolean hasB() {
		return _b != null;
	}

	public final Boolean isC() {
		return _c;
	}

	/**
	 * @see #isC()
	 */
	public final NullableValues setC(Boolean value) {
		_c = value;
		return this;
	}

	/**
	 * Checks, whether {@link #isC()} has a value.
	 */
	public final boolean hasC() {
		return _c != null;
	}

	public final String getD() {
		return _d;
	}

	/**
	 * @see #getD()
	 */
	public final NullableValues setD(String value) {
		_d = value;
		return this;
	}

	/**
	 * Checks, whether {@link #getD()} has a value.
	 */
	public final boolean hasD() {
		return _d != null;
	}

	public final java.util.List<Integer> getLa() {
		return _la;
	}

	/**
	 * @see #getLa()
	 */
	public final NullableValues setLa(java.util.List<Integer> value) {
		_la.clear();
		_la.addAll(value);
		return this;
	}

	/**
	 * Adds a value to the {@link #getLa()} list.
	 */
	public final NullableValues addLa(int value) {
		_la.add(value);
		return this;
	}

	/**
	 * Checks, whether {@link #getLa()} has a value.
	 */
	public final boolean hasLa() {
		return _la != null;
	}

	public final java.util.List<String> getLb() {
		return _lb;
	}

	/**
	 * @see #getLb()
	 */
	public final NullableValues setLb(java.util.List<String> value) {
		_lb.clear();
		_lb.addAll(value);
		return this;
	}

	/**
	 * Adds a value to the {@link #getLb()} list.
	 */
	public final NullableValues addLb(String value) {
		_lb.add(value);
		return this;
	}

	/**
	 * Checks, whether {@link #getLb()} has a value.
	 */
	public final boolean hasLb() {
		return _lb != null;
	}

	public final java.util.Map<String, Integer> getMa() {
		return _ma;
	}

	/**
	 * @see #getMa()
	 */
	public final NullableValues setMa(java.util.Map<String, Integer> value) {
		_ma.clear();
		_ma.putAll(value);
		return this;
	}

	/**
	 * Adds a value to the {@link #getMa()} map.
	 */
	public final void addMa(String key, int value) {
		if (_ma.containsKey(key)) {
			throw new IllegalArgumentException("Property 'ma' already contains a value for key '" + key + "'.");
		}
		_ma.put(key, value);
	}

	/**
	 * Checks, whether {@link #getMa()} has a value.
	 */
	public final boolean hasMa() {
		return _ma != null;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			A, 
			B, 
			C, 
			D, 
			LA, 
			LB, 
			MA));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case A: return getA();
			case B: return getB();
			case C: return isC();
			case D: return getD();
			case LA: return getLa();
			case LB: return getLb();
			case MA: return getMa();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case A: setA((Integer) value); break;
			case B: setB((Long) value); break;
			case C: setC((Boolean) value); break;
			case D: setD((String) value); break;
			case LA: setLa((java.util.List<Integer>) value); break;
			case LB: setLb((java.util.List<String>) value); break;
			case MA: setMa((java.util.Map<String, Integer>) value); break;
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
		if (hasA()) {
			out.name(A);
			out.value(getA());
		}
		if (hasB()) {
			out.name(B);
			out.value(getB());
		}
		if (hasC()) {
			out.name(C);
			out.value(isC());
		}
		if (hasD()) {
			out.name(D);
			out.value(getD());
		}
		if (hasLa()) {
			out.name(LA);
			out.beginArray();
			for (int x : getLa()) {
				out.value(x);
			}
			out.endArray();
		}
		if (hasLb()) {
			out.name(LB);
			out.beginArray();
			for (String x : getLb()) {
				out.value(x);
			}
			out.endArray();
		}
		if (hasMa()) {
			out.name(MA);
			out.beginObject();
			for (java.util.Map.Entry<String,Integer> entry : getMa().entrySet()) {
				out.name(entry.getKey());
				out.value(entry.getValue());
			}
			out.endObject();
		}
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case A: setA(in.nextInt()); break;
			case B: setB(in.nextLong()); break;
			case C: setC(in.nextBoolean()); break;
			case D: setD(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			case LA: {
				in.beginArray();
				while (in.hasNext()) {
					addLa(in.nextInt());
				}
				in.endArray();
			}
			break;
			case LB: {
				in.beginArray();
				while (in.hasNext()) {
					addLb(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in));
				}
				in.endArray();
			}
			break;
			case MA: {
				in.beginObject();
				while (in.hasNext()) {
					addMa(in.nextName(), in.nextInt());
				}
				in.endObject();
				break;
			}
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
		if (hasA()) {
			out.name(A__ID);
			out.value(getA());
		}
		if (hasB()) {
			out.name(B__ID);
			out.value(getB());
		}
		if (hasC()) {
			out.name(C__ID);
			out.value(isC());
		}
		if (hasD()) {
			out.name(D__ID);
			out.value(getD());
		}
		if (hasLa()) {
			out.name(LA__ID);
			{
				java.util.List<Integer> values = getLa();
				out.beginArray(de.haumacher.msgbuf.binary.DataType.INT, values.size());
				for (int x : values) {
					out.value(x);
				}
				out.endArray();
			}
		}
		if (hasLb()) {
			out.name(LB__ID);
			{
				java.util.List<String> values = getLb();
				out.beginArray(de.haumacher.msgbuf.binary.DataType.STRING, values.size());
				for (String x : values) {
					out.value(x);
				}
				out.endArray();
			}
		}
		if (hasMa()) {
			out.name(MA__ID);
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
			case A__ID: setA(in.nextInt()); break;
			case B__ID: setB(in.nextLong()); break;
			case C__ID: setC(in.nextBoolean()); break;
			case D__ID: setD(in.nextString()); break;
			case LA__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addLa(in.nextInt());
				}
				in.endArray();
			}
			break;
			case LB__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addLb(in.nextString());
				}
				in.endArray();
			}
			break;
			case MA__ID: {
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
					addMa(key, value);
					in.endObject();
				}
				in.endArray();
				break;
			}
			default: in.skipValue(); 
		}
	}

}
