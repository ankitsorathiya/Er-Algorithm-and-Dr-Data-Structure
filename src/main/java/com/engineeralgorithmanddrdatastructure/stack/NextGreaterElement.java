package com.engineeralgorithmanddrdatastructure.stack;

import java.util.Stack;

public class NextGreaterElement {
	public static int[] findNextGreaterElements(int[] data) {
		if (data == null || data.length <= 1) {
			return new int[] { -1 };
		}
		NextGreater[] convertedData = constructNextGreater(data);
		return findNextGreaterElements(convertedData);
	}

	private static NextGreater[] constructNextGreater(int[] data) {
		NextGreater[] convertedData = new NextGreater[data.length];
		for (int index = 0; index < data.length; index++) {
			convertedData[index] = new NextGreater(index, data[index]);
		}
		return convertedData;
	}

	private static int[] findNextGreaterElements(NextGreater[] data) {
		int[] nextGreaterElements = new int[data.length];
		Stack<NextGreater> nextGreater = new Stack<>();
		nextGreater.add(data[0]);
		for (int next = 1; next < data.length; next++) {
			while (!nextGreater.isEmpty() && nextGreater.peek().value < data[next].value) {
				nextGreaterElements[nextGreater.pop().index] = data[next].value;
			}
			nextGreater.push(data[next]);
		}
		while (!nextGreater.isEmpty()) {
			nextGreaterElements[nextGreater.pop().index] = -1;
		}
		return nextGreaterElements;
	}
}

class NextGreater {
	public NextGreater(int index, int value) {
		this.index = index;
		this.value = value;
	}

	int index;
	int value;
}
