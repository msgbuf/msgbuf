package test.openworld.deep.ext2.impl;

/**
 * Implementation of {@link test.openworld.deep.ext2.Shark}.
 */
public class Shark_Impl extends test.openworld.deep.ext1.impl.Fish_Impl implements test.openworld.deep.ext2.Shark {

	private int _teeth = 0;

	/**
	 * Creates a {@link Shark_Impl} instance.
	 *
	 * @see test.openworld.deep.ext2.Shark#create()
	 */
	public Shark_Impl() {
		super();
	}

	@Override
	public TypeKind kind() {
		return null;
	}

	@Override
	public final int getTeeth() {
		return _teeth;
	}

	@Override
	public test.openworld.deep.ext2.Shark setTeeth(int value) {
		internalSetTeeth(value);
		return this;
	}

	/** Internal setter for {@link #getTeeth()} without chain call utility. */
	protected final void internalSetTeeth(int value) {
		_listener.beforeSet(this, TEETH__PROP, value);
		_teeth = value;
		_listener.afterChanged(this, TEETH__PROP);
	}

	@Override
	public test.openworld.deep.ext2.Shark setFins(int value) {
		internalSetFins(value);
		return this;
	}

	@Override
	public test.openworld.deep.ext2.Shark setName(String value) {
		internalSetName(value);
		return this;
	}

	@Override
	public String jsonType() {
		return SHARK__TYPE;
	}

	@SuppressWarnings("hiding")
	protected static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			TEETH__PROP);
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
			case TEETH__PROP: return getTeeth();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case TEETH__PROP: internalSetTeeth((int) value); break;
			default: super.set(field, value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(TEETH__PROP);
		out.value(getTeeth());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case TEETH__PROP: setTeeth(in.nextInt()); break;
			default: super.readField(in, field);
		}
	}

	/** XML element name representing a {@link test.openworld.deep.ext2.Shark} type. */
	public static final String SHARK__XML_ELEMENT = "shark";

	/** XML attribute or element name of a {@link #getTeeth} property. */
	private static final String TEETH__XML_ATTR = "teeth";

	@Override
	public String getXmlTagName() {
		return SHARK__XML_ELEMENT;
	}

	/** Serializes all fields that are written as XML attributes. */
	@Override
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeAttributes(out);
		out.writeAttribute(TEETH__XML_ATTR, Integer.toString(getTeeth()));
	}

	/** Serializes all fields that are written as XML elements. */
	@Override
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeElements(out);
		// No element fields.
	}

	/** Creates a new {@link test.openworld.deep.ext2.Shark} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Shark_Impl readShark_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		Shark_Impl result = new Shark_Impl();
		result.readContentXml(in);
		return result;
	}

	@Override
	protected void readFieldXmlAttribute(String name, String value) {
		switch (name) {
			case TEETH__XML_ATTR: {
				setTeeth(Integer.parseInt(value));
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
			case TEETH__XML_ATTR: {
				setTeeth(Integer.parseInt(in.getElementText()));
				break;
			}
			default: {
				super.readFieldXmlElement(in, localName);
			}
		}
	}

	@Override
	public <R,A,E extends Throwable> R visit(test.openworld.deep.ext1.Fish.Visitor<R,A,E> v, A arg) throws E {
		if (v instanceof test.openworld.deep.ext2.Shark.Visitor) {
			return ((test.openworld.deep.ext2.Shark.Visitor<R,A,E>) v).visit(this, arg);
		}
		return v.visitDefault(this, arg);
	}

}
