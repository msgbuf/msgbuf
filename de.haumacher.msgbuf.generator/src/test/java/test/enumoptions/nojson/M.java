package test.enumoptions.nojson;

/**
 * Enums honor `option NoJson` like messages do (issue #20).
 */
public interface M extends de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	public enum Nested implements de.haumacher.msgbuf.data.ProtocolEnum {

		A("A"),

		B("B"),

		;

		private final String _protocolName;

		private Nested(String protocolName) {
			_protocolName = protocolName;
		}

		/**
		 * The protocol name of a {@link Nested} constant.
		 *
		 * @see #valueOfProtocol(String)
		 */
		@Override
		public String protocolName() {
			return _protocolName;
		}

		/** Looks up a {@link Nested} constant by it's protocol name. */
		public static Nested valueOfProtocol(String protocolName) {
			if (protocolName == null) { return null; }
			switch (protocolName) {
				case "A": return A;
				case "B": return B;
			}
			return A;
		}

		/** Writes this instance to the given binary output. */
		public final void writeTo(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
			switch (this) {
				case A: out.value(1); break;
				case B: out.value(2); break;
				default: out.value(0);
			}
		}

		/** Reads a new instance from the given binary reader. */
		public static Nested readNested(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			switch (in.nextInt()) {
				case 1: return A;
				case 2: return B;
				default: return A;
			}
		}
	}

	/**
	 * Creates a {@link test.enumoptions.nojson.M} instance.
	 */
	static test.enumoptions.nojson.M create() {
		return new test.enumoptions.nojson.impl.M_Impl();
	}

	/** Identifier for the {@link test.enumoptions.nojson.M} type in JSON format. */
	String M__TYPE = "M";

	/** @see #getNested() */
	String NESTED__PROP = "nested";

	/** @see #getTop() */
	String TOP__PROP = "top";

	/** Identifier for the property {@link #getNested()} in binary format. */
	static final int NESTED__ID = 1;

	/** Identifier for the property {@link #getTop()} in binary format. */
	static final int TOP__ID = 2;

	test.enumoptions.nojson.M.Nested getNested();

	/**
	 * @see #getNested()
	 */
	test.enumoptions.nojson.M setNested(test.enumoptions.nojson.M.Nested value);

	test.enumoptions.nojson.TopLevel getTop();

	/**
	 * @see #getTop()
	 */
	test.enumoptions.nojson.M setTop(test.enumoptions.nojson.TopLevel value);

	@Override
	public test.enumoptions.nojson.M registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.enumoptions.nojson.M unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.enumoptions.nojson.M readM(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.enumoptions.nojson.M result = test.enumoptions.nojson.impl.M_Impl.readM_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link M} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static M readM(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.enumoptions.nojson.impl.M_Impl.readM_XmlContent(in);
	}

}
