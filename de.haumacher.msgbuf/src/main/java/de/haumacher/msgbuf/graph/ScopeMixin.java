/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.graph;

import java.util.Map;
import java.util.function.Consumer;

/**
 * {@link Scope} implementation that can be mixed in to another class.
 *
 * @author <a href="mailto:haui@haumacher.de">Bernhard Haumacher</a>
 */
public interface ScopeMixin extends Scope {

	@Override
	default void resolve(Object id, Consumer<?> setter) {
		Object obj = index().get(id);
		if (obj == null) {
			@SuppressWarnings("unchecked")
			Consumer<Object> first = (Consumer<Object>) references().put(id, setter);
			if (first != null) {
				@SuppressWarnings("unchecked")
				Consumer<Object> next = (Consumer<Object>) setter;
				references().put(id, value -> {first.accept(value); next.accept(value);}); 
			}
		} else {
			@SuppressWarnings("unchecked")
			Consumer<Object> resolver = (Consumer<Object>) setter;
			resolver.accept(obj);
		}
	}

	@Override
	default void enter(Object id, Object obj) {
		index().put(id, obj);
		
		@SuppressWarnings("unchecked")
		Consumer<Object> references = (Consumer<Object>) references().remove(id);
		if (references != null) {
			references.accept(obj);
		}
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
	 * The index implementation associating object with IDs.
	 */
	Map<Object, Object> index();

	/**
	 * The mapping of IDs to callbacks that expect a value for such IDs.
	 */
	Map<Object, Consumer<?>> references();

}
