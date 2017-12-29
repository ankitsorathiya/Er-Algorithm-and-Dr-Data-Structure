package com.engineeralgorithmanddrdatastructure.array;

import java.util.HashMap;
import java.util.Map;

public class MaxChocolateProblem {
	public static int findMaxChocolateForEachStudents(int[] chocolateBoxes, int students) {
		int max = 0;
		if (chocolateBoxes == null || chocolateBoxes.length == 0 || students <= 0) {
			return max;
		}
		int[] memo = new int[chocolateBoxes.length];
		for (int box = 0; box < chocolateBoxes.length; box++) {
			for (int sumIndex = 0; sumIndex < memo.length; sumIndex++) {
				int chocolates = chocolateBoxes[box];
				int chocolateSum = memo[sumIndex];
				int maxChocolates = chocolateSum + chocolates;
				if (maxChocolates % students == 0) {
					int newMax = maxChocolates / students;
					if (newMax > max) {
						max = newMax;
					}
				}
				memo[sumIndex] = maxChocolates;
				if (chocolateSum == 0) {
					break;
				}
			}
		}
		return max;
	}

	public static int findMaxChocolateForEachStudents_efficient(int[] chocolateBoxes, int students) {
		int maxChocolates = 0;
		if (chocolateBoxes == null || chocolateBoxes.length == 0 || students <= 0) {
			return maxChocolates;
		}
		int[] chocolateSum = new int[chocolateBoxes.length];
		chocolateSum[0] = chocolateBoxes[0];
		for (int index = 1; index < chocolateBoxes.length; index++) {
			chocolateSum[index] = chocolateSum[index - 1] + chocolateBoxes[index];
		}
		Map<Integer, Integer> remainderMap = new HashMap<>();
		for (int sumIndex = 0; sumIndex < chocolateSum.length; sumIndex++) {

			int remainder = chocolateSum[sumIndex] % students;
			if (remainder == 0) {
				if (maxChocolates < chocolateSum[sumIndex]) {
					maxChocolates = chocolateSum[sumIndex];
				}
			} else if (remainderMap.containsKey(remainder)) {
				int remainderIndex = remainderMap.get(remainder);
				int newMax = chocolateSum[sumIndex] - chocolateSum[remainderIndex];
				if (newMax > maxChocolates) {
					maxChocolates = newMax;
				}
			} else {
				remainderMap.put(remainder, sumIndex);
			}
		}

		return maxChocolates / students;
	}
}
