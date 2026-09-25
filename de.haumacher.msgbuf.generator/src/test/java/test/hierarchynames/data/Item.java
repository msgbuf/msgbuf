package test.hierarchynames.data;

/**
 * Referenced from the readers of Outer.Shape, where Outer.Item shadows its simple name.
 */
public interface Item extends test.hierarchynames.data.Outer.Shape {

	/**
	 * Creates a {@link test.hierarchynames.data.Item} instance.
	 */
	static test.hierarchynames.data.Item create() {
		return new test.hierarchynames.data.impl.Item_Impl();
	}

	/** Identifier for the {@link test.hierarchynames.data.Item} type in JSON format. */
	String ITEM__TYPE = "TopItem";

	/** @see #getTop() */
	String TOP__PROP = "top";

	/** Identifier for the {@link test.hierarchynames.data.Item} type in binary format. */
	static final int ITEM__TYPE_ID = 1;

	/** Identifier for the property {@link #getTop()} in binary format. */
	static final int TOP__ID = 1;

	String getTop();

	/**
	 * @see #getTop()
	 */
	test.hierarchynames.data.Item setTop(String value);

	/** Reads a new instance from the given reader. */
	static test.hierarchynames.data.Item readItem(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.hierarchynames.data.impl.Item_Impl result = new test.hierarchynames.data.impl.Item_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.hierarchynames.data.Item readItem(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.hierarchynames.data.Item result = test.hierarchynames.data.impl.Item_Impl.readItem_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link Item} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Item readItem(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.hierarchynames.data.impl.Item_Impl.readItem_XmlContent(in);
	}

}
