/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.coder;

import java.io.IOException;

/**
 * TODO
 */
public interface Out {
	
	void writeInt(int value) throws IOException;
	void writeUInt(int value) throws IOException;
	void writeLong(long value) throws IOException;
	void writeFloat(float value) throws IOException;
	void writeDouble(double value) throws IOException;
	void writeString(String value) throws IOException;
	void writeBytes(byte[] value) throws IOException;

}
