package com.engineeralgorithmanddrdatastructure.array;

/**
 * 
 * @author ankit.sorathiya
 * 
 *         Divide array into K non empty segment, find max of each segment, find
 *         minimum of them, If it's less than Q return Q else return -1
 */
public class KSegment {
	public static int findSmallestInKSegment(int[] data, int K, int Q) {
		if (K <= 0 || data == null || data.length > K) {
			return -1;
		}
		int min = findMin(data);
		if (min < Q) {
			return min;
		}
		return -1;
	}

	private static int findMin(int[] data) {
		int min = Integer.MAX_VALUE;
		for (int index = 0; index < data.length; index++) {
			if (min > data[index]) {
				data[index] = min;
			}
		}
		return min;
	}
}
