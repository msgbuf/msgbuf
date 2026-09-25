package test.nested.doc;

/**
 * A hierarchy nested two levels deep with an abstract intermediate, a nested enum, a reserved-word
 * property and message name, and fields holding it as repeated, map and nullable values (issue #16).
 */
public interface Doc extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {
	public interface Sec extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {
		public interface Item extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

			/** Type codes for the {@link test.nested.doc.Doc.Sec.Item} hierarchy. */
			public enum TypeKind {

				/** Type literal for {@link test.nested.doc.Doc.Sec.Para}. */
				PARA,

				/** Type literal for {@link test.nested.doc.Doc.Sec.Case}. */
				CASE,

				/** Type literal for {@link test.nested.doc.Figure}. */
				FIGURE,
				;

			}

			/** Visitor interface for the {@link test.nested.doc.Doc.Sec.Item} hierarchy.*/
			public interface Visitor<R,A,E extends Throwable> extends test.nested.doc.Doc.Sec.Block.Visitor<R,A,E> {

				// Pure sum interface.

			}

			public enum Kind implements de.haumacher.msgbuf.data.ProtocolEnum {

				PLAIN("PLAIN"),

				RICH("RICH"),

				;

				private final String _protocolName;

				private Kind(String protocolName) {
					_protocolName = protocolName;
				}

				/**
				 * The protocol name of a {@link Kind} constant.
				 *
				 * @see #valueOfProtocol(String)
				 */
				@Override
				public String protocolName() {
					return _protocolName;
				}

				/** Looks up a {@link Kind} constant by it's protocol name. */
				public static Kind valueOfProtocol(String protocolName) {
					if (protocolName == null) { return null; }
					switch (protocolName) {
						case "PLAIN": return PLAIN;
						case "RICH": return RICH;
					}
					return PLAIN;
				}

				/** Writes this instance to the given output. */
				public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
					out.value(protocolName());
				}

				/** Reads a new instance from the given reader. */
				public static Kind readKind(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
					return valueOfProtocol(in.nextString());
				}

				/** Writes this instance to the given binary output. */
				public final void writeTo(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
					switch (this) {
						case PLAIN: out.value(1); break;
						case RICH: out.value(2); break;
						default: out.value(0);
					}
				}

				/** Reads a new instance from the given binary reader. */
				public static Kind readKind(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
					switch (in.nextInt()) {
						case 1: return PLAIN;
						case 2: return RICH;
						default: return PLAIN;
					}
				}
			}

			/** @see #getKind() */
			String KIND__PROP = "kind";

			/** @see #getPackage() */
			String PACKAGE__PROP = "package";

			/** Identifier for the property {@link #getKind()} in binary format. */
			static final int KIND__ID = 1;

			/** Identifier for the property {@link #getPackage()} in binary format. */
			static final int PACKAGE__ID = 2;

			/** The type code of this instance. */
			TypeKind kind();

			test.nested.doc.Doc.Sec.Item.Kind getKind();

			/**
			 * @see #getKind()
			 */
			test.nested.doc.Doc.Sec.Item setKind(test.nested.doc.Doc.Sec.Item.Kind value);

			String getPackage();

			/**
			 * @see #getPackage()
			 */
			test.nested.doc.Doc.Sec.Item setPackage(String value);

			@Override
			public test.nested.doc.Doc.Sec.Item registerListener(de.haumacher.msgbuf.observer.Listener l);

			@Override
			public test.nested.doc.Doc.Sec.Item unregisterListener(de.haumacher.msgbuf.observer.Listener l);

			/** Reads a new instance from the given reader. */
			static test.nested.doc.Doc.Sec.Item readItem(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
				test.nested.doc.Doc.Sec.Item result;
				in.beginArray();
				String type = in.nextString();
				switch (type) {
					case test.nested.doc.Doc.Sec.Para.PARA__TYPE: result = test.nested.doc.Doc.Sec.Para.readPara(in); break;
					case test.nested.doc.Doc.Sec.Case.CASE__TYPE: result = test.nested.doc.Doc.Sec.Case.readCase(in); break;
					case Figure.FIGURE__TYPE: result = test.nested.doc.Figure.readFigure(in); break;
					default: in.skipValue(); result = null; break;
				}
				in.endArray();
				return result;
			}

			/** The binary identifier for this concrete type in the polymorphic {@link test.nested.doc.Doc.Sec.Item} hierarchy. */
			abstract int typeId();

			/** Reads a new instance from the given reader. */
			static test.nested.doc.Doc.Sec.Item readItem(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
				in.beginObject();
				int typeField = in.nextName();
				assert typeField == 0;
				int type = in.nextInt();
				test.nested.doc.Doc.Sec.Item result;
				switch (type) {
					case test.nested.doc.Doc.Sec.Para.PARA__TYPE_ID: result = test.nested.doc.impl.Doc_Impl.Sec_Impl.Para_Impl.readPara_Content(in); break;
					case test.nested.doc.Doc.Sec.Case.CASE__TYPE_ID: result = test.nested.doc.impl.Doc_Impl.Sec_Impl.Case_Impl.readCase_Content(in); break;
					case test.nested.doc.Figure.FIGURE__TYPE_ID: result = test.nested.doc.impl.Figure_Impl.readFigure_Content(in); break;
					default: result = null; while (in.hasNext()) {in.skipValue(); }
				}
				in.endObject();
				return result;
			}

			/** Creates a new {@link Item} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
			public static Item readItem(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
				in.nextTag();
				return test.nested.doc.impl.Doc_Impl.Sec_Impl.Item_Impl.readItem_XmlContent(in);
			}

			/** Accepts the given visitor. */
			public abstract <R,A,E extends Throwable> R visit(Visitor<R,A,E> v, A arg) throws E;

		}
		public interface Block extends test.nested.doc.Doc.Sec.Item {

			/** Visitor interface for the {@link test.nested.doc.Doc.Sec.Block} hierarchy.*/
			public interface Visitor<R,A,E extends Throwable> {

				/** Visit case for {@link test.nested.doc.Doc.Sec.Para}.*/
				R visit(test.nested.doc.Doc.Sec.Para self, A arg) throws E;

				/** Visit case for {@link test.nested.doc.Doc.Sec.Case}.*/
				R visit(test.nested.doc.Doc.Sec.Case self, A arg) throws E;

				/** Visit case for {@link test.nested.doc.Figure}.*/
				R visit(test.nested.doc.Figure self, A arg) throws E;

			}

			/** @see #getWeight() */
			String WEIGHT__PROP = "weight";

			/** Identifier for the property {@link #getWeight()} in binary format. */
			static final int WEIGHT__ID = 3;

			int getWeight();

			/**
			 * @see #getWeight()
			 */
			test.nested.doc.Doc.Sec.Block setWeight(int value);

			@Override
			test.nested.doc.Doc.Sec.Block setKind(test.nested.doc.Doc.Sec.Item.Kind value);

			@Override
			test.nested.doc.Doc.Sec.Block setPackage(String value);

			/** Reads a new instance from the given reader. */
			static test.nested.doc.Doc.Sec.Block readBlock(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
				test.nested.doc.Doc.Sec.Block result;
				in.beginArray();
				String type = in.nextString();
				switch (type) {
					case test.nested.doc.Doc.Sec.Para.PARA__TYPE: result = test.nested.doc.Doc.Sec.Para.readPara(in); break;
					case test.nested.doc.Doc.Sec.Case.CASE__TYPE: result = test.nested.doc.Doc.Sec.Case.readCase(in); break;
					case Figure.FIGURE__TYPE: result = test.nested.doc.Figure.readFigure(in); break;
					default: in.skipValue(); result = null; break;
				}
				in.endArray();
				return result;
			}

			/** Reads a new instance from the given reader. */
			static test.nested.doc.Doc.Sec.Block readBlock(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
				in.beginObject();
				int typeField = in.nextName();
				assert typeField == 0;
				int type = in.nextInt();
				test.nested.doc.Doc.Sec.Block result;
				switch (type) {
					case test.nested.doc.Doc.Sec.Para.PARA__TYPE_ID: result = test.nested.doc.impl.Doc_Impl.Sec_Impl.Para_Impl.readPara_Content(in); break;
					case test.nested.doc.Doc.Sec.Case.CASE__TYPE_ID: result = test.nested.doc.impl.Doc_Impl.Sec_Impl.Case_Impl.readCase_Content(in); break;
					case test.nested.doc.Figure.FIGURE__TYPE_ID: result = test.nested.doc.impl.Figure_Impl.readFigure_Content(in); break;
					default: result = null; while (in.hasNext()) {in.skipValue(); }
				}
				in.endObject();
				return result;
			}

			/** Creates a new {@link Block} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
			public static Block readBlock(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
				in.nextTag();
				return test.nested.doc.impl.Doc_Impl.Sec_Impl.Block_Impl.readBlock_XmlContent(in);
			}

			/** Accepts the given visitor. */
			public abstract <R,A,E extends Throwable> R visit(Visitor<R,A,E> v, A arg) throws E;

		}
		public interface Para extends test.nested.doc.Doc.Sec.Block {

			/**
			 * Creates a {@link test.nested.doc.Doc.Sec.Para} instance.
			 */
			static test.nested.doc.Doc.Sec.Para create() {
				return new test.nested.doc.impl.Doc_Impl.Sec_Impl.Para_Impl();
			}

			/** Identifier for the {@link test.nested.doc.Doc.Sec.Para} type in JSON format. */
			String PARA__TYPE = "Para";

			/** @see #getText() */
			String TEXT__PROP = "text";

			/** Identifier for the {@link test.nested.doc.Doc.Sec.Para} type in binary format. */
			static final int PARA__TYPE_ID = 1;

			/** Identifier for the property {@link #getText()} in binary format. */
			static final int TEXT__ID = 4;

			String getText();

			/**
			 * @see #getText()
			 */
			test.nested.doc.Doc.Sec.Para setText(String value);

			@Override
			test.nested.doc.Doc.Sec.Para setWeight(int value);

			@Override
			test.nested.doc.Doc.Sec.Para setKind(test.nested.doc.Doc.Sec.Item.Kind value);

			@Override
			test.nested.doc.Doc.Sec.Para setPackage(String value);

			/** Reads a new instance from the given reader. */
			static test.nested.doc.Doc.Sec.Para readPara(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
				test.nested.doc.impl.Doc_Impl.Sec_Impl.Para_Impl result = new test.nested.doc.impl.Doc_Impl.Sec_Impl.Para_Impl();
				result.readContent(in);
				return result;
			}

			/** Reads a new instance from the given reader. */
			static test.nested.doc.Doc.Sec.Para readPara(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
				in.beginObject();
				test.nested.doc.Doc.Sec.Para result = test.nested.doc.impl.Doc_Impl.Sec_Impl.Para_Impl.readPara_Content(in);
				in.endObject();
				return result;
			}

			/** Creates a new {@link Para} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
			public static Para readPara(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
				in.nextTag();
				return test.nested.doc.impl.Doc_Impl.Sec_Impl.Para_Impl.readPara_XmlContent(in);
			}

		}
		public interface Case extends test.nested.doc.Doc.Sec.Block {

			/**
			 * Creates a {@link test.nested.doc.Doc.Sec.Case} instance.
			 */
			static test.nested.doc.Doc.Sec.Case create() {
				return new test.nested.doc.impl.Doc_Impl.Sec_Impl.Case_Impl();
			}

			/** Identifier for the {@link test.nested.doc.Doc.Sec.Case} type in JSON format. */
			String CASE__TYPE = "Case";

			/** @see #getChildren() */
			String CHILDREN__PROP = "children";

			/** Identifier for the {@link test.nested.doc.Doc.Sec.Case} type in binary format. */
			static final int CASE__TYPE_ID = 2;

			/** Identifier for the property {@link #getChildren()} in binary format. */
			static final int CHILDREN__ID = 4;

			java.util.List<test.nested.doc.Doc.Sec.Item> getChildren();

			/**
			 * @see #getChildren()
			 */
			test.nested.doc.Doc.Sec.Case setChildren(java.util.List<? extends test.nested.doc.Doc.Sec.Item> value);

			/**
			 * Adds a value to the {@link #getChildren()} list.
			 */
			test.nested.doc.Doc.Sec.Case addChildren(test.nested.doc.Doc.Sec.Item value);

			/**
			 * Removes a value from the {@link #getChildren()} list.
			 */
			void removeChildren(test.nested.doc.Doc.Sec.Item value);

			@Override
			test.nested.doc.Doc.Sec.Case setWeight(int value);

			@Override
			test.nested.doc.Doc.Sec.Case setKind(test.nested.doc.Doc.Sec.Item.Kind value);

			@Override
			test.nested.doc.Doc.Sec.Case setPackage(String value);

			/** Reads a new instance from the given reader. */
			static test.nested.doc.Doc.Sec.Case readCase(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
				test.nested.doc.impl.Doc_Impl.Sec_Impl.Case_Impl result = new test.nested.doc.impl.Doc_Impl.Sec_Impl.Case_Impl();
				result.readContent(in);
				return result;
			}

			/** Reads a new instance from the given reader. */
			static test.nested.doc.Doc.Sec.Case readCase(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
				in.beginObject();
				test.nested.doc.Doc.Sec.Case result = test.nested.doc.impl.Doc_Impl.Sec_Impl.Case_Impl.readCase_Content(in);
				in.endObject();
				return result;
			}

			/** Creates a new {@link Case} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
			public static Case readCase(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
				in.nextTag();
				return test.nested.doc.impl.Doc_Impl.Sec_Impl.Case_Impl.readCase_XmlContent(in);
			}

		}

		/**
		 * Creates a {@link test.nested.doc.Doc.Sec} instance.
		 */
		static test.nested.doc.Doc.Sec create() {
			return new test.nested.doc.impl.Doc_Impl.Sec_Impl();
		}

		/** Identifier for the {@link test.nested.doc.Doc.Sec} type in JSON format. */
		String SEC__TYPE = "Sec";

		@Override
		public test.nested.doc.Doc.Sec registerListener(de.haumacher.msgbuf.observer.Listener l);

		@Override
		public test.nested.doc.Doc.Sec unregisterListener(de.haumacher.msgbuf.observer.Listener l);

		/** Reads a new instance from the given reader. */
		static test.nested.doc.Doc.Sec readSec(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			test.nested.doc.impl.Doc_Impl.Sec_Impl result = new test.nested.doc.impl.Doc_Impl.Sec_Impl();
			result.readContent(in);
			return result;
		}

		/** Reads a new instance from the given reader. */
		static test.nested.doc.Doc.Sec readSec(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			in.beginObject();
			test.nested.doc.Doc.Sec result = test.nested.doc.impl.Doc_Impl.Sec_Impl.readSec_Content(in);
			in.endObject();
			return result;
		}

		/** Creates a new {@link Sec} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Sec readSec(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			in.nextTag();
			return test.nested.doc.impl.Doc_Impl.Sec_Impl.readSec_XmlContent(in);
		}

	}

	/**
	 * Creates a {@link test.nested.doc.Doc} instance.
	 */
	static test.nested.doc.Doc create() {
		return new test.nested.doc.impl.Doc_Impl();
	}

	/** Identifier for the {@link test.nested.doc.Doc} type in JSON format. */
	String DOC__TYPE = "Doc";

	/** @see #getItems() */
	String ITEMS__PROP = "items";

	/** @see #getByName() */
	String BY_NAME__PROP = "byName";

	/** @see #getMaybe() */
	String MAYBE__PROP = "maybe";

	/** Identifier for the property {@link #getItems()} in binary format. */
	static final int ITEMS__ID = 1;

	/** Identifier for the property {@link #getByName()} in binary format. */
	static final int BY_NAME__ID = 2;

	/** Identifier for the property {@link #getMaybe()} in binary format. */
	static final int MAYBE__ID = 3;

	java.util.List<test.nested.doc.Doc.Sec.Item> getItems();

	/**
	 * @see #getItems()
	 */
	test.nested.doc.Doc setItems(java.util.List<? extends test.nested.doc.Doc.Sec.Item> value);

	/**
	 * Adds a value to the {@link #getItems()} list.
	 */
	test.nested.doc.Doc addItem(test.nested.doc.Doc.Sec.Item value);

	/**
	 * Removes a value from the {@link #getItems()} list.
	 */
	void removeItem(test.nested.doc.Doc.Sec.Item value);

	java.util.Map<String, test.nested.doc.Doc.Sec.Item> getByName();

	/**
	 * @see #getByName()
	 */
	test.nested.doc.Doc setByName(java.util.Map<String, test.nested.doc.Doc.Sec.Item> value);

	/**
	 * Adds a key value pair to the {@link #getByName()} map.
	 */
	test.nested.doc.Doc putByName(String key, test.nested.doc.Doc.Sec.Item value);

	/**
	 * Removes a key from the {@link #getByName()} map.
	 */
	void removeByName(String key);

	test.nested.doc.Doc.Sec.Item getMaybe();

	/**
	 * @see #getMaybe()
	 */
	test.nested.doc.Doc setMaybe(test.nested.doc.Doc.Sec.Item value);

	/**
	 * Checks, whether {@link #getMaybe()} has a value.
	 */
	boolean hasMaybe();

	@Override
	public test.nested.doc.Doc registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.nested.doc.Doc unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.nested.doc.Doc readDoc(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.nested.doc.impl.Doc_Impl result = new test.nested.doc.impl.Doc_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.nested.doc.Doc readDoc(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.nested.doc.Doc result = test.nested.doc.impl.Doc_Impl.readDoc_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link Doc} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Doc readDoc(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.nested.doc.impl.Doc_Impl.readDoc_XmlContent(in);
	}

}
