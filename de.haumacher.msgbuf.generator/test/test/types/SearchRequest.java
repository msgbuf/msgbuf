package test.types;

public class SearchRequest {

	/**
	 * Creates a {@link SearchRequest} instance.
	 */
	public static SearchRequest searchRequest() {
		return new SearchRequest();
	}

	/**
	 * Creates a {@link SearchRequest} instance.
	 *
	 * @see #searchRequest()
	 */
	protected SearchRequest() {
		super();
	}

	private String _query = "";

	private int _pageNumber = 0;

	private int _resultPerPage = 0;

	public final String getQuery() {
		return _query;
	}

	/**
	 * @see #getQuery()
	 */
	public final SearchRequest setQuery(String value) {
		_query = value;
		return this;
	}

	public final int getPageNumber() {
		return _pageNumber;
	}

	/**
	 * @see #getPageNumber()
	 */
	public final SearchRequest setPageNumber(int value) {
		_pageNumber = value;
		return this;
	}

	public final int getResultPerPage() {
		return _resultPerPage;
	}

	/**
	 * @see #getResultPerPage()
	 */
	public final SearchRequest setResultPerPage(int value) {
		_resultPerPage = value;
		return this;
	}

	private static final int[] FIELDS = {1, 2, 3, };

	/** Reads a new instance from the given reader. */
	public static SearchRequest readSearchRequest(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		SearchRequest result = new SearchRequest();
		result.readContent(in);
		return result;
	}

	/** Writes this instance to the given output. */
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		out.beginObject();
		writeContent(out);
		out.endObject();
	}

	/** Reads all fields of this instance from the given input. */
	protected final void readContent(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		while (in.hasNext()) {
			String field = in.nextName();
			readField(in, field);
		}
	}

	/** Retrieves value of the field with the given index. */
	public Object get(String field) {
		switch (field) {
			case "query": return getQuery();
			case "page_number": return getPageNumber();
			case "result_per_page": return getResultPerPage();
			default: return null;
		}
	}

	/** Sets the value of the field with the given index. */
	public void set(String field, Object value) {
		switch (field) {
			case "query": setQuery((String) value); break;
			case "page_number": setPageNumber((int) value); break;
			case "result_per_page": setResultPerPage((int) value); break;
		}
	}

	/** Writes all fields of this instance to the given output. */
	protected void writeContent(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		out.name("query");
		out.value(getQuery());
		out.name("page_number");
		out.value(getPageNumber());
		out.name("result_per_page");
		out.value(getResultPerPage());
	}

	/** Reads the given field from the given input. */
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case "query": setQuery(in.nextString()); break;
			case "page_number": setPageNumber(in.nextInt()); break;
			case "result_per_page": setResultPerPage(in.nextInt()); break;
			default: in.skipValue();
		}
	}

}
