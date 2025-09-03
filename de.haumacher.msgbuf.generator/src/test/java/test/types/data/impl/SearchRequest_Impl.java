package test.types.data.impl;

/**
 * Implementation of {@link test.types.data.SearchRequest}.
 */
public class SearchRequest_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.types.data.SearchRequest {

	private String _query = "";

	private int _pageNumber = 0;

	private int _resultPerPage = 0;

	/**
	 * Creates a {@link SearchRequest_Impl} instance.
	 *
	 * @see test.types.data.SearchRequest#create()
	 */
	public SearchRequest_Impl() {
		super();
	}

	@Override
	public final String getQuery() {
		return _query;
	}

	@Override
	public test.types.data.SearchRequest setQuery(String value) {
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
	public final int getPageNumber() {
		return _pageNumber;
	}

	@Override
	public test.types.data.SearchRequest setPageNumber(int value) {
		internalSetPageNumber(value);
		return this;
	}

	/** Internal setter for {@link #getPageNumber()} without chain call utility. */
	protected final void internalSetPageNumber(int value) {
		_listener.beforeSet(this, PAGE_NUMBER__PROP, value);
		_pageNumber = value;
		_listener.afterChanged(this, PAGE_NUMBER__PROP);
	}

	@Override
	public final int getResultPerPage() {
		return _resultPerPage;
	}

	@Override
	public test.types.data.SearchRequest setResultPerPage(int value) {
		internalSetResultPerPage(value);
		return this;
	}

	/** Internal setter for {@link #getResultPerPage()} without chain call utility. */
	protected final void internalSetResultPerPage(int value) {
		_listener.beforeSet(this, RESULT_PER_PAGE__PROP, value);
		_resultPerPage = value;
		_listener.afterChanged(this, RESULT_PER_PAGE__PROP);
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.types.data.SearchRequest registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.types.data.SearchRequest unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		internalUnregisterListener(l);
		return this;
	}

	protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
	}

	@Override
	public String jsonType() {
		return SEARCH_REQUEST__TYPE;
	}

	static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			QUERY__PROP, 
			PAGE_NUMBER__PROP, 
			RESULT_PER_PAGE__PROP);
		PROPERTIES = java.util.Collections.unmodifiableList(local);
	}

	static final java.util.Set<String> TRANSIENT_PROPERTIES;
	static {
		java.util.HashSet<String> tmp = new java.util.HashSet<>();
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
			case PAGE_NUMBER__PROP: return getPageNumber();
			case RESULT_PER_PAGE__PROP: return getResultPerPage();
			default: return test.types.data.SearchRequest.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case QUERY__PROP: internalSetQuery((String) value); break;
			case PAGE_NUMBER__PROP: internalSetPageNumber((int) value); break;
			case RESULT_PER_PAGE__PROP: internalSetResultPerPage((int) value); break;
		}
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(QUERY__PROP);
		out.value(getQuery());
		out.name(PAGE_NUMBER__PROP);
		out.value(getPageNumber());
		out.name(RESULT_PER_PAGE__PROP);
		out.value(getResultPerPage());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case QUERY__PROP: setQuery(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			case PAGE_NUMBER__PROP: setPageNumber(in.nextInt()); break;
			case RESULT_PER_PAGE__PROP: setResultPerPage(in.nextInt()); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		out.beginObject();
		writeFields(out);
		out.endObject();
	}

	/**
	 * Serializes all fields of this instance to the given binary output.
	 *
	 * @param out
	 *        The binary output to write to.
	 * @throws java.io.IOException If writing fails.
	 */
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		out.name(QUERY__ID);
		out.value(getQuery());
		out.name(PAGE_NUMBER__ID);
		out.value(getPageNumber());
		out.name(RESULT_PER_PAGE__ID);
		out.value(getResultPerPage());
	}

	/** Helper for creating an object of type {@link test.types.data.SearchRequest} from a polymorphic composition. */
	public static test.types.data.SearchRequest readSearchRequest_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.types.data.impl.SearchRequest_Impl result = new SearchRequest_Impl();
		result.readContent(in);
		return result;
	}

	/** Helper for reading all fields of this instance. */
	protected final void readContent(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		while (in.hasNext()) {
			int field = in.nextName();
			readField(in, field);
		}
	}

	/** Consumes the value for the field with the given ID and assigns its value. */
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case QUERY__ID: setQuery(in.nextString()); break;
			case PAGE_NUMBER__ID: setPageNumber(in.nextInt()); break;
			case RESULT_PER_PAGE__ID: setResultPerPage(in.nextInt()); break;
			default: in.skipValue(); 
		}
	}

	/** XML element name representing a {@link test.types.data.SearchRequest} type. */
	public static final String SEARCH_REQUEST__XML_ELEMENT = "search-request";

	/** XML attribute or element name of a {@link #getQuery} property. */
	private static final String QUERY__XML_ATTR = "query";

	/** XML attribute or element name of a {@link #getPageNumber} property. */
	private static final String PAGE_NUMBER__XML_ATTR = "page-number";

	/** XML attribute or element name of a {@link #getResultPerPage} property. */
	private static final String RESULT_PER_PAGE__XML_ATTR = "result-per-page";

	@Override
	public String getXmlTagName() {
		return SEARCH_REQUEST__XML_ELEMENT;
	}

	@Override
	public final void writeContent(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		writeAttributes(out);
		writeElements(out);
	}

	/** Serializes all fields that are written as XML attributes. */
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		out.writeAttribute(QUERY__XML_ATTR, getQuery());
		out.writeAttribute(PAGE_NUMBER__XML_ATTR, Integer.toString(getPageNumber()));
		out.writeAttribute(RESULT_PER_PAGE__XML_ATTR, Integer.toString(getResultPerPage()));
	}

	/** Serializes all fields that are written as XML elements. */
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		// No element fields.
	}

	/** Creates a new {@link test.types.data.SearchRequest} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static SearchRequest_Impl readSearchRequest_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		SearchRequest_Impl result = new SearchRequest_Impl();
		result.readContentXml(in);
		return result;
	}

	/** Reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	protected final void readContentXml(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		for (int n = 0, cnt = in.getAttributeCount(); n < cnt; n++) {
			String name = in.getAttributeLocalName(n);
			String value = in.getAttributeValue(n);

			readFieldXmlAttribute(name, value);
		}
		while (true) {
			int event = in.nextTag();
			if (event == javax.xml.stream.XMLStreamConstants.END_ELEMENT) {
				break;
			}
			assert event == javax.xml.stream.XMLStreamConstants.START_ELEMENT;

			String localName = in.getLocalName();
			readFieldXmlElement(in, localName);
		}
	}

	/** Parses the given attribute value and assigns it to the field with the given name. */
	protected void readFieldXmlAttribute(String name, String value) {
		switch (name) {
			case QUERY__XML_ATTR: {
				setQuery(value);
				break;
			}
			case PAGE_NUMBER__XML_ATTR: {
				setPageNumber(Integer.parseInt(value));
				break;
			}
			case RESULT_PER_PAGE__XML_ATTR: {
				setResultPerPage(Integer.parseInt(value));
				break;
			}
			default: {
				// Skip unknown attribute.
			}
		}
	}

	/** Reads the element under the cursor and assigns its contents to the field with the given name. */
	protected void readFieldXmlElement(javax.xml.stream.XMLStreamReader in, String localName) throws javax.xml.stream.XMLStreamException {
		switch (localName) {
			case QUERY__XML_ATTR: {
				setQuery(in.getElementText());
				break;
			}
			case PAGE_NUMBER__XML_ATTR: {
				setPageNumber(Integer.parseInt(in.getElementText()));
				break;
			}
			case RESULT_PER_PAGE__XML_ATTR: {
				setResultPerPage(Integer.parseInt(in.getElementText()));
				break;
			}
			default: {
				internalSkipUntilMatchingEndElement(in);
			}
		}
	}

	protected static final void internalSkipUntilMatchingEndElement(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		int level = 0;
		while (true) {
			switch (in.next()) {
				case javax.xml.stream.XMLStreamConstants.START_ELEMENT: level++; break;
				case javax.xml.stream.XMLStreamConstants.END_ELEMENT: if (level == 0) { return; } else { level--; break; }
			}
		}
	}

}
