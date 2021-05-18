package test.enumeration;

public class SearchRequest extends de.haumacher.msgbuf.data.AbstractDataObject {

	public enum Corpus {

		UNIVERSAL,

		WEB,

		IMAGES,

		LOCAL,

		NEWS,

		PRODUCTS,

		VIDEO,

		;

		/** Writes this instance to the given output. */
		public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
			out.value(name());
		}

		/** Reads a new instance from the given reader. */
		public static Corpus readCorpus(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			return valueOf(in.nextString());
		}
	}

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

	private Corpus _corpus = Corpus.UNIVERSAL;

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

	public final Corpus getCorpus() {
		return _corpus;
	}

	/**
	 * @see #getCorpus()
	 */
	public final SearchRequest setCorpus(Corpus value) {
		_corpus = value;
		return this;
	}

	/**
	 * Checks, whether {@link #getCorpus()} has a value.
	 */
	public final boolean hasCorpus() {
		return _corpus != null;
	}

	/** Reads a new instance from the given reader. */
	public static SearchRequest readSearchRequest(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		SearchRequest result = new SearchRequest();
		result.readFields(in);
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
			case "corpus": return getCorpus();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case "query": setQuery((String) value); break;
			case "page_number": setPageNumber((int) value); break;
			case "result_per_page": setResultPerPage((int) value); break;
			case "corpus": setCorpus((Corpus) value); break;
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
		if (hasCorpus()) {
			out.name("corpus");
			getCorpus().writeTo(out);
		}
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case "query": setQuery(in.nextString()); break;
			case "page_number": setPageNumber(in.nextInt()); break;
			case "result_per_page": setResultPerPage(in.nextInt()); break;
			case "corpus": setCorpus(Corpus.readCorpus(in)); break;
			default: super.readField(in, field);
		}
	}

}
