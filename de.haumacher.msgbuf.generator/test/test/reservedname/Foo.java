package test.reservedname;

public enum Foo {

	;

	/** Writes this instance to the given output. */
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		out.value(name());
	}

	/** Reads a new instance from the given reader. */
	public static Foo readFoo(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		return valueOf(in.nextString());
	}
}
