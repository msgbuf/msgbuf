package test.lowercasemessage;

public interface A extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {
	public interface B extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

		/**
		 * Creates a {@link test.lowercasemessage.A.B} instance.
		 */
		static test.lowercasemessage.A.B create() {
			return new test.lowercasemessage.impl.A_Impl.B_Impl();
		}

		/** Identifier for the {@link test.lowercasemessage.A.B} type in JSON format. */
		static final String B__TYPE = "b";

		/** @see #getA1() */
		static final String A_1__PROP = "a1";

		/** @see #getB1() */
		static final String B_1__PROP = "b1";

		/** Identifier for the property {@link #getA1()} in binary format. */
		static final int A_1__ID = 1;

		/** Identifier for the property {@link #getB1()} in binary format. */
		static final int B_1__ID = 2;

		test.lowercasemessage.A getA1();

		/**
		 * @see #getA1()
		 */
		test.lowercasemessage.A.B setA1(test.lowercasemessage.A value);

		/**
		 * Checks, whether {@link #getA1()} has a value.
		 */
		boolean hasA1();

		test.lowercasemessage.A.B getB1();

		/**
		 * @see #getB1()
		 */
		test.lowercasemessage.A.B setB1(test.lowercasemessage.A.B value);

		/**
		 * Checks, whether {@link #getB1()} has a value.
		 */
		boolean hasB1();

		@Override
		public test.lowercasemessage.A.B registerListener(de.haumacher.msgbuf.observer.Listener l);

		@Override
		public test.lowercasemessage.A.B unregisterListener(de.haumacher.msgbuf.observer.Listener l);

		/** Reads a new instance from the given reader. */
		static test.lowercasemessage.A.B readb(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			test.lowercasemessage.impl.A_Impl.B_Impl result = new test.lowercasemessage.impl.A_Impl.B_Impl();
			result.readContent(in);
			return result;
		}

		/** Reads a new instance from the given reader. */
		static test.lowercasemessage.A.B readb(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			in.beginObject();
			test.lowercasemessage.A.B result = test.lowercasemessage.impl.A_Impl.B_Impl.readb_Content(in);
			in.endObject();
			return result;
		}

		/** Creates a new {@link B} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static B readB(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			in.nextTag();
			return test.lowercasemessage.impl.A_Impl.B_Impl.readB_XmlContent(in);
		}

	}

	/**
	 * Creates a {@link test.lowercasemessage.A} instance.
	 */
	static test.lowercasemessage.A create() {
		return new test.lowercasemessage.impl.A_Impl();
	}

	/** Identifier for the {@link test.lowercasemessage.A} type in JSON format. */
	static final String A__TYPE = "a";

	/** @see #getA1() */
	static final String A_1__PROP = "a1";

	/** @see #getB1() */
	static final String B_1__PROP = "b1";

	/** Identifier for the property {@link #getA1()} in binary format. */
	static final int A_1__ID = 1;

	/** Identifier for the property {@link #getB1()} in binary format. */
	static final int B_1__ID = 2;

	test.lowercasemessage.A getA1();

	/**
	 * @see #getA1()
	 */
	test.lowercasemessage.A setA1(test.lowercasemessage.A value);

	/**
	 * Checks, whether {@link #getA1()} has a value.
	 */
	boolean hasA1();

	test.lowercasemessage.A.B getB1();

	/**
	 * @see #getB1()
	 */
	test.lowercasemessage.A setB1(test.lowercasemessage.A.B value);

	/**
	 * Checks, whether {@link #getB1()} has a value.
	 */
	boolean hasB1();

	@Override
	public test.lowercasemessage.A registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.lowercasemessage.A unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.lowercasemessage.A reada(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.lowercasemessage.impl.A_Impl result = new test.lowercasemessage.impl.A_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.lowercasemessage.A reada(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.lowercasemessage.A result = test.lowercasemessage.impl.A_Impl.reada_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link A} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static A readA(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.lowercasemessage.impl.A_Impl.readA_XmlContent(in);
	}

}
