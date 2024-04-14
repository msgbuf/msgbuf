package test.embedded.data;

public interface Base extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/** Type codes for the {@link test.embedded.data.Base} hierarchy. */
	public enum TypeKind {

		/** Type literal for {@link test.embedded.data.A}. */
		A,

		/** Type literal for {@link test.embedded.data.B}. */
		B,
		;

	}

	/** Visitor interface for the {@link test.embedded.data.Base} hierarchy.*/
	public interface Visitor<R,A,E extends Throwable> {

		/** Visit case for {@link test.embedded.data.A}.*/
		R visit(test.embedded.data.A self, A arg) throws E;

		/** Visit case for {@link test.embedded.data.B}.*/
		R visit(test.embedded.data.B self, A arg) throws E;

	}

	/** The type code of this instance. */
	TypeKind kind();

	@Override
	public test.embedded.data.Base registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.embedded.data.Base unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.embedded.data.Base readBase(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.embedded.data.Base result;
		in.beginArray();
		String type = in.nextString();
		switch (type) {
			case A.A__TYPE: result = test.embedded.data.A.readA(in); break;
			case B.B__TYPE: result = test.embedded.data.B.readB(in); break;
			default: in.skipValue(); result = null; break;
		}
		in.endArray();
		return result;
	}

	/** The binary identifier for this concrete type in the polymorphic {@link test.embedded.data.Base} hierarchy. */
	abstract int typeId();

	/** Reads a new instance from the given reader. */
	static test.embedded.data.Base readBase(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		int typeField = in.nextName();
		assert typeField == 0;
		int type = in.nextInt();
		test.embedded.data.Base result;
		switch (type) {
			case test.embedded.data.A.A__TYPE_ID: result = test.embedded.data.impl.A_Impl.readA_Content(in); break;
			case test.embedded.data.B.B__TYPE_ID: result = test.embedded.data.impl.B_Impl.readB_Content(in); break;
			default: result = null; while (in.hasNext()) {in.skipValue(); }
		}
		in.endObject();
		return result;
	}

	/** Creates a new {@link Base} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Base readBase(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.embedded.data.impl.Base_Impl.readBase_XmlContent(in);
	}

	/** Accepts the given visitor. */
	public abstract <R,A,E extends Throwable> R visit(Visitor<R,A,E> v, A arg) throws E;

}
