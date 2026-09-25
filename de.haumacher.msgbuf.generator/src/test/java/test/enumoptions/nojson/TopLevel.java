package test.enumoptions.nojson;

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

	/** Writes this instance to the given binary output. */
	public final void writeTo(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		switch (this) {
			case X: out.value(1); break;
			case Y: out.value(2); break;
			default: out.value(0);
		}
	}

	/** Reads a new instance from the given binary reader. */
	public static TopLevel readTopLevel(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		switch (in.nextInt()) {
			case 1: return X;
			case 2: return Y;
			default: return X;
		}
	}
}
