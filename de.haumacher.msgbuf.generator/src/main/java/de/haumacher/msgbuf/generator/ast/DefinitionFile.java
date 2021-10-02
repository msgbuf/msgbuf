package de.haumacher.msgbuf.generator.ast;

/**
 * Representation of a <code>.proto</code> file with top-level {@link Definition}s.
 *
 * @see #getDefinitions()
 */
public class DefinitionFile extends de.haumacher.msgbuf.data.AbstractReflectiveDataObject implements de.haumacher.msgbuf.binary.BinaryDataObject {

	/**
	 * Creates a {@link DefinitionFile} instance.
	 */
	public static DefinitionFile create() {
		return new DefinitionFile();
	}

	/**
	 * Creates a {@link DefinitionFile} instance.
	 *
	 * @see #create()
	 */
	protected DefinitionFile() {
		super();
	}

	/** @see #getPackage() */
	public static final String PACKAGE = "package";

	/** @see #getOptions() */
	public static final String OPTIONS = "options";

	/** @see #getDefinitions() */
	public static final String DEFINITIONS = "definitions";

	private QName _package = null;

	private final java.util.List<Option> _options = new java.util.ArrayList<>();

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
	 * Annotations to this {@link DefinitionFile}
	 */
	public final java.util.List<Option> getOptions() {
		return _options;
	}

	/**
	 * @see #getOptions()
	 */
	public final DefinitionFile setOptions(java.util.List<Option> value) {
		_options.clear();
		_options.addAll(value);
		return this;
	}

	/**
	 * Adds a value to the {@link #getOptions()} list.
	 */
	public final DefinitionFile addOption(Option value) {
		_options.add(value);
		return this;
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

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			PACKAGE, 
			OPTIONS, 
			DEFINITIONS));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case PACKAGE: return getPackage();
			case OPTIONS: return getOptions();
			case DEFINITIONS: return getDefinitions();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case PACKAGE: setPackage((QName) value); break;
			case OPTIONS: setOptions((java.util.List<Option>) value); break;
			case DEFINITIONS: setDefinitions((java.util.List<Definition>) value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		if (hasPackage()) {
			out.name(PACKAGE);
			getPackage().writeTo(out);
		}
		out.name(OPTIONS);
		out.beginArray();
		for (Option x : getOptions()) {
			x.writeTo(out);
		}
		out.endArray();
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
			case OPTIONS: {
				in.beginArray();
				while (in.hasNext()) {
					addOption(Option.readOption(in));
				}
				in.endArray();
			}
			break;
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
	public final void writeTo(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		out.beginObject();
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
		if (hasPackage()) {
			out.name(1);
			getPackage().writeTo(out);
		}
		out.name(2);
		{
			java.util.List<Option> values = getOptions();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.OBJECT, values.size());
			for (Option x : values) {
				x.writeTo(out);
			}
			out.endArray();
		}
		out.name(3);
		{
			java.util.List<Definition> values = getDefinitions();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.OBJECT, values.size());
			for (Definition x : values) {
				x.writeTo(out);
			}
			out.endArray();
		}
	}

	/** Consumes the value for the field with the given ID and assigns its value. */
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case 1: setPackage(QName.readQName(in)); break;
			case 2: {
				in.beginArray();
				while (in.hasNext()) {
					addOption(Option.readOption(in));
				}
				in.endArray();
			}
			break;
			case 3: {
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

	/** Reads a new instance from the given reader. */
	public static DefinitionFile readDefinitionFile(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		DefinitionFile result = new DefinitionFile();
		while (in.hasNext()) {
			int field = in.nextName();
			result.readField(in, field);
		}
		in.endObject();
		return result;
	}

}
