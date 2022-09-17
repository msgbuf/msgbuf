package test.graph.data;

/**
 * A rectangle.
 */
class Rectangle_Impl extends AtomicShape_Impl implements Rectangle {

	private int _width = 0;

	private int _height = 0;

	/**
	 * Creates a {@link Rectangle_Impl} instance.
	 *
	 * @see Rectangle#create()
	 */
	protected Rectangle_Impl() {
		super();
	}

	@Override
	public TypeKind kind() {
		return TypeKind.RECTANGLE;
	}

	@Override
	public final int getWidth() {
		return _width;
	}

	@Override
	public Rectangle setWidth(int value) {
		internalSetWidth(value);
		return this;
	}

	/** Internal setter for {@link #getWidth()} without chain call utility. */
	protected final void internalSetWidth(int value) {
		_listener.beforeSet(this, WIDTH, value);
		_width = value;
	}

	@Override
	public final int getHeight() {
		return _height;
	}

	@Override
	public Rectangle setHeight(int value) {
		internalSetHeight(value);
		return this;
	}

	/** Internal setter for {@link #getHeight()} without chain call utility. */
	protected final void internalSetHeight(int value) {
		_listener.beforeSet(this, HEIGHT, value);
		_height = value;
	}

	@Override
	public Rectangle setXCoordinate(int value) {
		internalSetXCoordinate(value);
		return this;
	}

	@Override
	public Rectangle setYCoordinate(int value) {
		internalSetYCoordinate(value);
		return this;
	}

	@Override
	public String jsonType() {
		return RECTANGLE__TYPE;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			WIDTH, 
			HEIGHT));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case WIDTH: return getWidth();
			case HEIGHT: return getHeight();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case WIDTH: internalSetWidth((int) value); break;
			case HEIGHT: internalSetHeight((int) value); break;
			default: super.set(field, value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.graph.Scope scope, de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(scope, out);
		out.name(WIDTH);
		out.value(getWidth());
		out.name(HEIGHT);
		out.value(getHeight());
	}

	@Override
	public void writeFieldValue(de.haumacher.msgbuf.graph.Scope scope, de.haumacher.msgbuf.json.JsonWriter out, String field) throws java.io.IOException {
		switch (field) {
			case WIDTH: {
				out.value(getWidth());
				break;
			}
			case HEIGHT: {
				out.value(getHeight());
				break;
			}
			default: super.writeFieldValue(scope, out, field);
		}
	}

	@Override
	public void readField(de.haumacher.msgbuf.graph.Scope scope, de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case WIDTH: setWidth(in.nextInt()); break;
			case HEIGHT: setHeight(in.nextInt()); break;
			default: super.readField(scope, in, field);
		}
	}

	@Override
	public <R,A,E extends Throwable> R visit(AtomicShape.Visitor<R,A,E> v, A arg) throws E {
		return v.visit(this, arg);
	}

}
