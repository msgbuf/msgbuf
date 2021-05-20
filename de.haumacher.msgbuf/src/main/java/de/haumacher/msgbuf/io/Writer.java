/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.io;

import java.io.IOException;

/**
 * A character stream producer.
 * 
 * <p>
 * For compatibility with GWT, the native Java {@link java.io.Writer}
 * implementation cannot be used.
 * </p>
 */
public interface Writer {

	/**
	 * Writes a single character. The character to be written is contained in
	 * the 16 low-order bits of the given integer value; the 16 high-order bits
	 * are ignored.
	 *
	 * <p>
	 * Subclasses that intend to support efficient single-character output
	 * should override this method.
	 *
	 * @param ch
	 *        int specifying a character to be written
	 *
	 * @throws IOException
	 *         If an I/O error occurs
	 */
	void write(char ch) throws IOException;

	/**
	 * Writes a string.
	 *
	 * @param str
	 *        String to be written
	 *
	 * @throws IOException
	 *         If an I/O error occurs
	 */
	default void write(String str) throws IOException {
		write(str, 0, str.length());
	}

	/**
	 * Writes a portion of a string.
	 *
	 * @param str
	 *        A String
	 *
	 * @param start
	 *        Offset from which to start writing characters
	 *
	 * @param length
	 *        Number of characters to write
	 *
	 * @throws IndexOutOfBoundsException
	 *         If <tt>off</tt> is negative, or <tt>len</tt> is negative, or
	 *         <tt>off+len</tt> is negative or greater than the length of the
	 *         given string
	 *
	 * @throws IOException
	 *         If an I/O error occurs
	 */
	void write(String str, int start, int length) throws IOException;

	/**
	 * Flushes the stream. If the stream has saved any characters from the
	 * various write() methods in a buffer, write them immediately to their
	 * intended destination. Then, if that destination is another character or
	 * byte stream, flush it. Thus one flush() invocation will flush all the
	 * buffers in a chain of Writers and OutputStreams.
	 *
	 * @throws IOException
	 *         If an I/O error occurs
	 */
	void flush() throws IOException;

	/**
	 * Closes the stream, flushing it first. Once the stream has been closed,
	 * further write() or flush() invocations will cause an IOException to be
	 * thrown. Closing a previously closed stream has no effect.
	 *
	 * @throws IOException
	 *         If an I/O error occurs
	 */
	void close() throws IOException;

}
