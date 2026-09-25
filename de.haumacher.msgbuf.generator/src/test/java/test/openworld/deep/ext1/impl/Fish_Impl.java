package test.openworld.deep.ext1.impl;

/**
 * Implementation of {@link test.openworld.deep.ext1.Fish}.
 */
public abstract class Fish_Impl extends test.openworld.deep.base.impl.Animal_Impl implements test.openworld.deep.ext1.Fish {

	private int _fins = 0;

	/**
	 * Creates a {@link Fish_Impl} instance.
	 */
	public Fish_Impl() {
		super();
	}

	@Override
	public final int getFins() {
		return _fins;
	}

	@Override
	public test.openworld.deep.ext1.Fish setFins(int value) {
		internalSetFins(value);
		return this;
	}

	/** Internal setter for {@link #getFins()} without chain call utility. */
	protected final void internalSetFins(int value) {
		_listener.beforeSet(this, FINS__PROP, value);
		_fins = value;
		_listener.afterChanged(this, FINS__PROP);
	}

	@Override
	public test.openworld.deep.ext1.Fish setName(String value) {
		internalSetName(value);
		return this;
	}

	@SuppressWarnings("hiding")
	protected static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			FINS__PROP);
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
			case FINS__PROP: return getFins();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case FINS__PROP: internalSetFins((int) value); break;
			default: super.set(field, value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(FINS__PROP);
		out.value(getFins());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case FINS__PROP: setFins(in.nextInt()); break;
			default: super.readField(in, field);
		}
	}

	/** XML element name representing a {@link test.openworld.deep.ext1.Fish} type. */
	public static final String FISH__XML_ELEMENT = "fish";

	/** XML attribute or element name of a {@link #getFins} property. */
	private static final String FINS__XML_ATTR = "fins";

	/** Serializes all fields that are written as XML attributes. */
	@Override
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeAttributes(out);
		out.writeAttribute(FINS__XML_ATTR, Integer.toString(getFins()));
	}

	/** Serializes all fields that are written as XML elements. */
	@Override
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeElements(out);
		// No element fields.
	}

	/** Creates a new {@link test.openworld.deep.ext1.Fish} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Fish_Impl readFish_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		switch (in.getLocalName()) {
			case Trout_Impl.TROUT__XML_ELEMENT: {
				return test.openworld.deep.ext1.impl.Trout_Impl.readTrout_XmlContent(in);
			}

			default: {
				de.haumacher.msgbuf.data.Factory<? extends test.openworld.deep.base.Animal> factory = test.openworld.deep.base.Animal.XML_REGISTRY.get(in.getLocalName());
				test.openworld.deep.base.Animal instance = factory == null ? null : factory.create();
				if (instance instanceof Fish_Impl) {
					Fish_Impl result = (Fish_Impl) instance;
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
			case FINS__XML_ATTR: {
				setFins(Integer.parseInt(value));
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
			case FINS__XML_ATTR: {
				setFins(Integer.parseInt(in.getElementText()));
				break;
			}
			default: {
				super.readFieldXmlElement(in, localName);
			}
		}
	}

	@Override
	public final <R,A,E extends Throwable> R visit(test.openworld.deep.base.Animal.Visitor<R,A,E> v, A arg) throws E {
		if (v instanceof test.openworld.deep.ext1.Fish.Visitor) {
			return visit((test.openworld.deep.ext1.Fish.Visitor<R,A,E>) v, arg);
		}
		return v.visitDefault(this, arg);
	}

}
