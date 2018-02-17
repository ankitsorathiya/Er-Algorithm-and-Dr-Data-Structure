package com.engineeralgorithmanddrdatastructure.dp;

public class ChocolateDistribution {
	static int equal(int[] arr) {
		int result = Integer.MAX_VALUE;
		int min = findMin(arr);
		for (int target = min - 4; target <= min; target++) {
			int[] delta = findDelta(arr, target);
			int operation = 0;
			for (int index = 0; index < delta.length; index++) {
				int x = delta[index];
				int ai = x / 5;
				int bi = (x % 5) / 2;
				int ci = ((x % 5) % 2) / 1;
				operation += (ai + bi + ci);
			}
			result = Math.min(operation, result);
		}
		return result;
	}

	private static int[] findDelta(int[] arr, int min) {
		int[] delta = new int[arr.length];
		for (int index = 0; index < arr.length; index++) {
			delta[index] = arr[index] - min;
		}
		return delta;
	}

	private static int findMin(int[] arr) {
		int min = arr[0];
		for (int index = 1; index < arr.length; index++) {
			if (arr[index] < min) {
				min = arr[index];
			}
		}
		return min;
	}

}
