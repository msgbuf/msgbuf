package test.openworld.deep.ext1;

/**
 * Abstract intermediate declared in an extension file: a sibling subtree of Bird.
 */
public interface Fish extends test.openworld.deep.base.Animal {

	/** Visitor interface for the {@link test.openworld.deep.ext1.Fish} hierarchy.*/
	public interface Visitor<R,A,E extends Throwable> {

		/** Visit case for {@link test.openworld.deep.ext1.Trout}.*/
		R visit(test.openworld.deep.ext1.Trout self, A arg) throws E;

		/** Fallback for visiting subtypes not known at compile time. */
		R visitDefault(test.openworld.deep.ext1.Fish self, A arg) throws E;

	}

	/** @see #getFins() */
	String FINS__PROP = "fins";

	int getFins();

	/**
	 * @see #getFins()
	 */
	test.openworld.deep.ext1.Fish setFins(int value);

	@Override
	test.openworld.deep.ext1.Fish setName(String value);

	/** Reads a new instance from the given reader. */
	static test.openworld.deep.ext1.Fish readFish(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.openworld.deep.ext1.Fish result;
		in.beginArray();
		String type = in.nextString();
		switch (type) {
			case Trout.TROUT__TYPE: result = test.openworld.deep.ext1.Trout.readTrout(in); break;
			default: {
				de.haumacher.msgbuf.data.TypeRegistryLoader.ensureLoaded();
				de.haumacher.msgbuf.data.Factory<? extends test.openworld.deep.base.Animal> factory = test.openworld.deep.base.Animal.REGISTRY.get(type);
				test.openworld.deep.base.Animal instance = factory == null ? null : factory.create();
				if (instance instanceof test.openworld.deep.ext1.Fish) {
					result = (test.openworld.deep.ext1.Fish) instance;
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

	/** Creates a new {@link Fish} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Fish readFish(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.openworld.deep.ext1.impl.Fish_Impl.readFish_XmlContent(in);
	}

	/** Accepts the given visitor. */
	public abstract <R,A,E extends Throwable> R visit(Visitor<R,A,E> v, A arg) throws E;

}
