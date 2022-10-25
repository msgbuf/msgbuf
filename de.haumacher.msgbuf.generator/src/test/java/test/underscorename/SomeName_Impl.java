package test.underscorename;

class SomeName_Impl extends BaseMsg_Impl implements SomeName {

	private String _myField = "";

	/**
	 * Creates a {@link SomeName_Impl} instance.
	 *
	 * @see SomeName#create()
	 */
	protected SomeName_Impl() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.SOME_NAME;
	}

	@Override
	public final String getMyField() {
		return _myField;
	}

	@Override
	public SomeName setMyField(String value) {
		internalSetMyField(value);
		return this;
	}

	/** Internal setter for {@link #getMyField()} without chain call utility. */
	protected final void internalSetMyField(String value) {
		_listener.beforeSet(this, MY_FIELD, value);
		_myField = value;
	}

	@Override
	public String jsonType() {
		return SOME_NAME__TYPE;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			MY_FIELD));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case MY_FIELD: return getMyField();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case MY_FIELD: internalSetMyField((String) value); break;
			default: super.set(field, value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(MY_FIELD);
		out.value(getMyField());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case MY_FIELD: setMyField(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public int typeId() {
		return SOME_NAME__TYPE_ID;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(MY_FIELD__ID);
		out.value(getMyField());
	}

	/** Helper for creating an object of type {@link SomeName} from a polymorphic composition. */
	public static SomeName readsome_name_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.underscorename.SomeName_Impl result = new SomeName_Impl();
		result.readContent(in);
		return result;
	}

	@Override
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case MY_FIELD__ID: setMyField(in.nextString()); break;
			default: super.readField(in, field);
		}
	}

	/** XML element name representing a {@link SomeName} type. */
	public static final String SOME_NAME__XML_ELEMENT = "some-name";

	/** XML attribute or element name of a {@link #getMyField} property. */
	private static final String MY_FIELD__XML_ATTR = "my-field";

	/** Creates a new {@link SomeName} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static SomeName_Impl readSome_name_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		SomeName_Impl result = new SomeName_Impl();
		result.readContentXml(in);
		return result;
	}

	@Override
	protected void readFieldXmlAttribute(String name, String value) {
		switch (name) {
			case MY_FIELD__XML_ATTR: {
				setMyField(value);
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
			case MY_FIELD__XML_ATTR: {
				setMyField(in.getElementText());
				break;
			}
			default: {
				super.readFieldXmlElement(in, localName);
			}
		}
	}

	@Override
	public <R,A,E extends Throwable> R visit(BaseMsg.Visitor<R,A,E> v, A arg) throws E {
		return v.visit(this, arg);
	}

}
