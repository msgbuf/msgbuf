package test.openworld.deep.base;

/**
 * Root of an OpenWorld hierarchy with abstract intermediates (issues #26, #27).
 */
public interface Animal extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/** Type codes for the {@link test.openworld.deep.base.Animal} hierarchy. */
	public enum TypeKind {

		/** Type literal for {@link test.openworld.deep.base.Sparrow}. */
		SPARROW,

		/** Type literal for {@link test.openworld.deep.base.Dog}. */
		DOG,
		;

	}

	/** Registry for dynamically registered subtypes. */
	static final java.util.Map<String, de.haumacher.msgbuf.data.Factory<? extends test.openworld.deep.base.Animal>> REGISTRY = new java.util.HashMap<>();

	/**
	 * Registers a subtype factory for polymorphic deserialization.
	 */
	static void register(String typeId, de.haumacher.msgbuf.data.Factory<? extends test.openworld.deep.base.Animal> factory) {
		REGISTRY.put(typeId, factory);
	}

	/** Visitor interface for the {@link test.openworld.deep.base.Animal} hierarchy.*/
	public interface Visitor<R,A,E extends Throwable> extends test.openworld.deep.base.Bird.Visitor<R,A,E> {

		/** Visit case for {@link test.openworld.deep.base.Dog}.*/
		R visit(test.openworld.deep.base.Dog self, A arg) throws E;

		/** Fallback for visiting subtypes not known at compile time. */
		R visitDefault(test.openworld.deep.base.Animal self, A arg) throws E;

	}

	/** @see #getName() */
	String NAME__PROP = "name";

	/** The type code of this instance. */
	TypeKind kind();

	String getName();

	/**
	 * @see #getName()
	 */
	test.openworld.deep.base.Animal setName(String value);

	@Override
	public test.openworld.deep.base.Animal registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.openworld.deep.base.Animal unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.openworld.deep.base.Animal readAnimal(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.openworld.deep.base.Animal result;
		in.beginArray();
		String type = in.nextString();
		switch (type) {
			case Sparrow.SPARROW__TYPE: result = test.openworld.deep.base.Sparrow.readSparrow(in); break;
			case Dog.DOG__TYPE: result = test.openworld.deep.base.Dog.readDog(in); break;
			default: {
				de.haumacher.msgbuf.data.TypeRegistryLoader.ensureLoaded();
				de.haumacher.msgbuf.data.Factory<? extends test.openworld.deep.base.Animal> factory = test.openworld.deep.base.Animal.REGISTRY.get(type);
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
	static final java.util.Map<String, de.haumacher.msgbuf.data.Factory<? extends test.openworld.deep.base.Animal>> XML_REGISTRY = new java.util.HashMap<>();

	/**
	 * Registers a subtype factory for reading elements with the given name in XML format.
	 */
	static void registerXml(String elementName, de.haumacher.msgbuf.data.Factory<? extends test.openworld.deep.base.Animal> factory) {
		XML_REGISTRY.put(elementName, factory);
	}

	/** Creates a new {@link Animal} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Animal readAnimal(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.openworld.deep.base.impl.Animal_Impl.readAnimal_XmlContent(in);
	}

	/** Accepts the given visitor. */
	public abstract <R,A,E extends Throwable> R visit(Visitor<R,A,E> v, A arg) throws E;

}
