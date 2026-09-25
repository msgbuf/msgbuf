package test.nested.data;

/**
 * A top-level abstract root.
 */
public interface Animal extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/** Type codes for the {@link test.nested.data.Animal} hierarchy. */
	public enum TypeKind {

		/** Type literal for {@link test.nested.data.Zoo.Cat}. */
		CAT,

		/** Type literal for {@link test.nested.data.Zoo.Parrot}. */
		PARROT,
		;

	}

	/** Visitor interface for the {@link test.nested.data.Animal} hierarchy.*/
	public interface Visitor<R,A,E extends Throwable> extends test.nested.data.Zoo.Bird.Visitor<R,A,E> {

		/** Visit case for {@link test.nested.data.Zoo.Cat}.*/
		R visit(test.nested.data.Zoo.Cat self, A arg) throws E;

	}

	/** @see #getName() */
	String NAME__PROP = "name";

	/** Identifier for the property {@link #getName()} in binary format. */
	static final int NAME__ID = 1;

	/** The type code of this instance. */
	TypeKind kind();

	String getName();

	/**
	 * @see #getName()
	 */
	test.nested.data.Animal setName(String value);

	@Override
	public test.nested.data.Animal registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.nested.data.Animal unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.nested.data.Animal readAnimal(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.nested.data.Animal result;
		in.beginArray();
		String type = in.nextString();
		switch (type) {
			case test.nested.data.Zoo.Cat.CAT__TYPE: result = test.nested.data.Zoo.Cat.readCat(in); break;
			case test.nested.data.Zoo.Parrot.PARROT__TYPE: result = test.nested.data.Zoo.Parrot.readParrot(in); break;
			default: in.skipValue(); result = null; break;
		}
		in.endArray();
		return result;
	}

	/** The binary identifier for this concrete type in the polymorphic {@link test.nested.data.Animal} hierarchy. */
	abstract int typeId();

	/** Reads a new instance from the given reader. */
	static test.nested.data.Animal readAnimal(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		int typeField = in.nextName();
		assert typeField == 0;
		int type = in.nextInt();
		test.nested.data.Animal result;
		switch (type) {
			case test.nested.data.Zoo.Cat.CAT__TYPE_ID: result = test.nested.data.impl.Zoo_Impl.Cat_Impl.readCat_Content(in); break;
			case test.nested.data.Zoo.Parrot.PARROT__TYPE_ID: result = test.nested.data.impl.Zoo_Impl.Parrot_Impl.readParrot_Content(in); break;
			default: result = null; while (in.hasNext()) {in.skipValue(); }
		}
		in.endObject();
		return result;
	}

	/** Creates a new {@link Animal} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Animal readAnimal(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.nested.data.impl.Animal_Impl.readAnimal_XmlContent(in);
	}

	/** Accepts the given visitor. */
	public abstract <R,A,E extends Throwable> R visit(Visitor<R,A,E> v, A arg) throws E;

}
