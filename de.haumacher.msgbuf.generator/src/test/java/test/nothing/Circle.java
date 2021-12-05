package test.nothing;

/**
 * A circle {@link Shape}.
 */
public class Circle extends AtomicShape<Circle> {

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

	@Override
	protected final Circle self() {
		return this;
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
	public final Circle setRadius(int value) {
		_radius = value;
		return self();
	}

}
