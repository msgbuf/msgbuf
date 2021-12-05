/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.graph;

import java.io.IOException;

import de.haumacher.msgbuf.json.JsonReader;
import de.haumacher.msgbuf.json.JsonWriter;

/**
 * API for resolving cross-references in serialized object graphs.
 */
public interface Scope {

	/**
	 * Looks up the object with the given ID.
	 * 
	 * @param id
	 *        The ID of the requested object.
	 * @return The object with the given ID.
	 * @throws IllegalArgumentException
	 *         If there is no object with the requested ID.
	 */
	SharedGraphNode resolveOrFail(int id);

	/**
	 * Writes the given graph node to the given writer.
	 * 
	 * <p>
	 * If the node has already an ID in this scope, only the ID is transmitted as plain numeric value. Otherwise, a
	 * fresh ID is assigned to the node and the the full data of the given node is transmitted (by calling back to
	 * {@link SharedGraphNode#writeData(Scope, JsonWriter, int)}).
	 * </p>
	 *
	 * @param out
	 *        The {@link JsonWriter} to write to.
	 * @param node
	 *        The graph node to transmit.
	 */
	void writeRefOrData(JsonWriter out, SharedGraphNode node) throws IOException;

	/**
	 * Reads object data of the given node and assigns the given ID to this node.
	 *
	 * @param node
	 *        The node to read data for.
	 * @param id
	 *        The ID to assign ot the given node.
	 */
	void readData(SharedGraphNode node, int id, JsonReader in) throws IOException;

}
