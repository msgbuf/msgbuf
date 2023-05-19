package test.lowercasemessage.impl;

/**
 * Implementation of {@link test.lowercasemessage.A}.
 */
public class A_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.lowercasemessage.A {
	/**
	 * Implementation of {@link test.lowercasemessage.A.B}.
	 */
	public static class B_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.lowercasemessage.A.B {

		private test.lowercasemessage.A _a1 = null;

		private test.lowercasemessage.A.B _b1 = null;

		/**
		 * Creates a {@link B_Impl} instance.
		 *
		 * @see test.lowercasemessage.A.B#create()
		 */
		public B_Impl() {
			super();
		}

		@Override
		public final test.lowercasemessage.A getA1() {
			return _a1;
		}

		@Override
		public test.lowercasemessage.A.B setA1(test.lowercasemessage.A value) {
			internalSetA1(value);
			return this;
		}

		/** Internal setter for {@link #getA1()} without chain call utility. */
		protected final void internalSetA1(test.lowercasemessage.A value) {
			_listener.beforeSet(this, A_1__PROP, value);
			_a1 = value;
		}

		@Override
		public final boolean hasA1() {
			return _a1 != null;
		}

		@Override
		public final test.lowercasemessage.A.B getB1() {
			return _b1;
		}

		@Override
		public test.lowercasemessage.A.B setB1(test.lowercasemessage.A.B value) {
			internalSetB1(value);
			return this;
		}

		/** Internal setter for {@link #getB1()} without chain call utility. */
		protected final void internalSetB1(test.lowercasemessage.A.B value) {
			_listener.beforeSet(this, B_1__PROP, value);
			_b1 = value;
		}

		@Override
		public final boolean hasB1() {
			return _b1 != null;
		}

		protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

		@Override
		public test.lowercasemessage.A.B registerListener(de.haumacher.msgbuf.observer.Listener l) {
			internalRegisterListener(l);
			return this;
		}

		protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
			_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
		}

		@Override
		public test.lowercasemessage.A.B unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
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
				A_1__PROP, 
				B_1__PROP));

		@Override
		public java.util.List<String> properties() {
			return PROPERTIES;
		}

		@Override
		public Object get(String field) {
			switch (field) {
				case A_1__PROP: return getA1();
				case B_1__PROP: return getB1();
				default: return test.lowercasemessage.A.B.super.get(field);
			}
		}

		@Override
		public void set(String field, Object value) {
			switch (field) {
				case A_1__PROP: internalSetA1((test.lowercasemessage.A) value); break;
				case B_1__PROP: internalSetB1((test.lowercasemessage.A.B) value); break;
			}
		}

		@Override
		public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
			writeContent(out);
		}

		@Override
		protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
			super.writeFields(out);
			if (hasA1()) {
				out.name(A_1__PROP);
				getA1().writeTo(out);
			}
			if (hasB1()) {
				out.name(B_1__PROP);
				getB1().writeTo(out);
			}
		}

		@Override
		protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
			switch (field) {
				case A_1__PROP: setA1(test.lowercasemessage.A.reada(in)); break;
				case B_1__PROP: setB1(test.lowercasemessage.A.B.readb(in)); break;
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
			if (hasA1()) {
				out.name(A_1__ID);
				getA1().writeTo(out);
			}
			if (hasB1()) {
				out.name(B_1__ID);
				getB1().writeTo(out);
			}
		}

		/** Helper for creating an object of type {@link test.lowercasemessage.A.B} from a polymorphic composition. */
		public static test.lowercasemessage.A.B readb_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			test.lowercasemessage.impl.A_Impl.B_Impl result = new B_Impl();
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
				case A_1__ID: setA1(test.lowercasemessage.A.reada(in)); break;
				case B_1__ID: setB1(test.lowercasemessage.A.B.readb(in)); break;
				default: in.skipValue(); 
			}
		}

		/** XML element name representing a {@link test.lowercasemessage.A.B} type. */
		public static final String B__XML_ELEMENT = "b";

		/** XML attribute or element name of a {@link #getA1} property. */
		private static final String A_1__XML_ATTR = "a-1";

		/** XML attribute or element name of a {@link #getB1} property. */
		private static final String B_1__XML_ATTR = "b-1";

		@Override
		public String getXmlTagName() {
			return B__XML_ELEMENT;
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
			if (hasA1()) {
				out.writeStartElement(A_1__XML_ATTR);
				getA1().writeContent(out);
				out.writeEndElement();
			}
			if (hasB1()) {
				out.writeStartElement(B_1__XML_ATTR);
				getB1().writeContent(out);
				out.writeEndElement();
			}
		}

		/** Creates a new {@link test.lowercasemessage.A.B} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
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
				case A_1__XML_ATTR: {
					setA1(test.lowercasemessage.impl.A_Impl.readA_XmlContent(in));
					break;
				}
				case B_1__XML_ATTR: {
					setB1(test.lowercasemessage.impl.A_Impl.B_Impl.readB_XmlContent(in));
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

	private test.lowercasemessage.A _a1 = null;

	private test.lowercasemessage.A.B _b1 = null;

	/**
	 * Creates a {@link A_Impl} instance.
	 *
	 * @see test.lowercasemessage.A#create()
	 */
	public A_Impl() {
		super();
	}

	@Override
	public final test.lowercasemessage.A getA1() {
		return _a1;
	}

	@Override
	public test.lowercasemessage.A setA1(test.lowercasemessage.A value) {
		internalSetA1(value);
		return this;
	}

	/** Internal setter for {@link #getA1()} without chain call utility. */
	protected final void internalSetA1(test.lowercasemessage.A value) {
		_listener.beforeSet(this, A_1__PROP, value);
		_a1 = value;
	}

	@Override
	public final boolean hasA1() {
		return _a1 != null;
	}

	@Override
	public final test.lowercasemessage.A.B getB1() {
		return _b1;
	}

	@Override
	public test.lowercasemessage.A setB1(test.lowercasemessage.A.B value) {
		internalSetB1(value);
		return this;
	}

	/** Internal setter for {@link #getB1()} without chain call utility. */
	protected final void internalSetB1(test.lowercasemessage.A.B value) {
		_listener.beforeSet(this, B_1__PROP, value);
		_b1 = value;
	}

	@Override
	public final boolean hasB1() {
		return _b1 != null;
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.lowercasemessage.A registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.lowercasemessage.A unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
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
			A_1__PROP, 
			B_1__PROP));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case A_1__PROP: return getA1();
			case B_1__PROP: return getB1();
			default: return test.lowercasemessage.A.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case A_1__PROP: internalSetA1((test.lowercasemessage.A) value); break;
			case B_1__PROP: internalSetB1((test.lowercasemessage.A.B) value); break;
		}
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		if (hasA1()) {
			out.name(A_1__PROP);
			getA1().writeTo(out);
		}
		if (hasB1()) {
			out.name(B_1__PROP);
			getB1().writeTo(out);
		}
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case A_1__PROP: setA1(test.lowercasemessage.A.reada(in)); break;
			case B_1__PROP: setB1(test.lowercasemessage.A.B.readb(in)); break;
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
		if (hasA1()) {
			out.name(A_1__ID);
			getA1().writeTo(out);
		}
		if (hasB1()) {
			out.name(B_1__ID);
			getB1().writeTo(out);
		}
	}

	/** Helper for creating an object of type {@link test.lowercasemessage.A} from a polymorphic composition. */
	public static test.lowercasemessage.A reada_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.lowercasemessage.impl.A_Impl result = new A_Impl();
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
			case A_1__ID: setA1(test.lowercasemessage.A.reada(in)); break;
			case B_1__ID: setB1(test.lowercasemessage.A.B.readb(in)); break;
			default: in.skipValue(); 
		}
	}

	/** XML element name representing a {@link test.lowercasemessage.A} type. */
	public static final String A__XML_ELEMENT = "a";

	/** XML attribute or element name of a {@link #getA1} property. */
	private static final String A_1__XML_ATTR = "a-1";

	/** XML attribute or element name of a {@link #getB1} property. */
	private static final String B_1__XML_ATTR = "b-1";

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
		if (hasA1()) {
			out.writeStartElement(A_1__XML_ATTR);
			getA1().writeContent(out);
			out.writeEndElement();
		}
		if (hasB1()) {
			out.writeStartElement(B_1__XML_ATTR);
			getB1().writeContent(out);
			out.writeEndElement();
		}
	}

	/** Creates a new {@link test.lowercasemessage.A} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
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
			case A_1__XML_ATTR: {
				setA1(test.lowercasemessage.impl.A_Impl.readA_XmlContent(in));
				break;
			}
			case B_1__XML_ATTR: {
				setB1(test.lowercasemessage.impl.A_Impl.B_Impl.readB_XmlContent(in));
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
