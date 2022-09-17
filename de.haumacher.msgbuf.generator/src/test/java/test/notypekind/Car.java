package test.notypekind;

/**
 * A special {@link Shape} that contains concrete monomorphic references to type in a polymorphic hierarchy.
 */
public interface Car extends Shape {

	/**
	 * Creates a {@link Car} instance.
	 */
	static Car create() {
		return new test.notypekind.Car_Impl();
	}

	/** Identifier for the {@link Car} type in JSON format. */
	static final String CAR__TYPE = "Car";

	/** @see #getWheel1() */
	static final String WHEEL_1 = "wheel1";

	/** @see #getWheel2() */
	static final String WHEEL_2 = "wheel2";

	/** @see #getBody() */
	static final String BODY = "body";

	/** Identifier for the {@link Car} type in binary format. */
	static final int CAR__TYPE_ID = 4;

	/** Identifier for the property {@link #getWheel1()} in binary format. */
	static final int WHEEL_1__ID = 3;

	/** Identifier for the property {@link #getWheel2()} in binary format. */
	static final int WHEEL_2__ID = 4;

	/** Identifier for the property {@link #getBody()} in binary format. */
	static final int BODY__ID = 5;

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


	/** Reads a new instance from the given reader. */
	static Car readCar(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.notypekind.Car_Impl result = new test.notypekind.Car_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static Car readCar(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		Car result = test.notypekind.Car_Impl.readCar_Content(in);
		in.endObject();
		return result;
	}

}
