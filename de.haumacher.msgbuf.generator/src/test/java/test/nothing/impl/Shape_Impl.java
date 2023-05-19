package test.nothing.impl;

/**
 * Implementation of {@link test.nothing.Shape}.
 */
public abstract class Shape_Impl implements test.nothing.Shape {

	private int _xCoordinate = 0;

	private int _yCoordinate = 0;

	/**
	 * Creates a {@link Shape_Impl} instance.
	 */
	public Shape_Impl() {
		super();
	}

	@Override
	public final int getXCoordinate() {
		return _xCoordinate;
	}

	@Override
	public test.nothing.Shape setXCoordinate(int value) {
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
	public test.nothing.Shape setYCoordinate(int value) {
		internalSetYCoordinate(value);
		return this;
	}

	/** Internal setter for {@link #getYCoordinate()} without chain call utility. */
	protected final void internalSetYCoordinate(int value) {
		_yCoordinate = value;
	}

}
