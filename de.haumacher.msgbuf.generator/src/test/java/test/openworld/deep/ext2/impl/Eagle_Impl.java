package test.openworld.deep.ext2.impl;

/**
 * Implementation of {@link test.openworld.deep.ext2.Eagle}.
 */
public class Eagle_Impl extends test.openworld.deep.ext2.impl.Raptor_Impl implements test.openworld.deep.ext2.Eagle {

	private boolean _bald = false;

	/**
	 * Creates a {@link Eagle_Impl} instance.
	 *
	 * @see test.openworld.deep.ext2.Eagle#create()
	 */
	public Eagle_Impl() {
		super();
	}

	@Override
	public TypeKind kind() {
		return null;
	}

	@Override
	public final boolean isBald() {
		return _bald;
	}

	@Override
	public test.openworld.deep.ext2.Eagle setBald(boolean value) {
		internalSetBald(value);
		return this;
	}

	/** Internal setter for {@link #isBald()} without chain call utility. */
	protected final void internalSetBald(boolean value) {
		_listener.beforeSet(this, BALD__PROP, value);
		_bald = value;
		_listener.afterChanged(this, BALD__PROP);
	}

	@Override
	public test.openworld.deep.ext2.Eagle setSpeed(double value) {
		internalSetSpeed(value);
		return this;
	}

	@Override
	public test.openworld.deep.ext2.Eagle setWingspan(double value) {
		internalSetWingspan(value);
		return this;
	}

	@Override
	public test.openworld.deep.ext2.Eagle setName(String value) {
		internalSetName(value);
		return this;
	}

	@Override
	public String jsonType() {
		return EAGLE__TYPE;
	}

	@SuppressWarnings("hiding")
	static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			BALD__PROP);
		java.util.List<String> tmp = new java.util.ArrayList<>();
		tmp.addAll(test.openworld.deep.ext2.impl.Raptor_Impl.PROPERTIES);
		tmp.addAll(local);
		PROPERTIES = java.util.Collections.unmodifiableList(tmp);
	}

	@SuppressWarnings("hiding")
	static final java.util.Set<String> TRANSIENT_PROPERTIES;
	static {
		java.util.HashSet<String> tmp = new java.util.HashSet<>();
		tmp.addAll(test.openworld.deep.ext2.impl.Raptor_Impl.TRANSIENT_PROPERTIES);
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
			case BALD__PROP: return isBald();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case BALD__PROP: internalSetBald((boolean) value); break;
			default: super.set(field, value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(BALD__PROP);
		out.value(isBald());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case BALD__PROP: setBald(in.nextBoolean()); break;
			default: super.readField(in, field);
		}
	}

	/** XML element name representing a {@link test.openworld.deep.ext2.Eagle} type. */
	public static final String EAGLE__XML_ELEMENT = "eagle";

	/** XML attribute or element name of a {@link #isBald} property. */
	private static final String BALD__XML_ATTR = "bald";

	@Override
	public String getXmlTagName() {
		return EAGLE__XML_ELEMENT;
	}

	/** Serializes all fields that are written as XML attributes. */
	@Override
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeAttributes(out);
		out.writeAttribute(BALD__XML_ATTR, Boolean.toString(isBald()));
	}

	/** Serializes all fields that are written as XML elements. */
	@Override
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeElements(out);
		// No element fields.
	}

	/** Creates a new {@link test.openworld.deep.ext2.Eagle} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Eagle_Impl readEagle_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		Eagle_Impl result = new Eagle_Impl();
		result.readContentXml(in);
		return result;
	}

	@Override
	protected void readFieldXmlAttribute(String name, String value) {
		switch (name) {
			case BALD__XML_ATTR: {
				setBald(Boolean.parseBoolean(value));
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
			case BALD__XML_ATTR: {
				setBald(Boolean.parseBoolean(in.getElementText()));
				break;
			}
			default: {
				super.readFieldXmlElement(in, localName);
			}
		}
	}

	@Override
	public <R,A,E extends Throwable> R visit(test.openworld.deep.ext2.Raptor.Visitor<R,A,E> v, A arg) throws E {
		return v.visit(this, arg);
	}

}
