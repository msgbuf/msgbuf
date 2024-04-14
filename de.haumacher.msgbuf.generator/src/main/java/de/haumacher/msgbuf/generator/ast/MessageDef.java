package de.haumacher.msgbuf.generator.ast;

/**
 * {@link Definition} of a data class.
 */
public class MessageDef extends Definition implements de.haumacher.msgbuf.generator.MessageDefOperations {

	/**
	 * Creates a {@link de.haumacher.msgbuf.generator.ast.MessageDef} instance.
	 */
	public static de.haumacher.msgbuf.generator.ast.MessageDef create() {
		return new de.haumacher.msgbuf.generator.ast.MessageDef();
	}

	/** Identifier for the {@link de.haumacher.msgbuf.generator.ast.MessageDef} type in JSON format. */
	public static final String MESSAGE_DEF__TYPE = "MessageDef";

	/** @see #isAbstract() */
	public static final String ABSTRACT__PROP = "abstract";

	/** @see #getExtends() */
	public static final String EXTENDS__PROP = "extends";

	/** @see #getDefinitions() */
	public static final String DEFINITIONS__PROP = "definitions";

	/** @see #getFields() */
	public static final String FIELDS__PROP = "fields";

	/** @see #getSpecializations() */
	public static final String SPECIALIZATIONS__PROP = "specializations";

	/** @see #getExtendedDef() */
	public static final String EXTENDED_DEF__PROP = "extendedDef";

	/** @see #getId() */
	public static final String ID__PROP = "id";

	private boolean _abstract = false;

	private de.haumacher.msgbuf.generator.ast.QName _extends = null;

	private final java.util.List<de.haumacher.msgbuf.generator.ast.Definition> _definitions = new de.haumacher.msgbuf.util.ReferenceList<>() {
		@Override
		protected void beforeAdd(int index, de.haumacher.msgbuf.generator.ast.Definition element) {
			_listener.beforeAdd(MessageDef.this, DEFINITIONS__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, de.haumacher.msgbuf.generator.ast.Definition element) {
			_listener.afterRemove(MessageDef.this, DEFINITIONS__PROP, index, element);
		}
	};

	private final java.util.List<de.haumacher.msgbuf.generator.ast.Field> _fields = new de.haumacher.msgbuf.util.ReferenceList<>() {
		@Override
		protected void beforeAdd(int index, de.haumacher.msgbuf.generator.ast.Field element) {
			_listener.beforeAdd(MessageDef.this, FIELDS__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, de.haumacher.msgbuf.generator.ast.Field element) {
			_listener.afterRemove(MessageDef.this, FIELDS__PROP, index, element);
		}
	};

	private transient final java.util.List<de.haumacher.msgbuf.generator.ast.MessageDef> _specializations = new de.haumacher.msgbuf.util.ReferenceList<>() {
		@Override
		protected void beforeAdd(int index, de.haumacher.msgbuf.generator.ast.MessageDef element) {
			_listener.beforeAdd(MessageDef.this, SPECIALIZATIONS__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, de.haumacher.msgbuf.generator.ast.MessageDef element) {
			_listener.afterRemove(MessageDef.this, SPECIALIZATIONS__PROP, index, element);
		}
	};

	private transient de.haumacher.msgbuf.generator.ast.MessageDef _extendedDef = null;

	private transient int _id = 0;

	/**
	 * Creates a {@link MessageDef} instance.
	 *
	 * @see de.haumacher.msgbuf.generator.ast.MessageDef#create()
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
	public de.haumacher.msgbuf.generator.ast.MessageDef setAbstract(boolean value) {
		internalSetAbstract(value);
		return this;
	}

	/** Internal setter for {@link #isAbstract()} without chain call utility. */
	protected final void internalSetAbstract(boolean value) {
		_listener.beforeSet(this, ABSTRACT__PROP, value);
		_abstract = value;
	}

	/**
	 * Optional reference to another {@link MessageDef} whoes fields are inherited.
	 */
	public final de.haumacher.msgbuf.generator.ast.QName getExtends() {
		return _extends;
	}

	/**
	 * @see #getExtends()
	 */
	public de.haumacher.msgbuf.generator.ast.MessageDef setExtends(de.haumacher.msgbuf.generator.ast.QName value) {
		internalSetExtends(value);
		return this;
	}

	/** Internal setter for {@link #getExtends()} without chain call utility. */
	protected final void internalSetExtends(de.haumacher.msgbuf.generator.ast.QName value) {
		_listener.beforeSet(this, EXTENDS__PROP, value);
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
	public final java.util.List<de.haumacher.msgbuf.generator.ast.Definition> getDefinitions() {
		return _definitions;
	}

	/**
	 * @see #getDefinitions()
	 */
	public de.haumacher.msgbuf.generator.ast.MessageDef setDefinitions(java.util.List<? extends de.haumacher.msgbuf.generator.ast.Definition> value) {
		internalSetDefinitions(value);
		return this;
	}

	/** Internal setter for {@link #getDefinitions()} without chain call utility. */
	protected final void internalSetDefinitions(java.util.List<? extends de.haumacher.msgbuf.generator.ast.Definition> value) {
		if (value == null) throw new IllegalArgumentException("Property 'definitions' cannot be null.");
		_definitions.clear();
		_definitions.addAll(value);
	}

	/**
	 * Adds a value to the {@link #getDefinitions()} list.
	 */
	public de.haumacher.msgbuf.generator.ast.MessageDef addDefinition(de.haumacher.msgbuf.generator.ast.Definition value) {
		internalAddDefinition(value);
		return this;
	}

	/** Implementation of {@link #addDefinition(de.haumacher.msgbuf.generator.ast.Definition)} without chain call utility. */
	protected final void internalAddDefinition(de.haumacher.msgbuf.generator.ast.Definition value) {
		_definitions.add(value);
	}

	/**
	 * Removes a value from the {@link #getDefinitions()} list.
	 */
	public final void removeDefinition(de.haumacher.msgbuf.generator.ast.Definition value) {
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
	public final java.util.List<de.haumacher.msgbuf.generator.ast.Field> getFields() {
		return _fields;
	}

	/**
	 * @see #getFields()
	 */
	public de.haumacher.msgbuf.generator.ast.MessageDef setFields(java.util.List<? extends de.haumacher.msgbuf.generator.ast.Field> value) {
		internalSetFields(value);
		return this;
	}

	/** Internal setter for {@link #getFields()} without chain call utility. */
	protected final void internalSetFields(java.util.List<? extends de.haumacher.msgbuf.generator.ast.Field> value) {
		if (value == null) throw new IllegalArgumentException("Property 'fields' cannot be null.");
		_fields.clear();
		_fields.addAll(value);
	}

	/**
	 * Adds a value to the {@link #getFields()} list.
	 */
	public de.haumacher.msgbuf.generator.ast.MessageDef addField(de.haumacher.msgbuf.generator.ast.Field value) {
		internalAddField(value);
		return this;
	}

	/** Implementation of {@link #addField(de.haumacher.msgbuf.generator.ast.Field)} without chain call utility. */
	protected final void internalAddField(de.haumacher.msgbuf.generator.ast.Field value) {
		_fields.add(value);
	}

	/**
	 * Removes a value from the {@link #getFields()} list.
	 */
	public final void removeField(de.haumacher.msgbuf.generator.ast.Field value) {
		_fields.remove(value);
	}

	/**
	 * All {@link MessageDef data classes} that inherit from this data class.
	 */
	public final java.util.List<de.haumacher.msgbuf.generator.ast.MessageDef> getSpecializations() {
		return _specializations;
	}

	/**
	 * @see #getSpecializations()
	 */
	public de.haumacher.msgbuf.generator.ast.MessageDef setSpecializations(java.util.List<? extends de.haumacher.msgbuf.generator.ast.MessageDef> value) {
		internalSetSpecializations(value);
		return this;
	}

	/** Internal setter for {@link #getSpecializations()} without chain call utility. */
	protected final void internalSetSpecializations(java.util.List<? extends de.haumacher.msgbuf.generator.ast.MessageDef> value) {
		if (value == null) throw new IllegalArgumentException("Property 'specializations' cannot be null.");
		_specializations.clear();
		_specializations.addAll(value);
	}

	/**
	 * Adds a value to the {@link #getSpecializations()} list.
	 */
	public de.haumacher.msgbuf.generator.ast.MessageDef addSpecialization(de.haumacher.msgbuf.generator.ast.MessageDef value) {
		internalAddSpecialization(value);
		return this;
	}

	/** Implementation of {@link #addSpecialization(de.haumacher.msgbuf.generator.ast.MessageDef)} without chain call utility. */
	protected final void internalAddSpecialization(de.haumacher.msgbuf.generator.ast.MessageDef value) {
		_specializations.add(value);
	}

	/**
	 * Removes a value from the {@link #getSpecializations()} list.
	 */
	public final void removeSpecialization(de.haumacher.msgbuf.generator.ast.MessageDef value) {
		_specializations.remove(value);
	}

	/**
	 * Reference to the {@link MessageDef data class definition} that is referenced by the {@link #getExtends()} clause.
	 */
	public final de.haumacher.msgbuf.generator.ast.MessageDef getExtendedDef() {
		return _extendedDef;
	}

	/**
	 * @see #getExtendedDef()
	 */
	public de.haumacher.msgbuf.generator.ast.MessageDef setExtendedDef(de.haumacher.msgbuf.generator.ast.MessageDef value) {
		internalSetExtendedDef(value);
		return this;
	}

	/** Internal setter for {@link #getExtendedDef()} without chain call utility. */
	protected final void internalSetExtendedDef(de.haumacher.msgbuf.generator.ast.MessageDef value) {
		_listener.beforeSet(this, EXTENDED_DEF__PROP, value);
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
	public de.haumacher.msgbuf.generator.ast.MessageDef setId(int value) {
		internalSetId(value);
		return this;
	}

	/** Internal setter for {@link #getId()} without chain call utility. */
	protected final void internalSetId(int value) {
		_listener.beforeSet(this, ID__PROP, value);
		_id = value;
	}

	@Override
	public de.haumacher.msgbuf.generator.ast.MessageDef setName(String value) {
		internalSetName(value);
		return this;
	}

	@Override
	public de.haumacher.msgbuf.generator.ast.MessageDef setFile(de.haumacher.msgbuf.generator.ast.DefinitionFile value) {
		internalSetFile(value);
		return this;
	}

	@Override
	public de.haumacher.msgbuf.generator.ast.MessageDef setOuter(de.haumacher.msgbuf.generator.ast.MessageDef value) {
		internalSetOuter(value);
		return this;
	}

	@Override
	public de.haumacher.msgbuf.generator.ast.MessageDef setComment(String value) {
		internalSetComment(value);
		return this;
	}

	@Override
	public de.haumacher.msgbuf.generator.ast.MessageDef setOptions(java.util.Map<String, de.haumacher.msgbuf.generator.ast.Option> value) {
		internalSetOptions(value);
		return this;
	}

	@Override
	public de.haumacher.msgbuf.generator.ast.MessageDef putOption(String key, de.haumacher.msgbuf.generator.ast.Option value) {
		internalPutOption(key, value);
		return this;
	}

	@Override
	public String jsonType() {
		return MESSAGE_DEF__TYPE;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			ABSTRACT__PROP, 
			EXTENDS__PROP, 
			DEFINITIONS__PROP, 
			FIELDS__PROP, 
			SPECIALIZATIONS__PROP, 
			EXTENDED_DEF__PROP, 
			ID__PROP));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case ABSTRACT__PROP: return isAbstract();
			case EXTENDS__PROP: return getExtends();
			case DEFINITIONS__PROP: return getDefinitions();
			case FIELDS__PROP: return getFields();
			case SPECIALIZATIONS__PROP: return getSpecializations();
			case EXTENDED_DEF__PROP: return getExtendedDef();
			case ID__PROP: return getId();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case ABSTRACT__PROP: internalSetAbstract((boolean) value); break;
			case EXTENDS__PROP: internalSetExtends((de.haumacher.msgbuf.generator.ast.QName) value); break;
			case DEFINITIONS__PROP: internalSetDefinitions(de.haumacher.msgbuf.util.Conversions.asList(de.haumacher.msgbuf.generator.ast.Definition.class, value)); break;
			case FIELDS__PROP: internalSetFields(de.haumacher.msgbuf.util.Conversions.asList(de.haumacher.msgbuf.generator.ast.Field.class, value)); break;
			case SPECIALIZATIONS__PROP: internalSetSpecializations(de.haumacher.msgbuf.util.Conversions.asList(de.haumacher.msgbuf.generator.ast.MessageDef.class, value)); break;
			case EXTENDED_DEF__PROP: internalSetExtendedDef((de.haumacher.msgbuf.generator.ast.MessageDef) value); break;
			case ID__PROP: internalSetId((int) value); break;
			default: super.set(field, value); break;
		}
	}

	/** Reads a new instance from the given reader. */
	public static de.haumacher.msgbuf.generator.ast.MessageDef readMessageDef(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		de.haumacher.msgbuf.generator.ast.MessageDef result = new de.haumacher.msgbuf.generator.ast.MessageDef();
		result.readContent(in);
		return result;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(ABSTRACT__PROP);
		out.value(isAbstract());
		if (hasExtends()) {
			out.name(EXTENDS__PROP);
			getExtends().writeTo(out);
		}
		out.name(DEFINITIONS__PROP);
		out.beginArray();
		for (de.haumacher.msgbuf.generator.ast.Definition x : getDefinitions()) {
			x.writeTo(out);
		}
		out.endArray();
		out.name(FIELDS__PROP);
		out.beginArray();
		for (de.haumacher.msgbuf.generator.ast.Field x : getFields()) {
			x.writeContent(out);
		}
		out.endArray();
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case ABSTRACT__PROP: setAbstract(in.nextBoolean()); break;
			case EXTENDS__PROP: setExtends(de.haumacher.msgbuf.generator.ast.QName.readQName(in)); break;
			case DEFINITIONS__PROP: {
				in.beginArray();
				while (in.hasNext()) {
					addDefinition(de.haumacher.msgbuf.generator.ast.Definition.readDefinition(in));
				}
				in.endArray();
			}
			break;
			case FIELDS__PROP: {
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
	public MessageDef self() {
		return this;
	}

	@Override
	public <R,A> R visit(de.haumacher.msgbuf.generator.ast.Definition.Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}

}
