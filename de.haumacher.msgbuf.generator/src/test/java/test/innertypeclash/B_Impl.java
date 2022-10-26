package test.innertypeclash;

class B_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements B {
	static class C_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements C {

		/**
		 * Creates a {@link C_Impl} instance.
		 *
		 * @see C#create()
		 */
		protected C_Impl() {
			super();
		}

		protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

		@Override
		public C registerListener(de.haumacher.msgbuf.observer.Listener l) {
			internalRegisterListener(l);
			return this;
		}

		protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
			_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
		}

		@Override
		public C unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
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

		/** Helper for creating an object of type {@link C} from a polymorphic composition. */
		public static C readC_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			test.innertypeclash.B_Impl.C_Impl result = new C_Impl();
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

		/** XML element name representing a {@link C} type. */
		public static final String C__XML_ELEMENT = "c";

		/** Creates a new {@link C} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
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

	private A.C _ac = null;

	private B.C _bc = null;

	private C _c = null;

	/**
	 * Creates a {@link B_Impl} instance.
	 *
	 * @see B#create()
	 */
	protected B_Impl() {
		super();
	}

	@Override
	public final A.C getAc() {
		return _ac;
	}

	@Override
	public B setAc(A.C value) {
		internalSetAc(value);
		return this;
	}

	/** Internal setter for {@link #getAc()} without chain call utility. */
	protected final void internalSetAc(A.C value) {
		_listener.beforeSet(this, AC__PROP, value);
		_ac = value;
	}

	@Override
	public final boolean hasAc() {
		return _ac != null;
	}

	@Override
	public final B.C getBc() {
		return _bc;
	}

	@Override
	public B setBc(B.C value) {
		internalSetBc(value);
		return this;
	}

	/** Internal setter for {@link #getBc()} without chain call utility. */
	protected final void internalSetBc(B.C value) {
		_listener.beforeSet(this, BC__PROP, value);
		_bc = value;
	}

	@Override
	public final boolean hasBc() {
		return _bc != null;
	}

	@Override
	public final C getC() {
		return _c;
	}

	@Override
	public B setC(C value) {
		internalSetC(value);
		return this;
	}

	/** Internal setter for {@link #getC()} without chain call utility. */
	protected final void internalSetC(C value) {
		_listener.beforeSet(this, C__PROP, value);
		_c = value;
	}

	@Override
	public final boolean hasC() {
		return _c != null;
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public B registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public B unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		internalUnregisterListener(l);
		return this;
	}

	protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
	}

	@Override
	public String jsonType() {
		return B__TYPE;
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
			default: return B.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case AC__PROP: internalSetAc((A.C) value); break;
			case BC__PROP: internalSetBc((B.C) value); break;
			case C__PROP: internalSetC((C) value); break;
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
			case C__PROP: setC(test.innertypeclash.B.C.readC(in)); break;
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

	/** Helper for creating an object of type {@link B} from a polymorphic composition. */
	public static B readB_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.innertypeclash.B_Impl result = new B_Impl();
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
			case C__ID: setC(test.innertypeclash.B.C.readC(in)); break;
			default: in.skipValue(); 
		}
	}

	/** XML element name representing a {@link B} type. */
	public static final String B__XML_ELEMENT = "b";

	/** XML attribute or element name of a {@link #getAc} property. */
	private static final String AC__XML_ATTR = "ac";

	/** XML attribute or element name of a {@link #getBc} property. */
	private static final String BC__XML_ATTR = "bc";

	/** XML attribute or element name of a {@link #getC} property. */
	private static final String C__XML_ATTR = "c";

	/** Creates a new {@link B} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static B_Impl readB_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		B_Impl result = new B_Impl();
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
				setAc(test.innertypeclash.A_Impl.C_Impl.readC_XmlContent(in));
				break;
			}
			case BC__XML_ATTR: {
				setBc(test.innertypeclash.B_Impl.C_Impl.readC_XmlContent(in));
				break;
			}
			case C__XML_ATTR: {
				setC(test.innertypeclash.B_Impl.C_Impl.readC_XmlContent(in));
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
