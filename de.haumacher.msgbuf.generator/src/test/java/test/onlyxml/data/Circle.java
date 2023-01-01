package test.onlyxml.data;

/**
 * A circle {@link Shape}.
 */
public interface Circle extends AtomicShape {

	/**
	 * Creates a {@link test.onlyxml.data.Circle} instance.
	 */
	static test.onlyxml.data.Circle create() {
		return new test.onlyxml.data.impl.Circle_Impl();
	}

	/**
	 * The radius of this {@link Circle} around its coordinate origin at ({@link #getXCoordinate()}, {@link #getYCoordinate()}).
	 */
	int getRadius();

	/**
	 * @see #getRadius()
	 */
	test.onlyxml.data.Circle setRadius(int value);

	@Override
	test.onlyxml.data.Circle setXCoordinate(int value);

	@Override
	test.onlyxml.data.Circle setYCoordinate(int value);

	/** Creates a new {@link Circle} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Circle readCircle(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.onlyxml.data.impl.Circle_Impl.readCircle_XmlContent(in);
	}

}
