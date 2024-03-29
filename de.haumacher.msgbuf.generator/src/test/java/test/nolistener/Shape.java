package test.nolistener;

/**
 * An abstract base class for all shapes
 */
public interface Shape extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.data.ReflectiveDataObject, de.haumacher.msgbuf.xml.XmlSerializable {

	/** Type codes for the {@link test.nolistener.Shape} hierarchy. */
	public enum TypeKind {

		/** Type literal for {@link test.nolistener.Circle}. */
		CIRCLE,

		/** Type literal for {@link test.nolistener.Rectangle}. */
		RECTANGLE,

		/** Type literal for {@link test.nolistener.Group}. */
		GROUP,

		/** Type literal for {@link test.nolistener.Car}. */
		CAR,
		;

	}

	/** Visitor interface for the {@link test.nolistener.Shape} hierarchy.*/
	public interface Visitor<R,A,E extends Throwable> extends test.nolistener.AtomicShape.Visitor<R,A,E> {

		/** Visit case for {@link test.nolistener.Group}.*/
		R visit(test.nolistener.Group self, A arg) throws E;

		/** Visit case for {@link test.nolistener.Car}.*/
		R visit(test.nolistener.Car self, A arg) throws E;

	}

	/** @see #getXCoordinate() */
	String X_COORDINATE__PROP = "x";

	/** @see #getYCoordinate() */
	String Y_COORDINATE__PROP = "y";

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
	test.nolistener.Shape setXCoordinate(int value);

	/**
	 * Y coordinate of the origin of the coordinate system of this {@link Shape}.
	 */
	int getYCoordinate();

	/**
	 * @see #getYCoordinate()
	 */
	test.nolistener.Shape setYCoordinate(int value);

	/** Reads a new instance from the given reader. */
	static test.nolistener.Shape readShape(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.nolistener.Shape result;
		in.beginArray();
		String type = in.nextString();
		switch (type) {
			case Group.GROUP__TYPE: result = test.nolistener.Group.readGroup(in); break;
			case Car.CAR__TYPE: result = test.nolistener.Car.readCar(in); break;
			case Circle.CIRCLE__TYPE: result = test.nolistener.Circle.readCircle(in); break;
			case Rectangle.RECTANGLE__TYPE: result = test.nolistener.Rectangle.readRectangle(in); break;
			default: in.skipValue(); result = null; break;
		}
		in.endArray();
		return result;
	}

	/** The binary identifier for this concrete type in the polymorphic {@link test.nolistener.Shape} hierarchy. */
	abstract int typeId();

	/** Reads a new instance from the given reader. */
	static test.nolistener.Shape readShape(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		int typeField = in.nextName();
		assert typeField == 0;
		int type = in.nextInt();
		test.nolistener.Shape result;
		switch (type) {
			case test.nolistener.Group.GROUP__TYPE_ID: result = test.nolistener.impl.Group_Impl.readGroup_Content(in); break;
			case test.nolistener.Car.CAR__TYPE_ID: result = test.nolistener.impl.Car_Impl.readCar_Content(in); break;
			case test.nolistener.Circle.CIRCLE__TYPE_ID: result = test.nolistener.impl.Circle_Impl.readCircle_Content(in); break;
			case test.nolistener.Rectangle.RECTANGLE__TYPE_ID: result = test.nolistener.impl.Rectangle_Impl.readRectangle_Content(in); break;
			default: result = null; while (in.hasNext()) {in.skipValue(); }
		}
		in.endObject();
		return result;
	}

	/** Creates a new {@link Shape} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Shape readShape(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.nolistener.impl.Shape_Impl.readShape_XmlContent(in);
	}

	/** Accepts the given visitor. */
	public abstract <R,A,E extends Throwable> R visit(Visitor<R,A,E> v, A arg) throws E;

}
