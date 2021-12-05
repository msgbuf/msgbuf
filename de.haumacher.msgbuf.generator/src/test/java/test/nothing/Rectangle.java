package test.nothing;

/**
 * A rectangle.
 */
public class Rectangle extends AtomicShape<Rectangle> {

	/**
	 * Creates a {@link Rectangle} instance.
	 */
	public static Rectangle create() {
		return new Rectangle();
	}

	private int _width = 0;

	private int _height = 0;

	/**
	 * Creates a {@link Rectangle} instance.
	 *
	 * @see #create()
	 */
	protected Rectangle() {
		super();
	}

	@Override
	protected final Rectangle self() {
		return this;
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
	public final int getWidth() {
		return _width;
	}

	/**
	 * @see #getWidth()
	 */
	public final Rectangle setWidth(int value) {
		_width = value;
		return this;
	}

	/**
	 * The width of this {@link Rectangle}.
	 *
	 * @see #getWidth()
	 */
	public final int getHeight() {
		return _height;
	}

	/**
	 * @see #getHeight()
	 */
	public final Rectangle setHeight(int value) {
		_height = value;
		return this;
	}

}
