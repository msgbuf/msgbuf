package test.graph.data;

/**
 * A group of shapes.
 */
public interface Group extends Shape {

	/**
	 * Creates a {@link Group} instance.
	 */
	static Group create() {
		return new test.graph.data.Group_Impl();
	}

	/** Identifier for the {@link Group} type in JSON format. */
	static final String GROUP__TYPE = "Group";

	/** @see #getShapes() */
	static final String SHAPES = "shapes";

	/**
	 * All {@link Shape}s in this {@link Group}.
	 *
	 * <p>
	 * The origins of these {@link Shape}s get a coordinate offset of ({@link #getXCoordinate()}, {@link #getYCoordinate()}).
	 * </p>
	 */
	java.util.List<Shape> getShapes();

	/**
	 * @see #getShapes()
	 */
	Group setShapes(java.util.List<? extends Shape> value);

	/**
	 * Adds a value to the {@link #getShapes()} list.
	 */
	Group addShape(Shape value);

	/**
	 * Removes a value from the {@link #getShapes()} list.
	 */
	void removeShape(Shape value);

	@Override
	Group setXCoordinate(int value);

	@Override
	Group setYCoordinate(int value);


	/** Reads a new instance from the given reader. */
	static Group readGroup(de.haumacher.msgbuf.graph.Scope scope, de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		if (in.peek() == de.haumacher.msgbuf.json.JsonToken.NUMBER) {
			return (Group) scope.resolveOrFail(in.nextInt());
		}
		in.beginArray();
		String type = in.nextString();
		assert GROUP__TYPE.equals(type);
		int id = in.nextInt();
		test.graph.data.Group_Impl result = new test.graph.data.Group_Impl();
		scope.readData(result, id, in);
		in.endArray();
		return result;
	}

}
