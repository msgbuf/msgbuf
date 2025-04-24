package de.haumacher.msgbuf.graph.cmd;

/**
 * Base class of commands that encode changes to data objects.
 */
public abstract class Command extends de.haumacher.msgbuf.data.AbstractDataObject implements de.haumacher.msgbuf.binary.BinaryDataObject {

	/** Type codes for the {@link de.haumacher.msgbuf.graph.cmd.Command} hierarchy. */
	public enum TypeKind {

		/** Type literal for {@link de.haumacher.msgbuf.graph.cmd.SetProperty}. */
		SET_PROPERTY,

		/** Type literal for {@link de.haumacher.msgbuf.graph.cmd.InsertElement}. */
		INSERT_ELEMENT,

		/** Type literal for {@link de.haumacher.msgbuf.graph.cmd.RemoveElement}. */
		REMOVE_ELEMENT,
		;

	}

	/** Visitor interface for the {@link de.haumacher.msgbuf.graph.cmd.Command} hierarchy.*/
	public interface Visitor<R,A,E extends Throwable> extends de.haumacher.msgbuf.graph.cmd.ListUpdate.Visitor<R,A,E> {

		/** Visit case for {@link de.haumacher.msgbuf.graph.cmd.SetProperty}.*/
		R visit(de.haumacher.msgbuf.graph.cmd.SetProperty self, A arg) throws E;

	}

	/** @see #getId() */
	private static final String ID__PROP = "id";

	/** @see #getProperty() */
	private static final String PROPERTY__PROP = "p";

	/** Identifier for the property {@link #getId()} in binary format. */
	static final int ID__ID = 1;

	/** Identifier for the property {@link #getProperty()} in binary format. */
	static final int PROPERTY__ID = 2;

	private int _id = 0;

	private String _property = "";

	private transient de.haumacher.msgbuf.graph.SharedGraphNode _node = null;

	/**
	 * Creates a {@link Command} instance.
	 */
	protected Command() {
		super();
	}

	/** The type code of this instance. */
	public abstract TypeKind kind();

	/**
	 * The network ID of the changed object.
	 */
	public final int getId() {
		return _id;
	}

	/**
	 * @see #getId()
	 */
	public de.haumacher.msgbuf.graph.cmd.Command setId(int value) {
		internalSetId(value);
		return this;
	}

	/** Internal setter for {@link #getId()} without chain call utility. */
	protected final void internalSetId(int value) {
		_id = value;
	}

	/**
	 * The name of the changed property of the object with the given {@link #getId()}.
	 */
	public final String getProperty() {
		return _property;
	}

	/**
	 * @see #getProperty()
	 */
	public de.haumacher.msgbuf.graph.cmd.Command setProperty(String value) {
		internalSetProperty(value);
		return this;
	}

	/** Internal setter for {@link #getProperty()} without chain call utility. */
	protected final void internalSetProperty(String value) {
		_property = value;
	}

	/**
	 * Cache for the reference to the changed graph node itself.
	 */
	public final de.haumacher.msgbuf.graph.SharedGraphNode getNode() {
		return _node;
	}

	/**
	 * @see #getNode()
	 */
	public de.haumacher.msgbuf.graph.cmd.Command setNode(de.haumacher.msgbuf.graph.SharedGraphNode value) {
		internalSetNode(value);
		return this;
	}

	/** Internal setter for {@link #getNode()} without chain call utility. */
	protected final void internalSetNode(de.haumacher.msgbuf.graph.SharedGraphNode value) {
		_node = value;
	}

	/**
	 * Checks, whether {@link #getNode()} has a value.
	 */
	public final boolean hasNode() {
		return _node != null;
	}

	/** The type identifier for this concrete subtype. */
	public abstract String jsonType();

	/** Reads a new instance from the given reader. */
	public static de.haumacher.msgbuf.graph.cmd.Command readCommand(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		de.haumacher.msgbuf.graph.cmd.Command result;
		in.beginArray();
		String type = in.nextString();
		switch (type) {
			case SetProperty.SET_PROPERTY__TYPE: result = de.haumacher.msgbuf.graph.cmd.SetProperty.readSetProperty(in); break;
			case InsertElement.INSERT_ELEMENT__TYPE: result = de.haumacher.msgbuf.graph.cmd.InsertElement.readInsertElement(in); break;
			case RemoveElement.REMOVE_ELEMENT__TYPE: result = de.haumacher.msgbuf.graph.cmd.RemoveElement.readRemoveElement(in); break;
			default: in.skipValue(); result = null; break;
		}
		in.endArray();
		return result;
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		out.beginArray();
		out.value(jsonType());
		writeContent(out);
		out.endArray();
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(ID__PROP);
		out.value(getId());
		out.name(PROPERTY__PROP);
		out.value(getProperty());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case ID__PROP: setId(in.nextInt()); break;
			case PROPERTY__PROP: setProperty(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			default: super.readField(in, field);
		}
	}

	/** The binary identifier for this concrete type in the polymorphic {@link de.haumacher.msgbuf.graph.cmd.Command} hierarchy. */
	abstract int typeId();

	@Override
	public final void writeTo(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		out.beginObject();
		out.name(0);
		out.value(typeId());
		writeFields(out);
		out.endObject();
	}

	/**
	 * Serializes all fields of this instance to the given binary output.
	 *
	 * @param out
	 *        The binary output to write to.
	 * @throws java.io.IOException If writing fails.
	 */
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		out.name(ID__ID);
		out.value(getId());
		out.name(PROPERTY__ID);
		out.value(getProperty());
	}

	/** Reads a new instance from the given reader. */
	public static de.haumacher.msgbuf.graph.cmd.Command readCommand(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		int typeField = in.nextName();
		assert typeField == 0;
		int type = in.nextInt();
		de.haumacher.msgbuf.graph.cmd.Command result;
		switch (type) {
			case de.haumacher.msgbuf.graph.cmd.SetProperty.SET_PROPERTY__TYPE_ID: result = de.haumacher.msgbuf.graph.cmd.SetProperty.readSetProperty_Content(in); break;
			case de.haumacher.msgbuf.graph.cmd.InsertElement.INSERT_ELEMENT__TYPE_ID: result = de.haumacher.msgbuf.graph.cmd.InsertElement.readInsertElement_Content(in); break;
			case de.haumacher.msgbuf.graph.cmd.RemoveElement.REMOVE_ELEMENT__TYPE_ID: result = de.haumacher.msgbuf.graph.cmd.RemoveElement.readRemoveElement_Content(in); break;
			default: result = null; while (in.hasNext()) {in.skipValue(); }
		}
		in.endObject();
		return result;
	}

	/** Helper for reading all fields of this instance. */
	protected final void readContent(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		while (in.hasNext()) {
			int field = in.nextName();
			readField(in, field);
		}
	}

	/** Consumes the value for the field with the given ID and assigns its value. */
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case ID__ID: setId(in.nextInt()); break;
			case PROPERTY__ID: setProperty(in.nextString()); break;
			default: in.skipValue(); 
		}
	}

	/** Accepts the given visitor. */
	public abstract <R,A,E extends Throwable> R visit(Visitor<R,A,E> v, A arg) throws E;

}
