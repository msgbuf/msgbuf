/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * {@link List} implementing a repeated property of a data object that has a reverse end.
 * 
 * <p>
 * The reverse end must be handled in concrete subclasses by overriding {@link #beforeAdd(int, Object)} and
 * {@link #afterRemove(int, Object)}.
 * </p>
 */
public abstract class ReferenceList<T> extends ArrayList<T> {

	@Override
	public void add(int index, T element) {
		beforeAdd(index, element);
		super.add(index, element);
		afterChanged();
	}

	@Override
	public boolean add(T element) {
		beforeAdd(size(), element);
		boolean changed = super.add(element);
		if (changed) {
			afterChanged();
		}
		return changed;
	}

	@Override
	public boolean addAll(Collection<? extends T> collection) {
		beforeAddAll(size(), collection);
		boolean changed = super.addAll(collection);
		if (changed) {
			afterChanged();
		}
		return changed;
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> collection) {
		beforeAddAll(index, collection);
		boolean changed = super.addAll(index, collection);
		if (changed) {
			afterChanged();
		}
		return changed;
	}

	private void beforeAddAll(int index, Collection<? extends T> collection) {
		for (T element : collection) {
			beforeAdd(index++, element);
		}
	}

	protected abstract void beforeAdd(int index, T element);

	@Override
	public T remove(int index) {
		T removed = internalRemove(index);
		afterChanged();
		return removed;
	}

	private T internalRemove(int index) {
		T removed = super.remove(index);
		afterRemove(index, removed);
		return removed;
	}

	@Override
	public boolean remove(Object element) {
		int index = super.indexOf(element);
		boolean success = index >= 0;
		if (success) {
			internalRemove(index);
			afterChanged();
		}
		return success;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return doRemoveAll(c, true);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return doRemoveAll(c, false);
	}

	@Override
	public void clear() {
		int size = size();
		if (size == 0) {
			return;
		}
		for (int index = size - 1; index >= 0; index--) {
			internalRemove(index);
		}
		afterChanged();
	}

	/**
	 * Deletes elements in this collection specified by the given collection.
	 * 
	 * @param removePresent
	 *        Whether to remove present elements (or such that are absent in the given collection).
	 */
	private boolean doRemoveAll(Collection<?> c, boolean removePresent) {
		boolean changed = false;
		Collection<?> test = c instanceof Set<?> || c.size() < 10 ? c : new HashSet<>(c);
		for (int index = size() - 1; index >= 0; index--) {
			T element = get(index);
			if (test.contains(element) == removePresent) {
				internalRemove(index);
				changed = true;
			}
		}
		if (changed) {
			afterChanged();
		}
		return changed;
	}

	protected abstract void afterRemove(int index, T element);

	@Override
	public T set(int index, T element) {
		beforeAdd(index, element);
		T oldValue = super.set(index, element);
		afterRemove(index + 1, oldValue);
		afterChanged();
		return oldValue;
	}

	protected void afterChanged() {
		// empty for compatibility.
	}
}
