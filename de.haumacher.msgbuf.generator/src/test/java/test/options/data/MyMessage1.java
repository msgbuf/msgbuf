package test.options.data;

public interface MyMessage1 extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	public enum EnumAllowingAlias implements de.haumacher.msgbuf.data.ProtocolEnum {

		UNKNOWN("UNKNOWN"),

		STARTED("STARTED"),

		RUNNING("RUNNING"),

		;

		private final String _protocolName;

		private EnumAllowingAlias(String protocolName) {
			_protocolName = protocolName;
		}

		/**
		 * The protocol name of a {@link EnumAllowingAlias} constant.
		 *
		 * @see #valueOfProtocol(String)
		 */
		@Override
		public String protocolName() {
			return _protocolName;
		}

		/** Looks up a {@link EnumAllowingAlias} constant by it's protocol name. */
		public static EnumAllowingAlias valueOfProtocol(String protocolName) {
			if (protocolName == null) { return null; }
			switch (protocolName) {
				case "UNKNOWN": return UNKNOWN;
				case "STARTED": return STARTED;
				case "RUNNING": return RUNNING;
			}
			return UNKNOWN;
		}

		/** Writes this instance to the given output. */
		public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
			out.value(protocolName());
		}

		/** Reads a new instance from the given reader. */
		public static EnumAllowingAlias readEnumAllowingAlias(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			return valueOfProtocol(in.nextString());
		}

		/** Writes this instance to the given binary output. */
		public final void writeTo(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
			switch (this) {
				case UNKNOWN: out.value(2); break;
				case STARTED: out.value(1); break;
				case RUNNING: out.value(1); break;
				default: out.value(0);
			}
		}

		/** Reads a new instance from the given binary reader. */
		public static EnumAllowingAlias readEnumAllowingAlias(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			switch (in.nextInt()) {
				case 2: return UNKNOWN;
				case 1: return STARTED;
				default: return UNKNOWN;
			}
		}
	}

	/**
	 * Creates a {@link MyMessage1} instance.
	 */
	static MyMessage1 create() {
		return new test.options.data.MyMessage1_Impl();
	}

	/** Identifier for the {@link MyMessage1} type in JSON format. */
	static final String MY_MESSAGE_1__TYPE = "MyMessage1";

	@Override
	public MyMessage1 registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public MyMessage1 unregisterListener(de.haumacher.msgbuf.observer.Listener l);


	/** Reads a new instance from the given reader. */
	static MyMessage1 readMyMessage1(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.options.data.MyMessage1_Impl result = new test.options.data.MyMessage1_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static MyMessage1 readMyMessage1(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		MyMessage1 result = test.options.data.MyMessage1_Impl.readMyMessage1_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link MyMessage1} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static MyMessage1 readMyMessage1(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.options.data.MyMessage1_Impl.readMyMessage1_XmlContent(in);
	}

}
