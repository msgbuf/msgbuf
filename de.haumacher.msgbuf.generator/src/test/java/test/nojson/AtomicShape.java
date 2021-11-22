package test.nojson;

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

	/** Reads a new instance from the given reader. */
	public static AtomicShape readAtomicShape(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		AtomicShape result;
		int typeField = in.nextName();
		assert typeField == 0;
		int type = in.nextInt();
		switch (type) {
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

	/** Accepts the given visitor. */
	public abstract <R,A,E extends Throwable> R visit(Visitor<R,A,E> v, A arg) throws E;


	@Override
	public final <R,A,E extends Throwable> R visit(Shape.Visitor<R,A,E> v, A arg) throws E {
		return visit((Visitor<R,A,E>) v, arg);
	}

}
