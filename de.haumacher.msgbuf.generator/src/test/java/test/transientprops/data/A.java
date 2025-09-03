package test.transientprops.data;

public interface A extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/** Type codes for the {@link test.transientprops.data.A} hierarchy. */
	public enum TypeKind {

		/** Type literal for {@link test.transientprops.data.A}. */
		A,

		/** Type literal for {@link test.transientprops.data.B}. */
		B,

		/** Type literal for {@link test.transientprops.data.C}. */
		C,
		;

	}

	/**
	 * Creates a {@link test.transientprops.data.A} instance.
	 */
	static test.transientprops.data.A create() {
		return new test.transientprops.data.impl.A_Impl();
	}

	/** Identifier for the {@link test.transientprops.data.A} type in JSON format. */
	String A__TYPE = "A";

	/** @see #getX1() */
	String X_1__PROP = "x1";

	/** @see #getX2() */
	String X_2__PROP = "x2";

	/** Identifier for the property {@link #getX1()} in binary format. */
	static final int X_1__ID = 1;

	/** The type code of this instance. */
	TypeKind kind();

	String getX1();

	/**
	 * @see #getX1()
	 */
	test.transientprops.data.A setX1(String value);

	String getX2();

	/**
	 * @see #getX2()
	 */
	test.transientprops.data.A setX2(String value);

	@Override
	public test.transientprops.data.A registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.transientprops.data.A unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.transientprops.data.A readA(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.transientprops.data.impl.A_Impl result = new test.transientprops.data.impl.A_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.transientprops.data.A readA(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.transientprops.data.A result = test.transientprops.data.impl.A_Impl.readA_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link A} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static A readA(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.transientprops.data.impl.A_Impl.readA_XmlContent(in);
	}

}
