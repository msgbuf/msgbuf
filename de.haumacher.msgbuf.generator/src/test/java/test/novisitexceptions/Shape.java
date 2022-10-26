package test.novisitexceptions;

/**
 * An abstract base class for all shapes
 */
public interface Shape extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable {

	/** Type codes for the {@link Shape} hierarchy. */
	public enum TypeKind {

		/** Type literal for {@link Circle}. */
		CIRCLE,

		/** Type literal for {@link Rectangle}. */
		RECTANGLE,

		/** Type literal for {@link Group}. */
		GROUP,

		/** Type literal for {@link Car}. */
		CAR,
		;

	}

	/** Visitor interface for the {@link Shape} hierarchy.*/
	public interface Visitor<R,A> extends AtomicShape.Visitor<R,A> {

		/** Visit case for {@link Group}.*/
		R visit(Group self, A arg);

		/** Visit case for {@link Car}.*/
		R visit(Car self, A arg);

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
	Shape setXCoordinate(int value);

	/**
	 * Y coordinate of the origin of the coordinate system of this {@link Shape}.
	 */
	int getYCoordinate();

	/**
	 * @see #getYCoordinate()
	 */
	Shape setYCoordinate(int value);

	@Override
	public Shape registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public Shape unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static Shape readShape(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		Shape result;
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

	/** The binary identifier for this concrete type in the polymorphic {@link Shape} hierarchy. */
	abstract int typeId();

	/** Reads a new instance from the given reader. */
	static Shape readShape(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		int typeField = in.nextName();
		assert typeField == 0;
		int type = in.nextInt();
		Shape result;
		switch (type) {
			case Group.GROUP__TYPE_ID: result = test.novisitexceptions.Group_Impl.readGroup_Content(in); break;
			case Car.CAR__TYPE_ID: result = test.novisitexceptions.Car_Impl.readCar_Content(in); break;
			case Circle.CIRCLE__TYPE_ID: result = test.novisitexceptions.Circle_Impl.readCircle_Content(in); break;
			case Rectangle.RECTANGLE__TYPE_ID: result = test.novisitexceptions.Rectangle_Impl.readRectangle_Content(in); break;
			default: result = null; while (in.hasNext()) {in.skipValue(); }
		}
		in.endObject();
		return result;
	}

	/** Creates a new {@link Shape} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Shape readShape(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.novisitexceptions.Shape_Impl.readShape_XmlContent(in);
	}

	/** Accepts the given visitor. */
	public abstract <R,A> R visit(Visitor<R,A> v, A arg);

}
