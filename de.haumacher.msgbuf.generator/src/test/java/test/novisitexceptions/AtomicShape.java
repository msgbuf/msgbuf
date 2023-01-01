package test.novisitexceptions;

/**
 * A {@link Shape} that has no sub-shapes.
 */
public interface AtomicShape extends Shape {

	/** Visitor interface for the {@link test.novisitexceptions.AtomicShape} hierarchy.*/
	public interface Visitor<R,A> {

		/** Visit case for {@link test.novisitexceptions.Circle}.*/
		R visit(test.novisitexceptions.Circle self, A arg);

		/** Visit case for {@link test.novisitexceptions.Rectangle}.*/
		R visit(test.novisitexceptions.Rectangle self, A arg);

	}

	@Override
	test.novisitexceptions.AtomicShape setXCoordinate(int value);

	@Override
	test.novisitexceptions.AtomicShape setYCoordinate(int value);

	/** Reads a new instance from the given reader. */
	static test.novisitexceptions.AtomicShape readAtomicShape(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.novisitexceptions.AtomicShape result;
		in.beginArray();
		String type = in.nextString();
		switch (type) {
			case Circle.CIRCLE__TYPE: result = test.novisitexceptions.Circle.readCircle(in); break;
			case Rectangle.RECTANGLE__TYPE: result = test.novisitexceptions.Rectangle.readRectangle(in); break;
			default: in.skipValue(); result = null; break;
		}
		in.endArray();
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.novisitexceptions.AtomicShape readAtomicShape(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		int typeField = in.nextName();
		assert typeField == 0;
		int type = in.nextInt();
		test.novisitexceptions.AtomicShape result;
		switch (type) {
			case test.novisitexceptions.Circle.CIRCLE__TYPE_ID: result = test.novisitexceptions.impl.Circle_Impl.readCircle_Content(in); break;
			case test.novisitexceptions.Rectangle.RECTANGLE__TYPE_ID: result = test.novisitexceptions.impl.Rectangle_Impl.readRectangle_Content(in); break;
			default: result = null; while (in.hasNext()) {in.skipValue(); }
		}
		in.endObject();
		return result;
	}

	/** Creates a new {@link AtomicShape} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static AtomicShape readAtomicShape(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.novisitexceptions.impl.AtomicShape_Impl.readAtomicShape_XmlContent(in);
	}

	/** Accepts the given visitor. */
	public abstract <R,A> R visit(Visitor<R,A> v, A arg);

}
