package test.crossref.composite.impl;

/**
 * Implementation of {@link test.crossref.composite.Item}.
 */
public class Item_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.crossref.composite.Item {

	private String _productName = "";

	private int _quantity = 0;

	/**
	 * Creates a {@link Item_Impl} instance.
	 *
	 * @see test.crossref.composite.Item#create()
	 */
	public Item_Impl() {
		super();
	}

	@Override
	public final String getProductName() {
		return _productName;
	}

	@Override
	public test.crossref.composite.Item setProductName(String value) {
		internalSetProductName(value);
		return this;
	}

	/** Internal setter for {@link #getProductName()} without chain call utility. */
	protected final void internalSetProductName(String value) {
		_listener.beforeSet(this, PRODUCT_NAME__PROP, value);
		_productName = value;
		_listener.afterChanged(this, PRODUCT_NAME__PROP);
	}

	@Override
	public final int getQuantity() {
		return _quantity;
	}

	@Override
	public test.crossref.composite.Item setQuantity(int value) {
		internalSetQuantity(value);
		return this;
	}

	/** Internal setter for {@link #getQuantity()} without chain call utility. */
	protected final void internalSetQuantity(int value) {
		_listener.beforeSet(this, QUANTITY__PROP, value);
		_quantity = value;
		_listener.afterChanged(this, QUANTITY__PROP);
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.crossref.composite.Item registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.crossref.composite.Item unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		internalUnregisterListener(l);
		return this;
	}

	protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
	}

	@Override
	public String jsonType() {
		return ITEM__TYPE;
	}

	static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			PRODUCT_NAME__PROP, 
			QUANTITY__PROP);
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
			case PRODUCT_NAME__PROP: return getProductName();
			case QUANTITY__PROP: return getQuantity();
			default: return test.crossref.composite.Item.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case PRODUCT_NAME__PROP: internalSetProductName((String) value); break;
			case QUANTITY__PROP: internalSetQuantity((int) value); break;
		}
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(PRODUCT_NAME__PROP);
		out.value(getProductName());
		out.name(QUANTITY__PROP);
		out.value(getQuantity());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case PRODUCT_NAME__PROP: setProductName(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			case QUANTITY__PROP: setQuantity(in.nextInt()); break;
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
		out.name(PRODUCT_NAME__ID);
		out.value(getProductName());
		out.name(QUANTITY__ID);
		out.value(getQuantity());
	}

	/** Helper for creating an object of type {@link test.crossref.composite.Item} from a polymorphic composition. */
	public static test.crossref.composite.Item readItem_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.crossref.composite.impl.Item_Impl result = new Item_Impl();
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
			case PRODUCT_NAME__ID: setProductName(in.nextString()); break;
			case QUANTITY__ID: setQuantity(in.nextInt()); break;
			default: in.skipValue(); 
		}
	}

	/** XML element name representing a {@link test.crossref.composite.Item} type. */
	public static final String ITEM__XML_ELEMENT = "item";

	/** XML attribute or element name of a {@link #getProductName} property. */
	private static final String PRODUCT_NAME__XML_ATTR = "product-name";

	/** XML attribute or element name of a {@link #getQuantity} property. */
	private static final String QUANTITY__XML_ATTR = "quantity";

	@Override
	public String getXmlTagName() {
		return ITEM__XML_ELEMENT;
	}

	@Override
	public final void writeContent(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		writeAttributes(out);
		writeElements(out);
	}

	/** Serializes all fields that are written as XML attributes. */
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		out.writeAttribute(PRODUCT_NAME__XML_ATTR, getProductName());
		out.writeAttribute(QUANTITY__XML_ATTR, Integer.toString(getQuantity()));
	}

	/** Serializes all fields that are written as XML elements. */
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		// No element fields.
	}

	/** Creates a new {@link test.crossref.composite.Item} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Item_Impl readItem_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		Item_Impl result = new Item_Impl();
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
			case PRODUCT_NAME__XML_ATTR: {
				setProductName(value);
				break;
			}
			case QUANTITY__XML_ATTR: {
				setQuantity(Integer.parseInt(value));
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
			case PRODUCT_NAME__XML_ATTR: {
				setProductName(in.getElementText());
				break;
			}
			case QUANTITY__XML_ATTR: {
				setQuantity(Integer.parseInt(in.getElementText()));
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
