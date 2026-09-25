package test.nested.data;

/**
 * Hierarchies with an abstract root declared inside other messages (issue #16).
 */
public interface Outer extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {
	/**
	 * Abstract root of a hierarchy nested in a top-level message.
	 */
	public interface Shape extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

		/** Type codes for the {@link test.nested.data.Outer.Shape} hierarchy. */
		public enum TypeKind {

			/** Type literal for {@link test.nested.data.Outer.Circle}. */
			CIRCLE,

			/** Type literal for {@link test.nested.data.Outer.Square}. */
			SQUARE,

			/** Type literal for {@link test.nested.data.Triangle}. */
			TRIANGLE,
			;

		}

		/** Visitor interface for the {@link test.nested.data.Outer.Shape} hierarchy.*/
		public interface Visitor<R,A,E extends Throwable> {

			/** Visit case for {@link test.nested.data.Outer.Circle}.*/
			R visit(test.nested.data.Outer.Circle self, A arg) throws E;

			/** Visit case for {@link test.nested.data.Outer.Square}.*/
			R visit(test.nested.data.Outer.Square self, A arg) throws E;

			/** Visit case for {@link test.nested.data.Triangle}.*/
			R visit(test.nested.data.Triangle self, A arg) throws E;

		}

		/** @see #getName() */
		String NAME__PROP = "name";

		/** Identifier for the property {@link #getName()} in binary format. */
		static final int NAME__ID = 1;

		/** The type code of this instance. */
		TypeKind kind();

		String getName();

		/**
		 * @see #getName()
		 */
		test.nested.data.Outer.Shape setName(String value);

		@Override
		public test.nested.data.Outer.Shape registerListener(de.haumacher.msgbuf.observer.Listener l);

		@Override
		public test.nested.data.Outer.Shape unregisterListener(de.haumacher.msgbuf.observer.Listener l);

		/** Reads a new instance from the given reader. */
		static test.nested.data.Outer.Shape readShape(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			test.nested.data.Outer.Shape result;
			in.beginArray();
			String type = in.nextString();
			switch (type) {
				case test.nested.data.Outer.Circle.CIRCLE__TYPE: result = test.nested.data.Outer.Circle.readCircle(in); break;
				case test.nested.data.Outer.Square.SQUARE__TYPE: result = test.nested.data.Outer.Square.readSquare(in); break;
				case Triangle.TRIANGLE__TYPE: result = test.nested.data.Triangle.readTriangle(in); break;
				default: in.skipValue(); result = null; break;
			}
			in.endArray();
			return result;
		}

		/** The binary identifier for this concrete type in the polymorphic {@link test.nested.data.Outer.Shape} hierarchy. */
		abstract int typeId();

		/** Reads a new instance from the given reader. */
		static test.nested.data.Outer.Shape readShape(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			in.beginObject();
			int typeField = in.nextName();
			assert typeField == 0;
			int type = in.nextInt();
			test.nested.data.Outer.Shape result;
			switch (type) {
				case test.nested.data.Outer.Circle.CIRCLE__TYPE_ID: result = test.nested.data.impl.Outer_Impl.Circle_Impl.readCircle_Content(in); break;
				case test.nested.data.Outer.Square.SQUARE__TYPE_ID: result = test.nested.data.impl.Outer_Impl.Square_Impl.readSquare_Content(in); break;
				case test.nested.data.Triangle.TRIANGLE__TYPE_ID: result = test.nested.data.impl.Triangle_Impl.readTriangle_Content(in); break;
				default: result = null; while (in.hasNext()) {in.skipValue(); }
			}
			in.endObject();
			return result;
		}

		/** Creates a new {@link Shape} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Shape readShape(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			in.nextTag();
			return test.nested.data.impl.Outer_Impl.Shape_Impl.readShape_XmlContent(in);
		}

		/** Accepts the given visitor. */
		public abstract <R,A,E extends Throwable> R visit(Visitor<R,A,E> v, A arg) throws E;

	}
	public interface Circle extends test.nested.data.Outer.Shape {

		/**
		 * Creates a {@link test.nested.data.Outer.Circle} instance.
		 */
		static test.nested.data.Outer.Circle create() {
			return new test.nested.data.impl.Outer_Impl.Circle_Impl();
		}

		/** Identifier for the {@link test.nested.data.Outer.Circle} type in JSON format. */
		String CIRCLE__TYPE = "Circle";

		/** @see #getRadius() */
		String RADIUS__PROP = "radius";

		/** Identifier for the {@link test.nested.data.Outer.Circle} type in binary format. */
		static final int CIRCLE__TYPE_ID = 1;

		/** Identifier for the property {@link #getRadius()} in binary format. */
		static final int RADIUS__ID = 2;

		int getRadius();

		/**
		 * @see #getRadius()
		 */
		test.nested.data.Outer.Circle setRadius(int value);

		@Override
		test.nested.data.Outer.Circle setName(String value);

		/** Reads a new instance from the given reader. */
		static test.nested.data.Outer.Circle readCircle(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			test.nested.data.impl.Outer_Impl.Circle_Impl result = new test.nested.data.impl.Outer_Impl.Circle_Impl();
			result.readContent(in);
			return result;
		}

		/** Reads a new instance from the given reader. */
		static test.nested.data.Outer.Circle readCircle(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			in.beginObject();
			test.nested.data.Outer.Circle result = test.nested.data.impl.Outer_Impl.Circle_Impl.readCircle_Content(in);
			in.endObject();
			return result;
		}

		/** Creates a new {@link Circle} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Circle readCircle(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			in.nextTag();
			return test.nested.data.impl.Outer_Impl.Circle_Impl.readCircle_XmlContent(in);
		}

	}
	public interface Square extends test.nested.data.Outer.Shape {

		/**
		 * Creates a {@link test.nested.data.Outer.Square} instance.
		 */
		static test.nested.data.Outer.Square create() {
			return new test.nested.data.impl.Outer_Impl.Square_Impl();
		}

		/** Identifier for the {@link test.nested.data.Outer.Square} type in JSON format. */
		String SQUARE__TYPE = "Square";

		/** @see #getSide() */
		String SIDE__PROP = "side";

		/** Identifier for the {@link test.nested.data.Outer.Square} type in binary format. */
		static final int SQUARE__TYPE_ID = 2;

		/** Identifier for the property {@link #getSide()} in binary format. */
		static final int SIDE__ID = 2;

		int getSide();

		/**
		 * @see #getSide()
		 */
		test.nested.data.Outer.Square setSide(int value);

		@Override
		test.nested.data.Outer.Square setName(String value);

		/** Reads a new instance from the given reader. */
		static test.nested.data.Outer.Square readSquare(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			test.nested.data.impl.Outer_Impl.Square_Impl result = new test.nested.data.impl.Outer_Impl.Square_Impl();
			result.readContent(in);
			return result;
		}

		/** Reads a new instance from the given reader. */
		static test.nested.data.Outer.Square readSquare(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			in.beginObject();
			test.nested.data.Outer.Square result = test.nested.data.impl.Outer_Impl.Square_Impl.readSquare_Content(in);
			in.endObject();
			return result;
		}

		/** Creates a new {@link Square} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Square readSquare(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			in.nextTag();
			return test.nested.data.impl.Outer_Impl.Square_Impl.readSquare_XmlContent(in);
		}

	}
	/**
	 * A sibling message holding values of the nested abstract type.
	 */
	public interface Drawing extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

		/**
		 * Creates a {@link test.nested.data.Outer.Drawing} instance.
		 */
		static test.nested.data.Outer.Drawing create() {
			return new test.nested.data.impl.Outer_Impl.Drawing_Impl();
		}

		/** Identifier for the {@link test.nested.data.Outer.Drawing} type in JSON format. */
		String DRAWING__TYPE = "Drawing";

		/** @see #getMain() */
		String MAIN__PROP = "main";

		/** @see #getShapes() */
		String SHAPES__PROP = "shapes";

		/** Identifier for the property {@link #getMain()} in binary format. */
		static final int MAIN__ID = 1;

		/** Identifier for the property {@link #getShapes()} in binary format. */
		static final int SHAPES__ID = 2;

		test.nested.data.Outer.Shape getMain();

		/**
		 * @see #getMain()
		 */
		test.nested.data.Outer.Drawing setMain(test.nested.data.Outer.Shape value);

		/**
		 * Checks, whether {@link #getMain()} has a value.
		 */
		boolean hasMain();

		java.util.List<test.nested.data.Outer.Shape> getShapes();

		/**
		 * @see #getShapes()
		 */
		test.nested.data.Outer.Drawing setShapes(java.util.List<? extends test.nested.data.Outer.Shape> value);

		/**
		 * Adds a value to the {@link #getShapes()} list.
		 */
		test.nested.data.Outer.Drawing addShape(test.nested.data.Outer.Shape value);

		/**
		 * Removes a value from the {@link #getShapes()} list.
		 */
		void removeShape(test.nested.data.Outer.Shape value);

		@Override
		public test.nested.data.Outer.Drawing registerListener(de.haumacher.msgbuf.observer.Listener l);

		@Override
		public test.nested.data.Outer.Drawing unregisterListener(de.haumacher.msgbuf.observer.Listener l);

		/** Reads a new instance from the given reader. */
		static test.nested.data.Outer.Drawing readDrawing(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			test.nested.data.impl.Outer_Impl.Drawing_Impl result = new test.nested.data.impl.Outer_Impl.Drawing_Impl();
			result.readContent(in);
			return result;
		}

		/** Reads a new instance from the given reader. */
		static test.nested.data.Outer.Drawing readDrawing(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			in.beginObject();
			test.nested.data.Outer.Drawing result = test.nested.data.impl.Outer_Impl.Drawing_Impl.readDrawing_Content(in);
			in.endObject();
			return result;
		}

		/** Creates a new {@link Drawing} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Drawing readDrawing(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			in.nextTag();
			return test.nested.data.impl.Outer_Impl.Drawing_Impl.readDrawing_XmlContent(in);
		}

	}

	/**
	 * Creates a {@link test.nested.data.Outer} instance.
	 */
	static test.nested.data.Outer create() {
		return new test.nested.data.impl.Outer_Impl();
	}

	/** Identifier for the {@link test.nested.data.Outer} type in JSON format. */
	String OUTER__TYPE = "Outer";

	/** @see #getShape() */
	String SHAPE__PROP = "shape";

	/** Identifier for the property {@link #getShape()} in binary format. */
	static final int SHAPE__ID = 1;

	/**
	 * A field of the nested abstract type in the outer message itself.
	 */
	test.nested.data.Outer.Shape getShape();

	/**
	 * @see #getShape()
	 */
	test.nested.data.Outer setShape(test.nested.data.Outer.Shape value);

	/**
	 * Checks, whether {@link #getShape()} has a value.
	 */
	boolean hasShape();

	@Override
	public test.nested.data.Outer registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.nested.data.Outer unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.nested.data.Outer readOuter(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.nested.data.impl.Outer_Impl result = new test.nested.data.impl.Outer_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.nested.data.Outer readOuter(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.nested.data.Outer result = test.nested.data.impl.Outer_Impl.readOuter_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link Outer} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Outer readOuter(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.nested.data.impl.Outer_Impl.readOuter_XmlContent(in);
	}

}
