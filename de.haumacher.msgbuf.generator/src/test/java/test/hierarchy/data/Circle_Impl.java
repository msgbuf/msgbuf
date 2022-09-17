package test.hierarchy.data;

/**
 * A circle {@link Shape}.
 */
class Circle_Impl extends AtomicShape_Impl implements Circle {

	private int _radius = 0;

	/**
	 * Creates a {@link Circle_Impl} instance.
	 *
	 * @see Circle#create()
	 */
	protected Circle_Impl() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.CIRCLE;
	}

	@Override
	public final int getRadius() {
		return _radius;
	}

	@Override
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

	/** Helper for creating an object of type {@link Circle} from a polymorphic composition. */
	public static Circle readCircle_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.hierarchy.data.Circle_Impl result = new Circle_Impl();
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
