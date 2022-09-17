package test.graph.data;

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
