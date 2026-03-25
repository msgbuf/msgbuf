package test.jsonvalue.data.impl;

/**
 * Implementation of {@link test.jsonvalue.data.DynamicConfig}.
 */
public class DynamicConfig_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.jsonvalue.data.DynamicConfig {

	private String _name = "";

	private Object _config = null;

	private Object _metadata = null;

	/**
	 * Creates a {@link DynamicConfig_Impl} instance.
	 *
	 * @see test.jsonvalue.data.DynamicConfig#create()
	 */
	public DynamicConfig_Impl() {
		super();
	}

	@Override
	public final String getName() {
		return _name;
	}

	@Override
	public test.jsonvalue.data.DynamicConfig setName(String value) {
		internalSetName(value);
		return this;
	}

	/** Internal setter for {@link #getName()} without chain call utility. */
	protected final void internalSetName(String value) {
		_name = value;
	}

	@Override
	public final Object getConfig() {
		return _config;
	}

	@Override
	public test.jsonvalue.data.DynamicConfig setConfig(Object value) {
		internalSetConfig(value);
		return this;
	}

	/** Internal setter for {@link #getConfig()} without chain call utility. */
	protected final void internalSetConfig(Object value) {
		_config = value;
	}

	@Override
	public final boolean hasConfig() {
		return _config != null;
	}

	@Override
	public final Object getMetadata() {
		return _metadata;
	}

	@Override
	public test.jsonvalue.data.DynamicConfig setMetadata(Object value) {
		internalSetMetadata(value);
		return this;
	}

	/** Internal setter for {@link #getMetadata()} without chain call utility. */
	protected final void internalSetMetadata(Object value) {
		_metadata = value;
	}

	@Override
	public final boolean hasMetadata() {
		return _metadata != null;
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(NAME__PROP);
		out.value(getName());
		if (hasConfig()) {
			out.name(CONFIG__PROP);
			de.haumacher.msgbuf.json.JsonUtil.writeJsonValue(out, getConfig());
		}
		if (hasMetadata()) {
			out.name(METADATA__PROP);
			de.haumacher.msgbuf.json.JsonUtil.writeJsonValue(out, getMetadata());
		}
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case NAME__PROP: setName(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			case CONFIG__PROP: setConfig(de.haumacher.msgbuf.json.JsonUtil.nextJsonValue(in)); break;
			case METADATA__PROP: setMetadata(de.haumacher.msgbuf.json.JsonUtil.nextJsonValue(in)); break;
			default: super.readField(in, field);
		}
	}

}
