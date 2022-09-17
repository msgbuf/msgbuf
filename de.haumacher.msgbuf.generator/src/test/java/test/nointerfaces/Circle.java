package test.nointerfaces;

/**
 * A circle {@link Shape}.
 */
public class Circle extends AtomicShape {

	/**
	 * Creates a {@link Circle} instance.
	 */
	public static Circle create() {
		return new test.nointerfaces.Circle();
	}

	/** Identifier for the {@link Circle} type in JSON format. */
	public static final String CIRCLE__TYPE = "Circle";

	/** @see #getRadius() */
	public static final String RADIUS = "r";

	/** Identifier for the {@link Circle} type in binary format. */
	static final int CIRCLE__TYPE_ID = 1;

	/** Identifier for the property {@link #getRadius()} in binary format. */
	static final int RADIUS__ID = 3;

	private int _radius = 0;

	/**
	 * Creates a {@link Circle} instance.
	 *
	 * @see Circle#create()
	 */
	protected Circle() {
		super();
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
	public Circle setRadius(int value) {
		internalSetRadius(value);
		return this;
	}

	/** Internal setter for {@link #getRadius()} without chain call utility. */
	protected final void internalSetRadius(int value) {
		_listener.beforeSet(this, RADIUS, value);
		_radius = value;
	}

	@Override
	public Circle setXCoordinate(int value) {
		internalSetXCoordinate(value);
		return this;
	}

	@Override
	public Circle setYCoordinate(int value) {
		internalSetYCoordinate(value);
		return this;
	}

	@Override
	public String jsonType() {
		return CIRCLE__TYPE;
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
			case RADIUS: internalSetRadius((int) value); break;
			default: super.set(field, value); break;
		}
	}

	/** Reads a new instance from the given reader. */
	public static Circle readCircle(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.nointerfaces.Circle result = new test.nointerfaces.Circle();
		result.readContent(in);
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

	/** The binary identifier for this concrete type in the polymorphic {@link Circle} hierarchy. */
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
		Circle result = test.nointerfaces.Circle.readCircle_Content(in);
		in.endObject();
		return result;
	}

	/** Helper for creating an object of type {@link Circle} from a polymorphic composition. */
	public static Circle readCircle_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.nointerfaces.Circle result = new Circle();
		result.readContent(in);
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
