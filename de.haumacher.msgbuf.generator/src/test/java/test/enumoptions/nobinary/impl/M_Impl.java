package test.enumoptions.nobinary.impl;

/**
 * Implementation of {@link test.enumoptions.nobinary.M}.
 */
public class M_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.enumoptions.nobinary.M {

	private test.enumoptions.nobinary.M.Nested _nested = test.enumoptions.nobinary.M.Nested.A;

	private test.enumoptions.nobinary.TopLevel _top = test.enumoptions.nobinary.TopLevel.X;

	/**
	 * Creates a {@link M_Impl} instance.
	 *
	 * @see test.enumoptions.nobinary.M#create()
	 */
	public M_Impl() {
		super();
	}

	@Override
	public final test.enumoptions.nobinary.M.Nested getNested() {
		return _nested;
	}

	@Override
	public test.enumoptions.nobinary.M setNested(test.enumoptions.nobinary.M.Nested value) {
		internalSetNested(value);
		return this;
	}

	/** Internal setter for {@link #getNested()} without chain call utility. */
	protected final void internalSetNested(test.enumoptions.nobinary.M.Nested value) {
		if (value == null) throw new IllegalArgumentException("Property 'nested' cannot be null.");
		_listener.beforeSet(this, NESTED__PROP, value);
		_nested = value;
		_listener.afterChanged(this, NESTED__PROP);
	}

	@Override
	public final test.enumoptions.nobinary.TopLevel getTop() {
		return _top;
	}

	@Override
	public test.enumoptions.nobinary.M setTop(test.enumoptions.nobinary.TopLevel value) {
		internalSetTop(value);
		return this;
	}

	/** Internal setter for {@link #getTop()} without chain call utility. */
	protected final void internalSetTop(test.enumoptions.nobinary.TopLevel value) {
		if (value == null) throw new IllegalArgumentException("Property 'top' cannot be null.");
		_listener.beforeSet(this, TOP__PROP, value);
		_top = value;
		_listener.afterChanged(this, TOP__PROP);
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.enumoptions.nobinary.M registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.enumoptions.nobinary.M unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		internalUnregisterListener(l);
		return this;
	}

	protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
	}

	@Override
	public String jsonType() {
		return M__TYPE;
	}

	static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			NESTED__PROP, 
			TOP__PROP);
		PROPERTIES = java.util.Collections.unmodifiableList(local);
	}

	static final java.util.Set<String> TRANSIENT_PROPERTIES;
	static {
		java.util.HashSet<String> tmp = new java.util.HashSet<>();
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
			case NESTED__PROP: return getNested();
			case TOP__PROP: return getTop();
			default: return test.enumoptions.nobinary.M.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case NESTED__PROP: internalSetNested((test.enumoptions.nobinary.M.Nested) value); break;
			case TOP__PROP: internalSetTop((test.enumoptions.nobinary.TopLevel) value); break;
		}
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(NESTED__PROP);
		getNested().writeTo(out);
		out.name(TOP__PROP);
		getTop().writeTo(out);
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case NESTED__PROP: setNested(test.enumoptions.nobinary.M.Nested.readNested(in)); break;
			case TOP__PROP: setTop(test.enumoptions.nobinary.TopLevel.readTopLevel(in)); break;
			default: super.readField(in, field);
		}
	}

	/** XML element name representing a {@link test.enumoptions.nobinary.M} type. */
	public static final String M__XML_ELEMENT = "m";

	/** XML attribute or element name of a {@link #getNested} property. */
	private static final String NESTED__XML_ATTR = "nested";

	/** XML attribute or element name of a {@link #getTop} property. */
	private static final String TOP__XML_ATTR = "top";

	@Override
	public String getXmlTagName() {
		return M__XML_ELEMENT;
	}

	@Override
	public final void writeContent(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		writeAttributes(out);
		writeElements(out);
	}

	/** Serializes all fields that are written as XML attributes. */
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		out.writeAttribute(NESTED__XML_ATTR, getNested().protocolName());
		out.writeAttribute(TOP__XML_ATTR, getTop().protocolName());
	}

	/** Serializes all fields that are written as XML elements. */
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		// No element fields.
	}

	/** Creates a new {@link test.enumoptions.nobinary.M} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static M_Impl readM_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		M_Impl result = new M_Impl();
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
			case NESTED__XML_ATTR: {
				setNested(test.enumoptions.nobinary.M.Nested.valueOfProtocol(value));
				break;
			}
			case TOP__XML_ATTR: {
				setTop(test.enumoptions.nobinary.TopLevel.valueOfProtocol(value));
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
			case NESTED__XML_ATTR: {
				setNested(test.enumoptions.nobinary.M.Nested.valueOfProtocol(in.getElementText()));
				break;
			}
			case TOP__XML_ATTR: {
				setTop(test.enumoptions.nobinary.TopLevel.valueOfProtocol(in.getElementText()));
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
