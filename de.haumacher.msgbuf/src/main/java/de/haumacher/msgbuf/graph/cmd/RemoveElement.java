package de.haumacher.msgbuf.graph.cmd;

/**
 * The removal of an element of a list value.
 */
public class RemoveElement extends ListUpdate {

	/**
	 * Creates a {@link de.haumacher.msgbuf.graph.cmd.RemoveElement} instance.
	 */
	public static de.haumacher.msgbuf.graph.cmd.RemoveElement create() {
		return new de.haumacher.msgbuf.graph.cmd.RemoveElement();
	}

	/** Identifier for the {@link de.haumacher.msgbuf.graph.cmd.RemoveElement} type in JSON format. */
	public static final String REMOVE_ELEMENT__TYPE = "R";

	/** Identifier for the {@link de.haumacher.msgbuf.graph.cmd.RemoveElement} type in binary format. */
	static final int REMOVE_ELEMENT__TYPE_ID = 3;

	/**
	 * Creates a {@link RemoveElement} instance.
	 *
	 * @see de.haumacher.msgbuf.graph.cmd.RemoveElement#create()
	 */
	protected RemoveElement() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.REMOVE_ELEMENT;
	}

	@Override
	public de.haumacher.msgbuf.graph.cmd.RemoveElement setIndex(int value) {
		internalSetIndex(value);
		return this;
	}

	@Override
	public de.haumacher.msgbuf.graph.cmd.RemoveElement setNext(de.haumacher.msgbuf.graph.cmd.ListUpdate value) {
		internalSetNext(value);
		return this;
	}

	@Override
	public de.haumacher.msgbuf.graph.cmd.RemoveElement setId(int value) {
		internalSetId(value);
		return this;
	}

	@Override
	public de.haumacher.msgbuf.graph.cmd.RemoveElement setProperty(String value) {
		internalSetProperty(value);
		return this;
	}

	@Override
	public de.haumacher.msgbuf.graph.cmd.RemoveElement setNode(de.haumacher.msgbuf.graph.SharedGraphNode value) {
		internalSetNode(value);
		return this;
	}

	@Override
	public String jsonType() {
		return REMOVE_ELEMENT__TYPE;
	}

	/** Reads a new instance from the given reader. */
	public static de.haumacher.msgbuf.graph.cmd.RemoveElement readRemoveElement(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		de.haumacher.msgbuf.graph.cmd.RemoveElement result = new de.haumacher.msgbuf.graph.cmd.RemoveElement();
		result.readContent(in);
		return result;
	}

	/** The binary identifier for this concrete type in the polymorphic {@link de.haumacher.msgbuf.graph.cmd.RemoveElement} hierarchy. */
	public int typeId() {
		return REMOVE_ELEMENT__TYPE_ID;
	}

	/** Reads a new instance from the given reader. */
	public static de.haumacher.msgbuf.graph.cmd.RemoveElement readRemoveElement(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		de.haumacher.msgbuf.graph.cmd.RemoveElement result = de.haumacher.msgbuf.graph.cmd.RemoveElement.readRemoveElement_Content(in);
		in.endObject();
		return result;
	}

	/** Helper for creating an object of type {@link de.haumacher.msgbuf.graph.cmd.RemoveElement} from a polymorphic composition. */
	public static de.haumacher.msgbuf.graph.cmd.RemoveElement readRemoveElement_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		de.haumacher.msgbuf.graph.cmd.RemoveElement result = new RemoveElement();
		result.readContent(in);
		return result;
	}

	@Override
	public <R,A,E extends Throwable> R visit(de.haumacher.msgbuf.graph.cmd.ListUpdate.Visitor<R,A,E> v, A arg) throws E {
		return v.visit(this, arg);
	}

}
