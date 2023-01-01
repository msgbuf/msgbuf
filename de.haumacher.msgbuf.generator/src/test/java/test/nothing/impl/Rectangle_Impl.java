package test.nothing.impl;

/**
 * A rectangle.
 */
public class Rectangle_Impl extends test.nothing.impl.AtomicShape_Impl implements test.nothing.Rectangle {

	private int _width = 0;

	private int _height = 0;

	/**
	 * Creates a {@link Rectangle_Impl} instance.
	 *
	 * @see test.nothing.Rectangle#create()
	 */
	public Rectangle_Impl() {
		super();
	}

	@Override
	public final int getWidth() {
		return _width;
	}

	@Override
	public test.nothing.Rectangle setWidth(int value) {
		internalSetWidth(value);
		return this;
	}

	/** Internal setter for {@link #getWidth()} without chain call utility. */
	protected final void internalSetWidth(int value) {
		_width = value;
	}

	@Override
	public final int getHeight() {
		return _height;
	}

	@Override
	public test.nothing.Rectangle setHeight(int value) {
		internalSetHeight(value);
		return this;
	}

	/** Internal setter for {@link #getHeight()} without chain call utility. */
	protected final void internalSetHeight(int value) {
		_height = value;
	}

	@Override
	public test.nothing.Rectangle setXCoordinate(int value) {
		internalSetXCoordinate(value);
		return this;
	}

	@Override
	public test.nothing.Rectangle setYCoordinate(int value) {
		internalSetYCoordinate(value);
		return this;
	}

}
