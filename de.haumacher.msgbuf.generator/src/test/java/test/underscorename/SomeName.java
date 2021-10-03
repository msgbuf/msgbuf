package test.underscorename;

public class SomeName extends BaseMsg {

	/**
	 * Creates a {@link SomeName} instance.
	 */
	public static SomeName create() {
		return new SomeName();
	}

	/** Identifier for the {@link SomeName} type in JSON format. */
	public static final String SOME_NAME__TYPE = "some_name";

	/** @see #getMyField() */
	public static final String MY_FIELD = "my_field";

	/** Identifier for the {@link SomeName} type in binary format. */
	public static final int SOME_NAME__TYPE_ID = 1;

	/** Identifier for the property {@link #getMyField()} in binary format. */
	public static final int MY_FIELD__ID = 1;

	private String _myField = "";

	/**
	 * Creates a {@link SomeName} instance.
	 *
	 * @see #create()
	 */
	protected SomeName() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.SOME_NAME;
	}

	public final String getMyField() {
		return _myField;
	}

	/**
	 * @see #getMyField()
	 */
	public final SomeName setMyField(String value) {
		_myField = value;
		return this;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			MY_FIELD));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case MY_FIELD: return getMyField();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case MY_FIELD: setMyField((String) value); break;
			default: super.set(field, value); break;
		}
	}

	/** Reads a new instance from the given reader. */
	public static SomeName readsome_name(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		SomeName result = new SomeName();
		in.beginObject();
		result.readFields(in);
		in.endObject();
		return result;
	}

	@Override
	public String jsonType() {
		return SOME_NAME__TYPE;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(MY_FIELD);
		out.value(getMyField());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case MY_FIELD: setMyField(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public int typeId() {
		return SOME_NAME__TYPE_ID;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(MY_FIELD__ID);
		out.value(getMyField());
	}

	/** Reads a new instance from the given reader. */
	public static SomeName readsome_name(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		SomeName result = new SomeName();
		while (in.hasNext()) {
			int field = in.nextName();
			result.readField(in, field);
		}
		in.endObject();
		return result;
	}

	@Override
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case MY_FIELD__ID: setMyField(in.nextString()); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public <R,A> R visit(BaseMsg.Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}

}
