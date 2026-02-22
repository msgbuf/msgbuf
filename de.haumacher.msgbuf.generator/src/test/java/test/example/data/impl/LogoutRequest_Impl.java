package test.example.data.impl;

/**
 * Implementation of {@link test.example.data.LogoutRequest}.
 */
public class LogoutRequest_Impl extends test.example.data.impl.Request_Impl implements test.example.data.LogoutRequest {

	/**
	 * Creates a {@link LogoutRequest_Impl} instance.
	 *
	 * @see test.example.data.LogoutRequest#create()
	 */
	public LogoutRequest_Impl() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.LOGOUT_REQUEST;
	}

	@Override
	public test.example.data.LogoutRequest setSessionId(String value) {
		internalSetSessionId(value);
		return this;
	}

	@Override
	public String jsonType() {
		return LOGOUT_REQUEST__TYPE;
	}

	@Override
	public int typeId() {
		return LOGOUT_REQUEST__TYPE_ID;
	}

	/** Helper for creating an object of type {@link test.example.data.LogoutRequest} from a polymorphic composition. */
	public static test.example.data.LogoutRequest readLogoutRequest_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.example.data.impl.LogoutRequest_Impl result = new LogoutRequest_Impl();
		result.readContent(in);
		return result;
	}

	/** XML element name representing a {@link test.example.data.LogoutRequest} type. */
	public static final String LOGOUT_REQUEST__XML_ELEMENT = "logout-request";

	@Override
	public String getXmlTagName() {
		return LOGOUT_REQUEST__XML_ELEMENT;
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

	/** Creates a new {@link test.example.data.LogoutRequest} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static LogoutRequest_Impl readLogoutRequest_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		LogoutRequest_Impl result = new LogoutRequest_Impl();
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
	public <R,A,E extends Throwable> R visit(test.example.data.Request.Visitor<R,A,E> v, A arg) throws E {
		return v.visit(this, arg);
	}

}
