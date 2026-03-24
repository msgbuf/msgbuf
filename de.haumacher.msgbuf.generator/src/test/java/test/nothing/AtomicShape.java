package test.nothing;

/**
 * A {@link Shape} that has no sub-shapes.
 */
public interface AtomicShape extends test.nothing.Shape {

	@Override
	test.nothing.AtomicShape setXCoordinate(int value);

	@Override
	test.nothing.AtomicShape setYCoordinate(int value);

}
