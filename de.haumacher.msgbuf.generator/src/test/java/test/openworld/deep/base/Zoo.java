package test.openworld.deep.base;

/**
 * Holder of values of the hierarchy in single, repeated and nested fields.
 */
public interface Zoo extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {
	/**
	 * A nested message with fields of the hierarchy.
	 */
	public interface Aviary extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

		/**
		 * Creates a {@link test.openworld.deep.base.Zoo.Aviary} instance.
		 */
		static test.openworld.deep.base.Zoo.Aviary create() {
			return new test.openworld.deep.base.impl.Zoo_Impl.Aviary_Impl();
		}

		/** Identifier for the {@link test.openworld.deep.base.Zoo.Aviary} type in JSON format. */
		String AVIARY__TYPE = "Aviary";

		/** @see #getBoss() */
		String BOSS__PROP = "boss";

		/** @see #getResidents() */
		String RESIDENTS__PROP = "residents";

		test.openworld.deep.base.Bird getBoss();

		/**
		 * @see #getBoss()
		 */
		test.openworld.deep.base.Zoo.Aviary setBoss(test.openworld.deep.base.Bird value);

		/**
		 * Checks, whether {@link #getBoss()} has a value.
		 */
		boolean hasBoss();

		java.util.List<test.openworld.deep.base.Bird> getResidents();

		/**
		 * @see #getResidents()
		 */
		test.openworld.deep.base.Zoo.Aviary setResidents(java.util.List<? extends test.openworld.deep.base.Bird> value);

		/**
		 * Adds a value to the {@link #getResidents()} list.
		 */
		test.openworld.deep.base.Zoo.Aviary addResident(test.openworld.deep.base.Bird value);

		/**
		 * Removes a value from the {@link #getResidents()} list.
		 */
		void removeResident(test.openworld.deep.base.Bird value);

		@Override
		public test.openworld.deep.base.Zoo.Aviary registerListener(de.haumacher.msgbuf.observer.Listener l);

		@Override
		public test.openworld.deep.base.Zoo.Aviary unregisterListener(de.haumacher.msgbuf.observer.Listener l);

		/** Reads a new instance from the given reader. */
		static test.openworld.deep.base.Zoo.Aviary readAviary(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			test.openworld.deep.base.impl.Zoo_Impl.Aviary_Impl result = new test.openworld.deep.base.impl.Zoo_Impl.Aviary_Impl();
			result.readContent(in);
			return result;
		}

		/** Creates a new {@link Aviary} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Aviary readAviary(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			in.nextTag();
			return test.openworld.deep.base.impl.Zoo_Impl.Aviary_Impl.readAviary_XmlContent(in);
		}

	}

	/**
	 * Creates a {@link test.openworld.deep.base.Zoo} instance.
	 */
	static test.openworld.deep.base.Zoo create() {
		return new test.openworld.deep.base.impl.Zoo_Impl();
	}

	/** Identifier for the {@link test.openworld.deep.base.Zoo} type in JSON format. */
	String ZOO__TYPE = "Zoo";

	/** @see #getStar() */
	String STAR__PROP = "star";

	/** @see #getAnimals() */
	String ANIMALS__PROP = "animals";

	/** @see #getFavorite() */
	String FAVORITE__PROP = "favorite";

	/** @see #getBirds() */
	String BIRDS__PROP = "birds";

	/** @see #getAviary() */
	String AVIARY__PROP = "aviary";

	test.openworld.deep.base.Animal getStar();

	/**
	 * @see #getStar()
	 */
	test.openworld.deep.base.Zoo setStar(test.openworld.deep.base.Animal value);

	/**
	 * Checks, whether {@link #getStar()} has a value.
	 */
	boolean hasStar();

	java.util.List<test.openworld.deep.base.Animal> getAnimals();

	/**
	 * @see #getAnimals()
	 */
	test.openworld.deep.base.Zoo setAnimals(java.util.List<? extends test.openworld.deep.base.Animal> value);

	/**
	 * Adds a value to the {@link #getAnimals()} list.
	 */
	test.openworld.deep.base.Zoo addAnimal(test.openworld.deep.base.Animal value);

	/**
	 * Removes a value from the {@link #getAnimals()} list.
	 */
	void removeAnimal(test.openworld.deep.base.Animal value);

	test.openworld.deep.base.Bird getFavorite();

	/**
	 * @see #getFavorite()
	 */
	test.openworld.deep.base.Zoo setFavorite(test.openworld.deep.base.Bird value);

	/**
	 * Checks, whether {@link #getFavorite()} has a value.
	 */
	boolean hasFavorite();

	java.util.List<test.openworld.deep.base.Bird> getBirds();

	/**
	 * @see #getBirds()
	 */
	test.openworld.deep.base.Zoo setBirds(java.util.List<? extends test.openworld.deep.base.Bird> value);

	/**
	 * Adds a value to the {@link #getBirds()} list.
	 */
	test.openworld.deep.base.Zoo addBird(test.openworld.deep.base.Bird value);

	/**
	 * Removes a value from the {@link #getBirds()} list.
	 */
	void removeBird(test.openworld.deep.base.Bird value);

	test.openworld.deep.base.Zoo.Aviary getAviary();

	/**
	 * @see #getAviary()
	 */
	test.openworld.deep.base.Zoo setAviary(test.openworld.deep.base.Zoo.Aviary value);

	/**
	 * Checks, whether {@link #getAviary()} has a value.
	 */
	boolean hasAviary();

	@Override
	public test.openworld.deep.base.Zoo registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.openworld.deep.base.Zoo unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.openworld.deep.base.Zoo readZoo(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.openworld.deep.base.impl.Zoo_Impl result = new test.openworld.deep.base.impl.Zoo_Impl();
		result.readContent(in);
		return result;
	}

	/** Creates a new {@link Zoo} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Zoo readZoo(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.openworld.deep.base.impl.Zoo_Impl.readZoo_XmlContent(in);
	}

}
