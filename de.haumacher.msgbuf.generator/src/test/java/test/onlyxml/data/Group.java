package test.onlyxml.data;

/**
 * A group of shapes.
 */
public interface Group extends Shape {

	/**
	 * Creates a {@link test.onlyxml.data.Group} instance.
	 */
	static test.onlyxml.data.Group create() {
		return new test.onlyxml.data.impl.Group_Impl();
	}

	/**
	 * All {@link Shape}s in this {@link Group}.
	 *
	 * <p>
	 * The origins of these {@link Shape}s get a coordinate offset of ({@link #getXCoordinate()}, {@link #getYCoordinate()}).
	 * </p>
	 */
	java.util.List<test.onlyxml.data.Shape> getShapes();

	/**
	 * @see #getShapes()
	 */
	test.onlyxml.data.Group setShapes(java.util.List<? extends test.onlyxml.data.Shape> value);

	/**
	 * Adds a value to the {@link #getShapes()} list.
	 */
	test.onlyxml.data.Group addShape(test.onlyxml.data.Shape value);

	/**
	 * Removes a value from the {@link #getShapes()} list.
	 */
	void removeShape(test.onlyxml.data.Shape value);

	@Override
	test.onlyxml.data.Group setXCoordinate(int value);

	@Override
	test.onlyxml.data.Group setYCoordinate(int value);

	/** Creates a new {@link Group} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Group readGroup(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.onlyxml.data.impl.Group_Impl.readGroup_XmlContent(in);
	}

}
