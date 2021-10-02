package de.haumacher.msgbuf.generator.ast;

/**
 * Container for temporary collecting annotations without further semantics.
 */
public class OptionContainer extends WithOptions {

	/**
	 * Creates a {@link OptionContainer} instance.
	 */
	public static OptionContainer create() {
		return new OptionContainer();
	}

	/**
	 * Creates a {@link OptionContainer} instance.
	 *
	 * @see #create()
	 */
	protected OptionContainer() {
		super();
	}

	/** Reads a new instance from the given reader. */
	public static OptionContainer readOptionContainer(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		OptionContainer result = new OptionContainer();
		in.beginObject();
		result.readFields(in);
		in.endObject();
		return result;
	}

	@Override
	public String jsonType() {
		return "OptionContainer";
	}

	@Override
	public <R,A> R visit(WithOptions.Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}

}
