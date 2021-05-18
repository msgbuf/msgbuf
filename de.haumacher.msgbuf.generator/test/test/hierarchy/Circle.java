package test.hierarchy;

/**
 * A circle.
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

	private static final int[] FIELDS = {0, };

	/** Reads a new instance from the given reader. */
	public static Circle readCircle(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		Circle result = new Circle();
		result.readContent(in);
		return result;
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
	protected void writeContent(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeContent(out);
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
