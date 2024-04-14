package test.hierarchy.data;

/**
 * A shape that can be dynamically hidden.
 */
public interface Optional extends Shape {

	/**
	 * Creates a {@link test.hierarchy.data.Optional} instance.
	 */
	static test.hierarchy.data.Optional create() {
		return new test.hierarchy.data.impl.Optional_Impl();
	}

	/** Identifier for the {@link test.hierarchy.data.Optional} type in JSON format. */
	String OPTIONAL__TYPE = "Optional";

	/** @see #isHidden() */
	String HIDDEN__PROP = "hidden";

	/** @see #getShape() */
	String SHAPE__PROP = "shape";

	/** Identifier for the {@link test.hierarchy.data.Optional} type in binary format. */
	static final int OPTIONAL__TYPE_ID = 4;

	/** Identifier for the property {@link #isHidden()} in binary format. */
	static final int HIDDEN__ID = 4;

	/** Identifier for the property {@link #getShape()} in binary format. */
	static final int SHAPE__ID = 5;

	/**
	 * Whether {@link #getShape()} is hidden.
	 */
	boolean isHidden();

	/**
	 * @see #isHidden()
	 */
	test.hierarchy.data.Optional setHidden(boolean value);

	/**
	 * A {@link Shape} that can be dynamically hidden.
	 */
	test.hierarchy.data.Shape getShape();

	/**
	 * @see #getShape()
	 */
	test.hierarchy.data.Optional setShape(test.hierarchy.data.Shape value);

	/**
	 * Checks, whether {@link #getShape()} has a value.
	 */
	boolean hasShape();

	@Override
	test.hierarchy.data.Optional setXCoordinate(int value);

	@Override
	test.hierarchy.data.Optional setYCoordinate(int value);

	@Override
	test.hierarchy.data.Optional setColor(test.hierarchy.data.Color value);

	/** Reads a new instance from the given reader. */
	static test.hierarchy.data.Optional readOptional(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.hierarchy.data.impl.Optional_Impl result = new test.hierarchy.data.impl.Optional_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.hierarchy.data.Optional readOptional(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.hierarchy.data.Optional result = test.hierarchy.data.impl.Optional_Impl.readOptional_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link Optional} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Optional readOptional(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.hierarchy.data.impl.Optional_Impl.readOptional_XmlContent(in);
	}

}
