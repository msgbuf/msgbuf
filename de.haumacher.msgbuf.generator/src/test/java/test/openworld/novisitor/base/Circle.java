package test.openworld.novisitor.base;

public interface Circle extends test.openworld.novisitor.base.Shape {

	/**
	 * Creates a {@link test.openworld.novisitor.base.Circle} instance.
	 */
	static test.openworld.novisitor.base.Circle create() {
		return new test.openworld.novisitor.base.impl.Circle_Impl();
	}

	/** Identifier for the {@link test.openworld.novisitor.base.Circle} type in JSON format. */
	String CIRCLE__TYPE = "Circle";

	/** @see #getRadius() */
	String RADIUS__PROP = "radius";

	int getRadius();

	/**
	 * @see #getRadius()
	 */
	test.openworld.novisitor.base.Circle setRadius(int value);

	@Override
	test.openworld.novisitor.base.Circle setName(String value);

	/** Reads a new instance from the given reader. */
	static test.openworld.novisitor.base.Circle readCircle(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.openworld.novisitor.base.impl.Circle_Impl result = new test.openworld.novisitor.base.impl.Circle_Impl();
		result.readContent(in);
		return result;
	}

	/** Creates a new {@link Circle} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Circle readCircle(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.openworld.novisitor.base.impl.Circle_Impl.readCircle_XmlContent(in);
	}

}
