/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.binary;

import java.io.IOException;
import java.io.InputStream;

/**
 * Input interface for reading binary messages into data objects.
 * 
 * <p>
 * A message constructed by a {@link DataWriter} may only contain object at top-level. Therefore the first call to an
 * instance of {@link DataReader} must be {@link #beginObject()}.
 * </p>
 * 
 * @see DataWriter
 */
public interface DataReader {

	/**
	 * Starts reading an object.
	 * 
	 * <p>
	 * After this call, an alternating sequence of calls to {@link #nextName()} followed by a value retrieval method
	 * such as {@link #nextInt()},... {@link #nextString()} followed by a final call to {@link #endObject()} is
	 * expected.
	 * </p>
	 * 
	 * @throws IOException
	 *         If reading fails.
	 */
	void beginObject() throws IOException;

	/**
	 * Finishes reading the object started with the last call to {@link #beginObject()}.
	 * 
	 * @throws IOException
	 *         If reading fails.
	 */
	void endObject() throws IOException;

	/**
	 * When reading an {@link #beginObject() object} or {@link #beginArray() array}, whether there are more fields or
	 * array elements left to read.
	 * 
	 * @return The retrieved value.
	 * @throws IOException
	 *         If reading fails.
	 */
	boolean hasNext() throws IOException;

	/**
	 * When {@link #beginObject() reading an object}, retrieves the next field identifier.
	 * 
	 * <p>
	 * Note: {@link #hasNext()} must return <code>true</code> to be able to read the next field identifier.
	 * </p>
	 * 
	 * @return The retrieved value.
	 * @throws IOException
	 *         If reading fails.
	 */
	int nextName() throws IOException;

	/**
	 * Reads a boolean value.
	 * 
	 * @return The retrieved value.
	 * @throws IOException
	 *         If reading fails.
	 */
	default boolean nextBoolean() throws IOException {
		return nextInt() == 0 ? false : true;
	}

	/**
	 * Reads an (unsigned) integer value.
	 * 
	 * @return The retrieved value.
	 * @throws IOException
	 *         If reading fails.
	 */
	int nextInt() throws IOException;

	/**
	 * Reads a signed integer value.
	 * 
	 * @return The retrieved value.
	 * @throws IOException
	 *         If reading fails.
	 */
	int nextIntSigned() throws IOException;

	/**
	 * Reads a full 32 bit integer value.
	 * 
	 * @return The retrieved value.
	 * @throws IOException
	 *         If reading fails.
	 */
	int nextIntFixed() throws IOException;

	/**
	 * Reads an (unsigned) long value.
	 * 
	 * @return The retrieved value.
	 * @throws IOException
	 *         If reading fails.
	 */
	long nextLong() throws IOException;

	/**
	 * Reads a signed long value.
	 * 
	 * @return The retrieved value.
	 * @throws IOException
	 *         If reading fails.
	 */
	long nextLongSigned() throws IOException;

	/**
	 * Reads a full 64 bit long value.
	 * 
	 * @return The retrieved value.
	 * @throws IOException
	 *         If reading fails.
	 */
	long nextLongFixed() throws IOException;

	/**
	 * Reads a 32 bit float value.
	 * 
	 * @return The retrieved value.
	 * @throws IOException
	 *         If reading fails.
	 */
	float nextFloat() throws IOException;

	/**
	 * Reads a 64 bit double value.
	 * 
	 * @return The retrieved value.
	 * @throws IOException
	 *         If reading fails.
	 */
	double nextDouble() throws IOException;

	/**
	 * Reads an utf-8 {@link String} value.
	 * 
	 * @return The retrieved value.
	 * @throws IOException
	 *         If reading fails.
	 */
	String nextString() throws IOException;

	/**
	 * Reads a binary string value.
	 * 
	 * <p>
	 * The value might have been produced by {@link DataWriter#value(byte[])}, or
	 * {@link DataWriter#valueBinaryStream()}. Best efficiency is achieved, if a value produced with
	 * {@link DataWriter#valueBinaryStream()} is read by {@link #nextBinaryStream()}.
	 * </p>
	 * 
	 * @return The retrieved value.
	 * @throws IOException
	 *         If reading fails.
	 */
	byte[] nextBinary() throws IOException;

	/**
	 * Reads a binary stream value.
	 * 
	 * <p>
	 * The value might have been produced by {@link DataWriter#value(byte[])}, or
	 * {@link DataWriter#valueBinaryStream()}. Best efficiency is achieved, if a value produced with
	 * {@link DataWriter#valueBinaryStream()} is read by {@link #nextBinaryStream()}.
	 * </p>
	 * 
	 * @return The retrieved value as stream.
	 * @throws IOException
	 *         If reading fails.
	 */
	InputStream nextBinaryStream() throws IOException;

	/**
	 * Starts reading an array.
	 * 
	 * @return The number of array elements to read.
	 * 
	 * @throws IOException
	 *         If reading fails.
	 */
	int beginArray() throws IOException;

	/**
	 * Finishes reading the array started with {@link #beginArray()}.
	 * 
	 * @throws IOException
	 *         If reading fails.
	 */
	void endArray() throws IOException;

	/**
	 * Skips the current value to read.
	 * 
	 * @throws IOException
	 *         If reading fails.
	 */
	void skipValue() throws IOException;

}
