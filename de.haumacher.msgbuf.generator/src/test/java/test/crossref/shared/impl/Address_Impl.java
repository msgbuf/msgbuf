package test.crossref.shared.impl;

/**
 * Implementation of {@link test.crossref.shared.Address}.
 */
public class Address_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.crossref.shared.Address {

	private String _street = "";

	private String _city = "";

	private String _zip = "";

	/**
	 * Creates a {@link Address_Impl} instance.
	 *
	 * @see test.crossref.shared.Address#create()
	 */
	public Address_Impl() {
		super();
	}

	@Override
	public final String getStreet() {
		return _street;
	}

	@Override
	public test.crossref.shared.Address setStreet(String value) {
		internalSetStreet(value);
		return this;
	}

	/** Internal setter for {@link #getStreet()} without chain call utility. */
	protected final void internalSetStreet(String value) {
		_listener.beforeSet(this, STREET__PROP, value);
		_street = value;
		_listener.afterChanged(this, STREET__PROP);
	}

	@Override
	public final String getCity() {
		return _city;
	}

	@Override
	public test.crossref.shared.Address setCity(String value) {
		internalSetCity(value);
		return this;
	}

	/** Internal setter for {@link #getCity()} without chain call utility. */
	protected final void internalSetCity(String value) {
		_listener.beforeSet(this, CITY__PROP, value);
		_city = value;
		_listener.afterChanged(this, CITY__PROP);
	}

	@Override
	public final String getZip() {
		return _zip;
	}

	@Override
	public test.crossref.shared.Address setZip(String value) {
		internalSetZip(value);
		return this;
	}

	/** Internal setter for {@link #getZip()} without chain call utility. */
	protected final void internalSetZip(String value) {
		_listener.beforeSet(this, ZIP__PROP, value);
		_zip = value;
		_listener.afterChanged(this, ZIP__PROP);
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.crossref.shared.Address registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.crossref.shared.Address unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		internalUnregisterListener(l);
		return this;
	}

	protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
	}

	@Override
	public String jsonType() {
		return ADDRESS__TYPE;
	}

	static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			STREET__PROP, 
			CITY__PROP, 
			ZIP__PROP);
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
			case STREET__PROP: return getStreet();
			case CITY__PROP: return getCity();
			case ZIP__PROP: return getZip();
			default: return test.crossref.shared.Address.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case STREET__PROP: internalSetStreet((String) value); break;
			case CITY__PROP: internalSetCity((String) value); break;
			case ZIP__PROP: internalSetZip((String) value); break;
		}
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(STREET__PROP);
		out.value(getStreet());
		out.name(CITY__PROP);
		out.value(getCity());
		out.name(ZIP__PROP);
		out.value(getZip());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case STREET__PROP: setStreet(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			case CITY__PROP: setCity(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			case ZIP__PROP: setZip(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			default: super.readField(in, field);
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
		out.name(STREET__ID);
		out.value(getStreet());
		out.name(CITY__ID);
		out.value(getCity());
		out.name(ZIP__ID);
		out.value(getZip());
	}

	/** Helper for creating an object of type {@link test.crossref.shared.Address} from a polymorphic composition. */
	public static test.crossref.shared.Address readAddress_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.crossref.shared.impl.Address_Impl result = new Address_Impl();
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
			case STREET__ID: setStreet(in.nextString()); break;
			case CITY__ID: setCity(in.nextString()); break;
			case ZIP__ID: setZip(in.nextString()); break;
			default: in.skipValue(); 
		}
	}

	/** XML element name representing a {@link test.crossref.shared.Address} type. */
	public static final String ADDRESS__XML_ELEMENT = "address";

	/** XML attribute or element name of a {@link #getStreet} property. */
	private static final String STREET__XML_ATTR = "street";

	/** XML attribute or element name of a {@link #getCity} property. */
	private static final String CITY__XML_ATTR = "city";

	/** XML attribute or element name of a {@link #getZip} property. */
	private static final String ZIP__XML_ATTR = "zip";

	@Override
	public String getXmlTagName() {
		return ADDRESS__XML_ELEMENT;
	}

	@Override
	public final void writeContent(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		writeAttributes(out);
		writeElements(out);
	}

	/** Serializes all fields that are written as XML attributes. */
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		out.writeAttribute(STREET__XML_ATTR, getStreet());
		out.writeAttribute(CITY__XML_ATTR, getCity());
		out.writeAttribute(ZIP__XML_ATTR, getZip());
	}

	/** Serializes all fields that are written as XML elements. */
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		// No element fields.
	}

	/** Creates a new {@link test.crossref.shared.Address} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Address_Impl readAddress_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		Address_Impl result = new Address_Impl();
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
			case STREET__XML_ATTR: {
				setStreet(value);
				break;
			}
			case CITY__XML_ATTR: {
				setCity(value);
				break;
			}
			case ZIP__XML_ATTR: {
				setZip(value);
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
			case STREET__XML_ATTR: {
				setStreet(in.getElementText());
				break;
			}
			case CITY__XML_ATTR: {
				setCity(in.getElementText());
				break;
			}
			case ZIP__XML_ATTR: {
				setZip(in.getElementText());
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
