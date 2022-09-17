package de.haumacher.msgbuf.generator.ast;

/**
 * Representation of a <code>.proto</code> file with top-level {@link Definition}s.
 *
 * @see #getDefinitions()
 */
public class DefinitionFile extends WithOptions {

	/**
	 * Creates a {@link DefinitionFile} instance.
	 */
	public static DefinitionFile create() {
		return new de.haumacher.msgbuf.generator.ast.DefinitionFile();
	}

	/** Identifier for the {@link DefinitionFile} type in JSON format. */
	public static final String DEFINITION_FILE__TYPE = "DefinitionFile";

	/** @see #getPackage() */
	public static final String PACKAGE = "package";

	/** @see #getDefinitions() */
	public static final String DEFINITIONS = "definitions";

	private QName _package = null;

	private final java.util.List<Definition> _definitions = new de.haumacher.msgbuf.util.ReferenceList<Definition>() {
		@Override
		protected void beforeAdd(int index, Definition element) {
			_listener.beforeAdd(DefinitionFile.this, DEFINITIONS, index, element);
		}

		@Override
		protected void afterRemove(int index, Definition element) {
			_listener.afterRemove(DefinitionFile.this, DEFINITIONS, index, element);
		}
	};

	/**
	 * Creates a {@link DefinitionFile} instance.
	 *
	 * @see DefinitionFile#create()
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
	public final QName getPackage() {
		return _package;
	}

	/**
	 * @see #getPackage()
	 */
	public DefinitionFile setPackage(QName value) {
		internalSetPackage(value);
		return this;
	}

	/** Internal setter for {@link #getPackage()} without chain call utility. */
	protected final void internalSetPackage(QName value) {
		_listener.beforeSet(this, PACKAGE, value);
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
	public final java.util.List<Definition> getDefinitions() {
		return _definitions;
	}

	/**
	 * @see #getDefinitions()
	 */
	public DefinitionFile setDefinitions(java.util.List<? extends Definition> value) {
		internalSetDefinitions(value);
		return this;
	}

	/** Internal setter for {@link #getDefinitions()} without chain call utility. */
	protected final void internalSetDefinitions(java.util.List<? extends Definition> value) {
		if (value == null) throw new IllegalArgumentException("Property 'definitions' cannot be null.");
		_definitions.clear();
		_definitions.addAll(value);
	}

	/**
	 * Adds a value to the {@link #getDefinitions()} list.
	 */
	public DefinitionFile addDefinition(Definition value) {
		internalAddDefinition(value);
		return this;
	}

	/** Implementation of {@link #addDefinition(Definition)} without chain call utility. */
	protected final void internalAddDefinition(Definition value) {
		_definitions.add(value);
	}

	/**
	 * Removes a value from the {@link #getDefinitions()} list.
	 */
	public final void removeDefinition(Definition value) {
		_definitions.remove(value);
	}

	@Override
	public DefinitionFile setOptions(java.util.Map<String, Option> value) {
		internalSetOptions(value);
		return this;
	}

	@Override
	public DefinitionFile putOption(String key, Option value) {
		internalPutOption(key, value);
		return this;
	}

	@Override
	public String jsonType() {
		return DEFINITION_FILE__TYPE;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			PACKAGE, 
			DEFINITIONS));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case PACKAGE: return getPackage();
			case DEFINITIONS: return getDefinitions();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case PACKAGE: internalSetPackage((QName) value); break;
			case DEFINITIONS: internalSetDefinitions(de.haumacher.msgbuf.util.Conversions.asList(Definition.class, value)); break;
			default: super.set(field, value); break;
		}
	}

	/** Reads a new instance from the given reader. */
	public static DefinitionFile readDefinitionFile(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		de.haumacher.msgbuf.generator.ast.DefinitionFile result = new de.haumacher.msgbuf.generator.ast.DefinitionFile();
		result.readContent(in);
		return result;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		if (hasPackage()) {
			out.name(PACKAGE);
			getPackage().writeTo(out);
		}
		out.name(DEFINITIONS);
		out.beginArray();
		for (Definition x : getDefinitions()) {
			x.writeTo(out);
		}
		out.endArray();
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case PACKAGE: setPackage(de.haumacher.msgbuf.generator.ast.QName.readQName(in)); break;
			case DEFINITIONS: {
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
	public <R,A> R visit(WithOptions.Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}

}
