package test.noreflection;

/**
 * A {@link Shape} that has no sub-shapes.
 */
public abstract class AtomicShape extends Shape {

	/** Visitor interface for the {@link AtomicShape} hierarchy.*/
	public interface Visitor<R,A> {

		/** Visit case for {@link Circle}.*/
		R visit(Circle self, A arg);

		/** Visit case for {@link Rectangle}.*/
		R visit(Rectangle self, A arg);

	}

	/**
	 * Creates a {@link AtomicShape} instance.
	 */
	protected AtomicShape() {
		super();
	}

	/** Reads a new instance from the given reader. */
	public static AtomicShape readAtomicShape(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		AtomicShape result;
		in.beginArray();
		String type = in.nextString();
		switch (type) {
			case Circle.CIRCLE__TYPE: result = Circle.readCircle(in); break;
			case Rectangle.RECTANGLE__TYPE: result = Rectangle.readRectangle(in); break;
			default: in.skipValue(); result = null; break;
		}
		in.endArray();
		return result;
	}

	/** Reads a new instance from the given reader. */
	public static AtomicShape readAtomicShape(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		AtomicShape result;
		int typeField = in.nextName();
		assert typeField == 0;
		int type = in.nextInt();
		switch (type) {
			case Circle.CIRCLE__TYPE_ID: result = Circle.create(); break;
			case Rectangle.RECTANGLE__TYPE_ID: result = Rectangle.create(); break;
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


	@Override
	public final <R,A> R visit(Shape.Visitor<R,A> v, A arg) {
		return visit((Visitor<R,A>) v, arg);
	}

}
