package test.onlyxml.data;

/**
 * A rectangle.
 */
public interface Rectangle extends AtomicShape {

	/**
	 * Creates a {@link test.onlyxml.data.Rectangle} instance.
	 */
	static test.onlyxml.data.Rectangle create() {
		return new test.onlyxml.data.impl.Rectangle_Impl();
	}

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
	test.onlyxml.data.Rectangle setWidth(int value);

	/**
	 * The width of this {@link Rectangle}.
	 *
	 * @see #getWidth()
	 */
	int getHeight();

	/**
	 * @see #getHeight()
	 */
	test.onlyxml.data.Rectangle setHeight(int value);

	@Override
	test.onlyxml.data.Rectangle setXCoordinate(int value);

	@Override
	test.onlyxml.data.Rectangle setYCoordinate(int value);

	/** Creates a new {@link Rectangle} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Rectangle readRectangle(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.onlyxml.data.impl.Rectangle_Impl.readRectangle_XmlContent(in);
	}

}
