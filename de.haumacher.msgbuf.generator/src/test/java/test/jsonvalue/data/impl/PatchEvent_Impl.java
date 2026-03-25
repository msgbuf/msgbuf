package test.jsonvalue.data.impl;

/**
 * Implementation of {@link test.jsonvalue.data.PatchEvent}.
 */
public class PatchEvent_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.jsonvalue.data.PatchEvent {

	private String _controlId = "";

	private Object _patch = null;

	/**
	 * Creates a {@link PatchEvent_Impl} instance.
	 *
	 * @see test.jsonvalue.data.PatchEvent#create()
	 */
	public PatchEvent_Impl() {
		super();
	}

	@Override
	public final String getControlId() {
		return _controlId;
	}

	@Override
	public test.jsonvalue.data.PatchEvent setControlId(String value) {
		internalSetControlId(value);
		return this;
	}

	/** Internal setter for {@link #getControlId()} without chain call utility. */
	protected final void internalSetControlId(String value) {
		_controlId = value;
	}

	@Override
	public final Object getPatch() {
		return _patch;
	}

	@Override
	public test.jsonvalue.data.PatchEvent setPatch(Object value) {
		internalSetPatch(value);
		return this;
	}

	/** Internal setter for {@link #getPatch()} without chain call utility. */
	protected final void internalSetPatch(Object value) {
		_patch = value;
	}

	@Override
	public final boolean hasPatch() {
		return _patch != null;
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(CONTROL_ID__PROP);
		out.value(getControlId());
		if (hasPatch()) {
			out.name(PATCH__PROP);
			de.haumacher.msgbuf.json.JsonUtil.writeJsonValue(out, getPatch());
		}
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case CONTROL_ID__PROP: setControlId(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			case PATCH__PROP: setPatch(de.haumacher.msgbuf.json.JsonUtil.nextJsonValue(in)); break;
			default: super.readField(in, field);
		}
	}

}
