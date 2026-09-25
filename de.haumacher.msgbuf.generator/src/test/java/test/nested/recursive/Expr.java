package test.nested.recursive;

/**
 * Specializations nested in their own generalization (issue #32).
 */
public interface Expr extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	/** Type codes for the {@link test.nested.recursive.Expr} hierarchy. */
	public enum TypeKind {

		/** Type literal for {@link test.nested.recursive.Expr.Literal}. */
		LITERAL,

		/** Type literal for {@link test.nested.recursive.Expr.Sum}. */
		SUM,
		;

	}

	/** Visitor interface for the {@link test.nested.recursive.Expr} hierarchy.*/
	public interface Visitor<R,A,E extends Throwable> {

		/** Visit case for {@link test.nested.recursive.Expr.Literal}.*/
		R visit(test.nested.recursive.Expr.Literal self, A arg) throws E;

		/** Visit case for {@link test.nested.recursive.Expr.Sum}.*/
		R visit(test.nested.recursive.Expr.Sum self, A arg) throws E;

	}
	public interface Literal extends test.nested.recursive.Expr {

		/**
		 * Creates a {@link test.nested.recursive.Expr.Literal} instance.
		 */
		static test.nested.recursive.Expr.Literal create() {
			return new test.nested.recursive.impl.Expr_Impl.Literal_Impl();
		}

		/** Identifier for the {@link test.nested.recursive.Expr.Literal} type in JSON format. */
		String LITERAL__TYPE = "Literal";

		/** @see #getValue() */
		String VALUE__PROP = "value";

		/** Identifier for the {@link test.nested.recursive.Expr.Literal} type in binary format. */
		static final int LITERAL__TYPE_ID = 1;

		/** Identifier for the property {@link #getValue()} in binary format. */
		static final int VALUE__ID = 2;

		int getValue();

		/**
		 * @see #getValue()
		 */
		test.nested.recursive.Expr.Literal setValue(int value);

		@Override
		test.nested.recursive.Expr.Literal setLabel(String value);

		/** Reads a new instance from the given reader. */
		static test.nested.recursive.Expr.Literal readLiteral(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			test.nested.recursive.impl.Expr_Impl.Literal_Impl result = new test.nested.recursive.impl.Expr_Impl.Literal_Impl();
			result.readContent(in);
			return result;
		}

		/** Reads a new instance from the given reader. */
		static test.nested.recursive.Expr.Literal readLiteral(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			in.beginObject();
			test.nested.recursive.Expr.Literal result = test.nested.recursive.impl.Expr_Impl.Literal_Impl.readLiteral_Content(in);
			in.endObject();
			return result;
		}

		/** Creates a new {@link Literal} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Literal readLiteral(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			in.nextTag();
			return test.nested.recursive.impl.Expr_Impl.Literal_Impl.readLiteral_XmlContent(in);
		}

	}
	public interface Sum extends test.nested.recursive.Expr {

		/**
		 * Creates a {@link test.nested.recursive.Expr.Sum} instance.
		 */
		static test.nested.recursive.Expr.Sum create() {
			return new test.nested.recursive.impl.Expr_Impl.Sum_Impl();
		}

		/** Identifier for the {@link test.nested.recursive.Expr.Sum} type in JSON format. */
		String SUM__TYPE = "Sum";

		/** @see #getOperands() */
		String OPERANDS__PROP = "operands";

		/** @see #getFirst() */
		String FIRST__PROP = "first";

		/** Identifier for the {@link test.nested.recursive.Expr.Sum} type in binary format. */
		static final int SUM__TYPE_ID = 2;

		/** Identifier for the property {@link #getOperands()} in binary format. */
		static final int OPERANDS__ID = 2;

		/** Identifier for the property {@link #getFirst()} in binary format. */
		static final int FIRST__ID = 3;

		java.util.List<test.nested.recursive.Expr> getOperands();

		/**
		 * @see #getOperands()
		 */
		test.nested.recursive.Expr.Sum setOperands(java.util.List<? extends test.nested.recursive.Expr> value);

		/**
		 * Adds a value to the {@link #getOperands()} list.
		 */
		test.nested.recursive.Expr.Sum addOperand(test.nested.recursive.Expr value);

		/**
		 * Removes a value from the {@link #getOperands()} list.
		 */
		void removeOperand(test.nested.recursive.Expr value);

		test.nested.recursive.Expr.Literal getFirst();

		/**
		 * @see #getFirst()
		 */
		test.nested.recursive.Expr.Sum setFirst(test.nested.recursive.Expr.Literal value);

		/**
		 * Checks, whether {@link #getFirst()} has a value.
		 */
		boolean hasFirst();

		@Override
		test.nested.recursive.Expr.Sum setLabel(String value);

		/** Reads a new instance from the given reader. */
		static test.nested.recursive.Expr.Sum readSum(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			test.nested.recursive.impl.Expr_Impl.Sum_Impl result = new test.nested.recursive.impl.Expr_Impl.Sum_Impl();
			result.readContent(in);
			return result;
		}

		/** Reads a new instance from the given reader. */
		static test.nested.recursive.Expr.Sum readSum(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			in.beginObject();
			test.nested.recursive.Expr.Sum result = test.nested.recursive.impl.Expr_Impl.Sum_Impl.readSum_Content(in);
			in.endObject();
			return result;
		}

		/** Creates a new {@link Sum} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Sum readSum(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			in.nextTag();
			return test.nested.recursive.impl.Expr_Impl.Sum_Impl.readSum_XmlContent(in);
		}

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
	test.nested.recursive.Expr setLabel(String value);

	@Override
	public test.nested.recursive.Expr registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.nested.recursive.Expr unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.nested.recursive.Expr readExpr(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.nested.recursive.Expr result;
		in.beginArray();
		String type = in.nextString();
		switch (type) {
			case test.nested.recursive.Expr.Literal.LITERAL__TYPE: result = test.nested.recursive.Expr.Literal.readLiteral(in); break;
			case test.nested.recursive.Expr.Sum.SUM__TYPE: result = test.nested.recursive.Expr.Sum.readSum(in); break;
			default: in.skipValue(); result = null; break;
		}
		in.endArray();
		return result;
	}

	/** The binary identifier for this concrete type in the polymorphic {@link test.nested.recursive.Expr} hierarchy. */
	abstract int typeId();

	/** Reads a new instance from the given reader. */
	static test.nested.recursive.Expr readExpr(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		int typeField = in.nextName();
		assert typeField == 0;
		int type = in.nextInt();
		test.nested.recursive.Expr result;
		switch (type) {
			case test.nested.recursive.Expr.Literal.LITERAL__TYPE_ID: result = test.nested.recursive.impl.Expr_Impl.Literal_Impl.readLiteral_Content(in); break;
			case test.nested.recursive.Expr.Sum.SUM__TYPE_ID: result = test.nested.recursive.impl.Expr_Impl.Sum_Impl.readSum_Content(in); break;
			default: result = null; while (in.hasNext()) {in.skipValue(); }
		}
		in.endObject();
		return result;
	}

	/** Creates a new {@link Expr} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Expr readExpr(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.nested.recursive.impl.Expr_Impl.readExpr_XmlContent(in);
	}

	/** Accepts the given visitor. */
	public abstract <R,A,E extends Throwable> R visit(Visitor<R,A,E> v, A arg) throws E;

}
