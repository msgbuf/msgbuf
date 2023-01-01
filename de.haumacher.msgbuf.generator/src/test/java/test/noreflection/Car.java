package test.noreflection;

/**
 * A special {@link Shape} that contains concrete monomorphic references to type in a polymorphic hierarchy.
 */
public class Car extends Shape {

	/**
	 * Creates a {@link test.noreflection.Car} instance.
	 */
	public static test.noreflection.Car create() {
		return new test.noreflection.Car();
	}

	/** Identifier for the {@link test.noreflection.Car} type in JSON format. */
	public static final String CAR__TYPE = "Car";

	/** @see #getWheel1() */
	private static final String WHEEL_1__PROP = "wheel1";

	/** @see #getWheel2() */
	private static final String WHEEL_2__PROP = "wheel2";

	/** @see #getBody() */
	private static final String BODY__PROP = "body";

	private test.noreflection.Circle _wheel1 = null;

	private test.noreflection.Circle _wheel2 = null;

	private test.noreflection.Rectangle _body = null;

	/**
	 * Creates a {@link Car} instance.
	 *
	 * @see test.noreflection.Car#create()
	 */
	protected Car() {
		super();
	}

	/**
	 * The front wheel.
	 */
	public final test.noreflection.Circle getWheel1() {
		return _wheel1;
	}

	/**
	 * @see #getWheel1()
	 */
	public test.noreflection.Car setWheel1(test.noreflection.Circle value) {
		internalSetWheel1(value);
		return this;
	}

	/** Internal setter for {@link #getWheel1()} without chain call utility. */
	protected final void internalSetWheel1(test.noreflection.Circle value) {
		_wheel1 = value;
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
	public final test.noreflection.Circle getWheel2() {
		return _wheel2;
	}

	/**
	 * @see #getWheel2()
	 */
	public test.noreflection.Car setWheel2(test.noreflection.Circle value) {
		internalSetWheel2(value);
		return this;
	}

	/** Internal setter for {@link #getWheel2()} without chain call utility. */
	protected final void internalSetWheel2(test.noreflection.Circle value) {
		_wheel2 = value;
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
	public final test.noreflection.Rectangle getBody() {
		return _body;
	}

	/**
	 * @see #getBody()
	 */
	public test.noreflection.Car setBody(test.noreflection.Rectangle value) {
		internalSetBody(value);
		return this;
	}

	/** Internal setter for {@link #getBody()} without chain call utility. */
	protected final void internalSetBody(test.noreflection.Rectangle value) {
		_body = value;
	}

	/**
	 * Checks, whether {@link #getBody()} has a value.
	 */
	public final boolean hasBody() {
		return _body != null;
	}

	@Override
	public test.noreflection.Car setXCoordinate(int value) {
		internalSetXCoordinate(value);
		return this;
	}

	@Override
	public test.noreflection.Car setYCoordinate(int value) {
		internalSetYCoordinate(value);
		return this;
	}

	@Override
	public String jsonType() {
		return CAR__TYPE;
	}

	/** Reads a new instance from the given reader. */
	public static test.noreflection.Car readCar(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.noreflection.Car result = new test.noreflection.Car();
		result.readContent(in);
		return result;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		if (hasWheel1()) {
			out.name(WHEEL_1__PROP);
			getWheel1().writeContent(out);
		}
		if (hasWheel2()) {
			out.name(WHEEL_2__PROP);
			getWheel2().writeContent(out);
		}
		if (hasBody()) {
			out.name(BODY__PROP);
			getBody().writeContent(out);
		}
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case WHEEL_1__PROP: setWheel1(test.noreflection.Circle.readCircle(in)); break;
			case WHEEL_2__PROP: setWheel2(test.noreflection.Circle.readCircle(in)); break;
			case BODY__PROP: setBody(test.noreflection.Rectangle.readRectangle(in)); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public <R,A,E extends Throwable> R visit(test.noreflection.Shape.Visitor<R,A,E> v, A arg) throws E {
		return v.visit(this, arg);
	}

}
