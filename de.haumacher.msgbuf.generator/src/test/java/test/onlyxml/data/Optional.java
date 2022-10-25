package test.onlyxml.data;

/**
 * A shape that can be dynamically hidden.
 */
public interface Optional extends Shape {

	/**
	 * Creates a {@link Optional} instance.
	 */
	static Optional create() {
		return new test.onlyxml.data.Optional_Impl();
	}

	/**
	 * Whether {@link #getShape()} is hidden.
	 */
	boolean isHidden();

	/**
	 * @see #isHidden()
	 */
	Optional setHidden(boolean value);

	/**
	 * A {@link Shape} that can be dynamically hidden..
	 */
	Shape getShape();

	/**
	 * @see #getShape()
	 */
	Optional setShape(Shape value);

	/**
	 * Checks, whether {@link #getShape()} has a value.
	 */
	boolean hasShape();

	@Override
	Optional setXCoordinate(int value);

	@Override
	Optional setYCoordinate(int value);

	/** Creates a new {@link Optional} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Optional readOptional(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.onlyxml.data.Optional_Impl.readOptional_XmlContent(in);
	}

}
