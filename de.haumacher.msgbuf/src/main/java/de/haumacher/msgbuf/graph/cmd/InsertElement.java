package de.haumacher.msgbuf.graph.cmd;

/**
 * An insert operation to a list value.
 */
public class InsertElement extends ListUpdate {

	/**
	 * Creates a {@link InsertElement} instance.
	 */
	public static InsertElement create() {
		return new InsertElement();
	}

	/** Identifier for the {@link InsertElement} type in JSON format. */
	public static final String INSERT_ELEMENT__TYPE = "I";

	/** @see #getElement() */
	public static final String ELEMENT = "element";

	/** Identifier for the {@link InsertElement} type in binary format. */
	public static final int INSERT_ELEMENT__TYPE_ID = 2;

	private transient java.lang.Object _element = null;

	/**
	 * Creates a {@link InsertElement} instance.
	 *
	 * @see #create()
	 */
	protected InsertElement() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.INSERT_ELEMENT;
	}

	/**
	 * Cache for the actual value that was inserted to the given {@link #getIndex()}.
	 */
	public final java.lang.Object getElement() {
		return _element;
	}

	/**
	 * @see #getElement()
	 */
	public final InsertElement setElement(java.lang.Object value) {
		_listener.beforeSet(this, ELEMENT, value);
		_element = value;
		return this;
	}

	/**
	 * Checks, whether {@link #getElement()} has a value.
	 */
	public final boolean hasElement() {
		return _element != null;
	}

	@Override
	public String jsonType() {
		return INSERT_ELEMENT__TYPE;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			ELEMENT));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case ELEMENT: return getElement();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case ELEMENT: setElement((java.lang.Object) value); break;
			default: super.set(field, value); break;
		}
	}

	/** Reads a new instance from the given reader. */
	public static InsertElement readInsertElement(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		InsertElement result = new InsertElement();
		in.beginObject();
		result.readFields(in);
		in.endObject();
		return result;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			default: super.readField(in, field);
		}
	}

	@Override
	public int typeId() {
		return INSERT_ELEMENT__TYPE_ID;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		super.writeFields(out);
	}

	/** Reads a new instance from the given reader. */
	public static InsertElement readInsertElement(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		InsertElement result = new InsertElement();
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
			default: super.readField(in, field);
		}
	}

	@Override
	public <R,A,E extends Throwable> R visit(ListUpdate.Visitor<R,A,E> v, A arg) throws E {
		return v.visit(this, arg);
	}

}
