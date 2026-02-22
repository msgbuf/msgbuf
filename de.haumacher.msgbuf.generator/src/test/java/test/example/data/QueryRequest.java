package test.example.data;

/**
 * A request to execute a query.
 */
public interface QueryRequest extends Request {

	/**
	 * Creates a {@link test.example.data.QueryRequest} instance.
	 */
	static test.example.data.QueryRequest create() {
		return new test.example.data.impl.QueryRequest_Impl();
	}

	/** Identifier for the {@link test.example.data.QueryRequest} type in JSON format. */
	String QUERY_REQUEST__TYPE = "QueryRequest";

	/** @see #getQuery() */
	String QUERY__PROP = "query";

	/** @see #getLimit() */
	String LIMIT__PROP = "limit";

	/** Identifier for the {@link test.example.data.QueryRequest} type in binary format. */
	static final int QUERY_REQUEST__TYPE_ID = 2;

	/** Identifier for the property {@link #getQuery()} in binary format. */
	static final int QUERY__ID = 2;

	/** Identifier for the property {@link #getLimit()} in binary format. */
	static final int LIMIT__ID = 3;

	/**
	 * The query string to execute.
	 */
	String getQuery();

	/**
	 * @see #getQuery()
	 */
	test.example.data.QueryRequest setQuery(String value);

	/**
	 * The maximum number of results to return.
	 */
	int getLimit();

	/**
	 * @see #getLimit()
	 */
	test.example.data.QueryRequest setLimit(int value);

	@Override
	test.example.data.QueryRequest setSessionId(String value);

	/** Reads a new instance from the given reader. */
	static test.example.data.QueryRequest readQueryRequest(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.example.data.impl.QueryRequest_Impl result = new test.example.data.impl.QueryRequest_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.example.data.QueryRequest readQueryRequest(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.example.data.QueryRequest result = test.example.data.impl.QueryRequest_Impl.readQueryRequest_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link QueryRequest} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static QueryRequest readQueryRequest(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.example.data.impl.QueryRequest_Impl.readQueryRequest_XmlContent(in);
	}

}
