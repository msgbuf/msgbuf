package test.openworld.deep.ext1;

/**
 * Nested leaf of a nested hierarchy of another file.
 */
public interface Forest extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {
	public interface Oak extends test.openworld.deep.base.Habitat.Tree {

		/** Extended visitor that can handle {@link Oak}. */
		public interface Visitor<R,A,E extends Throwable> extends test.openworld.deep.base.Habitat.Tree.Visitor<R,A,E> {

			/** Visit case for {@link Oak}. */
			R visit(test.openworld.deep.ext1.Forest.Oak self, A arg) throws E;

		}

		/**
		 * Creates a {@link test.openworld.deep.ext1.Forest.Oak} instance.
		 */
		static test.openworld.deep.ext1.Forest.Oak create() {
			return new test.openworld.deep.ext1.impl.Forest_Impl.Oak_Impl();
		}

		/** Identifier for the {@link test.openworld.deep.ext1.Forest.Oak} type in JSON format. */
		String OAK__TYPE = "Oak";

		/** @see #getAge() */
		String AGE__PROP = "age";

		int getAge();

		/**
		 * @see #getAge()
		 */
		test.openworld.deep.ext1.Forest.Oak setAge(int value);

		@Override
		test.openworld.deep.ext1.Forest.Oak setHeight(int value);

		@Override
		test.openworld.deep.ext1.Forest.Oak setSpecies(String value);

		/** Reads a new instance from the given reader. */
		static test.openworld.deep.ext1.Forest.Oak readOak(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			test.openworld.deep.ext1.impl.Forest_Impl.Oak_Impl result = new test.openworld.deep.ext1.impl.Forest_Impl.Oak_Impl();
			result.readContent(in);
			return result;
		}

		/** Creates a new {@link Oak} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Oak readOak(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			in.nextTag();
			return test.openworld.deep.ext1.impl.Forest_Impl.Oak_Impl.readOak_XmlContent(in);
		}

	}

	/**
	 * Creates a {@link test.openworld.deep.ext1.Forest} instance.
	 */
	static test.openworld.deep.ext1.Forest create() {
		return new test.openworld.deep.ext1.impl.Forest_Impl();
	}

	/** Identifier for the {@link test.openworld.deep.ext1.Forest} type in JSON format. */
	String FOREST__TYPE = "Forest";

	@Override
	public test.openworld.deep.ext1.Forest registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.openworld.deep.ext1.Forest unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.openworld.deep.ext1.Forest readForest(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.openworld.deep.ext1.impl.Forest_Impl result = new test.openworld.deep.ext1.impl.Forest_Impl();
		result.readContent(in);
		return result;
	}

	/** Creates a new {@link Forest} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Forest readForest(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.openworld.deep.ext1.impl.Forest_Impl.readForest_XmlContent(in);
	}

}
