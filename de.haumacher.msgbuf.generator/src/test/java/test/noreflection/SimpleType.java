package test.noreflection;

/**
 * A concrete type without abstract super type.
 */
public class SimpleType extends de.haumacher.msgbuf.data.AbstractDataObject {

	/**
	 * Creates a {@link SimpleType} instance.
	 */
	public static SimpleType create() {
		return new test.noreflection.SimpleType();
	}

	/** Identifier for the {@link SimpleType} type in JSON format. */
	public static final String SIMPLE_TYPE__TYPE = "SimpleType";

	/** @see #getStr() */
	private static final String STR__PROP = "str";

	/** @see #getX() */
	private static final String X__PROP = "x";

	private String _str = "";

	private int _x = 0;

	/**
	 * Creates a {@link SimpleType} instance.
	 *
	 * @see SimpleType#create()
	 */
	protected SimpleType() {
		super();
	}

	/**
	 * A string property
	 */
	public final String getStr() {
		return _str;
	}

	/**
	 * @see #getStr()
	 */
	public SimpleType setStr(String value) {
		internalSetStr(value);
		return this;
	}

	/** Internal setter for {@link #getStr()} without chain call utility. */
	protected final void internalSetStr(String value) {
		_str = value;
	}

	/**
	 * An int property
	 */
	public final int getX() {
		return _x;
	}

	/**
	 * @see #getX()
	 */
	public SimpleType setX(int value) {
		internalSetX(value);
		return this;
	}

	/** Internal setter for {@link #getX()} without chain call utility. */
	protected final void internalSetX(int value) {
		_x = value;
	}

	public String jsonType() {
		return SIMPLE_TYPE__TYPE;
	}

	/** Reads a new instance from the given reader. */
	public static SimpleType readSimpleType(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.noreflection.SimpleType result = new test.noreflection.SimpleType();
		result.readContent(in);
		return result;
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(STR__PROP);
		out.value(getStr());
		out.name(X__PROP);
		out.value(getX());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case STR__PROP: setStr(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			case X__PROP: setX(in.nextInt()); break;
			default: super.readField(in, field);
		}
	}

}
