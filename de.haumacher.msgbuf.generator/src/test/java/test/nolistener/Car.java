package test.nolistener;

/**
 * A special {@link Shape} that contains concrete monomorphic references to type in a polymorphic hierarchy.
 */
public interface Car extends Shape {

	/**
	 * Creates a {@link test.nolistener.Car} instance.
	 */
	static test.nolistener.Car create() {
		return new test.nolistener.impl.Car_Impl();
	}

	/** Identifier for the {@link test.nolistener.Car} type in JSON format. */
	String CAR__TYPE = "Car";

	/** @see #getWheel1() */
	String WHEEL_1__PROP = "wheel1";

	/** @see #getWheel2() */
	String WHEEL_2__PROP = "wheel2";

	/** @see #getBody() */
	String BODY__PROP = "body";

	/** Identifier for the {@link test.nolistener.Car} type in binary format. */
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
	test.nolistener.Circle getWheel1();

	/**
	 * @see #getWheel1()
	 */
	test.nolistener.Car setWheel1(test.nolistener.Circle value);

	/**
	 * Checks, whether {@link #getWheel1()} has a value.
	 */
	boolean hasWheel1();

	/**
	 * The back wheel.
	 */
	test.nolistener.Circle getWheel2();

	/**
	 * @see #getWheel2()
	 */
	test.nolistener.Car setWheel2(test.nolistener.Circle value);

	/**
	 * Checks, whether {@link #getWheel2()} has a value.
	 */
	boolean hasWheel2();

	/**
	 * The car body.
	 */
	test.nolistener.Rectangle getBody();

	/**
	 * @see #getBody()
	 */
	test.nolistener.Car setBody(test.nolistener.Rectangle value);

	/**
	 * Checks, whether {@link #getBody()} has a value.
	 */
	boolean hasBody();

	@Override
	test.nolistener.Car setXCoordinate(int value);

	@Override
	test.nolistener.Car setYCoordinate(int value);

	/** Reads a new instance from the given reader. */
	static test.nolistener.Car readCar(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.nolistener.impl.Car_Impl result = new test.nolistener.impl.Car_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.nolistener.Car readCar(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.nolistener.Car result = test.nolistener.impl.Car_Impl.readCar_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link Car} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Car readCar(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.nolistener.impl.Car_Impl.readCar_XmlContent(in);
	}

}
