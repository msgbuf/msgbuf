package test.nested.data;

/**
 * A container for sub-messages extending a top-level abstract message.
 */
public interface Zoo extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {
	public interface Cat extends test.nested.data.Animal {

		/**
		 * Creates a {@link test.nested.data.Zoo.Cat} instance.
		 */
		static test.nested.data.Zoo.Cat create() {
			return new test.nested.data.impl.Zoo_Impl.Cat_Impl();
		}

		/** Identifier for the {@link test.nested.data.Zoo.Cat} type in JSON format. */
		String CAT__TYPE = "Cat";

		/** @see #isIndoor() */
		String INDOOR__PROP = "indoor";

		/** Identifier for the {@link test.nested.data.Zoo.Cat} type in binary format. */
		static final int CAT__TYPE_ID = 1;

		/** Identifier for the property {@link #isIndoor()} in binary format. */
		static final int INDOOR__ID = 2;

		boolean isIndoor();

		/**
		 * @see #isIndoor()
		 */
		test.nested.data.Zoo.Cat setIndoor(boolean value);

		@Override
		test.nested.data.Zoo.Cat setName(String value);

		/** Reads a new instance from the given reader. */
		static test.nested.data.Zoo.Cat readCat(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			test.nested.data.impl.Zoo_Impl.Cat_Impl result = new test.nested.data.impl.Zoo_Impl.Cat_Impl();
			result.readContent(in);
			return result;
		}

		/** Reads a new instance from the given reader. */
		static test.nested.data.Zoo.Cat readCat(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			in.beginObject();
			test.nested.data.Zoo.Cat result = test.nested.data.impl.Zoo_Impl.Cat_Impl.readCat_Content(in);
			in.endObject();
			return result;
		}

		/** Creates a new {@link Cat} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Cat readCat(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			in.nextTag();
			return test.nested.data.impl.Zoo_Impl.Cat_Impl.readCat_XmlContent(in);
		}

	}
	/**
	 * A nested abstract intermediate below a top-level root.
	 */
	public interface Bird extends test.nested.data.Animal {

		/** Visitor interface for the {@link test.nested.data.Zoo.Bird} hierarchy.*/
		public interface Visitor<R,A,E extends Throwable> {

			/** Visit case for {@link test.nested.data.Zoo.Parrot}.*/
			R visit(test.nested.data.Zoo.Parrot self, A arg) throws E;

		}

		/** @see #getWingspan() */
		String WINGSPAN__PROP = "wingspan";

		/** Identifier for the property {@link #getWingspan()} in binary format. */
		static final int WINGSPAN__ID = 2;

		double getWingspan();

		/**
		 * @see #getWingspan()
		 */
		test.nested.data.Zoo.Bird setWingspan(double value);

		@Override
		test.nested.data.Zoo.Bird setName(String value);

		/** Reads a new instance from the given reader. */
		static test.nested.data.Zoo.Bird readBird(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			test.nested.data.Zoo.Bird result;
			in.beginArray();
			String type = in.nextString();
			switch (type) {
				case test.nested.data.Zoo.Parrot.PARROT__TYPE: result = test.nested.data.Zoo.Parrot.readParrot(in); break;
				default: in.skipValue(); result = null; break;
			}
			in.endArray();
			return result;
		}

		/** Reads a new instance from the given reader. */
		static test.nested.data.Zoo.Bird readBird(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			in.beginObject();
			int typeField = in.nextName();
			assert typeField == 0;
			int type = in.nextInt();
			test.nested.data.Zoo.Bird result;
			switch (type) {
				case test.nested.data.Zoo.Parrot.PARROT__TYPE_ID: result = test.nested.data.impl.Zoo_Impl.Parrot_Impl.readParrot_Content(in); break;
				default: result = null; while (in.hasNext()) {in.skipValue(); }
			}
			in.endObject();
			return result;
		}

		/** Creates a new {@link Bird} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Bird readBird(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			in.nextTag();
			return test.nested.data.impl.Zoo_Impl.Bird_Impl.readBird_XmlContent(in);
		}

		/** Accepts the given visitor. */
		public abstract <R,A,E extends Throwable> R visit(Visitor<R,A,E> v, A arg) throws E;

	}
	public interface Parrot extends test.nested.data.Zoo.Bird {

		/**
		 * Creates a {@link test.nested.data.Zoo.Parrot} instance.
		 */
		static test.nested.data.Zoo.Parrot create() {
			return new test.nested.data.impl.Zoo_Impl.Parrot_Impl();
		}

		/** Identifier for the {@link test.nested.data.Zoo.Parrot} type in JSON format. */
		String PARROT__TYPE = "Parrot";

		/** @see #getWords() */
		String WORDS__PROP = "words";

		/** Identifier for the {@link test.nested.data.Zoo.Parrot} type in binary format. */
		static final int PARROT__TYPE_ID = 2;

		/** Identifier for the property {@link #getWords()} in binary format. */
		static final int WORDS__ID = 3;

		java.util.List<String> getWords();

		/**
		 * @see #getWords()
		 */
		test.nested.data.Zoo.Parrot setWords(java.util.List<? extends String> value);

		/**
		 * Adds a value to the {@link #getWords()} list.
		 */
		test.nested.data.Zoo.Parrot addWord(String value);

		/**
		 * Removes a value from the {@link #getWords()} list.
		 */
		void removeWord(String value);

		@Override
		test.nested.data.Zoo.Parrot setWingspan(double value);

		@Override
		test.nested.data.Zoo.Parrot setName(String value);

		/** Reads a new instance from the given reader. */
		static test.nested.data.Zoo.Parrot readParrot(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			test.nested.data.impl.Zoo_Impl.Parrot_Impl result = new test.nested.data.impl.Zoo_Impl.Parrot_Impl();
			result.readContent(in);
			return result;
		}

		/** Reads a new instance from the given reader. */
		static test.nested.data.Zoo.Parrot readParrot(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			in.beginObject();
			test.nested.data.Zoo.Parrot result = test.nested.data.impl.Zoo_Impl.Parrot_Impl.readParrot_Content(in);
			in.endObject();
			return result;
		}

		/** Creates a new {@link Parrot} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Parrot readParrot(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			in.nextTag();
			return test.nested.data.impl.Zoo_Impl.Parrot_Impl.readParrot_XmlContent(in);
		}

	}

	/**
	 * Creates a {@link test.nested.data.Zoo} instance.
	 */
	static test.nested.data.Zoo create() {
		return new test.nested.data.impl.Zoo_Impl();
	}

	/** Identifier for the {@link test.nested.data.Zoo} type in JSON format. */
	String ZOO__TYPE = "Zoo";

	/** @see #getAnimals() */
	String ANIMALS__PROP = "animals";

	/** Identifier for the property {@link #getAnimals()} in binary format. */
	static final int ANIMALS__ID = 1;

	java.util.List<test.nested.data.Animal> getAnimals();

	/**
	 * @see #getAnimals()
	 */
	test.nested.data.Zoo setAnimals(java.util.List<? extends test.nested.data.Animal> value);

	/**
	 * Adds a value to the {@link #getAnimals()} list.
	 */
	test.nested.data.Zoo addAnimal(test.nested.data.Animal value);

	/**
	 * Removes a value from the {@link #getAnimals()} list.
	 */
	void removeAnimal(test.nested.data.Animal value);

	@Override
	public test.nested.data.Zoo registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.nested.data.Zoo unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.nested.data.Zoo readZoo(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.nested.data.impl.Zoo_Impl result = new test.nested.data.impl.Zoo_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.nested.data.Zoo readZoo(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.nested.data.Zoo result = test.nested.data.impl.Zoo_Impl.readZoo_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link Zoo} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Zoo readZoo(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.nested.data.impl.Zoo_Impl.readZoo_XmlContent(in);
	}

}
