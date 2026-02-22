package test.example.data;

/**
 * A request to authenticate with the server.
 */
public interface LoginRequest extends Request {

	/**
	 * Creates a {@link test.example.data.LoginRequest} instance.
	 */
	static test.example.data.LoginRequest create() {
		return new test.example.data.impl.LoginRequest_Impl();
	}

	/** Identifier for the {@link test.example.data.LoginRequest} type in JSON format. */
	String LOGIN_REQUEST__TYPE = "LoginRequest";

	/** @see #getUsername() */
	String USERNAME__PROP = "username";

	/** @see #getPassword() */
	String PASSWORD__PROP = "password";

	/** Identifier for the {@link test.example.data.LoginRequest} type in binary format. */
	static final int LOGIN_REQUEST__TYPE_ID = 1;

	/** Identifier for the property {@link #getUsername()} in binary format. */
	static final int USERNAME__ID = 2;

	/** Identifier for the property {@link #getPassword()} in binary format. */
	static final int PASSWORD__ID = 3;

	/**
	 * The user name to log in with.
	 */
	String getUsername();

	/**
	 * @see #getUsername()
	 */
	test.example.data.LoginRequest setUsername(String value);

	/**
	 * The password for authentication.
	 */
	String getPassword();

	/**
	 * @see #getPassword()
	 */
	test.example.data.LoginRequest setPassword(String value);

	@Override
	test.example.data.LoginRequest setSessionId(String value);

	/** Reads a new instance from the given reader. */
	static test.example.data.LoginRequest readLoginRequest(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.example.data.impl.LoginRequest_Impl result = new test.example.data.impl.LoginRequest_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.example.data.LoginRequest readLoginRequest(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.example.data.LoginRequest result = test.example.data.impl.LoginRequest_Impl.readLoginRequest_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link LoginRequest} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static LoginRequest readLoginRequest(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.example.data.impl.LoginRequest_Impl.readLoginRequest_XmlContent(in);
	}

}
