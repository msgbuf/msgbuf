package test.hierarchy;

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
	public final void addShape(Shape value) {
		_shapes.add(value);
	}

	/** Reads a new instance from the given reader. */
	public static Group readGroup(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		Group result = new Group();
		result.readContent(in);
		return result;
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
	protected void writeContent(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeContent(out);
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
