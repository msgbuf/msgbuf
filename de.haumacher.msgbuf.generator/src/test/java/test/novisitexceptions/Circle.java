package test.novisitexceptions;

/**
 * A circle {@link Shape}.
 */
public interface Circle extends AtomicShape {

	/**
	 * Creates a {@link test.novisitexceptions.Circle} instance.
	 */
	static test.novisitexceptions.Circle create() {
		return new test.novisitexceptions.impl.Circle_Impl();
	}

	/** Identifier for the {@link test.novisitexceptions.Circle} type in JSON format. */
	String CIRCLE__TYPE = "Circle";

	/** @see #getRadius() */
	String RADIUS__PROP = "r";

	/** Identifier for the {@link test.novisitexceptions.Circle} type in binary format. */
	static final int CIRCLE__TYPE_ID = 1;

	/** Identifier for the property {@link #getRadius()} in binary format. */
	static final int RADIUS__ID = 3;

	/**
	 * The radius of this {@link Circle} around its coordinate origin at ({@link #getXCoordinate()}, {@link #getYCoordinate()}).
	 */
	int getRadius();

	/**
	 * @see #getRadius()
	 */
	test.novisitexceptions.Circle setRadius(int value);

	@Override
	test.novisitexceptions.Circle setXCoordinate(int value);

	@Override
	test.novisitexceptions.Circle setYCoordinate(int value);

	/** Reads a new instance from the given reader. */
	static test.novisitexceptions.Circle readCircle(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.novisitexceptions.impl.Circle_Impl result = new test.novisitexceptions.impl.Circle_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.novisitexceptions.Circle readCircle(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.novisitexceptions.Circle result = test.novisitexceptions.impl.Circle_Impl.readCircle_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link Circle} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Circle readCircle(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.novisitexceptions.impl.Circle_Impl.readCircle_XmlContent(in);
	}

}
