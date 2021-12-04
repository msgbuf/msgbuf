/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.graph;

import java.io.IOException;
import java.util.Map;
import java.util.function.Consumer;

import de.haumacher.msgbuf.json.JsonWriter;

/**
 * {@link Scope} implementation that can be mixed in to another class.
 *
 * @author <a href="mailto:haui@haumacher.de">Bernhard Haumacher</a>
 */
public interface ScopeMixin extends Scope {

	@Override
	default void resolve(int id, Consumer<SharedGraphNode> setter) {
		SharedGraphNode obj = index().get(id);
		if (obj == null) {
			Consumer<SharedGraphNode> first = references().put(id, setter);
			if (first != null) {
				Consumer<SharedGraphNode> next = setter;
				references().put(id, value -> {first.accept(value); next.accept(value);}); 
			}
		} else {
			Consumer<SharedGraphNode> resolver = setter;
			resolver.accept(obj);
		}
	}
	
	@Override
	default SharedGraphNode resolveOrFail(int id) {
		SharedGraphNode result = index().get(id);
		if (result == null) {
			throw new IllegalArgumentException("No object with ID '" + id + "'.");
		}
		return result;
	}
	
	@Override
	default int enter(AbstractSharedGraphNode node) {
		int id = node.id();
		if (id == 0) {
			id = newId();
			enter(node, id);
		}
		return id;
	}
	
	@Override
	default void enter(AbstractSharedGraphNode node, int id) {
		node.initId(id);
		SharedGraphNode clash = index().put(id, node);
		assert clash == null : "Clash of ID " + id + ": " + clash + " vs. " + node;
	}

	@Override
	default void write(JsonWriter out, AbstractSharedGraphNode node) throws IOException {
		node.writeTo(this, out, enter(node));
	}
	
	/**
	 * Checks whether all references have been resolved.
	 */
	default void finish() {
		if (references().size() > 0) {
			throw new IllegalStateException("Unresolved references: " + references().keySet());
		}
	}
	
	/**
	 * Creates a fresh ID.
	 */
	int newId();
	
	/**
	 * The index implementation associating object with IDs.
	 */
	Map<Object, SharedGraphNode> index();

	/**
	 * The mapping of IDs to callbacks that expect a value for such IDs.
	 */
	Map<Object, Consumer<SharedGraphNode>> references();

}
