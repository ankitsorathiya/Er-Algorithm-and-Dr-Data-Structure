package com.engineeralgorithmanddrdatastructure.dp;

/**
 * 
 * @author ankit.sorathiya
 *
 */
public class MagicalStringProblem {
	private static char[][] input = new char[5][];
	private static int mod = 0;
	static {
		mod = ((int) Math.pow(10, 9)) + 7;
		input[0] = new char[] { 'e' };
		input[1] = new char[] { 'a', 'i' };
		input[2] = new char[] { 'a', 'e', 'o', 'u' };
		input[3] = new char[] { 'i', 'u' };
		input[4] = new char[] { 'a' };
	}

	private static int getIndex(char c) {
		if (c == 'a') {
			return 0;
		} else if (c == 'e') {
			return 1;
		} else if (c == 'i') {
			return 2;
		} else if (c == 'o') {
			return 3;
		} else if (c == 'u') {
			return 4;
		} else {
			return -1;
		}
	}

	public static int countMagicalStringOfLength(int n) {
		if (n <= 0) {
			return n;
		}
		int[][] memo = new int[n + 1][input.length];
		for (int index = 0; index < input.length; index++) {
			findMagicalString(index, index, n, 0, memo);
		}
		int count = 0;
		for (int index = 0; index < input.length; index++) {
			count = (memo[n][index] + count) % mod;
		}
		return count;
	}

	private static void findMagicalString(int rootIndex, int index, int expectedSize, int currentSize, int[][] memo) {
		int memoedSize = expectedSize - currentSize;
		currentSize++;
		memo[currentSize][rootIndex] = (memo[currentSize][rootIndex] + 1) % mod;
		if (currentSize == expectedSize) {
			return;
		}
		if (memo[memoedSize][index] > 0) {
			memo[expectedSize][rootIndex] = (memo[expectedSize][rootIndex] + memo[memoedSize][index]) % mod;
			return;
		}

		for (int childIndex = 0; childIndex < input[index].length; childIndex++) {
			int followByIndex = getIndex(input[index][childIndex]);
			findMagicalString(rootIndex, followByIndex, expectedSize, currentSize, memo);
		}
	}

}
