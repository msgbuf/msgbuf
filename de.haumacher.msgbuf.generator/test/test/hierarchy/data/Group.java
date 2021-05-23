package test.hierarchy.data;

/**
 * A group of shapes.
 */
public class Group extends Shape {

	/**
	 * Creates a {@link Group} instance.
	 */
	public static Group group() {
		return new Group();
	}

	/**
	 * Creates a {@link Group} instance.
	 *
	 * @see #group()
	 */
	protected Group() {
		super();
	}

	private final java.util.List<Shape> _shapes = new java.util.ArrayList<>();

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

	/** Reads a new instance from the given reader. */
	public static Group readGroup(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		Group result = new Group();
		in.beginObject();
		result.readFields(in);
		in.endObject();
		return result;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(0);
		java.util.List<Shape> values = getShapes();
		out.beginArray(de.haumacher.msgbuf.binary.DataType.OBJECT, values.size());
		for (Shape x : values) {
			x.writeTo(out);
		}
		out.endArray();
	}

	@Override
	protected String jsonType() {
		return "Group";
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case "shapes": return getShapes();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case "shapes": setShapes((java.util.List<Shape>) value); break;
			default: super.set(field, value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name("shapes");
		out.beginArray();
		for (Shape x : getShapes()) {
			x.writeTo(out);
		}
		out.endArray();
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case "shapes": {
				in.beginArray();
				while (in.hasNext()) {
					addShape(Shape.readShape(in));
				}
				in.endArray();
			}
			break;
			default: super.readField(in, field);
		}
	}

	@Override
	public <R,A> R visit(Shape.Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}

}
