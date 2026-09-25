package test.hierarchynames.data;

public interface B extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {
	public interface Item extends test.hierarchynames.data.Msg {

		/**
		 * Creates a {@link test.hierarchynames.data.B.Item} instance.
		 */
		static test.hierarchynames.data.B.Item create() {
			return new test.hierarchynames.data.impl.B_Impl.Item_Impl();
		}

		/** Identifier for the {@link test.hierarchynames.data.B.Item} type in JSON format. */
		String ITEM__TYPE = "Item";

		/** @see #getB() */
		String B__PROP = "b";

		/** Identifier for the {@link test.hierarchynames.data.B.Item} type in binary format. */
		static final int ITEM__TYPE_ID = 2;

		/** Identifier for the property {@link #getB()} in binary format. */
		static final int B__ID = 1;

		int getB();

		/**
		 * @see #getB()
		 */
		test.hierarchynames.data.B.Item setB(int value);

		/** Reads a new instance from the given reader. */
		static test.hierarchynames.data.B.Item readItem(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			test.hierarchynames.data.impl.B_Impl.Item_Impl result = new test.hierarchynames.data.impl.B_Impl.Item_Impl();
			result.readContent(in);
			return result;
		}

		/** Reads a new instance from the given reader. */
		static test.hierarchynames.data.B.Item readItem(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			in.beginObject();
			test.hierarchynames.data.B.Item result = test.hierarchynames.data.impl.B_Impl.Item_Impl.readItem_Content(in);
			in.endObject();
			return result;
		}

		/** Creates a new {@link Item} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Item readItem(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			in.nextTag();
			return test.hierarchynames.data.impl.B_Impl.Item_Impl.readItem_XmlContent(in);
		}

	}

	/**
	 * Creates a {@link test.hierarchynames.data.B} instance.
	 */
	static test.hierarchynames.data.B create() {
		return new test.hierarchynames.data.impl.B_Impl();
	}

	/** Identifier for the {@link test.hierarchynames.data.B} type in JSON format. */
	String B__TYPE = "B";

	@Override
	public test.hierarchynames.data.B registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.hierarchynames.data.B unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.hierarchynames.data.B readB(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.hierarchynames.data.impl.B_Impl result = new test.hierarchynames.data.impl.B_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.hierarchynames.data.B readB(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.hierarchynames.data.B result = test.hierarchynames.data.impl.B_Impl.readB_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link B} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static B readB(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.hierarchynames.data.impl.B_Impl.readB_XmlContent(in);
	}

}
