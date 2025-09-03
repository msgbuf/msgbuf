package test.container.model.impl;

/**
 * Implementation of {@link test.container.model.MyContent}.
 */
public class MyContent_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.container.model.MyContent {

	private test.container.model.MyContainer _container = null;

	private String _name = "";

	/**
	 * Creates a {@link MyContent_Impl} instance.
	 *
	 * @see test.container.model.MyContent#create()
	 */
	public MyContent_Impl() {
		super();
	}

	@Override
	public final test.container.model.MyContainer getContainer() {
		return _container;
	}

	/**
	 * Internal setter for updating derived field.
	 */
	test.container.model.MyContent setContainer(test.container.model.MyContainer value) {
		internalSetContainer(value);
		return this;
	}

	/** Internal setter for {@link #getContainer()} without chain call utility. */
	protected final void internalSetContainer(test.container.model.MyContainer value) {
		_listener.beforeSet(this, CONTAINER__PROP, value);
		if (value != null && _container != null) {
			throw new IllegalStateException("Object may not be part of two different containers.");
		}
		_container = value;
		_listener.afterChanged(this, CONTAINER__PROP);
	}

	@Override
	public final boolean hasContainer() {
		return _container != null;
	}

	@Override
	public final String getName() {
		return _name;
	}

	@Override
	public test.container.model.MyContent setName(String value) {
		internalSetName(value);
		return this;
	}

	/** Internal setter for {@link #getName()} without chain call utility. */
	protected final void internalSetName(String value) {
		_listener.beforeSet(this, NAME__PROP, value);
		_name = value;
		_listener.afterChanged(this, NAME__PROP);
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.container.model.MyContent registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.container.model.MyContent unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		internalUnregisterListener(l);
		return this;
	}

	protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
	}

	@Override
	public String jsonType() {
		return MY_CONTENT__TYPE;
	}

	static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			CONTAINER__PROP, 
			NAME__PROP);
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
			case CONTAINER__PROP: return getContainer();
			case NAME__PROP: return getName();
			default: return test.container.model.MyContent.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case NAME__PROP: internalSetName((String) value); break;
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
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case NAME__PROP: setName(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
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
	}

	/** Helper for creating an object of type {@link test.container.model.MyContent} from a polymorphic composition. */
	public static test.container.model.MyContent readMyContent_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.container.model.impl.MyContent_Impl result = new MyContent_Impl();
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
			default: in.skipValue(); 
		}
	}

	/** XML element name representing a {@link test.container.model.MyContent} type. */
	public static final String MY_CONTENT__XML_ELEMENT = "my-content";

	/** XML attribute or element name of a {@link #getContainer} property. */
	private static final String CONTAINER__XML_ATTR = "container";

	/** XML attribute or element name of a {@link #getName} property. */
	private static final String NAME__XML_ATTR = "name";

	@Override
	public String getXmlTagName() {
		return MY_CONTENT__XML_ELEMENT;
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
		if (hasContainer()) {
			out.writeStartElement(CONTAINER__XML_ATTR);
			getContainer().writeContent(out);
			out.writeEndElement();
		}
	}

	/** Creates a new {@link test.container.model.MyContent} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static MyContent_Impl readMyContent_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		MyContent_Impl result = new MyContent_Impl();
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
			case CONTAINER__XML_ATTR: {
				setContainer(test.container.model.impl.MyContainer_Impl.readMyContainer_XmlContent(in));
				break;
			}
			case NAME__XML_ATTR: {
				setName(in.getElementText());
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
