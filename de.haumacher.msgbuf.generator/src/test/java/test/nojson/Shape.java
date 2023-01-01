package test.nojson;

/**
 * An abstract base class for all shapes
 */
public interface Shape extends de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/** Type codes for the {@link test.nojson.Shape} hierarchy. */
	public enum TypeKind {

		/** Type literal for {@link test.nojson.Circle}. */
		CIRCLE,

		/** Type literal for {@link test.nojson.Rectangle}. */
		RECTANGLE,

		/** Type literal for {@link test.nojson.Group}. */
		GROUP,

		/** Type literal for {@link test.nojson.Car}. */
		CAR,
		;

	}

	/** Visitor interface for the {@link test.nojson.Shape} hierarchy.*/
	public interface Visitor<R,A,E extends Throwable> extends test.nojson.AtomicShape.Visitor<R,A,E> {

		/** Visit case for {@link test.nojson.Group}.*/
		R visit(test.nojson.Group self, A arg) throws E;

		/** Visit case for {@link test.nojson.Car}.*/
		R visit(test.nojson.Car self, A arg) throws E;

	}

	/** @see #getXCoordinate() */
	static final String X_COORDINATE__PROP = "x";

	/** @see #getYCoordinate() */
	static final String Y_COORDINATE__PROP = "y";

	/** Identifier for the property {@link #getXCoordinate()} in binary format. */
	static final int X_COORDINATE__ID = 1;

	/** Identifier for the property {@link #getYCoordinate()} in binary format. */
	static final int Y_COORDINATE__ID = 2;

	/** The type code of this instance. */
	TypeKind kind();

	/**
	 * X coordinate of the origin of the coordinate system of this {@link Shape}.
	 */
	int getXCoordinate();

	/**
	 * @see #getXCoordinate()
	 */
	test.nojson.Shape setXCoordinate(int value);

	/**
	 * Y coordinate of the origin of the coordinate system of this {@link Shape}.
	 */
	int getYCoordinate();

	/**
	 * @see #getYCoordinate()
	 */
	test.nojson.Shape setYCoordinate(int value);

	@Override
	public test.nojson.Shape registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.nojson.Shape unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** The binary identifier for this concrete type in the polymorphic {@link test.nojson.Shape} hierarchy. */
	abstract int typeId();

	/** Reads a new instance from the given reader. */
	static test.nojson.Shape readShape(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		int typeField = in.nextName();
		assert typeField == 0;
		int type = in.nextInt();
		test.nojson.Shape result;
		switch (type) {
			case test.nojson.Group.GROUP__TYPE_ID: result = test.nojson.impl.Group_Impl.readGroup_Content(in); break;
			case test.nojson.Car.CAR__TYPE_ID: result = test.nojson.impl.Car_Impl.readCar_Content(in); break;
			case test.nojson.Circle.CIRCLE__TYPE_ID: result = test.nojson.impl.Circle_Impl.readCircle_Content(in); break;
			case test.nojson.Rectangle.RECTANGLE__TYPE_ID: result = test.nojson.impl.Rectangle_Impl.readRectangle_Content(in); break;
			default: result = null; while (in.hasNext()) {in.skipValue(); }
		}
		in.endObject();
		return result;
	}

	/** Creates a new {@link Shape} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Shape readShape(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.nojson.impl.Shape_Impl.readShape_XmlContent(in);
	}

	/** Accepts the given visitor. */
	public abstract <R,A,E extends Throwable> R visit(Visitor<R,A,E> v, A arg) throws E;

}
