package test.hierarchy.data;

/**
 * A circle {@link Shape}.
 */
public class Circle extends AtomicShape {

	/**
	 * Creates a {@link Circle} instance.
	 */
	public static Circle create() {
		return new Circle();
	}

	/**
	 * Creates a {@link Circle} instance.
	 *
	 * @see #create()
	 */
	protected Circle() {
		super();
	}

	/** @see #getRadius() */
	public static final String RADIUS = "radius";

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
	public String jsonType() {
		return "Circle";
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			RADIUS));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case RADIUS: return getRadius();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case RADIUS: setRadius((int) value); break;
			default: super.set(field, value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(RADIUS);
		out.value(getRadius());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case RADIUS: setRadius(in.nextInt()); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public int typeId() {
		return 1;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(3);
		out.value(getRadius());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case 3: setRadius(in.nextInt()); break;
			default: super.readField(in, field);
		}
	}

	/** Reads a new instance from the given reader. */
	public static Circle readCircle(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		Circle result = new Circle();
		while (in.hasNext()) {
			int field = in.nextName();
			result.readField(in, field);
		}
		in.endObject();
		return result;
	}

	@Override
	public <R,A> R visit(AtomicShape.Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}

}
