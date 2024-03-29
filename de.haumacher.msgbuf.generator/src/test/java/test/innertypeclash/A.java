package test.innertypeclash;

public interface A extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {
	public interface C extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

		/**
		 * Creates a {@link test.innertypeclash.A.C} instance.
		 */
		static test.innertypeclash.A.C create() {
			return new test.innertypeclash.impl.A_Impl.C_Impl();
		}

		/** Identifier for the {@link test.innertypeclash.A.C} type in JSON format. */
		String C__TYPE = "C";

		@Override
		public test.innertypeclash.A.C registerListener(de.haumacher.msgbuf.observer.Listener l);

		@Override
		public test.innertypeclash.A.C unregisterListener(de.haumacher.msgbuf.observer.Listener l);

		/** Reads a new instance from the given reader. */
		static test.innertypeclash.A.C readC(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			test.innertypeclash.impl.A_Impl.C_Impl result = new test.innertypeclash.impl.A_Impl.C_Impl();
			result.readContent(in);
			return result;
		}

		/** Reads a new instance from the given reader. */
		static test.innertypeclash.A.C readC(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			in.beginObject();
			test.innertypeclash.A.C result = test.innertypeclash.impl.A_Impl.C_Impl.readC_Content(in);
			in.endObject();
			return result;
		}

		/** Creates a new {@link C} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static C readC(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			in.nextTag();
			return test.innertypeclash.impl.A_Impl.C_Impl.readC_XmlContent(in);
		}

	}

	/**
	 * Creates a {@link test.innertypeclash.A} instance.
	 */
	static test.innertypeclash.A create() {
		return new test.innertypeclash.impl.A_Impl();
	}

	/** Identifier for the {@link test.innertypeclash.A} type in JSON format. */
	String A__TYPE = "A";

	/** @see #getAc() */
	String AC__PROP = "ac";

	/** @see #getBc() */
	String BC__PROP = "bc";

	/** @see #getC() */
	String C__PROP = "c";

	/** Identifier for the property {@link #getAc()} in binary format. */
	static final int AC__ID = 1;

	/** Identifier for the property {@link #getBc()} in binary format. */
	static final int BC__ID = 2;

	/** Identifier for the property {@link #getC()} in binary format. */
	static final int C__ID = 3;

	test.innertypeclash.A.C getAc();

	/**
	 * @see #getAc()
	 */
	test.innertypeclash.A setAc(test.innertypeclash.A.C value);

	/**
	 * Checks, whether {@link #getAc()} has a value.
	 */
	boolean hasAc();

	test.innertypeclash.B.C getBc();

	/**
	 * @see #getBc()
	 */
	test.innertypeclash.A setBc(test.innertypeclash.B.C value);

	/**
	 * Checks, whether {@link #getBc()} has a value.
	 */
	boolean hasBc();

	test.innertypeclash.A.C getC();

	/**
	 * @see #getC()
	 */
	test.innertypeclash.A setC(test.innertypeclash.A.C value);

	/**
	 * Checks, whether {@link #getC()} has a value.
	 */
	boolean hasC();

	@Override
	public test.innertypeclash.A registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.innertypeclash.A unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.innertypeclash.A readA(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.innertypeclash.impl.A_Impl result = new test.innertypeclash.impl.A_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.innertypeclash.A readA(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.innertypeclash.A result = test.innertypeclash.impl.A_Impl.readA_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link A} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static A readA(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.innertypeclash.impl.A_Impl.readA_XmlContent(in);
	}

}
