package test.openworld.deep.base.impl;

/**
 * Implementation of {@link test.openworld.deep.base.Sparrow}.
 */
public class Sparrow_Impl extends test.openworld.deep.base.impl.Bird_Impl implements test.openworld.deep.base.Sparrow {

	private int _flock = 0;

	/**
	 * Creates a {@link Sparrow_Impl} instance.
	 *
	 * @see test.openworld.deep.base.Sparrow#create()
	 */
	public Sparrow_Impl() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.SPARROW;
	}

	@Override
	public final int getFlock() {
		return _flock;
	}

	@Override
	public test.openworld.deep.base.Sparrow setFlock(int value) {
		internalSetFlock(value);
		return this;
	}

	/** Internal setter for {@link #getFlock()} without chain call utility. */
	protected final void internalSetFlock(int value) {
		_listener.beforeSet(this, FLOCK__PROP, value);
		_flock = value;
		_listener.afterChanged(this, FLOCK__PROP);
	}

	@Override
	public test.openworld.deep.base.Sparrow setWingspan(double value) {
		internalSetWingspan(value);
		return this;
	}

	@Override
	public test.openworld.deep.base.Sparrow setName(String value) {
		internalSetName(value);
		return this;
	}

	@Override
	public String jsonType() {
		return SPARROW__TYPE;
	}

	@SuppressWarnings("hiding")
	protected static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			FLOCK__PROP);
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
			case FLOCK__PROP: return getFlock();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case FLOCK__PROP: internalSetFlock((int) value); break;
			default: super.set(field, value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(FLOCK__PROP);
		out.value(getFlock());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case FLOCK__PROP: setFlock(in.nextInt()); break;
			default: super.readField(in, field);
		}
	}

	/** XML element name representing a {@link test.openworld.deep.base.Sparrow} type. */
	public static final String SPARROW__XML_ELEMENT = "sparrow";

	/** XML attribute or element name of a {@link #getFlock} property. */
	private static final String FLOCK__XML_ATTR = "flock";

	@Override
	public String getXmlTagName() {
		return SPARROW__XML_ELEMENT;
	}

	/** Serializes all fields that are written as XML attributes. */
	@Override
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeAttributes(out);
		out.writeAttribute(FLOCK__XML_ATTR, Integer.toString(getFlock()));
	}

	/** Serializes all fields that are written as XML elements. */
	@Override
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeElements(out);
		// No element fields.
	}

	/** Creates a new {@link test.openworld.deep.base.Sparrow} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Sparrow_Impl readSparrow_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		Sparrow_Impl result = new Sparrow_Impl();
		result.readContentXml(in);
		return result;
	}

	@Override
	protected void readFieldXmlAttribute(String name, String value) {
		switch (name) {
			case FLOCK__XML_ATTR: {
				setFlock(Integer.parseInt(value));
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
			case FLOCK__XML_ATTR: {
				setFlock(Integer.parseInt(in.getElementText()));
				break;
			}
			default: {
				super.readFieldXmlElement(in, localName);
			}
		}
	}

	@Override
	public <R,A,E extends Throwable> R visit(test.openworld.deep.base.Bird.Visitor<R,A,E> v, A arg) throws E {
		return v.visit(this, arg);
	}

}
