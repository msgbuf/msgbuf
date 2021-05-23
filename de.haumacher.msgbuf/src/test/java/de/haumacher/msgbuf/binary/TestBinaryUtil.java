/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.binary;

import junit.framework.TestCase;

/**
 * Test case for {@link BinaryUtil}.
 */
@SuppressWarnings("javadoc")
public class TestBinaryUtil extends TestCase {

	public void testZigzag() {
		assertEquals(0, BinaryUtil.zigzagEncode(0));
		assertEquals(0, BinaryUtil.zigzagEncode(0L));
		assertEquals(2, BinaryUtil.zigzagEncode(1));
		assertEquals(2, BinaryUtil.zigzagEncode(1L));
		assertEquals(1, BinaryUtil.zigzagEncode(-1));
		assertEquals(1, BinaryUtil.zigzagEncode(-1L));
		assertEquals(10, BinaryUtil.zigzagEncode(5));
		assertEquals(10, BinaryUtil.zigzagEncode(5L));
		
		assertEquals(1234, BinaryUtil.zigzagDecode(BinaryUtil.zigzagEncode(1234)));
		assertEquals(1234, BinaryUtil.zigzagDecode(BinaryUtil.zigzagEncode(1234L)));
		assertEquals(Integer.MAX_VALUE, BinaryUtil.zigzagDecode(BinaryUtil.zigzagEncode(Integer.MAX_VALUE)));
		assertEquals(Integer.MIN_VALUE, BinaryUtil.zigzagDecode(BinaryUtil.zigzagEncode(Integer.MIN_VALUE)));
		assertEquals(Long.MAX_VALUE, BinaryUtil.zigzagDecode(BinaryUtil.zigzagEncode(Long.MAX_VALUE)));
		assertEquals(Long.MIN_VALUE, BinaryUtil.zigzagDecode(BinaryUtil.zigzagEncode(Long.MIN_VALUE)));
	}
}
