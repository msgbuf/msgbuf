package test.example.data.impl;

/**
 * Implementation of {@link test.example.data.LoginRequest}.
 */
public class LoginRequest_Impl extends test.example.data.impl.Request_Impl implements test.example.data.LoginRequest {

	private String _username = "";

	private String _password = "";

	/**
	 * Creates a {@link LoginRequest_Impl} instance.
	 *
	 * @see test.example.data.LoginRequest#create()
	 */
	public LoginRequest_Impl() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.LOGIN_REQUEST;
	}

	@Override
	public final String getUsername() {
		return _username;
	}

	@Override
	public test.example.data.LoginRequest setUsername(String value) {
		internalSetUsername(value);
		return this;
	}

	/** Internal setter for {@link #getUsername()} without chain call utility. */
	protected final void internalSetUsername(String value) {
		_listener.beforeSet(this, USERNAME__PROP, value);
		_username = value;
		_listener.afterChanged(this, USERNAME__PROP);
	}

	@Override
	public final String getPassword() {
		return _password;
	}

	@Override
	public test.example.data.LoginRequest setPassword(String value) {
		internalSetPassword(value);
		return this;
	}

	/** Internal setter for {@link #getPassword()} without chain call utility. */
	protected final void internalSetPassword(String value) {
		_listener.beforeSet(this, PASSWORD__PROP, value);
		_password = value;
		_listener.afterChanged(this, PASSWORD__PROP);
	}

	@Override
	public test.example.data.LoginRequest setSessionId(String value) {
		internalSetSessionId(value);
		return this;
	}

	@Override
	public String jsonType() {
		return LOGIN_REQUEST__TYPE;
	}

	@SuppressWarnings("hiding")
	static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			USERNAME__PROP, 
			PASSWORD__PROP);
		java.util.List<String> tmp = new java.util.ArrayList<>();
		tmp.addAll(test.example.data.impl.Request_Impl.PROPERTIES);
		tmp.addAll(local);
		PROPERTIES = java.util.Collections.unmodifiableList(tmp);
	}

	@SuppressWarnings("hiding")
	static final java.util.Set<String> TRANSIENT_PROPERTIES;
	static {
		java.util.HashSet<String> tmp = new java.util.HashSet<>();
		tmp.addAll(test.example.data.impl.Request_Impl.TRANSIENT_PROPERTIES);
		tmp.addAll(java.util.Arrays.asList(
				));
		TRANSIENT_PROPERTIES = java.util.Collections.unmodifiableSet(tmp);
	}

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public java.util.Set<String> transientProperties() {
		return TRANSIENT_PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case USERNAME__PROP: return getUsername();
			case PASSWORD__PROP: return getPassword();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case USERNAME__PROP: internalSetUsername((String) value); break;
			case PASSWORD__PROP: internalSetPassword((String) value); break;
			default: super.set(field, value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(USERNAME__PROP);
		out.value(getUsername());
		out.name(PASSWORD__PROP);
		out.value(getPassword());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case USERNAME__PROP: setUsername(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			case PASSWORD__PROP: setPassword(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public int typeId() {
		return LOGIN_REQUEST__TYPE_ID;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(USERNAME__ID);
		out.value(getUsername());
		out.name(PASSWORD__ID);
		out.value(getPassword());
	}

	/** Helper for creating an object of type {@link test.example.data.LoginRequest} from a polymorphic composition. */
	public static test.example.data.LoginRequest readLoginRequest_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.example.data.impl.LoginRequest_Impl result = new LoginRequest_Impl();
		result.readContent(in);
		return result;
	}

	@Override
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case USERNAME__ID: setUsername(in.nextString()); break;
			case PASSWORD__ID: setPassword(in.nextString()); break;
			default: super.readField(in, field);
		}
	}

	/** XML element name representing a {@link test.example.data.LoginRequest} type. */
	public static final String LOGIN_REQUEST__XML_ELEMENT = "login-request";

	/** XML attribute or element name of a {@link #getUsername} property. */
	private static final String USERNAME__XML_ATTR = "username";

	/** XML attribute or element name of a {@link #getPassword} property. */
	private static final String PASSWORD__XML_ATTR = "password";

	@Override
	public String getXmlTagName() {
		return LOGIN_REQUEST__XML_ELEMENT;
	}

	/** Serializes all fields that are written as XML attributes. */
	@Override
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeAttributes(out);
		out.writeAttribute(USERNAME__XML_ATTR, getUsername());
		out.writeAttribute(PASSWORD__XML_ATTR, getPassword());
	}

	/** Serializes all fields that are written as XML elements. */
	@Override
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeElements(out);
		// No element fields.
	}

	/** Creates a new {@link test.example.data.LoginRequest} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static LoginRequest_Impl readLoginRequest_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		LoginRequest_Impl result = new LoginRequest_Impl();
		result.readContentXml(in);
		return result;
	}

	@Override
	protected void readFieldXmlAttribute(String name, String value) {
		switch (name) {
			case USERNAME__XML_ATTR: {
				setUsername(value);
				break;
			}
			case PASSWORD__XML_ATTR: {
				setPassword(value);
				break;
			}
			default: {
				super.readFieldXmlAttribute(name, value);
			}
		}
	}

	@Override
	protected void readFieldXmlElement(javax.xml.stream.XMLStreamReader in, String localName) throws javax.xml.stream.XMLStreamException {
		switch (localName) {
			case USERNAME__XML_ATTR: {
				setUsername(in.getElementText());
				break;
			}
			case PASSWORD__XML_ATTR: {
				setPassword(in.getElementText());
				break;
			}
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
