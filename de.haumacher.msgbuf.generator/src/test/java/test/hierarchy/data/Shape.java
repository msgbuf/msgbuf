package test.hierarchy.data;

/**
 * An abstract base class for all shapes
 */
public interface Shape extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/** Type codes for the {@link test.hierarchy.data.Shape} hierarchy. */
	public enum TypeKind {

		/** Type literal for {@link test.hierarchy.data.Circle}. */
		CIRCLE,

		/** Type literal for {@link test.hierarchy.data.Rectangle}. */
		RECTANGLE,

		/** Type literal for {@link test.hierarchy.data.Group}. */
		GROUP,

		/** Type literal for {@link test.hierarchy.data.Optional}. */
		OPTIONAL,

		/** Type literal for {@link test.hierarchy.data.Car}. */
		CAR,
		;

	}

	/** Visitor interface for the {@link test.hierarchy.data.Shape} hierarchy.*/
	public interface Visitor<R,A,E extends Throwable> extends test.hierarchy.data.AtomicShape.Visitor<R,A,E> {

		/** Visit case for {@link test.hierarchy.data.Group}.*/
		R visit(test.hierarchy.data.Group self, A arg) throws E;

		/** Visit case for {@link test.hierarchy.data.Optional}.*/
		R visit(test.hierarchy.data.Optional self, A arg) throws E;

		/** Visit case for {@link test.hierarchy.data.Car}.*/
		R visit(test.hierarchy.data.Car self, A arg) throws E;

	}

	/** @see #getXCoordinate() */
	static final String X_COORDINATE__PROP = "x";

	/** @see #getYCoordinate() */
	static final String Y_COORDINATE__PROP = "y";

	/** @see #getColor() */
	static final String COLOR__PROP = "color";

	/** Identifier for the property {@link #getXCoordinate()} in binary format. */
	static final int X_COORDINATE__ID = 1;

	/** Identifier for the property {@link #getYCoordinate()} in binary format. */
	static final int Y_COORDINATE__ID = 2;

	/** Identifier for the property {@link #getColor()} in binary format. */
	static final int COLOR__ID = 3;

	/** The type code of this instance. */
	TypeKind kind();

	/**
	 * X coordinate of the origin of the coordinate system of this {@link Shape}.
	 */
	int getXCoordinate();

	/**
	 * @see #getXCoordinate()
	 */
	test.hierarchy.data.Shape setXCoordinate(int value);

	/**
	 * Y coordinate of the origin of the coordinate system of this {@link Shape}.
	 */
	int getYCoordinate();

	/**
	 * @see #getYCoordinate()
	 */
	test.hierarchy.data.Shape setYCoordinate(int value);

	/**
	 * The shape's color.
	 */
	test.hierarchy.data.Color getColor();

	/**
	 * @see #getColor()
	 */
	test.hierarchy.data.Shape setColor(test.hierarchy.data.Color value);

	@Override
	public test.hierarchy.data.Shape registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.hierarchy.data.Shape unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.hierarchy.data.Shape readShape(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.hierarchy.data.Shape result;
		in.beginArray();
		String type = in.nextString();
		switch (type) {
			case Group.GROUP__TYPE: result = test.hierarchy.data.Group.readGroup(in); break;
			case Optional.OPTIONAL__TYPE: result = test.hierarchy.data.Optional.readOptional(in); break;
			case Car.CAR__TYPE: result = test.hierarchy.data.Car.readCar(in); break;
			case Circle.CIRCLE__TYPE: result = test.hierarchy.data.Circle.readCircle(in); break;
			case Rectangle.RECTANGLE__TYPE: result = test.hierarchy.data.Rectangle.readRectangle(in); break;
			default: in.skipValue(); result = null; break;
		}
		in.endArray();
		return result;
	}

	/** The binary identifier for this concrete type in the polymorphic {@link test.hierarchy.data.Shape} hierarchy. */
	abstract int typeId();

	/** Reads a new instance from the given reader. */
	static test.hierarchy.data.Shape readShape(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		int typeField = in.nextName();
		assert typeField == 0;
		int type = in.nextInt();
		test.hierarchy.data.Shape result;
		switch (type) {
			case test.hierarchy.data.Group.GROUP__TYPE_ID: result = test.hierarchy.data.impl.Group_Impl.readGroup_Content(in); break;
			case test.hierarchy.data.Optional.OPTIONAL__TYPE_ID: result = test.hierarchy.data.impl.Optional_Impl.readOptional_Content(in); break;
			case test.hierarchy.data.Car.CAR__TYPE_ID: result = test.hierarchy.data.impl.Car_Impl.readCar_Content(in); break;
			case test.hierarchy.data.Circle.CIRCLE__TYPE_ID: result = test.hierarchy.data.impl.Circle_Impl.readCircle_Content(in); break;
			case test.hierarchy.data.Rectangle.RECTANGLE__TYPE_ID: result = test.hierarchy.data.impl.Rectangle_Impl.readRectangle_Content(in); break;
			default: result = null; while (in.hasNext()) {in.skipValue(); }
		}
		in.endObject();
		return result;
	}

	/** Creates a new {@link Shape} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Shape readShape(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.hierarchy.data.impl.Shape_Impl.readShape_XmlContent(in);
	}

	/** Accepts the given visitor. */
	public abstract <R,A,E extends Throwable> R visit(Visitor<R,A,E> v, A arg) throws E;

}
