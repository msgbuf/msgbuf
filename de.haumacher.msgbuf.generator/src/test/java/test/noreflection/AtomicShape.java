package test.noreflection;

/**
 * A {@link Shape} that has no sub-shapes.
 */
public abstract class AtomicShape extends Shape {

	/** Visitor interface for the {@link AtomicShape} hierarchy.*/
	public interface Visitor<R,A,E extends Throwable> {

		/** Visit case for {@link Circle}.*/
		R visit(Circle self, A arg) throws E;

		/** Visit case for {@link Rectangle}.*/
		R visit(Rectangle self, A arg) throws E;

	}

	/**
	 * Creates a {@link AtomicShape} instance.
	 */
	protected AtomicShape() {
		super();
	}

	@Override
	public AtomicShape setXCoordinate(int value) {
		internalSetXCoordinate(value);
		return this;
	}

	@Override
	public AtomicShape setYCoordinate(int value) {
		internalSetYCoordinate(value);
		return this;
	}

	/** The type identifier for this concrete subtype. */
	public abstract String jsonType();

	/** Reads a new instance from the given reader. */
	public static AtomicShape readAtomicShape(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		AtomicShape result;
		in.beginArray();
		String type = in.nextString();
		switch (type) {
			case Circle.CIRCLE__TYPE: result = test.noreflection.Circle.readCircle(in); break;
			case Rectangle.RECTANGLE__TYPE: result = test.noreflection.Rectangle.readRectangle(in); break;
			default: in.skipValue(); result = null; break;
		}
		in.endArray();
		return result;
	}

	/** Accepts the given visitor. */
	public abstract <R,A,E extends Throwable> R visit(Visitor<R,A,E> v, A arg) throws E;

	@Override
	public final <R,A,E extends Throwable> R visit(Shape.Visitor<R,A,E> v, A arg) throws E {
		return visit((AtomicShape.Visitor<R,A,E>) v, arg);
	}

}
