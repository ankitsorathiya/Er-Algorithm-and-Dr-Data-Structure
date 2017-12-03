package com.engineeralgorithmanddrdatastructure.search;
import java.util.Scanner;

public class Max1sString {
	public static void main(String args[]) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		String input = scanner.next();

		char[] onesAndZeros = input.toCharArray();
		int[] memo = new int[n];
		int max = initializeSubArraysAndMax(onesAndZeros, memo);
		for (int q = 0; q < k; q++) {
			int queryType = scanner.nextInt();
			switch (queryType) {
			case 1:
				System.out.println(max);
				break;
			case 2:
				int changeIndex = scanner.nextInt();
				max = updateMemo(max, onesAndZeros, memo, changeIndex - 1);
				break;
			}

		}
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
