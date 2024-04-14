/*
 * Copyright (c) 2024 Bernhard Haumacher et al. All Rights Reserved.
 */
package test.operations;

import test.operations.data.Data;
import test.operations.data.ExtendedData;

/**
 * Mix-in interface for the extended data class {@link ExtendedData}.
 */
public interface ExtendedOperations extends DataOperations {
	
	@Override
	public ExtendedData self();
	

	/**
	 * Adds the current {@link Data#getX()} value to {@link ExtendedData#getY()}.
	 */
	default void addToY() {
		self().setY(self().getY() + self().getX());
	}
}
