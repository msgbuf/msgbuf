package test.nothing;

/**
 * A special {@link Shape} that contains concrete monomorphic references to type in a polymorphic hierarchy.
 */
public interface Car extends Shape {

	/**
	 * Creates a {@link Car} instance.
	 */
	static Car create() {
		return new test.nothing.Car_Impl();
	}

	/**
	 * The front wheel.
	 */
	Circle getWheel1();

	/**
	 * @see #getWheel1()
	 */
	Car setWheel1(Circle value);

	/**
	 * Checks, whether {@link #getWheel1()} has a value.
	 */
	boolean hasWheel1();

	/**
	 * The back wheel.
	 */
	Circle getWheel2();

	/**
	 * @see #getWheel2()
	 */
	Car setWheel2(Circle value);

	/**
	 * Checks, whether {@link #getWheel2()} has a value.
	 */
	boolean hasWheel2();

	/**
	 * The car body.
	 */
	Rectangle getBody();

	/**
	 * @see #getBody()
	 */
	Car setBody(Rectangle value);

	/**
	 * Checks, whether {@link #getBody()} has a value.
	 */
	boolean hasBody();

	@Override
	Car setXCoordinate(int value);

	@Override
	Car setYCoordinate(int value);

}
