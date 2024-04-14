package test.embedded.data.impl;

/**
 * Implementation of {@link test.embedded.data.EmbeddingContainer}.
 */
public class EmbeddingContainer_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.embedded.data.EmbeddingContainer {

	private String _name = "";

	private final java.util.List<test.embedded.data.Base> _contents = new de.haumacher.msgbuf.util.ReferenceList<>() {
		@Override
		protected void beforeAdd(int index, test.embedded.data.Base element) {
			_listener.beforeAdd(EmbeddingContainer_Impl.this, CONTENTS__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, test.embedded.data.Base element) {
			_listener.afterRemove(EmbeddingContainer_Impl.this, CONTENTS__PROP, index, element);
		}
	};

	/**
	 * Creates a {@link EmbeddingContainer_Impl} instance.
	 *
	 * @see test.embedded.data.EmbeddingContainer#create()
	 */
	public EmbeddingContainer_Impl() {
		super();
	}

	@Override
	public final String getName() {
		return _name;
	}

	@Override
	public test.embedded.data.EmbeddingContainer setName(String value) {
		internalSetName(value);
		return this;
	}

	/** Internal setter for {@link #getName()} without chain call utility. */
	protected final void internalSetName(String value) {
		_listener.beforeSet(this, NAME__PROP, value);
		_name = value;
	}

	@Override
	public final java.util.List<test.embedded.data.Base> getContents() {
		return _contents;
	}

	@Override
	public test.embedded.data.EmbeddingContainer setContents(java.util.List<? extends test.embedded.data.Base> value) {
		internalSetContents(value);
		return this;
	}

	/** Internal setter for {@link #getContents()} without chain call utility. */
	protected final void internalSetContents(java.util.List<? extends test.embedded.data.Base> value) {
		if (value == null) throw new IllegalArgumentException("Property 'contents' cannot be null.");
		_contents.clear();
		_contents.addAll(value);
	}

	@Override
	public test.embedded.data.EmbeddingContainer addContent(test.embedded.data.Base value) {
		internalAddContent(value);
		return this;
	}

	/** Implementation of {@link #addContent(test.embedded.data.Base)} without chain call utility. */
	protected final void internalAddContent(test.embedded.data.Base value) {
		_contents.add(value);
	}

	@Override
	public final void removeContent(test.embedded.data.Base value) {
		_contents.remove(value);
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.embedded.data.EmbeddingContainer registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.embedded.data.EmbeddingContainer unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		internalUnregisterListener(l);
		return this;
	}

	protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
	}

	@Override
	public String jsonType() {
		return EMBEDDING_CONTAINER__TYPE;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			NAME__PROP, 
			CONTENTS__PROP));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case NAME__PROP: return getName();
			case CONTENTS__PROP: return getContents();
			default: return test.embedded.data.EmbeddingContainer.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case NAME__PROP: internalSetName((String) value); break;
			case CONTENTS__PROP: internalSetContents(de.haumacher.msgbuf.util.Conversions.asList(test.embedded.data.Base.class, value)); break;
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
		out.name(CONTENTS__PROP);
		out.beginArray();
		for (test.embedded.data.Base x : getContents()) {
			x.writeTo(out);
		}
		out.endArray();
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case NAME__PROP: setName(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			case CONTENTS__PROP: {
				in.beginArray();
				while (in.hasNext()) {
					addContent(test.embedded.data.Base.readBase(in));
				}
				in.endArray();
			}
			break;
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
		out.name(CONTENTS__ID);
		{
			java.util.List<test.embedded.data.Base> values = getContents();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.OBJECT, values.size());
			for (test.embedded.data.Base x : values) {
				x.writeTo(out);
			}
			out.endArray();
		}
	}

	/** Helper for creating an object of type {@link test.embedded.data.EmbeddingContainer} from a polymorphic composition. */
	public static test.embedded.data.EmbeddingContainer readEmbeddingContainer_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.embedded.data.impl.EmbeddingContainer_Impl result = new EmbeddingContainer_Impl();
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
			case CONTENTS__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addContent(test.embedded.data.Base.readBase(in));
				}
				in.endArray();
			}
			break;
			default: in.skipValue(); 
		}
	}

	/** XML element name representing a {@link test.embedded.data.EmbeddingContainer} type. */
	public static final String EMBEDDING_CONTAINER__XML_ELEMENT = "embedding-container";

	/** XML attribute or element name of a {@link #getName} property. */
	private static final String NAME__XML_ATTR = "name";

	/** XML attribute or element name of a {@link #getContents} property. */
	private static final String CONTENTS__XML_ATTR = "contents";

	@Override
	public String getXmlTagName() {
		return EMBEDDING_CONTAINER__XML_ELEMENT;
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
		out.writeStartElement(CONTENTS__XML_ATTR);
		for (test.embedded.data.Base element : getContents()) {
			element.writeTo(out);
		}
		out.writeEndElement();
	}

	/** Creates a new {@link test.embedded.data.EmbeddingContainer} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static EmbeddingContainer_Impl readEmbeddingContainer_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		EmbeddingContainer_Impl result = new EmbeddingContainer_Impl();
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
			case test.embedded.data.impl.A_Impl.A__XML_ELEMENT: {
				addContent(test.embedded.data.impl.A_Impl.readA_XmlContent(in));
				break;
			}
			case test.embedded.data.impl.B_Impl.B__XML_ELEMENT: {
				addContent(test.embedded.data.impl.B_Impl.readB_XmlContent(in));
				break;
			}
			case CONTENTS__XML_ATTR: {
				internalReadContentsListXml(in);
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

	private void internalReadContentsListXml(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		while (true) {
			int event = in.nextTag();
			if (event == javax.xml.stream.XMLStreamConstants.END_ELEMENT) {
				break;
			}

			addContent(test.embedded.data.impl.Base_Impl.readBase_XmlContent(in));
		}
	}

}
