package com.engineeralgorithmanddrdatastructure.search;

/**
 * Given array, elements in odd index and even index are sorted independently
 * but entire array is not sorted. Find out index of given number from array.
 * Example 1. Array [1,2,3,4,5,8,10,9,11] find 10 output 6
 * 
 * Example 2. Array [1,2,3,4,5,8,10,9,11] find 15 output -1
 * 
 * Example 3. Array [1,5,2,8,3] find 5 output 1
 * 
 * @author ankit.sorathiya
 *
 */
public class BinarySearchVariation {

	public int findIndexOfGivenNumber(int[] independentlySorted, int number) {
		int result = this.findIndexOfGivenNumber(independentlySorted, number, 0, independentlySorted.length, true);
		if (result == -1) {
			result = this.findIndexOfGivenNumber(independentlySorted, number, 0, independentlySorted.length, false);
		}
		return result;
	}

	private int findIndexOfGivenNumber(int[] independentlySorted, int number, int startIndex, int endIndex,
			boolean even) {
		if (startIndex < 0 || endIndex < 0 || startIndex > independentlySorted.length
				|| endIndex > independentlySorted.length) {
			return -1;
		}
		int midIndex = findClosetIndex(startIndex, endIndex, even);
		if (midIndex < 0 || midIndex >= independentlySorted.length) {
			return -1;
		}
		if (number == independentlySorted[midIndex]) {
			return midIndex;
		} else if (number < independentlySorted[midIndex]) {
			return findIndexOfGivenNumber(independentlySorted, number, startIndex, midIndex - 2, even);
		} else {
			return findIndexOfGivenNumber(independentlySorted, number, midIndex + 2, endIndex, even);
		}

	}

	private int findClosetIndex(int start, int end, boolean even) {
		int midIndex = (start + end) / 2;
		if ((even && midIndex % 2 == 0) || (midIndex % 2 != 0 && !even)) {
			return midIndex;
		}
		int minusOne = midIndex - 1;
		int plusOne = midIndex + 1;
		if (start <= minusOne && minusOne <= end) {
			return minusOne;
		}
		if (start <= plusOne && plusOne <= end) {
			return minusOne;
		}
		return midIndex;
	}
}
