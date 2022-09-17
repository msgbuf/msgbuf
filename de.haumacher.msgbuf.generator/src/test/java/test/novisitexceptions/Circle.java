package test.novisitexceptions;

/**
 * A circle {@link Shape}.
 */
public interface Circle extends AtomicShape {

	/**
	 * Creates a {@link Circle} instance.
	 */
	static Circle create() {
		return new test.novisitexceptions.Circle_Impl();
	}

	/** Identifier for the {@link Circle} type in JSON format. */
	static final String CIRCLE__TYPE = "Circle";

	/** @see #getRadius() */
	static final String RADIUS = "r";

	/** Identifier for the {@link Circle} type in binary format. */
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
	Circle setRadius(int value);

	@Override
	Circle setXCoordinate(int value);

	@Override
	Circle setYCoordinate(int value);


	/** Reads a new instance from the given reader. */
	static Circle readCircle(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.novisitexceptions.Circle_Impl result = new test.novisitexceptions.Circle_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static Circle readCircle(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		Circle result = test.novisitexceptions.Circle_Impl.readCircle_Content(in);
		in.endObject();
		return result;
	}

}
