package test.nothing.impl;

/**
 * A special {@link Shape} that contains concrete monomorphic references to type in a polymorphic hierarchy.
 */
public class Car_Impl extends test.nothing.impl.Shape_Impl implements test.nothing.Car {

	private test.nothing.Circle _wheel1 = null;

	private test.nothing.Circle _wheel2 = null;

	private test.nothing.Rectangle _body = null;

	/**
	 * Creates a {@link Car_Impl} instance.
	 *
	 * @see test.nothing.Car#create()
	 */
	public Car_Impl() {
		super();
	}

	@Override
	public final test.nothing.Circle getWheel1() {
		return _wheel1;
	}

	@Override
	public test.nothing.Car setWheel1(test.nothing.Circle value) {
		internalSetWheel1(value);
		return this;
	}

	/** Internal setter for {@link #getWheel1()} without chain call utility. */
	protected final void internalSetWheel1(test.nothing.Circle value) {
		_wheel1 = value;
	}

	@Override
	public final boolean hasWheel1() {
		return _wheel1 != null;
	}

	@Override
	public final test.nothing.Circle getWheel2() {
		return _wheel2;
	}

	@Override
	public test.nothing.Car setWheel2(test.nothing.Circle value) {
		internalSetWheel2(value);
		return this;
	}

	/** Internal setter for {@link #getWheel2()} without chain call utility. */
	protected final void internalSetWheel2(test.nothing.Circle value) {
		_wheel2 = value;
	}

	@Override
	public final boolean hasWheel2() {
		return _wheel2 != null;
	}

	@Override
	public final test.nothing.Rectangle getBody() {
		return _body;
	}

	@Override
	public test.nothing.Car setBody(test.nothing.Rectangle value) {
		internalSetBody(value);
		return this;
	}

	/** Internal setter for {@link #getBody()} without chain call utility. */
	protected final void internalSetBody(test.nothing.Rectangle value) {
		_body = value;
	}

	@Override
	public final boolean hasBody() {
		return _body != null;
	}

	@Override
	public test.nothing.Car setXCoordinate(int value) {
		internalSetXCoordinate(value);
		return this;
	}

	@Override
	public test.nothing.Car setYCoordinate(int value) {
		internalSetYCoordinate(value);
		return this;
	}

}
