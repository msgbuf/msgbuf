package test.novisit;

/**
 * A {@link Shape} that has no sub-shapes.
 */
public interface AtomicShape extends Shape {

	@Override
	test.novisit.AtomicShape setXCoordinate(int value);

	@Override
	test.novisit.AtomicShape setYCoordinate(int value);

	/** Reads a new instance from the given reader. */
	static test.novisit.AtomicShape readAtomicShape(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.novisit.AtomicShape result;
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
	static test.novisit.AtomicShape readAtomicShape(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		int typeField = in.nextName();
		assert typeField == 0;
		int type = in.nextInt();
		test.novisit.AtomicShape result;
		switch (type) {
			case test.novisit.Circle.CIRCLE__TYPE_ID: result = test.novisit.impl.Circle_Impl.readCircle_Content(in); break;
			case test.novisit.Rectangle.RECTANGLE__TYPE_ID: result = test.novisit.impl.Rectangle_Impl.readRectangle_Content(in); break;
			default: result = null; while (in.hasNext()) {in.skipValue(); }
		}
		in.endObject();
		return result;
	}

	/** Creates a new {@link AtomicShape} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static AtomicShape readAtomicShape(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.novisit.impl.AtomicShape_Impl.readAtomicShape_XmlContent(in);
	}

}
