package test.nothing.impl;

/**
 * Implementation of {@link test.nothing.Group}.
 */
public class Group_Impl extends test.nothing.impl.Shape_Impl implements test.nothing.Group {

	private final java.util.List<test.nothing.Shape> _shapes = new java.util.ArrayList<>();

	/**
	 * Creates a {@link Group_Impl} instance.
	 *
	 * @see test.nothing.Group#create()
	 */
	public Group_Impl() {
		super();
	}

	@Override
	public final java.util.List<test.nothing.Shape> getShapes() {
		return _shapes;
	}

	@Override
	public test.nothing.Group setShapes(java.util.List<? extends test.nothing.Shape> value) {
		internalSetShapes(value);
		return this;
	}

	/** Internal setter for {@link #getShapes()} without chain call utility. */
	protected final void internalSetShapes(java.util.List<? extends test.nothing.Shape> value) {
		if (value == null) throw new IllegalArgumentException("Property 'shapes' cannot be null.");
		_shapes.clear();
		_shapes.addAll(value);
	}

	@Override
	public test.nothing.Group addShape(test.nothing.Shape value) {
		internalAddShape(value);
		return this;
	}

	/** Implementation of {@link #addShape(test.nothing.Shape)} without chain call utility. */
	protected final void internalAddShape(test.nothing.Shape value) {
		_shapes.add(value);
	}

	@Override
	public final void removeShape(test.nothing.Shape value) {
		_shapes.remove(value);
	}

	@Override
	public test.nothing.Group setXCoordinate(int value) {
		internalSetXCoordinate(value);
		return this;
	}

	@Override
	public test.nothing.Group setYCoordinate(int value) {
		internalSetYCoordinate(value);
		return this;
	}

}
