/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.graph;

import java.io.IOException;

import de.haumacher.msgbuf.data.AbstractDataObject;
import de.haumacher.msgbuf.io.StringW;
import de.haumacher.msgbuf.json.JsonReader;
import de.haumacher.msgbuf.json.JsonWriter;

/**
 * Base class for generated code implementing {@link SharedGraphNode}s.
 * 
 * <p>
 * This implementation is structurally equivalent to {@link AbstractDataObject} but adds a {@link Scope} to the method
 * signatures.
 * </p>
 */
public abstract class AbstractSharedGraphNode implements SharedGraphNode {
	
	private int _id;

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	/**
	 * The ID of this node in it's default {@link Scope}.
	 */
	public final int id() {
		return _id;
	}
	
	/**
	 * Assigns the given ID.
	 * 
	 * @see #id()
	 */
	protected void initId(int id) {
		assert _id == 0 : "ID already assigned.";
		if (id <= 0) {
			throw new IllegalArgumentException("Invalid ID: " + id);
		}
		_id = id;
	}

	@Override
	public SharedGraphNode registerListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
		return this;
	}

	@Override
	public SharedGraphNode unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
		return this;
	}
	
	@Override
	public final void writeTo(Scope scope, JsonWriter out) throws IOException {
		scope.writeRefOrData(out, this);
	}
	
	@Override
	public final void writeData(Scope scope, JsonWriter out, int id) throws IOException {
		out.beginArray();
		{
			out.value(jsonType());
			out.value(id);
			out.beginObject();
			{
				writeFields(scope, out);
			}
			out.endObject();
		}
		out.endArray();
	}

	/**
	 * Writes all fields of this instance to the given output.
	 * 
	 * @param scope
	 *        The shared graph {@link Scope}.
	 * @param out
	 *        The writer to write to.
	 * @throws IOException
	 *         If writing fails.
	 */
	protected void writeFields(Scope scope, JsonWriter out) throws IOException {
		// No fields.
	}
	
	@Override
	public final void readFields(Scope scope, JsonReader in) throws IOException {
		while (in.hasNext()) {
			String field = in.nextName();
			readField(scope, in, field);
		}
	}

	@Override
	public void readField(Scope scope, JsonReader in, String field) throws IOException {
		// Unknown, skip.
		in.skipValue();
	}
	
	@Override
	public void writeElement(Scope scope, JsonWriter out, String field, Object element) throws IOException {
		// Unknown.
		out.nullValue();
	}

	@Override
	public Object readElement(Scope scope, JsonReader in, String field) throws IOException {
		// Unknown.
		in.skipValue();
		return null;
	}

	@Override
	public void writeFieldValue(Scope scope, JsonWriter out, String field) throws IOException {
		// Unknown.
		out.nullValue();
	}

	@Override
	public String toString() {
		StringW out = new StringW();
		try {
			writeTo(new DummyScope(), new JsonWriter(out));
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
		return out.toString();
	}
	
}
