/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.graph;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import de.haumacher.msgbuf.json.JsonReader;
import de.haumacher.msgbuf.json.JsonWriter;

/**
 * {@link Scope} that can only create IDs.
 */
class DummyScope implements Scope {

	private int _nextId = 1;
	
	private Map<Object, Integer> _ids = new HashMap<>();

	@Override
	public SharedGraphNode resolveOrFail(int id) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void readData(SharedGraphNode node, int id, JsonReader in) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void writeRefOrData(JsonWriter out, SharedGraphNode node) throws IOException {
		Integer id = _ids.get(node);
		if (id == null) {
			id = Integer.valueOf(_nextId++);
			_ids.put(node, id);
			node.writeData(this, out, id.intValue());
		} else {
			out.value(id.intValue());
		}
	}

}
