/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.data;

import java.io.IOException;

import de.haumacher.msgbuf.json.JsonReader;
import de.haumacher.msgbuf.json.JsonWriter;

/**
 * Base class for {@link DataObject} implementations.
 */
public abstract class AbstractDataObject implements DataObject {

	@Override
	public Object get(String field) {
		return null;
	}
	
	@Override
	public void set(String field, Object value) {
		// Ignore.
	}
	
	/**
	 * Writes a JSON object containing keys for all fields of this object.
	 *
	 * @param out
	 *        The writer to write to.
	 */
	protected final void writeContent(JsonWriter out)
			throws java.io.IOException {
		out.beginObject();
		writeFields(out);
		out.endObject();
	}

	/**
	 * Writes all fields of this instance to the given output.
	 * 
	 * @param out
	 *        The writer to write to.
	 * @throws IOException
	 *         If writing fails.
	 */
	protected void writeFields(JsonWriter out) throws IOException {
		// No fields.
	}

	/**
	 * Reads all fields of this instance from the given input.
	 *
	 * @param in
	 *        The reader to take the input from.
	 */
	protected final void readFields(JsonReader in)
			throws java.io.IOException {
		while (in.hasNext()) {
			String field = in.nextName();
			readField(in, field);
		}
	}

	/**
	 * Reads the given field from the given input.
	 * 
	 * @param in
	 *        The reader to take the value from.
	 * @param field
	 *        The name of the field whose value should be read.
	 */
	protected void readField(de.haumacher.msgbuf.json.JsonReader in,
			String field) throws java.io.IOException {
		in.skipValue();
	}

}
