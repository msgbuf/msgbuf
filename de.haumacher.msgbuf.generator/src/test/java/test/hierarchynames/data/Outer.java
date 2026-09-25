package test.hierarchynames.data;

public interface Outer extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {
	/**
	 * Not part of the hierarchy, but in scope in the code of Shape.
	 */
	public interface Item extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

		/**
		 * Creates a {@link test.hierarchynames.data.Outer.Item} instance.
		 */
		static test.hierarchynames.data.Outer.Item create() {
			return new test.hierarchynames.data.impl.Outer_Impl.Item_Impl();
		}

		/** Identifier for the {@link test.hierarchynames.data.Outer.Item} type in JSON format. */
		String ITEM__TYPE = "Item";

		/** @see #getOther() */
		String OTHER__PROP = "other";

		/** Identifier for the property {@link #getOther()} in binary format. */
		static final int OTHER__ID = 1;

		String getOther();

		/**
		 * @see #getOther()
		 */
		test.hierarchynames.data.Outer.Item setOther(String value);

		@Override
		public test.hierarchynames.data.Outer.Item registerListener(de.haumacher.msgbuf.observer.Listener l);

		@Override
		public test.hierarchynames.data.Outer.Item unregisterListener(de.haumacher.msgbuf.observer.Listener l);

		/** Reads a new instance from the given reader. */
		static test.hierarchynames.data.Outer.Item readItem(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			test.hierarchynames.data.impl.Outer_Impl.Item_Impl result = new test.hierarchynames.data.impl.Outer_Impl.Item_Impl();
			result.readContent(in);
			return result;
		}

		/** Reads a new instance from the given reader. */
		static test.hierarchynames.data.Outer.Item readItem(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			in.beginObject();
			test.hierarchynames.data.Outer.Item result = test.hierarchynames.data.impl.Outer_Impl.Item_Impl.readItem_Content(in);
			in.endObject();
			return result;
		}

		/** Creates a new {@link Item} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Item readItem(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			in.nextTag();
			return test.hierarchynames.data.impl.Outer_Impl.Item_Impl.readItem_XmlContent(in);
		}

	}
	public interface Shape extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

		/** Visitor interface for the {@link test.hierarchynames.data.Outer.Shape} hierarchy.*/
		public interface Visitor<R,A,E extends Throwable> {

			/** Visit case for {@link test.hierarchynames.data.Item}.*/
			R visit(test.hierarchynames.data.Item self, A arg) throws E;

		}

		@Override
		public test.hierarchynames.data.Outer.Shape registerListener(de.haumacher.msgbuf.observer.Listener l);

		@Override
		public test.hierarchynames.data.Outer.Shape unregisterListener(de.haumacher.msgbuf.observer.Listener l);

		/** Reads a new instance from the given reader. */
		static test.hierarchynames.data.Outer.Shape readShape(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			test.hierarchynames.data.Outer.Shape result;
			in.beginArray();
			String type = in.nextString();
			switch (type) {
				case test.hierarchynames.data.Item.ITEM__TYPE: result = test.hierarchynames.data.Item.readItem(in); break;
				default: in.skipValue(); result = null; break;
			}
			in.endArray();
			return result;
		}

		/** The binary identifier for this concrete type in the polymorphic {@link test.hierarchynames.data.Outer.Shape} hierarchy. */
		abstract int typeId();

		/** Reads a new instance from the given reader. */
		static test.hierarchynames.data.Outer.Shape readShape(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			in.beginObject();
			int typeField = in.nextName();
			assert typeField == 0;
			int type = in.nextInt();
			test.hierarchynames.data.Outer.Shape result;
			switch (type) {
				case test.hierarchynames.data.Item.ITEM__TYPE_ID: result = test.hierarchynames.data.impl.Item_Impl.readItem_Content(in); break;
				default: result = null; while (in.hasNext()) {in.skipValue(); }
			}
			in.endObject();
			return result;
		}

		/** Creates a new {@link Shape} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Shape readShape(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			in.nextTag();
			return test.hierarchynames.data.impl.Outer_Impl.Shape_Impl.readShape_XmlContent(in);
		}

		/** Accepts the given visitor. */
		public abstract <R,A,E extends Throwable> R visit(Visitor<R,A,E> v, A arg) throws E;

	}

	/**
	 * Creates a {@link test.hierarchynames.data.Outer} instance.
	 */
	static test.hierarchynames.data.Outer create() {
		return new test.hierarchynames.data.impl.Outer_Impl();
	}

	/** Identifier for the {@link test.hierarchynames.data.Outer} type in JSON format. */
	String OUTER__TYPE = "Outer";

	@Override
	public test.hierarchynames.data.Outer registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.hierarchynames.data.Outer unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.hierarchynames.data.Outer readOuter(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.hierarchynames.data.impl.Outer_Impl result = new test.hierarchynames.data.impl.Outer_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.hierarchynames.data.Outer readOuter(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.hierarchynames.data.Outer result = test.hierarchynames.data.impl.Outer_Impl.readOuter_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link Outer} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Outer readOuter(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.hierarchynames.data.impl.Outer_Impl.readOuter_XmlContent(in);
	}

}
