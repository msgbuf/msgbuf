package test.nested.data;

public interface SearchResponse extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {
	public interface Result extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

		/**
		 * Creates a {@link test.nested.data.SearchResponse.Result} instance.
		 */
		static test.nested.data.SearchResponse.Result create() {
			return new test.nested.data.impl.SearchResponse_Impl.Result_Impl();
		}

		/** Identifier for the {@link test.nested.data.SearchResponse.Result} type in JSON format. */
		static final String RESULT__TYPE = "Result";

		/** @see #getUrl() */
		static final String URL__PROP = "url";

		/** @see #getTitle() */
		static final String TITLE__PROP = "title";

		/** @see #getSnippets() */
		static final String SNIPPETS__PROP = "snippets";

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
		test.nested.data.SearchResponse.Result setUrl(String value);

		String getTitle();

		/**
		 * @see #getTitle()
		 */
		test.nested.data.SearchResponse.Result setTitle(String value);

		java.util.List<String> getSnippets();

		/**
		 * @see #getSnippets()
		 */
		test.nested.data.SearchResponse.Result setSnippets(java.util.List<? extends String> value);

		/**
		 * Adds a value to the {@link #getSnippets()} list.
		 */
		test.nested.data.SearchResponse.Result addSnippet(String value);

		/**
		 * Removes a value from the {@link #getSnippets()} list.
		 */
		void removeSnippet(String value);

		@Override
		public test.nested.data.SearchResponse.Result registerListener(de.haumacher.msgbuf.observer.Listener l);

		@Override
		public test.nested.data.SearchResponse.Result unregisterListener(de.haumacher.msgbuf.observer.Listener l);

		/** Reads a new instance from the given reader. */
		static test.nested.data.SearchResponse.Result readResult(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			test.nested.data.impl.SearchResponse_Impl.Result_Impl result = new test.nested.data.impl.SearchResponse_Impl.Result_Impl();
			result.readContent(in);
			return result;
		}

		/** Reads a new instance from the given reader. */
		static test.nested.data.SearchResponse.Result readResult(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			in.beginObject();
			test.nested.data.SearchResponse.Result result = test.nested.data.impl.SearchResponse_Impl.Result_Impl.readResult_Content(in);
			in.endObject();
			return result;
		}

		/** Creates a new {@link Result} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Result readResult(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			in.nextTag();
			return test.nested.data.impl.SearchResponse_Impl.Result_Impl.readResult_XmlContent(in);
		}

	}

	/**
	 * Creates a {@link test.nested.data.SearchResponse} instance.
	 */
	static test.nested.data.SearchResponse create() {
		return new test.nested.data.impl.SearchResponse_Impl();
	}

	/** Identifier for the {@link test.nested.data.SearchResponse} type in JSON format. */
	static final String SEARCH_RESPONSE__TYPE = "SearchResponse";

	/** @see #getResults() */
	static final String RESULTS__PROP = "results";

	/** Identifier for the property {@link #getResults()} in binary format. */
	static final int RESULTS__ID = 1;

	java.util.List<test.nested.data.SearchResponse.Result> getResults();

	/**
	 * @see #getResults()
	 */
	test.nested.data.SearchResponse setResults(java.util.List<? extends test.nested.data.SearchResponse.Result> value);

	/**
	 * Adds a value to the {@link #getResults()} list.
	 */
	test.nested.data.SearchResponse addResult(test.nested.data.SearchResponse.Result value);

	/**
	 * Removes a value from the {@link #getResults()} list.
	 */
	void removeResult(test.nested.data.SearchResponse.Result value);

	@Override
	public test.nested.data.SearchResponse registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.nested.data.SearchResponse unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.nested.data.SearchResponse readSearchResponse(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.nested.data.impl.SearchResponse_Impl result = new test.nested.data.impl.SearchResponse_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.nested.data.SearchResponse readSearchResponse(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.nested.data.SearchResponse result = test.nested.data.impl.SearchResponse_Impl.readSearchResponse_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link SearchResponse} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static SearchResponse readSearchResponse(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.nested.data.impl.SearchResponse_Impl.readSearchResponse_XmlContent(in);
	}

}
