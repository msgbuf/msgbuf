package test.novisit;

/**
 * A special {@link Shape} that contains concrete monomorphic references to type in a polymorphic hierarchy.
 */
class Car_Impl extends Shape_Impl implements Car {

	private Circle _wheel1 = null;

	private Circle _wheel2 = null;

	private Rectangle _body = null;

	/**
	 * Creates a {@link Car_Impl} instance.
	 *
	 * @see Car#create()
	 */
	protected Car_Impl() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.CAR;
	}

	@Override
	public final Circle getWheel1() {
		return _wheel1;
	}

	@Override
	public Car setWheel1(Circle value) {
		internalSetWheel1(value);
		return this;
	}

	/** Internal setter for {@link #getWheel1()} without chain call utility. */
	protected final void internalSetWheel1(Circle value) {
		_listener.beforeSet(this, WHEEL_1, value);
		_wheel1 = value;
	}

	@Override
	public final boolean hasWheel1() {
		return _wheel1 != null;
	}

	@Override
	public final Circle getWheel2() {
		return _wheel2;
	}

	@Override
	public Car setWheel2(Circle value) {
		internalSetWheel2(value);
		return this;
	}

	/** Internal setter for {@link #getWheel2()} without chain call utility. */
	protected final void internalSetWheel2(Circle value) {
		_listener.beforeSet(this, WHEEL_2, value);
		_wheel2 = value;
	}

	@Override
	public final boolean hasWheel2() {
		return _wheel2 != null;
	}

	@Override
	public final Rectangle getBody() {
		return _body;
	}

	@Override
	public Car setBody(Rectangle value) {
		internalSetBody(value);
		return this;
	}

	/** Internal setter for {@link #getBody()} without chain call utility. */
	protected final void internalSetBody(Rectangle value) {
		_listener.beforeSet(this, BODY, value);
		_body = value;
	}

	@Override
	public final boolean hasBody() {
		return _body != null;
	}

	@Override
	public Car setXCoordinate(int value) {
		internalSetXCoordinate(value);
		return this;
	}

	@Override
	public Car setYCoordinate(int value) {
		internalSetYCoordinate(value);
		return this;
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
			case WHEEL_1: internalSetWheel1((Circle) value); break;
			case WHEEL_2: internalSetWheel2((Circle) value); break;
			case BODY: internalSetBody((Rectangle) value); break;
			default: super.set(field, value); break;
		}
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
			case WHEEL_1: setWheel1(test.novisit.Circle.readCircle(in)); break;
			case WHEEL_2: setWheel2(test.novisit.Circle.readCircle(in)); break;
			case BODY: setBody(test.novisit.Rectangle.readRectangle(in)); break;
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

	/** Helper for creating an object of type {@link Car} from a polymorphic composition. */
	public static Car readCar_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.novisit.Car_Impl result = new Car_Impl();
		result.readContent(in);
		return result;
	}

	@Override
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case WHEEL_1__ID: setWheel1(test.novisit.Circle.readCircle(in)); break;
			case WHEEL_2__ID: setWheel2(test.novisit.Circle.readCircle(in)); break;
			case BODY__ID: setBody(test.novisit.Rectangle.readRectangle(in)); break;
			default: super.readField(in, field);
		}
	}

}
