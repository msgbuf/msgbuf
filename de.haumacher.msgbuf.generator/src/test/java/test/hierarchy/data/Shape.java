package test.hierarchy.data;

/**
 * An abstract base class for all shapes
 */
public abstract class Shape extends de.haumacher.msgbuf.data.AbstractReflectiveDataObject implements de.haumacher.msgbuf.binary.BinaryDataObject {

	/** Visitor interface for the {@link Shape} hierarchy.*/
	public interface Visitor<R,A> extends AtomicShape.Visitor<R,A> {

		/** Visit case for {@link Group}.*/
		R visit(Group self, A arg);

		/** Visit case for {@link Car}.*/
		R visit(Car self, A arg);

	}

	/**
	 * Creates a {@link Shape} instance.
	 */
	protected Shape() {
		super();
	}

	/** @see #getXCoordinate() */
	public static final String X_COORDINATE = "x";

	/** @see #getYCoordinate() */
	public static final String Y_COORDINATE = "y";

	private int _xCoordinate = 0;

	private int _yCoordinate = 0;

	/**
	 * X coordinate of the origin of the coordinate system of this {@link Shape}.
	 */
	public final int getXCoordinate() {
		return _xCoordinate;
	}

	/**
	 * @see #getXCoordinate()
	 */
	public final Shape setXCoordinate(int value) {
		_xCoordinate = value;
		return this;
	}

	/**
	 * Y coordinate of the origin of the coordinate system of this {@link Shape}.
	 */
	public final int getYCoordinate() {
		return _yCoordinate;
	}

	/**
	 * @see #getYCoordinate()
	 */
	public final Shape setYCoordinate(int value) {
		_yCoordinate = value;
		return this;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			X_COORDINATE, 
			Y_COORDINATE));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case X_COORDINATE: return getXCoordinate();
			case Y_COORDINATE: return getYCoordinate();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case X_COORDINATE: setXCoordinate((int) value); break;
			case Y_COORDINATE: setYCoordinate((int) value); break;
		}
	}

	/** Reads a new instance from the given reader. */
	public static Shape readShape(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		Shape result;
		in.beginArray();
		String type = in.nextString();
		switch (type) {
			case "Group": result = Group.readGroup(in); break;
			case "Car": result = Car.readCar(in); break;
			case "Circle": result = Circle.readCircle(in); break;
			case "Rectangle": result = Rectangle.readRectangle(in); break;
			default: in.skipValue(); result = null; break;
		}
		in.endArray();
		return result;
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		out.beginArray();
		out.value(jsonType());
		writeContent(out);
		out.endArray();
	}

	/** The type identifier for this concrete subtype. */
	public abstract String jsonType();

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(X_COORDINATE);
		out.value(getXCoordinate());
		out.name(Y_COORDINATE);
		out.value(getYCoordinate());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case X_COORDINATE: setXCoordinate(in.nextInt()); break;
			case Y_COORDINATE: setYCoordinate(in.nextInt()); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		out.beginObject();
		out.name(0);
		out.value(typeId());
		writeFields(out);
		out.endObject();
	}

	/** The binary identifier for this concrete type in the polymorphic {@link Shape} hierarchy. */
	public abstract int typeId();

	/**
	 * Serializes all fields of this instance to the given binary output.
	 *
	 * @param out
	 *        The binary output to write to.
	 * @throws java.io.IOException If writing fails.
	 */
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		out.name(1);
		out.value(getXCoordinate());
		out.name(2);
		out.value(getYCoordinate());
	}

	/** Consumes the value for the field with the given ID and assigns its value. */
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case 1: setXCoordinate(in.nextInt()); break;
			case 2: setYCoordinate(in.nextInt()); break;
			default: in.skipValue(); 
		}
	}

	/** Reads a new instance from the given reader. */
	public static Shape readShape(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		Shape result;
		int typeField = in.nextName();
		assert typeField == 0;
		int type = in.nextInt();
		switch (type) {
			case 3: result = Group.create(); break;
			case 4: result = Car.create(); break;
			case 1: result = Circle.create(); break;
			case 2: result = Rectangle.create(); break;
			default: while (in.hasNext()) {in.skipValue(); } in.endObject(); return null;
		}
		while (in.hasNext()) {
			int field = in.nextName();
			result.readField(in, field);
		}
		in.endObject();
		return result;
	}

	/** Accepts the given visitor. */
	public abstract <R,A> R visit(Visitor<R,A> v, A arg);


}
