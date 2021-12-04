package de.haumacher.msgbuf.graph.cmd;

/**
 * The removal of an element of a list value.
 */
public class RemoveElement extends ListUpdate {

	/**
	 * Creates a {@link RemoveElement} instance.
	 */
	public static RemoveElement create() {
		return new RemoveElement();
	}

	/** Identifier for the {@link RemoveElement} type in JSON format. */
	public static final String REMOVE_ELEMENT__TYPE = "R";

	/** Identifier for the {@link RemoveElement} type in binary format. */
	public static final int REMOVE_ELEMENT__TYPE_ID = 3;

	/**
	 * Creates a {@link RemoveElement} instance.
	 *
	 * @see #create()
	 */
	protected RemoveElement() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.REMOVE_ELEMENT;
	}

	@Override
	public String jsonType() {
		return REMOVE_ELEMENT__TYPE;
	}

	/** Reads a new instance from the given reader. */
	public static RemoveElement readRemoveElement(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		RemoveElement result = new RemoveElement();
		in.beginObject();
		result.readFields(in);
		in.endObject();
		return result;
	}

	@Override
	public int typeId() {
		return REMOVE_ELEMENT__TYPE_ID;
	}

	/** Reads a new instance from the given reader. */
	public static RemoveElement readRemoveElement(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		RemoveElement result = new RemoveElement();
		while (in.hasNext()) {
			int field = in.nextName();
			result.readField(in, field);
		}
		in.endObject();
		return result;
	}

	@Override
	public <R,A,E extends Throwable> R visit(ListUpdate.Visitor<R,A,E> v, A arg) throws E {
		return v.visit(this, arg);
	}

}
