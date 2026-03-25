package test.crossref.composite;

/**
 * A delivery order referencing shared types.
 */
public interface DeliveryOrder extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/**
	 * Creates a {@link test.crossref.composite.DeliveryOrder} instance.
	 */
	static test.crossref.composite.DeliveryOrder create() {
		return new test.crossref.composite.impl.DeliveryOrder_Impl();
	}

	/** Identifier for the {@link test.crossref.composite.DeliveryOrder} type in JSON format. */
	String DELIVERY_ORDER__TYPE = "DeliveryOrder";

	/** @see #getOrderId() */
	String ORDER_ID__PROP = "orderId";

	/** @see #getSender() */
	String SENDER__PROP = "sender";

	/** @see #getRecipient() */
	String RECIPIENT__PROP = "recipient";

	/** @see #getItems() */
	String ITEMS__PROP = "items";

	/** Identifier for the property {@link #getOrderId()} in binary format. */
	static final int ORDER_ID__ID = 1;

	/** Identifier for the property {@link #getSender()} in binary format. */
	static final int SENDER__ID = 2;

	/** Identifier for the property {@link #getRecipient()} in binary format. */
	static final int RECIPIENT__ID = 3;

	/** Identifier for the property {@link #getItems()} in binary format. */
	static final int ITEMS__ID = 4;

	String getOrderId();

	/**
	 * @see #getOrderId()
	 */
	test.crossref.composite.DeliveryOrder setOrderId(String value);

	/**
	 * Sender address.
	 */
	test.crossref.shared.Address getSender();

	/**
	 * @see #getSender()
	 */
	test.crossref.composite.DeliveryOrder setSender(test.crossref.shared.Address value);

	/**
	 * Checks, whether {@link #getSender()} has a value.
	 */
	boolean hasSender();

	/**
	 * Recipient address.
	 */
	test.crossref.shared.Address getRecipient();

	/**
	 * @see #getRecipient()
	 */
	test.crossref.composite.DeliveryOrder setRecipient(test.crossref.shared.Address value);

	/**
	 * Checks, whether {@link #getRecipient()} has a value.
	 */
	boolean hasRecipient();

	/**
	 * Delivery items.
	 */
	java.util.List<test.crossref.composite.Item> getItems();

	/**
	 * @see #getItems()
	 */
	test.crossref.composite.DeliveryOrder setItems(java.util.List<? extends test.crossref.composite.Item> value);

	/**
	 * Adds a value to the {@link #getItems()} list.
	 */
	test.crossref.composite.DeliveryOrder addItem(test.crossref.composite.Item value);

	/**
	 * Removes a value from the {@link #getItems()} list.
	 */
	void removeItem(test.crossref.composite.Item value);

	@Override
	public test.crossref.composite.DeliveryOrder registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.crossref.composite.DeliveryOrder unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.crossref.composite.DeliveryOrder readDeliveryOrder(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.crossref.composite.impl.DeliveryOrder_Impl result = new test.crossref.composite.impl.DeliveryOrder_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.crossref.composite.DeliveryOrder readDeliveryOrder(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.crossref.composite.DeliveryOrder result = test.crossref.composite.impl.DeliveryOrder_Impl.readDeliveryOrder_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link DeliveryOrder} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static DeliveryOrder readDeliveryOrder(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.crossref.composite.impl.DeliveryOrder_Impl.readDeliveryOrder_XmlContent(in);
	}

}
