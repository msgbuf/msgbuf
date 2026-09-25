package test.openworld.novisitor.base;

/**
 * An OpenWorld hierarchy without visitors (issue #39).
 */
public interface Shape extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/** Type codes for the {@link test.openworld.novisitor.base.Shape} hierarchy. */
	public enum TypeKind {

		/** Type literal for {@link test.openworld.novisitor.base.Circle}. */
		CIRCLE,
		;

	}

	/** Registry for dynamically registered subtypes. */
	static final java.util.Map<String, de.haumacher.msgbuf.data.Factory<? extends test.openworld.novisitor.base.Shape>> REGISTRY = new java.util.HashMap<>();

	/**
	 * Registers a subtype factory for polymorphic deserialization.
	 */
	static void register(String typeId, de.haumacher.msgbuf.data.Factory<? extends test.openworld.novisitor.base.Shape> factory) {
		REGISTRY.put(typeId, factory);
	}

	/** @see #getName() */
	String NAME__PROP = "name";

	/** The type code of this instance. */
	TypeKind kind();

	String getName();

	/**
	 * @see #getName()
	 */
	test.openworld.novisitor.base.Shape setName(String value);

	@Override
	public test.openworld.novisitor.base.Shape registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.openworld.novisitor.base.Shape unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.openworld.novisitor.base.Shape readShape(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.openworld.novisitor.base.Shape result;
		in.beginArray();
		String type = in.nextString();
		switch (type) {
			case Circle.CIRCLE__TYPE: result = test.openworld.novisitor.base.Circle.readCircle(in); break;
			default: {
				de.haumacher.msgbuf.data.TypeRegistryLoader.ensureLoaded();
				de.haumacher.msgbuf.data.Factory<? extends test.openworld.novisitor.base.Shape> factory = test.openworld.novisitor.base.Shape.REGISTRY.get(type);
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
	static final java.util.Map<String, de.haumacher.msgbuf.data.Factory<? extends test.openworld.novisitor.base.Shape>> XML_REGISTRY = new java.util.HashMap<>();

	/**
	 * Registers a subtype factory for reading elements with the given name in XML format.
	 */
	static void registerXml(String elementName, de.haumacher.msgbuf.data.Factory<? extends test.openworld.novisitor.base.Shape> factory) {
		XML_REGISTRY.put(elementName, factory);
	}

	/** Creates a new {@link Shape} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Shape readShape(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.openworld.novisitor.base.impl.Shape_Impl.readShape_XmlContent(in);
	}

}
