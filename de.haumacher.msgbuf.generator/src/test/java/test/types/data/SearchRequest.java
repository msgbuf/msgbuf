package test.types.data;

public class SearchRequest extends de.haumacher.msgbuf.data.AbstractDataObject implements de.haumacher.msgbuf.binary.BinaryDataObject {

	/**
	 * Creates a {@link SearchRequest} instance.
	 */
	public static SearchRequest create() {
		return new SearchRequest();
	}

	/**
	 * Creates a {@link SearchRequest} instance.
	 *
	 * @see #create()
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
	public Object get(String field) {
		switch (field) {
			case "query": return getQuery();
			case "page_number": return getPageNumber();
			case "result_per_page": return getResultPerPage();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case "query": setQuery((String) value); break;
			case "page_number": setPageNumber((int) value); break;
			case "result_per_page": setResultPerPage((int) value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name("query");
		out.value(getQuery());
		out.name("page_number");
		out.value(getPageNumber());
		out.name("result_per_page");
		out.value(getResultPerPage());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case "query": setQuery(in.nextString()); break;
			case "page_number": setPageNumber(in.nextInt()); break;
			case "result_per_page": setResultPerPage(in.nextInt()); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		out.beginObject();
		writeFields(out);
		out.endObject();
	}

	/** Serializes all fields of this instance to the given binary output. */
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		out.name(1);
		out.value(getQuery());
		out.name(2);
		out.value(getPageNumber());
		out.name(3);
		out.value(getResultPerPage());
	}

	/** Consumes the value for the field with the given ID and assigns its value. */
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case 1: setQuery(in.nextString()); break;
			case 2: setPageNumber(in.nextInt()); break;
			case 3: setResultPerPage(in.nextInt()); break;
			default: in.skipValue(); 
		}
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

}
