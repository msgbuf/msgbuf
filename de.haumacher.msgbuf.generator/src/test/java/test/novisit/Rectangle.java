package test.novisit;

/**
 * A rectangle.
 */
public interface Rectangle extends AtomicShape {

	/**
	 * Creates a {@link Rectangle} instance.
	 */
	static Rectangle create() {
		return new test.novisit.Rectangle_Impl();
	}

	/** Identifier for the {@link Rectangle} type in JSON format. */
	static final String RECTANGLE__TYPE = "Rectangle";

	/** @see #getWidth() */
	static final String WIDTH = "w";

	/** @see #getHeight() */
	static final String HEIGHT = "h";

	/** Identifier for the {@link Rectangle} type in binary format. */
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
	Rectangle setWidth(int value);

	/**
	 * The width of this {@link Rectangle}.
	 *
	 * @see #getWidth()
	 */
	int getHeight();

	/**
	 * @see #getHeight()
	 */
	Rectangle setHeight(int value);

	@Override
	Rectangle setXCoordinate(int value);

	@Override
	Rectangle setYCoordinate(int value);


	/** Reads a new instance from the given reader. */
	static Rectangle readRectangle(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.novisit.Rectangle_Impl result = new test.novisit.Rectangle_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static Rectangle readRectangle(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		Rectangle result = test.novisit.Rectangle_Impl.readRectangle_Content(in);
		in.endObject();
		return result;
	}

}
