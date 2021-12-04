/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.observer;

import java.util.ArrayList;

/**
 * A listener observing an {@link Observable} object.
 */
public interface Listener {

	/**
	 * A {@link Listener} ignoring all events.
	 */
	Listener NONE = new Listener() {
		@Override
		public void beforeSet(Observable obj, String property, Object value) {
			// Ignore.
		}
	};

	/**
	 * Informs this {@link Listener} that the value of the given property is to be modified.
	 * 
	 * @param obj
	 *        The {@link Observable} object.
	 * @param property
	 *        The name of the property to be modified.
	 * @param value
	 *        The new value that is being set to the given property.
	 */
	void beforeSet(Observable obj, String property, Object value);
	
	/**
	 * Informs this {@link Listener} that an element will be added to the repeated property with the given name.
	 * 
	 * @param obj
	 *        The {@link Observable} object.
	 * @param property
	 *        The name of the property to be modified.
	 * @param index
	 *        The index where the new element will be added if the property is ordered, <code>-1</code> otherwise.
	 * @param element
	 *        The new element that is being added to the given property.
	 */
	default void beforeAdd(Observable obj, String property, int index, Object element) {
		// Ignore.
	}
	
	/** 
	 * Informs this {@link Listener} that an element was removed from a repeated property with the given name.
	 * 
	 * @param obj
	 *        The {@link Observable} object.
	 * @param property
	 *        The name of the property to be modified.
	 * @param index
	 *        The index where the element was removed if the property is ordered, <code>-1</code> otherwise.
	 * @param element
	 *        The element that was removed from the given property.
	 */
	default void afterRemove(Observable obj, String property, int index, Object element) {
		// Ignore.
	}

	/**
	 * {@link Listener} that multiplexes events to a list of potentially multiple target {@link Listener}s.
	 */
	final class MultiplexListener extends ArrayList<Listener> implements Listener {
		
		/** 
		 * Creates a {@link MultiplexListener}.
		 */
		public MultiplexListener(Listener a, Listener b) {
			super(2);
			add(a);
			add(b);
		}

		@Override
		public void beforeSet(Observable obj, String property, Object value) {
			for (Listener l : current()) {
				l.beforeSet(obj, property, value);
			}
		}
		
		@Override
		public void beforeAdd(Observable obj, String property, int index, Object element) {
			for (Listener l : current()) {
				l.beforeAdd(obj, property, index, element);
			}
		}
		
		@Override
		public void afterRemove(Observable obj, String property, int index, Object element) {
			for (Listener l : current()) {
				l.afterRemove(obj, property, index, element);
			}
		}

		private Listener[] current() {
			return toArray(new Listener[0]);
		}

		public Listener register(Listener l) {
			if (!contains(l)) {
				add(l);
			}
			return this;
		}
		
		public Listener unregister(Listener removed) {
			remove(removed);
			if (isEmpty()) {
				return NONE;
			}
			return this;
		}
	}

	/**
	 * Utility to use a single field of type {@link Listener} as storage for potentially multiple attached
	 * {@link Listener}s.
	 * 
	 * <p>
	 * To be used in the following way: <code>_listener = Listener.register(_listener, newListener);</code>
	 * </p>
	 * 
	 * @param current
	 *        The current value of the the listener field.
	 * @param added
	 *        The new {@link Listener} to add.
	 * @return The new value to store in the listener field.
	 */
	public static Listener register(Listener current, Listener added) {
		if (current == NONE || current == added) {
			return added;
		}
		
		if (current instanceof MultiplexListener) {
			return ((MultiplexListener) current).register(added);
		}
		
		return new MultiplexListener(current, added);
	}

	/** 
	 * Utility to remove a {@link Listener} from a listener list stored in a single field of type {@link Listener}.
	 * 
	 * @param current
	 *        The current value of the the listener field.
	 * @param removed
	 *        The {@link Listener} to remove.
	 * @return The new value to store in the listener field.
	 * 
	 * @see #register(Listener, Listener)
	 */
	public static Listener unregister(Listener current, Listener removed) {
		if (current == removed) {
			return NONE;
		}
		if (current instanceof MultiplexListener) {
			return ((MultiplexListener) current).unregister(removed);
		}
		return current;
	}

}
