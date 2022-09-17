package test.novisitexceptions;

/**
 * A {@link Shape} that has no sub-shapes.
 */
abstract class AtomicShape_Impl extends Shape_Impl implements AtomicShape {

	/**
	 * Creates a {@link AtomicShape_Impl} instance.
	 */
	protected AtomicShape_Impl() {
		super();
	}

	@Override
	public AtomicShape setXCoordinate(int value) {
		internalSetXCoordinate(value);
		return this;
	}

	@Override
	public AtomicShape setYCoordinate(int value) {
		internalSetYCoordinate(value);
		return this;
	}

	@Override
	public final <R,A> R visit(Shape.Visitor<R,A> v, A arg) {
		return visit((AtomicShape.Visitor<R,A>) v, arg);
	}

}
