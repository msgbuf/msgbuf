package test.references.data;

public interface B extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/**
	 * Creates a {@link B} instance.
	 */
	static B create() {
		return new test.references.data.B_Impl();
	}

	/** Identifier for the {@link B} type in JSON format. */
	static final String B__TYPE = "B";

	/** @see #getName() */
	static final String NAME__PROP = "name";

	/** @see #getInBs() */
	static final String IN_BS__PROP = "inBs";

	/** @see #getInB() */
	static final String IN_B__PROP = "inB";

	/** Identifier for the property {@link #getName()} in binary format. */
	static final int NAME__ID = 1;

	String getName();

	/**
	 * @see #getName()
	 */
	B setName(String value);

	java.util.List<A> getInBs();

	java.util.List<A> getInB();

	@Override
	public B registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public B unregisterListener(de.haumacher.msgbuf.observer.Listener l);


	/** Reads a new instance from the given reader. */
	static B readB(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.references.data.B_Impl result = new test.references.data.B_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static B readB(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		B result = test.references.data.B_Impl.readB_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link B} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static B readB(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.references.data.B_Impl.readB_XmlContent(in);
	}

}
