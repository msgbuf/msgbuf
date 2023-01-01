package test.nothing;

/**
 * A concrete type without abstract super type.
 */
class SimpleType_Impl implements SimpleType {

	private String _str = "";

	private int _x = 0;

	/**
	 * Creates a {@link SimpleType_Impl} instance.
	 *
	 * @see SimpleType#create()
	 */
	protected SimpleType_Impl() {
		super();
	}

	@Override
	public final String getStr() {
		return _str;
	}

	@Override
	public SimpleType setStr(String value) {
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
	public SimpleType setX(int value) {
		internalSetX(value);
		return this;
	}

	/** Internal setter for {@link #getX()} without chain call utility. */
	protected final void internalSetX(int value) {
		_x = value;
	}

}
