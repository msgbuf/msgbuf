package de.haumacher.msgbuf.generator.ast;

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

	private boolean _abstract;

	private QName _extends;

	private final java.util.List<Definition> _definitions = new java.util.ArrayList<>();

	private final java.util.List<Field> _fields = new java.util.ArrayList<>();

	private final java.util.List<MessageDef> _specializations = new java.util.ArrayList<>();

	private MessageDef _extendedDef;

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
	public final void addDefinition(Definition value) {
		_definitions.add(value);
	}

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
	public final void addField(Field value) {
		_fields.add(value);
	}

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
	public final void addSpecialization(MessageDef value) {
		_specializations.add(value);
	}

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

	private static final int[] FIELDS = {0, 0, 0, 0, 0, 0, };

	/** Reads a new instance from the given reader. */
	public static MessageDef readMessageDef(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		MessageDef result = new MessageDef();
		result.readContent(in);
		return result;
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
	protected void writeContent(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeContent(out);
		out.name("abstract");
		out.value(isAbstract());
		out.name("extends");
		getExtends().writeTo(out);
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
		out.name("specializations");
		out.beginArray();
		for (MessageDef x : getSpecializations()) {
			x.writeTo(out);
		}
		out.endArray();
		out.name("extendedDef");
		getExtendedDef().writeTo(out);
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
			case "specializations": {
				in.beginArray();
				while (in.hasNext()) {
					addSpecialization(MessageDef.readMessageDef(in));
				}
				in.endArray();
			}
			break;
			case "extendedDef": setExtendedDef(MessageDef.readMessageDef(in)); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public <R,A> R visit(Definition.Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}

}
