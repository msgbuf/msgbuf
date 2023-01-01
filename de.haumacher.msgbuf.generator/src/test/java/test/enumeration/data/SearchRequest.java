package test.enumeration.data;

public interface SearchRequest extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	public enum Corpus implements de.haumacher.msgbuf.data.ProtocolEnum {

		UNIVERSAL("UNIVERSAL"),

		WEB("WEB"),

		IMAGES("IMAGES"),

		LOCAL("LOCAL"),

		NEWS("NEWS"),

		PRODUCTS("PRODUCTS"),

		VIDEO("VIDEO"),

		;

		private final String _protocolName;

		private Corpus(String protocolName) {
			_protocolName = protocolName;
		}

		/**
		 * The protocol name of a {@link Corpus} constant.
		 *
		 * @see #valueOfProtocol(String)
		 */
		@Override
		public String protocolName() {
			return _protocolName;
		}

		/** Looks up a {@link Corpus} constant by it's protocol name. */
		public static Corpus valueOfProtocol(String protocolName) {
			if (protocolName == null) { return null; }
			switch (protocolName) {
				case "UNIVERSAL": return UNIVERSAL;
				case "WEB": return WEB;
				case "IMAGES": return IMAGES;
				case "LOCAL": return LOCAL;
				case "NEWS": return NEWS;
				case "PRODUCTS": return PRODUCTS;
				case "VIDEO": return VIDEO;
			}
			return UNIVERSAL;
		}

		/** Writes this instance to the given output. */
		public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
			out.value(protocolName());
		}

		/** Reads a new instance from the given reader. */
		public static Corpus readCorpus(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			return valueOfProtocol(in.nextString());
		}

		/** Writes this instance to the given binary output. */
		public final void writeTo(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
			switch (this) {
				case UNIVERSAL: out.value(7); break;
				case WEB: out.value(1); break;
				case IMAGES: out.value(2); break;
				case LOCAL: out.value(3); break;
				case NEWS: out.value(4); break;
				case PRODUCTS: out.value(5); break;
				case VIDEO: out.value(6); break;
				default: out.value(0);
			}
		}

		/** Reads a new instance from the given binary reader. */
		public static Corpus readCorpus(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			switch (in.nextInt()) {
				case 7: return UNIVERSAL;
				case 1: return WEB;
				case 2: return IMAGES;
				case 3: return LOCAL;
				case 4: return NEWS;
				case 5: return PRODUCTS;
				case 6: return VIDEO;
				default: return UNIVERSAL;
			}
		}
	}

	/**
	 * Creates a {@link test.enumeration.data.SearchRequest} instance.
	 */
	static test.enumeration.data.SearchRequest create() {
		return new test.enumeration.data.impl.SearchRequest_Impl();
	}

	/** Identifier for the {@link test.enumeration.data.SearchRequest} type in JSON format. */
	static final String SEARCH_REQUEST__TYPE = "SearchRequest";

	/** @see #getQuery() */
	static final String QUERY__PROP = "query";

	/** @see #getPageNumber() */
	static final String PAGE_NUMBER__PROP = "page_number";

	/** @see #getResultPerPage() */
	static final String RESULT_PER_PAGE__PROP = "result_per_page";

	/** @see #getCorpus() */
	static final String CORPUS__PROP = "corpus";

	/** Identifier for the property {@link #getQuery()} in binary format. */
	static final int QUERY__ID = 1;

	/** Identifier for the property {@link #getPageNumber()} in binary format. */
	static final int PAGE_NUMBER__ID = 2;

	/** Identifier for the property {@link #getResultPerPage()} in binary format. */
	static final int RESULT_PER_PAGE__ID = 3;

	/** Identifier for the property {@link #getCorpus()} in binary format. */
	static final int CORPUS__ID = 4;

	String getQuery();

	/**
	 * @see #getQuery()
	 */
	test.enumeration.data.SearchRequest setQuery(String value);

	int getPageNumber();

	/**
	 * @see #getPageNumber()
	 */
	test.enumeration.data.SearchRequest setPageNumber(int value);

	int getResultPerPage();

	/**
	 * @see #getResultPerPage()
	 */
	test.enumeration.data.SearchRequest setResultPerPage(int value);

	test.enumeration.data.SearchRequest.Corpus getCorpus();

	/**
	 * @see #getCorpus()
	 */
	test.enumeration.data.SearchRequest setCorpus(test.enumeration.data.SearchRequest.Corpus value);

	@Override
	public test.enumeration.data.SearchRequest registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.enumeration.data.SearchRequest unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.enumeration.data.SearchRequest readSearchRequest(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.enumeration.data.impl.SearchRequest_Impl result = new test.enumeration.data.impl.SearchRequest_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.enumeration.data.SearchRequest readSearchRequest(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.enumeration.data.SearchRequest result = test.enumeration.data.impl.SearchRequest_Impl.readSearchRequest_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link SearchRequest} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static SearchRequest readSearchRequest(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.enumeration.data.impl.SearchRequest_Impl.readSearchRequest_XmlContent(in);
	}

}
