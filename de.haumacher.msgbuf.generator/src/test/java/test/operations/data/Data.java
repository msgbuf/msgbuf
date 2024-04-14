package test.operations.data;

/**
 * Data class for testing operation mix-ins.
 */
public interface Data extends de.haumacher.msgbuf.data.DataObject, test.operations.DataOperations {

	/** Type codes for the {@link test.operations.data.Data} hierarchy. */
	public enum TypeKind {

		/** Type literal for {@link test.operations.data.Data}. */
		DATA,

		/** Type literal for {@link test.operations.data.ExtendedData}. */
		EXTENDED_DATA,
		;

	}

	/**
	 * Creates a {@link test.operations.data.Data} instance.
	 */
	static test.operations.data.Data create() {
		return new test.operations.data.impl.Data_Impl();
	}

	/** Identifier for the {@link test.operations.data.Data} type in JSON format. */
	String DATA__TYPE = "Data";

	/** @see #getX() */
	String X__PROP = "x";

	/** The type code of this instance. */
	TypeKind kind();

	/**
	 * Some integer data field.
	 */
	int getX();

	/**
	 * @see #getX()
	 */
	test.operations.data.Data setX(int value);

	/** Reads a new instance from the given reader. */
	static test.operations.data.Data readData(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.operations.data.impl.Data_Impl result = new test.operations.data.impl.Data_Impl();
		result.readContent(in);
		return result;
	}

	@Override
	default Data self() {
		return this;
	}

}
