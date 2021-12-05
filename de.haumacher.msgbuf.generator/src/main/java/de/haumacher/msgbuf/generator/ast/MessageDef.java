package de.haumacher.msgbuf.generator.ast;

/**
 * {@link Definition} of a data class.
 */
public class MessageDef extends Definition<MessageDef> {

	/**
	 * Creates a {@link MessageDef} instance.
	 */
	public static MessageDef create() {
		return new MessageDef();
	}

	/** Identifier for the {@link MessageDef} type in JSON format. */
	public static final String MESSAGE_DEF__TYPE = "MessageDef";

	/** @see #isAbstract() */
	public static final String ABSTRACT = "abstract";

	/** @see #getExtends() */
	public static final String EXTENDS = "extends";

	/** @see #getDefinitions() */
	public static final String DEFINITIONS = "definitions";

	/** @see #getFields() */
	public static final String FIELDS = "fields";

	/** @see #getSpecializations() */
	public static final String SPECIALIZATIONS = "specializations";

	/** @see #getExtendedDef() */
	public static final String EXTENDED_DEF = "extendedDef";

	/** @see #getId() */
	public static final String ID = "id";

	private boolean _abstract = false;

	private QName _extends = null;

	private final java.util.List<Definition<?>> _definitions = new de.haumacher.msgbuf.util.ReferenceList<Definition<?>>() {
		@Override
		protected void beforeAdd(int index, Definition<?> element) {
			_listener.beforeAdd(de.haumacher.msgbuf.generator.ast.MessageDef.this, DEFINITIONS, index, element);
		}

		@Override
		protected void afterRemove(int index, Definition<?> element) {
			_listener.afterRemove(de.haumacher.msgbuf.generator.ast.MessageDef.this, DEFINITIONS, index, element);
		}
	};

	private final java.util.List<Field> _fields = new de.haumacher.msgbuf.util.ReferenceList<Field>() {
		@Override
		protected void beforeAdd(int index, Field element) {
			_listener.beforeAdd(de.haumacher.msgbuf.generator.ast.MessageDef.this, FIELDS, index, element);
		}

		@Override
		protected void afterRemove(int index, Field element) {
			_listener.afterRemove(de.haumacher.msgbuf.generator.ast.MessageDef.this, FIELDS, index, element);
		}
	};

	private transient final java.util.List<MessageDef> _specializations = new de.haumacher.msgbuf.util.ReferenceList<MessageDef>() {
		@Override
		protected void beforeAdd(int index, MessageDef element) {
			_listener.beforeAdd(de.haumacher.msgbuf.generator.ast.MessageDef.this, SPECIALIZATIONS, index, element);
		}

		@Override
		protected void afterRemove(int index, MessageDef element) {
			_listener.afterRemove(de.haumacher.msgbuf.generator.ast.MessageDef.this, SPECIALIZATIONS, index, element);
		}
	};

	private transient MessageDef _extendedDef = null;

	private transient int _id = 0;

	/**
	 * Creates a {@link MessageDef} instance.
	 *
	 * @see #create()
	 */
	protected MessageDef() {
		super();
	}

	@Override
	protected final MessageDef self() {
		return this;
	}

	@Override
	public TypeKind kind() {
		return TypeKind.MESSAGE_DEF;
	}

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
		_listener.beforeSet(this, ABSTRACT, value);
		_abstract = value;
		return self();
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
		_listener.beforeSet(this, EXTENDS, value);
		_extends = value;
		return self();
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
	public final java.util.List<Definition<?>> getDefinitions() {
		return _definitions;
	}

	/**
	 * @see #getDefinitions()
	 */
	public final MessageDef setDefinitions(java.util.List<Definition<?>> value) {
		if (value == null) throw new IllegalArgumentException("Property 'definitions' cannot be null.");
		_definitions.clear();
		_definitions.addAll(value);
		return self();
	}

	/**
	 * Adds a value to the {@link #getDefinitions()} list.
	 */
	public final MessageDef addDefinition(Definition<?> value) {
		_definitions.add(value);
		return self();
	}

	/**
	 * Removes a value from the {@link #getDefinitions()} list.
	 */
	public final MessageDef removeDefinition(Definition<?> value) {
		_definitions.remove(value);
		return self();
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
		if (value == null) throw new IllegalArgumentException("Property 'fields' cannot be null.");
		_fields.clear();
		_fields.addAll(value);
		return self();
	}

	/**
	 * Adds a value to the {@link #getFields()} list.
	 */
	public final MessageDef addField(Field value) {
		_fields.add(value);
		return self();
	}

	/**
	 * Removes a value from the {@link #getFields()} list.
	 */
	public final MessageDef removeField(Field value) {
		_fields.remove(value);
		return self();
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
		if (value == null) throw new IllegalArgumentException("Property 'specializations' cannot be null.");
		_specializations.clear();
		_specializations.addAll(value);
		return self();
	}

	/**
	 * Adds a value to the {@link #getSpecializations()} list.
	 */
	public final MessageDef addSpecialization(MessageDef value) {
		_specializations.add(value);
		return self();
	}

	/**
	 * Removes a value from the {@link #getSpecializations()} list.
	 */
	public final MessageDef removeSpecialization(MessageDef value) {
		_specializations.remove(value);
		return self();
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
		_listener.beforeSet(this, EXTENDED_DEF, value);
		_extendedDef = value;
		return self();
	}

	/**
	 * Checks, whether {@link #getExtendedDef()} has a value.
	 */
	public final boolean hasExtendedDef() {
		return _extendedDef != null;
	}

	/**
	 * The ID used for distinguishing an instance of this type from instances of other types in the same polymorphic hierarchy.
	 */
	public final int getId() {
		return _id;
	}

	/**
	 * @see #getId()
	 */
	public final MessageDef setId(int value) {
		_listener.beforeSet(this, ID, value);
		_id = value;
		return self();
	}

	@Override
	public String jsonType() {
		return MESSAGE_DEF__TYPE;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			ABSTRACT, 
			EXTENDS, 
			DEFINITIONS, 
			FIELDS, 
			SPECIALIZATIONS, 
			EXTENDED_DEF, 
			ID));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case ABSTRACT: return isAbstract();
			case EXTENDS: return getExtends();
			case DEFINITIONS: return getDefinitions();
			case FIELDS: return getFields();
			case SPECIALIZATIONS: return getSpecializations();
			case EXTENDED_DEF: return getExtendedDef();
			case ID: return getId();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case ABSTRACT: setAbstract((boolean) value); break;
			case EXTENDS: setExtends((QName) value); break;
			case DEFINITIONS: setDefinitions((java.util.List<Definition<?>>) value); break;
			case FIELDS: setFields((java.util.List<Field>) value); break;
			case SPECIALIZATIONS: setSpecializations((java.util.List<MessageDef>) value); break;
			case EXTENDED_DEF: setExtendedDef((MessageDef) value); break;
			case ID: setId((int) value); break;
			default: super.set(field, value); break;
		}
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
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(ABSTRACT);
		out.value(isAbstract());
		if (hasExtends()) {
			out.name(EXTENDS);
			getExtends().writeTo(out);
		}
		out.name(DEFINITIONS);
		out.beginArray();
		for (Definition<?> x : getDefinitions()) {
			x.writeTo(out);
		}
		out.endArray();
		out.name(FIELDS);
		out.beginArray();
		for (Field x : getFields()) {
			x.writeContent(out);
		}
		out.endArray();
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case ABSTRACT: setAbstract(in.nextBoolean()); break;
			case EXTENDS: setExtends(de.haumacher.msgbuf.generator.ast.QName.readQName(in)); break;
			case DEFINITIONS: {
				in.beginArray();
				while (in.hasNext()) {
					addDefinition(de.haumacher.msgbuf.generator.ast.Definition.readDefinition(in));
				}
				in.endArray();
			}
			break;
			case FIELDS: {
				in.beginArray();
				while (in.hasNext()) {
					addField(de.haumacher.msgbuf.generator.ast.Field.readField(in));
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
