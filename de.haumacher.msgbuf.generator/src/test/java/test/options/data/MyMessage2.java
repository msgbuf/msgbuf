package test.options.data;

public interface MyMessage2 extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

	public enum EnumNotAllowingAlias implements de.haumacher.msgbuf.data.ProtocolEnum {

		UNKNOWN("UNKNOWN"),

		STARTED("STARTED"),

		;

		private final String _protocolName;

		private EnumNotAllowingAlias(String protocolName) {
			_protocolName = protocolName;
		}

		/**
		 * The protocol name of a {@link EnumNotAllowingAlias} constant.
		 *
		 * @see #valueOfProtocol(String)
		 */
		@Override
		public String protocolName() {
			return _protocolName;
		}

		/** Looks up a {@link EnumNotAllowingAlias} constant by it's protocol name. */
		public static EnumNotAllowingAlias valueOfProtocol(String protocolName) {
			if (protocolName == null) { return null; }
			switch (protocolName) {
				case "UNKNOWN": return UNKNOWN;
				case "STARTED": return STARTED;
			}
			return UNKNOWN;
		}

		/** Writes this instance to the given output. */
		public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
			out.value(protocolName());
		}

		/** Reads a new instance from the given reader. */
		public static EnumNotAllowingAlias readEnumNotAllowingAlias(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			return valueOfProtocol(in.nextString());
		}

		/** Writes this instance to the given binary output. */
		public final void writeTo(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
			switch (this) {
				case UNKNOWN: out.value(2); break;
				case STARTED: out.value(1); break;
				default: out.value(0);
			}
		}

		/** Reads a new instance from the given binary reader. */
		public static EnumNotAllowingAlias readEnumNotAllowingAlias(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			switch (in.nextInt()) {
				case 2: return UNKNOWN;
				case 1: return STARTED;
				default: return UNKNOWN;
			}
		}
	}

	/**
	 * Creates a {@link MyMessage2} instance.
	 */
	static MyMessage2 create() {
		return new test.options.data.MyMessage2_Impl();
	}

	/** Identifier for the {@link MyMessage2} type in JSON format. */
	static final String MY_MESSAGE_2__TYPE = "MyMessage2";

	@Override
	public MyMessage2 registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public MyMessage2 unregisterListener(de.haumacher.msgbuf.observer.Listener l);


	/** Reads a new instance from the given reader. */
	static MyMessage2 readMyMessage2(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.options.data.MyMessage2_Impl result = new test.options.data.MyMessage2_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static MyMessage2 readMyMessage2(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		MyMessage2 result = test.options.data.MyMessage2_Impl.readMyMessage2_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link MyMessage2} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static MyMessage2 readMyMessage2(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.options.data.MyMessage2_Impl.readMyMessage2_XmlContent(in);
	}

}
