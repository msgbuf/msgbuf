package test.nested.data.impl;

/**
 * Implementation of {@link test.nested.data.Zoo}.
 */
public class Zoo_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.nested.data.Zoo {
	/**
	 * Implementation of {@link test.nested.data.Zoo.Cat}.
	 */
	public static class Cat_Impl extends test.nested.data.impl.Animal_Impl implements test.nested.data.Zoo.Cat {

		private boolean _indoor = false;

		/**
		 * Creates a {@link Cat_Impl} instance.
		 *
		 * @see test.nested.data.Zoo.Cat#create()
		 */
		public Cat_Impl() {
			super();
		}

		@Override
		public TypeKind kind() {
			return TypeKind.CAT;
		}

		@Override
		public final boolean isIndoor() {
			return _indoor;
		}

		@Override
		public test.nested.data.Zoo.Cat setIndoor(boolean value) {
			internalSetIndoor(value);
			return this;
		}

		/** Internal setter for {@link #isIndoor()} without chain call utility. */
		protected final void internalSetIndoor(boolean value) {
			_listener.beforeSet(this, INDOOR__PROP, value);
			_indoor = value;
			_listener.afterChanged(this, INDOOR__PROP);
		}

		@Override
		public test.nested.data.Zoo.Cat setName(String value) {
			internalSetName(value);
			return this;
		}

		@Override
		public String jsonType() {
			return CAT__TYPE;
		}

		@SuppressWarnings("hiding")
		static final java.util.List<String> PROPERTIES;
		static {
			java.util.List<String> local = java.util.Arrays.asList(
				INDOOR__PROP);
			java.util.List<String> tmp = new java.util.ArrayList<>();
			tmp.addAll(test.nested.data.impl.Animal_Impl.PROPERTIES);
			tmp.addAll(local);
			PROPERTIES = java.util.Collections.unmodifiableList(tmp);
		}

		@SuppressWarnings("hiding")
		static final java.util.Set<String> TRANSIENT_PROPERTIES;
		static {
			java.util.HashSet<String> tmp = new java.util.HashSet<>();
			tmp.addAll(test.nested.data.impl.Animal_Impl.TRANSIENT_PROPERTIES);
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
				case INDOOR__PROP: return isIndoor();
				default: return super.get(field);
			}
		}

		@Override
		public void set(String field, Object value) {
			switch (field) {
				case INDOOR__PROP: internalSetIndoor((boolean) value); break;
				default: super.set(field, value); break;
			}
		}

		@Override
		protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
			super.writeFields(out);
			out.name(INDOOR__PROP);
			out.value(isIndoor());
		}

		@Override
		protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
			switch (field) {
				case INDOOR__PROP: setIndoor(in.nextBoolean()); break;
				default: super.readField(in, field);
			}
		}

		@Override
		public int typeId() {
			return CAT__TYPE_ID;
		}

		@Override
		protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
			super.writeFields(out);
			out.name(INDOOR__ID);
			out.value(isIndoor());
		}

		/** Helper for creating an object of type {@link test.nested.data.Zoo.Cat} from a polymorphic composition. */
		public static test.nested.data.Zoo.Cat readCat_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			test.nested.data.impl.Zoo_Impl.Cat_Impl result = new Cat_Impl();
			result.readContent(in);
			return result;
		}

		@Override
		protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
			switch (field) {
				case INDOOR__ID: setIndoor(in.nextBoolean()); break;
				default: super.readField(in, field);
			}
		}

		/** XML element name representing a {@link test.nested.data.Zoo.Cat} type. */
		public static final String CAT__XML_ELEMENT = "cat";

		/** XML attribute or element name of a {@link #isIndoor} property. */
		private static final String INDOOR__XML_ATTR = "indoor";

		@Override
		public String getXmlTagName() {
			return CAT__XML_ELEMENT;
		}

		/** Serializes all fields that are written as XML attributes. */
		@Override
		protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
			super.writeAttributes(out);
			out.writeAttribute(INDOOR__XML_ATTR, Boolean.toString(isIndoor()));
		}

		/** Serializes all fields that are written as XML elements. */
		@Override
		protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
			super.writeElements(out);
			// No element fields.
		}

		/** Creates a new {@link test.nested.data.Zoo.Cat} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Cat_Impl readCat_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			Cat_Impl result = new Cat_Impl();
			result.readContentXml(in);
			return result;
		}

		@Override
		protected void readFieldXmlAttribute(String name, String value) {
			switch (name) {
				case INDOOR__XML_ATTR: {
					setIndoor(Boolean.parseBoolean(value));
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
				case INDOOR__XML_ATTR: {
					setIndoor(Boolean.parseBoolean(in.getElementText()));
					break;
				}
				default: {
					super.readFieldXmlElement(in, localName);
				}
			}
		}

		@Override
		public <R,A,E extends Throwable> R visit(test.nested.data.Animal.Visitor<R,A,E> v, A arg) throws E {
			return v.visit(this, arg);
		}

	}
	/**
	 * Implementation of {@link test.nested.data.Zoo.Bird}.
	 */
	public static abstract class Bird_Impl extends test.nested.data.impl.Animal_Impl implements test.nested.data.Zoo.Bird {

		private double _wingspan = 0.0d;

		/**
		 * Creates a {@link Bird_Impl} instance.
		 */
		public Bird_Impl() {
			super();
		}

		@Override
		public final double getWingspan() {
			return _wingspan;
		}

		@Override
		public test.nested.data.Zoo.Bird setWingspan(double value) {
			internalSetWingspan(value);
			return this;
		}

		/** Internal setter for {@link #getWingspan()} without chain call utility. */
		protected final void internalSetWingspan(double value) {
			_listener.beforeSet(this, WINGSPAN__PROP, value);
			_wingspan = value;
			_listener.afterChanged(this, WINGSPAN__PROP);
		}

		@Override
		public test.nested.data.Zoo.Bird setName(String value) {
			internalSetName(value);
			return this;
		}

		@SuppressWarnings("hiding")
		static final java.util.List<String> PROPERTIES;
		static {
			java.util.List<String> local = java.util.Arrays.asList(
				WINGSPAN__PROP);
			java.util.List<String> tmp = new java.util.ArrayList<>();
			tmp.addAll(test.nested.data.impl.Animal_Impl.PROPERTIES);
			tmp.addAll(local);
			PROPERTIES = java.util.Collections.unmodifiableList(tmp);
		}

		@SuppressWarnings("hiding")
		static final java.util.Set<String> TRANSIENT_PROPERTIES;
		static {
			java.util.HashSet<String> tmp = new java.util.HashSet<>();
			tmp.addAll(test.nested.data.impl.Animal_Impl.TRANSIENT_PROPERTIES);
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
				case WINGSPAN__PROP: return getWingspan();
				default: return super.get(field);
			}
		}

		@Override
		public void set(String field, Object value) {
			switch (field) {
				case WINGSPAN__PROP: internalSetWingspan((double) value); break;
				default: super.set(field, value); break;
			}
		}

		@Override
		protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
			super.writeFields(out);
			out.name(WINGSPAN__PROP);
			out.value(getWingspan());
		}

		@Override
		protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
			switch (field) {
				case WINGSPAN__PROP: setWingspan(in.nextDouble()); break;
				default: super.readField(in, field);
			}
		}

		@Override
		protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
			super.writeFields(out);
			out.name(WINGSPAN__ID);
			out.value(getWingspan());
		}

		@Override
		protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
			switch (field) {
				case WINGSPAN__ID: setWingspan(in.nextDouble()); break;
				default: super.readField(in, field);
			}
		}

		/** XML element name representing a {@link test.nested.data.Zoo.Bird} type. */
		public static final String BIRD__XML_ELEMENT = "bird";

		/** XML attribute or element name of a {@link #getWingspan} property. */
		private static final String WINGSPAN__XML_ATTR = "wingspan";

		/** Serializes all fields that are written as XML attributes. */
		@Override
		protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
			super.writeAttributes(out);
			out.writeAttribute(WINGSPAN__XML_ATTR, Double.toString(getWingspan()));
		}

		/** Serializes all fields that are written as XML elements. */
		@Override
		protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
			super.writeElements(out);
			// No element fields.
		}

		/** Creates a new {@link test.nested.data.Zoo.Bird} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Bird_Impl readBird_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			switch (in.getLocalName()) {
				case test.nested.data.impl.Zoo_Impl.Parrot_Impl.PARROT__XML_ELEMENT: {
					return test.nested.data.impl.Zoo_Impl.Parrot_Impl.readParrot_XmlContent(in);
				}

				default: {
					internalSkipUntilMatchingEndElement(in);
					return null;
				}
			}
		}

		@Override
		protected void readFieldXmlAttribute(String name, String value) {
			switch (name) {
				case WINGSPAN__XML_ATTR: {
					setWingspan(Double.parseDouble(value));
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
				case WINGSPAN__XML_ATTR: {
					setWingspan(Double.parseDouble(in.getElementText()));
					break;
				}
				default: {
					super.readFieldXmlElement(in, localName);
				}
			}
		}

		@Override
		public final <R,A,E extends Throwable> R visit(test.nested.data.Animal.Visitor<R,A,E> v, A arg) throws E {
			return visit((test.nested.data.Zoo.Bird.Visitor<R,A,E>) v, arg);
		}

	}
	/**
	 * Implementation of {@link test.nested.data.Zoo.Parrot}.
	 */
	public static class Parrot_Impl extends test.nested.data.impl.Zoo_Impl.Bird_Impl implements test.nested.data.Zoo.Parrot {

		private final java.util.List<String> _words = new de.haumacher.msgbuf.util.ReferenceList<String>() {
			@Override
			protected void beforeAdd(int index, String element) {
				_listener.beforeAdd(Parrot_Impl.this, WORDS__PROP, index, element);
			}

			@Override
			protected void afterRemove(int index, String element) {
				_listener.afterRemove(Parrot_Impl.this, WORDS__PROP, index, element);
			}

			@Override
			protected void afterChanged() {
				_listener.afterChanged(Parrot_Impl.this, WORDS__PROP);
			}
		};

		/**
		 * Creates a {@link Parrot_Impl} instance.
		 *
		 * @see test.nested.data.Zoo.Parrot#create()
		 */
		public Parrot_Impl() {
			super();
		}

		@Override
		public TypeKind kind() {
			return TypeKind.PARROT;
		}

		@Override
		public final java.util.List<String> getWords() {
			return _words;
		}

		@Override
		public test.nested.data.Zoo.Parrot setWords(java.util.List<? extends String> value) {
			internalSetWords(value);
			return this;
		}

		/** Internal setter for {@link #getWords()} without chain call utility. */
		protected final void internalSetWords(java.util.List<? extends String> value) {
			_words.clear();
			_words.addAll(value);
		}

		@Override
		public test.nested.data.Zoo.Parrot addWord(String value) {
			internalAddWord(value);
			return this;
		}

		/** Implementation of {@link #addWord(String)} without chain call utility. */
		protected final void internalAddWord(String value) {
			_words.add(value);
		}

		@Override
		public final void removeWord(String value) {
			_words.remove(value);
		}

		@Override
		public test.nested.data.Zoo.Parrot setWingspan(double value) {
			internalSetWingspan(value);
			return this;
		}

		@Override
		public test.nested.data.Zoo.Parrot setName(String value) {
			internalSetName(value);
			return this;
		}

		@Override
		public String jsonType() {
			return PARROT__TYPE;
		}

		@SuppressWarnings("hiding")
		static final java.util.List<String> PROPERTIES;
		static {
			java.util.List<String> local = java.util.Arrays.asList(
				WORDS__PROP);
			java.util.List<String> tmp = new java.util.ArrayList<>();
			tmp.addAll(test.nested.data.impl.Zoo_Impl.Bird_Impl.PROPERTIES);
			tmp.addAll(local);
			PROPERTIES = java.util.Collections.unmodifiableList(tmp);
		}

		@SuppressWarnings("hiding")
		static final java.util.Set<String> TRANSIENT_PROPERTIES;
		static {
			java.util.HashSet<String> tmp = new java.util.HashSet<>();
			tmp.addAll(test.nested.data.impl.Zoo_Impl.Bird_Impl.TRANSIENT_PROPERTIES);
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
				case WORDS__PROP: return getWords();
				default: return super.get(field);
			}
		}

		@Override
		public void set(String field, Object value) {
			switch (field) {
				case WORDS__PROP: internalSetWords(de.haumacher.msgbuf.util.Conversions.asList(String.class, value)); break;
				default: super.set(field, value); break;
			}
		}

		@Override
		protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
			super.writeFields(out);
			out.name(WORDS__PROP);
			out.beginArray();
			for (String x : getWords()) {
				out.value(x);
			}
			out.endArray();
		}

		@Override
		protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
			switch (field) {
				case WORDS__PROP: {
					java.util.List<String> newValue = new java.util.ArrayList<>();
					in.beginArray();
					while (in.hasNext()) {
						newValue.add(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in));
					}
					in.endArray();
					setWords(newValue);
				}
				break;
				default: super.readField(in, field);
			}
		}

		@Override
		public int typeId() {
			return PARROT__TYPE_ID;
		}

		@Override
		protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
			super.writeFields(out);
			out.name(WORDS__ID);
			{
				java.util.List<String> values = getWords();
				out.beginArray(de.haumacher.msgbuf.binary.DataType.STRING, values.size());
				for (String x : values) {
					out.value(x);
				}
				out.endArray();
			}
		}

		/** Helper for creating an object of type {@link test.nested.data.Zoo.Parrot} from a polymorphic composition. */
		public static test.nested.data.Zoo.Parrot readParrot_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			test.nested.data.impl.Zoo_Impl.Parrot_Impl result = new Parrot_Impl();
			result.readContent(in);
			return result;
		}

		@Override
		protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
			switch (field) {
				case WORDS__ID: {
					in.beginArray();
					while (in.hasNext()) {
						addWord(in.nextString());
					}
					in.endArray();
				}
				break;
				default: super.readField(in, field);
			}
		}

		/** XML element name representing a {@link test.nested.data.Zoo.Parrot} type. */
		public static final String PARROT__XML_ELEMENT = "parrot";

		/** XML attribute or element name of a {@link #getWords} property. */
		private static final String WORDS__XML_ATTR = "words";

		@Override
		public String getXmlTagName() {
			return PARROT__XML_ELEMENT;
		}

		/** Serializes all fields that are written as XML attributes. */
		@Override
		protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
			super.writeAttributes(out);
			out.writeAttribute(WORDS__XML_ATTR, getWords().stream().map(x -> x).collect(java.util.stream.Collectors.joining(", ")));
		}

		/** Serializes all fields that are written as XML elements. */
		@Override
		protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
			super.writeElements(out);
			// No element fields.
		}

		/** Creates a new {@link test.nested.data.Zoo.Parrot} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Parrot_Impl readParrot_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			Parrot_Impl result = new Parrot_Impl();
			result.readContentXml(in);
			return result;
		}

		@Override
		protected void readFieldXmlAttribute(String name, String value) {
			switch (name) {
				case WORDS__XML_ATTR: {
					setWords(java.util.Arrays.stream(value.split("\\s*,\\s*")).map(x -> x).collect(java.util.stream.Collectors.toList()));
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
				case WORDS__XML_ATTR: {
					setWords(java.util.Arrays.stream(in.getElementText().split("\\s*,\\s*")).map(x -> x).collect(java.util.stream.Collectors.toList()));
					break;
				}
				default: {
					super.readFieldXmlElement(in, localName);
				}
			}
		}

		@Override
		public <R,A,E extends Throwable> R visit(test.nested.data.Zoo.Bird.Visitor<R,A,E> v, A arg) throws E {
			return v.visit(this, arg);
		}

	}

	private final java.util.List<test.nested.data.Animal> _animals = new de.haumacher.msgbuf.util.ReferenceList<test.nested.data.Animal>() {
		@Override
		protected void beforeAdd(int index, test.nested.data.Animal element) {
			_listener.beforeAdd(Zoo_Impl.this, ANIMALS__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, test.nested.data.Animal element) {
			_listener.afterRemove(Zoo_Impl.this, ANIMALS__PROP, index, element);
		}

		@Override
		protected void afterChanged() {
			_listener.afterChanged(Zoo_Impl.this, ANIMALS__PROP);
		}
	};

	/**
	 * Creates a {@link Zoo_Impl} instance.
	 *
	 * @see test.nested.data.Zoo#create()
	 */
	public Zoo_Impl() {
		super();
	}

	@Override
	public final java.util.List<test.nested.data.Animal> getAnimals() {
		return _animals;
	}

	@Override
	public test.nested.data.Zoo setAnimals(java.util.List<? extends test.nested.data.Animal> value) {
		internalSetAnimals(value);
		return this;
	}

	/** Internal setter for {@link #getAnimals()} without chain call utility. */
	protected final void internalSetAnimals(java.util.List<? extends test.nested.data.Animal> value) {
		if (value == null) throw new IllegalArgumentException("Property 'animals' cannot be null.");
		_animals.clear();
		_animals.addAll(value);
	}

	@Override
	public test.nested.data.Zoo addAnimal(test.nested.data.Animal value) {
		internalAddAnimal(value);
		return this;
	}

	/** Implementation of {@link #addAnimal(test.nested.data.Animal)} without chain call utility. */
	protected final void internalAddAnimal(test.nested.data.Animal value) {
		_animals.add(value);
	}

	@Override
	public final void removeAnimal(test.nested.data.Animal value) {
		_animals.remove(value);
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.nested.data.Zoo registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.nested.data.Zoo unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		internalUnregisterListener(l);
		return this;
	}

	protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
	}

	@Override
	public String jsonType() {
		return ZOO__TYPE;
	}

	static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			ANIMALS__PROP);
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
			case ANIMALS__PROP: return getAnimals();
			default: return test.nested.data.Zoo.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case ANIMALS__PROP: internalSetAnimals(de.haumacher.msgbuf.util.Conversions.asList(test.nested.data.Animal.class, value)); break;
		}
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(ANIMALS__PROP);
		out.beginArray();
		for (test.nested.data.Animal x : getAnimals()) {
			x.writeTo(out);
		}
		out.endArray();
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case ANIMALS__PROP: {
				java.util.List<test.nested.data.Animal> newValue = new java.util.ArrayList<>();
				in.beginArray();
				while (in.hasNext()) {
					newValue.add(test.nested.data.Animal.readAnimal(in));
				}
				in.endArray();
				setAnimals(newValue);
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
		out.name(ANIMALS__ID);
		{
			java.util.List<test.nested.data.Animal> values = getAnimals();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.OBJECT, values.size());
			for (test.nested.data.Animal x : values) {
				x.writeTo(out);
			}
			out.endArray();
		}
	}

	/** Helper for creating an object of type {@link test.nested.data.Zoo} from a polymorphic composition. */
	public static test.nested.data.Zoo readZoo_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.nested.data.impl.Zoo_Impl result = new Zoo_Impl();
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
			case ANIMALS__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addAnimal(test.nested.data.Animal.readAnimal(in));
				}
				in.endArray();
			}
			break;
			default: in.skipValue(); 
		}
	}

	/** XML element name representing a {@link test.nested.data.Zoo} type. */
	public static final String ZOO__XML_ELEMENT = "zoo";

	/** XML attribute or element name of a {@link #getAnimals} property. */
	private static final String ANIMALS__XML_ATTR = "animals";

	@Override
	public String getXmlTagName() {
		return ZOO__XML_ELEMENT;
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
		out.writeStartElement(ANIMALS__XML_ATTR);
		for (test.nested.data.Animal element : getAnimals()) {
			element.writeTo(out);
		}
		out.writeEndElement();
	}

	/** Creates a new {@link test.nested.data.Zoo} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Zoo_Impl readZoo_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		Zoo_Impl result = new Zoo_Impl();
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
			case ANIMALS__XML_ATTR: {
				internalReadAnimalsListXml(in);
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

	private void internalReadAnimalsListXml(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		while (true) {
			int event = in.nextTag();
			if (event == javax.xml.stream.XMLStreamConstants.END_ELEMENT) {
				break;
			}

			addAnimal(test.nested.data.impl.Animal_Impl.readAnimal_XmlContent(in));
		}
	}

}
