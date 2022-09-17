package test.nothing;

/**
 * A {@link Shape} that has no sub-shapes.
 */
public interface AtomicShape extends Shape {

	@Override
	AtomicShape setXCoordinate(int value);

	@Override
	AtomicShape setYCoordinate(int value);

}
