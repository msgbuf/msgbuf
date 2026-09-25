package test.nested.data;

/**
 * A hierarchy nested two levels deep.
 */
public interface Level1 extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {
	public interface Level2 extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {
		public interface Node extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

			/** Type codes for the {@link test.nested.data.Level1.Level2.Node} hierarchy. */
			public enum TypeKind {

				/** Type literal for {@link test.nested.data.Level1.Level2.Branch}. */
				BRANCH,

				/** Type literal for {@link test.nested.data.Level1.Level2.Root}. */
				ROOT,

				/** Type literal for {@link test.nested.data.Level1.Level2.Leaf}. */
				LEAF,
				;

			}

			/** Visitor interface for the {@link test.nested.data.Level1.Level2.Node} hierarchy.*/
			public interface Visitor<R,A,E extends Throwable> extends test.nested.data.Level1.Level2.Composite.Visitor<R,A,E> {

				/** Visit case for {@link test.nested.data.Level1.Level2.Leaf}.*/
				R visit(test.nested.data.Level1.Level2.Leaf self, A arg) throws E;

			}

			/** @see #getLabel() */
			String LABEL__PROP = "label";

			/** Identifier for the property {@link #getLabel()} in binary format. */
			static final int LABEL__ID = 1;

			/** The type code of this instance. */
			TypeKind kind();

			String getLabel();

			/**
			 * @see #getLabel()
			 */
			test.nested.data.Level1.Level2.Node setLabel(String value);

			@Override
			public test.nested.data.Level1.Level2.Node registerListener(de.haumacher.msgbuf.observer.Listener l);

			@Override
			public test.nested.data.Level1.Level2.Node unregisterListener(de.haumacher.msgbuf.observer.Listener l);

			/** Reads a new instance from the given reader. */
			static test.nested.data.Level1.Level2.Node readNode(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
				test.nested.data.Level1.Level2.Node result;
				in.beginArray();
				String type = in.nextString();
				switch (type) {
					case test.nested.data.Level1.Level2.Branch.BRANCH__TYPE: result = test.nested.data.Level1.Level2.Branch.readBranch(in); break;
					case test.nested.data.Level1.Level2.Root.ROOT__TYPE: result = test.nested.data.Level1.Level2.Root.readRoot(in); break;
					case test.nested.data.Level1.Level2.Leaf.LEAF__TYPE: result = test.nested.data.Level1.Level2.Leaf.readLeaf(in); break;
					default: in.skipValue(); result = null; break;
				}
				in.endArray();
				return result;
			}

			/** The binary identifier for this concrete type in the polymorphic {@link test.nested.data.Level1.Level2.Node} hierarchy. */
			abstract int typeId();

			/** Reads a new instance from the given reader. */
			static test.nested.data.Level1.Level2.Node readNode(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
				in.beginObject();
				int typeField = in.nextName();
				assert typeField == 0;
				int type = in.nextInt();
				test.nested.data.Level1.Level2.Node result;
				switch (type) {
					case test.nested.data.Level1.Level2.Branch.BRANCH__TYPE_ID: result = test.nested.data.impl.Level1_Impl.Level2_Impl.Branch_Impl.readBranch_Content(in); break;
					case test.nested.data.Level1.Level2.Root.ROOT__TYPE_ID: result = test.nested.data.impl.Level1_Impl.Level2_Impl.Root_Impl.readRoot_Content(in); break;
					case test.nested.data.Level1.Level2.Leaf.LEAF__TYPE_ID: result = test.nested.data.impl.Level1_Impl.Level2_Impl.Leaf_Impl.readLeaf_Content(in); break;
					default: result = null; while (in.hasNext()) {in.skipValue(); }
				}
				in.endObject();
				return result;
			}

			/** Creates a new {@link Node} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
			public static Node readNode(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
				in.nextTag();
				return test.nested.data.impl.Level1_Impl.Level2_Impl.Node_Impl.readNode_XmlContent(in);
			}

			/** Accepts the given visitor. */
			public abstract <R,A,E extends Throwable> R visit(Visitor<R,A,E> v, A arg) throws E;

		}
		/**
		 * Abstract intermediate.
		 */
		public interface Composite extends test.nested.data.Level1.Level2.Node {

			/** Visitor interface for the {@link test.nested.data.Level1.Level2.Composite} hierarchy.*/
			public interface Visitor<R,A,E extends Throwable> {

				/** Visit case for {@link test.nested.data.Level1.Level2.Branch}.*/
				R visit(test.nested.data.Level1.Level2.Branch self, A arg) throws E;

				/** Visit case for {@link test.nested.data.Level1.Level2.Root}.*/
				R visit(test.nested.data.Level1.Level2.Root self, A arg) throws E;

			}

			/** @see #getChildren() */
			String CHILDREN__PROP = "children";

			/** Identifier for the property {@link #getChildren()} in binary format. */
			static final int CHILDREN__ID = 2;

			java.util.List<test.nested.data.Level1.Level2.Node> getChildren();

			/**
			 * @see #getChildren()
			 */
			test.nested.data.Level1.Level2.Composite setChildren(java.util.List<? extends test.nested.data.Level1.Level2.Node> value);

			/**
			 * Adds a value to the {@link #getChildren()} list.
			 */
			test.nested.data.Level1.Level2.Composite addChildren(test.nested.data.Level1.Level2.Node value);

			/**
			 * Removes a value from the {@link #getChildren()} list.
			 */
			void removeChildren(test.nested.data.Level1.Level2.Node value);

			@Override
			test.nested.data.Level1.Level2.Composite setLabel(String value);

			/** Reads a new instance from the given reader. */
			static test.nested.data.Level1.Level2.Composite readComposite(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
				test.nested.data.Level1.Level2.Composite result;
				in.beginArray();
				String type = in.nextString();
				switch (type) {
					case test.nested.data.Level1.Level2.Branch.BRANCH__TYPE: result = test.nested.data.Level1.Level2.Branch.readBranch(in); break;
					case test.nested.data.Level1.Level2.Root.ROOT__TYPE: result = test.nested.data.Level1.Level2.Root.readRoot(in); break;
					default: in.skipValue(); result = null; break;
				}
				in.endArray();
				return result;
			}

			/** Reads a new instance from the given reader. */
			static test.nested.data.Level1.Level2.Composite readComposite(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
				in.beginObject();
				int typeField = in.nextName();
				assert typeField == 0;
				int type = in.nextInt();
				test.nested.data.Level1.Level2.Composite result;
				switch (type) {
					case test.nested.data.Level1.Level2.Branch.BRANCH__TYPE_ID: result = test.nested.data.impl.Level1_Impl.Level2_Impl.Branch_Impl.readBranch_Content(in); break;
					case test.nested.data.Level1.Level2.Root.ROOT__TYPE_ID: result = test.nested.data.impl.Level1_Impl.Level2_Impl.Root_Impl.readRoot_Content(in); break;
					default: result = null; while (in.hasNext()) {in.skipValue(); }
				}
				in.endObject();
				return result;
			}

			/** Creates a new {@link Composite} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
			public static Composite readComposite(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
				in.nextTag();
				return test.nested.data.impl.Level1_Impl.Level2_Impl.Composite_Impl.readComposite_XmlContent(in);
			}

			/** Accepts the given visitor. */
			public abstract <R,A,E extends Throwable> R visit(Visitor<R,A,E> v, A arg) throws E;

		}
		public interface Leaf extends test.nested.data.Level1.Level2.Node {

			/**
			 * Creates a {@link test.nested.data.Level1.Level2.Leaf} instance.
			 */
			static test.nested.data.Level1.Level2.Leaf create() {
				return new test.nested.data.impl.Level1_Impl.Level2_Impl.Leaf_Impl();
			}

			/** Identifier for the {@link test.nested.data.Level1.Level2.Leaf} type in JSON format. */
			String LEAF__TYPE = "Leaf";

			/** @see #getValue() */
			String VALUE__PROP = "value";

			/** Identifier for the {@link test.nested.data.Level1.Level2.Leaf} type in binary format. */
			static final int LEAF__TYPE_ID = 3;

			/** Identifier for the property {@link #getValue()} in binary format. */
			static final int VALUE__ID = 2;

			int getValue();

			/**
			 * @see #getValue()
			 */
			test.nested.data.Level1.Level2.Leaf setValue(int value);

			@Override
			test.nested.data.Level1.Level2.Leaf setLabel(String value);

			/** Reads a new instance from the given reader. */
			static test.nested.data.Level1.Level2.Leaf readLeaf(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
				test.nested.data.impl.Level1_Impl.Level2_Impl.Leaf_Impl result = new test.nested.data.impl.Level1_Impl.Level2_Impl.Leaf_Impl();
				result.readContent(in);
				return result;
			}

			/** Reads a new instance from the given reader. */
			static test.nested.data.Level1.Level2.Leaf readLeaf(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
				in.beginObject();
				test.nested.data.Level1.Level2.Leaf result = test.nested.data.impl.Level1_Impl.Level2_Impl.Leaf_Impl.readLeaf_Content(in);
				in.endObject();
				return result;
			}

			/** Creates a new {@link Leaf} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
			public static Leaf readLeaf(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
				in.nextTag();
				return test.nested.data.impl.Level1_Impl.Level2_Impl.Leaf_Impl.readLeaf_XmlContent(in);
			}

		}
		public interface Branch extends test.nested.data.Level1.Level2.Composite {

			/**
			 * Creates a {@link test.nested.data.Level1.Level2.Branch} instance.
			 */
			static test.nested.data.Level1.Level2.Branch create() {
				return new test.nested.data.impl.Level1_Impl.Level2_Impl.Branch_Impl();
			}

			/** Identifier for the {@link test.nested.data.Level1.Level2.Branch} type in JSON format. */
			String BRANCH__TYPE = "Branch";

			/** @see #isExpanded() */
			String EXPANDED__PROP = "expanded";

			/** Identifier for the {@link test.nested.data.Level1.Level2.Branch} type in binary format. */
			static final int BRANCH__TYPE_ID = 1;

			/** Identifier for the property {@link #isExpanded()} in binary format. */
			static final int EXPANDED__ID = 3;

			boolean isExpanded();

			/**
			 * @see #isExpanded()
			 */
			test.nested.data.Level1.Level2.Branch setExpanded(boolean value);

			@Override
			test.nested.data.Level1.Level2.Branch setChildren(java.util.List<? extends test.nested.data.Level1.Level2.Node> value);

			@Override
			test.nested.data.Level1.Level2.Branch addChildren(test.nested.data.Level1.Level2.Node value);

			@Override
			test.nested.data.Level1.Level2.Branch setLabel(String value);

			/** Reads a new instance from the given reader. */
			static test.nested.data.Level1.Level2.Branch readBranch(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
				test.nested.data.impl.Level1_Impl.Level2_Impl.Branch_Impl result = new test.nested.data.impl.Level1_Impl.Level2_Impl.Branch_Impl();
				result.readContent(in);
				return result;
			}

			/** Reads a new instance from the given reader. */
			static test.nested.data.Level1.Level2.Branch readBranch(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
				in.beginObject();
				test.nested.data.Level1.Level2.Branch result = test.nested.data.impl.Level1_Impl.Level2_Impl.Branch_Impl.readBranch_Content(in);
				in.endObject();
				return result;
			}

			/** Creates a new {@link Branch} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
			public static Branch readBranch(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
				in.nextTag();
				return test.nested.data.impl.Level1_Impl.Level2_Impl.Branch_Impl.readBranch_XmlContent(in);
			}

		}
		public interface Root extends test.nested.data.Level1.Level2.Composite {

			/**
			 * Creates a {@link test.nested.data.Level1.Level2.Root} instance.
			 */
			static test.nested.data.Level1.Level2.Root create() {
				return new test.nested.data.impl.Level1_Impl.Level2_Impl.Root_Impl();
			}

			/** Identifier for the {@link test.nested.data.Level1.Level2.Root} type in JSON format. */
			String ROOT__TYPE = "Root";

			/** @see #getTitle() */
			String TITLE__PROP = "title";

			/** Identifier for the {@link test.nested.data.Level1.Level2.Root} type in binary format. */
			static final int ROOT__TYPE_ID = 2;

			/** Identifier for the property {@link #getTitle()} in binary format. */
			static final int TITLE__ID = 3;

			String getTitle();

			/**
			 * @see #getTitle()
			 */
			test.nested.data.Level1.Level2.Root setTitle(String value);

			@Override
			test.nested.data.Level1.Level2.Root setChildren(java.util.List<? extends test.nested.data.Level1.Level2.Node> value);

			@Override
			test.nested.data.Level1.Level2.Root addChildren(test.nested.data.Level1.Level2.Node value);

			@Override
			test.nested.data.Level1.Level2.Root setLabel(String value);

			/** Reads a new instance from the given reader. */
			static test.nested.data.Level1.Level2.Root readRoot(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
				test.nested.data.impl.Level1_Impl.Level2_Impl.Root_Impl result = new test.nested.data.impl.Level1_Impl.Level2_Impl.Root_Impl();
				result.readContent(in);
				return result;
			}

			/** Reads a new instance from the given reader. */
			static test.nested.data.Level1.Level2.Root readRoot(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
				in.beginObject();
				test.nested.data.Level1.Level2.Root result = test.nested.data.impl.Level1_Impl.Level2_Impl.Root_Impl.readRoot_Content(in);
				in.endObject();
				return result;
			}

			/** Creates a new {@link Root} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
			public static Root readRoot(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
				in.nextTag();
				return test.nested.data.impl.Level1_Impl.Level2_Impl.Root_Impl.readRoot_XmlContent(in);
			}

		}

		/**
		 * Creates a {@link test.nested.data.Level1.Level2} instance.
		 */
		static test.nested.data.Level1.Level2 create() {
			return new test.nested.data.impl.Level1_Impl.Level2_Impl();
		}

		/** Identifier for the {@link test.nested.data.Level1.Level2} type in JSON format. */
		String LEVEL_2__TYPE = "Level2";

		@Override
		public test.nested.data.Level1.Level2 registerListener(de.haumacher.msgbuf.observer.Listener l);

		@Override
		public test.nested.data.Level1.Level2 unregisterListener(de.haumacher.msgbuf.observer.Listener l);

		/** Reads a new instance from the given reader. */
		static test.nested.data.Level1.Level2 readLevel2(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			test.nested.data.impl.Level1_Impl.Level2_Impl result = new test.nested.data.impl.Level1_Impl.Level2_Impl();
			result.readContent(in);
			return result;
		}

		/** Reads a new instance from the given reader. */
		static test.nested.data.Level1.Level2 readLevel2(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			in.beginObject();
			test.nested.data.Level1.Level2 result = test.nested.data.impl.Level1_Impl.Level2_Impl.readLevel2_Content(in);
			in.endObject();
			return result;
		}

		/** Creates a new {@link Level2} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Level2 readLevel2(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			in.nextTag();
			return test.nested.data.impl.Level1_Impl.Level2_Impl.readLevel2_XmlContent(in);
		}

	}

	/**
	 * Creates a {@link test.nested.data.Level1} instance.
	 */
	static test.nested.data.Level1 create() {
		return new test.nested.data.impl.Level1_Impl();
	}

	/** Identifier for the {@link test.nested.data.Level1} type in JSON format. */
	String LEVEL_1__TYPE = "Level1";

	/** @see #getNode() */
	String NODE__PROP = "node";

	/** @see #getNodes() */
	String NODES__PROP = "nodes";

	/** Identifier for the property {@link #getNode()} in binary format. */
	static final int NODE__ID = 1;

	/** Identifier for the property {@link #getNodes()} in binary format. */
	static final int NODES__ID = 2;

	test.nested.data.Level1.Level2.Node getNode();

	/**
	 * @see #getNode()
	 */
	test.nested.data.Level1 setNode(test.nested.data.Level1.Level2.Node value);

	/**
	 * Checks, whether {@link #getNode()} has a value.
	 */
	boolean hasNode();

	java.util.List<test.nested.data.Level1.Level2.Node> getNodes();

	/**
	 * @see #getNodes()
	 */
	test.nested.data.Level1 setNodes(java.util.List<? extends test.nested.data.Level1.Level2.Node> value);

	/**
	 * Adds a value to the {@link #getNodes()} list.
	 */
	test.nested.data.Level1 addNodes(test.nested.data.Level1.Level2.Node value);

	/**
	 * Removes a value from the {@link #getNodes()} list.
	 */
	void removeNodes(test.nested.data.Level1.Level2.Node value);

	@Override
	public test.nested.data.Level1 registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.nested.data.Level1 unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.nested.data.Level1 readLevel1(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.nested.data.impl.Level1_Impl result = new test.nested.data.impl.Level1_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.nested.data.Level1 readLevel1(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.nested.data.Level1 result = test.nested.data.impl.Level1_Impl.readLevel1_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link Level1} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Level1 readLevel1(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.nested.data.impl.Level1_Impl.readLevel1_XmlContent(in);
	}

}
