package test.graph.data;

/**
 * An abstract base class for all shapes
 */
abstract class Shape_Impl extends de.haumacher.msgbuf.graph.AbstractSharedGraphNode implements Shape {

	private int _xCoordinate = 0;

	private int _yCoordinate = 0;

	/**
	 * Creates a {@link Shape_Impl} instance.
	 */
	protected Shape_Impl() {
		super();
	}

	/** The type code of this instance. */
	public abstract TypeKind kind();

	@Override
	public final int getXCoordinate() {
		return _xCoordinate;
	}

	@Override
	public Shape setXCoordinate(int value) {
		internalSetXCoordinate(value);
		return this;
	}

	/** Internal setter for {@link #getXCoordinate()} without chain call utility. */
	protected final void internalSetXCoordinate(int value) {
		_listener.beforeSet(this, X_COORDINATE, value);
		_xCoordinate = value;
	}

	@Override
	public final int getYCoordinate() {
		return _yCoordinate;
	}

	@Override
	public Shape setYCoordinate(int value) {
		internalSetYCoordinate(value);
		return this;
	}

	/** Internal setter for {@link #getYCoordinate()} without chain call utility. */
	protected final void internalSetYCoordinate(int value) {
		_listener.beforeSet(this, Y_COORDINATE, value);
		_yCoordinate = value;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			X_COORDINATE, 
			Y_COORDINATE));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case X_COORDINATE: return getXCoordinate();
			case Y_COORDINATE: return getYCoordinate();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case X_COORDINATE: internalSetXCoordinate((int) value); break;
			case Y_COORDINATE: internalSetYCoordinate((int) value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.graph.Scope scope, de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(scope, out);
		out.name(X_COORDINATE);
		out.value(getXCoordinate());
		out.name(Y_COORDINATE);
		out.value(getYCoordinate());
	}

	@Override
	public void writeFieldValue(de.haumacher.msgbuf.graph.Scope scope, de.haumacher.msgbuf.json.JsonWriter out, String field) throws java.io.IOException {
		switch (field) {
			case X_COORDINATE: {
				out.value(getXCoordinate());
				break;
			}
			case Y_COORDINATE: {
				out.value(getYCoordinate());
				break;
			}
			default: super.writeFieldValue(scope, out, field);
		}
	}

	@Override
	public void readField(de.haumacher.msgbuf.graph.Scope scope, de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case X_COORDINATE: setXCoordinate(in.nextInt()); break;
			case Y_COORDINATE: setYCoordinate(in.nextInt()); break;
			default: super.readField(scope, in, field);
		}
	}

}
