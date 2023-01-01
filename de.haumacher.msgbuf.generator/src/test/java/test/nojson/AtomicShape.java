package test.nojson;

/**
 * A {@link Shape} that has no sub-shapes.
 */
public interface AtomicShape extends Shape {

	/** Visitor interface for the {@link test.nojson.AtomicShape} hierarchy.*/
	public interface Visitor<R,A,E extends Throwable> {

		/** Visit case for {@link test.nojson.Circle}.*/
		R visit(test.nojson.Circle self, A arg) throws E;

		/** Visit case for {@link test.nojson.Rectangle}.*/
		R visit(test.nojson.Rectangle self, A arg) throws E;

	}

	@Override
	test.nojson.AtomicShape setXCoordinate(int value);

	@Override
	test.nojson.AtomicShape setYCoordinate(int value);

	/** Reads a new instance from the given reader. */
	static test.nojson.AtomicShape readAtomicShape(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		int typeField = in.nextName();
		assert typeField == 0;
		int type = in.nextInt();
		test.nojson.AtomicShape result;
		switch (type) {
			case test.nojson.Circle.CIRCLE__TYPE_ID: result = test.nojson.impl.Circle_Impl.readCircle_Content(in); break;
			case test.nojson.Rectangle.RECTANGLE__TYPE_ID: result = test.nojson.impl.Rectangle_Impl.readRectangle_Content(in); break;
			default: result = null; while (in.hasNext()) {in.skipValue(); }
		}
		in.endObject();
		return result;
	}

	/** Creates a new {@link AtomicShape} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static AtomicShape readAtomicShape(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.nojson.impl.AtomicShape_Impl.readAtomicShape_XmlContent(in);
	}

	/** Accepts the given visitor. */
	public abstract <R,A,E extends Throwable> R visit(Visitor<R,A,E> v, A arg) throws E;

}
