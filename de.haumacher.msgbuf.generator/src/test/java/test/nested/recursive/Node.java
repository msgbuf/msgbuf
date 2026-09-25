package test.nested.recursive;

/**
 * A concrete message with a nested specialization of itself.
 */
public interface Node extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/** Type codes for the {@link test.nested.recursive.Node} hierarchy. */
	public enum TypeKind {

		/** Type literal for {@link test.nested.recursive.Node}. */
		NODE,

		/** Type literal for {@link test.nested.recursive.Node.Special}. */
		SPECIAL,
		;

	}
	public interface Special extends test.nested.recursive.Node {

		/**
		 * Creates a {@link test.nested.recursive.Node.Special} instance.
		 */
		static test.nested.recursive.Node.Special create() {
			return new test.nested.recursive.impl.Node_Impl.Special_Impl();
		}

		/** Identifier for the {@link test.nested.recursive.Node.Special} type in JSON format. */
		String SPECIAL__TYPE = "Special";

		/** @see #getWeight() */
		String WEIGHT__PROP = "weight";

		/** Identifier for the property {@link #getWeight()} in binary format. */
		static final int WEIGHT__ID = 3;

		int getWeight();

		/**
		 * @see #getWeight()
		 */
		test.nested.recursive.Node.Special setWeight(int value);

		@Override
		test.nested.recursive.Node.Special setName(String value);

		@Override
		test.nested.recursive.Node.Special setChildren(java.util.List<? extends test.nested.recursive.Node> value);

		@Override
		test.nested.recursive.Node.Special addChildren(test.nested.recursive.Node value);

		/** Reads a new instance from the given reader. */
		static test.nested.recursive.Node.Special readSpecial(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			test.nested.recursive.impl.Node_Impl.Special_Impl result = new test.nested.recursive.impl.Node_Impl.Special_Impl();
			result.readContent(in);
			return result;
		}

		/** Reads a new instance from the given reader. */
		static test.nested.recursive.Node.Special readSpecial(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			in.beginObject();
			test.nested.recursive.Node.Special result = test.nested.recursive.impl.Node_Impl.Special_Impl.readSpecial_Content(in);
			in.endObject();
			return result;
		}

		/** Creates a new {@link Special} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Special readSpecial(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			in.nextTag();
			return test.nested.recursive.impl.Node_Impl.Special_Impl.readSpecial_XmlContent(in);
		}

	}

	/**
	 * Creates a {@link test.nested.recursive.Node} instance.
	 */
	static test.nested.recursive.Node create() {
		return new test.nested.recursive.impl.Node_Impl();
	}

	/** Identifier for the {@link test.nested.recursive.Node} type in JSON format. */
	String NODE__TYPE = "Node";

	/** @see #getName() */
	String NAME__PROP = "name";

	/** @see #getChildren() */
	String CHILDREN__PROP = "children";

	/** Identifier for the property {@link #getName()} in binary format. */
	static final int NAME__ID = 1;

	/** Identifier for the property {@link #getChildren()} in binary format. */
	static final int CHILDREN__ID = 2;

	/** The type code of this instance. */
	TypeKind kind();

	String getName();

	/**
	 * @see #getName()
	 */
	test.nested.recursive.Node setName(String value);

	java.util.List<test.nested.recursive.Node> getChildren();

	/**
	 * @see #getChildren()
	 */
	test.nested.recursive.Node setChildren(java.util.List<? extends test.nested.recursive.Node> value);

	/**
	 * Adds a value to the {@link #getChildren()} list.
	 */
	test.nested.recursive.Node addChildren(test.nested.recursive.Node value);

	/**
	 * Removes a value from the {@link #getChildren()} list.
	 */
	void removeChildren(test.nested.recursive.Node value);

	@Override
	public test.nested.recursive.Node registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.nested.recursive.Node unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.nested.recursive.Node readNode(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.nested.recursive.impl.Node_Impl result = new test.nested.recursive.impl.Node_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.nested.recursive.Node readNode(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.nested.recursive.Node result = test.nested.recursive.impl.Node_Impl.readNode_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link Node} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Node readNode(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.nested.recursive.impl.Node_Impl.readNode_XmlContent(in);
	}

}
