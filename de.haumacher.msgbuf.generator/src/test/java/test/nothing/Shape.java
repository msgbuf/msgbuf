package test.nothing;

/**
 * An abstract base class for all shapes
 */
public abstract class Shape<S extends Shape<S>> {

	private int _xCoordinate = 0;

	private int _yCoordinate = 0;

	/**
	 * Creates a {@link Shape} instance.
	 */
	protected Shape() {
		super();
	}

	/** This instance with the concrete type. */
	protected abstract S self();

	/**
	 * X coordinate of the origin of the coordinate system of this {@link Shape}.
	 */
	public final int getXCoordinate() {
		return _xCoordinate;
	}

	/**
	 * @see #getXCoordinate()
	 */
	public final S setXCoordinate(int value) {
		_xCoordinate = value;
		return self();
	}

	/**
	 * Y coordinate of the origin of the coordinate system of this {@link Shape}.
	 */
	public final int getYCoordinate() {
		return _yCoordinate;
	}

	/**
	 * @see #getYCoordinate()
	 */
	public final S setYCoordinate(int value) {
		_yCoordinate = value;
		return self();
	}

}
