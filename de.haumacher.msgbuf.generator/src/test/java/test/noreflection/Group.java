package test.noreflection;

/**
 * A group of shapes.
 */
public class Group extends Shape {

	/**
	 * Creates a {@link Group} instance.
	 */
	public static Group create() {
		return new test.noreflection.Group();
	}

	/** Identifier for the {@link Group} type in JSON format. */
	public static final String GROUP__TYPE = "Group";

	/** @see #getShapes() */
	private static final String SHAPES__PROP = "shapes";

	private final java.util.List<Shape> _shapes = new java.util.ArrayList<>();

	/**
	 * Creates a {@link Group} instance.
	 *
	 * @see Group#create()
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
	public Group setShapes(java.util.List<? extends Shape> value) {
		internalSetShapes(value);
		return this;
	}

	/** Internal setter for {@link #getShapes()} without chain call utility. */
	protected final void internalSetShapes(java.util.List<? extends Shape> value) {
		if (value == null) throw new IllegalArgumentException("Property 'shapes' cannot be null.");
		_shapes.clear();
		_shapes.addAll(value);
	}

	/**
	 * Adds a value to the {@link #getShapes()} list.
	 */
	public Group addShape(Shape value) {
		internalAddShape(value);
		return this;
	}

	/** Implementation of {@link #addShape(Shape)} without chain call utility. */
	protected final void internalAddShape(Shape value) {
		_shapes.add(value);
	}

	/**
	 * Removes a value from the {@link #getShapes()} list.
	 */
	public final void removeShape(Shape value) {
		_shapes.remove(value);
	}

	@Override
	public Group setXCoordinate(int value) {
		internalSetXCoordinate(value);
		return this;
	}

	@Override
	public Group setYCoordinate(int value) {
		internalSetYCoordinate(value);
		return this;
	}

	@Override
	public String jsonType() {
		return GROUP__TYPE;
	}

	/** Reads a new instance from the given reader. */
	public static Group readGroup(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.noreflection.Group result = new test.noreflection.Group();
		result.readContent(in);
		return result;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(SHAPES__PROP);
		out.beginArray();
		for (Shape x : getShapes()) {
			x.writeTo(out);
		}
		out.endArray();
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case SHAPES__PROP: {
				in.beginArray();
				while (in.hasNext()) {
					addShape(test.noreflection.Shape.readShape(in));
				}
				in.endArray();
			}
			break;
			default: super.readField(in, field);
		}
	}

	@Override
	public <R,A,E extends Throwable> R visit(Shape.Visitor<R,A,E> v, A arg) throws E {
		return v.visit(this, arg);
	}

}
