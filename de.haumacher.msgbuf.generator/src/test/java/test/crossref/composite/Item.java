package test.crossref.composite;

/**
 * An item in a delivery.
 */
public interface Item extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/**
	 * Creates a {@link test.crossref.composite.Item} instance.
	 */
	static test.crossref.composite.Item create() {
		return new test.crossref.composite.impl.Item_Impl();
	}

	/** Identifier for the {@link test.crossref.composite.Item} type in JSON format. */
	String ITEM__TYPE = "Item";

	/** @see #getProductName() */
	String PRODUCT_NAME__PROP = "productName";

	/** @see #getQuantity() */
	String QUANTITY__PROP = "quantity";

	/** Identifier for the property {@link #getProductName()} in binary format. */
	static final int PRODUCT_NAME__ID = 1;

	/** Identifier for the property {@link #getQuantity()} in binary format. */
	static final int QUANTITY__ID = 2;

	String getProductName();

	/**
	 * @see #getProductName()
	 */
	test.crossref.composite.Item setProductName(String value);

	int getQuantity();

	/**
	 * @see #getQuantity()
	 */
	test.crossref.composite.Item setQuantity(int value);

	@Override
	public test.crossref.composite.Item registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.crossref.composite.Item unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.crossref.composite.Item readItem(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.crossref.composite.impl.Item_Impl result = new test.crossref.composite.impl.Item_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.crossref.composite.Item readItem(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.crossref.composite.Item result = test.crossref.composite.impl.Item_Impl.readItem_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link Item} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Item readItem(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.crossref.composite.impl.Item_Impl.readItem_XmlContent(in);
	}

}
