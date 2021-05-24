package test.hierarchy.data;

/**
 * A circle {@link Shape}.
 */
public class Circle extends Shape {

	/**
	 * Creates a {@link Circle} instance.
	 */
	public static Circle circle() {
		return new Circle();
	}

	/**
	 * Creates a {@link Circle} instance.
	 *
	 * @see #circle()
	 */
	protected Circle() {
		super();
	}

	private int _radius = 0;

	/**
	 * The radius of this {@link Circle} around its coordinate origin at ({@link #getXCoordinate()}, {@link #getYCoordinate()}).
	 */
	public final int getRadius() {
		return _radius;
	}

	/**
	 * @see #getRadius()
	 */
	public final Circle setRadius(int value) {
		_radius = value;
		return this;
	}

	/** Reads a new instance from the given reader. */
	public static Circle readCircle(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		Circle result = new Circle();
		in.beginObject();
		result.readFields(in);
		in.endObject();
		return result;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(3);
		out.value(getRadius());
	}

	@Override
	protected String jsonType() {
		return "Circle";
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case "radius": return getRadius();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case "radius": setRadius((int) value); break;
			default: super.set(field, value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name("radius");
		out.value(getRadius());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case "radius": setRadius(in.nextInt()); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public <R,A> R visit(Shape.Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}

}
