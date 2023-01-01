package test.nothing.impl;

/**
 * A concrete type without abstract super type.
 */
public class SimpleType_Impl implements test.nothing.SimpleType {

	private String _str = "";

	private int _x = 0;

	/**
	 * Creates a {@link SimpleType_Impl} instance.
	 *
	 * @see test.nothing.SimpleType#create()
	 */
	public SimpleType_Impl() {
		super();
	}

	@Override
	public final String getStr() {
		return _str;
	}

	@Override
	public test.nothing.SimpleType setStr(String value) {
		internalSetStr(value);
		return this;
	}

	/** Internal setter for {@link #getStr()} without chain call utility. */
	protected final void internalSetStr(String value) {
		_str = value;
	}

	@Override
	public final int getX() {
		return _x;
	}

	@Override
	public test.nothing.SimpleType setX(int value) {
		internalSetX(value);
		return this;
	}

	/** Internal setter for {@link #getX()} without chain call utility. */
	protected final void internalSetX(int value) {
		_x = value;
	}

}
