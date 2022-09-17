package test.nothing;

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

}
