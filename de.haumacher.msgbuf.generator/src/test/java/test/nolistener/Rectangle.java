package test.nolistener;

/**
 * A rectangle.
 */
public interface Rectangle extends AtomicShape {

	/**
	 * Creates a {@link test.nolistener.Rectangle} instance.
	 */
	static test.nolistener.Rectangle create() {
		return new test.nolistener.impl.Rectangle_Impl();
	}

	/** Identifier for the {@link test.nolistener.Rectangle} type in JSON format. */
	String RECTANGLE__TYPE = "Rectangle";

	/** @see #getWidth() */
	String WIDTH__PROP = "w";

	/** @see #getHeight() */
	String HEIGHT__PROP = "h";

	/** Identifier for the {@link test.nolistener.Rectangle} type in binary format. */
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
	test.nolistener.Rectangle setWidth(int value);

	/**
	 * The width of this {@link Rectangle}.
	 *
	 * @see #getWidth()
	 */
	int getHeight();

	/**
	 * @see #getHeight()
	 */
	test.nolistener.Rectangle setHeight(int value);

	@Override
	test.nolistener.Rectangle setXCoordinate(int value);

	@Override
	test.nolistener.Rectangle setYCoordinate(int value);

	/** Reads a new instance from the given reader. */
	static test.nolistener.Rectangle readRectangle(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.nolistener.impl.Rectangle_Impl result = new test.nolistener.impl.Rectangle_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.nolistener.Rectangle readRectangle(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.nolistener.Rectangle result = test.nolistener.impl.Rectangle_Impl.readRectangle_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link Rectangle} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Rectangle readRectangle(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.nolistener.impl.Rectangle_Impl.readRectangle_XmlContent(in);
	}

}
