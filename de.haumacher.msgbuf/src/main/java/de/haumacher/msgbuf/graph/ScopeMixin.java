/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.graph;

import java.io.IOException;
import java.util.Map;

import de.haumacher.msgbuf.json.JsonReader;
import de.haumacher.msgbuf.json.JsonWriter;

/**
 * {@link Scope} implementation that can be mixed in to another class.
 *
 * @author <a href="mailto:haui@haumacher.de">Bernhard Haumacher</a>
 */
public interface ScopeMixin extends Scope {

	@Override
	default SharedGraphNode resolveOrFail(int id) {
		SharedGraphNode result = index().get(id);
		if (result == null) {
			throw new IllegalArgumentException("No object with ID '" + id + "'.");
		}
		return result;
	}
	
	/**
	 * Assigns the given ID to the given node.
	 */
	default void enter(SharedGraphNode node, int id) {
		initId(node, id);
		SharedGraphNode clash = index().put(id, node);
		assert clash == null : "Clash of ID " + id + ": " + clash + " vs. " + node;
	}
	
	@Override
	default void readData(SharedGraphNode node, int id, JsonReader in) throws IOException {
		enter(node, id);
		in.beginObject();
		node.readFields(this, in);
		in.endObject();
	}

	@Override
	default void writeRefOrData(JsonWriter out, SharedGraphNode node) throws IOException {
		int id = id(node);
		if (id == 0) {
			id = newId();
			enter(node, id);
			node.writeData(this, out, id);
		} else {
			out.value(id);
		}
	}
	
	/** 
	 * Looks up the ID of the given node in this {@link Scope}.
	 * 
	 * @see #initId(SharedGraphNode, int)
	 */
	int id(SharedGraphNode node);

	/** 
	 * Assigns the given ID to the given node.
	 * 
	 * @see #id(SharedGraphNode)
	 */
	void initId(SharedGraphNode node, int id);

	/**
	 * Creates a fresh ID.
	 */
	int newId();
	
	/**
	 * The index implementation associating object with IDs.
	 */
	Map<Object, SharedGraphNode> index();

}
