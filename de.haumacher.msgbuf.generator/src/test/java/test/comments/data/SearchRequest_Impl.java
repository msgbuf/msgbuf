package test.comments.data;

/**
 * SearchRequest represents a search query, with {@link #getPageNumber() pagination options} to
 * indicate which results to include in the response.
 */
class SearchRequest_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements SearchRequest {

	private String _query = "";

	private int _pageNumber = 0;

	private int _resultPerPage = 0;

	/**
	 * Creates a {@link SearchRequest_Impl} instance.
	 *
	 * @see SearchRequest#create()
	 */
	protected SearchRequest_Impl() {
		super();
	}

	@Override
	public final String getQuery() {
		return _query;
	}

	@Override
	public SearchRequest setQuery(String value) {
		internalSetQuery(value);
		return this;
	}

	/** Internal setter for {@link #getQuery()} without chain call utility. */
	protected final void internalSetQuery(String value) {
		_listener.beforeSet(this, QUERY, value);
		_query = value;
	}

	@Override
	public final int getPageNumber() {
		return _pageNumber;
	}

	@Override
	public SearchRequest setPageNumber(int value) {
		internalSetPageNumber(value);
		return this;
	}

	/** Internal setter for {@link #getPageNumber()} without chain call utility. */
	protected final void internalSetPageNumber(int value) {
		_listener.beforeSet(this, PAGE_NUMBER, value);
		_pageNumber = value;
	}

	@Override
	public final int getResultPerPage() {
		return _resultPerPage;
	}

	@Override
	public SearchRequest setResultPerPage(int value) {
		internalSetResultPerPage(value);
		return this;
	}

	/** Internal setter for {@link #getResultPerPage()} without chain call utility. */
	protected final void internalSetResultPerPage(int value) {
		_listener.beforeSet(this, RESULT_PER_PAGE, value);
		_resultPerPage = value;
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public SearchRequest registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public SearchRequest unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
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

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			QUERY, 
			PAGE_NUMBER, 
			RESULT_PER_PAGE));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case QUERY: return getQuery();
			case PAGE_NUMBER: return getPageNumber();
			case RESULT_PER_PAGE: return getResultPerPage();
			default: return SearchRequest.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case QUERY: internalSetQuery((String) value); break;
			case PAGE_NUMBER: internalSetPageNumber((int) value); break;
			case RESULT_PER_PAGE: internalSetResultPerPage((int) value); break;
		}
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(QUERY);
		out.value(getQuery());
		out.name(PAGE_NUMBER);
		out.value(getPageNumber());
		out.name(RESULT_PER_PAGE);
		out.value(getResultPerPage());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case QUERY: setQuery(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			case PAGE_NUMBER: setPageNumber(in.nextInt()); break;
			case RESULT_PER_PAGE: setResultPerPage(in.nextInt()); break;
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

	/** Helper for creating an object of type {@link SearchRequest} from a polymorphic composition. */
	public static SearchRequest readSearchRequest_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.comments.data.SearchRequest_Impl result = new SearchRequest_Impl();
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

}
