package test.openworld.deep.base.impl;

/**
 * Implementation of {@link test.openworld.deep.base.Habitat}.
 */
public class Habitat_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.openworld.deep.base.Habitat {
	/**
	 * Implementation of {@link test.openworld.deep.base.Habitat.Plant}.
	 */
	public static abstract class Plant_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.openworld.deep.base.Habitat.Plant {

		static {
			de.haumacher.msgbuf.data.TypeRegistryLoader.ensureLoaded();
		}

		private String _species = "";

		/**
		 * Creates a {@link Plant_Impl} instance.
		 */
		public Plant_Impl() {
			super();
		}

		@Override
		public final String getSpecies() {
			return _species;
		}

		@Override
		public test.openworld.deep.base.Habitat.Plant setSpecies(String value) {
			internalSetSpecies(value);
			return this;
		}

		/** Internal setter for {@link #getSpecies()} without chain call utility. */
		protected final void internalSetSpecies(String value) {
			_listener.beforeSet(this, SPECIES__PROP, value);
			_species = value;
			_listener.afterChanged(this, SPECIES__PROP);
		}

		protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

		@Override
		public test.openworld.deep.base.Habitat.Plant registerListener(de.haumacher.msgbuf.observer.Listener l) {
			internalRegisterListener(l);
			return this;
		}

		protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
			_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
		}

		@Override
		public test.openworld.deep.base.Habitat.Plant unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
			internalUnregisterListener(l);
			return this;
		}

		protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
			_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
		}

		protected static final java.util.List<String> PROPERTIES;
		static {
			java.util.List<String> local = java.util.Arrays.asList(
				SPECIES__PROP);
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
				case SPECIES__PROP: return getSpecies();
				default: return test.openworld.deep.base.Habitat.Plant.super.get(field);
			}
		}

		@Override
		public void set(String field, Object value) {
			switch (field) {
				case SPECIES__PROP: internalSetSpecies((String) value); break;
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
			out.name(SPECIES__PROP);
			out.value(getSpecies());
		}

		@Override
		protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
			switch (field) {
				case SPECIES__PROP: setSpecies(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
				default: super.readField(in, field);
			}
		}

		/** XML element name representing a {@link test.openworld.deep.base.Habitat.Plant} type. */
		public static final String PLANT__XML_ELEMENT = "plant";

		/** XML attribute or element name of a {@link #getSpecies} property. */
		private static final String SPECIES__XML_ATTR = "species";

		@Override
		public final void writeContent(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
			writeAttributes(out);
			writeElements(out);
		}

		/** Serializes all fields that are written as XML attributes. */
		protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
			out.writeAttribute(SPECIES__XML_ATTR, getSpecies());
		}

		/** Serializes all fields that are written as XML elements. */
		protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
			// No element fields.
		}

		/** Creates a new {@link test.openworld.deep.base.Habitat.Plant} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Plant_Impl readPlant_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			switch (in.getLocalName()) {
				case test.openworld.deep.base.impl.Habitat_Impl.Birch_Impl.BIRCH__XML_ELEMENT: {
					return test.openworld.deep.base.impl.Habitat_Impl.Birch_Impl.readBirch_XmlContent(in);
				}

				default: {
					de.haumacher.msgbuf.data.Factory<? extends test.openworld.deep.base.Habitat.Plant> factory = test.openworld.deep.base.Habitat.Plant.XML_REGISTRY.get(in.getLocalName());
					test.openworld.deep.base.Habitat.Plant instance = factory == null ? null : factory.create();
					if (instance instanceof Plant_Impl) {
						Plant_Impl result = (Plant_Impl) instance;
						result.readContentXml(in);
						return result;
					}
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
				case SPECIES__XML_ATTR: {
					setSpecies(value);
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
				case SPECIES__XML_ATTR: {
					setSpecies(in.getElementText());
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
	/**
	 * Implementation of {@link test.openworld.deep.base.Habitat.Tree}.
	 */
	public static abstract class Tree_Impl extends test.openworld.deep.base.impl.Habitat_Impl.Plant_Impl implements test.openworld.deep.base.Habitat.Tree {

		private int _height = 0;

		/**
		 * Creates a {@link Tree_Impl} instance.
		 */
		public Tree_Impl() {
			super();
		}

		@Override
		public final int getHeight() {
			return _height;
		}

		@Override
		public test.openworld.deep.base.Habitat.Tree setHeight(int value) {
			internalSetHeight(value);
			return this;
		}

		/** Internal setter for {@link #getHeight()} without chain call utility. */
		protected final void internalSetHeight(int value) {
			_listener.beforeSet(this, HEIGHT__PROP, value);
			_height = value;
			_listener.afterChanged(this, HEIGHT__PROP);
		}

		@Override
		public test.openworld.deep.base.Habitat.Tree setSpecies(String value) {
			internalSetSpecies(value);
			return this;
		}

		@SuppressWarnings("hiding")
		protected static final java.util.List<String> PROPERTIES;
		static {
			java.util.List<String> local = java.util.Arrays.asList(
				HEIGHT__PROP);
			java.util.List<String> tmp = new java.util.ArrayList<>();
			tmp.addAll(test.openworld.deep.base.impl.Habitat_Impl.Plant_Impl.PROPERTIES);
			tmp.addAll(local);
			PROPERTIES = java.util.Collections.unmodifiableList(tmp);
		}

		@SuppressWarnings("hiding")
		protected static final java.util.Set<String> TRANSIENT_PROPERTIES;
		static {
			java.util.HashSet<String> tmp = new java.util.HashSet<>();
			tmp.addAll(test.openworld.deep.base.impl.Habitat_Impl.Plant_Impl.TRANSIENT_PROPERTIES);
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
				case HEIGHT__PROP: return getHeight();
				default: return super.get(field);
			}
		}

		@Override
		public void set(String field, Object value) {
			switch (field) {
				case HEIGHT__PROP: internalSetHeight((int) value); break;
				default: super.set(field, value); break;
			}
		}

		@Override
		protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
			super.writeFields(out);
			out.name(HEIGHT__PROP);
			out.value(getHeight());
		}

		@Override
		protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
			switch (field) {
				case HEIGHT__PROP: setHeight(in.nextInt()); break;
				default: super.readField(in, field);
			}
		}

		/** XML element name representing a {@link test.openworld.deep.base.Habitat.Tree} type. */
		public static final String TREE__XML_ELEMENT = "tree";

		/** XML attribute or element name of a {@link #getHeight} property. */
		private static final String HEIGHT__XML_ATTR = "height";

		/** Serializes all fields that are written as XML attributes. */
		@Override
		protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
			super.writeAttributes(out);
			out.writeAttribute(HEIGHT__XML_ATTR, Integer.toString(getHeight()));
		}

		/** Serializes all fields that are written as XML elements. */
		@Override
		protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
			super.writeElements(out);
			// No element fields.
		}

		/** Creates a new {@link test.openworld.deep.base.Habitat.Tree} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Tree_Impl readTree_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			switch (in.getLocalName()) {
				case test.openworld.deep.base.impl.Habitat_Impl.Birch_Impl.BIRCH__XML_ELEMENT: {
					return test.openworld.deep.base.impl.Habitat_Impl.Birch_Impl.readBirch_XmlContent(in);
				}

				default: {
					de.haumacher.msgbuf.data.Factory<? extends test.openworld.deep.base.Habitat.Plant> factory = test.openworld.deep.base.Habitat.Plant.XML_REGISTRY.get(in.getLocalName());
					test.openworld.deep.base.Habitat.Plant instance = factory == null ? null : factory.create();
					if (instance instanceof Tree_Impl) {
						Tree_Impl result = (Tree_Impl) instance;
						result.readContentXml(in);
						return result;
					}
					internalSkipUntilMatchingEndElement(in);
					return null;
				}
			}
		}

		@Override
		protected void readFieldXmlAttribute(String name, String value) {
			switch (name) {
				case HEIGHT__XML_ATTR: {
					setHeight(Integer.parseInt(value));
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
				case HEIGHT__XML_ATTR: {
					setHeight(Integer.parseInt(in.getElementText()));
					break;
				}
				default: {
					super.readFieldXmlElement(in, localName);
				}
			}
		}

		@Override
		public final <R,A,E extends Throwable> R visit(test.openworld.deep.base.Habitat.Plant.Visitor<R,A,E> v, A arg) throws E {
			return visit((test.openworld.deep.base.Habitat.Tree.Visitor<R,A,E>) v, arg);
		}

	}
	/**
	 * Implementation of {@link test.openworld.deep.base.Habitat.Birch}.
	 */
	public static class Birch_Impl extends test.openworld.deep.base.impl.Habitat_Impl.Tree_Impl implements test.openworld.deep.base.Habitat.Birch {

		/**
		 * Creates a {@link Birch_Impl} instance.
		 *
		 * @see test.openworld.deep.base.Habitat.Birch#create()
		 */
		public Birch_Impl() {
			super();
		}

		@Override
		public TypeKind kind() {
			return TypeKind.BIRCH;
		}

		@Override
		public test.openworld.deep.base.Habitat.Birch setHeight(int value) {
			internalSetHeight(value);
			return this;
		}

		@Override
		public test.openworld.deep.base.Habitat.Birch setSpecies(String value) {
			internalSetSpecies(value);
			return this;
		}

		@Override
		public String jsonType() {
			return BIRCH__TYPE;
		}

		/** XML element name representing a {@link test.openworld.deep.base.Habitat.Birch} type. */
		public static final String BIRCH__XML_ELEMENT = "birch";

		@Override
		public String getXmlTagName() {
			return BIRCH__XML_ELEMENT;
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
			// No element fields.
		}

		/** Creates a new {@link test.openworld.deep.base.Habitat.Birch} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Birch_Impl readBirch_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			Birch_Impl result = new Birch_Impl();
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
				default: {
					super.readFieldXmlElement(in, localName);
				}
			}
		}

		@Override
		public <R,A,E extends Throwable> R visit(test.openworld.deep.base.Habitat.Tree.Visitor<R,A,E> v, A arg) throws E {
			return v.visit(this, arg);
		}

	}

	private test.openworld.deep.base.Habitat.Tree _tallest = null;

	private final java.util.List<test.openworld.deep.base.Habitat.Plant> _plants = new de.haumacher.msgbuf.util.ReferenceList<test.openworld.deep.base.Habitat.Plant>() {
		@Override
		protected void beforeAdd(int index, test.openworld.deep.base.Habitat.Plant element) {
			_listener.beforeAdd(Habitat_Impl.this, PLANTS__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, test.openworld.deep.base.Habitat.Plant element) {
			_listener.afterRemove(Habitat_Impl.this, PLANTS__PROP, index, element);
		}

		@Override
		protected void afterChanged() {
			_listener.afterChanged(Habitat_Impl.this, PLANTS__PROP);
		}
	};

	/**
	 * Creates a {@link Habitat_Impl} instance.
	 *
	 * @see test.openworld.deep.base.Habitat#create()
	 */
	public Habitat_Impl() {
		super();
	}

	@Override
	public final test.openworld.deep.base.Habitat.Tree getTallest() {
		return _tallest;
	}

	@Override
	public test.openworld.deep.base.Habitat setTallest(test.openworld.deep.base.Habitat.Tree value) {
		internalSetTallest(value);
		return this;
	}

	/** Internal setter for {@link #getTallest()} without chain call utility. */
	protected final void internalSetTallest(test.openworld.deep.base.Habitat.Tree value) {
		_listener.beforeSet(this, TALLEST__PROP, value);
		_tallest = value;
		_listener.afterChanged(this, TALLEST__PROP);
	}

	@Override
	public final boolean hasTallest() {
		return _tallest != null;
	}

	@Override
	public final java.util.List<test.openworld.deep.base.Habitat.Plant> getPlants() {
		return _plants;
	}

	@Override
	public test.openworld.deep.base.Habitat setPlants(java.util.List<? extends test.openworld.deep.base.Habitat.Plant> value) {
		internalSetPlants(value);
		return this;
	}

	/** Internal setter for {@link #getPlants()} without chain call utility. */
	protected final void internalSetPlants(java.util.List<? extends test.openworld.deep.base.Habitat.Plant> value) {
		if (value == null) throw new IllegalArgumentException("Property 'plants' cannot be null.");
		_plants.clear();
		_plants.addAll(value);
	}

	@Override
	public test.openworld.deep.base.Habitat addPlant(test.openworld.deep.base.Habitat.Plant value) {
		internalAddPlant(value);
		return this;
	}

	/** Implementation of {@link #addPlant(test.openworld.deep.base.Habitat.Plant)} without chain call utility. */
	protected final void internalAddPlant(test.openworld.deep.base.Habitat.Plant value) {
		_plants.add(value);
	}

	@Override
	public final void removePlant(test.openworld.deep.base.Habitat.Plant value) {
		_plants.remove(value);
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public test.openworld.deep.base.Habitat registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public test.openworld.deep.base.Habitat unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		internalUnregisterListener(l);
		return this;
	}

	protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
	}

	@Override
	public String jsonType() {
		return HABITAT__TYPE;
	}

	protected static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			TALLEST__PROP, 
			PLANTS__PROP);
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
			case TALLEST__PROP: return getTallest();
			case PLANTS__PROP: return getPlants();
			default: return test.openworld.deep.base.Habitat.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case TALLEST__PROP: internalSetTallest((test.openworld.deep.base.Habitat.Tree) value); break;
			case PLANTS__PROP: internalSetPlants(de.haumacher.msgbuf.util.Conversions.asList(test.openworld.deep.base.Habitat.Plant.class, value)); break;
		}
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		if (hasTallest()) {
			out.name(TALLEST__PROP);
			getTallest().writeTo(out);
		}
		out.name(PLANTS__PROP);
		out.beginArray();
		for (test.openworld.deep.base.Habitat.Plant x : getPlants()) {
			x.writeTo(out);
		}
		out.endArray();
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case TALLEST__PROP: setTallest(test.openworld.deep.base.Habitat.Tree.readTree(in)); break;
			case PLANTS__PROP: {
				java.util.List<test.openworld.deep.base.Habitat.Plant> newValue = new java.util.ArrayList<>();
				in.beginArray();
				while (in.hasNext()) {
					newValue.add(test.openworld.deep.base.Habitat.Plant.readPlant(in));
				}
				in.endArray();
				setPlants(newValue);
			}
			break;
			default: super.readField(in, field);
		}
	}

	/** XML element name representing a {@link test.openworld.deep.base.Habitat} type. */
	public static final String HABITAT__XML_ELEMENT = "habitat";

	/** XML attribute or element name of a {@link #getTallest} property. */
	private static final String TALLEST__XML_ATTR = "tallest";

	/** XML attribute or element name of a {@link #getPlants} property. */
	private static final String PLANTS__XML_ATTR = "plants";

	@Override
	public String getXmlTagName() {
		return HABITAT__XML_ELEMENT;
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
		if (hasTallest()) {
			out.writeStartElement(TALLEST__XML_ATTR);
			getTallest().writeTo(out);
			out.writeEndElement();
		}
		out.writeStartElement(PLANTS__XML_ATTR);
		for (test.openworld.deep.base.Habitat.Plant element : getPlants()) {
			element.writeTo(out);
		}
		out.writeEndElement();
	}

	/** Creates a new {@link test.openworld.deep.base.Habitat} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Habitat_Impl readHabitat_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		Habitat_Impl result = new Habitat_Impl();
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
			case TALLEST__XML_ATTR: {
				in.nextTag();
				setTallest(test.openworld.deep.base.impl.Habitat_Impl.Tree_Impl.readTree_XmlContent(in));
				internalSkipUntilMatchingEndElement(in);
				break;
			}
			case PLANTS__XML_ATTR: {
				internalReadPlantsListXml(in);
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

	private void internalReadPlantsListXml(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		while (true) {
			int event = in.nextTag();
			if (event == javax.xml.stream.XMLStreamConstants.END_ELEMENT) {
				break;
			}

			addPlant(test.openworld.deep.base.impl.Habitat_Impl.Plant_Impl.readPlant_XmlContent(in));
		}
	}

}
