package test.nothing;

/**
 * A group of shapes.
 */
public interface Group extends Shape {

	/**
	 * Creates a {@link test.nothing.Group} instance.
	 */
	static test.nothing.Group create() {
		return new test.nothing.impl.Group_Impl();
	}

	/**
	 * All {@link Shape}s in this {@link Group}.
	 *
	 * <p>
	 * The origins of these {@link Shape}s get a coordinate offset of ({@link #getXCoordinate()}, {@link #getYCoordinate()}).
	 * </p>
	 */
	java.util.List<test.nothing.Shape> getShapes();

	/**
	 * @see #getShapes()
	 */
	test.nothing.Group setShapes(java.util.List<? extends test.nothing.Shape> value);

	/**
	 * Adds a value to the {@link #getShapes()} list.
	 */
	test.nothing.Group addShape(test.nothing.Shape value);

	/**
	 * Removes a value from the {@link #getShapes()} list.
	 */
	void removeShape(test.nothing.Shape value);

	@Override
	test.nothing.Group setXCoordinate(int value);

	@Override
	test.nothing.Group setYCoordinate(int value);

}
