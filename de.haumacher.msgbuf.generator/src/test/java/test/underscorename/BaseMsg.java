package test.underscorename;

public interface BaseMsg extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable {

	/** Type codes for the {@link BaseMsg} hierarchy. */
	public enum TypeKind {

		/** Type literal for {@link SomeName}. */
		SOME_NAME,

		/** Type literal for {@link AnnotatedMessage}. */
		ANNOTATED_MESSAGE,
		;

	}

	/** Visitor interface for the {@link BaseMsg} hierarchy.*/
	public interface Visitor<R,A,E extends Throwable> {

		/** Visit case for {@link SomeName}.*/
		R visit(SomeName self, A arg) throws E;

		/** Visit case for {@link AnnotatedMessage}.*/
		R visit(AnnotatedMessage self, A arg) throws E;

	}

	/** The type code of this instance. */
	TypeKind kind();

	@Override
	public BaseMsg registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public BaseMsg unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static BaseMsg readbase_msg(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
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

	/** The binary identifier for this concrete type in the polymorphic {@link BaseMsg} hierarchy. */
	abstract int typeId();

	/** Reads a new instance from the given reader. */
	static BaseMsg readbase_msg(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		int typeField = in.nextName();
		assert typeField == 0;
		int type = in.nextInt();
		BaseMsg result;
		switch (type) {
			case SomeName.SOME_NAME__TYPE_ID: result = test.underscorename.SomeName_Impl.readsome_name_Content(in); break;
			case AnnotatedMessage.ANNOTATED_MESSAGE__TYPE_ID: result = test.underscorename.AnnotatedMessage_Impl.readannotated_message_Content(in); break;
			default: result = null; while (in.hasNext()) {in.skipValue(); }
		}
		in.endObject();
		return result;
	}

	/** Creates a new {@link BaseMsg} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static BaseMsg readBase_msg(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.underscorename.BaseMsg_Impl.readBase_msg_XmlContent(in);
	}

	/** Accepts the given visitor. */
	public abstract <R,A,E extends Throwable> R visit(Visitor<R,A,E> v, A arg) throws E;

}
