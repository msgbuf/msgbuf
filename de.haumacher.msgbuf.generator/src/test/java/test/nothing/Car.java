package test.nothing;

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

	/**
	 * The front wheel.
	 */
	public final Circle getWheel1() {
		return _wheel1;
	}

	/**
	 * @see #getWheel1()
	 */
	public Car setWheel1(Circle value) {
		internalSetWheel1(value);
		return this;
	}
	/** Internal setter for {@link #getWheel1()} without chain call utility. */
	protected final void internalSetWheel1(Circle value) {
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
	public final Circle getWheel2() {
		return _wheel2;
	}

	/**
	 * @see #getWheel2()
	 */
	public Car setWheel2(Circle value) {
		internalSetWheel2(value);
		return this;
	}
	/** Internal setter for {@link #getWheel2()} without chain call utility. */
	protected final void internalSetWheel2(Circle value) {
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
	public final Rectangle getBody() {
		return _body;
	}

	/**
	 * @see #getBody()
	 */
	public Car setBody(Rectangle value) {
		internalSetBody(value);
		return this;
	}
	/** Internal setter for {@link #getBody()} without chain call utility. */
	protected final void internalSetBody(Rectangle value) {
		_body = value;
	}


	/**
	 * Checks, whether {@link #getBody()} has a value.
	 */
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

}
