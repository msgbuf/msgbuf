/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * {@link List} implementing a repeated property of a data object that has a reverse end.
 * 
 * <p>
 * The reverse end must be handled in concrete subclasses by overriding {@link #onAdd(Object)} and
 * {@link #onRemove(Object)}.
 * </p>
 */
public abstract class ReferenceList<T> extends ArrayList<T> {

	@Override
	public void add(int index, T element) {
		onAdd(element);
		super.add(index, element);
	}

	@Override
	public boolean add(T element) {
		onAdd(element);
		return super.add(element);
	}

	@Override
	public boolean addAll(Collection<? extends T> collection) {
		onAddAll(collection);
		return super.addAll(collection);
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> collection) {
		onAddAll(collection);
		return super.addAll(index, collection);
	}

	private void onAddAll(Collection<? extends T> collection) {
		for (T element : collection) {
			onAdd(element);
		}
	}

	protected abstract void onAdd(T element);

	@Override
	public T remove(int index) {
		T removed = super.remove(index);
		onRemove(removed);
		return removed;
	}

	@Override
	public boolean remove(Object element) {
		boolean success = super.remove(element);
		if (success) {
			@SuppressWarnings("unchecked")
			final T removed = (T) element;
			onRemove(removed);
		}
		return success;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return onRemoveAll(c, true);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return onRemoveAll(c, false);
	}

	@Override
	public void clear() {
		Object[] buffer = toArray();

		super.clear();

		for (Object element : buffer) {
			@SuppressWarnings("unchecked")
			final T removed = (T) element;
			onRemove(removed);
		}
	}

	/**
	 * Deletes elements in this collection specified by the given collection.
	 * 
	 * @param removePresent
	 *        Whether to remove present elements (or such that are absent in the given collection).
	 */
	private boolean onRemoveAll(Collection<?> c, boolean removePresent) {
		boolean changed = false;
		for (int index = 0; index < size();) {
			T element = get(index);
			if (c.contains(element) == removePresent) {
				remove(index);
				changed = true;
			} else {
				index++;
			}
		}
		return changed;
	}

	protected abstract void onRemove(T element);

}
