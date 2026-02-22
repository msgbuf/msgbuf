package test.example.data.impl;

/**
 * Implementation of {@link test.example.data.QueryRequest}.
 */
public class QueryRequest_Impl extends test.example.data.impl.Request_Impl implements test.example.data.QueryRequest {

	private String _query = "";

	private int _limit = 0;

	/**
	 * Creates a {@link QueryRequest_Impl} instance.
	 *
	 * @see test.example.data.QueryRequest#create()
	 */
	public QueryRequest_Impl() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.QUERY_REQUEST;
	}

	@Override
	public final String getQuery() {
		return _query;
	}

	@Override
	public test.example.data.QueryRequest setQuery(String value) {
		internalSetQuery(value);
		return this;
	}

	/** Internal setter for {@link #getQuery()} without chain call utility. */
	protected final void internalSetQuery(String value) {
		_listener.beforeSet(this, QUERY__PROP, value);
		_query = value;
		_listener.afterChanged(this, QUERY__PROP);
	}

	@Override
	public final int getLimit() {
		return _limit;
	}

	@Override
	public test.example.data.QueryRequest setLimit(int value) {
		internalSetLimit(value);
		return this;
	}

	/** Internal setter for {@link #getLimit()} without chain call utility. */
	protected final void internalSetLimit(int value) {
		_listener.beforeSet(this, LIMIT__PROP, value);
		_limit = value;
		_listener.afterChanged(this, LIMIT__PROP);
	}

	@Override
	public test.example.data.QueryRequest setSessionId(String value) {
		internalSetSessionId(value);
		return this;
	}

	@Override
	public String jsonType() {
		return QUERY_REQUEST__TYPE;
	}

	@SuppressWarnings("hiding")
	static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			QUERY__PROP, 
			LIMIT__PROP);
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
			case QUERY__PROP: return getQuery();
			case LIMIT__PROP: return getLimit();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case QUERY__PROP: internalSetQuery((String) value); break;
			case LIMIT__PROP: internalSetLimit((int) value); break;
			default: super.set(field, value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(QUERY__PROP);
		out.value(getQuery());
		out.name(LIMIT__PROP);
		out.value(getLimit());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case QUERY__PROP: setQuery(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			case LIMIT__PROP: setLimit(in.nextInt()); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public int typeId() {
		return QUERY_REQUEST__TYPE_ID;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(QUERY__ID);
		out.value(getQuery());
		out.name(LIMIT__ID);
		out.value(getLimit());
	}

	/** Helper for creating an object of type {@link test.example.data.QueryRequest} from a polymorphic composition. */
	public static test.example.data.QueryRequest readQueryRequest_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.example.data.impl.QueryRequest_Impl result = new QueryRequest_Impl();
		result.readContent(in);
		return result;
	}

	@Override
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case QUERY__ID: setQuery(in.nextString()); break;
			case LIMIT__ID: setLimit(in.nextInt()); break;
			default: super.readField(in, field);
		}
	}

	/** XML element name representing a {@link test.example.data.QueryRequest} type. */
	public static final String QUERY_REQUEST__XML_ELEMENT = "query-request";

	/** XML attribute or element name of a {@link #getQuery} property. */
	private static final String QUERY__XML_ATTR = "query";

	/** XML attribute or element name of a {@link #getLimit} property. */
	private static final String LIMIT__XML_ATTR = "limit";

	@Override
	public String getXmlTagName() {
		return QUERY_REQUEST__XML_ELEMENT;
	}

	/** Serializes all fields that are written as XML attributes. */
	@Override
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeAttributes(out);
		out.writeAttribute(QUERY__XML_ATTR, getQuery());
		out.writeAttribute(LIMIT__XML_ATTR, Integer.toString(getLimit()));
	}

	/** Serializes all fields that are written as XML elements. */
	@Override
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeElements(out);
		// No element fields.
	}

	/** Creates a new {@link test.example.data.QueryRequest} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static QueryRequest_Impl readQueryRequest_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		QueryRequest_Impl result = new QueryRequest_Impl();
		result.readContentXml(in);
		return result;
	}

	@Override
	protected void readFieldXmlAttribute(String name, String value) {
		switch (name) {
			case QUERY__XML_ATTR: {
				setQuery(value);
				break;
			}
			case LIMIT__XML_ATTR: {
				setLimit(Integer.parseInt(value));
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
			case QUERY__XML_ATTR: {
				setQuery(in.getElementText());
				break;
			}
			case LIMIT__XML_ATTR: {
				setLimit(Integer.parseInt(in.getElementText()));
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
