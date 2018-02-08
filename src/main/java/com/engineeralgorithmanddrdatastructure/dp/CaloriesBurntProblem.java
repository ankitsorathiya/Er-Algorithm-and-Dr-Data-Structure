package com.engineeralgorithmanddrdatastructure.dp;

public class CaloriesBurntProblem {
	/**
	 * You are given a 2 dimensional matrix X of n rows and n columns where X[i][j]
	 * denotes the calories burnt. Two persons, a boy and a girl, start from two
	 * corners of this matrix. The boy starts from cell (1,1) and needs to reach
	 * cell (n,n). On the other side, the girl starts from cell (n,1) and needs to
	 * reach (1,n). The boy can move right and down. The girl can move right and up.
	 * As they visit a cell, the amount in the cell X[i][j] is added to their total
	 * of calories burnt. You have to maximize the sum of total calories burnt by
	 * both of them under the condition that they shall meet only in one cell and
	 * the cost of this cell shall not be included in either of their total.
	 */
	public static int findMaxCaloriesBurnt(int[][] calories) {
		if (calories == null) {
			return 0;
		}
		int[][] boysH2D = findBoysCaloriesFromHomeToDestination(calories);
		int[][] boysD2H = findBoysCaloriesFromDestinationToHome(calories);
		int[][] girlsH2D = findGirlsCaloriesFromHomeToDestination(calories);
		int[][] girlsD2H = findGirlsCaloriesFromDestinationToHome(calories);
		return findMaxCalories(boysH2D, boysD2H, girlsH2D, girlsD2H);
	}

	private static int findMaxCalories(int[][] boysH2D, int[][] boysD2H, int[][] girlsH2D, int[][] girlsD2H) {
		int maxCalories = 0;
		int maxRow = boysD2H.length - 1;
		int maxCol = boysD2H.length - 1;
		for (int row = 1; row < maxRow; row++) {
			for (int col = 1; col < maxCol; col++) {
				int calories1 = (boysH2D[row][col - 1] + boysD2H[row][col + 1])
						+ (girlsH2D[row + 1][col] + girlsD2H[row - 1][col]);
				int calories2 = (boysH2D[row - 1][col] + boysD2H[row + 1][col])
						+ (girlsH2D[row][col - 1] + girlsD2H[row][col + 1]);
				maxCalories = Math.max(maxCalories, Math.max(calories1, calories2));
			}
		}
		return maxCalories;
	}

	private static int[][] findGirlsCaloriesFromHomeToDestination(int[][] calories) {
		int[][] girlsH2d = new int[calories.length][calories.length];
		int last = calories.length - 1;
		girlsH2d[last][0] = calories[last][0];
		for (int index = last - 1; index >= 0; index--) {
			girlsH2d[index][0] = girlsH2d[index + 1][0] + calories[index][0];
			int col = last - index;
			girlsH2d[last][col] = girlsH2d[last][col - 1] + calories[last][col];
		}
		for (int row = last - 1; row >= 0; row--) {
			for (int col = 1; col <= last; col++) {
				girlsH2d[row][col] = Math.max(girlsH2d[row][col - 1], girlsH2d[row + 1][col]) + calories[row][col];
			}
		}
		return girlsH2d;
	}

	private static int[][] findGirlsCaloriesFromDestinationToHome(int[][] calories) {
		int[][] girslD2H = new int[calories.length][calories.length];
		int last = calories.length - 1;
		girslD2H[0][last] = calories[0][last];
		for (int index = last - 1; index >= 0; index--) {
			girslD2H[0][index] = girslD2H[0][index + 1] + calories[0][index];
			int row = last - index;
			girslD2H[row][last] = girslD2H[row - 1][last] + calories[row][last];
		}
		for (int row = 1; row < calories.length; row++) {
			for (int col = calories.length - 2; col >= 0; col--) {
				girslD2H[row][col] = Math.max(girslD2H[row - 1][col], girslD2H[row][col + 1]) + calories[row][col];
			}
		}
		return girslD2H;
	}

	private static int[][] findBoysCaloriesFromDestinationToHome(int[][] calories) {
		int[][] boysD2H = new int[calories.length][calories.length];
		int last = calories.length - 1;
		boysD2H[last][last] = calories[last][last];
		for (int index = last - 1; index >= 0; index--) {
			boysD2H[last][index] = boysD2H[last][index + 1] + calories[last][index];
			boysD2H[index][last] = boysD2H[index + 1][last] + calories[index][last];
		}

		for (int row = last - 1; row >= 0; row--) {
			for (int col = last - 1; col >= 0; col--) {
				boysD2H[row][col] = Math.max(boysD2H[row][col + 1], boysD2H[row + 1][col]) + calories[row][col];
			}
		}

		return boysD2H;
	}

	private static int[][] findBoysCaloriesFromHomeToDestination(int[][] calories) {
		int[][] boysH2D = new int[calories.length][calories.length];
		boysH2D[0][0] = calories[0][0];
		for (int index = 1; index < calories.length; index++) {
			boysH2D[index][0] = calories[index][0] + boysH2D[index - 1][0];
			boysH2D[0][index] = boysH2D[0][index - 1] + calories[0][index];
		}
		for (int row = 1; row < calories.length; row++) {
			for (int col = 1; col < calories.length; col++) {
				boysH2D[row][col] = Math.max(boysH2D[row][col - 1], boysH2D[row - 1][col]) + calories[row][col];
			}
		}

		return boysH2D;
	}

}
