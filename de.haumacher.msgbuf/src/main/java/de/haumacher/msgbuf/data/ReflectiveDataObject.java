/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.data;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * An object with generically accessible properties.
 *
 * @author <a href="mailto:haui@haumacher.de">Bernhard Haumacher</a>
 */
public interface ReflectiveDataObject {

	/** The type identifier for this concrete sub-type. */
	public abstract String jsonType();

	/**
	 * All properties that are supported by this object.
	 * 
	 * @see #get(String)
	 */
	default List<String> properties() {
		return Collections.emptyList();
	}

	/**
	 * All {@link #properties()} that are marked <code>transient</code>.
	 */
	default Set<String> transientProperties() {
		return Collections.emptySet();
	}

	/**
	 * Retrieves value of the field with the given name.
	 * 
	 * @param field
	 *        The name of the property.
	 * @return The value of the property with the given name.
	 * 
	 * @see #properties()
	 */
	default Object get(String field) {
		return null;
	}

	/**
	 * Sets the value of the property with the given name.
	 * 
	 * @param field
	 *        The name of the property to update.
	 * @param value
	 *        The new value of the property.
	 * 
	 * @see #get(String)
	 */
	default void set(String field, Object value) {
		// Ignore.
	}

}
