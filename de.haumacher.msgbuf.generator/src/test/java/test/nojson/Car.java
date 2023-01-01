package test.nojson;

/**
 * A special {@link Shape} that contains concrete monomorphic references to type in a polymorphic hierarchy.
 */
public interface Car extends Shape {

	/**
	 * Creates a {@link test.nojson.Car} instance.
	 */
	static test.nojson.Car create() {
		return new test.nojson.impl.Car_Impl();
	}

	/** Identifier for the {@link test.nojson.Car} type in JSON format. */
	static final String CAR__TYPE = "Car";

	/** @see #getWheel1() */
	static final String WHEEL_1__PROP = "wheel1";

	/** @see #getWheel2() */
	static final String WHEEL_2__PROP = "wheel2";

	/** @see #getBody() */
	static final String BODY__PROP = "body";

	/** Identifier for the {@link test.nojson.Car} type in binary format. */
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
	test.nojson.Circle getWheel1();

	/**
	 * @see #getWheel1()
	 */
	test.nojson.Car setWheel1(test.nojson.Circle value);

	/**
	 * Checks, whether {@link #getWheel1()} has a value.
	 */
	boolean hasWheel1();

	/**
	 * The back wheel.
	 */
	test.nojson.Circle getWheel2();

	/**
	 * @see #getWheel2()
	 */
	test.nojson.Car setWheel2(test.nojson.Circle value);

	/**
	 * Checks, whether {@link #getWheel2()} has a value.
	 */
	boolean hasWheel2();

	/**
	 * The car body.
	 */
	test.nojson.Rectangle getBody();

	/**
	 * @see #getBody()
	 */
	test.nojson.Car setBody(test.nojson.Rectangle value);

	/**
	 * Checks, whether {@link #getBody()} has a value.
	 */
	boolean hasBody();

	@Override
	test.nojson.Car setXCoordinate(int value);

	@Override
	test.nojson.Car setYCoordinate(int value);

	/** Reads a new instance from the given reader. */
	static test.nojson.Car readCar(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.nojson.Car result = test.nojson.impl.Car_Impl.readCar_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link Car} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Car readCar(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.nojson.impl.Car_Impl.readCar_XmlContent(in);
	}

}
