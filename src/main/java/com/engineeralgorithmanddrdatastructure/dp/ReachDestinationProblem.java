package com.engineeralgorithmanddrdatastructure.dp;

/**
 * 
 * @author ankit.sorathiya
 * 
 * 
 *         Person is standing @ first stair and he/she wants to reach to the
 *         last stair. From each stair person can jump 1,2,3 stairs. find out
 *         how many possible ways are there to reach to last stair.
 * 
 * 
 *
 */
public class ReachDestinationProblem {
	public static int findWaysToReachDestination(int stairs) {
		if (stairs <= 0) {
			return 0;
		}
		int[] memo = new int[stairs];
		int destination = stairs - 1;
		for (int currentStair = stairs - 2; currentStair >= 0; currentStair--) {
			for (int jump = 3; jump > 0; jump--) {
				int where = jump + currentStair;
				if (where == destination) {
					memo[currentStair] += 1;
				} else if (where < destination) {
					memo[currentStair] += memo[where];
				}
			}
		}
		return memo[0];
	}
}
