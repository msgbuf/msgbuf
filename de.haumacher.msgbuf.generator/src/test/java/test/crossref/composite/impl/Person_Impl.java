package test.crossref.composite.impl;

/**
 * Implementation of {@link test.crossref.composite.Person}.
 */
public class Person_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.crossref.composite.Person {

	private String _name = "";

	private test.crossref.shared.Address _address = null;

	private test.crossref.shared.Coordinate _location = null;

	/**
	 * Creates a {@link Person_Impl} instance.
	 *
	 * @see test.crossref.composite.Person#create()
	 */
	public Person_Impl() {
		super();
	}

	@Override
	public final String getName() {
		return _name;
	}

	@Override
	public test.crossref.composite.Person setName(String value) {
		internalSetName(value);
		return this;
	}

	/** Internal setter for {@link #getName()} without chain call utility. */
	protected final void internalSetName(String value) {
		_listener.beforeSet(this, NAME__PROP, value);
		_name = value;
		_listener.afterChanged(this, NAME__PROP);
	}

	@Override
	public final test.crossref.shared.Address getAddress() {
		return _address;
	}

	@Override
	public test.crossref.composite.Person setAddress(test.crossref.shared.Address value) {
		internalSetAddress(value);
		return this;
	}

	/** Internal setter for {@link #getAddress()} without chain call utility. */
	protected final void internalSetAddress(test.crossref.shared.Address value) {
		_listener.beforeSet(this, ADDRESS__PROP, value);
		_address = value;
		_listener.afterChanged(this, ADDRESS__PROP);
	}

	@Override
	public final boolean hasAddress() {
		return _address != null;
	}

	@Override
	public final test.crossref.shared.Coordinate getLocation() {
		return _location;
	}

	@Override
	public test.crossref.composite.Person setLocation(test.crossref.shared.Coordinate value) {
		internalSetLocation(value);
		return this;
	}

	/** Internal setter for {@link #getLocation()} without chain call utility. */
	protected final void internalSetLocation(test.crossref.shared.Coordinate value) {
		_listener.beforeSet(this, LOCATION__PROP, value);
		_location = value;
		_listener.afterChanged(this, LOCATION__PROP);
	}

	@Override
	public final boolean hasLocation() {
		return _location != null;
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.crossref.composite.Person registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.crossref.composite.Person unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		internalUnregisterListener(l);
		return this;
	}

	protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
	}

	@Override
	public String jsonType() {
		return PERSON__TYPE;
	}

	static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			NAME__PROP, 
			ADDRESS__PROP, 
			LOCATION__PROP);
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
			case NAME__PROP: return getName();
			case ADDRESS__PROP: return getAddress();
			case LOCATION__PROP: return getLocation();
			default: return test.crossref.composite.Person.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case NAME__PROP: internalSetName((String) value); break;
			case ADDRESS__PROP: internalSetAddress((test.crossref.shared.Address) value); break;
			case LOCATION__PROP: internalSetLocation((test.crossref.shared.Coordinate) value); break;
		}
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(NAME__PROP);
		out.value(getName());
		if (hasAddress()) {
			out.name(ADDRESS__PROP);
			getAddress().writeTo(out);
		}
		if (hasLocation()) {
			out.name(LOCATION__PROP);
			getLocation().writeTo(out);
		}
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case NAME__PROP: setName(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			case ADDRESS__PROP: setAddress(test.crossref.shared.Address.readAddress(in)); break;
			case LOCATION__PROP: setLocation(test.crossref.shared.Coordinate.readCoordinate(in)); break;
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
		out.name(NAME__ID);
		out.value(getName());
		if (hasAddress()) {
			out.name(ADDRESS__ID);
			getAddress().writeTo(out);
		}
		if (hasLocation()) {
			out.name(LOCATION__ID);
			getLocation().writeTo(out);
		}
	}

	/** Helper for creating an object of type {@link test.crossref.composite.Person} from a polymorphic composition. */
	public static test.crossref.composite.Person readPerson_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.crossref.composite.impl.Person_Impl result = new Person_Impl();
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
			case NAME__ID: setName(in.nextString()); break;
			case ADDRESS__ID: setAddress(test.crossref.shared.Address.readAddress(in)); break;
			case LOCATION__ID: setLocation(test.crossref.shared.Coordinate.readCoordinate(in)); break;
			default: in.skipValue(); 
		}
	}

	/** XML element name representing a {@link test.crossref.composite.Person} type. */
	public static final String PERSON__XML_ELEMENT = "person";

	/** XML attribute or element name of a {@link #getName} property. */
	private static final String NAME__XML_ATTR = "name";

	/** XML attribute or element name of a {@link #getAddress} property. */
	private static final String ADDRESS__XML_ATTR = "address";

	/** XML attribute or element name of a {@link #getLocation} property. */
	private static final String LOCATION__XML_ATTR = "location";

	@Override
	public String getXmlTagName() {
		return PERSON__XML_ELEMENT;
	}

	@Override
	public final void writeContent(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		writeAttributes(out);
		writeElements(out);
	}

	/** Serializes all fields that are written as XML attributes. */
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		out.writeAttribute(NAME__XML_ATTR, getName());
	}

	/** Serializes all fields that are written as XML elements. */
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		if (hasAddress()) {
			out.writeStartElement(ADDRESS__XML_ATTR);
			getAddress().writeContent(out);
			out.writeEndElement();
		}
		if (hasLocation()) {
			out.writeStartElement(LOCATION__XML_ATTR);
			getLocation().writeContent(out);
			out.writeEndElement();
		}
	}

	/** Creates a new {@link test.crossref.composite.Person} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Person_Impl readPerson_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		Person_Impl result = new Person_Impl();
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
			case NAME__XML_ATTR: {
				setName(value);
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
			case NAME__XML_ATTR: {
				setName(in.getElementText());
				break;
			}
			case ADDRESS__XML_ATTR: {
				setAddress(test.crossref.shared.impl.Address_Impl.readAddress_XmlContent(in));
				break;
			}
			case LOCATION__XML_ATTR: {
				setLocation(test.crossref.shared.impl.Coordinate_Impl.readCoordinate_XmlContent(in));
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
