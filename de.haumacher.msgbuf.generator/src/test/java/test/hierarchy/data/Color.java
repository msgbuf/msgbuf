package test.hierarchy.data;

/**
 * {@link Shape} colors.
 */
public enum Color implements de.haumacher.msgbuf.data.ProtocolEnum {

	RED("red"),

	GREEN("green"),

	BLUE("blue"),

	YELLOW("yellow"),

	MAGENTA("magenta"),

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
			case "red": return RED;
			case "green": return GREEN;
			case "blue": return BLUE;
			case "yellow": return YELLOW;
			case "magenta": return MAGENTA;
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
			case BLUE: out.value(3); break;
			case YELLOW: out.value(4); break;
			case MAGENTA: out.value(5); break;
			default: out.value(0);
		}
	}

	/** Reads a new instance from the given binary reader. */
	public static Color readColor(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		switch (in.nextInt()) {
			case 1: return RED;
			case 2: return GREEN;
			case 3: return BLUE;
			case 4: return YELLOW;
			case 5: return MAGENTA;
			default: return RED;
		}
	}
}
