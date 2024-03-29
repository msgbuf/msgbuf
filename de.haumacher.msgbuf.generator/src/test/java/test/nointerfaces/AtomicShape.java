package test.nointerfaces;

/**
 * A {@link Shape} that has no sub-shapes.
 */
public abstract class AtomicShape extends Shape {

	/** Visitor interface for the {@link test.nointerfaces.AtomicShape} hierarchy.*/
	public interface Visitor<R,A,E extends Throwable> {

		/** Visit case for {@link test.nointerfaces.Circle}.*/
		R visit(test.nointerfaces.Circle self, A arg) throws E;

		/** Visit case for {@link test.nointerfaces.Rectangle}.*/
		R visit(test.nointerfaces.Rectangle self, A arg) throws E;

	}

	/**
	 * Creates a {@link AtomicShape} instance.
	 */
	protected AtomicShape() {
		super();
	}

	@Override
	public test.nointerfaces.AtomicShape setXCoordinate(int value) {
		internalSetXCoordinate(value);
		return this;
	}

	@Override
	public test.nointerfaces.AtomicShape setYCoordinate(int value) {
		internalSetYCoordinate(value);
		return this;
	}

	/** Reads a new instance from the given reader. */
	public static test.nointerfaces.AtomicShape readAtomicShape(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.nointerfaces.AtomicShape result;
		in.beginArray();
		String type = in.nextString();
		switch (type) {
			case Circle.CIRCLE__TYPE: result = test.nointerfaces.Circle.readCircle(in); break;
			case Rectangle.RECTANGLE__TYPE: result = test.nointerfaces.Rectangle.readRectangle(in); break;
			default: in.skipValue(); result = null; break;
		}
		in.endArray();
		return result;
	}

	/** Reads a new instance from the given reader. */
	public static test.nointerfaces.AtomicShape readAtomicShape(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		int typeField = in.nextName();
		assert typeField == 0;
		int type = in.nextInt();
		test.nointerfaces.AtomicShape result;
		switch (type) {
			case test.nointerfaces.Circle.CIRCLE__TYPE_ID: result = test.nointerfaces.Circle.readCircle_Content(in); break;
			case test.nointerfaces.Rectangle.RECTANGLE__TYPE_ID: result = test.nointerfaces.Rectangle.readRectangle_Content(in); break;
			default: result = null; while (in.hasNext()) {in.skipValue(); }
		}
		in.endObject();
		return result;
	}

	/** XML element name representing a {@link test.nointerfaces.AtomicShape} type. */
	public static final String ATOMIC_SHAPE__XML_ELEMENT = "atomic-shape";

	/** Serializes all fields that are written as XML attributes. */
	@Override
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeAttributes(out);
	}

	/** Serializes all fields that are written as XML elements. */
	@Override
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeElements(out);
		// No element fields.
	}

	/** Creates a new {@link test.nointerfaces.AtomicShape} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static AtomicShape readAtomicShape_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		switch (in.getLocalName()) {
			case Circle.CIRCLE__XML_ELEMENT: {
				return test.nointerfaces.Circle.readCircle_XmlContent(in);
			}

			case Rectangle.RECTANGLE__XML_ELEMENT: {
				return test.nointerfaces.Rectangle.readRectangle_XmlContent(in);
			}

			default: {
				internalSkipUntilMatchingEndElement(in);
				return null;
			}
		}
	}

	@Override
	protected void readFieldXmlAttribute(String name, String value) {
		switch (name) {
			default: {
				super.readFieldXmlAttribute(name, value);
			}
		}
	}

	@Override
	protected void readFieldXmlElement(javax.xml.stream.XMLStreamReader in, String localName) throws javax.xml.stream.XMLStreamException {
		switch (localName) {
			default: {
				super.readFieldXmlElement(in, localName);
			}
		}
	}

	/** Creates a new {@link AtomicShape} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static AtomicShape readAtomicShape(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.nointerfaces.AtomicShape.readAtomicShape_XmlContent(in);
	}

	/** Accepts the given visitor. */
	public abstract <R,A,E extends Throwable> R visit(Visitor<R,A,E> v, A arg) throws E;

	@Override
	public final <R,A,E extends Throwable> R visit(test.nointerfaces.Shape.Visitor<R,A,E> v, A arg) throws E {
		return visit((test.nointerfaces.AtomicShape.Visitor<R,A,E>) v, arg);
	}

}
