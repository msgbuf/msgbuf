package de.haumacher.msgbuf.graph.cmd;

/**
 * Base class of commands that encode changes to data objects.
 */
public abstract class Command extends de.haumacher.msgbuf.data.AbstractDataObject implements de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable {

	/** Type codes for the {@link Command} hierarchy. */
	public enum TypeKind {

		/** Type literal for {@link SetProperty}. */
		SET_PROPERTY,

		/** Type literal for {@link InsertElement}. */
		INSERT_ELEMENT,

		/** Type literal for {@link RemoveElement}. */
		REMOVE_ELEMENT,
		;

	}

	/** Visitor interface for the {@link Command} hierarchy.*/
	public interface Visitor<R,A,E extends Throwable> extends ListUpdate.Visitor<R,A,E> {

		/** Visit case for {@link SetProperty}.*/
		R visit(SetProperty self, A arg) throws E;

	}

	/** @see #getId() */
	public static final String ID = "id";

	/** @see #getProperty() */
	public static final String PROPERTY = "p";

	/** @see #getNode() */
	public static final String NODE = "node";

	/** Identifier for the property {@link #getId()} in binary format. */
	public static final int ID__ID = 1;

	/** Identifier for the property {@link #getProperty()} in binary format. */
	public static final int PROPERTY__ID = 2;

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
	public final Command setId(int value) {
		_listener.beforeSet(this, ID, value);
		_id = value;
		return this;
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
	public final Command setProperty(String value) {
		_listener.beforeSet(this, PROPERTY, value);
		_property = value;
		return this;
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
	public final Command setNode(de.haumacher.msgbuf.graph.SharedGraphNode value) {
		_listener.beforeSet(this, NODE, value);
		_node = value;
		return this;
	}

	/**
	 * Checks, whether {@link #getNode()} has a value.
	 */
	public final boolean hasNode() {
		return _node != null;
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public Command registerListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
		return this;
	}

	@Override
	public Command unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
		return this;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			ID, 
			PROPERTY, 
			NODE));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case ID: return getId();
			case PROPERTY: return getProperty();
			case NODE: return getNode();
			default: return de.haumacher.msgbuf.observer.Observable.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case ID: setId((int) value); break;
			case PROPERTY: setProperty((String) value); break;
			case NODE: setNode((de.haumacher.msgbuf.graph.SharedGraphNode) value); break;
		}
	}

	/** Reads a new instance from the given reader. */
	public static Command readCommand(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		Command result;
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
		out.name(ID);
		out.value(getId());
		out.name(PROPERTY);
		out.value(getProperty());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case ID: setId(in.nextInt()); break;
			case PROPERTY: setProperty(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			default: super.readField(in, field);
		}
	}

	/** The binary identifier for this concrete type in the polymorphic {@link Command} hierarchy. */
	public abstract int typeId();

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
	public static Command readCommand(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		Command result;
		int typeField = in.nextName();
		assert typeField == 0;
		int type = in.nextInt();
		switch (type) {
			case SetProperty.SET_PROPERTY__TYPE_ID: result = de.haumacher.msgbuf.graph.cmd.SetProperty.create(); break;
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
