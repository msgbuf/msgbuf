package test.graph.data;

/**
 * A special {@link Shape} that contains concrete monomorphic references to type in a polymorphic hierarchy.
 */
public class Car extends Shape<Car> {

	/**
	 * Creates a {@link Car} instance.
	 */
	public static Car create() {
		return new Car();
	}

	/** Identifier for the {@link Car} type in JSON format. */
	public static final String CAR__TYPE = "Car";

	/** @see #getWheel1() */
	public static final String WHEEL_1 = "wheel1";

	/** @see #getWheel2() */
	public static final String WHEEL_2 = "wheel2";

	/** @see #getBody() */
	public static final String BODY = "body";

	private Circle _wheel1 = null;

	private Circle _wheel2 = null;

	private Rectangle _body = null;

	/**
	 * Creates a {@link Car} instance.
	 *
	 * @see #create()
	 */
	protected Car() {
		super();
	}

	@Override
	protected Car self() {
		return this;
	}

	@Override
	public TypeKind kind() {
		return TypeKind.CAR;
	}

	/**
	 * The front wheel.
	 */
	public final Circle getWheel1() {
		return _wheel1;
	}

	/**
	 * @see #getWheel1()
	 */
	public final Car setWheel1(Circle value) {
		_listener.beforeSet(this, WHEEL_1, value);
		_wheel1 = value;
		return self();
	}

	/**
	 * Checks, whether {@link #getWheel1()} has a value.
	 */
	public final boolean hasWheel1() {
		return _wheel1 != null;
	}

	/**
	 * The back wheel.
	 */
	public final Circle getWheel2() {
		return _wheel2;
	}

	/**
	 * @see #getWheel2()
	 */
	public final Car setWheel2(Circle value) {
		_listener.beforeSet(this, WHEEL_2, value);
		_wheel2 = value;
		return self();
	}

	/**
	 * Checks, whether {@link #getWheel2()} has a value.
	 */
	public final boolean hasWheel2() {
		return _wheel2 != null;
	}

	/**
	 * The car body.
	 */
	public final Rectangle getBody() {
		return _body;
	}

	/**
	 * @see #getBody()
	 */
	public final Car setBody(Rectangle value) {
		_listener.beforeSet(this, BODY, value);
		_body = value;
		return self();
	}

	/**
	 * Checks, whether {@link #getBody()} has a value.
	 */
	public final boolean hasBody() {
		return _body != null;
	}

	@Override
	public String jsonType() {
		return CAR__TYPE;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			WHEEL_1, 
			WHEEL_2, 
			BODY));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case WHEEL_1: return getWheel1();
			case WHEEL_2: return getWheel2();
			case BODY: return getBody();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case WHEEL_1: setWheel1((Circle) value); break;
			case WHEEL_2: setWheel2((Circle) value); break;
			case BODY: setBody((Rectangle) value); break;
			default: super.set(field, value); break;
		}
	}

	/** Reads a new instance from the given reader. */
	public static Car readCar(de.haumacher.msgbuf.graph.Scope scope, de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		if (in.peek() == de.haumacher.msgbuf.json.JsonToken.NUMBER) {
			return (Car) scope.resolveOrFail(in.nextInt());
		}
		in.beginArray();
		String type = in.nextString();
		assert CAR__TYPE.equals(type);
		int id = in.nextInt();
		Car result = new Car();
		scope.readData(result, id, in);
		in.endArray();
		return result;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.graph.Scope scope, de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(scope, out);
		if (hasWheel1()) {
			out.name(WHEEL_1);
			getWheel1().writeTo(scope, out);
		}
		if (hasWheel2()) {
			out.name(WHEEL_2);
			getWheel2().writeTo(scope, out);
		}
		if (hasBody()) {
			out.name(BODY);
			getBody().writeTo(scope, out);
		}
	}

	@Override
	public void writeFieldValue(de.haumacher.msgbuf.graph.Scope scope, de.haumacher.msgbuf.json.JsonWriter out, String field) throws java.io.IOException {
		switch (field) {
			case WHEEL_1: {
				if (hasWheel1()) {
					getWheel1().writeTo(scope, out);
				} else {
					out.nullValue();
				}
				break;
			}
			case WHEEL_2: {
				if (hasWheel2()) {
					getWheel2().writeTo(scope, out);
				} else {
					out.nullValue();
				}
				break;
			}
			case BODY: {
				if (hasBody()) {
					getBody().writeTo(scope, out);
				} else {
					out.nullValue();
				}
				break;
			}
			default: super.writeFieldValue(scope, out, field);
		}
	}

	@Override
	public void readField(de.haumacher.msgbuf.graph.Scope scope, de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case WHEEL_1: setWheel1(test.graph.data.Circle.readCircle(scope, in)); break;
			case WHEEL_2: setWheel2(test.graph.data.Circle.readCircle(scope, in)); break;
			case BODY: setBody(test.graph.data.Rectangle.readRectangle(scope, in)); break;
			default: super.readField(scope, in, field);
		}
	}

	@Override
	public <R,A,E extends Throwable> R visit(Shape.Visitor<R,A,E> v, A arg) throws E {
		return v.visit(this, arg);
	}

}
