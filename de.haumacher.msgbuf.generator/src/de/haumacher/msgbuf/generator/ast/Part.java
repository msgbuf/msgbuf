package de.haumacher.msgbuf.generator.ast;

/**
 * Member of a {@link Definition}.
 */
public abstract class Part extends de.haumacher.msgbuf.data.AbstractDataObject implements de.haumacher.msgbuf.binary.BinaryDataObject {

	/** Visitor interface for the {@link Part} hierarchy.*/
	public interface Visitor<R,A> {

		/** Visit case for {@link Constant}.*/
		R visit(Constant self, A arg);

		/** Visit case for {@link Field}.*/
		R visit(Field self, A arg);

	}

	/**
	 * Creates a {@link Part} instance.
	 */
	protected Part() {
		super();
	}

	private String _comment = "";

	private String _name = "";

	private int _index = 0;

	private final java.util.List<Option> _options = new java.util.ArrayList<>();

	private transient Definition _owner = null;

	/**
	 * The documentation comment for this member.
	 */
	public final String getComment() {
		return _comment;
	}

	/**
	 * @see #getComment()
	 */
	public final Part setComment(String value) {
		_comment = value;
		return this;
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
	public final Part setName(String value) {
		_name = value;
		return this;
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
	public final Part setIndex(int value) {
		_index = value;
		return this;
	}

	/**
	 * Annotations to this {@link Part}
	 */
	public final java.util.List<Option> getOptions() {
		return _options;
	}

	/**
	 * @see #getOptions()
	 */
	public final Part setOptions(java.util.List<Option> value) {
		_options.clear();
		_options.addAll(value);
		return this;
	}

	/**
	 * Adds a value to the {@link #getOptions()} list.
	 */
	public final Part addOption(Option value) {
		_options.add(value);
		return this;
	}

	/**
	 * The {@link Definition} definint this {@link Part}.
	 */
	public final Definition getOwner() {
		return _owner;
	}

	/**
	 * @see #getOwner()
	 */
	public final Part setOwner(Definition value) {
		_owner = value;
		return this;
	}

	/**
	 * Checks, whether {@link #getOwner()} has a value.
	 */
	public final boolean hasOwner() {
		return _owner != null;
	}

	/** Reads a new instance from the given reader. */
	public static Part readPart(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		Part result;
		in.beginArray();
		String type = in.nextString();
		switch (type) {
			case "Constant": result = Constant.readConstant(in); break;
			case "Field": result = Field.readField(in); break;
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
			case "index": return getIndex();
			case "options": return getOptions();
			case "owner": return getOwner();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case "comment": setComment((String) value); break;
			case "name": setName((String) value); break;
			case "index": setIndex((int) value); break;
			case "options": setOptions((java.util.List<Option>) value); break;
			case "owner": setOwner((Definition) value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name("comment");
		out.value(getComment());
		out.name("name");
		out.value(getName());
		out.name("index");
		out.value(getIndex());
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
			case "index": setIndex(in.nextInt()); break;
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

	/** The binary identifier for this concrete type in the polymorphic {@link Part} hierarchy. */
	protected abstract int typeId();

	/** Serializes all fields of this instance to the given binary output. */
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		out.name(1);
		out.value(getComment());
		out.name(2);
		out.value(getName());
		out.name(3);
		out.value(getIndex());
		out.name(4);
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
	public static Part readPart(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		Part result;
		int typeField = in.nextName();
		assert typeField == 0;
		int type = in.nextInt();
		switch (type) {
			case 1: result = Constant.constant(); break;
			case 2: result = Field.field(); break;
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
			case 3: setIndex(in.nextInt()); break;
			case 4: {
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