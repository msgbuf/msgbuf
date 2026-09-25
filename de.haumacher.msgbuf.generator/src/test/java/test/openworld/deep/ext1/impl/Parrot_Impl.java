package test.openworld.deep.ext1.impl;

/**
 * Implementation of {@link test.openworld.deep.ext1.Parrot}.
 */
public class Parrot_Impl extends test.openworld.deep.base.impl.Bird_Impl implements test.openworld.deep.ext1.Parrot {

	private String _word = "";

	/**
	 * Creates a {@link Parrot_Impl} instance.
	 *
	 * @see test.openworld.deep.ext1.Parrot#create()
	 */
	public Parrot_Impl() {
		super();
	}

	@Override
	public TypeKind kind() {
		return null;
	}

	@Override
	public final String getWord() {
		return _word;
	}

	@Override
	public test.openworld.deep.ext1.Parrot setWord(String value) {
		internalSetWord(value);
		return this;
	}

	/** Internal setter for {@link #getWord()} without chain call utility. */
	protected final void internalSetWord(String value) {
		_listener.beforeSet(this, WORD__PROP, value);
		_word = value;
		_listener.afterChanged(this, WORD__PROP);
	}

	@Override
	public test.openworld.deep.ext1.Parrot setWingspan(double value) {
		internalSetWingspan(value);
		return this;
	}

	@Override
	public test.openworld.deep.ext1.Parrot setName(String value) {
		internalSetName(value);
		return this;
	}

	@Override
	public String jsonType() {
		return PARROT__TYPE;
	}

	@SuppressWarnings("hiding")
	protected static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			WORD__PROP);
		java.util.List<String> tmp = new java.util.ArrayList<>();
		tmp.addAll(test.openworld.deep.base.impl.Bird_Impl.PROPERTIES);
		tmp.addAll(local);
		PROPERTIES = java.util.Collections.unmodifiableList(tmp);
	}

	@SuppressWarnings("hiding")
	protected static final java.util.Set<String> TRANSIENT_PROPERTIES;
	static {
		java.util.HashSet<String> tmp = new java.util.HashSet<>();
		tmp.addAll(test.openworld.deep.base.impl.Bird_Impl.TRANSIENT_PROPERTIES);
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
			case WORD__PROP: return getWord();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case WORD__PROP: internalSetWord((String) value); break;
			default: super.set(field, value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(WORD__PROP);
		out.value(getWord());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case WORD__PROP: setWord(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			default: super.readField(in, field);
		}
	}

	/** XML element name representing a {@link test.openworld.deep.ext1.Parrot} type. */
	public static final String PARROT__XML_ELEMENT = "parrot";

	/** XML attribute or element name of a {@link #getWord} property. */
	private static final String WORD__XML_ATTR = "word";

	@Override
	public String getXmlTagName() {
		return PARROT__XML_ELEMENT;
	}

	/** Serializes all fields that are written as XML attributes. */
	@Override
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeAttributes(out);
		out.writeAttribute(WORD__XML_ATTR, getWord());
	}

	/** Serializes all fields that are written as XML elements. */
	@Override
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeElements(out);
		// No element fields.
	}

	/** Creates a new {@link test.openworld.deep.ext1.Parrot} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Parrot_Impl readParrot_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		Parrot_Impl result = new Parrot_Impl();
		result.readContentXml(in);
		return result;
	}

	@Override
	protected void readFieldXmlAttribute(String name, String value) {
		switch (name) {
			case WORD__XML_ATTR: {
				setWord(value);
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
			case WORD__XML_ATTR: {
				setWord(in.getElementText());
				break;
			}
			default: {
				super.readFieldXmlElement(in, localName);
			}
		}
	}

	@Override
	public <R,A,E extends Throwable> R visit(test.openworld.deep.base.Bird.Visitor<R,A,E> v, A arg) throws E {
		if (v instanceof test.openworld.deep.ext1.Parrot.Visitor) {
			return ((test.openworld.deep.ext1.Parrot.Visitor<R,A,E>) v).visit(this, arg);
		}
		return v.visitDefault(this, arg);
	}

}
