package test.openworld.deep.ext2.impl;

/**
 * Implementation of {@link test.openworld.deep.ext2.Raptor}.
 */
public abstract class Raptor_Impl extends test.openworld.deep.base.impl.Bird_Impl implements test.openworld.deep.ext2.Raptor {

	private double _speed = 0.0d;

	/**
	 * Creates a {@link Raptor_Impl} instance.
	 */
	public Raptor_Impl() {
		super();
	}

	@Override
	public final double getSpeed() {
		return _speed;
	}

	@Override
	public test.openworld.deep.ext2.Raptor setSpeed(double value) {
		internalSetSpeed(value);
		return this;
	}

	/** Internal setter for {@link #getSpeed()} without chain call utility. */
	protected final void internalSetSpeed(double value) {
		_listener.beforeSet(this, SPEED__PROP, value);
		_speed = value;
		_listener.afterChanged(this, SPEED__PROP);
	}

	@Override
	public test.openworld.deep.ext2.Raptor setWingspan(double value) {
		internalSetWingspan(value);
		return this;
	}

	@Override
	public test.openworld.deep.ext2.Raptor setName(String value) {
		internalSetName(value);
		return this;
	}

	@SuppressWarnings("hiding")
	protected static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			SPEED__PROP);
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
			case SPEED__PROP: return getSpeed();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case SPEED__PROP: internalSetSpeed((double) value); break;
			default: super.set(field, value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(SPEED__PROP);
		out.value(getSpeed());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case SPEED__PROP: setSpeed(in.nextDouble()); break;
			default: super.readField(in, field);
		}
	}

	/** XML element name representing a {@link test.openworld.deep.ext2.Raptor} type. */
	public static final String RAPTOR__XML_ELEMENT = "raptor";

	/** XML attribute or element name of a {@link #getSpeed} property. */
	private static final String SPEED__XML_ATTR = "speed";

	/** Serializes all fields that are written as XML attributes. */
	@Override
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeAttributes(out);
		out.writeAttribute(SPEED__XML_ATTR, Double.toString(getSpeed()));
	}

	/** Serializes all fields that are written as XML elements. */
	@Override
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeElements(out);
		// No element fields.
	}

	/** Creates a new {@link test.openworld.deep.ext2.Raptor} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Raptor_Impl readRaptor_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		switch (in.getLocalName()) {
			case Eagle_Impl.EAGLE__XML_ELEMENT: {
				return test.openworld.deep.ext2.impl.Eagle_Impl.readEagle_XmlContent(in);
			}

			default: {
				internalSkipUntilMatchingEndElement(in);
				return null;
			}
		}
	}

	@Override
	protected void readFieldXmlAttribute(String name, String value) {
		switch (name) {
			case SPEED__XML_ATTR: {
				setSpeed(Double.parseDouble(value));
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
			case SPEED__XML_ATTR: {
				setSpeed(Double.parseDouble(in.getElementText()));
				break;
			}
			default: {
				super.readFieldXmlElement(in, localName);
			}
		}
	}

	@Override
	public final <R,A,E extends Throwable> R visit(test.openworld.deep.base.Bird.Visitor<R,A,E> v, A arg) throws E {
		if (v instanceof test.openworld.deep.ext2.Raptor.Visitor) {
			return visit((test.openworld.deep.ext2.Raptor.Visitor<R,A,E>) v, arg);
		}
		return v.visitDefault(this, arg);
	}

}
