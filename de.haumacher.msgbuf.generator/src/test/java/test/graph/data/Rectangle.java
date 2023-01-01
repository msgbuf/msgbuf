package test.graph.data;

/**
 * A rectangle.
 */
public interface Rectangle extends AtomicShape {

	/**
	 * Creates a {@link test.graph.data.Rectangle} instance.
	 */
	static test.graph.data.Rectangle create() {
		return new test.graph.data.impl.Rectangle_Impl();
	}

	/** Identifier for the {@link test.graph.data.Rectangle} type in JSON format. */
	static final String RECTANGLE__TYPE = "Rectangle";

	/** @see #getWidth() */
	static final String WIDTH__PROP = "w";

	/** @see #getHeight() */
	static final String HEIGHT__PROP = "h";

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
	test.graph.data.Rectangle setWidth(int value);

	/**
	 * The width of this {@link Rectangle}.
	 *
	 * @see #getWidth()
	 */
	int getHeight();

	/**
	 * @see #getHeight()
	 */
	test.graph.data.Rectangle setHeight(int value);

	@Override
	test.graph.data.Rectangle setXCoordinate(int value);

	@Override
	test.graph.data.Rectangle setYCoordinate(int value);

	/** Reads a new instance from the given reader. */
	static test.graph.data.Rectangle readRectangle(de.haumacher.msgbuf.graph.Scope scope, de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		if (in.peek() == de.haumacher.msgbuf.json.JsonToken.NUMBER) {
			return (test.graph.data.Rectangle) scope.resolveOrFail(in.nextInt());
		}
		in.beginArray();
		String type = in.nextString();
		assert RECTANGLE__TYPE.equals(type);
		int id = in.nextInt();
		test.graph.data.impl.Rectangle_Impl result = new test.graph.data.impl.Rectangle_Impl();
		scope.readData(result, id, in);
		in.endArray();
		return result;
	}

	/** Creates a new {@link Rectangle} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Rectangle readRectangle(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.graph.data.impl.Rectangle_Impl.readRectangle_XmlContent(in);
	}

}
