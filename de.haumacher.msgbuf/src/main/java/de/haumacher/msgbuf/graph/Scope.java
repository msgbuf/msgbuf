/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.graph;

import java.util.function.Consumer;

/**
 * API for resolving cross-references in serialized object graphs.
 */
public interface Scope {

	/**
	 * Looks up the object with the given ID and passes it to the given {@link Consumer}.
	 * 
	 * <p>
	 * The call to the given consumer happens either as direct callback, if the object with the given ID is already
	 * available, or as soon as it becomes available in the future.
	 * </p>
	 *
	 * @param id
	 *        The ID of the requested object.
	 * @param setter
	 *        The callback to invoke with the object identified with the given ID as soon as this object becomes
	 *        available.
	 */
	void resolve(Object id, Consumer<?> setter);

	/**
	 * Enter an object with an ID to this scope.
	 *
	 * @param id
	 *        The ID for the given object.
	 * @param obj
	 *        The object that is identified with the given ID.
	 */
	void enter(Object id, Object obj);

}
