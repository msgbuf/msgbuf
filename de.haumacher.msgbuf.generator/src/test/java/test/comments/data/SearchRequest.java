package test.comments.data;

/**
 * SearchRequest represents a search query, with {@link #getPageNumber() pagination options} to
 * indicate which results to include in the response.
 */
public interface SearchRequest extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/**
	 * Creates a {@link test.comments.data.SearchRequest} instance.
	 */
	static test.comments.data.SearchRequest create() {
		return new test.comments.data.impl.SearchRequest_Impl();
	}

	/** Identifier for the {@link test.comments.data.SearchRequest} type in JSON format. */
	String SEARCH_REQUEST__TYPE = "SearchRequest";

	/** @see #getQuery() */
	String QUERY__PROP = "query";

	/** @see #getPageNumber() */
	String PAGE_NUMBER__PROP = "page_number";

	/** @see #getResultPerPage() */
	String RESULT_PER_PAGE__PROP = "result_per_page";

	/** Identifier for the property {@link #getQuery()} in binary format. */
	static final int QUERY__ID = 1;

	/** Identifier for the property {@link #getPageNumber()} in binary format. */
	static final int PAGE_NUMBER__ID = 2;

	/** Identifier for the property {@link #getResultPerPage()} in binary format. */
	static final int RESULT_PER_PAGE__ID = 3;

	/**
	 * The query string to interpret
	 */
	String getQuery();

	/**
	 * @see #getQuery()
	 */
	test.comments.data.SearchRequest setQuery(String value);

	/**
	 * The page of results to return. 
	 *
	 * <p>
	 * The number of entries in each page is specified by {@link #getResultPerPage()}.
	 * </p>
	 *
	 * @see #getResultPerPage()
	 */
	int getPageNumber();

	/**
	 * @see #getPageNumber()
	 */
	test.comments.data.SearchRequest setPageNumber(int value);

	/**
	 * The number of results to return at once.
	 *
	 * @see #getPageNumber()
	 */
	int getResultPerPage();

	/**
	 * @see #getResultPerPage()
	 */
	test.comments.data.SearchRequest setResultPerPage(int value);

	@Override
	public test.comments.data.SearchRequest registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.comments.data.SearchRequest unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.comments.data.SearchRequest readSearchRequest(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.comments.data.impl.SearchRequest_Impl result = new test.comments.data.impl.SearchRequest_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.comments.data.SearchRequest readSearchRequest(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.comments.data.SearchRequest result = test.comments.data.impl.SearchRequest_Impl.readSearchRequest_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link SearchRequest} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static SearchRequest readSearchRequest(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.comments.data.impl.SearchRequest_Impl.readSearchRequest_XmlContent(in);
	}

}
