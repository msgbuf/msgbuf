package test.jsonvalue.data;

/**
 * A message with multiple json fields.
 */
public interface DynamicConfig extends de.haumacher.msgbuf.data.DataObject {

	/**
	 * Creates a {@link test.jsonvalue.data.DynamicConfig} instance.
	 */
	static test.jsonvalue.data.DynamicConfig create() {
		return new test.jsonvalue.data.impl.DynamicConfig_Impl();
	}

	/** Identifier for the {@link test.jsonvalue.data.DynamicConfig} type in JSON format. */
	String DYNAMIC_CONFIG__TYPE = "DynamicConfig";

	/** @see #getName() */
	String NAME__PROP = "name";

	/** @see #getConfig() */
	String CONFIG__PROP = "config";

	/** @see #getMetadata() */
	String METADATA__PROP = "metadata";

	String getName();

	/**
	 * @see #getName()
	 */
	test.jsonvalue.data.DynamicConfig setName(String value);

	/**
	 * Primary configuration (any JSON structure).
	 */
	Object getConfig();

	/**
	 * @see #getConfig()
	 */
	test.jsonvalue.data.DynamicConfig setConfig(Object value);

	/**
	 * Checks, whether {@link #getConfig()} has a value.
	 */
	boolean hasConfig();

	/**
	 * Optional metadata.
	 */
	Object getMetadata();

	/**
	 * @see #getMetadata()
	 */
	test.jsonvalue.data.DynamicConfig setMetadata(Object value);

	/**
	 * Checks, whether {@link #getMetadata()} has a value.
	 */
	boolean hasMetadata();

	/** Reads a new instance from the given reader. */
	static test.jsonvalue.data.DynamicConfig readDynamicConfig(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.jsonvalue.data.impl.DynamicConfig_Impl result = new test.jsonvalue.data.impl.DynamicConfig_Impl();
		result.readContent(in);
		return result;
	}

}
