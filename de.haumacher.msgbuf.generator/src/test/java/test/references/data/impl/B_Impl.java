package test.references.data.impl;

public class B_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.references.data.B {

	private String _name = "";

	private final java.util.List<test.references.data.A> _inBs = new de.haumacher.msgbuf.util.ReferenceList<>() {
		@Override
		protected void beforeAdd(int index, test.references.data.A element) {
			_listener.beforeAdd(B_Impl.this, IN_BS__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, test.references.data.A element) {
			_listener.afterRemove(B_Impl.this, IN_BS__PROP, index, element);
		}
	};

	private final java.util.List<test.references.data.A> _inB = new de.haumacher.msgbuf.util.ReferenceList<>() {
		@Override
		protected void beforeAdd(int index, test.references.data.A element) {
			_listener.beforeAdd(B_Impl.this, IN_B__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, test.references.data.A element) {
			_listener.afterRemove(B_Impl.this, IN_B__PROP, index, element);
		}
	};

	/**
	 * Creates a {@link B_Impl} instance.
	 *
	 * @see test.references.data.B#create()
	 */
	public B_Impl() {
		super();
	}

	@Override
	public final String getName() {
		return _name;
	}

	@Override
	public test.references.data.B setName(String value) {
		internalSetName(value);
		return this;
	}

	/** Internal setter for {@link #getName()} without chain call utility. */
	protected final void internalSetName(String value) {
		_listener.beforeSet(this, NAME__PROP, value);
		_name = value;
	}

	@Override
	public final java.util.List<test.references.data.A> getInBs() {
		return _inBs;
	}

	/**
	 * Internal setter for updating derived field.
	 */
	test.references.data.B setInBs(java.util.List<? extends test.references.data.A> value) {
		internalSetInBs(value);
		return this;
	}

	/** Internal setter for {@link #getInBs()} without chain call utility. */
	protected final void internalSetInBs(java.util.List<? extends test.references.data.A> value) {
		if (value == null) throw new IllegalArgumentException("Property 'inBs' cannot be null.");
		_inBs.clear();
		_inBs.addAll(value);
	}

	test.references.data.B addInBs(test.references.data.A value) {
		internalAddInBs(value);
		return this;
	}

	/** Implementation of {@link #addInBs(test.references.data.A)} without chain call utility. */
	protected final void internalAddInBs(test.references.data.A value) {
		_inBs.add(value);
	}

	final void removeInBs(test.references.data.A value) {
		_inBs.remove(value);
	}

	@Override
	public final java.util.List<test.references.data.A> getInB() {
		return _inB;
	}

	/**
	 * Internal setter for updating derived field.
	 */
	test.references.data.B setInB(java.util.List<? extends test.references.data.A> value) {
		internalSetInB(value);
		return this;
	}

	/** Internal setter for {@link #getInB()} without chain call utility. */
	protected final void internalSetInB(java.util.List<? extends test.references.data.A> value) {
		if (value == null) throw new IllegalArgumentException("Property 'inB' cannot be null.");
		_inB.clear();
		_inB.addAll(value);
	}

	test.references.data.B addInB(test.references.data.A value) {
		internalAddInB(value);
		return this;
	}

	/** Implementation of {@link #addInB(test.references.data.A)} without chain call utility. */
	protected final void internalAddInB(test.references.data.A value) {
		_inB.add(value);
	}

	final void removeInB(test.references.data.A value) {
		_inB.remove(value);
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.references.data.B registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.references.data.B unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		internalUnregisterListener(l);
		return this;
	}

	protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
	}

	@Override
	public String jsonType() {
		return B__TYPE;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			NAME__PROP, 
			IN_BS__PROP, 
			IN_B__PROP));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case NAME__PROP: return getName();
			case IN_BS__PROP: return getInBs();
			case IN_B__PROP: return getInB();
			default: return test.references.data.B.super.get(field);
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

	/** Helper for creating an object of type {@link test.references.data.B} from a polymorphic composition. */
	public static test.references.data.B readB_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.references.data.impl.B_Impl result = new B_Impl();
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

	/** XML element name representing a {@link test.references.data.B} type. */
	public static final String B__XML_ELEMENT = "b";

	/** XML attribute or element name of a {@link #getName} property. */
	private static final String NAME__XML_ATTR = "name";

	/** XML attribute or element name of a {@link #getInBs} property. */
	private static final String IN_BS__XML_ATTR = "in-bs";

	/** XML attribute or element name of a {@link #getInB} property. */
	private static final String IN_B__XML_ATTR = "in-b";

	@Override
	public String getXmlTagName() {
		return B__XML_ELEMENT;
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
		out.writeStartElement(IN_BS__XML_ATTR);
		for (test.references.data.A element : getInBs()) {
			element.writeTo(out);
		}
		out.writeEndElement();
		out.writeStartElement(IN_B__XML_ATTR);
		for (test.references.data.A element : getInB()) {
			element.writeTo(out);
		}
		out.writeEndElement();
	}

	/** Creates a new {@link test.references.data.B} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static B_Impl readB_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		B_Impl result = new B_Impl();
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
			case IN_BS__XML_ATTR: {
				internalReadInBsListXml(in);
				break;
			}
			case IN_B__XML_ATTR: {
				internalReadInBListXml(in);
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

	private void internalReadInBsListXml(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		while (true) {
			int event = in.nextTag();
			if (event == javax.xml.stream.XMLStreamConstants.END_ELEMENT) {
				break;
			}

			addInBs(test.references.data.impl.A_Impl.readA_XmlContent(in));
		}
	}

	private void internalReadInBListXml(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		while (true) {
			int event = in.nextTag();
			if (event == javax.xml.stream.XMLStreamConstants.END_ELEMENT) {
				break;
			}

			addInB(test.references.data.impl.A_Impl.readA_XmlContent(in));
		}
	}

}
