package test.noreflection;

/**
 * A circle {@link Shape}.
 */
public class Circle extends AtomicShape<Circle> {

	/**
	 * Creates a {@link Circle} instance.
	 */
	public static Circle create() {
		return new Circle();
	}

	/** Identifier for the {@link Circle} type in JSON format. */
	public static final String CIRCLE__TYPE = "Circle";

	/** @see #getRadius() */
	private static final String RADIUS = "r";

	/** Identifier for the {@link Circle} type in binary format. */
	public static final int CIRCLE__TYPE_ID = 1;

	/** Identifier for the property {@link #getRadius()} in binary format. */
	public static final int RADIUS__ID = 3;

	private int _radius = 0;

	/**
	 * Creates a {@link Circle} instance.
	 *
	 * @see #create()
	 */
	protected Circle() {
		super();
	}

	@Override
	protected Circle self() {
		return this;
	}

	@Override
	public TypeKind kind() {
		return TypeKind.CIRCLE;
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
	public final Circle setRadius(int value) {
		_radius = value;
		return self();
	}

	@Override
	public String jsonType() {
		return CIRCLE__TYPE;
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
		return CIRCLE__TYPE_ID;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(RADIUS__ID);
		out.value(getRadius());
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
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case RADIUS__ID: setRadius(in.nextInt()); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public <R,A,E extends Throwable> R visit(AtomicShape.Visitor<R,A,E> v, A arg) throws E {
		return v.visit(this, arg);
	}

}
