package test.onlyxml.data;

/**
 * A special {@link Shape} that contains concrete monomorphic references to type in a polymorphic hierarchy.
 */
public interface Car extends Shape {

	/**
	 * Creates a {@link Car} instance.
	 */
	static Car create() {
		return new test.onlyxml.data.Car_Impl();
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

	/** Creates a new {@link Car} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Car readCar(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.onlyxml.data.Car_Impl.readCar_XmlContent(in);
	}

}
