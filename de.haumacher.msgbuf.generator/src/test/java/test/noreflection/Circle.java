package test.noreflection;

/**
 * A circle {@link Shape}.
 */
public class Circle extends AtomicShape {

	/**
	 * Creates a {@link test.noreflection.Circle} instance.
	 */
	public static test.noreflection.Circle create() {
		return new test.noreflection.Circle();
	}

	/** Identifier for the {@link test.noreflection.Circle} type in JSON format. */
	public static final String CIRCLE__TYPE = "Circle";

	/** @see #getRadius() */
	private static final String RADIUS__PROP = "r";

	private int _radius = 0;

	/**
	 * Creates a {@link Circle} instance.
	 *
	 * @see test.noreflection.Circle#create()
	 */
	protected Circle() {
		super();
	}

	/**
	 * The radius of this {@link Circle} around its coordinate origin at ({@link #getXCoordinate()}, {@link #getYCoordinate()}).
	 */
	public final int getRadius() {
		return _radius;
	}

	/**
	 * @see #getRadius()
	 */
	public test.noreflection.Circle setRadius(int value) {
		internalSetRadius(value);
		return this;
	}

	/** Internal setter for {@link #getRadius()} without chain call utility. */
	protected final void internalSetRadius(int value) {
		_radius = value;
	}

	@Override
	public test.noreflection.Circle setXCoordinate(int value) {
		internalSetXCoordinate(value);
		return this;
	}

	@Override
	public test.noreflection.Circle setYCoordinate(int value) {
		internalSetYCoordinate(value);
		return this;
	}

	@Override
	public String jsonType() {
		return CIRCLE__TYPE;
	}

	/** Reads a new instance from the given reader. */
	public static test.noreflection.Circle readCircle(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.noreflection.Circle result = new test.noreflection.Circle();
		result.readContent(in);
		return result;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(RADIUS__PROP);
		out.value(getRadius());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case RADIUS__PROP: setRadius(in.nextInt()); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public <R,A,E extends Throwable> R visit(test.noreflection.AtomicShape.Visitor<R,A,E> v, A arg) throws E {
		return v.visit(this, arg);
	}

}
