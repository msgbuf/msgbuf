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
		return new DefinitionFile();
	}

	/** Identifier for the {@link DefinitionFile} type in JSON format. */
	public static final String DEFINITION_FILE__TYPE = "DefinitionFile";

	/** @see #getPackage() */
	public static final String PACKAGE = "package";

	/** @see #getDefinitions() */
	public static final String DEFINITIONS = "definitions";

	private QName _package = null;

	private final java.util.List<Definition> _definitions = new java.util.ArrayList<>();

	/**
	 * Creates a {@link DefinitionFile} instance.
	 *
	 * @see #create()
	 */
	protected DefinitionFile() {
		super();
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
	public final DefinitionFile setPackage(QName value) {
		_package = value;
		return this;
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
	public final DefinitionFile setDefinitions(java.util.List<Definition> value) {
		_definitions.clear();
		_definitions.addAll(value);
		return this;
	}

	/**
	 * Adds a value to the {@link #getDefinitions()} list.
	 */
	public final DefinitionFile addDefinition(Definition value) {
		_definitions.add(value);
		return this;
	}

	/** Reads a new instance from the given reader. */
	public static DefinitionFile readDefinitionFile(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		DefinitionFile result = new DefinitionFile();
		in.beginObject();
		result.readFields(in);
		in.endObject();
		return result;
	}

	@Override
	public String jsonType() {
		return DEFINITION_FILE__TYPE;
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
			case PACKAGE: setPackage(QName.readQName(in)); break;
			case DEFINITIONS: {
				in.beginArray();
				while (in.hasNext()) {
					addDefinition(Definition.readDefinition(in));
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
