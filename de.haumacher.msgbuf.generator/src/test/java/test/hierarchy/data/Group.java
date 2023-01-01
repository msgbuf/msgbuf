package test.hierarchy.data;

/**
 * A group of shapes.
 */
public interface Group extends Shape {

	/**
	 * Creates a {@link test.hierarchy.data.Group} instance.
	 */
	static test.hierarchy.data.Group create() {
		return new test.hierarchy.data.impl.Group_Impl();
	}

	/** Identifier for the {@link test.hierarchy.data.Group} type in JSON format. */
	String GROUP__TYPE = "Group";

	/** @see #getShapes() */
	String SHAPES__PROP = "shapes";

	/** Identifier for the {@link test.hierarchy.data.Group} type in binary format. */
	static final int GROUP__TYPE_ID = 3;

	/** Identifier for the property {@link #getShapes()} in binary format. */
	static final int SHAPES__ID = 4;

	/**
	 * All {@link Shape}s in this {@link Group}.
	 *
	 * <p>
	 * The origins of these {@link Shape}s get a coordinate offset of ({@link #getXCoordinate()}, {@link #getYCoordinate()}).
	 * </p>
	 */
	java.util.List<test.hierarchy.data.Shape> getShapes();

	/**
	 * @see #getShapes()
	 */
	test.hierarchy.data.Group setShapes(java.util.List<? extends test.hierarchy.data.Shape> value);

	/**
	 * Adds a value to the {@link #getShapes()} list.
	 */
	test.hierarchy.data.Group addShape(test.hierarchy.data.Shape value);

	/**
	 * Removes a value from the {@link #getShapes()} list.
	 */
	void removeShape(test.hierarchy.data.Shape value);

	@Override
	test.hierarchy.data.Group setXCoordinate(int value);

	@Override
	test.hierarchy.data.Group setYCoordinate(int value);

	@Override
	test.hierarchy.data.Group setColor(test.hierarchy.data.Color value);

	/** Reads a new instance from the given reader. */
	static test.hierarchy.data.Group readGroup(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.hierarchy.data.impl.Group_Impl result = new test.hierarchy.data.impl.Group_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.hierarchy.data.Group readGroup(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.hierarchy.data.Group result = test.hierarchy.data.impl.Group_Impl.readGroup_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link Group} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Group readGroup(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.hierarchy.data.impl.Group_Impl.readGroup_XmlContent(in);
	}

}
