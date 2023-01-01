package test.onlyxml.data;

/**
 * A special {@link Shape} that contains concrete monomorphic references to type in a polymorphic hierarchy.
 */
public interface Car extends Shape {

	/**
	 * Creates a {@link test.onlyxml.data.Car} instance.
	 */
	static test.onlyxml.data.Car create() {
		return new test.onlyxml.data.impl.Car_Impl();
	}

	/**
	 * The front wheel.
	 */
	test.onlyxml.data.Circle getWheel1();

	/**
	 * @see #getWheel1()
	 */
	test.onlyxml.data.Car setWheel1(test.onlyxml.data.Circle value);

	/**
	 * Checks, whether {@link #getWheel1()} has a value.
	 */
	boolean hasWheel1();

	/**
	 * The back wheel.
	 */
	test.onlyxml.data.Circle getWheel2();

	/**
	 * @see #getWheel2()
	 */
	test.onlyxml.data.Car setWheel2(test.onlyxml.data.Circle value);

	/**
	 * Checks, whether {@link #getWheel2()} has a value.
	 */
	boolean hasWheel2();

	/**
	 * The car body.
	 */
	test.onlyxml.data.Rectangle getBody();

	/**
	 * @see #getBody()
	 */
	test.onlyxml.data.Car setBody(test.onlyxml.data.Rectangle value);

	/**
	 * Checks, whether {@link #getBody()} has a value.
	 */
	boolean hasBody();

	@Override
	test.onlyxml.data.Car setXCoordinate(int value);

	@Override
	test.onlyxml.data.Car setYCoordinate(int value);

	/** Creates a new {@link Car} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Car readCar(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.onlyxml.data.impl.Car_Impl.readCar_XmlContent(in);
	}

}
