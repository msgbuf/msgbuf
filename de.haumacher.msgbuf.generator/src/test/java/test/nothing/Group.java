package test.nothing;

/**
 * A group of shapes.
 */
public class Group extends Shape {

	/**
	 * Creates a {@link Group} instance.
	 */
	public static Group create() {
		return new Group();
	}

	private final java.util.List<Shape> _shapes = new java.util.ArrayList<>();

	/**
	 * Creates a {@link Group} instance.
	 *
	 * @see #create()
	 */
	protected Group() {
		super();
	}

	/**
	 * All {@link Shape}s in this {@link Group}.
	 *
	 * <p>
	 * The origins of these {@link Shape}s get a coordinate offset of ({@link #getXCoordinate()}, {@link #getYCoordinate()}).
	 * </p>
	 */
	public final java.util.List<Shape> getShapes() {
		return _shapes;
	}

	/**
	 * @see #getShapes()
	 */
	public final Group setShapes(java.util.List<Shape> value) {
		if (value == null) throw new IllegalArgumentException("Property 'shapes' cannot be null.");
		_shapes.clear();
		_shapes.addAll(value);
		return this;
	}

	/**
	 * Adds a value to the {@link #getShapes()} list.
	 */
	public final Group addShape(Shape value) {
		_shapes.add(value);
		return this;
	}

}
