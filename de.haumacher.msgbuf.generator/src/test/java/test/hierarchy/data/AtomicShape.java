package test.hierarchy.data;

/**
 * A {@link Shape} that has no sub-shapes.
 */
public interface AtomicShape extends Shape {

	/** Visitor interface for the {@link test.hierarchy.data.AtomicShape} hierarchy.*/
	public interface Visitor<R,A,E extends Throwable> {

		/** Visit case for {@link test.hierarchy.data.Circle}.*/
		R visit(test.hierarchy.data.Circle self, A arg) throws E;

		/** Visit case for {@link test.hierarchy.data.Rectangle}.*/
		R visit(test.hierarchy.data.Rectangle self, A arg) throws E;

	}

	@Override
	test.hierarchy.data.AtomicShape setXCoordinate(int value);

	@Override
	test.hierarchy.data.AtomicShape setYCoordinate(int value);

	@Override
	test.hierarchy.data.AtomicShape setColor(test.hierarchy.data.Color value);

	/** Reads a new instance from the given reader. */
	static test.hierarchy.data.AtomicShape readAtomicShape(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.hierarchy.data.AtomicShape result;
		in.beginArray();
		String type = in.nextString();
		switch (type) {
			case Circle.CIRCLE__TYPE: result = test.hierarchy.data.Circle.readCircle(in); break;
			case Rectangle.RECTANGLE__TYPE: result = test.hierarchy.data.Rectangle.readRectangle(in); break;
			default: in.skipValue(); result = null; break;
		}
		in.endArray();
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.hierarchy.data.AtomicShape readAtomicShape(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		int typeField = in.nextName();
		assert typeField == 0;
		int type = in.nextInt();
		test.hierarchy.data.AtomicShape result;
		switch (type) {
			case test.hierarchy.data.Circle.CIRCLE__TYPE_ID: result = test.hierarchy.data.impl.Circle_Impl.readCircle_Content(in); break;
			case test.hierarchy.data.Rectangle.RECTANGLE__TYPE_ID: result = test.hierarchy.data.impl.Rectangle_Impl.readRectangle_Content(in); break;
			default: result = null; while (in.hasNext()) {in.skipValue(); }
		}
		in.endObject();
		return result;
	}

	/** Creates a new {@link AtomicShape} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static AtomicShape readAtomicShape(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.hierarchy.data.impl.AtomicShape_Impl.readAtomicShape_XmlContent(in);
	}

	/** Accepts the given visitor. */
	public abstract <R,A,E extends Throwable> R visit(Visitor<R,A,E> v, A arg) throws E;

}
