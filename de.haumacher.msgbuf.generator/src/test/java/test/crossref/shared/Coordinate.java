package test.crossref.shared;

/**
 * A coordinate pair.
 */
public interface Coordinate extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/**
	 * Creates a {@link test.crossref.shared.Coordinate} instance.
	 */
	static test.crossref.shared.Coordinate create() {
		return new test.crossref.shared.impl.Coordinate_Impl();
	}

	/** Identifier for the {@link test.crossref.shared.Coordinate} type in JSON format. */
	String COORDINATE__TYPE = "Coordinate";

	/** @see #getLat() */
	String LAT__PROP = "lat";

	/** @see #getLon() */
	String LON__PROP = "lon";

	/** Identifier for the property {@link #getLat()} in binary format. */
	static final int LAT__ID = 1;

	/** Identifier for the property {@link #getLon()} in binary format. */
	static final int LON__ID = 2;

	double getLat();

	/**
	 * @see #getLat()
	 */
	test.crossref.shared.Coordinate setLat(double value);

	double getLon();

	/**
	 * @see #getLon()
	 */
	test.crossref.shared.Coordinate setLon(double value);

	@Override
	public test.crossref.shared.Coordinate registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.crossref.shared.Coordinate unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.crossref.shared.Coordinate readCoordinate(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.crossref.shared.impl.Coordinate_Impl result = new test.crossref.shared.impl.Coordinate_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.crossref.shared.Coordinate readCoordinate(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.crossref.shared.Coordinate result = test.crossref.shared.impl.Coordinate_Impl.readCoordinate_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link Coordinate} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Coordinate readCoordinate(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.crossref.shared.impl.Coordinate_Impl.readCoordinate_XmlContent(in);
	}

}
