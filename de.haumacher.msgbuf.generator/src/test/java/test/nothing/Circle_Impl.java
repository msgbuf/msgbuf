package test.nothing;

/**
 * A circle {@link Shape}.
 */
class Circle_Impl extends AtomicShape_Impl implements Circle {

	private int _radius = 0;

	/**
	 * Creates a {@link Circle_Impl} instance.
	 *
	 * @see Circle#create()
	 */
	protected Circle_Impl() {
		super();
	}

	@Override
	public final int getRadius() {
		return _radius;
	}

	@Override
	public Circle setRadius(int value) {
		internalSetRadius(value);
		return this;
	}

	/** Internal setter for {@link #getRadius()} without chain call utility. */
	protected final void internalSetRadius(int value) {
		_radius = value;
	}

	@Override
	public Circle setXCoordinate(int value) {
		internalSetXCoordinate(value);
		return this;
	}

	@Override
	public Circle setYCoordinate(int value) {
		internalSetYCoordinate(value);
		return this;
	}

}
