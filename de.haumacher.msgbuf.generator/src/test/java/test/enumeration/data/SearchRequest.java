package test.enumeration.data;

public class SearchRequest extends de.haumacher.msgbuf.data.AbstractDataObject implements de.haumacher.msgbuf.binary.BinaryDataObject {

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

		/** Writes this instance to the given binary output. */
		public final void writeTo(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
			switch (this) {
				case UNIVERSAL: out.value(0); break;
				case WEB: out.value(1); break;
				case IMAGES: out.value(2); break;
				case LOCAL: out.value(3); break;
				case NEWS: out.value(4); break;
				case PRODUCTS: out.value(5); break;
				case VIDEO: out.value(6); break;
				default: out.value(0);
			}
		}

		/** Reads a new instance from the given binary reader. */
		public static Corpus readCorpus(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			switch (in.nextInt()) {
				case 0: return UNIVERSAL;
				case 1: return WEB;
				case 2: return IMAGES;
				case 3: return LOCAL;
				case 4: return NEWS;
				case 5: return PRODUCTS;
				case 6: return VIDEO;
				default: return UNIVERSAL;
			}
		}
	}

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
		if (hasCorpus()) {
			out.name(4);
			getCorpus().writeTo(out);
		}
	}

	/** Consumes the value for the field with the given ID and assigns its value. */
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case 1: setQuery(in.nextString()); break;
			case 2: setPageNumber(in.nextInt()); break;
			case 3: setResultPerPage(in.nextInt()); break;
			case 4: setCorpus(Corpus.readCorpus(in)); break;
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
