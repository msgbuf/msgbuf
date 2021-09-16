package test.hierarchy.data;

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

	/**
	 * Creates a {@link Car} instance.
	 *
	 * @see #create()
	 */
	protected Car() {
		super();
	}

	private Circle _wheel1 = null;

	private Circle _wheel2 = null;

	private Rectangle _body = null;

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

	/** Reads a new instance from the given reader. */
	public static Car readCar(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		Car result = new Car();
		in.beginObject();
		result.readFields(in);
		in.endObject();
		return result;
	}

	@Override
	protected String jsonType() {
		return "Car";
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case "wheel1": return getWheel1();
			case "wheel2": return getWheel2();
			case "body": return getBody();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case "wheel1": setWheel1((Circle) value); break;
			case "wheel2": setWheel2((Circle) value); break;
			case "body": setBody((Rectangle) value); break;
			default: super.set(field, value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		if (hasWheel1()) {
			out.name("wheel1");
			getWheel1().writeContent(out);
		}
		if (hasWheel2()) {
			out.name("wheel2");
			getWheel2().writeContent(out);
		}
		if (hasBody()) {
			out.name("body");
			getBody().writeContent(out);
		}
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case "wheel1": setWheel1(Circle.readCircle(in)); break;
			case "wheel2": setWheel2(Circle.readCircle(in)); break;
			case "body": setBody(Rectangle.readRectangle(in)); break;
			default: super.readField(in, field);
		}
	}

	@Override
	protected int typeId() {
		return 4;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		super.writeFields(out);
		if (hasWheel1()) {
			out.name(3);
			getWheel1().writeTo(out);
		}
		if (hasWheel2()) {
			out.name(4);
			getWheel2().writeTo(out);
		}
		if (hasBody()) {
			out.name(5);
			getBody().writeTo(out);
		}
	}

	@Override
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case 3: setWheel1(Circle.readCircle(in)); break;
			case 4: setWheel2(Circle.readCircle(in)); break;
			case 5: setBody(Rectangle.readRectangle(in)); break;
			default: super.readField(in, field);
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
	public <R,A> R visit(Shape.Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}

}
