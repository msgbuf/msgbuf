/*
 * SPDX-FileCopyrightText: 2025 (c) Business Operation Systems GmbH <info@top-logic.com>
 * 
 * SPDX-License-Identifier: AGPL-3.0-only OR LicenseRef-BOS-TopLogic-1.0
 */
package test.defaultvalue;

import junit.framework.TestCase;
import test.defaultvalue.data.A;

/**
 * Test for annotated default values.
 */
public class TestDefaultValue extends TestCase {

	public void testDefault() {
		A a = A.create();
		assertEquals(true, a.isState());
		assertEquals("Hello world!", a.getS());
		assertEquals(13, a.getX());
		assertEquals(-42.13, a.getY());
	}
}
