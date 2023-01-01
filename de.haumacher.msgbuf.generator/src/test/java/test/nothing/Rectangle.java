package test.nothing;

/**
 * A rectangle.
 */
public interface Rectangle extends AtomicShape {

	/**
	 * Creates a {@link test.nothing.Rectangle} instance.
	 */
	static test.nothing.Rectangle create() {
		return new test.nothing.impl.Rectangle_Impl();
	}

	/**
	 * The width of this {@link Rectangle}.
	 *
	 * <p>
	 * The top left corner of this {@Rectangle} is at ({@link #getXCoordinate()}, {@link #getYCoordinate()}).
	 * </p>
	 *
	 * @see #getHeight()
	 */
	int getWidth();

	/**
	 * @see #getWidth()
	 */
	test.nothing.Rectangle setWidth(int value);

	/**
	 * The width of this {@link Rectangle}.
	 *
	 * @see #getWidth()
	 */
	int getHeight();

	/**
	 * @see #getHeight()
	 */
	test.nothing.Rectangle setHeight(int value);

	@Override
	test.nothing.Rectangle setXCoordinate(int value);

	@Override
	test.nothing.Rectangle setYCoordinate(int value);

}
