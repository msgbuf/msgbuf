package test.nested.data;

public class SearchResponse extends de.haumacher.msgbuf.data.AbstractDataObject implements de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable {
	public static class Result extends de.haumacher.msgbuf.data.AbstractDataObject implements de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable {

		/**
		 * Creates a {@link Result} instance.
		 */
		public static Result create() {
			return new Result();
		}

		/** Identifier for the {@link Result} type in JSON format. */
		public static final String RESULT__TYPE = "Result";

		/** @see #getUrl() */
		public static final String URL = "url";

		/** @see #getTitle() */
		public static final String TITLE = "title";

		/** @see #getSnippets() */
		public static final String SNIPPETS = "snippets";

		/** Identifier for the property {@link #getUrl()} in binary format. */
		public static final int URL__ID = 1;

		/** Identifier for the property {@link #getTitle()} in binary format. */
		public static final int TITLE__ID = 2;

		/** Identifier for the property {@link #getSnippets()} in binary format. */
		public static final int SNIPPETS__ID = 3;

		private String _url = "";

		private String _title = "";

		private final java.util.List<String> _snippets = new de.haumacher.msgbuf.util.ReferenceList<String>() {
			@Override
			protected void beforeAdd(int index, String element) {
				_listener.beforeAdd(test.nested.data.SearchResponse.Result.this, SNIPPETS, index, element);
			}

			@Override
			protected void afterRemove(int index, String element) {
				_listener.afterRemove(test.nested.data.SearchResponse.Result.this, SNIPPETS, index, element);
			}
		};

		/**
		 * Creates a {@link Result} instance.
		 *
		 * @see #create()
		 */
		protected Result() {
			super();
		}

		public final String getUrl() {
			return _url;
		}

		/**
		 * @see #getUrl()
		 */
		public final Result setUrl(String value) {
			_listener.beforeSet(this, URL, value);
			_url = value;
			return this;
		}

		public final String getTitle() {
			return _title;
		}

		/**
		 * @see #getTitle()
		 */
		public final Result setTitle(String value) {
			_listener.beforeSet(this, TITLE, value);
			_title = value;
			return this;
		}

		public final java.util.List<String> getSnippets() {
			return _snippets;
		}

		/**
		 * @see #getSnippets()
		 */
		public final Result setSnippets(java.util.List<String> value) {
			_snippets.clear();
			_snippets.addAll(value);
			return this;
		}

		/**
		 * Adds a value to the {@link #getSnippets()} list.
		 */
		public final Result addSnippet(String value) {
			_snippets.add(value);
			return this;
		}

		/**
		 * Removes a value from the {@link #getSnippets()} list.
		 */
		public final Result removeSnippet(String value) {
			_snippets.remove(value);
			return this;
		}

		protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

		@Override
		public Result registerListener(de.haumacher.msgbuf.observer.Listener l) {
			_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
			return this;
		}

		@Override
		public Result unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
			_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
			return this;
		}

		private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
			java.util.Arrays.asList(
				URL, 
				TITLE, 
				SNIPPETS));

		@Override
		public java.util.List<String> properties() {
			return PROPERTIES;
		}

		@Override
		public Object get(String field) {
			switch (field) {
				case URL: return getUrl();
				case TITLE: return getTitle();
				case SNIPPETS: return getSnippets();
				default: return de.haumacher.msgbuf.observer.Observable.super.get(field);
			}
		}

		@Override
		public void set(String field, Object value) {
			switch (field) {
				case URL: setUrl((String) value); break;
				case TITLE: setTitle((String) value); break;
				case SNIPPETS: setSnippets((java.util.List<String>) value); break;
			}
		}

		/** Reads a new instance from the given reader. */
		public static Result readResult(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			Result result = new Result();
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
			out.name(URL);
			out.value(getUrl());
			out.name(TITLE);
			out.value(getTitle());
			out.name(SNIPPETS);
			out.beginArray();
			for (String x : getSnippets()) {
				out.value(x);
			}
			out.endArray();
		}

		@Override
		protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
			switch (field) {
				case URL: setUrl(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
				case TITLE: setTitle(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
				case SNIPPETS: {
					in.beginArray();
					while (in.hasNext()) {
						addSnippet(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in));
					}
					in.endArray();
				}
				break;
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
			out.name(URL__ID);
			out.value(getUrl());
			out.name(TITLE__ID);
			out.value(getTitle());
			out.name(SNIPPETS__ID);
			{
				java.util.List<String> values = getSnippets();
				out.beginArray(de.haumacher.msgbuf.binary.DataType.STRING, values.size());
				for (String x : values) {
					out.value(x);
				}
				out.endArray();
			}
		}

		/** Reads a new instance from the given reader. */
		public static Result readResult(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			in.beginObject();
			Result result = new Result();
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
				case URL__ID: setUrl(in.nextString()); break;
				case TITLE__ID: setTitle(in.nextString()); break;
				case SNIPPETS__ID: {
					in.beginArray();
					while (in.hasNext()) {
						addSnippet(in.nextString());
					}
					in.endArray();
				}
				break;
				default: in.skipValue(); 
			}
		}

	}

	/**
	 * Creates a {@link SearchResponse} instance.
	 */
	public static SearchResponse create() {
		return new SearchResponse();
	}

	/** Identifier for the {@link SearchResponse} type in JSON format. */
	public static final String SEARCH_RESPONSE__TYPE = "SearchResponse";

	/** @see #getResults() */
	public static final String RESULTS = "results";

	/** Identifier for the property {@link #getResults()} in binary format. */
	public static final int RESULTS__ID = 1;

	private final java.util.List<Result> _results = new de.haumacher.msgbuf.util.ReferenceList<Result>() {
		@Override
		protected void beforeAdd(int index, Result element) {
			_listener.beforeAdd(test.nested.data.SearchResponse.this, RESULTS, index, element);
		}

		@Override
		protected void afterRemove(int index, Result element) {
			_listener.afterRemove(test.nested.data.SearchResponse.this, RESULTS, index, element);
		}
	};

	/**
	 * Creates a {@link SearchResponse} instance.
	 *
	 * @see #create()
	 */
	protected SearchResponse() {
		super();
	}

	public final java.util.List<Result> getResults() {
		return _results;
	}

	/**
	 * @see #getResults()
	 */
	public final SearchResponse setResults(java.util.List<Result> value) {
		if (value == null) throw new IllegalArgumentException("Property 'results' cannot be null.");
		_results.clear();
		_results.addAll(value);
		return this;
	}

	/**
	 * Adds a value to the {@link #getResults()} list.
	 */
	public final SearchResponse addResult(Result value) {
		_results.add(value);
		return this;
	}

	/**
	 * Removes a value from the {@link #getResults()} list.
	 */
	public final SearchResponse removeResult(Result value) {
		_results.remove(value);
		return this;
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public SearchResponse registerListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
		return this;
	}

	@Override
	public SearchResponse unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
		return this;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			RESULTS));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case RESULTS: return getResults();
			default: return de.haumacher.msgbuf.observer.Observable.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case RESULTS: setResults((java.util.List<Result>) value); break;
		}
	}

	/** Reads a new instance from the given reader. */
	public static SearchResponse readSearchResponse(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		SearchResponse result = new SearchResponse();
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
		out.name(RESULTS);
		out.beginArray();
		for (Result x : getResults()) {
			x.writeTo(out);
		}
		out.endArray();
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case RESULTS: {
				in.beginArray();
				while (in.hasNext()) {
					addResult(test.nested.data.SearchResponse.Result.readResult(in));
				}
				in.endArray();
			}
			break;
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
		out.name(RESULTS__ID);
		{
			java.util.List<Result> values = getResults();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.OBJECT, values.size());
			for (Result x : values) {
				x.writeTo(out);
			}
			out.endArray();
		}
	}

	/** Reads a new instance from the given reader. */
	public static SearchResponse readSearchResponse(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		SearchResponse result = new SearchResponse();
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
			case RESULTS__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addResult(test.nested.data.SearchResponse.Result.readResult(in));
				}
				in.endArray();
			}
			break;
			default: in.skipValue(); 
		}
	}

}
