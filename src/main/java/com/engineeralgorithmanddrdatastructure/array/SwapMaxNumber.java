package com.engineeralgorithmanddrdatastructure.array;

import java.util.ArrayList;
import java.util.List;

public class SwapMaxNumber {
	private static List<Integer> findIndexes(int digit, int[] memo) {
		List<Integer> indexes = new ArrayList<>();
		for (int index = 0; index < memo.length; index++) {
			if (memo[index] == digit) {
				indexes.add(index);
			}
		}
		return indexes;
	}

	public static String findMaxNumber(String number, int swaps) {
		int[] memo = buildMemo(number);
		for (int num = 9; num >= 0; num--) {
			List<Integer> indexes = findIndexes(num, memo);
			for (int index = 0; index < indexes.size(); index++) {
				int rightPointer = indexes.get(index);
				int leftPointer = rightPointer - 1;
				boolean done = false;
				while (rightPointer > 0) {
					if (swaps <= 0) {
						done = true;
						break;
					}
					if (memo[leftPointer] < memo[rightPointer]) {
						int cache = memo[leftPointer];
						memo[leftPointer] = memo[rightPointer];
						memo[rightPointer] = cache;
						swaps--;
						leftPointer--;
						rightPointer--;
					} else {
						break;
					}
				}
				if (done) {
					break;
				}
			}
		}
		return buildNumber(memo);
	}

	private static String buildNumber(int[] memo) {
		StringBuffer sbr = new StringBuffer();
		for (int index = 0; index < memo.length; index++) {
			sbr.append(memo[index]);
		}
		return sbr.toString();
	}

	private static int[] buildMemo(String numAsString) {
		int[] memo = new int[numAsString.length()];
		for (int index = 0; index < numAsString.length(); index++) {
			memo[index] = numAsString.charAt(index) - '0';
		}
		return memo;
	}
}
