package test.hierarchy.data;

/**
 * A circle {@link Shape}.
 */
public interface Circle extends AtomicShape {

	/**
	 * Creates a {@link test.hierarchy.data.Circle} instance.
	 */
	static test.hierarchy.data.Circle create() {
		return new test.hierarchy.data.impl.Circle_Impl();
	}

	/** Identifier for the {@link test.hierarchy.data.Circle} type in JSON format. */
	String CIRCLE__TYPE = "Circle";

	/** @see #getRadius() */
	String RADIUS__PROP = "r";

	/** Identifier for the {@link test.hierarchy.data.Circle} type in binary format. */
	static final int CIRCLE__TYPE_ID = 1;

	/** Identifier for the property {@link #getRadius()} in binary format. */
	static final int RADIUS__ID = 4;

	/**
	 * The radius of this {@link Circle} around its coordinate origin at ({@link #getXCoordinate()}, {@link #getYCoordinate()}).
	 */
	int getRadius();

	/**
	 * @see #getRadius()
	 */
	test.hierarchy.data.Circle setRadius(int value);

	@Override
	test.hierarchy.data.Circle setXCoordinate(int value);

	@Override
	test.hierarchy.data.Circle setYCoordinate(int value);

	@Override
	test.hierarchy.data.Circle setColor(test.hierarchy.data.Color value);

	/** Reads a new instance from the given reader. */
	static test.hierarchy.data.Circle readCircle(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.hierarchy.data.impl.Circle_Impl result = new test.hierarchy.data.impl.Circle_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.hierarchy.data.Circle readCircle(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.hierarchy.data.Circle result = test.hierarchy.data.impl.Circle_Impl.readCircle_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link Circle} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Circle readCircle(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.hierarchy.data.impl.Circle_Impl.readCircle_XmlContent(in);
	}

}
