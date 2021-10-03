package test.underscorename;

public class AnnotatedMessage extends BaseMsg {

	/**
	 * Creates a {@link AnnotatedMessage} instance.
	 */
	public static AnnotatedMessage create() {
		return new AnnotatedMessage();
	}

	/**
	 * Creates a {@link AnnotatedMessage} instance.
	 *
	 * @see #create()
	 */
	protected AnnotatedMessage() {
		super();
	}

	/** Identifier for the {@link AnnotatedMessage} type in JSON format. */
	public static final String ANNOTATED_MESSAGE__TYPE = "m1";

	/** @see #getAnnotatedField() */
	public static final String ANNOTATED_FIELD = "f1";

	/** Identifier for the {@link AnnotatedMessage} type in binary format. */
	public static final int ANNOTATED_MESSAGE__TYPE_ID = 2;

	/** Identifier for the property {@link #getAnnotatedField()} in binary format. */
	public static final int ANNOTATED_FIELD__ID = 1;

	private String _annotatedField = "";

	public final String getAnnotatedField() {
		return _annotatedField;
	}

	/**
	 * @see #getAnnotatedField()
	 */
	public final AnnotatedMessage setAnnotatedField(String value) {
		_annotatedField = value;
		return this;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			ANNOTATED_FIELD));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case ANNOTATED_FIELD: return getAnnotatedField();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case ANNOTATED_FIELD: setAnnotatedField((String) value); break;
			default: super.set(field, value); break;
		}
	}

	/** Reads a new instance from the given reader. */
	public static AnnotatedMessage readannotated_message(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		AnnotatedMessage result = new AnnotatedMessage();
		in.beginObject();
		result.readFields(in);
		in.endObject();
		return result;
	}

	@Override
	public String jsonType() {
		return ANNOTATED_MESSAGE__TYPE;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(ANNOTATED_FIELD);
		out.value(getAnnotatedField());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case ANNOTATED_FIELD: setAnnotatedField(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public int typeId() {
		return ANNOTATED_MESSAGE__TYPE_ID;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(ANNOTATED_FIELD__ID);
		out.value(getAnnotatedField());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case ANNOTATED_FIELD__ID: setAnnotatedField(in.nextString()); break;
			default: super.readField(in, field);
		}
	}

	/** Reads a new instance from the given reader. */
	public static AnnotatedMessage readannotated_message(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		AnnotatedMessage result = new AnnotatedMessage();
		while (in.hasNext()) {
			int field = in.nextName();
			result.readField(in, field);
		}
		in.endObject();
		return result;
	}

	@Override
	public <R,A> R visit(BaseMsg.Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}

}
