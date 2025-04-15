package de.haumacher.msgbuf.generator.ast;

/**
 * A dot-separated qualified name.
 */
public class QName extends de.haumacher.msgbuf.data.AbstractDataObject implements de.haumacher.msgbuf.observer.Observable {

	/**
	 * Creates a {@link de.haumacher.msgbuf.generator.ast.QName} instance.
	 */
	public static de.haumacher.msgbuf.generator.ast.QName create() {
		return new de.haumacher.msgbuf.generator.ast.QName();
	}

	/** Identifier for the {@link de.haumacher.msgbuf.generator.ast.QName} type in JSON format. */
	public static final String QNAME__TYPE = "QName";

	/** @see #getNames() */
	public static final String NAMES__PROP = "names";

	private final java.util.List<String> _names = new de.haumacher.msgbuf.util.ReferenceList<>() {
		@Override
		protected void beforeAdd(int index, String element) {
			_listener.beforeAdd(QName.this, NAMES__PROP, index, element);
		}

		@Override
		protected void afterRemove(int index, String element) {
			_listener.afterRemove(QName.this, NAMES__PROP, index, element);
		}
	};

	/**
	 * Creates a {@link QName} instance.
	 *
	 * @see de.haumacher.msgbuf.generator.ast.QName#create()
	 */
	protected QName() {
		super();
	}

	/**
	 * The parts that compose this qualified name.
	 */
	public final java.util.List<String> getNames() {
		return _names;
	}

	/**
	 * @see #getNames()
	 */
	public de.haumacher.msgbuf.generator.ast.QName setNames(java.util.List<? extends String> value) {
		internalSetNames(value);
		return this;
	}

	/** Internal setter for {@link #getNames()} without chain call utility. */
	protected final void internalSetNames(java.util.List<? extends String> value) {
		_names.clear();
		_names.addAll(value);
	}

	/**
	 * Adds a value to the {@link #getNames()} list.
	 */
	public de.haumacher.msgbuf.generator.ast.QName addName(String value) {
		internalAddName(value);
		return this;
	}

	/** Implementation of {@link #addName(String)} without chain call utility. */
	protected final void internalAddName(String value) {
		_names.add(value);
	}

	/**
	 * Removes a value from the {@link #getNames()} list.
	 */
	public final void removeName(String value) {
		_names.remove(value);
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public de.haumacher.msgbuf.generator.ast.QName registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public de.haumacher.msgbuf.generator.ast.QName unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		internalUnregisterListener(l);
		return this;
	}

	protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
	}

	@Override
	public String jsonType() {
		return QNAME__TYPE;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			NAMES__PROP));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case NAMES__PROP: return getNames();
			default: return null;
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case NAMES__PROP: internalSetNames(de.haumacher.msgbuf.util.Conversions.asList(String.class, value)); break;
		}
	}

	/** Reads a new instance from the given reader. */
	public static de.haumacher.msgbuf.generator.ast.QName readQName(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		de.haumacher.msgbuf.generator.ast.QName result = new de.haumacher.msgbuf.generator.ast.QName();
		result.readContent(in);
		return result;
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(NAMES__PROP);
		out.beginArray();
		for (String x : getNames()) {
			out.value(x);
		}
		out.endArray();
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case NAMES__PROP: {
				java.util.List<String> newValue = new java.util.ArrayList<>();
				in.beginArray();
				while (in.hasNext()) {
					newValue.add(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in));
				}
				in.endArray();
				setNames(newValue);
			}
			break;
			default: super.readField(in, field);
		}
	}

}
