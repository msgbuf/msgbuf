/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.coder;

import java.io.IOException;
import java.util.Base64;

import de.haumacher.msgbuf.io.Reader;

/**
 * TODO
 */
public class CodedIn implements In {

	private Reader _in;
	
	/** 
	 * Creates a {@link CodedIn}.
	 */
	public CodedIn(Reader in) {
		_in = in;
	}

	@Override
	public int readInt() throws IOException {
		return Coder.readInt(_in);
	}

	@Override
	public int readUInt() throws IOException {
		return Coder.readUInt(_in);
	}
	
	@Override
	public long readLong() throws IOException {
		return Coder.readLong(_in);
	}

	@Override
	public float readFloat() throws IOException {
		return Coder.readFloat(_in);
	}

	@Override
	public double readDouble() throws IOException {
		return Coder.readDouble(_in);
	}

	@Override
	public String readString() throws IOException {
		return Coder.readString(_in);
	}

	@Override
	public byte[] readBytes() throws IOException {
		return Base64.getUrlDecoder().decode(Coder.readString(_in));
	}

}
