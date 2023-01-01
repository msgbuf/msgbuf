package test.novisit;

/**
 * An abstract base class for all shapes
 */
public interface Shape extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/** Type codes for the {@link test.novisit.Shape} hierarchy. */
	public enum TypeKind {

		/** Type literal for {@link test.novisit.Circle}. */
		CIRCLE,

		/** Type literal for {@link test.novisit.Rectangle}. */
		RECTANGLE,

		/** Type literal for {@link test.novisit.Group}. */
		GROUP,

		/** Type literal for {@link test.novisit.Car}. */
		CAR,
		;

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
	test.novisit.Shape setXCoordinate(int value);

	/**
	 * Y coordinate of the origin of the coordinate system of this {@link Shape}.
	 */
	int getYCoordinate();

	/**
	 * @see #getYCoordinate()
	 */
	test.novisit.Shape setYCoordinate(int value);

	@Override
	public test.novisit.Shape registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.novisit.Shape unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.novisit.Shape readShape(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.novisit.Shape result;
		in.beginArray();
		String type = in.nextString();
		switch (type) {
			case Group.GROUP__TYPE: result = test.novisit.Group.readGroup(in); break;
			case Car.CAR__TYPE: result = test.novisit.Car.readCar(in); break;
			case Circle.CIRCLE__TYPE: result = test.novisit.Circle.readCircle(in); break;
			case Rectangle.RECTANGLE__TYPE: result = test.novisit.Rectangle.readRectangle(in); break;
			default: in.skipValue(); result = null; break;
		}
		in.endArray();
		return result;
	}

	/** The binary identifier for this concrete type in the polymorphic {@link test.novisit.Shape} hierarchy. */
	abstract int typeId();

	/** Reads a new instance from the given reader. */
	static test.novisit.Shape readShape(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		int typeField = in.nextName();
		assert typeField == 0;
		int type = in.nextInt();
		test.novisit.Shape result;
		switch (type) {
			case test.novisit.Group.GROUP__TYPE_ID: result = test.novisit.impl.Group_Impl.readGroup_Content(in); break;
			case test.novisit.Car.CAR__TYPE_ID: result = test.novisit.impl.Car_Impl.readCar_Content(in); break;
			case test.novisit.Circle.CIRCLE__TYPE_ID: result = test.novisit.impl.Circle_Impl.readCircle_Content(in); break;
			case test.novisit.Rectangle.RECTANGLE__TYPE_ID: result = test.novisit.impl.Rectangle_Impl.readRectangle_Content(in); break;
			default: result = null; while (in.hasNext()) {in.skipValue(); }
		}
		in.endObject();
		return result;
	}

	/** Creates a new {@link Shape} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Shape readShape(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.novisit.impl.Shape_Impl.readShape_XmlContent(in);
	}

}
