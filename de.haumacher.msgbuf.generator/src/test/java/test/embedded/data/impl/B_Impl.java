package test.embedded.data.impl;

/**
 * Implementation of {@link test.embedded.data.B}.
 */
public class B_Impl extends test.embedded.data.impl.Base_Impl implements test.embedded.data.B {

	/**
	 * Creates a {@link B_Impl} instance.
	 *
	 * @see test.embedded.data.B#create()
	 */
	public B_Impl() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.B;
	}

	@Override
	public String jsonType() {
		return B__TYPE;
	}

	@Override
	public int typeId() {
		return B__TYPE_ID;
	}

	/** Helper for creating an object of type {@link test.embedded.data.B} from a polymorphic composition. */
	public static test.embedded.data.B readB_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.embedded.data.impl.B_Impl result = new B_Impl();
		result.readContent(in);
		return result;
	}

	/** XML element name representing a {@link test.embedded.data.B} type. */
	public static final String B__XML_ELEMENT = "b";

	@Override
	public String getXmlTagName() {
		return B__XML_ELEMENT;
	}

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

	/** Creates a new {@link test.embedded.data.B} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static B_Impl readB_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		B_Impl result = new B_Impl();
		result.readContentXml(in);
		return result;
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

	@Override
	public <R,A,E extends Throwable> R visit(test.embedded.data.Base.Visitor<R,A,E> v, A arg) throws E {
		return v.visit(this, arg);
	}

}
