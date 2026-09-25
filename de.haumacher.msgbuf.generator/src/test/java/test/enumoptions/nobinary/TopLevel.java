package test.enumoptions.nobinary;

public enum TopLevel implements de.haumacher.msgbuf.data.ProtocolEnum {

	X("X"),

	Y("Y"),

	;

	private final String _protocolName;

	private TopLevel(String protocolName) {
		_protocolName = protocolName;
	}

	/**
	 * The protocol name of a {@link TopLevel} constant.
	 *
	 * @see #valueOfProtocol(String)
	 */
	@Override
	public String protocolName() {
		return _protocolName;
	}

	/** Looks up a {@link TopLevel} constant by it's protocol name. */
	public static TopLevel valueOfProtocol(String protocolName) {
		if (protocolName == null) { return null; }
		switch (protocolName) {
			case "X": return X;
			case "Y": return Y;
		}
		return X;
	}

	/** Writes this instance to the given output. */
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		out.value(protocolName());
	}

	/** Reads a new instance from the given reader. */
	public static TopLevel readTopLevel(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		return valueOfProtocol(in.nextString());
	}
}
