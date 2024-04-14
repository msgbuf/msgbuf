package de.haumacher.msgbuf.generator.ast;

/**
 * Base class of a definition in a {@link DefinitionFile}.
 */
public abstract class Definition extends DefinitionBase {

	/** Visitor interface for the {@link de.haumacher.msgbuf.generator.ast.Definition} hierarchy.*/
	public interface Visitor<R,A> {

		/** Visit case for {@link de.haumacher.msgbuf.generator.ast.EnumDef}.*/
		R visit(de.haumacher.msgbuf.generator.ast.EnumDef self, A arg);

		/** Visit case for {@link de.haumacher.msgbuf.generator.ast.MessageDef}.*/
		R visit(de.haumacher.msgbuf.generator.ast.MessageDef self, A arg);

	}

	/** @see #getName() */
	public static final String NAME__PROP = "name";

	/** @see #getFile() */
	public static final String FILE__PROP = "file";

	/** @see #getOuter() */
	public static final String OUTER__PROP = "outer";

	private String _name = "";

	private transient de.haumacher.msgbuf.generator.ast.DefinitionFile _file = null;

	private transient de.haumacher.msgbuf.generator.ast.MessageDef _outer = null;

	/**
	 * Creates a {@link Definition} instance.
	 */
	protected Definition() {
		super();
	}

	/**
	 * The name of this definition.
	 */
	public final String getName() {
		return _name;
	}

	/**
	 * @see #getName()
	 */
	public de.haumacher.msgbuf.generator.ast.Definition setName(String value) {
		internalSetName(value);
		return this;
	}

	/** Internal setter for {@link #getName()} without chain call utility. */
	protected final void internalSetName(String value) {
		_listener.beforeSet(this, NAME__PROP, value);
		_name = value;
	}

	/**
	 * Reference back to the {@link DefinitionFile} that contains this definition.
	 */
	public final de.haumacher.msgbuf.generator.ast.DefinitionFile getFile() {
		return _file;
	}

	/**
	 * @see #getFile()
	 */
	public de.haumacher.msgbuf.generator.ast.Definition setFile(de.haumacher.msgbuf.generator.ast.DefinitionFile value) {
		internalSetFile(value);
		return this;
	}

	/** Internal setter for {@link #getFile()} without chain call utility. */
	protected final void internalSetFile(de.haumacher.msgbuf.generator.ast.DefinitionFile value) {
		_listener.beforeSet(this, FILE__PROP, value);
		_file = value;
	}

	/**
	 * Checks, whether {@link #getFile()} has a value.
	 */
	public final boolean hasFile() {
		return _file != null;
	}

	/**
	 * The {@link MessageDef} that contains this inner {@Definition}.
	 *
	 * <p>
	 * The value is <code>null</code> for top-level defintions, see {@link #getFile()}.
	 * </p>
	 */
	public final de.haumacher.msgbuf.generator.ast.MessageDef getOuter() {
		return _outer;
	}

	/**
	 * @see #getOuter()
	 */
	public de.haumacher.msgbuf.generator.ast.Definition setOuter(de.haumacher.msgbuf.generator.ast.MessageDef value) {
		internalSetOuter(value);
		return this;
	}

	/** Internal setter for {@link #getOuter()} without chain call utility. */
	protected final void internalSetOuter(de.haumacher.msgbuf.generator.ast.MessageDef value) {
		_listener.beforeSet(this, OUTER__PROP, value);
		_outer = value;
	}

	/**
	 * Checks, whether {@link #getOuter()} has a value.
	 */
	public final boolean hasOuter() {
		return _outer != null;
	}

	@Override
	public de.haumacher.msgbuf.generator.ast.Definition setComment(String value) {
		internalSetComment(value);
		return this;
	}

	@Override
	public de.haumacher.msgbuf.generator.ast.Definition setOptions(java.util.Map<String, de.haumacher.msgbuf.generator.ast.Option> value) {
		internalSetOptions(value);
		return this;
	}

	@Override
	public de.haumacher.msgbuf.generator.ast.Definition putOption(String key, de.haumacher.msgbuf.generator.ast.Option value) {
		internalPutOption(key, value);
		return this;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			NAME__PROP, 
			FILE__PROP, 
			OUTER__PROP));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case NAME__PROP: return getName();
			case FILE__PROP: return getFile();
			case OUTER__PROP: return getOuter();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case NAME__PROP: internalSetName((String) value); break;
			case FILE__PROP: internalSetFile((de.haumacher.msgbuf.generator.ast.DefinitionFile) value); break;
			case OUTER__PROP: internalSetOuter((de.haumacher.msgbuf.generator.ast.MessageDef) value); break;
			default: super.set(field, value); break;
		}
	}

	/** Reads a new instance from the given reader. */
	public static de.haumacher.msgbuf.generator.ast.Definition readDefinition(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		de.haumacher.msgbuf.generator.ast.Definition result;
		in.beginArray();
		String type = in.nextString();
		switch (type) {
			case EnumDef.ENUM_DEF__TYPE: result = de.haumacher.msgbuf.generator.ast.EnumDef.readEnumDef(in); break;
			case MessageDef.MESSAGE_DEF__TYPE: result = de.haumacher.msgbuf.generator.ast.MessageDef.readMessageDef(in); break;
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
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case NAME__PROP: setName(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			default: super.readField(in, field);
		}
	}

	/** Accepts the given visitor. */
	public abstract <R,A> R visit(Visitor<R,A> v, A arg);

	@Override
	public final <R,A> R visit(de.haumacher.msgbuf.generator.ast.DefinitionBase.Visitor<R,A> v, A arg) {
		return visit((de.haumacher.msgbuf.generator.ast.Definition.Visitor<R,A>) v, arg);
	}

}
