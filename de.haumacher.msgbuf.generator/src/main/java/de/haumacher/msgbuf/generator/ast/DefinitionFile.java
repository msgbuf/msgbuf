package de.haumacher.msgbuf.generator.ast;

/**
 * Representation of a <code>.proto</code> file with top-level {@link Definition}s.
 *
 * @see #getDefinitions()
 */
public class DefinitionFile extends WithOptions {

	/**
	 * Creates a {@link de.haumacher.msgbuf.generator.ast.DefinitionFile} instance.
	 */
	public static de.haumacher.msgbuf.generator.ast.DefinitionFile create() {
		return new de.haumacher.msgbuf.generator.ast.DefinitionFile();
	}

	/** Identifier for the {@link de.haumacher.msgbuf.generator.ast.DefinitionFile} type in JSON format. */
	public static final String DEFINITION_FILE__TYPE = "DefinitionFile";

	/** @see #getPackage() */
	public static final String PACKAGE__PROP = "package";

	/** @see #getDefinitions() */
	public static final String DEFINITIONS__PROP = "definitions";

	private de.haumacher.msgbuf.generator.ast.QName _package = null;

	private final java.util.List<de.haumacher.msgbuf.generator.ast.Definition> _definitions = new de.haumacher.msgbuf.util.ReferenceList<>() {
		@Override
		protected void beforeAdd(int index, de.haumacher.msgbuf.generator.ast.Definition element) {
			_listener.beforeAdd(DefinitionFile.this, DEFINITIONS__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, de.haumacher.msgbuf.generator.ast.Definition element) {
			_listener.afterRemove(DefinitionFile.this, DEFINITIONS__PROP, index, element);
		}
	};

	/**
	 * Creates a {@link DefinitionFile} instance.
	 *
	 * @see de.haumacher.msgbuf.generator.ast.DefinitionFile#create()
	 */
	protected DefinitionFile() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.DEFINITION_FILE;
	}

	/**
	 * The package name for all types in this file.
	 */
	public final de.haumacher.msgbuf.generator.ast.QName getPackage() {
		return _package;
	}

	/**
	 * @see #getPackage()
	 */
	public de.haumacher.msgbuf.generator.ast.DefinitionFile setPackage(de.haumacher.msgbuf.generator.ast.QName value) {
		internalSetPackage(value);
		return this;
	}

	/** Internal setter for {@link #getPackage()} without chain call utility. */
	protected final void internalSetPackage(de.haumacher.msgbuf.generator.ast.QName value) {
		_listener.beforeSet(this, PACKAGE__PROP, value);
		_package = value;
	}

	/**
	 * Checks, whether {@link #getPackage()} has a value.
	 */
	public final boolean hasPackage() {
		return _package != null;
	}

	/**
	 * All definitions in this file.
	 */
	public final java.util.List<de.haumacher.msgbuf.generator.ast.Definition> getDefinitions() {
		return _definitions;
	}

	/**
	 * @see #getDefinitions()
	 */
	public de.haumacher.msgbuf.generator.ast.DefinitionFile setDefinitions(java.util.List<? extends de.haumacher.msgbuf.generator.ast.Definition> value) {
		internalSetDefinitions(value);
		return this;
	}

	/** Internal setter for {@link #getDefinitions()} without chain call utility. */
	protected final void internalSetDefinitions(java.util.List<? extends de.haumacher.msgbuf.generator.ast.Definition> value) {
		if (value == null) throw new IllegalArgumentException("Property 'definitions' cannot be null.");
		_definitions.clear();
		_definitions.addAll(value);
	}

	/**
	 * Adds a value to the {@link #getDefinitions()} list.
	 */
	public de.haumacher.msgbuf.generator.ast.DefinitionFile addDefinition(de.haumacher.msgbuf.generator.ast.Definition value) {
		internalAddDefinition(value);
		return this;
	}

	/** Implementation of {@link #addDefinition(de.haumacher.msgbuf.generator.ast.Definition)} without chain call utility. */
	protected final void internalAddDefinition(de.haumacher.msgbuf.generator.ast.Definition value) {
		_definitions.add(value);
	}

	/**
	 * Removes a value from the {@link #getDefinitions()} list.
	 */
	public final void removeDefinition(de.haumacher.msgbuf.generator.ast.Definition value) {
		_definitions.remove(value);
	}

	@Override
	public de.haumacher.msgbuf.generator.ast.DefinitionFile setOptions(java.util.Map<String, de.haumacher.msgbuf.generator.ast.Option> value) {
		internalSetOptions(value);
		return this;
	}

	@Override
	public de.haumacher.msgbuf.generator.ast.DefinitionFile putOption(String key, de.haumacher.msgbuf.generator.ast.Option value) {
		internalPutOption(key, value);
		return this;
	}

	@Override
	public String jsonType() {
		return DEFINITION_FILE__TYPE;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			PACKAGE__PROP, 
			DEFINITIONS__PROP));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case PACKAGE__PROP: return getPackage();
			case DEFINITIONS__PROP: return getDefinitions();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case PACKAGE__PROP: internalSetPackage((de.haumacher.msgbuf.generator.ast.QName) value); break;
			case DEFINITIONS__PROP: internalSetDefinitions(de.haumacher.msgbuf.util.Conversions.asList(de.haumacher.msgbuf.generator.ast.Definition.class, value)); break;
			default: super.set(field, value); break;
		}
	}

	/** Reads a new instance from the given reader. */
	public static de.haumacher.msgbuf.generator.ast.DefinitionFile readDefinitionFile(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		de.haumacher.msgbuf.generator.ast.DefinitionFile result = new de.haumacher.msgbuf.generator.ast.DefinitionFile();
		result.readContent(in);
		return result;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		if (hasPackage()) {
			out.name(PACKAGE__PROP);
			getPackage().writeTo(out);
		}
		out.name(DEFINITIONS__PROP);
		out.beginArray();
		for (de.haumacher.msgbuf.generator.ast.Definition x : getDefinitions()) {
			x.writeTo(out);
		}
		out.endArray();
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case PACKAGE__PROP: setPackage(de.haumacher.msgbuf.generator.ast.QName.readQName(in)); break;
			case DEFINITIONS__PROP: {
				in.beginArray();
				while (in.hasNext()) {
					addDefinition(de.haumacher.msgbuf.generator.ast.Definition.readDefinition(in));
				}
				in.endArray();
			}
			break;
			default: super.readField(in, field);
		}
	}

	@Override
	public <R,A> R visit(de.haumacher.msgbuf.generator.ast.WithOptions.Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}

}
