package test.onlyxml.data;

/**
 * A group of shapes.
 */
public interface Group extends Shape {

	/**
	 * Creates a {@link Group} instance.
	 */
	static Group create() {
		return new test.onlyxml.data.Group_Impl();
	}

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

	/** Creates a new {@link Group} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Group readGroup(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.onlyxml.data.Group_Impl.readGroup_XmlContent(in);
	}

}
