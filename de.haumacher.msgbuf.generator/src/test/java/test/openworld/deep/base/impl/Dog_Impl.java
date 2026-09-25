package test.openworld.deep.base.impl;

/**
 * Implementation of {@link test.openworld.deep.base.Dog}.
 */
public class Dog_Impl extends test.openworld.deep.base.impl.Animal_Impl implements test.openworld.deep.base.Dog {

	private boolean _good = false;

	/**
	 * Creates a {@link Dog_Impl} instance.
	 *
	 * @see test.openworld.deep.base.Dog#create()
	 */
	public Dog_Impl() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.DOG;
	}

	@Override
	public final boolean isGood() {
		return _good;
	}

	@Override
	public test.openworld.deep.base.Dog setGood(boolean value) {
		internalSetGood(value);
		return this;
	}

	/** Internal setter for {@link #isGood()} without chain call utility. */
	protected final void internalSetGood(boolean value) {
		_listener.beforeSet(this, GOOD__PROP, value);
		_good = value;
		_listener.afterChanged(this, GOOD__PROP);
	}

	@Override
	public test.openworld.deep.base.Dog setName(String value) {
		internalSetName(value);
		return this;
	}

	@Override
	public String jsonType() {
		return DOG__TYPE;
	}

	@SuppressWarnings("hiding")
	protected static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			GOOD__PROP);
		java.util.List<String> tmp = new java.util.ArrayList<>();
		tmp.addAll(test.openworld.deep.base.impl.Animal_Impl.PROPERTIES);
		tmp.addAll(local);
		PROPERTIES = java.util.Collections.unmodifiableList(tmp);
	}

	@SuppressWarnings("hiding")
	protected static final java.util.Set<String> TRANSIENT_PROPERTIES;
	static {
		java.util.HashSet<String> tmp = new java.util.HashSet<>();
		tmp.addAll(test.openworld.deep.base.impl.Animal_Impl.TRANSIENT_PROPERTIES);
		tmp.addAll(java.util.Arrays.asList(
				));
		TRANSIENT_PROPERTIES = java.util.Collections.unmodifiableSet(tmp);
	}

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public java.util.Set<String> transientProperties() {
		return TRANSIENT_PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case GOOD__PROP: return isGood();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case GOOD__PROP: internalSetGood((boolean) value); break;
			default: super.set(field, value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(GOOD__PROP);
		out.value(isGood());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case GOOD__PROP: setGood(in.nextBoolean()); break;
			default: super.readField(in, field);
		}
	}

	/** XML element name representing a {@link test.openworld.deep.base.Dog} type. */
	public static final String DOG__XML_ELEMENT = "dog";

	/** XML attribute or element name of a {@link #isGood} property. */
	private static final String GOOD__XML_ATTR = "good";

	@Override
	public String getXmlTagName() {
		return DOG__XML_ELEMENT;
	}

	/** Serializes all fields that are written as XML attributes. */
	@Override
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeAttributes(out);
		out.writeAttribute(GOOD__XML_ATTR, Boolean.toString(isGood()));
	}

	/** Serializes all fields that are written as XML elements. */
	@Override
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeElements(out);
		// No element fields.
	}

	/** Creates a new {@link test.openworld.deep.base.Dog} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Dog_Impl readDog_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		Dog_Impl result = new Dog_Impl();
		result.readContentXml(in);
		return result;
	}

	@Override
	protected void readFieldXmlAttribute(String name, String value) {
		switch (name) {
			case GOOD__XML_ATTR: {
				setGood(Boolean.parseBoolean(value));
				break;
			}
			default: {
				super.readFieldXmlAttribute(name, value);
			}
		}
	}

	@Override
	protected void readFieldXmlElement(javax.xml.stream.XMLStreamReader in, String localName) throws javax.xml.stream.XMLStreamException {
		switch (localName) {
			case GOOD__XML_ATTR: {
				setGood(Boolean.parseBoolean(in.getElementText()));
				break;
			}
			default: {
				super.readFieldXmlElement(in, localName);
			}
		}
	}

	@Override
	public <R,A,E extends Throwable> R visit(test.openworld.deep.base.Animal.Visitor<R,A,E> v, A arg) throws E {
		return v.visit(this, arg);
	}

}
