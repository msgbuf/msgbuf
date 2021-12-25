package test.nothing;

/**
 * A circle {@link Shape}.
 */
public class Circle extends AtomicShape {

	/**
	 * Creates a {@link Circle} instance.
	 */
	public static Circle create() {
		return new Circle();
	}

	private int _radius = 0;

	/**
	 * Creates a {@link Circle} instance.
	 *
	 * @see #create()
	 */
	protected Circle() {
		super();
	}

	/**
	 * The radius of this {@link Circle} around its coordinate origin at ({@link #getXCoordinate()}, {@link #getYCoordinate()}).
	 */
	public final int getRadius() {
		return _radius;
	}

	/**
	 * @see #getRadius()
	 */
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
