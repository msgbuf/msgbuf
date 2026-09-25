package test.openworld.deep.base;

/**
 * A nested OpenWorld hierarchy with an abstract intermediate.
 */
public interface Habitat extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {
	public interface Plant extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

		/** Type codes for the {@link test.openworld.deep.base.Habitat.Plant} hierarchy. */
		public enum TypeKind {

			/** Type literal for {@link test.openworld.deep.base.Habitat.Birch}. */
			BIRCH,
			;

		}

		/** Registry for dynamically registered subtypes. */
		static final java.util.Map<String, de.haumacher.msgbuf.data.Factory<? extends test.openworld.deep.base.Habitat.Plant>> REGISTRY = new java.util.HashMap<>();

		/**
		 * Registers a subtype factory for polymorphic deserialization.
		 */
		static void register(String typeId, de.haumacher.msgbuf.data.Factory<? extends test.openworld.deep.base.Habitat.Plant> factory) {
			REGISTRY.put(typeId, factory);
		}

		/** Visitor interface for the {@link test.openworld.deep.base.Habitat.Plant} hierarchy.*/
		public interface Visitor<R,A,E extends Throwable> extends test.openworld.deep.base.Habitat.Tree.Visitor<R,A,E> {

			// Pure sum interface.

			/** Fallback for visiting subtypes not known at compile time. */
			R visitDefault(test.openworld.deep.base.Habitat.Plant self, A arg) throws E;

		}

		/** @see #getSpecies() */
		String SPECIES__PROP = "species";

		/** The type code of this instance. */
		TypeKind kind();

		String getSpecies();

		/**
		 * @see #getSpecies()
		 */
		test.openworld.deep.base.Habitat.Plant setSpecies(String value);

		@Override
		public test.openworld.deep.base.Habitat.Plant registerListener(de.haumacher.msgbuf.observer.Listener l);

		@Override
		public test.openworld.deep.base.Habitat.Plant unregisterListener(de.haumacher.msgbuf.observer.Listener l);

		/** Reads a new instance from the given reader. */
		static test.openworld.deep.base.Habitat.Plant readPlant(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			test.openworld.deep.base.Habitat.Plant result;
			in.beginArray();
			String type = in.nextString();
			switch (type) {
				case test.openworld.deep.base.Habitat.Birch.BIRCH__TYPE: result = test.openworld.deep.base.Habitat.Birch.readBirch(in); break;
				default: {
					de.haumacher.msgbuf.data.TypeRegistryLoader.ensureLoaded();
					de.haumacher.msgbuf.data.Factory<? extends test.openworld.deep.base.Habitat.Plant> factory = test.openworld.deep.base.Habitat.Plant.REGISTRY.get(type);
					if (factory != null) {
						result = factory.create();
						result.readContent(in);
					} else {
						in.skipValue();
						result = null;
					}
				} break;
			}
			in.endArray();
			return result;
		}

		/** Registry for dynamically registered subtypes by their XML element names. */
		static final java.util.Map<String, de.haumacher.msgbuf.data.Factory<? extends test.openworld.deep.base.Habitat.Plant>> XML_REGISTRY = new java.util.HashMap<>();

		/**
		 * Registers a subtype factory for reading elements with the given name in XML format.
		 */
		static void registerXml(String elementName, de.haumacher.msgbuf.data.Factory<? extends test.openworld.deep.base.Habitat.Plant> factory) {
			XML_REGISTRY.put(elementName, factory);
		}

		/** Creates a new {@link Plant} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Plant readPlant(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			in.nextTag();
			return test.openworld.deep.base.impl.Habitat_Impl.Plant_Impl.readPlant_XmlContent(in);
		}

		/** Accepts the given visitor. */
		public abstract <R,A,E extends Throwable> R visit(Visitor<R,A,E> v, A arg) throws E;

	}
	public interface Tree extends test.openworld.deep.base.Habitat.Plant {

		/** Visitor interface for the {@link test.openworld.deep.base.Habitat.Tree} hierarchy.*/
		public interface Visitor<R,A,E extends Throwable> {

			/** Visit case for {@link test.openworld.deep.base.Habitat.Birch}.*/
			R visit(test.openworld.deep.base.Habitat.Birch self, A arg) throws E;

			/** Fallback for visiting subtypes not known at compile time. */
			R visitDefault(test.openworld.deep.base.Habitat.Tree self, A arg) throws E;

		}

		/** @see #getHeight() */
		String HEIGHT__PROP = "height";

		int getHeight();

		/**
		 * @see #getHeight()
		 */
		test.openworld.deep.base.Habitat.Tree setHeight(int value);

		@Override
		test.openworld.deep.base.Habitat.Tree setSpecies(String value);

		/** Reads a new instance from the given reader. */
		static test.openworld.deep.base.Habitat.Tree readTree(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			test.openworld.deep.base.Habitat.Tree result;
			in.beginArray();
			String type = in.nextString();
			switch (type) {
				case test.openworld.deep.base.Habitat.Birch.BIRCH__TYPE: result = test.openworld.deep.base.Habitat.Birch.readBirch(in); break;
				default: {
					de.haumacher.msgbuf.data.TypeRegistryLoader.ensureLoaded();
					de.haumacher.msgbuf.data.Factory<? extends test.openworld.deep.base.Habitat.Plant> factory = test.openworld.deep.base.Habitat.Plant.REGISTRY.get(type);
					test.openworld.deep.base.Habitat.Plant instance = factory == null ? null : factory.create();
					if (instance instanceof test.openworld.deep.base.Habitat.Tree) {
						result = (test.openworld.deep.base.Habitat.Tree) instance;
						result.readContent(in);
					} else {
						in.skipValue();
						result = null;
					}
				} break;
			}
			in.endArray();
			return result;
		}

		/** Creates a new {@link Tree} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Tree readTree(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			in.nextTag();
			return test.openworld.deep.base.impl.Habitat_Impl.Tree_Impl.readTree_XmlContent(in);
		}

		/** Accepts the given visitor. */
		public abstract <R,A,E extends Throwable> R visit(Visitor<R,A,E> v, A arg) throws E;

	}
	public interface Birch extends test.openworld.deep.base.Habitat.Tree {

		/**
		 * Creates a {@link test.openworld.deep.base.Habitat.Birch} instance.
		 */
		static test.openworld.deep.base.Habitat.Birch create() {
			return new test.openworld.deep.base.impl.Habitat_Impl.Birch_Impl();
		}

		/** Identifier for the {@link test.openworld.deep.base.Habitat.Birch} type in JSON format. */
		String BIRCH__TYPE = "Birch";

		@Override
		test.openworld.deep.base.Habitat.Birch setHeight(int value);

		@Override
		test.openworld.deep.base.Habitat.Birch setSpecies(String value);

		/** Reads a new instance from the given reader. */
		static test.openworld.deep.base.Habitat.Birch readBirch(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			test.openworld.deep.base.impl.Habitat_Impl.Birch_Impl result = new test.openworld.deep.base.impl.Habitat_Impl.Birch_Impl();
			result.readContent(in);
			return result;
		}

		/** Creates a new {@link Birch} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Birch readBirch(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			in.nextTag();
			return test.openworld.deep.base.impl.Habitat_Impl.Birch_Impl.readBirch_XmlContent(in);
		}

	}

	/**
	 * Creates a {@link test.openworld.deep.base.Habitat} instance.
	 */
	static test.openworld.deep.base.Habitat create() {
		return new test.openworld.deep.base.impl.Habitat_Impl();
	}

	/** Identifier for the {@link test.openworld.deep.base.Habitat} type in JSON format. */
	String HABITAT__TYPE = "Habitat";

	/** @see #getTallest() */
	String TALLEST__PROP = "tallest";

	/** @see #getPlants() */
	String PLANTS__PROP = "plants";

	test.openworld.deep.base.Habitat.Tree getTallest();

	/**
	 * @see #getTallest()
	 */
	test.openworld.deep.base.Habitat setTallest(test.openworld.deep.base.Habitat.Tree value);

	/**
	 * Checks, whether {@link #getTallest()} has a value.
	 */
	boolean hasTallest();

	java.util.List<test.openworld.deep.base.Habitat.Plant> getPlants();

	/**
	 * @see #getPlants()
	 */
	test.openworld.deep.base.Habitat setPlants(java.util.List<? extends test.openworld.deep.base.Habitat.Plant> value);

	/**
	 * Adds a value to the {@link #getPlants()} list.
	 */
	test.openworld.deep.base.Habitat addPlant(test.openworld.deep.base.Habitat.Plant value);

	/**
	 * Removes a value from the {@link #getPlants()} list.
	 */
	void removePlant(test.openworld.deep.base.Habitat.Plant value);

	@Override
	public test.openworld.deep.base.Habitat registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.openworld.deep.base.Habitat unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.openworld.deep.base.Habitat readHabitat(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.openworld.deep.base.impl.Habitat_Impl result = new test.openworld.deep.base.impl.Habitat_Impl();
		result.readContent(in);
		return result;
	}

	/** Creates a new {@link Habitat} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Habitat readHabitat(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.openworld.deep.base.impl.Habitat_Impl.readHabitat_XmlContent(in);
	}

}
