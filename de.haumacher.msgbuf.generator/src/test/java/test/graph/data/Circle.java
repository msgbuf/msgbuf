package test.graph.data;

/**
 * A circle {@link Shape}.
 */
public interface Circle extends AtomicShape {

	/**
	 * Creates a {@link Circle} instance.
	 */
	static Circle create() {
		return new test.graph.data.Circle_Impl();
	}

	/** Identifier for the {@link Circle} type in JSON format. */
	static final String CIRCLE__TYPE = "Circle";

	/** @see #getRadius() */
	static final String RADIUS__PROP = "r";

	/**
	 * The radius of this {@link Circle} around its coordinate origin at ({@link #getXCoordinate()}, {@link #getYCoordinate()}).
	 */
	int getRadius();

	/**
	 * @see #getRadius()
	 */
	Circle setRadius(int value);

	@Override
	Circle setXCoordinate(int value);

	@Override
	Circle setYCoordinate(int value);

	/** Reads a new instance from the given reader. */
	static Circle readCircle(de.haumacher.msgbuf.graph.Scope scope, de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		if (in.peek() == de.haumacher.msgbuf.json.JsonToken.NUMBER) {
			return (Circle) scope.resolveOrFail(in.nextInt());
		}
		in.beginArray();
		String type = in.nextString();
		assert CIRCLE__TYPE.equals(type);
		int id = in.nextInt();
		test.graph.data.Circle_Impl result = new test.graph.data.Circle_Impl();
		scope.readData(result, id, in);
		in.endArray();
		return result;
	}

	/** Creates a new {@link Circle} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Circle readCircle(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.graph.data.Circle_Impl.readCircle_XmlContent(in);
	}

}
