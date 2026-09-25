package test.openworld.deep.base.impl;

/**
 * Implementation of {@link test.openworld.deep.base.Bird}.
 */
public abstract class Bird_Impl extends test.openworld.deep.base.impl.Animal_Impl implements test.openworld.deep.base.Bird {

	private double _wingspan = 0.0d;

	/**
	 * Creates a {@link Bird_Impl} instance.
	 */
	public Bird_Impl() {
		super();
	}

	@Override
	public final double getWingspan() {
		return _wingspan;
	}

	@Override
	public test.openworld.deep.base.Bird setWingspan(double value) {
		internalSetWingspan(value);
		return this;
	}

	/** Internal setter for {@link #getWingspan()} without chain call utility. */
	protected final void internalSetWingspan(double value) {
		_listener.beforeSet(this, WINGSPAN__PROP, value);
		_wingspan = value;
		_listener.afterChanged(this, WINGSPAN__PROP);
	}

	@Override
	public test.openworld.deep.base.Bird setName(String value) {
		internalSetName(value);
		return this;
	}

	@SuppressWarnings("hiding")
	protected static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			WINGSPAN__PROP);
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
			case WINGSPAN__PROP: return getWingspan();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case WINGSPAN__PROP: internalSetWingspan((double) value); break;
			default: super.set(field, value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(WINGSPAN__PROP);
		out.value(getWingspan());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case WINGSPAN__PROP: setWingspan(in.nextDouble()); break;
			default: super.readField(in, field);
		}
	}

	/** XML element name representing a {@link test.openworld.deep.base.Bird} type. */
	public static final String BIRD__XML_ELEMENT = "bird";

	/** XML attribute or element name of a {@link #getWingspan} property. */
	private static final String WINGSPAN__XML_ATTR = "wingspan";

	/** Serializes all fields that are written as XML attributes. */
	@Override
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeAttributes(out);
		out.writeAttribute(WINGSPAN__XML_ATTR, Double.toString(getWingspan()));
	}

	/** Serializes all fields that are written as XML elements. */
	@Override
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeElements(out);
		// No element fields.
	}

	/** Creates a new {@link test.openworld.deep.base.Bird} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Bird_Impl readBird_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		switch (in.getLocalName()) {
			case Sparrow_Impl.SPARROW__XML_ELEMENT: {
				return test.openworld.deep.base.impl.Sparrow_Impl.readSparrow_XmlContent(in);
			}

			default: {
				de.haumacher.msgbuf.data.Factory<? extends test.openworld.deep.base.Animal> factory = test.openworld.deep.base.Animal.XML_REGISTRY.get(in.getLocalName());
				test.openworld.deep.base.Animal instance = factory == null ? null : factory.create();
				if (instance instanceof Bird_Impl) {
					Bird_Impl result = (Bird_Impl) instance;
					result.readContentXml(in);
					return result;
				}
				internalSkipUntilMatchingEndElement(in);
				return null;
			}
		}
	}

	@Override
	protected void readFieldXmlAttribute(String name, String value) {
		switch (name) {
			case WINGSPAN__XML_ATTR: {
				setWingspan(Double.parseDouble(value));
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
			case WINGSPAN__XML_ATTR: {
				setWingspan(Double.parseDouble(in.getElementText()));
				break;
			}
			default: {
				super.readFieldXmlElement(in, localName);
			}
		}
	}

	@Override
	public final <R,A,E extends Throwable> R visit(test.openworld.deep.base.Animal.Visitor<R,A,E> v, A arg) throws E {
		return visit((test.openworld.deep.base.Bird.Visitor<R,A,E>) v, arg);
	}

}
