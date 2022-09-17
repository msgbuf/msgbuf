package test.nothing;

/**
 * An abstract base class for all shapes
 */
abstract class Shape_Impl implements Shape {

	private int _xCoordinate = 0;

	private int _yCoordinate = 0;

	/**
	 * Creates a {@link Shape_Impl} instance.
	 */
	protected Shape_Impl() {
		super();
	}

	@Override
	public final int getXCoordinate() {
		return _xCoordinate;
	}

	@Override
	public Shape setXCoordinate(int value) {
		internalSetXCoordinate(value);
		return this;
	}

	/** Internal setter for {@link #getXCoordinate()} without chain call utility. */
	protected final void internalSetXCoordinate(int value) {
		_xCoordinate = value;
	}

	@Override
	public final int getYCoordinate() {
		return _yCoordinate;
	}

	@Override
	public Shape setYCoordinate(int value) {
		internalSetYCoordinate(value);
		return this;
	}

	/** Internal setter for {@link #getYCoordinate()} without chain call utility. */
	protected final void internalSetYCoordinate(int value) {
		_yCoordinate = value;
	}

}
