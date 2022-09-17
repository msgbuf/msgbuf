/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.data;

import java.io.IOException;

import de.haumacher.msgbuf.json.JsonReader;
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

	/**
	 * Writes a JSON object containing keys for all fields of this object.
	 * 
	 * <p>
	 * In contrast to {@link #writeTo(JsonWriter)}, the resulting object contains no type information. Therefore, this
	 * method must only be called directly, if the reader knows the type of the object to read from the context. For
	 * reading the data, a per-type generated <code>read[type-name]()</code> method must be called.
	 * </p>
	 *
	 * @param out
	 *        The writer to write to.
	 */
	void writeContent(JsonWriter out) throws IOException;

	/**
	 * Reads a JSON object containing keys for all fields of this object.
	 * 
	 * <p>
	 * This method does not consider type information contained in the stream.
	 * </p>
	 * 
	 * @param in
	 *        The writer to write to.
	 */
	void readContent(JsonReader in) throws IOException;

}
