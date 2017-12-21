package com.engineeralgorithmanddrdatastructure.dp;

public class RobotHomeProblem {
	public int howManyWaysRobotCanReachHome(int[][] maze, int homeRow, int homeColumn) {
		int[][] memo = new int[maze.length][maze.length];
		initializeBaseCase(memo);
		for (int row = memo.length - 2; row >= 0; row--) {
			for (int col = memo.length - 2; col >= 0; col--) {
				memo[row][col] = memo[row][col + 1] + memo[row + 1][col];
			}
		}
		return memo[0][0];
	}

	private int[][] initializeBaseCase(int[][] maze) {
		int[][] memo = new int[maze.length][maze.length];
		for (int index = 0; index < maze.length - 2; index++) {
			memo[index][maze.length - 1] = 1;
			memo[maze.length - 1][index] = 1;
		}
		return memo;
	}
}
