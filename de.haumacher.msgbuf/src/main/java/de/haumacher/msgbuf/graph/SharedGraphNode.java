/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.graph;

import java.io.IOException;

import de.haumacher.msgbuf.json.JsonReader;
import de.haumacher.msgbuf.json.JsonWriter;
import de.haumacher.msgbuf.observer.Observable;

/**
 * Object in a shared graph.
 * 
 * <p>
 * A shared graph is a collection of interconnected objects that exist on multiple host computers. All graphs are
 * observed for modifications. Modifications on one host can be transmitted as patch to all other participants and
 * applied there to keep the shared graph in sync.
 * </p>
 */
public interface SharedGraphNode extends Observable {

	/**
	 * Writes this node to the given writer.
	 * 
	 * <p>
	 * Depending on the given {@link Scope}, only a reference to this object is transmitted, if this node is already
	 * known by the {@link Scope}. Otherwise, the {@link #writeData(Scope, JsonWriter, int) complete object} data is
	 * transmitted.
	 * </p>
	 *
	 * @param scope
	 *        The shared graph {@link Scope} that handles object references.
	 * @param out
	 *        The writer to write to.
	 */
	void writeTo(Scope scope, JsonWriter out) throws IOException;

	/**
	 * Writes the complete data of this node including type and ID to the given writer.
	 * 
	 * <p>
	 * Note: This method should only be called from a {@link Scope}'s
	 * {@link Scope#writeRefOrData(JsonWriter, SharedGraphNode)} if a fresh ID was assigned.
	 * </p>
	 *
	 * @param scope
	 *        The shared graph {@link Scope} that handles object references.
	 * @param out
	 *        The writer to write to.
	 * @param id
	 *        The ID to use for this node.
	 */
	void writeData(Scope scope, JsonWriter out, int id) throws IOException;

	/**
	 * Reads all fields of this instance from the given input.
	 *
	 * @param scope
	 *        The shared graph {@link Scope} that handles object references.
	 * @param in
	 *        The reader to take the input from.
	 */
	void readFields(Scope scope, JsonReader in) throws IOException;

	/**
	 * Writes a single value that is currently assigned to the field with the given name to the given writer.
	 *
	 * @param scope
	 *        The shared graph {@link Scope} that handles object references.
	 * @param out
	 *        The writer to write to.
	 * @param field
	 *        The name of the field whose value should be written.
	 */
	void writeFieldValue(Scope scope, JsonWriter out, String field) throws IOException;

	/**
	 * Reads the given field from the given input.
	 * 
	 * @param scope
	 *        The shared graph {@link Scope} that handles object references.
	 * @param in
	 *        The reader to take the value from.
	 * @param field
	 *        The name of the field whose value should be read.
	 */
	void readField(Scope scope, JsonReader in, String field) throws IOException;

	/**
	 * Writes the given element value that is compatible with the repeated field with the given name to the given
	 * output.
	 *
	 * @param scope
	 *        The shared graph {@link Scope} that handles object references.
	 * @param out
	 *        The writer to write to.
	 * @param field
	 *        The name of the field whose element should be written.
	 * @param element
	 *        The element value of the given field.
	 */
	void writeElement(Scope scope, JsonWriter out, String field, Object element) throws IOException;

	/**
	 * Read an element of the repeated field with the given name.
	 *
	 * @param scope
	 *        The shared graph {@link Scope} that handles object references.
	 * @param in
	 *        The reader to take the value from.
	 * @param field
	 *        The repeated field where an element value should be read for.
	 * @return The read element value.
	 */
	Object readElement(Scope scope, JsonReader in, String field) throws IOException;

}
