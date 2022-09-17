package test.nointerfaces;

/**
 * A group of shapes.
 */
public class Group extends Shape {

	/**
	 * Creates a {@link Group} instance.
	 */
	public static Group create() {
		return new test.nointerfaces.Group();
	}

	/** Identifier for the {@link Group} type in JSON format. */
	public static final String GROUP__TYPE = "Group";

	/** @see #getShapes() */
	public static final String SHAPES = "shapes";

	/** Identifier for the {@link Group} type in binary format. */
	static final int GROUP__TYPE_ID = 3;

	/** Identifier for the property {@link #getShapes()} in binary format. */
	static final int SHAPES__ID = 3;

	private final java.util.List<Shape> _shapes = new de.haumacher.msgbuf.util.ReferenceList<Shape>() {
		@Override
		protected void beforeAdd(int index, Shape element) {
			_listener.beforeAdd(Group.this, SHAPES, index, element);
		}

		@Override
		protected void afterRemove(int index, Shape element) {
			_listener.afterRemove(Group.this, SHAPES, index, element);
		}
	};

	/**
	 * Creates a {@link Group} instance.
	 *
	 * @see Group#create()
	 */
	protected Group() {
		super();
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
			case SHAPES: internalSetShapes(de.haumacher.msgbuf.util.Conversions.asList(Shape.class, value)); break;
			default: super.set(field, value); break;
		}
	}

	/** Reads a new instance from the given reader. */
	public static Group readGroup(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.nointerfaces.Group result = new test.nointerfaces.Group();
		result.readContent(in);
		return result;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(SHAPES);
		out.beginArray();
		for (Shape x : getShapes()) {
			x.writeTo(out);
		}
		out.endArray();
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case SHAPES: {
				in.beginArray();
				while (in.hasNext()) {
					addShape(test.nointerfaces.Shape.readShape(in));
				}
				in.endArray();
			}
			break;
			default: super.readField(in, field);
		}
	}

	/** The binary identifier for this concrete type in the polymorphic {@link Group} hierarchy. */
	public int typeId() {
		return GROUP__TYPE_ID;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(SHAPES__ID);
		{
			java.util.List<Shape> values = getShapes();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.OBJECT, values.size());
			for (Shape x : values) {
				x.writeTo(out);
			}
			out.endArray();
		}
	}

	/** Reads a new instance from the given reader. */
	public static Group readGroup(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		Group result = test.nointerfaces.Group.readGroup_Content(in);
		in.endObject();
		return result;
	}

	/** Helper for creating an object of type {@link Group} from a polymorphic composition. */
	public static Group readGroup_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.nointerfaces.Group result = new Group();
		result.readContent(in);
		return result;
	}

	@Override
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case SHAPES__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addShape(test.nointerfaces.Shape.readShape(in));
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
