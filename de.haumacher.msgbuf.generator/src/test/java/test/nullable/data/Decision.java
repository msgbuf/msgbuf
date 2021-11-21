package test.nullable.data;

public enum Decision {

	YES("YES"),

	NO("NO"),

	;

	private final String _protocolName;

	private Decision(String protocolName) {
		_protocolName = protocolName;
	}

	/**
	 * The protocol name of a {@link Decision} constant.
	 *
	 * @see #valueOfProtocol(String)
	 */
	public String protocolName() {
		return _protocolName;
	}

	/** Looks up a {@link Decision} constant by it's protocol name. */
	public static Decision valueOfProtocol(String protocolName) {
		if (protocolName == null) { return null; }
		switch (protocolName) {
			case "YES": return YES;
			case "NO": return NO;
		}
		return YES;
	}

	/** Writes this instance to the given output. */
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		out.value(protocolName());
	}

	/** Reads a new instance from the given reader. */
	public static Decision readDecision(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		return valueOfProtocol(in.nextString());
	}

	/** Writes this instance to the given binary output. */
	public final void writeTo(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		switch (this) {
			case YES: out.value(1); break;
			case NO: out.value(2); break;
			default: out.value(0);
		}
	}

	/** Reads a new instance from the given binary reader. */
	public static Decision readDecision(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		switch (in.nextInt()) {
			case 1: return YES;
			case 2: return NO;
			default: return YES;
		}
	}
}
