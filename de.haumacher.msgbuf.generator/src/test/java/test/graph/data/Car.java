package test.graph.data;

/**
 * A special {@link Shape} that contains concrete monomorphic references to type in a polymorphic hierarchy.
 */
public interface Car extends Shape {

	/**
	 * Creates a {@link Car} instance.
	 */
	static Car create() {
		return new test.graph.data.Car_Impl();
	}

	/** Identifier for the {@link Car} type in JSON format. */
	static final String CAR__TYPE = "Car";

	/** @see #getWheel1() */
	static final String WHEEL_1__PROP = "wheel1";

	/** @see #getWheel2() */
	static final String WHEEL_2__PROP = "wheel2";

	/** @see #getBody() */
	static final String BODY__PROP = "body";

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
	static Car readCar(de.haumacher.msgbuf.graph.Scope scope, de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		if (in.peek() == de.haumacher.msgbuf.json.JsonToken.NUMBER) {
			return (Car) scope.resolveOrFail(in.nextInt());
		}
		in.beginArray();
		String type = in.nextString();
		assert CAR__TYPE.equals(type);
		int id = in.nextInt();
		test.graph.data.Car_Impl result = new test.graph.data.Car_Impl();
		scope.readData(result, id, in);
		in.endArray();
		return result;
	}

	/** Creates a new {@link Car} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Car readCar(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.graph.data.Car_Impl.readCar_XmlContent(in);
	}

}
