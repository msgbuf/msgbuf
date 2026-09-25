package test.hierarchynames.data;

public interface A extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {
	public interface Item extends test.hierarchynames.data.Msg {

		/**
		 * Creates a {@link test.hierarchynames.data.A.Item} instance.
		 */
		static test.hierarchynames.data.A.Item create() {
			return new test.hierarchynames.data.impl.A_Impl.Item_Impl();
		}

		/** Identifier for the {@link test.hierarchynames.data.A.Item} type in JSON format. */
		String ITEM__TYPE = "A.Item";

		/** @see #getA() */
		String A__PROP = "a";

		/** Identifier for the {@link test.hierarchynames.data.A.Item} type in binary format. */
		static final int ITEM__TYPE_ID = 1;

		/** Identifier for the property {@link #getA()} in binary format. */
		static final int A__ID = 1;

		String getA();

		/**
		 * @see #getA()
		 */
		test.hierarchynames.data.A.Item setA(String value);

		/** Reads a new instance from the given reader. */
		static test.hierarchynames.data.A.Item readItem(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			test.hierarchynames.data.impl.A_Impl.Item_Impl result = new test.hierarchynames.data.impl.A_Impl.Item_Impl();
			result.readContent(in);
			return result;
		}

		/** Reads a new instance from the given reader. */
		static test.hierarchynames.data.A.Item readItem(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			in.beginObject();
			test.hierarchynames.data.A.Item result = test.hierarchynames.data.impl.A_Impl.Item_Impl.readItem_Content(in);
			in.endObject();
			return result;
		}

		/** Creates a new {@link Item} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Item readItem(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			in.nextTag();
			return test.hierarchynames.data.impl.A_Impl.Item_Impl.readItem_XmlContent(in);
		}

	}

	/**
	 * Creates a {@link test.hierarchynames.data.A} instance.
	 */
	static test.hierarchynames.data.A create() {
		return new test.hierarchynames.data.impl.A_Impl();
	}

	/** Identifier for the {@link test.hierarchynames.data.A} type in JSON format. */
	String A__TYPE = "A";

	@Override
	public test.hierarchynames.data.A registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.hierarchynames.data.A unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.hierarchynames.data.A readA(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.hierarchynames.data.impl.A_Impl result = new test.hierarchynames.data.impl.A_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.hierarchynames.data.A readA(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.hierarchynames.data.A result = test.hierarchynames.data.impl.A_Impl.readA_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link A} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static A readA(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.hierarchynames.data.impl.A_Impl.readA_XmlContent(in);
	}

}
