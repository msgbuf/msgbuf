package de.haumacher.msgbuf.generator.ast;

/**
 * Base class for possible {@link Field} types.
 */
public abstract class Type extends de.haumacher.msgbuf.data.AbstractDataObject implements de.haumacher.msgbuf.observer.Observable {

	/** Type codes for the {@link Type} hierarchy. */
	public enum TypeKind {

		/** Type literal for {@link CustomType}. */
		CUSTOM_TYPE,

		/** Type literal for {@link PrimitiveType}. */
		PRIMITIVE_TYPE,

		/** Type literal for {@link MapType}. */
		MAP_TYPE,
		;

	}

	/** Visitor interface for the {@link Type} hierarchy.*/
	public interface Visitor<R,A> {

		/** Visit case for {@link CustomType}.*/
		R visit(CustomType self, A arg);

		/** Visit case for {@link PrimitiveType}.*/
		R visit(PrimitiveType self, A arg);

		/** Visit case for {@link MapType}.*/
		R visit(MapType self, A arg);

	}

	/**
	 * Creates a {@link Type} instance.
	 */
	protected Type() {
		super();
	}

	/** The type code of this instance. */
	public abstract TypeKind kind();

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public Type registerListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
		return this;
	}

	@Override
	public Type unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
		return this;
	}

	/** Reads a new instance from the given reader. */
	public static Type readType(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		Type result;
		in.beginArray();
		String type = in.nextString();
		switch (type) {
			case CustomType.CUSTOM_TYPE__TYPE: result = de.haumacher.msgbuf.generator.ast.CustomType.readCustomType(in); break;
			case PrimitiveType.PRIMITIVE_TYPE__TYPE: result = de.haumacher.msgbuf.generator.ast.PrimitiveType.readPrimitiveType(in); break;
			case MapType.MAP_TYPE__TYPE: result = de.haumacher.msgbuf.generator.ast.MapType.readMapType(in); break;
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
