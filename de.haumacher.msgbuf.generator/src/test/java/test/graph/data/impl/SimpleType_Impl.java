package test.graph.data.impl;

/**
 * Implementation of {@link test.graph.data.SimpleType}.
 */
public class SimpleType_Impl extends de.haumacher.msgbuf.graph.AbstractSharedGraphNode implements test.graph.data.SimpleType {

	private String _str = "";

	private int _x = 0;

	/**
	 * Creates a {@link SimpleType_Impl} instance.
	 *
	 * @see test.graph.data.SimpleType#create()
	 */
	public SimpleType_Impl() {
		super();
	}

	@Override
	public final String getStr() {
		return _str;
	}

	@Override
	public test.graph.data.SimpleType setStr(String value) {
		internalSetStr(value);
		return this;
	}

	/** Internal setter for {@link #getStr()} without chain call utility. */
	protected final void internalSetStr(String value) {
		_listener.beforeSet(this, STR__PROP, value);
		_str = value;
	}

	@Override
	public final int getX() {
		return _x;
	}

	@Override
	public test.graph.data.SimpleType setX(int value) {
		internalSetX(value);
		return this;
	}

	/** Internal setter for {@link #getX()} without chain call utility. */
	protected final void internalSetX(int value) {
		_listener.beforeSet(this, X__PROP, value);
		_x = value;
	}

	@Override
	public String jsonType() {
		return SIMPLE_TYPE__TYPE;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			STR__PROP, 
			X__PROP));

	private static java.util.Set<String> TRANSIENT_PROPERTIES = java.util.Collections.unmodifiableSet(new java.util.HashSet<>(
			java.util.Arrays.asList(
				)));

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
			case STR__PROP: return getStr();
			case X__PROP: return getX();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case STR__PROP: internalSetStr((String) value); break;
			case X__PROP: internalSetX((int) value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.graph.Scope scope, de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(scope, out);
		out.name(STR__PROP);
		out.value(getStr());
		out.name(X__PROP);
		out.value(getX());
	}

	@Override
	public void writeFieldValue(de.haumacher.msgbuf.graph.Scope scope, de.haumacher.msgbuf.json.JsonWriter out, String field) throws java.io.IOException {
		switch (field) {
			case STR__PROP: {
				out.value(getStr());
				break;
			}
			case X__PROP: {
				out.value(getX());
				break;
			}
			default: super.writeFieldValue(scope, out, field);
		}
	}

	@Override
	public void readField(de.haumacher.msgbuf.graph.Scope scope, de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case STR__PROP: setStr(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			case X__PROP: setX(in.nextInt()); break;
			default: super.readField(scope, in, field);
		}
	}

	/** XML element name representing a {@link test.graph.data.SimpleType} type. */
	public static final String SIMPLE_TYPE__XML_ELEMENT = "simple-type";

	/** XML attribute or element name of a {@link #getStr} property. */
	private static final String STR__XML_ATTR = "str";

	/** XML attribute or element name of a {@link #getX} property. */
	private static final String X__XML_ATTR = "x";

	@Override
	public String getXmlTagName() {
		return SIMPLE_TYPE__XML_ELEMENT;
	}

	@Override
	public final void writeContent(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		writeAttributes(out);
		writeElements(out);
	}

	/** Serializes all fields that are written as XML attributes. */
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		out.writeAttribute(STR__XML_ATTR, getStr());
		out.writeAttribute(X__XML_ATTR, Integer.toString(getX()));
	}

	/** Serializes all fields that are written as XML elements. */
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		// No element fields.
	}

	/** Creates a new {@link test.graph.data.SimpleType} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static SimpleType_Impl readSimpleType_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		SimpleType_Impl result = new SimpleType_Impl();
		result.readContentXml(in);
		return result;
	}

	/** Reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	protected final void readContentXml(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		for (int n = 0, cnt = in.getAttributeCount(); n < cnt; n++) {
			String name = in.getAttributeLocalName(n);
			String value = in.getAttributeValue(n);

			readFieldXmlAttribute(name, value);
		}
		while (true) {
			int event = in.nextTag();
			if (event == javax.xml.stream.XMLStreamConstants.END_ELEMENT) {
				break;
			}
			assert event == javax.xml.stream.XMLStreamConstants.START_ELEMENT;

			String localName = in.getLocalName();
			readFieldXmlElement(in, localName);
		}
	}

	/** Parses the given attribute value and assigns it to the field with the given name. */
	protected void readFieldXmlAttribute(String name, String value) {
		switch (name) {
			case STR__XML_ATTR: {
				setStr(value);
				break;
			}
			case X__XML_ATTR: {
				setX(Integer.parseInt(value));
				break;
			}
			default: {
				// Skip unknown attribute.
			}
		}
	}

	/** Reads the element under the cursor and assigns its contents to the field with the given name. */
	protected void readFieldXmlElement(javax.xml.stream.XMLStreamReader in, String localName) throws javax.xml.stream.XMLStreamException {
		switch (localName) {
			case STR__XML_ATTR: {
				setStr(in.getElementText());
				break;
			}
			case X__XML_ATTR: {
				setX(Integer.parseInt(in.getElementText()));
				break;
			}
			default: {
				internalSkipUntilMatchingEndElement(in);
			}
		}
	}

	protected static final void internalSkipUntilMatchingEndElement(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		int level = 0;
		while (true) {
			switch (in.next()) {
				case javax.xml.stream.XMLStreamConstants.START_ELEMENT: level++; break;
				case javax.xml.stream.XMLStreamConstants.END_ELEMENT: if (level == 0) { return; } else { level--; break; }
			}
		}
	}

}
