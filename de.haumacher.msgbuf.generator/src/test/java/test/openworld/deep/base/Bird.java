package test.openworld.deep.base;

/**
 * Abstract intermediate of the base file, extended in other files.
 */
public interface Bird extends test.openworld.deep.base.Animal {

	/** Visitor interface for the {@link test.openworld.deep.base.Bird} hierarchy.*/
	public interface Visitor<R,A,E extends Throwable> {

		/** Visit case for {@link test.openworld.deep.base.Sparrow}.*/
		R visit(test.openworld.deep.base.Sparrow self, A arg) throws E;

		/** Fallback for visiting subtypes not known at compile time. */
		R visitDefault(test.openworld.deep.base.Bird self, A arg) throws E;

	}

	/** @see #getWingspan() */
	String WINGSPAN__PROP = "wingspan";

	double getWingspan();

	/**
	 * @see #getWingspan()
	 */
	test.openworld.deep.base.Bird setWingspan(double value);

	@Override
	test.openworld.deep.base.Bird setName(String value);

	/** Reads a new instance from the given reader. */
	static test.openworld.deep.base.Bird readBird(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.openworld.deep.base.Bird result;
		in.beginArray();
		String type = in.nextString();
		switch (type) {
			case Sparrow.SPARROW__TYPE: result = test.openworld.deep.base.Sparrow.readSparrow(in); break;
			default: {
				de.haumacher.msgbuf.data.TypeRegistryLoader.ensureLoaded();
				de.haumacher.msgbuf.data.Factory<? extends test.openworld.deep.base.Animal> factory = test.openworld.deep.base.Animal.REGISTRY.get(type);
				test.openworld.deep.base.Animal instance = factory == null ? null : factory.create();
				if (instance instanceof test.openworld.deep.base.Bird) {
					result = (test.openworld.deep.base.Bird) instance;
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

	/** Creates a new {@link Bird} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Bird readBird(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.openworld.deep.base.impl.Bird_Impl.readBird_XmlContent(in);
	}

	/** Accepts the given visitor. */
	public abstract <R,A,E extends Throwable> R visit(Visitor<R,A,E> v, A arg) throws E;

}
