package test.nothing.impl;

/**
 * A {@link Shape} that has no sub-shapes.
 */
public abstract class AtomicShape_Impl extends test.nothing.impl.Shape_Impl implements test.nothing.AtomicShape {

	/**
	 * Creates a {@link AtomicShape_Impl} instance.
	 */
	public AtomicShape_Impl() {
		super();
	}

	@Override
	public test.nothing.AtomicShape setXCoordinate(int value) {
		internalSetXCoordinate(value);
		return this;
	}

	@Override
	public test.nothing.AtomicShape setYCoordinate(int value) {
		internalSetYCoordinate(value);
		return this;
	}

}
