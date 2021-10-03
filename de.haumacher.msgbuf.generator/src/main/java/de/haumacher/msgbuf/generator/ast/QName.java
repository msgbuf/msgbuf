package de.haumacher.msgbuf.generator.ast;

/**
 * A dot-separated qualified name.
 */
public class QName extends de.haumacher.msgbuf.data.AbstractDataObject {

	/**
	 * Creates a {@link QName} instance.
	 */
	public static QName create() {
		return new QName();
	}

	/** Identifier for the {@link QName} type in JSON format. */
	public static final String QNAME__TYPE = "QName";

	/** @see #getNames() */
	private static final String NAMES = "names";

	private final java.util.List<String> _names = new java.util.ArrayList<>();

	/**
	 * Creates a {@link QName} instance.
	 *
	 * @see #create()
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
	public final QName setNames(java.util.List<String> value) {
		_names.clear();
		_names.addAll(value);
		return this;
	}

	/**
	 * Adds a value to the {@link #getNames()} list.
	 */
	public final QName addName(String value) {
		_names.add(value);
		return this;
	}

	/** Reads a new instance from the given reader. */
	public static QName readQName(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		QName result = new QName();
		in.beginObject();
		result.readFields(in);
		in.endObject();
		return result;
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(NAMES);
		out.beginArray();
		for (String x : getNames()) {
			out.value(x);
		}
		out.endArray();
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case NAMES: {
				in.beginArray();
				while (in.hasNext()) {
					addName(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in));
				}
				in.endArray();
			}
			break;
			default: super.readField(in, field);
		}
	}

}
