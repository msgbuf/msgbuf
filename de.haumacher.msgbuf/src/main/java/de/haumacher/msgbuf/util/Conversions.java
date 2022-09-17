/*
 * Copyright (c) 2022 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.util;

import java.util.List;

/**
 * Utilities for value conversions.
 */
public class Conversions {

	/**
	 * Checked conversion to a typed list.
	 *
	 * @param <T>
	 *        The element type of the list.
	 * @param type
	 *        The dynamic element type of the list.
	 * @param value
	 *        The generic value.
	 * @return The typed list value.
	 */
	public static <T> List<? extends T> asList(Class<T> type, Object value) {
		@SuppressWarnings("unchecked")
		List<? extends T> result = (List<? extends T>) value;
		for (T element : result) {
			if (element != null && !type.isInstance(element)) {
				throw new ClassCastException("Not an instance of '" + type + "': " + element);
			}
		}
		return result;
	}

}
