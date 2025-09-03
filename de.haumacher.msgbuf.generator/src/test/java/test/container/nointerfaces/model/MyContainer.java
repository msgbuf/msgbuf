package test.container.nointerfaces.model;

public class MyContainer extends de.haumacher.msgbuf.data.AbstractDataObject implements de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/**
	 * Creates a {@link test.container.nointerfaces.model.MyContainer} instance.
	 */
	public static test.container.nointerfaces.model.MyContainer create() {
		return new test.container.nointerfaces.model.MyContainer();
	}

	/** Identifier for the {@link test.container.nointerfaces.model.MyContainer} type in JSON format. */
	public static final String MY_CONTAINER__TYPE = "MyContainer";

	/** @see #getName() */
	public static final String NAME__PROP = "name";

	/** @see #getContent1() */
	public static final String CONTENT_1__PROP = "content1";

	/** @see #getContent2() */
	public static final String CONTENT_2__PROP = "content2";

	/** @see #getContentList() */
	public static final String CONTENT_LIST__PROP = "contentList";

	/** @see #getContentMap() */
	public static final String CONTENT_MAP__PROP = "contentMap";

	/** @see #getOther() */
	public static final String OTHER__PROP = "other";

	/** @see #getOthers() */
	public static final String OTHERS__PROP = "others";

	/** Identifier for the property {@link #getName()} in binary format. */
	static final int NAME__ID = 1;

	/** Identifier for the property {@link #getContent1()} in binary format. */
	static final int CONTENT_1__ID = 2;

	/** Identifier for the property {@link #getContent2()} in binary format. */
	static final int CONTENT_2__ID = 3;

	/** Identifier for the property {@link #getContentList()} in binary format. */
	static final int CONTENT_LIST__ID = 4;

	/** Identifier for the property {@link #getContentMap()} in binary format. */
	static final int CONTENT_MAP__ID = 5;

	/** Identifier for the property {@link #getOther()} in binary format. */
	static final int OTHER__ID = 6;

	/** Identifier for the property {@link #getOthers()} in binary format. */
	static final int OTHERS__ID = 7;

	private String _name = "";

	private test.container.nointerfaces.model.MyContent _content1 = null;

	private test.container.nointerfaces.model.MyContent _content2 = null;

	private final java.util.List<test.container.nointerfaces.model.MyContent> _contentList = new de.haumacher.msgbuf.util.ReferenceList<test.container.nointerfaces.model.MyContent>() {
		@Override
		protected void beforeAdd(int index, test.container.nointerfaces.model.MyContent element) {
			test.container.nointerfaces.model.MyContent added = element;
			test.container.nointerfaces.model.MyContainer oldContainer = added.getContainer();
			if (oldContainer != null && oldContainer != MyContainer.this) {
				throw new IllegalStateException("Object may not be part of two different containers.");
			}
			_listener.beforeAdd(MyContainer.this, CONTENT_LIST__PROP, index, element);
			added.internalSetContainer(MyContainer.this);
		}

		@Override
		protected void afterRemove(int index, test.container.nointerfaces.model.MyContent element) {
			test.container.nointerfaces.model.MyContent removed = element;
			removed.internalSetContainer(null);
			_listener.afterRemove(MyContainer.this, CONTENT_LIST__PROP, index, element);
		}

		@Override
		protected void afterChanged() {
			_listener.afterChanged(MyContainer.this, CONTENT_LIST__PROP);
		}
	};

	private final java.util.Map<String, test.container.nointerfaces.model.MyContent> _contentMap = new de.haumacher.msgbuf.util.ReferenceMap<String, test.container.nointerfaces.model.MyContent>() {
		@Override
		protected void beforeAdd(String index, test.container.nointerfaces.model.MyContent element) {
			test.container.nointerfaces.model.MyContent added = element;
			test.container.nointerfaces.model.MyContainer oldContainer = added.getContainer();
			if (oldContainer != null && oldContainer != MyContainer.this) {
				throw new IllegalStateException("Object may not be part of two different containers.");
			}
			_listener.beforeAdd(MyContainer.this, CONTENT_MAP__PROP, index, element);
			added.internalSetContainer(MyContainer.this);
		}

		@Override
		protected void afterRemove(String index, test.container.nointerfaces.model.MyContent element) {
			test.container.nointerfaces.model.MyContent removed = element;
			removed.internalSetContainer(null);
			_listener.afterRemove(MyContainer.this, CONTENT_MAP__PROP, index, element);
		}

		@Override
		protected void afterChanged() {
			_listener.afterChanged(MyContainer.this, CONTENT_MAP__PROP);
		}
	};

	private test.container.nointerfaces.model.MyContent _other = null;

	private final java.util.List<test.container.nointerfaces.model.MyContent> _others = new de.haumacher.msgbuf.util.ReferenceList<test.container.nointerfaces.model.MyContent>() {
		@Override
		protected void beforeAdd(int index, test.container.nointerfaces.model.MyContent element) {
			_listener.beforeAdd(MyContainer.this, OTHERS__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, test.container.nointerfaces.model.MyContent element) {
			_listener.afterRemove(MyContainer.this, OTHERS__PROP, index, element);
		}

		@Override
		protected void afterChanged() {
			_listener.afterChanged(MyContainer.this, OTHERS__PROP);
		}
	};

	/**
	 * Creates a {@link MyContainer} instance.
	 *
	 * @see test.container.nointerfaces.model.MyContainer#create()
	 */
	protected MyContainer() {
		super();
	}

	public final String getName() {
		return _name;
	}

	/**
	 * @see #getName()
	 */
	public test.container.nointerfaces.model.MyContainer setName(String value) {
		internalSetName(value);
		return this;
	}

	/** Internal setter for {@link #getName()} without chain call utility. */
	protected final void internalSetName(String value) {
		_listener.beforeSet(this, NAME__PROP, value);
		_name = value;
		_listener.afterChanged(this, NAME__PROP);
	}

	public final test.container.nointerfaces.model.MyContent getContent1() {
		return _content1;
	}

	/**
	 * @see #getContent1()
	 */
	public test.container.nointerfaces.model.MyContainer setContent1(test.container.nointerfaces.model.MyContent value) {
		internalSetContent1(value);
		return this;
	}

	/** Internal setter for {@link #getContent1()} without chain call utility. */
	protected final void internalSetContent1(test.container.nointerfaces.model.MyContent value) {
		test.container.nointerfaces.model.MyContent before = _content1;
		test.container.nointerfaces.model.MyContent after = value;
		if (after != null) {
			test.container.nointerfaces.model.MyContainer oldContainer = after.getContainer();
			if (oldContainer != null && oldContainer != this) {
				throw new IllegalStateException("Object may not be part of two different containers.");
			}
		}
		_listener.beforeSet(this, CONTENT_1__PROP, value);
		if (before != null) {
			before.internalSetContainer(null);
		}
		_content1 = value;
		if (after != null) {
			after.internalSetContainer(this);
		}
		_listener.afterChanged(this, CONTENT_1__PROP);
	}

	/**
	 * Checks, whether {@link #getContent1()} has a value.
	 */
	public final boolean hasContent1() {
		return _content1 != null;
	}

	public final test.container.nointerfaces.model.MyContent getContent2() {
		return _content2;
	}

	/**
	 * @see #getContent2()
	 */
	public test.container.nointerfaces.model.MyContainer setContent2(test.container.nointerfaces.model.MyContent value) {
		internalSetContent2(value);
		return this;
	}

	/** Internal setter for {@link #getContent2()} without chain call utility. */
	protected final void internalSetContent2(test.container.nointerfaces.model.MyContent value) {
		test.container.nointerfaces.model.MyContent before = _content2;
		test.container.nointerfaces.model.MyContent after = value;
		if (after != null) {
			test.container.nointerfaces.model.MyContainer oldContainer = after.getContainer();
			if (oldContainer != null && oldContainer != this) {
				throw new IllegalStateException("Object may not be part of two different containers.");
			}
		}
		_listener.beforeSet(this, CONTENT_2__PROP, value);
		if (before != null) {
			before.internalSetContainer(null);
		}
		_content2 = value;
		if (after != null) {
			after.internalSetContainer(this);
		}
		_listener.afterChanged(this, CONTENT_2__PROP);
	}

	/**
	 * Checks, whether {@link #getContent2()} has a value.
	 */
	public final boolean hasContent2() {
		return _content2 != null;
	}

	public final java.util.List<test.container.nointerfaces.model.MyContent> getContentList() {
		return _contentList;
	}

	/**
	 * @see #getContentList()
	 */
	public test.container.nointerfaces.model.MyContainer setContentList(java.util.List<? extends test.container.nointerfaces.model.MyContent> value) {
		internalSetContentList(value);
		return this;
	}

	/** Internal setter for {@link #getContentList()} without chain call utility. */
	protected final void internalSetContentList(java.util.List<? extends test.container.nointerfaces.model.MyContent> value) {
		if (value == null) throw new IllegalArgumentException("Property 'contentList' cannot be null.");
		_contentList.clear();
		_contentList.addAll(value);
	}

	/**
	 * Adds a value to the {@link #getContentList()} list.
	 */
	public test.container.nointerfaces.model.MyContainer addContentList(test.container.nointerfaces.model.MyContent value) {
		internalAddContentList(value);
		return this;
	}

	/** Implementation of {@link #addContentList(test.container.nointerfaces.model.MyContent)} without chain call utility. */
	protected final void internalAddContentList(test.container.nointerfaces.model.MyContent value) {
		_contentList.add(value);
	}

	/**
	 * Removes a value from the {@link #getContentList()} list.
	 */
	public final void removeContentList(test.container.nointerfaces.model.MyContent value) {
		_contentList.remove(value);
	}

	public final java.util.Map<String, test.container.nointerfaces.model.MyContent> getContentMap() {
		return _contentMap;
	}

	/**
	 * @see #getContentMap()
	 */
	public test.container.nointerfaces.model.MyContainer setContentMap(java.util.Map<String, test.container.nointerfaces.model.MyContent> value) {
		internalSetContentMap(value);
		return this;
	}

	/** Internal setter for {@link #getContentMap()} without chain call utility. */
	protected final void internalSetContentMap(java.util.Map<String, test.container.nointerfaces.model.MyContent> value) {
		if (value == null) throw new IllegalArgumentException("Property 'contentMap' cannot be null.");
		_contentMap.clear();
		_contentMap.putAll(value);
	}

	/**
	 * Adds a key value pair to the {@link #getContentMap()} map.
	 */
	public test.container.nointerfaces.model.MyContainer putContentMap(String key, test.container.nointerfaces.model.MyContent value) {
		internalPutContentMap(key, value);
		return this;
	}

	/** Implementation of {@link #putContentMap(String, test.container.nointerfaces.model.MyContent)} without chain call utility. */
	protected final void  internalPutContentMap(String key, test.container.nointerfaces.model.MyContent value) {
		if (_contentMap.containsKey(key)) {
			throw new IllegalArgumentException("Property 'contentMap' already contains a value for key '" + key + "'.");
		}
		_contentMap.put(key, value);
	}

	/**
	 * Removes a key from the {@link #getContentMap()} map.
	 */
	public final void removeContentMap(String key) {
		_contentMap.remove(key);
	}

	public final test.container.nointerfaces.model.MyContent getOther() {
		return _other;
	}

	/**
	 * @see #getOther()
	 */
	public test.container.nointerfaces.model.MyContainer setOther(test.container.nointerfaces.model.MyContent value) {
		internalSetOther(value);
		return this;
	}

	/** Internal setter for {@link #getOther()} without chain call utility. */
	protected final void internalSetOther(test.container.nointerfaces.model.MyContent value) {
		_listener.beforeSet(this, OTHER__PROP, value);
		_other = value;
		_listener.afterChanged(this, OTHER__PROP);
	}

	/**
	 * Checks, whether {@link #getOther()} has a value.
	 */
	public final boolean hasOther() {
		return _other != null;
	}

	public final java.util.List<test.container.nointerfaces.model.MyContent> getOthers() {
		return _others;
	}

	/**
	 * @see #getOthers()
	 */
	public test.container.nointerfaces.model.MyContainer setOthers(java.util.List<? extends test.container.nointerfaces.model.MyContent> value) {
		internalSetOthers(value);
		return this;
	}

	/** Internal setter for {@link #getOthers()} without chain call utility. */
	protected final void internalSetOthers(java.util.List<? extends test.container.nointerfaces.model.MyContent> value) {
		if (value == null) throw new IllegalArgumentException("Property 'others' cannot be null.");
		_others.clear();
		_others.addAll(value);
	}

	/**
	 * Adds a value to the {@link #getOthers()} list.
	 */
	public test.container.nointerfaces.model.MyContainer addOthers(test.container.nointerfaces.model.MyContent value) {
		internalAddOthers(value);
		return this;
	}

	/** Implementation of {@link #addOthers(test.container.nointerfaces.model.MyContent)} without chain call utility. */
	protected final void internalAddOthers(test.container.nointerfaces.model.MyContent value) {
		_others.add(value);
	}

	/**
	 * Removes a value from the {@link #getOthers()} list.
	 */
	public final void removeOthers(test.container.nointerfaces.model.MyContent value) {
		_others.remove(value);
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.container.nointerfaces.model.MyContainer registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.container.nointerfaces.model.MyContainer unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		internalUnregisterListener(l);
		return this;
	}

	protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
	}

	@Override
	public String jsonType() {
		return MY_CONTAINER__TYPE;
	}

	static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			NAME__PROP, 
			CONTENT_1__PROP, 
			CONTENT_2__PROP, 
			CONTENT_LIST__PROP, 
			CONTENT_MAP__PROP, 
			OTHER__PROP, 
			OTHERS__PROP);
		PROPERTIES = java.util.Collections.unmodifiableList(local);
	}

	static final java.util.Set<String> TRANSIENT_PROPERTIES;
	static {
		java.util.HashSet<String> tmp = new java.util.HashSet<>();
		tmp.addAll(java.util.Arrays.asList(
				));
		TRANSIENT_PROPERTIES = java.util.Collections.unmodifiableSet(tmp);
	}

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
			case NAME__PROP: return getName();
			case CONTENT_1__PROP: return getContent1();
			case CONTENT_2__PROP: return getContent2();
			case CONTENT_LIST__PROP: return getContentList();
			case CONTENT_MAP__PROP: return getContentMap();
			case OTHER__PROP: return getOther();
			case OTHERS__PROP: return getOthers();
			default: return null;
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case NAME__PROP: internalSetName((String) value); break;
			case CONTENT_1__PROP: internalSetContent1((test.container.nointerfaces.model.MyContent) value); break;
			case CONTENT_2__PROP: internalSetContent2((test.container.nointerfaces.model.MyContent) value); break;
			case CONTENT_LIST__PROP: internalSetContentList(de.haumacher.msgbuf.util.Conversions.asList(test.container.nointerfaces.model.MyContent.class, value)); break;
			case CONTENT_MAP__PROP: internalSetContentMap((java.util.Map<String, test.container.nointerfaces.model.MyContent>) value); break;
			case OTHER__PROP: internalSetOther((test.container.nointerfaces.model.MyContent) value); break;
			case OTHERS__PROP: internalSetOthers(de.haumacher.msgbuf.util.Conversions.asList(test.container.nointerfaces.model.MyContent.class, value)); break;
		}
	}

	/** Reads a new instance from the given reader. */
	public static test.container.nointerfaces.model.MyContainer readMyContainer(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.container.nointerfaces.model.MyContainer result = new test.container.nointerfaces.model.MyContainer();
		result.readContent(in);
		return result;
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(NAME__PROP);
		out.value(getName());
		if (hasContent1()) {
			out.name(CONTENT_1__PROP);
			getContent1().writeTo(out);
		}
		if (hasContent2()) {
			out.name(CONTENT_2__PROP);
			getContent2().writeTo(out);
		}
		out.name(CONTENT_LIST__PROP);
		out.beginArray();
		for (test.container.nointerfaces.model.MyContent x : getContentList()) {
			x.writeTo(out);
		}
		out.endArray();
		out.name(CONTENT_MAP__PROP);
		out.beginObject();
		for (java.util.Map.Entry<String,test.container.nointerfaces.model.MyContent> entry : getContentMap().entrySet()) {
			out.name(entry.getKey());
			entry.getValue().writeTo(out);
		}
		out.endObject();
		if (hasOther()) {
			out.name(OTHER__PROP);
			getOther().writeTo(out);
		}
		out.name(OTHERS__PROP);
		out.beginArray();
		for (test.container.nointerfaces.model.MyContent x : getOthers()) {
			x.writeTo(out);
		}
		out.endArray();
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case NAME__PROP: setName(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			case CONTENT_1__PROP: setContent1(test.container.nointerfaces.model.MyContent.readMyContent(in)); break;
			case CONTENT_2__PROP: setContent2(test.container.nointerfaces.model.MyContent.readMyContent(in)); break;
			case CONTENT_LIST__PROP: {
				java.util.List<test.container.nointerfaces.model.MyContent> newValue = new java.util.ArrayList<>();
				in.beginArray();
				while (in.hasNext()) {
					newValue.add(test.container.nointerfaces.model.MyContent.readMyContent(in));
				}
				in.endArray();
				setContentList(newValue);
			}
			break;
			case CONTENT_MAP__PROP: {
				java.util.Map<String, test.container.nointerfaces.model.MyContent> newValue = new java.util.LinkedHashMap<>();
				in.beginObject();
				while (in.hasNext()) {
					newValue.put(in.nextName(), test.container.nointerfaces.model.MyContent.readMyContent(in));
				}
				in.endObject();
				setContentMap(newValue);
				break;
			}
			case OTHER__PROP: setOther(test.container.nointerfaces.model.MyContent.readMyContent(in)); break;
			case OTHERS__PROP: {
				java.util.List<test.container.nointerfaces.model.MyContent> newValue = new java.util.ArrayList<>();
				in.beginArray();
				while (in.hasNext()) {
					newValue.add(test.container.nointerfaces.model.MyContent.readMyContent(in));
				}
				in.endArray();
				setOthers(newValue);
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
		out.name(NAME__ID);
		out.value(getName());
		if (hasContent1()) {
			out.name(CONTENT_1__ID);
			getContent1().writeTo(out);
		}
		if (hasContent2()) {
			out.name(CONTENT_2__ID);
			getContent2().writeTo(out);
		}
		out.name(CONTENT_LIST__ID);
		{
			java.util.List<test.container.nointerfaces.model.MyContent> values = getContentList();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.OBJECT, values.size());
			for (test.container.nointerfaces.model.MyContent x : values) {
				x.writeTo(out);
			}
			out.endArray();
		}
		out.name(CONTENT_MAP__ID);
		if (hasOther()) {
			out.name(OTHER__ID);
			getOther().writeTo(out);
		}
		out.name(OTHERS__ID);
		{
			java.util.List<test.container.nointerfaces.model.MyContent> values = getOthers();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.OBJECT, values.size());
			for (test.container.nointerfaces.model.MyContent x : values) {
				x.writeTo(out);
			}
			out.endArray();
		}
	}

	/** Reads a new instance from the given reader. */
	public static test.container.nointerfaces.model.MyContainer readMyContainer(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.container.nointerfaces.model.MyContainer result = test.container.nointerfaces.model.MyContainer.readMyContainer_Content(in);
		in.endObject();
		return result;
	}

	/** Helper for creating an object of type {@link test.container.nointerfaces.model.MyContainer} from a polymorphic composition. */
	public static test.container.nointerfaces.model.MyContainer readMyContainer_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.container.nointerfaces.model.MyContainer result = new MyContainer();
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
			case NAME__ID: setName(in.nextString()); break;
			case CONTENT_1__ID: setContent1(test.container.nointerfaces.model.MyContent.readMyContent(in)); break;
			case CONTENT_2__ID: setContent2(test.container.nointerfaces.model.MyContent.readMyContent(in)); break;
			case CONTENT_LIST__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addContentList(test.container.nointerfaces.model.MyContent.readMyContent(in));
				}
				in.endArray();
			}
			break;
			case CONTENT_MAP__ID: {
				in.beginArray();
				while (in.hasNext()) {
					in.beginObject();
					String key = "";
					test.container.nointerfaces.model.MyContent value = null;
					while (in.hasNext()) {
						switch (in.nextName()) {
							case 1: key = in.nextString(); break;
							case 2: value = test.container.nointerfaces.model.MyContent.readMyContent(in); break;
							default: in.skipValue(); break;
						}
					}
					putContentMap(key, value);
					in.endObject();
				}
				in.endArray();
				break;
			}
			case OTHER__ID: setOther(test.container.nointerfaces.model.MyContent.readMyContent(in)); break;
			case OTHERS__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addOthers(test.container.nointerfaces.model.MyContent.readMyContent(in));
				}
				in.endArray();
			}
			break;
			default: in.skipValue(); 
		}
	}

	/** XML element name representing a {@link test.container.nointerfaces.model.MyContainer} type. */
	public static final String MY_CONTAINER__XML_ELEMENT = "my-container";

	/** XML attribute or element name of a {@link #getName} property. */
	private static final String NAME__XML_ATTR = "name";

	/** XML attribute or element name of a {@link #getContent1} property. */
	private static final String CONTENT_1__XML_ATTR = "content-1";

	/** XML attribute or element name of a {@link #getContent2} property. */
	private static final String CONTENT_2__XML_ATTR = "content-2";

	/** XML attribute or element name of a {@link #getContentList} property. */
	private static final String CONTENT_LIST__XML_ATTR = "content-list";

	/** XML attribute or element name of a {@link #getContentMap} property. */
	private static final String CONTENT_MAP__XML_ATTR = "content-map";

	/** XML attribute or element name of a {@link #getOther} property. */
	private static final String OTHER__XML_ATTR = "other";

	/** XML attribute or element name of a {@link #getOthers} property. */
	private static final String OTHERS__XML_ATTR = "others";

	@Override
	public String getXmlTagName() {
		return MY_CONTAINER__XML_ELEMENT;
	}

	@Override
	public final void writeContent(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		writeAttributes(out);
		writeElements(out);
	}

	/** Serializes all fields that are written as XML attributes. */
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		out.writeAttribute(NAME__XML_ATTR, getName());
	}

	/** Serializes all fields that are written as XML elements. */
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		if (hasContent1()) {
			out.writeStartElement(CONTENT_1__XML_ATTR);
			getContent1().writeContent(out);
			out.writeEndElement();
		}
		if (hasContent2()) {
			out.writeStartElement(CONTENT_2__XML_ATTR);
			getContent2().writeContent(out);
			out.writeEndElement();
		}
		out.writeStartElement(CONTENT_LIST__XML_ATTR);
		for (test.container.nointerfaces.model.MyContent element : getContentList()) {
			element.writeTo(out);
		}
		out.writeEndElement();
		if (hasOther()) {
			out.writeStartElement(OTHER__XML_ATTR);
			getOther().writeContent(out);
			out.writeEndElement();
		}
		out.writeStartElement(OTHERS__XML_ATTR);
		for (test.container.nointerfaces.model.MyContent element : getOthers()) {
			element.writeTo(out);
		}
		out.writeEndElement();
	}

	/** Creates a new {@link test.container.nointerfaces.model.MyContainer} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static MyContainer readMyContainer_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		MyContainer result = new MyContainer();
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
			case NAME__XML_ATTR: {
				setName(value);
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
			case NAME__XML_ATTR: {
				setName(in.getElementText());
				break;
			}
			case CONTENT_1__XML_ATTR: {
				setContent1(test.container.nointerfaces.model.MyContent.readMyContent_XmlContent(in));
				break;
			}
			case CONTENT_2__XML_ATTR: {
				setContent2(test.container.nointerfaces.model.MyContent.readMyContent_XmlContent(in));
				break;
			}
			case CONTENT_LIST__XML_ATTR: {
				internalReadContentListListXml(in);
				break;
			}
			case OTHER__XML_ATTR: {
				setOther(test.container.nointerfaces.model.MyContent.readMyContent_XmlContent(in));
				break;
			}
			case OTHERS__XML_ATTR: {
				internalReadOthersListXml(in);
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

	private void internalReadContentListListXml(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		while (true) {
			int event = in.nextTag();
			if (event == javax.xml.stream.XMLStreamConstants.END_ELEMENT) {
				break;
			}

			addContentList(test.container.nointerfaces.model.MyContent.readMyContent_XmlContent(in));
		}
	}

	private void internalReadOthersListXml(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		while (true) {
			int event = in.nextTag();
			if (event == javax.xml.stream.XMLStreamConstants.END_ELEMENT) {
				break;
			}

			addOthers(test.container.nointerfaces.model.MyContent.readMyContent_XmlContent(in));
		}
	}

	/** Creates a new {@link MyContainer} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static MyContainer readMyContainer(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.container.nointerfaces.model.MyContainer.readMyContainer_XmlContent(in);
	}

}
