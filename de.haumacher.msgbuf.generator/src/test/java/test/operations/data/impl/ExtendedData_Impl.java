package test.operations.data.impl;

/**
 * Implementation of {@link test.operations.data.ExtendedData}.
 */
public class ExtendedData_Impl extends test.operations.data.impl.Data_Impl implements test.operations.data.ExtendedData {

	private int _y = 0;

	/**
	 * Creates a {@link ExtendedData_Impl} instance.
	 *
	 * @see test.operations.data.ExtendedData#create()
	 */
	public ExtendedData_Impl() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.EXTENDED_DATA;
	}

	@Override
	public final int getY() {
		return _y;
	}

	@Override
	public test.operations.data.ExtendedData setY(int value) {
		internalSetY(value);
		return this;
	}

	/** Internal setter for {@link #getY()} without chain call utility. */
	protected final void internalSetY(int value) {
		_y = value;
	}

	@Override
	public test.operations.data.ExtendedData setX(int value) {
		internalSetX(value);
		return this;
	}

	@Override
	public String jsonType() {
		return EXTENDED_DATA__TYPE;
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(Y__PROP);
		out.value(getY());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case Y__PROP: setY(in.nextInt()); break;
			default: super.readField(in, field);
		}
	}

}
