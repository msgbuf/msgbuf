/*
 * Copyright (c) 2021 Bernhard Haumacher. All Rights Reserved.
 */
package de.haumacher.msgbuf.server.io;

import java.io.IOException;

import de.haumacher.msgbuf.io.Writer;

/**
 * Adapter to use a {@link java.io.Writer} as {@link Writer}.
 *
 * @author <a href="mailto:haui@haumacher.de">Bernhard Haumacher</a>
 */
public final class WriterAdapter implements Writer {

	private final java.io.Writer _out;

	/** 
	 * Creates a {@link WriterAdapter}.
	 */
	public WriterAdapter(java.io.Writer out) {
		_out = out;
	}

	@Override
	public void write(char ch) throws IOException {
		_out.write(ch);
	}

	@Override
	public void write(String str, int start, int length) throws IOException {
		_out.write(str, start, length);
	}

	@Override
	public void flush() throws IOException {
		_out.flush();
	}

	@Override
	public void close() throws IOException {
		_out.close();
	}

}
