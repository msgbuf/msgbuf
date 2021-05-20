package de.haumacher.msgbuf.generator.ast;

/**
 * Representation of a <code>.proto</code> file with top-level {@link Definition}s.
 *
 * @see #getDefinitions()
 */
public class DefinitionFile extends de.haumacher.msgbuf.data.AbstractDataObject {

	/**
	 * Creates a {@link DefinitionFile} instance.
	 */
	public static DefinitionFile definitionFile() {
		return new DefinitionFile();
	}

	/**
	 * Creates a {@link DefinitionFile} instance.
	 *
	 * @see #definitionFile()
	 */
	protected DefinitionFile() {
		super();
	}

	private QName _package = null;

	private final java.util.List<Definition> _definitions = new java.util.ArrayList<>();

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
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case "package": return getPackage();
			case "definitions": return getDefinitions();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case "package": setPackage((QName) value); break;
			case "definitions": setDefinitions((java.util.List<Definition>) value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		if (hasPackage()) {
			out.name("package");
			getPackage().writeTo(out);
		}
		out.name("definitions");
		out.beginArray();
		for (Definition x : getDefinitions()) {
			x.writeTo(out);
		}
		out.endArray();
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case "package": setPackage(QName.readQName(in)); break;
			case "definitions": {
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

}
