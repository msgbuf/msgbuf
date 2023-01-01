package test.nolistener;

/**
 * A group of shapes.
 */
public interface Group extends Shape {

	/**
	 * Creates a {@link test.nolistener.Group} instance.
	 */
	static test.nolistener.Group create() {
		return new test.nolistener.impl.Group_Impl();
	}

	/** Identifier for the {@link test.nolistener.Group} type in JSON format. */
	static final String GROUP__TYPE = "Group";

	/** @see #getShapes() */
	static final String SHAPES__PROP = "shapes";

	/** Identifier for the {@link test.nolistener.Group} type in binary format. */
	static final int GROUP__TYPE_ID = 3;

	/** Identifier for the property {@link #getShapes()} in binary format. */
	static final int SHAPES__ID = 3;

	/**
	 * All {@link Shape}s in this {@link Group}.
	 *
	 * <p>
	 * The origins of these {@link Shape}s get a coordinate offset of ({@link #getXCoordinate()}, {@link #getYCoordinate()}).
	 * </p>
	 */
	java.util.List<test.nolistener.Shape> getShapes();

	/**
	 * @see #getShapes()
	 */
	test.nolistener.Group setShapes(java.util.List<? extends test.nolistener.Shape> value);

	/**
	 * Adds a value to the {@link #getShapes()} list.
	 */
	test.nolistener.Group addShape(test.nolistener.Shape value);

	/**
	 * Removes a value from the {@link #getShapes()} list.
	 */
	void removeShape(test.nolistener.Shape value);

	@Override
	test.nolistener.Group setXCoordinate(int value);

	@Override
	test.nolistener.Group setYCoordinate(int value);

	/** Reads a new instance from the given reader. */
	static test.nolistener.Group readGroup(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.nolistener.impl.Group_Impl result = new test.nolistener.impl.Group_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.nolistener.Group readGroup(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.nolistener.Group result = test.nolistener.impl.Group_Impl.readGroup_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link Group} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Group readGroup(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.nolistener.impl.Group_Impl.readGroup_XmlContent(in);
	}

}
