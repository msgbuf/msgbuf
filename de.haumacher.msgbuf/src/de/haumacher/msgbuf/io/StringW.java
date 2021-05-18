/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.io;

import java.io.IOException;

/**
 * {@link Writer} that constructs an in-memory {@link String}.
 */
public class StringW implements Writer {
	
	private final StringBuilder _buffer = new StringBuilder();

	@Override
	public void write(char ch) {
		_buffer.append(ch);
	}

	@Override
	public void write(String str) {
		_buffer.append(str);
	}

	@Override
	public void write(String str, int start, int length) throws IOException {
		_buffer.append(str, start, start + length);
	}

	@Override
	public void flush() {
		// Ignore.
	}

	@Override
	public void close() {
		// Ignore.
	}
	
	@Override
	public String toString() {
		return _buffer.toString();
	}

}
