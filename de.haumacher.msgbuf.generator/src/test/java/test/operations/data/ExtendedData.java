package test.operations.data;

public interface ExtendedData extends Data, test.operations.ExtendedOperations {

	/**
	 * Creates a {@link test.operations.data.ExtendedData} instance.
	 */
	static test.operations.data.ExtendedData create() {
		return new test.operations.data.impl.ExtendedData_Impl();
	}

	/** Identifier for the {@link test.operations.data.ExtendedData} type in JSON format. */
	String EXTENDED_DATA__TYPE = "ExtendedData";

	/** @see #getY() */
	String Y__PROP = "y";

	/**
	 * Some other integer data field.
	 */
	int getY();

	/**
	 * @see #getY()
	 */
	test.operations.data.ExtendedData setY(int value);

	@Override
	test.operations.data.ExtendedData setX(int value);

	/** Reads a new instance from the given reader. */
	static test.operations.data.ExtendedData readExtendedData(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.operations.data.impl.ExtendedData_Impl result = new test.operations.data.impl.ExtendedData_Impl();
		result.readContent(in);
		return result;
	}

	@Override
	default ExtendedData self() {
		return this;
	}

}
