package test.nothing;

/**
 * A concrete type without abstract super type.
 */
public interface SimpleType {

	/**
	 * Creates a {@link SimpleType} instance.
	 */
	static SimpleType create() {
		return new test.nothing.SimpleType_Impl();
	}

	/**
	 * A string property
	 */
	String getStr();

	/**
	 * @see #getStr()
	 */
	SimpleType setStr(String value);

	/**
	 * An int property
	 */
	int getX();

	/**
	 * @see #getX()
	 */
	SimpleType setX(int value);

}
