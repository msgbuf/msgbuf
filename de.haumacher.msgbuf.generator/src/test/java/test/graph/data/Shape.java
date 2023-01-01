package test.graph.data;

/**
 * An abstract base class for all shapes
 */
public interface Shape extends de.haumacher.msgbuf.graph.SharedGraphNode, de.haumacher.msgbuf.xml.XmlSerializable {

	/** Type codes for the {@link test.graph.data.Shape} hierarchy. */
	public enum TypeKind {

		/** Type literal for {@link test.graph.data.Circle}. */
		CIRCLE,

		/** Type literal for {@link test.graph.data.Rectangle}. */
		RECTANGLE,

		/** Type literal for {@link test.graph.data.Group}. */
		GROUP,

		/** Type literal for {@link test.graph.data.Car}. */
		CAR,
		;

	}

	/** Visitor interface for the {@link test.graph.data.Shape} hierarchy.*/
	public interface Visitor<R,A,E extends Throwable> extends test.graph.data.AtomicShape.Visitor<R,A,E> {

		/** Visit case for {@link test.graph.data.Group}.*/
		R visit(test.graph.data.Group self, A arg) throws E;

		/** Visit case for {@link test.graph.data.Car}.*/
		R visit(test.graph.data.Car self, A arg) throws E;

	}

	/** @see #getXCoordinate() */
	String X_COORDINATE__PROP = "x";

	/** @see #getYCoordinate() */
	String Y_COORDINATE__PROP = "y";

	/** The type code of this instance. */
	TypeKind kind();

	/**
	 * X coordinate of the origin of the coordinate system of this {@link Shape}.
	 */
	int getXCoordinate();

	/**
	 * @see #getXCoordinate()
	 */
	test.graph.data.Shape setXCoordinate(int value);

	/**
	 * Y coordinate of the origin of the coordinate system of this {@link Shape}.
	 */
	int getYCoordinate();

	/**
	 * @see #getYCoordinate()
	 */
	test.graph.data.Shape setYCoordinate(int value);

	/** Reads a new instance from the given reader. */
	static test.graph.data.Shape readShape(de.haumacher.msgbuf.graph.Scope scope, de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		if (in.peek() == de.haumacher.msgbuf.json.JsonToken.NUMBER) {
			return (test.graph.data.Shape) scope.resolveOrFail(in.nextInt());
		}
		test.graph.data.Shape result;
		in.beginArray();
		String type = in.nextString();
		int id = in.nextInt();
		switch (type) {
			case Group.GROUP__TYPE: result = test.graph.data.Group.create(); break;
			case Car.CAR__TYPE: result = test.graph.data.Car.create(); break;
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

	/** Creates a new {@link Shape} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Shape readShape(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.graph.data.impl.Shape_Impl.readShape_XmlContent(in);
	}

	/** Accepts the given visitor. */
	public abstract <R,A,E extends Throwable> R visit(Visitor<R,A,E> v, A arg) throws E;

}
