package de.haumacher.msgbuf.graph.cmd;

/**
 * An operation setting the value of a property to a new value.
 */
public class SetProperty extends Command {

	/**
	 * Creates a {@link SetProperty} instance.
	 */
	public static SetProperty create() {
		return new SetProperty();
	}

	/** Identifier for the {@link SetProperty} type in JSON format. */
	public static final String SET_PROPERTY__TYPE = "S";

	/** Identifier for the {@link SetProperty} type in binary format. */
	public static final int SET_PROPERTY__TYPE_ID = 1;

	/**
	 * Creates a {@link SetProperty} instance.
	 *
	 * @see #create()
	 */
	protected SetProperty() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.SET_PROPERTY;
	}

	@Override
	public String jsonType() {
		return SET_PROPERTY__TYPE;
	}

	/** Reads a new instance from the given reader. */
	public static SetProperty readSetProperty(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		SetProperty result = new SetProperty();
		in.beginObject();
		result.readFields(in);
		in.endObject();
		return result;
	}

	@Override
	public int typeId() {
		return SET_PROPERTY__TYPE_ID;
	}

	/** Reads a new instance from the given reader. */
	public static SetProperty readSetProperty(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		SetProperty result = new SetProperty();
		while (in.hasNext()) {
			int field = in.nextName();
			result.readField(in, field);
		}
		in.endObject();
		return result;
	}

	@Override
	public <R,A,E extends Throwable> R visit(Command.Visitor<R,A,E> v, A arg) throws E {
		return v.visit(this, arg);
	}

}
