package test.graph.data;

/**
 * A group of shapes.
 */
public interface Group extends Shape {

	/**
	 * Creates a {@link test.graph.data.Group} instance.
	 */
	static test.graph.data.Group create() {
		return new test.graph.data.impl.Group_Impl();
	}

	/** Identifier for the {@link test.graph.data.Group} type in JSON format. */
	String GROUP__TYPE = "Group";

	/** @see #getShapes() */
	String SHAPES__PROP = "shapes";

	/**
	 * All {@link Shape}s in this {@link Group}.
	 *
	 * <p>
	 * The origins of these {@link Shape}s get a coordinate offset of ({@link #getXCoordinate()}, {@link #getYCoordinate()}).
	 * </p>
	 */
	java.util.List<test.graph.data.Shape> getShapes();

	/**
	 * @see #getShapes()
	 */
	test.graph.data.Group setShapes(java.util.List<? extends test.graph.data.Shape> value);

	/**
	 * Adds a value to the {@link #getShapes()} list.
	 */
	test.graph.data.Group addShape(test.graph.data.Shape value);

	/**
	 * Removes a value from the {@link #getShapes()} list.
	 */
	void removeShape(test.graph.data.Shape value);

	@Override
	test.graph.data.Group setXCoordinate(int value);

	@Override
	test.graph.data.Group setYCoordinate(int value);

	/** Reads a new instance from the given reader. */
	static test.graph.data.Group readGroup(de.haumacher.msgbuf.graph.Scope scope, de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		if (in.peek() == de.haumacher.msgbuf.json.JsonToken.NUMBER) {
			return (test.graph.data.Group) scope.resolveOrFail(in.nextInt());
		}
		in.beginArray();
		String type = in.nextString();
		assert GROUP__TYPE.equals(type);
		int id = in.nextInt();
		test.graph.data.impl.Group_Impl result = new test.graph.data.impl.Group_Impl();
		scope.readData(result, id, in);
		in.endArray();
		return result;
	}

	/** Creates a new {@link Group} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Group readGroup(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.graph.data.impl.Group_Impl.readGroup_XmlContent(in);
	}

}
