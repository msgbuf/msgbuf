package test.example.data;

/**
 * An abstract base class for all requests in the messaging protocol.
 */
public interface Request extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/** Type codes for the {@link test.example.data.Request} hierarchy. */
	public enum TypeKind {

		/** Type literal for {@link test.example.data.LoginRequest}. */
		LOGIN_REQUEST,

		/** Type literal for {@link test.example.data.QueryRequest}. */
		QUERY_REQUEST,

		/** Type literal for {@link test.example.data.LogoutRequest}. */
		LOGOUT_REQUEST,
		;

	}

	/** Visitor interface for the {@link test.example.data.Request} hierarchy.*/
	public interface Visitor<R,A,E extends Throwable> {

		/** Visit case for {@link test.example.data.LoginRequest}.*/
		R visit(test.example.data.LoginRequest self, A arg) throws E;

		/** Visit case for {@link test.example.data.QueryRequest}.*/
		R visit(test.example.data.QueryRequest self, A arg) throws E;

		/** Visit case for {@link test.example.data.LogoutRequest}.*/
		R visit(test.example.data.LogoutRequest self, A arg) throws E;

	}

	/** @see #getSessionId() */
	String SESSION_ID__PROP = "sessionId";

	/** Identifier for the property {@link #getSessionId()} in binary format. */
	static final int SESSION_ID__ID = 1;

	/** The type code of this instance. */
	TypeKind kind();

	/**
	 * The session identifier for this request.
	 */
	String getSessionId();

	/**
	 * @see #getSessionId()
	 */
	test.example.data.Request setSessionId(String value);

	@Override
	public test.example.data.Request registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.example.data.Request unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.example.data.Request readRequest(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.example.data.Request result;
		in.beginArray();
		String type = in.nextString();
		switch (type) {
			case LoginRequest.LOGIN_REQUEST__TYPE: result = test.example.data.LoginRequest.readLoginRequest(in); break;
			case QueryRequest.QUERY_REQUEST__TYPE: result = test.example.data.QueryRequest.readQueryRequest(in); break;
			case LogoutRequest.LOGOUT_REQUEST__TYPE: result = test.example.data.LogoutRequest.readLogoutRequest(in); break;
			default: in.skipValue(); result = null; break;
		}
		in.endArray();
		return result;
	}

	/** The binary identifier for this concrete type in the polymorphic {@link test.example.data.Request} hierarchy. */
	abstract int typeId();

	/** Reads a new instance from the given reader. */
	static test.example.data.Request readRequest(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		int typeField = in.nextName();
		assert typeField == 0;
		int type = in.nextInt();
		test.example.data.Request result;
		switch (type) {
			case test.example.data.LoginRequest.LOGIN_REQUEST__TYPE_ID: result = test.example.data.impl.LoginRequest_Impl.readLoginRequest_Content(in); break;
			case test.example.data.QueryRequest.QUERY_REQUEST__TYPE_ID: result = test.example.data.impl.QueryRequest_Impl.readQueryRequest_Content(in); break;
			case test.example.data.LogoutRequest.LOGOUT_REQUEST__TYPE_ID: result = test.example.data.impl.LogoutRequest_Impl.readLogoutRequest_Content(in); break;
			default: result = null; while (in.hasNext()) {in.skipValue(); }
		}
		in.endObject();
		return result;
	}

	/** Creates a new {@link Request} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Request readRequest(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.example.data.impl.Request_Impl.readRequest_XmlContent(in);
	}

	/** Accepts the given visitor. */
	public abstract <R,A,E extends Throwable> R visit(Visitor<R,A,E> v, A arg) throws E;

}
