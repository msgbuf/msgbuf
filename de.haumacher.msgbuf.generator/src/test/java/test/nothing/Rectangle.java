package test.nothing;

/**
 * A rectangle.
 */
public interface Rectangle extends AtomicShape {

	/**
	 * Creates a {@link Rectangle} instance.
	 */
	static Rectangle create() {
		return new test.nothing.Rectangle_Impl();
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
	Rectangle setWidth(int value);

	/**
	 * The width of this {@link Rectangle}.
	 *
	 * @see #getWidth()
	 */
	int getHeight();

	/**
	 * @see #getHeight()
	 */
	Rectangle setHeight(int value);

	@Override
	Rectangle setXCoordinate(int value);

	@Override
	Rectangle setYCoordinate(int value);

}
