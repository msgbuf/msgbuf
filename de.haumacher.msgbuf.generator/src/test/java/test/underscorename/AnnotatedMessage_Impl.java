package test.underscorename;

class AnnotatedMessage_Impl extends BaseMsg_Impl implements AnnotatedMessage {

	private String _annotatedField = "";

	/**
	 * Creates a {@link AnnotatedMessage_Impl} instance.
	 *
	 * @see AnnotatedMessage#create()
	 */
	protected AnnotatedMessage_Impl() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.ANNOTATED_MESSAGE;
	}

	@Override
	public final String getAnnotatedField() {
		return _annotatedField;
	}

	@Override
	public AnnotatedMessage setAnnotatedField(String value) {
		internalSetAnnotatedField(value);
		return this;
	}

	/** Internal setter for {@link #getAnnotatedField()} without chain call utility. */
	protected final void internalSetAnnotatedField(String value) {
		_listener.beforeSet(this, ANNOTATED_FIELD, value);
		_annotatedField = value;
	}

	@Override
	public String jsonType() {
		return ANNOTATED_MESSAGE__TYPE;
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
			case ANNOTATED_FIELD: internalSetAnnotatedField((String) value); break;
			default: super.set(field, value); break;
		}
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

	/** Helper for creating an object of type {@link AnnotatedMessage} from a polymorphic composition. */
	public static AnnotatedMessage readannotated_message_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.underscorename.AnnotatedMessage_Impl result = new AnnotatedMessage_Impl();
		result.readContent(in);
		return result;
	}

	@Override
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case ANNOTATED_FIELD__ID: setAnnotatedField(in.nextString()); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public <R,A,E extends Throwable> R visit(BaseMsg.Visitor<R,A,E> v, A arg) throws E {
		return v.visit(this, arg);
	}

}
