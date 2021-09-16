package test.nested.data;

public class SearchResponse extends de.haumacher.msgbuf.data.AbstractDataObject implements de.haumacher.msgbuf.binary.BinaryDataObject {
	public static class Result extends de.haumacher.msgbuf.data.AbstractDataObject implements de.haumacher.msgbuf.binary.BinaryDataObject {

		/**
		 * Creates a {@link Result} instance.
		 */
		public static Result create() {
			return new Result();
		}

		/**
		 * Creates a {@link Result} instance.
		 *
		 * @see #create()
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
		public final Result addSnippet(String value) {
			_snippets.add(value);
			return this;
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
		public Object get(String field) {
			switch (field) {
				case "url": return getUrl();
				case "title": return getTitle();
				case "snippets": return getSnippets();
				default: return super.get(field);
			}
		}

		@Override
		public void set(String field, Object value) {
			switch (field) {
				case "url": setUrl((String) value); break;
				case "title": setTitle((String) value); break;
				case "snippets": setSnippets((java.util.List<String>) value); break;
			}
		}

		@Override
		protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
			super.writeFields(out);
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

		@Override
		protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
			switch (field) {
				case "url": setUrl(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
				case "title": setTitle(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
				case "snippets": {
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
			out.name(1);
			out.value(getUrl());
			out.name(2);
			out.value(getTitle());
			out.name(3);
			{
				java.util.List<String> values = getSnippets();
				out.beginArray(de.haumacher.msgbuf.binary.DataType.STRING, values.size());
				for (String x : values) {
					out.value(x);
				}
				out.endArray();
			}
		}

		/** Consumes the value for the field with the given ID and assigns its value. */
		protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
			switch (field) {
				case 1: setUrl(in.nextString()); break;
				case 2: setTitle(in.nextString()); break;
				case 3: {
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

	}

	/**
	 * Creates a {@link SearchResponse} instance.
	 */
	public static SearchResponse create() {
		return new SearchResponse();
	}

	/**
	 * Creates a {@link SearchResponse} instance.
	 *
	 * @see #create()
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
	public final SearchResponse addResult(Result value) {
		_results.add(value);
		return this;
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
	public Object get(String field) {
		switch (field) {
			case "results": return getResults();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case "results": setResults((java.util.List<Result>) value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name("results");
		out.beginArray();
		for (Result x : getResults()) {
			x.writeTo(out);
		}
		out.endArray();
	}

	@Override
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
		out.name(1);
		{
			java.util.List<Result> values = getResults();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.OBJECT, values.size());
			for (Result x : values) {
				x.writeTo(out);
			}
			out.endArray();
		}
	}

	/** Consumes the value for the field with the given ID and assigns its value. */
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case 1: {
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

}
