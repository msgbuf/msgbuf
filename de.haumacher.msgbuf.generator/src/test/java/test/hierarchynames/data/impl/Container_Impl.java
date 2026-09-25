package test.hierarchynames.data.impl;

/**
 * Implementation of {@link test.hierarchynames.data.Container}.
 */
public class Container_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.hierarchynames.data.Container {

	private test.hierarchynames.data.Msg _msg = null;

	private test.hierarchynames.data.Outer.Shape _shape = null;

	/**
	 * Creates a {@link Container_Impl} instance.
	 *
	 * @see test.hierarchynames.data.Container#create()
	 */
	public Container_Impl() {
		super();
	}

	@Override
	public final test.hierarchynames.data.Msg getMsg() {
		return _msg;
	}

	@Override
	public test.hierarchynames.data.Container setMsg(test.hierarchynames.data.Msg value) {
		internalSetMsg(value);
		return this;
	}

	/** Internal setter for {@link #getMsg()} without chain call utility. */
	protected final void internalSetMsg(test.hierarchynames.data.Msg value) {
		_listener.beforeSet(this, MSG__PROP, value);
		_msg = value;
		_listener.afterChanged(this, MSG__PROP);
	}

	@Override
	public final boolean hasMsg() {
		return _msg != null;
	}

	@Override
	public final test.hierarchynames.data.Outer.Shape getShape() {
		return _shape;
	}

	@Override
	public test.hierarchynames.data.Container setShape(test.hierarchynames.data.Outer.Shape value) {
		internalSetShape(value);
		return this;
	}

	/** Internal setter for {@link #getShape()} without chain call utility. */
	protected final void internalSetShape(test.hierarchynames.data.Outer.Shape value) {
		_listener.beforeSet(this, SHAPE__PROP, value);
		_shape = value;
		_listener.afterChanged(this, SHAPE__PROP);
	}

	@Override
	public final boolean hasShape() {
		return _shape != null;
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.hierarchynames.data.Container registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.hierarchynames.data.Container unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		internalUnregisterListener(l);
		return this;
	}

	protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
	}

	@Override
	public String jsonType() {
		return CONTAINER__TYPE;
	}

	static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			MSG__PROP, 
			SHAPE__PROP);
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
			case MSG__PROP: return getMsg();
			case SHAPE__PROP: return getShape();
			default: return test.hierarchynames.data.Container.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case MSG__PROP: internalSetMsg((test.hierarchynames.data.Msg) value); break;
			case SHAPE__PROP: internalSetShape((test.hierarchynames.data.Outer.Shape) value); break;
		}
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		if (hasMsg()) {
			out.name(MSG__PROP);
			getMsg().writeTo(out);
		}
		if (hasShape()) {
			out.name(SHAPE__PROP);
			getShape().writeTo(out);
		}
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case MSG__PROP: setMsg(test.hierarchynames.data.Msg.readMsg(in)); break;
			case SHAPE__PROP: setShape(test.hierarchynames.data.Outer.Shape.readShape(in)); break;
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
		if (hasMsg()) {
			out.name(MSG__ID);
			getMsg().writeTo(out);
		}
		if (hasShape()) {
			out.name(SHAPE__ID);
			getShape().writeTo(out);
		}
	}

	/** Helper for creating an object of type {@link test.hierarchynames.data.Container} from a polymorphic composition. */
	public static test.hierarchynames.data.Container readContainer_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.hierarchynames.data.impl.Container_Impl result = new Container_Impl();
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
			case MSG__ID: setMsg(test.hierarchynames.data.Msg.readMsg(in)); break;
			case SHAPE__ID: setShape(test.hierarchynames.data.Outer.Shape.readShape(in)); break;
			default: in.skipValue(); 
		}
	}

	/** XML element name representing a {@link test.hierarchynames.data.Container} type. */
	public static final String CONTAINER__XML_ELEMENT = "container";

	/** XML attribute or element name of a {@link #getMsg} property. */
	private static final String MSG__XML_ATTR = "msg";

	/** XML attribute or element name of a {@link #getShape} property. */
	private static final String SHAPE__XML_ATTR = "shape";

	@Override
	public String getXmlTagName() {
		return CONTAINER__XML_ELEMENT;
	}

	@Override
	public final void writeContent(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		writeAttributes(out);
		writeElements(out);
	}

	/** Serializes all fields that are written as XML attributes. */
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
	}

	/** Serializes all fields that are written as XML elements. */
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		if (hasMsg()) {
			out.writeStartElement(MSG__XML_ATTR);
			getMsg().writeTo(out);
			out.writeEndElement();
		}
		if (hasShape()) {
			out.writeStartElement(SHAPE__XML_ATTR);
			getShape().writeTo(out);
			out.writeEndElement();
		}
	}

	/** Creates a new {@link test.hierarchynames.data.Container} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Container_Impl readContainer_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		Container_Impl result = new Container_Impl();
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
			default: {
				// Skip unknown attribute.
			}
		}
	}

	/** Reads the element under the cursor and assigns its contents to the field with the given name. */
	protected void readFieldXmlElement(javax.xml.stream.XMLStreamReader in, String localName) throws javax.xml.stream.XMLStreamException {
		switch (localName) {
			case MSG__XML_ATTR: {
				in.nextTag();
				setMsg(test.hierarchynames.data.impl.Msg_Impl.readMsg_XmlContent(in));
				internalSkipUntilMatchingEndElement(in);
				break;
			}
			case SHAPE__XML_ATTR: {
				in.nextTag();
				setShape(test.hierarchynames.data.impl.Outer_Impl.Shape_Impl.readShape_XmlContent(in));
				internalSkipUntilMatchingEndElement(in);
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
