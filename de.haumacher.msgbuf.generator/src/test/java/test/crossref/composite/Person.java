package test.crossref.composite;

/**
 * A person with an address from the shared protocol.
 */
public interface Person extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/**
	 * Creates a {@link test.crossref.composite.Person} instance.
	 */
	static test.crossref.composite.Person create() {
		return new test.crossref.composite.impl.Person_Impl();
	}

	/** Identifier for the {@link test.crossref.composite.Person} type in JSON format. */
	String PERSON__TYPE = "Person";

	/** @see #getName() */
	String NAME__PROP = "name";

	/** @see #getAddress() */
	String ADDRESS__PROP = "address";

	/** @see #getLocation() */
	String LOCATION__PROP = "location";

	/** Identifier for the property {@link #getName()} in binary format. */
	static final int NAME__ID = 1;

	/** Identifier for the property {@link #getAddress()} in binary format. */
	static final int ADDRESS__ID = 2;

	/** Identifier for the property {@link #getLocation()} in binary format. */
	static final int LOCATION__ID = 3;

	String getName();

	/**
	 * @see #getName()
	 */
	test.crossref.composite.Person setName(String value);

	/**
	 * The person's home address (embedded from shared protocol).
	 */
	test.crossref.shared.Address getAddress();

	/**
	 * @see #getAddress()
	 */
	test.crossref.composite.Person setAddress(test.crossref.shared.Address value);

	/**
	 * Checks, whether {@link #getAddress()} has a value.
	 */
	boolean hasAddress();

	/**
	 * The person's location.
	 */
	test.crossref.shared.Coordinate getLocation();

	/**
	 * @see #getLocation()
	 */
	test.crossref.composite.Person setLocation(test.crossref.shared.Coordinate value);

	/**
	 * Checks, whether {@link #getLocation()} has a value.
	 */
	boolean hasLocation();

	@Override
	public test.crossref.composite.Person registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.crossref.composite.Person unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.crossref.composite.Person readPerson(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.crossref.composite.impl.Person_Impl result = new test.crossref.composite.impl.Person_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.crossref.composite.Person readPerson(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.crossref.composite.Person result = test.crossref.composite.impl.Person_Impl.readPerson_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link Person} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Person readPerson(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.crossref.composite.impl.Person_Impl.readPerson_XmlContent(in);
	}

}
