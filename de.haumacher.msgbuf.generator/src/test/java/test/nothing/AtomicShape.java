package test.nothing;

/**
 * A {@link Shape} that has no sub-shapes.
 */
public abstract class AtomicShape<S extends AtomicShape<S>> extends Shape<S> {

	/**
	 * Creates a {@link AtomicShape} instance.
	 */
	protected AtomicShape() {
		super();
	}

}
