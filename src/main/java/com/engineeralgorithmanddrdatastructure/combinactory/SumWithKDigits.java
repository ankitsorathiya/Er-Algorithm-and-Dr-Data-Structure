package com.engineeralgorithmanddrdatastructure.combinactory;

import java.util.ArrayList;
import java.util.List;

public class SumWithKDigits {
	public static List<List<Integer>> findKDigitsWhoSum(int[] input, int k, int sum) {
		List<List<Integer>> result = new ArrayList<>();
		if (k <= 0) {
			return result;
		}
		for (int index = 0; index <= input.length - k; index++) {
			if (input[index] < sum) {
				ArrayList<Integer> currentSolution = new ArrayList<Integer>();
				currentSolution.add(input[index]);
				findKDigitsWhoSum(input, index + 1, k - 1, sum - input[index], result, currentSolution);
			}
		}
		return result;
	}

	private static void findKDigitsWhoSum(int[] input, int index, int k, int sum, List<List<Integer>> result,
			ArrayList<Integer> solution) {
		if (index > input.length) {
			return;
		}
		if (k == 0 && sum == 0) {
			result.add(solution);
			return;
		}

		for (int i = index; i < input.length; i++) {
			int remainingSum = sum - input[i];
			int remainingK = k - 1;
			if (remainingK < 0 || remainingSum < 0) {
				continue;
			}
			@SuppressWarnings("unchecked")
			ArrayList<Integer> newSolution = (ArrayList<Integer>) solution.clone();
			newSolution.add(input[i]);
			findKDigitsWhoSum(input, i + 1, remainingK, remainingSum, result, newSolution);
		}

	}

}
