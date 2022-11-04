package test.innertypeclash;

public interface A extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {
	public interface C extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

		/**
		 * Creates a {@link C} instance.
		 */
		static C create() {
			return new test.innertypeclash.A_Impl.C_Impl();
		}

		/** Identifier for the {@link C} type in JSON format. */
		static final String C__TYPE = "C";

		@Override
		public C registerListener(de.haumacher.msgbuf.observer.Listener l);

		@Override
		public C unregisterListener(de.haumacher.msgbuf.observer.Listener l);


		/** Reads a new instance from the given reader. */
		static C readC(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			test.innertypeclash.A_Impl.C_Impl result = new test.innertypeclash.A_Impl.C_Impl();
			result.readContent(in);
			return result;
		}

		/** Reads a new instance from the given reader. */
		static C readC(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			in.beginObject();
			C result = test.innertypeclash.A_Impl.C_Impl.readC_Content(in);
			in.endObject();
			return result;
		}

		/** Creates a new {@link C} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static C readC(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			in.nextTag();
			return test.innertypeclash.A_Impl.C_Impl.readC_XmlContent(in);
		}

	}

	/**
	 * Creates a {@link A} instance.
	 */
	static A create() {
		return new test.innertypeclash.A_Impl();
	}

	/** Identifier for the {@link A} type in JSON format. */
	static final String A__TYPE = "A";

	/** @see #getAc() */
	static final String AC__PROP = "ac";

	/** @see #getBc() */
	static final String BC__PROP = "bc";

	/** @see #getC() */
	static final String C__PROP = "c";

	/** Identifier for the property {@link #getAc()} in binary format. */
	static final int AC__ID = 1;

	/** Identifier for the property {@link #getBc()} in binary format. */
	static final int BC__ID = 2;

	/** Identifier for the property {@link #getC()} in binary format. */
	static final int C__ID = 3;

	A.C getAc();

	/**
	 * @see #getAc()
	 */
	A setAc(A.C value);

	/**
	 * Checks, whether {@link #getAc()} has a value.
	 */
	boolean hasAc();

	B.C getBc();

	/**
	 * @see #getBc()
	 */
	A setBc(B.C value);

	/**
	 * Checks, whether {@link #getBc()} has a value.
	 */
	boolean hasBc();

	C getC();

	/**
	 * @see #getC()
	 */
	A setC(C value);

	/**
	 * Checks, whether {@link #getC()} has a value.
	 */
	boolean hasC();

	@Override
	public A registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public A unregisterListener(de.haumacher.msgbuf.observer.Listener l);


	/** Reads a new instance from the given reader. */
	static A readA(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.innertypeclash.A_Impl result = new test.innertypeclash.A_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static A readA(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		A result = test.innertypeclash.A_Impl.readA_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link A} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static A readA(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.innertypeclash.A_Impl.readA_XmlContent(in);
	}

}
