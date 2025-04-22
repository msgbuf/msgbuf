/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.io;

import java.io.IOException;

/**
 * {@link Reader} that reads from an in-memory {@link String}.
 */
public class StringR implements Reader {
	
	private final String _in;
	private int _pos;

	/** 
	 * Creates a {@link StringR}.
	 *
	 */
	public StringR(String in) {
		_in = in;
	}

	@Override
	public int read() throws IOException {
		if (_in.length() == _pos) {
			// Finished.
			return -1;
		}
		return _in.charAt(_pos++);
	}
	
	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		if (_in.length() == _pos) {
			// Finished.
			return -1;
		}
		int count = Math.min(len, _in.length() - _pos);
		int end = _pos + count;
		_in.getChars(_pos, end, cbuf, off);
		_pos = end;
		return count;
	}
	
	@Override
	public void close() throws IOException {
		// Ignore.
	}
}
