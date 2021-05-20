/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.coder;

import java.io.IOException;
import java.util.Base64;

/**
 * TODO
 */
public class CodedOut implements Out {
	
	private Appendable _out;

	/** 
	 * Creates a {@link CodedOut}.
	 */
	public CodedOut(Appendable out) {
		_out = out;
	}

	@Override
	public void writeInt(int value) throws IOException {
		Coder.appendInt(_out, value);
	}

	@Override
	public void writeUInt(int value) throws IOException {
		Coder.appendUInt(_out, value);
	}
	
	@Override
	public void writeLong(long value) throws IOException {
		Coder.appendLong(_out, value);
	}

	@Override
	public void writeFloat(float value) throws IOException {
		Coder.appendFloat(_out, value);
	}

	@Override
	public void writeDouble(double value) throws IOException {
		Coder.appendDouble(_out, value);
	}

	@Override
	public void writeString(String value) throws IOException {
		Coder.appendString(_out, value);
	}

	@Override
	public void writeBytes(byte[] value) throws IOException {
		Coder.appendString(_out, Base64.getUrlEncoder().encodeToString(value));
	}

}
