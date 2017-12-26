package com.engineeralgorithmanddrdatastructure.kadane;

public class MaxSubArraySum {

	public static int calculateMaxSumSubArray(int[] data) {
		if (data == null || data.length == 0) {
			return 0;
		}
		int currentMax = data[0];
		int sum = data[0];
		int max = data[0];
		for (int index = 1; index < data.length; index++) {
			sum = sum + data[index];
			currentMax = Math.max(Math.max(currentMax, sum), data[index]);
			if (data[index] > sum) {
				sum = data[index];
			}
			if (currentMax > max) {
				max = currentMax;
			}
		}
		return max;
	}

}
