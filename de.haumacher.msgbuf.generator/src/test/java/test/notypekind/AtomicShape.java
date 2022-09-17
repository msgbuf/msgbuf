package test.notypekind;

/**
 * A {@link Shape} that has no sub-shapes.
 */
public interface AtomicShape extends Shape {

	/** Visitor interface for the {@link AtomicShape} hierarchy.*/
	public interface Visitor<R,A,E extends Throwable> {

		/** Visit case for {@link Circle}.*/
		R visit(Circle self, A arg) throws E;

		/** Visit case for {@link Rectangle}.*/
		R visit(Rectangle self, A arg) throws E;

	}

	@Override
	AtomicShape setXCoordinate(int value);

	@Override
	AtomicShape setYCoordinate(int value);

	/** Reads a new instance from the given reader. */
	static AtomicShape readAtomicShape(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		AtomicShape result;
		in.beginArray();
		String type = in.nextString();
		switch (type) {
			case Circle.CIRCLE__TYPE: result = test.notypekind.Circle.readCircle(in); break;
			case Rectangle.RECTANGLE__TYPE: result = test.notypekind.Rectangle.readRectangle(in); break;
			default: in.skipValue(); result = null; break;
		}
		in.endArray();
		return result;
	}

	/** Reads a new instance from the given reader. */
	static AtomicShape readAtomicShape(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		int typeField = in.nextName();
		assert typeField == 0;
		int type = in.nextInt();
		AtomicShape result;
		switch (type) {
			case Circle.CIRCLE__TYPE_ID: result = test.notypekind.Circle_Impl.readCircle_Content(in); break;
			case Rectangle.RECTANGLE__TYPE_ID: result = test.notypekind.Rectangle_Impl.readRectangle_Content(in); break;
			default: result = null; while (in.hasNext()) {in.skipValue(); }
		}
		in.endObject();
		return result;
	}

	/** Accepts the given visitor. */
	public abstract <R,A,E extends Throwable> R visit(Visitor<R,A,E> v, A arg) throws E;

}
