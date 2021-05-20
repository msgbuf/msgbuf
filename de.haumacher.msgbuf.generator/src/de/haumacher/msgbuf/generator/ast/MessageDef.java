package de.haumacher.msgbuf.generator.ast;

/**
 * {@link Definition} of a data class.
 */
public class MessageDef extends Definition {

	/**
	 * Creates a {@link MessageDef} instance.
	 */
	public static MessageDef messageDef() {
		return new MessageDef();
	}

	/**
	 * Creates a {@link MessageDef} instance.
	 *
	 * @see #messageDef()
	 */
	protected MessageDef() {
		super();
	}

	private boolean _abstract = false;

	private QName _extends = null;

	private final java.util.List<Definition> _definitions = new java.util.ArrayList<>();

	private final java.util.List<Field> _fields = new java.util.ArrayList<>();

	private transient final java.util.List<MessageDef> _specializations = new java.util.ArrayList<>();

	private transient MessageDef _extendedDef = null;

	/**
	 * Whether this class only serves as super type for other data classes.
	 */
	public final boolean isAbstract() {
		return _abstract;
	}

	/**
	 * @see #isAbstract()
	 */
	public final MessageDef setAbstract(boolean value) {
		_abstract = value;
		return this;
	}

	/**
	 * Optional reference to another {@link MessageDef} whoes fields are inherited.
	 */
	public final QName getExtends() {
		return _extends;
	}

	/**
	 * @see #getExtends()
	 */
	public final MessageDef setExtends(QName value) {
		_extends = value;
		return this;
	}

	/**
	 * Checks, whether {@link #getExtends()} has a value.
	 */
	public final boolean hasExtends() {
		return _extends != null;
	}

	/**
	 * Ohter {@link Definition}s that are local to this data class.
	 */
	public final java.util.List<Definition> getDefinitions() {
		return _definitions;
	}

	/**
	 * @see #getDefinitions()
	 */
	public final MessageDef setDefinitions(java.util.List<Definition> value) {
		_definitions.clear();
		_definitions.addAll(value);
		return this;
	}

	/**
	 * Adds a value to the {@link #getDefinitions()} list.
	 */
	public final MessageDef addDefinition(Definition value) {
		_definitions.add(value);
		return this;
	}

	/**
	 * All {@link Field}s locally defined in this data class. 
	 *
	 * <p>
	 * This list does not contain {@link Field}s that are {@link #getExtends() inherited} from other data classes.
	 * </p>
	 *
	 * @see #getExtends()
	 */
	public final java.util.List<Field> getFields() {
		return _fields;
	}

	/**
	 * @see #getFields()
	 */
	public final MessageDef setFields(java.util.List<Field> value) {
		_fields.clear();
		_fields.addAll(value);
		return this;
	}

	/**
	 * Adds a value to the {@link #getFields()} list.
	 */
	public final MessageDef addField(Field value) {
		_fields.add(value);
		return this;
	}

	/**
	 * All {@link MessageDef data classes} that inherit from this data class.
	 */
	public final java.util.List<MessageDef> getSpecializations() {
		return _specializations;
	}

	/**
	 * @see #getSpecializations()
	 */
	public final MessageDef setSpecializations(java.util.List<MessageDef> value) {
		_specializations.clear();
		_specializations.addAll(value);
		return this;
	}

	/**
	 * Adds a value to the {@link #getSpecializations()} list.
	 */
	public final MessageDef addSpecialization(MessageDef value) {
		_specializations.add(value);
		return this;
	}

	/**
	 * Reference to the {@link MessageDef data class definition} that is referenced by the {@link #getExtends()} clause.
	 */
	public final MessageDef getExtendedDef() {
		return _extendedDef;
	}

	/**
	 * @see #getExtendedDef()
	 */
	public final MessageDef setExtendedDef(MessageDef value) {
		_extendedDef = value;
		return this;
	}

	/**
	 * Checks, whether {@link #getExtendedDef()} has a value.
	 */
	public final boolean hasExtendedDef() {
		return _extendedDef != null;
	}

	/** Reads a new instance from the given reader. */
	public static MessageDef readMessageDef(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		MessageDef result = new MessageDef();
		in.beginObject();
		result.readFields(in);
		in.endObject();
		return result;
	}

	@Override
	protected String jsonType() {
		return "MessageDef";
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case "abstract": return isAbstract();
			case "extends": return getExtends();
			case "definitions": return getDefinitions();
			case "fields": return getFields();
			case "specializations": return getSpecializations();
			case "extendedDef": return getExtendedDef();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case "abstract": setAbstract((boolean) value); break;
			case "extends": setExtends((QName) value); break;
			case "definitions": setDefinitions((java.util.List<Definition>) value); break;
			case "fields": setFields((java.util.List<Field>) value); break;
			case "specializations": setSpecializations((java.util.List<MessageDef>) value); break;
			case "extendedDef": setExtendedDef((MessageDef) value); break;
			default: super.set(field, value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name("abstract");
		out.value(isAbstract());
		if (hasExtends()) {
			out.name("extends");
			getExtends().writeTo(out);
		}
		out.name("definitions");
		out.beginArray();
		for (Definition x : getDefinitions()) {
			x.writeTo(out);
		}
		out.endArray();
		out.name("fields");
		out.beginArray();
		for (Field x : getFields()) {
			x.writeTo(out);
		}
		out.endArray();
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case "abstract": setAbstract(in.nextBoolean()); break;
			case "extends": setExtends(QName.readQName(in)); break;
			case "definitions": {
				in.beginArray();
				while (in.hasNext()) {
					addDefinition(Definition.readDefinition(in));
				}
				in.endArray();
			}
			break;
			case "fields": {
				in.beginArray();
				while (in.hasNext()) {
					addField(Field.readField(in));
				}
				in.endArray();
			}
			break;
			default: super.readField(in, field);
		}
	}

	@Override
	public <R,A> R visit(Definition.Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}

}
