package test.references.data.impl;

public class A_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.references.data.A {

	private String _name = "";

	private test.references.data.A _contents = null;

	private final java.util.List<test.references.data.A> _children = new de.haumacher.msgbuf.util.ReferenceList<>() {
		@Override
		protected void beforeAdd(int index, test.references.data.A element) {
			_listener.beforeAdd(A_Impl.this, CHILDREN__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, test.references.data.A element) {
			_listener.afterRemove(A_Impl.this, CHILDREN__PROP, index, element);
		}
	};

	private final java.util.List<test.references.data.B> _bs = new de.haumacher.msgbuf.util.ReferenceList<>() {
		@Override
		protected void beforeAdd(int index, test.references.data.B element) {
			test.references.data.impl.B_Impl added = (test.references.data.impl.B_Impl) element;
			_listener.beforeAdd(A_Impl.this, BS__PROP, index, element);
			added.addInBs(A_Impl.this);
		}

		@Override
		protected void afterRemove(int index, test.references.data.B element) {
			test.references.data.impl.B_Impl removed = (test.references.data.impl.B_Impl) element;
			removed.removeInBs(A_Impl.this);
			_listener.afterRemove(A_Impl.this, BS__PROP, index, element);
		}
	};

	private test.references.data.B _b = null;

	private test.references.data.A _other = null;

	private final java.util.List<test.references.data.A> _others = new de.haumacher.msgbuf.util.ReferenceList<>() {
		@Override
		protected void beforeAdd(int index, test.references.data.A element) {
			test.references.data.impl.A_Impl added = (test.references.data.impl.A_Impl) element;
			_listener.beforeAdd(A_Impl.this, OTHERS__PROP, index, element);
			added.addInOthers(A_Impl.this);
		}

		@Override
		protected void afterRemove(int index, test.references.data.A element) {
			test.references.data.impl.A_Impl removed = (test.references.data.impl.A_Impl) element;
			removed.removeInOthers(A_Impl.this);
			_listener.afterRemove(A_Impl.this, OTHERS__PROP, index, element);
		}
	};

	private final java.util.List<test.references.data.A> _inOther = new de.haumacher.msgbuf.util.ReferenceList<>() {
		@Override
		protected void beforeAdd(int index, test.references.data.A element) {
			_listener.beforeAdd(A_Impl.this, IN_OTHER__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, test.references.data.A element) {
			_listener.afterRemove(A_Impl.this, IN_OTHER__PROP, index, element);
		}
	};

	private final java.util.List<test.references.data.A> _inOthers = new de.haumacher.msgbuf.util.ReferenceList<>() {
		@Override
		protected void beforeAdd(int index, test.references.data.A element) {
			_listener.beforeAdd(A_Impl.this, IN_OTHERS__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, test.references.data.A element) {
			_listener.afterRemove(A_Impl.this, IN_OTHERS__PROP, index, element);
		}
	};

	/**
	 * Creates a {@link A_Impl} instance.
	 *
	 * @see test.references.data.A#create()
	 */
	public A_Impl() {
		super();
	}

	@Override
	public final String getName() {
		return _name;
	}

	@Override
	public test.references.data.A setName(String value) {
		internalSetName(value);
		return this;
	}

	/** Internal setter for {@link #getName()} without chain call utility. */
	protected final void internalSetName(String value) {
		_listener.beforeSet(this, NAME__PROP, value);
		_name = value;
	}

	@Override
	public final test.references.data.A getContents() {
		return _contents;
	}

	@Override
	public test.references.data.A setContents(test.references.data.A value) {
		internalSetContents(value);
		return this;
	}

	/** Internal setter for {@link #getContents()} without chain call utility. */
	protected final void internalSetContents(test.references.data.A value) {
		_listener.beforeSet(this, CONTENTS__PROP, value);
		_contents = value;
	}

	@Override
	public final boolean hasContents() {
		return _contents != null;
	}

	@Override
	public final java.util.List<test.references.data.A> getChildren() {
		return _children;
	}

	@Override
	public test.references.data.A setChildren(java.util.List<? extends test.references.data.A> value) {
		internalSetChildren(value);
		return this;
	}

	/** Internal setter for {@link #getChildren()} without chain call utility. */
	protected final void internalSetChildren(java.util.List<? extends test.references.data.A> value) {
		if (value == null) throw new IllegalArgumentException("Property 'children' cannot be null.");
		_children.clear();
		_children.addAll(value);
	}

	@Override
	public test.references.data.A addChildren(test.references.data.A value) {
		internalAddChildren(value);
		return this;
	}

	/** Implementation of {@link #addChildren(test.references.data.A)} without chain call utility. */
	protected final void internalAddChildren(test.references.data.A value) {
		_children.add(value);
	}

	@Override
	public final void removeChildren(test.references.data.A value) {
		_children.remove(value);
	}

	@Override
	public final java.util.List<test.references.data.B> getBs() {
		return _bs;
	}

	@Override
	public test.references.data.A setBs(java.util.List<? extends test.references.data.B> value) {
		internalSetBs(value);
		return this;
	}

	/** Internal setter for {@link #getBs()} without chain call utility. */
	protected final void internalSetBs(java.util.List<? extends test.references.data.B> value) {
		if (value == null) throw new IllegalArgumentException("Property 'bs' cannot be null.");
		_bs.clear();
		_bs.addAll(value);
	}

	@Override
	public test.references.data.A addBs(test.references.data.B value) {
		internalAddBs(value);
		return this;
	}

	/** Implementation of {@link #addBs(test.references.data.B)} without chain call utility. */
	protected final void internalAddBs(test.references.data.B value) {
		_bs.add(value);
	}

	@Override
	public final void removeBs(test.references.data.B value) {
		_bs.remove(value);
	}

	@Override
	public final test.references.data.B getB() {
		return _b;
	}

	@Override
	public test.references.data.A setB(test.references.data.B value) {
		internalSetB(value);
		return this;
	}

	/** Internal setter for {@link #getB()} without chain call utility. */
	protected final void internalSetB(test.references.data.B value) {
		test.references.data.impl.B_Impl before = (test.references.data.impl.B_Impl) _b;
		test.references.data.impl.B_Impl after = (test.references.data.impl.B_Impl) value;
		_listener.beforeSet(this, B__PROP, value);
		if (before != null) {
			before.removeInB(this);
		}
		_b = value;
		if (after != null) {
			after.addInB(this);
		}
	}

	@Override
	public final boolean hasB() {
		return _b != null;
	}

	@Override
	public final test.references.data.A getOther() {
		return _other;
	}

	@Override
	public test.references.data.A setOther(test.references.data.A value) {
		internalSetOther(value);
		return this;
	}

	/** Internal setter for {@link #getOther()} without chain call utility. */
	protected final void internalSetOther(test.references.data.A value) {
		test.references.data.impl.A_Impl before = (test.references.data.impl.A_Impl) _other;
		test.references.data.impl.A_Impl after = (test.references.data.impl.A_Impl) value;
		_listener.beforeSet(this, OTHER__PROP, value);
		if (before != null) {
			before.removeInOther(this);
		}
		_other = value;
		if (after != null) {
			after.addInOther(this);
		}
	}

	@Override
	public final boolean hasOther() {
		return _other != null;
	}

	@Override
	public final java.util.List<test.references.data.A> getOthers() {
		return _others;
	}

	@Override
	public test.references.data.A setOthers(java.util.List<? extends test.references.data.A> value) {
		internalSetOthers(value);
		return this;
	}

	/** Internal setter for {@link #getOthers()} without chain call utility. */
	protected final void internalSetOthers(java.util.List<? extends test.references.data.A> value) {
		if (value == null) throw new IllegalArgumentException("Property 'others' cannot be null.");
		_others.clear();
		_others.addAll(value);
	}

	@Override
	public test.references.data.A addOthers(test.references.data.A value) {
		internalAddOthers(value);
		return this;
	}

	/** Implementation of {@link #addOthers(test.references.data.A)} without chain call utility. */
	protected final void internalAddOthers(test.references.data.A value) {
		_others.add(value);
	}

	@Override
	public final void removeOthers(test.references.data.A value) {
		_others.remove(value);
	}

	@Override
	public final java.util.List<test.references.data.A> getInOther() {
		return _inOther;
	}

	/**
	 * Internal setter for updating derived field.
	 */
	test.references.data.A setInOther(java.util.List<? extends test.references.data.A> value) {
		internalSetInOther(value);
		return this;
	}

	/** Internal setter for {@link #getInOther()} without chain call utility. */
	protected final void internalSetInOther(java.util.List<? extends test.references.data.A> value) {
		if (value == null) throw new IllegalArgumentException("Property 'inOther' cannot be null.");
		_inOther.clear();
		_inOther.addAll(value);
	}

	test.references.data.A addInOther(test.references.data.A value) {
		internalAddInOther(value);
		return this;
	}

	/** Implementation of {@link #addInOther(test.references.data.A)} without chain call utility. */
	protected final void internalAddInOther(test.references.data.A value) {
		_inOther.add(value);
	}

	final void removeInOther(test.references.data.A value) {
		_inOther.remove(value);
	}

	@Override
	public final java.util.List<test.references.data.A> getInOthers() {
		return _inOthers;
	}

	/**
	 * Internal setter for updating derived field.
	 */
	test.references.data.A setInOthers(java.util.List<? extends test.references.data.A> value) {
		internalSetInOthers(value);
		return this;
	}

	/** Internal setter for {@link #getInOthers()} without chain call utility. */
	protected final void internalSetInOthers(java.util.List<? extends test.references.data.A> value) {
		if (value == null) throw new IllegalArgumentException("Property 'inOthers' cannot be null.");
		_inOthers.clear();
		_inOthers.addAll(value);
	}

	test.references.data.A addInOthers(test.references.data.A value) {
		internalAddInOthers(value);
		return this;
	}

	/** Implementation of {@link #addInOthers(test.references.data.A)} without chain call utility. */
	protected final void internalAddInOthers(test.references.data.A value) {
		_inOthers.add(value);
	}

	final void removeInOthers(test.references.data.A value) {
		_inOthers.remove(value);
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.references.data.A registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.references.data.A unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		internalUnregisterListener(l);
		return this;
	}

	protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
	}

	@Override
	public String jsonType() {
		return A__TYPE;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			NAME__PROP, 
			CONTENTS__PROP, 
			CHILDREN__PROP, 
			BS__PROP, 
			B__PROP, 
			OTHER__PROP, 
			OTHERS__PROP, 
			IN_OTHER__PROP, 
			IN_OTHERS__PROP));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case NAME__PROP: return getName();
			case CONTENTS__PROP: return getContents();
			case CHILDREN__PROP: return getChildren();
			case BS__PROP: return getBs();
			case B__PROP: return getB();
			case OTHER__PROP: return getOther();
			case OTHERS__PROP: return getOthers();
			case IN_OTHER__PROP: return getInOther();
			case IN_OTHERS__PROP: return getInOthers();
			default: return test.references.data.A.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case NAME__PROP: internalSetName((String) value); break;
			case CONTENTS__PROP: internalSetContents((test.references.data.A) value); break;
			case CHILDREN__PROP: internalSetChildren(de.haumacher.msgbuf.util.Conversions.asList(test.references.data.A.class, value)); break;
			case BS__PROP: internalSetBs(de.haumacher.msgbuf.util.Conversions.asList(test.references.data.B.class, value)); break;
			case B__PROP: internalSetB((test.references.data.B) value); break;
			case OTHER__PROP: internalSetOther((test.references.data.A) value); break;
			case OTHERS__PROP: internalSetOthers(de.haumacher.msgbuf.util.Conversions.asList(test.references.data.A.class, value)); break;
		}
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
		if (hasContents()) {
			out.name(CONTENTS__PROP);
			getContents().writeTo(out);
		}
		out.name(CHILDREN__PROP);
		out.beginArray();
		for (test.references.data.A x : getChildren()) {
			x.writeTo(out);
		}
		out.endArray();
		out.name(BS__PROP);
		out.beginArray();
		for (test.references.data.B x : getBs()) {
			x.writeTo(out);
		}
		out.endArray();
		if (hasB()) {
			out.name(B__PROP);
			getB().writeTo(out);
		}
		if (hasOther()) {
			out.name(OTHER__PROP);
			getOther().writeTo(out);
		}
		out.name(OTHERS__PROP);
		out.beginArray();
		for (test.references.data.A x : getOthers()) {
			x.writeTo(out);
		}
		out.endArray();
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case NAME__PROP: setName(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			case CONTENTS__PROP: setContents(test.references.data.A.readA(in)); break;
			case CHILDREN__PROP: {
				in.beginArray();
				while (in.hasNext()) {
					addChildren(test.references.data.A.readA(in));
				}
				in.endArray();
			}
			break;
			case BS__PROP: {
				in.beginArray();
				while (in.hasNext()) {
					addBs(test.references.data.B.readB(in));
				}
				in.endArray();
			}
			break;
			case B__PROP: setB(test.references.data.B.readB(in)); break;
			case OTHER__PROP: setOther(test.references.data.A.readA(in)); break;
			case OTHERS__PROP: {
				in.beginArray();
				while (in.hasNext()) {
					addOthers(test.references.data.A.readA(in));
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
		out.name(NAME__ID);
		out.value(getName());
		if (hasContents()) {
			out.name(CONTENTS__ID);
			getContents().writeTo(out);
		}
		out.name(CHILDREN__ID);
		{
			java.util.List<test.references.data.A> values = getChildren();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.OBJECT, values.size());
			for (test.references.data.A x : values) {
				x.writeTo(out);
			}
			out.endArray();
		}
		out.name(BS__ID);
		{
			java.util.List<test.references.data.B> values = getBs();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.OBJECT, values.size());
			for (test.references.data.B x : values) {
				x.writeTo(out);
			}
			out.endArray();
		}
		if (hasB()) {
			out.name(B__ID);
			getB().writeTo(out);
		}
		if (hasOther()) {
			out.name(OTHER__ID);
			getOther().writeTo(out);
		}
		out.name(OTHERS__ID);
		{
			java.util.List<test.references.data.A> values = getOthers();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.OBJECT, values.size());
			for (test.references.data.A x : values) {
				x.writeTo(out);
			}
			out.endArray();
		}
	}

	/** Helper for creating an object of type {@link test.references.data.A} from a polymorphic composition. */
	public static test.references.data.A readA_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.references.data.impl.A_Impl result = new A_Impl();
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
			case CONTENTS__ID: setContents(test.references.data.A.readA(in)); break;
			case CHILDREN__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addChildren(test.references.data.A.readA(in));
				}
				in.endArray();
			}
			break;
			case BS__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addBs(test.references.data.B.readB(in));
				}
				in.endArray();
			}
			break;
			case B__ID: setB(test.references.data.B.readB(in)); break;
			case OTHER__ID: setOther(test.references.data.A.readA(in)); break;
			case OTHERS__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addOthers(test.references.data.A.readA(in));
				}
				in.endArray();
			}
			break;
			default: in.skipValue(); 
		}
	}

	/** XML element name representing a {@link test.references.data.A} type. */
	public static final String A__XML_ELEMENT = "a";

	/** XML attribute or element name of a {@link #getName} property. */
	private static final String NAME__XML_ATTR = "name";

	/** XML attribute or element name of a {@link #getContents} property. */
	private static final String CONTENTS__XML_ATTR = "contents";

	/** XML attribute or element name of a {@link #getChildren} property. */
	private static final String CHILDREN__XML_ATTR = "children";

	/** XML attribute or element name of a {@link #getBs} property. */
	private static final String BS__XML_ATTR = "bs";

	/** XML attribute or element name of a {@link #getB} property. */
	private static final String B__XML_ATTR = "b";

	/** XML attribute or element name of a {@link #getOther} property. */
	private static final String OTHER__XML_ATTR = "other";

	/** XML attribute or element name of a {@link #getOthers} property. */
	private static final String OTHERS__XML_ATTR = "others";

	/** XML attribute or element name of a {@link #getInOther} property. */
	private static final String IN_OTHER__XML_ATTR = "in-other";

	/** XML attribute or element name of a {@link #getInOthers} property. */
	private static final String IN_OTHERS__XML_ATTR = "in-others";

	@Override
	public String getXmlTagName() {
		return A__XML_ELEMENT;
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
		if (hasContents()) {
			out.writeStartElement(CONTENTS__XML_ATTR);
			getContents().writeContent(out);
			out.writeEndElement();
		}
		out.writeStartElement(CHILDREN__XML_ATTR);
		for (test.references.data.A element : getChildren()) {
			element.writeTo(out);
		}
		out.writeEndElement();
		out.writeStartElement(BS__XML_ATTR);
		for (test.references.data.B element : getBs()) {
			element.writeTo(out);
		}
		out.writeEndElement();
		if (hasB()) {
			out.writeStartElement(B__XML_ATTR);
			getB().writeContent(out);
			out.writeEndElement();
		}
		if (hasOther()) {
			out.writeStartElement(OTHER__XML_ATTR);
			getOther().writeContent(out);
			out.writeEndElement();
		}
		out.writeStartElement(OTHERS__XML_ATTR);
		for (test.references.data.A element : getOthers()) {
			element.writeTo(out);
		}
		out.writeEndElement();
		out.writeStartElement(IN_OTHER__XML_ATTR);
		for (test.references.data.A element : getInOther()) {
			element.writeTo(out);
		}
		out.writeEndElement();
		out.writeStartElement(IN_OTHERS__XML_ATTR);
		for (test.references.data.A element : getInOthers()) {
			element.writeTo(out);
		}
		out.writeEndElement();
	}

	/** Creates a new {@link test.references.data.A} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static A_Impl readA_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		A_Impl result = new A_Impl();
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
			case CONTENTS__XML_ATTR: {
				setContents(test.references.data.impl.A_Impl.readA_XmlContent(in));
				break;
			}
			case CHILDREN__XML_ATTR: {
				internalReadChildrenListXml(in);
				break;
			}
			case BS__XML_ATTR: {
				internalReadBsListXml(in);
				break;
			}
			case B__XML_ATTR: {
				setB(test.references.data.impl.B_Impl.readB_XmlContent(in));
				break;
			}
			case OTHER__XML_ATTR: {
				setOther(test.references.data.impl.A_Impl.readA_XmlContent(in));
				break;
			}
			case OTHERS__XML_ATTR: {
				internalReadOthersListXml(in);
				break;
			}
			case IN_OTHER__XML_ATTR: {
				internalReadInOtherListXml(in);
				break;
			}
			case IN_OTHERS__XML_ATTR: {
				internalReadInOthersListXml(in);
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

	private void internalReadChildrenListXml(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		while (true) {
			int event = in.nextTag();
			if (event == javax.xml.stream.XMLStreamConstants.END_ELEMENT) {
				break;
			}

			addChildren(test.references.data.impl.A_Impl.readA_XmlContent(in));
		}
	}

	private void internalReadBsListXml(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		while (true) {
			int event = in.nextTag();
			if (event == javax.xml.stream.XMLStreamConstants.END_ELEMENT) {
				break;
			}

			addBs(test.references.data.impl.B_Impl.readB_XmlContent(in));
		}
	}

	private void internalReadOthersListXml(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		while (true) {
			int event = in.nextTag();
			if (event == javax.xml.stream.XMLStreamConstants.END_ELEMENT) {
				break;
			}

			addOthers(test.references.data.impl.A_Impl.readA_XmlContent(in));
		}
	}

	private void internalReadInOtherListXml(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		while (true) {
			int event = in.nextTag();
			if (event == javax.xml.stream.XMLStreamConstants.END_ELEMENT) {
				break;
			}

			addInOther(test.references.data.impl.A_Impl.readA_XmlContent(in));
		}
	}

	private void internalReadInOthersListXml(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		while (true) {
			int event = in.nextTag();
			if (event == javax.xml.stream.XMLStreamConstants.END_ELEMENT) {
				break;
			}

			addInOthers(test.references.data.impl.A_Impl.readA_XmlContent(in));
		}
	}

}
