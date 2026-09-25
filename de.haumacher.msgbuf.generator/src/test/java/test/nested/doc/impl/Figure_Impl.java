package test.nested.doc.impl;

/**
 * Implementation of {@link test.nested.doc.Figure}.
 */
public class Figure_Impl extends test.nested.doc.impl.Doc_Impl.Sec_Impl.Block_Impl implements test.nested.doc.Figure {

	private String _src = "";

	/**
	 * Creates a {@link Figure_Impl} instance.
	 *
	 * @see test.nested.doc.Figure#create()
	 */
	public Figure_Impl() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.FIGURE;
	}

	@Override
	public final String getSrc() {
		return _src;
	}

	@Override
	public test.nested.doc.Figure setSrc(String value) {
		internalSetSrc(value);
		return this;
	}

	/** Internal setter for {@link #getSrc()} without chain call utility. */
	protected final void internalSetSrc(String value) {
		_listener.beforeSet(this, SRC__PROP, value);
		_src = value;
		_listener.afterChanged(this, SRC__PROP);
	}

	@Override
	public test.nested.doc.Figure setWeight(int value) {
		internalSetWeight(value);
		return this;
	}

	@Override
	public test.nested.doc.Figure setKind(test.nested.doc.Doc.Sec.Item.Kind value) {
		internalSetKind(value);
		return this;
	}

	@Override
	public test.nested.doc.Figure setPackage(String value) {
		internalSetPackage(value);
		return this;
	}

	@Override
	public String jsonType() {
		return FIGURE__TYPE;
	}

	@SuppressWarnings("hiding")
	static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			SRC__PROP);
		java.util.List<String> tmp = new java.util.ArrayList<>();
		tmp.addAll(test.nested.doc.impl.Doc_Impl.Sec_Impl.Block_Impl.PROPERTIES);
		tmp.addAll(local);
		PROPERTIES = java.util.Collections.unmodifiableList(tmp);
	}

	@SuppressWarnings("hiding")
	static final java.util.Set<String> TRANSIENT_PROPERTIES;
	static {
		java.util.HashSet<String> tmp = new java.util.HashSet<>();
		tmp.addAll(test.nested.doc.impl.Doc_Impl.Sec_Impl.Block_Impl.TRANSIENT_PROPERTIES);
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
			case SRC__PROP: return getSrc();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case SRC__PROP: internalSetSrc((String) value); break;
			default: super.set(field, value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(SRC__PROP);
		out.value(getSrc());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case SRC__PROP: setSrc(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public int typeId() {
		return FIGURE__TYPE_ID;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(SRC__ID);
		out.value(getSrc());
	}

	/** Helper for creating an object of type {@link test.nested.doc.Figure} from a polymorphic composition. */
	public static test.nested.doc.Figure readFigure_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.nested.doc.impl.Figure_Impl result = new Figure_Impl();
		result.readContent(in);
		return result;
	}

	@Override
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case SRC__ID: setSrc(in.nextString()); break;
			default: super.readField(in, field);
		}
	}

	/** XML element name representing a {@link test.nested.doc.Figure} type. */
	public static final String FIGURE__XML_ELEMENT = "figure";

	/** XML attribute or element name of a {@link #getSrc} property. */
	private static final String SRC__XML_ATTR = "src";

	@Override
	public String getXmlTagName() {
		return FIGURE__XML_ELEMENT;
	}

	/** Serializes all fields that are written as XML attributes. */
	@Override
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeAttributes(out);
		out.writeAttribute(SRC__XML_ATTR, getSrc());
	}

	/** Serializes all fields that are written as XML elements. */
	@Override
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeElements(out);
		// No element fields.
	}

	/** Creates a new {@link test.nested.doc.Figure} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Figure_Impl readFigure_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		Figure_Impl result = new Figure_Impl();
		result.readContentXml(in);
		return result;
	}

	@Override
	protected void readFieldXmlAttribute(String name, String value) {
		switch (name) {
			case SRC__XML_ATTR: {
				setSrc(value);
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
			case SRC__XML_ATTR: {
				setSrc(in.getElementText());
				break;
			}
			default: {
				super.readFieldXmlElement(in, localName);
			}
		}
	}

	@Override
	public <R,A,E extends Throwable> R visit(test.nested.doc.Doc.Sec.Block.Visitor<R,A,E> v, A arg) throws E {
		return v.visit(this, arg);
	}

}
