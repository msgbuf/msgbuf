package test.types.data;

public class SearchRequest extends de.haumacher.msgbuf.data.AbstractDataObject implements de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable {

	/**
	 * Creates a {@link SearchRequest} instance.
	 */
	public static SearchRequest create() {
		return new SearchRequest();
	}

	/** Identifier for the {@link SearchRequest} type in JSON format. */
	public static final String SEARCH_REQUEST__TYPE = "SearchRequest";

	/** @see #getQuery() */
	public static final String QUERY = "query";

	/** @see #getPageNumber() */
	public static final String PAGE_NUMBER = "page_number";

	/** @see #getResultPerPage() */
	public static final String RESULT_PER_PAGE = "result_per_page";

	/** Identifier for the property {@link #getQuery()} in binary format. */
	public static final int QUERY__ID = 1;

	/** Identifier for the property {@link #getPageNumber()} in binary format. */
	public static final int PAGE_NUMBER__ID = 2;

	/** Identifier for the property {@link #getResultPerPage()} in binary format. */
	public static final int RESULT_PER_PAGE__ID = 3;

	private String _query = "";

	private int _pageNumber = 0;

	private int _resultPerPage = 0;

	/**
	 * Creates a {@link SearchRequest} instance.
	 *
	 * @see #create()
	 */
	protected SearchRequest() {
		super();
	}

	public final String getQuery() {
		return _query;
	}

	/**
	 * @see #getQuery()
	 */
	public SearchRequest setQuery(String value) {
		internalSetQuery(value);
		return this;
	}
	/** Internal setter for {@link #getQuery()} without chain call utility. */
	protected final void internalSetQuery(String value) {
		_listener.beforeSet(this, QUERY, value);
		_query = value;
	}


	public final int getPageNumber() {
		return _pageNumber;
	}

	/**
	 * @see #getPageNumber()
	 */
	public SearchRequest setPageNumber(int value) {
		internalSetPageNumber(value);
		return this;
	}
	/** Internal setter for {@link #getPageNumber()} without chain call utility. */
	protected final void internalSetPageNumber(int value) {
		_listener.beforeSet(this, PAGE_NUMBER, value);
		_pageNumber = value;
	}


	public final int getResultPerPage() {
		return _resultPerPage;
	}

	/**
	 * @see #getResultPerPage()
	 */
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
			default: return de.haumacher.msgbuf.observer.Observable.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case QUERY: setQuery((String) value); break;
			case PAGE_NUMBER: setPageNumber((int) value); break;
			case RESULT_PER_PAGE: setResultPerPage((int) value); break;
		}
	}

	/** Reads a new instance from the given reader. */
	public static SearchRequest readSearchRequest(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		SearchRequest result = new SearchRequest();
		in.beginObject();
		result.readFields(in);
		in.endObject();
		return result;
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

	/** Reads a new instance from the given reader. */
	public static SearchRequest readSearchRequest(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		SearchRequest result = new SearchRequest();
		while (in.hasNext()) {
			int field = in.nextName();
			result.readField(in, field);
		}
		in.endObject();
		return result;
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
