/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.data;

import java.util.List;

/**
 * An object with generically accessible properties.
 *
 * @author <a href="mailto:haui@haumacher.de">Bernhard Haumacher</a>
 */
public interface ReflectiveDataObject {

	/**
	 * All properties that are supported by this object.
	 * 
	 * @see #get(String)
	 */
	List<String> properties();

	/**
	 * Retrieves value of the field with the given name.
	 * 
	 * @param field
	 *        The name of the property.
	 * @return The value of the property with the given name.
	 * 
	 * @see #properties()
	 */
	Object get(String field);

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
	void set(String field, Object value);

}
