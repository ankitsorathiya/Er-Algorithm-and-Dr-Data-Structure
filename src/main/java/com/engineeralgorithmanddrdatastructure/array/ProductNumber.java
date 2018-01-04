package com.engineeralgorithmanddrdatastructure.array;

/**
 * 
 * @author ankit.sorathiya
 *
 *
 *         You have an array of integers, and for each index you want to find
 *         the product of every integer except the integer at that index.
 */
public class ProductNumber {
	public static int[] findProduct(int[] data) {
		if (data == null || data.length < 2) {
			return null;
		}
		int[] result = new int[data.length];
		int zeroIndex = -1;
		int zeroCount = 0;
		int product = 1;
		for (int index = 0; index < data.length; index++) {
			if (data[index] == 0) {
				zeroCount++;
				zeroIndex = index;
			}
			if (zeroCount > 1) {
				product = 0;
				break;
			} else if (data[index] != 0) {
				product *= data[index];
			}
		}
		if (zeroCount > 1) {
			return result;
		}

		for (int index = 0; index < data.length; index++) {
			if (data[index] != 0) {
				if (zeroCount == 1 && zeroIndex != index) {
					result[index] = 0;
				} else {
					result[index] = product / data[index];
				}
			} else {
				result[index] = product;
			}
		}
		return result;
	}

	public static int[] findProductGreedy(int[] data) {
		if (data == null || data.length < 2) {
			return null;
		}
		int[] result = new int[data.length];
		int product = 1;
		for (int index = 0; index < data.length; index++) {
			result[index] = product;
			product *= data[index];
		}
		product = 1;
		for (int index = data.length - 1; index >= 0; index--) {
			result[index] *= product;
			product *= data[index];
		}
		return result;
	}
}
