package test.references.data;

class A_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements A {

	private String _name = "";

	private A _contents = null;

	private final java.util.List<A> _children = new de.haumacher.msgbuf.util.ReferenceList<A>() {
		@Override
		protected void beforeAdd(int index, A element) {
			_listener.beforeAdd(A_Impl.this, CHILDREN__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, A element) {
			_listener.afterRemove(A_Impl.this, CHILDREN__PROP, index, element);
		}
	};

	private final java.util.List<B> _bs = new de.haumacher.msgbuf.util.ReferenceList<B>() {
		@Override
		protected void beforeAdd(int index, B element) {
			_listener.beforeAdd(A_Impl.this, BS__PROP, index, element);
			((B_Impl) element).addInBs(A_Impl.this);
		}

		@Override
		protected void afterRemove(int index, B element) {
			((B_Impl) element).removeInBs(A_Impl.this);
			_listener.afterRemove(A_Impl.this, BS__PROP, index, element);
		}
	};

	private B _b = null;

	private A _other = null;

	private final java.util.List<A> _others = new de.haumacher.msgbuf.util.ReferenceList<A>() {
		@Override
		protected void beforeAdd(int index, A element) {
			_listener.beforeAdd(A_Impl.this, OTHERS__PROP, index, element);
			((A_Impl) element).addInOthers(A_Impl.this);
		}

		@Override
		protected void afterRemove(int index, A element) {
			((A_Impl) element).removeInOthers(A_Impl.this);
			_listener.afterRemove(A_Impl.this, OTHERS__PROP, index, element);
		}
	};

	private final java.util.List<A> _inOther = new de.haumacher.msgbuf.util.ReferenceList<A>() {
		@Override
		protected void beforeAdd(int index, A element) {
			_listener.beforeAdd(A_Impl.this, IN_OTHER__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, A element) {
			_listener.afterRemove(A_Impl.this, IN_OTHER__PROP, index, element);
		}
	};

	private final java.util.List<A> _inOthers = new de.haumacher.msgbuf.util.ReferenceList<A>() {
		@Override
		protected void beforeAdd(int index, A element) {
			_listener.beforeAdd(A_Impl.this, IN_OTHERS__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, A element) {
			_listener.afterRemove(A_Impl.this, IN_OTHERS__PROP, index, element);
		}
	};

	/**
	 * Creates a {@link A_Impl} instance.
	 *
	 * @see A#create()
	 */
	protected A_Impl() {
		super();
	}

	@Override
	public final String getName() {
		return _name;
	}

	@Override
	public A setName(String value) {
		internalSetName(value);
		return this;
	}

	/** Internal setter for {@link #getName()} without chain call utility. */
	protected final void internalSetName(String value) {
		_listener.beforeSet(this, NAME__PROP, value);
		_name = value;
	}

	@Override
	public final A getContents() {
		return _contents;
	}

	@Override
	public A setContents(A value) {
		internalSetContents(value);
		return this;
	}

	/** Internal setter for {@link #getContents()} without chain call utility. */
	protected final void internalSetContents(A value) {
		_listener.beforeSet(this, CONTENTS__PROP, value);
		_contents = value;
	}

	@Override
	public final boolean hasContents() {
		return _contents != null;
	}

	@Override
	public final java.util.List<A> getChildren() {
		return _children;
	}

	@Override
	public A setChildren(java.util.List<? extends A> value) {
		internalSetChildren(value);
		return this;
	}

	/** Internal setter for {@link #getChildren()} without chain call utility. */
	protected final void internalSetChildren(java.util.List<? extends A> value) {
		if (value == null) throw new IllegalArgumentException("Property 'children' cannot be null.");
		_children.clear();
		_children.addAll(value);
	}

	@Override
	public A addChildren(A value) {
		internalAddChildren(value);
		return this;
	}

	/** Implementation of {@link #addChildren(A)} without chain call utility. */
	protected final void internalAddChildren(A value) {
		_children.add(value);
	}

	@Override
	public final void removeChildren(A value) {
		_children.remove(value);
	}

	@Override
	public final java.util.List<B> getBs() {
		return _bs;
	}

	@Override
	public A setBs(java.util.List<? extends B> value) {
		internalSetBs(value);
		return this;
	}

	/** Internal setter for {@link #getBs()} without chain call utility. */
	protected final void internalSetBs(java.util.List<? extends B> value) {
		if (value == null) throw new IllegalArgumentException("Property 'bs' cannot be null.");
		_bs.clear();
		_bs.addAll(value);
	}

	@Override
	public A addBs(B value) {
		internalAddBs(value);
		return this;
	}

	/** Implementation of {@link #addBs(B)} without chain call utility. */
	protected final void internalAddBs(B value) {
		_bs.add(value);
	}

	@Override
	public final void removeBs(B value) {
		_bs.remove(value);
	}

	@Override
	public final B getB() {
		return _b;
	}

	@Override
	public A setB(B value) {
		internalSetB(value);
		return this;
	}

	/** Internal setter for {@link #getB()} without chain call utility. */
	protected final void internalSetB(B value) {
		_listener.beforeSet(this, B__PROP, value);
		if (_b != null) {
			((B_Impl) _b).removeInB(this);
		}
		_b = value;
		if (value != null) {
			((B_Impl) value).addInB(this);
		}
	}

	@Override
	public final boolean hasB() {
		return _b != null;
	}

	@Override
	public final A getOther() {
		return _other;
	}

	@Override
	public A setOther(A value) {
		internalSetOther(value);
		return this;
	}

	/** Internal setter for {@link #getOther()} without chain call utility. */
	protected final void internalSetOther(A value) {
		_listener.beforeSet(this, OTHER__PROP, value);
		if (_other != null) {
			((A_Impl) _other).removeInOther(this);
		}
		_other = value;
		if (value != null) {
			((A_Impl) value).addInOther(this);
		}
	}

	@Override
	public final boolean hasOther() {
		return _other != null;
	}

	@Override
	public final java.util.List<A> getOthers() {
		return _others;
	}

	@Override
	public A setOthers(java.util.List<? extends A> value) {
		internalSetOthers(value);
		return this;
	}

	/** Internal setter for {@link #getOthers()} without chain call utility. */
	protected final void internalSetOthers(java.util.List<? extends A> value) {
		if (value == null) throw new IllegalArgumentException("Property 'others' cannot be null.");
		_others.clear();
		_others.addAll(value);
	}

	@Override
	public A addOthers(A value) {
		internalAddOthers(value);
		return this;
	}

	/** Implementation of {@link #addOthers(A)} without chain call utility. */
	protected final void internalAddOthers(A value) {
		_others.add(value);
	}

	@Override
	public final void removeOthers(A value) {
		_others.remove(value);
	}

	@Override
	public final java.util.List<A> getInOther() {
		return _inOther;
	}

	A setInOther(java.util.List<? extends A> value) {
		internalSetInOther(value);
		return this;
	}

	/** Internal setter for {@link #getInOther()} without chain call utility. */
	protected final void internalSetInOther(java.util.List<? extends A> value) {
		if (value == null) throw new IllegalArgumentException("Property 'inOther' cannot be null.");
		_inOther.clear();
		_inOther.addAll(value);
	}

	A addInOther(A value) {
		internalAddInOther(value);
		return this;
	}

	/** Implementation of {@link #addInOther(A)} without chain call utility. */
	protected final void internalAddInOther(A value) {
		_inOther.add(value);
	}

	final void removeInOther(A value) {
		_inOther.remove(value);
	}

	@Override
	public final java.util.List<A> getInOthers() {
		return _inOthers;
	}

	A setInOthers(java.util.List<? extends A> value) {
		internalSetInOthers(value);
		return this;
	}

	/** Internal setter for {@link #getInOthers()} without chain call utility. */
	protected final void internalSetInOthers(java.util.List<? extends A> value) {
		if (value == null) throw new IllegalArgumentException("Property 'inOthers' cannot be null.");
		_inOthers.clear();
		_inOthers.addAll(value);
	}

	A addInOthers(A value) {
		internalAddInOthers(value);
		return this;
	}

	/** Implementation of {@link #addInOthers(A)} without chain call utility. */
	protected final void internalAddInOthers(A value) {
		_inOthers.add(value);
	}

	final void removeInOthers(A value) {
		_inOthers.remove(value);
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public A registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public A unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
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
			default: return A.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case NAME__PROP: internalSetName((String) value); break;
			case CONTENTS__PROP: internalSetContents((A) value); break;
			case CHILDREN__PROP: internalSetChildren(de.haumacher.msgbuf.util.Conversions.asList(A.class, value)); break;
			case BS__PROP: internalSetBs(de.haumacher.msgbuf.util.Conversions.asList(B.class, value)); break;
			case B__PROP: internalSetB((B) value); break;
			case OTHER__PROP: internalSetOther((A) value); break;
			case OTHERS__PROP: internalSetOthers(de.haumacher.msgbuf.util.Conversions.asList(A.class, value)); break;
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
		for (A x : getChildren()) {
			x.writeTo(out);
		}
		out.endArray();
		out.name(BS__PROP);
		out.beginArray();
		for (B x : getBs()) {
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
		for (A x : getOthers()) {
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
			java.util.List<A> values = getChildren();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.OBJECT, values.size());
			for (A x : values) {
				x.writeTo(out);
			}
			out.endArray();
		}
		out.name(BS__ID);
		{
			java.util.List<B> values = getBs();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.OBJECT, values.size());
			for (B x : values) {
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
			java.util.List<A> values = getOthers();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.OBJECT, values.size());
			for (A x : values) {
				x.writeTo(out);
			}
			out.endArray();
		}
	}

	/** Helper for creating an object of type {@link A} from a polymorphic composition. */
	public static A readA_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.references.data.A_Impl result = new A_Impl();
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

	/** XML element name representing a {@link A} type. */
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

	/** Creates a new {@link A} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
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
				setContents(test.references.data.A_Impl.readA_XmlContent(in));
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
				setB(test.references.data.B_Impl.readB_XmlContent(in));
				break;
			}
			case OTHER__XML_ATTR: {
				setOther(test.references.data.A_Impl.readA_XmlContent(in));
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

			addChildren(test.references.data.A_Impl.readA_XmlContent(in));
		}
	}

	private void internalReadBsListXml(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		while (true) {
			int event = in.nextTag();
			if (event == javax.xml.stream.XMLStreamConstants.END_ELEMENT) {
				break;
			}

			addBs(test.references.data.B_Impl.readB_XmlContent(in));
		}
	}

	private void internalReadOthersListXml(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		while (true) {
			int event = in.nextTag();
			if (event == javax.xml.stream.XMLStreamConstants.END_ELEMENT) {
				break;
			}

			addOthers(test.references.data.A_Impl.readA_XmlContent(in));
		}
	}

	private void internalReadInOtherListXml(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		while (true) {
			int event = in.nextTag();
			if (event == javax.xml.stream.XMLStreamConstants.END_ELEMENT) {
				break;
			}

			addInOther(test.references.data.A_Impl.readA_XmlContent(in));
		}
	}

	private void internalReadInOthersListXml(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		while (true) {
			int event = in.nextTag();
			if (event == javax.xml.stream.XMLStreamConstants.END_ELEMENT) {
				break;
			}

			addInOthers(test.references.data.A_Impl.readA_XmlContent(in));
		}
	}

}
