package test.enumoptions.nojson.impl;

/**
 * Implementation of {@link test.enumoptions.nojson.M}.
 */
public class M_Impl implements test.enumoptions.nojson.M {

	private test.enumoptions.nojson.M.Nested _nested = test.enumoptions.nojson.M.Nested.A;

	private test.enumoptions.nojson.TopLevel _top = test.enumoptions.nojson.TopLevel.X;

	/**
	 * Creates a {@link M_Impl} instance.
	 *
	 * @see test.enumoptions.nojson.M#create()
	 */
	public M_Impl() {
		super();
	}

	@Override
	public final test.enumoptions.nojson.M.Nested getNested() {
		return _nested;
	}

	@Override
	public test.enumoptions.nojson.M setNested(test.enumoptions.nojson.M.Nested value) {
		internalSetNested(value);
		return this;
	}

	/** Internal setter for {@link #getNested()} without chain call utility. */
	protected final void internalSetNested(test.enumoptions.nojson.M.Nested value) {
		if (value == null) throw new IllegalArgumentException("Property 'nested' cannot be null.");
		_listener.beforeSet(this, NESTED__PROP, value);
		_nested = value;
		_listener.afterChanged(this, NESTED__PROP);
	}

	@Override
	public final test.enumoptions.nojson.TopLevel getTop() {
		return _top;
	}

	@Override
	public test.enumoptions.nojson.M setTop(test.enumoptions.nojson.TopLevel value) {
		internalSetTop(value);
		return this;
	}

	/** Internal setter for {@link #getTop()} without chain call utility. */
	protected final void internalSetTop(test.enumoptions.nojson.TopLevel value) {
		if (value == null) throw new IllegalArgumentException("Property 'top' cannot be null.");
		_listener.beforeSet(this, TOP__PROP, value);
		_top = value;
		_listener.afterChanged(this, TOP__PROP);
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.enumoptions.nojson.M registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.enumoptions.nojson.M unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
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
			default: return test.enumoptions.nojson.M.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case NESTED__PROP: internalSetNested((test.enumoptions.nojson.M.Nested) value); break;
			case TOP__PROP: internalSetTop((test.enumoptions.nojson.TopLevel) value); break;
		}
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		out.beginObject();
		writeFields(out);
		out.endObject();
	}

	/**
	 * Serializes all fields of this instance to the given binary output.
	 *
	 * @param out
	 *        The binary output to write to.
	 * @throws java.io.IOException If writing fails.
	 */
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		out.name(NESTED__ID);
		getNested().writeTo(out);
		out.name(TOP__ID);
		getTop().writeTo(out);
	}

	/** Helper for creating an object of type {@link test.enumoptions.nojson.M} from a polymorphic composition. */
	public static test.enumoptions.nojson.M readM_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.enumoptions.nojson.impl.M_Impl result = new M_Impl();
		result.readContent(in);
		return result;
	}

	/** Helper for reading all fields of this instance. */
	protected final void readContent(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		while (in.hasNext()) {
			int field = in.nextName();
			readField(in, field);
		}
	}

	/** Consumes the value for the field with the given ID and assigns its value. */
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case NESTED__ID: setNested(test.enumoptions.nojson.M.Nested.readNested(in)); break;
			case TOP__ID: setTop(test.enumoptions.nojson.TopLevel.readTopLevel(in)); break;
			default: in.skipValue(); 
		}
	}

	/** XML element name representing a {@link test.enumoptions.nojson.M} type. */
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

	/** Creates a new {@link test.enumoptions.nojson.M} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
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
				setNested(test.enumoptions.nojson.M.Nested.valueOfProtocol(value));
				break;
			}
			case TOP__XML_ATTR: {
				setTop(test.enumoptions.nojson.TopLevel.valueOfProtocol(value));
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
				setNested(test.enumoptions.nojson.M.Nested.valueOfProtocol(in.getElementText()));
				break;
			}
			case TOP__XML_ATTR: {
				setTop(test.enumoptions.nojson.TopLevel.valueOfProtocol(in.getElementText()));
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
