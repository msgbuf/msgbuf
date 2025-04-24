package de.haumacher.msgbuf.graph.cmd;

/**
 * An insert operation to a list value.
 */
public class InsertElement extends ListUpdate {

	/**
	 * Creates a {@link de.haumacher.msgbuf.graph.cmd.InsertElement} instance.
	 */
	public static de.haumacher.msgbuf.graph.cmd.InsertElement create() {
		return new de.haumacher.msgbuf.graph.cmd.InsertElement();
	}

	/** Identifier for the {@link de.haumacher.msgbuf.graph.cmd.InsertElement} type in JSON format. */
	public static final String INSERT_ELEMENT__TYPE = "I";

	/** Identifier for the {@link de.haumacher.msgbuf.graph.cmd.InsertElement} type in binary format. */
	static final int INSERT_ELEMENT__TYPE_ID = 2;

	private transient java.lang.Object _element = null;

	/**
	 * Creates a {@link InsertElement} instance.
	 *
	 * @see de.haumacher.msgbuf.graph.cmd.InsertElement#create()
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
	public de.haumacher.msgbuf.graph.cmd.InsertElement setElement(java.lang.Object value) {
		internalSetElement(value);
		return this;
	}

	/** Internal setter for {@link #getElement()} without chain call utility. */
	protected final void internalSetElement(java.lang.Object value) {
		_element = value;
	}

	/**
	 * Checks, whether {@link #getElement()} has a value.
	 */
	public final boolean hasElement() {
		return _element != null;
	}

	@Override
	public de.haumacher.msgbuf.graph.cmd.InsertElement setIndex(int value) {
		internalSetIndex(value);
		return this;
	}

	@Override
	public de.haumacher.msgbuf.graph.cmd.InsertElement setNext(de.haumacher.msgbuf.graph.cmd.ListUpdate value) {
		internalSetNext(value);
		return this;
	}

	@Override
	public de.haumacher.msgbuf.graph.cmd.InsertElement setId(int value) {
		internalSetId(value);
		return this;
	}

	@Override
	public de.haumacher.msgbuf.graph.cmd.InsertElement setProperty(String value) {
		internalSetProperty(value);
		return this;
	}

	@Override
	public de.haumacher.msgbuf.graph.cmd.InsertElement setNode(de.haumacher.msgbuf.graph.SharedGraphNode value) {
		internalSetNode(value);
		return this;
	}

	@Override
	public String jsonType() {
		return INSERT_ELEMENT__TYPE;
	}

	/** Reads a new instance from the given reader. */
	public static de.haumacher.msgbuf.graph.cmd.InsertElement readInsertElement(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		de.haumacher.msgbuf.graph.cmd.InsertElement result = new de.haumacher.msgbuf.graph.cmd.InsertElement();
		result.readContent(in);
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

	/** The binary identifier for this concrete type in the polymorphic {@link de.haumacher.msgbuf.graph.cmd.InsertElement} hierarchy. */
	public int typeId() {
		return INSERT_ELEMENT__TYPE_ID;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		super.writeFields(out);
	}

	/** Reads a new instance from the given reader. */
	public static de.haumacher.msgbuf.graph.cmd.InsertElement readInsertElement(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		de.haumacher.msgbuf.graph.cmd.InsertElement result = de.haumacher.msgbuf.graph.cmd.InsertElement.readInsertElement_Content(in);
		in.endObject();
		return result;
	}

	/** Helper for creating an object of type {@link de.haumacher.msgbuf.graph.cmd.InsertElement} from a polymorphic composition. */
	public static de.haumacher.msgbuf.graph.cmd.InsertElement readInsertElement_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		de.haumacher.msgbuf.graph.cmd.InsertElement result = new InsertElement();
		result.readContent(in);
		return result;
	}

	@Override
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			default: super.readField(in, field);
		}
	}

	@Override
	public <R,A,E extends Throwable> R visit(de.haumacher.msgbuf.graph.cmd.ListUpdate.Visitor<R,A,E> v, A arg) throws E {
		return v.visit(this, arg);
	}

}
