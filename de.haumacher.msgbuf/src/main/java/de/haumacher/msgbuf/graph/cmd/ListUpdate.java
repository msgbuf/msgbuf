package de.haumacher.msgbuf.graph.cmd;

/**
 * Base class for operations internally changing the values of repeated properties.
 */
public abstract class ListUpdate extends Command {

	/** Visitor interface for the {@link ListUpdate} hierarchy.*/
	public interface Visitor<R,A,E extends Throwable> {

		/** Visit case for {@link InsertElement}.*/
		R visit(InsertElement self, A arg) throws E;

		/** Visit case for {@link RemoveElement}.*/
		R visit(RemoveElement self, A arg) throws E;

	}

	/** @see #getIndex() */
	public static final String INDEX = "i";

	/** @see #getNext() */
	public static final String NEXT = "next";

	/** Identifier for the property {@link #getIndex()} in binary format. */
	public static final int INDEX__ID = 4;

	private int _index = 0;

	private transient ListUpdate _next = null;

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
	public final ListUpdate setIndex(int value) {
		_listener.beforeSet(this, INDEX, value);
		_index = value;
		return this;
	}

	/**
	 * Pointer to chain updates for the same property.
	 */
	public final ListUpdate getNext() {
		return _next;
	}

	/**
	 * @see #getNext()
	 */
	public final ListUpdate setNext(ListUpdate value) {
		_listener.beforeSet(this, NEXT, value);
		_next = value;
		return this;
	}

	/**
	 * Checks, whether {@link #getNext()} has a value.
	 */
	public final boolean hasNext() {
		return _next != null;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			INDEX, 
			NEXT));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case INDEX: return getIndex();
			case NEXT: return getNext();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case INDEX: setIndex((int) value); break;
			case NEXT: setNext((ListUpdate) value); break;
			default: super.set(field, value); break;
		}
	}

	/** Reads a new instance from the given reader. */
	public static ListUpdate readListUpdate(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		ListUpdate result;
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
		out.name(INDEX);
		out.value(getIndex());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case INDEX: setIndex(in.nextInt()); break;
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
	public static ListUpdate readListUpdate(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		ListUpdate result;
		int typeField = in.nextName();
		assert typeField == 0;
		int type = in.nextInt();
		switch (type) {
			case InsertElement.INSERT_ELEMENT__TYPE_ID: result = de.haumacher.msgbuf.graph.cmd.InsertElement.create(); break;
			case RemoveElement.REMOVE_ELEMENT__TYPE_ID: result = de.haumacher.msgbuf.graph.cmd.RemoveElement.create(); break;
			default: while (in.hasNext()) {in.skipValue(); } in.endObject(); return null;
		}
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
			case INDEX__ID: setIndex(in.nextInt()); break;
			default: super.readField(in, field);
		}
	}

	/** Accepts the given visitor. */
	public abstract <R,A,E extends Throwable> R visit(Visitor<R,A,E> v, A arg) throws E;


	@Override
	public final <R,A,E extends Throwable> R visit(Command.Visitor<R,A,E> v, A arg) throws E {
		return visit((Visitor<R,A,E>) v, arg);
	}

}
