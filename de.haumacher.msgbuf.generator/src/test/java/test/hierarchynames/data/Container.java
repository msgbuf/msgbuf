package test.hierarchynames.data;

public interface Container extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/**
	 * Creates a {@link test.hierarchynames.data.Container} instance.
	 */
	static test.hierarchynames.data.Container create() {
		return new test.hierarchynames.data.impl.Container_Impl();
	}

	/** Identifier for the {@link test.hierarchynames.data.Container} type in JSON format. */
	String CONTAINER__TYPE = "Container";

	/** @see #getMsg() */
	String MSG__PROP = "msg";

	/** @see #getShape() */
	String SHAPE__PROP = "shape";

	/** Identifier for the property {@link #getMsg()} in binary format. */
	static final int MSG__ID = 1;

	/** Identifier for the property {@link #getShape()} in binary format. */
	static final int SHAPE__ID = 2;

	test.hierarchynames.data.Msg getMsg();

	/**
	 * @see #getMsg()
	 */
	test.hierarchynames.data.Container setMsg(test.hierarchynames.data.Msg value);

	/**
	 * Checks, whether {@link #getMsg()} has a value.
	 */
	boolean hasMsg();

	test.hierarchynames.data.Outer.Shape getShape();

	/**
	 * @see #getShape()
	 */
	test.hierarchynames.data.Container setShape(test.hierarchynames.data.Outer.Shape value);

	/**
	 * Checks, whether {@link #getShape()} has a value.
	 */
	boolean hasShape();

	@Override
	public test.hierarchynames.data.Container registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.hierarchynames.data.Container unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.hierarchynames.data.Container readContainer(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.hierarchynames.data.impl.Container_Impl result = new test.hierarchynames.data.impl.Container_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.hierarchynames.data.Container readContainer(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.hierarchynames.data.Container result = test.hierarchynames.data.impl.Container_Impl.readContainer_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link Container} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Container readContainer(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.hierarchynames.data.impl.Container_Impl.readContainer_XmlContent(in);
	}

}
