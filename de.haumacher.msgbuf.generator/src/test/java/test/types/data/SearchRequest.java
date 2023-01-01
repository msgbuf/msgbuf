package test.types.data;

public interface SearchRequest extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/**
	 * Creates a {@link test.types.data.SearchRequest} instance.
	 */
	static test.types.data.SearchRequest create() {
		return new test.types.data.impl.SearchRequest_Impl();
	}

	/** Identifier for the {@link test.types.data.SearchRequest} type in JSON format. */
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

	String getQuery();

	/**
	 * @see #getQuery()
	 */
	test.types.data.SearchRequest setQuery(String value);

	int getPageNumber();

	/**
	 * @see #getPageNumber()
	 */
	test.types.data.SearchRequest setPageNumber(int value);

	int getResultPerPage();

	/**
	 * @see #getResultPerPage()
	 */
	test.types.data.SearchRequest setResultPerPage(int value);

	@Override
	public test.types.data.SearchRequest registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.types.data.SearchRequest unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.types.data.SearchRequest readSearchRequest(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.types.data.impl.SearchRequest_Impl result = new test.types.data.impl.SearchRequest_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.types.data.SearchRequest readSearchRequest(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.types.data.SearchRequest result = test.types.data.impl.SearchRequest_Impl.readSearchRequest_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link SearchRequest} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static SearchRequest readSearchRequest(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.types.data.impl.SearchRequest_Impl.readSearchRequest_XmlContent(in);
	}

}
