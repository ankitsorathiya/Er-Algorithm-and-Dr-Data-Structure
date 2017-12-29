package com.engineeralgorithmanddrdatastructure.ds.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class ContiguousSeries {
	public static boolean isContigueousSerise(int[] data) {
		if (data == null || data.length <= 1) {
			return true;
		}
		Queue<Integer> minHeap = new PriorityQueue<Integer>();
		for (int number : data) {
			minHeap.add(number);
		}
		int previous = minHeap.poll();
		while (!minHeap.isEmpty()) {
			int current = minHeap.poll();
			if (current - previous > 1) {
				return false;
			}
			previous = current;
		}
		return true;
	}

	public static boolean isContigueousSerise_efficient(int[] data) {
		if (data == null || data.length <= 1) {
			return true;
		}
		int max = data[0];
		int min = data[0];
		for (int index = 1; index < data.length; index++) {
			if (data[index] > max) {
				max = data[index];
			}
			if (data[index] < min) {
				min = data[index];
			}
		}
		boolean[] memo = new boolean[max - min + 1];
		for (int noIndex = 0; noIndex < data.length; noIndex++) {
			memo[data[noIndex] - min] = true;
		}
		for (int memoIndex = 0; memoIndex < memo.length; memoIndex++) {
			if (!memo[memoIndex]) {
				return false;
			}
		}
		return true;
	}

}
