package com.engineeralgorithmanddrdatastructure.dp;

public class RobotHomeProblem {
	public static int howManyWaysRobotCanReachHome(int[][] maze) {
		int[][] memo = initializeMemo(maze);
		for (int row = memo.length - 2; row >= 0; row--) {
			for (int col = memo.length - 2; col >= 0; col--) {
				if (maze[row][col] == 0) {
					memo[row][col] = 0;
				} else {
					memo[row][col] = memo[row][col + 1] + memo[row + 1][col];
				}
			}
		}
		return memo[0][0];
	}

	private static int[][] initializeMemo(int[][] maze) {
		int[][] memo = new int[maze.length][maze.length];
		memo[maze.length - 1][maze.length - 1] = 1;
		for (int index = maze.length - 2; index >= 0; index--) {
			memo[index][maze.length - 1] = maze[index][maze.length - 1] == 0 ? 0 : maze[index + 1][maze.length - 1];
			memo[maze.length - 1][index] = maze[maze.length - 1][index] == 0 ? 0 : maze[maze.length - 1][index + 1];
		}
		return memo;
	}
}
