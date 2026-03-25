package test.crossref.shared;

/**
 * Shared address type used by other protocols.
 */
public interface Address extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/**
	 * Creates a {@link test.crossref.shared.Address} instance.
	 */
	static test.crossref.shared.Address create() {
		return new test.crossref.shared.impl.Address_Impl();
	}

	/** Identifier for the {@link test.crossref.shared.Address} type in JSON format. */
	String ADDRESS__TYPE = "Address";

	/** @see #getStreet() */
	String STREET__PROP = "street";

	/** @see #getCity() */
	String CITY__PROP = "city";

	/** @see #getZip() */
	String ZIP__PROP = "zip";

	/** Identifier for the property {@link #getStreet()} in binary format. */
	static final int STREET__ID = 1;

	/** Identifier for the property {@link #getCity()} in binary format. */
	static final int CITY__ID = 2;

	/** Identifier for the property {@link #getZip()} in binary format. */
	static final int ZIP__ID = 3;

	String getStreet();

	/**
	 * @see #getStreet()
	 */
	test.crossref.shared.Address setStreet(String value);

	String getCity();

	/**
	 * @see #getCity()
	 */
	test.crossref.shared.Address setCity(String value);

	String getZip();

	/**
	 * @see #getZip()
	 */
	test.crossref.shared.Address setZip(String value);

	@Override
	public test.crossref.shared.Address registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.crossref.shared.Address unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.crossref.shared.Address readAddress(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.crossref.shared.impl.Address_Impl result = new test.crossref.shared.impl.Address_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.crossref.shared.Address readAddress(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.crossref.shared.Address result = test.crossref.shared.impl.Address_Impl.readAddress_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link Address} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Address readAddress(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.crossref.shared.impl.Address_Impl.readAddress_XmlContent(in);
	}

}
