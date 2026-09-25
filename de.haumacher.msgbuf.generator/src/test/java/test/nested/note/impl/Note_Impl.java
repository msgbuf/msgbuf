package test.nested.note.impl;

/**
 * Implementation of {@link test.nested.note.Note}.
 */
public class Note_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.nested.note.Note {
	/**
	 * Implementation of {@link test.nested.note.Note.Inner}.
	 */
	public static class Inner_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.nested.note.Note.Inner {

		private final java.util.List<test.nested.doc.Doc.Sec.Item> _refs = new de.haumacher.msgbuf.util.ReferenceList<test.nested.doc.Doc.Sec.Item>() {
			@Override
			protected void beforeAdd(int index, test.nested.doc.Doc.Sec.Item element) {
				_listener.beforeAdd(Inner_Impl.this, REFS__PROP, index, element);
			}

			@Override
			protected void afterRemove(int index, test.nested.doc.Doc.Sec.Item element) {
				_listener.afterRemove(Inner_Impl.this, REFS__PROP, index, element);
			}

			@Override
			protected void afterChanged() {
				_listener.afterChanged(Inner_Impl.this, REFS__PROP);
			}
		};

		/**
		 * Creates a {@link Inner_Impl} instance.
		 *
		 * @see test.nested.note.Note.Inner#create()
		 */
		public Inner_Impl() {
			super();
		}

		@Override
		public final java.util.List<test.nested.doc.Doc.Sec.Item> getRefs() {
			return _refs;
		}

		@Override
		public test.nested.note.Note.Inner setRefs(java.util.List<? extends test.nested.doc.Doc.Sec.Item> value) {
			internalSetRefs(value);
			return this;
		}

		/** Internal setter for {@link #getRefs()} without chain call utility. */
		protected final void internalSetRefs(java.util.List<? extends test.nested.doc.Doc.Sec.Item> value) {
			if (value == null) throw new IllegalArgumentException("Property 'refs' cannot be null.");
			_refs.clear();
			_refs.addAll(value);
		}

		@Override
		public test.nested.note.Note.Inner addRef(test.nested.doc.Doc.Sec.Item value) {
			internalAddRef(value);
			return this;
		}

		/** Implementation of {@link #addRef(test.nested.doc.Doc.Sec.Item)} without chain call utility. */
		protected final void internalAddRef(test.nested.doc.Doc.Sec.Item value) {
			_refs.add(value);
		}

		@Override
		public final void removeRef(test.nested.doc.Doc.Sec.Item value) {
			_refs.remove(value);
		}

		protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

		@Override
		public test.nested.note.Note.Inner registerListener(de.haumacher.msgbuf.observer.Listener l) {
			internalRegisterListener(l);
			return this;
		}

		protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
			_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
		}

		@Override
		public test.nested.note.Note.Inner unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
			internalUnregisterListener(l);
			return this;
		}

		protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
			_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
		}

		@Override
		public String jsonType() {
			return INNER__TYPE;
		}

		static final java.util.List<String> PROPERTIES;
		static {
			java.util.List<String> local = java.util.Arrays.asList(
				REFS__PROP);
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
				case REFS__PROP: return getRefs();
				default: return test.nested.note.Note.Inner.super.get(field);
			}
		}

		@Override
		public void set(String field, Object value) {
			switch (field) {
				case REFS__PROP: internalSetRefs(de.haumacher.msgbuf.util.Conversions.asList(test.nested.doc.Doc.Sec.Item.class, value)); break;
			}
		}

		@Override
		public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
			writeContent(out);
		}

		@Override
		protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
			super.writeFields(out);
			out.name(REFS__PROP);
			out.beginArray();
			for (test.nested.doc.Doc.Sec.Item x : getRefs()) {
				x.writeTo(out);
			}
			out.endArray();
		}

		@Override
		protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
			switch (field) {
				case REFS__PROP: {
					java.util.List<test.nested.doc.Doc.Sec.Item> newValue = new java.util.ArrayList<>();
					in.beginArray();
					while (in.hasNext()) {
						newValue.add(test.nested.doc.Doc.Sec.Item.readItem(in));
					}
					in.endArray();
					setRefs(newValue);
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
			out.name(REFS__ID);
			{
				java.util.List<test.nested.doc.Doc.Sec.Item> values = getRefs();
				out.beginArray(de.haumacher.msgbuf.binary.DataType.OBJECT, values.size());
				for (test.nested.doc.Doc.Sec.Item x : values) {
					x.writeTo(out);
				}
				out.endArray();
			}
		}

		/** Helper for creating an object of type {@link test.nested.note.Note.Inner} from a polymorphic composition. */
		public static test.nested.note.Note.Inner readInner_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			test.nested.note.impl.Note_Impl.Inner_Impl result = new Inner_Impl();
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
				case REFS__ID: {
					in.beginArray();
					while (in.hasNext()) {
						addRef(test.nested.doc.Doc.Sec.Item.readItem(in));
					}
					in.endArray();
				}
				break;
				default: in.skipValue(); 
			}
		}

		/** XML element name representing a {@link test.nested.note.Note.Inner} type. */
		public static final String INNER__XML_ELEMENT = "inner";

		/** XML attribute or element name of a {@link #getRefs} property. */
		private static final String REFS__XML_ATTR = "refs";

		@Override
		public String getXmlTagName() {
			return INNER__XML_ELEMENT;
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
			out.writeStartElement(REFS__XML_ATTR);
			for (test.nested.doc.Doc.Sec.Item element : getRefs()) {
				element.writeTo(out);
			}
			out.writeEndElement();
		}

		/** Creates a new {@link test.nested.note.Note.Inner} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Inner_Impl readInner_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			Inner_Impl result = new Inner_Impl();
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
				case REFS__XML_ATTR: {
					internalReadRefsListXml(in);
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

		private void internalReadRefsListXml(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			while (true) {
				int event = in.nextTag();
				if (event == javax.xml.stream.XMLStreamConstants.END_ELEMENT) {
					break;
				}

				addRef(test.nested.doc.impl.Doc_Impl.Sec_Impl.Item_Impl.readItem_XmlContent(in));
			}
		}

	}

	private test.nested.doc.Doc.Sec.Item _target = null;

	private test.nested.note.Note.Inner _inner = null;

	/**
	 * Creates a {@link Note_Impl} instance.
	 *
	 * @see test.nested.note.Note#create()
	 */
	public Note_Impl() {
		super();
	}

	@Override
	public final test.nested.doc.Doc.Sec.Item getTarget() {
		return _target;
	}

	@Override
	public test.nested.note.Note setTarget(test.nested.doc.Doc.Sec.Item value) {
		internalSetTarget(value);
		return this;
	}

	/** Internal setter for {@link #getTarget()} without chain call utility. */
	protected final void internalSetTarget(test.nested.doc.Doc.Sec.Item value) {
		_listener.beforeSet(this, TARGET__PROP, value);
		_target = value;
		_listener.afterChanged(this, TARGET__PROP);
	}

	@Override
	public final boolean hasTarget() {
		return _target != null;
	}

	@Override
	public final test.nested.note.Note.Inner getInner() {
		return _inner;
	}

	@Override
	public test.nested.note.Note setInner(test.nested.note.Note.Inner value) {
		internalSetInner(value);
		return this;
	}

	/** Internal setter for {@link #getInner()} without chain call utility. */
	protected final void internalSetInner(test.nested.note.Note.Inner value) {
		_listener.beforeSet(this, INNER__PROP, value);
		_inner = value;
		_listener.afterChanged(this, INNER__PROP);
	}

	@Override
	public final boolean hasInner() {
		return _inner != null;
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.nested.note.Note registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.nested.note.Note unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		internalUnregisterListener(l);
		return this;
	}

	protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
	}

	@Override
	public String jsonType() {
		return NOTE__TYPE;
	}

	static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			TARGET__PROP, 
			INNER__PROP);
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
			case TARGET__PROP: return getTarget();
			case INNER__PROP: return getInner();
			default: return test.nested.note.Note.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case TARGET__PROP: internalSetTarget((test.nested.doc.Doc.Sec.Item) value); break;
			case INNER__PROP: internalSetInner((test.nested.note.Note.Inner) value); break;
		}
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		if (hasTarget()) {
			out.name(TARGET__PROP);
			getTarget().writeTo(out);
		}
		if (hasInner()) {
			out.name(INNER__PROP);
			getInner().writeTo(out);
		}
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case TARGET__PROP: setTarget(test.nested.doc.Doc.Sec.Item.readItem(in)); break;
			case INNER__PROP: setInner(test.nested.note.Note.Inner.readInner(in)); break;
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
		if (hasTarget()) {
			out.name(TARGET__ID);
			getTarget().writeTo(out);
		}
		if (hasInner()) {
			out.name(INNER__ID);
			getInner().writeTo(out);
		}
	}

	/** Helper for creating an object of type {@link test.nested.note.Note} from a polymorphic composition. */
	public static test.nested.note.Note readNote_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.nested.note.impl.Note_Impl result = new Note_Impl();
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
			case TARGET__ID: setTarget(test.nested.doc.Doc.Sec.Item.readItem(in)); break;
			case INNER__ID: setInner(test.nested.note.Note.Inner.readInner(in)); break;
			default: in.skipValue(); 
		}
	}

	/** XML element name representing a {@link test.nested.note.Note} type. */
	public static final String NOTE__XML_ELEMENT = "note";

	/** XML attribute or element name of a {@link #getTarget} property. */
	private static final String TARGET__XML_ATTR = "target";

	/** XML attribute or element name of a {@link #getInner} property. */
	private static final String INNER__XML_ATTR = "inner";

	@Override
	public String getXmlTagName() {
		return NOTE__XML_ELEMENT;
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
		if (hasTarget()) {
			out.writeStartElement(TARGET__XML_ATTR);
			getTarget().writeTo(out);
			out.writeEndElement();
		}
		if (hasInner()) {
			out.writeStartElement(INNER__XML_ATTR);
			getInner().writeContent(out);
			out.writeEndElement();
		}
	}

	/** Creates a new {@link test.nested.note.Note} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Note_Impl readNote_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		Note_Impl result = new Note_Impl();
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
			case TARGET__XML_ATTR: {
				in.nextTag();
				setTarget(test.nested.doc.impl.Doc_Impl.Sec_Impl.Item_Impl.readItem_XmlContent(in));
				internalSkipUntilMatchingEndElement(in);
				break;
			}
			case INNER__XML_ATTR: {
				setInner(test.nested.note.impl.Note_Impl.Inner_Impl.readInner_XmlContent(in));
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
