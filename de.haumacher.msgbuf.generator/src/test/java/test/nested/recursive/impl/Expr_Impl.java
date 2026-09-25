package test.nested.recursive.impl;

/**
 * Implementation of {@link test.nested.recursive.Expr}.
 */
public abstract class Expr_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.nested.recursive.Expr {
	/**
	 * Implementation of {@link test.nested.recursive.Expr.Literal}.
	 */
	public static class Literal_Impl extends test.nested.recursive.impl.Expr_Impl implements test.nested.recursive.Expr.Literal {

		private int _value = 0;

		/**
		 * Creates a {@link Literal_Impl} instance.
		 *
		 * @see test.nested.recursive.Expr.Literal#create()
		 */
		public Literal_Impl() {
			super();
		}

		@Override
		public TypeKind kind() {
			return TypeKind.LITERAL;
		}

		@Override
		public final int getValue() {
			return _value;
		}

		@Override
		public test.nested.recursive.Expr.Literal setValue(int value) {
			internalSetValue(value);
			return this;
		}

		/** Internal setter for {@link #getValue()} without chain call utility. */
		protected final void internalSetValue(int value) {
			_listener.beforeSet(this, VALUE__PROP, value);
			_value = value;
			_listener.afterChanged(this, VALUE__PROP);
		}

		@Override
		public test.nested.recursive.Expr.Literal setLabel(String value) {
			internalSetLabel(value);
			return this;
		}

		@Override
		public String jsonType() {
			return LITERAL__TYPE;
		}

		@SuppressWarnings("hiding")
		static final java.util.List<String> PROPERTIES;
		static {
			java.util.List<String> local = java.util.Arrays.asList(
				VALUE__PROP);
			java.util.List<String> tmp = new java.util.ArrayList<>();
			tmp.addAll(test.nested.recursive.impl.Expr_Impl.PROPERTIES);
			tmp.addAll(local);
			PROPERTIES = java.util.Collections.unmodifiableList(tmp);
		}

		@SuppressWarnings("hiding")
		static final java.util.Set<String> TRANSIENT_PROPERTIES;
		static {
			java.util.HashSet<String> tmp = new java.util.HashSet<>();
			tmp.addAll(test.nested.recursive.impl.Expr_Impl.TRANSIENT_PROPERTIES);
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
				case VALUE__PROP: return getValue();
				default: return super.get(field);
			}
		}

		@Override
		public void set(String field, Object value) {
			switch (field) {
				case VALUE__PROP: internalSetValue((int) value); break;
				default: super.set(field, value); break;
			}
		}

		@Override
		protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
			super.writeFields(out);
			out.name(VALUE__PROP);
			out.value(getValue());
		}

		@Override
		protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
			switch (field) {
				case VALUE__PROP: setValue(in.nextInt()); break;
				default: super.readField(in, field);
			}
		}

		@Override
		public int typeId() {
			return LITERAL__TYPE_ID;
		}

		@Override
		protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
			super.writeFields(out);
			out.name(VALUE__ID);
			out.value(getValue());
		}

		/** Helper for creating an object of type {@link test.nested.recursive.Expr.Literal} from a polymorphic composition. */
		public static test.nested.recursive.Expr.Literal readLiteral_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			test.nested.recursive.impl.Expr_Impl.Literal_Impl result = new Literal_Impl();
			result.readContent(in);
			return result;
		}

		@Override
		protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
			switch (field) {
				case VALUE__ID: setValue(in.nextInt()); break;
				default: super.readField(in, field);
			}
		}

		/** XML element name representing a {@link test.nested.recursive.Expr.Literal} type. */
		public static final String LITERAL__XML_ELEMENT = "literal";

		/** XML attribute or element name of a {@link #getValue} property. */
		private static final String VALUE__XML_ATTR = "value";

		@Override
		public String getXmlTagName() {
			return LITERAL__XML_ELEMENT;
		}

		/** Serializes all fields that are written as XML attributes. */
		@Override
		protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
			super.writeAttributes(out);
			out.writeAttribute(VALUE__XML_ATTR, Integer.toString(getValue()));
		}

		/** Serializes all fields that are written as XML elements. */
		@Override
		protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
			super.writeElements(out);
			// No element fields.
		}

		/** Creates a new {@link test.nested.recursive.Expr.Literal} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Literal_Impl readLiteral_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			Literal_Impl result = new Literal_Impl();
			result.readContentXml(in);
			return result;
		}

		@Override
		protected void readFieldXmlAttribute(String name, String value) {
			switch (name) {
				case VALUE__XML_ATTR: {
					setValue(Integer.parseInt(value));
					break;
				}
				default: {
					super.readFieldXmlAttribute(name, value);
				}
			}
		}

		@Override
		protected void readFieldXmlElement(javax.xml.stream.XMLStreamReader in, String localName) throws javax.xml.stream.XMLStreamException {
			switch (localName) {
				case VALUE__XML_ATTR: {
					setValue(Integer.parseInt(in.getElementText()));
					break;
				}
				default: {
					super.readFieldXmlElement(in, localName);
				}
			}
		}

		@Override
		public <R,A,E extends Throwable> R visit(test.nested.recursive.Expr.Visitor<R,A,E> v, A arg) throws E {
			return v.visit(this, arg);
		}

	}
	/**
	 * Implementation of {@link test.nested.recursive.Expr.Sum}.
	 */
	public static class Sum_Impl extends test.nested.recursive.impl.Expr_Impl implements test.nested.recursive.Expr.Sum {

		private final java.util.List<test.nested.recursive.Expr> _operands = new de.haumacher.msgbuf.util.ReferenceList<test.nested.recursive.Expr>() {
			@Override
			protected void beforeAdd(int index, test.nested.recursive.Expr element) {
				_listener.beforeAdd(Sum_Impl.this, OPERANDS__PROP, index, element);
			}

			@Override
			protected void afterRemove(int index, test.nested.recursive.Expr element) {
				_listener.afterRemove(Sum_Impl.this, OPERANDS__PROP, index, element);
			}

			@Override
			protected void afterChanged() {
				_listener.afterChanged(Sum_Impl.this, OPERANDS__PROP);
			}
		};

		private test.nested.recursive.Expr.Literal _first = null;

		/**
		 * Creates a {@link Sum_Impl} instance.
		 *
		 * @see test.nested.recursive.Expr.Sum#create()
		 */
		public Sum_Impl() {
			super();
		}

		@Override
		public TypeKind kind() {
			return TypeKind.SUM;
		}

		@Override
		public final java.util.List<test.nested.recursive.Expr> getOperands() {
			return _operands;
		}

		@Override
		public test.nested.recursive.Expr.Sum setOperands(java.util.List<? extends test.nested.recursive.Expr> value) {
			internalSetOperands(value);
			return this;
		}

		/** Internal setter for {@link #getOperands()} without chain call utility. */
		protected final void internalSetOperands(java.util.List<? extends test.nested.recursive.Expr> value) {
			if (value == null) throw new IllegalArgumentException("Property 'operands' cannot be null.");
			_operands.clear();
			_operands.addAll(value);
		}

		@Override
		public test.nested.recursive.Expr.Sum addOperand(test.nested.recursive.Expr value) {
			internalAddOperand(value);
			return this;
		}

		/** Implementation of {@link #addOperand(test.nested.recursive.Expr)} without chain call utility. */
		protected final void internalAddOperand(test.nested.recursive.Expr value) {
			_operands.add(value);
		}

		@Override
		public final void removeOperand(test.nested.recursive.Expr value) {
			_operands.remove(value);
		}

		@Override
		public final test.nested.recursive.Expr.Literal getFirst() {
			return _first;
		}

		@Override
		public test.nested.recursive.Expr.Sum setFirst(test.nested.recursive.Expr.Literal value) {
			internalSetFirst(value);
			return this;
		}

		/** Internal setter for {@link #getFirst()} without chain call utility. */
		protected final void internalSetFirst(test.nested.recursive.Expr.Literal value) {
			_listener.beforeSet(this, FIRST__PROP, value);
			_first = value;
			_listener.afterChanged(this, FIRST__PROP);
		}

		@Override
		public final boolean hasFirst() {
			return _first != null;
		}

		@Override
		public test.nested.recursive.Expr.Sum setLabel(String value) {
			internalSetLabel(value);
			return this;
		}

		@Override
		public String jsonType() {
			return SUM__TYPE;
		}

		@SuppressWarnings("hiding")
		static final java.util.List<String> PROPERTIES;
		static {
			java.util.List<String> local = java.util.Arrays.asList(
				OPERANDS__PROP, 
				FIRST__PROP);
			java.util.List<String> tmp = new java.util.ArrayList<>();
			tmp.addAll(test.nested.recursive.impl.Expr_Impl.PROPERTIES);
			tmp.addAll(local);
			PROPERTIES = java.util.Collections.unmodifiableList(tmp);
		}

		@SuppressWarnings("hiding")
		static final java.util.Set<String> TRANSIENT_PROPERTIES;
		static {
			java.util.HashSet<String> tmp = new java.util.HashSet<>();
			tmp.addAll(test.nested.recursive.impl.Expr_Impl.TRANSIENT_PROPERTIES);
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
				case OPERANDS__PROP: return getOperands();
				case FIRST__PROP: return getFirst();
				default: return super.get(field);
			}
		}

		@Override
		public void set(String field, Object value) {
			switch (field) {
				case OPERANDS__PROP: internalSetOperands(de.haumacher.msgbuf.util.Conversions.asList(test.nested.recursive.Expr.class, value)); break;
				case FIRST__PROP: internalSetFirst((test.nested.recursive.Expr.Literal) value); break;
				default: super.set(field, value); break;
			}
		}

		@Override
		protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
			super.writeFields(out);
			out.name(OPERANDS__PROP);
			out.beginArray();
			for (test.nested.recursive.Expr x : getOperands()) {
				x.writeTo(out);
			}
			out.endArray();
			if (hasFirst()) {
				out.name(FIRST__PROP);
				getFirst().writeContent(out);
			}
		}

		@Override
		protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
			switch (field) {
				case OPERANDS__PROP: {
					java.util.List<test.nested.recursive.Expr> newValue = new java.util.ArrayList<>();
					in.beginArray();
					while (in.hasNext()) {
						newValue.add(test.nested.recursive.Expr.readExpr(in));
					}
					in.endArray();
					setOperands(newValue);
				}
				break;
				case FIRST__PROP: setFirst(test.nested.recursive.Expr.Literal.readLiteral(in)); break;
				default: super.readField(in, field);
			}
		}

		@Override
		public int typeId() {
			return SUM__TYPE_ID;
		}

		@Override
		protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
			super.writeFields(out);
			out.name(OPERANDS__ID);
			{
				java.util.List<test.nested.recursive.Expr> values = getOperands();
				out.beginArray(de.haumacher.msgbuf.binary.DataType.OBJECT, values.size());
				for (test.nested.recursive.Expr x : values) {
					x.writeTo(out);
				}
				out.endArray();
			}
			if (hasFirst()) {
				out.name(FIRST__ID);
				getFirst().writeTo(out);
			}
		}

		/** Helper for creating an object of type {@link test.nested.recursive.Expr.Sum} from a polymorphic composition. */
		public static test.nested.recursive.Expr.Sum readSum_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			test.nested.recursive.impl.Expr_Impl.Sum_Impl result = new Sum_Impl();
			result.readContent(in);
			return result;
		}

		@Override
		protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
			switch (field) {
				case OPERANDS__ID: {
					in.beginArray();
					while (in.hasNext()) {
						addOperand(test.nested.recursive.Expr.readExpr(in));
					}
					in.endArray();
				}
				break;
				case FIRST__ID: setFirst(test.nested.recursive.Expr.Literal.readLiteral(in)); break;
				default: super.readField(in, field);
			}
		}

		/** XML element name representing a {@link test.nested.recursive.Expr.Sum} type. */
		public static final String SUM__XML_ELEMENT = "sum";

		/** XML attribute or element name of a {@link #getOperands} property. */
		private static final String OPERANDS__XML_ATTR = "operands";

		/** XML attribute or element name of a {@link #getFirst} property. */
		private static final String FIRST__XML_ATTR = "first";

		@Override
		public String getXmlTagName() {
			return SUM__XML_ELEMENT;
		}

		/** Serializes all fields that are written as XML attributes. */
		@Override
		protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
			super.writeAttributes(out);
		}

		/** Serializes all fields that are written as XML elements. */
		@Override
		protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
			super.writeElements(out);
			out.writeStartElement(OPERANDS__XML_ATTR);
			for (test.nested.recursive.Expr element : getOperands()) {
				element.writeTo(out);
			}
			out.writeEndElement();
			if (hasFirst()) {
				out.writeStartElement(FIRST__XML_ATTR);
				getFirst().writeContent(out);
				out.writeEndElement();
			}
		}

		/** Creates a new {@link test.nested.recursive.Expr.Sum} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Sum_Impl readSum_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			Sum_Impl result = new Sum_Impl();
			result.readContentXml(in);
			return result;
		}

		@Override
		protected void readFieldXmlAttribute(String name, String value) {
			switch (name) {
				default: {
					super.readFieldXmlAttribute(name, value);
				}
			}
		}

		@Override
		protected void readFieldXmlElement(javax.xml.stream.XMLStreamReader in, String localName) throws javax.xml.stream.XMLStreamException {
			switch (localName) {
				case OPERANDS__XML_ATTR: {
					internalReadOperandsListXml(in);
					break;
				}
				case FIRST__XML_ATTR: {
					setFirst(test.nested.recursive.impl.Expr_Impl.Literal_Impl.readLiteral_XmlContent(in));
					break;
				}
				default: {
					super.readFieldXmlElement(in, localName);
				}
			}
		}

		private void internalReadOperandsListXml(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			while (true) {
				int event = in.nextTag();
				if (event == javax.xml.stream.XMLStreamConstants.END_ELEMENT) {
					break;
				}

				addOperand(test.nested.recursive.impl.Expr_Impl.readExpr_XmlContent(in));
			}
		}

		@Override
		public <R,A,E extends Throwable> R visit(test.nested.recursive.Expr.Visitor<R,A,E> v, A arg) throws E {
			return v.visit(this, arg);
		}

	}

	private String _label = "";

	/**
	 * Creates a {@link Expr_Impl} instance.
	 */
	public Expr_Impl() {
		super();
	}

	@Override
	public final String getLabel() {
		return _label;
	}

	@Override
	public test.nested.recursive.Expr setLabel(String value) {
		internalSetLabel(value);
		return this;
	}

	/** Internal setter for {@link #getLabel()} without chain call utility. */
	protected final void internalSetLabel(String value) {
		_listener.beforeSet(this, LABEL__PROP, value);
		_label = value;
		_listener.afterChanged(this, LABEL__PROP);
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.nested.recursive.Expr registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.nested.recursive.Expr unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		internalUnregisterListener(l);
		return this;
	}

	protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
	}

	static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			LABEL__PROP);
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
			case LABEL__PROP: return getLabel();
			default: return test.nested.recursive.Expr.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case LABEL__PROP: internalSetLabel((String) value); break;
		}
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		out.beginArray();
		out.value(jsonType());
		writeContent(out);
		out.endArray();
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(LABEL__PROP);
		out.value(getLabel());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case LABEL__PROP: setLabel(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		out.beginObject();
		out.name(0);
		out.value(typeId());
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
		out.name(LABEL__ID);
		out.value(getLabel());
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
			case LABEL__ID: setLabel(in.nextString()); break;
			default: in.skipValue(); 
		}
	}

	/** XML element name representing a {@link test.nested.recursive.Expr} type. */
	public static final String EXPR__XML_ELEMENT = "expr";

	/** XML attribute or element name of a {@link #getLabel} property. */
	private static final String LABEL__XML_ATTR = "label";

	@Override
	public final void writeContent(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		writeAttributes(out);
		writeElements(out);
	}

	/** Serializes all fields that are written as XML attributes. */
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		out.writeAttribute(LABEL__XML_ATTR, getLabel());
	}

	/** Serializes all fields that are written as XML elements. */
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		// No element fields.
	}

	/** Creates a new {@link test.nested.recursive.Expr} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Expr_Impl readExpr_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		switch (in.getLocalName()) {
			case test.nested.recursive.impl.Expr_Impl.Literal_Impl.LITERAL__XML_ELEMENT: {
				return test.nested.recursive.impl.Expr_Impl.Literal_Impl.readLiteral_XmlContent(in);
			}

			case test.nested.recursive.impl.Expr_Impl.Sum_Impl.SUM__XML_ELEMENT: {
				return test.nested.recursive.impl.Expr_Impl.Sum_Impl.readSum_XmlContent(in);
			}

			default: {
				internalSkipUntilMatchingEndElement(in);
				return null;
			}
		}
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
			case LABEL__XML_ATTR: {
				setLabel(value);
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
			case LABEL__XML_ATTR: {
				setLabel(in.getElementText());
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
