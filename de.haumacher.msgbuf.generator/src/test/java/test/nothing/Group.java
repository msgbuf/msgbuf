package test.nothing;

/**
 * A group of shapes.
 */
public interface Group extends Shape {

	/**
	 * Creates a {@link Group} instance.
	 */
	static Group create() {
		return new test.nothing.Group_Impl();
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

}
