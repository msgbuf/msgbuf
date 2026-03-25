package test.crossref.composite.impl;

/**
 * Implementation of {@link test.crossref.composite.DeliveryOrder}.
 */
public class DeliveryOrder_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.crossref.composite.DeliveryOrder {

	private String _orderId = "";

	private test.crossref.shared.Address _sender = null;

	private test.crossref.shared.Address _recipient = null;

	private final java.util.List<test.crossref.composite.Item> _items = new de.haumacher.msgbuf.util.ReferenceList<test.crossref.composite.Item>() {
		@Override
		protected void beforeAdd(int index, test.crossref.composite.Item element) {
			_listener.beforeAdd(DeliveryOrder_Impl.this, ITEMS__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, test.crossref.composite.Item element) {
			_listener.afterRemove(DeliveryOrder_Impl.this, ITEMS__PROP, index, element);
		}

		@Override
		protected void afterChanged() {
			_listener.afterChanged(DeliveryOrder_Impl.this, ITEMS__PROP);
		}
	};

	/**
	 * Creates a {@link DeliveryOrder_Impl} instance.
	 *
	 * @see test.crossref.composite.DeliveryOrder#create()
	 */
	public DeliveryOrder_Impl() {
		super();
	}

	@Override
	public final String getOrderId() {
		return _orderId;
	}

	@Override
	public test.crossref.composite.DeliveryOrder setOrderId(String value) {
		internalSetOrderId(value);
		return this;
	}

	/** Internal setter for {@link #getOrderId()} without chain call utility. */
	protected final void internalSetOrderId(String value) {
		_listener.beforeSet(this, ORDER_ID__PROP, value);
		_orderId = value;
		_listener.afterChanged(this, ORDER_ID__PROP);
	}

	@Override
	public final test.crossref.shared.Address getSender() {
		return _sender;
	}

	@Override
	public test.crossref.composite.DeliveryOrder setSender(test.crossref.shared.Address value) {
		internalSetSender(value);
		return this;
	}

	/** Internal setter for {@link #getSender()} without chain call utility. */
	protected final void internalSetSender(test.crossref.shared.Address value) {
		_listener.beforeSet(this, SENDER__PROP, value);
		_sender = value;
		_listener.afterChanged(this, SENDER__PROP);
	}

	@Override
	public final boolean hasSender() {
		return _sender != null;
	}

	@Override
	public final test.crossref.shared.Address getRecipient() {
		return _recipient;
	}

	@Override
	public test.crossref.composite.DeliveryOrder setRecipient(test.crossref.shared.Address value) {
		internalSetRecipient(value);
		return this;
	}

	/** Internal setter for {@link #getRecipient()} without chain call utility. */
	protected final void internalSetRecipient(test.crossref.shared.Address value) {
		_listener.beforeSet(this, RECIPIENT__PROP, value);
		_recipient = value;
		_listener.afterChanged(this, RECIPIENT__PROP);
	}

	@Override
	public final boolean hasRecipient() {
		return _recipient != null;
	}

	@Override
	public final java.util.List<test.crossref.composite.Item> getItems() {
		return _items;
	}

	@Override
	public test.crossref.composite.DeliveryOrder setItems(java.util.List<? extends test.crossref.composite.Item> value) {
		internalSetItems(value);
		return this;
	}

	/** Internal setter for {@link #getItems()} without chain call utility. */
	protected final void internalSetItems(java.util.List<? extends test.crossref.composite.Item> value) {
		if (value == null) throw new IllegalArgumentException("Property 'items' cannot be null.");
		_items.clear();
		_items.addAll(value);
	}

	@Override
	public test.crossref.composite.DeliveryOrder addItem(test.crossref.composite.Item value) {
		internalAddItem(value);
		return this;
	}

	/** Implementation of {@link #addItem(test.crossref.composite.Item)} without chain call utility. */
	protected final void internalAddItem(test.crossref.composite.Item value) {
		_items.add(value);
	}

	@Override
	public final void removeItem(test.crossref.composite.Item value) {
		_items.remove(value);
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.crossref.composite.DeliveryOrder registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.crossref.composite.DeliveryOrder unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		internalUnregisterListener(l);
		return this;
	}

	protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
	}

	@Override
	public String jsonType() {
		return DELIVERY_ORDER__TYPE;
	}

	static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			ORDER_ID__PROP, 
			SENDER__PROP, 
			RECIPIENT__PROP, 
			ITEMS__PROP);
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
			case ORDER_ID__PROP: return getOrderId();
			case SENDER__PROP: return getSender();
			case RECIPIENT__PROP: return getRecipient();
			case ITEMS__PROP: return getItems();
			default: return test.crossref.composite.DeliveryOrder.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case ORDER_ID__PROP: internalSetOrderId((String) value); break;
			case SENDER__PROP: internalSetSender((test.crossref.shared.Address) value); break;
			case RECIPIENT__PROP: internalSetRecipient((test.crossref.shared.Address) value); break;
			case ITEMS__PROP: internalSetItems(de.haumacher.msgbuf.util.Conversions.asList(test.crossref.composite.Item.class, value)); break;
		}
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(ORDER_ID__PROP);
		out.value(getOrderId());
		if (hasSender()) {
			out.name(SENDER__PROP);
			getSender().writeTo(out);
		}
		if (hasRecipient()) {
			out.name(RECIPIENT__PROP);
			getRecipient().writeTo(out);
		}
		out.name(ITEMS__PROP);
		out.beginArray();
		for (test.crossref.composite.Item x : getItems()) {
			x.writeTo(out);
		}
		out.endArray();
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case ORDER_ID__PROP: setOrderId(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			case SENDER__PROP: setSender(test.crossref.shared.Address.readAddress(in)); break;
			case RECIPIENT__PROP: setRecipient(test.crossref.shared.Address.readAddress(in)); break;
			case ITEMS__PROP: {
				java.util.List<test.crossref.composite.Item> newValue = new java.util.ArrayList<>();
				in.beginArray();
				while (in.hasNext()) {
					newValue.add(test.crossref.composite.Item.readItem(in));
				}
				in.endArray();
				setItems(newValue);
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
		out.name(ORDER_ID__ID);
		out.value(getOrderId());
		if (hasSender()) {
			out.name(SENDER__ID);
			getSender().writeTo(out);
		}
		if (hasRecipient()) {
			out.name(RECIPIENT__ID);
			getRecipient().writeTo(out);
		}
		out.name(ITEMS__ID);
		{
			java.util.List<test.crossref.composite.Item> values = getItems();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.OBJECT, values.size());
			for (test.crossref.composite.Item x : values) {
				x.writeTo(out);
			}
			out.endArray();
		}
	}

	/** Helper for creating an object of type {@link test.crossref.composite.DeliveryOrder} from a polymorphic composition. */
	public static test.crossref.composite.DeliveryOrder readDeliveryOrder_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.crossref.composite.impl.DeliveryOrder_Impl result = new DeliveryOrder_Impl();
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
			case ORDER_ID__ID: setOrderId(in.nextString()); break;
			case SENDER__ID: setSender(test.crossref.shared.Address.readAddress(in)); break;
			case RECIPIENT__ID: setRecipient(test.crossref.shared.Address.readAddress(in)); break;
			case ITEMS__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addItem(test.crossref.composite.Item.readItem(in));
				}
				in.endArray();
			}
			break;
			default: in.skipValue(); 
		}
	}

	/** XML element name representing a {@link test.crossref.composite.DeliveryOrder} type. */
	public static final String DELIVERY_ORDER__XML_ELEMENT = "delivery-order";

	/** XML attribute or element name of a {@link #getOrderId} property. */
	private static final String ORDER_ID__XML_ATTR = "order-id";

	/** XML attribute or element name of a {@link #getSender} property. */
	private static final String SENDER__XML_ATTR = "sender";

	/** XML attribute or element name of a {@link #getRecipient} property. */
	private static final String RECIPIENT__XML_ATTR = "recipient";

	/** XML attribute or element name of a {@link #getItems} property. */
	private static final String ITEMS__XML_ATTR = "items";

	@Override
	public String getXmlTagName() {
		return DELIVERY_ORDER__XML_ELEMENT;
	}

	@Override
	public final void writeContent(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		writeAttributes(out);
		writeElements(out);
	}

	/** Serializes all fields that are written as XML attributes. */
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		out.writeAttribute(ORDER_ID__XML_ATTR, getOrderId());
	}

	/** Serializes all fields that are written as XML elements. */
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		if (hasSender()) {
			out.writeStartElement(SENDER__XML_ATTR);
			getSender().writeContent(out);
			out.writeEndElement();
		}
		if (hasRecipient()) {
			out.writeStartElement(RECIPIENT__XML_ATTR);
			getRecipient().writeContent(out);
			out.writeEndElement();
		}
		out.writeStartElement(ITEMS__XML_ATTR);
		for (test.crossref.composite.Item element : getItems()) {
			element.writeTo(out);
		}
		out.writeEndElement();
	}

	/** Creates a new {@link test.crossref.composite.DeliveryOrder} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static DeliveryOrder_Impl readDeliveryOrder_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		DeliveryOrder_Impl result = new DeliveryOrder_Impl();
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
			case ORDER_ID__XML_ATTR: {
				setOrderId(value);
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
			case ORDER_ID__XML_ATTR: {
				setOrderId(in.getElementText());
				break;
			}
			case SENDER__XML_ATTR: {
				setSender(test.crossref.shared.impl.Address_Impl.readAddress_XmlContent(in));
				break;
			}
			case RECIPIENT__XML_ATTR: {
				setRecipient(test.crossref.shared.impl.Address_Impl.readAddress_XmlContent(in));
				break;
			}
			case ITEMS__XML_ATTR: {
				internalReadItemsListXml(in);
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

	private void internalReadItemsListXml(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		while (true) {
			int event = in.nextTag();
			if (event == javax.xml.stream.XMLStreamConstants.END_ELEMENT) {
				break;
			}

			addItem(test.crossref.composite.impl.Item_Impl.readItem_XmlContent(in));
		}
	}

}
