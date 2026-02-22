package test.example.data;

/**
 * A request to end the current session.
 */
public interface LogoutRequest extends Request {

	/**
	 * Creates a {@link test.example.data.LogoutRequest} instance.
	 */
	static test.example.data.LogoutRequest create() {
		return new test.example.data.impl.LogoutRequest_Impl();
	}

	/** Identifier for the {@link test.example.data.LogoutRequest} type in JSON format. */
	String LOGOUT_REQUEST__TYPE = "LogoutRequest";

	/** Identifier for the {@link test.example.data.LogoutRequest} type in binary format. */
	static final int LOGOUT_REQUEST__TYPE_ID = 3;

	@Override
	test.example.data.LogoutRequest setSessionId(String value);

	/** Reads a new instance from the given reader. */
	static test.example.data.LogoutRequest readLogoutRequest(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.example.data.impl.LogoutRequest_Impl result = new test.example.data.impl.LogoutRequest_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.example.data.LogoutRequest readLogoutRequest(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.example.data.LogoutRequest result = test.example.data.impl.LogoutRequest_Impl.readLogoutRequest_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link LogoutRequest} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static LogoutRequest readLogoutRequest(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.example.data.impl.LogoutRequest_Impl.readLogoutRequest_XmlContent(in);
	}

}
