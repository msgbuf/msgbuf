package test.operations.data.impl;

/**
 * Implementation of {@link test.operations.data.Data}.
 */
public class Data_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.operations.data.Data {

	private int _x = 0;

	/**
	 * Creates a {@link Data_Impl} instance.
	 *
	 * @see test.operations.data.Data#create()
	 */
	public Data_Impl() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.DATA;
	}

	@Override
	public final int getX() {
		return _x;
	}

	@Override
	public test.operations.data.Data setX(int value) {
		internalSetX(value);
		return this;
	}

	/** Internal setter for {@link #getX()} without chain call utility. */
	protected final void internalSetX(int value) {
		_x = value;
	}

	/** The type identifier for this concrete subtype. */
	public String jsonType() {
		return DATA__TYPE;
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(X__PROP);
		out.value(getX());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case X__PROP: setX(in.nextInt()); break;
			default: super.readField(in, field);
		}
	}

}
