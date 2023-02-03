package de.haumacher.msgbuf.generator.ast;

/**
 * {@link Definition} of a data class.
 */
public class MessageDef extends Definition implements de.haumacher.msgbuf.generator.MessageDefOperations {

	/**
	 * Creates a {@link MessageDef} instance.
	 */
	public static MessageDef create() {
		return new de.haumacher.msgbuf.generator.ast.MessageDef();
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

	private final java.util.List<Definition> _definitions = new de.haumacher.msgbuf.util.ReferenceList<Definition>() {
		@Override
		protected void beforeAdd(int index, Definition element) {
			_listener.beforeAdd(MessageDef.this, DEFINITIONS, index, element);
		}

		@Override
		protected void afterRemove(int index, Definition element) {
			_listener.afterRemove(MessageDef.this, DEFINITIONS, index, element);
		}
	};

	private final java.util.List<Field> _fields = new de.haumacher.msgbuf.util.ReferenceList<Field>() {
		@Override
		protected void beforeAdd(int index, Field element) {
			_listener.beforeAdd(MessageDef.this, FIELDS, index, element);
		}

		@Override
		protected void afterRemove(int index, Field element) {
			_listener.afterRemove(MessageDef.this, FIELDS, index, element);
		}
	};

	private transient final java.util.List<MessageDef> _specializations = new de.haumacher.msgbuf.util.ReferenceList<MessageDef>() {
		@Override
		protected void beforeAdd(int index, MessageDef element) {
			_listener.beforeAdd(MessageDef.this, SPECIALIZATIONS, index, element);
		}

		@Override
		protected void afterRemove(int index, MessageDef element) {
			_listener.afterRemove(MessageDef.this, SPECIALIZATIONS, index, element);
		}
	};

	private transient MessageDef _extendedDef = null;

	private transient int _id = 0;

	/**
	 * Creates a {@link MessageDef} instance.
	 *
	 * @see MessageDef#create()
	 */
	protected MessageDef() {
		super();
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
	public MessageDef setAbstract(boolean value) {
		internalSetAbstract(value);
		return this;
	}

	/** Internal setter for {@link #isAbstract()} without chain call utility. */
	protected final void internalSetAbstract(boolean value) {
		_listener.beforeSet(this, ABSTRACT, value);
		_abstract = value;
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
	public MessageDef setExtends(QName value) {
		internalSetExtends(value);
		return this;
	}

	/** Internal setter for {@link #getExtends()} without chain call utility. */
	protected final void internalSetExtends(QName value) {
		_listener.beforeSet(this, EXTENDS, value);
		_extends = value;
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
	public MessageDef setDefinitions(java.util.List<? extends Definition> value) {
		internalSetDefinitions(value);
		return this;
	}

	/** Internal setter for {@link #getDefinitions()} without chain call utility. */
	protected final void internalSetDefinitions(java.util.List<? extends Definition> value) {
		if (value == null) throw new IllegalArgumentException("Property 'definitions' cannot be null.");
		_definitions.clear();
		_definitions.addAll(value);
	}

	/**
	 * Adds a value to the {@link #getDefinitions()} list.
	 */
	public MessageDef addDefinition(Definition value) {
		internalAddDefinition(value);
		return this;
	}

	/** Implementation of {@link #addDefinition(Definition)} without chain call utility. */
	protected final void internalAddDefinition(Definition value) {
		_definitions.add(value);
	}

	/**
	 * Removes a value from the {@link #getDefinitions()} list.
	 */
	public final void removeDefinition(Definition value) {
		_definitions.remove(value);
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
	public MessageDef setFields(java.util.List<? extends Field> value) {
		internalSetFields(value);
		return this;
	}

	/** Internal setter for {@link #getFields()} without chain call utility. */
	protected final void internalSetFields(java.util.List<? extends Field> value) {
		if (value == null) throw new IllegalArgumentException("Property 'fields' cannot be null.");
		_fields.clear();
		_fields.addAll(value);
	}

	/**
	 * Adds a value to the {@link #getFields()} list.
	 */
	public MessageDef addField(Field value) {
		internalAddField(value);
		return this;
	}

	/** Implementation of {@link #addField(Field)} without chain call utility. */
	protected final void internalAddField(Field value) {
		_fields.add(value);
	}

	/**
	 * Removes a value from the {@link #getFields()} list.
	 */
	public final void removeField(Field value) {
		_fields.remove(value);
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
	public MessageDef setSpecializations(java.util.List<? extends MessageDef> value) {
		internalSetSpecializations(value);
		return this;
	}

	/** Internal setter for {@link #getSpecializations()} without chain call utility. */
	protected final void internalSetSpecializations(java.util.List<? extends MessageDef> value) {
		if (value == null) throw new IllegalArgumentException("Property 'specializations' cannot be null.");
		_specializations.clear();
		_specializations.addAll(value);
	}

	/**
	 * Adds a value to the {@link #getSpecializations()} list.
	 */
	public MessageDef addSpecialization(MessageDef value) {
		internalAddSpecialization(value);
		return this;
	}

	/** Implementation of {@link #addSpecialization(MessageDef)} without chain call utility. */
	protected final void internalAddSpecialization(MessageDef value) {
		_specializations.add(value);
	}

	/**
	 * Removes a value from the {@link #getSpecializations()} list.
	 */
	public final void removeSpecialization(MessageDef value) {
		_specializations.remove(value);
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
	public MessageDef setExtendedDef(MessageDef value) {
		internalSetExtendedDef(value);
		return this;
	}

	/** Internal setter for {@link #getExtendedDef()} without chain call utility. */
	protected final void internalSetExtendedDef(MessageDef value) {
		_listener.beforeSet(this, EXTENDED_DEF, value);
		_extendedDef = value;
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
	public MessageDef setId(int value) {
		internalSetId(value);
		return this;
	}

	/** Internal setter for {@link #getId()} without chain call utility. */
	protected final void internalSetId(int value) {
		_listener.beforeSet(this, ID, value);
		_id = value;
	}

	@Override
	public MessageDef setName(String value) {
		internalSetName(value);
		return this;
	}

	@Override
	public MessageDef setFile(DefinitionFile value) {
		internalSetFile(value);
		return this;
	}

	@Override
	public MessageDef setOuter(MessageDef value) {
		internalSetOuter(value);
		return this;
	}

	@Override
	public MessageDef setComment(String value) {
		internalSetComment(value);
		return this;
	}

	@Override
	public MessageDef setOptions(java.util.Map<String, Option> value) {
		internalSetOptions(value);
		return this;
	}

	@Override
	public MessageDef putOption(String key, Option value) {
		internalPutOption(key, value);
		return this;
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
			case ABSTRACT: internalSetAbstract((boolean) value); break;
			case EXTENDS: internalSetExtends((QName) value); break;
			case DEFINITIONS: internalSetDefinitions(de.haumacher.msgbuf.util.Conversions.asList(Definition.class, value)); break;
			case FIELDS: internalSetFields(de.haumacher.msgbuf.util.Conversions.asList(Field.class, value)); break;
			case SPECIALIZATIONS: internalSetSpecializations(de.haumacher.msgbuf.util.Conversions.asList(MessageDef.class, value)); break;
			case EXTENDED_DEF: internalSetExtendedDef((MessageDef) value); break;
			case ID: internalSetId((int) value); break;
			default: super.set(field, value); break;
		}
	}

	/** Reads a new instance from the given reader. */
	public static MessageDef readMessageDef(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		de.haumacher.msgbuf.generator.ast.MessageDef result = new de.haumacher.msgbuf.generator.ast.MessageDef();
		result.readContent(in);
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
		for (Definition x : getDefinitions()) {
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

	@Override
	public MessageDef self() {
		return this;
	}

}
