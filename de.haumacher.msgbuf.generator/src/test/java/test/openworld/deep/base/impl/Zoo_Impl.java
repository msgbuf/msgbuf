package test.openworld.deep.base.impl;

/**
 * Implementation of {@link test.openworld.deep.base.Zoo}.
 */
public class Zoo_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.openworld.deep.base.Zoo {
	/**
	 * Implementation of {@link test.openworld.deep.base.Zoo.Aviary}.
	 */
	public static class Aviary_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.openworld.deep.base.Zoo.Aviary {

		private test.openworld.deep.base.Bird _boss = null;

		private final java.util.List<test.openworld.deep.base.Bird> _residents = new de.haumacher.msgbuf.util.ReferenceList<test.openworld.deep.base.Bird>() {
			@Override
			protected void beforeAdd(int index, test.openworld.deep.base.Bird element) {
				_listener.beforeAdd(Aviary_Impl.this, RESIDENTS__PROP, index, element);
			}

			@Override
			protected void afterRemove(int index, test.openworld.deep.base.Bird element) {
				_listener.afterRemove(Aviary_Impl.this, RESIDENTS__PROP, index, element);
			}

			@Override
			protected void afterChanged() {
				_listener.afterChanged(Aviary_Impl.this, RESIDENTS__PROP);
			}
		};

		/**
		 * Creates a {@link Aviary_Impl} instance.
		 *
		 * @see test.openworld.deep.base.Zoo.Aviary#create()
		 */
		public Aviary_Impl() {
			super();
		}

		@Override
		public final test.openworld.deep.base.Bird getBoss() {
			return _boss;
		}

		@Override
		public test.openworld.deep.base.Zoo.Aviary setBoss(test.openworld.deep.base.Bird value) {
			internalSetBoss(value);
			return this;
		}

		/** Internal setter for {@link #getBoss()} without chain call utility. */
		protected final void internalSetBoss(test.openworld.deep.base.Bird value) {
			_listener.beforeSet(this, BOSS__PROP, value);
			_boss = value;
			_listener.afterChanged(this, BOSS__PROP);
		}

		@Override
		public final boolean hasBoss() {
			return _boss != null;
		}

		@Override
		public final java.util.List<test.openworld.deep.base.Bird> getResidents() {
			return _residents;
		}

		@Override
		public test.openworld.deep.base.Zoo.Aviary setResidents(java.util.List<? extends test.openworld.deep.base.Bird> value) {
			internalSetResidents(value);
			return this;
		}

		/** Internal setter for {@link #getResidents()} without chain call utility. */
		protected final void internalSetResidents(java.util.List<? extends test.openworld.deep.base.Bird> value) {
			if (value == null) throw new IllegalArgumentException("Property 'residents' cannot be null.");
			_residents.clear();
			_residents.addAll(value);
		}

		@Override
		public test.openworld.deep.base.Zoo.Aviary addResident(test.openworld.deep.base.Bird value) {
			internalAddResident(value);
			return this;
		}

		/** Implementation of {@link #addResident(test.openworld.deep.base.Bird)} without chain call utility. */
		protected final void internalAddResident(test.openworld.deep.base.Bird value) {
			_residents.add(value);
		}

		@Override
		public final void removeResident(test.openworld.deep.base.Bird value) {
			_residents.remove(value);
		}

		protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

		@Override
		public test.openworld.deep.base.Zoo.Aviary registerListener(de.haumacher.msgbuf.observer.Listener l) {
			internalRegisterListener(l);
			return this;
		}

		protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
			_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
		}

		@Override
		public test.openworld.deep.base.Zoo.Aviary unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
			internalUnregisterListener(l);
			return this;
		}

		protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
			_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
		}

		@Override
		public String jsonType() {
			return AVIARY__TYPE;
		}

		protected static final java.util.List<String> PROPERTIES;
		static {
			java.util.List<String> local = java.util.Arrays.asList(
				BOSS__PROP, 
				RESIDENTS__PROP);
			PROPERTIES = java.util.Collections.unmodifiableList(local);
		}

		protected static final java.util.Set<String> TRANSIENT_PROPERTIES;
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
				case BOSS__PROP: return getBoss();
				case RESIDENTS__PROP: return getResidents();
				default: return test.openworld.deep.base.Zoo.Aviary.super.get(field);
			}
		}

		@Override
		public void set(String field, Object value) {
			switch (field) {
				case BOSS__PROP: internalSetBoss((test.openworld.deep.base.Bird) value); break;
				case RESIDENTS__PROP: internalSetResidents(de.haumacher.msgbuf.util.Conversions.asList(test.openworld.deep.base.Bird.class, value)); break;
			}
		}

		@Override
		public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
			writeContent(out);
		}

		@Override
		protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
			super.writeFields(out);
			if (hasBoss()) {
				out.name(BOSS__PROP);
				getBoss().writeTo(out);
			}
			out.name(RESIDENTS__PROP);
			out.beginArray();
			for (test.openworld.deep.base.Bird x : getResidents()) {
				x.writeTo(out);
			}
			out.endArray();
		}

		@Override
		protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
			switch (field) {
				case BOSS__PROP: setBoss(test.openworld.deep.base.Bird.readBird(in)); break;
				case RESIDENTS__PROP: {
					java.util.List<test.openworld.deep.base.Bird> newValue = new java.util.ArrayList<>();
					in.beginArray();
					while (in.hasNext()) {
						newValue.add(test.openworld.deep.base.Bird.readBird(in));
					}
					in.endArray();
					setResidents(newValue);
				}
				break;
				default: super.readField(in, field);
			}
		}

		/** XML element name representing a {@link test.openworld.deep.base.Zoo.Aviary} type. */
		public static final String AVIARY__XML_ELEMENT = "aviary";

		/** XML attribute or element name of a {@link #getBoss} property. */
		private static final String BOSS__XML_ATTR = "boss";

		/** XML attribute or element name of a {@link #getResidents} property. */
		private static final String RESIDENTS__XML_ATTR = "residents";

		@Override
		public String getXmlTagName() {
			return AVIARY__XML_ELEMENT;
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
			if (hasBoss()) {
				out.writeStartElement(BOSS__XML_ATTR);
				getBoss().writeTo(out);
				out.writeEndElement();
			}
			out.writeStartElement(RESIDENTS__XML_ATTR);
			for (test.openworld.deep.base.Bird element : getResidents()) {
				element.writeTo(out);
			}
			out.writeEndElement();
		}

		/** Creates a new {@link test.openworld.deep.base.Zoo.Aviary} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Aviary_Impl readAviary_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			Aviary_Impl result = new Aviary_Impl();
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
				case BOSS__XML_ATTR: {
					in.nextTag();
					setBoss(test.openworld.deep.base.impl.Bird_Impl.readBird_XmlContent(in));
					internalSkipUntilMatchingEndElement(in);
					break;
				}
				case RESIDENTS__XML_ATTR: {
					internalReadResidentsListXml(in);
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

		private void internalReadResidentsListXml(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			while (true) {
				int event = in.nextTag();
				if (event == javax.xml.stream.XMLStreamConstants.END_ELEMENT) {
					break;
				}

				addResident(test.openworld.deep.base.impl.Bird_Impl.readBird_XmlContent(in));
			}
		}

	}

	private test.openworld.deep.base.Animal _star = null;

	private final java.util.List<test.openworld.deep.base.Animal> _animals = new de.haumacher.msgbuf.util.ReferenceList<test.openworld.deep.base.Animal>() {
		@Override
		protected void beforeAdd(int index, test.openworld.deep.base.Animal element) {
			_listener.beforeAdd(Zoo_Impl.this, ANIMALS__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, test.openworld.deep.base.Animal element) {
			_listener.afterRemove(Zoo_Impl.this, ANIMALS__PROP, index, element);
		}

		@Override
		protected void afterChanged() {
			_listener.afterChanged(Zoo_Impl.this, ANIMALS__PROP);
		}
	};

	private test.openworld.deep.base.Bird _favorite = null;

	private final java.util.List<test.openworld.deep.base.Bird> _birds = new de.haumacher.msgbuf.util.ReferenceList<test.openworld.deep.base.Bird>() {
		@Override
		protected void beforeAdd(int index, test.openworld.deep.base.Bird element) {
			_listener.beforeAdd(Zoo_Impl.this, BIRDS__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, test.openworld.deep.base.Bird element) {
			_listener.afterRemove(Zoo_Impl.this, BIRDS__PROP, index, element);
		}

		@Override
		protected void afterChanged() {
			_listener.afterChanged(Zoo_Impl.this, BIRDS__PROP);
		}
	};

	private test.openworld.deep.base.Zoo.Aviary _aviary = null;

	/**
	 * Creates a {@link Zoo_Impl} instance.
	 *
	 * @see test.openworld.deep.base.Zoo#create()
	 */
	public Zoo_Impl() {
		super();
	}

	@Override
	public final test.openworld.deep.base.Animal getStar() {
		return _star;
	}

	@Override
	public test.openworld.deep.base.Zoo setStar(test.openworld.deep.base.Animal value) {
		internalSetStar(value);
		return this;
	}

	/** Internal setter for {@link #getStar()} without chain call utility. */
	protected final void internalSetStar(test.openworld.deep.base.Animal value) {
		_listener.beforeSet(this, STAR__PROP, value);
		_star = value;
		_listener.afterChanged(this, STAR__PROP);
	}

	@Override
	public final boolean hasStar() {
		return _star != null;
	}

	@Override
	public final java.util.List<test.openworld.deep.base.Animal> getAnimals() {
		return _animals;
	}

	@Override
	public test.openworld.deep.base.Zoo setAnimals(java.util.List<? extends test.openworld.deep.base.Animal> value) {
		internalSetAnimals(value);
		return this;
	}

	/** Internal setter for {@link #getAnimals()} without chain call utility. */
	protected final void internalSetAnimals(java.util.List<? extends test.openworld.deep.base.Animal> value) {
		if (value == null) throw new IllegalArgumentException("Property 'animals' cannot be null.");
		_animals.clear();
		_animals.addAll(value);
	}

	@Override
	public test.openworld.deep.base.Zoo addAnimal(test.openworld.deep.base.Animal value) {
		internalAddAnimal(value);
		return this;
	}

	/** Implementation of {@link #addAnimal(test.openworld.deep.base.Animal)} without chain call utility. */
	protected final void internalAddAnimal(test.openworld.deep.base.Animal value) {
		_animals.add(value);
	}

	@Override
	public final void removeAnimal(test.openworld.deep.base.Animal value) {
		_animals.remove(value);
	}

	@Override
	public final test.openworld.deep.base.Bird getFavorite() {
		return _favorite;
	}

	@Override
	public test.openworld.deep.base.Zoo setFavorite(test.openworld.deep.base.Bird value) {
		internalSetFavorite(value);
		return this;
	}

	/** Internal setter for {@link #getFavorite()} without chain call utility. */
	protected final void internalSetFavorite(test.openworld.deep.base.Bird value) {
		_listener.beforeSet(this, FAVORITE__PROP, value);
		_favorite = value;
		_listener.afterChanged(this, FAVORITE__PROP);
	}

	@Override
	public final boolean hasFavorite() {
		return _favorite != null;
	}

	@Override
	public final java.util.List<test.openworld.deep.base.Bird> getBirds() {
		return _birds;
	}

	@Override
	public test.openworld.deep.base.Zoo setBirds(java.util.List<? extends test.openworld.deep.base.Bird> value) {
		internalSetBirds(value);
		return this;
	}

	/** Internal setter for {@link #getBirds()} without chain call utility. */
	protected final void internalSetBirds(java.util.List<? extends test.openworld.deep.base.Bird> value) {
		if (value == null) throw new IllegalArgumentException("Property 'birds' cannot be null.");
		_birds.clear();
		_birds.addAll(value);
	}

	@Override
	public test.openworld.deep.base.Zoo addBird(test.openworld.deep.base.Bird value) {
		internalAddBird(value);
		return this;
	}

	/** Implementation of {@link #addBird(test.openworld.deep.base.Bird)} without chain call utility. */
	protected final void internalAddBird(test.openworld.deep.base.Bird value) {
		_birds.add(value);
	}

	@Override
	public final void removeBird(test.openworld.deep.base.Bird value) {
		_birds.remove(value);
	}

	@Override
	public final test.openworld.deep.base.Zoo.Aviary getAviary() {
		return _aviary;
	}

	@Override
	public test.openworld.deep.base.Zoo setAviary(test.openworld.deep.base.Zoo.Aviary value) {
		internalSetAviary(value);
		return this;
	}

	/** Internal setter for {@link #getAviary()} without chain call utility. */
	protected final void internalSetAviary(test.openworld.deep.base.Zoo.Aviary value) {
		_listener.beforeSet(this, AVIARY__PROP, value);
		_aviary = value;
		_listener.afterChanged(this, AVIARY__PROP);
	}

	@Override
	public final boolean hasAviary() {
		return _aviary != null;
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.openworld.deep.base.Zoo registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.openworld.deep.base.Zoo unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
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

	protected static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			STAR__PROP, 
			ANIMALS__PROP, 
			FAVORITE__PROP, 
			BIRDS__PROP, 
			AVIARY__PROP);
		PROPERTIES = java.util.Collections.unmodifiableList(local);
	}

	protected static final java.util.Set<String> TRANSIENT_PROPERTIES;
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
			case STAR__PROP: return getStar();
			case ANIMALS__PROP: return getAnimals();
			case FAVORITE__PROP: return getFavorite();
			case BIRDS__PROP: return getBirds();
			case AVIARY__PROP: return getAviary();
			default: return test.openworld.deep.base.Zoo.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case STAR__PROP: internalSetStar((test.openworld.deep.base.Animal) value); break;
			case ANIMALS__PROP: internalSetAnimals(de.haumacher.msgbuf.util.Conversions.asList(test.openworld.deep.base.Animal.class, value)); break;
			case FAVORITE__PROP: internalSetFavorite((test.openworld.deep.base.Bird) value); break;
			case BIRDS__PROP: internalSetBirds(de.haumacher.msgbuf.util.Conversions.asList(test.openworld.deep.base.Bird.class, value)); break;
			case AVIARY__PROP: internalSetAviary((test.openworld.deep.base.Zoo.Aviary) value); break;
		}
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		if (hasStar()) {
			out.name(STAR__PROP);
			getStar().writeTo(out);
		}
		out.name(ANIMALS__PROP);
		out.beginArray();
		for (test.openworld.deep.base.Animal x : getAnimals()) {
			x.writeTo(out);
		}
		out.endArray();
		if (hasFavorite()) {
			out.name(FAVORITE__PROP);
			getFavorite().writeTo(out);
		}
		out.name(BIRDS__PROP);
		out.beginArray();
		for (test.openworld.deep.base.Bird x : getBirds()) {
			x.writeTo(out);
		}
		out.endArray();
		if (hasAviary()) {
			out.name(AVIARY__PROP);
			getAviary().writeTo(out);
		}
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case STAR__PROP: setStar(test.openworld.deep.base.Animal.readAnimal(in)); break;
			case ANIMALS__PROP: {
				java.util.List<test.openworld.deep.base.Animal> newValue = new java.util.ArrayList<>();
				in.beginArray();
				while (in.hasNext()) {
					newValue.add(test.openworld.deep.base.Animal.readAnimal(in));
				}
				in.endArray();
				setAnimals(newValue);
			}
			break;
			case FAVORITE__PROP: setFavorite(test.openworld.deep.base.Bird.readBird(in)); break;
			case BIRDS__PROP: {
				java.util.List<test.openworld.deep.base.Bird> newValue = new java.util.ArrayList<>();
				in.beginArray();
				while (in.hasNext()) {
					newValue.add(test.openworld.deep.base.Bird.readBird(in));
				}
				in.endArray();
				setBirds(newValue);
			}
			break;
			case AVIARY__PROP: setAviary(test.openworld.deep.base.Zoo.Aviary.readAviary(in)); break;
			default: super.readField(in, field);
		}
	}

	/** XML element name representing a {@link test.openworld.deep.base.Zoo} type. */
	public static final String ZOO__XML_ELEMENT = "zoo";

	/** XML attribute or element name of a {@link #getStar} property. */
	private static final String STAR__XML_ATTR = "star";

	/** XML attribute or element name of a {@link #getAnimals} property. */
	private static final String ANIMALS__XML_ATTR = "animals";

	/** XML attribute or element name of a {@link #getFavorite} property. */
	private static final String FAVORITE__XML_ATTR = "favorite";

	/** XML attribute or element name of a {@link #getBirds} property. */
	private static final String BIRDS__XML_ATTR = "birds";

	/** XML attribute or element name of a {@link #getAviary} property. */
	private static final String AVIARY__XML_ATTR = "aviary";

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
		if (hasStar()) {
			out.writeStartElement(STAR__XML_ATTR);
			getStar().writeTo(out);
			out.writeEndElement();
		}
		out.writeStartElement(ANIMALS__XML_ATTR);
		for (test.openworld.deep.base.Animal element : getAnimals()) {
			element.writeTo(out);
		}
		out.writeEndElement();
		if (hasFavorite()) {
			out.writeStartElement(FAVORITE__XML_ATTR);
			getFavorite().writeTo(out);
			out.writeEndElement();
		}
		out.writeStartElement(BIRDS__XML_ATTR);
		for (test.openworld.deep.base.Bird element : getBirds()) {
			element.writeTo(out);
		}
		out.writeEndElement();
		if (hasAviary()) {
			out.writeStartElement(AVIARY__XML_ATTR);
			getAviary().writeContent(out);
			out.writeEndElement();
		}
	}

	/** Creates a new {@link test.openworld.deep.base.Zoo} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
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
			case STAR__XML_ATTR: {
				in.nextTag();
				setStar(test.openworld.deep.base.impl.Animal_Impl.readAnimal_XmlContent(in));
				internalSkipUntilMatchingEndElement(in);
				break;
			}
			case ANIMALS__XML_ATTR: {
				internalReadAnimalsListXml(in);
				break;
			}
			case FAVORITE__XML_ATTR: {
				in.nextTag();
				setFavorite(test.openworld.deep.base.impl.Bird_Impl.readBird_XmlContent(in));
				internalSkipUntilMatchingEndElement(in);
				break;
			}
			case BIRDS__XML_ATTR: {
				internalReadBirdsListXml(in);
				break;
			}
			case AVIARY__XML_ATTR: {
				setAviary(test.openworld.deep.base.impl.Zoo_Impl.Aviary_Impl.readAviary_XmlContent(in));
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

			addAnimal(test.openworld.deep.base.impl.Animal_Impl.readAnimal_XmlContent(in));
		}
	}

	private void internalReadBirdsListXml(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		while (true) {
			int event = in.nextTag();
			if (event == javax.xml.stream.XMLStreamConstants.END_ELEMENT) {
				break;
			}

			addBird(test.openworld.deep.base.impl.Bird_Impl.readBird_XmlContent(in));
		}
	}

}
