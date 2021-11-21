package test.options.data;

public class MyMessage1 extends de.haumacher.msgbuf.data.AbstractDataObject implements de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable {

	public enum EnumAllowingAlias {

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
	public static MyMessage1 create() {
		return new MyMessage1();
	}

	/** Identifier for the {@link MyMessage1} type in JSON format. */
	public static final String MY_MESSAGE_1__TYPE = "MyMessage1";

	/**
	 * Creates a {@link MyMessage1} instance.
	 *
	 * @see #create()
	 */
	protected MyMessage1() {
		super();
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public MyMessage1 registerListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
		return this;
	}

	@Override
	public MyMessage1 unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
		return this;
	}

	/** Reads a new instance from the given reader. */
	public static MyMessage1 readMyMessage1(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		MyMessage1 result = new MyMessage1();
		in.beginObject();
		result.readFields(in);
		in.endObject();
		return result;
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		out.beginObject();
		writeFields(out);
		out.endObject();
	}

	/**
	 * Serializes all fields of this instance to the given binary output.
	 *
	 * @param out
	 *        The binary output to write to.
	 * @throws java.io.IOException If writing fails.
	 */
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		// No fields to write, hook for subclasses.
	}

	/** Reads a new instance from the given reader. */
	public static MyMessage1 readMyMessage1(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		MyMessage1 result = new MyMessage1();
		while (in.hasNext()) {
			int field = in.nextName();
			result.readField(in, field);
		}
		in.endObject();
		return result;
	}

	/** Consumes the value for the field with the given ID and assigns its value. */
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			default: in.skipValue(); 
		}
	}

}
