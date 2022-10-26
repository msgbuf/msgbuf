package test.innertypeclash;

public interface B extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable {
	public interface C extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable {

		/**
		 * Creates a {@link C} instance.
		 */
		static C create() {
			return new test.innertypeclash.B_Impl.C_Impl();
		}

		/** Identifier for the {@link C} type in JSON format. */
		static final String C__TYPE = "C";

		@Override
		public C registerListener(de.haumacher.msgbuf.observer.Listener l);

		@Override
		public C unregisterListener(de.haumacher.msgbuf.observer.Listener l);


		/** Reads a new instance from the given reader. */
		static C readC(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			test.innertypeclash.B_Impl.C_Impl result = new test.innertypeclash.B_Impl.C_Impl();
			result.readContent(in);
			return result;
		}

		/** Reads a new instance from the given reader. */
		static C readC(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			in.beginObject();
			C result = test.innertypeclash.B_Impl.C_Impl.readC_Content(in);
			in.endObject();
			return result;
		}

		/** Creates a new {@link C} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static C readC(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			in.nextTag();
			return test.innertypeclash.B_Impl.C_Impl.readC_XmlContent(in);
		}

	}

	/**
	 * Creates a {@link B} instance.
	 */
	static B create() {
		return new test.innertypeclash.B_Impl();
	}

	/** Identifier for the {@link B} type in JSON format. */
	static final String B__TYPE = "B";

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
	B setAc(A.C value);

	/**
	 * Checks, whether {@link #getAc()} has a value.
	 */
	boolean hasAc();

	B.C getBc();

	/**
	 * @see #getBc()
	 */
	B setBc(B.C value);

	/**
	 * Checks, whether {@link #getBc()} has a value.
	 */
	boolean hasBc();

	C getC();

	/**
	 * @see #getC()
	 */
	B setC(C value);

	/**
	 * Checks, whether {@link #getC()} has a value.
	 */
	boolean hasC();

	@Override
	public B registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public B unregisterListener(de.haumacher.msgbuf.observer.Listener l);


	/** Reads a new instance from the given reader. */
	static B readB(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.innertypeclash.B_Impl result = new test.innertypeclash.B_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static B readB(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		B result = test.innertypeclash.B_Impl.readB_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link B} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static B readB(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.innertypeclash.B_Impl.readB_XmlContent(in);
	}

}
