package test.nothing;

/**
 * A circle {@link Shape}.
 */
public interface Circle extends AtomicShape {

	/**
	 * Creates a {@link Circle} instance.
	 */
	static Circle create() {
		return new test.nothing.Circle_Impl();
	}

	/**
	 * The radius of this {@link Circle} around its coordinate origin at ({@link #getXCoordinate()}, {@link #getYCoordinate()}).
	 */
	int getRadius();

	/**
	 * @see #getRadius()
	 */
	Circle setRadius(int value);

	@Override
	Circle setXCoordinate(int value);

	@Override
	Circle setYCoordinate(int value);

}
