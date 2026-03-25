package test.crossref.shared.impl;

/**
 * Implementation of {@link test.crossref.shared.Coordinate}.
 */
public class Coordinate_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.crossref.shared.Coordinate {

	private double _lat = 0.0d;

	private double _lon = 0.0d;

	/**
	 * Creates a {@link Coordinate_Impl} instance.
	 *
	 * @see test.crossref.shared.Coordinate#create()
	 */
	public Coordinate_Impl() {
		super();
	}

	@Override
	public final double getLat() {
		return _lat;
	}

	@Override
	public test.crossref.shared.Coordinate setLat(double value) {
		internalSetLat(value);
		return this;
	}

	/** Internal setter for {@link #getLat()} without chain call utility. */
	protected final void internalSetLat(double value) {
		_listener.beforeSet(this, LAT__PROP, value);
		_lat = value;
		_listener.afterChanged(this, LAT__PROP);
	}

	@Override
	public final double getLon() {
		return _lon;
	}

	@Override
	public test.crossref.shared.Coordinate setLon(double value) {
		internalSetLon(value);
		return this;
	}

	/** Internal setter for {@link #getLon()} without chain call utility. */
	protected final void internalSetLon(double value) {
		_listener.beforeSet(this, LON__PROP, value);
		_lon = value;
		_listener.afterChanged(this, LON__PROP);
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.crossref.shared.Coordinate registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.crossref.shared.Coordinate unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		internalUnregisterListener(l);
		return this;
	}

	protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
	}

	@Override
	public String jsonType() {
		return COORDINATE__TYPE;
	}

	static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			LAT__PROP, 
			LON__PROP);
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
			case LAT__PROP: return getLat();
			case LON__PROP: return getLon();
			default: return test.crossref.shared.Coordinate.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case LAT__PROP: internalSetLat((double) value); break;
			case LON__PROP: internalSetLon((double) value); break;
		}
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(LAT__PROP);
		out.value(getLat());
		out.name(LON__PROP);
		out.value(getLon());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case LAT__PROP: setLat(in.nextDouble()); break;
			case LON__PROP: setLon(in.nextDouble()); break;
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
		out.name(LAT__ID);
		out.value(getLat());
		out.name(LON__ID);
		out.value(getLon());
	}

	/** Helper for creating an object of type {@link test.crossref.shared.Coordinate} from a polymorphic composition. */
	public static test.crossref.shared.Coordinate readCoordinate_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.crossref.shared.impl.Coordinate_Impl result = new Coordinate_Impl();
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
			case LAT__ID: setLat(in.nextDouble()); break;
			case LON__ID: setLon(in.nextDouble()); break;
			default: in.skipValue(); 
		}
	}

	/** XML element name representing a {@link test.crossref.shared.Coordinate} type. */
	public static final String COORDINATE__XML_ELEMENT = "coordinate";

	/** XML attribute or element name of a {@link #getLat} property. */
	private static final String LAT__XML_ATTR = "lat";

	/** XML attribute or element name of a {@link #getLon} property. */
	private static final String LON__XML_ATTR = "lon";

	@Override
	public String getXmlTagName() {
		return COORDINATE__XML_ELEMENT;
	}

	@Override
	public final void writeContent(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		writeAttributes(out);
		writeElements(out);
	}

	/** Serializes all fields that are written as XML attributes. */
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		out.writeAttribute(LAT__XML_ATTR, Double.toString(getLat()));
		out.writeAttribute(LON__XML_ATTR, Double.toString(getLon()));
	}

	/** Serializes all fields that are written as XML elements. */
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		// No element fields.
	}

	/** Creates a new {@link test.crossref.shared.Coordinate} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Coordinate_Impl readCoordinate_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		Coordinate_Impl result = new Coordinate_Impl();
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
			case LAT__XML_ATTR: {
				setLat(Double.parseDouble(value));
				break;
			}
			case LON__XML_ATTR: {
				setLon(Double.parseDouble(value));
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
			case LAT__XML_ATTR: {
				setLat(Double.parseDouble(in.getElementText()));
				break;
			}
			case LON__XML_ATTR: {
				setLon(Double.parseDouble(in.getElementText()));
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
