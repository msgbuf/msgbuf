package de.haumacher.msgbuf.generator.ast;

/**
 * Base class of a definition in a {@link DefinitionFile}.
 */
public abstract class Definition extends de.haumacher.msgbuf.data.AbstractDataObject implements de.haumacher.msgbuf.binary.BinaryDataObject {

	/** Visitor interface for the {@link Definition} hierarchy.*/
	public interface Visitor<R,A> {

		/** Visit case for {@link EnumDef}.*/
		R visit(EnumDef self, A arg);

		/** Visit case for {@link MessageDef}.*/
		R visit(MessageDef self, A arg);

	}

	/**
	 * Creates a {@link Definition} instance.
	 */
	protected Definition() {
		super();
	}

	private String _comment = "";

	private String _name = "";

	private final java.util.List<Option> _options = new java.util.ArrayList<>();

	private transient DefinitionFile _file = null;

	private transient MessageDef _outer = null;

	/**
	 * The documentation comment for this definition.
	 */
	public final String getComment() {
		return _comment;
	}

	/**
	 * @see #getComment()
	 */
	public final Definition setComment(String value) {
		_comment = value;
		return this;
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
	public final Definition setName(String value) {
		_name = value;
		return this;
	}

	/**
	 * Annotations to this {@link Definition}
	 */
	public final java.util.List<Option> getOptions() {
		return _options;
	}

	/**
	 * @see #getOptions()
	 */
	public final Definition setOptions(java.util.List<Option> value) {
		_options.clear();
		_options.addAll(value);
		return this;
	}

	/**
	 * Adds a value to the {@link #getOptions()} list.
	 */
	public final Definition addOption(Option value) {
		_options.add(value);
		return this;
	}

	/**
	 * Reference back to the {@link DefinitionFile} that contains this definition.
	 */
	public final DefinitionFile getFile() {
		return _file;
	}

	/**
	 * @see #getFile()
	 */
	public final Definition setFile(DefinitionFile value) {
		_file = value;
		return this;
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
	public final MessageDef getOuter() {
		return _outer;
	}

	/**
	 * @see #getOuter()
	 */
	public final Definition setOuter(MessageDef value) {
		_outer = value;
		return this;
	}

	/**
	 * Checks, whether {@link #getOuter()} has a value.
	 */
	public final boolean hasOuter() {
		return _outer != null;
	}

	/** Reads a new instance from the given reader. */
	public static Definition readDefinition(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		Definition result;
		in.beginArray();
		String type = in.nextString();
		switch (type) {
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
	protected abstract String jsonType();

	@Override
	public Object get(String field) {
		switch (field) {
			case "comment": return getComment();
			case "name": return getName();
			case "options": return getOptions();
			case "file": return getFile();
			case "outer": return getOuter();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case "comment": setComment((String) value); break;
			case "name": setName((String) value); break;
			case "options": setOptions((java.util.List<Option>) value); break;
			case "file": setFile((DefinitionFile) value); break;
			case "outer": setOuter((MessageDef) value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name("comment");
		out.value(getComment());
		out.name("name");
		out.value(getName());
		out.name("options");
		out.beginArray();
		for (Option x : getOptions()) {
			x.writeTo(out);
		}
		out.endArray();
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case "comment": setComment(in.nextString()); break;
			case "name": setName(in.nextString()); break;
			case "options": {
				in.beginArray();
				while (in.hasNext()) {
					addOption(Option.readOption(in));
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
		out.name(0);
		out.value(typeId());
		writeFields(out);
		out.endObject();
	}

	/** The binary identifier for this concrete type in the polymorphic {@link Definition} hierarchy. */
	protected abstract int typeId();

	/** Serializes all fields of this instance to the given binary output. */
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		out.name(1);
		out.value(getComment());
		out.name(2);
		out.value(getName());
		out.name(3);
		{
			java.util.List<Option> values = getOptions();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.OBJECT, values.size());
			for (Option x : values) {
				x.writeTo(out);
			}
			out.endArray();
		}
	}

	/** Reads a new instance from the given reader. */
	public static Definition readDefinition(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		Definition result;
		int typeField = in.nextName();
		assert typeField == 0;
		int type = in.nextInt();
		switch (type) {
			case 1: result = EnumDef.enumDef(); break;
			case 2: result = MessageDef.messageDef(); break;
			default: while (in.hasNext()) {in.skipValue(); } in.endObject(); return null;
		}
		while (in.hasNext()) {
			int field = in.nextName();
			result.readField(in, field);
		}
		in.endObject();
		return result;
	}

	/** Consumes the value for the field with the given ID and assigns its value. */
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case 1: setComment(in.nextString()); break;
			case 2: setName(in.nextString()); break;
			case 3: {
				in.beginArray();
				while (in.hasNext()) {
					addOption(Option.readOption(in));
				}
				in.endArray();
			}
			break;
			default: in.skipValue(); 
		}
	}

	/** Accepts the given visitor. */
	public abstract <R,A> R visit(Visitor<R,A> v, A arg);


}
