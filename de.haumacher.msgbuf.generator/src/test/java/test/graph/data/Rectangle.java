package test.graph.data;

/**
 * A rectangle.
 */
public interface Rectangle extends AtomicShape {

	/**
	 * Creates a {@link Rectangle} instance.
	 */
	static Rectangle create() {
		return new test.graph.data.Rectangle_Impl();
	}

	/** Identifier for the {@link Rectangle} type in JSON format. */
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
	static Rectangle readRectangle(de.haumacher.msgbuf.graph.Scope scope, de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		if (in.peek() == de.haumacher.msgbuf.json.JsonToken.NUMBER) {
			return (Rectangle) scope.resolveOrFail(in.nextInt());
		}
		in.beginArray();
		String type = in.nextString();
		assert RECTANGLE__TYPE.equals(type);
		int id = in.nextInt();
		test.graph.data.Rectangle_Impl result = new test.graph.data.Rectangle_Impl();
		scope.readData(result, id, in);
		in.endArray();
		return result;
	}

	/** Creates a new {@link Rectangle} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Rectangle readRectangle(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.graph.data.Rectangle_Impl.readRectangle_XmlContent(in);
	}

}
