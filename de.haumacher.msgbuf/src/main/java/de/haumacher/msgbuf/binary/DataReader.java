/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.binary;

import java.io.IOException;
import java.io.InputStream;

/**
 * Output interface for creating binary messages out of data objects.
 * 
 * <p>
 * A message constructed by a {@link DataWriter} may only contain object at
 * top-level. Therefore the first call to an instance of {@link DataReader} must
 * be {@link #beginObject()}.
 * </p>
 * 
 * @see DataWriter
 */
public interface DataReader {

	/**
	 * Starts reading an object.
	 * 
	 * <p>
	 * After this call, an alternating sequence of calls to {@link #nextName()}
	 * followed by a value retrieval method such as {@link #nextInt()},...
	 * {@link #nextString()} followed by a final call to {@link #endObject()} is
	 * expected.
	 * </p>
	 */
	void beginObject() throws IOException;

	/**
	 * Finishes reading the object started with the last call to
	 * {@link #beginObject()}.
	 */
	void endObject() throws IOException;

	/**
	 * When reading an {@link #beginObject() object} or {@link #beginArray()
	 * array}, whether there are more fields or array elements left to read.
	 */
	boolean hasNext() throws IOException;

	/**
	 * When {@link #beginObject() reading an object}, retrieves the next field
	 * identifier.
	 * 
	 * <p>
	 * Note: {@link #hasNext()} must return <code>true</code> to be able to read
	 * the next field identifier.
	 * </p>
	 */
	int nextName() throws IOException;

	/**
	 * Reads a boolean value.
	 */
	default boolean nextBoolean() throws IOException {
		return nextInt() == 0 ? false : true;
	}
	
	/**
	 * Reads an (unsigned) integer value.
	 */
	int nextInt() throws IOException;

	/**
	 * Reads a signed integer value.
	 */
	int nextIntSigned() throws IOException;

	/**
	 * Reads a full 32 bit integer value.
	 */
	int nextIntFixed() throws IOException;

	/**
	 * Reads an (unsigned) long value.
	 */
	long nextLong() throws IOException;

	/**
	 * Reads a signed long value.
	 */
	long nextLongSigned() throws IOException;

	/**
	 * Reads a full 64 bit long value.
	 */
	long nextLongFixed() throws IOException;

	/**
	 * Reads a 32 bit float value.
	 */
	float nextFloat() throws IOException;

	/**
	 * Reads a 64 bit double value.
	 */
	double nextDouble() throws IOException;

	/**
	 * Reads an utf-8 {@link String} value.
	 */
	String nextString() throws IOException;

	/**
	 * Reads a binary string value.
	 * 
	 * <p>
	 * The value might have been produced by {@link DataWriter#value(byte[])},
	 * or {@link DataWriter#valueBinaryStream()}. Best efficiency is achieved, if a
	 * value produced with {@link DataWriter#valueBinaryStream()} is read by
	 * {@link #nextBinaryStream()}.
	 * </p>
	 */
	byte[] nextBinary() throws IOException;
	
	/**
	 * Reads a binary stream value.
	 * 
	 * <p>
	 * The value might have been produced by {@link DataWriter#value(byte[])},
	 * or {@link DataWriter#valueBinaryStream()}. Best efficiency is achieved, if a
	 * value produced with {@link DataWriter#valueBinaryStream()} is read by
	 * {@link #nextBinaryStream()}.
	 * </p>
	 */
	InputStream nextBinaryStream() throws IOException;

	/**
	 * Starts reading an array.
	 * 
	 * @return The number of array elements to read.
	 */
	int beginArray() throws IOException;

	/**
	 * Finishes reading the array started with {@link #beginArray()}.
	 */
	void endArray() throws IOException;

	/**
	 * Skips the current value to read.
	 */
	void skipValue() throws IOException;

}
