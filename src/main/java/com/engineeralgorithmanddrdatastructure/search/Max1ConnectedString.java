package com.engineeralgorithmanddrdatastructure.search;

import java.util.ArrayList;
import java.util.List;

public class Max1ConnectedString {
	public static List<Integer> executeFindMaxQueries(char[] onesAndZeros, String[] queries) {
		int[] memo = new int[onesAndZeros.length];
		int max = initializeSubArraysAndMax(onesAndZeros, memo);
		List<Integer> result = new ArrayList<>();
		for (int q = 0; q < queries.length; q++) {
			String[] chunks = queries[q].split(" ");
			int queryType = Integer.parseInt(chunks[0]);
			switch (queryType) {
			case 1:
				result.add(max);
				break;
			case 2:
				int changeIndex = Integer.parseInt(chunks[1]);
				max = updateMemo(max, onesAndZeros, memo, changeIndex - 1);
				break;
			}

		}
		return result;
	}

	private static int updateMemo(int currentMax, char[] onesAndZeros, int[] memo, int changeIndex) {
		if (onesAndZeros[changeIndex] == '1') {
			return currentMax;
		}
		onesAndZeros[changeIndex] = '1';
		memo[changeIndex] = 1;
		int positive = changeIndex + 1;
		boolean positiveChanged = false;
		while (positive < onesAndZeros.length) {
			if (memo[positive] == 0) {
				break;
			}
			positiveChanged = true;
			memo[positive] += 1;
			positive++;
		}
		boolean negativeChanged = false;
		int negetive = changeIndex - 1;
		while (negetive >= 0) {
			if (memo[negetive] == 0) {
				break;
			}
			memo[negetive] += 1;
			negativeChanged = true;
			negetive--;
		}
		if (negativeChanged && positiveChanged) {
			memo[changeIndex] = memo[changeIndex - 1] + memo[changeIndex + 1] - 1;
			int negetive1 = changeIndex - 1;
			while (negetive1 >= 0) {
				if (memo[negetive1] == 0) {
					break;
				}
				memo[negetive1] = memo[changeIndex];
				negetive1--;
			}
			int positive1 = changeIndex + 1;
			while (positive1 < onesAndZeros.length) {
				if (memo[positive1] == 0) {
					break;
				}
				memo[positive1] = memo[changeIndex];
				positive1++;
			}

		} else if (negativeChanged) {
			memo[changeIndex] = memo[changeIndex - 1];
		} else if (positiveChanged) {
			memo[changeIndex] = memo[changeIndex + 1];
		}
		if (memo[changeIndex] > currentMax) {
			return memo[changeIndex];
		} else {
			return currentMax;
		}

	}

	private static int initializeSubArraysAndMax(char[] onesAndZeros, int[] memo) {
		int startIndex = 0;
		int max = 0;
		while (startIndex < onesAndZeros.length) {
			if (onesAndZeros[startIndex] == '1') {
				int count = 1;
				int nextIndex = startIndex + 1;
				while (nextIndex < onesAndZeros.length && onesAndZeros[nextIndex] == '1') {
					count++;
					nextIndex++;
				}
				for (int index = startIndex; index < nextIndex; index++) {
					memo[index] = count;
				}
				max = Math.max(count, max);
				startIndex = nextIndex;
			} else {
				startIndex++;
			}
		}
		return max;
	}

}
