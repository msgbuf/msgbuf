/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.data;

import java.io.IOException;

import de.haumacher.msgbuf.json.JsonWriter;

/**
 * Common interface for all <code>msgbuf</code> generated data objects.
 */
public interface DataObject {

	/**
	 * Retrieves value of the field with the given name.
	 * 
	 * @param field
	 *        The name of the field.
	 * @return The value of the field with the given name.
	 */
	Object get(String field);

	/**
	 * Sets the value of the field with the given name.
	 * 
	 * @param field
	 *        The name of the field to update.
	 * @param value
	 *        The new value of the field.
	 */
	void set(String field, Object value);

	/**
	 * Writes this instance to the given output.
	 * 
	 * @param out
	 *        The {@link JsonWriter} to write this instance to.
	 */
	void writeTo(JsonWriter out) throws IOException;

}
