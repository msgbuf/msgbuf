package test.nested.data;

class SearchResponse_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements SearchResponse {
	static class Result_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements Result {

		private String _url = "";

		private String _title = "";

		private final java.util.List<String> _snippets = new de.haumacher.msgbuf.util.ReferenceList<String>() {
			@Override
			protected void beforeAdd(int index, String element) {
				_listener.beforeAdd(Result_Impl.this, SNIPPETS, index, element);
			}

			@Override
			protected void afterRemove(int index, String element) {
				_listener.afterRemove(Result_Impl.this, SNIPPETS, index, element);
			}
		};

		/**
		 * Creates a {@link Result_Impl} instance.
		 *
		 * @see Result#create()
		 */
		protected Result_Impl() {
			super();
		}

		@Override
		public final String getUrl() {
			return _url;
		}

		@Override
		public Result setUrl(String value) {
			internalSetUrl(value);
			return this;
		}

		/** Internal setter for {@link #getUrl()} without chain call utility. */
		protected final void internalSetUrl(String value) {
			_listener.beforeSet(this, URL, value);
			_url = value;
		}

		@Override
		public final String getTitle() {
			return _title;
		}

		@Override
		public Result setTitle(String value) {
			internalSetTitle(value);
			return this;
		}

		/** Internal setter for {@link #getTitle()} without chain call utility. */
		protected final void internalSetTitle(String value) {
			_listener.beforeSet(this, TITLE, value);
			_title = value;
		}

		@Override
		public final java.util.List<String> getSnippets() {
			return _snippets;
		}

		@Override
		public Result setSnippets(java.util.List<? extends String> value) {
			internalSetSnippets(value);
			return this;
		}

		/** Internal setter for {@link #getSnippets()} without chain call utility. */
		protected final void internalSetSnippets(java.util.List<? extends String> value) {
			_snippets.clear();
			_snippets.addAll(value);
		}

		@Override
		public Result addSnippet(String value) {
			internalAddSnippet(value);
			return this;
		}

		/** Implementation of {@link #addSnippet(String)} without chain call utility. */
		protected final void internalAddSnippet(String value) {
			_snippets.add(value);
		}

		@Override
		public final void removeSnippet(String value) {
			_snippets.remove(value);
		}

		protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

		@Override
		public Result registerListener(de.haumacher.msgbuf.observer.Listener l) {
			internalRegisterListener(l);
			return this;
		}

		protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
			_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
		}

		@Override
		public Result unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
			internalUnregisterListener(l);
			return this;
		}

		protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
			_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
		}

		@Override
		public String jsonType() {
			return RESULT__TYPE;
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
				default: return Result.super.get(field);
			}
		}

		@Override
		public void set(String field, Object value) {
			switch (field) {
				case URL: internalSetUrl((String) value); break;
				case TITLE: internalSetTitle((String) value); break;
				case SNIPPETS: internalSetSnippets(de.haumacher.msgbuf.util.Conversions.asList(String.class, value)); break;
			}
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

		/** Helper for creating an object of type {@link Result} from a polymorphic composition. */
		public static Result readResult_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			test.nested.data.SearchResponse_Impl.Result_Impl result = new Result_Impl();
			result.readContent(in);
			return result;
		}

		/** Helper for reading all fields of this instance. */
		protected final void readContent(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			while (in.hasNext()) {
				int field = in.nextName();
				readField(in, field);
			}
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

	private final java.util.List<Result> _results = new de.haumacher.msgbuf.util.ReferenceList<Result>() {
		@Override
		protected void beforeAdd(int index, Result element) {
			_listener.beforeAdd(SearchResponse_Impl.this, RESULTS, index, element);
		}

		@Override
		protected void afterRemove(int index, Result element) {
			_listener.afterRemove(SearchResponse_Impl.this, RESULTS, index, element);
		}
	};

	/**
	 * Creates a {@link SearchResponse_Impl} instance.
	 *
	 * @see SearchResponse#create()
	 */
	protected SearchResponse_Impl() {
		super();
	}

	@Override
	public final java.util.List<Result> getResults() {
		return _results;
	}

	@Override
	public SearchResponse setResults(java.util.List<? extends Result> value) {
		internalSetResults(value);
		return this;
	}

	/** Internal setter for {@link #getResults()} without chain call utility. */
	protected final void internalSetResults(java.util.List<? extends Result> value) {
		if (value == null) throw new IllegalArgumentException("Property 'results' cannot be null.");
		_results.clear();
		_results.addAll(value);
	}

	@Override
	public SearchResponse addResult(Result value) {
		internalAddResult(value);
		return this;
	}

	/** Implementation of {@link #addResult(Result)} without chain call utility. */
	protected final void internalAddResult(Result value) {
		_results.add(value);
	}

	@Override
	public final void removeResult(Result value) {
		_results.remove(value);
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public SearchResponse registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public SearchResponse unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		internalUnregisterListener(l);
		return this;
	}

	protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
	}

	@Override
	public String jsonType() {
		return SEARCH_RESPONSE__TYPE;
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
			default: return SearchResponse.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case RESULTS: internalSetResults(de.haumacher.msgbuf.util.Conversions.asList(Result.class, value)); break;
		}
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

	/** Helper for creating an object of type {@link SearchResponse} from a polymorphic composition. */
	public static SearchResponse readSearchResponse_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.nested.data.SearchResponse_Impl result = new SearchResponse_Impl();
		result.readContent(in);
		return result;
	}

	/** Helper for reading all fields of this instance. */
	protected final void readContent(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		while (in.hasNext()) {
			int field = in.nextName();
			readField(in, field);
		}
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
