package test.innertypeclash.impl;

/**
 * Implementation of {@link test.innertypeclash.A}.
 */
public class A_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.innertypeclash.A {
	/**
	 * Implementation of {@link test.innertypeclash.A.C}.
	 */
	public static class C_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.innertypeclash.A.C {

		/**
		 * Creates a {@link C_Impl} instance.
		 *
		 * @see test.innertypeclash.A.C#create()
		 */
		public C_Impl() {
			super();
		}

		protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

		@Override
		public test.innertypeclash.A.C registerListener(de.haumacher.msgbuf.observer.Listener l) {
			internalRegisterListener(l);
			return this;
		}

		protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
			_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
		}

		@Override
		public test.innertypeclash.A.C unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
			internalUnregisterListener(l);
			return this;
		}

		protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
			_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
		}

		@Override
		public String jsonType() {
			return C__TYPE;
		}

		@Override
		public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
			writeContent(out);
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
			// No fields to write, hook for subclasses.
		}

		/** Helper for creating an object of type {@link test.innertypeclash.A.C} from a polymorphic composition. */
		public static test.innertypeclash.A.C readC_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			test.innertypeclash.impl.A_Impl.C_Impl result = new C_Impl();
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
				default: in.skipValue(); 
			}
		}

		/** XML element name representing a {@link test.innertypeclash.A.C} type. */
		public static final String C__XML_ELEMENT = "c";

		@Override
		public String getXmlTagName() {
			return C__XML_ELEMENT;
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

		/** Creates a new {@link test.innertypeclash.A.C} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static C_Impl readC_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			C_Impl result = new C_Impl();
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

	private test.innertypeclash.A.C _ac = null;

	private test.innertypeclash.B.C _bc = null;

	private test.innertypeclash.A.C _c = null;

	/**
	 * Creates a {@link A_Impl} instance.
	 *
	 * @see test.innertypeclash.A#create()
	 */
	public A_Impl() {
		super();
	}

	@Override
	public final test.innertypeclash.A.C getAc() {
		return _ac;
	}

	@Override
	public test.innertypeclash.A setAc(test.innertypeclash.A.C value) {
		internalSetAc(value);
		return this;
	}

	/** Internal setter for {@link #getAc()} without chain call utility. */
	protected final void internalSetAc(test.innertypeclash.A.C value) {
		_listener.beforeSet(this, AC__PROP, value);
		_ac = value;
	}

	@Override
	public final boolean hasAc() {
		return _ac != null;
	}

	@Override
	public final test.innertypeclash.B.C getBc() {
		return _bc;
	}

	@Override
	public test.innertypeclash.A setBc(test.innertypeclash.B.C value) {
		internalSetBc(value);
		return this;
	}

	/** Internal setter for {@link #getBc()} without chain call utility. */
	protected final void internalSetBc(test.innertypeclash.B.C value) {
		_listener.beforeSet(this, BC__PROP, value);
		_bc = value;
	}

	@Override
	public final boolean hasBc() {
		return _bc != null;
	}

	@Override
	public final test.innertypeclash.A.C getC() {
		return _c;
	}

	@Override
	public test.innertypeclash.A setC(test.innertypeclash.A.C value) {
		internalSetC(value);
		return this;
	}

	/** Internal setter for {@link #getC()} without chain call utility. */
	protected final void internalSetC(test.innertypeclash.A.C value) {
		_listener.beforeSet(this, C__PROP, value);
		_c = value;
	}

	@Override
	public final boolean hasC() {
		return _c != null;
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.innertypeclash.A registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.innertypeclash.A unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
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
			AC__PROP, 
			BC__PROP, 
			C__PROP));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case AC__PROP: return getAc();
			case BC__PROP: return getBc();
			case C__PROP: return getC();
			default: return test.innertypeclash.A.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case AC__PROP: internalSetAc((test.innertypeclash.A.C) value); break;
			case BC__PROP: internalSetBc((test.innertypeclash.B.C) value); break;
			case C__PROP: internalSetC((test.innertypeclash.A.C) value); break;
		}
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		if (hasAc()) {
			out.name(AC__PROP);
			getAc().writeTo(out);
		}
		if (hasBc()) {
			out.name(BC__PROP);
			getBc().writeTo(out);
		}
		if (hasC()) {
			out.name(C__PROP);
			getC().writeTo(out);
		}
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case AC__PROP: setAc(test.innertypeclash.A.C.readC(in)); break;
			case BC__PROP: setBc(test.innertypeclash.B.C.readC(in)); break;
			case C__PROP: setC(test.innertypeclash.A.C.readC(in)); break;
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
		if (hasAc()) {
			out.name(AC__ID);
			getAc().writeTo(out);
		}
		if (hasBc()) {
			out.name(BC__ID);
			getBc().writeTo(out);
		}
		if (hasC()) {
			out.name(C__ID);
			getC().writeTo(out);
		}
	}

	/** Helper for creating an object of type {@link test.innertypeclash.A} from a polymorphic composition. */
	public static test.innertypeclash.A readA_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.innertypeclash.impl.A_Impl result = new A_Impl();
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
			case AC__ID: setAc(test.innertypeclash.A.C.readC(in)); break;
			case BC__ID: setBc(test.innertypeclash.B.C.readC(in)); break;
			case C__ID: setC(test.innertypeclash.A.C.readC(in)); break;
			default: in.skipValue(); 
		}
	}

	/** XML element name representing a {@link test.innertypeclash.A} type. */
	public static final String A__XML_ELEMENT = "a";

	/** XML attribute or element name of a {@link #getAc} property. */
	private static final String AC__XML_ATTR = "ac";

	/** XML attribute or element name of a {@link #getBc} property. */
	private static final String BC__XML_ATTR = "bc";

	/** XML attribute or element name of a {@link #getC} property. */
	private static final String C__XML_ATTR = "c";

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
	}

	/** Serializes all fields that are written as XML elements. */
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		if (hasAc()) {
			out.writeStartElement(AC__XML_ATTR);
			getAc().writeContent(out);
			out.writeEndElement();
		}
		if (hasBc()) {
			out.writeStartElement(BC__XML_ATTR);
			getBc().writeContent(out);
			out.writeEndElement();
		}
		if (hasC()) {
			out.writeStartElement(C__XML_ATTR);
			getC().writeContent(out);
			out.writeEndElement();
		}
	}

	/** Creates a new {@link test.innertypeclash.A} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
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
			default: {
				// Skip unknown attribute.
			}
		}
	}

	/** Reads the element under the cursor and assigns its contents to the field with the given name. */
	protected void readFieldXmlElement(javax.xml.stream.XMLStreamReader in, String localName) throws javax.xml.stream.XMLStreamException {
		switch (localName) {
			case AC__XML_ATTR: {
				setAc(test.innertypeclash.impl.A_Impl.C_Impl.readC_XmlContent(in));
				break;
			}
			case BC__XML_ATTR: {
				setBc(test.innertypeclash.impl.B_Impl.C_Impl.readC_XmlContent(in));
				break;
			}
			case C__XML_ATTR: {
				setC(test.innertypeclash.impl.A_Impl.C_Impl.readC_XmlContent(in));
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
