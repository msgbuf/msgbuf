package test.graph.data;

/**
 * A concrete type without abstract super type.
 */
public interface SimpleType extends de.haumacher.msgbuf.graph.SharedGraphNode, de.haumacher.msgbuf.xml.XmlSerializable {

	/**
	 * Creates a {@link test.graph.data.SimpleType} instance.
	 */
	static test.graph.data.SimpleType create() {
		return new test.graph.data.impl.SimpleType_Impl();
	}

	/** Identifier for the {@link test.graph.data.SimpleType} type in JSON format. */
	String SIMPLE_TYPE__TYPE = "SimpleType";

	/** @see #getStr() */
	String STR__PROP = "str";

	/** @see #getX() */
	String X__PROP = "x";

	/**
	 * A string property
	 */
	String getStr();

	/**
	 * @see #getStr()
	 */
	test.graph.data.SimpleType setStr(String value);

	/**
	 * An int property
	 */
	int getX();

	/**
	 * @see #getX()
	 */
	test.graph.data.SimpleType setX(int value);

	/** Reads a new instance from the given reader. */
	static test.graph.data.SimpleType readSimpleType(de.haumacher.msgbuf.graph.Scope scope, de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		if (in.peek() == de.haumacher.msgbuf.json.JsonToken.NUMBER) {
			return (test.graph.data.SimpleType) scope.resolveOrFail(in.nextInt());
		}
		in.beginArray();
		String type = in.nextString();
		assert SIMPLE_TYPE__TYPE.equals(type);
		int id = in.nextInt();
		test.graph.data.impl.SimpleType_Impl result = new test.graph.data.impl.SimpleType_Impl();
		scope.readData(result, id, in);
		in.endArray();
		return result;
	}

	/** Creates a new {@link SimpleType} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static SimpleType readSimpleType(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.graph.data.impl.SimpleType_Impl.readSimpleType_XmlContent(in);
	}

}
