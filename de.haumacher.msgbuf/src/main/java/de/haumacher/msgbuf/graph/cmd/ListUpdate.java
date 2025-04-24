package de.haumacher.msgbuf.graph.cmd;

/**
 * Base class for operations internally changing the values of repeated properties.
 */
public abstract class ListUpdate extends Command {

	/** Visitor interface for the {@link de.haumacher.msgbuf.graph.cmd.ListUpdate} hierarchy.*/
	public interface Visitor<R,A,E extends Throwable> {

		/** Visit case for {@link de.haumacher.msgbuf.graph.cmd.InsertElement}.*/
		R visit(de.haumacher.msgbuf.graph.cmd.InsertElement self, A arg) throws E;

		/** Visit case for {@link de.haumacher.msgbuf.graph.cmd.RemoveElement}.*/
		R visit(de.haumacher.msgbuf.graph.cmd.RemoveElement self, A arg) throws E;

	}

	/** @see #getIndex() */
	private static final String INDEX__PROP = "i";

	/** Identifier for the property {@link #getIndex()} in binary format. */
	static final int INDEX__ID = 4;

	private int _index = 0;

	private transient de.haumacher.msgbuf.graph.cmd.ListUpdate _next = null;

	/**
	 * Creates a {@link ListUpdate} instance.
	 */
	protected ListUpdate() {
		super();
	}

	/**
	 * The list index that is modified.
	 */
	public final int getIndex() {
		return _index;
	}

	/**
	 * @see #getIndex()
	 */
	public de.haumacher.msgbuf.graph.cmd.ListUpdate setIndex(int value) {
		internalSetIndex(value);
		return this;
	}

	/** Internal setter for {@link #getIndex()} without chain call utility. */
	protected final void internalSetIndex(int value) {
		_index = value;
	}

	/**
	 * Pointer to chain updates for the same property.
	 */
	public final de.haumacher.msgbuf.graph.cmd.ListUpdate getNext() {
		return _next;
	}

	/**
	 * @see #getNext()
	 */
	public de.haumacher.msgbuf.graph.cmd.ListUpdate setNext(de.haumacher.msgbuf.graph.cmd.ListUpdate value) {
		internalSetNext(value);
		return this;
	}

	/** Internal setter for {@link #getNext()} without chain call utility. */
	protected final void internalSetNext(de.haumacher.msgbuf.graph.cmd.ListUpdate value) {
		_next = value;
	}

	/**
	 * Checks, whether {@link #getNext()} has a value.
	 */
	public final boolean hasNext() {
		return _next != null;
	}

	@Override
	public de.haumacher.msgbuf.graph.cmd.ListUpdate setId(int value) {
		internalSetId(value);
		return this;
	}

	@Override
	public de.haumacher.msgbuf.graph.cmd.ListUpdate setProperty(String value) {
		internalSetProperty(value);
		return this;
	}

	@Override
	public de.haumacher.msgbuf.graph.cmd.ListUpdate setNode(de.haumacher.msgbuf.graph.SharedGraphNode value) {
		internalSetNode(value);
		return this;
	}

	/** Reads a new instance from the given reader. */
	public static de.haumacher.msgbuf.graph.cmd.ListUpdate readListUpdate(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		de.haumacher.msgbuf.graph.cmd.ListUpdate result;
		in.beginArray();
		String type = in.nextString();
		switch (type) {
			case InsertElement.INSERT_ELEMENT__TYPE: result = de.haumacher.msgbuf.graph.cmd.InsertElement.readInsertElement(in); break;
			case RemoveElement.REMOVE_ELEMENT__TYPE: result = de.haumacher.msgbuf.graph.cmd.RemoveElement.readRemoveElement(in); break;
			default: in.skipValue(); result = null; break;
		}
		in.endArray();
		return result;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(INDEX__PROP);
		out.value(getIndex());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case INDEX__PROP: setIndex(in.nextInt()); break;
			default: super.readField(in, field);
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(INDEX__ID);
		out.value(getIndex());
	}

	/** Reads a new instance from the given reader. */
	public static de.haumacher.msgbuf.graph.cmd.ListUpdate readListUpdate(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		int typeField = in.nextName();
		assert typeField == 0;
		int type = in.nextInt();
		de.haumacher.msgbuf.graph.cmd.ListUpdate result;
		switch (type) {
			case de.haumacher.msgbuf.graph.cmd.InsertElement.INSERT_ELEMENT__TYPE_ID: result = de.haumacher.msgbuf.graph.cmd.InsertElement.readInsertElement_Content(in); break;
			case de.haumacher.msgbuf.graph.cmd.RemoveElement.REMOVE_ELEMENT__TYPE_ID: result = de.haumacher.msgbuf.graph.cmd.RemoveElement.readRemoveElement_Content(in); break;
			default: result = null; while (in.hasNext()) {in.skipValue(); }
		}
		in.endObject();
		return result;
	}

	@Override
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case INDEX__ID: setIndex(in.nextInt()); break;
			default: super.readField(in, field);
		}
	}

	/** Accepts the given visitor. */
	public abstract <R,A,E extends Throwable> R visit(Visitor<R,A,E> v, A arg) throws E;

	@Override
	public final <R,A,E extends Throwable> R visit(de.haumacher.msgbuf.graph.cmd.Command.Visitor<R,A,E> v, A arg) throws E {
		return visit((de.haumacher.msgbuf.graph.cmd.ListUpdate.Visitor<R,A,E>) v, arg);
	}

}
