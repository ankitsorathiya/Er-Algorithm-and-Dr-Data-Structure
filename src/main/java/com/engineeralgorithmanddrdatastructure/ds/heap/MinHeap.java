package com.engineeralgorithmanddrdatastructure.ds.heap;

import java.util.Comparator;

public class MinHeap<T> extends Heap<T> {

	public MinHeap(T[] data, Comparator<T> comparator) {
		super(data, comparator);
	}

	@Override
	protected void add(T item) {
		this.ensureCapacity();
		this.data[pointer] = item;
		pointer++;
		hipifyUp();
	}

	@Override
	protected T peek() throws EmptyHeapException {
		if (pointer < data.length) {
			return data[pointer];
		}
		throw new EmptyHeapException("Heap is empty");
	}

	@Override
	protected T poll() throws EmptyHeapException {
		if (pointer == 0) {
			throw new EmptyHeapException("Heap is empty");
		}
		T item = this.data[pointer];
		hipifyUp();
		return item;
	}

	@Override
	protected void hipifyUp() {
		int lastInsertedIndex = this.pointer - 1;
		if (lastInsertedIndex <= 0) {
			return;
		}
		int parentIndex = this.getParentIndex(lastInsertedIndex);
		while (parentIndex >= 0) {
			int result = this.comparator.compare(data[lastInsertedIndex], data[parentIndex]);
			if (result > 0) {
				T temp = data[lastInsertedIndex];
				data[lastInsertedIndex] = data[parentIndex];
				data[parentIndex] = temp;
				lastInsertedIndex = parentIndex;
				parentIndex = this.getParentIndex(parentIndex);
			} else {
				break;
			}
		}
	}

	@Override
	protected void hipifyDown() {

	}

}
