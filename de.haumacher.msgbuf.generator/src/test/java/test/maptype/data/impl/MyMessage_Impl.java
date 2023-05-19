package test.maptype.data.impl;

/**
 * Implementation of {@link test.maptype.data.MyMessage}.
 */
public class MyMessage_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.maptype.data.MyMessage {

	private final java.util.Map<String, test.maptype.data.Project> _projects = new de.haumacher.msgbuf.util.ReferenceMap<>() {
		@Override
		protected void beforeAdd(String index, test.maptype.data.Project element) {
			_listener.beforeAdd(MyMessage_Impl.this, PROJECTS__PROP, index, element);
		}

		@Override
		protected void afterRemove(String index, test.maptype.data.Project element) {
			_listener.afterRemove(MyMessage_Impl.this, PROJECTS__PROP, index, element);
		}
	};

	private final java.util.Map<Integer, String> _rating = new de.haumacher.msgbuf.util.ReferenceMap<>() {
		@Override
		protected void beforeAdd(Integer index, String element) {
			_listener.beforeAdd(MyMessage_Impl.this, RATING__PROP, index, element);
		}

		@Override
		protected void afterRemove(Integer index, String element) {
			_listener.afterRemove(MyMessage_Impl.this, RATING__PROP, index, element);
		}
	};

	/**
	 * Creates a {@link MyMessage_Impl} instance.
	 *
	 * @see test.maptype.data.MyMessage#create()
	 */
	public MyMessage_Impl() {
		super();
	}

	@Override
	public final java.util.Map<String, test.maptype.data.Project> getProjects() {
		return _projects;
	}

	@Override
	public test.maptype.data.MyMessage setProjects(java.util.Map<String, test.maptype.data.Project> value) {
		internalSetProjects(value);
		return this;
	}

	/** Internal setter for {@link #getProjects()} without chain call utility. */
	protected final void internalSetProjects(java.util.Map<String, test.maptype.data.Project> value) {
		if (value == null) throw new IllegalArgumentException("Property 'projects' cannot be null.");
		_projects.clear();
		_projects.putAll(value);
	}

	@Override
	public test.maptype.data.MyMessage putProject(String key, test.maptype.data.Project value) {
		internalPutProject(key, value);
		return this;
	}

	/** Implementation of {@link #putProject(String, test.maptype.data.Project)} without chain call utility. */
	protected final void  internalPutProject(String key, test.maptype.data.Project value) {
		if (_projects.containsKey(key)) {
			throw new IllegalArgumentException("Property 'projects' already contains a value for key '" + key + "'.");
		}
		_projects.put(key, value);
	}

	@Override
	public final void removeProject(String key) {
		_projects.remove(key);
	}

	@Override
	public final java.util.Map<Integer, String> getRating() {
		return _rating;
	}

	@Override
	public test.maptype.data.MyMessage setRating(java.util.Map<Integer, String> value) {
		internalSetRating(value);
		return this;
	}

	/** Internal setter for {@link #getRating()} without chain call utility. */
	protected final void internalSetRating(java.util.Map<Integer, String> value) {
		if (value == null) throw new IllegalArgumentException("Property 'rating' cannot be null.");
		_rating.clear();
		_rating.putAll(value);
	}

	@Override
	public test.maptype.data.MyMessage putRating(int key, String value) {
		internalPutRating(key, value);
		return this;
	}

	/** Implementation of {@link #putRating(int, String)} without chain call utility. */
	protected final void  internalPutRating(int key, String value) {
		if (_rating.containsKey(key)) {
			throw new IllegalArgumentException("Property 'rating' already contains a value for key '" + key + "'.");
		}
		_rating.put(key, value);
	}

	@Override
	public final void removeRating(int key) {
		_rating.remove(key);
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.maptype.data.MyMessage registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.maptype.data.MyMessage unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		internalUnregisterListener(l);
		return this;
	}

	protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
	}

	@Override
	public String jsonType() {
		return MY_MESSAGE__TYPE;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			PROJECTS__PROP, 
			RATING__PROP));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case PROJECTS__PROP: return getProjects();
			case RATING__PROP: return getRating();
			default: return test.maptype.data.MyMessage.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case PROJECTS__PROP: internalSetProjects((java.util.Map<String, test.maptype.data.Project>) value); break;
			case RATING__PROP: internalSetRating((java.util.Map<Integer, String>) value); break;
		}
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(PROJECTS__PROP);
		out.beginObject();
		for (java.util.Map.Entry<String,test.maptype.data.Project> entry : getProjects().entrySet()) {
			out.name(entry.getKey());
			entry.getValue().writeTo(out);
		}
		out.endObject();
		out.name(RATING__PROP);
		out.beginArray();
		for (java.util.Map.Entry<Integer,String> entry : getRating().entrySet()) {
			out.beginObject();
			out.name("key");
			out.value(entry.getKey());
			out.name("value");
			out.value(entry.getValue());
			out.endObject();
		}
		out.endArray();
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case PROJECTS__PROP: {
				in.beginObject();
				while (in.hasNext()) {
					putProject(in.nextName(), test.maptype.data.Project.readProject(in));
				}
				in.endObject();
				break;
			}
			case RATING__PROP: {
				in.beginArray();
				while (in.hasNext()) {
					in.beginObject();
					int key = 0;
					String value = "";
					while (in.hasNext()) {
						switch (in.nextName()) {
							case "key": key = in.nextInt(); break;
							case "value": value = de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in); break;
							default: in.skipValue(); break;
						}
					}
					putRating(key, value);
					in.endObject();
				}
				in.endArray();
				break;
			}
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
		out.name(PROJECTS__ID);
		out.name(RATING__ID);
	}

	/** Helper for creating an object of type {@link test.maptype.data.MyMessage} from a polymorphic composition. */
	public static test.maptype.data.MyMessage readMyMessage_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.maptype.data.impl.MyMessage_Impl result = new MyMessage_Impl();
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
			case PROJECTS__ID: {
				in.beginArray();
				while (in.hasNext()) {
					in.beginObject();
					String key = "";
					test.maptype.data.Project value = null;
					while (in.hasNext()) {
						switch (in.nextName()) {
							case 1: key = in.nextString(); break;
							case 2: value = test.maptype.data.Project.readProject(in); break;
							default: in.skipValue(); break;
						}
					}
					putProject(key, value);
					in.endObject();
				}
				in.endArray();
				break;
			}
			case RATING__ID: {
				in.beginArray();
				while (in.hasNext()) {
					in.beginObject();
					int key = 0;
					String value = "";
					while (in.hasNext()) {
						switch (in.nextName()) {
							case 1: key = in.nextInt(); break;
							case 2: value = in.nextString(); break;
							default: in.skipValue(); break;
						}
					}
					putRating(key, value);
					in.endObject();
				}
				in.endArray();
				break;
			}
			default: in.skipValue(); 
		}
	}

	/** XML element name representing a {@link test.maptype.data.MyMessage} type. */
	public static final String MY_MESSAGE__XML_ELEMENT = "my-message";

	/** XML attribute or element name of a {@link #getProjects} property. */
	private static final String PROJECTS__XML_ATTR = "projects";

	/** XML attribute or element name of a {@link #getRating} property. */
	private static final String RATING__XML_ATTR = "rating";

	@Override
	public String getXmlTagName() {
		return MY_MESSAGE__XML_ELEMENT;
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
		// No element fields.
	}

	/** Creates a new {@link test.maptype.data.MyMessage} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static MyMessage_Impl readMyMessage_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		MyMessage_Impl result = new MyMessage_Impl();
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
