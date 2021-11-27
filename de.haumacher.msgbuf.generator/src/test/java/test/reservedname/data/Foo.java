package test.reservedname.data;

public enum Foo implements de.haumacher.msgbuf.data.ProtocolEnum {

	;

	private final String _protocolName;

	private Foo(String protocolName) {
		_protocolName = protocolName;
	}

	/**
	 * The protocol name of a {@link Foo} constant.
	 *
	 * @see #valueOfProtocol(String)
	 */
	@Override
	public String protocolName() {
		return _protocolName;
	}

	/** Looks up a {@link Foo} constant by it's protocol name. */
	public static Foo valueOfProtocol(String protocolName) {
		if (protocolName == null) { return null; }
		switch (protocolName) {
		}
		return null;
	}

	/** Writes this instance to the given output. */
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		out.value(protocolName());
	}

	/** Reads a new instance from the given reader. */
	public static Foo readFoo(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		return valueOfProtocol(in.nextString());
	}

	/** Writes this instance to the given binary output. */
	public final void writeTo(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		switch (this) {
			default: out.value(0);
		}
	}

	/** Reads a new instance from the given binary reader. */
	public static Foo readFoo(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		switch (in.nextInt()) {
			default: return null;
		}
	}
}
