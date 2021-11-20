package test.underscorename;

public abstract class BaseMsg extends de.haumacher.msgbuf.data.AbstractDataObject implements de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable {

	/** Type codes for the {@link BaseMsg} hierarchy. */
	public enum TypeKind {

		/** Type literal for {@link SomeName}. */
		SOME_NAME,

		/** Type literal for {@link AnnotatedMessage}. */
		ANNOTATED_MESSAGE,
		;

	}

	/** Visitor interface for the {@link BaseMsg} hierarchy.*/
	public interface Visitor<R,A> {

		/** Visit case for {@link SomeName}.*/
		R visit(SomeName self, A arg);

		/** Visit case for {@link AnnotatedMessage}.*/
		R visit(AnnotatedMessage self, A arg);

	}

	/**
	 * Creates a {@link BaseMsg} instance.
	 */
	protected BaseMsg() {
		super();
	}

	/** The type code of this instance. */
	public abstract TypeKind kind();

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public BaseMsg registerListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
		return this;
	}

	@Override
	public BaseMsg unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
		return this;
	}

	/** Reads a new instance from the given reader. */
	public static BaseMsg readbase_msg(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		BaseMsg result;
		in.beginArray();
		String type = in.nextString();
		switch (type) {
			case SomeName.SOME_NAME__TYPE: result = test.underscorename.SomeName.readsome_name(in); break;
			case AnnotatedMessage.ANNOTATED_MESSAGE__TYPE: result = test.underscorename.AnnotatedMessage.readannotated_message(in); break;
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
	public abstract String jsonType();

	/** The binary identifier for this concrete type in the polymorphic {@link BaseMsg} hierarchy. */
	public abstract int typeId();

	@Override
	public final void writeTo(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		out.beginObject();
		out.name(0);
		out.value(typeId());
		writeFields(out);
		out.endObject();
	}

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

	/** Reads a new instance from the given reader. */
	public static BaseMsg readbase_msg(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		BaseMsg result;
		int typeField = in.nextName();
		assert typeField == 0;
		int type = in.nextInt();
		switch (type) {
			case SomeName.SOME_NAME__TYPE_ID: result = test.underscorename.SomeName.create(); break;
			case AnnotatedMessage.ANNOTATED_MESSAGE__TYPE_ID: result = test.underscorename.AnnotatedMessage.create(); break;
			default: while (in.hasNext()) {in.skipValue(); } in.endObject(); return null;
		}
		while (in.hasNext()) {
			int field = in.nextName();
			result.readField(in, field);
		}
		in.endObject();
		return result;
	}

	/** Consumes the value for the field with the given ID and assigns its value. */
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			default: in.skipValue(); 
		}
	}

	/** Accepts the given visitor. */
	public abstract <R,A> R visit(Visitor<R,A> v, A arg);


}
