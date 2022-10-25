package test.nested.data;

public interface SearchResponse extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable {
	public interface Result extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable {

		/**
		 * Creates a {@link Result} instance.
		 */
		static Result create() {
			return new test.nested.data.SearchResponse_Impl.Result_Impl();
		}

		/** Identifier for the {@link Result} type in JSON format. */
		static final String RESULT__TYPE = "Result";

		/** @see #getUrl() */
		static final String URL = "url";

		/** @see #getTitle() */
		static final String TITLE = "title";

		/** @see #getSnippets() */
		static final String SNIPPETS = "snippets";

		/** Identifier for the property {@link #getUrl()} in binary format. */
		static final int URL__ID = 1;

		/** Identifier for the property {@link #getTitle()} in binary format. */
		static final int TITLE__ID = 2;

		/** Identifier for the property {@link #getSnippets()} in binary format. */
		static final int SNIPPETS__ID = 3;

		String getUrl();

		/**
		 * @see #getUrl()
		 */
		Result setUrl(String value);

		String getTitle();

		/**
		 * @see #getTitle()
		 */
		Result setTitle(String value);

		java.util.List<String> getSnippets();

		/**
		 * @see #getSnippets()
		 */
		Result setSnippets(java.util.List<? extends String> value);

		/**
		 * Adds a value to the {@link #getSnippets()} list.
		 */
		Result addSnippet(String value);

		/**
		 * Removes a value from the {@link #getSnippets()} list.
		 */
		void removeSnippet(String value);

		@Override
		public Result registerListener(de.haumacher.msgbuf.observer.Listener l);

		@Override
		public Result unregisterListener(de.haumacher.msgbuf.observer.Listener l);


		/** Reads a new instance from the given reader. */
		static Result readResult(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			test.nested.data.SearchResponse_Impl.Result_Impl result = new test.nested.data.SearchResponse_Impl.Result_Impl();
			result.readContent(in);
			return result;
		}

		/** Reads a new instance from the given reader. */
		static Result readResult(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			in.beginObject();
			Result result = test.nested.data.SearchResponse_Impl.Result_Impl.readResult_Content(in);
			in.endObject();
			return result;
		}

		/** Creates a new {@link Result} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Result readResult(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			in.nextTag();
			return test.nested.data.SearchResponse_Impl.Result_Impl.readResult_XmlContent(in);
		}

	}

	/**
	 * Creates a {@link SearchResponse} instance.
	 */
	static SearchResponse create() {
		return new test.nested.data.SearchResponse_Impl();
	}

	/** Identifier for the {@link SearchResponse} type in JSON format. */
	static final String SEARCH_RESPONSE__TYPE = "SearchResponse";

	/** @see #getResults() */
	static final String RESULTS = "results";

	/** Identifier for the property {@link #getResults()} in binary format. */
	static final int RESULTS__ID = 1;

	java.util.List<Result> getResults();

	/**
	 * @see #getResults()
	 */
	SearchResponse setResults(java.util.List<? extends Result> value);

	/**
	 * Adds a value to the {@link #getResults()} list.
	 */
	SearchResponse addResult(Result value);

	/**
	 * Removes a value from the {@link #getResults()} list.
	 */
	void removeResult(Result value);

	@Override
	public SearchResponse registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public SearchResponse unregisterListener(de.haumacher.msgbuf.observer.Listener l);


	/** Reads a new instance from the given reader. */
	static SearchResponse readSearchResponse(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.nested.data.SearchResponse_Impl result = new test.nested.data.SearchResponse_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static SearchResponse readSearchResponse(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		SearchResponse result = test.nested.data.SearchResponse_Impl.readSearchResponse_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link SearchResponse} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static SearchResponse readSearchResponse(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.nested.data.SearchResponse_Impl.readSearchResponse_XmlContent(in);
	}

}
