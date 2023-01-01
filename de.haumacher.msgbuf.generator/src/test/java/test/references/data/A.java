package test.references.data;

public interface A extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/**
	 * Creates a {@link A} instance.
	 */
	static A create() {
		return new test.references.data.A_Impl();
	}

	/** Identifier for the {@link A} type in JSON format. */
	static final String A__TYPE = "A";

	/** @see #getName() */
	static final String NAME__PROP = "name";

	/** @see #getContents() */
	static final String CONTENTS__PROP = "contents";

	/** @see #getChildren() */
	static final String CHILDREN__PROP = "children";

	/** @see #getBs() */
	static final String BS__PROP = "bs";

	/** @see #getB() */
	static final String B__PROP = "b";

	/** @see #getOther() */
	static final String OTHER__PROP = "other";

	/** @see #getOthers() */
	static final String OTHERS__PROP = "others";

	/** @see #getInOther() */
	static final String IN_OTHER__PROP = "inOther";

	/** @see #getInOthers() */
	static final String IN_OTHERS__PROP = "inOthers";

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
	A setName(String value);

	A getContents();

	/**
	 * @see #getContents()
	 */
	A setContents(A value);

	/**
	 * Checks, whether {@link #getContents()} has a value.
	 */
	boolean hasContents();

	java.util.List<A> getChildren();

	/**
	 * @see #getChildren()
	 */
	A setChildren(java.util.List<? extends A> value);

	/**
	 * Adds a value to the {@link #getChildren()} list.
	 */
	A addChildren(A value);

	/**
	 * Removes a value from the {@link #getChildren()} list.
	 */
	void removeChildren(A value);

	java.util.List<B> getBs();

	/**
	 * @see #getBs()
	 */
	A setBs(java.util.List<? extends B> value);

	/**
	 * Adds a value to the {@link #getBs()} list.
	 */
	A addBs(B value);

	/**
	 * Removes a value from the {@link #getBs()} list.
	 */
	void removeBs(B value);

	B getB();

	/**
	 * @see #getB()
	 */
	A setB(B value);

	/**
	 * Checks, whether {@link #getB()} has a value.
	 */
	boolean hasB();

	A getOther();

	/**
	 * @see #getOther()
	 */
	A setOther(A value);

	/**
	 * Checks, whether {@link #getOther()} has a value.
	 */
	boolean hasOther();

	java.util.List<A> getOthers();

	/**
	 * @see #getOthers()
	 */
	A setOthers(java.util.List<? extends A> value);

	/**
	 * Adds a value to the {@link #getOthers()} list.
	 */
	A addOthers(A value);

	/**
	 * Removes a value from the {@link #getOthers()} list.
	 */
	void removeOthers(A value);

	java.util.List<A> getInOther();

	java.util.List<A> getInOthers();

	@Override
	public A registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public A unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static A readA(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.references.data.A_Impl result = new test.references.data.A_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static A readA(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		A result = test.references.data.A_Impl.readA_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link A} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static A readA(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.references.data.A_Impl.readA_XmlContent(in);
	}

}
