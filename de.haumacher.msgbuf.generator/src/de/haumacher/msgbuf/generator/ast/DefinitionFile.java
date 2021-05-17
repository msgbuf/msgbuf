package de.haumacher.msgbuf.generator.ast;

public class DefinitionFile {

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

	private QName _package;

	private final java.util.List<Definition> _definitions = new java.util.ArrayList<>();

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
	public final void addDefinition(Definition value) {
		_definitions.add(value);
	}

	private static final int[] FIELDS = {0, 0, };

	/** Reads a new instance from the given reader. */
	public static DefinitionFile readDefinitionFile(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		DefinitionFile result = new DefinitionFile();
		result.readContent(in);
		return result;
	}

	/** Writes this instance to the given output. */
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		out.beginObject();
		writeContent(out);
		out.endObject();
	}

	/** Reads all fields of this instance from the given input. */
	protected final void readContent(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		while (in.hasNext()) {
			String field = in.nextName();
			readField(in, field);
		}
	}

	/** Retrieves value of the field with the given index. */
	public Object get(String field) {
		switch (field) {
			case "package": return getPackage();
			case "definitions": return getDefinitions();
			default: return null;
		}
	}

	/** Sets the value of the field with the given index. */
	public void set(String field, Object value) {
		switch (field) {
			case "package": setPackage((QName) value); break;
			case "definitions": setDefinitions((java.util.List<Definition>) value); break;
		}
	}

	/** Writes all fields of this instance to the given output. */
	protected void writeContent(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		out.name("package");
		getPackage().writeTo(out);
		out.name("definitions");
		out.beginArray();
		for (Definition x : getDefinitions()) {
			x.writeTo(out);
		}
		out.endArray();
	}

	/** Reads the given field from the given input. */
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
			default: in.skipValue();
		}
	}

}
