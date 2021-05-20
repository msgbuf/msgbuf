/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.coder;

import java.io.IOException;

/**
 * TODO
 */
public interface In {
	
	int readInt() throws IOException;
	int readUInt() throws IOException;
	long readLong() throws IOException;
	float readFloat() throws IOException;
	double readDouble() throws IOException;
	String readString() throws IOException;
	byte[] readBytes() throws IOException;

}
