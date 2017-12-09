package com.engineeralgorithmanddrdatastructure.ds.heap;

import java.util.Comparator;

public class Heap<T> {
	private T[] data;
	private Comparator<T> comparator;
	private int pointer = 0;
	private double increaseBy = 0.25;
	private int fixedSize = 10;

	@SuppressWarnings("unchecked")
	public Heap(Comparator<T> comparator) {
		if (comparator == null) {
			throw new InvalidComparator("Comparactor can not be null");
		}
		this.data = (T[]) new Object[fixedSize];
		this.comparator = comparator;
	}

	public void add(T item) {
		this.ensureCapacity();
		this.data[pointer] = item;
		pointer++;
		heapifyUp();
	}

	public T peek() throws EmptyHeapException {
		if (pointer > 0) {
			return this.data[0];
		}
		throw new EmptyHeapException("Heap is empty");
	}

	public T poll() throws EmptyHeapException {
		if (pointer == 0) {
			throw new EmptyHeapException("Heap is empty");
		}
		T item = this.data[0];
		pointer--;
		this.data[0] = this.data[pointer];
		this.data[pointer] = null;
		heapifyDown();
		return item;
	}

	private void heapifyUp() {
		int lastInsertedIndex = this.pointer - 1;
		if (lastInsertedIndex <= 0) {
			return;
		}
		int parentIndex = this.getParentIndex(lastInsertedIndex);
		while (parentIndex >= 0) {
			int result = this.compare(data[parentIndex], data[lastInsertedIndex]);
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

	private void heapifyDown() {
		int parentIndex = 0;
		while (!isRootInOrder(parentIndex)) {
			int childIndex = this.getReplacementIndex(parentIndex);
			T temp = this.data[childIndex];
			this.data[childIndex] = this.data[parentIndex];
			this.data[parentIndex] = temp;
			parentIndex = childIndex;
		}
	}

	private int getReplacementIndex(int parentIndex) {
		int leftChildIndex = this.getLeftChildIndex(parentIndex);
		int rightChildIndex = this.getRightChildIndex(parentIndex);
		if (this.data[leftChildIndex] != null && this.data[rightChildIndex] != null) {
			int result = this.compare(this.data[leftChildIndex], this.data[rightChildIndex]);
			if (result <= 0) {
				return leftChildIndex;
			} else {
				return rightChildIndex;
			}
		}
		return leftChildIndex;
	}

	private boolean isRootInOrder(int parentIndex) {
		return isRootInOrderWithLeftChild(parentIndex) && isRootInOrderWithRightChild(parentIndex);
	}

	private boolean isRootInOrderWithRightChild(int parentIndex) {
		int rightChildIndex = this.getRightChildIndex(parentIndex);
		if (rightChildIndex >= pointer) {
			return true;
		}

		int rightResult = this.compare(this.data[parentIndex], this.data[rightChildIndex]);
		if (rightResult > 0) {
			return false;
		}
		return true;
	}

	private boolean isRootInOrderWithLeftChild(int parentIndex) {
		int leftChildIndex = this.getLeftChildIndex(parentIndex);
		if (leftChildIndex >= pointer) {
			return true;
		}
		int leftResult = this.compare(this.data[parentIndex], this.data[leftChildIndex]);
		if (leftResult > 0) {
			return false;
		}
		return true;
	}

	private final int getParentIndex(int index) {
		if (index <= 0) {
			return -1;
		}
		int parentIndex = (index / 2);
		return index % 2 == 0 ? parentIndex - 1 : parentIndex;
	}

	private final int getLeftChildIndex(int parentIndex) {
		return parentIndex * 2 + 1;
	}

	private final int getRightChildIndex(int parentIndex) {
		return parentIndex * 2 + 2;

	}

	private final int compare(T first, T second) {
		return comparator.compare(first, second);
	}

	private final void ensureCapacity() {
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

class EmptyHeapException extends UnsupportedOperationException {
	public EmptyHeapException(String message) {
		super(message);
	}
}

class InvalidComparator extends UnsupportedOperationException {
	public InvalidComparator(String message) {
		super(message);
	}

}
