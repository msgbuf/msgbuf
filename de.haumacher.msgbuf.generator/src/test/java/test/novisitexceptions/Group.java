package test.novisitexceptions;

/**
 * A group of shapes.
 */
public interface Group extends Shape {

	/**
	 * Creates a {@link Group} instance.
	 */
	static Group create() {
		return new test.novisitexceptions.Group_Impl();
	}

	/** Identifier for the {@link Group} type in JSON format. */
	static final String GROUP__TYPE = "Group";

	/** @see #getShapes() */
	static final String SHAPES = "shapes";

	/** Identifier for the {@link Group} type in binary format. */
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
	java.util.List<Shape> getShapes();

	/**
	 * @see #getShapes()
	 */
	Group setShapes(java.util.List<? extends Shape> value);

	/**
	 * Adds a value to the {@link #getShapes()} list.
	 */
	Group addShape(Shape value);

	/**
	 * Removes a value from the {@link #getShapes()} list.
	 */
	void removeShape(Shape value);

	@Override
	Group setXCoordinate(int value);

	@Override
	Group setYCoordinate(int value);


	/** Reads a new instance from the given reader. */
	static Group readGroup(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.novisitexceptions.Group_Impl result = new test.novisitexceptions.Group_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static Group readGroup(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		Group result = test.novisitexceptions.Group_Impl.readGroup_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link Group} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Group readGroup(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.novisitexceptions.Group_Impl.readGroup_XmlContent(in);
	}

}
