/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.binary;

/**
 * Utilities for binary value encoding.
 */
public class BinaryUtil {

	/**
	 * Zig-zag encodes the given <code>int</code> producing a small positive number for inputs with small absolute
	 * value.
	 * 
	 * @param value
	 *        The value to encode.
	 * @return The zig-zag encoded value.
	 */
	public static int zigzagEncode(int value) {
		return value << 1 ^ value >> 31;
	}

	/**
	 * Zig-zag encodes the given <code>long</code> producing a small positive number for inputs with small absolute
	 * value.
	 * 
	 * @param value
	 *        The value to encode.
	 * @return The zig-zag encoded value.
	 */
	public static long zigzagEncode(long value) {
		return value << 1 ^ value >> 63;
	}

	/**
	 * Decodes the result of {@link #zigzagEncode(int)} to its original signed value.
	 * 
	 * @param value
	 *        The value to decode.
	 * @return The zig-zag decoded value.
	 */
	public static int zigzagDecode(int value) {
		boolean negative = (value & OctetDataReader.BIT_1) != 0;
		int result = value >>> 1;
		if (negative) {
			result = ~result;
		}
		return result;
	}

	/**
	 * Decodes the result of {@link #zigzagEncode(long)} to its original signed value.
	 * 
	 * @param value
	 *        The value to decode.
	 * @return The zig-zag decoded value.
	 */
	public static long zigzagDecode(long value) {
		boolean negative = (value & OctetDataReader.BIT_1) != 0;
		long result = value >>> 1;
		if (negative) {
			result = ~result;
		}
		return result;
	}

}
