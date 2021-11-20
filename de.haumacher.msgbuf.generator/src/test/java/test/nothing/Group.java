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

	/** @see #getShapes() */
	public static final String SHAPES = "shapes";

	private final java.util.List<Shape> _shapes = new de.haumacher.msgbuf.util.ReferenceList<Shape>() {
		@Override
		protected void beforeAdd(int index, Shape element) {
			_listener.beforeAdd(test.nothing.Group.this, SHAPES, index, element);
		}

		@Override
		protected void afterRemove(int index, Shape element) {
			_listener.afterRemove(test.nothing.Group.this, SHAPES, index, element);
		}
	};

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

	/**
	 * Removes a value from the {@link #getShapes()} list.
	 */
	public final Group removeShape(Shape value) {
		_shapes.remove(value);
		return this;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			SHAPES));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case SHAPES: return getShapes();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case SHAPES: setShapes((java.util.List<Shape>) value); break;
			default: super.set(field, value); break;
		}
	}

}
