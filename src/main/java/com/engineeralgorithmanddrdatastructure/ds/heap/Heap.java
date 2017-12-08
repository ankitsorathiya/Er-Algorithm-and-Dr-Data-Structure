package com.engineeralgorithmanddrdatastructure.ds.heap;

import java.util.Comparator;

public abstract class Heap<T> {
	protected T[] data;
	protected Comparator<T> comparator;
	protected int pointer = 0;
	protected double increaseBy = 0.25;

	public Heap(T[] data, Comparator<T> comparator) {
		this.data = data;
		this.comparator = comparator;
	}

	protected abstract void add(T item);

	protected abstract T peek() throws EmptyHeapException;

	protected abstract T poll() throws EmptyHeapException;

	protected abstract void hipifyUp();

	protected abstract void hipifyDown();

	protected final int getParentIndex(int index) {
		if (index <= 0) {
			return -1;
		}
		int parentIndex = (index / 2);
		return index % 2 == 0 ? parentIndex - 1 : parentIndex;
	}

	protected final int getLeftChildIndex(int parentIndex) {
		return parentIndex * 2 + 1;
	}

	protected final int getRightChildIndex(int parentIndex) {
		return parentIndex * 2 + 2;

	}

	protected final int compareTo(T first, T second) {
		return comparator.compare(first, second);
	}

	protected final void ensureCapacity() {
		if (pointer == data.length) {
			increaseCapacity();
		}
	}

	private void increaseCapacity() {
		int computedLength = (int) (data.length * increaseBy) + data.length;
		@SuppressWarnings("unchecked")
		T[] newData = (T[]) new Object[computedLength];
		for (int index = 0; index < data.length; index++) {
			newData[index] = this.data[index];
		}
		this.data = newData;
	}
}

class EmptyHeapException extends Exception {
	public EmptyHeapException(String message) {
		super(message);
	}
}
