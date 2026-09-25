package test.openworld.deep.ext1.impl;

/**
 * Implementation of {@link test.openworld.deep.ext1.Trout}.
 */
public class Trout_Impl extends test.openworld.deep.ext1.impl.Fish_Impl implements test.openworld.deep.ext1.Trout {

	private boolean _rainbow = false;

	/**
	 * Creates a {@link Trout_Impl} instance.
	 *
	 * @see test.openworld.deep.ext1.Trout#create()
	 */
	public Trout_Impl() {
		super();
	}

	@Override
	public TypeKind kind() {
		return null;
	}

	@Override
	public final boolean isRainbow() {
		return _rainbow;
	}

	@Override
	public test.openworld.deep.ext1.Trout setRainbow(boolean value) {
		internalSetRainbow(value);
		return this;
	}

	/** Internal setter for {@link #isRainbow()} without chain call utility. */
	protected final void internalSetRainbow(boolean value) {
		_listener.beforeSet(this, RAINBOW__PROP, value);
		_rainbow = value;
		_listener.afterChanged(this, RAINBOW__PROP);
	}

	@Override
	public test.openworld.deep.ext1.Trout setFins(int value) {
		internalSetFins(value);
		return this;
	}

	@Override
	public test.openworld.deep.ext1.Trout setName(String value) {
		internalSetName(value);
		return this;
	}

	@Override
	public String jsonType() {
		return TROUT__TYPE;
	}

	@SuppressWarnings("hiding")
	protected static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			RAINBOW__PROP);
		java.util.List<String> tmp = new java.util.ArrayList<>();
		tmp.addAll(test.openworld.deep.ext1.impl.Fish_Impl.PROPERTIES);
		tmp.addAll(local);
		PROPERTIES = java.util.Collections.unmodifiableList(tmp);
	}

	@SuppressWarnings("hiding")
	protected static final java.util.Set<String> TRANSIENT_PROPERTIES;
	static {
		java.util.HashSet<String> tmp = new java.util.HashSet<>();
		tmp.addAll(test.openworld.deep.ext1.impl.Fish_Impl.TRANSIENT_PROPERTIES);
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
			case RAINBOW__PROP: return isRainbow();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case RAINBOW__PROP: internalSetRainbow((boolean) value); break;
			default: super.set(field, value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(RAINBOW__PROP);
		out.value(isRainbow());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case RAINBOW__PROP: setRainbow(in.nextBoolean()); break;
			default: super.readField(in, field);
		}
	}

	/** XML element name representing a {@link test.openworld.deep.ext1.Trout} type. */
	public static final String TROUT__XML_ELEMENT = "trout";

	/** XML attribute or element name of a {@link #isRainbow} property. */
	private static final String RAINBOW__XML_ATTR = "rainbow";

	@Override
	public String getXmlTagName() {
		return TROUT__XML_ELEMENT;
	}

	/** Serializes all fields that are written as XML attributes. */
	@Override
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeAttributes(out);
		out.writeAttribute(RAINBOW__XML_ATTR, Boolean.toString(isRainbow()));
	}

	/** Serializes all fields that are written as XML elements. */
	@Override
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeElements(out);
		// No element fields.
	}

	/** Creates a new {@link test.openworld.deep.ext1.Trout} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Trout_Impl readTrout_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		Trout_Impl result = new Trout_Impl();
		result.readContentXml(in);
		return result;
	}

	@Override
	protected void readFieldXmlAttribute(String name, String value) {
		switch (name) {
			case RAINBOW__XML_ATTR: {
				setRainbow(Boolean.parseBoolean(value));
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
			case RAINBOW__XML_ATTR: {
				setRainbow(Boolean.parseBoolean(in.getElementText()));
				break;
			}
			default: {
				super.readFieldXmlElement(in, localName);
			}
		}
	}

	@Override
	public <R,A,E extends Throwable> R visit(test.openworld.deep.ext1.Fish.Visitor<R,A,E> v, A arg) throws E {
		return v.visit(this, arg);
	}

}
