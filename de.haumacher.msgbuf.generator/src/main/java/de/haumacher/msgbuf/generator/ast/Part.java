package de.haumacher.msgbuf.generator.ast;

/**
 * Member of a {@link Definition}.
 */
public abstract class Part extends DefinitionBase {

	/** Visitor interface for the {@link Part} hierarchy.*/
	public interface Visitor<R,A> {

		/** Visit case for {@link Constant}.*/
		R visit(Constant self, A arg);

		/** Visit case for {@link Field}.*/
		R visit(Field self, A arg);

	}

	/** @see #getName() */
	public static final String NAME = "name";

	/** @see #getIndex() */
	public static final String INDEX = "index";

	/** @see #getOwner() */
	public static final String OWNER = "owner";

	private String _name = "";

	private int _index = 0;

	private transient Definition _owner = null;

	/**
	 * Creates a {@link Part} instance.
	 */
	protected Part() {
		super();
	}

	/**
	 * The name of this member.
	 */
	public final String getName() {
		return _name;
	}

	/**
	 * @see #getName()
	 */
	public final Part setName(String value) {
		_listener.beforeSet(this, NAME, value);
		_name = value;
		return this;
	}

	/**
	 * The numeric identifier for this member.
	 */
	public final int getIndex() {
		return _index;
	}

	/**
	 * @see #getIndex()
	 */
	public final Part setIndex(int value) {
		_listener.beforeSet(this, INDEX, value);
		_index = value;
		return this;
	}

	/**
	 * The {@link Definition} definint this {@link Part}.
	 */
	public final Definition getOwner() {
		return _owner;
	}

	/**
	 * @see #getOwner()
	 */
	public final Part setOwner(Definition value) {
		_listener.beforeSet(this, OWNER, value);
		_owner = value;
		return this;
	}

	/**
	 * Checks, whether {@link #getOwner()} has a value.
	 */
	public final boolean hasOwner() {
		return _owner != null;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			NAME, 
			INDEX, 
			OWNER));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case NAME: return getName();
			case INDEX: return getIndex();
			case OWNER: return getOwner();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case NAME: setName((String) value); break;
			case INDEX: setIndex((int) value); break;
			case OWNER: setOwner((Definition) value); break;
			default: super.set(field, value); break;
		}
	}

	/** Reads a new instance from the given reader. */
	public static Part readPart(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		Part result;
		in.beginArray();
		String type = in.nextString();
		switch (type) {
			case Constant.CONSTANT__TYPE: result = de.haumacher.msgbuf.generator.ast.Constant.readConstant(in); break;
			case Field.FIELD__TYPE: result = de.haumacher.msgbuf.generator.ast.Field.readField(in); break;
			default: in.skipValue(); result = null; break;
		}
		in.endArray();
		return result;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(NAME);
		out.value(getName());
		out.name(INDEX);
		out.value(getIndex());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case NAME: setName(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			case INDEX: setIndex(in.nextInt()); break;
			default: super.readField(in, field);
		}
	}

	/** Accepts the given visitor. */
	public abstract <R,A> R visit(Visitor<R,A> v, A arg);


	@Override
	public final <R,A> R visit(DefinitionBase.Visitor<R,A> v, A arg) {
		return visit((Visitor<R,A>) v, arg);
	}

}
