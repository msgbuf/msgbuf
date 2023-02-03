package test.container.model.impl;

public class MyContainer_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.container.model.MyContainer {

	private String _name = "";

	private test.container.model.MyContent _content1 = null;

	private test.container.model.MyContent _content2 = null;

	/**
	 * Creates a {@link MyContainer_Impl} instance.
	 *
	 * @see test.container.model.MyContainer#create()
	 */
	public MyContainer_Impl() {
		super();
	}

	@Override
	public final String getName() {
		return _name;
	}

	@Override
	public test.container.model.MyContainer setName(String value) {
		internalSetName(value);
		return this;
	}

	/** Internal setter for {@link #getName()} without chain call utility. */
	protected final void internalSetName(String value) {
		_listener.beforeSet(this, NAME__PROP, value);
		_name = value;
	}

	@Override
	public final test.container.model.MyContent getContent1() {
		return _content1;
	}

	@Override
	public test.container.model.MyContainer setContent1(test.container.model.MyContent value) {
		internalSetContent1(value);
		return this;
	}

	/** Internal setter for {@link #getContent1()} without chain call utility. */
	protected final void internalSetContent1(test.container.model.MyContent value) {
		test.container.model.impl.MyContent_Impl before = (test.container.model.impl.MyContent_Impl) _content1;
		test.container.model.impl.MyContent_Impl after = (test.container.model.impl.MyContent_Impl) value;
		if (after != null) {
			test.container.model.MyContainer oldContainer = after.getContainer();
			if (oldContainer != null && oldContainer != this) {
				throw new IllegalStateException("Object may not be part of two different containers.");
			}
		}
		_listener.beforeSet(this, CONTENT_1__PROP, value);
		if (before != null) {
			before.internalSetContainer(null);
		}
		_content1 = value;
		if (after != null) {
			after.internalSetContainer(this);
		}
	}

	@Override
	public final boolean hasContent1() {
		return _content1 != null;
	}

	@Override
	public final test.container.model.MyContent getContent2() {
		return _content2;
	}

	@Override
	public test.container.model.MyContainer setContent2(test.container.model.MyContent value) {
		internalSetContent2(value);
		return this;
	}

	/** Internal setter for {@link #getContent2()} without chain call utility. */
	protected final void internalSetContent2(test.container.model.MyContent value) {
		test.container.model.impl.MyContent_Impl before = (test.container.model.impl.MyContent_Impl) _content2;
		test.container.model.impl.MyContent_Impl after = (test.container.model.impl.MyContent_Impl) value;
		if (after != null) {
			test.container.model.MyContainer oldContainer = after.getContainer();
			if (oldContainer != null && oldContainer != this) {
				throw new IllegalStateException("Object may not be part of two different containers.");
			}
		}
		_listener.beforeSet(this, CONTENT_2__PROP, value);
		if (before != null) {
			before.internalSetContainer(null);
		}
		_content2 = value;
		if (after != null) {
			after.internalSetContainer(this);
		}
	}

	@Override
	public final boolean hasContent2() {
		return _content2 != null;
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.container.model.MyContainer registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.container.model.MyContainer unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		internalUnregisterListener(l);
		return this;
	}

	protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
	}

	@Override
	public String jsonType() {
		return MY_CONTAINER__TYPE;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			NAME__PROP, 
			CONTENT_1__PROP, 
			CONTENT_2__PROP));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case NAME__PROP: return getName();
			case CONTENT_1__PROP: return getContent1();
			case CONTENT_2__PROP: return getContent2();
			default: return test.container.model.MyContainer.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case NAME__PROP: internalSetName((String) value); break;
			case CONTENT_1__PROP: internalSetContent1((test.container.model.MyContent) value); break;
			case CONTENT_2__PROP: internalSetContent2((test.container.model.MyContent) value); break;
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
		if (hasContent1()) {
			out.name(CONTENT_1__PROP);
			getContent1().writeTo(out);
		}
		if (hasContent2()) {
			out.name(CONTENT_2__PROP);
			getContent2().writeTo(out);
		}
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case NAME__PROP: setName(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			case CONTENT_1__PROP: setContent1(test.container.model.MyContent.readMyContent(in)); break;
			case CONTENT_2__PROP: setContent2(test.container.model.MyContent.readMyContent(in)); break;
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
		if (hasContent1()) {
			out.name(CONTENT_1__ID);
			getContent1().writeTo(out);
		}
		if (hasContent2()) {
			out.name(CONTENT_2__ID);
			getContent2().writeTo(out);
		}
	}

	/** Helper for creating an object of type {@link test.container.model.MyContainer} from a polymorphic composition. */
	public static test.container.model.MyContainer readMyContainer_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.container.model.impl.MyContainer_Impl result = new MyContainer_Impl();
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
			case CONTENT_1__ID: setContent1(test.container.model.MyContent.readMyContent(in)); break;
			case CONTENT_2__ID: setContent2(test.container.model.MyContent.readMyContent(in)); break;
			default: in.skipValue(); 
		}
	}

	/** XML element name representing a {@link test.container.model.MyContainer} type. */
	public static final String MY_CONTAINER__XML_ELEMENT = "my-container";

	/** XML attribute or element name of a {@link #getName} property. */
	private static final String NAME__XML_ATTR = "name";

	/** XML attribute or element name of a {@link #getContent1} property. */
	private static final String CONTENT_1__XML_ATTR = "content-1";

	/** XML attribute or element name of a {@link #getContent2} property. */
	private static final String CONTENT_2__XML_ATTR = "content-2";

	@Override
	public String getXmlTagName() {
		return MY_CONTAINER__XML_ELEMENT;
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
		if (hasContent1()) {
			out.writeStartElement(CONTENT_1__XML_ATTR);
			getContent1().writeContent(out);
			out.writeEndElement();
		}
		if (hasContent2()) {
			out.writeStartElement(CONTENT_2__XML_ATTR);
			getContent2().writeContent(out);
			out.writeEndElement();
		}
	}

	/** Creates a new {@link test.container.model.MyContainer} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static MyContainer_Impl readMyContainer_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		MyContainer_Impl result = new MyContainer_Impl();
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
			case CONTENT_1__XML_ATTR: {
				setContent1(test.container.model.impl.MyContent_Impl.readMyContent_XmlContent(in));
				break;
			}
			case CONTENT_2__XML_ATTR: {
				setContent2(test.container.model.impl.MyContent_Impl.readMyContent_XmlContent(in));
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
