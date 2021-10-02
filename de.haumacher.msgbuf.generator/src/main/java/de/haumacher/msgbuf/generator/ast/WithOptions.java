package de.haumacher.msgbuf.generator.ast;

/**
 * Base class for object that can be annotated.
 */
public abstract class WithOptions extends de.haumacher.msgbuf.data.AbstractDataObject {

	/** Visitor interface for the {@link WithOptions} hierarchy.*/
	public interface Visitor<R,A> extends Part.Visitor<R,A>, Definition.Visitor<R,A> {

		/** Visit case for {@link DefinitionFile}.*/
		R visit(DefinitionFile self, A arg);

	}

	/**
	 * Creates a {@link WithOptions} instance.
	 */
	protected WithOptions() {
		super();
	}

	/** @see #getOptions() */
	public static final String OPTIONS = "options";

	private java.util.Map<String, Option> _options = new java.util.HashMap<>();

	/**
	 * Annotations to this definition.
	 */
	public final java.util.Map<String, Option> getOptions() {
		return _options;
	}

	/**
	 * @see #getOptions()
	 */
	public final WithOptions setOptions(java.util.Map<String, Option> value) {
		_options.clear();
		_options.putAll(value);
		return this;
	}

	/**
	 * Adds a value to the {@link #getOptions()} map.
	 */
	public final void addOption(String key, Option value) {
		if (_options.containsKey(key)) {
			throw new IllegalArgumentException("Property 'options' already contains a value for key '" + key + "'.");
		}
		_options.put(key, value);
	}

	/** Reads a new instance from the given reader. */
	public static WithOptions readWithOptions(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		WithOptions result;
		in.beginArray();
		String type = in.nextString();
		switch (type) {
			case "DefinitionFile": result = DefinitionFile.readDefinitionFile(in); break;
			case "Constant": result = Constant.readConstant(in); break;
			case "Field": result = Field.readField(in); break;
			case "EnumDef": result = EnumDef.readEnumDef(in); break;
			case "MessageDef": result = MessageDef.readMessageDef(in); break;
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

	/** The type identifier for this concrete subtype. */
	public abstract String jsonType();

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(OPTIONS);
		out.beginObject();
		for (java.util.Map.Entry<String,Option> entry : getOptions().entrySet()) {
			out.name(entry.getKey());
			entry.getValue().writeTo(out);
		}
		out.endObject();
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case OPTIONS: {
				in.beginObject();
				while (in.hasNext()) {
					addOption(in.nextName(), Option.readOption(in));
				}
				in.endObject();
				break;
			}
			default: super.readField(in, field);
		}
	}

	/** Accepts the given visitor. */
	public abstract <R,A> R visit(Visitor<R,A> v, A arg);


}
