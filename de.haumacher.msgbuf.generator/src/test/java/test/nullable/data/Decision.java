package test.nullable.data;

public enum Decision {

	YES,

	NO,

	;

	/** Writes this instance to the given output. */
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		out.value(name());
	}

	/** Reads a new instance from the given reader. */
	public static Decision readDecision(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		return valueOf(in.nextString());
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
