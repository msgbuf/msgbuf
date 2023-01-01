package test.lowercasemessage;

public interface A extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {
	public interface B extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

		/**
		 * Creates a {@link B} instance.
		 */
		static B create() {
			return new test.lowercasemessage.A_Impl.B_Impl();
		}

		/** Identifier for the {@link B} type in JSON format. */
		static final String B__TYPE = "b";

		/** @see #getA1() */
		static final String A_1__PROP = "a1";

		/** @see #getB1() */
		static final String B_1__PROP = "b1";

		/** Identifier for the property {@link #getA1()} in binary format. */
		static final int A_1__ID = 1;

		/** Identifier for the property {@link #getB1()} in binary format. */
		static final int B_1__ID = 2;

		A getA1();

		/**
		 * @see #getA1()
		 */
		B setA1(A value);

		/**
		 * Checks, whether {@link #getA1()} has a value.
		 */
		boolean hasA1();

		A.B getB1();

		/**
		 * @see #getB1()
		 */
		B setB1(A.B value);

		/**
		 * Checks, whether {@link #getB1()} has a value.
		 */
		boolean hasB1();

		@Override
		public B registerListener(de.haumacher.msgbuf.observer.Listener l);

		@Override
		public B unregisterListener(de.haumacher.msgbuf.observer.Listener l);

		/** Reads a new instance from the given reader. */
		static B readb(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			test.lowercasemessage.A_Impl.B_Impl result = new test.lowercasemessage.A_Impl.B_Impl();
			result.readContent(in);
			return result;
		}

		/** Reads a new instance from the given reader. */
		static B readb(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			in.beginObject();
			B result = test.lowercasemessage.A_Impl.B_Impl.readb_Content(in);
			in.endObject();
			return result;
		}

		/** Creates a new {@link B} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static B readB(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			in.nextTag();
			return test.lowercasemessage.A_Impl.B_Impl.readB_XmlContent(in);
		}

	}

	/**
	 * Creates a {@link A} instance.
	 */
	static A create() {
		return new test.lowercasemessage.A_Impl();
	}

	/** Identifier for the {@link A} type in JSON format. */
	static final String A__TYPE = "a";

	/** @see #getA1() */
	static final String A_1__PROP = "a1";

	/** @see #getB1() */
	static final String B_1__PROP = "b1";

	/** Identifier for the property {@link #getA1()} in binary format. */
	static final int A_1__ID = 1;

	/** Identifier for the property {@link #getB1()} in binary format. */
	static final int B_1__ID = 2;

	A getA1();

	/**
	 * @see #getA1()
	 */
	A setA1(A value);

	/**
	 * Checks, whether {@link #getA1()} has a value.
	 */
	boolean hasA1();

	A.B getB1();

	/**
	 * @see #getB1()
	 */
	A setB1(A.B value);

	/**
	 * Checks, whether {@link #getB1()} has a value.
	 */
	boolean hasB1();

	@Override
	public A registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public A unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static A reada(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.lowercasemessage.A_Impl result = new test.lowercasemessage.A_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static A reada(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		A result = test.lowercasemessage.A_Impl.reada_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link A} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static A readA(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.lowercasemessage.A_Impl.readA_XmlContent(in);
	}

}
