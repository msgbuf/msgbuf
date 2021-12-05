package test.noreflection;

/**
 * A rectangle.
 */
public class Rectangle extends AtomicShape<Rectangle> {

	/**
	 * Creates a {@link Rectangle} instance.
	 */
	public static Rectangle create() {
		return new Rectangle();
	}

	/** Identifier for the {@link Rectangle} type in JSON format. */
	public static final String RECTANGLE__TYPE = "Rectangle";

	/** @see #getWidth() */
	private static final String WIDTH = "w";

	/** @see #getHeight() */
	private static final String HEIGHT = "h";

	/** Identifier for the {@link Rectangle} type in binary format. */
	public static final int RECTANGLE__TYPE_ID = 2;

	/** Identifier for the property {@link #getWidth()} in binary format. */
	public static final int WIDTH__ID = 3;

	/** Identifier for the property {@link #getHeight()} in binary format. */
	public static final int HEIGHT__ID = 4;

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
	protected Rectangle self() {
		return this;
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
		_width = value;
		return self();
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
		_height = value;
		return self();
	}

	@Override
	public String jsonType() {
		return RECTANGLE__TYPE;
	}

	/** Reads a new instance from the given reader. */
	public static Rectangle readRectangle(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		Rectangle result = new Rectangle();
		in.beginObject();
		result.readFields(in);
		in.endObject();
		return result;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(WIDTH);
		out.value(getWidth());
		out.name(HEIGHT);
		out.value(getHeight());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case WIDTH: setWidth(in.nextInt()); break;
			case HEIGHT: setHeight(in.nextInt()); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public int typeId() {
		return RECTANGLE__TYPE_ID;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(WIDTH__ID);
		out.value(getWidth());
		out.name(HEIGHT__ID);
		out.value(getHeight());
	}

	/** Reads a new instance from the given reader. */
	public static Rectangle readRectangle(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		Rectangle result = new Rectangle();
		while (in.hasNext()) {
			int field = in.nextName();
			result.readField(in, field);
		}
		in.endObject();
		return result;
	}

	@Override
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case WIDTH__ID: setWidth(in.nextInt()); break;
			case HEIGHT__ID: setHeight(in.nextInt()); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public <R,A,E extends Throwable> R visit(AtomicShape.Visitor<R,A,E> v, A arg) throws E {
		return v.visit(this, arg);
	}

}
