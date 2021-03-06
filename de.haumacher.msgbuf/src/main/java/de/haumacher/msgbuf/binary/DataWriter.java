/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.binary;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Output interface for creating binary messages out of data objects.
 * 
 * <p>
 * Top-level, only objects must be written. Therefore, the first call to a
 * {@link DataWriter} must be {@link #beginObject()}.
 * </p>
 * 
 * @see #beginObject()
 * @see DataReader
 */
public interface DataWriter {

	/**
	 * Starts writing an object.
	 * 
	 * <p>
	 * A sequence of interleaving calls to {@link #name(int)} and a value
	 * encoding method such as {@link #value(int)} is expected followed by a
	 * final {@link #endObject()} call.
	 * </p>
	 * 
	 * @throws IOException If writing fails.
	 */
	void beginObject() throws IOException;

	/**
	 * Finishes writing the fields of the object started with the last call to
	 * {@link #beginObject()}.
	 * 
	 * @throws IOException If writing fails.
	 */
	void endObject() throws IOException;

	/**
	 * Writes an identifier of a field fo the currently written object.
	 * 
	 * @throws IOException If writing fails.
	 */
	void name(int id) throws IOException;
	
	/**
	 * Writes a <code>boolean</code> value.
	 * 
	 * @throws IOException If writing fails.
	 */
	default void value(boolean value) throws IOException {
		value(value ? 1 : 0);
	}

	/**
	 * Writes an unsigned <code>int</code> value.
	 * 
	 * @throws IOException If writing fails.
	 */
	void value(int value) throws IOException;

	/**
	 * Writes a signed <code>int</code> value.
	 * 
	 * @throws IOException If writing fails.
	 */
	void valueSigned(int value) throws IOException;

	/**
	 * Writes a fixed size 32 bit <code>int</code> value.
	 * 
	 * @throws IOException If writing fails.
	 */
	void valueFixed(int value) throws IOException;

	/**
	 * Writes an unsigned <code>long</code> value.
	 * 
	 * @throws IOException If writing fails.
	 */
	void value(long value) throws IOException;

	/**
	 * Writes a signed <code>long</code> value.
	 * 
	 * @throws IOException If writing fails.
	 */
	void valueSigned(long value) throws IOException;

	/**
	 * Writes a fixed size 64 bit <code>long</code> value.
	 * 
	 * @throws IOException If writing fails.
	 */
	void valueFixed(long value) throws IOException;

	/**
	 * Writes a <code>float</code> value.
	 * 
	 * @throws IOException If writing fails.
	 */
	void value(float value) throws IOException;

	/**
	 * Writes a <code>double</code> value.
	 * 
	 * @throws IOException If writing fails.
	 */
	void value(double value) throws IOException;

	/**
	 * Writes a {@link String} value in <code>utf-8</code> encoding.
	 * 
	 * @throws IOException If writing fails.
	 */
	void value(String value) throws IOException;

	/**
	 * Writes a binary string value.
	 * 
	 * @throws IOException If writing fails.
	 */
	void value(byte[] value) throws IOException;
	
	/**
	 * Starts writing a binary value of arbitrary length in chunked mode.
	 * 
	 * <p>
	 * The binary contents must be written the the resulting
	 * {@link OutputStream}. No other methods of this {@link DataWriter} must be
	 * called before the resulting {@link OutputStream} has been
	 * {@link OutputStream#close() closed}.
	 * </p>
	 * 
	 * @throws IOException If writing fails.
	 */
	OutputStream valueBinaryStream() throws IOException;

	/**
	 * Starts writing an array value with entries of the given type.
	 * 
	 * @param type
	 *        The type of the array elements.
	 * @param lenght
	 *        The number of elements that follow.
	 * 
	 * @throws IOException If writing fails.
	 */
	void beginArray(DataType type, int lenght) throws IOException;

	/**
	 * Stops writing the array started with the last call to
	 * {@link #beginObject()}.
	 * 
	 * @throws IOException If writing fails.
	 */
	void endArray() throws IOException;

}
