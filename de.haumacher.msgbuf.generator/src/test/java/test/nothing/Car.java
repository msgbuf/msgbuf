package test.nothing;

/**
 * A special {@link Shape} that contains concrete monomorphic references to type in a polymorphic hierarchy.
 */
public interface Car extends Shape {

	/**
	 * Creates a {@link test.nothing.Car} instance.
	 */
	static test.nothing.Car create() {
		return new test.nothing.impl.Car_Impl();
	}

	/**
	 * The front wheel.
	 */
	test.nothing.Circle getWheel1();

	/**
	 * @see #getWheel1()
	 */
	test.nothing.Car setWheel1(test.nothing.Circle value);

	/**
	 * Checks, whether {@link #getWheel1()} has a value.
	 */
	boolean hasWheel1();

	/**
	 * The back wheel.
	 */
	test.nothing.Circle getWheel2();

	/**
	 * @see #getWheel2()
	 */
	test.nothing.Car setWheel2(test.nothing.Circle value);

	/**
	 * Checks, whether {@link #getWheel2()} has a value.
	 */
	boolean hasWheel2();

	/**
	 * The car body.
	 */
	test.nothing.Rectangle getBody();

	/**
	 * @see #getBody()
	 */
	test.nothing.Car setBody(test.nothing.Rectangle value);

	/**
	 * Checks, whether {@link #getBody()} has a value.
	 */
	boolean hasBody();

	@Override
	test.nothing.Car setXCoordinate(int value);

	@Override
	test.nothing.Car setYCoordinate(int value);

}
