package test.hierarchy.data;

/**
 * A shape that can be dynamically hidden.
 */
public interface Optional extends Shape {

	/**
	 * Creates a {@link Optional} instance.
	 */
	static Optional create() {
		return new test.hierarchy.data.Optional_Impl();
	}

	/** Identifier for the {@link Optional} type in JSON format. */
	static final String OPTIONAL__TYPE = "Optional";

	/** @see #isHidden() */
	static final String HIDDEN = "hidden";

	/** @see #getShape() */
	static final String SHAPE = "shape";

	/** Identifier for the {@link Optional} type in binary format. */
	static final int OPTIONAL__TYPE_ID = 4;

	/** Identifier for the property {@link #isHidden()} in binary format. */
	static final int HIDDEN__ID = 3;

	/** Identifier for the property {@link #getShape()} in binary format. */
	static final int SHAPE__ID = 4;

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


	/** Reads a new instance from the given reader. */
	static Optional readOptional(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.hierarchy.data.Optional_Impl result = new test.hierarchy.data.Optional_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static Optional readOptional(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		Optional result = test.hierarchy.data.Optional_Impl.readOptional_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link Optional} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Optional readOptional(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.hierarchy.data.Optional_Impl.readOptional_XmlContent(in);
	}

}
