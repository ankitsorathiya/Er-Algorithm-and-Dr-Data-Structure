package com.engineeralgorithmanddrdatastructure.dp;

public class SherlockAndCost {
	static int cost(int[] arr) {
		int[][] memo = new int[arr.length][2];
		for (int index = 1; index < memo.length; index++) {
			memo[index][0] = Math.max(memo[index - 1][0], memo[index - 1][1] + Math.abs(arr[index - 1] - 1));
			memo[index][1] = Math.max(memo[index - 1][0] + Math.abs(arr[index] - 1),
					memo[index - 1][1] + Math.abs(arr[index] - arr[index - 1]));
		}
		return Math.max(memo[arr.length - 1][0], memo[arr.length - 1][1]);
	}
}
