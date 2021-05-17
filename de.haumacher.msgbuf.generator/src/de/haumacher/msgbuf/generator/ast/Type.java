package de.haumacher.msgbuf.generator.ast;

public abstract class Type {

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
	 *
	 * @see #type()
	 */
	protected Type() {
		super();
	}

	private static final int[] FIELDS = {};

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

	/** Writes this instance to the given output. */
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		out.beginObject();
		writeContent(out);
		out.endObject();
	}

	/** Reads all fields of this instance from the given input. */
	protected final void readContent(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		while (in.hasNext()) {
			String field = in.nextName();
			readField(in, field);
		}
	}

	/** Retrieves value of the field with the given index. */
	public Object get(String field) {
		switch (field) {
			default: return null;
		}
	}

	/** Sets the value of the field with the given index. */
	public void set(String field, Object value) {
		// No fields.
	}

	/** Writes all fields of this instance to the given output. */
	protected void writeContent(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		// No fields.
	}

	/** Reads the given field from the given input. */
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			default: in.skipValue();
		}
	}

	/** Accepts the given visitor. */
	public abstract <R,A> R visit(Visitor<R,A> v, A arg);


}
