package test.innertypeclash;

public interface B extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {
	public interface C extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

		/**
		 * Creates a {@link test.innertypeclash.B.C} instance.
		 */
		static test.innertypeclash.B.C create() {
			return new test.innertypeclash.impl.B_Impl.C_Impl();
		}

		/** Identifier for the {@link test.innertypeclash.B.C} type in JSON format. */
		String C__TYPE = "C";

		@Override
		public test.innertypeclash.B.C registerListener(de.haumacher.msgbuf.observer.Listener l);

		@Override
		public test.innertypeclash.B.C unregisterListener(de.haumacher.msgbuf.observer.Listener l);

		/** Reads a new instance from the given reader. */
		static test.innertypeclash.B.C readC(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			test.innertypeclash.impl.B_Impl.C_Impl result = new test.innertypeclash.impl.B_Impl.C_Impl();
			result.readContent(in);
			return result;
		}

		/** Reads a new instance from the given reader. */
		static test.innertypeclash.B.C readC(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			in.beginObject();
			test.innertypeclash.B.C result = test.innertypeclash.impl.B_Impl.C_Impl.readC_Content(in);
			in.endObject();
			return result;
		}

		/** Creates a new {@link C} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static C readC(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			in.nextTag();
			return test.innertypeclash.impl.B_Impl.C_Impl.readC_XmlContent(in);
		}

	}

	/**
	 * Creates a {@link test.innertypeclash.B} instance.
	 */
	static test.innertypeclash.B create() {
		return new test.innertypeclash.impl.B_Impl();
	}

	/** Identifier for the {@link test.innertypeclash.B} type in JSON format. */
	String B__TYPE = "B";

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
	test.innertypeclash.B setAc(test.innertypeclash.A.C value);

	/**
	 * Checks, whether {@link #getAc()} has a value.
	 */
	boolean hasAc();

	test.innertypeclash.B.C getBc();

	/**
	 * @see #getBc()
	 */
	test.innertypeclash.B setBc(test.innertypeclash.B.C value);

	/**
	 * Checks, whether {@link #getBc()} has a value.
	 */
	boolean hasBc();

	test.innertypeclash.B.C getC();

	/**
	 * @see #getC()
	 */
	test.innertypeclash.B setC(test.innertypeclash.B.C value);

	/**
	 * Checks, whether {@link #getC()} has a value.
	 */
	boolean hasC();

	@Override
	public test.innertypeclash.B registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.innertypeclash.B unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.innertypeclash.B readB(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.innertypeclash.impl.B_Impl result = new test.innertypeclash.impl.B_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.innertypeclash.B readB(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.innertypeclash.B result = test.innertypeclash.impl.B_Impl.readB_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link B} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static B readB(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.innertypeclash.impl.B_Impl.readB_XmlContent(in);
	}

}
