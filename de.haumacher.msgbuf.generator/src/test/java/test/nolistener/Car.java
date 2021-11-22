package test.nolistener;

/**
 * A special {@link Shape} that contains concrete monomorphic references to type in a polymorphic hierarchy.
 */
public class Car extends Shape {

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

	/** Identifier for the {@link Car} type in binary format. */
	public static final int CAR__TYPE_ID = 4;

	/** Identifier for the property {@link #getWheel1()} in binary format. */
	public static final int WHEEL_1__ID = 3;

	/** Identifier for the property {@link #getWheel2()} in binary format. */
	public static final int WHEEL_2__ID = 4;

	/** Identifier for the property {@link #getBody()} in binary format. */
	public static final int BODY__ID = 5;

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
		_wheel1 = value;
		return this;
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
		_wheel2 = value;
		return this;
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
		_body = value;
		return this;
	}

	/**
	 * Checks, whether {@link #getBody()} has a value.
	 */
	public final boolean hasBody() {
		return _body != null;
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
	public static Car readCar(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		Car result = new Car();
		in.beginObject();
		result.readFields(in);
		in.endObject();
		return result;
	}

	@Override
	public String jsonType() {
		return CAR__TYPE;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		if (hasWheel1()) {
			out.name(WHEEL_1);
			getWheel1().writeContent(out);
		}
		if (hasWheel2()) {
			out.name(WHEEL_2);
			getWheel2().writeContent(out);
		}
		if (hasBody()) {
			out.name(BODY);
			getBody().writeContent(out);
		}
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case WHEEL_1: setWheel1(test.nolistener.Circle.readCircle(in)); break;
			case WHEEL_2: setWheel2(test.nolistener.Circle.readCircle(in)); break;
			case BODY: setBody(test.nolistener.Rectangle.readRectangle(in)); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public int typeId() {
		return CAR__TYPE_ID;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		super.writeFields(out);
		if (hasWheel1()) {
			out.name(WHEEL_1__ID);
			getWheel1().writeTo(out);
		}
		if (hasWheel2()) {
			out.name(WHEEL_2__ID);
			getWheel2().writeTo(out);
		}
		if (hasBody()) {
			out.name(BODY__ID);
			getBody().writeTo(out);
		}
	}

	/** Reads a new instance from the given reader. */
	public static Car readCar(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		Car result = new Car();
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
			case WHEEL_1__ID: setWheel1(test.nolistener.Circle.readCircle(in)); break;
			case WHEEL_2__ID: setWheel2(test.nolistener.Circle.readCircle(in)); break;
			case BODY__ID: setBody(test.nolistener.Rectangle.readRectangle(in)); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public <R,A,E extends Throwable> R visit(Shape.Visitor<R,A,E> v, A arg) throws E {
		return v.visit(this, arg);
	}

}
