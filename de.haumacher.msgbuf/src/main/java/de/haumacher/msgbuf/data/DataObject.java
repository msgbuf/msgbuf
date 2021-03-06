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
	 * Writes this instance to the given output.
	 * 
	 * @param out
	 *        The {@link JsonWriter} to write this instance to.
	 * 
	 * @throws IOException
	 *         if writing fails.
	 */
	void writeTo(JsonWriter out) throws IOException;

}
