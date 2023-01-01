package test.graph.data;

/**
 * A special {@link Shape} that contains concrete monomorphic references to type in a polymorphic hierarchy.
 */
public interface Car extends Shape {

	/**
	 * Creates a {@link test.graph.data.Car} instance.
	 */
	static test.graph.data.Car create() {
		return new test.graph.data.impl.Car_Impl();
	}

	/** Identifier for the {@link test.graph.data.Car} type in JSON format. */
	String CAR__TYPE = "Car";

	/** @see #getWheel1() */
	String WHEEL_1__PROP = "wheel1";

	/** @see #getWheel2() */
	String WHEEL_2__PROP = "wheel2";

	/** @see #getBody() */
	String BODY__PROP = "body";

	/**
	 * The front wheel.
	 */
	test.graph.data.Circle getWheel1();

	/**
	 * @see #getWheel1()
	 */
	test.graph.data.Car setWheel1(test.graph.data.Circle value);

	/**
	 * Checks, whether {@link #getWheel1()} has a value.
	 */
	boolean hasWheel1();

	/**
	 * The back wheel.
	 */
	test.graph.data.Circle getWheel2();

	/**
	 * @see #getWheel2()
	 */
	test.graph.data.Car setWheel2(test.graph.data.Circle value);

	/**
	 * Checks, whether {@link #getWheel2()} has a value.
	 */
	boolean hasWheel2();

	/**
	 * The car body.
	 */
	test.graph.data.Rectangle getBody();

	/**
	 * @see #getBody()
	 */
	test.graph.data.Car setBody(test.graph.data.Rectangle value);

	/**
	 * Checks, whether {@link #getBody()} has a value.
	 */
	boolean hasBody();

	@Override
	test.graph.data.Car setXCoordinate(int value);

	@Override
	test.graph.data.Car setYCoordinate(int value);

	/** Reads a new instance from the given reader. */
	static test.graph.data.Car readCar(de.haumacher.msgbuf.graph.Scope scope, de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		if (in.peek() == de.haumacher.msgbuf.json.JsonToken.NUMBER) {
			return (test.graph.data.Car) scope.resolveOrFail(in.nextInt());
		}
		in.beginArray();
		String type = in.nextString();
		assert CAR__TYPE.equals(type);
		int id = in.nextInt();
		test.graph.data.impl.Car_Impl result = new test.graph.data.impl.Car_Impl();
		scope.readData(result, id, in);
		in.endArray();
		return result;
	}

	/** Creates a new {@link Car} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Car readCar(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.graph.data.impl.Car_Impl.readCar_XmlContent(in);
	}

}
