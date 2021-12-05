package test.hierarchy.data;

/**
 * A {@link Shape} that has no sub-shapes.
 */
public abstract class AtomicShape<S extends AtomicShape<S>> extends Shape<S> {

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
	public static AtomicShape<?> readAtomicShape(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		AtomicShape<?> result;
		in.beginArray();
		String type = in.nextString();
		switch (type) {
			case Circle.CIRCLE__TYPE: result = test.hierarchy.data.Circle.readCircle(in); break;
			case Rectangle.RECTANGLE__TYPE: result = test.hierarchy.data.Rectangle.readRectangle(in); break;
			default: in.skipValue(); result = null; break;
		}
		in.endArray();
		return result;
	}

	/** Reads a new instance from the given reader. */
	public static AtomicShape<?> readAtomicShape(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		AtomicShape<?> result;
		int typeField = in.nextName();
		assert typeField == 0;
		int type = in.nextInt();
		switch (type) {
			case Circle.CIRCLE__TYPE_ID: result = test.hierarchy.data.Circle.create(); break;
			case Rectangle.RECTANGLE__TYPE_ID: result = test.hierarchy.data.Rectangle.create(); break;
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
