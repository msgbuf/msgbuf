/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.coder;

import java.io.EOFException;
import java.io.IOException;

import de.haumacher.msgbuf.io.Reader;

/**
 * Run-length encoding and decoding of Java primitive types into a stream of characters.
 */
public class Coder {

	private static final char[] BASE_64_URL = { 'A', 'B', 'C', 'D', 'E', 'F',
			'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
			'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
			'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
			't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', '-', '_' };
	
	private static final int[] DIGIT = new int[256];
	
	static {
		for (int n = 0, cnt = BASE_64_URL.length; n < cnt; n++) {
			DIGIT[BASE_64_URL[n]] = n;
		}
	}

	private static final int MASK_4 = 0xFFFFFFFF >>> (32 - 4);

	private static final int MASK_5 = 0xFFFFFFFF >>> (32 - 5);

	private static final int BIT_1 = 0x00000001;

	private static final int BIT_5 = BIT_1 << 4;

	private static final int BIT_6 = BIT_1 << 5;

	public static void appendInt(Appendable out, int num) throws IOException {
		boolean negative = num < 0;
		if (negative) {
			num = -num;
		}

		{
			int digit = num & MASK_4;
			num = num >>> 4;

			if (negative) {
				digit |= BIT_5;
			}
			if (num == 0) {
				out.append(BASE_64_URL[digit | BIT_6]);
				return;
			}
			out.append(BASE_64_URL[digit]);
		}

		appendUInt(out, num);
	}
	
	public static void appendUInt(Appendable out, int num) throws IOException {
		while (true) {
			int digit = num & MASK_5;
			num = num >>> 5;
			if (num == 0) {
				out.append(BASE_64_URL[digit | BIT_6]);
				return;
			}
			out.append(BASE_64_URL[digit]);
		}
	}
	
	public static int readInt(Reader in) throws IOException {
		int digit = DIGIT[in.read()];
		boolean negative = (digit & BIT_5) != 0;
		
		int result = digit & MASK_4;
		
		if ((digit & BIT_6) == 0) {
			result = readIntBits(in, 4, result);
		}
		
		return negative ? -result : result;
	}

	public static int readUInt(Reader in) throws IOException {
		return readIntBits(in, 0, 0);
	}

	private static int readIntBits(Reader in, int offset, int result)
			throws IOException {
		while (true) {
			int digit = DIGIT[in.read()];
			result |= (digit & MASK_5) << offset;
			
			if ((digit & BIT_6) != 0) {
				break;
			}
			offset += 5;
		}
		return result;
	}
	
	public static void appendLong(Appendable out, long num) throws IOException {
		boolean negative = num < 0;
		if (negative) {
			num = -num;
		}

		{
			int digit = (int) (num & MASK_4);
			num = num >>> 4;

			if (negative) {
				digit |= BIT_5;
			}
			if (num == 0) {
				out.append(BASE_64_URL[digit | BIT_6]);
				return;
			}
			out.append(BASE_64_URL[digit]);
		}

		while (true) {
			int digit = (int) (num & MASK_5);
			num = num >>> 5;
			if (num == 0) {
				out.append(BASE_64_URL[digit | BIT_6]);
				return;
			}
			out.append(BASE_64_URL[digit]);
		}
	}
	
	public static long readLong(Reader in) throws IOException {
		long digit = DIGIT[in.read()];
		boolean negative = (digit & BIT_5) != 0;
		
		long result = digit & MASK_4;
		
		if ((digit & BIT_6) == 0) {
			int offset = 4;
			
			while (true) {
				digit = DIGIT[in.read()];
				result |= (digit & MASK_5) << offset;
				
				if ((digit & BIT_6) != 0) {
					break;
				}
				offset += 5;
			}
		}
		
		return negative ? -result : result;
	}

	public static void appendString(Appendable out, String s) throws IOException {
		appendUInt(out, s.length());
		out.append(s);
	}

	public static String readString(Reader in) throws IOException {
		int length = readUInt(in);
		return readString(in, length);
	}
	
	private static String readString(Reader in, int length) throws IOException {
		char[] buffer = new char[length];
		int pos = 0;
		while (pos < length) {
			int direct = in.read(buffer, pos, length - pos);
			if (direct < 0) {
				throw new EOFException("Missing input");
			}
			pos += direct;
		}
		return new String(buffer);
	}

	public static void appendFloat(Appendable out, float num) throws IOException {
		appendString(out, Float.toString(num));
	}
	
	public static float readFloat(Reader in) throws IOException {
		return Float.parseFloat(readString(in));
	}
	
	public static void appendDouble(Appendable out, double num) throws IOException {
		appendString(out, Double.toString(num));
	}
	
	public static double readDouble(Reader in) throws IOException {
		return Double.parseDouble(readString(in));
	}
	
}
