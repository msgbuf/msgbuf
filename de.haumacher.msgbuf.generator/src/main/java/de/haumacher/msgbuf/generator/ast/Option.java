package de.haumacher.msgbuf.generator.ast;

/**
 * Base class for an option annotation.
 *
 * @see StringOption 
 * @see NumberOption 
 * @see Flag
 */
public abstract class Option extends de.haumacher.msgbuf.data.AbstractDataObject implements de.haumacher.msgbuf.observer.Observable {

	/** Type codes for the {@link de.haumacher.msgbuf.generator.ast.Option} hierarchy. */
	public enum TypeKind {

		/** Type literal for {@link de.haumacher.msgbuf.generator.ast.StringOption}. */
		STRING_OPTION,

		/** Type literal for {@link de.haumacher.msgbuf.generator.ast.NumberOption}. */
		NUMBER_OPTION,

		/** Type literal for {@link de.haumacher.msgbuf.generator.ast.Flag}. */
		FLAG,
		;

	}

	/** Visitor interface for the {@link de.haumacher.msgbuf.generator.ast.Option} hierarchy.*/
	public interface Visitor<R,A> {

		/** Visit case for {@link de.haumacher.msgbuf.generator.ast.StringOption}.*/
		R visit(de.haumacher.msgbuf.generator.ast.StringOption self, A arg);

		/** Visit case for {@link de.haumacher.msgbuf.generator.ast.NumberOption}.*/
		R visit(de.haumacher.msgbuf.generator.ast.NumberOption self, A arg);

		/** Visit case for {@link de.haumacher.msgbuf.generator.ast.Flag}.*/
		R visit(de.haumacher.msgbuf.generator.ast.Flag self, A arg);

	}

	/**
	 * Creates a {@link Option} instance.
	 */
	protected Option() {
		super();
	}

	/** The type code of this instance. */
	public abstract TypeKind kind();

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public de.haumacher.msgbuf.generator.ast.Option registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public de.haumacher.msgbuf.generator.ast.Option unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		internalUnregisterListener(l);
		return this;
	}

	protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
	}

	/** Reads a new instance from the given reader. */
	public static de.haumacher.msgbuf.generator.ast.Option readOption(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		de.haumacher.msgbuf.generator.ast.Option result;
		in.beginArray();
		String type = in.nextString();
		switch (type) {
			case StringOption.STRING_OPTION__TYPE: result = de.haumacher.msgbuf.generator.ast.StringOption.readStringOption(in); break;
			case NumberOption.NUMBER_OPTION__TYPE: result = de.haumacher.msgbuf.generator.ast.NumberOption.readNumberOption(in); break;
			case Flag.FLAG__TYPE: result = de.haumacher.msgbuf.generator.ast.Flag.readFlag(in); break;
			default: in.skipValue(); result = null; break;
		}
		in.endArray();
		return result;
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		out.beginArray();
		out.value(jsonType());
		writeContent(out);
		out.endArray();
	}

	/** Accepts the given visitor. */
	public abstract <R,A> R visit(Visitor<R,A> v, A arg);

}
