package test.graph.data;

/**
 * A {@link Shape} that has no sub-shapes.
 */
public interface AtomicShape extends Shape {

	/** Visitor interface for the {@link test.graph.data.AtomicShape} hierarchy.*/
	public interface Visitor<R,A,E extends Throwable> {

		/** Visit case for {@link test.graph.data.Circle}.*/
		R visit(test.graph.data.Circle self, A arg) throws E;

		/** Visit case for {@link test.graph.data.Rectangle}.*/
		R visit(test.graph.data.Rectangle self, A arg) throws E;

	}

	@Override
	test.graph.data.AtomicShape setXCoordinate(int value);

	@Override
	test.graph.data.AtomicShape setYCoordinate(int value);

	/** Reads a new instance from the given reader. */
	static test.graph.data.AtomicShape readAtomicShape(de.haumacher.msgbuf.graph.Scope scope, de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		if (in.peek() == de.haumacher.msgbuf.json.JsonToken.NUMBER) {
			return (test.graph.data.AtomicShape) scope.resolveOrFail(in.nextInt());
		}
		test.graph.data.AtomicShape result;
		in.beginArray();
		String type = in.nextString();
		int id = in.nextInt();
		switch (type) {
			case Circle.CIRCLE__TYPE: result = test.graph.data.Circle.create(); break;
			case Rectangle.RECTANGLE__TYPE: result = test.graph.data.Rectangle.create(); break;
			default: in.skipValue(); result = null; break;
		}
		if (result != null) {
			scope.readData(result, id, in);
		}
		in.endArray();
		return result;
	}

	/** Creates a new {@link AtomicShape} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static AtomicShape readAtomicShape(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.graph.data.impl.AtomicShape_Impl.readAtomicShape_XmlContent(in);
	}

	/** Accepts the given visitor. */
	public abstract <R,A,E extends Throwable> R visit(Visitor<R,A,E> v, A arg) throws E;

}
