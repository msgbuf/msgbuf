package test.nojson;

/**
 * A rectangle.
 */
public interface Rectangle extends AtomicShape {

	/**
	 * Creates a {@link test.nojson.Rectangle} instance.
	 */
	static test.nojson.Rectangle create() {
		return new test.nojson.impl.Rectangle_Impl();
	}

	/** Identifier for the {@link test.nojson.Rectangle} type in JSON format. */
	String RECTANGLE__TYPE = "Rectangle";

	/** @see #getWidth() */
	String WIDTH__PROP = "w";

	/** @see #getHeight() */
	String HEIGHT__PROP = "h";

	/** Identifier for the {@link test.nojson.Rectangle} type in binary format. */
	static final int RECTANGLE__TYPE_ID = 2;

	/** Identifier for the property {@link #getWidth()} in binary format. */
	static final int WIDTH__ID = 3;

	/** Identifier for the property {@link #getHeight()} in binary format. */
	static final int HEIGHT__ID = 4;

	/**
	 * The width of this {@link Rectangle}.
	 *
	 * <p>
	 * The top left corner of this {@Rectangle} is at ({@link #getXCoordinate()}, {@link #getYCoordinate()}).
	 * </p>
	 *
	 * @see #getHeight()
	 */
	int getWidth();

	/**
	 * @see #getWidth()
	 */
	test.nojson.Rectangle setWidth(int value);

	/**
	 * The width of this {@link Rectangle}.
	 *
	 * @see #getWidth()
	 */
	int getHeight();

	/**
	 * @see #getHeight()
	 */
	test.nojson.Rectangle setHeight(int value);

	@Override
	test.nojson.Rectangle setXCoordinate(int value);

	@Override
	test.nojson.Rectangle setYCoordinate(int value);

	/** Reads a new instance from the given reader. */
	static test.nojson.Rectangle readRectangle(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.nojson.Rectangle result = test.nojson.impl.Rectangle_Impl.readRectangle_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link Rectangle} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Rectangle readRectangle(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.nojson.impl.Rectangle_Impl.readRectangle_XmlContent(in);
	}

}
