/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.graph;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import de.haumacher.msgbuf.json.JsonWriter;

/**
 * {@link Scope} that can only create IDs.
 */
class DummyScope implements Scope {

	private int _nextId = 1;
	
	private Map<Object, Integer> _ids = new HashMap<>();

	@Override
	public void resolve(int id, Consumer<SharedGraphNode> setter) {
		throw new UnsupportedOperationException();
	}

	@Override
	public SharedGraphNode resolveOrFail(int id) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public int enter(AbstractSharedGraphNode node) {
		Integer id = _ids.get(node);
		if (id == null) {
			id = Integer.valueOf(_nextId++);
			enter(node, id);
		}
		return id.intValue();
	}
	
	@Override
	public void enter(AbstractSharedGraphNode node, int id) {
		_ids.put(node, id);
	}

	@Override
	public void write(JsonWriter out, AbstractSharedGraphNode node) throws IOException {
		node.writeTo(this, out, enter(node));
	}

}
