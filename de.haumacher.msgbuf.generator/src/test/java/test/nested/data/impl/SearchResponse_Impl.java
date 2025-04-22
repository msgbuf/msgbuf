package test.nested.data.impl;

/**
 * Implementation of {@link test.nested.data.SearchResponse}.
 */
public class SearchResponse_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.nested.data.SearchResponse {
	/**
	 * Implementation of {@link test.nested.data.SearchResponse.Result}.
	 */
	public static class Result_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.nested.data.SearchResponse.Result {

		private String _url = "";

		private String _title = "";

		private final java.util.List<String> _snippets = new de.haumacher.msgbuf.util.ReferenceList<String>() {
			@Override
			protected void beforeAdd(int index, String element) {
				_listener.beforeAdd(Result_Impl.this, SNIPPETS__PROP, index, element);
			}

			@Override
			protected void afterRemove(int index, String element) {
				_listener.afterRemove(Result_Impl.this, SNIPPETS__PROP, index, element);
			}
		};

		/**
		 * Creates a {@link Result_Impl} instance.
		 *
		 * @see test.nested.data.SearchResponse.Result#create()
		 */
		public Result_Impl() {
			super();
		}

		@Override
		public final String getUrl() {
			return _url;
		}

		@Override
		public test.nested.data.SearchResponse.Result setUrl(String value) {
			internalSetUrl(value);
			return this;
		}

		/** Internal setter for {@link #getUrl()} without chain call utility. */
		protected final void internalSetUrl(String value) {
			_listener.beforeSet(this, URL__PROP, value);
			_url = value;
		}

		@Override
		public final String getTitle() {
			return _title;
		}

		@Override
		public test.nested.data.SearchResponse.Result setTitle(String value) {
			internalSetTitle(value);
			return this;
		}

		/** Internal setter for {@link #getTitle()} without chain call utility. */
		protected final void internalSetTitle(String value) {
			_listener.beforeSet(this, TITLE__PROP, value);
			_title = value;
		}

		@Override
		public final java.util.List<String> getSnippets() {
			return _snippets;
		}

		@Override
		public test.nested.data.SearchResponse.Result setSnippets(java.util.List<? extends String> value) {
			internalSetSnippets(value);
			return this;
		}

		/** Internal setter for {@link #getSnippets()} without chain call utility. */
		protected final void internalSetSnippets(java.util.List<? extends String> value) {
			_snippets.clear();
			_snippets.addAll(value);
		}

		@Override
		public test.nested.data.SearchResponse.Result addSnippet(String value) {
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
		public test.nested.data.SearchResponse.Result registerListener(de.haumacher.msgbuf.observer.Listener l) {
			internalRegisterListener(l);
			return this;
		}

		protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
			_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
		}

		@Override
		public test.nested.data.SearchResponse.Result unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
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
				URL__PROP, 
				TITLE__PROP, 
				SNIPPETS__PROP));

		private static java.util.Set<String> TRANSIENT_PROPERTIES = java.util.Collections.unmodifiableSet(new java.util.HashSet<>(
				java.util.Arrays.asList(
					)));

		@Override
		public java.util.List<String> properties() {
			return PROPERTIES;
		}

		@Override
		public java.util.Set<String> transientProperties() {
			return TRANSIENT_PROPERTIES;
		}

		@Override
		public Object get(String field) {
			switch (field) {
				case URL__PROP: return getUrl();
				case TITLE__PROP: return getTitle();
				case SNIPPETS__PROP: return getSnippets();
				default: return test.nested.data.SearchResponse.Result.super.get(field);
			}
		}

		@Override
		public void set(String field, Object value) {
			switch (field) {
				case URL__PROP: internalSetUrl((String) value); break;
				case TITLE__PROP: internalSetTitle((String) value); break;
				case SNIPPETS__PROP: internalSetSnippets(de.haumacher.msgbuf.util.Conversions.asList(String.class, value)); break;
			}
		}

		@Override
		public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
			writeContent(out);
		}

		@Override
		protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
			super.writeFields(out);
			out.name(URL__PROP);
			out.value(getUrl());
			out.name(TITLE__PROP);
			out.value(getTitle());
			out.name(SNIPPETS__PROP);
			out.beginArray();
			for (String x : getSnippets()) {
				out.value(x);
			}
			out.endArray();
		}

		@Override
		protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
			switch (field) {
				case URL__PROP: setUrl(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
				case TITLE__PROP: setTitle(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
				case SNIPPETS__PROP: {
					java.util.List<String> newValue = new java.util.ArrayList<>();
					in.beginArray();
					while (in.hasNext()) {
						newValue.add(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in));
					}
					in.endArray();
					setSnippets(newValue);
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

		/** Helper for creating an object of type {@link test.nested.data.SearchResponse.Result} from a polymorphic composition. */
		public static test.nested.data.SearchResponse.Result readResult_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			test.nested.data.impl.SearchResponse_Impl.Result_Impl result = new Result_Impl();
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

		/** XML element name representing a {@link test.nested.data.SearchResponse.Result} type. */
		public static final String RESULT__XML_ELEMENT = "result";

		/** XML attribute or element name of a {@link #getUrl} property. */
		private static final String URL__XML_ATTR = "url";

		/** XML attribute or element name of a {@link #getTitle} property. */
		private static final String TITLE__XML_ATTR = "title";

		/** XML attribute or element name of a {@link #getSnippets} property. */
		private static final String SNIPPETS__XML_ATTR = "snippets";

		@Override
		public String getXmlTagName() {
			return RESULT__XML_ELEMENT;
		}

		@Override
		public final void writeContent(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
			writeAttributes(out);
			writeElements(out);
		}

		/** Serializes all fields that are written as XML attributes. */
		protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
			out.writeAttribute(URL__XML_ATTR, getUrl());
			out.writeAttribute(TITLE__XML_ATTR, getTitle());
			out.writeAttribute(SNIPPETS__XML_ATTR, getSnippets().stream().map(x -> x).collect(java.util.stream.Collectors.joining(", ")));
		}

		/** Serializes all fields that are written as XML elements. */
		protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
			// No element fields.
		}

		/** Creates a new {@link test.nested.data.SearchResponse.Result} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Result_Impl readResult_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			Result_Impl result = new Result_Impl();
			result.readContentXml(in);
			return result;
		}

		/** Reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		protected final void readContentXml(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			for (int n = 0, cnt = in.getAttributeCount(); n < cnt; n++) {
				String name = in.getAttributeLocalName(n);
				String value = in.getAttributeValue(n);

				readFieldXmlAttribute(name, value);
			}
			while (true) {
				int event = in.nextTag();
				if (event == javax.xml.stream.XMLStreamConstants.END_ELEMENT) {
					break;
				}
				assert event == javax.xml.stream.XMLStreamConstants.START_ELEMENT;

				String localName = in.getLocalName();
				readFieldXmlElement(in, localName);
			}
		}

		/** Parses the given attribute value and assigns it to the field with the given name. */
		protected void readFieldXmlAttribute(String name, String value) {
			switch (name) {
				case URL__XML_ATTR: {
					setUrl(value);
					break;
				}
				case TITLE__XML_ATTR: {
					setTitle(value);
					break;
				}
				case SNIPPETS__XML_ATTR: {
					setSnippets(java.util.Arrays.stream(value.split("\\s*,\\s*")).map(x -> x).collect(java.util.stream.Collectors.toList()));
					break;
				}
				default: {
					// Skip unknown attribute.
				}
			}
		}

		/** Reads the element under the cursor and assigns its contents to the field with the given name. */
		protected void readFieldXmlElement(javax.xml.stream.XMLStreamReader in, String localName) throws javax.xml.stream.XMLStreamException {
			switch (localName) {
				case URL__XML_ATTR: {
					setUrl(in.getElementText());
					break;
				}
				case TITLE__XML_ATTR: {
					setTitle(in.getElementText());
					break;
				}
				case SNIPPETS__XML_ATTR: {
					setSnippets(java.util.Arrays.stream(in.getElementText().split("\\s*,\\s*")).map(x -> x).collect(java.util.stream.Collectors.toList()));
					break;
				}
				default: {
					internalSkipUntilMatchingEndElement(in);
				}
			}
		}

		protected static final void internalSkipUntilMatchingEndElement(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			int level = 0;
			while (true) {
				switch (in.next()) {
					case javax.xml.stream.XMLStreamConstants.START_ELEMENT: level++; break;
					case javax.xml.stream.XMLStreamConstants.END_ELEMENT: if (level == 0) { return; } else { level--; break; }
				}
			}
		}

	}

	private final java.util.List<test.nested.data.SearchResponse.Result> _results = new de.haumacher.msgbuf.util.ReferenceList<test.nested.data.SearchResponse.Result>() {
		@Override
		protected void beforeAdd(int index, test.nested.data.SearchResponse.Result element) {
			_listener.beforeAdd(SearchResponse_Impl.this, RESULTS__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, test.nested.data.SearchResponse.Result element) {
			_listener.afterRemove(SearchResponse_Impl.this, RESULTS__PROP, index, element);
		}
	};

	/**
	 * Creates a {@link SearchResponse_Impl} instance.
	 *
	 * @see test.nested.data.SearchResponse#create()
	 */
	public SearchResponse_Impl() {
		super();
	}

	@Override
	public final java.util.List<test.nested.data.SearchResponse.Result> getResults() {
		return _results;
	}

	@Override
	public test.nested.data.SearchResponse setResults(java.util.List<? extends test.nested.data.SearchResponse.Result> value) {
		internalSetResults(value);
		return this;
	}

	/** Internal setter for {@link #getResults()} without chain call utility. */
	protected final void internalSetResults(java.util.List<? extends test.nested.data.SearchResponse.Result> value) {
		if (value == null) throw new IllegalArgumentException("Property 'results' cannot be null.");
		_results.clear();
		_results.addAll(value);
	}

	@Override
	public test.nested.data.SearchResponse addResult(test.nested.data.SearchResponse.Result value) {
		internalAddResult(value);
		return this;
	}

	/** Implementation of {@link #addResult(test.nested.data.SearchResponse.Result)} without chain call utility. */
	protected final void internalAddResult(test.nested.data.SearchResponse.Result value) {
		_results.add(value);
	}

	@Override
	public final void removeResult(test.nested.data.SearchResponse.Result value) {
		_results.remove(value);
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.nested.data.SearchResponse registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.nested.data.SearchResponse unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
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
			RESULTS__PROP));

	private static java.util.Set<String> TRANSIENT_PROPERTIES = java.util.Collections.unmodifiableSet(new java.util.HashSet<>(
			java.util.Arrays.asList(
				)));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public java.util.Set<String> transientProperties() {
		return TRANSIENT_PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case RESULTS__PROP: return getResults();
			default: return test.nested.data.SearchResponse.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case RESULTS__PROP: internalSetResults(de.haumacher.msgbuf.util.Conversions.asList(test.nested.data.SearchResponse.Result.class, value)); break;
		}
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(RESULTS__PROP);
		out.beginArray();
		for (test.nested.data.SearchResponse.Result x : getResults()) {
			x.writeTo(out);
		}
		out.endArray();
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case RESULTS__PROP: {
				java.util.List<test.nested.data.SearchResponse.Result> newValue = new java.util.ArrayList<>();
				in.beginArray();
				while (in.hasNext()) {
					newValue.add(test.nested.data.SearchResponse.Result.readResult(in));
				}
				in.endArray();
				setResults(newValue);
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
			java.util.List<test.nested.data.SearchResponse.Result> values = getResults();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.OBJECT, values.size());
			for (test.nested.data.SearchResponse.Result x : values) {
				x.writeTo(out);
			}
			out.endArray();
		}
	}

	/** Helper for creating an object of type {@link test.nested.data.SearchResponse} from a polymorphic composition. */
	public static test.nested.data.SearchResponse readSearchResponse_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.nested.data.impl.SearchResponse_Impl result = new SearchResponse_Impl();
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

	/** XML element name representing a {@link test.nested.data.SearchResponse} type. */
	public static final String SEARCH_RESPONSE__XML_ELEMENT = "search-response";

	/** XML attribute or element name of a {@link #getResults} property. */
	private static final String RESULTS__XML_ATTR = "results";

	@Override
	public String getXmlTagName() {
		return SEARCH_RESPONSE__XML_ELEMENT;
	}

	@Override
	public final void writeContent(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		writeAttributes(out);
		writeElements(out);
	}

	/** Serializes all fields that are written as XML attributes. */
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
	}

	/** Serializes all fields that are written as XML elements. */
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		out.writeStartElement(RESULTS__XML_ATTR);
		for (test.nested.data.SearchResponse.Result element : getResults()) {
			element.writeTo(out);
		}
		out.writeEndElement();
	}

	/** Creates a new {@link test.nested.data.SearchResponse} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static SearchResponse_Impl readSearchResponse_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		SearchResponse_Impl result = new SearchResponse_Impl();
		result.readContentXml(in);
		return result;
	}

	/** Reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	protected final void readContentXml(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		for (int n = 0, cnt = in.getAttributeCount(); n < cnt; n++) {
			String name = in.getAttributeLocalName(n);
			String value = in.getAttributeValue(n);

			readFieldXmlAttribute(name, value);
		}
		while (true) {
			int event = in.nextTag();
			if (event == javax.xml.stream.XMLStreamConstants.END_ELEMENT) {
				break;
			}
			assert event == javax.xml.stream.XMLStreamConstants.START_ELEMENT;

			String localName = in.getLocalName();
			readFieldXmlElement(in, localName);
		}
	}

	/** Parses the given attribute value and assigns it to the field with the given name. */
	protected void readFieldXmlAttribute(String name, String value) {
		switch (name) {
			default: {
				// Skip unknown attribute.
			}
		}
	}

	/** Reads the element under the cursor and assigns its contents to the field with the given name. */
	protected void readFieldXmlElement(javax.xml.stream.XMLStreamReader in, String localName) throws javax.xml.stream.XMLStreamException {
		switch (localName) {
			case RESULTS__XML_ATTR: {
				internalReadResultsListXml(in);
				break;
			}
			default: {
				internalSkipUntilMatchingEndElement(in);
			}
		}
	}

	protected static final void internalSkipUntilMatchingEndElement(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		int level = 0;
		while (true) {
			switch (in.next()) {
				case javax.xml.stream.XMLStreamConstants.START_ELEMENT: level++; break;
				case javax.xml.stream.XMLStreamConstants.END_ELEMENT: if (level == 0) { return; } else { level--; break; }
			}
		}
	}

	private void internalReadResultsListXml(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		while (true) {
			int event = in.nextTag();
			if (event == javax.xml.stream.XMLStreamConstants.END_ELEMENT) {
				break;
			}

			addResult(test.nested.data.impl.SearchResponse_Impl.Result_Impl.readResult_XmlContent(in));
		}
	}

}
