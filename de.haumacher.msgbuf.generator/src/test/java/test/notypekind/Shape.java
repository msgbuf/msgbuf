package test.notypekind;

/**
 * An abstract base class for all shapes
 */
public interface Shape extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/** Visitor interface for the {@link Shape} hierarchy.*/
	public interface Visitor<R,A,E extends Throwable> extends AtomicShape.Visitor<R,A,E> {

		/** Visit case for {@link Group}.*/
		R visit(Group self, A arg) throws E;

		/** Visit case for {@link Car}.*/
		R visit(Car self, A arg) throws E;

	}

	/** @see #getXCoordinate() */
	static final String X_COORDINATE__PROP = "x";

	/** @see #getYCoordinate() */
	static final String Y_COORDINATE__PROP = "y";

	/** Identifier for the property {@link #getXCoordinate()} in binary format. */
	static final int X_COORDINATE__ID = 1;

	/** Identifier for the property {@link #getYCoordinate()} in binary format. */
	static final int Y_COORDINATE__ID = 2;

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
			case Group.GROUP__TYPE: result = test.notypekind.Group.readGroup(in); break;
			case Car.CAR__TYPE: result = test.notypekind.Car.readCar(in); break;
			case Circle.CIRCLE__TYPE: result = test.notypekind.Circle.readCircle(in); break;
			case Rectangle.RECTANGLE__TYPE: result = test.notypekind.Rectangle.readRectangle(in); break;
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
			case Group.GROUP__TYPE_ID: result = test.notypekind.Group_Impl.readGroup_Content(in); break;
			case Car.CAR__TYPE_ID: result = test.notypekind.Car_Impl.readCar_Content(in); break;
			case Circle.CIRCLE__TYPE_ID: result = test.notypekind.Circle_Impl.readCircle_Content(in); break;
			case Rectangle.RECTANGLE__TYPE_ID: result = test.notypekind.Rectangle_Impl.readRectangle_Content(in); break;
			default: result = null; while (in.hasNext()) {in.skipValue(); }
		}
		in.endObject();
		return result;
	}

	/** Creates a new {@link Shape} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Shape readShape(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.notypekind.Shape_Impl.readShape_XmlContent(in);
	}

	/** Accepts the given visitor. */
	public abstract <R,A,E extends Throwable> R visit(Visitor<R,A,E> v, A arg) throws E;

}
