package test.nothing;

/**
 * A circle {@link Shape}.
 */
public interface Circle extends AtomicShape {

	/**
	 * Creates a {@link test.nothing.Circle} instance.
	 */
	static test.nothing.Circle create() {
		return new test.nothing.impl.Circle_Impl();
	}

	/**
	 * The radius of this {@link Circle} around its coordinate origin at ({@link #getXCoordinate()}, {@link #getYCoordinate()}).
	 */
	int getRadius();

	/**
	 * @see #getRadius()
	 */
	test.nothing.Circle setRadius(int value);

	@Override
	test.nothing.Circle setXCoordinate(int value);

	@Override
	test.nothing.Circle setYCoordinate(int value);

}
