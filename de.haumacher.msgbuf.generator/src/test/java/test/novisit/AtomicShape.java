package test.novisit;

/**
 * A {@link Shape} that has no sub-shapes.
 */
public interface AtomicShape extends Shape {

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
			case Circle.CIRCLE__TYPE: result = test.novisit.Circle.readCircle(in); break;
			case Rectangle.RECTANGLE__TYPE: result = test.novisit.Rectangle.readRectangle(in); break;
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
			case Circle.CIRCLE__TYPE_ID: result = test.novisit.Circle_Impl.readCircle_Content(in); break;
			case Rectangle.RECTANGLE__TYPE_ID: result = test.novisit.Rectangle_Impl.readRectangle_Content(in); break;
			default: result = null; while (in.hasNext()) {in.skipValue(); }
		}
		in.endObject();
		return result;
	}

}
