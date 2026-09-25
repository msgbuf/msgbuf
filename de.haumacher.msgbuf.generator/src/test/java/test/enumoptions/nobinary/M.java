package test.enumoptions.nobinary;

/**
 * Enums honor `option NoBinary` like messages do (issue #20).
 */
public interface M extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

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

		/** Writes this instance to the given output. */
		public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
			out.value(protocolName());
		}

		/** Reads a new instance from the given reader. */
		public static Nested readNested(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			return valueOfProtocol(in.nextString());
		}
	}

	/**
	 * Creates a {@link test.enumoptions.nobinary.M} instance.
	 */
	static test.enumoptions.nobinary.M create() {
		return new test.enumoptions.nobinary.impl.M_Impl();
	}

	/** Identifier for the {@link test.enumoptions.nobinary.M} type in JSON format. */
	String M__TYPE = "M";

	/** @see #getNested() */
	String NESTED__PROP = "nested";

	/** @see #getTop() */
	String TOP__PROP = "top";

	test.enumoptions.nobinary.M.Nested getNested();

	/**
	 * @see #getNested()
	 */
	test.enumoptions.nobinary.M setNested(test.enumoptions.nobinary.M.Nested value);

	test.enumoptions.nobinary.TopLevel getTop();

	/**
	 * @see #getTop()
	 */
	test.enumoptions.nobinary.M setTop(test.enumoptions.nobinary.TopLevel value);

	@Override
	public test.enumoptions.nobinary.M registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.enumoptions.nobinary.M unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.enumoptions.nobinary.M readM(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.enumoptions.nobinary.impl.M_Impl result = new test.enumoptions.nobinary.impl.M_Impl();
		result.readContent(in);
		return result;
	}

	/** Creates a new {@link M} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static M readM(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.enumoptions.nobinary.impl.M_Impl.readM_XmlContent(in);
	}

}
