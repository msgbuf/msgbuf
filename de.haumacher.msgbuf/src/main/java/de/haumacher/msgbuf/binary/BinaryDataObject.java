/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.binary;

import java.io.IOException;

import de.haumacher.msgbuf.data.DataObject;

/**
 * {@link DataObject} that supports creating binary messages.
 * 
 * @see DataWriter
 * @see DataReader
 */
public interface BinaryDataObject {
	
	/**
	 * Writes the content of this {@link DataObject} to the given binary output.
	 * 
	 * @param out
	 *        The writer to write this object to.
	 * 
	 * @throws IOException If writing fails.
	 */
	public void writeTo(DataWriter out) throws IOException;

}
