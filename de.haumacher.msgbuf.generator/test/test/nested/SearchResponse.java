package test.nested;

public class SearchResponse {
	public static class Result {

		/**
		 * Creates a {@link Result} instance.
		 */
		public static Result result() {
			return new Result();
		}

		/**
		 * Creates a {@link Result} instance.
		 *
		 * @see #result()
		 */
		protected Result() {
			super();
		}

		private String _url = "";

		private String _title = "";

		private final java.util.List<String> _snippets = new java.util.ArrayList<>();

		public final String getUrl() {
			return _url;
		}

		/**
		 * @see #getUrl()
		 */
		public final Result setUrl(String value) {
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
		public final void addSnippet(String value) {
			_snippets.add(value);
		}

		/** Reads a new instance from the given reader. */
		public static Result readResult(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			Result result = new Result();
			result.readContent(in);
			return result;
		}

		/** Writes this instance to the given output. */
		public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
			out.beginObject();
			writeContent(out);
			out.endObject();
		}

		/** Reads all fields of this instance from the given input. */
		protected final void readContent(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			while (in.hasNext()) {
				String field = in.nextName();
				readField(in, field);
			}
		}

		/** Retrieves value of the field with the given index. */
		public Object get(String field) {
			switch (field) {
				case "url": return getUrl();
				case "title": return getTitle();
				case "snippets": return getSnippets();
				default: return null;
			}
		}

		/** Sets the value of the field with the given index. */
		public void set(String field, Object value) {
			switch (field) {
				case "url": setUrl((String) value); break;
				case "title": setTitle((String) value); break;
				case "snippets": setSnippets((java.util.List<String>) value); break;
			}
		}

		/** Writes all fields of this instance to the given output. */
		protected void writeContent(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
			out.name("url");
			out.value(getUrl());
			out.name("title");
			out.value(getTitle());
			out.name("snippets");
			out.beginArray();
			for (String x : getSnippets()) {
				out.value(x);
			}
			out.endArray();
		}

		/** Reads the given field from the given input. */
		protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
			switch (field) {
				case "url": setUrl(in.nextString()); break;
				case "title": setTitle(in.nextString()); break;
				case "snippets": {
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
	public static SearchResponse searchResponse() {
		return new SearchResponse();
	}

	/**
	 * Creates a {@link SearchResponse} instance.
	 *
	 * @see #searchResponse()
	 */
	protected SearchResponse() {
		super();
	}

	private final java.util.List<Result> _results = new java.util.ArrayList<>();

	public final java.util.List<Result> getResults() {
		return _results;
	}

	/**
	 * @see #getResults()
	 */
	public final SearchResponse setResults(java.util.List<Result> value) {
		_results.clear();
		_results.addAll(value);
		return this;
	}

	/**
	 * Adds a value to the {@link #getResults()} list.
	 */
	public final void addResult(Result value) {
		_results.add(value);
	}

	/** Reads a new instance from the given reader. */
	public static SearchResponse readSearchResponse(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		SearchResponse result = new SearchResponse();
		result.readContent(in);
		return result;
	}

	/** Writes this instance to the given output. */
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		out.beginObject();
		writeContent(out);
		out.endObject();
	}

	/** Reads all fields of this instance from the given input. */
	protected final void readContent(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		while (in.hasNext()) {
			String field = in.nextName();
			readField(in, field);
		}
	}

	/** Retrieves value of the field with the given index. */
	public Object get(String field) {
		switch (field) {
			case "results": return getResults();
			default: return null;
		}
	}

	/** Sets the value of the field with the given index. */
	public void set(String field, Object value) {
		switch (field) {
			case "results": setResults((java.util.List<Result>) value); break;
		}
	}

	/** Writes all fields of this instance to the given output. */
	protected void writeContent(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		out.name("results");
		out.beginArray();
		for (Result x : getResults()) {
			x.writeTo(out);
		}
		out.endArray();
	}

	/** Reads the given field from the given input. */
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case "results": {
				in.beginArray();
				while (in.hasNext()) {
					addResult(Result.readResult(in));
				}
				in.endArray();
			}
			break;
			default: in.skipValue();
		}
	}

}
