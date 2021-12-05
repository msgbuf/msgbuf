package test.graph.data;

/**
 * A group of shapes.
 */
public class Group extends Shape<Group> {

	/**
	 * Creates a {@link Group} instance.
	 */
	public static Group create() {
		return new Group();
	}

	/** Identifier for the {@link Group} type in JSON format. */
	public static final String GROUP__TYPE = "Group";

	/** @see #getShapes() */
	public static final String SHAPES = "shapes";

	private final java.util.List<Shape<?>> _shapes = new de.haumacher.msgbuf.util.ReferenceList<Shape<?>>() {
		@Override
		protected void beforeAdd(int index, Shape<?> element) {
			_listener.beforeAdd(test.graph.data.Group.this, SHAPES, index, element);
		}

		@Override
		protected void afterRemove(int index, Shape<?> element) {
			_listener.afterRemove(test.graph.data.Group.this, SHAPES, index, element);
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

	@Override
	protected Group self() {
		return this;
	}

	@Override
	public TypeKind kind() {
		return TypeKind.GROUP;
	}

	/**
	 * All {@link Shape}s in this {@link Group}.
	 *
	 * <p>
	 * The origins of these {@link Shape}s get a coordinate offset of ({@link #getXCoordinate()}, {@link #getYCoordinate()}).
	 * </p>
	 */
	public final java.util.List<Shape<?>> getShapes() {
		return _shapes;
	}

	/**
	 * @see #getShapes()
	 */
	public final Group setShapes(java.util.List<Shape<?>> value) {
		if (value == null) throw new IllegalArgumentException("Property 'shapes' cannot be null.");
		_shapes.clear();
		_shapes.addAll(value);
		return self();
	}

	/**
	 * Adds a value to the {@link #getShapes()} list.
	 */
	public final Group addShape(Shape<?> value) {
		_shapes.add(value);
		return self();
	}

	/**
	 * Removes a value from the {@link #getShapes()} list.
	 */
	public final Group removeShape(Shape<?> value) {
		_shapes.remove(value);
		return self();
	}

	@Override
	public String jsonType() {
		return GROUP__TYPE;
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
			case SHAPES: setShapes((java.util.List<Shape<?>>) value); break;
			default: super.set(field, value); break;
		}
	}

	/** Reads a new instance from the given reader. */
	public static Group readGroup(de.haumacher.msgbuf.graph.Scope scope, de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		if (in.peek() == de.haumacher.msgbuf.json.JsonToken.NUMBER) {
			return (Group) scope.resolveOrFail(in.nextInt());
		}
		in.beginArray();
		String type = in.nextString();
		assert GROUP__TYPE.equals(type);
		int id = in.nextInt();
		Group result = new Group();
		scope.readData(result, id, in);
		in.endArray();
		return result;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.graph.Scope scope, de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(scope, out);
		out.name(SHAPES);
		out.beginArray();
		for (Shape<?> x : getShapes()) {
			x.writeTo(scope, out);
		}
		out.endArray();
	}

	@Override
	public void writeFieldValue(de.haumacher.msgbuf.graph.Scope scope, de.haumacher.msgbuf.json.JsonWriter out, String field) throws java.io.IOException {
		switch (field) {
			case SHAPES: {
				out.beginArray();
				for (Shape<?> x : getShapes()) {
					x.writeTo(scope, out);
				}
				out.endArray();
				break;
			}
			default: super.writeFieldValue(scope, out, field);
		}
	}

	@Override
	public void readField(de.haumacher.msgbuf.graph.Scope scope, de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case SHAPES: {
				in.beginArray();
				while (in.hasNext()) {
					addShape(test.graph.data.Shape.readShape(scope, in));
				}
				in.endArray();
			}
			break;
			default: super.readField(scope, in, field);
		}
	}

	@Override
	public void writeElement(de.haumacher.msgbuf.graph.Scope scope, de.haumacher.msgbuf.json.JsonWriter out, String field, Object element) throws java.io.IOException {
		switch (field) {
			case SHAPES: {
				((Shape<?>) element).writeTo(scope, out);
				break;
			}
			default: super.writeElement(scope, out, field, element);
		}
	}

	@Override
	public Object readElement(de.haumacher.msgbuf.graph.Scope scope, de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case SHAPES: {
				return test.graph.data.Shape.readShape(scope, in);
			}
			default: return super.readElement(scope, in, field);
		}
	}

	@Override
	public <R,A,E extends Throwable> R visit(Shape.Visitor<R,A,E> v, A arg) throws E {
		return v.visit(this, arg);
	}

}
