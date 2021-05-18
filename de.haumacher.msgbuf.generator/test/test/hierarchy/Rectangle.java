package test.hierarchy;

/**
 * A rectangle.
 */
public class Rectangle extends Shape {

	/**
	 * Creates a {@link Rectangle} instance.
	 */
	public static Rectangle rectangle() {
		return new Rectangle();
	}

	/**
	 * Creates a {@link Rectangle} instance.
	 *
	 * @see #rectangle()
	 */
	protected Rectangle() {
		super();
	}

	private int _width = 0;

	private int _height = 0;

	public final int getWidth() {
		return _width;
	}

	/**
	 * @see #getWidth()
	 */
	public final Rectangle setWidth(int value) {
		_width = value;
		return this;
	}

	public final int getHeight() {
		return _height;
	}

	/**
	 * @see #getHeight()
	 */
	public final Rectangle setHeight(int value) {
		_height = value;
		return this;
	}

	/** Reads a new instance from the given reader. */
	public static Rectangle readRectangle(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		Rectangle result = new Rectangle();
		result.readFields(in);
		return result;
	}

	@Override
	protected String jsonType() {
		return "Rectangle";
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case "width": return getWidth();
			case "height": return getHeight();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case "width": setWidth((int) value); break;
			case "height": setHeight((int) value); break;
			default: super.set(field, value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name("width");
		out.value(getWidth());
		out.name("height");
		out.value(getHeight());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case "width": setWidth(in.nextInt()); break;
			case "height": setHeight(in.nextInt()); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public <R,A> R visit(Shape.Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}

}
