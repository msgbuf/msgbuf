/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.io;

import java.io.IOException;

import de.haumacher.msgbuf.server.io.ReaderAdapter;

/**
 * A character stream reader.
 * 
 * <p>
 * For compatibility with GWT, the native Java {@link java.io.Reader} implementation
 * cannot be used.
 * </p>
 * 
 * @see ReaderAdapter
 * @see StringR
 */
public interface Reader {

	/**
	 * Reads a single character.
	 *
	 * <p>
	 * Subclasses that intend to support efficient single-character input should
	 * override this method.
	 * </p>
	 *
	 * @return The character read, as an integer in the range 0 to 65535
	 *         (<tt>0x00-0xffff</tt>), or -1 if the end of the stream has been
	 *         reached
	 *
	 * @throws IOException
	 *         If an I/O error occurs
	 */
	public int read() throws IOException;

	/**
	 * Reads characters into a portion of an array.
	 *
	 * @param cbuf
	 *        Destination buffer
	 * @param off
	 *        Offset at which to start storing characters
	 * @param len
	 *        Maximum number of characters to read
	 *
	 * @return The number of characters read, or -1 if the end of the stream has
	 *         been reached
	 *
	 * @throws IOException
	 *         If an I/O error occurs
	 */
	int read(char cbuf[], int off, int len) throws IOException;

	/**
	 * Closes the stream and releases any system resources associated with it.
	 * Once the stream has been closed, further read(), ready(), mark(),
	 * reset(), or skip() invocations will throw an {@link IOException}. Closing
	 * a previously closed stream has no effect.
	 *
	 * @throws IOException
	 *         If an I/O error occurs
	 */
	public void close() throws IOException;

}
