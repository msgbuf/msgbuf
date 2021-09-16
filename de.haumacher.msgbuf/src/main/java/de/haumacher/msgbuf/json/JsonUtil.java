/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.json;

import java.io.IOException;

/**
 * Utilities for reading and writing JSON.
 *
 * @author <a href="mailto:haui@haumacher.de">Bernhard Haumacher</a>
 */
public class JsonUtil {
	
	/**
	 * Reads a string or a <code>null</code> value from the given reader.
	 */
	public static String nextStringOptional(JsonReader in) throws IOException {
		if (in.peek() == JsonToken.NULL) {
			in.nextNull();
			return null;
		}
		
		return in.nextString();
	}

	/**
	 * Reads a byte array or a <code>null</code> value from the given reader.
	 */
	public static byte[] nextBinaryOptional(JsonReader in) throws IOException {
		if (in.peek() == JsonToken.NULL) {
			in.nextNull();
			return null;
		}
		
		return Base64Utils.fromBase64(in.nextString());
	}
	
	/**
	 * Writes the given byte array as Base64 encoded string.
	 */
	public static void writeBinaryOptional(JsonWriter out, byte[] value) throws IOException {
		if (value == null) {
			out.nullValue();
		} else {
			out.value(Base64Utils.toBase64(value));
		}
	}
	
}
