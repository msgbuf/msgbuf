package test.graph.data;

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
	public static AtomicShape<?> readAtomicShape(de.haumacher.msgbuf.graph.Scope scope, de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		if (in.peek() == de.haumacher.msgbuf.json.JsonToken.NUMBER) {
			return (AtomicShape<?>) scope.resolveOrFail(in.nextInt());
		}
		AtomicShape<?> result;
		in.beginArray();
		String type = in.nextString();
		int id = in.nextInt();
		switch (type) {
			case Circle.CIRCLE__TYPE: result = Circle.create(); break;
			case Rectangle.RECTANGLE__TYPE: result = Rectangle.create(); break;
			default: in.skipValue(); result = null; break;
		}
		if (result != null) {
			scope.readData(result, id, in);
		}
		in.endArray();
		return result;
	}

	/** Accepts the given visitor. */
	public abstract <R,A,E extends Throwable> R visit(Visitor<R,A,E> v, A arg) throws E;


	@Override
	public final <R,A,E extends Throwable> R visit(Shape.Visitor<R,A,E> v, A arg) throws E {
		return visit((Visitor<R,A,E>) v, arg);
	}

}
