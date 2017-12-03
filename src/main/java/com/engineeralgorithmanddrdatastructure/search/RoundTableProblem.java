
package com.engineeralgorithmanddrdatastructure.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class RoundTableProblem {
	public static void main(String args[]) throws Exception {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int Q = scanner.nextInt();
		int[] universities = new int[N];
		for (int index = 0; index < N; index++) {
			universities[index] = scanner.nextInt();
		}
		Map<String, Integer> memo = new HashMap<>();
		Map<Integer, List<Integer>> universityPositions = new HashMap<>();
		for (int q = 0; q < Q; q++) {
			int xUniversity = scanner.nextInt();
			int yUniversity = scanner.nextInt();
			System.out.println(
					RoundTable.findSolution(universities, memo, universityPositions, xUniversity, yUniversity));
		}

	}
}

class RoundTable {

	public static int findSolution(int[] universities, Map<String, Integer> memo,
			Map<Integer, List<Integer>> universityPositions, int xUniversity, int yUniversity) {
		// store in ascending orders
		String memoKey = xUniversity < yUniversity ? xUniversity + " " + yUniversity : yUniversity + " " + xUniversity;
		if (memo.containsKey(memoKey)) {
			return memo.get(memoKey);
		}
		List<Integer> xUniversityPosition = findUniversityPositions(xUniversity, universities, universityPositions);
		List<Integer> yUniversityPosition = findUniversityPositions(yUniversity, universities, universityPositions);
		int minStepsRequire = Integer.MAX_VALUE;
		for (int xIndex = 0; xIndex < xUniversityPosition.size(); xIndex++) {
			for (int yIndex = 0; yIndex < yUniversityPosition.size(); yIndex++) {
				if (xUniversityPosition.get(xIndex) == yUniversityPosition.get(yIndex)) {
					continue;
				}
				int xUniversityIndex = xUniversityPosition.get(xIndex);
				int yUniversityIndex = yUniversityPosition.get(yIndex);
				int result = getRequireSteps(universities, xUniversityIndex, yUniversityIndex);
				if (result < minStepsRequire) {
					minStepsRequire = result;
				}
			}
		}
		memo.put(memoKey, minStepsRequire);
		return minStepsRequire;
	}

	private static int getRequireSteps(int universities[], int xUniversityIndex, int yUniversityIndex) {
		int absDiff = Math.abs(xUniversityIndex - yUniversityIndex);
		if (absDiff <= 1) {
			return 0;
		}
		int small = xUniversityIndex < yUniversityIndex ? xUniversityIndex : yUniversityIndex;
		int big = xUniversityIndex > yUniversityIndex ? xUniversityIndex : yUniversityIndex;
		int half = universities.length / 2;
		int smallStrategy = absDiff >= half ? -1 : 1;
		int bigStrategy = absDiff < half ? -1 : 1;
		int currentSteps = 0;
		while (Math.abs(small - big) > 1) {
			small = (small + smallStrategy) % universities.length;
			big = (big + bigStrategy) % universities.length;
			if (small < 0) {
				small = universities.length - 1;
			}
			if (big < 0) {
				big = universities.length - 1;
			}
			currentSteps++;
		}
		return currentSteps;
	}

	private static List<Integer> findUniversityPositions(int university, int[] universities,
			Map<Integer, List<Integer>> universityPositions) {
		if (universityPositions.containsKey(university)) {
			return universityPositions.get(university);
		}
		List<Integer> universityPosition = new ArrayList<>();
		for (int index = 0; index < universities.length; index++) {
			if (universities[index] == university) {
				universityPosition.add(index);
			}
		}
		universityPositions.put(university, universityPosition);
		return universityPosition;
	}

}
