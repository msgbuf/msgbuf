/*
 * Copyright (c) 2024 Bernhard Haumacher et al. All Rights Reserved.
 */
package test.operations;

import test.operations.data.Data;

/**
 * Operations mix-in for the {@link Data} class.
 */
public interface DataOperations {

	/**
	 * Access to the data class.
	 */
	Data self();
	
	/**
	 * Increments {@link Data#getX()}
	 */
	default void inc() {
		self().setX(self().getX() + 1);
	}
}
