package test.nothing;

/**
 * An abstract base class for all shapes
 */
public abstract class Shape {

	private int _xCoordinate = 0;

	private int _yCoordinate = 0;

	/**
	 * Creates a {@link Shape} instance.
	 */
	protected Shape() {
		super();
	}

	/**
	 * X coordinate of the origin of the coordinate system of this {@link Shape}.
	 */
	public final int getXCoordinate() {
		return _xCoordinate;
	}

	/**
	 * @see #getXCoordinate()
	 */
	public Shape setXCoordinate(int value) {
		internalSetXCoordinate(value);
		return this;
	}
	/** Internal setter for {@link #getXCoordinate()} without chain call utility. */
	protected final void internalSetXCoordinate(int value) {
		_xCoordinate = value;
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
	public Shape setYCoordinate(int value) {
		internalSetYCoordinate(value);
		return this;
	}
	/** Internal setter for {@link #getYCoordinate()} without chain call utility. */
	protected final void internalSetYCoordinate(int value) {
		_yCoordinate = value;
	}


}
