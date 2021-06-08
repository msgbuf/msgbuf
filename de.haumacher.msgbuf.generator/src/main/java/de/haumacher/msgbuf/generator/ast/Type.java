package de.haumacher.msgbuf.generator.ast;

/**
 * Base class for possible {@link Field} types.
 */
public abstract class Type extends de.haumacher.msgbuf.data.AbstractDataObject implements de.haumacher.msgbuf.binary.BinaryDataObject {

	/** Visitor interface for the {@link Type} hierarchy.*/
	public interface Visitor<R,A> {

		/** Visit case for {@link CustomType}.*/
		R visit(CustomType self, A arg);

		/** Visit case for {@link PrimitiveType}.*/
		R visit(PrimitiveType self, A arg);

		/** Visit case for {@link MapType}.*/
		R visit(MapType self, A arg);

	}

	/**
	 * Creates a {@link Type} instance.
	 */
	protected Type() {
		super();
	}

	/** Reads a new instance from the given reader. */
	public static Type readType(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		Type result;
		in.beginArray();
		String type = in.nextString();
		switch (type) {
			case "CustomType": result = CustomType.readCustomType(in); break;
			case "PrimitiveType": result = PrimitiveType.readPrimitiveType(in); break;
			case "MapType": result = MapType.readMapType(in); break;
			default: in.skipValue(); result = null; break;
		}
		in.endArray();
		return result;
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		out.beginArray();
		out.value(jsonType());
		writeContent(out);
		out.endArray();
	}

	/** The type identifier for this concrete subtype. */
	protected abstract String jsonType();

	@Override
	public final void writeTo(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		out.beginObject();
		out.name(0);
		out.value(typeId());
		writeFields(out);
		out.endObject();
	}

	/** The binary identifier for this concrete type in the polymorphic {@link Type} hierarchy. */
	protected abstract int typeId();

	/**
	 * Serializes all fields of this instance to the given binary output.
	 *
	 * @param out
	 *        The binary output to write to.
	 * @throws java.io.IOException If writing fails.
	 */
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		// No fields to write, hook for subclasses.
	}

	/** Consumes the value for the field with the given ID and assigns its value. */
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			default: in.skipValue(); 
		}
	}

	/** Reads a new instance from the given reader. */
	public static Type readType(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		Type result;
		int typeField = in.nextName();
		assert typeField == 0;
		int type = in.nextInt();
		switch (type) {
			case 1: result = CustomType.create(); break;
			case 2: result = PrimitiveType.create(); break;
			case 3: result = MapType.create(); break;
			default: while (in.hasNext()) {in.skipValue(); } in.endObject(); return null;
		}
		while (in.hasNext()) {
			int field = in.nextName();
			result.readField(in, field);
		}
		in.endObject();
		return result;
	}

	/** Accepts the given visitor. */
	public abstract <R,A> R visit(Visitor<R,A> v, A arg);


}
