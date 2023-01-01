package test.nothing.impl;

/**
 * A circle {@link Shape}.
 */
public class Circle_Impl extends test.nothing.impl.AtomicShape_Impl implements test.nothing.Circle {

	private int _radius = 0;

	/**
	 * Creates a {@link Circle_Impl} instance.
	 *
	 * @see test.nothing.Circle#create()
	 */
	public Circle_Impl() {
		super();
	}

	@Override
	public final int getRadius() {
		return _radius;
	}

	@Override
	public test.nothing.Circle setRadius(int value) {
		internalSetRadius(value);
		return this;
	}

	/** Internal setter for {@link #getRadius()} without chain call utility. */
	protected final void internalSetRadius(int value) {
		_radius = value;
	}

	@Override
	public test.nothing.Circle setXCoordinate(int value) {
		internalSetXCoordinate(value);
		return this;
	}

	@Override
	public test.nothing.Circle setYCoordinate(int value) {
		internalSetYCoordinate(value);
		return this;
	}

}
