package test.references.data;

public interface A extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/**
	 * Creates a {@link test.references.data.A} instance.
	 */
	static test.references.data.A create() {
		return new test.references.data.impl.A_Impl();
	}

	/** Identifier for the {@link test.references.data.A} type in JSON format. */
	String A__TYPE = "A";

	/** @see #getName() */
	String NAME__PROP = "name";

	/** @see #getContents() */
	String CONTENTS__PROP = "contents";

	/** @see #getChildren() */
	String CHILDREN__PROP = "children";

	/** @see #getBs() */
	String BS__PROP = "bs";

	/** @see #getB() */
	String B__PROP = "b";

	/** @see #getOther() */
	String OTHER__PROP = "other";

	/** @see #getOthers() */
	String OTHERS__PROP = "others";

	/** @see #getInOther() */
	String IN_OTHER__PROP = "inOther";

	/** @see #getInOthers() */
	String IN_OTHERS__PROP = "inOthers";

	/** Identifier for the property {@link #getName()} in binary format. */
	static final int NAME__ID = 1;

	/** Identifier for the property {@link #getContents()} in binary format. */
	static final int CONTENTS__ID = 2;

	/** Identifier for the property {@link #getChildren()} in binary format. */
	static final int CHILDREN__ID = 3;

	/** Identifier for the property {@link #getBs()} in binary format. */
	static final int BS__ID = 4;

	/** Identifier for the property {@link #getB()} in binary format. */
	static final int B__ID = 5;

	/** Identifier for the property {@link #getOther()} in binary format. */
	static final int OTHER__ID = 6;

	/** Identifier for the property {@link #getOthers()} in binary format. */
	static final int OTHERS__ID = 7;

	String getName();

	/**
	 * @see #getName()
	 */
	test.references.data.A setName(String value);

	test.references.data.A getContents();

	/**
	 * @see #getContents()
	 */
	test.references.data.A setContents(test.references.data.A value);

	/**
	 * Checks, whether {@link #getContents()} has a value.
	 */
	boolean hasContents();

	java.util.List<test.references.data.A> getChildren();

	/**
	 * @see #getChildren()
	 */
	test.references.data.A setChildren(java.util.List<? extends test.references.data.A> value);

	/**
	 * Adds a value to the {@link #getChildren()} list.
	 */
	test.references.data.A addChildren(test.references.data.A value);

	/**
	 * Removes a value from the {@link #getChildren()} list.
	 */
	void removeChildren(test.references.data.A value);

	java.util.List<test.references.data.B> getBs();

	/**
	 * @see #getBs()
	 */
	test.references.data.A setBs(java.util.List<? extends test.references.data.B> value);

	/**
	 * Adds a value to the {@link #getBs()} list.
	 */
	test.references.data.A addBs(test.references.data.B value);

	/**
	 * Removes a value from the {@link #getBs()} list.
	 */
	void removeBs(test.references.data.B value);

	test.references.data.B getB();

	/**
	 * @see #getB()
	 */
	test.references.data.A setB(test.references.data.B value);

	/**
	 * Checks, whether {@link #getB()} has a value.
	 */
	boolean hasB();

	test.references.data.A getOther();

	/**
	 * @see #getOther()
	 */
	test.references.data.A setOther(test.references.data.A value);

	/**
	 * Checks, whether {@link #getOther()} has a value.
	 */
	boolean hasOther();

	java.util.List<test.references.data.A> getOthers();

	/**
	 * @see #getOthers()
	 */
	test.references.data.A setOthers(java.util.List<? extends test.references.data.A> value);

	/**
	 * Adds a value to the {@link #getOthers()} list.
	 */
	test.references.data.A addOthers(test.references.data.A value);

	/**
	 * Removes a value from the {@link #getOthers()} list.
	 */
	void removeOthers(test.references.data.A value);

	java.util.List<test.references.data.A> getInOther();

	java.util.List<test.references.data.A> getInOthers();

	@Override
	public test.references.data.A registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.references.data.A unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.references.data.A readA(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.references.data.impl.A_Impl result = new test.references.data.impl.A_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.references.data.A readA(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.references.data.A result = test.references.data.impl.A_Impl.readA_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link A} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static A readA(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.references.data.impl.A_Impl.readA_XmlContent(in);
	}

}
