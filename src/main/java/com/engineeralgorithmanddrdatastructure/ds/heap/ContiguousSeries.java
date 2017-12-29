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

}
