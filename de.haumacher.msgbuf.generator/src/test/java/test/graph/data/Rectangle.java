package test.graph.data;

/**
 * A rectangle.
 */
public class Rectangle extends AtomicShape {

	/**
	 * Creates a {@link Rectangle} instance.
	 */
	public static Rectangle create() {
		return new Rectangle();
	}

	/** Identifier for the {@link Rectangle} type in JSON format. */
	public static final String RECTANGLE__TYPE = "Rectangle";

	/** @see #getWidth() */
	public static final String WIDTH = "w";

	/** @see #getHeight() */
	public static final String HEIGHT = "h";

	private int _width = 0;

	private int _height = 0;

	/**
	 * Creates a {@link Rectangle} instance.
	 *
	 * @see #create()
	 */
	protected Rectangle() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.RECTANGLE;
	}

	/**
	 * The width of this {@link Rectangle}.
	 *
	 * <p>
	 * The top left corner of this {@Rectangle} is at ({@link #getXCoordinate()}, {@link #getYCoordinate()}).
	 * </p>
	 *
	 * @see #getHeight()
	 */
	public final int getWidth() {
		return _width;
	}

	/**
	 * @see #getWidth()
	 */
	public final Rectangle setWidth(int value) {
		_listener.beforeSet(this, WIDTH, value);
		_width = value;
		return this;
	}

	/**
	 * The width of this {@link Rectangle}.
	 *
	 * @see #getWidth()
	 */
	public final int getHeight() {
		return _height;
	}

	/**
	 * @see #getHeight()
	 */
	public final Rectangle setHeight(int value) {
		_listener.beforeSet(this, HEIGHT, value);
		_height = value;
		return this;
	}

	@Override
	public String jsonType() {
		return RECTANGLE__TYPE;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			WIDTH, 
			HEIGHT));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case WIDTH: return getWidth();
			case HEIGHT: return getHeight();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case WIDTH: setWidth((int) value); break;
			case HEIGHT: setHeight((int) value); break;
			default: super.set(field, value); break;
		}
	}

	/** Reads a new instance from the given reader. */
	public static Rectangle readRectangle(de.haumacher.msgbuf.graph.Scope scope, de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		if (in.peek() == de.haumacher.msgbuf.json.JsonToken.NUMBER) {
			return (Rectangle) scope.resolveOrFail(in.nextInt());
		}
		in.beginArray();
		String type = in.nextString();
		assert RECTANGLE__TYPE.equals(type);
		int id = in.nextInt();
		Rectangle result = new Rectangle();
		scope.enter(result, id);
		in.beginObject();
		result.readFields(scope, in);
		in.endObject();
		in.endArray();
		return result;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.graph.Scope scope, de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(scope, out);
		out.name(WIDTH);
		out.value(getWidth());
		out.name(HEIGHT);
		out.value(getHeight());
	}

	@Override
	public void writeFieldValue(de.haumacher.msgbuf.graph.Scope scope, de.haumacher.msgbuf.json.JsonWriter out, String field) throws java.io.IOException {
		switch (field) {
			case WIDTH: {
				out.value(getWidth());
				break;
			}
			case HEIGHT: {
				out.value(getHeight());
				break;
			}
			default: super.writeFieldValue(scope, out, field);
		}
	}

	@Override
	public void readField(de.haumacher.msgbuf.graph.Scope scope, de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case WIDTH: setWidth(in.nextInt()); break;
			case HEIGHT: setHeight(in.nextInt()); break;
			default: super.readField(scope, in, field);
		}
	}

	@Override
	public <R,A,E extends Throwable> R visit(AtomicShape.Visitor<R,A,E> v, A arg) throws E {
		return v.visit(this, arg);
	}

}
