package test.nojson;

/**
 * An abstract base class for all shapes
 */
public abstract class Shape<S extends Shape<S>> implements de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable {

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
	public interface Visitor<R,A,E extends Throwable> extends AtomicShape.Visitor<R,A,E> {

		/** Visit case for {@link Group}.*/
		R visit(Group self, A arg) throws E;

		/** Visit case for {@link Car}.*/
		R visit(Car self, A arg) throws E;

	}

	/** @see #getXCoordinate() */
	public static final String X_COORDINATE = "x";

	/** @see #getYCoordinate() */
	public static final String Y_COORDINATE = "y";

	/** Identifier for the property {@link #getXCoordinate()} in binary format. */
	public static final int X_COORDINATE__ID = 1;

	/** Identifier for the property {@link #getYCoordinate()} in binary format. */
	public static final int Y_COORDINATE__ID = 2;

	private int _xCoordinate = 0;

	private int _yCoordinate = 0;

	/**
	 * Creates a {@link Shape} instance.
	 */
	protected Shape() {
		super();
	}

	/** This instance with the concrete type. */
	protected abstract S self();

	/** The type code of this instance. */
	public abstract TypeKind kind();

	/**
	 * X coordinate of the origin of the coordinate system of this {@link Shape}.
	 */
	public final int getXCoordinate() {
		return _xCoordinate;
	}

	/**
	 * @see #getXCoordinate()
	 */
	public final S setXCoordinate(int value) {
		_listener.beforeSet(this, X_COORDINATE, value);
		_xCoordinate = value;
		return self();
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
	public final S setYCoordinate(int value) {
		_listener.beforeSet(this, Y_COORDINATE, value);
		_yCoordinate = value;
		return self();
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public S registerListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
		return self();
	}

	@Override
	public S unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
		return self();
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
			default: return de.haumacher.msgbuf.observer.Observable.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case X_COORDINATE: setXCoordinate((int) value); break;
			case Y_COORDINATE: setYCoordinate((int) value); break;
		}
	}

	/** The binary identifier for this concrete type in the polymorphic {@link Shape} hierarchy. */
	public abstract int typeId();

	@Override
	public final void writeTo(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		out.beginObject();
		out.name(0);
		out.value(typeId());
		writeFields(out);
		out.endObject();
	}

	/**
	 * Serializes all fields of this instance to the given binary output.
	 *
	 * @param out
	 *        The binary output to write to.
	 * @throws java.io.IOException If writing fails.
	 */
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		out.name(X_COORDINATE__ID);
		out.value(getXCoordinate());
		out.name(Y_COORDINATE__ID);
		out.value(getYCoordinate());
	}

	/** Reads a new instance from the given reader. */
	public static Shape<?> readShape(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		Shape<?> result;
		int typeField = in.nextName();
		assert typeField == 0;
		int type = in.nextInt();
		switch (type) {
			case Group.GROUP__TYPE_ID: result = test.nojson.Group.create(); break;
			case Car.CAR__TYPE_ID: result = test.nojson.Car.create(); break;
			case Circle.CIRCLE__TYPE_ID: result = test.nojson.Circle.create(); break;
			case Rectangle.RECTANGLE__TYPE_ID: result = test.nojson.Rectangle.create(); break;
			default: while (in.hasNext()) {in.skipValue(); } in.endObject(); return null;
		}
		while (in.hasNext()) {
			int field = in.nextName();
			result.readField(in, field);
		}
		in.endObject();
		return result;
	}

	/** Consumes the value for the field with the given ID and assigns its value. */
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case X_COORDINATE__ID: setXCoordinate(in.nextInt()); break;
			case Y_COORDINATE__ID: setYCoordinate(in.nextInt()); break;
			default: in.skipValue(); 
		}
	}

	/** Accepts the given visitor. */
	public abstract <R,A,E extends Throwable> R visit(Visitor<R,A,E> v, A arg) throws E;


}
