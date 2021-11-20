/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.observer;

import de.haumacher.msgbuf.data.ReflectiveDataObject;

/**
 * {@link ReflectiveDataObject} whose properties can be observed.
 */
public interface Observable extends ReflectiveDataObject {
	
	/**
	 * Attaches the given {@link Listener} to this object.
	 * 
	 * <p>
	 * If the given {@link Listener} is already attached, it is not attached again.
	 * </p>
	 * 
	 * @param l
	 *        The {@link Listener} to attach.
	 * @return This object for call chaining.
	 */
	Observable registerListener(Listener l);

	/**
	 * Removes the given {@link Listener} from this object.
	 * 
	 * @param l
	 *        The {@link Listener} to remove.
	 * @return This object for call chaining.
	 */
	Observable unregisterListener(Listener l);

}
