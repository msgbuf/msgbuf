package de.haumacher.msgbuf.graph.cmd;

/**
 * An operation setting the value of a property to a new value.
 */
public class SetProperty extends Command {

	/**
	 * Creates a {@link de.haumacher.msgbuf.graph.cmd.SetProperty} instance.
	 */
	public static de.haumacher.msgbuf.graph.cmd.SetProperty create() {
		return new de.haumacher.msgbuf.graph.cmd.SetProperty();
	}

	/** Identifier for the {@link de.haumacher.msgbuf.graph.cmd.SetProperty} type in JSON format. */
	public static final String SET_PROPERTY__TYPE = "S";

	/** Identifier for the {@link de.haumacher.msgbuf.graph.cmd.SetProperty} type in binary format. */
	static final int SET_PROPERTY__TYPE_ID = 1;

	/**
	 * Creates a {@link SetProperty} instance.
	 *
	 * @see de.haumacher.msgbuf.graph.cmd.SetProperty#create()
	 */
	protected SetProperty() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.SET_PROPERTY;
	}

	@Override
	public de.haumacher.msgbuf.graph.cmd.SetProperty setId(int value) {
		internalSetId(value);
		return this;
	}

	@Override
	public de.haumacher.msgbuf.graph.cmd.SetProperty setProperty(String value) {
		internalSetProperty(value);
		return this;
	}

	@Override
	public de.haumacher.msgbuf.graph.cmd.SetProperty setNode(de.haumacher.msgbuf.graph.SharedGraphNode value) {
		internalSetNode(value);
		return this;
	}

	@Override
	public String jsonType() {
		return SET_PROPERTY__TYPE;
	}

	/** Reads a new instance from the given reader. */
	public static de.haumacher.msgbuf.graph.cmd.SetProperty readSetProperty(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		de.haumacher.msgbuf.graph.cmd.SetProperty result = new de.haumacher.msgbuf.graph.cmd.SetProperty();
		result.readContent(in);
		return result;
	}

	/** The binary identifier for this concrete type in the polymorphic {@link de.haumacher.msgbuf.graph.cmd.SetProperty} hierarchy. */
	public int typeId() {
		return SET_PROPERTY__TYPE_ID;
	}

	/** Reads a new instance from the given reader. */
	public static de.haumacher.msgbuf.graph.cmd.SetProperty readSetProperty(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		de.haumacher.msgbuf.graph.cmd.SetProperty result = de.haumacher.msgbuf.graph.cmd.SetProperty.readSetProperty_Content(in);
		in.endObject();
		return result;
	}

	/** Helper for creating an object of type {@link de.haumacher.msgbuf.graph.cmd.SetProperty} from a polymorphic composition. */
	public static de.haumacher.msgbuf.graph.cmd.SetProperty readSetProperty_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		de.haumacher.msgbuf.graph.cmd.SetProperty result = new SetProperty();
		result.readContent(in);
		return result;
	}

	@Override
	public <R,A,E extends Throwable> R visit(de.haumacher.msgbuf.graph.cmd.Command.Visitor<R,A,E> v, A arg) throws E {
		return v.visit(this, arg);
	}

}
