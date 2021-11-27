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

	/** Identifier for the {@link OptionContainer} type in JSON format. */
	public static final String OPTION_CONTAINER__TYPE = "OptionContainer";

	/**
	 * Creates a {@link OptionContainer} instance.
	 *
	 * @see #create()
	 */
	protected OptionContainer() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.OPTION_CONTAINER;
	}

	@Override
	public String jsonType() {
		return OPTION_CONTAINER__TYPE;
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
	public <R,A> R visit(WithOptions.Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}

}
