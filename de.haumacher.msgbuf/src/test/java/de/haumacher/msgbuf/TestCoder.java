/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf;

import java.io.IOException;

import de.haumacher.msgbuf.coder.Coder;
import de.haumacher.msgbuf.io.StringR;
import junit.framework.TestCase;

/**
 * Test case for {@link Coder}.
 */
public class TestCoder extends TestCase {
	
	public void testInt() throws IOException {
		assertEncodeInt(0);
		assertEncodeInt(1);
		assertEncodeInt(15);
		assertEncodeInt(20);
		assertEncodeInt(31);
		assertEncodeInt(300);
		assertEncodeInt(511);
		assertEncodeInt(1023);
		assertEncodeInt(4000);
		assertEncodeInt(50000);
		assertEncodeInt(600000);
		assertEncodeInt(Integer.MAX_VALUE);
		assertEncodeInt(Integer.MIN_VALUE);
	}
	
	private void assertEncodeInt(int n) throws IOException {
		assertDirectEncodeInt(n);
		assertDirectEncodeInt(-n);
		assertDirectEncodeUInt(n);
		assertDirectEncodeUInt(-n);
	}
	
	private void assertDirectEncodeInt(int n) throws IOException {
		String encoded = encodeInt(n);
		int decoded = decodeInt(encoded);
		assertEquals(n, decoded);
	}

	private void assertDirectEncodeUInt(int n) throws IOException {
		String encoded = encodeUInt(n);
		int decoded = decodeUInt(encoded);
		assertEquals(n, decoded);
	}
	
	private static int decodeInt(String encode) throws IOException {
		return Coder.readInt(new StringR(encode));
	}

	private static String encodeInt(int n) throws IOException {
		StringBuilder buffer = new StringBuilder();
		Coder.appendInt(buffer, n);
		return buffer.toString(); 
	}

	private static int decodeUInt(String encode) throws IOException {
		return Coder.readUInt(new StringR(encode));
	}
	
	private static String encodeUInt(int n) throws IOException {
		StringBuilder buffer = new StringBuilder();
		Coder.appendUInt(buffer, n);
		return buffer.toString(); 
	}

	public void testLong() throws IOException {
		assertEncodeLong(0);
		assertEncodeLong(1);
		assertEncodeLong(15);
		assertEncodeLong(20);
		assertEncodeLong(300);
		assertEncodeLong(511);
		assertEncodeLong(4000);
		assertEncodeLong(50000);
		assertEncodeLong(600000);
		assertEncodeLong(Long.MAX_VALUE);
		assertEncodeLong(Long.MIN_VALUE);
	}

	private void assertEncodeLong(long n) throws IOException {
		assertDirectEncodeLong(n);
		assertDirectEncodeLong(-n);
	}
	
	private void assertDirectEncodeLong(long n) throws IOException {
		String encoded = encodeLong(n);
		long decoded = decodeLong(encoded);
		assertEquals(n, decoded);
	}

	private static String encodeLong(long n) throws IOException {
		StringBuilder buffer = new StringBuilder();
		Coder.appendLong(buffer, n);
		return buffer.toString(); 
	}
	
	private long decodeLong(String encoded) throws IOException {
		return Coder.readLong(new StringR(encoded));
	}
	
	public void testString() throws IOException {
		assertEncodeString("");
		assertEncodeString("Hello world.");
	}

	private void assertEncodeString(String s) throws IOException {
		String encoded = encodeString(s);
		String decoded = decodeString(encoded);
		assertEquals(s, decoded);
	}

	private static String encodeString(String s) throws IOException {
		StringBuilder buffer = new StringBuilder();
		Coder.appendString(buffer, s);
		return buffer.toString(); 
	}
	
	private String decodeString(String encoded) throws IOException {
		return Coder.readString(new StringR(encoded));
	}
	
	public void testFloat() throws IOException {
		assertEncodeFloat(0.0f);
		assertEncodeFloat(1.0f);
		assertEncodeFloat(-1.0f);
		assertEncodeFloat(1E10f);
	}
	
	private void assertEncodeFloat(float s) throws IOException {
		String encoded = encodeFloat(s);
		float decoded = decodeFloat(encoded);
		assertEquals(s, decoded);
	}
	
	private static String encodeFloat(float s) throws IOException {
		StringBuilder buffer = new StringBuilder();
		Coder.appendFloat(buffer, s);
		return buffer.toString(); 
	}
	
	private float decodeFloat(String encoded) throws IOException {
		return Coder.readFloat(new StringR(encoded));
	}
	

}
