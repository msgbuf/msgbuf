package de.haumacher.msgbuf.generator.ast;

/**
 * Member of a {@link Definition}.
 */
public abstract class Part extends DefinitionBase {

	/** Visitor interface for the {@link de.haumacher.msgbuf.generator.ast.Part} hierarchy.*/
	public interface Visitor<R,A> {

		/** Visit case for {@link de.haumacher.msgbuf.generator.ast.Constant}.*/
		R visit(de.haumacher.msgbuf.generator.ast.Constant self, A arg);

		/** Visit case for {@link de.haumacher.msgbuf.generator.ast.Field}.*/
		R visit(de.haumacher.msgbuf.generator.ast.Field self, A arg);

	}

	/** @see #getName() */
	public static final String NAME__PROP = "name";

	/** @see #getIndex() */
	public static final String INDEX__PROP = "index";

	/** @see #getOwner() */
	public static final String OWNER__PROP = "owner";

	private String _name = "";

	private int _index = 0;

	private transient de.haumacher.msgbuf.generator.ast.Definition _owner = null;

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
	public de.haumacher.msgbuf.generator.ast.Part setName(String value) {
		internalSetName(value);
		return this;
	}

	/** Internal setter for {@link #getName()} without chain call utility. */
	protected final void internalSetName(String value) {
		_listener.beforeSet(this, NAME__PROP, value);
		_name = value;
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
	public de.haumacher.msgbuf.generator.ast.Part setIndex(int value) {
		internalSetIndex(value);
		return this;
	}

	/** Internal setter for {@link #getIndex()} without chain call utility. */
	protected final void internalSetIndex(int value) {
		_listener.beforeSet(this, INDEX__PROP, value);
		_index = value;
	}

	/**
	 * The {@link Definition} definint this {@link Part}.
	 */
	public final de.haumacher.msgbuf.generator.ast.Definition getOwner() {
		return _owner;
	}

	/**
	 * @see #getOwner()
	 */
	public de.haumacher.msgbuf.generator.ast.Part setOwner(de.haumacher.msgbuf.generator.ast.Definition value) {
		internalSetOwner(value);
		return this;
	}

	/** Internal setter for {@link #getOwner()} without chain call utility. */
	protected final void internalSetOwner(de.haumacher.msgbuf.generator.ast.Definition value) {
		_listener.beforeSet(this, OWNER__PROP, value);
		_owner = value;
	}

	/**
	 * Checks, whether {@link #getOwner()} has a value.
	 */
	public final boolean hasOwner() {
		return _owner != null;
	}

	@Override
	public de.haumacher.msgbuf.generator.ast.Part setComment(String value) {
		internalSetComment(value);
		return this;
	}

	@Override
	public de.haumacher.msgbuf.generator.ast.Part setOptions(java.util.Map<String, de.haumacher.msgbuf.generator.ast.Option> value) {
		internalSetOptions(value);
		return this;
	}

	@Override
	public de.haumacher.msgbuf.generator.ast.Part putOption(String key, de.haumacher.msgbuf.generator.ast.Option value) {
		internalPutOption(key, value);
		return this;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			NAME__PROP, 
			INDEX__PROP, 
			OWNER__PROP));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case NAME__PROP: return getName();
			case INDEX__PROP: return getIndex();
			case OWNER__PROP: return getOwner();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case NAME__PROP: internalSetName((String) value); break;
			case INDEX__PROP: internalSetIndex((int) value); break;
			case OWNER__PROP: internalSetOwner((de.haumacher.msgbuf.generator.ast.Definition) value); break;
			default: super.set(field, value); break;
		}
	}

	/** Reads a new instance from the given reader. */
	public static de.haumacher.msgbuf.generator.ast.Part readPart(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		de.haumacher.msgbuf.generator.ast.Part result;
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
		out.name(NAME__PROP);
		out.value(getName());
		out.name(INDEX__PROP);
		out.value(getIndex());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case NAME__PROP: setName(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			case INDEX__PROP: setIndex(in.nextInt()); break;
			default: super.readField(in, field);
		}
	}

	/** Accepts the given visitor. */
	public abstract <R,A> R visit(Visitor<R,A> v, A arg);

	@Override
	public final <R,A> R visit(de.haumacher.msgbuf.generator.ast.DefinitionBase.Visitor<R,A> v, A arg) {
		return visit((de.haumacher.msgbuf.generator.ast.Part.Visitor<R,A>) v, arg);
	}

}
