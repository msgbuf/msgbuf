package test.jsonbinary.data.impl;

/**
 * Implementation of {@link test.jsonbinary.data.BinaryPatchEvent}.
 */
public class BinaryPatchEvent_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements test.jsonbinary.data.BinaryPatchEvent {

	private String _controlId = "";

	private Object _patch = null;

	/**
	 * Creates a {@link BinaryPatchEvent_Impl} instance.
	 *
	 * @see test.jsonbinary.data.BinaryPatchEvent#create()
	 */
	public BinaryPatchEvent_Impl() {
		super();
	}

	@Override
	public final String getControlId() {
		return _controlId;
	}

	@Override
	public test.jsonbinary.data.BinaryPatchEvent setControlId(String value) {
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
	public test.jsonbinary.data.BinaryPatchEvent setPatch(Object value) {
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

	@Override
	public final void writeTo(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		out.beginObject();
		writeFields(out);
		out.endObject();
	}

	/**
	 * Serializes all fields of this instance to the given binary output.
	 *
	 * @param out
	 *        The binary output to write to.
	 * @throws java.io.IOException If writing fails.
	 */
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		out.name(CONTROL_ID__ID);
		out.value(getControlId());
		if (hasPatch()) {
			out.name(PATCH__ID);
			de.haumacher.msgbuf.json.JsonUtil.toJsonValue(getPatch()).writeTo(out);
		}
	}

	/** Helper for creating an object of type {@link test.jsonbinary.data.BinaryPatchEvent} from a polymorphic composition. */
	public static test.jsonbinary.data.BinaryPatchEvent readBinaryPatchEvent_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.jsonbinary.data.impl.BinaryPatchEvent_Impl result = new BinaryPatchEvent_Impl();
		result.readContent(in);
		return result;
	}

	/** Helper for reading all fields of this instance. */
	protected final void readContent(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		while (in.hasNext()) {
			int field = in.nextName();
			readField(in, field);
		}
	}

	/** Consumes the value for the field with the given ID and assigns its value. */
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case CONTROL_ID__ID: setControlId(in.nextString()); break;
			case PATCH__ID: setPatch(de.haumacher.msgbuf.json.JsonUtil.fromJsonValue(de.haumacher.msgbuf.json.value.JsonValue.readJsonValue(in))); break;
			default: in.skipValue(); 
		}
	}

}
