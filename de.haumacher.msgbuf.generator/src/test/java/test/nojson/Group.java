package test.nojson;

/**
 * A group of shapes.
 */
public interface Group extends Shape {

	/**
	 * Creates a {@link test.nojson.Group} instance.
	 */
	static test.nojson.Group create() {
		return new test.nojson.impl.Group_Impl();
	}

	/** Identifier for the {@link test.nojson.Group} type in JSON format. */
	String GROUP__TYPE = "Group";

	/** @see #getShapes() */
	String SHAPES__PROP = "shapes";

	/** Identifier for the {@link test.nojson.Group} type in binary format. */
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
	java.util.List<test.nojson.Shape> getShapes();

	/**
	 * @see #getShapes()
	 */
	test.nojson.Group setShapes(java.util.List<? extends test.nojson.Shape> value);

	/**
	 * Adds a value to the {@link #getShapes()} list.
	 */
	test.nojson.Group addShape(test.nojson.Shape value);

	/**
	 * Removes a value from the {@link #getShapes()} list.
	 */
	void removeShape(test.nojson.Shape value);

	@Override
	test.nojson.Group setXCoordinate(int value);

	@Override
	test.nojson.Group setYCoordinate(int value);

	/** Reads a new instance from the given reader. */
	static test.nojson.Group readGroup(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.nojson.Group result = test.nojson.impl.Group_Impl.readGroup_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link Group} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Group readGroup(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.nojson.impl.Group_Impl.readGroup_XmlContent(in);
	}

}
