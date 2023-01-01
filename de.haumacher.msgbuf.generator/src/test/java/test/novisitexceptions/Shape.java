package test.novisitexceptions;

/**
 * An abstract base class for all shapes
 */
public interface Shape extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/** Type codes for the {@link test.novisitexceptions.Shape} hierarchy. */
	public enum TypeKind {

		/** Type literal for {@link test.novisitexceptions.Circle}. */
		CIRCLE,

		/** Type literal for {@link test.novisitexceptions.Rectangle}. */
		RECTANGLE,

		/** Type literal for {@link test.novisitexceptions.Group}. */
		GROUP,

		/** Type literal for {@link test.novisitexceptions.Car}. */
		CAR,
		;

	}

	/** Visitor interface for the {@link test.novisitexceptions.Shape} hierarchy.*/
	public interface Visitor<R,A> extends test.novisitexceptions.AtomicShape.Visitor<R,A> {

		/** Visit case for {@link test.novisitexceptions.Group}.*/
		R visit(test.novisitexceptions.Group self, A arg);

		/** Visit case for {@link test.novisitexceptions.Car}.*/
		R visit(test.novisitexceptions.Car self, A arg);

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
	test.novisitexceptions.Shape setXCoordinate(int value);

	/**
	 * Y coordinate of the origin of the coordinate system of this {@link Shape}.
	 */
	int getYCoordinate();

	/**
	 * @see #getYCoordinate()
	 */
	test.novisitexceptions.Shape setYCoordinate(int value);

	@Override
	public test.novisitexceptions.Shape registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.novisitexceptions.Shape unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.novisitexceptions.Shape readShape(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.novisitexceptions.Shape result;
		in.beginArray();
		String type = in.nextString();
		switch (type) {
			case Group.GROUP__TYPE: result = test.novisitexceptions.Group.readGroup(in); break;
			case Car.CAR__TYPE: result = test.novisitexceptions.Car.readCar(in); break;
			case Circle.CIRCLE__TYPE: result = test.novisitexceptions.Circle.readCircle(in); break;
			case Rectangle.RECTANGLE__TYPE: result = test.novisitexceptions.Rectangle.readRectangle(in); break;
			default: in.skipValue(); result = null; break;
		}
		in.endArray();
		return result;
	}

	/** The binary identifier for this concrete type in the polymorphic {@link test.novisitexceptions.Shape} hierarchy. */
	abstract int typeId();

	/** Reads a new instance from the given reader. */
	static test.novisitexceptions.Shape readShape(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		int typeField = in.nextName();
		assert typeField == 0;
		int type = in.nextInt();
		test.novisitexceptions.Shape result;
		switch (type) {
			case test.novisitexceptions.Group.GROUP__TYPE_ID: result = test.novisitexceptions.impl.Group_Impl.readGroup_Content(in); break;
			case test.novisitexceptions.Car.CAR__TYPE_ID: result = test.novisitexceptions.impl.Car_Impl.readCar_Content(in); break;
			case test.novisitexceptions.Circle.CIRCLE__TYPE_ID: result = test.novisitexceptions.impl.Circle_Impl.readCircle_Content(in); break;
			case test.novisitexceptions.Rectangle.RECTANGLE__TYPE_ID: result = test.novisitexceptions.impl.Rectangle_Impl.readRectangle_Content(in); break;
			default: result = null; while (in.hasNext()) {in.skipValue(); }
		}
		in.endObject();
		return result;
	}

	/** Creates a new {@link Shape} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Shape readShape(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.novisitexceptions.impl.Shape_Impl.readShape_XmlContent(in);
	}

	/** Accepts the given visitor. */
	public abstract <R,A> R visit(Visitor<R,A> v, A arg);

}
