/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.data;

import java.io.IOException;

import de.haumacher.msgbuf.io.StringW;
import de.haumacher.msgbuf.json.JsonReader;
import de.haumacher.msgbuf.json.JsonWriter;

/**
 * Base class for {@link DataObject} implementations.
 */
public abstract class AbstractDataObject implements DataObject {

	@Override
	public final void writeContent(JsonWriter out) throws java.io.IOException {
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

	@Override
	public final void readContent(JsonReader in) throws java.io.IOException {
		in.beginObject();
		readFields(in);
		in.endObject();
	}

	/**
	 * Reads all fields of this instance from the given input.
	 *
	 * @param in
	 *        The reader to take the input from.
	 */
	protected final void readFields(JsonReader in) throws IOException {
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
	protected void readField(JsonReader in, String field) throws IOException {
		in.skipValue();
	}

	@Override
	public String toString() {
		StringW out = new StringW();
		try {
			writeTo(new JsonWriter(out));
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
		return out.toString();
	}
	
}
