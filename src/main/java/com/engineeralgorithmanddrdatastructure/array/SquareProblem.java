package com.engineeralgorithmanddrdatastructure.array;

import java.util.ArrayList;
import java.util.List;

public class SquareProblem {
	public static Integer[] findSpecialSquare(int range) {
		List<Integer> result = new ArrayList<>();
		for (int num = 4; num <= range; num++) {
			String value = Integer.valueOf((int) Math.pow(num, 2)).toString();
			if (isSpecialSquare(value, num)) {
				result.add(num);
			}
		}
		Integer[] intArray = new Integer[result.size()];
		return result.toArray(intArray);
	}

	private static boolean isSpecialSquare(String digits, int originalNumber) {
		if (digits == null || digits.length() == 1) {
			return false;
		}
		int firstSum = digits.charAt(0) - '0';
		int lastSum = Integer.parseInt(digits.substring(1, digits.length()));
		if (firstSum + lastSum == originalNumber) {
			return true;
		}
		int totalDigits = digits.length();
		for (int index = 1; index < totalDigits - 1; index++) {
			int currentDigit = digits.charAt(index) - '0';
			firstSum = (int) ((Math.pow(10, index) * firstSum) + currentDigit);
			lastSum = (int) (lastSum - ((Math.pow(10, totalDigits - index - 1) * currentDigit)));
			if (firstSum + lastSum == originalNumber) {
				return true;
			}
		}

		return false;
	}
}
