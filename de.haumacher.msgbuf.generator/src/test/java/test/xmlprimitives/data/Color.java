package test.xmlprimitives.data;

public enum Color implements de.haumacher.msgbuf.data.ProtocolEnum {

	RED("RED"),

	GREEN("GREEN"),

	;

	private final String _protocolName;

	private Color(String protocolName) {
		_protocolName = protocolName;
	}

	/**
	 * The protocol name of a {@link Color} constant.
	 *
	 * @see #valueOfProtocol(String)
	 */
	@Override
	public String protocolName() {
		return _protocolName;
	}

	/** Looks up a {@link Color} constant by it's protocol name. */
	public static Color valueOfProtocol(String protocolName) {
		if (protocolName == null) { return null; }
		switch (protocolName) {
			case "RED": return RED;
			case "GREEN": return GREEN;
		}
		return RED;
	}

	/** Writes this instance to the given output. */
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		out.value(protocolName());
	}

	/** Reads a new instance from the given reader. */
	public static Color readColor(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		return valueOfProtocol(in.nextString());
	}

	/** Writes this instance to the given binary output. */
	public final void writeTo(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		switch (this) {
			case RED: out.value(1); break;
			case GREEN: out.value(2); break;
			default: out.value(0);
		}
	}

	/** Reads a new instance from the given binary reader. */
	public static Color readColor(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		switch (in.nextInt()) {
			case 1: return RED;
			case 2: return GREEN;
			default: return RED;
		}
	}
}
