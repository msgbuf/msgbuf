package test.nested.data;

/**
 * A top-level holder of values of nested abstract types.
 */
public interface Holder extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/**
	 * Creates a {@link test.nested.data.Holder} instance.
	 */
	static test.nested.data.Holder create() {
		return new test.nested.data.impl.Holder_Impl();
	}

	/** Identifier for the {@link test.nested.data.Holder} type in JSON format. */
	String HOLDER__TYPE = "Holder";

	/** @see #getShape() */
	String SHAPE__PROP = "shape";

	/** @see #getShapes() */
	String SHAPES__PROP = "shapes";

	/** @see #getNode() */
	String NODE__PROP = "node";

	/** @see #getAnimals() */
	String ANIMALS__PROP = "animals";

	/** Identifier for the property {@link #getShape()} in binary format. */
	static final int SHAPE__ID = 1;

	/** Identifier for the property {@link #getShapes()} in binary format. */
	static final int SHAPES__ID = 2;

	/** Identifier for the property {@link #getNode()} in binary format. */
	static final int NODE__ID = 3;

	/** Identifier for the property {@link #getAnimals()} in binary format. */
	static final int ANIMALS__ID = 4;

	test.nested.data.Outer.Shape getShape();

	/**
	 * @see #getShape()
	 */
	test.nested.data.Holder setShape(test.nested.data.Outer.Shape value);

	/**
	 * Checks, whether {@link #getShape()} has a value.
	 */
	boolean hasShape();

	java.util.List<test.nested.data.Outer.Shape> getShapes();

	/**
	 * @see #getShapes()
	 */
	test.nested.data.Holder setShapes(java.util.List<? extends test.nested.data.Outer.Shape> value);

	/**
	 * Adds a value to the {@link #getShapes()} list.
	 */
	test.nested.data.Holder addShapes(test.nested.data.Outer.Shape value);

	/**
	 * Removes a value from the {@link #getShapes()} list.
	 */
	void removeShapes(test.nested.data.Outer.Shape value);

	test.nested.data.Level1.Level2.Node getNode();

	/**
	 * @see #getNode()
	 */
	test.nested.data.Holder setNode(test.nested.data.Level1.Level2.Node value);

	/**
	 * Checks, whether {@link #getNode()} has a value.
	 */
	boolean hasNode();

	java.util.List<test.nested.data.Animal> getAnimals();

	/**
	 * @see #getAnimals()
	 */
	test.nested.data.Holder setAnimals(java.util.List<? extends test.nested.data.Animal> value);

	/**
	 * Adds a value to the {@link #getAnimals()} list.
	 */
	test.nested.data.Holder addAnimal(test.nested.data.Animal value);

	/**
	 * Removes a value from the {@link #getAnimals()} list.
	 */
	void removeAnimal(test.nested.data.Animal value);

	@Override
	public test.nested.data.Holder registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.nested.data.Holder unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.nested.data.Holder readHolder(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.nested.data.impl.Holder_Impl result = new test.nested.data.impl.Holder_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.nested.data.Holder readHolder(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.nested.data.Holder result = test.nested.data.impl.Holder_Impl.readHolder_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link Holder} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Holder readHolder(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.nested.data.impl.Holder_Impl.readHolder_XmlContent(in);
	}

}
