/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * {@link Map} implementing a map-valued property of a data object that has a reverse end.
 * 
 * <p>
 * The reverse end must be handled in concrete subclasses by overriding {@link #beforeAdd(Object, Object)} and
 * {@link #afterRemove(Object, Object)}.
 * </p>
 */
public abstract class ReferenceMap<K, V> extends HashMap<K, V> {

	@Override
	public V put(K key, V value) {
		V oldValue = remove(key);
		
		beforeAdd(key, value);
		super.put(key, value);
		return oldValue; 
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> collection) {
		beforeAddAll(collection);
		super.putAll(collection);
	}
	
	private void beforeAddAll(Map<? extends K, ? extends V> collection) {
		for (Entry<? extends K, ? extends V> value : collection.entrySet()) {
			beforeAdd(value.getKey(), value.getValue());
		}
	}

	protected abstract void beforeAdd(K key, V value);

	@Override
	public V remove(Object key) {
		final V removed = super.remove(key);
		if (removed != null) {
			@SuppressWarnings("unchecked")
			K removedKey = (K) key;
			afterRemove(removedKey, removed);
		}
		return removed;
	}

	@Override
	public boolean remove(Object key, Object value) {
		final boolean success = super.remove(key, value);
		if (success) {
			@SuppressWarnings("unchecked")
			K removedKey = (K) key;
			@SuppressWarnings("unchecked")
			V removed = (V) value;
			afterRemove(removedKey, removed);
		}
		return success;
	}
	
	@Override
	public void clear() {
		for (K key : new ArrayList<>(keySet())) {
			remove(key);
		}
	}

	protected abstract void afterRemove(K key, V value);

}
