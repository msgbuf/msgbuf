package test.hierarchynames.data;

public interface Msg extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/** Visitor interface for the {@link test.hierarchynames.data.Msg} hierarchy.*/
	public interface Visitor<R,A,E extends Throwable> {

		/** Visit case for {@link test.hierarchynames.data.A.Item}.*/
		R visit(test.hierarchynames.data.A.Item self, A arg) throws E;

		/** Visit case for {@link test.hierarchynames.data.B.Item}.*/
		R visit(test.hierarchynames.data.B.Item self, A arg) throws E;

	}

	@Override
	public test.hierarchynames.data.Msg registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.hierarchynames.data.Msg unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.hierarchynames.data.Msg readMsg(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.hierarchynames.data.Msg result;
		in.beginArray();
		String type = in.nextString();
		switch (type) {
			case test.hierarchynames.data.A.Item.ITEM__TYPE: result = test.hierarchynames.data.A.Item.readItem(in); break;
			case test.hierarchynames.data.B.Item.ITEM__TYPE: result = test.hierarchynames.data.B.Item.readItem(in); break;
			default: in.skipValue(); result = null; break;
		}
		in.endArray();
		return result;
	}

	/** The binary identifier for this concrete type in the polymorphic {@link test.hierarchynames.data.Msg} hierarchy. */
	abstract int typeId();

	/** Reads a new instance from the given reader. */
	static test.hierarchynames.data.Msg readMsg(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		int typeField = in.nextName();
		assert typeField == 0;
		int type = in.nextInt();
		test.hierarchynames.data.Msg result;
		switch (type) {
			case test.hierarchynames.data.A.Item.ITEM__TYPE_ID: result = test.hierarchynames.data.impl.A_Impl.Item_Impl.readItem_Content(in); break;
			case test.hierarchynames.data.B.Item.ITEM__TYPE_ID: result = test.hierarchynames.data.impl.B_Impl.Item_Impl.readItem_Content(in); break;
			default: result = null; while (in.hasNext()) {in.skipValue(); }
		}
		in.endObject();
		return result;
	}

	/** Creates a new {@link Msg} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Msg readMsg(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.hierarchynames.data.impl.Msg_Impl.readMsg_XmlContent(in);
	}

	/** Accepts the given visitor. */
	public abstract <R,A,E extends Throwable> R visit(Visitor<R,A,E> v, A arg) throws E;

}
