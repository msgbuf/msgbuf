/*
 * SPDX-FileCopyrightText: 2025 (c) Business Operation Systems GmbH <info@top-logic.com>
 * 
 * SPDX-License-Identifier: AGPL-3.0-only OR LicenseRef-BOS-TopLogic-1.0
 */
package test.transientprops;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;
import test.transientprops.data.A;
import test.transientprops.data.B;
import test.transientprops.data.C;

/**
 * Test case for transient properties.
 */
public class TestTransientProps extends TestCase {
	
	public void testA() {
		assertEquals(set(A.X_2__PROP), A.create().transientProperties());
		assertEquals(Arrays.asList(A.X_1__PROP, A.X_2__PROP), A.create().properties());
	}

	public void testB() {
		assertEquals(set(A.X_2__PROP, B.Y_2__PROP), B.create().transientProperties());
		assertEquals(Arrays.asList(A.X_1__PROP, A.X_2__PROP, B.Y_1__PROP, B.Y_2__PROP), B.create().properties());
	}
	
	public void testC() {
		assertEquals(set(A.X_2__PROP, B.Y_2__PROP, C.Z_2__PROP), C.create().transientProperties());
		assertEquals(Arrays.asList(A.X_1__PROP, A.X_2__PROP, B.Y_1__PROP, B.Y_2__PROP, C.Z_1__PROP, C.Z_2__PROP), C.create().properties());
	}
	
	private Set<String> set(String ...s) {
		return new HashSet<>(Arrays.asList(s));
	}

}
