package test.openworld.deep.ext1.impl;

/**
 * Implementation of {@link test.openworld.deep.ext1.Pond}.
 */
public class Pond_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.openworld.deep.ext1.Pond {

	private test.openworld.deep.ext1.Fish _king = null;

	private final java.util.List<test.openworld.deep.ext1.Fish> _school = new de.haumacher.msgbuf.util.ReferenceList<test.openworld.deep.ext1.Fish>() {
		@Override
		protected void beforeAdd(int index, test.openworld.deep.ext1.Fish element) {
			_listener.beforeAdd(Pond_Impl.this, SCHOOL__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, test.openworld.deep.ext1.Fish element) {
			_listener.afterRemove(Pond_Impl.this, SCHOOL__PROP, index, element);
		}

		@Override
		protected void afterChanged() {
			_listener.afterChanged(Pond_Impl.this, SCHOOL__PROP);
		}
	};

	/**
	 * Creates a {@link Pond_Impl} instance.
	 *
	 * @see test.openworld.deep.ext1.Pond#create()
	 */
	public Pond_Impl() {
		super();
	}

	@Override
	public final test.openworld.deep.ext1.Fish getKing() {
		return _king;
	}

	@Override
	public test.openworld.deep.ext1.Pond setKing(test.openworld.deep.ext1.Fish value) {
		internalSetKing(value);
		return this;
	}

	/** Internal setter for {@link #getKing()} without chain call utility. */
	protected final void internalSetKing(test.openworld.deep.ext1.Fish value) {
		_listener.beforeSet(this, KING__PROP, value);
		_king = value;
		_listener.afterChanged(this, KING__PROP);
	}

	@Override
	public final boolean hasKing() {
		return _king != null;
	}

	@Override
	public final java.util.List<test.openworld.deep.ext1.Fish> getSchool() {
		return _school;
	}

	@Override
	public test.openworld.deep.ext1.Pond setSchool(java.util.List<? extends test.openworld.deep.ext1.Fish> value) {
		internalSetSchool(value);
		return this;
	}

	/** Internal setter for {@link #getSchool()} without chain call utility. */
	protected final void internalSetSchool(java.util.List<? extends test.openworld.deep.ext1.Fish> value) {
		if (value == null) throw new IllegalArgumentException("Property 'school' cannot be null.");
		_school.clear();
		_school.addAll(value);
	}

	@Override
	public test.openworld.deep.ext1.Pond addSchool(test.openworld.deep.ext1.Fish value) {
		internalAddSchool(value);
		return this;
	}

	/** Implementation of {@link #addSchool(test.openworld.deep.ext1.Fish)} without chain call utility. */
	protected final void internalAddSchool(test.openworld.deep.ext1.Fish value) {
		_school.add(value);
	}

	@Override
	public final void removeSchool(test.openworld.deep.ext1.Fish value) {
		_school.remove(value);
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.openworld.deep.ext1.Pond registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.openworld.deep.ext1.Pond unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		internalUnregisterListener(l);
		return this;
	}

	protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
	}

	@Override
	public String jsonType() {
		return POND__TYPE;
	}

	protected static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			KING__PROP, 
			SCHOOL__PROP);
		PROPERTIES = java.util.Collections.unmodifiableList(local);
	}

	protected static final java.util.Set<String> TRANSIENT_PROPERTIES;
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
			case KING__PROP: return getKing();
			case SCHOOL__PROP: return getSchool();
			default: return test.openworld.deep.ext1.Pond.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case KING__PROP: internalSetKing((test.openworld.deep.ext1.Fish) value); break;
			case SCHOOL__PROP: internalSetSchool(de.haumacher.msgbuf.util.Conversions.asList(test.openworld.deep.ext1.Fish.class, value)); break;
		}
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		if (hasKing()) {
			out.name(KING__PROP);
			getKing().writeTo(out);
		}
		out.name(SCHOOL__PROP);
		out.beginArray();
		for (test.openworld.deep.ext1.Fish x : getSchool()) {
			x.writeTo(out);
		}
		out.endArray();
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case KING__PROP: setKing(test.openworld.deep.ext1.Fish.readFish(in)); break;
			case SCHOOL__PROP: {
				java.util.List<test.openworld.deep.ext1.Fish> newValue = new java.util.ArrayList<>();
				in.beginArray();
				while (in.hasNext()) {
					newValue.add(test.openworld.deep.ext1.Fish.readFish(in));
				}
				in.endArray();
				setSchool(newValue);
			}
			break;
			default: super.readField(in, field);
		}
	}

	/** XML element name representing a {@link test.openworld.deep.ext1.Pond} type. */
	public static final String POND__XML_ELEMENT = "pond";

	/** XML attribute or element name of a {@link #getKing} property. */
	private static final String KING__XML_ATTR = "king";

	/** XML attribute or element name of a {@link #getSchool} property. */
	private static final String SCHOOL__XML_ATTR = "school";

	@Override
	public String getXmlTagName() {
		return POND__XML_ELEMENT;
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
		if (hasKing()) {
			out.writeStartElement(KING__XML_ATTR);
			getKing().writeTo(out);
			out.writeEndElement();
		}
		out.writeStartElement(SCHOOL__XML_ATTR);
		for (test.openworld.deep.ext1.Fish element : getSchool()) {
			element.writeTo(out);
		}
		out.writeEndElement();
	}

	/** Creates a new {@link test.openworld.deep.ext1.Pond} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Pond_Impl readPond_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		Pond_Impl result = new Pond_Impl();
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
			case KING__XML_ATTR: {
				in.nextTag();
				setKing(test.openworld.deep.ext1.impl.Fish_Impl.readFish_XmlContent(in));
				internalSkipUntilMatchingEndElement(in);
				break;
			}
			case SCHOOL__XML_ATTR: {
				internalReadSchoolListXml(in);
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

	private void internalReadSchoolListXml(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		while (true) {
			int event = in.nextTag();
			if (event == javax.xml.stream.XMLStreamConstants.END_ELEMENT) {
				break;
			}

			addSchool(test.openworld.deep.ext1.impl.Fish_Impl.readFish_XmlContent(in));
		}
	}

}
