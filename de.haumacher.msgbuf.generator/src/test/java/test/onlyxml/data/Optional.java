package test.onlyxml.data;

/**
 * A shape that can be dynamically hidden.
 */
public interface Optional extends Shape {

	/**
	 * Creates a {@link test.onlyxml.data.Optional} instance.
	 */
	static test.onlyxml.data.Optional create() {
		return new test.onlyxml.data.impl.Optional_Impl();
	}

	/**
	 * Whether {@link #getShape()} is hidden.
	 */
	boolean isHidden();

	/**
	 * @see #isHidden()
	 */
	test.onlyxml.data.Optional setHidden(boolean value);

	/**
	 * A {@link Shape} that can be dynamically hidden..
	 */
	test.onlyxml.data.Shape getShape();

	/**
	 * @see #getShape()
	 */
	test.onlyxml.data.Optional setShape(test.onlyxml.data.Shape value);

	/**
	 * Checks, whether {@link #getShape()} has a value.
	 */
	boolean hasShape();

	@Override
	test.onlyxml.data.Optional setXCoordinate(int value);

	@Override
	test.onlyxml.data.Optional setYCoordinate(int value);

	/** Creates a new {@link Optional} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Optional readOptional(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.onlyxml.data.impl.Optional_Impl.readOptional_XmlContent(in);
	}

}
