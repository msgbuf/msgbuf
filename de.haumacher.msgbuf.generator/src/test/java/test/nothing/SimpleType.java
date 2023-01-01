package test.nothing;

/**
 * A concrete type without abstract super type.
 */
public interface SimpleType {

	/**
	 * Creates a {@link test.nothing.SimpleType} instance.
	 */
	static test.nothing.SimpleType create() {
		return new test.nothing.impl.SimpleType_Impl();
	}

	/**
	 * A string property
	 */
	String getStr();

	/**
	 * @see #getStr()
	 */
	test.nothing.SimpleType setStr(String value);

	/**
	 * An int property
	 */
	int getX();

	/**
	 * @see #getX()
	 */
	test.nothing.SimpleType setX(int value);

}
